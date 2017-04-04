package team.tab.daixu.util.upload;

/**
 * Created by CLY on 2017/4/4.
 */
public interface UploadUtil {
    /**
     *  获取当前日期字符串
     * @param separator 路径分隔符，UNIX 系统上，此字段的值为 '/'。Windows 系统上，它为 '\'
     * @return 当前日期
     */
    String getNowDateStr(String separator);

    /**
     * 生成一个唯一的文件名
     * @return 文件名
     */
    String getUniqueFileName();
}
