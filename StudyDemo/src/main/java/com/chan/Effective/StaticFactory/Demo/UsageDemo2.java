package com.chan.Effective.StaticFactory.Demo;

import com.chan.test.BaseDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Osborn on 2017/7/18.
 */

//让我感觉到了一丝Spring的阴毛
public class UsageDemo2 extends BaseDemo {
	@Override
	public String explain() {
		return null;
	}

}
//Service provider framework sketch


//服务接口
//Service interface
interface Service {

}


//生产者接口
//Service Provider interface
interface Provider {
	//提供服务
	public Service newService();
}


//Noninstantiable class for service registration and access
class Services {
	private static final String DEFAULT_PROVIDER_NAME = "<def>";

	private Services() {
	}

	/**
	 * 存储服务商的类对象
	 */
	//Map service names to services
	public static final Map<String, Provider> providers = new ConcurrentHashMap<>();

	//	注册默认服务商
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}
	//	注册服务商
	private static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	//Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	private static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException("No provider registerd with name:" + name);
		return p.newService();
	}
}

