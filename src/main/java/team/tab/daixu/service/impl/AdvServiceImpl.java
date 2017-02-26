package team.tab.daixu.service.impl;

import team.tab.daixu.dao.AdvDao;
import team.tab.daixu.entity.AdvEntity;
import team.tab.daixu.service.AdvService;

import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
public class AdvServiceImpl implements AdvService {
    private AdvDao advDaoImpl;

    @Override
    public List<AdvEntity> findAll() {
        return advDaoImpl.findAll();
    }
}
