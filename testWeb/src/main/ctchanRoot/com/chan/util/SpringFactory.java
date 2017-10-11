package com.chan.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class SpringFactory {
    public <T> T getIntance(Class<T> clz, HttpServletRequest request) {
        return null;
    }
}
