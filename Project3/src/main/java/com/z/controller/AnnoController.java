package com.z.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.service.AnnoService;

@Controller
public class AnnoController {
	
	AnnoService service;
	ServletContext context;
	
//	@Autowired
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
		
		System.out.println("新建立的時間 ab.getStartTime() :  " + ab.getStartTime());
		LocalDateTime tranST = LocalDateTime.parse(ab.getStartTime().replace("T", " "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		String nst =tranST.format(DateTimeFormatter.ofPattern("yyyy-MM-DD HH:MM:SS"));
		
		ab.setStartTime(nst);
		
		LocalDateTime tranET = LocalDateTime.parse(ab.getEndTime().replace("T", " "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		String net =tranET.format(DateTimeFormatter.ofPattern("yyyy-MM-DD HH:MM:SS"));
		
		ab.setEndTime(net);
		
		System.out.println("轉換後的時間  nst : " + nst);
		System.out.println("轉換後的時間  net : " + net);		
//		String[] suppressedFields = result.getSuppressedFields();
//		, BindingResult result
//		if(suppressedFields.length > 0) {
//			throw new RuntimeException("傳入不允許的欄位");
//		} 
 		service.addNewAnno(ab);
		return "redirect:/bgAnnos";
	}
	
	
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("empName", "roleId", "email", "password", "status", "startDate" ,"endDate");
//	}
	
	//----------------------------------
	@RequestMapping(value = "/anno/update/{annoId}", method = RequestMethod.GET)
	public String updateAnno(Model model, @PathVariable("annoId") Integer annoId) {
		AnnoBean ab = service.showOneAnno(annoId);
		ab.setStartTime(ab.getStartTime().replace(" ", "T").replace(":00.0", ""));
		ab.setEndTime(ab.getEndTime().replace(" ", "T").replace(":00.0", ""));
		System.out.println("從DB抓出來的時間 ab.getStartTime() : " + ab.getStartTime());
		model.addAttribute("annoBean", ab);
		return "z/editAnno";
	}
	
	
	@RequestMapping(value = "/anno/update/{annoId}", method = RequestMethod.POST)
	public String processUdateAnno(@ModelAttribute("annoBean") AnnoBean ab) {
		System.out.println("修改之後的時間(轉換前) ab.getStartTime() :  " + ab.getStartTime());
		System.out.println("修改後但沒動的時間(轉換前) ab.getEndStartTime() :  " + ab.getEndTime());
		LocalDateTime tranST = LocalDateTime.parse(ab.getStartTime().replace("T", " "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		String nst =tranST.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS"));
		System.out.println("nst : " + nst);
		
		ab.setStartTime(nst);
		
		LocalDateTime tranET = LocalDateTime.parse(ab.getEndTime().replace("T", " "), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.println("ab.getEndTime().replace : " + ab.getEndTime().replace("T", " "));	
		String net =tranET.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS"));
		System.out.println("net : " + net);	
		ab.setEndTime(net);
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// java.util.Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		dateFormat.setLenient(false);    //規則是否寬鬆。如13月
		CustomDateEditor ce = new CustomDateEditor(dateFormat, true); 		//空白日期是否合法
		binder.registerCustomEditor(Date.class, ce);
		// java.sql.Date		
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat2.setLenient(false);
		CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true); 
		binder.registerCustomEditor(java.sql.Date.class, ce2);
	}

}
