package com.labprog.databaseproject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // buscar pessoa
        PessoaDAO op2 = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            op2 = new PessoaDAO();
            pessoas = op2.listAll();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Pessoa p : pessoas) {
            out.println("<p>Nome: " + p.getNome() + " - Email: " + p.getEmail() + "</p>");
        }

        out.println("</body></html>");
    }

    public void destroy() {
    }
}