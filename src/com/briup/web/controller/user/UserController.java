package com.briup.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Cst_customer;
import com.briup.bean.Sys_role;
import com.briup.bean.Sys_user;
import com.briup.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// 自动注入service对象
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(String name, String password, HttpSession session) {
		Sys_user user = null;
		try {
			// 调用service层进行业务逻辑处理
			user = userService.findlogin(name, password);
			System.out.println(user);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			return "sign";

		} else{
			session.setAttribute("user", user);
			return "redirect:/index";
		}
	}
	
	
	@RequestMapping("/findallrole")
	public String findAllRole(HttpSession session) {
		try {
			// 查出所有客户信息
			 List<Sys_role> list = userService.findAllRole();
			// System.out.println(list);
			// 将list放到session里面
			 session.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/System_juese";
	}
	
	@RequestMapping("/addrole")
	public String addRole(Sys_role role) {
		try {
			userService.addRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/updaterole")
	public String updateRole(Sys_role role) {
		try {
			userService.updateRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping("/deleterole")
	public String deleteRole(Sys_role role) {
		try {
			userService.deleteRole(role.getRole_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/user/findallrole";
	}

	@RequestMapping("/findallmgr")
	public String findAllMgr(HttpSession session) {
		try {
			// 查出所有客户信息
			List<Sys_user> list = userService.findAllMgr();
			// System.out.println(list);
			// 将list放到session里面
			session.setAttribute("allmgr", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pages/System_yonghu";
	}
	
	@RequestMapping("/adduser")
	public String addUser(Sys_user user) {
		try {
			Sys_role findOneRole = userService.findOneRole(user.getUsr_role_id());
			user.setUsr_role_name(findOneRole.getRole_name());
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	@RequestMapping("/updateuser")
	public String updateUser(Sys_user user) {
		try {
			Sys_role findOneRole = userService.findOneRole(user.getUsr_role_id());
			user.setUsr_role_name(findOneRole.getRole_name());
			userService.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index";
	}
	@RequestMapping("/deleteuser")
	public String deleteUser(Sys_user user) {
		try {
			userService.deleteUser(user.getUsr_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/user/findallmgr";
	}
}
