package com.demo.service;

import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2019/1/11
 * 14:22
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAo userDAo = new UserDAo();
        boolean flag = Ajax_Test_Servlet.flag;
        if(flag){
            try {
                userDAo.register(username,password);
                request.getRequestDispatcher("success.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
