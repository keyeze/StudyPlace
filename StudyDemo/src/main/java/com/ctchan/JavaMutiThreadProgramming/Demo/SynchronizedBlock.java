package com.ctchan.JavaMutiThreadProgramming.Demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Osborn on 2017/7/19.
 */
public class SynchronizedBlock {

	public static class ObjectService {
		public void serviceMethod() {
			try {
				System.out.println(Thread.currentThread().getName() + " 线程进入serviceMethod()");
				synchronized (this) {
					System.out.println(Thread.currentThread().getName() + " 线程进入代码块");
					System.out.println("begin time = " + System.currentTimeMillis());
					Thread.sleep(8000);
					System.out.println("end time = " + System.currentTimeMillis());
					System.out.println(Thread.currentThread().getName() + " 线程结束释放代码块");
				}
				System.out.println(Thread.currentThread().getName() + " 线程结束serviceMethod()");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Runnable r = System.out::println;
		ObjectService os = new ObjectService();
		new Thread(os::serviceMethod).start();
		new Thread(os::serviceMethod).start();

	}



	@Test
	public void fun() {
//
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		System.out.println("Demo1:");
//		list.forEach(System.out::println);
//		System.out.println("Demo2:");
//		list.stream().filter(i -> i >= 2).forEach(System.out::println);

		List<Person> list2 = new ArrayList<>();
		list2.add(new Person().setAge(12).setName("Chan"));
		list2.add(new Person().setAge(13).setName("Luo"));
		List nameList = list2.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println(nameList);
	}
	public static class Person {
		public String name;
		public Integer age;
		public String getName() {return name;}
		public Person setName(String name) {this.name = name;return this;}
		public Integer getAge() {return age;}
		public Person setAge(Integer age) {this.age = age;return this;}
	}
}