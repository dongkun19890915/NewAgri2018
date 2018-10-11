/**
 * Created by ZhangJiansen on 2016/9/19.
 * 共同体成员比例维护模块
 */
define([ 'angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var communityMemberPath = 'components/pms/communityMember';
        $stateProvider
            .state("main.communityMember", {
                url:"/communityMember",
                templateUrl:communityMemberPath+ "/tpl/communityMember.html",
                controller:'communityMemberCtrl',
                resolve:{
                    loadcommunityMember:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            communityMemberPath+'/controller/communityMember.ctrl.js',
                            communityMemberPath+'/service/communityMember.serv.js']);
                    }]
                }
            })
            .state("main.communityMemberMaintain", {
                url:"/communityMemberMaintain",
                templateUrl:communityMemberPath+ "/tpl/communityMemberMaintain.html",
                controller:'communityMemberMaintainCtrl',
                resolve:{
                    loadcommunityMemberMaintain:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            communityMemberPath+'/controller/communityMemberMaintain.ctrl.js',
                            communityMemberPath+ '/service/communityMemberMaintain.serv.js']);
                    }]
                }
            });
    };
    /*模块定义*/
    var businessPmsCommunityMember = angular.module('business.pms.communityMember', []);
    businessPmsCommunityMember.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessPmsCommunityMember.controller = $controllerProvider.register;
            businessPmsCommunityMember.directive = $compileProvider.directive;
            businessPmsCommunityMember.filter = $filterProvider.register;
            businessPmsCommunityMember.factory = $provide.factory;
            businessPmsCommunityMember.service = $provide.service;
            businessPmsCommunityMember.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessPmsCommunityMember.config(['$stateProvider',routerFn]);
    return businessPmsCommunityMember;
});