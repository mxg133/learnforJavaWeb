package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-30 9:56 上午
 * @description
 * Filter 过滤器的使用步骤:
 *      1、编写一个类去实现 Filter 接口
 *      2、实现过滤方法 doFilter()
 *      3、到 web.xml 中去配置 Filter 的拦截路径
 *
 *
 *  Filter 的生命周期包含几个方法
 *      1、构造器方法
 *      2、init 初始化方法
 *          第 1，2 步，在 web 工程启动的时候执行(Filter 已经创建)
 *      3、doFilter 过滤方法
 *          第 3 步，每次拦截到请求，就会执行
 *      4、destroy 销毁
 *          第 4 步，停止 web 工程的时候，就会执行(停止 web 工程，也会销毁 Filter 过滤器)
 *
 * FilterConfig 类
 *      FilterConfig 类见名知义，它是 Filter 过滤器的配置文件类。
 *      Tomcat 每次创建 Filter 的时候，也会同时创建一个 FilterConfig 类，这里包含了 Filter 配置文件的配置信息。
 *
 *      FilterConfig 类的作用是获取 filter 过滤器的配置内容
 *           1、获取 Filter 的名称 filter-name 的内容
 *           2、获取在 Filter 中配置的 init-param 初始化参数
 *           3、获取 ServletContext 对象
 *
 *
 *
 *
 * Filter 的拦截路径
 *  --精确匹配
 *      <url-pattern>/target.jsp</url-pattern>
 *      以上配置的路径，表示请求地址必须为:http://ip:port/工程路径/target.jsp
 *  --目录匹配
 *      <url-pattern>/admin/*</url-pattern>
 *      以上配置的路径，表示请求地址必须为:http://ip:port/工程路径/admin/*
 *  --后缀名匹配
 *      <url-pattern>*.jsp</url-pattern>
 *      以上配置的路径，表示请求地址必须以.jsp 结尾才会拦截到
 *
 *      Filter 过滤器它只关心请求的地址是否匹配，不关心请求的资源是否存在!!!
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1、Filter的AdminFilter()构造器方法 ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2、Filter的init(FilterConfig filterConfig)初始化方法 ");

//         1、获取 Filter 的名称 filter-name 的内容
        System.out.println("filter-name -> " + filterConfig.getFilterName());
//         2、获取在 Filter 中配置的 init-param 初始化参数
        System.out.println("初始化参数username的值是 -> " + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数 url 的值是 -> " + filterConfig.getInitParameter("url"));
//         3、获取 ServletContext 对象
        System.out.println(filterConfig.getServletContext());
    }
    /**
     * doFilter 方法，专门用于拦截请求。可以做权限检查
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3、Filter的doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)方法 ");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        // 如果等于 null，说明还没有登录
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4、Filter的destroy() 销毁方法 ");
    }
}
