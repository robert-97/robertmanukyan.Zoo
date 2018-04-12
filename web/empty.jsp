<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.demo.Cookies" %>
<%--<%--%>
    <%--if(Cookies.getCookie(request).getValue().equals("user")){--%>
        <%--HttpServletResponse httpResponse = (HttpServletResponse) response;--%>
        <%--httpResponse.sendRedirect("/empty.jsp");--%>
    <%--}--%>
<%--%>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="resurse/css/welcomePageStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>


    <div class="float-right" id="user-name-label">
        <%
            out.println("user role : " + Cookies.getCookie(request).getValue()) ;
        %>
        <h3>You had successfully login.</h3>
        <form action="/">
            <button href="/" onclick="deleteCookie('auth')">Log Out</button>
        </form>
    </div>

    <div>
    <%
        if( Cookies.getCookie(request)!= null) {
            if(Cookies.getCookie(request).getValue().equals("admin")){

    %>
        <form action="CageAdder" method="get">
            Cage number:<br>
            <input type="text" name="cageNumber"><br>
            Animal type:<br>
            <input type="text" name="animalType"><br>
            Animal name:<br>
            <input type="text" name="animalName"><br>
            <button>add</button>
        </form>
    <%
            }
        }

    %>

    </div>
    <%
         if( Cookies.getCookie(request)!= null) {
             if(Cookies.getCookie(request).getValue().equals("user")){

             }
         }
    %>


<script src="resurse/js/index.js"></script>
</body>
</html>

