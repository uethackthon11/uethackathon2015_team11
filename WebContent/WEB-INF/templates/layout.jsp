<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <!-- Bootstrap core CSS -->
    <link href="<spring:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<spring:url value="/resources/fonts/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<spring:url value="/resources/css/animate.min.css" />" rel="stylesheet">
    
    <!-- Custom styling plus plugins -->
    <link href="<spring:url value="/resources/css/custom.css" />" rel="stylesheet">
    <link href="<spring:url value="/resources/css/icheck/flat/green.css" />" rel="stylesheet">
    
</head>
<body class="nav-md" ng-app="myApp">
    <div class="container body">
        <div class="main_container">
			<tiles:insertAttribute name="header" ignore="true"/>
			<tiles:insertAttribute name="menu" ignore="true"/>
        	
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" ignore="true"/>
   		</div>

    	<div id="custom_notifications" class="custom-notifications dsp_none">
	        <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
	        </ul>
	        <div class="clearfix"></div>
	        <div id="notif-group" class="tabbed_notifications"></div>
   		</div>
  	</div>
	<script src="<spring:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js" />"></script>
    <!-- chart js -->
    <script src="<spring:url value="/resources/js/chartjs/chart.min.js" />"></script>
    <!-- bootstrap progress js -->
    <script src="<spring:url value="/resources/js/progressbar/bootstrap-progressbar.min.js" />"></script>
    <script src="<spring:url value="/resources/js/nicescroll/jquery.nicescroll.min.js" />"></script>
    <script src="<spring:url value="/resources/js/icheck/icheck.min.js" />"></script>
   	<script src="<spring:url value="/resources/js/custom.js" />"></script>
    <!-- PNotifi -->
    <!-- angular -->
        <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <%-- <script type="text/javascript" src="<spring:url value="/resources/js/angular/angular.min.js" />"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-sanitize.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/angular/angular-ui-router.min.js" />"></script>
	<script type="text/javascript" src="<spring:url value="/resources/js/angular/angular-confirm.js" />"></script>
     --%>
     <script type="text/javascript" src="<spring:url value="/resources/js/dirPagination.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/jsModule.js" />"></script>
    
    <script type="text/javascript" src="<spring:url value="/resources/js/notify/pnotify.core.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/notify/pnotify.buttons.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/notify/pnotify.nonblock.js" />"></script>
</body>
</html>