/**
 * Created by GuoXiangLian on 2016/9/19.
 * 共同体资料维护维护模块
 */
define(['angular'
],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var communityPath = 'components/ims/community';
        $stateProvider
            .state("main.community", {
                url:"/community",
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            communityPath+'/controller/community.ctrl.js',
                            communityPath+'/service/community.serv.js']);
                    }]
                },
                templateUrl: "components/ims/community/tpl/community.html",
                controller:"communityCtrl"
            })
            .state("main.communityInform", {
                url:"/communityInform?continueData",
                resolve:{
                    loadCommunityInform:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            communityPath+'/controller/communityInform.ctrl.js',
                            communityPath+'/service/communityInform.serv.js']);
                    }]
                },
                templateUrl: "components/ims/community/tpl/communityInform.html",
                controller:"communityInformCtrl"
            });
    };

    /*模块定义*/
    var businessImsCommunity = angular.module('business.ims.community', []);

    businessImsCommunity.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessImsCommunity.controller = $controllerProvider.register;
            businessImsCommunity.directive = $compileProvider.directive;
            businessImsCommunity.filter = $filterProvider.register;
            businessImsCommunity.factory = $provide.factory;
            businessImsCommunity.service = $provide.service;
            businessImsCommunity.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessImsCommunity.config(['$stateProvider',routerFn]);

    return businessImsCommunity;
});