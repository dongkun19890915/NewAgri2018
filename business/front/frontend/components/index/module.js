/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*首页-统计图表*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/index';
        $stateProvider
            .state("main.index", {
                url:"/index",
                templateUrl: "components/index/tpl/index.html",
                controller:'indexCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/index.ctrl.js',
                            userPath+'/service/index.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busIndex = angular.module('business.index', []);  //TODO: rename to dashboard
    busIndex.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busIndex.controller = $controllerProvider.register;
            busIndex.directive = $compileProvider.directive;
            busIndex.filter = $filterProvider.register;
            busIndex.factory = $provide.factory;
            busIndex.service = $provide.service;
            busIndex.constant = $provide.constant;
        }]);

    /*定义路由*/
    busIndex.config(['$stateProvider',routerFn]);
    return busIndex;
});

