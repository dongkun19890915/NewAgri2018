/**
 * Created by ZhangJiansen on 2016/9/18.
 * 线下收费待确认模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    var routerFn = function($stateProvider){
        var userPath = 'components/payment/chargeConfirm';
        var reportPath = 'components/prpins/report';
        var proposalPath = 'components/prpins/proposal';
        $stateProvider
            //勿删
            /*.state("main.offLineChargeConfirm", {
             url:"/offLineChargeConfirm",
             templateUrl: "components/chargeConfirm/tpl/offLineChargeConfirm.html"

             })*/
            .state("main.offLineChargeConfirm", {
                url:"/offLineChargeConfirmProposal",
                templateUrl: userPath+"/tpl/offLineChargeConfirmProposal.html",
                controller:'offLineChargeConfirmProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/offLineChargeConfirmProposal.ctrl.js',
                            userPath+'/service/offLineChargeConfirmProposal.serv.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js']);
                    }]
                }
            })
            .state("main.offLineChargeConfirm.confirmEndorse", {
                url:"/offLineChargeConfirmEndorse",
                templateUrl: userPath+"/tpl/offLineChargeConfirmEndorse.html",
                controller:'offLineChargeConfirmEndorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/offLineChargeConfirmEndorse.ctrl.js',
                            userPath+'/service/offLineChargeConfirmEndorse.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var paymentConfirm = angular.module('business.payment.chargeConfirm', []);
    paymentConfirm.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            paymentConfirm.controller = $controllerProvider.register;
            paymentConfirm.directive = $compileProvider.directive;
            paymentConfirm.filter = $filterProvider.register;
            paymentConfirm.factory = $provide.factory;
            paymentConfirm.service = $provide.service;
            paymentConfirm.constant = $provide.constant;
        }]);

    /*定义路由*/
    paymentConfirm.config(['$stateProvider',routerFn]);
    return paymentConfirm;
});

