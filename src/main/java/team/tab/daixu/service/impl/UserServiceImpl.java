package team.tab.daixu.service.impl;

import org.springframework.stereotype.Service;
import team.tab.daixu.dao.UserDao;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.UserService;
import team.tab.daixu.util.password.PasswordUtil;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDaoImpl")
    private UserDao userDaoImpl;

    @Resource(name = "passwordUtilImpl")
    private PasswordUtil passwordUtilImpl;

    @Override
    public Boolean save(UserEntity userEntity) {
        return null;
    }

    @Override
    public List<UserEntity> findRecommendAuthor() {
        return null;
    }

    @Override
    public UserEntity findOneById(Integer user_id) {
        return null;
    }

    @Override
    public List<UserEntity> findFollowListById(Integer user_id) {
        return null;
    }

    @Override
    public Boolean actLogin(String user_email, String password, HttpServletRequest request, HttpServletResponse response) {
        UserEntity userEntity = userDaoImpl.findByEmail(user_email);

        String user_password = userEntity.getPassword();//数据库中的用户密码
        String get_psw_md5 = passwordUtilImpl.encrypted(password);//将传入密码进行md5加密

        if (user_password == get_psw_md5){//比较传入密码是否正确
            long user_id = userEntity.getId();

            //根据用户id生成一个盐值，每次发送id都将该盐值也发送过去，当下次接收cookie时判断该盐值是否正确，如果不正确就表示被篡改了
            String user_salt = passwordUtilImpl.encrypted(user_id+"user_id");

            Cookie cookie = new Cookie("user_id",user_id+"|"+user_salt);
            cookie.setMaxAge(720 * 60);// 12h
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean actEndLogin(HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
            return false;
        } else {
            for(Cookie cookie : cookies){
                //如果找到同名cookie，就将value设置为null，将存活时间设置为0，再替换掉原cookie，这样就相当于删除了。
                if(cookie.getName().equals("user_name")){
                    String[] cookie_value = cookie.getValue().split("//|");

                    String user_id = cookie_value[0];
                    String salt = cookie_value[1];

                    if (salt== passwordUtilImpl.encrypted(user_id+"user_id")){
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        return true;
                    }else {
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
