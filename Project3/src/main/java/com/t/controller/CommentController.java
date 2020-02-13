package com.t.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.a.service.MovieService;
import com.a.test.ShowtimeBean;
import com.google.gson.Gson;
import com.t.model.CommentBean;
import com.t.service.CommentService;
import com.t.service.ExpectationService;
import com.t.validator.CommentValidator;

@Controller
public class CommentController {

	CommentService service;
	MovieService mService;
	ServletContext context;
	ExpectationService eService;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(CommentService service, MovieService mService, ExpectationService eService) {
		this.service = service;
		this.mService = mService;
		this.eService = eService;
	}

//	@RequestMapping("/commentGetMovieID")
//	public String getMovieById(@RequestParam("movieID") Integer movieID, Model model) {
//		model.addAttribute("movie", service.getMovieById(movieID));
//		return "movieID";
//	}

	// 印出該會員的留言
	@RequestMapping("/usercomment/{movieID}")
	public String getUserComment(HttpServletRequest request, @PathVariable("movieID") Integer movieID, Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		int commentID = service.getCommentID(memberID, movieID);
		CommentBean cb = service.getTheCommentBean(commentID);
		model.addAttribute("CommentBean", cb);
		return "t/onecomment";
	}

	// 列出所有Comment
	@RequestMapping("/findAllComment")
	public String findAllComment(Model model) {
		List<CommentBean> list = service.findAllComment();
		model.addAttribute("Comments", list);
		return "t/comments";
	}

	// 查詢並列出上映中電影ID給查詢comment
	@RequestMapping("/getMovieID")
	public String seleteMovieID(Model model) {
		List<String> list = service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/selectmovieID";
	}

	// 查詢並列出上映中電影ID給新增comment
	@RequestMapping("/getMovieIDforadd")
	public String seleteMovieIDForAdd(Model model) {
		List<String> list = service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/addcommentbymovieID";
	}

	// 用movieID查詢comment
	@RequestMapping("/comments/{movieID}")
	public String getCommentByMovie(@PathVariable("movieID") Integer movieID, Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		Double avgGrade = service.getAvgGrade(movieID);
		if (avgGrade == 0) {
			model.addAttribute("AVGGrade", "尚無評價");
		} else {
			model.addAttribute("AVGGrade", avgGrade);
		}
		if (mID == null) {
			List<CommentBean> comments = service.getCommentByMovieNoLoginByTime(movieID);
			model.addAttribute("Comments", comments);
		} else {
			int memberIDBlock = Integer.parseInt(mID);
			List<CommentBean> comments = service.getCommentByMovieOrderByTime(movieID, memberIDBlock);
			model.addAttribute("Comments", comments);
		}
		return "t/comments";
	}

//	@RequestMapping(value = "/comments/add/{movieID}", method = RequestMethod.GET)
//	public String getAddNewComment(@PathVariable("movieID")Integer movieID,HttpServletRequest request,Model model) {
//		Cookie[] cookies = request.getCookies();
//		String mID = null;
//		for (Cookie cookie : cookies) {
//			String name = cookie.getName();
//			if(name.equals("memberID")) {
//				mID = cookie.getValue();
//			}
//		}
//		int memberID = Integer.parseInt(mID);
//		//檢查是否有在該電影留過言
//		boolean ce = service.checkCommentExist(memberID,movieID);
//		//如果有 印出該留言並提供修改或刪除選項
//		if(ce == true){
//			int commentID = service.getCommentID(memberID,movieID);
//			CommentBean cb = service.getTheCommentBean(commentID);
//			model.addAttribute("CommentBean", cb);
//			return "t/onecomment";
//		}
//		//如果無 顯示撰寫區
//		else{
//			CommentBean cb = new CommentBean();
//			model.addAttribute("commentBean",cb);
//			return "t/addcomment";
//		}		
//	}

	@RequestMapping(value = "/comments/add/{runID}", method = RequestMethod.POST)
	public String processAddNewComment(@PathVariable("runID") String runID,
			@ModelAttribute("commentBean") CommentBean cb, BindingResult result, HttpServletRequest request,
			Model model) {
		RunningBean run = mService.getRunningBeanById(runID);

		HashMap<String, String> errorMsgMap1 = new HashMap<String, String>();

		if (cb.getWatched() == null) {
			errorMsgMap1.put("watchedError", "您不可來自未來!");
		}

		if (!errorMsgMap1.isEmpty()) {
			model.addAttribute("errorMsgMap", errorMsgMap1);
//			System.out.println("有近來這邊嗎11111");
			return "redirect:/show/this/movie?runID=" + runID;
		}

//		System.out.println("有近來這邊嗎????");

		CommentValidator validator = new CommentValidator();
		// 呼叫Validate進行資料檢查
		validator.validate(cb, result);
		if (result.hasErrors()) {
			return "redirect:/show/this/movie?runID=" + runID;
		}
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		if (mID == null) {
			return "redirect:/member/login";
		} else {
			int movieID = run.getMovie().getMovieID();
			int nMID = Integer.parseInt(mID);
			cb.setMemberID(nMID);
			cb.setMovieID(movieID);
			cb.setCommentDelete(0);
			cb.setReportComment(0);
			service.addComment(cb);
		}
		return "redirect:/show/this/movie?runID=" + runID;
	}

