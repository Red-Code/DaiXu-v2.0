package team.tab.daixu.service;

import team.tab.daixu.entity.ArticleLabelEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleLabelService {
    /**
     * 储存文章标签
     * @param article_id 文章id
     * @param mix_article_label 文章标签（每个标签之间用逗号隔开）
     * @return 是否成功
     */
    Boolean actSave(long article_id,String mix_article_label);
}
