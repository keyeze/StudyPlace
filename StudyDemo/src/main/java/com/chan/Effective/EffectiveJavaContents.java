package com.chan.Effective;

import com.chan.Effective.Advice5.Advise5;
import com.chan.Effective.Buidler.Builder;
import com.chan.Effective.Singleton.Singleton;
import com.chan.Effective.StaticFactory.Characteristic;
import com.chan.test.DemoExplain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

/**
 * 该方法用于展示 Effective Java 的建议条目,并让我熟悉 Enum ^_^
 * Created by keyez on 2017/7/16.
 */
public enum EffectiveJavaContents implements DemoExplain {
    A1(1, "第1条:考虑用静态工厂方法代替构造器", Characteristic.class),
    A2(2, "第2条:遇到多个构造器参数时要考虑用构建器", Builder.class),
    A3(3, "第3条:用私有构造器或者枚举类型强化Singleton属性", Singleton.class),
    A4(4, "第4条:通过私有构造器强化不可实例化的能力", RefuseInstance.class),
    A5(5, "第5条:避免创建不必要的对象", Advise5.class),;

    private final String title;
    private final Integer id;
    private Class<?> clazz = null;

    EffectiveJavaContents(Integer id, String title, Class<?> clazz) {
        this.title = title;
        this.id = id;
        if (clazz == null) return;
        this.clazz = clazz;

    }

    @Override
    public String explain() {
        return this.name() + "{" +
                id + ". '" + title + '\'' +
                " : " + (clazz == null ? clazz : clazz.getName()) +
                '}';
    }

    @Override
    public Boolean needToString() {
        return false;
    }

    @Override
    public String toString() {
        return explain();
    }

    public static void main(String[] args) {
        List<EffectiveJavaContents> list = new ArrayList<EffectiveJavaContents>() {
            public String toString() {
                Iterator<EffectiveJavaContents> it = iterator();
                if (!it.hasNext())
                    return "[]";

                StringBuilder sb = new StringBuilder();
                for (; ; ) {
                    EffectiveJavaContents e = it.next();
                    sb.append(e);
                    if (!it.hasNext())
                        return sb.append('.').toString();
                    sb.append(',').append('\n');
                }
            }
        };
        Collections.addAll(list, EffectiveJavaContents.values());
        System.out.println(list);
    }
}
