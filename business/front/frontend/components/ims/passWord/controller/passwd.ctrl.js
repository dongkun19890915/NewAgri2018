/**
 * Created by zkr22 on 2016/10/20.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var passwdCtrlHandler = function($scope,passwdServ,$state,FormFocus) {
        /*弹层初始化*/
        $scope.passwdSucLayer = true;
        $scope.passwdFailLayer = true;
        $scope.exitFailLayer = true;

        /*是否为必填*/
        $scope.required=true;

        /*初始化数据*/
        $scope.userDto = {"userCode": $scope.user.userCode};

        /*获取用户信息*/
      var querUserInfo = function(){
          passwdServ.querInfoUser($scope.userDto).then(
              function(answer){
                  if(answer.data==null){
                      angular.alert("该登录账号不存在！");
                  }else{
                      $scope.user = answer.data;
                      if($scope.user.modifyPasswdFlag!="1"){
                          angular.alert("对不起，管理员设置不允许您自行修改密码，请联系管理员！");
                      }
                  }
              },
              function(error){
                  //cconsole.log(JSON.stringify(error.data));
                  //$scope.message="异常错误，请联系管理员！"
                  //$scope.passwdSucLayer = false;
              }
          )
      };
        querUserInfo();

        /*确认密码是否一致*/
        $scope.surePasswd = function(){
            var newPassword = $scope.userDto.newPassword;
            var passwordAgain = $scope.passWordAgain;
            if(newPassword!=passwordAgain&&passwordAgain!=null&&newPassword!=null){
                angular.alert("确认密码与新密码输入不一致！");
            }
        };

        /*校验原密码是否正确*/
        var checkPwd = function(){
            passwdServ.checkPasswd($scope.userDto).then(
                function(answer){
                    var resultCode = answer.data.resultCode;
                    if(resultCode=="0000"){
                        if($scope.userDto.newPassword ==$scope.passWordAgain){
                            updatePwd();
                        }else{
                            angular.alert("确认密码与新密码输入不一致！");
                        }
                    }else{
                        angular.alert("原密码校验失败！");
                    }
                },
                function(error){
                    angular.alert("原密码校验失败！");
                })
        };

        /*修改密码*/
        var updatePwd = function(){
            passwdServ.updatePasswd($scope.userDto).then(
                function(answer){
                    var resultCode = answer.data.resultCode;
                    if(resultCode=="0000"){
                        angular.alert("您的密码修改成功！");
                    }else{
                        angular.alert("您的密码修改失败！");
                    }
                },function(error){
                    angular.alert("异常错误，请联系管理员！");
                });
        };

        /*确定修改密码按钮*/
        $scope.sure = function(){
            $scope.updatePwdDisableFlag = false;
            if (this.updateForm.$invalid) {
                FormFocus.focusEle("updateForm");
                return;
            }
            checkPwd();
        };

        /*页面退出*/
       $scope.exit = function(){
            $state.go('main.index');
        };

        /*弹层的退出*/
        $scope.close = function(){
            $scope.passwdFailLayer = true;
        };
        $scope.sucClose = function(){
            $scope.passwdSucLayer = true;
            $state.go('main.index');
        };
        $scope.checkClose =function(){
            $scope.exitFailLayer = true;
            $state.go('main.index');
        };
    };

    moduleApp.controller('passwdCtrl',['$scope','passwdServ','$state','FormFocus',passwdCtrlHandler]);

});
