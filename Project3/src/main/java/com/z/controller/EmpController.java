package com.z.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.p.model.MemberBean;
import com.z.exception.EmpNotFoundException;
import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.RoleBean;
import com.z.service.EmpService;

@Controller
public class EmpController {
	
	EmpService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(EmpService service) {
		this.service = service;
	}
	
	//以下三個為新增員工方法
	@RequestMapping(value = "/emp/add", method = RequestMethod.GET)
	public String addNewEmp(Model model) {
		EmpBean eb = new EmpBean();
		model.addAttribute("empBean", eb);
		return "z/addEmp";
	}
	
	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public String processAddNewEmp(@ModelAttribute("empBean") EmpBean eb) {
		
//		String[] suppressedFields = result.getSuppressedFields();
//		, BindingResult result
//		if(suppressedFields.length > 0) {
//			throw new RuntimeException("傳入不允許的欄位");
//		} 
 		service.saveEmp(eb);
		return "z/addEmp";
	}
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
	
	//----------------------------------
	
	@RequestMapping(value = "/emps")
	public String getAllEmps(Model model) {
		List<EmpBean> allEmps = service.findAllEmps();
		model.addAttribute("allEmps", allEmps);
		return "z/emps";
	}
	
	
	@RequestMapping(value = "/emp")
	public String getEmp(@RequestParam("empId") Integer empId, Model model) {
		EmpBean eb = service.getEmp(empId);
//		if(eb == null) {
//			model.addAttribute("emp", eb);   //如果無該員工ID，需要出現提示訊息
//		}
		model.addAttribute("emp", eb);
		return "z/emp";
	}
	
	@RequestMapping(value = "searchEmp")
	public String searchEmp(Model model) {
		return "z/searchEmp";
	}
	
	@ExceptionHandler({EmpNotFoundException.class})
	public String handler(HttpServletRequest request, EmpNotFoundException exception, Model model) {
		String message = "查無員工編號：";
		model.addAttribute("message",message);
		model.addAttribute("empId", exception.getEmpId());
		return "z/searchEmp";
	}
	
	@ModelAttribute("roleList")
	public Map<Integer, String> getRoleCompanyList() {
		Map<Integer, String> roleMap = new HashMap<>();
		List<RoleBean> list = service.getRoleList();
		for (RoleBean rb : list) {
			roleMap.put(rb.getRoleId(), rb.getRoleName());
		}
		return roleMap;
	}
	
	@ModelAttribute("empStatusList")
	public Map<Integer, String> getEmpStatusList() {
		Map<Integer, String> empStatusMap = new HashMap<>();
		List<EmpStatusBean> list = service.getEmpStatusList();
		for (EmpStatusBean rb : list) {
			empStatusMap.put(rb.getStatus(), rb.getStatusName());
		}
		return empStatusMap;
	}
	
	
	@RequestMapping(value = "/emp/update/{empId}", method = RequestMethod.GET)
	public String updateEmp(Model model, @PathVariable("empId") Integer empId) {
		EmpBean ab = service.getEmp(empId);
		model.addAttribute("empBean", ab);
		//試著加上是否為員工本人的判斷，導向不同頁面
		return "z/editEmp";
	}
	
	
	@RequestMapping(value = "/emp/update/{empId}", method = RequestMethod.POST)
	public String processUdateEmp(@ModelAttribute("empBean") EmpBean eb) {
		service.saveEmp(eb);
		return "redirect:/emps";
	}
	
	//  以下尚未實作完成
	
	//以下為導入登入頁面的controller
	@RequestMapping(value="/emp/login", method = RequestMethod.GET)
	public String login(Model model){
		EmpBean eb = new EmpBean();
		model.addAttribute("empBean",eb);
		return "EmpLogin";
	}
	
	//以下為判斷登入的方法
	@RequestMapping(value="/emp/login", method = RequestMethod.POST)
	public String logincheck(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("empBean")EmpBean eb,Model model) {
		HttpSession session = request.getSession();
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		if(eb.getEmail() == null || eb.getEmail().trim().length() == 0) {
			errorMsgMap.put("IDError","帳號欄位不得空白，請重新輸入!");
		}
		if(eb.getPassword() == null || eb.getPassword().trim().length() == 0) {
			errorMsgMap.put("pwdError","密碼欄位不得空白，請重新輸入!");
		}
		
		EmpBean eb2 = service.login(eb.getEmail(), eb.getPassword());
		if(eb2 != null) {
			//登入成功，將mb2物件放進session範圍中，識別字串為LoginOK
			session.setAttribute("LoginOK", eb2);
			Cookie cookie = new Cookie("email",eb2.getEmail());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("EmpName",eb2.getEmpName());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    cookie = new Cookie("EmpID",eb2.getEmpId().toString());
		    cookie.setMaxAge(7 * 24 * 60 * 60);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    
		    Cookie[] cookies = request.getCookies();
			String mID = null;
			for (Cookie cookiess : cookies) {
				String name = cookie.getName();
				if(name.equals("memberID")) {
					mID = cookie.getValue();
				}
			}
			int nMID = Integer.parseInt(mID);
		    
		}else {
			errorMsgMap.put("IDPwdError","帳號或密碼錯誤，請重新輸入!");
		}
		if(!errorMsgMap.isEmpty()) {
			model.addAttribute("errorMsgMap", errorMsgMap);
			return "login";
		}
		return "loginSuccess"; //到時候要導到LoginSucess頁面
	}
	
	//以下為登出方法
	@GetMapping("/member/logout")
	public String EmpLogout(HttpServletRequest request,HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("LoginOK");
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
		}
		return "redirect:/";
	}
	

}
