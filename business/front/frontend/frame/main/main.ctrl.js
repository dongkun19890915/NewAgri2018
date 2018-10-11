define(['app','constants','angular'
], function (app,constants,angular) {
    'use strict';
    app.controller('mainCtrl', ['$scope','$rootScope','$state','$q','$$user',
        function ($scope,$rootScope,$state,$q,$$user) {

            /* *
             * 导航栏刷新控制
            * */
            var onStateChange = function(state){
                if(state=="main.index") {
                    $scope.showMainNagiv = false;
                }else{
                    $scope.showMainNagiv = true;
                }
            };
            $scope.$on('$stateChangeSuccess', function(event, toState) {
                console.log("current.state.name="+$state.$current.self.name);
                var stateName = $state.$current.self.name;
                if (angular.isDefined(stateName)) {
                    onStateChange(stateName);
                }
            });


            /* *
             * 页面最小高度控制
             * */
            var winH = $(window).height()-68;
            $(".main_right").css("min-height",winH+'px');

            /* *
             * 菜单开关
             * */
            $scope.isActive=true;
            $scope.navClick = function(){
                $scope.$broadcast('SHOWNAVMENU');
                $scope.isActive=!$scope.isActive;
                $scope.leftFlag = !$scope.leftFlag;
                $scope.rightFlag = !$scope.rightFlag;
            };

        }]);
});