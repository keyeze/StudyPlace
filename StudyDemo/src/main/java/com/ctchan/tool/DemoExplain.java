package com.ctchan.tool;

/**
 * Created by keyez on 2017/7/16.
 */
public interface DemoExplain {
    /**
     * 是否在解释时附上toString()
     */
    public Boolean needToString();

    /**
     * 解释方法,需要为每个Demo编写
     */
    public String explain();
}
