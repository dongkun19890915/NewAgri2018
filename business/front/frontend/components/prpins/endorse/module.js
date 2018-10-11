/**
 * Created by ZhangJiansen on 2016/9/18.
 * 新增批改模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/endorse';
        var customerPath = 'components/prpins/customer';
        var proposalPath = 'components/prpins/proposal';
        var underwritePath = 'components/prpins/underwrite';
        var reportPath = 'components/prpins/report';
        $stateProvider
            .state("main.endorse", {
                url:"/endorse",
                templateUrl: "components/prpins/endorse/tpl/endorse.html",
                controller:'endorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorse.ctrl.js',
                            userPath+'/service/endorse.serv.js']);
                    }]
                }
            })
            .state("main.endorseInsured", {
                url:"/endorseInsured?policyNo?endorType?endorDate?validDate?oper?applyNo",
                templateUrl: "components/prpins/endorse/tpl/endorseInsured.html",
                controller:'endorseInsuredCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseInsured.ctrl.js',
                            userPath+'/service/endorseInsured.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            customerPath+'/service/cusLayer.serv.js',
                            customerPath+'/service/teamLayer.serv.js']);
                    }]
                }
            })
            .state("main.endorseBusiness", {
                url:"/endorseBusiness?policyNo?endorType?endorDate?validDate?oper?applyNo",
                templateUrl: "components/prpins/endorse/tpl/endorseBusiness.html",
                controller:'endorseBusinessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseBusiness.ctrl.js',
                            userPath+'/service/endorseBusiness.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js']);
                    }]
                }
            })
            .state("main.endorseSurrend", {
                url:"/endorseSurrend?policyNo?endorType?endorDate?validDate?oper?applyNo",
                templateUrl: "components/prpins/endorse/tpl/endorseSurrend.html",
                controller:'endorseSurrendCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseSurrend.ctrl.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            userPath+'/service/endorseSurrend.serv.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js']);
                    }]
                }
            })
            .state("main.endorseConfirm", {
                url:"/endorseConfirm?applyNo?pageDir?policyNo?oper",
                templateUrl: "components/prpins/endorse/tpl/endorseConfirm.html",
                controller:'endorseConfirmCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseConfirm.ctrl.js',
                            userPath+'/service/endorseConfirm.serv.js',
                            underwritePath+'/service/underwriteEndorse.serv.js']);
                    }]
                }
            })
            .state("main.endorseDeleteSuccess", {
                url:"/endorseDeleteSuccess?applyNo",
                templateUrl: "components/prpins/endorse/tpl/endorseDeleteSuccess.html",
                controller:'endorseDeleteSuccessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseDeleteSuccess.ctrl.js']);
                    }]
                }
            })
            .state("main.endorseDeleteFail", {
                url:"/endorseDeleteFail?applyNo",
                templateUrl: "components/prpins/endorse/tpl/endorseDeleteFail.html",
                controller:'endorseDeleteFailCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorseDeleteFail.ctrl.js']);
                    }]
                }
            })
            .state("main.endorsePublicSuccess", {
                url:"/endorsePublicSuccess?msg?applyNo?endorType",
                templateUrl: "components/prpins/endorse/tpl/endorsePublicSuccess.html",
                controller:'endorsePublicSuccessCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/endorsePublicSuccess.ctrl.js',
                            userPath+'/service/endorseSuccess.serv.js']);
                    }]
                }
            });
    };
    /*模块定义*/
    var prpinsEndorse = angular.module('business.prpins.endorse', []);

    prpinsEndorse.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            prpinsEndorse.controller = $controllerProvider.register;
            prpinsEndorse.directive = $compileProvider.directive;
            prpinsEndorse.filter = $filterProvider.register;
            prpinsEndorse.factory = $provide.factory;
            prpinsEndorse.service = $provide.service;
            prpinsEndorse.constant = $provide.constant;
        }]);

    /*定义路由*/
    prpinsEndorse.config(['$stateProvider',routerFn]);
    return prpinsEndorse;

});

