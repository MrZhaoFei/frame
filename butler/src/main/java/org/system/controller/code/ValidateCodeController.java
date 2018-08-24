package org.system.controller.code;

import jdk.nashorn.internal.objects.Global;
import org.core.result.ResultCode;
import org.core.result.ResultMap;
import org.redis.cache.RedisCacheManager;
import org.redis.token.AuthenticationSession;
import org.redis.token.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.entity.sms.SmsSendRecord;
import org.system.global.BaseGlobal;
import org.system.message.Prompt;
import org.system.service.iface.sms.ISmsSendRecordService;
import org.tools.code.ValidCodeUtils;
import org.tools.md5.MD5Util;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ValidateCodeController
 * @Author Zhao.Fei
 * @Date 2018/8/24 11:00
 * @Description 验证码
 */
@RequestMapping("/code")
@Controller
public class ValidateCodeController {

    private static final Logger logger= LoggerFactory.getLogger(ValidateCodeController.class);

    @Resource
    private ISmsSendRecordService smsSendRecordService;
    @Resource
    private RedisCacheManager cacheManager;

    /**
     * @Author Zhao.Fei
     * @Param [phone]
     * @Date 2018/8/24 12:36
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 根据手机号码生成验证码
     **/
    @RequestMapping(value = {"/phone/{phone}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCodeByPhone(@PathVariable("phone") String phone) {
        /*生成验证码*/
        String code = ValidCodeUtils.generateNumber(6);
        /*TODO 设置缓存*/
        String token = MD5Util.getInstance().getSessionToken(phone);
        Map<String, Object> cache = new HashMap<>();
        cache.put("code", code);
        cache.put("phone", phone);
        /*放入缓存 已实现自动踢出*/
        cacheManager.AuthenticationToken(new AuthenticationToken(BaseGlobal.CACHE_CODE,phone, new AuthenticationSession(token, cache)));
        /*TODO 短信服务器*/
        logger.debug("手机号码:"+phone+" 验证码:"+code+" Token:"+token);

        /* 执行新增短信记录操作 */
        SmsSendRecord sms = new SmsSendRecord();
        sms.setContent(Prompt.bundle("valid.code.valid.model", code));
        sms.setPhone(phone);
        sms.setCreateDate(new Date());
        if (smsSendRecordService.insertSmsSendRecord(sms) > 0) {
            return ResultMap.convertMap(ResultCode.SUCCESS,token, Prompt.bundle("valid.code.send.success"));
        }
        return ResultMap.convertMap(ResultCode.FAIL, Prompt.bundle("valid.code.send.fail"));
    }


}
