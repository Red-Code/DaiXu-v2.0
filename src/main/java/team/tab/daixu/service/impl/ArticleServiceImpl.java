package team.tab.daixu.service.impl;


import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import team.tab.daixu.dao.ArticleDao;
import team.tab.daixu.entity.ArticleEntity;
import team.tab.daixu.service.ArticleService;
import team.tab.daixu.util.StringUtil;

import javax.annotation.Resource;
import java.io.File;
import java.util.Properties;

/**
 * Created by CLY on 2017/1/5.
 */
public class ArticleServiceImpl implements ArticleService {
    @Resource(name = "articleDaoImpl")
    private ArticleDao articleDaoImpl;

    @Override
    public ArticleEntity save(ArticleEntity articleEntity, MultipartFile file) throws Exception {
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
        String uri = File.separator+ StringUtil.getNowDateStr(File.separator);
        File dir = new File(localPath + uri);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //创建新文件
        String newFileName = StringUtil.getUniqueFileName();
        File f = new File(dir.getPath() + File.separator + newFileName + "." + suffix);

        //将输入流中的数据复制到新文件
        FileUtils.copyInputStreamToFile(file.getInputStream(), f);

        //将封面图url装到持久化类里面
        articleEntity.setSurface(urlPath + uri.replace("\\", "/") + "/" + newFileName + "." + suffix);
        ArticleEntity result_save = articleDaoImpl.act_save(articleEntity);

        return result_save;
    }

    @Override
    public ArticleEntity findOneById(Integer article_id) {
        return articleDaoImpl.findOneById(article_id);
    }

    @Override
    public String findNowStatus(Integer article_id, Integer user_id) {
        return null;
    }

    @Override
    public String checkContinue(int user_id, int article_id) {
        return "1";
    }
}
