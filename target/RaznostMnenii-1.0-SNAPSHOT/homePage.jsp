<%--
  Created by IntelliJ IDEA.
  User: pasandep
  Date: 25.09.2020
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Главная</title>
    <link rel="stylesheet" type="text/css" href="/style/homePageStyle.css">
</head>
<body>
<header>
    <a href="/homePage"><img src="/img/RaznostMneniiPNG.png" id="logo"></a>
    <a href="/ProfileServlet"><button id="toSignInBtn"><%=request.getSession().getAttribute("buttonValue")%></button></a>
    <div class="menu-sections">
        <div class="dropdown-news">
            <a id="current-menu-section" class="menu-sections-btns" id="dropbtn-news" href="/homePage">ГЛАВНАЯ</a>
            <div class="dropdown-content-news">
                <a href="/homePage?id=1">Единая Россия</a>
                <a href="/homePage?id=2">КПРФ</a>
                <a href="/homePage?id=3">ЛДПР</a>
                <a href="/homePage?id=4">СР</a>
            </div>
        </div>
        <a class="menu-sections-btns" href="/GovernmentPageServlet">ГОСУСТРОЙСТВО</a>
        <a class="menu-sections-btns" href="/GosdumaPageServlet">ГОСДУМА</a>
        <div class="dropdown-consignments">
            <a class="menu-sections-btns" id="dropbtn-consignments" href="#">ПАРТИИ</a>
            <div class="dropdown-content-consignments">
                <a href="/ConsignmentPage?id=1">Единая Россия</a>
                <a href="/ConsignmentPage?id=2">КПРФ</a>
                <a href="/ConsignmentPage?id=3">ЛДПР</a>
                <a href="/ConsignmentPage?id=4">СР</a>
            </div>
        </div>
        <a class="menu-sections-btns" href="/PutinPageServlet">ПУТИН</a>
        <a class="menu-sections-btns" href="/RegionsPageServlet">РЕГИОНЫ</a>

    </div>
</header>
<c:forEach items="${news}" var="news">
    <div class="news">
        <img id="news-pic" src="${news.newsPicture}">
        <h2 id="news-title">${news.title}</h2>
        <p id="news-content" style="max-width: 380px">${news.mainText}</p>
    </div>
</c:forEach>
</body>
</html>