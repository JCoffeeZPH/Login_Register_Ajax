package com.demo.service;

import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2019/1/11
 * 15:22
 */
@WebServlet(name = "Ajax_Test_Servlet")
public class Ajax_Test_Servlet extends HttpServlet {
    static boolean flag = false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        if("".equals(username) || "".equals(username.trim())){
            System.out.println("用户名为空");
            out.println("<font color=red>用户名不能为空</font>");
        }else {
            UserDAo userDAo = new UserDAo();
            try {
                flag = userDAo.isRegister(username);
                if(!flag){
                    out.println("<font color=red>用户名已存在</font>");
                    System.out.println("用户名已存在");
                }else{
                    System.out.println("用户名可用");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
