package team.tab.daixu.util.upload.impl;

import org.springframework.stereotype.Component;
import team.tab.daixu.util.upload.UploadUtil;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by CLY on 2017/4/4.
 */
@Component
public class UploadUtilImpl implements UploadUtil {
    @Override
    public String getNowDateStr(String separator) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH)+1;
        int day = now.get(Calendar.DATE);

        return year + separator + month + separator + day;
    }

    @Override
    public String getUniqueFileName() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "");
    }
}
