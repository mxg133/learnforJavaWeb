package filter;

import utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-30 6:04 下午
 * @description
 */
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(req, resp);

            JDBCUtils.commitAndClose();//提交事物
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();//回滚事物
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
