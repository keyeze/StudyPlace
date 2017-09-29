package com.chan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osborn on 2017/8/10.
 */

public class Customer extends Person {
	private String tableNum;
	private List<Order> orders;

	public Waitor serviceWaitor;

	/**
	 * 支付订单
	 */
	@RestaurantService(Waitor.class)
	public void payTheBill() {
		//todo :等待服务员服务....
		try {
			this.CallWaitor();
			Double sumCost = serviceWaitor.takeBillCost(tableNum);
			//核对菜单金额
			if (checkPrice(sumCost)) {
				//todo:订单正常的打印内容
				RestaurantPool.printMachine.print(() -> "OK");
				return;
			}
			//对比用户桌上的订单与餐饮店的底单详情
			if (checkOrderDetail()) {
				//todo:订单对比详情后的打印内容
				RestaurantPool.printMachine.print(() -> "OK");
				return;
			}
			//呼唤管理人员解决问题
			this.CallGM();
		} finally {
			this.overService(null);
		}
	}

	//todo :这里应该进行进行读写锁操作,当超过时间 客户不需要 waitor 时 释放wait用户
	private void overService(Task task) {
		//添加Waitor任务
		if (task != null)
			serviceWaitor.acceptTask(task);
		//todo:添加服务等待结束,等待时间,这个过程会随着overService的进入而强制结束;
		RestaurantPool.WaitorPool.beFreeWaitor(serviceWaitor);
		this.serviceWaitor = null;

	}

	/**
	 * 呼叫管理员!!
	 */
	private void CallGM() {
	}

	/**
	 * 呼叫服务员
	 */
	private void CallWaitor() {
		if (serviceWaitor != null)
			return;
		this.serviceWaitor = RestaurantPool.WaitorPool.CallWaitor();
	}

	/**
	 * 校验订单价格
	 */
	//todo :这里应该完成的是手头上的订单价格的校验
	private boolean checkPrice(Double prePayMoney) {
		return true;
	}

	/**
	 * 订单详情
	 */
	//todo :对比订单详细,是哪里出现了错误
	private boolean checkOrderDetail() {
		return true;
	}

	/**
	 * 进店
	 */
	@RestaurantService(Waitor.class)
	private void intoRestaurant() {
		try {
			this.CallWaitor();
			tableNum = serviceWaitor.searchTableNum();
		} finally {
			//todo:这里应该有个获得菜单的任务
			this.overService(null);
		}
	}

	/**
	 * 下单
	 */
	@RestaurantService(Waitor.class)
	private void placeTheBill() {
		try {
			this.CallWaitor();
			//todo:这里还有个获得菜单的过程,先略
			Order order = new Order(this.tableNum);
			order.setStatus(Order.Status.PLACE);
			List<Food> menu = new ArrayList<>();
			//todo:点菜的过程,略
			order.setMenu(menu);
			RestaurantPool.OrderPool.addTableOrder(tableNum, order);
			orders.add(order);
		} finally {
			this.overService(() -> serviceWaitor.requestCook(tableNum));
		}
	}

	@RestaurantService(GM.class)
	private void refundRequest() {

		this.CallGM();//todo:呼叫GM然后进行一系列协商工作

	}

	//todo :吃饭和上菜之间应该存在增菜之类,催单的操作.
	private void eatting() {
	}
	//todo:可以进行代理加上
	/**
	 * try {
	 * this.CallWaitor();
	 * ...
	 * } finally {
	 * this.overService();
	 * }
	 * <p>
	 * 利用 @WaitorService
	 */
}
