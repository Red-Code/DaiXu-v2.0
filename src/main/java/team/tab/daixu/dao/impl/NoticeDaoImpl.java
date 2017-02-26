package team.tab.daixu.dao.impl;

import team.tab.daixu.dao.NoticeDao;
import team.tab.daixu.entity.NoticeEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class NoticeDaoImpl implements NoticeDao {
    @Override
    public void save(NoticeEntity newsEntity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(NoticeEntity newsEntity) {

    }

    @Override
    public List<NoticeEntity> findByReceiveId(int receive_id) {
        return null;
    }

    @Override
    public List<NoticeEntity> findNewByReceiveId(int receive_id) {
        return null;
    }

    @Override
    public int findNoSeeByReceiveId(int receive_id) {
        return 0;
    }
}
