/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'common/frame/header/header.ctrl',
    'common/frame/menu/menu.ctrl',
    'common/frame/menu/menu.serv'

], function (app,constants) {
    'use strict';
    app.registerController('mainCtrl', ['$scope', '$rootScope','$$user','$$cherry', '$http','$timeout','$state','$$finder',
        function ($scope, $rootScope, $$user, $$cherry, $http,$timeout,$state,$$finder) {
            $scope.parameterConvert={};
            /*
             * 菜单刷新高亮显示
             * */
            $scope.getMenuData=function(data){
                $scope.menuData=data;
            }
            $scope.currentURL ={
                currentType:"dashboard"
            };
            $scope.mainViewFlag=true;// 菜单及顶栏显示控制
            $rootScope.$on("$stateChangeStart",function (event,toState, toParams, fromState, fromParams) {
                console.log(toParams.authSystemFlag );
                if(toState.name!="message") {
                    if (toParams.authSystemFlag == null || toParams.authSystemFlag == ""  ) {
                        $scope.authSystemFlag = true;//是否有系统和菜单访问权限
                    } else {
                        $scope.mainViewFlag=false;
                        $scope.authSystemFlag = false;
                        if(toParams.authSystemFlag!="claim" && toParams.authSystemFlag!="undwrt") {
                            $$finder.find('checkURLPower', "url=" + toState.name, {
                                success: function (data) {
                                    var authFlag = data.content.authFlag;
                                    if (!authFlag) {
                                        event.preventDefault();
                                        $state.go("message", {
                                            "message": "人员权限不足",
                                            "authSystemFlag": toParams.authSystemFlag
                                        });
                                    }
                                    console.log(data);
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        }else{
                            $scope.authSystemhead=true;
                        }

                    }
                }
                $rootScope.mainViewFlag=$scope.mainViewFlag;
                $rootScope.authSystemFlag=$scope.authSystemFlag;
                $rootScope.systemFlag=toParams.authSystemFlag;
            });
            $rootScope.$on("$stateChangeSuccess",function (event) {
                $timeout(function(){
                    $scope.currentURL.currentType = $state.$current.name;
                },200)
            });
            $rootScope.goBackDashboard=function(){
                $state.go('dashboard')
            }
            //判斷是否是空對象
            $rootScope.isEmptyObject= function (e) {
                var t;
                for (t in e)
                    return !1;
                return !0
            }
        }]);

});