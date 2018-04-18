<%@ page import="com.demo.dao.ZooDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.models.Cage" %>
<%--
  Created by IntelliJ IDEA.
  User: robert.manukyan
  Date: 14.04.2018
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resurse/css/adminPageStyle.css">


</head>
<body>
<form action="AnimalAdder" method="get">
    Cage number:<br>
    <%
        ZooDao zooDao = new ZooDao();
        List<Cage> cages = zooDao.getCages();
    %>
    <select name="cageNumber" required>
        <%
            for (Cage cage : cages) {
        %>
        <option value="<%out.println(cage.getCageNumberID());%>"><%out.println(cage.getCageNumber());%></option>
        <%
            }
        %>
    </select><br>
    Animal type:<br>
    <input type="text" name="animalType" required><br>
    Animal name:<br>
    <input type="text" name="animalName" required><br>
    <input type="submit" value="Add">
</form>

</body>
</html>
