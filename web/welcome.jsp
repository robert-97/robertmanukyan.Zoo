<%@ page import="com.demo.cookieFinder.CookieFinder" %>
<%--<%--%>
<%--if(CookieFinder.getCookie(request).getValue().equals("user")){--%>
<%--HttpServletResponse httpResponse = (HttpServletResponse) response;--%>
<%--httpResponse.sendRedirect("/welcome.jsp");--%>
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
        out.println("user role : " + CookieFinder.getCookie(request,"temp").getValue());
    %>
    <h3>You had successfully login.</h3>
    <form action="/">
        <button href="/" onclick="deleteCookie('temp')">Log Out</button>
    </form>
</div>

<div>
    <%
        if (CookieFinder.getCookie(request,"temp") != null) {
            if (CookieFinder.getCookie(request,"temp").getValue().equals("admin")) {

    %>
    <jsp:include page="innerPages/admin.jsp"/>
    <%
            }
        }

    %>
</div>
<%
    if (CookieFinder.getCookie(request,"temp") != null) {
        if (CookieFinder.getCookie(request,"temp").getValue().equals("user")) {
%>
<jsp:include page="innerPages/user.jsp"/>
<%
        }
    }
%>

<script src="resurse/js/index.js"></script>
<script src="resurse/js/userPageModal.js"></script>
</body>
</html>

