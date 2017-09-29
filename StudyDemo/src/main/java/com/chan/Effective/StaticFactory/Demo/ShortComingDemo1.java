package com.chan.Effective.StaticFactory.Demo;

import com.chan.test.BaseDemo;

/**
 * 静态工厂方法与构造器不同的第一个缺点在于，类如果不含公有或者受保护的构造器，就不能被子类化
 * <p>
 * 这样易于扩展
 * <p>
 * Created by keyez on 2017/7/17.
 */
public class ShortComingDemo1 extends BaseDemo {

	@Override
	public String explain() {
		return null;
	}
}
