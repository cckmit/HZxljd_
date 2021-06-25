package com.ruoyi.common.enums;

public enum EventTypeStatus {

    /**上报平台编码**/
    EVENT_PLAT_CODE("platCode","1001,1002,1003,1004"),
    /******************智慧城管事件分类*********************/
    EVENT_PLAT_1001_CODE("chengguan","62055,62056,62057,62040,62054,62059,62061,62053,62063,62062,62060"),
    EVENT_PLAT_1001_CODE001("62055","垃圾堆积"),
    EVENT_PLAT_1001_CODE002("62056","出店经营"),
    EVENT_PLAT_1001_CODE003("62057","无照经营游商"),
    EVENT_PLAT_1001_CODE004("62040","机动车违停"),
    EVENT_PLAT_1001_CODE005("62054","非机动车违停"),
    EVENT_PLAT_1001_CODE006("62059","违规广告"),
    EVENT_PLAT_1001_CODE007("62061","沿街晾挂"),
    EVENT_PLAT_1001_CODE008("62053","人员聚集"),
    EVENT_PLAT_1001_CODE009("62063","打包垃圾"),
    EVENT_PLAT_1001_CODE010("62062","垃圾箱垃圾溢出"),
    EVENT_PLAT_1001_CODE011("62060","垃圾暴露"),

    /********************************青山云事件分类***********************/
    EVENT_PLAT_1004_CODE("qingshanyun","1,2,3,4"),
    EVENT_PLAT_1004_CODE001("1","投诉建议"),
    EVENT_PLAT_1004_CODE002("2","寻求帮助"),
    EVENT_PLAT_1004_CODE003("3","环境交通"),
    EVENT_PLAT_1004_CODE004("4","其他类型"),

    /**预警赋能**/
    EVENT_STATUS_CODE01("transferAll","2,3,5"),

    /***********************综治平台的物联网设备编号***************************/
    EVENT_CAMERA_TYPE_CODE001("09-01-02","地磁传感器"),
    EVENT_CAMERA_TYPE_CODE002("09-06-01","水压传感嚣"),
    EVENT_CAMERA_TYPE_CODE003("09-08-01","无线烟感"),
    EVENT_CAMERA_TYPE_CODE004("09-01-02","智能电感"),
    EVENT_CAMERA_TYPE_CODE005("01-01-01","电梯"),
    EVENT_CAMERA_TYPE_CODE006("08-01-03","监控摄像头"),
    EVENT_CAMERA_TYPE_CODE007("05-03-01","人脸识别相机"),
    EVENT_CAMERA_TYPE_CODE008("09-03-01","井盖监测终端"),
    EVENT_CAMERA_TYPE_CODE009("06-01-03","车牌识别相机"),
    EVENT_CAMERA_TYPE_CODE010("09-06-02","液位传感嚣"),

    EVENT_CAMERA_TYPE_CODE("machine","09-01-02,09-06-01,09-08-01,09-01-02,01-01-01,08-01-03,05-03-01,09-03-01,06-01-03,09-06-02"),
    /************************综治平台的大类************************************/
    EVENT_PLAT_1003_CODE("zongzhi","01,02,03,04"),
    EVENT_PLAT_1003_CODE001("01","综合执法"),
    EVENT_PLAT_1003_CODE002("02","便民服务"),
    EVENT_PLAT_1003_CODE003("03","市场监管"),
    EVENT_PLAT_1003_CODE004("04","综治工作"),


    /******************平台事件的处置方式*********************/
    EVENT_DONE_WAY01("1","machineDis"),     //机器处置
    EVENT_DONE_WAY02("2","errorDis"),       //异常关闭
    EVENT_DONE_WAY03("3","togetherDis"),    //共治处置
    EVENT_DONE_WAY04("4","lawDis"),         //执法处置

    /***************应急消防大类 应急隐患 下的小类****************/
    EVENT_TROUBLE_STATUS01("00","报警"),
    EVENT_TROUBLE_STATUS02("01","隐患"),
    EVENT_TROUBLE_STATUS03("02","巡查"),

    EVENT_TROUBLE_STATUS_CORRE00("00","000,001,002"),//报警下的小类
    EVENT_TROUBLE_STATUS_CORRE01("01","001,002,003,004"),//隐患下的小类

    EVENT_TROUBLE_STATUS01_SUB01("001","电器老化"),
    EVENT_TROUBLE_STATUS01_SUB02("002","吸烟，乱扔烟头"),
    EVENT_TROUBLE_STATUS01_SUB03("003","阻塞消防逃生通道"),
    EVENT_TROUBLE_STATUS01_SUB04("004","员工消防意识不足"),

    EVENT_TROUBLE_STATUS00_SUB01("000","异常"),
    EVENT_TROUBLE_STATUS00_SUB02("001","火警"),
    EVENT_TROUBLE_STATUS00_SUB03("002","故障");


    private final String code;

    private final String desc;

    private EventTypeStatus(final String code, final String desc){
        this.code = code;
        this.desc = desc;
    }

    public static String getDesc(String value) {
        EventTypeStatus[] instructionEnums = values();
        for (EventTypeStatus enumFinanceStatus : instructionEnums) {
            if (enumFinanceStatus.code().equals(value)) {
                return enumFinanceStatus.desc();
            }
        }
        return null;
    }

    /**
     * 根据Code获得枚举
     *
     * @param code
     * @return
     */
    public static EventTypeStatus getByCode(String code) {
        EventTypeStatus[] types = values();
        for (EventTypeStatus type : types) {
            if (type.equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String code(){
        return this.code;
    }

    public String desc(){
        return this.desc;
    }
}
