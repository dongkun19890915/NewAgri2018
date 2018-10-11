/**
 * Created by guoxianglian on 2016/9/23.
 * 下载清分文件
 */
define(['angular'],function (angular) {
    'use strict';
    /*清分文件下载*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/clearFile/downloadClearFile';
        $stateProvider
            .state("main.downloadClearFile", {
                url:"/downloadClearFile",
                templateUrl: "components/clearFile/downloadClearFile/tpl/downloadClearFile.html",
                controller:'downloadClearFileCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/downloadClearFile.ctrl.js',
                            userPath+'/service/downloadClearFile.serv.js']);
                    }]
                }
            })
    };

    /*模块定义*/
    var busDownload = angular.module('business.clearFile.downloadClearFile', []);
    busDownload.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busDownload.controller = $controllerProvider.register;
            busDownload.directive = $compileProvider.directive;
            busDownload.filter = $filterProvider.register;
            busDownload.factory = $provide.factory;
            busDownload.service = $provide.service;
            busDownload.constant = $provide.constant;
        }]);

    /*定义路由*/
    busDownload.config(['$stateProvider',routerFn]);
    return busDownload;
});
