package com.example.demo.config.redis;

/**
 * @title:
 * @Description:redis的key值常量类
 * @Date:2018/3/16
 * @Author:tong.niu
 * @Company: 北京亚湾信息技术有限公司
 */
public class RedisKey {
    /**
     * 登陆KEY
     */
    public static final String TMS_WELL_KEY = "tw-to-uuid-";

    /**
     * 二维码key
     */
    public static final String TMS_WELL_SOCKET_QRCODE_KEY = "tw-to-qrid-";
    /**
     * H5扫码获取地理位置调度KEY
     */
    public static final String TMS_WELL_LOCATION_SCHEDULE = "tw-lac-sche-lock";
    /**
     * 定时发送短信锁
     */
    public static final String TMS_WELL_SMS_SENDMSG = "tw_sms_record_sendMsg";
    /**
     * 检测成功状态
     */
    public static final String TMS_WELL_SMS_CKECKSUCCESS = "tw_sms_record_checkSuccess";

    /**
     * 定时扣除短信服务费
     */
    public static final String TMS_WELL_CONTRACT = "tms_well_contract";
    /**
     * 定时扣除投放费用
     */
    public static final String TMS_NEWTON_COST = "tms_well_cost";
    //验证码
    public static final String TMS_WELL_LOGIN_CODE = "tw-well-login-code-";
    public static final String TMS_WELL_FLIGHT_MODEL_REMIND = "tms-well-flight-model-remind";
    public static final String TMS_WELL_FLIGHT_MODEL_EXPIRE_REMIND = "tms-well-flight-model-expire-remind";
    public static final String TMS_WELL_FLIGHT_MODEL_SWITCH_REMIND = "tms-well-flight-model-switch-remind";
    public static final String TMS_WELL_FLIGHT_MODEL_CLOSE_REMIND = "tms-well-flight-model-close-remind";
    public static final String TMS_WELL_NEWTON_TEMP_CLUE_OUT_TASK = "tms-well-newton-temp-clue-out-task";
    /**
     * 置顶操作的时间限制
     */
    private static final String TOP_REDIS_TIEM = "tms_well_top_";

    // 定时关闭已结束的广告联盟投放任务
    public static final String AUTO_CLOSE_AD_TASK = "tms_well_auto_close_ad_task";

    public static final String TMS_WELL_OUTPUT_VALUE_RECALL_SMS_RECORD_TASK = "tms_well_output_value_recall_sms_record_task";


    public static String getTopChannelContentId(String accountId, Long comId) {
        return TOP_REDIS_TIEM + accountId + "_" + comId;
    }

    public static String getClueAutoDistributeKey(Long comId) {
        return "tms_well_clue_auto_distribute_" + comId;
    }
}
