package com.chan.Effective.StaticFactory.Demo.EX;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务市场
//Noninstantiable class for service registration and access
public class Services {
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

	//选择并提供服务
	//Service access API
	public static <T> T newInstance() throws Exception {
		Provider provider = providers.get(null);
		if (provider == null) {
            throw new Exception();
        }
		Service service = provider.newService(null);
		if (service == null) {
            throw new Exception();
        }
		if (service.getClass() != null) {
            return (T) newInstance(DEFAULT_PROVIDER_NAME);
        }

		return null;
	}

	private static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null) {
            throw new IllegalArgumentException("No provider registerd with name:" + name);
        }
		return p.newService(name);
	}
}

