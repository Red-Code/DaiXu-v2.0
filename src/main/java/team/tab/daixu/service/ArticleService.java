package team.tab.daixu.service;

import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.entity.ArticleEntity;

import java.util.List;

/**
 * Created by CLY on 2017/1/3.
 */
public interface ArticleService {
    /**
     * 创建新文章
     * @param articleEntity 文章实例化对象
     * @param article_img 文章图片文件
     * @return 如果成功返回该文章的持久化对象，失败则返回null
     * @throws Exception 存储图片时的异常
     */
    ArticleEntity save(ArticleEntity articleEntity, MultipartFile article_img) throws Exception;

    /**
     * 根据id查询具体文章的首部信息
     * @param article_id 文章id
     * @return 单个文章持久化类对象
     */
    ArticleEntity findOneById(Integer article_id);

    /**
     * 根据文章id和目前的访问用户id查询出该文章目前的接龙状况
     * @param article_id 文章id
     * @param user_id 目前的访问用户id
     * @return null表示该文章目前没有被接龙。“1”表示自己正在接龙该文章。“2”表示该文章目前正在被别人接龙。
     */
    String findNowStatus(Integer article_id,Integer user_id);

    /**
     * 根据用户id查看其是否能抢接续写该文章
     * @param user_id 用户id
     * @param article_id 文章id
     * @return “1”表示能抢接该文章。“2”表示该文章正在被别人续写不能抢接。“3”表示该用户目前被禁言不能抢接
     */
    String checkContinue(int user_id,int article_id);
}