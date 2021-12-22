<%--
  Created by IntelliJ IDEA.
  User: pasandep
  Date: 06.11.2020
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Упс!</title>
    <link rel="stylesheet" type="text/css" href="/style/ErrorPageStyle.css">
</head>
<body>
<center><h1 id="error"><%=request.getAttribute("error")%></h1></center>
<center><h1>Ой... что-то упало =(</h1></center>
<center><a href="/homePage">ГЛАВНАЯ</a> </center>
<video autoplay muted loop
       style="position: absolute; z-index: -1; left: 50%;  transform: translateX(-50%); top: 0; max-width: 100%; max-height: 100%;  min-width: 100%; min-height: 100%; opacity: 0.4; overflow: hidden;">
    <source src="img/LeninFalls.mp4" type="video/mp4">
</video>
</body>
</html>
