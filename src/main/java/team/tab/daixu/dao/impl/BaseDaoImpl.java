package team.tab.daixu.dao.impl;
/**
 * Created by CLY on 2017/4/5.
 */

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.util.Assert;
import team.tab.daixu.dao.BaseDao;
import team.tab.daixu.util.page.PageUtil;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * dao层顶部抽象基类，结合反射提供常用方法，且提供分页相关方法给其他子类dao使用。
 * @param <T> 具体的持久化类
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;//注入sessionFactory
    @Resource(name = "pageUtilImpl")
    private PageUtil pageUtilImpl;

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
    public List find(String hql) {
        Query query = creatQuery(hql,null);

        List list = query.list();
        return list;
    }

    @Override
    public List find(String hql,Object... values) {
        Query query = creatQuery(hql,values);

        List list = query.list();
        return list;
    }

    @Override
    public boolean initialize(T entity) {
        boolean result = false;
        try {
            Hibernate.initialize(entity);

            result = true;
        }catch (Exception e){

        }
        return result;
    }

    /**
     * 内部方法。根据hql语句和分页条件，查询出所需页面的记录列表并装入pageutil对象中，返回pageutil
     * @param hql 查询语句，里面使用占位符对关键属性进行站位
     * @param pageNo 查询页数
     * @param pageSize 每页展示记录的数量
     * @param values 占位符所对应的具体属性值（顺序与占位符顺序一致，是个数组）
     * @return 含有分页信息和当前页数据列表的pageutil
     */
    protected PageUtil pagedQuery(String hql,int pageNo,int pageSize,Object... values){
        //Assert是spring提供的“断言工具”，Assert.hasText判断其传入参数不能为null，且至少包含一个非空字符。
        Assert.hasText(hql,"hql语句有错");
        Assert.isTrue(pageNo>=1,"当前页数不能小于1");
        Assert.isTrue(pageSize>=0,"每页展示数不能小于0");

        //将每页展示数存入page对象。
        pageUtilImpl.setPageSize(pageSize);

        //根据条件，查询存在的条目“总数”,并将总数存入page对象
        String countHql = "select count(*)"+removeSelect(removeOrder(hql));
        List countList = find(countHql,values);
        long totalCount = (Long)countList.get(0);
        pageUtilImpl.setTotalCount(totalCount);

        //没有查询到数据，传一个空的分页对象。
        if (totalCount<1){
            return pageUtilImpl;
        }

        //找到该页第一条数据的查询起始位，并存入page类
        int startIndex = pageUtilImpl.getStartOfPage(pageNo,pageSize);
        pageUtilImpl.setStart(startIndex);

        //查询出该页数据，并存入page类。
        Query query = creatQuery(hql, values);
        List date_list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();//设置查询的起始位，和查询条数，然后再查询。
        pageUtilImpl.setDateList(date_list);

        return pageUtilImpl;
    }

    /**
     * 将hql语句以及它的占位符值，装进query并返回query对象
     * @param hql hql语句
     * @param values 占位符所对应具体值
     * @return 装有hql语句的query对象
     */
    protected Query creatQuery(String hql,Object... values){
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        for (int i=0;i<values.length;i++){
            query.setParameter(i,values);
        }
        return query;
    }

    /**
     * 去除hql语句中的select子句（为count计算做准备）
     * @param hql 待处理的hql语句
     * @return 已处理的hql语句
     */
    private String removeSelect(String hql){
        //如果存在select子句，则该字句一定存在于“from”关键字之前。

        /**
         * 找到from关键字的位置。删除该位置之前的所有内容
         * toLowCase()：将字符串中所有的大写字符转化成小写字符，返回转化后的string
         * indexOf(String str)：返回str在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
         */
        int pos = hql.toLowerCase().indexOf("from");
        Assert.isTrue(pos!=-1,"hql语句必须包含“from”关键字");

        /**
         * str.substring(int i)：
         * 截取掉str从首字母起长度为i的字符串，将剩余字符串赋值给str
         */
        return hql.substring(pos);
    }

    /**
     * 去除hql语句中的order by子句（为count计算做准备）
     * @param hql 待处理的hql语句
     * @return 已处理的hql语句
     */
    private String removeOrder(String hql){
        //创建一个正则的匹配模式，Pattern.CASE_INSENSITIVE是“启用不区分大小写的匹配”
        Pattern pattern = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]]",Pattern.CASE_INSENSITIVE);
        //matcher相当于一个状态机器，一个Matcher实例在这个给定的Pattern实例的模式控制下进行字符串的匹配工作。
        Matcher matcher = pattern.matcher(hql);

        /**
         * String是一个不可变的对象，每次对string的更改等同于生成了一个新string对象，然后指针指向新string对象。
         * StringBuffer每次的结果操作是对StringBuffer对象本身进行操作，不会生成新对象。
         * 所以如果是经常更改的字符串，推荐用stringBuffer类型（比如此时）
         * 此stringBuffer用来存储替换过的内容
         */
        StringBuffer stringBuffer = new StringBuffer();

        /**
         * find()与while结合，每次循环会找到一个符合匹配条件的结果。
         * 如Matcher m = Pattern.compile("//w+").matcher("AAA bbb CcC");
         * while(m.find())
                System.out.println(m.group());
         第一次循环匹配出“AAA”，之后继续···
         结果就是：
         AAA
         bbb
         CcC
         */
        while (matcher.find()){
            //在Matcher.find()找到匹配的地方用“”替换掉，然后将替换后的结果加进StringBuffer中去
            matcher.appendReplacement(stringBuffer,"");
        }
        //这时可能还有字符串但是不匹配的没有加入stringBuffer，
        //matcher.appendTail(stringBuffer);的目的就是将这些字符串加入stringBuffer构成完整字符串
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
