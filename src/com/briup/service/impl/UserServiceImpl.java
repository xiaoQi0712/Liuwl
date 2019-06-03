package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Sys_role;
import com.briup.bean.Sys_user;
import com.briup.dao.UserDao;
import com.briup.service.UserService;
import com.briup.util.PageUtil;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserDao userdao;
	@Override
	public Sys_user findlogin(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Sys_user user = userdao.login(username, password);
		return user;
	}

	@Override
	public List<Sys_user> findAllMgr() throws Exception {
		List<Sys_user> list = userdao.getAllMgr();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Sys_role> findAllRole() throws Exception {
		List<Sys_role> list = userdao.getAllRole();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Sys_role findOneRole(int role_id) throws Exception {
		Sys_role role = userdao.getOneRole(role_id);
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public void updateRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		userdao.updateRole(role);
		
	}

	@Override
	public PageUtil<Sys_user> findAllUser(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllRows() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sys_user findOneUser(int usr_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(Sys_user user) throws Exception {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
		
	}

	@Override
	public void addUser(Sys_user user) throws Exception {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}

	@Override
	public void deleteUser(int usr_id) throws Exception {
		// TODO Auto-generated method stub
		userdao.deleteUser(usr_id);
		
	}

	@Override
	public void addRole(Sys_role role) throws Exception {
		// TODO Auto-generated method stub
		userdao.addRole(role);
	}

	@Override
	public void deleteRole(int role_id) throws Exception {
		// TODO Auto-generated method stub
		userdao.deleteRole(role_id);
		
	}

}
