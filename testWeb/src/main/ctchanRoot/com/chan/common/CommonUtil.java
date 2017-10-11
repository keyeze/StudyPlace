package com.chan.common;

public class CommonUtil {
    public enum STATUS {
        //用于标记记录是否被删除
        NORMAL(0, "正常"), DELETE(1, "删除"),
        //用于判断支付状态
        NO_PAY(0, "未支付"), HAS_PAY(1, "已支付"),
        //用于跟踪订单状态
        ORDER_GENERATE(0, "订单生成"), ORDER_COMPLETE(1, "订单完成"),
        ORDER_APPLICATION_DRAWBACK(2, "申请退款"), ORDER_REFUND(3, "已退款"), ORDER_SHUT_DOWN(4, "订单关闭");
        private Integer value;
        private String name;

        public Integer is() {
            return value;
        }

        public String show() {
            return name;
        }

        STATUS(Integer value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public enum ORDER_TYPE {
        SHOP(1, "商品"), GIFT(2, "礼品"), TICKET(3, "门票"), PRE_TICKET(4, "预售票"), SELL(5, "零售"), DRINK(6, "水吧");

        ORDER_TYPE(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        private Integer value;
        private String name;

        public Integer is() {
            return value;
        }

        public String show() {
            return name;
        }

    }

    public enum PAY_WAY {
        BALANCE(0, "余额支付"), WEIXIN(1, "微信支付"), ALIPAY(2, "支付宝"), UNIONPAY(3, "银联支付"), CASH(4, "现金支付");

        PAY_WAY(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        private Integer value;
        private String name;

        public Integer is() {
            return value;
        }

        public String show() {
            return name;
        }

    }
}
