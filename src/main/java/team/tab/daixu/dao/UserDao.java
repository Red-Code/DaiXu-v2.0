package team.tab.daixu.dao;


import team.tab.daixu.entity.UserEntity;

import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public interface UserDao {
    void save(UserEntity userEntity);
    void delete(int id);
    void update(UserEntity userEntity);
    UserEntity findById(int id);
    List<UserEntity> findAll();
}
