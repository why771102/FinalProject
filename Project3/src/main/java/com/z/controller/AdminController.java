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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.z.exception.EmpNotFoundException;
import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.RoleBean;
import com.z.service.EmpService;

@Controller
public class AdminController {
	
	EmpService service;
	ServletContext context;
	
//	@Autowired
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
	public String addNewEmp(@ModelAttribute("empBean") EmpBean eb) {
		eb.setPassword(eb.getUid());
 		service.saveEmp(eb);
		return "redirect:/emps";
	}
	
	@RequestMapping(value = "/emps")
	public String getAllEmps(Model model) {
		List<EmpBean> allEmps = service.findAllEmps();
		model.addAttribute("allEmps", allEmps);
		return "z/emps";
	}
	
	@RequestMapping(value = "/empsAjax" ,produces="application/json;charset=UTF-8;")
	public @ResponseBody String getAllEmpsAjax(Model model) {
		List<EmpBean> allEmps = service.findAllEmps();
		model.addAttribute("allEmps", allEmps);
		Gson gson = new Gson();
		String str = gson.toJson(allEmps);
		return str;
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
	
	
	@RequestMapping("resetPwd")
	public @ResponseBody String resetPwd(Integer empId) {
		System.out.println("resetPwd = " + empId);
		EmpBean eb = service.getEmp(empId);
		eb.setPassword(eb.getUid());
		eb.setRoleId(eb.getRoleBean().getRoleId());
		eb.setStatus(eb.getEmpStatusBean().getStatus());
		service.saveEmp(eb);
		Gson gson = new Gson();
		return gson.toJson(eb);
		
	}

}
