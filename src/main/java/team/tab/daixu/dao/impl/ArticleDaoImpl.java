package team.tab.daixu.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import team.tab.daixu.cons.ArticleRuleRank;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.UserJoinType;
import team.tab.daixu.dao.ArticleDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.RtaskEntity;
import team.tab.daixu.entity.UserEntity;
import team.tab.daixu.util.page.PageUtil;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by CLY on 2017/1/5.
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImpl<ArticleEntity> implements ArticleDao {
    //按文章总楼数降序排列
    private final String GET_HOT="from ArticleEntity order by total desc";
    //按文章的更新时间降序排列
    private final String GET_NEW="from ArticleEntity order by update desc";
    //是精品文章，且按文章的更新时间降序排列
    private final String GET_FINE_NEW="from ArticleEntity where fine=2 order by update desc";
    //按等级限制，按文章的更新时间降序排列
    private final String GET_RANK_NEW="from ArticleEntity where jurisdiction=? order by update desc";
    //按等级限制，按文章总楼数降序排列
    private final String GET_RANK_HOT="from ArticleEntity where jurisdiction=? order by total desc";
    //按等级限制，按标签限制，按文章的更新时间降序排列
    private final String GET_RANK_LABLE_NEW="from ArticleEntity a,ArticleLabelEntity ab where a.jurisdiction=? and ab.label=? and a.id=ab.articleId order by a.update desc";
    //按等级限制，按标签限制，按文章总楼数降序排列
    private final String GET_RANK_LABLE_HOT="from ArticleEntity a,ArticleLabelEntity ab where a.jurisdiction=? and ab.label=? and a.id=ab.articleId order by a.total desc";
    //某用户发布的文章，按文章的更新时间降序排列
    private final String GET_USER_NEW="";
    //某用户续写的文章，按文章总楼数降序排列
    private final String GET_USER_HOT="";

    @Override
    public List<ArticleEntity> findHomepageHeadArticle(int show_num) {
        List<ArticleEntity> date_list = find(GET_HOT, 0, show_num);
        return date_list;
    }

    @Override
    public List<ArticleEntity> findArticleNewList(int show_num) {
        List<ArticleEntity> date_list = find(GET_NEW, 0, show_num);
        return date_list;
    }

    @Override
    public List<ArticleEntity> findArticleRecommendList(int show_num) {
        List<ArticleEntity> date_list = find(GET_FINE_NEW, 0, show_num);
        return date_list;
    }

    @Override
    public PageUtil findMoreByWhere(int now_page, OrderConstent order, ArticleRuleRank rule_rank, int show_num) {
        PageUtil pageUtil;
        int jurisdictionRank = judgeUtilImpl.getJurisdictionRank(rule_rank);

        switch (order){
            case ORDER_NEW:
                pageUtil = pagedQuery(GET_RANK_NEW,now_page,show_num,jurisdictionRank);
                break;
            case ORDER_HOT:
                pageUtil = pagedQuery(GET_RANK_HOT,now_page,show_num,jurisdictionRank);
                break;
            default:
                pageUtil = pagedQuery(GET_RANK_NEW,now_page,show_num,jurisdictionRank);
                break;
        }
        return pageUtil;
    }

    @Override
    public PageUtil findMoreByWhere(int now_page, OrderConstent order, ArticleRuleRank rule_rank, int show_num, String tag) {
        PageUtil pageUtil;
        int jurisdictionRank = judgeUtilImpl.getJurisdictionRank(rule_rank);

        switch (order){
            case ORDER_NEW:
                pageUtil = pagedQuery(GET_RANK_LABLE_NEW,now_page,show_num,jurisdictionRank,tag);
                break;
            case ORDER_HOT:
                pageUtil = pagedQuery(GET_RANK_LABLE_HOT,now_page,show_num,jurisdictionRank,tag);
                break;
            default:
                pageUtil = pagedQuery(GET_RANK_LABLE_NEW,now_page,show_num,jurisdictionRank,tag);
                break;
        }
        return pageUtil;
    }

    @Override
    public PageUtil findMoreByUser(long user_id, int now_page, OrderConstent order, int show_num, UserJoinType relate_type) {
        PageUtil pageUtil;

        switch (order){
            case ORDER_NEW:
                pageUtil = pagedQuery(GET_RANK_NEW,now_page,show_num);
                break;
            case ORDER_HOT:
                pageUtil = pagedQuery(GET_RANK_HOT,now_page,show_num);
                break;
            default:
                pageUtil = pagedQuery(GET_RANK_NEW,now_page,show_num);
                break;
        }
        return pageUtil;
    }
}
