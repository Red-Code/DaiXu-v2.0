package team.tab.daixu.service.impl;

import team.tab.daixu.dao.ContinueDao;
import team.tab.daixu.entity.ContinueEntity;
import team.tab.daixu.service.ContinueService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class ContinueServiceImpl implements ContinueService {
    private ContinueDao continueDaoImpl;
    @Override
    public Boolean save(ContinueEntity continueEntity) {
        return continueDaoImpl.save(continueEntity);
    }
}
