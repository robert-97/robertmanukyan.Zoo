<%@ page import="com.demo.dao.ZooDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.models.Cage" %>
<%--
  Created by IntelliJ IDEA.
  User: robert.manukyan
  Date: 14.04.2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resurse/css/userPageStyle.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../resurse/js/ajax.js"></script>
</head>
<body>

<div class="margin-left">
    <h2>Cages</h2>
    <%
        ZooDao zooDao = new ZooDao();
        List<Cage> cages = zooDao.getCages();

        for (Cage cage : cages) {
    %>
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"
            id="cageNumber<%out.print(cage.getCageNumberID());%>"
            onclick="getAnimals('<%out.print(cage.getCageNumberID());%>')"><%out.print(cage.getCageNumber());%></button>
    <%
        }
    %>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Cage</h4>
                </div>
                <div class="modal-body" id="animals-info">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>