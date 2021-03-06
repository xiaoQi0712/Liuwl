package com.briup.order.sms.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DishesExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public DishesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDishesIdIsNull() {
            addCriterion("dishes_id is null");
            return (Criteria) this;
        }

        public Criteria andDishesIdIsNotNull() {
            addCriterion("dishes_id is not null");
            return (Criteria) this;
        }

        public Criteria andDishesIdEqualTo(Integer value) {
            addCriterion("dishes_id =", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotEqualTo(Integer value) {
            addCriterion("dishes_id <>", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdGreaterThan(Integer value) {
            addCriterion("dishes_id >", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dishes_id >=", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdLessThan(Integer value) {
            addCriterion("dishes_id <", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdLessThanOrEqualTo(Integer value) {
            addCriterion("dishes_id <=", value, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdIn(List<Integer> values) {
            addCriterion("dishes_id in", values, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotIn(List<Integer> values) {
            addCriterion("dishes_id not in", values, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdBetween(Integer value1, Integer value2) {
            addCriterion("dishes_id between", value1, value2, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dishes_id not between", value1, value2, "dishesId");
            return (Criteria) this;
        }

        public Criteria andDishesNameIsNull() {
            addCriterion("dishes_name is null");
            return (Criteria) this;
        }

        public Criteria andDishesNameIsNotNull() {
            addCriterion("dishes_name is not null");
            return (Criteria) this;
        }

        public Criteria andDishesNameEqualTo(String value) {
            addCriterion("dishes_name =", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotEqualTo(String value) {
            addCriterion("dishes_name <>", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameGreaterThan(String value) {
            addCriterion("dishes_name >", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameGreaterThanOrEqualTo(String value) {
            addCriterion("dishes_name >=", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLessThan(String value) {
            addCriterion("dishes_name <", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLessThanOrEqualTo(String value) {
            addCriterion("dishes_name <=", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameLike(String value) {
            addCriterion("dishes_name like", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotLike(String value) {
            addCriterion("dishes_name not like", value, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameIn(List<String> values) {
            addCriterion("dishes_name in", values, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotIn(List<String> values) {
            addCriterion("dishes_name not in", values, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameBetween(String value1, String value2) {
            addCriterion("dishes_name between", value1, value2, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesNameNotBetween(String value1, String value2) {
            addCriterion("dishes_name not between", value1, value2, "dishesName");
            return (Criteria) this;
        }

        public Criteria andDishesReferralIsNull() {
            addCriterion("dishes_referral is null");
            return (Criteria) this;
        }

        public Criteria andDishesReferralIsNotNull() {
            addCriterion("dishes_referral is not null");
            return (Criteria) this;
        }

        public Criteria andDishesReferralEqualTo(String value) {
            addCriterion("dishes_referral =", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralNotEqualTo(String value) {
            addCriterion("dishes_referral <>", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralGreaterThan(String value) {
            addCriterion("dishes_referral >", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralGreaterThanOrEqualTo(String value) {
            addCriterion("dishes_referral >=", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralLessThan(String value) {
            addCriterion("dishes_referral <", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralLessThanOrEqualTo(String value) {
            addCriterion("dishes_referral <=", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralLike(String value) {
            addCriterion("dishes_referral like", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralNotLike(String value) {
            addCriterion("dishes_referral not like", value, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralIn(List<String> values) {
            addCriterion("dishes_referral in", values, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralNotIn(List<String> values) {
            addCriterion("dishes_referral not in", values, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralBetween(String value1, String value2) {
            addCriterion("dishes_referral between", value1, value2, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesReferralNotBetween(String value1, String value2) {
            addCriterion("dishes_referral not between", value1, value2, "dishesReferral");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIsNull() {
            addCriterion("dishes_price is null");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIsNotNull() {
            addCriterion("dishes_price is not null");
            return (Criteria) this;
        }

        public Criteria andDishesPriceEqualTo(BigDecimal value) {
            addCriterion("dishes_price =", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotEqualTo(BigDecimal value) {
            addCriterion("dishes_price <>", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceGreaterThan(BigDecimal value) {
            addCriterion("dishes_price >", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dishes_price >=", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceLessThan(BigDecimal value) {
            addCriterion("dishes_price <", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dishes_price <=", value, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceIn(List<BigDecimal> values) {
            addCriterion("dishes_price in", values, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotIn(List<BigDecimal> values) {
            addCriterion("dishes_price not in", values, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dishes_price between", value1, value2, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dishes_price not between", value1, value2, "dishesPrice");
            return (Criteria) this;
        }

        public Criteria andDishesImageIsNull() {
            addCriterion("dishes_image is null");
            return (Criteria) this;
        }

        public Criteria andDishesImageIsNotNull() {
            addCriterion("dishes_image is not null");
            return (Criteria) this;
        }

        public Criteria andDishesImageEqualTo(String value) {
            addCriterion("dishes_image =", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageNotEqualTo(String value) {
            addCriterion("dishes_image <>", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageGreaterThan(String value) {
            addCriterion("dishes_image >", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageGreaterThanOrEqualTo(String value) {
            addCriterion("dishes_image >=", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageLessThan(String value) {
            addCriterion("dishes_image <", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageLessThanOrEqualTo(String value) {
            addCriterion("dishes_image <=", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageLike(String value) {
            addCriterion("dishes_image like", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageNotLike(String value) {
            addCriterion("dishes_image not like", value, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageIn(List<String> values) {
            addCriterion("dishes_image in", values, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageNotIn(List<String> values) {
            addCriterion("dishes_image not in", values, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageBetween(String value1, String value2) {
            addCriterion("dishes_image between", value1, value2, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesImageNotBetween(String value1, String value2) {
            addCriterion("dishes_image not between", value1, value2, "dishesImage");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdIsNull() {
            addCriterion("dishes_classify_id is null");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdIsNotNull() {
            addCriterion("dishes_classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdEqualTo(Integer value) {
            addCriterion("dishes_classify_id =", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdNotEqualTo(Integer value) {
            addCriterion("dishes_classify_id <>", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdGreaterThan(Integer value) {
            addCriterion("dishes_classify_id >", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dishes_classify_id >=", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdLessThan(Integer value) {
            addCriterion("dishes_classify_id <", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("dishes_classify_id <=", value, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdIn(List<Integer> values) {
            addCriterion("dishes_classify_id in", values, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdNotIn(List<Integer> values) {
            addCriterion("dishes_classify_id not in", values, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdBetween(Integer value1, Integer value2) {
            addCriterion("dishes_classify_id between", value1, value2, "dishesClassifyId");
            return (Criteria) this;
        }

        public Criteria andDishesClassifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dishes_classify_id not between", value1, value2, "dishesClassifyId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table btsf_dishes
     *
     * @mbg.generated do_not_delete_during_merge Wed May 15 19:04:08 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table btsf_dishes
     *
     * @mbg.generated Wed May 15 19:04:08 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}