package com.chan.service;

import com.chan.entity.Order;

public interface IOrderService {

    /**
     * 通过订单ID获取订单信息
     *
     * @param orderId 订单ID
     * @return
     */
    public Order redealPreOrder(Long orderId) throws Throwable;

    /**
     * 通过自定义订单生成器获得订单,并保存到数据库中
     *
     * @param orderBuilder 订单生成器
     * @return
     */


    public Order insertPreOrder(Order.OrderBuilder orderBuilder) throws RefuseException, Exception;

    /**
     * 通过订单,计算将扣除的用户货币保存在订单记录中.
     *
     * @param order 订单
     * @return
     */
    public void updateCostByOrder(Order order);

    /**
     * 通过订单,检查用户余额是否满足支付订单的条件.
     *
     * @param order
     * @return
     */
    public void checkMemberBalanceByOrder(Order order);

    /**
     * 通过订单,扣除非第三方支付扣款
     *
     * @param order 订单
     */
    public void updateMemberBalanceExceptOtherPayByOrder(Order order);

    /**
     * 通过订单,支付完成
     *
     * @param order 订单
     */
    public void updateOrderWhenAfterPay(Order order);


}
