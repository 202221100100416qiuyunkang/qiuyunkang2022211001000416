package com.Liuxiang.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con =null;
    @Override
    public void init() {
//        String driver1 = getServletContext().getInitParameter("driver1");
//        String url1 = getServletContext().getInitParameter("url1");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//        con=(Connection) getServletContext().getAttribute("con");
//        try {
//            Class.forName(driver1);
//            con = DriverManager.getConnection(url1, username, password);
        con=(Connection) getServletContext().getAttribute("con");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
//        String str = "select id,username,password,email.gender,birthdate * from usertable where username= 'Liuxiang' and password= '2022211001000413'";
//        try {
//            ResultSet rus=con.createStatement().executeQuery(str);
//            PrintWriter writer=response.getWriter();
//            if (rus.next()){
////            writer.println("LOGIN SUCCESS !!!");
////            writer.println("WELCOME,XiongYuXuan");}
//              request.setAttribute("username",rus.getString("id"));
//                request.setAttribute("password",rus.getString("password"));
//                request.setAttribute("email",rus.getString("email"));
//                request.setAttribute("gender",rus.getString("gender"));
//                request.setAttribute("birthdate",rus.getString("birthdate"));
//                request.setAttribute("username",rus.getString("id"));
//
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            }
//            else{
////                writer.println("LOGIN ERROR!!!");
//                request.setAttribute("message","username or password error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
//        String str = "select id,username,password,email,gender,birthdate * from usertable where username= 'Liuxiang' and password= '2022211001000413'";
        String str = "SELECT id, username, password, email, gender, birthdate FROM usertable WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            ResultSet rus=con.createStatement().executeQuery(str);
            PrintWriter writer=response.getWriter();
            if (rus.next()){
//            writer.println("LOGIN SUCCESS !!!");
//            writer.println("WELCOME,");}
                request.setAttribute("username",rus.getString("username"));
                request.setAttribute("password",rus.getString("password"));
                request.setAttribute("email",rus.getString("email"));
                request.setAttribute("gender",rus.getString("gender"));
                request.setAttribute("birthdate",rus.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
            else{
//                writer.println("LOGIN ERROR!!!");
                request.setAttribute("message","username or password error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
