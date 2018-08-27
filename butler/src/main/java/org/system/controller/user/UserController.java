package org.system.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.core.entity.BaseEntity;
import org.core.result.ResultCode;
import org.core.result.ResultMap;
import org.redis.cache.RedisCacheManager;
import org.redis.token.AuthenticationSession;
import org.redis.token.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.entity.user.User;
import org.system.global.BaseGlobal;
import org.system.message.Prompt;
import org.system.service.iface.user.IUserService;
import org.tools.md5.MD5Util;

/**
 * @ClassName UserController
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:16
 * @Description 用户信息
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @Resource
    private RedisCacheManager cacheManager;

    /***
     * @Author Zhao.Fei
     * @Param [verifyCode,验证码
     * user, result]
     * @Date 2018/8/24 10:20
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 用户手机注册
     **/
    @RequestMapping(value = {"/register/{verifyCode}"}, method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Map<String, Object> userRegister(@PathVariable("verifyCode") String verifyCode,@Validated({User.UserRegister.class}) @RequestBody User user, BindingResult result,
                                            @RequestHeader(value = BaseGlobal.TOKEN_FLAG) String token) {
        logger.info("**这是日志");
        /*TODO 通过电话获取缓存验证码*/
        AuthenticationSession session = cacheManager
                .getSession(new AuthenticationToken(BaseGlobal.CACHE_CODE, token));
        if (session==null){
            /*TODO 等待修改为拦截器*/
            return ResultMap.convertMap(ResultCode.FAIL, Prompt.bundle("valid.code.data.empty"));
        }
        String code = (String) session.get(Map.class).get("code");
        logger.info("验证码："+code);
        /*TODO 判断用户是否已经注册*/
        Map<String,Object> userIsExistsMap=userService.getUserIsExists(user);
        if (userIsExistsMap!=null && userIsExistsMap.size()>0){
            return ResultMap.convertMap(ResultCode.DATA_EXIST, Prompt.bundle("user.data.exists"));
        }
        /*设置默认属性*/
        user.setCreateDate(new Date());
        /*注册新增用户*/
        if (userService.insertUser(user) > 0) {
            /*移除验证码缓存*/
            cacheManager.removeAuthenticationToken(new AuthenticationToken(BaseGlobal.CACHE_CODE,token));
            return ResultMap.convertMap(ResultCode.SUCCESS);
        } else {
            return ResultMap.convertMap(ResultCode.FAIL);
        }

    }

    /**
     * @Author Zhao.Fei
     * @Param [userId, user, result]
     * @Date 2018/8/10 17:12
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description  查询用户详情
     **/
    @RequestMapping(value = {"/{userId}"},method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserDetail(@PathVariable("userId") Integer userId, @Validated(BaseEntity.SelectOne.class) User user, BindingResult result) {
    	logger.debug("debug日志****");
    	logger.info("info日志****");
    	logger.error("error日志****");
    	System.out.println("jjjjjjj");
    	System.out.println(5/0);
    	
        user.setId(userId);
        /*查询用户详情*/
        Map<String, Object> resultMap = userService.getUserDetail(user);
        if (resultMap != null && resultMap.size() > 0) {
            String token = MD5Util.getInstance().getSessionToken(resultMap.get("id"));
            // 放入缓存 已实现自动踢出
            cacheManager.AuthenticationToken(new AuthenticationToken(BaseGlobal.CACHE_USER,
                    resultMap.get("id").toString(), new AuthenticationSession(token, resultMap)));
            Map<String, Object> cache = new HashMap<>();
            cache.put("info", resultMap);
            cache.put("token", token);
            return ResultMap.convertMap(ResultCode.SUCCESS, cache);
        } else {
            return ResultMap.convertMap(ResultCode.FAIL);
        }
    }
}
