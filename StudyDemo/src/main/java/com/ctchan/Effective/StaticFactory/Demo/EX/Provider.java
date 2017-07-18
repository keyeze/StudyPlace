package com.ctchan.Effective.StaticFactory.Demo.EX;

import com.ctchan.tool.BaseDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务商应该还要暴露它们的服务
//Service Provider interface
public interface Provider {
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	public static final ConcurrentHashMap<String, Service> servicesMap = new ConcurrentHashMap<>();

	//提供服务
	public Service newService(String name);

	//暴露服务
	public Map<String, Service> showServices();

}


