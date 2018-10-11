$(function(){
	
	var cookie = getCookie("SSO");
	$("#cookie").text(cookie);
	if(cookie != null && cookie != ""){
		var token = getCookie("SSO");
		token = token.replace("\"","");
		token = token.replace("\"","");
		var dataArray = {"token":token};
		$.ajax({
			url:"/sso/token",
			type:"GET",
			data:dataArray,
			dataType:"jsonp",
			success:function(data){
				if(data.status == "500"){
					console.log(data.description);
				}
				else {
					
				}
			},
			error:function(){
				console.log("Get UserName Fail");
			}
		});
	}
	
	//设置Cookie
	function setCookie(name,value){
		var days = 2;
		var exp = new Date();
		exp.setTime(exp.getTime() + days*24*60*60*1000);
		document.cookie = name + "=" + escape(value);
	}
	
	//读取Cookie
	function getCookie(name){
		var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
        if(arr=document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
	}
	
})