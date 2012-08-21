<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" language="javascript" >
    $(document).ready(function () {
          $('.dropdown-toggle').dropdown();
    }); 
 </script>
 
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="#">Project name</a>
			<ul class="nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
			<ul class="nav pull-right">
				<li id="fat-menu" class="dropdown">
					<a href="#" id="drop1" role="button" class="dropdown-toggle" data-toggle="dropdown">
						Login
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
						<li>
							<a tabindex="-1" href="#">Facebook</a>
						</li>
						<li>
							<a tabindex="-1" href="#">Twitter</a>
						</li>
						<li>
							<a tabindex="-1" href="#">LinkedIn</a>
						</li>
						<li class="divider"></li>
						<li>
							<a tabindex="-1" href="#">Sign Up</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>