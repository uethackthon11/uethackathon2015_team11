<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <link rel="stylesheet" href="<spring:url value="/resources/css/style.css" />">
   <input class="hidden" value="${groupId}" id="groupId" />
   <input class="hidden" value="${statusId}" id="statusId" />
<!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            User Profile
          </h1>
        </section>

        <!-- Main content -->
        <section class="content" ng-controller="statusCtrl">

            <div class="row">
            <div class="col-md-12">
              <div class="nav-tabs-custom">
                <!-- <ul class="nav nav-tabs">
                  <li class="active"><a href="#activity" data-toggle="tab">Chi tiết bài đăng</a></li>
                </ul> -->
                <div class="tab-content" style="border: 1px solid #ff00ff">
                  <div class="active tab-pane" id="activity">
                    <!-- Post -->
                    <div class="post">
                      <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="<spring:url value="/resources/avatar/{{status.writerDetail.avatar}}" />" alt="user image">
                        <span class='username'>
                          <a href="#">{{status.writerDetail.name}}</a>
                          <a href='#' class='pull-right btn-box-tool'><i class='fa fa-times'></i></a>
                        </span>
                        <span class='description'>{{comment.dateTime | date : 'dd-M-yyyy HH:ss'}}</span>
                      </div><!-- /.user-block -->
                      <p>
                        {{status.content}}
                      </p>
                      <ul class="list-inline">
                        <li class="pull-right"><a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments (5)</a></li>
                      </ul>
						
                    </div><!-- /.post -->
				
                </div><!-- /.tab-content -->
								<input class="form-control input-sm" id="new_comment" type="text" placeholder="Type a comment">
								<br/>
								<button class="btn btn-primary" ng-click="addComment()">Bình luận</button>
              </div><!-- /.nav-tabs-custom -->
              
            </div><!-- /.col -->




		<div class="row">
            <div class="col-md-12">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#activity" data-toggle="tab">Bình luận</a></li>
                </ul>
                <div class="tab-content">
                  <div class="active tab-pane" id="activity">
                    <!-- Post -->
                    <div class="post" dir-paginate="comment in status.commentDetails | itemsPerPage: pageSize" current-page="currentPage">
                      <div class="user-block">
                        <img class="img-circle img-bordered-sm" src="<spring:url value="/resources/avatar/{{comment.writerDetail.avatar}}" />" alt="user image">
                        <span class='username'>
                          <a href="#">{{comment.writerDetail.name}}</a>
                          <a href='#' class='pull-right btn-box-tool'><i class='fa fa-times'></i></a>
                        </span>
                        <span class='description'>{{comment.dateTime | date : 'dd-M-yyyy HH:ss'}}</span>
                      </div><!-- /.user-block -->
                      <p>
                        {{comment.content}}
                      </p>
                      <ul class="list-inline">
                        <li><a href="#" ng-click="likeComment(comment)" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                      </ul>

                    </div><!-- /.post -->
					<div class="text-right" style="margin-top: -10px">
			          	<dir-pagination-controls boundary-links="true" on-page-change="pageChangeHandler(newPageNumber)" template-url="http://localhost:8080/SpringProject/resources/dirPagination.tpl.html"></script>"></dir-pagination-controls>
			        </div>
				
                </div><!-- /.tab-content -->
              </div><!-- /.nav-tabs-custom -->
            </div><!-- /.col -->
          </div><!-- /.row -->




        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->