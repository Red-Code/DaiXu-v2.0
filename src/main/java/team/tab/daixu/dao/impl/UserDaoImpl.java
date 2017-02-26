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
    public void save(UserEntity userEntity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(UserEntity userEntity) {

    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

//    @Resource(name = "sessionFactory")
//    private SessionFactory sessionFactory;//注入sessionFactory
//
//    @Override
//    public List<UserEntity> select_user() {
//        String hql = "from UserEntity";//hql语句
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//
//        return query.list();
//    }
}
