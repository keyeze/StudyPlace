package com.chan.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {

    public interface OrderBuilder {
        public Order build();
    }

    private Order() {
    }


    private Long id;

    private String orderInfoNumber; // 订单号

    private User user; // 会员

    private Date createTime; // 创建时间，注册时间

    private BigDecimal totalMoney; // 总金额

    private BigDecimal ACost; // A类货币费用

    private BigDecimal BCost; // A类货币费用

    private BigDecimal CCost; // A类货币费用

    private Date payTime; // 付款时间

    private String payWay; // 支付方式 ‘0’=余额支付；‘1’=微信支付，2支付宝 3银联支付 4现金支付 5兑换券 6F币支付(仅适用于礼品类)

    private Integer payStatus; // 付款状态（未付款、已付款） ‘0’=未付款；‘1’=已付款 2 =退款

    /**
     * 详细请见 {@link com.chan.common.CommonUtil.ORDER_TYPE}
     */
    private String orderType;// 订单类型 ‘1’=商品；‘2’=礼品；‘3’=门票 4="预售票"  5="卖品"

    private List<OrderDetail> orderDetails;

    /**
     * {@link com.chan.common.CommonUtil.STATUS}
     */
    private Integer orderStatus;

    private Integer status; // 状态（0已删除、1未删除）

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrderInfoNumber() {
        return orderInfoNumber;
    }

    public Order setOrderInfoNumber(String orderInfoNumber) {
        this.orderInfoNumber = orderInfoNumber;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Order setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public Order setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
        return this;
    }

    public BigDecimal getACost() {
        return ACost;
    }

    public Order setACost(BigDecimal ACost) {
        this.ACost = ACost;
        return this;
    }

    public BigDecimal getBCost() {
        return BCost;
    }

    public Order setBCost(BigDecimal BCost) {
        this.BCost = BCost;
        return this;
    }

    public BigDecimal getCCost() {
        return CCost;
    }

    public Order setCCost(BigDecimal CCost) {
        this.CCost = CCost;
        return this;
    }

    public Date getPayTime() {
        return payTime;
    }

    public Order setPayTime(Date payTime) {
        this.payTime = payTime;
        return this;
    }

    public String getPayWay() {
        return payWay;
    }

    public Order setPayWay(String payWay) {
        this.payWay = payWay;
        return this;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public Order setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public Order setOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Order setStatus(Integer status) {
        this.status = status;
        return this;
    }
}