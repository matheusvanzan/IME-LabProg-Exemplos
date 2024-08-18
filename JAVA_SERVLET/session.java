// Gravar
HttpSession session = request.getSession();
session.setAttribute("username", "ricardofranco");

out.println("<a href=\"servlet-2\">verificar</a>");

// Ler
HttpSession session = request.getSession();
String sessao = (String) session.getAttribute("username");

out.println("Usuário logado (sessão): " + sessao);