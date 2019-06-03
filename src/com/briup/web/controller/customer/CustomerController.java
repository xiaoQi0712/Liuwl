package com.briup.web.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Cst_activity;
import com.briup.bean.Cst_customer;
import com.briup.bean.Cst_linkman;
import com.briup.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	 @Autowired
	 public CustomerService service;
	@RequestMapping("/findcustomer")
	public String find(HttpSession session) {
		try {
			// 查出所有客户信息
			 List<Cst_customer> list = service.findallCustomer();
			// System.out.println(list);
			// 将list放到session里面
			 session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Info_find";

	}
	@RequestMapping("/addcustomer")
	public String add(Cst_customer customer){
		try {
			service.saveCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
		
	}
	
	@RequestMapping("/updatecustomer")
	public String update(Cst_customer customer){
		try {
			service.updateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
		
	}
	@RequestMapping("/deletecustomer")
	public String delete(Cst_customer customer){
		try {
			service.deleteCustomerById(customer.getCust_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/findcustomer";
		
	}
	@RequestMapping("/findlinkman")
	public String findLinkman(Cst_customer customer,HttpSession session){
		List<Cst_linkman> list = null;
		try {
			list=service.findAllLinkman(customer.getCust_id());
			session.setAttribute("list", list);
			session.setAttribute("cust_id", customer.getCust_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Info_pencil";
	}
	
	@RequestMapping("/addlinkman")
	public String addLinkman(Cst_linkman linkman){
		try {
			service.saveLinkMan(linkman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/updatelinkman")
	public String updateLinkman(Cst_linkman linkman){
		try {
			service.updateLinkman(linkman);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/deletelinkman")
	public String deleteLinkman(Cst_linkman linkman){
		try {
			service.deleteLinkMan(linkman);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/findlinkman";	
	}
	
	@RequestMapping("/findacv")
	public String findAllAcv( Integer cust_id,HttpSession session){
		List<Cst_activity> list = null;
		try {
			list=service.findAllAcv(cust_id);
			session.setAttribute("list", list);
			session.setAttribute("cust_id", cust_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/Info_book";
	}
	
	@RequestMapping("/addacv")
	public String addAcv(Cst_activity activity,HttpSession session){
		try {
			Integer cust_id = (Integer) session.getAttribute("cust_id");
			activity.setAtv_cust_id(cust_id);
			service.saveCst_activity(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/updateacv")
	public String updateAcv(Cst_activity activity){
		try {
			service.updateAtv(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/deleteacv")
	public String deleteAcv(Cst_activity activity){
		try {
			service.deleteAtv(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/findacv";	
	}

}
