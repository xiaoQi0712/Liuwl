package com.briup.order.sms.service.Impl;

import com.briup.order.sms.bean.Classify;
import com.briup.order.sms.bean.ClassifyExample;
import com.briup.order.sms.mapper.ClassifyMapper;
import com.briup.order.sms.service.IClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassifyServiceImpl implements IClassifyService {
    @Resource
    private ClassifyMapper classifyMapper;

    @Override
    public List<Classify> findClassifyName() {
        ClassifyExample example = new ClassifyExample();
        return classifyMapper.selectByExample(example);
    }

    @Override
    public void Add(Classify classify) {
        if (classify.getClassifyId() == null){
            classifyMapper.insert(classify);
        }else {
            classifyMapper.updateByPrimaryKey(classify);
        }
    }
}
