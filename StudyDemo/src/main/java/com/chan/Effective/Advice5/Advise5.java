package com.chan.Effective.Advice5;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
}
