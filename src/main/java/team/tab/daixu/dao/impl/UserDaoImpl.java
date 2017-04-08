package team.tab.daixu.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.UserDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.UserEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2016/12/26.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {

}
