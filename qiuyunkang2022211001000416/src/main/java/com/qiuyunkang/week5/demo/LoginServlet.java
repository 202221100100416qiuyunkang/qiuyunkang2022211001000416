package com.qiuyunkang.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;

    public void init() throws ServletException {
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usertable WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // 用户名和密码匹配，登录成功
                PrintWriter out = response.getWriter();
                out.println("Login Success!!!");
                out.println("Welcome " + username);
            } else {
                // 用户名或密码错误
                PrintWriter out = response.getWriter();
                out.println("Username or Password Error!!!");
            }
        } catch (SQLException e) {
            throw new ServletException("Error in accessing database", e);
        }
    }

    @Override
    public void destroy() {
        // 关闭数据库连接
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}