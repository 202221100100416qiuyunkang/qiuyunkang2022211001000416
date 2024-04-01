package com.qiuyunkang.week4.demo;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ConfigDemoServlet",
        value="/config",
        initParams={
                @WebInitParam(name = "name1", value = "qiuyunkang"),
                @WebInitParam(name = "studentId1", value = "202221100100416")
        })
public class ConfigDemoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletConfig config = getServletConfig();

        String name = config.getInitParameter("YourName");
        String id = config.getInitParameter("studentId");

        System.out.println("Name: " + name);
        System.out.println("Id: " + id);

        String name1 = config.getInitParameter("name1");
        String studentId1 = config.getInitParameter("studentId1");

        System.out.println("Name: " + name1);
        System.out.println("Student ID: " + studentId1);

        // Write output to the HTTP response
        response.setContentType("text/plain"); // Set content type to text/plain
        response.getWriter().println("Name: " + name);
        response.getWriter().println("Id: " + id);
        response.getWriter().println("name1: " + name1);
        response.getWriter().println("Id1: " + studentId1);
    }
}