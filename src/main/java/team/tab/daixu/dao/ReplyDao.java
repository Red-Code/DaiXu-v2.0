package team.tab.daixu.dao;

import team.tab.daixu.entity.ReplyEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ReplyDao {
    void save(ReplyEntity replyEntity);
    void delete(int id);
    void update(ReplyEntity replyEntity);
    List<ReplyEntity> findByLayer(int layer_id);//根据层id，查询出该层的回复总数
}
