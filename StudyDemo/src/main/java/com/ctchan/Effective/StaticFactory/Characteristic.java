package com.ctchan.Effective.StaticFactory;

import com.ctchan.Effective.StaticFactory.Demo.*;
import com.ctchan.tool.DemoExplain;

/**
 * 第一条:考虑用静态工厂方法代替构造器
 * <p>
 * Created by keyez on 2017/7/16.
 */

public enum Characteristic implements DemoExplain {
	A1(1, "静态工厂方法与构造器不同的第一大优势在于,它们有名称", AdvantageDemo1.class),
	A2(2, "静态工厂方法与构造器不同的第二大优势在于,不必在每次调用它们的时候都创建一个新对象", AdvantageDemo2.class),
	A3(3, "静态工厂方法与构造器不同的第三个优势在于，它们可以返回原返回类型的任何子类型的对象", AdvantageDemo3.class),
	A4(4, "静态工厂方法与构造器不同的第四个优势在于，在创建参数化类型实例时，它可以让代码更简洁", AdvantageDemo4.class),
	S1(5, "静态工厂方法与构造器不同的第一个缺点在于，类如果不含公有或者受保护的构造器，就不能被子类化", ShortComingDemo1.class),
	S2(5, "静态工厂方法与构造器不同的第二个缺点在于，它们与其他的静态方法实际上没有任何区别", ShortComingDemo2.class),
	PUB(6, "静态工厂方法一些惯用名称",UsageDemo.class);

	private final Integer id;
	private final String title;
	private final Class clazz;

	Characteristic(Integer id, String title, Class clazz) {
		this.id = id;
		this.title = title;
		this.clazz = clazz;
	}

	public Boolean needToString() {
		return false;
	}

	@Override
	public String toString() {
		return this.name() + "{" +
			id + ". '" + title + '\'' +
			explain() +
			'}';
	}

	@Override
	public String explain() {
		return " : " + (clazz == null ? clazz : clazz.getName());
	}

	/**
	 * 关于Boolean的静态工厂方法实例
	 */
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	//TODO 1.静态工厂方法与构造器不同的第一大优势在于它们有名称
}
