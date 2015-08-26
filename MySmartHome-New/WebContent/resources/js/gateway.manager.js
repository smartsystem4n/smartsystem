(function($) {

	var methods = {
		init : function() {
			return this.each(function() {
				var $this = $(this);
				$this.data({
					"ajaxBaseUrl" : "/testp/"
				});
			});
		},

		destruct : function() {
			return this.each(function() {
				var $this = $(this);
				$this.removeData("ajaxBaseUrl");
				$this.removeData("htmlBaseUrl");
			});
		},
	};

	$.fn.gatewayManager = function(method) {
		// Method calling logic
		if (methods[method]) {
			return methods[method].apply(this);

		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this);

		} else {
			$.error('Method ' + method + ' does not exist on jQuery.gatewayManager');
		}
	};

})(jQuery);