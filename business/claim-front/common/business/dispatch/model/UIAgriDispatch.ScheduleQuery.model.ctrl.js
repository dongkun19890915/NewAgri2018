/**
 * DESC       : 国元农险理赔调度---班表查询弹层页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017/12/9
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriDispatchScheduleQueryModelCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','FormFocus',
        function ($rootScope, $scope, $location,$state, $$finder, FormFocus) {
            $scope.checkScheduleQueryFlag = false;
            $scope.$on("ScheduleQueryLayerSwitch",function (event) {
                $scope.checkScheduleQueryFlag = !$scope.checkScheduleQueryFlag; // 弹层显示隐藏
            });
            $scope.close = function () {
                $scope.checkScheduleQueryFlag = false;
            };
        }]);
});