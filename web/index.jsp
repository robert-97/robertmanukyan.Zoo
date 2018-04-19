<%@ page import="com.demo.cookieFinder.CookieFinder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (CookieFinder.getCookie(request,"temp") != null) {
        HttpServletResponse httpResponse = response;
        httpResponse.sendRedirect("/welcome.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Flat HTML5/CSS3 Login Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="resurse/css/loginPageStyle.css">

</head>

<body>

<div class="login-page">
    <div class="form">
        <!--registration form-->
        <form class="register-form" action="/registration" method="post">
            <input type="text" name="name" placeholder="name" required />
            <input type="password" name="password" placeholder="password" required/>
            <input type="text" name="role" placeholder="role" required/>
            <button onclick="checkEmail">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>

        <!--login form-->

        <form class="login-form" action="/login" method="post">
            <input type="text" name="userName" placeholder="username" required/>
            <input type="password" name="password" placeholder="password" required/>
            <button>login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>

    </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="resurse/js/index.js"></script>

</body>

</html>
