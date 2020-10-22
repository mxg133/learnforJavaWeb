package servlet;

import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-22 5:26 下午
 * @description
 */
public class CookieServlet extends BaseServlet {
    protected void creatCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 创建Cookie对象
        Cookie cookie = new Cookie("key0", "v0");
        Cookie cookie1 = new Cookie("key1", "v1");
        Cookie cookie2 = new Cookie("key2", "v2");
        //2 通知客户端保存Cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().write("Cookie 创建 ");
    }


    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        Cookie iWannaCookie = CookieUtils.findCookie("key1", cookies);

//        for (Cookie cookie: cookies) {
//            // getName方法返回Cookie的key（名）
//            // getValue方法返回Cookie的value值
//            response.getWriter().write("cookie :  " + cookie.getName() + " = " + cookie.getValue() + "<br/>");
//
//            if ("key1".equals(cookie.getName())) {
//                iWannaCookie = cookie;
//                break;
//            }
//        }
        // 如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iWannaCookie != null) {
            response.getWriter().write("OK 找到了！cookie :  " + iWannaCookie.getName() + " = " + iWannaCookie.getValue() + "<br/>");

        }
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方案一：
        //1、先创建一个要修改的同名的Cookie对象
        // 2、在构造器，同时赋于新的Cookie值。
        //Cookie cookie = new Cookie("key1","newValue1");
        //3、调用response.addCookie( Cookie ); 通知 客户端 保存修改
        //resp.addCookie(cookie);

        //方案二：
        //1、先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
        //2、调用setValue()方法赋于新的Cookie值。
            cookie.setValue("newV1");
        //3、调用response.addCookie()通知客户端保存修改
            response.addCookie(cookie);
        }
        response.getWriter().write(" ok方案2 ");
    }

}