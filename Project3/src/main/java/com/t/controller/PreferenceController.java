package com.t.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.t.model.CommentBean;
import com.t.model.PreferenceBean;
import com.t.service.PreferenceService;

@Controller
public class PreferenceController {

	PreferenceService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(PreferenceService service) {
		this.service = service;
	}
	
	//新增欄位 填入讚 噓 屏蔽
	@RequestMapping(value = "/preference/addlike")
	public String processAddLike(@RequestParam("id")Integer commentID,PreferenceBean pb,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int memberID = Integer.parseInt(mID);
		boolean le = service.checkLikeExist(memberID, commentID);
		if(le == true){
			
		}
		if(le == false) {
			pb.setCommentID(commentID);
			pb.setMemberID(memberID);
			pb.setGood(1);
			pb.setBad(0);
			pb.setBlock(0);
			service.addLike(pb);
		}
		return "redirect:/findAllComment";	
	}
	
	@RequestMapping(value = "/preference/addbad")
	public String processAddBad(@RequestParam("id")Integer commentID,PreferenceBean pb,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		pb.setCommentID(commentID);
		pb.setMemberID(nMID);
		pb.setGood(0);
		pb.setBad(1);
		pb.setBlock(0);
		service.addLike(pb);
		return "redirect:/findAllComment";	
	}
	
	@RequestMapping(value = "/preference/addblock")
	public String processAddBlock(@RequestParam("id")Integer commentID,PreferenceBean pb,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		pb.setCommentID(commentID);
		pb.setMemberID(nMID);
		pb.setGood(0);
		pb.setBad(0);
		pb.setBlock(1);
		service.addLike(pb);				
		return "redirect:/findAllComment";	
	}
}
