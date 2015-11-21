<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <input class="hidden" value="${groupId}" id="groupId"/>
<!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Diễn Đàn Trao Đổi
          </h1>
        </section>

        <!-- Main content -->
        <section class="content" ng-controller="groupCtrl">

          <!-- row -->
          <div class="row">
            <div class="col-md-12">
              <!-- The time line -->
              <ul class="timeline">
                <!-- timeline time label -->
                <li class="time-label">
                  <span class="bg-red">
                    Thông báo
                  </span>
                </li>
                <!-- /.timeline-label -->
                <!-- timeline item -->
                <li ng-repeat="post in group.thongBaos">
                  <i class="fa fa-user bg-aqua"></i>
                  <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> {{post.dateTime | date: 'dd-M-yyyy HH:ss'}}</span>
                    <h3 class="timeline-header"><a href="#">{{post.title}}</h3>
                    <div class="timeline-body" style="padding-left: 20px; margin-bottom: 10px; margin-top: 10px">
                      {{post.content}}
                    </div>
                    <div class="timeline-footer">
                      <a href="http://localhost:8080/SpringProject/group/${groupId}/status/{{post.id}}" class="btn btn-warning btn-flat btn-xs">Xem chủ đề</a>
                    </div>
                  </div>
                </li>
                <!-- END timeline item -->
                <!-- timeline time label -->
                <li class="time-label">
                  <span class="bg-green">
                    Hỏi Đáp
                  </span>
                </li>
                <!-- /.timeline-label -->
                <!-- timeline item -->
                <li ng-repeat="post in group.hoiDaps">
                  <i class="fa fa-comments bg-yellow"></i>
                  <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> {{post.dateTime | date: 'dd-M-yyyy HH:ss'}}</span>
                    <h3 class="timeline-header"><a href="#">{{post.title}}</h3>
                    <div class="timeline-body">
                      {{post.content}}
                    </div>
                    <div class="timeline-footer">
                      <a href="http://localhost:8080/SpringProject/group/${groupId}/status/{{post.id}}" class="btn btn-primary btn-flat btn-xs">Xem chủ đề</a>
                    </div>
                  </div>
                </li>
                 <li class="time-label">
                  <span class="bg-green">
                   	Tài Liệu
                  </span>
                </li>
                <li ng-repeat="post in group.taiLieus">
                  <i class="fa fa-envelope bg-blue"></i>
                  <div class="timeline-item">
                    <span class="time"><i class="fa fa-clock-o"></i> {{post.dateTime | date: 'dd-M-yyyy HH:ss'}}</span>
                    <h3 class="timeline-header"><a href="#">{{post.title}}</h3>
                    <div class="timeline-body">
                      {{post.content}}
                    </div>
                    <div class="timeline-footer">
                      <a href="http://localhost:8080/SpringProject/group/${groupId}/status/{{post.id}}" class="btn btn-warning btn-flat btn-xs">Xem chủ đề</a>
                    </div>
                  </div>
                </li>
                <!-- END timeline item -->
                <!-- timeline item -->
                <!-- END timeline item -->
                <li>
                  <i class="fa fa-clock-o bg-gray"></i>
                </li>
              </ul>
            </div><!-- /.col -->
          </div><!-- /.row -->
</section>
</div>