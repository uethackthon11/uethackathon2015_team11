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

                    <tr ng-repeat="student in students" style="padding:5px">
                      <td style="text-align: center; width: 15px">{{$index + 1}}</td>
                      <td style="text-align: center">{{student.studentDetail.name}}</td>
                      <td style="text-align: center">{{student.studentDetail.birthday | date:'dd-M-yyyy'}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[0].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[0].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[1].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[1].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[2].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[2].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[3].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[3].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[4].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[4].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[5].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[5].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[6].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[6].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[7].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[7].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[8].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[8].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[9].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[9].score"/></td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 0">{{student.scores[10].score}}</td>
                      <td style="text-align: center; width: 50px" ng-if="editable[student.studentDetail.userId] == 1" ><input style="width: 50px" ng-model="student.scores[10].score"/></td>
                      <td style="text-align: center; width: 50px">
                      		<button class="btn btn-primary" ng-if="editable[student.studentDetail.userId] == 0" ng-click="editable[student.studentDetail.userId] = 1"><i class="fa fa-edit"></i></button>
                      		<button class="btn btn-success" ng-if="editable[student.studentDetail.userId] == 1" ng-click="update(student)"><i class="fa fa-check"></i></button>
                      		<button class="btn btn-warning" ng-if="editable[student.studentDetail.userId] == 1" ng-click="cancel(student)"><i class="fa fa-close"></i></button>
                      </td>
                    </tr>

                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
          </div>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->