<%--
  Created by IntelliJ IDEA.
  User: pasandep
  Date: 15.10.2020
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Профиль</title>
    <link rel="stylesheet" type="text/css" href="/style/profilePageStyle.css">
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
<div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center">
            <div class="col-xl-6 col-md-12">
                <div class="card user-card-full">
                    <div class="row m-l-0 m-r-0">
                        <div class="col-sm-4 bg-c-lite-green user-profile">
                            <center>
                                <div class="card-block text-center text-white">
                                    <div class="m-b-25"> <img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image"> </div>
                                    <h1 class="f-w-600"><%=request.getSession().getAttribute("username")%></h1>
                                </div>
                            </center>
                        </div>
                        <div class="col-sm-8">
                            <div class="card-block">
                                <center><h6 class="m-b-20 p-b-5 b-b-default f-w-600">Информация</h6></center>
                                <center><div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10 f-w-600">Дата регистрации</p>
                                        <h6 class="text-muted f-w-400"><%=request.getSession().getAttribute("createDateTime")%></h6>
                                    </div>
                                </div>
                                </center>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
