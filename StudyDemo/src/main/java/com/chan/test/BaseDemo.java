package com.chan.test;

/**
 * Created by keyez on 2017/7/16.
 */
public abstract class BaseDemo implements DemoExplain {
    public Boolean needToString() {
        return false;
    }
    @Override
    public String toString() {
        return (this.needToString() ? super.toString() + "\n**************************\n" : "")
                + (this.explain() == null ? "作者太懒没有做出解释..." : this.explain());
    }
}
