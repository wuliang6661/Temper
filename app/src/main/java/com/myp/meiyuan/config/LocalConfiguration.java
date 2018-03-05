package com.myp.meiyuan.config;

/**
 * Created by wuliang on 2017/3/6.
 * <p>
 * 程序的公共环境配置，或公共字段存放
 */

public class LocalConfiguration {

    // 自己微信应用的 appId
    public static final String WEIXIN_APP_ID = "填写自己的APP_id";
    public static final String APP_SECRET = "填写自己的AppSecret";

    public static final String userName = "userName";

    public static final int DEVICE_TYPE_TEMPERATURE = 1;// 空气温度

    public static final int DEVICE_TYPE_HUMIDITY = 2;// 空气湿度

    public static final int DEVICE_TYPE_CO2 = 3;// CO2浓度

    public static final int DEVICE_TYPE_LIGHT = 4;// 光照强度

    public static final int DEVICE_TYPE_VIDEO = 5;// 视频

    public static final int DEVICE_TYPE_SWITCH = 6;// 开关

    public static final int DEVICE_TYPE_PICTURE = 7;// 图片

    public static final int DEVICE_TYPE_SoilMoisture = 8;//土壤养分

    public static final int DEVICE_TYPE_SoilNutrient = 9;//土壤水分

    public static final int DEVICE_TYPE_SoilMoistureNutrient = 10;//土壤养分和水分

    public static final int DEVICE_TYPE_SoilTEMPERATURE = 11;//土壤温度

    public static final int DEVICE_TYPE_SoilPH = 12;//土壤PH

    public static final int DEVICE_TYPE_Soil3Nutrient = 13;//三通道土壤水分

    public static final int DEVICE_TYPE_WindRainfall = 14;//风速，风向，雨量

    public static final int DEVICE_TYPE_MOSWITCH = 15;// 模拟水阀

    public static final int DEVICE_TYPE_BUSWITCH = 16;// 补光灯

}
