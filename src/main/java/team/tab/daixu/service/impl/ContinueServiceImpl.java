package team.tab.daixu.service.impl;

import org.springframework.stereotype.Service;
import team.tab.daixu.dao.ContinueDao;
import team.tab.daixu.entity.ContinueEntity;
import team.tab.daixu.service.ContinueService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Service
public class ContinueServiceImpl implements ContinueService {
    private ContinueDao continueDaoImpl;
    @Override
    public Boolean save(ContinueEntity continueEntity) {
        return continueDaoImpl.save(continueEntity);
    }

    @Override
    public List<ContinueEntity> findMoreByWhere(Integer article_id, Integer now_layer, int show_num) {
        return null;
    }

    @Override
    public int findPageSum(int show_num, int article_id) {
        return 0;
    }
}