	// 自行刪除
	@RequestMapping("/comments/delete/{runID}")
	public String deleteComment(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			@ModelAttribute("updateComment") CommentBean cb2, Model model) {
		cb2.setCommentID(commentID);
		service.deleteComment(commentID);
		return "redirect:/show/this/movie?runID=" + runID;
	}

	// 從後台取消檢舉
	@RequestMapping("/comments/cancalreport/{commentID}")
	public String cancalReportComment(@PathVariable("commentID") Integer commentID,
			@ModelAttribute("CommentBean") CommentBean cb, Model model) {
		cb.setCommentID(commentID);
		service.cancalReportComment(commentID);
		return "redirect:/findAllReportComment";
	}
	
	// 從後台刪除
	@RequestMapping("/comments/deletereport/{commentID}")
	public String deleteCommentFromBack(@PathVariable("commentID") Integer commentID,
			@ModelAttribute("CommentBean") CommentBean cb, Model model) {
		cb.setCommentID(commentID);
		service.deleteComment(commentID);
		return "redirect:/findAllReportComment";
	}

	//檢舉
	@RequestMapping("/comments/report/{runID}")
	public String reportComment(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			@ModelAttribute("CommentBean") CommentBean cb, Model model) {
		cb.setCommentID(commentID);
		service.reportComment(commentID);
		return "redirect:/show/this/movie?runID=" + runID;
	}

	// 查詢單筆
	@RequestMapping("/onecomment")
	public String getOneCommentBean(Integer commentID, Model model) {
		model.addAttribute("Comment", service.getTheCommentBean(commentID));
		return "t/onecomment";
	}

//	//抓出所有commentBean裡的東西
//	@RequestMapping(value = "/update/comment")
//	public String getupdateProducts(Model model) {
//		List<CommentBean> list=service.findAllComment();
//		model.addAttribute("comment", list);
//		return "t/onecomment";
//	}

	// 用對應的commentID找出該comment的資料
//	@RequestMapping(value = "/update/comment/{commentID}", method = RequestMethod.GET)
//	public String getupdateComment(@PathVariable("commentID")Integer commentID,Model model) {
//		CommentBean cb = service.getTheCommentBean(commentID);
//		model.addAttribute("CommentBean", cb);
//		return "t/updatecomment";
//	}

//	@RequestMapping(value = "/update/comment/{commentID}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")
//	public @ResponseBody String getupdateComment2(Model model) {
//		int commentID = service.getCommentID(memberID,movieID);
//		CommentBean cb = service.getTheCommentBean(commentID);
//		model.addAttribute("updateComment", cb);
//		Gson gson = new Gson();
//		String str = gson.toJson(cb);
//		return str;
//	}

	// 修改該留言內容
	@RequestMapping(value = "/update/comment/{runID}", method = RequestMethod.POST)
	public String proccessupdateComment(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			@ModelAttribute("updateComment") CommentBean cb1, Model model) {
		cb1.setCommentID(commentID); // 抓ID塞進cb1
		service.updateComment(cb1);
		return "redirect:/show/this/movie?runID=" + runID;
	}

	// 列出所有被檢舉的Comment
//	@RequestMapping("/findAllReportComment")
//	public String findAllReportComment(Model model) {
//		List<CommentBean> list=service.findAllReportComment();
//		model.addAttribute("ReportComments", list);
//		return "t/reportedcomment";
//	}

	// 列出所有被檢舉的Comment
	@RequestMapping("/findAllReportComment")
	public String findAllReportComment(Model model) {
		List<CommentBean> list = service.findAllReportComment();
		model.addAttribute("ReportComments", list);
		return "t/thereported";
	}

	@RequestMapping(value = "/reportedAjax", produces = "application/json;charset=UTF-8;")
	public @ResponseBody String getAllEmpsAjax(Model model) {
		List<CommentBean> list = service.findAllReportComment();
		model.addAttribute("ReportComments", list);
		Gson gson = new Gson();
		String str = gson.toJson(list);
		return str;
	}

