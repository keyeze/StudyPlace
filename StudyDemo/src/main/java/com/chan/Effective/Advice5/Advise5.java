package com.chan.Effective.Advice5;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.WeakHashMap;

public class Advise5 {
    String s = new String("DON'T DO THIS!");//DON'T DO THIS!
    //   Suggest To  -->
    String s2 = "DON'T DO THIS!";

    static class Person {
        private Date birthDate;

        //Other fields ,methods,and constructor omitted
        //DON'T DO THIS!
        public boolean isBabyBoomer() {
            //Unnecessary allocation of expensive object
            Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
            Date boomStart = gmtCal.getTime();
            gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
            Date bommEnd = gmtCal.getTime();
            return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(bommEnd) < 0;
        }

        //改进后
        private static final Date BOOM_START;
        private static final Date BOOM_END;

        static {
            Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_START = gmtCal.getTime();
            gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
            BOOM_END = gmtCal.getTime();
        }

        public boolean isBabyBoomer2() {
            return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
        }
    }

    //要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
    @Test
    public void demo(){
        Long sum = 0L;
        long start = new Date().getTime();
        for (long i = 0; i < Integer.MAX_VALUE; i++)
            sum +=i;
        long end = new Date().getTime();
        System.out.println("time use:"+(end-start)+" ms!");

        long sum2 = 0L;
        start = new Date().getTime();
        for (long i = 0; i < Integer.MAX_VALUE; i++)
            sum2 +=i;
        end = new Date().getTime();
        System.out.println("time use:"+(end-start)+" ms!");

        Long sum3 = 0L;
        start = new Date().getTime();
        for (Long i = 0L; i < Integer.MAX_VALUE; i++)
            sum3 +=i;
        end = new Date().getTime();
        System.out.println("time use:"+(end-start)+" ms!");


    }
}
