package com.labprog.hibernateproject;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.labprog.entities.*;
import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Servlet1", value = "/servlet1")
public class Servlet1 extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PessoaManager objects = new PessoaManager();
        Pessoa p = objects.create(
                "Matheus",
                "vanzan3@eb.mil.br",
                "123",
                "123",
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