package com.briup.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Cst_customer;
import com.briup.bean.Salchance;
import com.briup.bean.Salplan;
import com.briup.dao.SalDao;
import com.briup.service.SalchanceService;
import com.briup.util.PageUtil;

@Service("salchanceService")
public class SalchanceServiceImpl implements SalchanceService {

	@Autowired
	private SalDao salDao;
	
	@Override
	public List<Salchance> findAllChance() throws Exception {
		// TODO Auto-generated method stub
		List<Salchance> list = salDao.findAllChance();
		return list;
	}

	@Override
	public void saveChanceService(Salchance sc) throws Exception {

		salDao.saveChance(sc);
	}
	
	@Override
	public void updateChanceService2(Salchance sc) throws Exception {

		salDao.updatechance2(sc);
	}
	
	@Override
	public void deleteSalchance(Serializable chc_id) throws Exception {

		salDao.deleteSalchance(chc_id);
	}
	
	@Override
	public List<Salchance> findAllChanceByDueName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Salchance> list = salDao.findAllChanceByDueName(name);
		return list;
	}

	@Override
	public void savePlanService(Salplan sp) throws Exception {

		salDao.savePlan(sp);
	}

	@Override
	public void updateChanceByStatus(int pla_chc_id,int chc_status) throws Exception {
		// TODO Auto-generated method stub
		salDao.updatechance3(pla_chc_id,chc_status);
	}

	@Override
	public void saveCustomerService(Cst_customer cc) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAllRows() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllRowss() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageUtil<Salchance> findSalchanceByPageService(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salplan> findAllSalPlan() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salplan> findSalPlans(Serializable chc_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<Salplan> findSalplanByPageService(int curpage, int row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateChanceService(Serializable chc_id, Salchance sc) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Salchance findOneSalchance(Serializable chc_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salplan findSalplan(Serializable chc_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSalplanService(Serializable pla_id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalplanService(Salplan sp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalplanService(Serializable pla_chc_id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageUtil<Salchance> findSalPageByCon(int curpage, int row, Salchance sc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSalplanService2(Salplan sp) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
