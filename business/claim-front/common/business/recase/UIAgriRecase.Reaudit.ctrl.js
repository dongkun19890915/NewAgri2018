/**
 * DESC       : 国元农险理赔班表管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.29
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                      班表管理-新增班表页面控制器搭建
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriRecaseReauditCtrl', ['$rootScope', '$scope', '$location', '$state', '$$finder','$stateParams',
        function ($rootScope, $scope, $location, $state ,$$finder, $stateParams) {
            $scope.queryDto={};
            $scope.state = $stateParams.state;
            // console.log($scope.state);
            // console.log(888);

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };




        }]);
});