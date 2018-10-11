/**
 * Created by Guoxianglian on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeConfirmCtrl = function($scope,$state) {

        //初始化界面
        var initFunc = function(){
            /*tab切换响应方法*/
            $scope.endorseTab = function(){
                $scope.curActive='endorse';
                $state.go('main.offLineChargeConfirm.confirmEndorse');
            };
            $scope.proposalTab=function(){
                $scope.curActive='proposal';
                $state.go('main.offLineChargeConfirm.confirmProposal');
            };
        };
        initFunc();

        $scope.curActive='proposal';
        $state.go("main.offLineChargeConfirm.confirmProposal");

    };

    moduleApp.controller('offLineChargeConfirmCtrl',['$scope','$state',offLineChargeConfirmCtrl]);
});
