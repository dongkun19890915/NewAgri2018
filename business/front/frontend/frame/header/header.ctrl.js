define(['app','constants','angular'
], function (app,constants,angular) {
    'use strict';
    app.controller('headerCtrl', ['$scope','$rootScope','$q','$$user','$translate','localStorageService',
        function ($scope,$rootScope,$q,$$user,$translate,localStorageService) {

            $scope.langs = [{code:'zh-cn',name:"中文"},{code:"en-us",name:"English"}];
            $scope.switchLanguage = function () {
                $translate.use($scope.loginUser.language);
                localStorageService.set("userLang",$scope.loginUser.language);
            };
            /* *
            *登录注销响应
            * */
            $scope.logout = function(){
                $$user.logout(function(){
                    var deffer = $q.defer();
                    angular.comfirm("确定要注销吗?",{okCallback:function(ok){
                        deffer.resolve();
                    },closeCallback:function(cancel){
                        deffer.reject();
                    }});
                    return deffer.promise;

                    /*var deffer = $q.defer();
                    if(confirm('确定要注销吗?'))
                        deffer.resolve();
                    else
                        deffer.reject();
                    return deffer.promise;*/
                });
            };


            /* *
            * 获取用户已登录信息
            * */
            var user = $$user.getUser();
            $scope.loginUser = $scope.loginUser || {};
            $scope.loginUser.userCode = user.userCode;
            $scope.loginUser.userName = user.userName;
            console.log("#######:"+localStorageService.get("userLang"));
            $scope.loginUser.language = localStorageService.get("userLang") || 'zh-cn';

            console.info("welcode:",user.userName);

        }]);
});