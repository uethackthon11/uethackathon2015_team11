<div class="login-box">
      <div class="login-logo">
        <a href="../../index2.html"><b>Admin</b>LTE</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <div class="row">
				<div class="col-md-4 col-md-offset-4">
		            <img src="http://phongdep.vn/sites/default/files/default_images/no-avatar.jpg" style="max-width: 100px;max-height: 100px;" class="img-circle profile_img"/>
				</div>
			</div>
	    	<br/>
	    	<form action="login" method="POST">
	    		
	    		<div class="alert alert-danger hidden" role="alert" id="error">
					${error}
				</div>
	    	
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
			            <input type="text" class="form-control has-feedback-left" name="id" placeholder="ID" required>
			            <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
			            <input type="text" class="form-control has-feedback-left" name="password" placeholder="Password" required>
			            <span class="fa fa-lock form-control-feedback left" aria-hidden="true"></span>
					</div>
				</div>
				<div class="clearfix"></div>
				<br/>
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
			           <input type="submit" class="btn btn-primary pull-right" value="Log In" />
					</div>
				</div>
			</form>


      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
<script>

$('body').removeClass('skin-blue').removeClass('sidebar-mini').addClass('login-page');

$(document).ready(function(){
	if($.trim($('#error').text()) != '')
		$('#error').removeClass('hidden');
});

</script>