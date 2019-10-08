package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author Baseen
 * @Date Created in 2019/9/28 22:27
 * @Version v1.0
 **/
public interface UserService {
    /**
     * 注册
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
