package com.labprog.hibernateproject;

import com.labprog.entities.Pessoa;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ListAllServlet", value = "/list")
public class ListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        PessoaManager objects = new PessoaManager();
        String email = request.getParameter("email");
        if (email == null) {

            List<Pessoa> pessoaList = objects.getAll();
            Iterator it = pessoaList.iterator();

            out.println("<h2>List All</h2>");
            while (it.hasNext()) {
                Pessoa p = (Pessoa) it.next();
                out.println("<p>Pessoa: " + p.getEmail() + " <a href=\"/list?email=" + p.getEmail() + "\">Ver</a></p>");
            }
        } else {
            out.println("<h2>Get</h2>");
            Pessoa p = objects.getByEmail(email);
            out.println("<p>Email: " + p.getEmail() + "</p>");
            out.println("<p>Nome: " + p.getNome() + "</p>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}