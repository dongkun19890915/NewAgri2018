/**
 * DESC       : 国元农险理赔立案任务---理赔沟通弹层
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriClaimCommunicationModelCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$state',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state) {
            $scope.checkCommunicationFlag = false;
            $scope.$on("SendCommunicationLayerSwitch",function (event) {
                $scope.checkCommunicationFlag = !$scope.checkCommunicationFlag; // 弹层显示隐藏
            })
            $scope.close = function () {
                $scope.checkCommunicationFlag = false;
            };
            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);
});