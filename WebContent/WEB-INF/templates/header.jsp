<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="main-header">
	    <meta charset="utf-8">
	<!-- Logo -->
	<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/logo2.png" />" alt="User profile picture"></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"> HighSchool Support</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav" ng-controller="notificationCtrl">
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">{{notifications.length}}</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">Bạn có {{notifications.length}} thông báo mới!</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu" ng-repeat="notification in notifications">
									<li ng-if="notification.type==3">
										<a href="#" style="white-space:initial"> 
											<i class="fa fa-warning text-red"></i>
											<b>{{notification.sender_name}}</b> đã gửi yêu cầu xem lại điểm của họ
										</a>
									</li>
									<li ng-if="notification.type==2">
										<a href="#" style="white-space:initial"> 
											<i class="fa fa-commenting-o text-green"></i>
											<b>{{notification.sender_name}}</b> đã nhận xét về bạn
										</a>
									</li>
									<li ng-if="notification.type==1">
										<a href="#" style="white-space:initial"> 
											<i class="fa fa-flag text-aqua"></i>
											<b>{{' ' + notification.sender_name}}</b> đã cập nhật điểm của bạn
										</a>
									</li>
									
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul></li>
				<!-- Tasks: style can be found in dropdown.less -->
				<li class="dropdown tasks-menu">
					<ul class="dropdown-menu">
						<li class="footer"><a href="#">View all tasks</a></li>
					</ul>
				</li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu" style="margin-right: 10px">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img
						src="<spring:url value="/resources/avatar/${avatar}" />"
						class="user-image" alt="User Image"> <span class="hidden-xs">${name}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-primary btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="${pageContext.request.contextPath}/logout"
									class="btn btn-warning btn-flat">Sign out</a>
							</div>
						</li>
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
			</ul>
		</div>
	</nav>
</header>
