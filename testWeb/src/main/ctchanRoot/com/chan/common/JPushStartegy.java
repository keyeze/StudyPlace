package com.chan.common;

import javax.xml.bind.annotation.XmlType;

/**
 * 这是用于极光推送的接口方法.
 * 用于发送四中消息:通知,自定义消息,富媒体和本体通知
 * 该接口默认的实现类有:
 * {@link AndriodJPush}&&{@link IPhoneJPush}
 */
public interface JPushStartegy {


    void pushMessage();
}
