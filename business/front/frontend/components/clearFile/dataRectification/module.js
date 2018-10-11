/**
 * 清分异常处理
 */
define(['angular'],function (angular) {
    'use strict';
    /*清分异常处理*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/clearFile/dataRectification';
        $stateProvider
            .state("main.dataRectification", {
                url:"/dataRectification",
                templateUrl: userPath+"/tpl/dataRectification.html",
                controller:'dataRectificationCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/dataRectification.ctrl.js',
                            userPath+'/service/dataRectification.serv.js']);
                    }]
                }
            })
    };

    /*模块定义*/
    var busDataRect = angular.module('business.clearFile.dataRectification', []);
    busDataRect.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busDataRect.controller = $controllerProvider.register;
            busDataRect.directive = $compileProvider.directive;
            busDataRect.filter = $filterProvider.register;
            busDataRect.factory = $provide.factory;
            busDataRect.service = $provide.service;
            busDataRect.constant = $provide.constant;
        }]);

    /*定义路由*/
    busDataRect.config(['$stateProvider',routerFn]);
    return busDataRect;
});
