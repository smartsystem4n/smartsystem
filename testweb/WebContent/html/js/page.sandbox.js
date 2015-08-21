var moduleSettings = {
	'pageModules' : [ {
		'name' : 'showRooms',
		'instances' : [ {
			'el' : 'rooms-tab'
		} ]
	} ]
};

function playInSandBox() {
	$("#rooms-tab").showRooms("render");
}

var tabMap = {
	'rooms-tab' : 'showRooms'
};