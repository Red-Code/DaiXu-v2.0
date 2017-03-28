package team.tab.daixu.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import team.tab.daixu.dao.UserDao;
import team.tab.daixu.entity.UserEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public Boolean save(UserEntity userEntity) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    @Override
    public Boolean update(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }
}
