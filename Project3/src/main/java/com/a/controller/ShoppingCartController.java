package com.a.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.service.SCOrderDetailsService;
import com.a.service.SCOrdersService;
import com.a.service.ShoppingCartService;
import com.google.gson.Gson;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;

@Controller
public class ShoppingCartController implements ServletContextAware{
	
	//購物車第一個分類ID
	Integer categoryID = 6;
	//購物車最後一個分類ID
	Integer endCatID = 13;

	ShoppingCartService scservice;
	SCOrderDetailsService scodservice;
	SCOrdersService scoservice;
	ProductsService pservice;
	ServletContext context;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
		
	}

	@Autowired
	public void setService(ShoppingCartService scservice, SCOrderDetailsService scodservice,
			SCOrdersService scoservice, ProductsService pservice) {
		this.scservice = scservice;
		this.scodservice = scodservice;
		this.scoservice = scoservice;
		this.pservice = pservice;
	}

	//取得會員購物車
	//若無登入會先跳登入頁面
	@SuppressWarnings("unused")
	@GetMapping("/getShoppingCart")
	public String getShoppingCart(Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Cookie[] cookies = request.getCookies();
//		if (cookies.length < 4) {
//			MemberBean mb = new MemberBean();
//			model.addAttribute("memberBean", mb);
//			return "redirect:/member/login";
//		}
		Integer memberID = scservice.getMemberID(request);
		System.out.println(memberID);
		Integer SCOrderID = scservice.getShoppingCart(memberID);
		List<SCOrderDetailBean> list = scservice.getOrderDetails(SCOrderID);
		if (SCOrderID != null) {
			// showShoppingCart
			
			if (list.size() == 0) {
				System.out.println("Shopping cart is empty");
				model.addAttribute("shoppingCart", list);
			} else {
				for(int products = 0; products < list.size(); products++) {
					int shoppingCartQuantity = list.get(products).getQuantity();
					int stockQuantity = list.get(products).getProductsBean().getUnitStock();
					//若購物車裡的商品選購數已大於存貨
					if(shoppingCartQuantity > stockQuantity && stockQuantity != 0) {
						list.get(products).setQuantity(stockQuantity);
						scservice.updateQty(list.get(products));
					}
				}
				System.out.println("There are items in shopping cart");
				model.addAttribute("shoppingCart", list);
			}
		} else {
			SCOrdersBean scob = new SCOrdersBean();
			scob.setMemberID(memberID);
			scoservice.insertOrder(scob);
			System.out.println("Shopping cart is empty");
			model.addAttribute("shoppingCart", list);
		}
		return "a/ShoppingCart";
	}

	@PostMapping("/deleteProduct")
	public String showShoppingCartItem(@RequestParam("orderID") String orderID, @RequestParam("productID") String productID) {
		System.out.println(orderID + " " + productID);
		scservice.deleteProduct(Integer.parseInt(orderID), Integer.parseInt(productID));
		System.out.println("This is deleteProducts");
		return "a/ShoppingCart";
	}
	
	//要顯示不同分類+分類裡其中一個產品的圖
	@GetMapping("/showAllProducts")
	public String showAllProducts(Model model) {
		List<ProductsBean> map = new ArrayList<>();
		for(Integer cID = categoryID; cID <= endCatID; cID++) {
			List<ProductsBean> list = pservice.getCategoryID(cID);
			System.out.println(list.get(0).getProductID());
			map.add(list.get(0));
		}
		model.addAttribute("product", map);
		return "a/allProducts";
	}
	
	@GetMapping("/products/{productID}")
	public ResponseEntity<byte[]> productImage(HttpServletResponse resp, @PathVariable Integer productID) {
	    String filePath = "/resources/images/NoImage.jpg";
	    System.out.println(productID);
	    byte[] media = null;
	    HttpHeaders headers = new HttpHeaders();
	    String filename = "";
	    int len = 0;
	    ProductsBean bean = pservice.getProduct(productID);
	    System.out.println(bean);
	    if (bean != null) {
	        Blob blob = bean.getProductImage();
	        filename = bean.getFileName();
	        if (blob != null) {
	            try {
	                len = (int) blob.length();
	                media = blob.getBytes(1, len); //  blob.getBytes(1, len): 是 1 開頭。Jdbc相關的類別都是1 開頭。
	            } catch (SQLException e) {
	                throw new RuntimeException("RunMovieController的getPicture()發生SQLException: " + e.getMessage());
	            }
	        } else {
	            media = toByteArray(filePath);    
	            filename = filePath;            
	        }
	    } else {
	    	media = toByteArray(filePath);    
	        filename = filePath;            
	    }
	       headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	       System.out.println(filename);
	       String mimeType = context.getMimeType(filename);
	    MediaType mediaType = MediaType.valueOf(mimeType);
	    System.out.println("mediaType =" + mediaType);
	    headers.setContentType(mediaType);
	    ResponseEntity<byte[]> responseEntity = 
	                new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
	
	private byte[] toByteArray(String filepath) {
	    byte[] b = null;
	    String realPath = context.getRealPath(filepath);
	    try {
	          File file = new File(realPath);
	          long size = file.length();
	          b = new byte[(int)size];
	          InputStream fis = context.getResourceAsStream(filepath);
	          fis.read(b);
	    } catch (FileNotFoundException e) {
	          e.printStackTrace();
	    } catch (IOException e) {
	          e.printStackTrace();
	    }
	    return b;
	}

	@GetMapping("/categoryProducts/{categoryID}")
	public String getAllProductsFromCategory(Model model, @PathVariable("categoryID") Integer categoryID) {
		System.out.println("this is product categoryID");
		List<ProductsBean> list = pservice.getCategoryID(categoryID);
		Gson gson = new Gson();
		String prod = gson.toJson(list);
		model.addAttribute("productList", list);
		model.addAttribute("prod", prod);
		return "a/categoryProducts";
	}
	
	//加選購商品進入購物車
	//需先確定會員有購物車
	@GetMapping("/addToShoppingCart")
	public String addProductsToShoppingCart(HttpServletRequest request) {
		Integer memberID = scservice.getMemberID(request);
		System.out.println(memberID);
		Integer SCOrderID = scservice.getShoppingCart(memberID);
		if(SCOrderID == null) {
			SCOrdersBean scob = new SCOrdersBean();
			scob.setMemberID(memberID);
			scoservice.insertOrder(scob);

		}
		
		return null;
	}
	
	
}
