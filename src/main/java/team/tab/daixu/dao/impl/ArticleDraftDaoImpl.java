package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.ArticleDraftDao;
import team.tab.daixu.entity.ArticleDraftEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class ArticleDraftDaoImpl implements ArticleDraftDao{
    @Override
    public void save(ArticleDraftEntity articleDraftEntity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(ArticleDraftEntity articleDraftEntity) {

    }

    @Override
    public List<ArticleDraftEntity> findByAuthorId(int author_id) {
        return null;
    }
}
