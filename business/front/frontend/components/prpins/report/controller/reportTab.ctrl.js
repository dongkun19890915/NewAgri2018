/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportTabCtrl = function($scope,$state) {
        $scope.showExit=true;
        $scope.proposalTab = function(){
            $scope.curActive='appli';
            $state.go('main.reportTab.proposal');
        };
        $scope.endorseTab=function(){
            $scope.curActive='endor';
            $state.go('main.reportTab.endorse');
        };

        $scope.curActive='appli';
        $state.go('main.reportTab.proposal');

        $scope.reBack=function(){
            $state.go('main.report');
        }
    };
    moduleApp.controller('reportTabCtrl',['$scope','$state',reportTabCtrl]);
});
