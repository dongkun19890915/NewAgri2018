/**
 * 请求远程服务，设置cookie
 * 张荐森
 * 2016/09/28
 * */
var g_ReturnUrlValid = false;
var g_ReturnUrlObj = parseURL($("#returnURL").val());

document.onkeydown = function (e) {
	var theEvent = window.event || e; 
	var code = theEvent.keyCode || theEvent.which; 
	if (code == 13) { 
		$('#passWord').keypad('hide');
		$("#passWord").blur();
		$("#submit").click(); 
	} 
};
var closeKeyPad = function(){
    $("#passWord").removeClass("is-keypad").unbind();
     // ISSHOW=true;
};

$(function () {
    //登录背景框大小适应
    // console.log($(window).height());
	$("#loginBox").height($(window).height()-30);
	window.onresize=function(){
        $("#loginBox").height($(window).height()-30);
	};

	$("#trigerKeypad").click(function(){
        //控制keypad是否显示
		var flag=$("div.keypad-popup").css("display").toLowerCase();
		if(flag=="none"){
            var keypad = $('#passWord').keypad({
                keypadOnly: false,
                layout: [
                    '1234567890' + $.keypad.BACK,
                    'abcdefghij' + $.keypad.CLEAR,
                    'klmnopqrst' + $.keypad.SHIFT,
                    'uvwxyz@_-.' + $.keypad.CLOSE
                ],
                randomiseAll: true,
                closeText: '关闭',
                clearText: '清空',
                backText: '删除',
                shiftText: '切换',
                enterText: '确定',
                onClose: closeKeyPad
            });
            $('#passWord').focus();

            $("button.keypad-back").click(function(){

            	console.log("ddf");
            	$("#passWord").focus();
			});
        }
	});

});

/*登录失败后提示*/
function errorTipShow(text){
	$(".err_tip").removeClass("hide");
	$(".err_tip span").html("");
	$(".err_tip span").html(text);
}

function loadContent(text){
	var ops={
			text:text,
			iconTag:"img",
			icon:$("#resourcePath").val()+"/images/loading.gif",
	};
	$(".login_load").removeClass("hide");
	$(".login_load").mLoading(ops);
};

function closeLoad(){
	$(".login_load").addClass("hide");
};

function startLogin(){
	refreshStatus(true,"正在登录...");
	loadContent("正在登录");
};

function endLogin(){
	refreshStatus(false,"登 录");
	closeLoad();
};

function startCheckLogin(){
	refreshStatus(true,"检查登录状态...");
	loadContent("检查登录状态");
};

function endCheckLogin(){
	refreshStatus(false,"登 录");
	closeLoad();
};

function refreshStatus(dealing, text){
	$("#submit").text(text);
	$("#submit").attr("disabled",dealing);
}

function setCookieRemote(remoteurls){
	//5s后没反应直接跳转到页面 定时器ID， 用户取消定时器
	//var timerID = setTimeout("redirect()",5000);
	if(remoteurls == null){
		endLogin();
		return;
	}
	var successCount = 0;
	var failCount = 0;
	//域名相匹配的URL个数
	var totalValidUrlCount = remoteurls.length;
	for (var i = 0; i < remoteurls.length; i++) {
		var  strurl = remoteurls[i] ;
		validateUrl(strurl);
        console.log(strurl);
        //alert("开始回写地址"+strurl);
		try
		  {
			  $.ajax({
					url:strurl,
					type:"GET",
					timeout:2000, /*2秒内请求不到，则超时处理*/
					dataType: "jsonp",
					async: true, 
			        jsonp: "callback",
			        jsonpCallback:"successCallback",
					success:function(data)
					{
                        //alert("回写地址成功"+strurl);
						successCount++;
						redirect(totalValidUrlCount,successCount,failCount);
					},error:function(result, status){
                      //alert("回写地址失败"+strurl);
						failCount++;
						redirect(totalValidUrlCount,successCount,failCount);
					}
			});
		 }catch(err)
		{
		    //alert("回写地址异常"+strurl);
		    continue;
		}
	}
}

function callback(){
	//alert("*********callback*********");
}

function successCallback(){
	//alert("*********successCallback*********");
}

/**
 * 校验待跳转的url是否与回写cookie的url同一域名
 * @param effectiveUrl
 * @returns
 */
function validateUrl(effectiveUrl){
	if(g_ReturnUrlObj == null){
		return;
	}
	var urlObj = parseURL(effectiveUrl);
	//这个地方不能加端口号控制，因为sso的端口号和前端系统不一致
	//这样会导致sso的cookie写不上，后续注销就会失败
    // if(urlObj != null  && g_ReturnUrlObj.host == urlObj.host && g_ReturnUrlObj.port == urlObj.port){
    // if(urlObj != null  && g_ReturnUrlObj.host == urlObj.host){
	//TODO 上线修改
	// if(urlObj != null  && (g_ReturnUrlObj.host == urlObj.host|| g_ReturnUrlObj.host=="localhost")){
    if(urlObj != null){
		g_ReturnUrlValid = true;
	}
}

/**
 * url跳转
 */
