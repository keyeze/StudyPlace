package com.chan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.util.TreeSet;

/**
 * Created by Osborn on 2017/8/10.
 */
public class Food {
	private Double price;
	private String foodName;
	private Status status;
	private static Status classStatus;
	private static TreeSet<RawFood> recipes;//todo:原材料清单

	public Double getPrice() {
		return price;
	}

	public Food setPrice(Double price) {
		this.price = price;
		return this;
	}

	public String getFoodName() {
		return foodName;
	}

	public Food setFoodName(String foodName) {
		this.foodName = foodName;
		return this;
	}

	enum Status {
		COMMIT, MAKING, STOCK, UNSTOCK, BOOK
	}
}
