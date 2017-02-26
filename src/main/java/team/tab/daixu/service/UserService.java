package team.tab.daixu.service;


import team.tab.daixu.entity.UserEntity;

import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public interface UserService {
    /**
     * 创建新用户
     * @param userEntity 用户实例对象
     * @return 成功为真
     */
    Boolean save(UserEntity userEntity);

    /**
     * 查找推荐作者列表（有五人）
     * @return 推荐作者列表
     */
    List<UserEntity> findRecommendAuthor();

    /**
     * 根据用户id查询用户信息
     * @param user_id 用户id
     * @return 用户持久化类
     */
    UserEntity findOneById(Integer user_id);

    /**
     * 根据用户id，查询出该用户所关注的人的列表
     * @param user_id 用户id
     * @return 被关注的人（列表）
     */
    List<UserEntity> findFollowListById(Integer user_id);

    /**
     * 登录
     * @param user_email 用户邮箱
     * @param password 用户密码
     * @return 结果
     */
    Boolean actLogin(String user_email,String password);

    /**
     * 使用户退出登录
     * @param user_id 用户id
     * @return 操作结果
     */
    Boolean actEndLogin(int user_id);
}
