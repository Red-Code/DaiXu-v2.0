package team.tab.daixu.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import team.tab.daixu.dao.ArticleDao;
import team.tab.daixu.entity.ArticleEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class ArticleDaoImpl implements ArticleDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;//注入sessionFactory

    @Override
    public ArticleEntity act_save(ArticleEntity articleEntity) {
        return null;
    }

    @Override
    public ArticleEntity findOneById(Integer article_id) {
        String hql = "from ArticleEntity where articleId="+article_id;//hql语句
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<ArticleEntity> list_article = query.list();
        System.out.print("list结构"+list_article.get(0).getArticleName());

        return null;
    }
}
