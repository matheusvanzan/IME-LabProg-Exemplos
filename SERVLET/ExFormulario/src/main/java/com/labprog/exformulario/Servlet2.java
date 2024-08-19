package com.labprog.exformulario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet {

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String role = request.getParameter("role");
        String recommend = request.getParameter("recommend");
        String languages = request.getParameter("languages");
        String comment = request.getParameter("comment");

        Pessoa p = new Pessoa();
        p.setEmail(email);
        p.setNome(name);
        request.getSession().setAttribute("pessoa", p);

        try {
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<p>name: " + name + "</p>");
//        out.println("<p>email: " + email + "</p>");
//        out.println("<p>age: " + age + "</p>");
//        out.println("<p>role: " + role + "</p>");
//        out.println("<p>recommend: " + recommend + "</p>");
//        out.println("<p>languages: " + languages + "</p>");
//        out.println("<p>comment: " + comment + "</p>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
}