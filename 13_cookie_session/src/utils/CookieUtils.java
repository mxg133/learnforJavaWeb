package utils;

import javax.servlet.http.Cookie;

/**
 * @author 孟享广
 * @date 2020-10-22 8:15 下午
 * @description
 */
public class CookieUtils {
    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie cookies[]) {
        if (name == null || cookies == null || cookies.length == 0) {
                return null;
        }

        for (Cookie cookie: cookies) {

            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
