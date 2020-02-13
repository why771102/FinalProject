package com.t.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.t.model.CommentBean;
import com.t.model.PreferenceBean;
import com.t.service.PreferenceService;

@Controller
public class PreferenceController {

	PreferenceService service;
	ServletContext context;

//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(PreferenceService service) {
		this.service = service;
	}

	// 新增欄位 填入讚 噓 屏蔽
	@RequestMapping("/preference/addlike/{runID}")
	public String processAddLike(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			PreferenceBean pb, HttpServletRequest request, Model model) {
//		System.out.println("runID1 = " + runID);
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		pb.setCommentID(commentID);
		pb.setMemberID(memberID);
		// 檢查是否有在該留言建立過喜好欄位
		boolean le = service.checkLikeExist(memberID, commentID);
		if (le == true) {
			// 檢查good是否為1
			boolean lt = service.checkLikeTrue(memberID, commentID);
			if (lt == true) {
				service.cancel(memberID, commentID);
			}
			if (lt == false) {
				service.addGood(memberID, commentID);
			}
		}
		if (le == false) {
			pb.setGood(1);
			pb.setBad(0);
			pb.setBlock(0);
			service.addLike(pb);
		}
//		System.out.println("runID2 = " + runID);
		return "redirect:/show/this/movie?runID=" + runID;
	}

	@RequestMapping("/preference/addbad/{runID}")
	public String processAddBad(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			PreferenceBean pb, HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		pb.setCommentID(commentID);
		pb.setMemberID(memberID);
		// 檢查是否有在該留言建立過喜好欄位
		boolean le = service.checkLikeExist(memberID, commentID);
		if (le == true) {
			// 檢查bad是否為1
			boolean dt = service.checkDislikeTrue(memberID, commentID);
			if (dt == true) {
				service.cancel(memberID, commentID);
			}
			if (dt == false) {
				service.addBad(memberID, commentID);
			}
		}
		if (le == false) {
			pb.setGood(0);
			pb.setBad(1);
			pb.setBlock(0);
			service.addLike(pb);
		}
		return "redirect:/show/this/movie?runID=" + runID;
	}

	@RequestMapping("/preference/addblock/{runID}")
	public String processAddBlock(@PathVariable("runID") String runID, @RequestParam("id") Integer commentID,
			PreferenceBean pb, HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		pb.setCommentID(commentID);
		pb.setMemberID(memberID);
		boolean le = service.checkLikeExist(memberID, commentID);
		if (le == true) {
			service.fixBlock(memberID, commentID);
		}
		if (le == false) {
			pb.setGood(0);
			pb.setBad(0);
			pb.setBlock(1);
			service.addLike(pb);
		}
		return "redirect:/show/this/movie?runID=" + runID;
	}

	// 第一次按讚
//	@ResponseBody
//	@RequestMapping("/addcommentlike")
//	public String addLike(Integer commentID, Integer memberID) {
//		PreferenceBean pb = new PreferenceBean();
//		pb.setCommentID(commentID);
//		pb.setMemberID(memberID);
//		pb.setGood(1);
//		pb.setBad(0);
//		pb.setBlock(0);
//		System.out.println("目標commentID" + commentID);
//		System.out.println("目標memberID" + memberID);
//		service.addLike(pb);
//		return "success";
//	}
//
//	// 第一次按噓
//	@ResponseBody
//	@RequestMapping("/addcommentbad")
//	public String addBad(Integer commentID, Integer memberID) {
//		PreferenceBean pb = new PreferenceBean();
//		pb.setCommentID(commentID);
//		pb.setMemberID(memberID);
//		pb.setGood(0);
//		pb.setBad(1);
//		pb.setBlock(0);
//		System.out.println("目標commentID" + commentID);
//		System.out.println("目標memberID" + memberID);
//		service.addLike(pb);
//		return "success";
//	}
//
//	// 按讚
//	@ResponseBody
//	@RequestMapping("/addcommentblock")
//	public String addBlock(Integer commentID, Integer memberID) {
//		PreferenceBean pb = new PreferenceBean();
//		pb.setCommentID(commentID);
//		pb.setMemberID(memberID);
//		System.out.println("目標commentID" + commentID);
//		System.out.println("目標memberID" + memberID);
//		boolean le = service.checkLikeExist(memberID, commentID);
//		if (le == true) {
//			service.fixBlock(memberID, commentID);
//		}
//		if (le == false) {
//			pb.setGood(0);
//			pb.setBad(0);
//			pb.setBlock(1);
//			service.addLike(pb);
//		}
//		return "success";
//	}

}
