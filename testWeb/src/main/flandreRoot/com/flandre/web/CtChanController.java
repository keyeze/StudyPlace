package com.flandre.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Osborn on 2017/8/29.
 */
@Controller
@RequestMapping("/ctchan")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CtChanController {

    private Log logger = LogFactory.getLog(getClass());

    @RequestMapping("helloWorld")
    @ResponseBody
    public Object helloWorld() {
        return "helloWorld";
    }

    @RequestMapping("helloWorld2")
    public String helloWorld2(ModelAndView view) {
        return "/helloWorld";
    }
}
