package com.a.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.Hallcomparator;
import com.a.test.ShowtimeBean;
import com.c.model.HallBean;
import com.c.service.HallService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.p.model.HallOrderBean;
import com.p.service.HallOrderService;

@Controller
public class RunMovieController implements ServletContextAware{
	ServletContext context;
	MovieService mService;
	HallService hService;
	HallOrderService hoService;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	@Autowired
	public void setService(MovieService mService, HallService hService, HallOrderService hoService) {
		this.mService = mService;
		this.hService = hService;
		this.hoService = hoService;
	}

	// 新增電影方法

	@GetMapping(value = "/movie/add") // URL
	public String proceessAdd(Model model) {
		MovieBean mb = new MovieBean();

		// 傳空的Bean去前端//如果controller有資料要
		model.addAttribute("Movie", mb);

		return "a/addMovie";
	}

	@PostMapping(value = "/movie/add")
	public String addNewMove(Model model, @ModelAttribute("Movie") MovieBean mb, BindingResult result,
			HttpServletRequest request, @RequestParam("release") String release,
			@RequestParam("expectedOffDate") String expectedOffDate, @RequestParam("MustShowDay") String MustShowDay) {
		String url = request.getContextPath();
		System.out.println(url);
		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("傳入不允許的欄位");
		}
		MultipartFile movieImage = mb.getMovieImage();
		String originalFilename = movieImage.getOriginalFilename();
		mb.setFileName(originalFilename);
		if (movieImage != null && !movieImage.isEmpty() ) {
			try {
				byte[] b = movieImage.getBytes();
				Blob blob = new SerialBlob(b);
				mb.setPhoto(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		mb.setStatus(0);

		mService.addmovie(mb);

		// save RunningBean in SQL
		DateTimeFormatter fmtD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startDate = LocalDate.parse(release, fmtD);
		LocalDate endDate2 = LocalDate.parse(expectedOffDate, fmtD);
		long daysDiff = ChronoUnit.DAYS.between(startDate, endDate2);
		int totalDay = (int) (daysDiff);

		RunningBean rb1 = new RunningBean();
//	 		int totalDay = Integer.parseInt(expectedOnDate);
		int mustDay = Integer.parseInt(MustShowDay);
		LocalDate endDate = startDate.plusDays(mustDay - 1);
		LocalDate startDate2 = startDate.plusDays(mustDay);
		if (totalDay - mustDay > 0 && mustDay != 0) {
			RunningBean rb2 = new RunningBean(release, mustDay, 0, endDate.toString(), "2999-01-01", 0, mb);
			mService.addrunning(rb2);
			rb1 = new RunningBean(startDate2.toString(), (totalDay - mustDay), 0, expectedOffDate, "2999-01-01", 1, mb);
		} else if (mustDay == 0) {
			rb1 = new RunningBean(release, totalDay, 0, expectedOffDate, "2999-01-01", 1, mb);

		} else {
			// totalDay=mustDay
			rb1 = new RunningBean(release, totalDay, 0, expectedOffDate, "2999-01-01", 0, mb);
		}

		mService.addrunning(rb1);

//	 		//取出來看看 ok
//	 		MovieBean mbget = mService.getMovieBeanById(1);
//	 		System.out.println("title:"+mbget.getTitle()+"合約:"+mbget.getContractDate()+"預估 :"+mbget.getExpectedProfit()
//            +"拆帳:"+mbget.getProfitRatio()+"狀態:"+mbget.getStatus()+"片長:"+mbget.getRunningTime()
//	);
//	 	

		// 換URL
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url + "/addmovie/success");
		// 換URL
		return "index-a";
	}

	@GetMapping(value = "/Allrunning/add")
	public String addAllRunning() {
//		List<MovieBean> Allmovie_list=new ArrayList<>();
		int dataCount = 51;
		LocalDateTime startTime = LocalDateTime.parse("2019/10/01 00:00:00",
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		for (int i = 1; i <= dataCount; i++) {

			MovieBean mb = mService.getMovieBeanById(i);
			int random = (int) (Math.random() * 3 + 1);

			LocalDate startDate = startTime.toLocalDate().plusDays(random);
			LocalDate endDate2 = startDate.plusDays(30);
			long daysDiff = ChronoUnit.DAYS.between(startDate, endDate2);
			int totalDay = (int) (daysDiff);

			RunningBean rb1 = new RunningBean();
//		 		int totalDay = Integer.parseInt(expectedOnDate);
			int mustDay = 7;
			LocalDate endDate = startDate.plusDays(mustDay - 1);
			LocalDate startDate2 = startDate.plusDays(mustDay);
			if (totalDay - mustDay > 0 && mustDay != 0) {
				RunningBean rb2 = new RunningBean(startDate.toString(), mustDay, 7, endDate.toString(),
						endDate.toString(), 0, mb);
				mService.addrunning(rb2);
				rb1 = new RunningBean(startDate2.toString(), (totalDay - mustDay), 23, endDate2.toString(),
						endDate2.toString(), 1, mb);
			} else if (mustDay == 0) {
				rb1 = new RunningBean(startDate.toString(), totalDay, 30, endDate2.toString(), endDate2.toString(), 1,
						mb);

			} else {
				// totalDay=mustDay
				rb1 = new RunningBean(startDate.toString(), totalDay, 30, endDate2.toString(), endDate2.toString(), 0,
						mb);
			}

			mService.addrunning(rb1);
			startTime = startDate.atTime(LocalTime.now());

		}

		return "index-a";
	}

	// 一部電影的畫面
	@GetMapping(value = "/movie/show") // URL 跟<a href='movie/show'> 相關
	public String showMovie(Model model) {
		MovieBean mb = new MovieBean();

		// 傳空的Bean去前端//如果controller有資料要
		model.addAttribute("Movie", mb);

		return "a/showMovie";// URL 跟 eclip 擺放位置相關
	}
	
	//顯示電影圖
	//Added getPicture to RunMovieController + getByteArray
	@GetMapping("/getPicture/{movieID}")
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer movieID) {
	    String filePath = "/resources/images/NoImage.jpg";
	    System.out.println(movieID);
	    byte[] media = null;
	    HttpHeaders headers = new HttpHeaders();
	    String filename = "";
	    int len = 0;
	    MovieBean bean = mService.getMovieBeanById(movieID);
	    System.out.println(bean);
	    if (bean != null) {
	        Blob blob = bean.getPhoto();
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
    //顯示上映電影
	@GetMapping(value = "/AllMovie/show") // URL 跟<a href='movie/show'> 相關
	public String showAllMovie(Model model,HttpServletRequest request,HttpServletResponse response) {
		LocalDate today = (LocalDate.now());
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();
		List<RunningBean> rb_list = mService.getAllOnMoive(today);
		List<MovieBean> mb_list = new ArrayList<>();
		rb_list.size();
		int pageNo =-1;
	   String pageNoStr = request.getParameter("pageNo");
        int totalPage =mService.getTotalPages(rb_list.size());
        
//        Map<Integer,MovieBean>movie= mService.getPageBooks(pageNo, rb_list);
		
        if (pageNoStr == null) {  
			pageNo = 1;
//			// 讀取瀏覽器送來的所有 Cookies
//			Cookie[] cookies = request.getCookies();
//			if (cookies != null) {
//				// 逐筆檢視Cookie內的資料
//				for (Cookie c : cookies) {
//					if (c.getName().equals(memberId + "pageNo")) {
//						try {
//							pageNo = Integer.parseInt(c.getValue().trim());
//						} catch (NumberFormatException e) {
//							;
//						}
//						break;
//					}
//				}
//			}
		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
        
        for(int i=pageNo;i<pageNo*8-1;i++) {
        	mb_list.add(rb_list.get(i).getMovie());
        }
     // 讀取一頁的書籍資料之前，告訴service，現在要讀哪一頁
     		// service.setPageNo(pageNo);
     		model.addAttribute("mb_list",mb_list);
     		// service.getPageBooks()方法開始讀取一頁的書籍資料
//     		 Map<Integer,MovieBean>movie2 = mService.getPageBooks(pageNo, rb_list);
     		 
//     		Map<Integer, BookBean> bookMap = service.getPageBooks(pageNo);
     	    request.setAttribute("pageNo", String.valueOf(pageNo));
     		request.setAttribute("totalPages", totalPage);
     		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
//     		request.setAttribute("movie", movie2);

     		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
     		// -----------------------
     		Cookie pnCookie = new Cookie( "pageNo", String.valueOf(pageNo));
     	    // 設定Cookie的存活期為30天
     		pnCookie.setMaxAge(30 * 24 * 60 * 60);
     	    // 設定Cookie的路徑為 Context Path		
     		pnCookie.setPath(request.getContextPath());
     		// 將Cookie加入回應物件內
     		response.addCookie(pnCookie);
     		// -----------------------
     		// 交由listBooks.jsp來顯示某頁的書籍資料，同時準備『第一頁』、
     		// 『前一頁』、『下一頁』、『最末頁』等資料
//     		RequestDispatcher rd = request.getRequestDispatcher("a/showAllMovie.jsp");
//     		rd.forward(request, response);
//     		return;

		// 傳空的Bean去前端//如果controller有資料要
//			model.addAttribute("Movie", rb_list);

		return "a/showAllMovie";// URL 跟 eclip 擺放位置相關

	}
	
	@RequestMapping(value="/AllMovie/MoviesPageNo=2")
	public String queryOnMovie(Model model) {
		LocalDate today = (LocalDate.now());
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();
		List<RunningBean> rb_list = mService.getAllOnMoive(today);
		List<MovieBean> mb_list = new ArrayList<>();
		for(int i=1;i<2*8-1;i++) {
			if(i<rb_list.size()) {
        	mb_list.add(rb_list.get(i).getMovie());
        }
			}
		System.out.println("123");
		return "a/showAllMovie";
	}

	@GetMapping(value = "/Method/test") // URL 跟<a href='movie/show'> 相關
	public String testMethod(Model model) {
//		LocalDate today = (LocalDate.now()).plusDays(2);
//		List<HallBean> hb_list = hService.getAllHalls(0);
//		List<HallOrderBean> hob_list = hoService.getHallOrder(today);
//		for(HallOrderBean hob:hob_list) {
//		
//			System.out.println(hob.getEndTime());
//			System.out.println(hob.getHb().getHallID());
//			System.out.println(hob.getStartTime());
//			System.out.println(hob.getOrderHours());
//			System.out.println(hb_list.get(1).getHallID());
//			if (hob.getHb().getHallID().equalsIgnoreCase(hb_list.get(1).getHallID())) {
////				HallTime = HallTime - (hob.getOrderHours()) - (restTime.getRunningTime());
//				ShowtimeBean hall = new ShowtimeBean(0, hob.getOrderHours() * 60, hob);
//				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
//				LocalDateTime date2 = LocalDateTime.parse(hob.getStartTime(), fmt);
//				hall.setStartTime(date2);
//				OrderHall_list.add(hall);
		// 創一個統稱包廳的Bean Running

//			} else {
//			}
//		}

		return "index-a";// URL 跟 eclip 擺放位置相關

	}
	//把showtimemovie 修改
	@GetMapping(value = "/showTime/update/{date}{time}{hall}")
	public String updateData(Model model, HttpServletRequest request, @PathVariable("date") String date ,@PathVariable("time") String time) {
		String[] datetime = date.split("\\=");
          System.out.println("0"+datetime[0]);
          System.out.println("1"+datetime[1]);
//          System.out.println("2"+datetime[2]);
          for(String a :datetime) {
        	  System.out.println("datetime:"+a);
          }
		System.out.println("date"+date);
		System.out.println("time"+time);


		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String str =datetime[0]+" "+datetime[1];
		System.out.println("str:"+str);
		LocalTime time1 = LocalTime.parse(str,df);
		LocalDate day1 = LocalDate.parse(str,df);
		if(time1.getHour()<=2) {
		   day1 = (LocalDate.parse(str,df)).minusDays(1);
		}else {}
		List<ShowTimeHistoryBean> STHB_List =new ArrayList();
		
//		if(datetime[2] != "All") {
//			STHB_List =mService.getshowMovieByDayAndHallID(day1, datetime[2]);
//		}else {
			//把指定日期(一天)的showTimeHistory 取出 並塞進showtimeBean
			STHB_List =mService.getshowMovie(day1);
//		}
		
		List<ShowtimeBean> oneDayShowTime = new ArrayList();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
		for(ShowTimeHistoryBean sthb :STHB_List) {
			System.out.println(sthb.getPlayStartTime());
		
			LocalDateTime dateTime = LocalDateTime.parse(sthb.getPlayStartTime(), fmt);
			oneDayShowTime.add(new ShowtimeBean(1, sthb.getRun().getMovie().getRunningTime(),sthb.getRun().getMovie().getExpectedProfit() ,
					(dateTime.toLocalDate()).toString(), (dateTime.toLocalTime()).toString(), sthb));
		}
		//確認包場
		List<HallOrderBean> hob_list = hoService.getHallOrder(day1);
		if(hob_list.size()>0) {
		   for(HallOrderBean hob : hob_list) {
			LocalDateTime dateTime = LocalDateTime.parse(hob.getStartTime(), fmt);
			oneDayShowTime.add(new ShowtimeBean(0, (hob.getOrderHours()*60), hob,(dateTime.toLocalDate()).toString(), (dateTime.toLocalTime()).toString(), hob.getHb()));
			
		   }
		}
		//取現在可以上映的movie
		List<RunningBean> rb_List=mService.getAllOnMoive(day1);
		
		//有幾廳
		List<HallBean> hb_list = hService.getAllHalls(0);
		int Hallcount = hb_list.size();// 有幾個聽
		
	
		Gson gson = new Gson();
		String runMovie = gson.toJson(rb_List);
		String hall = gson.toJson(hb_list);
		String showTime = gson.toJson(oneDayShowTime);
		request.setAttribute("showTime", showTime);
		request.setAttribute("hall", hall);
		request.setAttribute("runMovie", runMovie);

		
		
		return "a/updateShowTime";
	}


	@GetMapping(value = "/movie/autoRun") // URL 跟<a href='movie/show'> 相關
	public String RunningMovie(Model model, HttpServletRequest request) {
		List<ShowtimeBean> AllDayShowTime = new ArrayList();
		List<ShowtimeBean> AllShowTime = new ArrayList();

		int day = 2;
		// 跑第一天 //creatOneweekShowTime(LocalDateTime)
		for (int d = 2; d <= day; d++) {
			LocalDateTime runDateTime = LocalDate.now().plusDays(d).atTime(9, 0);
			ShowtimeBean restTime = new ShowtimeBean(2, 10);
			double rate = 0.8;
			mService.creatOneDayShowTime(runDateTime, rate, restTime, d, AllDayShowTime);
		}

		System.out.println("--------------------THE END--------------------------");
//希望他按照Ａ開頭排下去
		List<HallBean> hb_list2 = hService.getAllHalls(0);

		for (int d2 = 2; d2 <= day; d2++) {
			for (HallBean hb : hb_list2) {
				ShowtimeBean aa = null;
				for (ShowtimeBean stb : AllDayShowTime) {
					if ((stb.getHall().getHallID()).equalsIgnoreCase(hb.getHallID())) {

						if ((stb.getDay().toString()).equalsIgnoreCase(((LocalDate.now().plusDays(d2)).toString()))) {

							AllShowTime.add(stb);
							aa=null;
						}else {
							aa = stb;
						}
						if(aa!=null) {
						AllShowTime.add(aa);
					}
						}
					
				}
				
			}
		}
		Gson gson = new Gson();
		String jsonstring = gson.toJson(AllShowTime);
		request.setAttribute("AllShowTime", AllShowTime);
		request.setAttribute("jsonString", jsonstring);



		return "a/dataTable";// URL 跟 eclip 擺放位置相關

	}
	
	@PostMapping(value = "/update/check")
	public @ResponseBody String updateNewShowTime(Model model,
			@RequestParam(value="updateShowTime") String sth) {
//		@RequestParam("updateShowTime") String updateShowTime
//		@RequestParam(value="showTimeHistory", required = false) String showTimeHistory
		System.out.println("hihihi");
		System.out.println(" 傳回來的東西:"+sth);
		
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<ShowTimeHistoryBean>>(){}.getType();
		List<ShowTimeHistoryBean> sthb_list = new Gson().fromJson(sth, listType);
		boolean result =false;
		System.out.println(sthb_list.size());
		for(ShowTimeHistoryBean sthb: sthb_list) {
			System.out.println(sthb.getPlayStartTime());
			System.out.println(sthb.getHallID());
			System.out.println(sthb.getRunID());
			System.out.println(sthb.getShowTimeId());
			 result=mService.updateShowTimeHistoryBean(sthb);
			System.out.println(result);
			
		}
		if(result == true) {
		
			return "true";
		}
		
		return "a/oldShowTimeHistory";
	}
	
	@GetMapping(value = "/oldShowTimeHistory")
	public String showOldShowTimeHistoryData() {
		System.out.println("wwwwww");
		//日期
		LocalDateTime today= LocalDateTime.now();
        mService.getShowTimeHistoryByTime(today.toLocalDate().toString(), today.toLocalDate().toString());
		
		
		//廳
//		List<HallBean> hb_list = hService.getAllHalls(0);
//		model.addAttribute(hb_list);
		return "a/oldShowTimeHistory";
	}
	
	
	@PostMapping(value = "/showTimeHistory/show")
	public @ResponseBody String showTimeHistoryData(Model model,
			HttpServletRequest request, @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("hallID") String hallID) {
		System.out.println(start);
		System.out.println(end);
		System.out.println(hallID);
		List<ShowTimeHistoryBean> sthb_list= new ArrayList<>();
		//電影院的
		List<ShowtimeBean> showTime_list= new ArrayList<>();
		if(hallID == "All") {
			System.out.println("查詢所有的廳");
			 sthb_list=mService.getShowTimeHistoryByTime(end, start);
		}else {
		     sthb_list=mService.getShowTimeHistoryByDate(end, start,hallID);
		}
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
		for(ShowTimeHistoryBean sthb:sthb_list) {
			
			  LocalDateTime dateTime = LocalDateTime.parse(sthb.getPlayStartTime(), fmt);
			  showTime_list.add(new ShowtimeBean(1, sthb.getRun().getMovie().getRunningTime(),sthb.getRun().getMovie().getExpectedProfit() ,
						(dateTime.toLocalDate()).toString(), (dateTime.toLocalTime()).toString(), sthb));
		}
		
		
		
		//把指定日期(一天)的showTimeHistory 取出 並塞進showtimeBean
		
		
				
					
			
		//包場的
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		
//		List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
//	List<HallOrderBean> hob_list = hoService.getHallOrder(day1);
//	if(hob_list.size()>0) {
//	   for(HallOrderBean hob : hob_list) {
//		LocalDateTime dateTime = LocalDateTime.parse(hob.getStartTime(), fmt);
//		showTime.add(new ShowtimeBean(0, (hob.getOrderHours()*60), hob,(dateTime.toLocalDate()).toString(), (dateTime.toLocalTime()).toString(), hob.getHb()));
	
		Gson gson =new Gson();
		
		String showTime = gson.toJson(showTime_list);
  	   request.setAttribute("showTime", showTime);
		

		return showTime;
	}
	
	
	
	@PostMapping(value = "/save/showtime")
	public String addNewMove(Model model,
			HttpServletRequest request, @RequestParam("release") String release) {
		String url = request.getContextPath();
		System.out.println(url);
		System.out.print(release);
		Gson gson =new Gson();
		String[] stb =gson.fromJson(release, String[].class);
		for(int i=0;i<stb.length;i++) {
			System.out.print(stb[i]);
		}
		System.out.println(stb);
		
		return "index-a";
		}

	@GetMapping(value = "/commingSoon/All/movie")
	public String addCommingSoonAllMovie(Model model,
			HttpServletRequest request, @RequestParam("page") String page) {
		System.out.println("getPage:"+page);
		int pageNo = 1;
		if(page !=null) {
			pageNo = Integer.parseInt(page);
		}
		//取未來上映的電影 day  ~ 一個月
		System.out.println(pageNo);
		int totalPages= 1;
		
		List<RunningBean>rb_list=mService.getComingSoonMovie();
		totalPages = rb_list.size()/8;
		int movieNum =(pageNo*8 - (pageNo-1)*8);
		List<RunningBean>rb_page_list =new ArrayList<RunningBean>();
		for(int i=0;i<movieNum;i++) {
			rb_page_list.add(rb_list.get(i));
		}
        
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("totalPages", totalPages);
        Gson gson =new Gson();
        model.addAttribute(rb_page_list);
        request.setAttribute("rb_list", gson.toJson(rb_page_list));
		

		return "a/showCommingSoonMovie";
	}
	@PostMapping(value = "/show/this/movie")
	public   String showThisMovie(Model model,
			HttpServletRequest request ,@RequestBody RunningBean run) {
		System.out.println("inShowThisMovie");
		
		System.out.println(run);
		Gson gson = new Gson();
//		Type BeanType = new TypeToken<RunningBean>(){}.getType();
//		RunningBean rb = new Gson().fromJson(run, BeanType);
		//get showTime by runningBean
		LocalDate today = LocalDate.now();
		LocalDate endDay = today.plusWeeks(1);
		List<ShowTimeHistoryBean> sthb_list= new ArrayList<>();
		 sthb_list= mService.getRunBeanLastSTHB(run, endDay.toString(), today.toString());
		model.addAttribute(sthb_list);
		request.setAttribute("sthb_list",gson.toJson(sthb_list) );
		
//		String  runID =rb.getRunID().toString();
		
		
		return "a/showmovie";
	}
//	
//	@GetMapping(value = "/show/this/movie{runID}")
//	public String showThisMovieByrunID(Model model,
//			HttpServletRequest request,@PathVariable("runID") String runID ) {
//	//use runID get run and than get showID
//		
//		return "a/showmovie";
//	}
	
	
	
	
	
	
	
	
	

	




	

}
