package com.briup.web.controller.sale;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.Salchance;
import com.briup.service.SalchanceService;
import com.briup.util.PageUtil;

@Controller
@RequestMapping("/sale")
public class SaleChanceController {

	@Autowired
	private SalchanceService salchanceService;

	@RequestMapping("/findAllChance")
	public String findAllChance(HttpSession session) {
		try {
			List<Salchance> chances = salchanceService.findAllChance();
			session.setAttribute("chances", chances);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pages/Sale_sale";
	}
	
	@RequestMapping("/addChance")
	public String addChance(Salchance sc) {
		try {
			salchanceService.saveChanceService(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	
	@RequestMapping("/updateChance")
	public String updateChance(Salchance sc) {
		try {
			salchanceService.updateChanceService2(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/deleteChance")
	public String deleteChance(@RequestParam("chc_id") int chc_id) {
		try {
			salchanceService.deleteSalchance(chc_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/sale/findAllChance";
	}


}
