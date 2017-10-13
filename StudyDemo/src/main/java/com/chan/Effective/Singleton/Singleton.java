package com.chan.Effective.Singleton;

import com.chan.Effective.Builder.Demo.NutritionFacts;
import com.chan.Effective.Singleton.Demo.GlobalSingleton;
import com.chan.Effective.Singleton.Demo.SingletonDemo;
import com.chan.test.DemoExplain;

public enum Singleton implements DemoExplain {
    U1(1, "Singleton的实现方法", SingletonDemo.class),
    U2(2, "提供readResolve方法或单个元素枚举类型让Singleton全局单例", GlobalSingleton.class);

    private final String title;
    private final Integer id;
    private Class<?> clazz = null;

    Singleton(Integer id, String title, Class<?> clazz) {
        this.title = title;
        this.id = id;
        if (clazz == null)
            return;
        this.clazz = clazz;

    }

    @Override
    public String toString() {
        return explain();
    }

    /**
     * 是否在解释时附上toString()
     */
    @Override
    public Boolean needToString() {
        return false;
    }

    /**
     * 解释方法,需要为每个Demo编写
     */
    @Override
    public String explain() {
        return this.name() + "{" +
                id + ". '" + title + '\'' +
                " : " + (clazz == null ? null : clazz.getName()) +
                '}';
    }
}
