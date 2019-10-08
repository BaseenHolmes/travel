package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @ClassName UserDao
 * @Description: TODO
 * @Author Baseen
 * @Date Created in 2019/9/28 22:25
 * @Version v1.0
 **/
public interface UserDao {
    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return user对象
     */
    User findByUsername(String username);

    void updateStatus(User user);

    User findUserByCode(String code);

    User findByUsernameAndPassword(User user);

}
