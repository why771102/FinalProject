package com.p.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p.model.MemberBean;

//@WebFilter("/LoginFilter")// 要在WebAppInitializer中宣告此Filter
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "mustLogin1", value = "/member/query"), 
				@WebInitParam(name = "mustLogin2", value = "/hallOrder/apply"), 
				@WebInitParam(name = "mustLogin3", value = "/Member/hallOrderQuery"),
				@WebInitParam(name = "mustLogin4", value = "/getShoppingCart"),
				@WebInitParam(name = "mustLogin5", value = "/preference/addlike"),
				@WebInitParam(name = "mustLogin6", value = "/preference/addbad"),
				@WebInitParam(name = "mustLogin7", value = "/preference/addblock"),
				@WebInitParam(name = "mustLogin8", value = "/member/ticket"),
				@WebInitParam(name = "mustLogin9", value = "/questionList")
		})
public class LoginFilter implements Filter {
	List<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while (e.hasMoreElements()) {
			String path = e.nextElement();
			url.add(fConfig.getInitParameter(path));
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isRequestedSessionIdValid = false;
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			servletPath = req.getServletPath();
			contextPath = req.getContextPath();
			requestURI = req.getRequestURI();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();
//			System.out.println("看有沒有跑進來");
			if (mustLogin()) {
				if (checkLogin(req)) {
					// 需要登入，但已經登入
					chain.doFilter(request, response);
				} else {
					// 需要登入，尚未登入，所以送回登入畫面
					HttpSession session = req.getSession();

					if (!isRequestedSessionIdValid) {
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					} else {
						// 記住原本的"requestURI"，稍後如果登入成功，系統可以自動轉入
						// 原本要執行的程式。
						session.setAttribute("requestURI", requestURI);
					}
					resp.sendRedirect(contextPath + "/member/login");
					return;
				}
			} else { // 不需要登入，直接去執行他要執行的程式
				chain.doFilter(request, response);
			}
		} else {
			throw new ServletException("Request/Response 型態錯誤(極不可能發生)");
		}
	}

	// 判斷Session物件內是否含有識別字串為LoginOK的屬性物件，如果有，表示已經登入，否則尚未登入
	private boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		MemberBean loginToken = (MemberBean) session.getAttribute("LoginOK");
		
		Cookie[] cookies = req.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		if ((loginToken == null && mID == null) || cookies.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 如果請求的ServletPath的前導字是以某個必須登入才能使用之資源的路徑，那就必須登入。
	private boolean mustLogin() {
		boolean login = false;
		for (String sURL : url) {
			if (sURL.endsWith("*")) {
				sURL = sURL.substring(0, sURL.length() - 1); // 除去掉最後一個字元的剩餘字串
				if (servletPath.startsWith(sURL)) {
					login = true;
					break;
				}
			} else {
				if (servletPath.equals(sURL)) {
					login = true;
					break;
				}
			}
		}
		return login;
	}

	public LoginFilter() {

	}

	public void destroy() {

	}

}
