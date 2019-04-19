package com.example.mothertochild.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtils {
    //截取数字  【读取字符串中第一个连续的字符串，不包含后面不连续的数字】
    public static Integer getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return Integer.valueOf(matcher.group(0));
        }
        return 0;
    }

    // 截取非数字
    public static String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}
