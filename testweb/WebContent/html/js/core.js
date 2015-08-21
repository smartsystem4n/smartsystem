jQuery(document).ready(function($) {
	$("body").gatewayManager('init');
	$("body").pageManager('init', moduleSettings).pageManager('play');
});
