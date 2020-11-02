package servlet;

import com.google.gson.Gson;
import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 孟享广
 * @date 2020-11-02 8:28 上午
 * @description
 * 2、AJAX 请求
 *
 * 2.1、什么是 AJAX 请求
 * AJAX 即“Asynchronous Javascript And XML”(异步 JavaScript 和 XML)，是指一种创建交互式网页应用的网页开发 技术。
 *
 * ajax 是一种浏览器通过 js 异步发起请求，局部更新页面的技术。
 * Ajax 请求的局部更新，浏览器地址栏不会发生变化
 * 局部更新不会舍弃原来页面的内容
 *
 * 2.3、jQuery 中的 AJAX 请求
 * $.ajax 方法
 *      url     表示请求的地址
 *      type    表示请求的类型 GET 或 POST 请求
 *      data    表示发送给服务器的数据
 *      success 请求成功，响应的回调函数
 *          格式有两种:
 *            一:name=value&name=value
 *            二:{key:value}
 *      dataType 响应的数据类型
 *            常用的数据类型有:
 *                text 表示纯文本
 *                xml  表示 xml 数据 (过时)
 *                json 表示 json 对象
 *
 * $.get 方法 和  $.post 方法
 *      url         请求的 url 地址
 *      data        发送的数据
 *      callback    成功的回调函数
 *      type        返回的数据类型
 *
 * $.getJSON 方法
 *      url         请求的 url 地址
 *      data        发送给服务器的数据
 *      callback    成功的回调函数
 *
 *      表单序列化 serialize()
 *          serialize()可以把表单中所有表单项的内容都获取到，
 *          并以 name=value&name=value 的形式进行拼接。
 */
public class AjaxServlet extends BaseServlet {
    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 javaScriptAjax()方法。Ajax请求过来······");
        Person person = new Person(1, " -value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryAjax()方法。Ajax请求过来······");
        Person person = new Person(1, " jQueryAjax->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryGet()方法。Ajax请求过来······");
        Person person = new Person(1, " jQueryPGet->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryPost()方法。Ajax请求过来······");
        Person person = new Person(1, " -jQueryPost->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryGetJSON()方法。Ajax请求过来······");
        Person person = new Person(1, " -jQueryGetJSON->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQueryS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryGetJSON()方法。Ajax请求过来······");
        Person person = new Person(1, " -jQueryGetJSON->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxServlet 的 jQueryGetJSON()方法。Ajax请求过来······");

        System.out.println("用户名： " + request.getParameter("username"));
        System.out.println("密码： " + request.getParameter("password"));

        Person person = new Person(1, " -jQuerySerialize->value1- ");

        // json格式的字符串
        Gson gson = new Gson();

        String personJsonString = gson.toJson(person);

        response.getWriter().write(personJsonString);
    }
}
