package org.system.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.user.User;
import org.system.mapper.user.UserMapper;
import org.system.service.iface.user.IUserService;

import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Author Zhao.Fei
 * @Date 2018/8/10 16:27
 * @Description TODO
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper mapper;

    @Override
    public int insertUser(User user) {
        return mapper.insert(user);
    }

    @Override
    public Map<String, Object> getUserDetail(User user) {
        return mapper.selectOne(user);
    }

    @Override
    public Map<String, Object> getUserIsExists(User user) {
        return mapper.selectIsExists(user);
    }
}
