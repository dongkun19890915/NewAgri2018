/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*路由定义实现方法-收费模块*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/payment/chargeFail';
        $stateProvider
            .state("main.chargeFail", {
                url:"/chargeFail",
                templateUrl: "components/payment/chargeFail/tpl/chargeFail.html",
                controller:'chargeFailCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/chargeFail.ctrl.js']);
                    }]
                }
            });
    };
    /*模块定义*/
    var paymentChargeFail = angular.module('business.payment.chargeFail', []);
    paymentChargeFail.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            paymentChargeFail.controller = $controllerProvider.register;
            paymentChargeFail.directive = $compileProvider.directive;
            paymentChargeFail.filter = $filterProvider.register;
            paymentChargeFail.factory = $provide.factory;
            paymentChargeFail.service = $provide.service;
            paymentChargeFail.constant = $provide.constant;
        }]);

    /*定义路由*/
    paymentChargeFail.config(['$stateProvider',routerFn]);
    return paymentChargeFail;
});

