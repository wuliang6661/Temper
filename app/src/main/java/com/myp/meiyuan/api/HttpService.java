package com.myp.meiyuan.api;

import com.myp.meiyuan.entity.DataBo;
import com.myp.meiyuan.entity.DeviceAndGroupBo;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.entity.OperationRecoderBo;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.entity.VideoBo;
import com.myp.meiyuan.entity.WaitRecoderBo;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wuliang on 2017/3/9.
 * <p>
 * 此处存放后台服务器的所有接口数据
 */

public interface HttpService {

    String URL = "http://120.27.133.127";   //测试服


    @GET("/xiaokedou1/equipment/getDataDevicesByGroupId")
    Observable<List<DeviceBO>> getDeviceGroup(@Query("params") String params);


    @GET("/xiaokedou1/device/searchOneDevice")
    Observable<DataBo> getSearchList(@Query("params") String params);


    /**
     * 获取控制数据
     */
    @GET("/xiaokedou1/equipment/getAllSwitchDevicesByGroupId")
    Observable<List<FamenBo>> getFamenList(@Query("params") String params);

    /**
     * 获取大棚列表
     */
    @GET("/xiaokedou1/equipment/getAllgroups")
    Observable<List<GroupBO>> getGroupList(@Query("params") String params);

    /**
     * 修改名称
     */
    @GET("/xiaokedou1/equipment/updateGroupName")
    Observable<Object> updateName(@Query("params") String params);

    /**
     * 修改控制详情
     */
    @GET("/xiaokedou1/equipment/updateSwitchDevice")
    Observable<Object> updateControl(@Query("params") String params);


    /**
     * 获取用户信息
     */
    @GET("/xiaokedou1/user/getUserInfo")
    Observable<UserBo> getUserMessage(@Query("params") String params);

    /**
     * 修改个人信息
     */
    @GET("/xiaokedou1/user/updateUser")
    Observable<String> updateUser(@Query("params") String params);

    /**
     * 修改密码
     */
    @GET("/xiaokedou/user/updatePassword")
    Observable<ResultBo> updatePassWord(@Query("params") String params);

    /**
     * 上传头像
     */
    @FormUrlEncoded
    @POST("/xiaokedou1/user/uploadImg")
    Observable<ResultBo> updateUserImg(@Field("params") String params);


    /**
     * 获取告警记录
     */
    @GET("/xiaokedou1/message/alarminfo")
    Observable<List<WaitRecoderBo>> getWaitRecoder(@Query("params") String params);

    /**
     * 获取操作记录
     */
    @GET("/xiaokedou1/historyBrowseController/getHistroy")
    Observable<List<OperationRecoderBo>> getOperationRecoder(@Query("params") String params);

    /**
     * 获取红外入侵记录
     */
    @GET("/xiaokedou1/message/invadeInfo")
    Observable<List<WaitRecoderBo>> getInvadeInfo(@Query("params") String params);


    /**
     * 获取设备名称和所属分组
     */
    @GET("/xiaokedou1/equipment/getAllNumericDevices")
    Observable<List<DeviceAndGroupBo>> getAllNumDevices(@Query("params") String params);

    /**
     * 修改设备名称和所属分组
     */
    @GET("/xiaokedou1/equipment/updatecDeviceName")
    Observable<String> updateDeviceName(@Query("params") String params);

    /**
     * 登录
     */
    @GET("/xiaokedou1/user/login")
    Observable<String> userLogin(@Query("params") String params);

    /**
     * 添加设备
     */
    @GET("/xiaokedou1/equipment/addNumericDevices")
    Observable<ResultBo> addDevices(@Query("params") String params);

    /**
     * 获取视频列表
     */
    @GET("/xiaokedou1/equipment/getAllVideoDevicesByGroupId")
    Observable<List<VideoBo>> getVideoList(@Query("params") String params);


}
