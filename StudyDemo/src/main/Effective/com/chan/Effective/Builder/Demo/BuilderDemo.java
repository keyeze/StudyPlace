package com.chan.Effective.Builder.Demo;

import com.chan.test.BaseDemo;

/**
 * Created by Osborn on 2017/7/17.
 */


public class BuilderDemo extends BaseDemo{
	@Override
	public String explain() {
		return null;
	}

	public Long id;
	public String name;
	public Integer age;



	public static class Builder{

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
