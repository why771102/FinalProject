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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.model.CommentBean;
import com.t.service.CommentService;

@Controller
public class CommentController {

	CommentService service;
	ServletContext context;
	
	@Autowired
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
	
	//列出所有Comment
	@RequestMapping("/findAllComment")
	public String findAllComment(Model model) {
		List<CommentBean> list=service.findAllComment();
		model.addAttribute("Comments", list);
		return "t/comments";
	}
	
	//查詢並列出電影ID們
	@RequestMapping("/getMovieID")
	public String seleteMovieID(Model model) {
		List<String> list=service.getMovies();
		model.addAttribute("movieIDList", list);
		return "t/selectmovieID";
	}
	
	//用movieID查詢comment
	@RequestMapping("/comments/{movieID}")
	public String getCommentByMovie(@PathVariable("movieID")Integer movieID,Model model) {
		List<CommentBean> comments=service.getCommentByMovie(movieID);
		model.addAttribute("Comments", comments);
		return "t/comments";
	}
	
	@RequestMapping(value = "/comments/add", method = RequestMethod.GET)
	public String getAddNewComment(Model model) {
		CommentBean cb = new CommentBean();
		model.addAttribute("commentBean",cb);
		return "t/addcomment";		
	}
	
	@RequestMapping(value = "/comments/add", method = RequestMethod.POST)
	public String processAddNewComment(CommentBean cb,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		cb.setMemberID(nMID);
		//預設刪除檢舉為0
		if(cb.getCommentDelete() == null || cb.getReportComment() == null) {
			cb.setCommentDelete(0);
			cb.setReportComment(0);
		}
		service.addComment(cb);
		return "redirect:/findAllComment";	
	}
	
	@RequestMapping("/comments/delete/{commentID}")
	public String getDeleteComment(@PathVariable("commentID")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);
		service.deleteComment(commentID);
		return "redirect:/findAllComment";		
	}
	
	@RequestMapping("/comments/report")
	public String reportComment(@RequestParam("id")Integer commentID,@ModelAttribute("CommentBean") CommentBean cb,Model model) {
		cb.setCommentID(commentID);
		service.reportComment(commentID);
		return "redirect:/findAllComment";
	}
	
	//查詢單筆
	@RequestMapping("/onecomment")
	public String getOneCommentBean(@RequestParam("id")Integer commentID,Model model) {
		model.addAttribute("Comment",service.getTheCommentBean(commentID));
		return "t/onecomment";
	}
	
	//抓出所有commentBean裡的東西
	@RequestMapping(value = "/update/comment")
	public String getupdateProducts(Model model) {
		List<CommentBean> list=service.findAllComment();
		model.addAttribute("comment", list);
		return "t/onecomment";
	}
	
	//用對應的commentID找出該comment的資料
	@RequestMapping(value = "/update/comment/{commentID}", method = RequestMethod.GET)
	public String getupdateComment(@PathVariable("commentID")Integer commentID,Model model) {
		CommentBean pb = service.getTheCommentBean(commentID);
		model.addAttribute("CommentBean", pb);
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
	@RequestMapping("/findAllReportComment")
	public String findAllReportComment(Model model) {
		List<CommentBean> list=service.findAllReportComment();
		model.addAttribute("ReportComments", list);
		return "t/reportedcomment";
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
