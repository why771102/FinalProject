package com.z.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.model.EmpStatusBean;
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
	
	@RequestMapping(value = "/bgAnnos")
	public String getAllAnnos(Model model) {
		List<AnnoBean> allAnnos = service.showAnno();
		model.addAttribute("allAnnos", allAnnos);
		return "z/bgAnnos";
	}
	
	//以下三個為新增公告方法
	@RequestMapping(value = "/anno/add", method = RequestMethod.GET)
	public String addNewAnno(Model model) {
		AnnoBean ab = new AnnoBean();
		model.addAttribute("annoBean", ab);
		return "z/addAnno";
	}
	
	@RequestMapping(value = "/anno/add", method = RequestMethod.POST)
	public String processAddNewEmp(@ModelAttribute("annoBean") AnnoBean ab) {
		
//		String[] suppressedFields = result.getSuppressedFields();
//		, BindingResult result
//		if(suppressedFields.length > 0) {
//			throw new RuntimeException("傳入不允許的欄位");
//		} 
 		service.addNewAnno(ab);
		return "redirect:/annos";
	}
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
	
	//----------------------------------
	@RequestMapping(value = "/anno/update/{annoId}", method = RequestMethod.GET)
	public String updateAnno(Model model, @PathVariable("annoId") Integer annoId) {
		AnnoBean ab = service.showOneAnno(annoId);
		model.addAttribute("annoBean", ab);
		return "z/editAnno";
	}
	
	
	@RequestMapping(value = "/anno/update/{annoId}", method = RequestMethod.POST)
	public String processUdateAnno(@ModelAttribute("annoBean") AnnoBean ab) {
		service.addNewAnno(ab);
		return "redirect:/bgAnnos";
	}

	
	@ModelAttribute("annoStatusList")
	public Map<Integer, String> getannoStatusList() {
		Map<Integer, String> annoStatusMap = new HashMap<>();
		List<AnnoStatusBean> list = service.getAnnoStatusList();
		for (AnnoStatusBean rb : list) {
			annoStatusMap.put(rb.getStatus(), rb.getStatusName());
		}
		return annoStatusMap;
	}
	
	//前台顯示公告用(依照優先度排序)
	@RequestMapping(value = "/annos")
	public String showAnnos(Model model) {
		List<AnnoBean> allAnnos = service.showAnnoToMember();
		model.addAttribute("allAnnos", allAnnos);
		return "z/annos";
	}
	
	@RequestMapping(value = "/anno/launch/{annoId}")
	public String launchAnno(Model model, @PathVariable("annoId") Integer annoId) {
		service.launchAnno(annoId);
		return "redirect:/bgAnnos";
	}

	@RequestMapping(value = "/anno/takeoff/{annoId}")
	public String tackOffAnno(Model model, @PathVariable("annoId") Integer annoId) {
		service.takeOff(annoId);
		return "redirect:/bgAnnos";
	}

}
