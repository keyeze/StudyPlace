package com.ctchan.JavaMutiThreadProgramming.Demo.Third.Rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 标记需要Waitor服务的方法
 */
@Target(ElementType.METHOD)
public @interface RestaurantService {
	public Class value();
}
