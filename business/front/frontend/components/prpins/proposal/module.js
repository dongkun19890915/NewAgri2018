/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/proposal';
        var customerPath = 'components/prpins/customer';
        var indexPath = 'components/index';
        var chargePath = 'components/payment/charge';
        $stateProvider
            .state("main.choiceProposal", {
                url:"/choiceProposal",
                templateUrl: "components/prpins/proposal/tpl/choiceProposal.html",
                controller:'choiceProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/choiceProposal.ctrl.js',
                            userPath+'/service/choiceProposal.serv.js',
                            indexPath+'/service/index.serv.js'
                        ]);
                    }]
                }
            })
            .state("main.application", {
                url:"/application?riskCode&continueData&editType&copyObjectId",
                templateUrl: "components/prpins/proposal/tpl/proposal.html",
                controller:'proposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/proposal.ctrl.js',
                            userPath+'/controller/insured.ctrl.js',
                            userPath+'/controller/insured.ctrl.js',
                            userPath+'/controller/importInsured.ctrl.js',
                            userPath+'/service/proposal.serv.js',
                            userPath+'/service/insured.serv.js',
                            userPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            userPath+'/service/applicationFileUploadLayer.serv.js',
                            customerPath+'/service/cusLayer.serv.js',
                            customerPath+'/service/teamLayer.serv.js',
                            userPath+'/controller/pdfLayer.ctrl.js',
                            userPath+'/service/proposal.serv.js']);
                    }]
                }
            })
            .state("main.applicationSuc", {
                url:"/applicationSuc?policyNo",
                templateUrl: "components/prpins/proposal/tpl/applicationSuc.html",
                controller:'applicationSucCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/applicationSuc.ctrl.js',
                            chargePath+'/service/chargeSuccess.serv.js']);
                    }]
                }
            })
            .state("main.applicationDeleteSuccess", {
                url:"/applicationDeleteSuccess?proposalNo",
                templateUrl: "components/prpins/proposal/tpl/applicationDeleteSuccess.html",
                controller:'applicationDeleteSuccCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/applicationDeleteSucc.ctrl.js']);
                    }]
                }
            })
            .state("main.applicationDeleteFail", {
                url:"/applicationDeleteFail?proposalNo",
                templateUrl: "components/prpins/proposal/tpl/applicationDeleteFail.html",
                controller:'applicationDelFailCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/applicationDelFail.ctrl.js']);
                    }]
                }
            })
            .state("pdf", {
                url:"/pdf?fileId",
                templateUrl: 'components/prpins/proposal/tpl/pdfLayer.html',
                controller:'pdfLayerCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/pdfLayer.ctrl.js']);
                    }]
                }
            })
            .state("main.syncValidMsg", {
                url:"/syncValidMsg?proposalNo&applyName&sumPremium",
                templateUrl: "components/prpins/proposal/tpl/syncValidMsg.html",
                controller:'syncValidMsgCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/syncValidMsg.ctrl.js']);
                    }]
                }
            })
        ;
    };

    /*模块定义*/
    var prpinsProposal = angular.module('business.prpins.proposal', []);

    prpinsProposal.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            prpinsProposal.controller = $controllerProvider.register;
            prpinsProposal.directive = $compileProvider.directive;
            prpinsProposal.filter = $filterProvider.register;
            prpinsProposal.factory = $provide.factory;
            prpinsProposal.service = $provide.service;
            prpinsProposal.constant = $provide.constant;
        }]);

    /*定义路由*/
    prpinsProposal.config(['$stateProvider',routerFn]);
    return prpinsProposal;



});

