<div class="login-box">
      <div class="login-logo">
        <a href="../../index2.html"><b>Highschool</b> Support</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <div class="row">
				<div class="col-md-3 col-md-offset-3">
		            <img src="resources/avatar/logo2.png" style="max-width: 150px;max-height: 150px;" class="img-circle profile_img"/>
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