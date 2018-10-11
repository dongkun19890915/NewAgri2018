/**
 * Created by ZhangJiansen on 2016/9/18.
 * 文件资料维护模块定义
 */
define(['angular'],function (angular) {
    'use strict';

    /*路由定义实现方法-文件资料维护*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/material';
        $stateProvider
            .state("main.material", {
                url:"/material",
                templateUrl: userPath+"/tpl/material.html",
                controller:'materialCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/material.ctrl.js',
                            userPath+'/controller/meterLayer.ctrl.js',
                            userPath+'/service/material.serv.js']);
                    }]
                }
            })
            .state("main.materialSearch", {
                url:"/materialSearch",
                templateUrl: userPath+"/tpl/materialSearch.html",
                controller:'materialSearchCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/materialSearch.ctrl.js',
                            userPath+'/service/material.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var material = angular.module('business.material', []);
    material.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            material.controller = $controllerProvider.register;
            material.directive = $compileProvider.directive;
            material.filter = $filterProvider.register;
            material.factory = $provide.factory;
            material.service = $provide.service;
            material.constant = $provide.constant;
        }]);

    /*定义路由*/
    material.config(['$stateProvider',routerFn]);
    return material;
});

