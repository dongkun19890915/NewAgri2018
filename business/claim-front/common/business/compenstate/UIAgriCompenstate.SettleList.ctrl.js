/**
 * DESC       : 国元农险理赔理算缮制理赔清单页面
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
    app.registerController('UIAgriCompenstateSettleListCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams',
        function ($rootScope, $scope, $location, $$finder, $stateParams) {
            $scope.queryDto={};
            $scope.state = $stateParams.state;
            console.log($scope.state);

            $scope.isShow=false;
            $scope.showPage= function () {
                $scope.isShow=!$scope.isShow;
            };
            $scope.context=false;
            $scope.showContext= function () {
                $scope.context=!$scope.context;
            }
        }]);
});