function redirect(total,succ,fail){
	//全部回调完再跳转
	if(total > (succ+fail)){
		return;
	}
	var returnUrl = $("#returnURL").val();
    console.log("跳转地址"+returnUrl,g_ReturnUrlValid);
	//跳转的url为空则不跳转，跳转的url地址不存在回写cookie列表中不跳转
    if(returnUrl == null || returnUrl=="null" || returnUrl =="" || g_ReturnUrlValid == false){
    //f(g_ReturnUrlValid == false){
		endLogin();
		errorTipShow("登陆成功,但未获取到您访问系统的地址");
		return;
	}
	//跳转到前面访问的页面
	window.location.href=$("#returnURL").val();
	endLogin();
}

/**
 * 检查是否已在统一登录平台做过登录
 * 张荐森
 * 2016/09/28
 * */
function checkLoginStatus(){
    console.log("checkLoginStatus");
	/*
	 * 如果来自同一地址，则不再检查，防止死循环
	 */
	if(isCurrentURL($("#returnURL").val())){
		return;
	}
	var urlStr = $("#statusPath").val();
	startCheckLogin();
	$.ajax({
		url:urlStr,
		type:"GET",
		success:function(data)
		{
			if(data.retCode == "200"){
                console.log("校验登陆成功");
				//调用回写cookie服务
				setCookieRemote(data.redirectURLs);
			}
			endCheckLogin()
		},error:function(result, status){
			errorTipShow("登录状态检测接口调用失败");
			endCheckLogin();
		}
	});
};
    

$(function(){
	//checkLoginStatus();
	//登陆按钮触发事件
	$("#submit").bind('click', function(){
		var userCode = $.trim($("#userCode").val()); //用户名
		var passWord = $.trim($("#passWord").val()); //用户密码
		var verifyCode = $("#verifyCode").val(); //验证码
		var dataArray = {"userCode":userCode,"passWord":passWord,"verifyCode":"1133"};
		var urlStr = $("#authPath").val();
		
		if(userCode == null || userCode == ""){
			errorTipShow("请输入账号");
			return;
		}
		if(passWord == null || passWord == ""){
			errorTipShow("请输入密码");
			return;
		}
		
		startLogin();
        console.log("开始登陆");
		$.ajax({
			url:urlStr,
			type:"POST",
			data:JSON.stringify(dataArray),
			contentType:"application/json;charset=UTF-8",
			dataType:"json",
			success:function(data)
			{
				if(data.retCode == "200"){
                    console.log("登陆成功");
					//调用回写cookie服务
					setCookieRemote(data.redirectURLs);
				}else{
                    console.log("登陆失败");
					errorTipShow(data.retMsg);
					endLogin();
				}
			},
			error:function(result, status){
				errorTipShow("登陆失败");
				endLogin();
			}
		});		
	});
	
	//注销登录状态
	$("#logout").bind('click', function(){
		clearCookie();
		var urlStr = $("#logoutPath").val();
		window.location.href=urlStr;
	});

	/*$("#logout").bind('click', function(){
		var token = getCookie("SSO");
		token = token.replace("\"","");
		token = token.replace("\"","");
		var dataArray = {"token":token};
		$.ajax({
			url:"/logout",
			type:"GET",
			data:dataArray,
			dataType:"jsonp",
			success:function(data){
				if(data.statusCode == "500"){
					alert(data.description);
				}else {
					alert("注销登录成功");
				}
			},error:function(){
				alert("LogOut FAIL");
			}
		});
	});*/
	
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
	
	function clearCookie(){ 
		var keys=document.cookie.match(/[^ =;]+(?=\=)/g); 
		if (keys) { 
			for (var i = keys.length; i>=0; i--) {
				document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString() ;
			}
		} 
	} 
	//忘记密码按钮
	$("#forgot").click(function(){
		$(".mask").show();
		$(".email_post").show();
	});
	//忘记密码弹层退出按钮
	$(".button_cancel").click(function(){
		$(".mask").hide();
		$(".email_post").hide();
	});
	//忘记密码弹层X按钮
	$(".button_exit").click(function(){
		$(".mask").hide();
		$(".email_post").hide();
	});
	//忘记密码弹层确定按钮
	$("#sure").bind('click',function(){
		var ok=true;
		var userCode = $.trim($("#userCode1").val()); //用户名
		var userDto ={"userCode":userCode};
		if(userCode == null || userCode == ""){
			errorTipShow("请输入账号");
			alert("请输入账号!!")
			ok = false;
		}
		if(ok){
			$.ajax({
                // url:"/comm-sso/api/forgotPasswd",
                url:"/api/forgotPasswd",
				type:"POST",
				data:JSON.stringify(userDto),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				async:false,
				success:function(data)
				{
					if(data.retCode == "0000"){
						alert(data.retMsg);
						//跳转回登陆页面/弹层关闭
						$(".mask").hide();
						$(".email_post").hide();
					}else{
						alert(data.retMsg);
					}
				},
				error:function(result, status){
					alert("校验异常，请联系管理员");
				}
			});
		}		
	});
	
})