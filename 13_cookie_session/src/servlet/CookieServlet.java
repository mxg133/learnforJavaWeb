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
 * a)什么是 Cookie?
 * 1、Cookie 翻译过来是饼干的意思。
 * 2、Cookie 是服务器通知客户端保存键值对的一种技术。
 * 3、客户端有了 Cookie 后，每次请求都发送给服务器。
 * 4、每个 Cookie 的大小不能超过 4kb
 *
 * c)服务器如何获取 Cookie
 * 服务器获取客户端的 Cookie 只需要一行代码:req.getCookies():Cookie[]
 *
 *
 * d)Cookie 值的修改
 * 方案一:
 * 1、先创建一个要修改的同名(指的就是 key)的 Cookie 对象 2、在构造器，同时赋于新的 Cookie 值。
 * 3、调用 response.addCookie( Cookie );
 * 方案二:
 * 1、先查找到需要修改的 Cookie 对象
 * 2、调用 setValue()方法赋于新的 Cookie 值。 3、调用 response.addCookie()通知客户端保存修改
 *
 * f) Cookie 生命控制
 * Cookie 的生命控制指的是如何管理 Cookie 什么时候被销毁(删除)
 * setMaxAge()
 * 正数，表示在指定的秒数后过期 负数，表示浏览器一关，Cookie 就会被删除(默认值是-1) 零，表示马上删除 Cookie
 *
 *
 * g)Cookie 有效路径 Path 的设置
 * Cookie 的 path 属性可以有效的过滤哪些 Cookie 可以发送给服务器。哪些不发。
 * path 属性是通过请求的地址来进行有效的过滤。 CookieA path=/工程路径
 * CookieB path=/工程路径/abc
 * 请求地址如下:
 * http://ip:port/工程路径/a.html CookieA 发送
 * CookieB 不发送
 * http://ip:port/工程路径/abc/a.html CookieA 发送
 * CookieB 发送
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

    /**
     * Cookie 的生命控制指的是如何管理 Cookie 什么时候被销毁(删除)
     * setMaxAge()
     * 正数，表示在指定的秒数后过期 负数，表示浏览器一关，Cookie 就会被删除(默认值是-1) 零，表示马上删除
     */
    /**
     * 默认的会话级别的Cookie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLifeCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("d1", "d1v1");

        cookie.setMaxAge(-1);//设置存活时间

        response.addCookie(cookie);

    }

    /**
     * 马上删除一个Cookie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNowCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先找到你要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            // 调用setMaxAge(0);
            cookie.setMaxAge(0);// 表示马上删除，都不需要等待浏览器关闭
        }
        // 调用response.addCookie(cookie);
        response.addCookie(cookie);

        response.getWriter().write("删除 k1 ");

    }

    /**
     * 设置存活1个小时的Cooie
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void life3600Cookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("life", "life3600");

        cookie.setMaxAge(60 * 60);// 设置Cookie一小时之后被删除。无效
        response.addCookie(cookie);
        response.getWriter().write("已经创建了一个存活一小时的Cookie");
    }


    /**
     * g)Cookie 有效路径 Path 的设置
     * Cookie 的 path 属性可以有效的过滤哪些 Cookie 可以发送给服务器。哪些不发。
     * path 属性是通过请求的地址来进行有效的过滤。 CookieA path=/工程路径
     * CookieB path=/工程路径/abc
     * 请求地址如下:
     * http://ip:port/工程路径/a.html CookieA 发送
     * CookieB 不发送
     * http://ip:port/工程路径/abc/a.html CookieA 发送
     * CookieB 发送
     */

    protected void pathCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "pathCookie1");
        // getContextPath() ===>>>>  得到工程路径
        cookie.setPath(request.getContextPath() + "/abc");// ===>>>>  /工程路径/abc
        response.addCookie(cookie);
        response.getWriter().write("创建了一个带有Path路径的Cookie");
    }
}