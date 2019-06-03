package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.Phone;
import com.briup.apps.tb_app01.bean.PhoneExample;
import com.briup.apps.tb_app01.mapper.PhoneMapper;
import com.briup.apps.tb_app01.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tb_app01
 * @description:
 * @author: charles
 * @create: 2019-04-29 19:02
 **/
@Service
public class PhoneServiceImpl implements IPhoneService {
    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    public List<Phone> findAll() {
        PhoneExample example = new PhoneExample();
        return phoneMapper.selectByExample(example);
    }

    @Override
    public void saveOrUpdate(Phone phone) {
        if(phone.getId()!=null){

        } else {
            phone.setStatus("正常");
            phoneMapper.insert(phone);
        }
    }


    @Override
    public Phone findById(long id) {
        PhoneExample example = new PhoneExample();
        example.createCriteria().andIdEqualTo(id);
        List<Phone> list = phoneMapper.selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}

