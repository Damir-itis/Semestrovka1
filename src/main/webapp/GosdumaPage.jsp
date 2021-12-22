<%--
  Created by IntelliJ IDEA.
  User: pasandep
  Date: 05.11.2020
  Time: 02:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Госдума</title>
    <link rel="stylesheet" type="text/css" href="/style/GosdumaPageStyle.css">
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
        <a id="current-menu-section" class="menu-sections-btns" href="#">ГОСДУМА</a>
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
<center><h2>ГОСУДАРСТВЕННАЯ ДУМА</h2></center>
<h3>Государственная Дума состоит из 450 депутатов. Депутаты Государственной Думы избираются от различных политических партий, общественных движений либо как независимые кандидаты сроком на 4 года и работают на профессиональной постоянной основе.</h3>
<h3>К ведению Государственной Думы относятся:</h3>
<ul>
    <li>дача согласия Президенту РФ на назначение Председателя Правительства страны;</li>
    <li>решение вопроса о доверии Правительству РФ;</li>
    <li>назначение на должность и освобождение от должности Председателя Центрального банка;</li>
    <li>назначение на должность и освобождение от должности Уполномоченного по правам человека;</li>
    <li>объявление амнистии;</li>
    <li>выдвижение обвинения против Президента РФ для отрешения его от должности.</li>
</ul>
<img src="img/Gosduma.jpg" id="gosduma-picture">
<p id="gosduma-text">Государственная Дума является одной из двух палат российского парламента – Федерального Собрания. К ее ведению относится принятие федеральных конституционных законов и федеральных законов, контроль деятельности Правительства Российской Федерации, назначение и освобождение от должности руководителей Центрального банка и Счетной палаты, Уполномоченного по правам человека, объявление амнистии, вопросы международного парламентского сотрудничества.
    Всем салют! Не знаю, успете ли вы это увидеть, но я хочу передать всем огромный привет! Мне кажется, вся наша группа хорошо справилась с семестровкой. Да, пусть у некоторых что-то ещё не работает, но ведь главное - это старания, которые мы вложили. Все люди в нашей группе - не дураки и не будут подводить как своих товарищей по команде, так и Катю.
    Ну а если вдруг вы не вложили даже капельку сил в этот проект, что ж, грустненько выходит. Не забывайте, вы работаете в команде, ваши товарищи надеются на вас, а препод видит в вас отражение знаний, которые он вам дал. Не расстривайте себя, товарищей, Катю! Обнял</p>
</body>
</html>
