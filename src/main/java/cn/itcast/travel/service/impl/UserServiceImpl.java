package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author Baseen
 * @Date Created in 2019/9/28 22:27
 * @Version v1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u = userDao.findByUsername(user.getName());
        if (u != null) {
            return false;
        }

        //设置激活码与激活状态
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());

        //保存用户信息
        userDao.save(user);

        //发送邮件
        String mailText = "<a href='https://localhost:8080/travel/activeUserServlet?code="+ user.getCode() +"'>点击这里激活</a>";
        MailUtils.sendMail("745182569@qq.com",mailText,"测试激活邮件");

        return true;
    }

    /**
     * 激活用户
     * @param code
     * @return 激活是否成功
     */
    @Override
    public boolean active(String code) {
        //根据激活码查找用户
        User user = userDao.findUserByCode(code);
        //如果返回的user不为空则找到了当前用户信息，执行激活标志设置
        if(user != null){
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user);
    }

}
