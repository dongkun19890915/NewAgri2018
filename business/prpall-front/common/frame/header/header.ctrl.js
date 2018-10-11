/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'config',
    'constants',
    'layer', 'jsonDB'
], function (app,config,constants,layer, jsonDB) {
    'use strict';
    app.registerController('headerCtrl', ['$rootScope', '$scope','$$finder','$$user','$state','$window','commonApiServ',
        function ($rootScope,$scope,$$finder,$$user,$state,$window,commonApiServ ){
            var sexcontent="1";
            $scope.typePass=false;
            $scope.change=function (){
                $scope.typePass=!$scope.typePass;
            }
            $scope.typePass2=false;
            $scope.change2=function (){
                $scope.typePass2=!$scope.typePass2;
            }
            $scope.typePass3=false;
            $scope.change3=function (){
                $scope.typePass3=!$scope.typePass3;
            }
            $scope.proposal={};
            //$scope.proposal.mySex='1';
            $scope.dropDownShow = false;
           /* $scope.changedropDownShow= function () {
                $scope.dropDownShow = true;
                //$('.drop-down-con').toggle();
                //$scope.dropDownShow =  !$scope.dropDownShow;
            };*/
            $scope.header='header';
            // 登录成功后请求登录机构
            $$user.getLoginUser().then(function (data) {
                var user = data.data.content.userInfo;
                $rootScope.comcodeIndex=user.loginComCode;
                if(data.data.content.retCode == '200') {
                    $$finder.find('selectfind', {
                        'userCode':$rootScope.user.userCode,
                    }, {
                        success: function (data) {
                            $scope.comCodeList=data.content;
                            $rootScope.comcodeIndexList= $scope.comCodeList;
                            //取第一个登陆机构
                            $rootScope.loginComCName = $scope.comCodeList[0].comCName;
                            $scope.code="";
                            $scope.code = $scope.comCodeList[0].comCode
                            $scope.isChange($scope.comCodeList[0].comCode);
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            });
            //登录成功后查询个人信息
            $scope.getLoginUser= function () {
                $$user.checkIsLoginSuccess().then(function (data) {
                    var user = data.data.content.userInfo;

                    if(data.data.content.retCode == '200') {
                        $$finder.find('getUserInfo', {

                        }, {
                            success: function (data) {
                                $rootScope.userInformation=data.content;
                                $scope.user.sex=$rootScope.userInformation.sex;
                                if(!($rootScope.userInformation.sex&&$rootScope.userInformation.identifyNumber&&$rootScope.userInformation.mobile&&$rootScope.userInformation.email)){
                                    layer.open({
                                        offset: ['40%', '40%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,//隐藏滚动条
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: '请完善个人信息！',
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            layer.close(index);
                                            $('.layer-message').css('display','block');
                                            $scope.male();
                                            $scope.proposal.myName=$scope.user.userName;
                                        }
                                    })

                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }
                });
            }
            $scope.getLoginUser();
            $scope.isChange=function(value){
                $rootScope.user.loginComCode=value;
                //防止切换登陆机构时登陆名称没有赋值
                angular.forEach($scope.comCodeList, function (data, index) {
                    if(value==data.comCode){
                        $rootScope.loginComCName = data.comCName;
                    }
                });
                if($rootScope.authSystemFlag==true){
                }
                if($rootScope.systemFlag!='GIS' && ($rootScope.systemFlag!='claim'&&$rootScope.systemFlag!='undwrt')){
                    $rootScope.onQueryMenu();
                    $rootScope.goBackDashboard();
                    $rootScope.start();
                    $rootScope.changeBuesnessNo();
                }
            }
            //注销方法
            $scope.logout = function(){
                $('.layer-password').css('display','none');
                $('.layer-message').css('display','none')
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,//隐藏滚动条
                    closeBtn: 0,
                    title: '温馨提示',
                    content:'确认退出，重新登录？',
                    btn: ['确定','取消'],
                    btn1: function(index, layero){
                        $$user.logout().then(function (data) {
                            // console.log("logout",data);
                            data=data["data"];
                            if(data["code"] && data["code"]=="0000"){
                                if(data["content"]["redirectUrl"]){
                                    window.location.href=data["content"]["redirectUrl"];
                                }
                            }

                        },function (err) {

                        });
                    },
                    btn2:function(index, layero){
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });


            };
            //点击男
            $scope.male =function(){
                $('.man').css('background','#0099CC');
                $('.woman').css('background','#999');
                $('.iconfont-woman').css('display','none');
                $('.iconfont-man').css('display','block');
                $scope.proposal.mySex='1';

            }
            //点击女
            $scope.female= function(){
                $('.man').css('background','#999');
                $('.woman').css('background','#0099CC');
                $('.iconfont-woman').css('display','block');
                $('.iconfont-man').css('display','none');
                $scope.proposal.mySex='2';
            }
            $scope.pressDecimal = function ($event) {
                if (($event.keyCode >= 48 && $event.keyCode <= 57) || $event.keyCode == 46) {
                    return true;
                } else {
                    $event.preventDefault();
                }
            }

            //修改密码弹层
            $scope.cpw =function(){
                $('.layer-message').css('display','none');
                $('.layer-password').css('display','block');
                $("html,body").css({overflow:"hidden"}) //隐藏滚动条
                //$("#cpwform").reset();
                //document.getElementById("cpwform").reset();
                $scope.proposal.originalPassword="";
                $scope.proposal.newPassword="";
                $scope.proposal.password="";
                $scope.proposal.originalPasswordError="";
                $scope.proposal.newPasswordError="";
                $scope.proposal.passwordError="";
                $scope.proposal.Error="";
                $$finder.find('getUserInfo', {}, {
                    success: function (data) {
                        $scope.proposal.userCode=data.content.userCode;
                    },
                    error: function (e) {
                        options.error(e);
                    }

                });
            }
            //原始密码失去焦点
            $scope.originalPasswordBlur=function($event){
                var regex =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str1=regex.test($scope.proposal.originalPassword);
                if (!$scope.proposal.originalPassword){
                    $scope.proposal.originalPasswordError="原始密码不能为空，请重新输入";
                    $event.target.focus();
                }else if (str1==false){
                    $scope.proposal.originalPasswordError="原始密码不符合系统的密码设置规则，请重新输入!";
                    $event.target.focus();
                }else{
                    $scope.proposal.originalPasswordError="";
                }
            }
            //新密码失去焦点
            $scope.newPasswordBlur=function($event){
                var regex2 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str2=regex2.test($scope.proposal.newPassword);
                if (!$scope.proposal.newPassword){
                    $scope.proposal.newPasswordError="新密码不能为空，请重新输入！";
                    $event.target.focus();
                } else if (str2==false){
                    $scope.proposal.newPasswordError="新密码不符合系统的密码设置规则，请重新输入！";
                    $event.target.focus();
                } else if ( $scope.proposal.newPassword==$scope.proposal.originalPassword){
                    $scope.proposal.newPasswordError="新密码不能和原密码一样，请重新输入!";
                    $event.target.focus();
                } else{
                    $scope.proposal.newPasswordError="";
                }
            }
            //重复新密码失去焦点
            $scope.passwordBlur=function($event){
                if ($scope.proposal.password&&($scope.proposal.newPassword!= $scope.proposal.password)){
                    $scope.proposal.passwordError="重复新密码和新密码不一致，请重新输入!";
                    //$scope.proposal.newPassword="";
                    $scope.proposal.password="";
                    $event.target.focus();
                }else {
                    $scope.proposal.passwordError="";
                }

            }
            //修改密码校验
            $scope.check=function(originalPassword,newPassword,password){
                var regex =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str1=regex.test(originalPassword);
                var content="";
               regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str2=regex.test(newPassword);
                if (!$scope.proposal.originalPassword){
                    $scope.proposal.originalPasswordError='原始密码不能为空，请重新输入!';
                    //$scope.proposal.originalPassword="";

                }
                /*else if (str1==false){
                    $scope.proposal.originalPasswordError='原始密码不符合系统的密码设置规则，请重新输入!';
                    $scope.proposal.originalPassword="";

                }*/
                else if (str2==false){
                    $scope.proposal.newPassword="";
                    $scope.proposal.newPasswordError='新密码不符合系统的密码设置规则，请重新输入!'
                }else   if (originalPassword==newPassword){
                    $scope.proposal.newPassword="";
                    $scope.proposal.password="";
                    $scope.proposal.newPasswordError= '新密码不能和原密码一样，请重新输入!';
                }else  if (newPassword!=password){
                    $scope.proposal.password="";
                    $scope.proposal.passwordError= '重复新密码和新密码不一致，请重新输入!';
                }else {
                    $$finder.find('modifypwd', {

                        "oldpwd": originalPassword,
                        "newpwd": newPassword

                    }, {
                        success: function (data) {


                            if (data.code == '0000') {
                                $('.layer-password').css('display', 'none');
                                $("html,body").css({overflow:"auto"})  //出现滚动条
                               var content="密码修改成功！"
                                layer.open({
                                    offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,//隐藏滚动条
                                    title: '温馨提示',
                                    content: content,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        $$user.logout().then(function (data) {
                                            // console.log("logout",data);
                                            data=data["data"];
                                            if(data["code"] && data["code"]=="0000"){
                                                if(data["content"]["redirectUrl"]){
                                                    window.location.href=data["content"]["redirectUrl"];
                                                }
                                            }
                                        },function (err) {

                                        });
                                        layer.close(index);
                                    }
                                });
                            }
                            if (data.code == '9999') {
                                $scope.proposal.Error = data.message;

                                //$scope.proposal.newPassword="";
                                $scope.proposal.originalPassword = "";
                                //$scope.proposal.password="";


                            }


                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

            }
            //姓名失去焦点
            $scope.myNameBlur=function($event){
                var regexname=/([A-Za-z]|[\u4E00-\u9FA5])/g;
                var str=regexname.test($scope.proposal.myName);
                if (!$scope.proposal.myName){
                    $scope.proposal.myNameError="姓名不能为空！";
                    $event.target.focus();
                }else if (str==false){
                    $scope.proposal.myNameError="姓名只能是汉字或者字母！";
                    $event.target.focus();
                }else{
                    $scope.proposal.myNameError=""
                }
            }
            //身份证号码失去焦点
            $scope.myIdNumberBlur=function($event){
                if (!$scope.proposal.myIdNumber){
                    $scope.proposal.myIdNumberError="身份证号码不能为空！";
                    $event.target.focus();
                }else if (!commonApiServ.IdCardValidate($scope.proposal.myIdNumber)){
                    $scope.proposal.myIdNumberError="身份证格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.proposal.myIdNumberError="";
                }
            }
            //电话号码失去焦点
            $scope.myTelNemberBlur=function($event){
                var regexMyTelNember2=/^1[3|4|5|9|6|7|8][0-9]{0,}$/;//电话号码校验
                var regexMyTelNember=/^1[3|4|5|9|6|7|8][0-9]{9}$/;//电话号码校验
                var strMyTelNember=regexMyTelNember.test($scope.proposal.myTelNember);
                if (!$scope.proposal.myTelNember){
                    $scope.proposal.myTelNemberError="电话号码不能为空！";
                    $event.target.focus();
                }else if(!regexMyTelNember2.test($scope.proposal.myTelNember)){
                    $scope.proposal.myTelNemberError="电话号码号段错误，请重新输入！";
                    $event.target.focus();
                }else if(strMyTelNember==false){
                    $scope.proposal.myTelNemberError="电话号码长度错误，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.proposal.myTelNemberError="";
                }
            }
            //邮箱失去焦点
            $scope.myEmailBlur=function($event){

                var regexMyEmail=/\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/g;//邮箱校验
                var strMyEmail=regexMyEmail.test($scope.proposal.myEmail);
                if(!$scope.proposal.myEmail){
                    $scope.proposal.myEmailError="邮箱不能为空！";
                    $event.target.focus();
                }else if (strMyEmail==false){
                    $scope.proposal.myEmailError="邮箱格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.proposal.myEmailError="";
                }
            }
            //生日失去焦点
            $scope.myBirthdayBlur=function($event){
               // var regexMyBirthday=/^(\d{4})-(\d{1,2})-(\d{1,2})$/g;
                var regexMyBirthday = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;//生日校验
                var strMyBirthday=regexMyBirthday.test($scope.proposal.myBirthday);
                if (strMyBirthday==false&&$scope.proposal.myBirthday!=""&&$scope.proposal.myBirthday!=undefined){
                    $scope.proposal.myBirthdayError="生日格式为：**-**-**，请重新输入!";
                    $event.target.focus();
                }else{
                    $scope.proposal.myBirthdayError="";
                }
            }
            //QQ失去焦点
            $scope.myQQBlur=function($event){
                var regexQQ=/[1-9]([0-9]{5,11})/g;//QQ校验
                var strQQ=regexQQ.test($scope.proposal.myQQ);
                if (strQQ==false&&$scope.proposal.myQQ!=""&&$scope.proposal.myQQ!=undefined){
                    $scope.proposal.myQQError="QQ格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.proposal.myQQError=""
                }
            }
            //我的信息
            $scope.saveMyInfo=function(){
                               var regexname=/^[\u4E00-\u9FA5]+$/;//姓名校验
                var str=regexname.test($scope.proposal.myName);
                var regexmyIdNumber=/^\d{17}[\d|x]|\d{15}$/;//身份证校验
                var strMyIdNumber=regexmyIdNumber.test($scope.proposal.myIdNumber);
                var regexMyEmail=/^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}$/;//邮箱校验
                var strMyEmail=regexMyEmail.test($scope.proposal.myEmail);
                var regexMyTelNember=/^0?(13|14|15|16|17|18|19)[0-9]{9}$/;//电话号码校验
                var strMyTelNember=regexMyTelNember.test($scope.proposal.myTelNember);
                var regexMyBirthday=/^(1\d{3}|2\d{3})-(0[1-9]|1[012])-([0-2]\d|3[01])$/;//生日校验
                var strMyBirthday=regexMyBirthday.test($scope.proposal.myBirthday);
                var regexQQ=/^[1-9]([0-9]{5,11})$/;//QQ校验
                var strQQ=regexQQ.test($scope.proposal.myQQ);
                var content = "";
                if (!$scope.proposal.myName){
                    content='姓名不能为空！'
                }else if (str==false){
                    content='姓名只能是汉字或者字母！'
                    $scope.proposal.myName="";
                }else if (!$scope.proposal.mySex){
                    content='性别不能为空！'
                }else if (!$scope.proposal.myIdNumber){
                    content='身份证号码不能为空！'
                }else if (!commonApiServ.IdCardValidate($scope.proposal.myIdNumber)){
                    content='身份证格式不正确，请重新输入！'
                    $scope.proposal.myIdNumber="";
                }else if (!$scope.proposal.myTelNember){
                    content='电话号码不能为空！'
                }else if (strMyTelNember==false){
                    content='电话号码格式不正确，请重新输入！'
                    $scope.proposal.myTelNember="";
                }else if (!$scope.proposal.myEmail){
                    content='邮箱不能为空！'
                }else if (strMyEmail==false){
                    content='邮箱格式不正确，请重新输入！'
                    $scope.proposal.myEmail="";
                }else if (strMyBirthday==false&&$scope.proposal.myBirthday!=""&&$scope.proposal.myBirthday!=undefined){
                    content='生日格式不正确,，请重新输入！格式为：**-**-**';
                    $scope.proposal.myBirthday="";
                }else if (strQQ==false&&$scope.proposal.myQQ!=""&&$scope.proposal.myQQ!=undefined){
                    content='QQ格式不正确，请重新输入！'
                    $scope.proposal.myQQ="";
                }
                if (content) {
                    layer.open({
                        /*offset: ['35%', '29%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,//隐藏滚动条
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return;
                }else{
                    $$finder.find('modifyUserInfo', {
                        "userName":$scope.proposal.myName,
                        "sex":$scope.proposal.mySex,
                        "identifyNumber":$scope.proposal.myIdNumber,
                        "mobile":$scope.proposal.myTelNember,
                        "email":$scope.proposal.myEmail,
                        "Birthday":$scope.proposal.myBirthday,
                        "qq":$scope.proposal.myQQ,
                        "weChat":$scope.proposal.myWeChat,
                        "address":$scope.proposal.myAddress

                    }, {
                        success: function (data) {
                            var con=""
                            if (data.code=="0000"){
                                con="保存成功!";
                                $('.layer-message').css('display','none');
                                $("html,body").css({overflow:"auto"})  //出现滚动条
                            }else{
                                con=data.message
                            }
                            layer.open({
                                scrollbar: false,//隐藏滚动条
                                offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content:con,
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                    $$finder.find('getUserInfo', {

                                    }, {
                                        success: function (data) {
                                            $rootScope.userInformation=data.content;
                                            $scope.user.sex=$rootScope.userInformation.sex
                                            $scope.user.userName=$rootScope.userInformation.userName;
                                        },
                                        error: function (e) {
                                            options.error(e);
                                        }
                                    });
                                    goBackDashboard();
                                }
                            });

                        },
                        error: function (e) {
                            options.error(e);
                        }

                    });
                }

            }
           //电子邮箱后缀
            function inputList(input,list){
                var mailBox = [
                    "@qq.com",
                    "@sina.com",
                    "@163.com",
                    "@126.com",
                    "@yahoo.com.cn",
                    "@gmail.com",
                    "@sohu.com"
                ];
                input.bind('input propertychange', function() {
                    var key = input.val();
                    if(key.indexOf("@") != -1){
                        key = key.slice(0,key.indexOf("@"));
                    }
                    var mailBoxLen = mailBox.length;
                    var html = "";
                    for(var i=0; i<mailBoxLen; i++){
                        html += '<option value="'+ key + mailBox[i] +'"></option>';
                    }
                    list.html(html);
                });
            }
            //修改密码弹层关闭
            $scope.delete_5 =function(){
                $('.layer-password').css('display','none');
                $("html,body").css({overflow:"auto"})  //出现滚动条
            };
            //我的信息弹层
            $scope.message =function(){
                $("html,body").css({overflow:"hidden"}) //隐藏滚动条
                inputList($("#input2"),$("#input_list"));
                $('.layer-password').css('display','none')
                $('.layer-message').css('display','block')
                $scope.proposal.myNameError="";
                $scope.proposal.myIdNumberError="";
                $scope.proposal.myTelNemberError="";
                $scope.proposal.myEmailError="";
                $scope.proposal.myBirthdayError="";
                $scope.proposal.myQQError="";
                $$finder.find('getUserInfo', {}, {
                    success: function (data) {
                        console.log(data)
                        var content=data.content;
                        sexcontent=content.sex;
                        $scope.proposal.myName=content.userName;
                        if(content.sex=="2"){
                            $('.man').css('background','#999');
                            $('.woman').css('background','#0099CC');
                            $('.iconfont-woman').css('display','block');
                            $('.iconfont-man').css('display','none');
                            $scope.proposal.mySex="2";
                        }else{
                            $('.man').css('background','#0099CC');
                            $('.woman').css('background','#999');
                            $('.iconfont-woman').css('display','none');
                            $('.iconfont-man').css('display','block');
                            $scope.proposal.mySex="1"
                        }
                        $scope.proposal.myIdNumber=content.identifyNumber?content.identifyNumber:"";
                        $scope.proposal.myTelNember=content.mobile?content.mobile:"";
                        $scope.proposal.myEmail=content.email?content.email:"";
                        $scope.proposal.myBirthday=content.Birthday?content.Birthday:"";
                        $scope.proposal.myQQ=content.qq?content.qq:"";
                        $scope.proposal.myWeChat=content.weChat?content.weChat:"";
                        $scope.proposal.myAddress=content.address

                    },
                    error: function (e) {
                        options.error(e);
                    }

                });
            };
            //我的信息弹层关闭
            $scope.delete_6 =function(){
                $('.layer-message').css('display','none');
                $("html,body").css({overflow:"auto"})  //出现滚动条
                $scope.getLoginUser();
            };
            $$finder.find("frontEnd", {
            }, {
                success: function (data1) {
                    $rootScope.frontEnd=data1.content;
                },
                error: function (error) {
                    console.error("前端地址配置获取失败:", angular.fromJson(error));
                }
            });
            //修改密码成功弹层关闭
            $scope.delete_7 =function(){
                $('.layer-demo').css('display','none');
                $$user.logout().then(function (data) {
                    // console.log("logout",data);
                    data=data["data"];
                    if(data["code"] && data["code"]=="0000"){
                        if(data["content"]["redirectUrl"]){
                            window.location.href=data["content"]["redirectUrl"];
                        }
                    }

                },function (err) {

                });
            };

        }]);
});