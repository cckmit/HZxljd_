package com.ruoyi.common.config;




public class HkwsConfig {
    //事件订阅
    public static final String subscribe = "/artemis/api/v1/event/external/subscribe";

    //分页查询出详细的场所信息
    public static final String storefetch = "/artemis/api/v1/store/fetch";

//    public static final String fetchAll = "/artemis/api/v1/event/external/fetchAll";

    //区域接口
    /*public static final  String qyinfo = "/artemis/api/resource/v1/regions";*/
    public static final  String qyinfo = "/artemis/api/v1/gdsc/gridConfig/v1/getGridByParams";

    //区域绑定的用户信息
    public static  final String qyinfouser = "/artemis/api/v1/gridConfig/v1/getGridUserByParams";

    //点位增设建议申请
    public static final String pointproposal = "/artemis/api/cvsj/v1/suggestion/apply";

    //非机动车停放增设
    public static final String  applyparkingarea="/artemis/api/v1/spi/parkingAreaManage/applyParkingArea";
    //停放区增设建议反馈
    public static  final String  pointproposalback = "/artemis/api/v1/spi/parkingAreaManage/feedbackApplyParkingArea";

    //事件反馈
    public static final String eventFeedback = "/artemis/api/v1/event/external/feedback";

    //闲林海康事件
    public static final String eventcg="/artemis/api/istreet/v1/istreetService/alarm/data/list";
    //闲林城管摄像头信息
    public static final String sheXiang="/artemis/api/istreet/v1/istreetService/alarm/configuration/cameras";
    //闲林全部摄像头信息
    public static final String sheXiangAll="/artemis/api/resource/v1/cameras";
    //实时视频接口
    public static final String previewUrl="/artemis/api/video/v1/cameras/previewURLs";
    ///artemis/api/eventService/v1/eventSubscriptionByEventTypes


    //正式环境
    public static String host="10.109.232.2:443";
    public static String appKey = "25704725";
    public static String appSecret = "ZWeSTu8sNwuy5aIyFGgO";

    //测试环境
//    public static String host="211.140.29.11:3443";
//    public static String appKey = "29623199";
//    public static String appSecret = "VpI6k9vqne7tZLMSpAWT";

}
