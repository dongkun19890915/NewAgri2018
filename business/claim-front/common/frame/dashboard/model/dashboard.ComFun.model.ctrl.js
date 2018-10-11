/**
 * DESC       : 国元农险理赔工作台---修改常用功能弹层页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app,constants,layer) {
    'use strict';
    app.registerController('dashboardComFunModelCtrl', ['$rootScope', '$scope','$$finder',
        function ($rootScope, $scope, $$finder){
            $scope.checkComFunFlag = false;
            $scope.$on("ComFunLayerSwitch",function (event) {
                $scope.checkComFunFlag =! $scope.checkComFunFlag;
            })
            $scope.close = function () {
                $scope.checkComFunFlag = false;
            }



        }]);
});