var app = angular.module('myApp', ['angularUtils.directives.dirPagination']);
app.controller('scoreCtrl', function($scope, $http) {
	
	$scope.currentPage = 1;
	$scope.pageSize = 5;
	/*for (i = ($scope.currentPage-1)*$scope.pageSize; i < $scope.pageSize; i++) {
		$scope.selectState[data[i].fb_id] = 0;
	}*/
	
	$scope.classes = [
	                 {id: '12a3',name:'12A3'},
	                 {id: '12a2',name:'12A2'},
	                 {id: '12a1',name:'12A1'},
	               ];
	$scope.students = [];
	$scope.class_selected = function($class){
		$http.get("thuylt/class/" + $class.id)
		.success(function(data){
			$scope.students = data;
			console.log($scope.students);
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
	
	/*$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/profile/query")
	.success(function(data){
		$scope.user = data;
	});*/
	$scope.user = {id: '1',avatar: '4.jpg' ,name:'Nguyễn Văn Hợp', birthday: 1447219609527, sex: 1, address: 'Mê Linh - Hà Nội', introduce:'hehe'};
	
	$scope.comments = [
	                   {
	                	   message : "Học giỏi, ngoan ngoãn",
		                   time : 1447219609527,
		                   user : {
		                	   name : "Vương Thị Hồng",
		                	   avatar : "1.jpg"
		                   }
	                   },
	                   {
	                	   message : "Học giỏi, ngoan ngoãn",
		                   time : 1447219609527,
		                   user : {
		                	   name : "Nguyễn Văn Kim",
		                	   avatar : "2.jpg"
		                   }
	                   },
	                   {
	                	   message : "Học giỏi, ngoan ngoãn",
		                   time : 1447219609527,
		                   user : {
		                	   name : "Đậu Mạnh Quang",
		                	   avatar : "3.jpg"
		                   }
	                   }
	                   ];
});
app.controller("commentCtrl" , function($scope, $http){
	
	$http.get("http://localhost:8080/SpringProject/" + $('#id').val() + "/comment")
	.success(function(data){
		$scope.comments = data;
	});
	
});