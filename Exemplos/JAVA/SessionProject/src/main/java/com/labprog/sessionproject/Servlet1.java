package com.labprog.sessionproject;

import java.io.*;
import java.util.*;
import java.lang.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "servlet1", value = "/servlet1")
public class Servlet1 extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String user = request.getParameter("username");
        String pwd = request.getParameter("password");

        // validar usuario com a senha

        HttpSession session = request.getSession();
        session.setAttribute("username", user);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet 1</h1>");
        out.println("<a href=\"servlet2\">Verificar Session</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}