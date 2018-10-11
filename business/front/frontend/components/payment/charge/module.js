/**
 * Created by ZhangJiansen on 2016/9/18.
 * 支付模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/payment/charge';
        var proposalPath = 'components/prpins/proposal';
        $stateProvider
            .state("main.offLineCharge", {
                url:"/offLineCharge?proposalNo",
                templateUrl: "components/payment/charge/tpl/offLineCharge.html",
                controller:'offLineChargeCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/offLineCharge.ctrl.js',
                            userPath+'/service/offLineCharge.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js']);
                    }]
                }
            })
            .state("main.offLineChargeSuccess", {
                url:"/offLineChargeSuccess?policyNo",
                templateUrl: "components/payment/charge/tpl/offLineChargeSuccess.html",
                controller:'offLineChargeSuccessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/chargeSuccess.ctrl.js',
                            userPath+'/service/chargeSuccess.serv.js']);
                    }]
                }
            })
            .state("main.onLineChargeSuccess", {
                url:"/onLineChargeSuccess?policyNo",
                templateUrl: "components/payment/charge/tpl/onLineChargeSuccess.html",
                controller:'offLineChargeSuccessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/chargeSuccess.ctrl.js',
                            userPath+'/service/chargeSuccess.serv.js']);
                    }]
                }
            })
            .state("main.onLineCharge", {
                url:"/onLineCharge?proposalNo",
                templateUrl: "components/payment/charge/tpl/onLineCharge.html",
                controller:'onLineChargeCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/onLineCharge.ctrl.js',
                            userPath+'/service/onLineCharge.serv.js',
                            userPath+'/controller/onLineChargeLayer.ctrl.js',
                            userPath+'/service/onLineChargeLayer.serv.js',
                            proposalPath+'/controller/pdfLayer.ctrl.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var paymentCharge = angular.module('business.payment.charge', []);
    paymentCharge.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            paymentCharge.controller = $controllerProvider.register;
            paymentCharge.directive = $compileProvider.directive;
            paymentCharge.filter = $filterProvider.register;
            paymentCharge.factory = $provide.factory;
            paymentCharge.service = $provide.service;
            paymentCharge.constant = $provide.constant;
        }]);

    /*定义路由*/
    paymentCharge.config(['$stateProvider',routerFn]);
    return paymentCharge;
});

