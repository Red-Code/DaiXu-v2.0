package team.tab.daixu.dao;

import team.tab.daixu.entity.NewsEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface NewsDao {
    void save(NewsEntity newsEntity);
    void delete(int id);
    void update(NewsEntity newsEntity);
    List<NewsEntity> findByReceiveId(int receive_id);//根据接收者id查询出所有的消息
    List<NewsEntity> findNewByReceiveId(int receive_id);//根据用户id查询出未读消息
    int findNoSeeByReceiveId(int receive_id);//根据用户id查询出该用户的未读消息数。
}
