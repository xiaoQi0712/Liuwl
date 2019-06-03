package com.briup.order.sms.mapper;

import com.briup.order.sms.bean.Classify;
import com.briup.order.sms.bean.ClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassifyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    long countByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int deleteByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int deleteByPrimaryKey(Integer classifyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int insert(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int insertSelective(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    List<Classify> selectByExample(ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    Classify selectByPrimaryKey(Integer classifyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int updateByPrimaryKeySelective(Classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_classify
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    int updateByPrimaryKey(Classify record);
}