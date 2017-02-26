package team.tab.daixu.dao;

import team.tab.daixu.entity.ArticleLabelEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleLabelDao {
    /**
     * 将数组里的标签依次存到数据库里
     * @param article_id 标签所属文章id
     * @param array_label 一维数组，含有多个标签
     * @return 是否成功
     */
    Boolean act_save(int article_id,String[] array_label);
}
