/**
 * Created by guoxianglian on 2016/9/18.
 * 下载清分文件模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*收费模块*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/clearFile/settleReport';
        $stateProvider
            .state("main.settleReport", {
                url:"/settleReport",
                templateUrl: "components/clearFile/settleReport/tpl/settleReport.html",
                controller:'settleReportCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/settleReport.ctrl.js',
                            userPath+'/service/settleReport.serv.js']);
                    }]
                }
            });
    };


    /*模块定义*/
    var busSettle = angular.module('business.clearFile.settleReport', []);
    busSettle.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busSettle.controller = $controllerProvider.register;
            busSettle.directive = $compileProvider.directive;
            busSettle.filter = $filterProvider.register;
            busSettle.factory = $provide.factory;
            busSettle.service = $provide.service;
            busSettle.constant = $provide.constant;
        }]);

    /*定义路由*/
    busSettle.config(['$stateProvider',routerFn]);
    return busSettle;

});

