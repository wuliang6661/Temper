package com.myp.meiyuan.api;

import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.entity.MonitorBo;

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

    String URL = "http://120.27.133.127/";   //测试服


    @GET("xiaokedou1/equipment/getDataDevicesByGroupId")
    Observable<List<DeviceBO>> getDeviceGroup(@Query("params") String params);


    @GET("/xiaokedou1/device/searchOneDevice")
    Observable<List<MonitorBo>> getSearchList(@Query("params") String params);


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

}
