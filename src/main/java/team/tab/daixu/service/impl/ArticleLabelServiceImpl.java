package team.tab.daixu.service.impl;


import org.springframework.stereotype.Service;
import team.tab.daixu.dao.ArticleLabelDao;
import team.tab.daixu.service.ArticleLabelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
    private ArticleLabelDao articleLabelDaoImpl;

    @Override
    public Boolean actSave(long article_id, String mix_article_label) {
//        String[] array_label = mix_article_label.split(",");
//
//        Boolean result_save = articleLabelDaoImpl.act_save(article_id,array_label);
//
//        return result_save;
        return true;
    }
}
