<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <link rel="stylesheet" href="<spring:url value="/resources/css/style.css" />">
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
				<div class="col-md-11" style="padding-left:45px;">
					<h1 style = "padding-bottom: 20px"> Nhóm toán lớp 9 </h1>
					
					
					<div class="priority high" ><span style = "padding: 16px 10 16px 10; font-size:120%;"> Thông báo </span></div>
					<table style= "min-width: 100%;">
					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Phương trình đường thẳng </a> </div>
							<div> Tính ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture">  </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture">  </td>
					</tr>

					</table>

					<div class="priority low"><span style = "padding: 16px 10 16px 10; font-size:120%;"> Hỏi đáp </span></div>
					<table style= "min-width: 100%;">
					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Phương trình đường thẳng </a> </div>
							<div> Tính ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					</table >

					<div class="priority medium"><span style = "padding: 16px 10 16px 10; font-size:120%;"> Tài liệu </span></div>
					<table style= "min-width: 100%;">
					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Phương trình đường thẳng </a> </div>
							<div> Tính ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					<tr class="task high" style = "padding: 10px 0 10px 0">
						<td class="desc">
							<div class="title"> <a href='#'> [Bài tập]Công thức lượng giác </a> </div>
							<div> Chứng minh các công thức lượng giác sau ...</div>
						</td>
						
						<td style = "float:right; padding: 10px 10px 10px 10px " class="name"> 
								<div> Nguyễn Văn Kim </div>
								<div class="date" > 1 ngày trước </div>
						</td> 
						<td style = "float:right; padding: 10px 0 10px 0"> <img style = "height: 50px; width: 50px " src="<spring:url value="/resources/avatar/1.jpg" />" alt="User profile picture"> </td>
					</tr>

					</table>


					<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
						<div class="modal-content">
							<ul class="list-inline item-details">
								<li><a href="http://themifycloud.com">Admin templates</a></li>
								<li><a href="http://themescloud.org">Bootstrap themes</a></li>
							</ul>
						</div>
					</div>
					<div class="clearfix"></div>		
					
				</div>
				<div class="col-md-1"></div>	
						
			</div>
</section><!-- /.content -->
      </div><!-- /.content-wrapper -->
 