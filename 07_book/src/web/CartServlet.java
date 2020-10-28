package web;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceimpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-28 9:49 上午
 * @description
 */
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceimpl();

    /**
     * 加入购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        String ids = request.getParameter("id");
        int id = WebUtils.parseInt(ids, 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        // 最后一个添加的商品名称
        request.getSession().setAttribute("lastName", cartItem.getName());
        // 重定向回原来商品所在的地址页面
        String referer = request.getHeader("Referer");//得到之前的地址
        response.sendRedirect(referer);

    }

    /**
     * 删除商品项
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 删除 了购物车商品项
            cart.deleteItem(id);
            // 重定向回原来购物车展示页面
            String referer = request.getHeader("Referer");//得到之前的地址
            response.sendRedirect(referer);
        }
    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 清空购物车
            cart.clear();
            // 重定向回原来购物车展示页面
            String referer = request.getHeader("Referer");//得到之前的地址
            response.sendRedirect(referer);
        }
    }

    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数 商品编号 、商品数量
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 0);
        // 获取Cart购物车对象
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 修改商品数量
        if (cart != null) {
            cart.updateCount(id, count);
            // 重定向回原来购物车展示页面
            String referer = request.getHeader("Referer");//得到之前的地址
            response.sendRedirect(referer);
        }
    }



}



