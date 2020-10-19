package web;

import pojo.Book;
import service.BookService;
import service.impl.BookServiceimpl;

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

    protected void add(HttpServletRequest request, HttpServletResponse response) {

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) {

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) {

    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        request.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }


}
