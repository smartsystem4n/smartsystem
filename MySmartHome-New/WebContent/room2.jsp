<!DOCTYPE html>
<%@page import="com.chmapbrains.smart.system.home.SwitchInfo"%>
<%@page import="com.chmapbrains.smart.system.component.Switch"%>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        -->
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

<link href="resources/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/bootswatch/cyborg/bootstrap.css"
	rel="stylesheet" type="text/css" />


<link rel="stylesheet" href="resources/css/toggles-full.css">

<script src="resources/js/toggles.min.js" type="text/javascript"></script>
<script>
	$(function() {
		$("#themes").load("themes.html", function() {

		});

	});
</script>

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

<body id="body">
	<div class="">
		<div class="container">
			<div class="navbar-header">
				<img
					src="resources/img/creative_brain_animated---Copy---Copy-new.gif"
					class="center-block img-responsive img-rounded">
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<%@ include file="dropdown-image.jsp"%>

				<div id="themes"></div>

			</div>
		</div>
	</div>
	<%@ include file="button-theme2.jsp"%>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>

</html>