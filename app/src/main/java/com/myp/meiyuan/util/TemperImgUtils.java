package com.myp.meiyuan.util;

import com.myp.meiyuan.R;
import com.myp.meiyuan.config.LocalConfiguration;

/**
 * Created by wuliang on 2018/3/9.
 * <p>
 * 根据DeviceTypeID来选择图片
 */

public class TemperImgUtils {


    public static int getResImg(int typeId, String status) {
        switch (typeId) {
            case LocalConfiguration.DEVICE_TYPE_TEMPERATURE:  //空气温度
                if ("在线".equals(status)) {
                    return R.drawable.wendu;
                } else {
                    return R.drawable.wendu_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_HUMIDITY:  // 空气湿度
                if ("在线".equals(status)) {
                    return R.drawable.shidu;
                } else {
                    return R.drawable.shudu_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_CO2:  //Co2浓度
                if ("在线".equals(status)) {
                    return R.drawable.co2;
                } else {
                    return R.drawable.co2_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_LIGHT:  //光照强度
                if ("在线".equals(status)) {
                    return R.drawable.guangzhao;
                } else {
                    return R.drawable.guangzhao_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_VIDEO:  //视频
                if ("在线".equals(status)) {
                    return R.drawable.shexiang;
                } else {
                    return R.drawable.shexiang_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_SWITCH:   //开关
                if ("在线".equals(status)) {
                    return R.drawable.device_jichu;
                } else {
                    return R.drawable.device_jichu_hui;
                }
            case LocalConfiguration.DEVICE_TYPE_PICTURE:   //图片
            case LocalConfiguration.DEVICE_TYPE_SoilMoisture:  //土壤养分
                if ("在线".equals(status)) {
                    return R.drawable.yangfen;
                } else {
                    return R.drawable.yangfen_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_SoilNutrient:  //土壤水份
            case LocalConfiguration.DEVICE_TYPE_Soil3Nutrient:  //三通道土壤水分
                if ("在线".equals(status)) {
                    return R.drawable.tu_shidu;
                } else {
                    return R.drawable.tu_shidu_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_SoilMoistureNutrient:  //土壤水份和养分
                if ("在线".equals(status)) {
                    return R.drawable.tu_wenandshi;
                } else {
                    return R.drawable.tu_wenandshi_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_SoilTEMPERATURE:  //土壤温度
                if ("在线".equals(status)) {
                    return R.drawable.tu_wendu;
                } else {
                    return R.drawable.tu_wendu_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_SoilPH:  //土壤PH
                if ("在线".equals(status)) {
                    return R.drawable.tu_ph;
                } else {
                    return R.drawable.tu_ph_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_WindRainfall:  //风速，风向，雨量
                if ("在线".equals(status)) {
                    return R.drawable.fengsu;
                } else {
                    return R.drawable.fengsu_dis;
                }
            case LocalConfiguration.DEVICE_TYPE_MOSWITCH:  //模拟水阀
                if ("在线".equals(status)) {
                    return R.drawable.device_moni;
                } else {
                    return R.drawable.device_moni_hui;
                }
            case LocalConfiguration.DEVICE_TYPE_BUSWITCH:  //补光灯
                if ("在线".equals(status)) {
                    return R.drawable.device_buguangdeng;
                } else {
                    return R.drawable.device_buguangdeng_hui;
                }
        }
        return 0;
    }

    public static String getTextType(int typeId) {
        switch (typeId) {
            case LocalConfiguration.DEVICE_TYPE_TEMPERATURE:  //空气温度
            case LocalConfiguration.DEVICE_TYPE_SoilTEMPERATURE:  //土壤温度
                return "℃";
            case LocalConfiguration.DEVICE_TYPE_HUMIDITY:  // 空气湿度
            case LocalConfiguration.DEVICE_TYPE_SoilMoisture:  //土壤养分
            case LocalConfiguration.DEVICE_TYPE_SoilNutrient:  //土壤水份
            case LocalConfiguration.DEVICE_TYPE_Soil3Nutrient:  //三通道土壤水分
            case LocalConfiguration.DEVICE_TYPE_SoilMoistureNutrient:  //土壤水份和养分
                return "%";
            case LocalConfiguration.DEVICE_TYPE_CO2:  //Co2浓度
                return "PPM";
            case LocalConfiguration.DEVICE_TYPE_LIGHT:  //光照强度
                return "Lx";
            case LocalConfiguration.DEVICE_TYPE_VIDEO:  //视频
            case LocalConfiguration.DEVICE_TYPE_SWITCH:   //开关
            case LocalConfiguration.DEVICE_TYPE_PICTURE:   //图片
            case LocalConfiguration.DEVICE_TYPE_MOSWITCH:  //模拟水阀
            case LocalConfiguration.DEVICE_TYPE_BUSWITCH:  //补光灯
                return "个";
            case LocalConfiguration.DEVICE_TYPE_SoilPH:  //土壤PH
                return "PH";
            case LocalConfiguration.DEVICE_TYPE_WindRainfall:  //风速，风向，雨量
                return "";
        }
        return "";
    }


}