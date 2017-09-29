package com.chan.JavaMutiThreadProgramming.Demo.Third.Rest;

/**
 * Created by Osborn on 2017/8/10.
 */
public class FoodOrder {
	public Food food;
	private String tableNum;

	enum Status {
		PACLE, PROP, CANCEL, COMMIT
	}
}
