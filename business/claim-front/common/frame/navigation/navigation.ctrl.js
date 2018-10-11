define(['app','constants'], function (app,constants) {
    'use strict';
    app.registerController('navigationCtrl', ['$rootScope','$location','$scope','$state','menuServ','localStorageService',
        function($rootScope,$location,$scope, $state, menuServ,localStorageService) {

            function navChange(toState){
                //调用menu.serv.js中的getMenuName方法
                var obj = menuServ.getMenuNameFoPosition(toState);
                //当判断成立时，函数直接跳出函数，以下的函数就停止执行。
                //当进行一次页面加载后，obj.menuName中就会保存一个值。此时判断就不会成立，继续以下的方法。
                console.log(obj);
                var NAVIGATION =  localStorageService.get(constants.NAVIGATION);
                if(!obj.parentMenu&&!obj.menuName && !NAVIGATION){
                    return
                }else if(!obj.parentMenu&&!obj.menuName && NAVIGATION){
                    obj = NAVIGATION;
                }
                if(obj.parentMenu){
                    $scope.parentMenu=obj.parentMenu;
                    $scope.parentShow=true
                }else {
                    $scope.parentShow=false
                }
                if(obj.menuName != null && obj.menuName != ""){
                    $scope.state = toState;
                    $scope.title = obj.menuName;
                }

                if(toState == 'dashboard'){
                    $scope.navigationShow = false;
                }else{
                    $scope.navigationShow = true;
                }
                localStorageService.set(constants.NAVIGATION,obj);
            }
            //初始化页面信息
            $scope.crumbslist = [
                {state: "dashboard", name: "首页"}
            ];
            $scope.$on('$stateChangeSuccess', function(event, toState) {
                //获取当前的url
                console.log($state);
                var stateName = $state.$current.self.name;
                if (angular.isDefined(stateName)) {
                    navChange(stateName);
                }
            });
        }]);
});