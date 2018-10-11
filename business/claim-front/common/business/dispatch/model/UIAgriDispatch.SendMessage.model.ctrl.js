/**
 * DESC       : 国元农险理赔调度---短信发送弹层页面
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
    app.registerController('UIAgriDispatchSendMessageModelCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','$stateParams','FormFocus',
        function ($rootScope, $scope, $location,$state, $$finder,$stateParams, FormFocus) {
            $scope.checkSendMessageFlag = false;
            //

            $scope.$on("SendMessageLayerSwitch",function (event) {
                $scope.checkSendMessageFlag = !$scope.checkSendMessageFlag; // 弹层显示隐藏
            });
            $scope.close = function () {
                $scope.checkSendMessageFlag = false;
            };
        }]);
});