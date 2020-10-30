package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-30 11:40 上午
 * @description
 * FilterChain 过滤器链
 *      Filter 过滤器
 *      Chain 链，链条
 *      FilterChain 就是过滤器链(多个过滤器如何一起工作)
 *
 *      顺序 和 web.xml 的顺序有关
 */
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(" Filter1 的 前置代码 ····");
        System.out.println(" Filter1 的 线程： " + Thread.currentThread().getName());
        System.out.println(" Filter1 " + req.getParameter("username"));
        req.setAttribute("key1", "value1");
        chain.doFilter(req, resp);
        System.out.println(" Filter1 的 后置代码 ····");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
