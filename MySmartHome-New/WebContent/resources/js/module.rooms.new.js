(function($) {
	var methods = {
		init : function(options) {
			return this.each(function() {

				serviceConfig = {
					'viewRoomsService' : 'view/rooms/',
					'updateLight' : 'light/updatestate/',
					'updateFan' : 'fan/updatestate/',
					'updateFanSpeed' : 'fan/updatespeed/'
				};
				settings = $.extend({
					'color' : 'navy',
					'background_color' : 'silver'
				}, options);

				settingsObject = {
					'servicePath' : serviceConfig,
					'settings' : settings
				}

				var $this = $(this);
				$this.data(settingsObject);

				$this.find('.smartHomeAction').on(
						'click',
						function(event) {
							//console.log(state); // true | false
							var state = $(this).data("state");
							if(!$(this).hasClass("fanSpeed"))
							{
								performAction($(this), state, $this
										.data("servicePath"));
							}
							else
							{
								// it is fan speed controller
								var speed =$.trim($(this).html().replace(/&nbsp;/g, '')) ;
								var state = $(this).data("state");
								performFanSpeedAction($(this), state,speed, $this
										.data("servicePath"));
							}
							
						});
			});
		},

		destruct : function() {
			return this.each(function() {
				var $this = $(this);
				$this.removeData('settings');
				$this.removeData('servicePath');
				$this.empty();
			});
		},

		onTabDeactivate : function() {
			return this.each(function() {
				var $this = $(this);
			});
		},

		beforeActivate : function() {

		},

		validate : function() {

		},
		saveTab : function() {

		},
		resetScroll : function resetScreenScrolls() {
			/*
			 * var _scrollPane = $("#homeTabScroll"); if
			 * (_scrollPane.data('jsp') != undefined) {
			 * _scrollPane.data('jsp').reinitialise(); } else {
			 * _scrollPane.jScrollPane(); }
			 */
		},
		render : function(options) {
			return this.each(function() {
				var $this = $(this);
				services = $this.data("servicePath");
				var doStuff = function() {
					var viewRoomsServiceURL = services.viewRoomsService;
					var options = {
						url : viewRoomsServiceURL,
						dataType : 'json',
						async : false,
						cache : false,
						success : function(data) {
							renderRooms(data);
						}
					};
					appGet(options);

				};
				doStuff();
				setInterval(doStuff, 10000);
			});
		}
	};

	$.fn.showRooms = function(method, houseHoldObj, options) {
		// Method calling logic
		if (methods[method]) {
			if (method !== 'init') {
				if ($(this).data().settings === undefined
						|| $(this).data().settings == null) {
					$.error('The showGrid module has not been initialized!');
				}
			}
			return methods[method].apply(this, Array.prototype.slice.call(
					arguments, 1));

		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, Array.prototype.slice.call(
					arguments, 2));

		} else {
			$.error('Method ' + method + ' does not exist on jQuery.tooltip');
		}
	};

})(jQuery);

function renderRooms(data) {
	if (isDefined(data)) {
		renderRoom1(data[0]);
		// renderRoom2(data[1]);
	}
}

function renderRoomsByType(type,data) {
	//alert(type);
	if (isDefined(data)) {
		//renderRoom1(data[0]);
		// renderRoom2(data[1]);
		if (isDefined(type) && 'light' == type) {
			updateLightRoom1(data) ;
		} else if (isDefined(type) && 'fan' == type) {
			updateFanRoom1(data);
		}
	}
}

function renderRoom1(roomData) {
	if (isDefined(roomData)) {
		// $("#room1Name").html(roomData.room.label);
		//var sequenceNo = 1;
		var lights = roomData.lights;
		if (isDefined(lights) && lights.length > 0) {
			$.each(lights, function(key, light) {
				updateLightRoom1(light);
			});
		}
		var fans = roomData.fans;
		if (isDefined(fans) && fans.length > 0) {
			$.each(fans, function(key, fan) {
				updateFanRoom1(fan);
			});
		}
	}
}

function updateLightRoom1(light)
{
	var btn = "room1BtnLight" + light.sequenceNo;
	//sequenceNo++;
	// var div = btn + "Div";
	// var lbl = btn + "Label";
	// $('#' + div).show();
	// $('#' + lbl).html(light.label);
	$('#' + btn).find("img").data("devId", light.id).data('devType', 'light');
	if (isDefined(light.state) && light.state == 'ON') {
		// $('#' + btn).bootstrapSwitch('state', true);
		$('#' + btn).find("img").attr("src","resources/img/lighting_white48px.png");
		$('#' + btn).find("img").data("state",false);// next stage
	} else {
		// $('#' + btn).bootstrapSwitch('state', false);
		$('#' + btn).find("img").attr("src","resources/img/lightingalt_white48px.png");
		$('#' + btn).find("img").data("state",true);// next stage
	}
}

function updateFanRoom1(fan)
{
	var btn = "room1BtnFan" + fan.sequenceNo;
	//sequenceNo++;
	var div = btn + "Div";
	var lbl = btn + "Label";
	// $('#' + div).show();
	// $('#' + lbl).html(fan.label);
	$('#' + btn).find("img").data("devId", fan.id).data('devType', 'fan');
	$('#' + btn).find(".fanSpeed").data("devId", fan.id).data('devType', 'fanSpeed');
	if (isDefined(fan.state) && fan.state == 'ON') {
		// $('#' + btn).bootstrapSwitch('state', true);					
		$('#' + btn).find("img").attr("src","resources/img/myfan.gif");
		$('#' + btn).find("img").data("state",false);// next stage
	} else {
		// $('#' + btn).bootstrapSwitch('state', false);					
		$('#' + btn).find("img").attr("src","resources/img/myfan.png");
		$('#' + btn).find("img").data("state",true);// next stage
	}	
}

function performAction($element, state, services) {
	var $this = $(this);
	if (state) {
		state = "ON";
		$element.data("state",false);// next stage
	} else {
		state = "OFF";
		$element.data("state",true);// next stage
	}
	// services = $this.data("servicePath");
	var viewRoomsServiceURL;
	var type = $element.data('devType');
	{
		if (isDefined(type) && 'light' == type) {
			viewRoomsServiceURL = services.updateLight;
		} else if (isDefined(type) && 'fan' == type) {
			viewRoomsServiceURL = services.updateFan;
		}
	}
	viewRoomsServiceURL = viewRoomsServiceURL + $element.data('devId') + "/"
			+ state;
	var options = {
		url : viewRoomsServiceURL,
		dataType : 'json',
		async : false,
		cache : false,
		success : function(data) {
			renderRoomsByType(type,data);
		}
	};
	appGet(options);
}

function performFanSpeedAction($element, state, speed, services) {
	var $this = $(this);
	
	var type = $element.data('devType');
	{
		if (isDefined(type) && 'fanSpeed' == type) {
			viewRoomsServiceURL = services.updateFanSpeed;
		} 
	}
	viewRoomsServiceURL = viewRoomsServiceURL + $element.data('devId') + "/"
			+ speed;
	var options = {
		url : viewRoomsServiceURL,
		dataType : 'json',
		async : false,
		cache : false,
		success : function(data) {
			renderRoomsByType(type,data);
		}
	};
	appGet(options);
}