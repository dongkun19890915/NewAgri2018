/**
 * Created by GuoXiangLian on 2016/9/19.
 * 区域销售限额维护模块
 */
define([ 'angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var areaquotaPath = 'components/pms/areaquota';
        $stateProvider
            .state("main.areaquota", {
                url:"/areaquota",
                templateUrl:areaquotaPath+ "/tpl/areaquota.html",
                controller:'areaquotaCtrl',
                resolve:{
                    loadAreaquota:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            areaquotaPath+'/controller/areaquota.ctrl.js',
                            areaquotaPath+'/service/areaquota.serv.js']);
                    }]
                }
            })
            .state("main.areaquotaMaintain", {
                url:"/areaquotaMaintain",
                templateUrl:areaquotaPath+ "/tpl/areaquotaMaintain.html",
                controller:'areaquotaMaintainCtrl',
                resolve:{
                    loadAreaquotaMaintain:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            areaquotaPath+'/controller/areaquotaMaintain.ctrl.js',
                            areaquotaPath+ '/service/areaquotaMaintain.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var businessPmsAreaquota = angular.module('business.pms.areaquota', []);
    businessPmsAreaquota.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessPmsAreaquota.controller = $controllerProvider.register;
            businessPmsAreaquota.directive = $compileProvider.directive;
            businessPmsAreaquota.filter = $filterProvider.register;
            businessPmsAreaquota.factory = $provide.factory;
            businessPmsAreaquota.service = $provide.service;
            businessPmsAreaquota.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessPmsAreaquota.config(['$stateProvider',routerFn]);
    return businessPmsAreaquota;
});
