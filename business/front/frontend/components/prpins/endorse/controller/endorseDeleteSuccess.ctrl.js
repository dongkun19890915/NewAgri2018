/**
 * Created by guoxianglian on 2016/9/10.
 * 删除模块批单成功控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseDeleteSuccessCtrl = function($scope,$stateParams) {
        $scope.applyNo = $stateParams.applyNo;
    };
    moduleApp.controller('endorseDeleteSuccessCtrl',['$scope','$stateParams',endorseDeleteSuccessCtrl]);
});