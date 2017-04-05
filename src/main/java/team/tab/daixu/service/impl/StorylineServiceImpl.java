package team.tab.daixu.service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.cons.OrderConstent;
import team.tab.daixu.dao.StorylineDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.entity.StorylineEntity;
import team.tab.daixu.service.StorylineService;
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
        StorylineEntity result_save = storylineDaoImpl.save(storylineEntity);

        return result_save;
    }

    @Override
    public Boolean update(StorylineEntity storylineEntity) {
        return storylineDaoImpl.update(storylineEntity);
    }

    @Override
    public List<StorylineEntity> findMoreByWhere(Integer now_page, OrderConstent order, Integer rule, int show_num) {
        int begin_limit = now_page*show_num-show_num;

        List<StorylineEntity> result_find;
        switch (order){
            case ORDER_NEW://表示是最新查询
                result_find = storylineDaoImpl.findMoreByOrderNews(begin_limit, rule, show_num);
                break;
            case ORDER_HOT://按最热查询
                result_find = storylineDaoImpl.findMoreByOrderHot(begin_limit,rule,show_num);
                break;
            default:
                result_find = null;
        }

        return result_find;
    }

    @Override
    public List<StorylineEntity> findMoreByWhere(Integer now_page, OrderConstent order, Integer rule, int show_num, String tag) {
        int begin_limit = now_page*show_num-show_num;

        List<StorylineEntity> result_find;
        switch (order){
            case ORDER_NEW:
                result_find = storylineDaoImpl.findMoreByOrderNews(begin_limit, rule, show_num,tag);
                break;
            case ORDER_HOT:
                result_find = storylineDaoImpl.findMoreByOrderHot(begin_limit,rule,show_num,tag);
                break;
            default:
                result_find = null;
                break;
        }

        return result_find;
    }

    @Override
    public int findPageSum(int show_num) {
        int sum_count = storylineDaoImpl.findSumByCount();
        int sum_page = sum_count/show_num;
        return sum_page;
    }

    @Override
    public StorylineEntity findOneById(Integer storyline_id) {
        return storylineDaoImpl.findOneById(storyline_id);
    }

    @Override
    public List<StorylineEntity> findMoreByUser(Integer user_id, int now_page, OrderConstent time_order, int show_num, int relate_type) {
        int begin_limit = now_page*show_num-show_num;

        List<StorylineEntity> result_storyline;
        if (relate_type == 1){//表示是用户发布的，所以与storylineDao有关
            result_storyline = storylineDaoImpl.findMoreByOrderNews(user_id,begin_limit,show_num);
        }else if (relate_type==2){//用户参与的，与controllerDao有关
            result_storyline = null;
        }else {
            result_storyline = null;
        }
        return result_storyline;
    }

    @Override
    public int findPageSumByUser(Integer user_id, int show_num, int relate_type) {

        int sum_count;
        if (relate_type == 1){//表示是用户发布的，所以与storylineDao有关
            sum_count = storylineDaoImpl.findSumByCount(user_id);
        }else if (relate_type==2){//用户参与的，与controllerDao有关
            sum_count = 0;
        }else {
            sum_count = 0;
        }

        int sum_page = sum_count/show_num;
        return sum_page;
    }

    @Override
    public List<StorylineEntity> findMoreRecommend(int storyline_commend_show_num) {
        return storylineDaoImpl.findMoreByOrderHot(0,1,storyline_commend_show_num);
    }
}
