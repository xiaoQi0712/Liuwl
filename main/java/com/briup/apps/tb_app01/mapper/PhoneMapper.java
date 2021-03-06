package com.briup.apps.tb_app01.mapper;

import com.briup.apps.tb_app01.bean.Phone;
import com.briup.apps.tb_app01.bean.PhoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    long countByExample(PhoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int deleteByExample(PhoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int insert(Phone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int insertSelective(Phone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    List<Phone> selectByExample(PhoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    Phone selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByExampleSelective(@Param("record") Phone record, @Param("example") PhoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByExample(@Param("record") Phone record, @Param("example") PhoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByPrimaryKeySelective(Phone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_phone
     *
     * @mbg.generated Tue Apr 30 15:14:24 CST 2019
     */
    int updateByPrimaryKey(Phone record);
}