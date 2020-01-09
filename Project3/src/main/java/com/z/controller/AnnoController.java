package com.z.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.z.exception.EmpNotFoundException;
import com.z.model.AnnoBean;
import com.z.model.EmpBean;
import com.z.model.RoleBean;
import com.z.service.AnnoService;

@Controller
public class AnnoController {
	
	AnnoService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(AnnoService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/annos")
	public String getAllAnnos(Model model) {
		List<AnnoBean> allAnnos = service.showAnno();
		model.addAttribute("allAnnos", allAnnos);
		return "annos";
	}
	
	//以下三個為新增公告方法
	@RequestMapping(value = "/anno/add", method = RequestMethod.GET)
	public String addNewAnno(Model model) {
		AnnoBean ab = new AnnoBean();
		model.addAttribute("annoBean", ab);
		return "addAnno";
	}
	
	@RequestMapping(value = "/anno/add", method = RequestMethod.POST)
	public String processAddNewEmp(@ModelAttribute("annoBean") AnnoBean ab) {
		
//		String[] suppressedFields = result.getSuppressedFields();
//		, BindingResult result
//		if(suppressedFields.length > 0) {
//			throw new RuntimeException("傳入不允許的欄位");
//		} 
 		service.addNewAnno(ab);
		return "addAnno";
	}
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
	
	//----------------------------------
	

	
	
	@RequestMapping(value = "/emp")
	public String getEmp(@RequestParam("empId") Integer empId, Model model) {
		EmpBean eb = service.getEmp(empId);
//		if(eb == null) {
//			model.addAttribute("emp", eb);   //如果無該員工ID，需要出現提示訊息
//		}
		model.addAttribute("emp", eb);
		return "emp";
	}
	
	@RequestMapping(value = "searchEmp")
	public String searchEmp(Model model) {
		return "searchEmp";
	}
	
	@ExceptionHandler({EmpNotFoundException.class})
	public String handler(HttpServletRequest request, EmpNotFoundException exception, Model model) {
		String message = "查無員工編號：";
		model.addAttribute("message",message);
		model.addAttribute("empId", exception.getEmpId());
		return "searchEmp";
	}
	
	@ModelAttribute("roleList")
	public Map<Integer, String> getCompanyList() {
		Map<Integer, String> roleMap = new HashMap<>();
		List<RoleBean> list = service.getRoleList();
		for (RoleBean rb : list) {
			roleMap.put(rb.getRoleId(), rb.getRoleName());
		}
		return roleMap;
	}
	

}
