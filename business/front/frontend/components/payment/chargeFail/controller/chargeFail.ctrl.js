/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var chargeFailCtrl = function($scope) {
        $scope.chargeError=true;
        $scope.chargeFailSubmit=function(){
            $scope.chargeError=false;
        };
        $scope.chargeFailDetail=function(){
             $scope.chargeError=false;
        };
        $scope.layerClose=function(){
            $scope.chargeError=true;
        };
        $scope.chargeFailReset=function(){
            $scope.Dto="";
        }
    };
    moduleApp.controller('chargeFailCtrl',['$scope',chargeFailCtrl]);
});