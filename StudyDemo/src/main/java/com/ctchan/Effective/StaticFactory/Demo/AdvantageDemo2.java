package com.ctchan.Effective.StaticFactory.Demo;

import com.ctchan.tool.BaseDemo;

/**
 * 静态工厂方法与构造器不同的第二大优势在于,不必在每次调用它们的时候都创建一个新对象
 * <p>
 * Created by keyez on 2017/7/17.
 */
public class AdvantageDemo2 extends BaseDemo{

    @Override
    public String explain() {
        return null;
    }
    public Boolean changeBoolean(boolean b){
        return b?Boolean.TRUE:Boolean.FALSE;
    }


}
