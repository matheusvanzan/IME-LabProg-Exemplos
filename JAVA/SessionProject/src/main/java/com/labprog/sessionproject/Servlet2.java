package com.labprog.sessionproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servlet2", value = "/servlet2")
public class Servlet2 extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("username");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet 2</h1>");
        out.println("Usuário logado (sessão): " + sessao);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}