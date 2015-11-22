<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li ng-i="${role} == 1">
              <a href="${pageContext.request.contextPath}/${username}/profile">
                <i class="fa fa-th"></i> <span>Thông Tin Cá Nhân</span>
              </a>
            </li>
            <li ng-i="${role} == 3 || ${role} == 0">
              <a href="${pageContext.request.contextPath}/home">
                <i class="fa fa-th"></i> <span>Danh sách lớp học</span>
              </a>
            </li>
            <!-- <li class="active treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
                <li><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
              </ul>
            </li> -->
            <li class="treeview" ng-if="${role} == 1">
              <a href="#">
                <i class="fa fa-group"></i>
                <span>Group môn học</span>
              </a>
              <ul class="treeview-menu" >
                <li><a href="${pageContext.request.contextPath}/group/1"><i class="fa fa-circle-o"></i> Group môn toán</a></li>
                <li><a href="${pageContext.request.contextPath}/group/2"><i class="fa fa-circle-o"></i> Group môn hóa</a></li>
                <li><a href="${pageContext.request.contextPath}/group/3"><i class="fa fa-circle-o"></i> Group môn lí</a></li>
              </ul>
            </li>
            
            <li class="treeview" ng-if="${role} == 3">
              <a href="#">
                <i class="fa fa-group"></i>
                <span>Group môn học</span>
              </a>
              <ul class="treeview-menu" >
                <li><a href="${pageContext.request.contextPath}/group/1"><i class="fa fa-circle-o"></i> Group môn toán</a></li>
              </ul>
            </li>
            
            <li class="treeview" ng-if="${role} == 0">
              <a href="${pageContext.request.contextPath}/avg_grade">
                <i class="fa fa-pie-chart"></i>
                <span>Thống Kê Cuối Năm</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
            </li>
            
            
            <li>
              <a href="${pageContext.request.contextPath}/calendar" ng-if="${role} != 3">
                <i class="fa fa-calendar"></i> <span>Lịch học</span>
                <small class="label pull-right bg-red">3</small>
              </a>
            </li>
            
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>