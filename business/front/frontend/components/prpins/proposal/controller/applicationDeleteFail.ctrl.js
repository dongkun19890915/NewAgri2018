/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保成功控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var applicationDelFailCtrl = function($scope,$stateParams) {
        $scope.proposalNo = $stateParams.proposalNo;
    };
    moduleApp.controller('applicationDelFailCtrl',['$scope','$stateParams',applicationDelFailCtrl]);
});