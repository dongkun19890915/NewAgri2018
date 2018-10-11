/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*待处理投保、批改*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/suspendEndorse';
        $stateProvider
            .state("main.suspendEndorse",{
                url:"/suspendEndorse",
                templateUrl: "components/prpins/suspendEndorse/tpl/suspendEndorse.html",
                controller:'suspendEndorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/suspendEndorse.ctrl.js',
                            userPath+'/service/suspendEndorse.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busEndorse = angular.module('business.prpins.suspendEndorse', []);
    busEndorse.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busEndorse.controller = $controllerProvider.register;
            busEndorse.directive = $compileProvider.directive;
            busEndorse.filter = $filterProvider.register;
            busEndorse.factory = $provide.factory;
            busEndorse.service = $provide.service;
            busEndorse.constant = $provide.constant;
        }]);

    /*定义路由*/
    busEndorse.config(['$stateProvider',routerFn]);
    return busEndorse;
});

