var app = angular.module('myApp', ['angularUtils.directives.dirPagination']);
app.controller('scoreCtrl', function($scope, $http) {
	
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	/*for (i = ($scope.currentPage-1)*$scope.pageSize; i < $scope.pageSize; i++) {
		$scope.selectState[data[i].fb_id] = 0;
	}*/
	
	$scope.studentComment = {};
	
	$scope.classes = [];
	$scope.students = [];
	$scope.copyData = [];
	$scope.commentStatus = [];
	$scope.comment = {studentId : 0, comment : ""};
	
	$http.get($('#rootPath').val() + "/class")
	.success(function(data){
		$scope.classes = data;
	});
	
	$scope.editable = [];
	$scope.class_selected = function($class){
		$http.get($('#rootPath').val() + "/class/" + $class.classDetail.id + "/student/" + $class.subjectId)
		.success(function(data){
			$scope.students = data;
			for(var i = 0 ; i < data.length ; i++){
				for(var j = 0 ; j < data[i].scores.length ; j++){
					if(data[i].scores[j].score == -1){
						data[i].scores[j].score = '';
					}
				}
			}
			console.log(data);
			$scope.copyData = angular.copy(data);
			for(var i = 0 ; i < data.length ; i++){
				$scope.editable[data[i].studentDetail.userId] = 0;
				$scope.commentStatus[data[i].studentDetail.userId] = 0;
			}
		});
	};
	
	$scope.update = function($student){
		$scope.editable[$student.studentDetail.userId] = 0;
		$scope.copyData = angular.copy($scope.students);
		
		$http({
				url : $('#rootPath').val() + "/class/update_score",
				data : $student,
				method  : 'POST',
		       contentType: "application/json",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
		})
		.success(function(){
			
			$(function () {
	            new PNotify({
	                title: "Thành công",
	                type: "primary",
	                text: "Đã update điểm của " + $student.studentDetail.name,
	                nonblock: {
	                    nonblock: true
	                },
	                before_close: function (PNotify) {
	                    PNotify.update({
	                        title: PNotify.options.title + " - Enjoy your Stay",
	                        before_close: null
	                    });
	                    PNotify.queueRemove();
	                    return false;
	                }
	            });

	        });
			
			$http({
				url : $('#rootPath').val() + "/add_notification",
				params : {
					type : 1,
					recieverId : $student.studentDetail.userId
				},
				method  : 'POST',
		       contentType: "application/json",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
			})
			
		});
		
	};
	$scope.cancel = function($student){
		$scope.editable[$student.studentDetail.userId] = 0;
		$scope.students = angular.copy($scope.copyData);
	}
	
	$scope.clickAddComment = function($student){
		console.log($student);
		$scope.comment.studentId = $student.studentDetail.userId;
		console.log($scope.comment)
	}
	
	$scope.addComment = function($comment){
		
		$http({
			
			url : $('#rootPath').val() + "/" + $comment.studentId + "/profile/add_comment",
			method : 'POST',
			data : {
				'message' : $comment.comment,
			},
			contentType: "application/json",
		    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
			
		})
		.success(function(){
			$scope.comment.comment = "";
			$(function () {
	            new PNotify({
	                title: "Thành công",
	                type: "warning",
	                text: "Đã thêm 1 nhận xét mới.",
	                nonblock: {
	                    nonblock: true
	                },
	                before_close: function (PNotify) {
	                    PNotify.update({
	                        title: PNotify.options.title + " - Enjoy your Stay",
	                        before_close: null
	                    });
	                    PNotify.queueRemove();
	                    return false;
	                }
	            });

	        });
			
			$http({
				url : $('#rootPath').val() + "/add_notification",
				params : {
					type : 2,
					recieverId : $comment.studentId
				},
				method  : 'POST',
		       contentType: "application/json",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
			})
		});
		
	};
	
    /*var data = [{id: '1',name:'Jani',birthday:'16/11/1994',mouth_score: '9',middle_score:'9',final_score:'10'},
				{id: '2',name:'Mark',birthday:'17/11/1994',mouth_score: '5',middle_score:'3',final_score:'6'},
				{id: '3',name:'Tin',birthday:'18/11/1994',mouth_score: '8',middle_score:'7',final_score:'8'}]
    $scope.editable = [];
    
    for(var i = 0 ; i < data.length ; i++){
    	$scope.editable[data[i].id] = false;
    }
    
    $scope.names = angular.copy(data);
    $scope.edit = false;*/
});
app.controller("profileCtrl" , function($scope, $http){
	
	
	$scope.viewerId = $('#viewerId').val();
	$scope.studentId = $('#studentId').val();
	/*$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/profile/query")
	.success(function(data){
		$scope.user = data;
	});*/
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.user = {};
	$scope.reportScore = {
			teacherId : 1,
			scoreType : '',
			col : 1
	};
	
	$http.get($('#rootPath').val() + "/" + $('#student').val() + "/user_detail")
	.success(function(data){
		$scope.user = data;
	});
	
	$scope.comments = [];
	
	$http.get($('#rootPath').val() + "/" + $('#student').val() + "/comments")
	.success(function(data){
		$scope.comments = data;
	});
	
	$scope.subjects = [];
	
	$http.get($('#rootPath').val() + "/" + $('#student').val() + "/scores")
	.success(function(data){
		$scope.subjects = data;
		console.log(data);
	});
	
	$scope.addComment = function(){
		$http({
			
			url : $('#rootPath').val() + "/" + $('#student').val() + "/profile/add_comment",
			method : 'POST',
			data : {
				'message' : $('#comment').val(),
			},
			contentType: "application/json",
		    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
			
		})
		.success(function(){
			$http.get($('#rootPath').val() + "/" + $('#student').val() + "/comments")
			.success(function(data){
				$('#comment').val("");
				$scope.comments = data;
				 $(function () {
			            new PNotify({
			                title: "Thành công",
			                type: "warning",
			                text: "Đã thêm 1 nhận xét mới.",
			                nonblock: {
			                    nonblock: true
			                },
			                before_close: function (PNotify) {
			                    PNotify.update({
			                        title: PNotify.options.title + " - Enjoy your Stay",
			                        before_close: null
			                    });
			                    PNotify.queueRemove();
			                    return false;
			                }
			            });

			        });
			});
			$http({
				url : $('#rootPath').val() + "/add_notification",
				params : {
					type : 2,
					recieverId : $('#studentId').val()
				},
				method  : 'POST',
		       contentType: "application/json",
		       headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
			})
		});
		
	};
	
	$scope.report = function(){
		
		console.log($scope.reportScore);
		
		$http({
			url : $('#rootPath').val() + "/add_notification",
			params : {
				type : 3,
				recieverId : $scope.reportScore.teacherId,
				message : $scope.reportScore.scoreType,
				col : $scope.reportScore.col
			},
			method  : 'POST',
	       contentType: "application/json",
	       headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'}
		})
		.success(function(){
			$(function () {
	            new PNotify({
	                title: "Thành công",
	                type: "warning",
	                text: "Đã gửi 1 yêu cầu xem lại điểm.",
	                nonblock: {
	                    nonblock: true
	                },
	                before_close: function (PNotify) {
	                    PNotify.update({
	                        title: PNotify.options.title + " - Enjoy your Stay",
	                        before_close: null
	                    });
	                    PNotify.queueRemove();
	                    return false;
	                }
	            });

	        });
		});
		
	};
});

app.controller("notificationCtrl", function($scope,$http){
	
	$scope.notifications = [];
	
	$http.get($('#rootPath').val() + "/" + $('#id_user').val() + "/notification")
	.success(function(data){
		$scope.notifications = data;
		console.log(data);
	});
	
});
/*app.controller("commentCtrl" , function($scope, $http){
	
	$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/comment")
	.success(function(data){
		$scope.comments = data;
	});
	
});*/