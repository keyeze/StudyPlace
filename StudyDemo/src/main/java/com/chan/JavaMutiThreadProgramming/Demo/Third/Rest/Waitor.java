package com.chan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Osborn on 2017/8/10.
 */
public class Waitor extends Person {
	Queue<Task> tasks = new ConcurrentLinkedQueue<Task>();
	private Cooker serviceCooker;

	//结算 table 的消费金额
	public Double takeBillCost(String table_num) {
		List<Order> orders = RestaurantPool.OrderPool.getTableOrder(table_num);
		Double sumCost = 0d;
		//生成结算订单
		for (Order item : orders)
			sumCost += item.getTotalPrice();
		return sumCost;
	}

	//找座位
	public String searchTableNum() {
		return RestaurantPool.TablePool.prepareTable();
	}

	//添加任务
	public void acceptTask(Task task) {
		this.tasks.add(task);
	}

	//执行任务
	public void doTask() {
		//todo:这里处理应该是有问题的
		tasks.forEach(Task::doIt);
		tasks.clear();
	}

	//要求厨师做菜
	public void requestCook(String tableNum) {
		List<Order> orders = RestaurantPool.OrderPool.getTableOrder(tableNum);
//		orders.stream().map(order -> {
//			order.getMenu().forEach()
//		});

	}

	//todo :这里可以和Customer的CallWaitor做共用操作.
	public void CallCooker() {
		if (serviceCooker != null)
			return;
		this.serviceCooker = RestaurantPool.CookerPool.CallCooker();
	}

}
