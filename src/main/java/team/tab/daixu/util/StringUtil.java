package team.tab.daixu.util;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by CLY on 2017/2/23.
 * 工具类
 */
public class StringUtil {

    /**
     *  获取当前日期字符串
     * @param separator
     * @return
     */
    public static String getNowDateStr(String separator){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DATE);

        return year + separator + month + separator + day;
    }

    //生成唯一的文件名
    public static String getUniqueFileName(){
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }
}
