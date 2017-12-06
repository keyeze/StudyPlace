package com.chan.Effective.StaticFactory.Demo.EX;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//服务商应该还要暴露它们的服务
//Service Provider interface
public interface Provider {
    String DEFAULT_PROVIDER_NAME = "<def>";
    ConcurrentHashMap<String, Service> SERVICES_MAP = new ConcurrentHashMap<>();

    /**
     * 提供服务
     *
     * @param name
     * @return
     */

    Service newService(String name);

    /**
     * 暴露服务
     */

    Map<String, Service> showServices();

}


