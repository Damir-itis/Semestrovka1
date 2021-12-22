<%--
  Created by IntelliJ IDEA.
  User: pasandep
  Date: 25.10.2020
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>${name}</title>
    <link rel="stylesheet" type="text/css" href="/style/ConsignmentPageStyle.css">
</head>
<body>
<header>
    <a href="/homePage"><img src="/img/RaznostMneniiPNG.png" id="logo"></a>
    <a href="/ProfileServlet"><button id="toSignInBtn"><%=request.getSession().getAttribute("buttonValue")%></button></a>
    <div class="menu-sections">
        <div class="dropdown-news">
            <a class="menu-sections-btns" id="dropbtn-news" href="/homePage">ГЛАВНАЯ</a>
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
            <a id="current-menu-section" class="menu-sections-btns" id="dropbtn-consignments" href="#">ПАРТИИ</a>
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
    <center><h1 id="consignment-name">${name}</h1></center>
    <img id="consignment-picture" src=${consignmentPicture}>
    <p><img id="leader-image" src="${leaderPicture}">${consignmentDescription}</p>
    <br>
    <h2>Здесь вы можете обсудить деятельность данной партии: </h2>
    <form method="post" action="/ConsignmentPage">
        <textarea id="comment-area" name="comment" cols="100" rows="5"></textarea>
        <br>
        <input id="send-button" type="submit" value="Отправить">
        <input id="clear-button" type="reset" value="Очистить">
    </form>
    <c:forEach items="${comments}" var="comment">
        <hr>
        <h3>${comment.authorUsername}</h3>
        <p>${comment.commentText}</p>
        <p>${comment.commentTimeOfCreate}</p>
    </c:forEach>
    <hr>
</body>
</html>
