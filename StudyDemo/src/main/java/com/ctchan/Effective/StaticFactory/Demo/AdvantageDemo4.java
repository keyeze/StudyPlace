package com.ctchan.Effective.StaticFactory.Demo;

import com.ctchan.tool.BaseDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 静态工厂方法与构造器不同的第四个优势在于，在创建参数化类型实例时，它可以让代码更简洁
 * <p>
 * 这样易于扩展
 * <p>
 * Created by keyez on 2017/7/17.
 */
public class AdvantageDemo4 extends BaseDemo {

	@Override
	public String explain() {
		return null;
	}

	public static <K, V> Map<K, V> newInstance() {
		return new HashMap<>();
	}

	public static void main(String[] args) {
		Map<String, String> map = AdvantageDemo4.newInstance();
		Map<Integer, Integer> map2 = AdvantageDemo4.newInstance();
	}
}
