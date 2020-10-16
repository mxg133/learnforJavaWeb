package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * @author 孟享广
 * @date 2020-10-16 7:37 下午
 * @description
 */
public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFileName = "6.jpg";

        //2.读取要下载的文件内容(通过ServletContext对象可以获取)
        ServletContext servletContext = getServletContext();
        //获取要下载的文件的类型
//        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        String mimeType = servletContext.getMimeType("/file/" + URLEncoder.encode("美利坚.jpg", "utf-8"));//非要中文名

        System.out.println("下载的文件的类型" + mimeType);
        //4.在回传前，通过相应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        //5.还要告诉客户端收到的数据用于下载使用（还是使用响应头）
        //Content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，表示下载使用
        if (request.getHeader("User-Agent").contains("Firefox")){
//        response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?64?" + new BASE64Encoder().encode("美利坚.jpg".getBytes("UTF-8")) + "?=");//火狐
        }else {
//        response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("美利坚.jpg", "utf-8"));//非要中文名
        }
        /**
         * /被服务器 解析表示地址为http://ip:prot/工程名/ 映射到代码的web目录
         */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        OutputStream outputStream = response.getOutputStream();
        //3.把下载的文件内容回传给客户端
        //读取输入流中全部的数据， 复制给输出流， 输出客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
