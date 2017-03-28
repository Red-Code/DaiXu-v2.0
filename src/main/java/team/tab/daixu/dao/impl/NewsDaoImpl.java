package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.NewsDao;
import team.tab.daixu.entity.NewsEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class NewsDaoImpl implements NewsDao {
    @Override
    public void save(NewsEntity newsEntity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(NewsEntity newsEntity) {

    }

    @Override
    public List<NewsEntity> findByReceiveId(int receive_id) {
        return null;
    }

    @Override
    public List<NewsEntity> findNewByReceiveId(int receive_id) {
        return null;
    }

    @Override
    public int findNoSeeByReceiveId(int receive_id) {
        return 0;
    }
}
