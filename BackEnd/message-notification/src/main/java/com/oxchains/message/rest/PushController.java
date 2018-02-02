package com.oxchains.message.rest;

import com.oxchains.message.common.RestResp;
import com.oxchains.message.domain.PushData;
import com.oxchains.message.service.PushService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author luoxuri
 * @create 2018-02-01 14:25
 **/
@RestController
@RequestMapping(value = "/push")
public class PushController {

    @Resource
    private PushService pushService;

    /**
     * 推送给设备标识参数的用户
     * @param pushData 推送数据
     * @return 1or0
     */
    @PostMapping(value = "/registrationId")
    public RestResp pushToRegistrationId(@RequestBody PushData pushData){
        return pushService.pushToRegistrationId(pushData);
    }

    /**
     * 推送给所有android用户
     * @param pushData
     * @return
     */
    @PostMapping(value = "/android")
    public RestResp pushToAllAndroid(@RequestBody PushData pushData){
        return pushService.pushToAllAndroid(pushData);
    }

    /**
     * 推送给所有ios用户
     * @param pushData
     * @return
     */
    @PostMapping(value = "/ios")
    public RestResp pushToAllIos(@RequestBody PushData pushData){
        return pushService.pushToAllIos(pushData);
    }

    @PostMapping(value = "/android-ios")
    public RestResp pushToAndroidAndIos(@RequestBody PushData pushData){
        return pushService.pushToAndroidAndIos(pushData);
    }
}
