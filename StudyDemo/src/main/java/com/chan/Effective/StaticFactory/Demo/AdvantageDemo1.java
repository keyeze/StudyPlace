package com.chan.Effective.StaticFactory.Demo;

import com.chan.test.BaseDemo;

import java.util.Random;

/**
 * 相比于构造方法静态工厂方法它有名字
 *
 * Created by keyez on 2017/7/16.
 */
public class AdvantageDemo1 extends BaseDemo{

    private Integer num;

    //    构造方法:获得获得一个随机x位内的偶数对象
    public AdvantageDemo1(Random rand, int x) {
        this.num = rand.nextInt(100000000) % ((int) Math.pow(10, x) >> 1) << 1;

    }

    //    构造方法:获得获得一个随机x位内的奇数对象
    public AdvantageDemo1(int x, Random rand) {
        this.num = 1 + (rand.nextInt(100000000) % ((int) Math.pow(10, x) >> 1) << 1);
    }

    //    静态工厂方法:获得获得一个随机x位内的偶数对象
    public static AdvantageDemo1 getEvenNum_Random(Random rand, int x) {
        return new AdvantageDemo1(rand, x);
    }

    //    静态工厂方法:获得获得一个随机x位内的奇数对象
    public static AdvantageDemo1 getOddNum_Random(Random rand, int x) {
        return new AdvantageDemo1(x, rand);
    }

    @Override
    public String toString() {
        return num.toString();
    }

    public static void main(String[] args) {
        int bit = 2;
        Random rand = new Random();
        System.out.println(new AdvantageDemo1(rand, bit));
        System.out.println(new AdvantageDemo1(bit, rand));
        //以上两种方法你从函数本身不知道哪个是获得偶数哪个是获得奇数
        //以下两种方法你可以清楚的知道自己获取的是什么对象
        System.out.println(AdvantageDemo1.getEvenNum_Random(rand, bit));
        System.out.println(AdvantageDemo1.getOddNum_Random(rand, bit));

    }

    @Override
    public String explain() {
        return null;
    }
}
