/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var usermaintainCtrl = function ($scope,$state,$stateParams,usermaintainServ,FormFocus) {
        /*获取证件类型*/
        var idefiType = "PersonalIdentifyType";
        var conditionDto = {"codeType":idefiType};

        /*获取登录用户*/
        var globalUserCode = $scope.user.userCode;
        var userDtoInIt = {"userCode":globalUserCode};

        /*是否是共享账户*/
        $scope.nameTrue = "请输入姓名";
        $scope.tureFalse = "录单人员录入";
        $scope.trueFalse1 = "业务人员录入";

        /*修改标志*/
        var modifyFlag = false;

        /*密码标志*/
        $scope.hideFlag=false;

        /*readonly 是否只读*/
        $scope.userCodeReadonly=false;
        $scope.proviceReadonly = false;

        /*证件号码是否必填*/
        $scope.codeTypeT = false;

        /*弹层窗提示*/
        $scope.userSucLayer = true;
        $scope.userFailLayer = true;
        $scope.userCheckPasswdAndUserCode = true;
        $scope.userUpdateSucLayer = true;
        $scope.userSaveSucLayer = true;
        $scope.exitLayer = true;

        /*确定按钮是否禁用*/
        $scope.userSaveDisableFlag=false;
        var searchFlag=false;

        /*正则*/
        $scope.userCodePattern = "/^[a-zA-Z][a-zA-Z0-9_-]{5,19}$/";
        $scope.requiredFlag = true;
        $scope.userDto = {};
        $scope.UserGradeConditionDto ={};
        $scope.userDto.grade={};
        $scope.userDto.validStatus = "1";
        $scope.gradeRequire = true;
        var userCode = $stateParams.continueData;

        /*初始化*/
        var init=function() {
            var userDto = $scope.userDto;
            if (userCode) {
                //修改页面，加载机构信息
                var userDtoModify ={"userCode":userCode} ;
                modifyFlag = true;
                $scope.requiredFlag = false;
                $scope.hideFlag=true;
                $scope.userCodePattern="";
                userDto.userCode = userCode;
                queryUserInfo(userDto);
                queryHeacComCode(userDtoModify);
                queryProviceComCode(userDtoModify);
                queryGradeList(userDto);
                $scope.userCodeReadonly = true;
            }else{
                var nullDto = {};
                modifyFlag = false;
                queryHeacComCode(userDtoInIt);
                queryProviceComCode(userDtoInIt);
                queryGrade(nullDto);
            }
        };

        /*修改页面获取岗位*/
        var queryGradeList = function(){
            usermaintainServ.queryListGrade($scope.userDto).then(
                function(answer){
                    angular.forEach(answer.data,function(grade){
                        grade.gradeTName = true;
                        if(grade.flag=="1") {
                            grade.gradeTName = false;
                        }
                        //  共同体运维用户 执行机构超级用户 成员公司超级用户 岗位信息不是必填
                        if( (grade.gradeCode == '001' || grade.gradeCode == '002' || grade.gradeCode == '003')
                            && grade.checked == true){
                            $scope.gradeRequire = false;
                        }
                    });
                    $scope.grades=answer.data;
                },
                function(error){
                    console.log(JSON.stringify(error.date))
                })
        };
        /*是否指定密码修改岗位*/
        var modifyPwdGrade = function (flag) {
            $scope.grades.forEach(
                function (grade) {
                    // 007 修改密码岗
                    if(grade.gradeCode == '007'){
                        grade.checked = flag;
                    }
                }
            );
        };
        /*保存时岗位校验*/
        var validateGrade = function (grades) {
           var count = 0;
            grades.forEach(
               function(grade){
                   if (grade.checked && grade.gradeCode != '006' && grade.gradeCode != '007' ) {
                       count++;
                   }
               }
            );
            if (count == 0 ){
                return false;
            }else{
                return true;
            }
        };
        /*查询岗位*/
        var queryGrade = function(nullDto){
            usermaintainServ.gradeQuery(nullDto).then(
                function(answer){
                  angular.forEach(answer.data,function(data){
                        data.gradeTName = true;
                        if(data.flag=="1") {
                            data.gradeTName = false;
                        }
                    });
                    $scope.grades=answer.data;
                },
                function(error){
                    console.log(JSON.stringify(error.date))
                })
        };

        /*所属保险公司   */
        var queryHeacComCode = function(userDto){
            usermaintainServ.queryHeacComCode(userDto).then(
                function(answer){
                    $scope.headComName = answer.data;
                    $scope.userDto.headComCode=$scope.headComName.comCode;
                },function (error) {
                    console.log(JSON.stringify(error.date))
                }
            )};

        /*获取省级机构*/
       var queryProviceComCode = function(userDto){
            userDto.validStatus = '1';
            usermaintainServ.proviceComCodeQuery(userDto).then(
                function(answer){
                    $scope.queryProviceList=answer.data;
                },function(error){
                    console.log(JSON.stringify(error.date))
                }
            )};
        /*获取个人用户信息*/
        var queryUserInfo = function(userDto){
            usermaintainServ.queryInfoUser(userDto).then(
                function(answer){
                    $scope.userDto= answer.data;
                    console.log(answer.data);
                    if(answer.data.modifyPasswdFlag=="1"){
                        $scope.modifyPasswdFlagLeft = false;
                        $scope.modifyPasswdFlagRight = false;

                    }else{
                        $scope.modifyPasswdFlagLeft = true;
                        $scope.modifyPasswdFlagRight = true;
                    }
                    if(answer.data.shareFlag=="1"){
                        $scope.isFlag = false;
                        $scope.isNotFlag = false;
                        $scope.tureFalse = "共享账号无需填写";
                        $scope.trueFalse1 = "共享账号无需填写";
                        $scope.nameTrue = "共享账号无需填写";
                    }else{
                        $scope.isFlag = true;
                        $scope.isNotFlag = true;
                        $scope.tureFalse = "录单人员录入";
                        $scope.trueFalse1 = "业务人员录入";
                    }
                },function(error){
                    console.log(JSON.stringify(error.date))
                })
        };

        /*保存用户*/
        var saveUser = function(userDto){
            /*禁用确定按钮*/
            $scope.userSaveDisableFlag=true;
            usermaintainServ.saveUser(userDto).then(
                function(answer){
                    var userSaveData = answer.data;
                    if(userSaveData.resultCode==null||userSaveData.resultCode=="9999"){
                        $scope.message = userSaveData.resultMsg;
                        $scope.userFailLayer = false;
                        /*启用确定按钮*/
                        $scope.userSaveDisableFlag=false;
                    }else{
                        $scope.message =userDto.userCode+"保存成功";
                        $scope.userSaveSucLayer = false;
                        console.log("保存用户接口返回信息为", userSaveData);
                        /*禁用确定按钮*/
                        $scope.userSaveDisableFlag=true;
                    }
                },
                function(error) {
                    $scope.message=JSON.stringify(error.data);
                    /*启用确定按钮*/
                    $scope.userSaveDisableFlag=false;
                  //  $scope.userFailLayer = false;
                })
        };

        /*修改用户*/
        var updateUser = function(userDto){
            $scope.userSaveDisableFlag = true;
            userDto.proviceComCode = userDto.proviceComCode?userDto.proviceComCode:'';
            userDto.identityType =  userDto.identityType? userDto.identityType :'';
            usermaintainServ.updateUser(userDto).then(
                function(answer){
                    if(answer.data.resultCode=="0000"){
                        //更新成功
                        $scope.message =userDto.userCode+"修改成功";
                        $scope.userSaveSucLayer = false;
                        /*  确定按钮是否禁用*/
                        $scope.userSaveDisableFlag=true;
                    }else{
                        $scope.message=answer.data.resultMsg;
                        $scope.userFailLayer = false;
                        /*启用确定按钮*/
                        $scope.userSaveDisableFlag = false;
                    }
                },
                function(error){
                    $scope.message=answer.data.resultMsg;
                    /*启用确定按钮*/
                    $scope.userSaveDisableFlag = false;
                  //  $scope.userFailLayer = false;
                })
        };

        /*判断账号和密码是否一致*/
        $scope.checkPasswdAndUserCode = function(){
            var userCode =  $scope.userDto.userCode;
            var passWord = $scope.userDto.passWord;
            if(userCode!=null){
                if(userCode!=passWord){
                }else{
                    $scope.userCheckPasswdAndUserCode = false;
                }
            }
        };

        /*证件类型和证件号码的绑定*/
        $scope.$watch("userDto.identityType",function(){
             if($scope.userDto.identityType){
                 $scope.codeTypeT = true;
                 if(!$scope.userDto.identifyNumber){
                     $(".validation-errorText[name='identifyNumber']").html("已选择证件类型，必须录入证件号码");
                     $(".validation-errorText[name='identifyNumber']").show();
                 }
            }else{
                 $scope.codeTypeT = false;
                 $scope.userDto.identifyNumber = "";
                 $(".validation-errorText[name='identifyNumber']").hide();
            }
        });


        init();

        /*radio -是否能修改密码*/
        $scope.modifyPasswdFlagLeft = true;
        $scope.modifyPasswdFlagRight =true;
        $scope.userDto.modifyPasswdFlag= "0";
        $scope.modifyClick1 = function(){
             $scope.userDto.modifyPasswdFlag = '0';
             $scope.modifyPasswdFlagLeft = true;
             $scope.modifyPasswdFlagRight = true;
             modifyPwdGrade(false);
        };
        $scope.modifyClick = function(){
            $scope.userDto.modifyPasswdFlag = '1';
            $scope.modifyPasswdFlagLeft = false;
            $scope.modifyPasswdFlagRight = false;
            modifyPwdGrade(true);
        };
        /*radio -是否是共保体公司*/
        $scope.isFlag = true;
        $scope.isNotFlag = true;
        $scope.userDto.shareFlag = "0";
        $scope.isClick = function(){
            $scope.userDto.shareFlag = '1';
            $scope.isFlag = false;
            $scope.isNotFlag = false;
            $scope.tureFalse = "共享账号无需填写";
            $scope.trueFalse1 = "共享账号无需填写";
            $scope.nameTrue = "共享账号无需填写";
            if(modifyFlag==false){
                $scope.userDto.salesManName="";
                $scope.userDto.recordManCode="";
                $scope.userDto.salesManCode="";
            }
        };
        $scope.isClick1 = function(){
            $scope.userDto.shareFlag = '0';
            $scope.isFlag = true;
            $scope.isNotFlag = true;
            $scope.tureFalse = "录单人员录入";
            $scope.trueFalse1 = "业务人员录入";
             $scope.nameTrue = "";
        };

        /*弹层点击关闭*/
        $scope.userClose = function(){
           // $state.go('main.user');
            $scope.userSucLayer = true;
            $scope.userFailLayer = true;
            $scope.userCheckPasswdAndUserCode = true;
            $scope.userUpdateSucLayer = true;
        };

        /*保存成功退出按钮*/
        $scope.userSaveSucClose = function(){
            $scope.userSaveSucLayer = true;
            $state.go("main.user");
        };

        /*新增页面退出按钮*/
        $scope.exitClose = function(){
            $scope.exitLayer = true;
        };
        $scope.exitSucClose = function(){
            $scope.exitLayer = true;
            $state.go("main.user");
        };

        /*校验账号是否重复*/
        $scope.checkUserCode = function(){
            //判断是修改还是保存
           var usermodify = $stateParams.continueData;
            var userDtoData = $scope.userDto;
            if(!usermodify){
                usermaintainServ.checkUserCode(userDtoData).then(
                    function(answer){
                        var checkUserCodeData = answer.data;
                        if( answer.data.resultCode=="0000"){

                        }else{
                            $scope.message=answer.data.resultMsg;
                            $scope.userFailLayer = false;
                        }
                    },
                    function(error){
                        $scope.message=JSON.stringify(error.data);
                        $scope.message=answer.data.resultMsg;
                     //   $scope.userFailLayer = false;
                    })
            }
        };

        /*确定按钮*/
        $scope.userSave = function() {
            $scope.userDto.grades = $scope.grades;
            console.log($scope.userDto.grades);
            var data = $scope.userDto;
            /*禁用保存按钮*/
            if (this.userSaveForm.$invalid) {
                FormFocus.focusEle("userSaveForm");
                return;
            }
            //检查岗位
            if(!validateGrade($scope.userDto.grades)){
                $scope.message = "请选择岗位";
                $scope.userFailLayer = false;
                return;
            }
            // 填了证件号码必须选择证件类型，选了证件类型必须填证件号码
            if((data.identifyNumber !== undefined && data.identifyNumber.length > 0) ^ ( data.identityType!== undefined && data.identityType.length > 0)            ){
                $scope.message = "证件类型和证件号码需同时填写";
                $scope.userFailLayer = false;
                return;
            }
            if (modifyFlag) {
                updateUser(data);
            } else {
                if($scope.userDto.passWord==$scope.userDto.checkPassWord){
                    if($scope.userDto.passWord==$scope.userDto.userCode){
                        $scope.message = "密码与账户不能相同";
                        $scope.userFailLayer = false;
                    }else {
                        saveUser(data);
                    }
                }else{
                    $scope.message = "两次输入密码不一致，请重新输入";
                    $scope.userFailLayer = false;
                }
            }
        };

        /*退出按钮*/
        $scope.exit = function(){
            $scope.message = "  确认退出？";
            $scope.exitLayer = false;
        };
        
        /*退出取消按钮*/
        $scope.exitCancel = function(){
            $scope.exitLayer = true;
        };
    };
    moduleApp.controller('usermaintainCtrl',['$scope','$state','$stateParams','usermaintainServ','FormFocus',usermaintainCtrl]);
});

