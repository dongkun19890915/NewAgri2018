/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var modifyPasswordCtrl = function ($scope,$state,$stateParams,modifyPasswordServ,FormFocus) {
        /*初始化数据*/
        var userCode = $stateParams.continueData;
        $scope.userDto ={"userCode":userCode};

        /*弹层*/
        $scope.userCheckUserCodeFailLayer = true;
        $scope.userFailLayer = true;
        $scope.userSucLayer = true;
        $scope.updatePasswdSucLayer = true;

        /*禁用保存按钮*/
        $scope.updatePwdDisableFlag = false;

        /*点击关闭*/
        $scope.userClose = function(){
            $scope.userSucLayer = true;
            $scope.userFailLayer = true;
            $scope.checkPwdFailLayer = true;
            $scope.userCheckUserCodeFailLayer = true;
        };

        /*确认密码*/
        $scope.surePasswd = function(){
            var newPassword = $scope.userDto.newPassword;
            var passwordAgain = $scope.passWordAgain;
            if(newPassword!=passwordAgain&&passwordAgain!=null&&newPassword!=null){
                $scope.userCheckUserCodeFailLayer = false;
            }
        };

    /*确定修改密码按钮*/
    $scope.sure = function(){
        console.log($scope.userDto.newPassword);
        $scope.updatePwdDisableFlag = false;
        if (this.updateForm.$invalid) {
            FormFocus.focusEle("updateForm");
            $scope.updatePwdDisableFlag = false;
            return;
        }
        if($scope.userDto.newPassword==userCode){
            angular.alert("密码和账户名重复！");
        }else{
            var data = $scope.userDto;
            /*禁用保存按钮*/
            $scope.updatePwdDisableFlag=true;
            surePassword();
        }
    };

        /*确认密码*/
        var surePassword = function(){
            var newPassword = $scope.userDto.newPassword;
            var passwordAgain = $scope.passWordAgain;
            if(newPassword!=passwordAgain){
                $scope.userCheckUserCodeFailLayer = false;
            }else{
                updatePassword();
            }
        };

        /*修改密码*/
        var updatePassword = function(){
            var data = $scope.userDto;
           modifyPasswordServ.updatePassWord(data).then(
            function (answer){
                var result = answer.data;
                if(result.resultCode=="0000"){
                    $scope.message=result.resultMsg;
                    $scope.updatePasswdSucLayer = false;
                    $scope.updatePwdDisableFlag = true;
                }else{
                    $scope.message=userCode+"密码校验未通过";
                    $scope.userFailLayer = false;
                }
            },function (error){
                   $scope.message=result.resultMsg;
                   $scope.userFailLayer = false;
                });
        };

        /*校验用户名与密码是否一致*/
        $scope.checkUserCode=function(){
            var newPassword = $scope.userDto.newPassword;
          if(userCode==newPassword){
              angular.alert("密码和账户名重复！");
          }
        };
        
        /*退出按钮*/
        $scope.exit = function(){
            $state.go('main.user');
        };
        $scope.updateSuc = function(){
            $state.go('main.user');
        }
    };
    moduleApp.controller('modifyPasswordCtrl',['$scope','$state','$stateParams','modifyPasswordServ',modifyPasswordCtrl]);

});

