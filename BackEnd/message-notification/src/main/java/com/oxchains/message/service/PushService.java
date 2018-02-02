package com.oxchains.message.service;

import com.oxchains.message.common.RestResp;
import com.oxchains.message.domain.PushData;
import com.oxchains.message.util.JPushUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author luoxuri
 * @create 2018-02-01 14:31
 **/
@Service
public class PushService {

    private final Logger LOG = LoggerFactory.getLogger(PushService.class);

    public RestResp pushToRegistrationId(PushData pushData) {
        try {
            int result = JPushUtils.sendToRegistrationId(
                    pushData.getRegistrationId(),
                    pushData.getNotificationTitle(),
                    pushData.getNotificationSummary(),
                    pushData.getMsgTitle(),
                    pushData.getMsgContent(),
                    pushData.getExtrasParam());
            if (result == 1){
                return RestResp.success("操作成功");
            }
        } catch (Exception e){
            LOG.error("push to registrationId error", e);
        }
        return RestResp.fail("操作失败");
    }

    public RestResp pushToAllAndroid(PushData pushData) {
        try {
            int result = JPushUtils.sendToAllAndroid(
                    pushData.getNotificationTitle(),
                    pushData.getNotificationSummary(),
                    pushData.getMsgTitle(),
                    pushData.getMsgContent(),
                    pushData.getExtrasParam());
            if (result == 1){
                return RestResp.success("操作成功");
            }
        } catch (Exception e){
            LOG.error("push to all android error", e);
        }
        return RestResp.fail("操作失败");

    }

    public RestResp pushToAllIos(PushData pushData) {
        try {
            int result = JPushUtils.sendToAllIos(
                    pushData.getNotificationTitle(),
                    pushData.getMsgTitle(),
                    pushData.getMsgContent(),
                    pushData.getExtrasParam());
            if (result == 1){
                return RestResp.success("操作成功");
            }
        } catch (Exception e){
            LOG.error("push to all ios error", e);
        }
        return RestResp.fail("操作失败");
    }

    public RestResp pushToAndroidAndIos(PushData pushData) {
        try {
            int result = JPushUtils.sendToAndroidAndIos(
                    pushData.getNotificationTitle(),
                    pushData.getMsgTitle(),
                    pushData.getMsgContent(),
                    pushData.getExtrasParam());
            if (result == 1){
                return RestResp.success("操作成功");
            }
        } catch (Exception e){
            LOG.error("push to android and ios error", e);
        }
        return RestResp.fail("操作失败");
    }
}
