package team.tab.daixu.dao.impl;

import org.springframework.stereotype.Repository;
import team.tab.daixu.dao.ContinueDao;
import team.tab.daixu.entity.ContinueEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class ContinueDaoImpl implements ContinueDao {
    @Override
    public Boolean save(ContinueEntity continueEntity) {
        return null;
    }

    @Override
    public List<ContinueEntity> findMoreByWhere(Integer article_id, Integer begin_lilmit, int show_num) {
        return null;
    }

    @Override
    public int findPageSum(int show_num, int article_id) {
        return 0;
    }
}
