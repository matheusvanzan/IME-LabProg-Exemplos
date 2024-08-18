// Gravr cookies
Cookie c1 = new Cookie("universidade", "ime");
response.addCookie(c1);

c2 = new Cookie("disciplina", "lab-prog-3");
response.addCookie(c2);

out.println("<a href=\"servlet2\">Cookies gravados</>");

// Ler cookies
Cookie[] c = request.getCookies();

for (Cookie cookie : c) {
  out.println("<h3>");
  out.println(cookie.getName() + " : " + cookie.getValue() + " - Tempo: " + cookie.getMaxAge());
  out.println("</h3>");
}
