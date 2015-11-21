<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Simple Tables
            <small>preview of simple tables</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Tables</a></li>
            <li class="active">Simple</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content" ng-controller="scoreCtrl">
          <div class="row">
          </div><!-- /.row -->
          <div class="row">
            <div class="col-xs-12">
              <div class="box">
                <div class="box-header" style="margin-top: 10px">
                  <select style="padding: 5px" ng-model="myClass" ng-change='class_selected(myClass)' ng-options="class.subjectName + ' - ' + class.classDetail.name for class in classes">
                  		<option value="">---Please select---</option>
                  </select>
                  <div class="box-tools">
                    <div class="input-group" style="width: 250px;">
                      <input type="text" name="table_search" class="form-control input-sm pull-right" placeholder="Search">
                      <div class="input-group-btn">
                        <button class="btn btn-sm btn-primary">Tìm kiếm</button>
                      </div>
                    </div>
                  </div>
                </div><!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                  <table class="table table-bordered table-hover">
                    <tr>
                      <th rowspan="3" style="text-align: center; vertical-align: middle">STT</th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle" class="col-xs-2" middle">Họ tên</th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle" class="col-xs-1" >Ngày sinh</th>
                      <th colspan="9" style="text-align: center"> Điểm </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle"> Cuối kỳ </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle"> TB môn </th>
                      <th rowspan="3" style="text-align: center; vertical-align: middle"> Hoạt động </th>
                    </tr>

                    <tr>
                      <th colspan="6" style="text-align: center"> Hệ số 1 </th>
                      <th colspan="3" style="text-align: center" class="col-xs-2"> Hệ số 2 </th>
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

                    <tr ng-repeat="student in students" style="padding:2px">
                      <td style="text-align: center">{{$index + 1}}</td>
                      <td style="text-align: center">{{student.studentDetail.name}}</td>
                      <td style="text-align: center">{{student.studentDetail.birthday | date:'dd-M-yyyy'}}</td>
                      <td style="text-align: center">6</td>
                      <td style="text-align: center"> 8.5</td>
                      <td style="text-align: center"> 7</td>
                      <td style="text-align: center"> 7</td>
                      <td style="text-align: center"> 7.5</td>
                      <td style="text-align: center"> 8.5</td>
                      <td style="text-align: center"> 6.5</td>
                      <td style="text-align: center"> 8.5</td>
                      <td style="text-align: center"> 9</td>
                      <td style="text-align: center"> 8</td>
                      <td style="text-align: center"> 8.5</td>
                      <td style="text-align: center"> </td>
                    </tr>

                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->