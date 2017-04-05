package team.tab.daixu.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.ArticleDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.RtaskEntity;
import team.tab.daixu.entity.UserEntity;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<ArticleEntity> implements ArticleDao {
    @Override
    public ArticleEntity act_save(ArticleEntity articleEntity) {
        return null;
    }

    @Override
    public ArticleEntity getOneById(Integer article_id) {
        String hql = "from ArticleEntity where id="+article_id;//hql语句
        Query query = sessionFactory.getCurrentSession().createQuery(hql);


        List<ArticleEntity> list_article = query.list();

        Serializable ddd = sessionFactory.getCurrentSession().save(list_article.get(0));
        System.out.print("list结构"+list_article.get(0).getName());

//        Session session=sessionFactory.openSession();//打开Session
//        Transaction tx=session.beginTransaction();//开启事务
//        ArticleEntity articleEntity= new ArticleEntity();//实例化对象
//        articleEntity.setArticleName("1231");
//        articleEntity.setArticleContent("enisda");
//        articleEntity.setArticleAuthor(321);
//
//        session.save(articleEntity);
//        tx.commit();//提交事务
//        session.close();//关闭Session

        return null;
    }

    @Override
    public List<ArticleEntity> findHomepageHeadArticle() {
        return null;
    }

    @Override
    public List<ArticleEntity> findArticleNewList(int show_num) {
        return null;
    }

    @Override
    public List<ArticleEntity> findArticleRecommendList(int show_num) {
        return null;
    }

    @Override
    public List<ArticleEntity> findMoreByWhere(Integer begin_limit, String order, Integer rule, int show_num) {
        return null;
    }

    @Override
    public List<ArticleEntity> findMoreByWhere(Integer begin_limit, String order, Integer rule, int show_num, String tag) {
        return null;
    }

    @Override
    public int findPageSum(int show_num) {
        return 0;
    }

    @Override
    public List<ArticleEntity> findMoreByUser(Integer user_id, Integer begin_limit, String order, int show_num, int relate_type) {
        return null;
    }

    @Override
    public int findPageSumByUser(Integer user_id, int show_num, int relate_type) {
        return 0;
    }
}
