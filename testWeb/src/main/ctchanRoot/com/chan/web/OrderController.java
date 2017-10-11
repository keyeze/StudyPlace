package com.chan.web;

import com.chan.service.IOrderService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class OrderController {
    @Resource
    private IOrderService orderService;
}
