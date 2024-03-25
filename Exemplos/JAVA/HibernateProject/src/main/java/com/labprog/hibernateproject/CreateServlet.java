package com.labprog.hibernateproject;

import java.io.*;

import com.labprog.entities.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PessoaManager objects = new PessoaManager();
        Pessoa p = objects.create(
                "Matheus",
                "vanzan.matheus@eb.mil.br",
                "123456789",
                "123456789",
                "M",
                "1992-12-12"
        );

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Dado salvo!</h1>");
        out.println("<p>" + p.getEmail() + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}