package com.myp.meiyuan.api;

import com.myp.meiyuan.base.MyApplication;
import com.myp.meiyuan.config.LocalConfiguration;
import com.myp.meiyuan.entity.DataBo;
import com.myp.meiyuan.entity.DeviceAndGroupBo;
import com.myp.meiyuan.entity.DeviceBO;
import com.myp.meiyuan.entity.FamenBo;
import com.myp.meiyuan.entity.GroupBO;
import com.myp.meiyuan.entity.OperationRecoderBo;
import com.myp.meiyuan.entity.ResultBo;
import com.myp.meiyuan.entity.UserBo;
import com.myp.meiyuan.entity.WaitRecoderBo;
import com.myp.meiyuan.util.MD5;
import com.myp.meiyuan.util.StringUtils;
import com.myp.meiyuan.util.rx.RxResultHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import rx.Observable;

/**
 * Created by wuliang on 2017/4/19.
 * <p>
 * 所有网络请求方法
 */

public class HttpServiceIml {

    private static HttpService service;

    /**
     * 获取代理对象
     */
    private static HttpService getService() {
        if (service == null)
            service = ApiManager.getInstance().configRetrofit(HttpService.class, HttpService.URL);
        return service;
    }


    /**
     * 获取设备列表
     */
    public static Observable<List<DeviceBO>> getDeviceList(String groupId) {
        JSONObject object = new JSONObject();
        try {
            object.put("groupId", groupId);
            return getService().getDeviceGroup(object.toString()).compose(RxResultHelper.<List<DeviceBO>>httpResult01());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 获取设备检测状态
     */
    public static Observable<DataBo> getDeviceSearch(String deviceTypeId, String deviceId, String timeGap) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("deviceTypeId", deviceTypeId);
            object.put("deviceId", deviceId);
            object.put("timeGap", timeGap);
            return getService().getSearchList(object.toString()).compose(RxResultHelper.<DataBo>httpResult01());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 获取阀门列表
     */
    public static Observable<List<FamenBo>> getFamenList(String groupId) {
        JSONObject object = new JSONObject();
        try {
            object.put("groupId", groupId);
            return getService().getFamenList(object.toString()).compose(RxResultHelper.<List<FamenBo>>httpResult01());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取大棚列表
     */
    public static Observable<List<GroupBO>> getGroupList() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getGroupList(object.toString()).compose(RxResultHelper.<List<GroupBO>>httpResult01());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改大棚名称
     */
    public static Observable<Object> updateGroupName(String groupId, String groupName) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("groupId", groupId);
            object.put("groupName", groupName);
            return getService().updateName(object.toString()).compose(RxResultHelper.httpResult01());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改控制详情
     */
    public static Observable<Object> updateControl(String deviceTypeId, String deviceId, String switchStatus, String lastStatusChangeTime, String mode,
                                                   String timeParameters, String timeStatus, String firstLetter) {
        JSONObject object = new JSONObject();
        try {
            object.put("deviceTypeId", deviceTypeId);
            object.put("deviceId", deviceId);
            if (!StringUtils.isEmpty(switchStatus)) {
                object.put("switchStatus", switchStatus);
            }
            object.put("lastStatusChangeTime", lastStatusChangeTime);
            object.put("mode", mode);
            object.put("timeParameters", timeParameters);
            object.put("timeStatus", timeStatus);
            object.put("firstLetter", firstLetter);
            return getService().updateControl(object.toString()).compose(RxResultHelper.httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取告警记录
     */
    public static Observable<List<WaitRecoderBo>> getWaitRecoders() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getWaitRecoder(object.toString()).compose(RxResultHelper.<List<WaitRecoderBo>>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取操作记录
     */
    public static Observable<List<OperationRecoderBo>> getOperationRecoders() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getOperationRecoder(object.toString()).compose(RxResultHelper.<List<OperationRecoderBo>>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取红外入侵记录
     */
    /**
     * 获取告警记录
     */
    public static Observable<List<WaitRecoderBo>> getInvation() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getInvadeInfo(object.toString()).compose(RxResultHelper.<List<WaitRecoderBo>>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 修改密码
     */
    public static Observable<ResultBo> updatePassWord(String oldPassword, String newPassword, String newPassword2) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("oldPassword", MD5.strToMd5Low32(oldPassword));
            object.put("newPassword", MD5.strToMd5Low32(newPassword));
            object.put("newPassword2", MD5.strToMd5Low32(newPassword2));
            return getService().updatePassWord(object.toString()).compose(RxResultHelper.<ResultBo>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取个人信息
     */
    public static Observable<UserBo> getUserMessage() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getUserMessage(object.toString()).compose(RxResultHelper.<UserBo>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取设备名称和所属分组
     */
    public static Observable<List<DeviceAndGroupBo>> getDeviceAndGroup() {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            return getService().getAllNumDevices(object.toString()).compose(RxResultHelper.<List<DeviceAndGroupBo>>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改设备名称和分组
     */
    public static Observable<String> udpateDeviceName(String deviceId, String deviceTypeId, String groupId, String deviceName) {
        JSONObject object = new JSONObject();
        try {
            object.put("deviceId", deviceId);
            object.put("deviceTypeId", deviceTypeId);
            object.put("groupId", groupId);
            object.put("deviceName", deviceName);
            return getService().updateDeviceName(object.toString()).compose(RxResultHelper.<String>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 登录接口
     */
    public static Observable<String> userLogin(String userName, String password) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", userName);
            object.put("password", MD5.strToMd5Low32(password));
            return getService().userLogin(object.toString()).compose(RxResultHelper.<String>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改用户信息
     */
    public static Observable<String> updateUser(String realName, String gender, String telPhone,
                                                String mobile, String email,
                                                String company, String dept, String address,
                                                String addressDetail) {
        JSONObject object = new JSONObject();
        try {
            object.put("userName", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("realName", realName);
            object.put("gender", gender);
            object.put("telPhone", telPhone);
            object.put("mobile", mobile);
            object.put("email", email);
            object.put("company", company);
            object.put("dept", dept);
            object.put("address", address);
            object.put("addressDetail", addressDetail);
            return getService().updateUser(object.toString()).compose(RxResultHelper.<String>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 上传用户头像
     */
    public static Observable<ResultBo> updateUserImage(String photo) {
        JSONObject object = new JSONObject();
        try {
            object.put("username", MyApplication.sp.getString(LocalConfiguration.userName));
            object.put("photo", photo);
            return getService().updateUserImg(object.toString()).compose(RxResultHelper.<ResultBo>httpResult01());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
