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
import java.util.List;

/**
 * @author 孟享广
 * @date 2020-10-19 4:52 下午
 * @description
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceimpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo++;
//        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//        2、调用BookService.addBook()保存图书
        bookService.addBook(book);
//        3、跳到图书列表页面
//                /client/bookServlet?action=list
//        request.getRequestDispatcher("/client/bookServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1、获取请求的参数id，图书编程
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
//        2、调用bookService.deleteBookById();删除图书
                bookService.deleteBookById(id);
//        3、重定向回图书列表管理页面
//                /book/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath() + "/book/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) {
//        1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//        2、调用BookService.updateBook( book );修改图书
        bookService.updateBook(book);
//        3、重定向回图书列表管理页面
//        地址：/工程名/manager/bookServlet?action=list
        request.getRequestDispatcher(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) {
        //1 获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("i"), 0);
        //2 调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3 保存到图书到Request域中
        request.setAttribute("book", book);
        //4 请求转发到。pages/manager/book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp");
    }


    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        request.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/book/Servlet?action=page");
        //3 保存Page对象到Request域中
        request.setAttribute("page", page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/page/manager/book_manager.jsp").forward(request, response);
    }
}
