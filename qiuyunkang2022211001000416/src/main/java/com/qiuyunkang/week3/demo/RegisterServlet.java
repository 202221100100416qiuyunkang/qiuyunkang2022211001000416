package com.qiuyunkang.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    Connection con=null;

    @Override
    public void init() {

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
        con= (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1="1";
        String username1=request.getParameter("username");
        String password1=request.getParameter("password");
        String email1= request.getParameter("email");
        String gender1=request.getParameter("gender");
        String birthdate1=request.getParameter("birthdate");

        try {
            PreparedStatement stmt = con.prepareStatement("insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)");
            stmt.setString(1, id1);
            stmt.setString(2, username1);
            stmt.setString(3, password1);
            stmt.setString(4, email1);
            stmt.setString(5, gender1);
            stmt.setString(6, birthdate1);
            //set other parameters
            stmt.executeUpdate();
            con.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String str = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(str);
            try {
//                PrintWriter writer = response.getWriter();
//                writer.println("<html><head><meta charset=\"UTF-8\"><title>User Information</title></head><body>");
//                writer.println("<table border='1'>");
//                writer.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
//                while (rs.next()) {
//                    String id = rs.getString("id");
//                    String username = rs.getString("username");
//                    String password = rs.getString("password");
//                    String email = rs.getString("email");
//                    String gender = rs.getString("gender");
//                    String birthdate = rs.getString("birthdate");
//
//                    writer.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td>" + email + "</td><td>" + gender + "</td><td>" + birthdate + "</td></tr>");
//                }
//                writer.println("</table>");
//                writer.println("</body></html>");

                //request.setAttribute("rsname",rs);
//                request.getRequestDispatcher("userList.jsp").forward(request,response);
//                System.out.println("I am in forward");
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        String id1="1";
//        String username1=request.getParameter("username");
//        String password1=request.getParameter("password");
//        String email1= request.getParameter("email");
//        String gender1=request.getParameter("gender");
//        String birthdate1=request.getParameter("birthdate");
//
//        try {
//            PreparedStatement stmt = con.prepareStatement("insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)");
//            stmt.setString(1, id1);
//            stmt.setString(2, username1);
//            stmt.setString(3, password1);
//            stmt.setString(4, email1);
//            stmt.setString(5, gender1);
//            stmt.setString(6, birthdate1);
//            //set other parameters
//            stmt.executeUpdate();
//            con.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        String str = "select * from usertable";
//        try {
//            ResultSet rs = con.createStatement().executeQuery(str);
//            try {
//                PrintWriter writer = response.getWriter();
//                writer.println("<html><head><meta charset=\"UTF-8\"><title>User Information</title></head><body>");
//                writer.println("<table border='1'>");
//                writer.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
//                while (rs.next()) {
//                    String id = rs.getString("id");
//                    String username = rs.getString("username");
//                    String password = rs.getString("password");
//                    String email = rs.getString("email");
//                    String gender = rs.getString("gender");
//                    String birthdate = rs.getString("birthdate");
//
//                    writer.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td>" + email + "</td><td>" + gender + "</td><td>" + birthdate + "</td></tr>");
//                }
//                writer.println("</table>");
//                writer.println("</body></html>");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}