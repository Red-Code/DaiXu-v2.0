package team.tab.daixu.util.judge.impl;

import org.springframework.stereotype.Component;
import team.tab.daixu.cons.ArticleRuleRank;
import team.tab.daixu.util.judge.JudgeUtil;

/**
 * Created by CLY on 2017/4/8.
 */
@Component
public class JudgeUtilImpl implements JudgeUtil {
    @Override
    public int getJurisdictionRank(ArticleRuleRank articleRuleRank) {
        int jurisdiction_rank ;
        switch (articleRuleRank){
            case RANK_1://等级1以上的用户能接（包括等级1），即没有限制。
                jurisdiction_rank = 1;
                break;
            case RANK_2:
                jurisdiction_rank = 2;
                break;
            case RANK_3:
                jurisdiction_rank = 3;
                break;
            case RANK_4:
                jurisdiction_rank = 4;
                break;
            case RANK_5:
                jurisdiction_rank = 5;
                break;
            case RANK_6:
                jurisdiction_rank = 6;
                break;
            case RANK_7:
                jurisdiction_rank = 7;
                break;
            case RANK_8:
                jurisdiction_rank = 8;
                break;
            case RANK_9:
                jurisdiction_rank = 9;
                break;
            default:
                jurisdiction_rank = 1;
                break;
        }

        return jurisdiction_rank;
    }
}
