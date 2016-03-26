<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 29.03.2016
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Process </title>
</head>
<body>

<form action="/process" method="post">
<textarea name="text"></textarea>

    <select name="Operation">
        <option value="symbol" selected> Количество символов </option>
        <option value="word"> Количество слов </option>
        <option value="sentence"> Количество предложений </option>
        <option value="paragraph"> Количество абзацев </option>
    </select>
<input type="submit" value="Process">
  <h3>  ${message}</h3>
</form>
</body>
</html>
