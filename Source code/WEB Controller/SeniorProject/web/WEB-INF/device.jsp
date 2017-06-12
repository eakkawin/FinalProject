<%-- 
    Document   : dashboard
    Created on : Aug 26, 2016, 7:39:08 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Automate Classroom</title>

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />       
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="assets/global/css/components-md.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="assets/global/css/plugins-md.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="assets/layouts/layout3/css/layout.css" rel="stylesheet" type="text/css" />
        <link href="assets/layouts/layout3/css/themes/default.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/layouts/layout3/css/custom.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <!-- END HEAD -->


    </head>
    <body>
    <body class="page-container-bg-solid page-md">
        <div class="page-wrapper">
            <div class="page-wrapper-row">
                <div class="page-wrapper-top">
                    <!-- BEGIN HEADER -->
                    <div class="page-header">
                        <!-- BEGIN HEADER TOP -->
                        <div class="page-header-top fix-header">
                            <div class="container">
                                <!-- BEGIN LOGO -->
                                <div class="page-logo">

                                    <h3>Automate Classroom</h3>

                                </div>
                                <!-- END LOGO -->
                                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                                <a href="javascript:;" class="menu-toggler"></a>
                                <!-- END RESPONSIVE MENU TOGGLER -->
                                <!-- BEGIN TOP NAVIGATION MENU -->
                                <div class="top-menu">
                                    <ul class="nav navbar-nav pull-right">
                                        <li class="dropdown dropdown-user dropdown-dark" style="padding: 0px 10px;">
                                            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true" style="background-color: transparent;height:50px;">
                                                <img src="assets/pic/user.png">
                                                <span class="username username-hide-mobile">Welcome, ${user.username}</span>
                                            </a>
                                            <ul class="dropdown-menu dropdown-menu-default">
                                                <li>
                                                    <a href="page_user_profile_1.html" class="user-menu">
                                                        <i class="icon-user"></i> My Profile 
                                                    </a>
                                                </li>
                                                <c:if test="${sessionScope.user.role == 'admin'}">                  
                                                    <li>
                                                        <a href="AddUser" class="user-menu">
                                                            <i class="icon-plus"></i> Add user
                                                        </a>
                                                    </li>
                                                </c:if>
                                                <li class="divider"> </li>
                                                <li>
                                                    <a href="Logout" class="user-menu">
                                                        <i class="icon-key"></i> Log Out </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <!-- END USER LOGIN DROPDOWN -->
                                    </ul>
                                </div>
                                <!-- END TOP NAVIGATION MENU -->
                            </div>
                        </div>
                        <!-- END TOP Header top -->
                        <!-- BEGIN HEADER MENU -->
                        <div class="page-header-menu fix-menu">
                            <div class="container">
                                <!-- BEGIN HEADER SEARCH BOX -->
                                <form class="search-form" action="/AdminSearch" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search" name="query">
                                        <span class="input-group-btn">
                                            <a href="javascript:;" class="btn submit">
                                                <i class="icon-magnifier"></i>
                                            </a>
                                        </span>
                                    </div>
                                </form>
                                <!-- END HEADER SEARCH BOX -->
                                <!-- BEGIN MEGA MENU -->
                                <!-- DOC: Apply "hor-menu-light" class after the "hor-menu" class below to have a horizontal menu with white background -->
                                <!-- DOC: Remove data-hover="dropdown" and data-close-others="true" attributes below to disable the dropdown opening on mouse hover -->
                                <div class="hor-menu  ">
                                    <ul class="nav navbar-nav">
                                        <li class="menu-dropdown classic-menu-dropdown">
                                            <a href="Login"> Home </a>
                                        </li>
                                        <li class="menu-dropdown classic-menu-dropdown active">
                                            <a href="Manage">Manage</a>
                                        </li>
                                        <li class="menu-dropdown classic-menu-dropdown">
                                            <a href="Transaction"> Log </a>
                                        </li>
                                        </li>
                                        <li class="menu-dropdown classic-menu-dropdown">
                                            <a href="About"> About </a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- END MEGA MENU -->
                            </div>
                        </div>
                        <!-- END HEADER MENU -->

                    </div>
                </div>
            </div>
            <!-- middle-->
            <div class="page-wrapper-row full-height">
                <div class="page-wrapper-middle">
                    <!-- BEGIN CONTAINER -->
                    <div class="page-container">
                        <!-- BEGIN CONTENT -->
                        <div class="page-content-wrapper">
                            <!-- BEGIN CONTENT BODY -->
                            <!-- BEGIN PAGE HEAD-->
                            <div class="page-head margin-ph">
                                <div class="container">
                                    <!-- BEGIN PAGE TITLE -->
                                    <div class="page-title">
                                        <h1>Train-1
                                            <small>All devices you can manage</small>
                                        </h1>
                                    </div>
                                    <!-- END PAGE TITLE -->
                                </div>



                            </div>
                            <!-- BEGIN PAGE CONTENT BODY -->
                            <div class="page-content">
                                <div class="container">
                                    <div class="page-content block-white-status ">
                                        <div class="title_device">
                                            Status
                                            <hr>
                                        </div>
                                        <div class="col-md-12">

                                            <c:forEach items="${devices}" var="device" varStatus="vs">
                                                <div class="col-md-3">
                                                    <div class="portlet light">
                                                        <div class="portlet-title">
                                                            <div class="caption center-title">

                                                                <a href="DeviceLog?id=${device.deviceId}">
                                                                    <c:if test="${vs.count<=12}">
                                                                        <img src="assets/pic/light-bulb.png">
                                                                        <span>Light ${device.deviceId}</span>
                                                                    </c:if>
                                                                    <c:if test="${vs.count==13}">
                                                                        <img src="assets/pic/projector.png">
                                                                        <span>Projector</span>
                                                                    </c:if>
                                                                    <c:if test="${vs.count==14}">
                                                                        <img src="assets/pic/powerstrip.png">
                                                                        <span>Powerbar</span>
                                                                    </c:if>
                                                                    <c:if test="${vs.count==15||vs.count==16}">
                                                                        <img src="assets/pic/air-conditioner.png">
                                                                        <span>Air condition</span>
                                                                    </c:if>
                                                                    <c:if test="${vs.count==17}">
                                                                        <img src="assets/pic/tiny-pc.png">
                                                                        <span>PC</span>
                                                                    </c:if>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <div class="status" name="status" id="${device.status}">Status : ${device.status}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                </form>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="page-content block-white-manage device-block">
                                        <div class="title_device" id="device-block">
                                            Device
                                            <hr>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="col-md-3 re-padding">
                                                <ul class="nav navbar-nav box">
                                                    <li class="dropdown dropdown-user dropdown-dark box">
                                                        <a href="javascript:;" class="dropdown-toggle border-box" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">

                                                            <img class="margin-left-5" src="assets/pic/light-bulb.png"/><span class="username username-hide-mobile margin-left-20">Light<span class="show-left-arrow light-dropbtn"></span></span>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-default" style="width: 100%">

                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">Light first row</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="21">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="21">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="divider"> </li>                
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">Light second row</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="22">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="22">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="divider"> </li>
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">Light third row</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="23">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="23">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="divider"> </li> 
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">All light</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="24">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="24">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                                <ul class="nav navbar-nav box">
                                                    <li class="dropdown dropdown-user dropdown-dark box">
                                                        <a href="javascript:;" class="dropdown-toggle border-box" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                                            <img class="margin-left-5" src="assets/pic/air-conditioner.png"/><span class="username username-hide-mobile margin-left-20">Air condition<span class="show-left-arrow air-dropbtn"></span> </span>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-default" style="width: 100%">
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">Left air condition</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="16">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="16">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="divider"> </li>
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">Right air condition</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="17">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="17">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                            <li class="divider"> </li>
                                                            <li class="dropdown-submenu">
                                                                <a class="subsmenu-onoff" tabindex="-1" href="#">All air condition</a>
                                                                <ul class="dropdown-menu">
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="25">
                                                                            <input type="hidden" name="content" value="ON">
                                                                            <button type="submit" class="full-btn">Turn On</button>
                                                                        </form>
                                                                    </li>
                                                                    <li>
                                                                        <form action="Turning" method="post">
                                                                            <input type="hidden" name="device_id" value="25">
                                                                            <input type="hidden" name="content" value="OFF">
                                                                            <button type="submit" class="full-btn">Turn Off</button>
                                                                        </form>
                                                                    </li>
                                                                </ul>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                                <ul class="nav navbar-nav box">
                                                    <li class="dropdown dropdown-user dropdown-dark box">
                                                        <a href="javascript:;" class="dropdown-toggle border-box" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                                            <img class="margin-left-5" src="assets/pic/projector.png"/><span class="username username-hide-mobile margin-left-20">Projector<span class="show-left-arrow proj-dropbtn"></span> </span>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-default" style="width: 100%">
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="13">
                                                                    <input type="hidden" name="content" id="projector" value="ON">
                                                                    <button type="submit" class="button-device border-box">Turn On</button>
                                                                </form>
                                                            </li>
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="13">
                                                                    <input type="hidden" name="content" id="projector" value="OFF">
                                                                    <button type="submit" class="button-device border-box">Turn Off</button>
                                                                </form>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                                <ul class="nav navbar-nav box">
                                                    <li class="dropdown dropdown-user dropdown-dark box">
                                                        <a href="javascript:;" class="dropdown-toggle border-box" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                                            <img class="margin-left-5" src="assets/pic/powerstrip.png"/><span class="username username-hide-mobile margin-left-20">Powerbar<span class="show-left-arrow pwb-dropbtn"></span> </span>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-default" style="width: 100%">
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="15">
                                                                    <input type="hidden" name="content" value="ON">
                                                                    <button type="submit" class="button-device border-box">Turn On</button>
                                                                </form>
                                                            </li>
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="15">
                                                                    <input type="hidden" name="content" value="OFF">
                                                                    <button type="submit" class="button-device border-box">Turn Off</button>
                                                                </form>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                                <ul class="nav navbar-nav box">
                                                    <li class="dropdown dropdown-user dropdown-dark box">
                                                        <a href="javascript:;" class="dropdown-toggle border-box" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                                                            <img class="margin-left-5" src="assets/pic/tiny-pc.png"/><span class="username username-hide-mobile margin-left-20">PC<span class="show-left-arrow pc-dropbtn"></span> </span>
                                                        </a>
                                                        <ul class="dropdown-menu dropdown-menu-default" style="width: 100%">
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="18">
                                                                    <input type="hidden" name="content" value="ON">
                                                                    <button type="submit" class="button-device border-box">Turn On</button>
                                                                </form>
                                                            </li>
                                                            <li>
                                                                <form action="Turning" method="post">
                                                                    <input type="hidden" name="device_id" value="18">
                                                                    <input type="hidden" name="content" value="OFF">
                                                                    <button type="submit" class="button-device border-box">Turn Off</button>
                                                                </form>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>

                                            </div>

                                            <div class="col-md-9 float-r">
                                                <c:forEach items="${devices}" var="device" varStatus="vs">
                                                    <c:if test="${vs.count<13}">
                                                        <form action="Turning" method="post">
                                                            <div class="col-md-3">
                                                                <div class="portlet light">
                                                                    <div class="portlet-title">
                                                                        <div class="caption center-title">

                                                                            <img src="assets/pic/light-bulb.png"/> Light ${device.deviceId}
                                                                        </div>
                                                                    </div>
                                                                    <div class="portlet-body">
                                                                        <!--<div class="status">Status : ${device.status}</div>-->
                                                                        <input type="hidden" name="device_id" value="${device.deviceId}">
                                                                        <input type="hidden" name="content" value="${device.status== "ON"?"OFF": "ON"}">
                                                                        <div class="form-body">
                                                                            <div class="form-actions">
                                                                                <div class="row">
                                                                                    <div class="status">
                                                                                        <a href="#device-block"><button type="submit" class="btn default">${device.status== "ON"?"TURN OFF": "TURN ON"}</button></a>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END PAGE CONTENT BODY -->
                </div>
            </div>

        </div>
    </div>

    <!-- end middle -->
    <!-- Botttom Banner -->
    <div class="page-wrapper-row">
        <div class="page-wrapper-bottom">
            <!-- BEGIN FOOTER -->
            <!-- BEGIN PRE-FOOTER -->
            <div class="page-prefooter">
                <div class="container">
                    <div class="row">
                        <!--                                <div class="col-md-4 col-sm-6 col-xs-12 footer-block">
                                                            <img src="assets/pic/sit.png">
                                                        </div>-->
                        <div class="col-md-12 col-sm-12 col-xs-12 footer-block" style="text-align: center;">
                            <h2>About</h2>
                            <p style="width: 25%;margin: auto;">  The system manage rooms of SIT. Helping infrastructure more efficiency , faster , easier. </p>
                        </div>
                        <!--                                <div class="col-md-4 col-sm-6 col-xs-12 footer-block">
                                                            <img src="assets/pic/KMUTT.png" width="100px" height="100px">
                                                        </div>-->




                    </div>
                </div>
            </div>
            <!-- END PRE-FOOTER -->
            <!-- BEGIN INNER FOOTER -->
            <div class="page-footer">
                <div class="container" style="text-align: center;">
                    2016 &copy;SIT KMUTT
                </div>
            </div>
            <div class="scroll-to-top">
                <i class="icon-arrow-up"></i>
            </div>
            <!-- END INNER FOOTER -->
            <!-- END FOOTER -->
        </div>
    </div>

    <!--END BOTTOM -->
</div>


</body>





















<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>  

<script src="assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js" type="text/javascript"></script>
<script src="assets/global/plugins/ckeditor/ckeditor.js" type="text/javascript"></script>    
<script src="assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>

<!--script>
$("#form_sample_2").validate();
</script-->

<script src="assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="assets/pages/scripts/form-validation.min.js" type="text/javascript"></script>
<script>
    function myFunction(id) {
        var x = document.getElementById(id);
        if (x.className.indexOf("w3-show") == -1) {
            x.className += " w3-show";
        } else {
            x.className = x.className.replace(" w3-show", "");
        }
    }
</script>
</html>
