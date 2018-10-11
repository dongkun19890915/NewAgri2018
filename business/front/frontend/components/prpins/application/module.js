/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    var basePath = 'components/prpins/application';

    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        $stateProvider
            .state("main.insure", {
                url:"/insure",
                templateUrl: basePath+"/tpl/insure.html",
                controller:'insureCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            basePath+'/controller/insure.ctrl.js'
                        ]);
                    }]
                }
            })
            .state("main.insure.add", {
                url:"/add?riskCode&disStyle",
                templateUrl: basePath+"/tpl/addProposal.html",
                controller:'addProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            basePath+'/controller/addProposal.ctrl.js',
                            basePath+'/controller/subCtrl/baseInfo.ctrl.js',
                            basePath+'/service/productConfig.serv.js'
                        ]);
                    }]
                }
            })
        ;
    };

    /*模块定义*/
    var mod = angular.module('business.prpins.insure', []);

    mod.basePath = basePath;

    mod.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            mod.controller = $controllerProvider.register;
            mod.directive = $compileProvider.directive;
            mod.filter = $filterProvider.register;
            mod.factory = $provide.factory;
            mod.service = $provide.service;
            mod.constant = $provide.constant;
        }]);

    /*定义路由*/
    mod.config(['$stateProvider',routerFn]);
    return mod;



});

