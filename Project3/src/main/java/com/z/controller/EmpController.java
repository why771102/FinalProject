package com.z.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z.model.EmpBean;
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
		return "addEmp";
	}
	
	@RequestMapping(value = "/emp/add", method = RequestMethod.POST)
	public String processAddNewEmp(@ModelAttribute("empBean") EmpBean eb) {
		
//		String[] suppressedFields = result.getSuppressedFields();
//		, BindingResult result
//		if(suppressedFields.length > 0) {
//			throw new RuntimeException("傳入不允許的欄位");
//		} 
 		service.saveEmp(eb);
		return "addEmp";
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
		return "emps";
	}
	
	
	@RequestMapping(value = "/emp")
	public String getEmp(@RequestParam("empId") Integer empId, Model model) {
		EmpBean eb = service.getEmp(empId);
		model.addAttribute("emp", eb);
		return "emp";
	}
	
	@RequestMapping(value = "searchEmp")
	public String searchEmp(Model model) {
		return "searchEmp";
	}
	
	

}
