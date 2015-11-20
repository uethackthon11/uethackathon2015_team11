<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            User Profile
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Examples</a></li>
            <li class="active">User profile</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content" ng-controller="profileCtrl">

          <div class="row">
            <div class="col-md-3">

              <!-- Profile Image -->
              <div class="box box-primary">
                <div class="box-body box-profile">
                  <img class="profile-user-img img-responsive img-circle" src="<spring:url value="/resources/avatar/{{user.avatar}}" />" alt="User profile picture">
                  <h3 class="profile-username text-center">{{user.name}}</h3>
                  <p class="text-muted text-center">Học Sinh</p>

                  <ul class="list-group list-group-unbordered">
                    <li class="list-group-item">
                      <b>Ngày Sinh</b> <a class="pull-right"> {{user.birthdat | date : 'dd-M-yyy'}}</a>
                    </li>
                    <li class="list-group-item">
                      <b>Giới Tính</b> 
                      <a class="pull-right" ng-if="user.sex == 1"> Nam</a>
                      <a class="pull-right" ng-if="user.sex == 0"> Nữ</a>
                    </li>
                    <li class="list-group-item">
                      <b>Địa Chỉ</b> <a class="pull-right"> {{user.address}}</a>
                    </li>
                    <li class="list-group-item">
                      <b>Giới Thiệu</b> <a class="pull-right"> {{user.introduce}}</a>
                    </li>
                  </ul>

                  <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
                </div><!-- /.box-body -->
              </div><!-- /.box -->

            </div><!-- /.col -->
            <div class="col-md-9">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#activity" data-toggle="tab">Activity</a></li>
                  <li><a href="#timeline" data-toggle="tab">Bảng Điểm</a></li>
                </ul>
                <div class="tab-content">
                  <div class="active tab-pane" id="activity">
                    <!-- Post -->
                    <div class="post" ng-repeat="comment in comments">
                      <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="<spring:url value="/resources/avatar/{{comment.user.avatar}}" />" alt="user image">
                        <span class='username'>
                          <a href="#">{{comment.user.name}}</a>
                          <a href='#' class='pull-right btn-box-tool'><i class='fa fa-times'></i></a>
                        </span>
                        <span class='description'>{{comment.time | date : 'dd-M-yyyy HH:ss'}}</span>
                      </div><!-- /.user-block -->
                      <p>
                        {{comment.message}}
                      </p>
                      
                    </div><!-- /.post -->

                    
                      <form class='form-horizontal'>
                        <div class='form-group margin-bottom-none'>
                          <div class='col-sm-9'>
                            <input class="form-control input-sm" placeholder="Response">
                          </div>                          
                          <div class='col-sm-3'>
                            <button class='btn btn-danger pull-right btn-block btn-sm'>Send</button>
                          </div>                          
                        </div>                        
                      </form>
                   

                    
                  </div><!-- /.tab-pane -->
                  <div class="tab-pane" id="timeline">
                  	Bảng điểm ở đây
                  	
                  </div><!-- /.tab-pane -->

                </div><!-- /.tab-content -->
              </div><!-- /.nav-tabs-custom -->
            </div><!-- /.col -->
          </div><!-- /.row -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
