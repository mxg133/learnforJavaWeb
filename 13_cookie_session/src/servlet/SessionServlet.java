package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-10-26 5:30 下午
 * @description
 * i) 什么是 Session 会话?
 * 1、Session 就一个接口(HttpSession)。
 * 2、Session 就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。 3、每个客户端都有自己的一个 Session 会话。
 * 4、Session 会话中，我们经常用来保存用户登录之后的信息。
 *
 * j) 如何创建 Session 和获取(id 号,是否为新)
 * 如何创建和获取 Session。它们的 API 是一样的。 request.getSession()
 * 第一次调用是:创建 Session 会话 之后调用都是:获取前面创建好的 Session 会话对象。
 * isNew(); 判断到底是不是刚创建出来的(新的) true 表示刚创建
 * false 表示获取之前创建
 * 每个会话都有一个身份证号。也就是 ID 值。而且这个 ID 是唯一的。
 * getId() 得到 Session 的会话 id 值。
 *
 * l) Session 生命周期控制
 * public void setMaxInactiveInterval(int interval)
 *      设置 Session 的超时时间(以秒为单位)，超过指定的时长，Session 就会被销毁。
 *      值为正数的时候，设定 Session 的超时时长。 负数表示永不超时(极少使用)
 * public int getMaxInactiveInterval()
 *      获取 Session 的超时时间 publicvoidinvalidate() 让当前Session会话马上超时无效。
 * Session 默认的超时时间长为 30 分钟。
 * 因为在 Tomcat 服务器的配置文件 web.xml 中默认有以下的配置，它就表示配置了当前 Tomcat 服务器下所有的 Session 超时配置默认时长为:30 分钟。
 * <session-config>
 *     <session-timeout>30</session-timeout>
 * </session-config>
 *
 * 如果说。你希望你的 web 工程，默认的 Session 的超时时长为其他时长。
 * 你可以在你自己的 web.xml 配置文件中做 以上相同的配置。
 * 就可以修改你的 web 工程所有 Seession 的默认超时时长。
 *
 * 如果你想只修改个别 Session 的超时时长。就可以使用上面的 API。
 * setMaxInactiveInterval(int interval)来进行单独的设 置。
 * session.setMaxInactiveInterval(int interval)单独设置超时时长。
 *
 */
public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建和获取Session会话对象
        HttpSession session = request.getSession();
        // 判断 当前Session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识 id
        String id = session.getId();

        //打印
        response.getWriter().write("得到的session 的 id 为： " + id + "<br/>");
        response.getWriter().write("得到的session 是否是新的 ：  " + isNew + "<br/>");
    }

    /**
     * 往Session中保存数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key1", "value1");

        response.getWriter().write("存数据到 session·····");
    }

    /**
     * 获取Session域中的数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object key1 = request.getSession().getAttribute("key1");
        response.getWriter().write("从session获取的 key1 的数据是： " + key1);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取了Session的默认超时时长
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("session 的默认时长为 ：  " + maxInactiveInterval);
    }

    protected void life3s(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先获取Session对象
        HttpSession session = request.getSession();
        // 设置当前Session3秒后超时
        session.setMaxInactiveInterval(3);
        response.getWriter().write("  当前Session已经设置为3秒后超时   ");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先获取Session对象
        HttpSession session = request.getSession();
        // 让Session会话马上超时
        session.invalidate();

        response.getWriter().write("Session已经设置为超时（无效）");
    }
}
