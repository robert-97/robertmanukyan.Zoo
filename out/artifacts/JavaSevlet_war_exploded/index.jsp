<%@ page import="com.demo.Cookies" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>

  <%--if(!("".equals(Cookies.getCookie(request).getValue()))){--%>
    <%--HttpServletResponse httpResponse = response;--%>
    <%--httpResponse.sendRedirect("/empty.jsp");--%>
  <%--}--%>
<%--%>--%>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Flat HTML5/CSS3 Login Form</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" href="resurse/css/style.css">

</head>

<body>

<div class="login-page">
  <div class="form">

    <form class="register-form" action="/registration" method="post">
      <input type="text" name="name" placeholder="name"/>
      <input type="password" name="password" placeholder="password"/>
      <input type="text" name="role" placeholder="role"/>
      <button onclick="checkEmail">create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>

    <form class="login-form" action="/login"  method="post">
      <input type="text" name="userName" placeholder="username"/>
      <input type="password" name="password" placeholder="password"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>

  </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script  src="resurse/js/index.js"></script>

</body>

</html>
