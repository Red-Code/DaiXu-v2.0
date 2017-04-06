package team.tab.daixu.util.page;

import java.util.List;

/**
 * Created by CLY on 2017/4/6.
 */
public interface PageUtil {
    int page_size=20;//每页展示的记录数
    long total_count=0;//记录总数

    List data=null;//当前页中存放的记录

    /**
     * 获取总页数
     * @return 总页数
     */
    long getTotalPageCount();

    /**
     * 获取当前页码，页码从1开始
     * @return 当前页码
     */
    long getCurrentPageNo();

    /**
     * 判断该页是否有下一页
     * @return
     */
    boolean isHasNextPage();

    /**
     * 判断该页是否有上一页
     * @return
     */
    boolean isHasPreviousPage();


}
