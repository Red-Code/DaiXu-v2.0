package team.tab.daixu.util.page.impl;

import org.springframework.stereotype.Component;
import team.tab.daixu.util.page.PageUtil;

import java.util.List;

/**
 * Created by CLY on 2017/4/6.
 */
@Component
public class PageUtilImpl implements PageUtil {
    private int page_size;//每页展示的记录数
    private long start;//当前页第一条数据在数据库表中的位置
    private long total_count;//记录总数
    private List date_list;//当前页中存放的记录

    //给各个参数赋初始值
    public PageUtilImpl(int page_size,long start,long total_count,List date_list) {
        this.page_size = page_size;
        this.start = start;
        this.total_count = total_count;
        this.date_list = date_list;
    }

    @Override
    public long getTotalPageCount() {
        return 0;
    }

    @Override
    public long getCurrentPageNo() {
        return 0;
    }

    @Override
    public boolean isHasNextPage() {
        return false;
    }

    @Override
    public boolean isHasPreviousPage() {
        return false;
    }

    @Override
    public int getStartOfPage(int pageNo, int pageSize) {
        return 0;
    }

    @Override
    public PageUtil setPageSize(int page_size) {
        return null;
    }

    @Override
    public PageUtil setStart(long start) {
        return null;
    }

    @Override
    public PageUtil setTotalCount(long total_count) {
        return null;
    }

    @Override
    public PageUtil setDateList(List date_list) {
        return null;
    }
}
