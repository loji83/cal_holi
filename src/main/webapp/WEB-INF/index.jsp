<%--
Created by IntelliJ IDEA.
  User: KST
  Date: 2020-09-15
  Time: 오후 3:05
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

    <!-- datepicker-->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css"/>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css"/>
    <!-- Include Date Range Picker -->
    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css"/>
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
        <nav class="col-sm-2 col-md-2 hidden-xs-down bg-faded sidebar">
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
                    <a class="nav-link" href="#">Approval</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">fff</a>
                </li>
            </ul>
        </nav>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <div class="table-responsive col-sm-6">
                <table class="table table-bordered">
                    <h3>Holiday</h3>
                    <thead>
                    <tr>
                        <th>TotalDays</th>
                        <th>cntUsed</th>
                        <th>remain</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><c:out value="${holiCnt.totalDays}"></c:out></td>
                        <td><c:out value="${holiCnt.cntUsed}"></c:out></td>
                        <td><c:out value="${holiCnt.remain}"></c:out></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive col-8">
                <hr>
                <h3>holiday list</h3>
                <table class="table table-striped" id="originTable">
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
                    <tbody id="originTbody">

                    </tbody>
                </table>
                <hr>
            </div>
            <div class="container-fluid">
                <h3>application</h3>
                <div class="row">
                    <div class='col-md-2 col-xs-4'>
                        <div class="form-group">
                            <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                                <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1">
                                <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='col-md-2 col-xs-4'>
                        <div class="form-group">
                            <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                                <input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker2">
                                <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='col-md-2 col-xs-4'>
                        <select class="form-control">
                            <option>반차</option>
                            <option>휴가</option>
                        </select>
                    </div>
                    <div class='col-sm-2'>
                        <button class="btn btn-primary" id="applyButton" onclick="applyButton()">신청</button>
                    </div>
                </div>
            </div>

        </main>
    </div>
    <script>
        var list = "";
        $(document).ready(function(){
            list = ${holiList};
            reloadListTable();

        });

        function cancelButton(holiNo){

            console.log(list[holiNo].state);
            var holidayState = list[holiNo].state;
            var used = '사용';
            $.ajax({
                url : "localhost:8080/cancelHoliday",
                success: function (){
                    removeListTable();
                    reloadListTable();
                },
                error: function (holidayState) {
                    if(holidayState === used){
                        alert("이미 사용한 휴가는 취소할 수 없음");
                    }
                }
            });

        }

        function removeListTable(){
            $('#originTbody').empty();
        }

        function reloadListTable(){

            console.log(list);
            var html = "";

            for(var i=0; i < list.length; i++){
                var holi = list[i];

                html += '<tr><td>' + (i+1) +'</td><td>' + holi.holiType + '</td><td>' + holi.startDate + '</td><td>' + holi.endDate + '</td><td>' + holi.duration + '</td><td>' + holi.state
                    + '</td><td><input type="button" class="btn btn-danger btn-sm" value="취소" onclick="cancelButton('
                    + i
                    +')"></td></tr>';

            }
            $('#originTbody').html(html);
        }
    </script>
</div>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'YYYY/MM/DD',
            daysOfWeekDisabled: [0, 6],
            timepicker: false,
            minDate: 0
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY/MM/DD',
            useCurrent: false,
            daysOfWeekDisabled: [0, 6],
            timepicker: false,
            minDate: 0
        });

        $("#datetimepicker1").on("change.datetimepicker", function (e) {
            $('#datetimepicker2').datetimepicker('minDate', e.date);
        });

        $("#datetimepicker2").on("change.datetimepicker", function (e) {
            $('#datetimepicker1').datetimepicker('maxDate', e.date);
        });

    });
</script>


<!-- Bootstrap core JavaScript================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>window.jQuery || document.write('<script src="/js/jquery.min.js"><\/script>')</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
