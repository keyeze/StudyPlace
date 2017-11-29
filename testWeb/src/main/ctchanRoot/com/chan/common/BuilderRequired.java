package com.chan.common;

/**
 * 用于 Builder对象校验是否必填
 */
public @interface BuilderRequired {
    /**
     * 是否进行非无效字符验证:
     * 比如:
     * String -> ""
     * int ->0
     * 该值设置为true时,无法通过验证.
     * 否则只判断是否为空.
     *
     * @return
     */
    boolean value() default true;
}