	@ModelAttribute("movieList")
	public Map<Integer, String> getMovieList() {
		Map<Integer, String> MovieMap = new HashMap<>();
		List<MovieBean> list = service.getMovieList();
		for (MovieBean mb : list) {
			MovieMap.put(mb.getMovieID(), mb.getTitle());
		}
		return MovieMap;
	}
//	
//	@ModelAttribute("memberList")
//	public Map<Integer, String> getMemberList() {
//		Map<Integer, String> MemberMap = new HashMap<>();
//		List<MemberBean> list = service.getMemberList();
//		for (MemberBean mb : list) {
//			MemberMap.put(mb.getMemberID(),mb.getAccount());
//		}
//		return MemberMap;
//	}

	// 顯示單個已經上映電影
	@RequestMapping(value = "/show/this/movie/bygrade/{runID}")
	public String showThisMovieByGrade(@PathVariable("runID") String runID, Model model, HttpServletRequest request) {
		RunningBean run = mService.getRunningBeanById(runID);
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}

		int movieID = run.getMovie().getMovieID();

		Double avgGrade = service.getAvgGrade(movieID);
		if (avgGrade == 0) {
			model.addAttribute("AVGGrade", "尚無評價");
		} else {
			model.addAttribute("AVGGrade", avgGrade);
		}
		// 印所有留言
		if (mID == null) {
			List<CommentBean> comments = service.getCommentByMovieNoLoginByGradeDesc(movieID);
			model.addAttribute("Comments", comments);

			model.addAttribute("haveComment", "0");
			CommentBean cb = new CommentBean();
			model.addAttribute("commentBean", cb);
		} else {
			int memberIDBlock = Integer.parseInt(mID);
			List<CommentBean> comments = service.getCommentByMovieOrderByGradeDesc(movieID, memberIDBlock);
			model.addAttribute("Comments", comments);

			int memberID = Integer.parseInt(mID);
			// 檢驗是否在這電影留過言
			boolean ce = service.checkCommentExist(memberID, movieID);
			// 如果有 印出該留言並可修改
			if (ce == true) {
				int commentID = service.getCommentID(memberID, movieID);
				CommentBean cb1 = service.getTheCommentBean(commentID);
				model.addAttribute("haveComment", "1");
				model.addAttribute("updateComment", cb1);
			} // 如果無 印出留言區
			else {
				model.addAttribute("haveComment", "0");
				CommentBean cb = new CommentBean();
				model.addAttribute("commentBean", cb);
			}
		}

		Integer avgExpectation = eService.getAvgExpectation(movieID);
		if (avgExpectation == null) {
			model.addAttribute("AVGExpectation", "尚無資料");
		} else {
			model.addAttribute("AVGExpectation", avgExpectation);
		}

		System.out.println("inShowThisMovie");

		System.out.println(runID);
		Gson gson = new Gson();
//			Type BeanType = new TypeToken<RunningBean>(){}.getType();
//			RunningBean rb = new Gson().fromJson(run, BeanType);
		// get showTime by runningBean
		System.out.println("電影名稱:" + run.getMovie().getTitle());

		LocalDate today = LocalDate.now();
		LocalDate endDay = today.plusWeeks(1);
		List<ShowTimeHistoryBean> sthb_list = new ArrayList<>();
//			 sthb_list= mService.getRunBeanLastSTHB(run, endDay.toString(), today.toString());
		sthb_list = mService.getShowTimeHistoryListByRunIDAndTime(runID, endDay.toString(), today.toString());
		List<ShowtimeBean> oneMovie = new ArrayList();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");

		// sort by time
		mService.sortShowTimeByTime(sthb_list);

		// put in oneMovie
		for (ShowTimeHistoryBean sthb : sthb_list) {
			System.out.println(sthb.getPlayStartTime());

			LocalDateTime dateTime = LocalDateTime.parse(sthb.getPlayStartTime(), fmt);
			oneMovie.add(new ShowtimeBean(1, sthb, (dateTime.toLocalDate()).toString(),
					(dateTime.toLocalTime()).toString()));
		}
		model.addAttribute("run", run);
//			 System.out.println("電影名稱2:"+sthb_list.get(1).getRun().getMovie().getTitle());
		model.addAttribute("sthb_list1", sthb_list);
		model.addAttribute("oneMovie1", oneMovie);
		request.setAttribute("sthb_list", gson.toJson(sthb_list));
		request.setAttribute("oneMovie", gson.toJson(oneMovie));

//			String  runID =rb.getRunID().toString();

		return "a/showMovie2";
	}

	// 修改該留言內容
	@RequestMapping(value = "/show/this/movie/bytime/{runID}")
	public String showThisMovieByTime(@PathVariable("runID") String runID,Model model) {		
		return "redirect:/show/this/movie?runID=" + runID;
	}
}
