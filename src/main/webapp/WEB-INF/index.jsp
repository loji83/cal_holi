<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: KST
  Date: 2020-09-15
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Holiday</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
</head>
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
                    <a class="nav-link active" href="#">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Applications</a>
                </li>
            </ul>

            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">Show Approval</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Approval</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">One more nav</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Another nav item</a>
                </li>
            </ul>
        </nav>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <h2>Holiday</h2><hr>
            <div class="table-responsive col-sm-6">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>TotalDays</th>
                        <th>cntUsed</th>
                        <th>remain</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>15</td>
                        <td>2</td>
                        <td>13</td>
                    </tr>
                    </tbody>
                </table>
            </div>
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
                        <th> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>연차</td>
                        <td>2020-08-14</td>
                        <td>2020-08-15</td>
                        <td>2</td>
                        <td>사용</td>
                        <td>
                             <!--<button type="button" class="btn btn-primary">승인</button>  -->
                            <button type="button" class="btn btn-danger">취소</button>
                        </td>
                    </tr>
                    <tr>
                        <td>1,002</td>
                        <td>amet</td>
                        <td>consectetur</td>
                        <td>adipiscing</td>
                        <td>elit</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <hr>
            <div class="container">
                <%= request.getAttribute("holiCnt")%>
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
