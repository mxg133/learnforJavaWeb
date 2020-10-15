package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 孟享广
 * @date 2020-10-15 7:56 下午
 * @description
 */
/*
什么是 Listener 监听器?
1、Listener 监听器它是 JavaWeb 的三大组件之一。JavaWeb 的三大组件分别是:Servlet 程序、Filter 过滤器、Listener 监 听器。
2、Listener 它是 JavaEE 的规范，就是接口 3、监听器的作用是，监听某种事物的变化。然后通过回调函数，反馈给客户(程序)去做一些相应的处理。
ServletContextListener 监听器 ServletContextListener 它可以监听 ServletContext 对象的创建和销毁。
ServletContext 对象在 web 工程启动的时候创建，在 web 工程停止的时候销毁。
监听到创建和销毁之后都会分别调用 ServletContextListener 监听器的方法反馈。
 */
public class MyServletContextListenerImpl implements ServletContextListener {
    /**
     * 在 ServletContext 对象创建之后马上调用，做初始化
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("第 1 个函数 contextInitialized() ");
    }

    /**
     * 在 ServletContext 对象销毁之后调用
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("第 2 个函数 contextDestroyed() ");
    }
}
