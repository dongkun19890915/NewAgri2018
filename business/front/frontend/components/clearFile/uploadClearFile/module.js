/**
 * 下载清分文件
 */
define(['angular'],function (angular) {
    'use strict';
    /*清分文件下载上传*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/clearFile/uploadClearFile';
        $stateProvider
            .state("main.uploadClearFile", {
                url:"/uploadClearFile",
                templateUrl: "components/clearFile/uploadClearFile/tpl/uploadClearFile.html",
                controller:'uploadClearFileCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/uploadClearFile.ctrl.js',
                            userPath+'/service/uploadClearFile.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busUpload = angular.module('business.clearFile.uploadClearFile', []);
    busUpload.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busUpload.controller = $controllerProvider.register;
            busUpload.directive = $compileProvider.directive;
            busUpload.filter = $filterProvider.register;
            busUpload.factory = $provide.factory;
            busUpload.service = $provide.service;
            busUpload.constant = $provide.constant;
        }]);

    /*定义路由*/
    busUpload.config(['$stateProvider',routerFn]);
    return busUpload;
});
