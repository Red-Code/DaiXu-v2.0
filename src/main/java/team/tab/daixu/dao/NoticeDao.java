package team.tab.daixu.dao;

import team.tab.daixu.entity.NoticeEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface NoticeDao {
    void save(NoticeEntity newsEntity);
    void delete(int id);
    void update(NoticeEntity newsEntity);
    List<NoticeEntity> findByReceiveId(int receive_id);//根据接收者id查询出所有的信息
    List<NoticeEntity> findNewByReceiveId(int receive_id);//根据用户id查询出未读信息
    int findNoSeeByReceiveId(int receive_id);//根据用户id查询出该用户的未读信息数。
}
