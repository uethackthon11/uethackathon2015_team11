<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<input class="hidden" value="${student_name}" id="student" />
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
            <div class="col-md-4">

              <!-- Profile Image -->
              <div class="box box-primary">
                <div class="box-body box-profile">
                  <img class="profile-user-img img-responsive img-circle" src="<spring:url value="/resources/avatar/{{user.avatar}}" />" alt="User profile picture">
                  <h3 class="profile-username text-center">{{user.name}}</h3>
                  <p class="text-muted text-center">Học Sinh</p>

                  <ul class="list-group list-group-unbordered">
                    <li class="list-group-item">
                      <b>Ngày Sinh</b> <a class="pull-right"> {{user.birthday | date : 'dd-M-yyyy'}}</a>
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
            <div class="col-md-8">
            	<div id="container" class="box box-primary" style="width: 700px; margin: 0 auto"></div>
            </div>
            </div>
            <div class="row">
            <div class="col-md-12">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#activity" data-toggle="tab">Nhận Xét Của Giáo Viên</a></li>
                  <li><a href="#timeline" data-toggle="tab">Bảng Điểm</a></li>
                </ul>
                <div class="tab-content">
                  <div class="active tab-pane" id="activity">
                    <!-- Post -->
                    <div class="post" ng-repeat="comment in comments">
                      <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="<spring:url value="/resources/avatar/{{comment.avatar}}" />" alt="user image">
                        <span class='username'>
                          <a href="#">{{comment.writer}}</a>
                          <a href='#' class='pull-right btn-box-tool'><i class='fa fa-times'></i></a>
                        </span>
                        <span class='description'>{{comment.time | date : 'dd-M-yyyy HH:ss'}}</span>
                      </div><!-- /.user-block -->
                      <p>
                        {{comment.content}}
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
                  	<section class="content">
          <div class="row">
          </div><!-- /.row -->
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Bảng điểm học kỳ 1</h3>
                  <div class="box-tools">
                    <div class="input-group" style="width: 150px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-bordered table-hover" style=" border: 2px solid #cccccc">
                    <tr>
                      <th rowspan="3" style="text-align: center; vertical-align: middle">STT</th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle" class="col-xs-2">Môn học</th>
                      <th colspan="9" style="text-align: center"> Điểm </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle"> Cuối kỳ </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle"> TB môn </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle" class="col-xs-2"> Report </th>
                    </tr>

                    <tr>
                      <th colspan="6" style="text-align: center"> Hệ số 1 </th>
                      <th colspan="3" style="text-align: center"> Hệ số 2 </th>
                    </tr>

                     <tr>
                      <th colspan="3" style="text-align: center"> Điểm miệng </th>
                      <th colspan="3" style="text-align: center"> Điểm viết </th>
                      <th colspan="3" style="text-align: center"> Điểm viết </th>
                    </tr>

                    <!-- <tr>
                      <th style="text-align: center">  </th>
                      <th style="text-align: center">  </th>
                      <th style="text-align: center">  </th>
                      <th style="text-align: center"> (1) </th>
                      <th style="text-align: center"> (2) </th>
                      <th style="text-align: center"> (3) </th>
                      <th style="text-align: center"> (4) </th>
                      <th style="text-align: center"> (1) </th>
                      <th style="text-align: center"> (2) </th>
                      <th style="text-align: center"> (3) </th>
                      <th style="text-align: center"> (4) </th>
                      <th style="text-align: center"> (1) </th>
                      <th style="text-align: center"> (2) </th>
                      <th style="text-align: center"> (3) </th>
                      <th style="text-align: center"> (1) </th>
                    </tr> -->

                    <tr ng-repeat="subject in subjects">
                      <td style="text-align: center">{{$index + 1}}</td>
                      <td style="text-align: center">{{subject.name}}</td>
                      <td style="text-align: center">subject.score[0].score</td>
                      <td style="text-align: center">subject.score[1].score</td>
                      <td style="text-align: center">subject.score[2].score</td>
                      <td style="text-align: center">subject.score[3].score</td>
                      <td style="text-align: center">subject.score[4].score</td>
                      <td style="text-align: center">subject.score[5].score</td>
                      <td style="text-align: center">subject.score[6].score</td>
                      <td style="text-align: center">subject.score[7].score</td>
                      <td style="text-align: center">subject.score[8].score</td>
                      <td style="text-align: center">subject.score[9].score</td>
                      <td style="text-align: center"> 7.5</td>
                      <td style="text-align: center"><button class="btn btn-warning"><i class="fa fa-mail-forward"></i></button></td>
                    </tr>

                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>
        </section><!-- /.content -->
                  	
                  <!-- </div>/.tab-pane
                  <div class="tab-pane" id="statistic">
                  		Thống Kê ở Đây
                  		<div id="container" style="width: 100%; height: 600px; margin: 0 auto"></div>
                  		
                  </div> -->

                </div><!-- /.tab-content -->
              </div><!-- /.nav-tabs-custom -->
            </div><!-- /.col -->
          </div><!-- /.row -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
