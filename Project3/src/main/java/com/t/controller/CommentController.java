package com.t.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
import com.google.gson.Gson;
import com.p.model.MemberBean;
import com.p.validator.MemberValidator;
import com.t.model.CommentBean;
import com.t.service.CommentService;
import com.t.validator.CommentValidator;
import com.z.model.EmpBean;

@Controller
public class CommentController {

	CommentService service;
	ServletContext context;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(CommentService service) {
		this.service = service;
	}
	
//	@RequestMapping("/commentGetMovieID")
//	public String getMovieById(@RequestParam("movieID") Integer movieID, Model model) {
//		model.addAttribute("movie", service.getMovieById(movieID));
//		return "movieID";
//	}
	
	//印出該會員的留言
	@RequestMapping("/usercomment/{movieID}")
	public String getUserComment(HttpServletRequest request,@PathVariable("movieID")Integer movieID,Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		int commentID = service.getCommentID(memberID,movieID);
		CommentBean cb = service.getTheCommentBean(commentID);
		model.addAttribute("CommentBean", cb);
		return "t/onecomment";
	}
	
	//列出所有Comment
	@RequestMapping("/findAllComment")
	public String findAllComment(Model model) {
		List<CommentBean> list=service.findAllComment();
		model.addAttribute("Comments", list);
		return "t/comments";
	}
	
	//查詢並列出上映中電影ID給查詢comment
	@RequestMapping("/getMovieID")
	public String seleteMovieID(Model model) {
		List<String> list=service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/selectmovieID";
	}
	
	//查詢並列出上映中電影ID給新增comment
	@RequestMapping("/getMovieIDforadd")
	public String seleteMovieIDForAdd(Model model) {
		List<String> list=service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/addcommentbymovieID";
	}
	
	//用movieID查詢comment
	@RequestMapping("/comments/{movieID}")
	public String getCommentByMovie(@PathVariable("movieID")Integer movieID,Model model,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		Double avgGrade = service.getAvgGrade(movieID);
		if(avgGrade == 0) {
			model.addAttribute("AVGGrade", "尚無評價");
		}else {
			model.addAttribute("AVGGrade", avgGrade);
		}		
		if(mID == null) {
			List<CommentBean> comments=service.getCommentByMovieNoLoginByTime(movieID);
			model.addAttribute("Comments", comments);
		}else {
			int memberIDBlock = Integer.parseInt(mID);
			List<CommentBean> comments=service.getCommentByMovieOrderByTime(movieID, memberIDBlock);
			model.addAttribute("Comments", comments);
		}		
		return "t/comments";
	}
	
	@RequestMapping(value = "/comments/add/{movieID}", method = RequestMethod.GET)
	public String getAddNewComment(@PathVariable("movieID")Integer movieID,HttpServletRequest request,Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		//檢查是否有在該電影留過言
		boolean ce = service.checkCommentExist(memberID,movieID);
		//如果有 印出該留言並提供修改或刪除選項
		if(ce == true){
			System.out.println("memberID = " + memberID);
			System.out.println("movieID = " + movieID);
			int commentID = service.getCommentID(memberID,movieID);
			CommentBean cb = service.getTheCommentBean(commentID);
			model.addAttribute("CommentBean", cb);
			return "t/onecomment";
		}
		//如果無 顯示撰寫區
		else{
			CommentBean cb = new CommentBean();
			model.addAttribute("commentBean",cb);
			return "t/addcomment";
		}		
	}
	
	@RequestMapping(value = "/comments/add/{movieID}", method = RequestMethod.POST)
	public String processAddNewComment(@PathVariable("movieID")Integer movieID,CommentBean cb,BindingResult result,HttpServletRequest request) {
		CommentValidator validator = new CommentValidator();
		// 呼叫Validate進行資料檢查
		validator.validate(cb, result);
		if (result.hasErrors()) {
			return "t/addcomment";
		}
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		if(mID == null) {
			return "redirect:/member/login";
		}else {
			int nMID = Integer.parseInt(mID);
			cb.setMemberID(nMID);
			cb.setCommentDelete(0);
			cb.setReportComment(0);
			service.addComment(cb);
		}
		return "redirect:/comments/{movieID}";	
	}
	
	//用戶自行刪除
//	@RequestMapping("/comments/delete/{commentID}")
//	public String getDeleteComment(@PathVariable("commentID")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
//		cb.setCommentID(commentID);
//		service.deleteComment(commentID);
//		return "redirect:/findAllComment";		
//	}
	
	
	//從後台刪除
	@RequestMapping("/comments/delete/{commentID}")
	public String deleteComment(@PathVariable("commentID")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);
		service.deleteComment(commentID);
		return "redirect:/findAllReportComment";		
	}
	
	//從後台取消檢舉
	@RequestMapping("/comments/cancalreport/{commentID}")
	public String cancalReportComment(@PathVariable("commentID")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);
		service.cancalReportComment(commentID);
		return "redirect:/findAllReportComment";		
	}
	
	@RequestMapping("/comments/report/{movieID}")
	public String reportComment(@PathVariable("movieID")Integer movieID,@RequestParam("id")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);
		service.reportComment(commentID);
		return "redirect:/comments/{movieID}";
	}
	
	//查詢單筆
	@RequestMapping("/onecomment")
	public String getOneCommentBean(Integer commentID,Model model) {
		model.addAttribute("Comment",service.getTheCommentBean(commentID));
		return "t/onecomment";
	}
	
//	//抓出所有commentBean裡的東西
//	@RequestMapping(value = "/update/comment")
//	public String getupdateProducts(Model model) {
//		List<CommentBean> list=service.findAllComment();
//		model.addAttribute("comment", list);
//		return "t/onecomment";
//	}
	
	//用對應的commentID找出該comment的資料
	@RequestMapping(value = "/update/comment/{commentID}", method = RequestMethod.GET)
	public String getupdateComment(@PathVariable("commentID")Integer commentID,Model model) {
		CommentBean cb = service.getTheCommentBean(commentID);
		model.addAttribute("CommentBean", cb);
		return "t/updatecomment";
	}
	
	//修改該留言內容
	@RequestMapping(value = "/update/comment/{commentID}", method = RequestMethod.POST)
	public String proccessupdateComment(@PathVariable("commentID")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);   //抓路徑ID塞進cb
		service.updateComment(cb);
		model.addAttribute("Comment",service.getTheCommentBean(commentID));
		return "t/onecomment";
	}
	
	//列出所有被檢舉的Comment
//	@RequestMapping("/findAllReportComment")
//	public String findAllReportComment(Model model) {
//		List<CommentBean> list=service.findAllReportComment();
//		model.addAttribute("ReportComments", list);
//		return "t/reportedcomment";
//	}
	
	//列出所有被檢舉的Comment
	@RequestMapping("/findAllReportComment")
	public String findAllReportComment(Model model) {
		List<CommentBean> list=service.findAllReportComment();
		model.addAttribute("ReportComments", list);
		return "t/thereported";
	}
	
	@RequestMapping(value = "/reportedAjax" ,produces="application/json;charset=UTF-8;")
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
			MovieMap.put(mb.getMovieID(),mb.getTitle());
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
}
