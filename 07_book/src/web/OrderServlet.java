package web;

import pojo.Cart;
import pojo.User;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-28 7:21 下午
 * @description
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void creatOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = loginUser.getId();
        // 调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.creatOrder(cart, userId);
//        request.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
