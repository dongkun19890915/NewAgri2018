/**
 * Created by guoxianglian on 2016/9/10.
 * 删除模块批单成功控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var documentDelSucCtrl = function($scope,$stateParams) {
        $scope.applyNo = $stateParams.applyNo;
    };

    moduleApp.controller('documentDelSucCtrl',['$scope','$stateParams',documentDelSucCtrl]);
});