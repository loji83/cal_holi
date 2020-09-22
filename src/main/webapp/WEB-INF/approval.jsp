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

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css"/>

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
                    <a class="nav-link" href="#">Applications</a>
                </li>
            </ul>

            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Approval<span class="sr-only">(current)</span></a>
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
                <table class="table table-striped" id="approvalTable">
                    <thead>
                        <tr><th>휴가번호</th><th>사원번호</th><th>휴가유형</th><th>시작일</th><th>종료일</th><th>기간</th><th>상태</th><th></th></tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>

            </div>
        </main>
    </div>
</div>
<script>
    var list = "";

    $(document).ready(function(){
        list = ${approvalList};
        reloadListTable();
    });

    function reloadListTable(){

        console.log(list);

        var html = "";

        for(var i=0; i < list.length; i++){
            var holi = list[i];

            html += '<tr>';

            html += '<td>' + (i+1) +'</td>';
            html += '<td>' + holi.empNo + '</td>';
            html += '<td>' + holi.holiType + '</td>';
            html += '<td>' + holi.startDate + '</td>';
            html += '<td>' + holi.endDate + '</td>';
            html += '<td>' + holi.duration + '</td>';
            html += '<td>' + holi.state + '</td>';
            html += '<td><input type="button" class="btn btn-primary btn-sm" value="승인" onclick="cancelButton(' + i +')">' +
                    '<input type="button" class="btn btn-danger btn-sm" value="반려" onclick="cancelButton(' + i +')"></td>';

            html += '</tr>';
        }
        $('#approvalTable > tbody').append(html);
    }

    function clickButton() {

    }
</script>
</body>
</html>
