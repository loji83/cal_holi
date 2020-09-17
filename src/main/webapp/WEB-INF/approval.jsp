<%--
  Created by IntelliJ IDEA.
  User: KST
  Date: 2020-09-17
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Holiday</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-expand-sm fixed-top navbar-light" style="background-color: #dcdcdc">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">
            <img src="https://www.ksmartech.com/images/common/ksmartech_logo.png" height="20"
                 class="d-inline-block align-top" alt="">
        </a>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Applications<span class="sr-only">(current)</span></a>
                </li>
            </ul>

            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Approval</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">ffff</a>
                </li>
            </ul>
        </nav>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <h2>Approval</h2>
            <hr>
            <div class="table-responsive col-8">
                <h3><br>holiday list</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>no.</th>
                        <th>휴가유형</th>
                        <th>시작일</th>
                        <th>종료일</th>
                        <th>기간</th>
                        <th>상태</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${approvalList}" var="list">
                        <tr>
                            <td><c:out value="${list.holiNo}"></c:out></td>
                            <td><c:out value="${list.holiType}"></c:out></td>
                            <td><c:out value="${list.startDate}"></c:out></td>
                            <td><c:out value="${list.endDate}"></c:out></td>
                            <td><c:out value="${list.duration}"></c:out></td>
                            <td><c:out value="${list.state}"></c:out></td>
                            <td>
                            <button type="button" class="btn btn-primary" onclick="clickButton()">승인</button>
                                <button type="button" class="btn btn-danger" onclick="clickButton()">반려</button>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>

                </table>
                <c:forEach items="${approvalList}" var="appr">
                    <p>${appr}</p>
                </c:forEach>

            </div>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/js/jquery.min.js"><\/script>')</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
