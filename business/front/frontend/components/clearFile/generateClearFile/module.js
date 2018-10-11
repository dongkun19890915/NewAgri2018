/**
 * 
 * 清分文件生成
 */
define(['angular'],function (angular) {
    'use strict';
    /*清分文件生成*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/clearFile/generateClearFile';
        $stateProvider
            .state("main.generateClearFile", {
                url:"/generateClearFile",
                templateUrl: "components/clearFile/generateClearFile/tpl/generateClearFile.html",
                controller:'generateClearFileCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/generateClearFile.ctrl.js',
                            userPath+'/service/generateClearFile.serv.js']);
                    }]
                }
            })
    };

    /*模块定义*/
    var busGenerate = angular.module('business.clearFile.generateClearFile', []);
    busGenerate.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busGenerate.controller = $controllerProvider.register;
            busGenerate.directive = $compileProvider.directive;
            busGenerate.filter = $filterProvider.register;
            busGenerate.factory = $provide.factory;
            busGenerate.service = $provide.service;
            busGenerate.constant = $provide.constant;
        }]);

    /*定义路由*/
    busGenerate.config(['$stateProvider',routerFn]);
    return busGenerate;
});
