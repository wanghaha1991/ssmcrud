package cn.kgc.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author asus
 * @Title: DateConverter
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/7 18:50
 */
public class DateConverter implements Converter<String, Date> {
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字符串转换为日期类型
            return simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 如果转换异常则返回空
        return null;
    }
}
