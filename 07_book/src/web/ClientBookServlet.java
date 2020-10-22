package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceimpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-22 11:21 上午
 * @description
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceimpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/book/Servlet?action=page");
        //3 保存Page对象到Request域中
        request.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/page/client/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);

        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/book/Servlet?action=pageByPrice");

        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }

        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3 保存Page对象到Request域中
        request.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/page/client/index.jsp").forward(request, response);
    }
}
