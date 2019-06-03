package com.briup.apps.tb_app01.service.impl;

import com.briup.apps.tb_app01.bean.User;
import com.briup.apps.tb_app01.bean.UserExample;
import com.briup.apps.tb_app01.mapper.UserMapper;
import com.briup.apps.tb_app01.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tb_app01
 * @description: 用户接口实现类
 * @author: charles
 * @create: 2019-05-05 09:19
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query(User user) {
        // 用户名 姓名 性别 类型
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.getRealname()!=null){
            criteria.andRealnameLike("%"+user.getRealname()+"%");
        }
        if(user.getUsername()!=null){
            criteria.andUsernameLike("%"+user.getUsername()+"%");
        }
        if(user.getGender()!=null){
            criteria.andGenderEqualTo(user.getGender());
        }
        if(user.getType()!=null){
            criteria.andTypeEqualTo(user.getType());
        }
        return userMapper.selectByExample(example);
    }
    //通过类型查找
    @Override
    public List<User> findByType(String type) {

    UserExample example = new UserExample();
        example.createCriteria().andTypeEqualTo(type);
        return userMapper.selectByExample(example);
    }
    //保存或更新
    @Override
    public void saveOrUpdate(User user) {
        if(user.getId()!=null){
            User db_user = findById(user.getId());
            //将获取的值覆盖掉
            db_user.setUsername(user.getUsername());
            db_user.setRealname(user.getRealname());
            db_user.setGender(user.getGender());
            userMapper.updateByPrimaryKey(db_user);
        } else {
            userMapper.insert(user);
        }
    }
    //通过Id查找
    @Override
    public User findById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
    //通过Id删除
    @Override
    public void deleteById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }
    //批量删除
    @Override
    public void batchDelete(long[] ids) {
        for(long id : ids){
            userMapper.deleteByPrimaryKey(id);
        }
    }


}






