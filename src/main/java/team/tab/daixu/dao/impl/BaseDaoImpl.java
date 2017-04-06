package team.tab.daixu.dao.impl;
/**
 * Created by CLY on 2017/4/5.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import team.tab.daixu.dao.BaseDao;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;//注入sessionFactory

    private Class<T> entityClass;

    //构造方法，通过反射获得子类的“确定的持久化类”，并赋值给entityClass
    public BaseDaoImpl(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        entityClass = (Class)params[0];
    }

    @Override
    public boolean save(T entity) {
        boolean result = false;
        try {
            Session session=sessionFactory.openSession();//打开Session
            Transaction tx=session.beginTransaction();//开启事务
            session.save(entity);
            tx.commit();//提交事务
            session.close();//关闭Session

            result = true;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean delete(T entity) {
        boolean result = false;
        try {
            Session session=sessionFactory.openSession();//打开Session
            Transaction tx=session.beginTransaction();//开启事务
            session.delete(entity);
            tx.commit();//提交事务
            session.close();//关闭Session

            result = true;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public boolean update(T entity) {
        boolean result = false;
        try {
            Session session=sessionFactory.openSession();//打开Session
            Transaction tx=session.beginTransaction();//开启事务
            session.update(entity);
            tx.commit();//提交事务
            session.close();//关闭Session

            result = true;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public T getById(long id) {
        T result = null;
        try {
            Session session=sessionFactory.openSession();//打开Session
            T entity = session.get(entityClass,id);
            result = entity;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public T loadById(long   id) {
        T result = null;
        try {
            Session session=sessionFactory.openSession();//打开Session
            T entity = session.load(entityClass,id);
            result = entity;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<T> loadAll() {
        List<T> result = null;
        try {
            String hql = "from entityClass";//hql语句
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            List<T> list = query.list();
            result = list;
        }catch (Exception e){

        }
        return result;
    }

    @Override
    public List<T> find(String hql) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<T> list = query.list();
        return list;
    }

    @Override
    public boolean initialize(T entity) {
        return true;
    }
}
