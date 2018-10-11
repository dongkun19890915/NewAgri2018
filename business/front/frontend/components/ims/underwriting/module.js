/**
 * Created by guoxianglian on 2016/9/23.
 * 核保权限模块
 */
define([ 'angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var underwritingPath = 'components/ims/underwriting';
        $stateProvider
            .state("main.underwriting",{
                url:"/underwriting",
                templateUrl:underwritingPath + "/tpl/underwriting.html",
                controller:"underwritingCtrl",
                resolve:{
                    loadUnderwriting:['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            underwritingPath + '/controller/underwriting.ctrl.js',
                            underwritingPath + '/service/underwriting.serv.js'
                        ]);
                    }]
                }
            });
    };

    /*模块定义*/
    var businessImsUnderwriting = angular.module('business.ims.underwriting', []);

    businessImsUnderwriting.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessImsUnderwriting.controller = $controllerProvider.register;
            businessImsUnderwriting.directive = $compileProvider.directive;
            businessImsUnderwriting.filter = $filterProvider.register;
            businessImsUnderwriting.factory = $provide.factory;
            businessImsUnderwriting.service = $provide.service;
            businessImsUnderwriting.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessImsUnderwriting.config(['$stateProvider',routerFn]);

    return businessImsUnderwriting;
});
