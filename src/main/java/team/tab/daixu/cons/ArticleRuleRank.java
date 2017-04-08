package team.tab.daixu.cons;

/**
 * Created by CLY on 2017/4/7.
 */

/**
 * 文章规则：
 * 进行续写用户的等级限制，只有规定登记以上的用户才能进行该文章的续写。
 */
public enum ArticleRuleRank {
    RANK_1,//等级1以上的用户能接（包括等级1），即没有限制。
    RANK_2,//等级2以上用户能接（包括等级2）
    RANK_3,
    RANK_4,
    RANK_5,
    RANK_6,
    RANK_7,
    RANK_8,
    RANK_9;
}
