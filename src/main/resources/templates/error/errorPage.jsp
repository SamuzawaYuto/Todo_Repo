<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>エラー</title>
</head>
<body>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% if (errorMessage != null) { %>
    <div style="color: red;"><%= errorMessage %></div>
<% } %>
<a href="index.jsp">戻る</a>
</body>
</html>