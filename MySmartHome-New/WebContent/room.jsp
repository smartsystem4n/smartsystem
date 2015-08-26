<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Smart System by Champ Brains</title>
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">
<link href="resources/css/simple-line-icons.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/zTreeStyle.css"
	type="text/css">
<link href="resources/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
        queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file://
        -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.min.js"></script>
<script>
	$(function() {
		$("#page-header").load("page-header.html", function() {
			$("#roomsli").addClass('active');
		});

	});
</script>
<script>
	$(function() {
		$("#themes").load("themes.html", function() {

		});

	});
</script>
<!-- Include all compiled plugins (below), or include individual
        files as needed -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/quick-sidebar.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.ztree.core-3.5.js"></script>
<link rel="stylesheet" href="resources/css/toggles-full.css">

<script src="resources/js/toggles.min.js" type="text/javascript"></script>

<!-- start: https://github.com/simontabor/jquery-toggles/ -->
<script type="text/javascript">
	$('body').ready(function() {
		document.body.style.cursor = 'none';
		$('.toggle').toggles({
			drag : true, // allow dragging the toggle between positions
			click : true, // allow clicking on the toggle
			text : {
				on : 'ON', // text for the ON position
				off : 'OFF' // and off
			},
			on : false, // is the toggle ON on init
			animate : 250, // animation time
			transition : 'swing', // animation transition,
			checkbox : null, // the checkbox to toggle (for use in forms)
			clicker : null, // element that can be clicked on to toggle. removes binding from the toggle itself (use nesting)
			width : 50, // width used if not set in css
			height : 50, // height if not set in css
			type : 'compact' // if this is set to 'select' then the select style toggle will be used
		});
	});
</script>
<script type="text/javascript" src="resources/js/gateway.manager.js"></script>
<script type="text/javascript" src="resources/js/page.manager.js"></script>
<script type="text/javascript" src="resources/js/core.js"></script>
<script type="text/javascript" src="resources/js/page.sandbox.js"></script>
<script type="text/javascript" src="resources/js/module.rooms.js"></script>
<script type="text/javascript" src="resources/js/ajaxLoader.js"></script>
<script type="text/javascript" src="resources/js/commonsAjax.js"></script>
<style type="text/css">
div {
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	-o-user-select: none;
	user-select: none;
}
</style>
</head>

<body>
	<div id="page-header"></div>
	<div class="clearfix"></div>
	<div class="page-container">
		<div class="page-sidebar-wrapper">
			<div class="col-xs-12 container">
				<div class="row">
					<div
						class="col-xs-4 col-sm-4 col-md-4 page-sidebar navbar-collapse collapse">
						<ul id="accordion" class="panel-group">
							<li class="panel panel-default"><a href="##collapse2"
								data-parent="#accordion" data-toggle="collapse"
								class="collapsed">

									<h3 class="panel-title">

										<span class="title"><span class="icon"><i
												class="icon-paper-plane">&nbsp;</i></span>All Smart Device control</span>

										<span style="top: none" class="z-arrow"></span>

									</h3>

							</a>
								<div id="collapse2" class="panel-collapse collapse">Display
									all smart device in room</div></li>
							<li class="panel panel-default"><a href="#collapse3"
								data-parent="#accordion" data-toggle="collapse"
								class="collapsed">

									<h3 class="panel-title">

										<span class="title"><span class="icon"><i
												class="icon-screen-smartphone">&nbsp;</i></span>Room Scenes</span> <span
											style="top: none" class="z-arrow"></span>

									</h3>

							</a>
								<div id="collapse3" class="panel-collapse collapse">Custom
									option like where user can customised light option based on his
									req. Like party lights</div></li>
							<li class="panel panel-default"><a href="#collapse4"
								data-parent="#accordion" data-toggle="collapse"
								class="collapsed">

									<h3 class="panel-title">

										<span class="title"><span class="icon"><i
												class="icon-star">&nbsp;</i></span>Statistic</span> <span
											style="top: none" class="z-arrow"></span>

									</h3>

							</a>
								<div id="collapse4" class="panel-collapse collapse">about
									light usage and other feature</div></li>
						</ul>
					</div>
					<div class="col-xs-12 col-sm-8 col-md-8">
						<div class="col-xs-12 container">
							<div class="row">
								<div class="col-xs-9">
									<h1 class="text-center text-danger">Control Unit</h1>
								</div>
								<div class="col-xs-3">
									<div class="btn-group btn-group-xs">
										<a aria-expanded="true" href="#"
											class="btn btn-default dropdown-toggle"
											data-toggle="dropdown"> Dropdown <span class="caret"></span>
										</a>
										<ul class="dropdown-menu">
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/1.jpg)')"
												href="#">Action</a></li>
											<li><a href="#"
												onclick="$('body').css('background-image', 'url(resources/img/2.jpg)')">Action2</a>
											</li>
											<li><a href="#"
												onclick="$('body').css('background-image', 'url(resources/img/3.jpg)')">Action3</a>
											</li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/4.jpg)')"
												href="#">Action4</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/5.jpg)')"
												href="#">Action5</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/6.jpg)')"
												href="#">Action6</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/7.jpg)')"
												href="#">Action7</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/8.jpg)')"
												href="#">Action8</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/9.jpg)')"
												href="#">Action9</a></li>
											<li><a
												onclick="$('body').css('background-image', 'url(resources/img/10.jpg)')"
												href="#">Action10</a></li>
										</ul>
									</div>

									<div id="themes"></div>
								</div>

								<br>

								<%@ include file="button-theme1.jsp"%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>

</html>