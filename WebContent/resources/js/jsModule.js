var app = angular.module('myApp', ['angularUtils.directives.dirPagination']);
app.controller('scoreCtrl', function($scope, $http) {
	
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	/*for (i = ($scope.currentPage-1)*$scope.pageSize; i < $scope.pageSize; i++) {
		$scope.selectState[data[i].fb_id] = 0;
	}*/
	
	$scope.classes = [];
	$scope.students = [];
	$scope.copyData = [];
	
	$http.get($('#rootPath').val() + "/class")
	.success(function(data){
		$scope.classes = data;
		console.log(data);
	});
	
	$scope.editable = [];
	$scope.class_selected = function($class){
		$http.get($('#rootPath').val() + "/class/" + $class.classDetail.id + "/student/" + $class.subjectId)
		.success(function(data){
			console.log(data);
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
			for(var i = 0 ; i < data.length ; i++)
				$scope.editable[data[i].studentDetail.userId] = 0;
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
		
	};
	$scope.cancel = function($student){
		$scope.editable[$student.studentDetail.userId] = 0;
		$scope.students = angular.copy($scope.copyData);
	}
	
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
	
	/*$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/profile/query")
	.success(function(data){
		$scope.user = data;
	});*/
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	$scope.user = {};
	
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
	});
	
	$scope.addComment = function(){
		console.log("fdff");
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
					 	console.log("haha");
			            new PNotify({
			                title: "Thành công",
			                type: "success",
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
		});
		
		
		
	};
});
/*app.controller("commentCtrl" , function($scope, $http){
	
	$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/comment")
	.success(function(data){
		$scope.comments = data;
	});
	
});*/