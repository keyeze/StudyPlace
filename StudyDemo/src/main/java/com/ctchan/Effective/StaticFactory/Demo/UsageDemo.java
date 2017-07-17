package com.ctchan.Effective.StaticFactory.Demo;

import java.util.EnumSet;

/**
 * 静态工厂方法一些惯用名称
 * <p>
 * Created by Osborn on 2017/7/17.
 */
public class UsageDemo {

	private static final Object OBJ = new Object();

	//返回的实例与参数具有相同值，一般做一些类型转换
	public static Boolean valueOf(boolean b) {

		return b ? Boolean.TRUE : Boolean.FALSE;

	}

	//返回的实例与参数具有相同值，一般做一些类型转换,是一种valueOf的简化，在EnumSet中有实例
	public static Boolean of(boolean b) {
		return UsageDemo.valueOf(b);
	}

	//获得方式通过参数来描述，比一定返回具有相同的值，对于单例，没有参数，则返回唯一实例
	public static Object getInstance() {
		return UsageDemo.OBJ;
	}

	//相较于getInstance，能够确保返回的每个实例都与所有其他实例不同。
	public static Object newInstance() {
		return new Object();
	}

	//不明所以
	public static Object getType() {
		try {
			return OBJ.getClass().getMethod("getInstance", null).getReturnType();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//不明所以
	public static Object newType() {
		try {
			return UsageDemo.class.getMethod("getInstance", null).getReturnType();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
