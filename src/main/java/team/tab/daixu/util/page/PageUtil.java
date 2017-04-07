package team.tab.daixu.util.page;

/**
 * Created by CLY on 2017/4/6.
 */
import java.util.List;

/**
 * 分页对象，包含：“当前页的list数据”和“分页信息”
 */
public interface PageUtil {
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

    /**
     * 找到“某页的第一条数据”在数据库表中的位置。
     * （即行号，用来作为查询的起始位置）
     * @param pageNo 当前页数
     * @param pageSize 每页展示的记录数
     * @return 所在位置
     */
    int getStartOfPage(int pageNo,int pageSize);

    /**
     * 为当前分页对象设置每页展示的记录数
     * @param page_size 新的每页展示数
     * @return 设置完的分页对象
     */
    PageUtil setPageSize(int page_size);

    /**
     * 为当前分页对象设置当前页第一条数据在数据库表中的位置
     * @param start 当前页第一条数据在数据库表中的位置
     * @return 设置完的分页对象
     */
    PageUtil setStart(long start);

    /**
     * 设置记录总条数
     * @param total_count 记录总条数
     * @return 设置完的分页对象
     */
    PageUtil setTotalCount(long total_count);

    /**
     * 设置当前页中存放的记录
     * @param date_list 当前页中存放的记录
     * @return 设置完的分页对象
     */
    PageUtil setDateList(List date_list);
}
