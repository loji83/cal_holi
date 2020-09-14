<%--
  Created by IntelliJ IDEA.
  User: KST
  Date: 2020-09-14
  Time: 오후 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>

    <link rel="stylesheet" href="css/bootstrap.css">

    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap.min.datepicker.js"></script>



    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Container wrapper -->
        <div class="container-fluid">
            <!-- Navbar brand -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    <img src="https://www.ksmartech.com/images/common/ksmartech_logo.png" height="20" class="d-inline-block align-top" alt="">
                </a>
            </div>


            <!-- Collapsible wrapper -->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <!-- Left links -->
                <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Apply</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Check</a>
                    </li>
                    <!-- Navbar dropdown -->
                    <li class="nav-item dropdown">
                        <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-expanded="false"
                        >
                            TeamLeader
                        </a>
                        <!-- Dropdown menu -->
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider" /></li>
                            <li>
                                <a class="dropdown-item" href="#">Approval</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"
                        >Disabled</a
                        >
                    </li>
                </ul>

            </div>
            <!-- Collapsible wrapper -->
        </div>
        <!-- Container wrapper -->
    </nav>
</head>

<body>
<div class="container">
    <div class="row">
       <div class="col-4">
           <h2>linked picker</h2>
           <p>These are two individual date and time pickers, of which, one is used to select start date and time and the other is used to select end date and time.</p>
           <!-- datepicker -->
           <div class="row">
               <div class="col-sm-6">
                   <div class="form-group pmd-textfield pmd-textfield-floating-label">
                       <label class="control-label" for="datepicker-start">Start Date</label>
                       <input type="text" class="form-control" id="datepicker-start">
                   </div>
               </div>
               <div class="col-sm-6">
                   <div class="form-group pmd-textfield pmd-textfield-floating-label">
                       <label class="control-label" for="datepicker-end">End Date</label>
                       <input type="text" class="form-control" id="datepicker-end">
                   </div>
               </div>
           </div>
       </div>
        <div class="col-8">
            <h2>first row col4</h2>
        </div>
    </div>
</div>

</body>
</html>
