package team.tab.daixu.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.cons.StorylineNumRule;
import team.tab.daixu.cons.UserJoinType;
import team.tab.daixu.dao.StorylineDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.service.StorylineService;
import team.tab.daixu.util.page.PageUtil;
import team.tab.daixu.util.upload.UploadUtil;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * Created by CLY on 2017/1/5.
 */
@Service
public class StorylineServiceImpl implements StorylineService {
    @Resource(name = "uploadUtilImpl")
    private UploadUtil uploadUtilImpl;

    private StorylineDao storylineDaoImpl;
    @Override
    public StorylineEntity save(StorylineEntity storylineEntity, MultipartFile file) throws Exception{
        //过滤合法的文件类型
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
        String allowSuffixs = "gif,jpg,jpeg,bmp,png,ico";
        if(allowSuffixs.indexOf(suffix) == -1){
            return null;
        }

        //获取网络地址、本地地址头部
        Properties config = new Properties();
        config.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        String urlPath = config.getProperty("urlRoot");
        String localPath = config.getProperty("localRoot");

        //创建新目录
        String uri = File.separator+ uploadUtilImpl.getNowDateStr(File.separator);
        File dir = new File(localPath + uri);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //创建新文件
        String newFileName = uploadUtilImpl.getUniqueFileName();
        File f = new File(dir.getPath() + File.separator + newFileName + "." + suffix);

        //将输入流中的数据复制到新文件
        FileUtils.copyInputStreamToFile(file.getInputStream(), f);

        //将封面图url装到持久化类里面
        storylineEntity.setSurface(urlPath + uri.replace("\\", "/") + "/" + newFileName + "." + suffix);
        boolean result_save = storylineDaoImpl.save(storylineEntity);//此时持久化对象已经拥有id
        if (result_save){
            return storylineEntity;
        }else {
            return null;
        }


    }

    @Override
    public Boolean update(StorylineEntity storylineEntity) {
        return storylineDaoImpl.update(storylineEntity);
    }

    @Override
    public PageUtil findMoreByOrderRule(int now_page, OrderConstent order, StorylineNumRule num_rule, int show_num) {
        PageUtil result_find = storylineDaoImpl.findMoreByOrderRule(now_page,order,num_rule,show_num);

        return result_find;
    }

    @Override
    public PageUtil findMoreByOrderRuleTag(int now_page, OrderConstent order, StorylineNumRule num_rule,int show_num, String tag) {
        PageUtil result_find = storylineDaoImpl.findMoreByOrderRuleTag(now_page, order, num_rule, show_num, tag);

        return result_find;
    }

    @Override
    public StorylineEntity findOneById(long storyline_id) {
        return storylineDaoImpl.getById(storyline_id);
    }

    @Override
    public PageUtil findMoreByUser(long user_id, int now_page, OrderConstent time_order, int show_num, UserJoinType relate_type) {
        PageUtil result_storyline = storylineDaoImpl.findMoreByUser(user_id, now_page, time_order, show_num, relate_type);

        return result_storyline;
    }

    @Override
    public List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num) {
        return storylineDaoImpl.findMoreRecommend(storyline_commend_show_num);
    }

    @Override
    public List<StorylineEntity> findStorylineNewList(int show_num) {
        return null;
    }
}
