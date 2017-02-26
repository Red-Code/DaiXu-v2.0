package team.tab.daixu.service.impl;

import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public class UserServiceImpl implements UserService {
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
    public Boolean actLogin(String user_email, String password) {
        return null;
    }

    @Override
    public Boolean actEndLogin(int user_id) {
        return null;
    }
}
