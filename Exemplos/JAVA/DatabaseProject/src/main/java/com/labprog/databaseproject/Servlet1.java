package com.labprog.databaseproject;

import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servlet1", value = "/servlet1")
public class Servlet1 extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // objeto que representa o item
        Pessoa p = new Pessoa();
        p.setNome("Ricardo");
        p.setEmail("ricardofranco@ime.eb.br");
        p.setCpf("123.456.789-00");
        p.setTelefone("21123456789");
        p.setSexo("M");
        Date dt = null;
        try {
            dt = new SimpleDateFormat("yyyy-MM-dd").parse("1992-12-12");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        p.setDtNasc(dt);

        // operacoes no banco (CRUD)
        PessoaDAO op = null;
        int result = 0;

        try {
            op = new PessoaDAO();
            result = op.insert(p);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // buscar pessoa
        PessoaDAO op2 = null;
        try {
            op2 = new PessoaDAO();
            op2.search("ricardofranco@ime.eb.br");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}