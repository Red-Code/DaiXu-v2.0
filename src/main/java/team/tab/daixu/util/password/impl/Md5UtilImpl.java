package team.tab.daixu.util.password.impl;

import org.springframework.stereotype.Component;
import team.tab.daixu.util.password.PasswordUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CLY on 2017/4/4.
 */
@Component
public class Md5UtilImpl implements PasswordUtil {
    @Override
    public String encrypted(String origin_data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(origin_data.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
