/*
 * Use for HTTP GET
 */
function appGet(options) {
	var settings = addMandatoryOptions(options, true);
	settings.type = 'GET';
	$.ajax(settings);
}

function appPost(options) {
	var settings = addMandatoryOptions(options);
	settings.type = 'POST';
	settings.processData = false;

	/*
	 * set content type and stringify json object
	 */
	if (settings.data) {
		settings.contentType = 'application/json';
		jsonData = JSON.stringify(settings.data);
		settings.data = jsonData;
	}
	$.ajax(settings);
}

function appPut(options) {
	var settings = addMandatoryOptions(options);
	settings.type = 'PUT';
	$.ajax(settings);
}

/*
 * Use for HTTP GET
 */
function appDelete(options) {
	var settings = addMandatoryOptions(options);
	settings.type = 'DELETE';
	$.ajax(settings);
}

function addMandatoryOptions(options, isGet) {

	ticket = getCookie("APP_TICKET");
	appHeaders = {
		APP_TICKET : ticket
	};

	defaultOptions = {
		headers : appHeaders,
		error : handleError
	};

	if (isGet === true) {
		defaultOptions.cache = true;
	}

	if (!isDefined(defaultOptions.timeout)) {
		defaultOptions.timeout = 600000;
	}

	// merge default options and options sent by caller
	var settings = $.extend(true, {}, defaultOptions, options);

	return settings;
}

function addMandatoryOptionsWithoutLoader(options) {

	ticket = getCookie("APP_UID");
	appHeaders = {
		APP_TICKET : ticket
	};

	defaultOptions = {
		headers : appHeaders,
		error : handleError
	}

	if (!isDefined(defaultOptions.timeout)) {
		defaultOptions.timeout = 600000;
	}

	// merge default options and options sent by caller
	var settings = $.extend(true, {}, defaultOptions, options);

	return settings;
}

function startLoader() {
	loader = new ajaxLoader($('body'));
	$("body").data("bodyAjaxLoader", loader);
}

function removeLoader() {
	loader = $("body").data("bodyAjaxLoader");
	if (loader) {
		loader.removeAllLoader();
	}
	$("body").removeData("bodyAjaxLoader");
}

function handleError(jqXHR, textStatus, errorThrown) {
	$('#errorContainer').empty();
	$('#errorResponse').empty()
	$('#errorContainer').show();

	if (jqXHR.status == 500) {
		$('#errorContainer').append(
				'<li class="errorMessage nameError">Error occurred while executing the request ' + textStatus + ' '
						+ errorThrown + ' >><a id="clicError" href="#">Click here to see error text</a></li>');
		var ajaxErrorMessage = $("<span class='ajaxErrorMessage'/>");
		var errorMsgJSON = JSON.parse(jqXHR.responseText);

		ajaxErrorMessage.append("<h3>" + errorMsgJSON.url + "</h3><br/>");
		ajaxErrorMessage.append("<h5>" + errorMsgJSON.exception + "</h5><br/>");
		ajaxErrorMessage.append("<h5>" + errorMsgJSON.stackTrace + "</h5>");

		$('#errorResponse').html(ajaxErrorMessage);
		$('#clicError').hover(function(e) {
			$("#errorResponse").show();
			moveLeft = $(this).outerWidth();
			moveDown = ($("#errorResponse").outerHeight() / 2);
		}, function() {
			if (!($("#clicError").hasClass("show"))) {
				$("#errorResponse").hide(); // dont hide popup if it is clicked
			}
		});
		$('#clicError').click(function(e) {
			if (!($(this).hasClass("show"))) {
				$("errorResponse").show();
			}
			$(this).toggleClass("show");
		});
	} else if (jqXHR.status == 403) {
		window.location.href = $('body').data("appSingOutMessageURL");
	} else {
		$('#errorContainer').append(
				'<li class="errorMessage nameError">Error occurred while executing the request ' + textStatus + ' '
						+ errorThrown);
	}

}

function manageAjaxLoader() {
	$("body").unbind("ajaxStart");
	$("body").ajaxStart(function() {
		startLoader();
	});

	$("body").unbind("ajaxStop");
	$("body").ajaxStop(function() {
		removeLoader();
	});
}

function getCookie(cookieName) {
	var cookieValue = document.cookie;
	var cookieStart = cookieValue.indexOf(" " + cookieName + "=");
	if (cookieStart == -1) {
		cookieStart = cookieValue.indexOf(cookieName + "=");
	}
	if (cookieStart == -1) {
		cookieValue = null;
	} else {
		cookieStart = cookieValue.indexOf("=", cookieStart) + 1;
		var cookieEnd = cookieValue.indexOf(";", cookieStart);
		if (cookieEnd == -1) {
			cookieEnd = cookieValue.length;
		}
		cookieValue = unescape(cookieValue.substring(cookieStart, cookieEnd));
	}
	return cookieValue;
}

function isDefined(variable) {
	if (typeof variable == 'boolean') {
		return true;
	}

	return (typeof variable != 'undefined' && variable != null && variable != "");
}