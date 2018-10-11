/**
 * Created by ZhangJiansen on 2017/3/8.
 * Controller层只处理视图数据绑定，后端交互在service处理
 */
define(['../../module'], function (moduleApp) {
    'use strict';
    var baseInfoCtrl = function($q,$rootScope,$scope,$modal,$http,$state,FormFocus)
    {
        var vm = $scope.$parent.vm;
        vm.policy.prpTmain.proposalNo = "123";
    };
    moduleApp.controller('baseInfoCtrl',['$q','$rootScope','$scope','$modal','$http','$state','FormFocus',baseInfoCtrl]);
});