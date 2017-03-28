package team.tab.daixu.dao;


import team.tab.daixu.entity.UserEntity;

import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public interface UserDao {
    /**
     * 存储用户
     * @param userEntity 用户持久化类
     * @return true为成功，false为失败
     */
    Boolean save(UserEntity userEntity);

    /**
     * 删除用户
     * @param id 用户id
     * @return true为成功，false为失败
     */
    Boolean delete(int id);

    /**
     * 更新用户信息
     * @param userEntity 持久化类
     * @return true为成功，false为失败
     */
    Boolean update(UserEntity userEntity);

    /**
     * 根据用户id找到具体用户
     * @param id 用户id
     * @return 用户持久化对象
     */
    UserEntity findById(int id);

    /**
     * 根据用户账号查询用户
     * @param email 用户邮箱账号
     * @return 用户持久化类
     */
    UserEntity findByEmail(String email);
}
