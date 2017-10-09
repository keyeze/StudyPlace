package com.chan.web.servlet;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Component
public class CtChanHandlerMapping implements HandlerMapping {
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        System.out.println("CtChan的Handler处理链路");
        return null;
    }
}
