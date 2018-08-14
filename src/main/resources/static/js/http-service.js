(function(factory){if(typeof define==="function"&&define.amd){define(["jquery"],factory)}else{if(typeof exports==="object"){factory(require("jquery"))}else{factory(jQuery)}}}(function($){var pluses=/\+/g;function encode(s){return config.raw?s:encodeURIComponent(s)}function decode(s){return config.raw?s:decodeURIComponent(s)}function stringifyCookieValue(value){return encode(config.json?JSON.stringify(value):String(value))}function parseCookieValue(s){if(s.indexOf('"')===0){s=s.slice(1,-1).replace(/\\"/g,'"').replace(/\\\\/g,"\\")}try{s=decodeURIComponent(s.replace(pluses," "));return config.json?JSON.parse(s):s}catch(e){}}function read(s,converter){var value=config.raw?s:parseCookieValue(s);return $.isFunction(converter)?converter(value):value}var config=$.cookie=function(key,value,options){if(value!==undefined&&!$.isFunction(value)){options=$.extend({},config.defaults,options);if(typeof options.expires==="number"){var days=options.expires,t=options.expires=new Date();t.setTime(+t+days*86400000)}return(document.cookie=[encode(key),"=",stringifyCookieValue(value),options.expires?"; expires="+options.expires.toUTCString():"",options.path?"; path="+options.path:"",options.domain?"; domain="+options.domain:"",options.secure?"; secure":""].join(""))}var result=key?undefined:{};var cookies=document.cookie?document.cookie.split("; "):[];for(var i=0,l=cookies.length;i<l;i++){var parts=cookies[i].split("=");var name=decode(parts.shift());var cookie=parts.join("=");if(key&&key===name){result=read(cookie,value);break}if(!key&&(cookie=read(cookie))!==undefined){result[name]=cookie}}return result};config.defaults={};$.removeCookie=function(key,options){if($.cookie(key)===undefined){return false}$.cookie(key,"",$.extend({},options,{expires:-1}));return !$.cookie(key)}}));

var DEFAULT_CUSTOM_DOMAIN = "/";
var DEFAULT_CUSTOM_ROOT_URL = "";
var HttpService = {
	SESSION_ID_COOKIE : 'JSESSIONID',
	SESSION_AUTH : 'SESSIONAUTH',
	IS_WINDOW_OPEN_URL : false,
	USERNAME : "USERNAME",
	PHONE:"PHONE",
};

HttpService.setSessionCookie = function(sessionValue) {

	$.cookie(HttpService.SESSION_AUTH, encodeURIComponent(sessionValue), {
		"expires" : 1
	});
};

HttpService.deleteSessionCookie = function() {
	$.removeCookie(HttpService.SESSION_AUTH, {
		"path" : "/"
	});
};
HttpService.getSessionCookie = function() {

	var sessionValue = $.cookie(HttpService.SESSION_AUTH);

	if (sessionValue == null) {
		return sessionValue;
	} else {
		return decodeURIComponent(sessionValue);
	}

};
// Login service
HttpService.loginIn = function(sessionValue) {
	this.setSessionCookie(sessionValue);
};

// Logout service
HttpService.loginOut = function() {
	this.deleteSessionCookie();
	var p = {};
	p.success = function(res) {
		if (res.result.toUpperCase() == ("SUCCESS")) {
			window.location.href = "/index";
		}
	}
	HttpService.call("/logout", {}, p);
};

HttpService.isLogin = function() {
	var sessionValue = this.getSessionCookie();
	if (!sessionValue || sessionValue == null
			|| typeof sessionValue == "undefined" || $.trim(sessionValue) == "") {
		return false;
	}
	return true;
};
HttpService.getLoginCookie = function() {
	if (this.isLogin()) {
		var sessionValue = this.getSessionCookie();
		return sessionValue;
	}
	return null;
};

HttpService.checkLogin = function() {
	if (!this.isLogin()) {
		window.location.href = "/login.html?callBackUrl="
				+ encodeURI(window.location.href);
	}
};

HttpService.loginRedirectUrl = function() {
	var url = window.location.search;

	if(url.indexOf("callBackUrl=")!=-1){
		var callBackUrl = url.substring(url.indexOf("callBackUrl=") + 12);
		if (callBackUrl !== "" && callBackUrl !== null
				&& typeof callBackUrl != "undefined") {
			window.location.href = decodeURI(callBackUrl);
		}
	}else {
		window.location.href = "/user/personalCenter.html";
	}
}

HttpService.tips = function addTips(txt, wid, align, times){
	 if(typeof(times) == "undefined"){
		 times = 2500;
	 }
	 if($(".tips").length > 0){
		return; 
	 }else{
		 if(align == 0){
			 txtAlign = "left"
		 }else if(align == 1){
			 txtAlign = "center"
		 }else{
			 txtAlign = "right"
		 }
		var tipsObj = $('<div class="tips"><p style="width:'+ wid +'%; text-align:'+ txtAlign +'">'+ txt + '</p></div>');
		$("body").append(tipsObj);
		setTimeout(function(){
			$(".tips").animate({opacity:0}, 500, function(){
				$(".tips").remove();	
			});
		}, times);
	 }
}

HttpService.loadings = function(domHg) {
	$("body").append($('<div class="loadings"><div class="ldbd"><i></i></div></div>').clone());
}

HttpService.loadingsRemove = function() {
	$(".loadings").remove();
}

HttpService.getQueryString = function(name) { //获取uri变量的值
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	var context = ""; 
	if (r != null) 
		 context = r[2]; 
	reg = null; 
	r = null; 
	return context == null || context == "" || context == "undefined" ? "" : context; 
}

HttpService.call = function(action, params, options) {
	var url = action 
	/*var times = new Date().getTime();
	params["appParams.time"]      = times;
	params["device"]              = "h5";*/
	var option = {};
	option.validate = function() {
		return true;
	}

	option.beforeSubmit = function() {
		//console.log('BeforeSubmit >>>> do you need me show animation ?');
	};
	option.success = function(response) {
		// console.log('SUCCESS >>>>'+response);
	};
	option.error = function(response) {
		//  console.log('ERROR >>>>'+response);
	};
	option.complete = function() {
		// console.log('Complete >>>> do you need me close animation ?');
	};
	$.extend(option, options);
	//do validation
	if (!option.validate()) {
		return false;
	}
	//before submit data handling
	option.beforeSubmit.call(this);
	// ajax call service
	
	HttpService.loadings();
	$.ajax(url, {
		'dataType' : 'json',// if you want to cross domain post 
		'type':"POST",// if you want to cross domain post ,you should use GET
		'traditional' : true, // Server only supports traditional style params
		'data' : params,
		'async' : true,
		'success' : function(response, status, xhr) {//response, status, xhr
			/*if(response.result.toUpperCase() == "LOGIN"){
                HttpService.deleteSessionCookie();
                HttpService.checkLogin();
                 return;
             }else if(response.result.toUpperCase() == "REDIRECT"){
                 var url=response.content;
                 window.location.href=url;
             }else if(response.result.toUpperCase() == "FORM"){
                 $('#dynamicDivElementId').html(response.content);
                 option.success(response);
             }*/ if(response.result.toUpperCase() == "SUCCESS"){
            	 option.success(response);
             }else if(response.result.toUpperCase() == "LOGIN"){
            	 HttpService.deleteSessionCookie();
                 HttpService.checkLogin();
                  return;
             }else{
            	 option.error(response);
            	 HttpService.tips(response.errors, 70, 1);
             }
			 HttpService.loadingsRemove();
		},
		'error' : function(xhr, status, error) {
			HttpService.loadingsRemove();
			HttpService.tips("网络出错了，请稍后再试！", 80, 1);
		},
		'complete' : function(res) { 
			 option.complete();
			 HttpService.loadingsRemove();
		}
	});
};
HttpService.redirectToAction = function(action) {
	location = DEFAULT_CUSTOM_ROOT_URL + action + '?JSESSIONID='
			+ this.getSessionId();
}
HttpService.formatDate =function formatDate(DateIn){
    var Year=0;
    var Month=0;
    var Day=0;
    var Hour=0;
    var Minute=0;
    var Second=0;
    var CurrentDate="";
    //初始化时间
    Year=DateIn.getFullYear();
    Month=DateIn.getMonth()+1;
    Day=DateIn.getDate();
    Hour=DateIn.getHours();
    Minute=DateIn.getMinutes();
    Second=DateIn.getSeconds();
    CurrentDate=Year+"-";
    if(Month>=10){
        CurrentDate=CurrentDate+Month+"-";
    }else{
        CurrentDate=CurrentDate+"0"+Month+"-";
    }
    if(Day>=10){
        CurrentDate=CurrentDate+Day;
    }else{
        CurrentDate=CurrentDate+"0"+Day;
    }
    if(Hour>=10){
        CurrentDate=CurrentDate+" "+Hour;
    }else{
        CurrentDate=CurrentDate+" 0"+Hour;
    }
    if(Minute>=10){
        CurrentDate=CurrentDate+":"+Minute;
    }else{
        CurrentDate=CurrentDate+":0"+Minute;
    }
    if(Second>=10){
        CurrentDate=CurrentDate+":"+Second;
    }else{
        CurrentDate=CurrentDate+":0"+Second;
    }
    return CurrentDate;
};

window.HttpService = HttpService;
