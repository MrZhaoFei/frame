package org.system.controller.user;

import org.core.entity.BaseEntity;
import org.core.result.ResultCode;
import org.core.result.ResultMap;
import org.redis.cache.RedisCacheManager;
import org.redis.token.AuthenticationSession;
import org.redis.token.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.entity.User;
import org.system.global.BaseGlobal;
import org.system.service.iface.user.IUserService;
import org.tools.md5.MD5Util;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:16
 * @Description 用户信息
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Resource
    private RedisCacheManager cacheManager;

    /**
     * @Author Zhao.Fei
     * @Param [user, result]
     * @Date 2018/8/10 16:22
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description 新增用户
     **/
    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Map<String, Object> insertUser(@RequestBody @Validated({BaseEntity.Insert.class}) User user, BindingResult result) {

        /*新增用户*/
        if (userService.insertUser(user) > 0) {
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
