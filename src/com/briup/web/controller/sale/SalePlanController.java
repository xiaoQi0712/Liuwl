package com.briup.web.controller.sale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.Salchance;
import com.briup.bean.Salplan;
import com.briup.bean.Sys_user;
import com.briup.service.SalchanceService;
import com.briup.util.PageUtil;

@Controller
@RequestMapping("/plan")
public class SalePlanController {

	@Autowired
	private SalchanceService salchanceService;


	@RequestMapping("/findAllChanceByDueName")
	public String findAllChanceByDueName(HttpSession session) {
		try {
			Sys_user user = (Sys_user) session.getAttribute("user");
			
			List<Salchance> chances2 = salchanceService.findAllChanceByDueName(user.getUsr_name());
			session.setAttribute("chances2", chances2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pages/Sale_kaifa";
	}
	
	@RequestMapping("/savePlan")
	public String savePlan(Salplan plan) {
		try {
			int chc_status;
			if(plan.getPla_result()==null){
				plan.setPla_result("开始开发");
				chc_status = 2;
			}else{
				chc_status = 3;
			}
			salchanceService.savePlanService(plan);
			salchanceService.updateChanceByStatus(plan.getPla_chc_id(),chc_status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	

}
