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
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
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
            <div class="table-responsive col-sm-8">
                <table class="table table-bordered col-md-8">
                    <h3>Holiday</h3>
                    <thead>
                        <tr><th>TotalDays</th><th>cntUsed</th><th>remain</th></tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><c:out value="${holiCnt.totalDays}"></c:out></td>
                        <td><c:out value="${holiCnt.cntUsed}"></c:out></td>
                        <td><c:out value="${holiCnt.remain}"></c:out></td>
                    </tr>
                    </tbody>
                </table><hr>
            </div>

            <div class="container-fluid">
                <h3>application</h3>
                <div class="row">
                    <div class='col-md-2 col-xs-4'>
                        <div class="form-group">
                            <div class="input-group date" data-target-input="nearest">
                                <input type="text" class="form-control datetimepicker-input" id="datetimepicker1" data-target="#datetimepicker1">
                                <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='col-md-2 col-xs-4'>
                        <div class="form-group">
                            <div class="input-group date" data-target-input="nearest">
                                <input type="text" class="form-control datetimepicker-input" id="datetimepicker2" data-target="#datetimepicker2">
                                <div class="input-group-append" data-target="#datetimepicker2" data-toggle="datetimepicker">
                                    <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class='col-md-2 col-xs-4'>
                        <select class="form-control" id="selectType">
                            <option id="allDayType">휴가</option>
                            <option id="halfDayType">반차</option>
                        </select>
                    </div>
                    <div class='col-sm-2'>
                        <button class="btn btn-primary" id="applyButton" onclick="applyButton()">신청</button>
                    </div>
                </div>
            </div>

            <div class="table-responsive col-8">
                <hr>
                <h3>holiday list</h3>
                <table class="table table-striped" id="originTable">
                    <thead><tr><th>no.</th><th>휴가유형</th><th>시작일</th><th>종료일</th><th>기간</th><th>상태</th><th></th></tr></thead>
                    <tbody></tbody>
                </table>
                <hr>
            </div>

        </main>
    </div>
</div>

<script>
    var list = "";

    $(document).ready(function(){
        list = ${holiList};
        loadListTable();
    });

    function cancelButton(holiNo){

        var holidayState = list[holiNo].state;
        var holidayEmpNo = list[holiNo].empNo;
        var holidayNo = list[holiNo].holiNo;

        if(holidayState === '사용') {
            alert("이미 사용한 휴가는 취소할 수 없음");
        }
        else if(holidayState === '반려'){
            alert("반려 처리된 휴가는 취소할 수 없음");
        }
        else{
            if(confirm("취소하시겠습니까?")==true){

                console.log(holidayState +"/"+ holidayEmpNo +"/"+ holidayNo);

                $.ajax({
                    url : "http://localhost:8080/cancelHoliday",
                    type : "DELETE",
                    contentType: "application/json; charset=utf-8",
                    dataType: "text",
                    data : JSON.stringify(
                        {
                            "empNo" : holidayEmpNo,
                            "holiNo" : holidayNo
                        }
                    ),
                    success: function (response){

                        console.log("response type : "+typeof response);

                        var result = JSON.parse(response);
                        console.log("result : " + result);
                        console.log("result.code : " + result.code);
                        console.log("Type of result.code : " + typeof result.code);

                        if(result.code === "0000"){
                            alert("삭제되었습니다.");
                            location.reload();
                        }
                    },
                    error:  function () {
                        console.log(Error);
                    }
                });
            }else {
                return ;
            }

        }
    }

    function loadListTable(){
        console.log(list);

        var html = "";

        for(var i=0; i < list.length; i++){
            var holi = list[i];

            html += '<tr>';

            html += '<td>' + (i+1) +'</td>';
            html += '<td>' + holi.holiType + '</td>';
            html += '<td>' + holi.startDate + '</td>';
            html += '<td>' + holi.endDate + '</td>';
            html += '<td>' + holi.duration + '</td>';
            html += '<td>' + holi.state + '</td>';
            html += '<td><input type="button" class="btn btn-danger btn-sm" value="취소" onclick="cancelButton(' + i +')"></td>';

            html += '</tr>';
        }
        $('#originTable > tbody').append(html);
    }

    function applyButton(){
        var holidayEmpNo = '8';
        var dateStart = Date.parse($('#datetimepicker1').val());
        var dateEnd = Date.parse($('#datetimepicker2').val());
        var dayOffType = $('#selectType').val();
        var half = $('#halfDayType').val();

        console.log(typeof dateStart);

        if ((dateStart !== dateEnd) && (dayOffType === half)){
            alert('날짜를 다시 확인해주세요.');
        }
        else if((dateStart === dateEnd) && (dayOffType === half)){
            if(confirm("반차를 신청하시겠습니까?")==true){
                callApply();
            }
            else return;
        }
        else {
            if(confirm("휴가를 신청하시겠습니까?")==true){
                callApply();
            }
        }

        // 휴가 신청 api 호출
        function callApply(){
            $.ajax({
                url : "http://localhost:8080/applyHoliday",
                type : "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "text",
                data : JSON.stringify(
                    {
                        "startDate" : dateStart,
                        "endDate" : dateEnd,
                        "holiType" : dayOffType,
                        "empNo" : holidayEmpNo
                    }
                ),
                success: function (response){

                    console.log("response type : "+typeof response);

                    var result = JSON.parse(response);
                    console.log("result : " + result);
                    console.log("result.code : " + result.code);
                    console.log("Type of result.code : " + typeof result.code);

                    if(result.code === "0000"){
                        console.log("refresh");
                        location.reload();
                    }
                },
                error:  function () {
                    console.log("오류 : "+ Error);
                }
            });
        }
    }

    // datepicker
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
<%--<script>window.jQuery || document.write('<script src="/js/jquery.min.js"><\/script>')</script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"--%>
<%--        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
</body>
</html>
