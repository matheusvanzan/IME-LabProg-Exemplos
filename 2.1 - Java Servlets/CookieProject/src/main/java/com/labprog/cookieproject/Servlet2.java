package com.labprog.cookieproject;

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

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet 2</h1>");

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            out.println("<p>");
            out.println(c.getName() + " : " + c.getValue());
            out.println("</p>");
        }

        out.println("</body></html>");
    }

    public void destroy() {
    }
}