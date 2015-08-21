<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Smart System by Champ Brains</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/simple-line-icons.css" rel="stylesheet">
<link rel="stylesheet" href="css/zTreeStyle.css" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
        queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file://
        -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script>
	$(function() {
		$("#page-header").load("page-header.html", function() {
			$("#roomsli").addClass('active');
		});

	});
</script>
<!-- Include all compiled plugins (below), or include individual
        files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/quick-sidebar.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<!-- <link rel="stylesheet" href="css/toggles-full.css"> -->
<!-- <script src="js/toggles.min.js" type="text/javascript"></script> -->
<script type="text/javascript" src="js/gateway.manager.js"></script>
<script type="text/javascript" src="js/page.manager.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/page.sandbox.js"></script>
<script type="text/javascript" src="js/module.rooms.js"></script>
<script type="text/javascript" src="js/ajaxLoader.js"></script>
<script type="text/javascript" src="js/commonsAjax.js"></script>
<!-- start: https://github.com/simontabor/jquery-toggles/ -->
<link href="css/bootstrap-switch.css" rel="stylesheet">
<script src="js/bootstrap-switch.js"></script>
</head>

<body>
	<div id="page-header"></div>
	<div class="clearfix"></div>
	<div class="page-container">
		<div class="page-sidebar-wrapper">
			<div id="rooms-tab" class="container-fluid">
				<div class="row">
				<!-- 
					<div class="col-xs-4 col-sm-4 col-md-4 page-sidebar navbar-collapse collapse">
						<ul id="accordion" class="panel-group">
							<li class="panel panel-default">
								<a href="##collapse2" data-parent="#accordion" data-toggle="collapse" class="collapsed">
									<h3 class="panel-title">
										<span class="title"><span class="icon"><i class="icon-paper-plane">&nbsp;</i>
										</span>All Smart Device control</span>
										<span style="top: none" class="z-arrow"></span>
									</h3>
								</a> 
								<div id="collapse2" class="panel-collapse collapse">Display all smart device in room</div>
							</li>
							<li class="panel panel-default">
								<a href="#collapse3" data-parent="#accordion" data-toggle="collapse" class="collapsed">
									<h3 class="panel-title">
										<span class="title"><span class="icon"><i class="icon-screen-smartphone">&nbsp;</i></span>Custom Option</span> 
										<span style="top: none" class="z-arrow"></span>
									</h3>
								</a>
								<div id="collapse3" class="panel-collapse collapse">Custom
									option like where user can customised light option based on his
									req. Like party lights</div>
							</li>
							<li class="panel panel-default">
								<a href="#collapse4" data-parent="#accordion" data-toggle="collapse" class="collapsed">
										<h3 class="panel-title"> 
											<span class="title"><span class="icon"><i class="icon-star">&nbsp;</i></span>Statistic</span> 
											<span style="top: none" class="z-arrow"></span>
										</h3>
								</a>
								<div id="collapse4" class="panel-collapse collapse">about light usage and other feature</div>
							</li>
						</ul>
					</div>  -->

					<div class="">
						<div class="container-fluid">
							<!--  Room1 -->
							<div id="room1">
								<div class="row">
									<div class="">
										<!-- <h4 id="room1Name" class="text-center text-danger"></h4> -->
										<img class="img-responsive" src="img/MasterBedroom.png" />
									</div>
								</div>
								<div class="row">
								<div class="panel panel-default">
									<table class="table">
										<tbody>
											<tr id = "room1Btn1Div" style="background-color:#2980b9;display: none;">
												<td id = "room1Btn1Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room1Btn1" name="room1Btn1"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											
											<tr id = "room1Btn2Div" style="background-color:#2980b9;display: none;">
												<td id = "room1Btn2Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room1Btn2" name="room1Btn2"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											
											<tr id = "room1Btn3Div" style="background-color:#2980b9;display: none;">
												<td id = "room1Btn3Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room1Btn3" name="room1Btn3"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											</tbody>
									</table>
								</div>
								</div>
							</div>
							<!--  Room1 End-->
							
							<!--  Room2 -->
							<div id="room2">
								<div class="row">
									<div class="">
										<!-- <h4 id="room2Name" class="text-center text-danger"></h4> -->
										<img class="img-responsive" src="img/MasterBedroom.png" />
									</div>
								</div>
								<div class="row">
								<div class="panel panel-default">
									<table class="table">
										<tbody>
											<tr id = "room2Btn1Div" style="background-color:#2980b9;style=display: none;">
												<td id = "room2Btn1Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room2Btn1" name="room2Btn1"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											
											<tr id = "room2Btn2Div" style="background-color:#2980b9;style=display: none;">
												<td id = "room2Btn2Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room2Btn2" name="room2Btn2"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											
											<tr id = "room2Btn3Div" style="background-color:#2980b9;display: none;">
												<td id = "room2Btn3Label" style="vertical-align: middle; color:#fff"></td>
												<td class="text-right text-nowrap">
													<!-- <button class="btn btn-default btn-info">
														<span class="glyphicon glyphicon-new-window"></span>
													</button> -->
													<input type="checkbox" id="room2Btn3" name="room2Btn3"
														class="myBtns" data-size="small" data-on-color="primary"
														data-off-color="info">
													</td>
											</tr>
											</tbody>
									</table>
								</div>
								</div>
							</div>
							<!--  Room2 End-->

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>