package team.tab.daixu.dao;

/**
 * Created by CLY on 2017/4/5.
 */

import team.tab.daixu.util.page.PageUtil;

import java.util.List;

/**
 * dao层顶部接口，提供增删改等公共方法
 * @param <T> 泛型，Entity持久化类对象
 */
public interface BaseDao<T> {
    /**
     * 存储持久化对象
     * @param entity 一个持久化对象
     * @return 是否成功
     */
    boolean save(T entity);

    /**
     * 删除一个持久化对象
     * @param entity 持久化对象
     * @return 是否成功
     */
    boolean delete(T entity);

    /**
     * 更新一个持久化对象
     * @param entity 持久化对象
     * @return 是否成功
     */
    boolean update (T entity);

    /**
     * 根据id，通过get方法获取持久化对象
     * @param id
     * @return 持久化对象
     */
    T getById(long id);

    /**
     * 根据id，通过load方法加载持久化对象
     * @param id
     * @return 持久化对象
     */
    T loadById(long id);

    /**
     * 加载所有持久化对象
     * @return 持久化对象列表
     */
    List<T> loadAll();

    /**
     * 执行hql语句查询，并返回list结果
     * @param hql hql语句
     * @return 结果列表
     */
    List find(String hql);

    /**
     * 执行一个含有占位符的hql查询，并返回list结果
     * @param hql hql语句
     * @param values 占位符所对应的具体属性值
     * @return 查询结果
     */
    List find(String hql,Object... values);

    /**
     * 对延迟加载的持久化对象执行初始化
     * @param entity “延迟加载”的持久化对象
     * @return 是否成功
     */
    boolean initialize(T entity);
}
