package cn.itcast.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: Baseen
 * @Date: 2019/10/8 19:26
 * @Version: v1.0
 **/
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前请求URI
        String uri = request.getRequestURI();

        //截取方法名
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        //通过反射指定要执行的方法
        try {
            Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

            //执行方法
            method.invoke(this,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
