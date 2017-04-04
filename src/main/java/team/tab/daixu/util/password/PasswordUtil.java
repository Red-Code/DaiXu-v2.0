package team.tab.daixu.util.password;

/**
 * Created by CLY on 2017/4/4.
 */
public interface PasswordUtil {
    /**
     * 将原数据进行加密后返回
     * @param origin_data 待加密数据
     * @return 加密之后的数据
     */
    String encrypted(String origin_data);
}
