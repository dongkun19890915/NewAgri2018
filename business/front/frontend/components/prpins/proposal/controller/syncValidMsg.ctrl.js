/**
 * Created by GuoXiangLian on 2016/9/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var syncValidMsgCtrl = function($scope,$state,$stateParams,$window,$interval) {
        $scope.proposalNo = $stateParams.proposalNo;
        $scope.sumPremium = $stateParams.sumPremium;
        $scope.applyName = $stateParams.applyName;
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index");
        };
    };
    moduleApp.controller('syncValidMsgCtrl',['$scope','$state','$stateParams','$window','$interval',syncValidMsgCtrl]);
});
