package team.tab.daixu.dao;

import team.tab.daixu.entity.ArticleDraftEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleDraftDao {
    void save(ArticleDraftEntity articleDraftEntity);
    void delete(int id);
    void update(ArticleDraftEntity articleDraftEntity);
    List<ArticleDraftEntity> findByAuthorId(int author_id);//根据用户id查询出这个用户的全部草稿
}
