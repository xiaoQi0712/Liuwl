package com.briup.apps.tb_app01.service;

import com.briup.apps.tb_app01.bean.User;

import java.util.List;

public interface IUserService {


    List<User> query(User user);


    /**
     * @Description: 通过类型查找用户
     * @Param: [type]
     * @return: java.util.List<com.briup.apps.tb_app01.bean.User>
     * @Author: charles
     * @Date: 2019-05-05
     */
    List<User> findByType(String type);

    /**
     * @Description: 保存或更新用户信息
     * @Param: [user]
     * @return: void
     * @Author: charles
     * @Date: 2019-05-05
     */
    void saveOrUpdate(User user);

    /**
     * @Description: 通过id查找
     * @Param: [id]
     * @return: com.briup.apps.tb_app01.bean.User
     * @Author: charles
     * @Date: 2019-05-05
     */
    User findById(long id);

    /**
     * @Description: 通过id删除
     * @Param: [id]
     * @return: void
     * @Author: charles
     * @Date: 2019-05-05
     */
    void deleteById(long id);

    /**
     * @Description: 批量删除
     * @Param: [ids]
     * @return: void
     * @Author: charles
     * @Date: 2019-05-05
     */
    void batchDelete(long[] ids);

}
