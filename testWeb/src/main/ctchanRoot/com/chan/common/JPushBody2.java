package com.chan.common;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by keyez on 2017/11/29.
 */
public class JPushBody2 {
    /**
     * 通知内容
     * 这里指定内容将会覆盖上级统一指定的 alert 信息；内容为空则不展示到通知栏。支持字符串形式也支持官方定义的alert payload 结构
     * 内容为String或JSONObject格式
     **/
    @BuilderRequired(false)
    @BuilderSupportClass(value = {String.class, JSONObject.class})
    Object alert;
    /**
     * 通知提示声1
     * 音	如果无此字段，则此消息无声音提示；有此字段，如果找到了指定的声音就播放该声音，否则播放默认声音,如果此字段为空字符串，iOS 7 为默认声音，iOS 8及以上系统为无声音。(消息) 说明：JPush 官方 API Library (SDK) 会默认填充声音字段。提供另外的方法关闭声音。
     **/
    String sound;
    /**
     * 应用角标
     * 如果不填，表示不改变角标数字；否则把角标数字改为指定的数字；为 0 表示清除。JPush 官方 API Library(SDK) 会默认填充badge值为"+1",详情参考：badge +1
     **/
    Integer badge;
    /**
     * 推送唤醒
     * 推送的时候携带"content-available":true 说明是 Background Remote Notification，如果不携带此字段则是普通的Remote Notification。详情参考：Background Remote Notification
     **/
    //todo 这里应该发送的名字为 'content-available'
    boolean content_available;
    /**
     * 通知扩展
     * 推送的时候携带”mutable-content":true 说明是支持iOS10的UNNotificationServiceExtension，如果不携带此字段则是普通的Remote Notification。详情参考：UNNotificationServiceExtension
     **/

    //todo 这里应该发送的名字为 'mutable-content'
    boolean mutable_content;
    /**
     * IOS8
     * 才支持。设置APNs payload中的"category"字段值
     */
    String category;
    /**
     * 可选
     * 附加字段
     * 这里自定义 Key/value 信息，以供业务使用。
     **/
    JSONObject extras;


}
