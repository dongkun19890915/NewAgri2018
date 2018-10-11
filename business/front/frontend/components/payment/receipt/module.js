/**
 * Created by Guoxianglian  on 2016/9/19.
 *索要发票模块
 */
define(['angular'],function (angular) {
    'use strict';
    /*索要发票模块*/
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/payment/receipt';
        var endorsePath = 'components/prpins/endorse';
        $stateProvider
            .state("main.receipt", {
                url:"/receipt",
                templateUrl: "components/payment/receipt/tpl/receipt.html",
                controller:'receiptCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/receipt.ctrl.js',
                            userPath+'/service/receipt.serv.js']);
                    }]
                }
            })
            .state("main.receiptSuccess", {
                url:"/receiptSuccess",
                templateUrl: "components/payment/receipt/tpl/receiptSuccess.html",
                controller:'endorseDeleteSuccessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            endorsePath+'/controller/endorseDeleteSuccess.ctrl.js']);
                    }]
                }
            });
    };
    /*模块定义*/
    var paymentReceipt = angular.module('business.payment.receipt', []);
    paymentReceipt.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            paymentReceipt.controller = $controllerProvider.register;
            paymentReceipt.directive = $compileProvider.directive;
            paymentReceipt.filter = $filterProvider.register;
            paymentReceipt.factory = $provide.factory;
            paymentReceipt.service = $provide.service;
            paymentReceipt.constant = $provide.constant;
        }]);

    /*定义路由*/
    paymentReceipt.config(['$stateProvider',routerFn]);
    return paymentReceipt;
});