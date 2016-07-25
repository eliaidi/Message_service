/*
 *  @ Author lizhiyang
 *  @ DESC 股神 base js
 *
 * */

function IVAGNER (){
	this.ua = navigator.userAgent;
	this.android = this.ua.match(/(Android)\s+([\d.]+)/);
	this.ios = this.ua.match(/(iPhone\sOS)\s([\d_]+)/);
	this.clientName = this.ios ? 'iOS' : this.android ? 'Android' : 'unknown'
}

IVAGNER.prototype = {
	constructor: IVAGNER,
	//获取url参数
	getUrlParam: function(paramName){
		var paramValue = '';
		var isFound = false;
		if (document.location.search.indexOf('?') == 0 && document.location.search.indexOf('=')>1){
			arrSource = unescape(document.location.search).substring(1,document.location.search.length).split('&');
			i = 0;
			while (i < arrSource.length && !isFound){
				if (arrSource[i].indexOf('=') > 0){
					if (arrSource[i].split('=')[0].toLowerCase()==paramName.toLowerCase()){
						paramValue = arrSource[i].split('=')[1];
						isFound = true;
					}
				}
				i++;
			}
		}
		return paramValue;
	},
	// storage操作
	storage: {
		setSessionStorage:function(key,value){
			window.sessionStorage[key] = value;
		},
		getSessionStorage:function(key){
			return window.sessionStorage.getItem(key)
		},
		setLocalStorage:function(key,value){
			window.localStorage[key] = value;
		},
		getLocalStorage:function(key){
			return window.localStorage.getItem(key)
		},
		clearSessionStorage:function(key){
			if(key){
				window.sessionStorage.removeItem(key);
			}
			else{
				window.sessionStorage.clear();
			}
		},
		clearLocalStorage:function(key){
			if(key){
				window.localStorage.removeItem(key);
			}
			else{
				window.localStorage.clear();
			}
		}
	},
	// 格式化时间
	transformTime: function (time) {
		var today = new Date();
		// for mm-dd hh:mm:ss
		if(time.indexOf('-') < 4 && time.indexOf('-') > -1) {
			var thisYear = today.getFullYear();
			time = thisYear + '-' + time;
		}
		// for mm/dd hh:mm:ss
		if(time.indexOf('/') < 4 && time.indexOf('/') > -1) {
			var thisYear = today.getFullYear();
			time = thisYear + '/' + time;
		}
		time = time.replace(/-/g,"/");
		var date = new Date(time);
		if(Math.abs(today.getTime() - date.getTime()) <= 60000){
			return '刚刚';
		}
		else if(date.toDateString() == today.toDateString() && date.getHours() == today.getHours()){
			//安卓 0分钟前
			var diff = Math.abs((today.getMinutes() - date.getMinutes())) == '0' ? '刚刚' : Math.abs((today.getMinutes() - date.getMinutes())) + '分钟前';
			return diff ;
		}
		else if(date.toDateString() == today.toDateString()){
			var diff = Math.abs((today.getHours() - date.getHours())) + '小时前';
			return diff
		}
		else{
			return time.replace(/\//g,"-");
		}
	}
};

var ivagner = new IVAGNER();


