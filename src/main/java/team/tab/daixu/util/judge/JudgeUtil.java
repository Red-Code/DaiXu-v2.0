package team.tab.daixu.util.judge;

import team.tab.daixu.cons.ArticleRuleRank;

/**
 * Created by CLY on 2017/4/8.
 */
public interface JudgeUtil {
    /**
     * 根据传入的等级限制，返回具体的限制级数。
     * @param articleRuleRank 等级限制枚举
     * @return 具体限制级数
     */
    int getJurisdictionRank(ArticleRuleRank articleRuleRank);
}
