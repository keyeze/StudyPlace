package com.chan.web;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import com.chan.service.IOrderService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class OrderController {

    @Resource
    private JPushClient jPushClient;
    @Resource
    private IOrderService orderService;

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        Map result = new HashMap<>();
        result.put("code", "OK");
        return result;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Object test2() throws APIConnectionException, APIRequestException {
//        JPushClient jPushClient = new JPushClient(masterSecret, appKey);
//
        PushPayload pushPayload = buildPushObject();
        System.out.println(pushPayload);
        PushResult result = jPushClient.sendPush(pushPayload);
        System.out.println(result);
        return "OK";
    }

    private PushPayload buildPushObject() {
        return PushPayload.alertAll("OK");
    }
}
