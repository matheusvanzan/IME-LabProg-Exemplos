package com.labprog.cookieproject;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie c1 = new Cookie("universidade", "ime");
        response.addCookie(c1);

        Cookie c2 = new Cookie("disciplina", "lab-prog-3");
        response.addCookie(c2);

        // Optional
//        Enumeration<String> names = request.getParameterNames();
//        String[] values = request.getParameterValues("");
        Map<String, String[]> map = request.getParameterMap();

        System.out.println("AAAA   \n\n");
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = request.getParameter(key);

            Cookie c3 = new Cookie(key, value);
            response.addCookie(c3);

        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Servlet 1</h1>");
        out.println("<a href=\"servlet2\">Ver cookies gravados</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}