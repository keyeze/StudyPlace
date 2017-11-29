package com.chan.common;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by keyez on 2017/11/29.
 */
public class JPushBody {


    /**
     * 通知内容
     * 这里指定了，则会覆盖上级统一指定的 alert 信息；内容可以为空字符串，则表示不展示到通知栏。
     */
    @BuilderRequired(false)
    private String alert;
    /**
     * 通知标题
     * 如果指定了，则通知里原来展示 App名称的地方，将展示成这个字段。
     */
    private String title;
    /**
     * 通知栏样式ID
     * Android SDK 可设置通知栏样式，这里根据样式 ID 来指定该使用哪套样式。
     */
    private int builder_id;
    /**
     * 通知栏展示优先级
     * 默认为0，范围为 -2～2 ，其他值将会被忽略而采用默认。
     */
    private int priority;
    /**
     * 通知栏条目过滤或排序
     * 完全依赖 rom 厂商对 category 的处理策略
     */
    private String category;
    /**
     * 通知栏样式类型
     * 默认为0，还有1，2，3可选，用来指定选择哪种通知栏样式，其他值无效。有三种可选分别为bigText=1，Inbox=2，bigPicture=3。
     */
    private int style;
    /**
     * 通知提醒方式
     * 可选范围为 -1 ～ 7 ，对应 Notification.DEFAULT_ALL = -1 或者 Notification.DEFAULT_SOUND = 1, Notification.DEFAULT_VIBRATE = 2, Notification.DEFAULT_LIGHTS = 4 的任意 “or” 组合。默认按照 -1 处理。
     */
    private int alert_type;
    /**
     * 大文本通知栏样式
     * 当 style = 1 时可用，内容会被通知栏以大文本的形式展示出来。支持 api 16以上的rom。
     */
    @BuilderRelation(key = "style", value = JPushCommon.ANDRIOD_COMMON.Style.BIG_TEXT)
    private String big_text;
    /**
     * 文本条目通知栏样式
     * 当 style = 2 时可用， json 的每个 key 对应的 value 会被当作文本条目逐条展示。支持 api 16以上的rom。
     */
    @BuilderRelation(key = "style", value = JPushCommon.ANDRIOD_COMMON.Style.INBOX)
    private JSONObject inbox;
    /**
     * 大图片通知栏样式
     * 当 style = 3 时可用，可以是网络图片 url，或本地图片的 path，目前支持.jpg和.png后缀的图片。图片内容会被通知栏以大图片的形式展示出来。如果是 http／https 的url，会自动下载；如果要指定开发者准备的本地图片就填sdcard 的相对路径。支持 api 16以上的rom。
     */
    @BuilderRelation(key = "style", value = JPushCommon.ANDRIOD_COMMON.Style.BIG_PIC_PATH)
    private String big_pic_path;
    /**
     * 扩展字段
     * 这里自定义 JSON 格式的 Key/Value 信息，以供业务使用。
     */
    private JSONObject extra;

}
