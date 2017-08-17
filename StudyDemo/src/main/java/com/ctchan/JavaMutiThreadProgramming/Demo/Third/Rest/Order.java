package com.ctchan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Osborn on 2017/8/10.
 */
//todo :这里的订单应该由OrderPool出单,不能直接new
public class Order {
	enum Status {
		COMINT("完成订单"), REFUND("退款"), PLACE("下单"), SERVING("上菜中");
		private final String name;

		Status(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}


	private final String tableNum;
	public List<Food> menu;
	private Status status;

	public Order setMenu(List<Food> menu) {
		this.menu = menu;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public Order setStatus(Status status) {
		this.status = status;
		return this;
	}

	//todo:这里修改一下用Builder模式,Effective Java Tips 2
	public Order(String tableNum) {
		this.tableNum = tableNum;
	}

	public Double getTotalPrice() {
		BigDecimal sum = new BigDecimal(0);
		for (Double item : menu.stream().map(Food::getPrice).collect(Collectors.toList())) {
			sum.add(new BigDecimal(item));
		}
		return sum.setScale(2, BigDecimal.ROUND_UP).doubleValue();
	}

	public List<Food> getMenu() {
		return menu;
	}

	public String getTableNum() {
		return tableNum;
	}
}