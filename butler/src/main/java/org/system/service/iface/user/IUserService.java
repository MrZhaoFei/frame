package org.system.service.iface.user;

import org.system.entity.User;

import java.util.Map;

/**
 * @ClassName IUserService
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:25
 * @Description TODO
 */
public interface IUserService {

    /**
     * @Author Zhao.Fei
     * @Param [user]
     * @Date 2018/8/10 16:26
     * @return int
     * @Description  新增用户
     **/
    public int insertUser(User user);

    /**
     * @Author Zhao.Fei
     * @Param [user]
     * @Date 2018/8/10 17:11
     * @return int
     * @Description 查询用户详情
     **/
    public Map<String,Object> getUserDetail(User user);

}
