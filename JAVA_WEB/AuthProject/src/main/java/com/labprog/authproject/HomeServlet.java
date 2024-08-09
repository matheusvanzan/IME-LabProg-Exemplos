package com.labprog.authproject;

import java.io.*;

import com.labprog.entities.User;
import com.labprog.utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Força o carregamento previo de uma sessao do Hibernate
        HibernateUtil.getSessionFactory();

        // Checar se ja esta logado
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
        } else {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}