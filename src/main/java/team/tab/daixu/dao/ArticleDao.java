package team.tab.daixu.dao;

import team.tab.daixu.entity.ArticleEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleDao {
    /**
     * 将文章持久化对象存入数据库
     * @param articleEntity 持久化对象
     * @return 存储成功的持久化类对象,失败返回null
     */
    ArticleEntity act_save(ArticleEntity articleEntity);

    /**
     * 根据id查询具体文章的首部信息
     * @param article_id 文章id
     * @return 单个文章持久化类对象
     */
    ArticleEntity findOneById(Integer article_id);
}