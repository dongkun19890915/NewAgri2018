/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('headerCtrl', ['$rootScope','$state', '$scope', '$$finder','$$user','FormFocus', 'regexpConstants','menuServ','commonApiServ',
        function ($rootScope,$state, $scope, $$finder, $$user, FormFocus, regexpConstants, menuServ,commonApiServ) {
            // $scope.header = 'header';
            // $scope.changePasswordDialog=false;
            // $scope.userMessageiDalog=false;
            $scope.regData = regexpConstants;
            $scope.cardType = '01';
            $scope.personalInfor = { // 个人信息

            };
            $$finder.post('frontEnd',"").then(
                function (data) {
                    $rootScope.frontEnd=data;
                }
            );
            $$user.getLoginUser().then(function (data) {
                $$finder.post("getUserInfo",{}).then(function (data) {
                    $scope.personalInfor = data;
                })
            }
            )

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
            $scope.changePassword = function () {
                $scope.changePasswordDialog = true;
            }
            $scope.delete_5 = function () {
                $scope.changePasswordDialog = false;
            }

            //修改密码校验
            $scope.check=function(originalPassword,newPassword,password){
                var regex =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str1=regex.test(originalPassword);
                var content="";
                regex = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str2=regex.test(newPassword);
                if (!$scope.personalInfor.originalPassword){
                    $scope.personalInfor.originalPasswordError='原始密码不能为空，请重新输入!';
                    //$scope.proposal.originalPassword="";

                }
                /*else if (str1==false){
                    $scope.proposal.originalPasswordError='原始密码不符合系统的密码设置规则，请重新输入!';
                    $scope.proposal.originalPassword="";

                }*/
                else if (str2==false){
                    $scope.personalInfor.newPassword="";
                    $scope.personalInfor.newPasswordError='新密码不符合系统的密码设置规则，请重新输入!'
                }else   if (originalPassword==newPassword){
                    $scope.personalInfor.newPassword="";
                    $scope.personalInfor.password="";
                    $scope.personalInfor.newPasswordError= '新密码不能和原密码一样，请重新输入!';
                }else  if (newPassword!=password){
                    $scope.personalInfor.password="";
                    $scope.personalInfor.passwordError= '重复新密码和新密码不一致，请重新输入!';
                }else {
                    $$finder.post('modifypwd',{
                        "oldpwd": originalPassword,
                        "newpwd": newPassword
                    }).then(
                        function (data) {
                            console.log("以下是修改密码的结果")
                            console.log(data)
                            if (data.resultCode == '0000') {
                                $('.layer-password').css('display', 'none');
                                var content="密码修改成功！"
                                layer.open({
                                    offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
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
                            if (data.resultCode == '9999') {
                                $scope.personalInfor.Error = data.message;

                                //$scope.proposal.newPassword="";
                                $scope.personalInfor.originalPassword = "";
                                //$scope.proposal.password="";

                            }
                        }
                    )
                }

            }

            $scope.newPasswordBlur=function($event){
                var regex2 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                var str2=regex2.test($scope.personalInfor.newPassword);
                if (!$scope.personalInfor.newPassword){
                    $scope.personalInfor.newPasswordError="新密码不能为空，请重新输入！";
                    $event.target.focus();
                } else if (str2==false){
                    $scope.personalInfor.newPasswordError="新密码不符合系统的密码设置规则，请重新输入！";
                    $event.target.focus();
                } else if ( $scope.personalInfor.newPassword==$scope.personalInfor.originalPassword){
                    $scope.personalInfor.newPasswordError="新密码不能和原密码一样，请重新输入!";
                    $event.target.focus();
                } else{
                    $scope.personalInfor.newPasswordError="";
                }
            }

            //重复新密码失去焦点
            $scope.passwordBlur=function($event){
                if ($scope.personalInfor.password&&($scope.personalInfor.newPassword!= $scope.personalInfor.password)){
                    $scope.personalInfor.passwordError="重复新密码和新密码不一致，请重新输入!";
                    //$scope.proposal.newPassword="";
                    $scope.personalInfor.password="";
                    $event.target.focus();
                }else {
                    $scope.personalInfor.passwordError="";
                }

            }
            $scope.modifyMyInfo = function(_this){
                inputList($("#input2"),$("#input_list"));
                _this.userMessageiDalog=true;
                $$finder.post("getUserInfo",{}).then(function (data) {
                    $scope.personalInfor = data;
                    console.log("以下是该客户的客户信息")
                    console.log(data)
                    console.log($scope.personalInfor.sex)
                    var dt = $scope.personalInfor.birthday;
                    var unixTimestamp = new Date( dt) ;
                    var year=unixTimestamp.getFullYear();
                    var month=unixTimestamp.getMonth()+1;
                    var day = unixTimestamp.getDate();
                    var month1 = "";
                    if(month<10){
                        month1 = "0"+month;
                    }else{
                        month1 = month;
                    }
                    var day1 = "";
                    if(day<10){
                        day1 = "0"+day;
                    }else{
                        day1 = day;
                    }
                    $scope.personalInfor.birthday = year+"-"+month1+"-"+day1;
                });
            };
            // $scope.inputUserId = function (_this) {
            //     if(_this.userForm.userId.$valid) { // 校验通过带入性别 生日
            //         var sex =''; // 身份证号性别标识位
            //         var birthday = '';
            //         var userId = $scope.personalInfor.userId;
            //         if(userId.length===15){
            //             sex = userId.substr(14,1);
            //             birthday = '19' + userId.substr(6,2) + '-' + userId.substr(8,2)+'-' +  userId.substr(10,2);
            //         }else {
            //             sex = userId.substr(16,1);
            //             birthday = userId.substr(6,4) + '-' + userId.substr(10,2)+'-' +  userId.substr(12,2);
            //         }
            //         $scope.personalInfor.userGender = sex%2===0?'2':'1';
            //         $scope.personalInfor.birthday = birthday;
            //     }
            //
            // };
			
			// 登录成功后请求登录机构
            $$user.getLoginUser().then(function (data) {
                var user = data.data.content.userInfo;
                $rootScope.comcodeIndex=user.loginComCode;
                if(data.data.content.retCode == '200') {
                    $$finder.post('selectfind', {'userCode':$rootScope.user.userCode}).then(
						function (data) {
                            debugger;
                            $scope.comCodeList=data;
                            $rootScope.comcodeIndexList= $scope.comCodeList;
                            //取第一个登陆机构
                            $rootScope.loginComCName = $scope.comCodeList[0].comCName;
                            $scope.code="";
                            $scope.code = $scope.comCodeList[0].comCode
                            $scope.isChange($scope.comCodeList[0].comCode);
							
						}
					);
				}
			});
            //机构更改的查询方法
            $scope.isChange=function(value){
                console.log('以下是登录机构');
                console.log(value);
                $rootScope.user.loginComCode=value;
                if($rootScope.systemFlag!='GIS' && ($rootScope.systemFlag!='claim'&&$rootScope.systemFlag!='undwrt')){
                    $rootScope.onQueryMenu(value);
                    $rootScope.start();
                    $rootScope.goBackDashboard();
                }

            }

            //注销方法
            $scope.logout = function(){

                $('.layer-password').css('display','none');
                $('.layer-message').css('display','none')
                layer.open({
                    offset: ['45%', '40%'],
                    skin: 'large-layer-content',
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
            $scope.pressDecimal = function ($event) {
                if (($event.keyCode >= 48 && $event.keyCode <= 57) || $event.keyCode == 46) {
                    return true;
                } else {
                    $event.preventDefault();
                }
            }
            //姓名失去焦点
            $scope.myClaimName=function($event){
                var regexname=/([A-Za-z]|[\u4E00-\u9FA5])/g;
                var str=regexname.test($scope.personalInfor.userName);
                if (!$scope.personalInfor.userName){
                    $scope.personalInfor.userNameError="姓名不能为空！";
                    $event.target.focus();
                }else if (str){
                    $scope.personalInfor.userNameError="姓名只能是汉字或者字母！";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.userNameError=""
                }
            }
            //身份证号码失去焦点
            $scope.myClaimIdNumber=function($event){

                if (!$scope.personalInfor.identifyNumber){
                    $scope.personalInfor.identifyNumberError="身份证号码不能为空！";
                    $event.target.focus();
                }else if (!commonApiServ.IdCardValidate($scope.personalInfor.identifyNumber)){
                    $scope.personalInfor.identifyNumberError="身份证格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.identifyNumberError="";
                }
            }
            //电话号码失去焦点
            $scope.myClaimMobile=function($event){
                var regexMyTelNember=/0?(13|14|15|17|18)[0-9]{9}/g;//电话号码校验
                var strMyTelNember=regexMyTelNember.test($scope.personalInfor.mobile);
                if (!$scope.personalInfor.mobile){
                    $scope.personalInfor.mobileError="电话号码不能为空！";
                    $event.target.focus();
                }else if(!strMyTelNember){
                    $scope.personalInfor.mobileError="电话号码格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.mobileError="";
                }
            }
            //邮箱失去焦点
            $scope.myClaimEmail=function($event){
                var regexMyEmail=/\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/g;//邮箱校验
                var strMyEmail=regexMyEmail.test($scope.personalInfor.email);
                if(!$scope.personalInfor.email){
                    $scope.personalInfor.emailError="邮箱不能为空！";
                    $event.target.focus();
                }else if (!strMyEmail){
                    $scope.personalInfor.emailError="邮箱格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.emailError="";
                }
            }
            //生日失去焦点
            $scope.myClaimBirth=function($event){
                // var regexMyBirthday=/^(\d{4})-(\d{1,2})-(\d{1,2})$/g;
                var regexMyBirthday = /^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;//生日校验
                var strMyBirthday=regexMyBirthday.test($scope.personalInfor.birthday);
                if (!strMyBirthday&&$scope.personalInfor.birthday!=""){
                    $scope.personalInfor.birthdayError="生日格式为：**-**-**，请重新输入!";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.birthdayError="";
                }
            }
            //QQ失去焦点
            $scope.myClaimQQ=function($event){
                var regexQQ=/[1-9]([0-9]{5,11})/g;//QQ校验
                var strQQ=regexQQ.test($scope.personalInfor.qq);
                if (!strQQ&&$scope.personalInfor.qq!=""){
                    $scope.personalInfor.qqError="QQ格式不正确，请重新输入！";
                    $event.target.focus();
                }else{
                    $scope.personalInfor.qqError=""
                }
            }

            //点击男
            $scope.male =function(){
                $('.man').css('background','#0099CC');
                $('.woman').css('background','#999');
                $('.iconfont-woman').css('display','none');
                $('.iconfont-man').css('display','block');
                $scope.personalInfor.sex='1';

            }
            //点击女
            $scope.female= function(){
                $('.man').css('background','#999');
                $('.woman').css('background','#0099CC');
                $('.iconfont-woman').css('display','block');
                $('.iconfont-man').css('display','none');
                $scope.personalInfor.sex='2';
            }
            //我的信息弹窗
            $scope.saveUserInfo = function (_this) {
                var regexname=/^[\u4E00-\u9FA5]+$/;//姓名校验
                var str=regexname.test($scope.personalInfor.userName);
                var regexmyIdNumber=/^\d{17}[\d|x]|\d{15}$/;//身份证校验
                var strMyIdNumber=regexmyIdNumber.test($scope.personalInfor.identifyNumber);
                var regexMyEmail=/^\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}$/;//邮箱校验
                var strMyEmail=regexMyEmail.test($scope.personalInfor.email);
                var regexMyTelNember=/^0?(13|14|15|18)[0-9]{9}$/;//电话号码校验
                var strMyTelNember=regexMyTelNember.test($scope.personalInfor.mobile);
                var regexMyBirthday=/^(1\d{3}|2\d{3})-(0[1-9]|1[012])-([0-2]\d|3[01])$/;//生日校验
                var strMyBirthday=regexMyBirthday.test($scope.personalInfor.birthday);
                var regexQQ=/^[1-9]([0-9]{5,11})$/;//QQ校验
                var strQQ=regexQQ.test($scope.personalInfor.qq);

                var content = "";
                if (!$scope.personalInfor.userName){
                    content='姓名不能为空！'
                }else if (!str){
                    content='姓名只能是汉字或者字母！'
                    $scope.personalInfor.userName="";
                }else if (!$scope.personalInfor.sex){
                    content='性别不能为空！'
                }else if (!$scope.personalInfor.identifyNumber){
                    content='身份证号码不能为空！'
                }else if (!commonApiServ.IdCardValidate($scope.personalInfor.identifyNumber)){
                    content='身份证格式不正确，请重新输入！'
                    $scope.personalInfor.identifyNumber="";
                }else if (!$scope.personalInfor.mobile){
                    content='电话号码不能为空！'
                }else if (!strMyTelNember){
                    content='电话号码格式不正确，请重新输入！'
                    $scope.personalInfor.mobile="";
                }else if (!$scope.personalInfor.email){
                    content='邮箱不能为空！'
                }else if (!strMyEmail){
                    content='邮箱格式不正确，请重新输入！'
                    $scope.personalInfor.email="";
                }else if (!strMyBirthday&&$scope.personalInfor.birthday!=""&&$scope.personalInfor.birthday!=undefined){
                    content='生日格式不正确,，请重新输入！格式为：**-**-**';
                    $scope.personalInfor.birthday="";
                }else if (!strQQ&&$scope.personalInfor.qq!=""&&$scope.personalInfor.qq!=undefined){
                    content='QQ格式不正确，请重新输入！'
                    $scope.personalInfor.qq="";
                }
                //传参
                if(content){
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
                            FormFocus.focusEle('userForm');
                        }
                    });
                    return;
                }else{
                    $$finder.post('modifyUserInfo', {
                        "userName":$scope.personalInfor.userName,
                        "sex":$scope.personalInfor.sex,
                        "identifyNumber":$scope.personalInfor.identifyNumber,
                        "mobile":$scope.personalInfor.mobile,
                        "email":$scope.personalInfor.email,
                        "Birthday":$scope.personalInfor.birthday,
                        "qq":$scope.personalInfor.qq,
                        "weChat":$scope.personalInfor.weChat,
                        "address":$scope.personalInfor.address
                    }).then(function (data) {
                        _this.userMessageiDalog = false;
                        layerMsg("保存成功!");
                    });
                }
                /*if(_this.userForm.$valid){
                    $$finder.post("modifyUserInfo",$scope.personalInfor).then(function (data) {
                        _this.userMessageiDalog = false
                    });

                } else {
                    FormFocus.focusEle('userForm');
                }*/

            }
            //
            // $scope.checkidentifyNumber= function ($event,str) {
            //     if(str){
            //         if(!IdCardValidate(str)){
            //             $scope.check.identifyNumber="身份证号码格式不正确，请修改！";
            //             $event.target.focus();
            //         }else{
            //             $scope.check.identifyNumber="";
            //         }
            //     }else{
            //         $scope.check.identifyNumber="";
            //     }
            // }
            //
            // IdCardValidate = function (idCard) {
            //     idCard = this.trim(idCard.replace(/ /g, "")); //去掉字符串头尾空格
            //     if (idCard.length == 15) {
            //         return this.isValidityBrithBy15IdCard(idCard); //进行15位身份证的验证
            //     } else if (idCard.length == 18) {
            //         var a_idCard = idCard.split(""); // 得到身份证数组
            //         if(this.isValidityBrithBy18IdCard(idCard) && this.isTrueValidateCodeBy18IdCard(a_idCard)){//进行18位身份证的基本验证和第18位的验证
            //             return true;
            //         }else {
            //             return false;
            //         }
            //     } else {
            //         return false;
            //     }
            // }
            //
            // isValidityBrithBy15IdCard = function(idCard15){
            //     var year =  idCard15.substring(6,8);
            //     var month = idCard15.substring(8,10);
            //     var day = idCard15.substring(10,12);
            //     var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
            //     // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
            //     if(temp_date.getYear()!=parseFloat(year)
            //         ||temp_date.getMonth()!=parseFloat(month)-1
            //         ||temp_date.getDate()!=parseFloat(day)){
            //         return false;
            //     }else{
            //         return true;
            //     }
            // }
            //
            // isValidityBrithBy18IdCard = function(idCard18) {
            //     var year = idCard18.substring(6, 10);
            //     var month = idCard18.substring(10, 12);
            //     var day = idCard18.substring(12, 14);
            //     var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
            //     // 这里用getFullYear()获取年份，避免千年虫问题
            //     if (temp_date.getFullYear() != parseFloat(year)
            //         || temp_date.getMonth() != parseFloat(month) - 1
            //         || temp_date.getDate() != parseFloat(day)) {
            //         return false;
            //     } else {
            //         return true;
            //     }
            // }
            //
            // isTrueValidateCodeBy18IdCard=function (a_idCard) {
            //     var valCodePosition;
            //     var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 身份证验证位值.10代表X
            //     var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子
            //     var sum = 0; // 声明加权求和变量
            //     if (a_idCard[17].toLowerCase() == 'x') {
            //         a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作
            //     }
            //     for ( var i = 0; i < 17; i++) {
            //         sum += Wi[i] * a_idCard[i];            // 加权求和
            //     }
            //     valCodePosition = sum % 11;                // 得到验证码所位置
            //     if (a_idCard[17] == ValideCode[valCodePosition]) {
            //         return true;
            //     } else {
            //         return false;
            //     }
            // }

            //此为菜单查询的入参
            $scope.userInfo = {
                comCode:$rootScope.user.loginComCode,
                userCode:$rootScope.user.userCode,
                systemCode:"claim"
            }

            $rootScope.goBackDashboard=function () {
                    $state.go('dashboard')
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

            //递归取菜单
            var changeData=function(data,ary){
                var ary=ary||[];
                angular.forEach(data,function(item,index){
                    ary.push(item.utiMenuDto)
                    item.utiMenuDto.nodes=[];
                    if(item.childMenuList&&item.childMenuList.length!=0){
                        changeData(item.childMenuList,item.utiMenuDto.nodes)
                    }
                })
                return ary
            }

        }]);
});