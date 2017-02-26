package team.tab.daixu.dao;

import team.tab.daixu.entity.CollectionEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface CollectionDao {
    void save(CollectionEntity collectionEntity);
    void delete(int id);
    void update(CollectionEntity collectionEntity);
    List<CollectionEntity> findByUserId(int user_id);//根据用户id，查询出他的收藏
}
