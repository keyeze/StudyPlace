package com.chan.common;

/**
 * Created by keyez on 2017/11/29.
 */
public class JPushCommon {

    public static class ANDRIOD_COMMON {
        public static class Style {
            public final static int BIG_TEXT = 1;
            public final static int INBOX = 2;
            public final static int BIG_PIC_PATH = 3;
        }

        public static class Notification {
            public final static int DEFAULT_ALL = -1;
            public final static int DEFALUT_SOURD = 1;
            public final static int DEFAULT_VIBRATE = 2;
            public final static int DEFAULT_LIGHTS = 4;
        }
    }

    public static class IPHONE_COMMON {
        public static class Bagge {
            public final static int CLEAR = 0;
            public final static int DEFAULT = 1;
        }

        public static class ContentAvailable {
            public final static boolean BACKGROUND_REMOTE_NOTIFICATION = true;
            public final static boolean COMMON_REMOTE_NOTIFICATION = false;
        }

        public static class MutableContent {
            public final static boolean UNNOTIFICATION_SERVICE_EXTENSION = true;
            public final static boolean COMMON_REMOTE_NOTIFICATION = false;
        }
    }


}
