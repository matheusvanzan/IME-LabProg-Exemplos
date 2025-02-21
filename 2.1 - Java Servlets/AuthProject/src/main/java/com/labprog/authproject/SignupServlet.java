package com.labprog.authproject;

import com.labprog.entities.User;
import com.labprog.utils.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signup", value = "/signup")
public class SignupServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // alguma coisa aqui

        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserManager manager = new UserManager();
            manager.createUser(email, username, password);
        } catch(Exception e) {
            request.getSession().setAttribute("error", "Erro desconhecido");
            response.sendRedirect("/signup");
        }

        response.sendRedirect("/login");
    }

    public void destroy() {
    }
}