package com.security.demo.encode;

import io.micrometer.common.util.StringUtils;
// Log utils se lam cho data co dang ? moi khi truyen parametter vao
public class LogUtils {
    public static String maskSensitiveData(String data) {
        if (StringUtils.isEmpty(data)) {
            return "?????";
        }
        int length = data.length();
        return "?".repeat(length);
    }
}
