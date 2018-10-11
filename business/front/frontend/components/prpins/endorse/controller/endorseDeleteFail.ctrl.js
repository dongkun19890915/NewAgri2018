/**
 * Created by guoxianglian on 2016/9/10.
 * 删除模块批单失败控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseDeleteFailCtrl = function($scope,$stateParams) {
        $scope.applyNo = $stateParams.applyNo;
    };
    moduleApp.controller('endorseDeleteFailCtrl',['$scope','$stateParams',endorseDeleteFailCtrl]);
});