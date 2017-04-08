package team.tab.daixu.dao;


import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.UserEntity;

import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public interface UserDao extends BaseDao<UserEntity>{
    /**
     * 根据用户邮箱查找用户
     * @param user_email 用户邮箱
     * @return 持久化对象
     */
    UserEntity findByEmail(String user_email);
}
