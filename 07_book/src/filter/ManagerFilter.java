package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-30 3:04 下午
 * @description
 */
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            chain.doFilter(req, resp);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
