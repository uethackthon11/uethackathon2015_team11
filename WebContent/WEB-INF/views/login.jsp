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
	    		<section>
						<div class="form-group">
		    				<div class="input-group">
			      				<div class="input-group-addon"><span class="text-primary fa fa-user"></span></div>
								<input type="text" class="form-control has-feedback-left" name="id" placeholder="ID" required>
							</div>
						</div>
						<div class="form-group">
		    				<div class="input-group">
			      				<div class="input-group-addon"><span class="text-primary fa fa-lock"></span></div>
								<input type="text" class="form-control has-feedback-left" name="password" placeholder="Password" required>
							</div>
						</div>
						
						<div class="form-group">
							<input type="checkbox" name="remember" value="1" /> Remember me
						</div>
						
						<button type="submit" value="Log In" class="btn btn-block btn-success">Sign in</button>
					</section>
					<div>
						<a href="#">Forgot password ?</a>
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