/**
 * Created by guoxianglian on 2016/9/23.
 */
define([ 'angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/ims/user';
        $stateProvider
            .state("main.user",{
                url:"/user",
                templateUrl: "components/ims/user/tpl/userQuery.html",
                controller:'userQueryCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/userQuery.ctrl.js',
                            userPath+'/controller/userImport.ctrl.js',
                            userPath+'/service/userQuery.serv.js']);
                    }]
                }
            })
            .state("main.usermaintain",{
                url:"/usermaintain?continueData",
                templateUrl: "components/ims/user/tpl/usermaintain.html",
                controller:'usermaintainCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/usermaintain.ctrl.js',
                            userPath+'/service/usermaintain.serv.js']);
                    }]
                }
            })
            .state("main.modifyPassword",{
                url:"/modifyPassword?continueData",
                templateUrl: "components/ims/user/tpl/modifyPassword.html",
                controller:'modifyPasswordCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/modifyPassword.ctrl.js',
                            userPath+'/service/modifyPassword.serv.js']);
                    }]
                }
            })
            /*.state("main.password",{})*/;

    };

    /*模块定义*/
    var businessImsUser = angular.module('business.ims.user', []);

    businessImsUser.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessImsUser.controller = $controllerProvider.register;
            businessImsUser.directive = $compileProvider.directive;
            businessImsUser.filter = $filterProvider.register;
            businessImsUser.factory = $provide.factory;
            businessImsUser.service = $provide.service;
            businessImsUser.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessImsUser.config(['$stateProvider',routerFn]);
    return businessImsUser;
});
