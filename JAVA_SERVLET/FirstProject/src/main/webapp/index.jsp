<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

<%!
int myDouble(int x) {
  return 2*x;
}
%>

<%
  out.println("myDouble(5) = " + Integer.toString(myDouble(5)));
%>

myDouble(2) = <%=myDouble(2)%>

<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<br><br>

<jsp:useBean id="fibo" class="com.firstproject.firstproject.Fibonacci"></jsp:useBean>
<%=fibo.fibStr(2)%>

</body>
</html>