package com.chan.service;

import com.chan.common.CommonUtil;
import com.chan.common.SuccessThrowable;
import com.chan.dao.IOrderDao;
import com.chan.entity.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderService implements IOrderService {


    @Resource
    private IOrderDao orderDao;

    /**
     * 通过订单ID获取预支付订单信息,
     * 充值金额计算,支付方式.
     *
     * @param orderId 订单ID
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.Throwable.class, noRollbackFor = com.chan.common.SuccessThrowable.class)
    public Order redealPreOrder(Long orderId) throws Throwable {
        Order order = orderDao.getOrderById(orderId);
        if (CommonUtil.STATUS.HAS_PAY.is().equals(order.getPayStatus()))
            throw new SuccessThrowable("已经支付过,无需再次调用支付流程");
        order.setACost(null);
        order.setBCost(null);
        order.setCCost(null);
        order.setPayWay(null);
        orderDao.modifyOrder(order);
        return orderDao.getOrderById(order.getId());
    }

    /**
     * 通过自定义订单生成器获得订单,并保存到数据库中
     *
     * @param orderBuilder 订单生成器
     * @return
     */
    @Override
    public Order insertPreOrder(Order.OrderBuilder orderBuilder) throws Exception {
        //生成订单
        Order order = orderBuilder.build();
        orderDao.addOrder(order);
        //清减库存
        subStockByOrder(order);

        //订单生成最终检测检测
        refuseProductOrderCheck();
        //发起定时任务,定时关闭订单
        pickUpTimedTask(order);
        return order;
    }

    //订单生成最终检测检测,如果不符合要求不将生成订单
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class, noRollbackFor = SuccessThrowable.class)
    public void refuseProductOrderCheck() throws RefuseException {
        throw new RefuseException("无法发起订单!");
    }

    //通过生成的订单信息的创建时间,发起定时任务,定时关闭订单
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class, noRollbackFor = SuccessThrowable.class)
    public void pickUpTimedTask(Order order) {
    }

    //通过生成的订单信息清减库存
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class, noRollbackFor = SuccessThrowable.class)
    public void subStockByOrder(Order order) {
    }

    /**
     * 通过订单,计算将扣除的用户货币保存在订单记录中.
     *
     * @param order
     * @return
     */
    @Override
    public void updateCostByOrder(Order order) {

    }

    /**
     * 通过订单,检查用户余额是否满足支付订单的条件.
     *
     * @param order
     * @return
     */
    @Override
    public void checkMemberBalanceByOrder(Order order) {

    }

    /**
     * 通过订单,扣除非第三方支付扣款
     *
     * @param order
     */
    @Override
    public void updateMemberBalanceExceptOtherPayByOrder(Order order) {

    }

    /**
     * 通过订单,支付完成
     *
     * @param order
     */
    @Override
    public void updateOrderWhenAfterPay(Order order) {

    }
}
