package com.labprog.userproject;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        //

        try {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        // pegar os dados do formulario
        String username = request.getParameter("username");
        String passord = request.getParameter("password");

        User u = new User();
        u.setUsername(username);

        // salvar o username na session
        request.getSession().setAttribute("user", u);



        try {
//            response.sendRedirect("home.jsp");
            response.sendRedirect("/home");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}