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
	@GetMapping(value = "/showTime/update/{date}{time}")
	public String addNewMovie(Model model, HttpServletRequest request, @PathVariable("date") String date ,@PathVariable("time") String time) {
		String[] datetime = date.split("\\|");
          System.out.println("0"+datetime[0]);
          System.out.println("1"+datetime[1]);
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
		}
		//把指定日期(一天)的showTimeHistory 取出 並塞進showtimeBean
		List<ShowTimeHistoryBean> STHB_List =mService.getshowMovie(day1);
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
			creatOneDayShowTime(runDateTime, rate, restTime, d, AllDayShowTime);
		}

		System.out.println("--------------------THE END--------------------------");

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
	public String updateNewShowTime(Model model,
			@RequestParam(value="updateShowTime") String sth) {
//		@RequestParam("updateShowTime") String updateShowTime
//		@RequestParam(value="showTimeHistory", required = false) String showTimeHistory
		System.out.println("hihihi");
		System.out.println(" 傳回來的東西:"+sth);
		
//		Gson gson = new Gson();
//		Type listType = new TypeToken<ArrayList<ShowTimeHistoryBean>>(){}.getType();
//		List<ShowTimeHistoryBean> sthb_list = new Gson().fromJson(sth, listType);
//		
//		System.out.println(sthb_list.size());
//		for(ShowTimeHistoryBean sthb: sthb_list) {
//			System.out.println(sthb.getPlayStartTime());
//		}

		
		
		return "index-a";
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

	public int checkHallOrder(LocalDateTime runDateTime, HallBean hb, int HallTime, List<ShowtimeBean> OrderHall_list) {
		int HallOrderTime = 0;
		List<HallOrderBean> hob_list = hoService.getHallOrder(runDateTime.toLocalDate());
		if (hob_list.size() != 0) {
			for (HallOrderBean hob : hob_list) {
				if (hob.getHb().getHallID().equalsIgnoreCase(hb.getHallID())) {
//					HallTime = HallTime - (hob.getOrderHours()) - (restTime.getRunningTime());
					ShowtimeBean hall = new ShowtimeBean(0, hob.getOrderHours() * 60, hob);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
					LocalDateTime date2 = LocalDateTime.parse(hob.getStartTime(), fmt);
					hall.setStartTime(date2);
					hall.setDay(date2.toLocalDate());
					hall.setTime(date2.toLocalTime());
					hall.setHall(hob.getHb());
					OrderHall_list.add(hall);
					// 創一個統稱包廳的Bean Running
					HallOrderTime += (hob.getOrderHours() * 60);
				} else {
				}

			}

		} else {
		}
		return HallOrderTime;

	}

	public void setAllMoviePT(List<RunningBean> Allrb_list, List<ShowtimeBean> runMovie_list) {
		System.out.println("--------------------------------- 所有可排片size:" + Allrb_list.size());
		for (RunningBean rb : Allrb_list) {
			// setPTValue
			if (rb.getMovie().getMovieStatusBean().getStatusID() == 0) {
				// 新片取預估ＰＴ
				ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
						rb.getMovie().getExpectedProfit(), rb);
				mService.updateMovieStatus(rb.getMovie(), 1);
				runMovie_list.add(movie);

			} else if (rb.getMovie().getMovieStatusBean().getStatusID() == 1) {
				// 舊片取上星期ＰＴ值
				// 先取showtimeHitory
				// 這邊會有問題runningID 一部電影可能有兩個
				List<RunningBean> Movie_rb_list = mService.getnRunningBeanByMovieID(rb.getMovie().getMovieID());
				int AllPrice = 0;
				int AllTime = 0;
				for (RunningBean rb2 : Movie_rb_list) {
					List<ShowTimeHistoryBean> sthb_list = mService.getShowTimeHistoryBean(rb2);
					AllTime = AllTime + (sthb_list.size()) * (rb2.getMovie().getRunningTime());

					for (ShowTimeHistoryBean sthb : sthb_list) {
						// showID to seatOrder get seatOrder //seatOrderList.size()*270//P
						// AllPrice= AllPrice +(seatOrderList.size()*270);
						// getOrderBean (List)
						// AllPrice = AllPrice +(getTickBean(List) .size()*票價 （票的總類？？票價）)
					}
				}
				// hihi這邊要改 rb.getMovie().getExpectedProfit() 改成 AllPrice/AllTime
				ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
						rb.getMovie().getExpectedProfit(), rb);
				runMovie_list.add(movie);
			} else {
				System.out.println("下檔");
			}
		}
		System.out.println("=============before sort=============");
		for (ShowtimeBean sb : runMovie_list) {
			System.out.println(sb.getRb().getRunID() + "  " + sb.getPrice_time());
		}
		mService.sortPT(runMovie_list);
		// Sort runMovie List order by PT
		System.out.println("after======sort");
		for (ShowtimeBean sb : runMovie_list) {
			System.out.println(sb.getRb().getRunID() + "  " + sb.getPrice_time());
		}

	}

	public void setHallOrderAndotherMovieInFinalList(LocalDateTime runDateTime, int HallTime,
			List<ShowtimeBean> OrderHall_list, List<ShowtimeBean> changeTimeList_list,
			List<ShowtimeBean> FinalShowMovie_list, ShowtimeBean restTime,String HallName) {
		if(OrderHall_list.size()==0) {
			changeTimeList_list.add(0,restTime);
			for(ShowtimeBean stb:changeTimeList_list) {
				 FinalShowMovie_list.add(stb);
			}
			
		}else {
		for (int oht = 0; oht < OrderHall_list.size(); oht++) {
			OrderHall_list.get(oht).getStartTime();// String to LoalDateTime
            System.out.println("orderHallTimeStart:"+OrderHall_list.get(oht).getStartTime());
			Duration duration = Duration.between(runDateTime,OrderHall_list.get(oht).getStartTime());
			System.out.println("runDateTime:"+runDateTime);
			int minust1 = (int) duration.toMinutes();
			System.out.println("minust1:"+minust1);//60
			System.out.println("duration:"+duration);
			int runtimeTotal = 0;
			int runtime = 0;
			for (int t = 0; t < changeTimeList_list.size(); t++) {
			
				runtimeTotal = runtime + changeTimeList_list.get(t).getRunningTime();//142
				System.out.println(runtimeTotal);
				System.out.println(runtime);
				if (runtime < minust1 && runtimeTotal > minust1) {
					System.out.println("IN IF------------:runtime < minust1 && runtimeTotal > minust1");
					if (minust1 - runtime > HallTime) {
						System.out.println("-----------------Insert orderHall");
						FinalShowMovie_list.add(new ShowtimeBean(0,minust1));
						FinalShowMovie_list.add(OrderHall_list.get(oht));
						runtimeTotal =runtimeTotal+OrderHall_list.get(oht).getRunningTime();
						runtime =runtimeTotal;

					} else {
						System.out.println("-----------------Insert orderHall2");
						FinalShowMovie_list.add(OrderHall_list.get(oht));
						FinalShowMovie_list.add(changeTimeList_list.get(t));
						runtimeTotal =runtimeTotal+OrderHall_list.get(oht).getRunningTime();
						runtime =runtimeTotal;
//		    				 HallTime =HallTime-(OrderHall_list.get(o).getRunningTime());
					}

				} else {
					FinalShowMovie_list.add(changeTimeList_list.get(t));
				}
				runtime = runtimeTotal;
			}
//		    	
		}
		}



	}

	public void saveshowTimeHitory(List<ShowtimeBean> FinalShowMovie_list, LocalDateTime runDateTime, HallBean hall,
			int restTime, List<ShowtimeBean> AllDayShowTime) {
//		if(Halltime>0 ) {
//			int r=((Halltime)/(FinalShowMovie_list.size()));

//		}else {}
		for (ShowtimeBean stb : FinalShowMovie_list) {
			stb.setStartTime(runDateTime);
			stb.setDay(runDateTime.toLocalDate());// .plusMinutes(restTime)
			stb.setTime(runDateTime.toLocalTime());// .plusMinutes(restTime)
			System.out.println("runDateTime1:" + runDateTime);
			runDateTime = runDateTime.plusMinutes(stb.getRunningTime());
			// 如果(把休息時間排除)
			System.out.println("runDateTime2:" + runDateTime);
			System.out.println("stb.getStID()" + stb.getStID());
			if (stb.getStID() == 1) {
//				HallBean dfa = hb_list.get(Hall_i);
				System.out.println("幾廳" + hall.getHallID());
				stb.setHall(hall);
//				 AllDayShowTime.put(hall.getHallID(), stb);
				String showtime = (stb.getStartTime().toLocalDate()).toString() + " "
						+ (stb.getStartTime().toLocalTime()).toString();
				System.out.println(showtime);
				ShowTimeHistoryBean show = new ShowTimeHistoryBean(hall, stb.getRb(), showtime);
				mService.addShowTimeHistory(show);
//				int showTimeId =mService.getShowTimeIdByTime(showtime);
				
				AllDayShowTime.add(new ShowtimeBean(1, stb.getRunningTime(),Math.round(stb.getPrice_time()) , stb.getRb(),
						stb.getDay(), stb.getTime(), hall));
      			
      			System.out.println("AllDayShowTime1:"+AllDayShowTime.size());
				System.out.println("stb.RunID()" + stb.getRb().getRunID());
//				System.out.println("MovieInsertHallsize:" + MovieInsetHall_list.size());
				System.out.println("----------------------------------------------");
			} else if (stb.getStID() == 0) {
				AllDayShowTime.add(
						new ShowtimeBean(0, stb.getRunningTime(), stb.getHob(), stb.getDay(), stb.getTime(), hall));
				stb.setHall(hall);

//			 AllDayShowTime.put(hall.getHallID(), stb);
				System.out.println("----------------------------------------------have HallOrder ");
			}
			
		}

		System.out.println("AllDayShowTime2:" + AllDayShowTime.size());
		System.out.println("FinalShowMovie_list" + FinalShowMovie_list.size());
	}

	public void creatOneDayShowTime(LocalDateTime runDateTime, double rate, ShowtimeBean restTime, int d,
			List<ShowtimeBean> AllDayShowTime) {
//		int startTime =9;
//      public void creatOneDayShowTime(LocalDateTime runDateTime) {};
		List<RunningBean> Allrb_list = new ArrayList<>();// 存電影排片 還沒有PT
		List<ShowtimeBean> runMovie_list = new ArrayList<>(); // 存電影排片 有PT值的
//		ShowtimeBean restTime = new ShowtimeBean(2, 10);// 清場時間（分鐘）

//		double rate = 0.8;// 遞減函數

//		LocalDateTime runDateTime = LocalDate.now().plusDays(1).atTime(9, 0); // 初始時間
		// 確認廳數 //checkUseHall
		// 確認那些影廳可以用 status =0=ok
		List<HallBean> hb_list = hService.getAllHalls(0);

		int Hallcount = hb_list.size();// 有幾個聽
		// Sort Hall orderby 座位數(大到小)
		Comparator Hallcomp = new Hallcomparator();
		Collections.sort(hb_list, Hallcomp);
		System.out.println("============= 確認那些影廳可以用  結束:================= ");



		// 取出今天可以排片的片
		Allrb_list = mService.getAllOnMoive(runDateTime.toLocalDate());
		System.out.println("今天可以排片的片:" + Allrb_list);

//	 }
		// 取出今天一定要排片
		List<RunningBean> shouldRB_list = mService.checkContract(Allrb_list);
		System.out.println("一定要排片:" + shouldRB_list);

		// PT排片 public setAllMoviePT(
		// List<RunningBean>Allrb_list,List<ShowtimeBean>runMovie_list){ }
		// 分出已上映 未上映 setPTValue
		//
		setAllMoviePT(Allrb_list, runMovie_list);
		System.out.println("=============setAllMoviePT 結束:================= ");
		// 從第一廳開始排
		for (int Hall_i = 0; Hall_i < Hallcount; Hall_i++) {
			restTime.setRunningTime(10);
			System.out.println("第幾廳: " + (Hall_i + 1) + hb_list.get(Hall_i).getHallID());
			runDateTime = LocalDate.now().plusDays(d).atTime(9, 0);

			List<ShowtimeBean> OrderHall_list = new ArrayList<>(); // 存包場
			List<ShowtimeBean> Contract_list = new ArrayList<>(); // 存合約
			List<ShowtimeBean> MovieInsetHall_list = new ArrayList<>(); // 存按照PT值排好的順序
			List<ShowtimeBean> changeTimeList_list = new ArrayList<>();// 最後排片(放時間)
			List<ShowtimeBean> FinalShowMovie_list = new ArrayList<>();// 最後排片(放時間)
			int HallTime = 1020; // 1020營業時間＊60(分鐘）

//			runDateTime = LocalDate.now().plusDays(1).atTime(9, 0);
			System.out.println("StartTime-------:" + HallTime);
			// 確認包場
			// void checkHallOrder(LocalDateTime runDateTime ,int i, List<HallBean> hb_list)
			HallTime = HallTime - checkHallOrder(runDateTime, hb_list.get(Hall_i), HallTime, OrderHall_list);
			System.out.println("=============包場 結束:================= ");
			System.out.println("合約數量:" + Contract_list.size());
			System.out.println("必須排數量:" + shouldRB_list.size());
//			System.out.println("InOneHall:" + InOneHall);
			System.out.println("checkHallOrder---------------:" + HallTime);
			// 把合約內容排進去 addContract
			int shouldcount = shouldRB_list.size();
			int InOneHall = (shouldcount / Hallcount);
			int lestHall = (shouldcount % Hallcount);
			System.out.println("InOneHall: " + InOneHall);
			System.out.println("lestHall: " + lestHall);
			System.out.println("contract1----HallTime----:" + HallTime);
			if (shouldRB_list.size() > 0) {

				if (Hall_i - (Hallcount - lestHall) >= 0 && !(InOneHall < 1)) {
					InOneHall += 1;
				}

				for (int j = 0; j < InOneHall; j++) {

					RunningBean rb = shouldRB_list.get(0);
					ShowtimeBean movie = new ShowtimeBean(1, rb.getMovie().getRunningTime(),
							rb.getMovie().getExpectedProfit(), rb);
					HallTime = HallTime - (movie.getRunningTime()) - (restTime.getRunningTime());
					Contract_list.add(movie);
					shouldRB_list.remove(rb);
				}
				System.out.println("第幾個聽:" + Hall_i);
			}
			System.out.println("contract1----HallTime----:" + HallTime);
			System.out.println("=============合約結束:================= ");
//          if(d>1) {
//          	Allrb_list.clear();
//          }
//			

			System.out.println("runMovie_list in MovieInsetHall_list-----------------------------------------------");
			System.out.println("MovieInsetHall_list:" + MovieInsetHall_list.size());
			System.out.println("runMovie Size:" + runMovie_list.size());
			System.out.println("HallTime :" + HallTime);

			// public void runMovieByPT(int HallTime,runMovie_list ) {}
			System.out.println("runMovie_list in MovieInsetHall_list-----------------------------------------------");

			while (HallTime > 0) {
				boolean runMoviedetect = false;

				for (int l = 0; l < (runMovie_list.size() - 1); l++) {

					if (HallTime > runMovie_list.get(l).getRunningTime()) {
						HallTime = HallTime - ((runMovie_list.get(l)).getRunningTime()) - (restTime.getRunningTime());
						MovieInsetHall_list.add(runMovie_list.get(l));

						runMovie_list.get(l).setPrice_time(runMovie_list.get(l).getPrice_time() * rate);
//											showMovie_list.add(restTime);
						System.out.println("2: " + HallTime);
						mService.sortPT(runMovie_list);
						runMoviedetect = true;
						break;
					} else {
					}
				}

				if (!runMoviedetect) {
					break;
				}
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());
			System.out.println("決定電影ＰＴ值順序結束" + MovieInsetHall_list.size());

			// 把合約跟ＰＴ排片合併 Contract_list MovieInsetHall_list
			for (ShowtimeBean stb : Contract_list) {
//				stb.setHall(hb_list.get(Hall_i));
				System.out.println(stb.getHall().getHallID());
				System.out.println("=================================Contract RunID" + stb.getRb().getRunID());
				MovieInsetHall_list.add(stb);
			}
			System.out.println("MovieInsertHall Size:" + MovieInsetHall_list.size());
			
			// 調整休息時間長度
			if(OrderHall_list.size()<=0) {
				System.out.println("-----------------------change restTime3");
				int r = ((HallTime) / (MovieInsetHall_list.size()));
				if (HallTime > 0) {
					restTime.setRunningTime(restTime.getRunningTime() + r);
				} else {}
			}else {}
			
			// 排時間
//							runDateTime.minusMinutes(chaneTime);
			// 找出需要推移的時間有多少 insertTime 回傳int should changeTime
//						public void setTime() {}

			// 取1-2 （壓在1點分界的）
			// public int changeTimeAbout1to2clock(int runtimeTotal,int
			// thisTime,List<ShowtimeBean> MovieInsetHall_list)
			// retrun (runtimeTotal - thisTime)
			// int minusTime = minusTime(MovieInsetHall_list);
			int runtimeTotal = 0;
			int thisTime = 900;

			for (ShowtimeBean stb : MovieInsetHall_list) {
				// 表示電影
				runtimeTotal = runtimeTotal + stb.getRunningTime() + restTime.getRunningTime();

				if (runtimeTotal > thisTime) { // 900
					break; // 要往前推的秒數

				} else {
				}

			}
			System.out.println(runtimeTotal);

//							runDateTime=runDateTime.minusMinutes(runtimeTotal-900);
			// 取9-12 （壓在9點分界的）
			// 把時間放進去public sortFinal(int minusTime,MovieInsetHall_list){}
			System.out.println("要往前推多久:" + (runtimeTotal - thisTime));
			System.out.println(" 取9-12 （壓在9點分界的）-----------------------------------------------");
			System.out.println(runDateTime);
			int runtime = 0;
			if (runtimeTotal < 0) {

			} else {
				runtime = 0 - (runtimeTotal - thisTime);
			}

			runtimeTotal = 0;

			for (int s = 0; s < MovieInsetHall_list.size(); s++) {// 可能會出問題
//				System.out.println(" s" + s);
//				System.out.println(" MovieInsetHall_list" + MovieInsetHall_list.size());
//				System.out.println(" runtime1:" + runtimeTotal);
				// 表示電影
				runtimeTotal = runtime + MovieInsetHall_list.get(s).getRunningTime();
				System.out.println(" runtime2:" + runtimeTotal);
				if (runtimeTotal > 780 && runtime <= 780 + 180) {// 720
					changeTimeList_list.add(0, MovieInsetHall_list.get(s));
					changeTimeList_list.add(1,restTime);
					System.out.println(" 取9-12 ----------------");

				} else {
					changeTimeList_list.add(MovieInsetHall_list.get(s));
					changeTimeList_list.add(restTime);
					runtime = runtimeTotal;
				}
			}
			
//			for(ShowtimeBean stb:changeTimeList_list) {
//				System.out.println("C排序-----------------------");
//				System.out.println(stb.getStID());
//			}

			// 處理包場問題

			setHallOrderAndotherMovieInFinalList(runDateTime, HallTime, OrderHall_list, changeTimeList_list,
					FinalShowMovie_list, restTime,hb_list.get(Hall_i).getHallID());

			System.out.println("----解決包場問題-------------------------------------------");
		
			System.out.println("contract1----HallTime----:" + HallTime);
			System.out.println(" changeTimeList_list size:" + changeTimeList_list.size());
			System.out.println(" FinalShowMovie_list size:" + FinalShowMovie_list.size());
			System.out.println(" MovieInsetHall_list size:" + MovieInsetHall_list.size());
			System.out.println("-----------------------------------------------");
			// save showTimeHitory(List<ShowtimeBean> FinalShowMovie_list)

			// 把東西存進去排片
			saveshowTimeHitory(FinalShowMovie_list, runDateTime, hb_list.get(Hall_i), restTime.getRunningTime(),
					AllDayShowTime);
		

			System.out.println("--------------------THE END--------------------------");
		} // 廳
	}

	

}
