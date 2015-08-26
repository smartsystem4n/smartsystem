(function( $ ){
	
	var methods = {
    	init : function(options) {
    		return this.each(function() {    		           				
	    		var $this = $(this);
	    		
	    		pageModules = $.extend({}, options);
	    		$this.data(pageModules);
	    		
    			for (var i = 0; i < pageModules.pageModules.length; i++)	{
    				pModule = pageModules.pageModules[i];
	    			for (var j = 0; j < pModule.instances.length; j++)	{
		    			instance = pModule.instances[j];
		    			$("#" + instance.el)[pModule.name]('init', instance.settings);

		    			servicePath = $("#" + instance.el).data("servicePath");
		    			htmlServicePath = $("#" + instance.el).data("htmlServicePath");

		    			if (servicePath != undefined || servicePath != null)	{
			    			
		    				ajaxBaseUrl = $("body").data("ajaxBaseUrl");
			    			$.map(servicePath, function(path, serviceKey) {
			    				servicePath[serviceKey] = ajaxBaseUrl + path;
							});
			    			
			    			$("#" + instance.el).data({"servicePath" : servicePath }); 
		    			}

		    			if (htmlServicePath !== undefined || htmlServicePath != null)	{
		    				htmlBaseUrl = $("body").data("htmlBaseUrl");
			    			$.map(htmlServicePath, function(path, serviceKey) {
			    				htmlServicePath[serviceKey] = htmlBaseUrl + path;
							});
			    			
			    			$("#" + instance.el).data({"htmlServicePath" : htmlServicePath }); 
		    			}
	    			}		
	    		}
			});
	    	
    	},
	    
	    destruct : function() { 
    		return this.each(function() {        
	    		var $this = $(this);
	    		pageModules = $this.data('pageModules');
    			for (var i = 0; i < pageModules.length; i++)	{
    				pModule = pageModules[i];
	    			for (var j = 0; j < pModule.instances.length; j++)	{
		    			instance = pModule.instances[j];
		    			$("#" + instance.el)[pModule.name]('destruct');
		    			
	    			}		
				}	    		
				
			});
    	},
    	
    	play : function() {
    		return this.each(function() {        
	    		var $this = $(this);
	    		playInSandBox();
			});
    	}
    	
 	};

  	$.fn.pageManager = function(method, options) {    
	    // Method calling logic
	    if ( methods[method]) {
	    	return methods[ method ].apply(this, Array.prototype.slice.call(arguments, 1));
	    	
	    } else if ( typeof method === 'object' || ! method ) {
	    	return methods.init.apply(this, Array.prototype.slice.call(arguments, 1));
    		
	    } else {
	    	$.error( 'Method ' +  method + ' does not exist on jQuery.ccmcPageManager' );
	    }
 	};

})( jQuery );