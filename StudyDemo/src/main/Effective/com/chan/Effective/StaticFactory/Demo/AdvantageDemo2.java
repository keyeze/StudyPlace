package com.chan.Effective.StaticFactory.Demo;

import com.chan.test.BaseDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态工厂方法与构造器不同的第二大优势在于,不必在每次调用它们的时候都创建一个新对象
 * <p>
 * Created by keyez on 2017/7/17.
 */
public class AdvantageDemo2 extends BaseDemo {

	private static AdvantageDemo2 advantageDemo2 = new AdvantageDemo2("这是一个单例，你可以通过'=='进行比较");
	private final String str;

	public static AdvantageDemo2 getAdvantageDemo2() {
		return advantageDemo2;
	}

	@Override
	public String toString() {
		return str;
	}

	public AdvantageDemo2(String str) {
		this.str = str;
	}

	@Override
    public String explain() {
		return null;
	}

	public static void main(String[] args) {
		List<AdvantageDemo2> list = new ArrayList<>();
		//创建一个新对象，他的引用地址为A
		list.add(new AdvantageDemo2("这是通过构造器获得的类1"));
		//创建一个新对象，他的引用地址为B
		list.add(new AdvantageDemo2("这是通过构造器获得的类2"));
		//这是静态工厂获得的对象，他的引用地址为静态工厂的引用地址C
		list.add(AdvantageDemo2.getAdvantageDemo2());
		//这是静态工厂获得的对象，他的引用地址为静态工厂的引用地址C
		list.add(AdvantageDemo2.getAdvantageDemo2());
		for (AdvantageDemo2 advantageDemo2 : list) {
			for (AdvantageDemo2 advantageDemo2_2 : list) {
				System.out.print(advantageDemo2);
				System.out.print(" vs ");
				System.out.print(advantageDemo2_2);
				System.out.print(" : ");
				System.out.println(advantageDemo2 == advantageDemo2_2);
			}
		}
		//通过比较可以发现，在比较引用时两个对象比较除了本身都为false，两个静态工厂的对象相互比较，结果都为true.
	}

}
