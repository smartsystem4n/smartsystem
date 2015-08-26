(function($) {
	var methods = {
		init : function(options) {
			return this.each(function() {

				serviceConfig = {
					'viewRoomsService' : 'view/rooms/',
					'updateLight' : 'light/updatestate/',
					'updateFan' : 'fan/updatestate/'
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
				
				$this.find('.smartHomeAction').on('toggle', function(event, state) {
					  console.log(state); // true | false
					  performAction($(this),state, $this.data("servicePath"));
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
		render : function render(options) {
			return this.each(function() {										
				var $this = $(this);
				services = $this.data("servicePath");
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
			});
		}
	};
	

	$.fn.showRooms = function(method, houseHoldObj, options) {
		// Method calling logic
		if (methods[method]) {
			if (method !== 'init') {
				if ($(this).data().settings === undefined || $(this).data().settings == null) {
					$.error('The showGrid module has not been initialized!');
				}
			}
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));

		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, Array.prototype.slice.call(arguments, 2));

		} else {
			$.error('Method ' + method + ' does not exist on jQuery.tooltip');
		}
	};

})(jQuery);

function renderRooms(data) {
	if (isDefined(data)) {
		renderRoom1(data[0]);
		//renderRoom2(data[1]);
	}
}

function renderRoom1(roomData) {
	if (isDefined(roomData)) {
		//$("#room1Name").html(roomData.room.label);
		var sequenceNo = 1;
		var lights = roomData.lights;
		if (isDefined(lights) && lights.length > 0) {
			$.each(lights, function(key, light) {
				var btn = "room1Btn" + sequenceNo;
				sequenceNo++;
				//var div = btn + "Div";
				//var lbl = btn + "Label";
				//$('#' + div).show();
				//$('#' + lbl).html(light.label);
				$('#' + btn).data("devId", light.id).data('devType', 'light');
				if (isDefined(light.state) && light.state == 'ON') {
					//$('#' + btn).bootstrapSwitch('state', true);
					$('#' + btn).data('toggles').toggle(true, true, true);
				} else {
					//$('#' + btn).bootstrapSwitch('state', false);
					$('#' + btn).data('toggles').toggle(false, true, true);
				}
			});
		}
		var fans = roomData.fans;
		if (isDefined(fans) && fans.length > 0) {
			$.each(fans, function(key, fan) {
				var btn = "room1Btn" + sequenceNo;
				sequenceNo++;
				var div = btn + "Div";
				var lbl = btn + "Label";
				//$('#' + div).show();
				//$('#' + lbl).html(fan.label);
				$('#' + btn).data("devId", fan.id).data('devType', 'fan');
				if (isDefined(fan.state) && fan.state == 'ON') {
					//$('#' + btn).bootstrapSwitch('state', true);
					$('#' + btn).data('toggles').toggle(true, true, true);
				} else {
					//$('#' + btn).bootstrapSwitch('state', false);
					$('#' + btn).data('toggles').toggle(false, true, true);
				}
			});
		}
	}
}

function renderRoom2(roomData) {
	if (isDefined(roomData)) {
		//$("#room1Name").html(roomData.room.label);
		var sequenceNo = 1;
		var lights = roomData.lights;
		if (isDefined(lights) && lights.length > 0) {
			$.each(lights, function(key, light) {
				var btn = "room2Btn" + sequenceNo;
				sequenceNo++;
				var div = btn + "Div";
				var lbl = btn + "Label";
				$('#' + div).show();
				$('#' + lbl).html(light.label);
				$('#' + btn).data("devId", light.id).data('devType', 'light');
				if (isDefined(light.state) && light.state == 'ON') {
					$('#' + btn).bootstrapSwitch('state', true);
				} else {
					$('#' + btn).bootstrapSwitch('state', false);
				}
			});
		}
		var fans = roomData.fans;
		if (isDefined(fans) && fans.length > 0) {
			$.each(fans, function(key, fan) {
				var btn = "room2Btn" + sequenceNo;
				sequenceNo++;
				var div = btn + "Div";
				var lbl = btn + "Label";
				$('#' + div).show();
				$('#' + lbl).html(fan.label);
				$('#' + btn).data("devId", fan.id).data('devType', 'fan');
				if (isDefined(fan.state) && fan.state == 'ON') {
					$('#' + btn).bootstrapSwitch('state', true);
				} else {
					$('#' + btn).bootstrapSwitch('state', false);
				}
			});
		}
	}
}

function performAction($element,state, services) {
	var $this = $(this);
	if (state) {
		state = "ON";
	} else {
		state = "OFF";
	}
	//services = $this.data("servicePath");
	var viewRoomsServiceURL;
	var type = $element.data('devType');
	{
		if (isDefined(type) && 'light' == type) {
			viewRoomsServiceURL = services.updateLight;
		} else if (isDefined(type) && 'fan' == type) {
			viewRoomsServiceURL = services.updateFan;
		}
	}
	viewRoomsServiceURL = viewRoomsServiceURL + $element.data('devId') + "/" + state;
	var options = {
		url : viewRoomsServiceURL,
		dataType : 'json',
		async : false,
		cache : false,
		success : function(data) {
			// renderRooms(data);
		}
	};
	appGet(options);
}