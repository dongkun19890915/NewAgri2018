/**
 * Created by guoxianglian on 2016/9/23.
 */
define(['angular'],function (angular) {
    'use strict';
    /*单证模块*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/underwrite';
        var proposalPath = 'components/prpins/proposal';
        var reportPath = 'components/prpins/report';
        var endorsePath = 'components/prpins/endorse';
        $stateProvider
            .state("main.underwrite", {
                url:"/underwrite",
                templateUrl: "components/prpins/underwrite/tpl/underwrite.html",
                controller:'underwriteCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwrite.ctrl.js',
                            userPath+'/service/underwrite.serv.js']);
                    }]
                }
            })
            .state("main.underwriteSur", {
                url:"/underwriteSur?applyNo?policyNo",
                templateUrl: "components/prpins/underwrite/tpl/underwriteSur.html",
                controller:'underwriteSurCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwriteSur.ctrl.js',
                            userPath+'/service/underwriteSur.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js'
                        ]);
                    }]
                }
            })
            .state("main.underwriteInsured", {
                url:"/underwriteInsured?applyNo?policyNo",
                templateUrl: "components/prpins/underwrite/tpl/underwriteInsured.html",
                controller:'underwriteInsuredCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwriteInsured.ctrl.js',
                            userPath+'/service/underwriteSur.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            endorsePath+'/service/endorseInsured.serv.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js'
                        ]);
                    }]
                }
            })
            .state("main.underwriteBus", {
                url:"/underwriteBus?applyNo?policyNo",
                templateUrl: "components/prpins/underwrite/tpl/underwriteBus.html",
                controller:'underwriteBusCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwriteBus.ctrl.js',
                            userPath+'/service/underwriteSur.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js',
                            reportPath+'/controller/reportInsuredLayer.ctrl.js',
                            reportPath+'/controller/reportProposal.ctrl.js',
                            reportPath+'/service/reportProposal.serv.js'
                        ]);
                    }]
                }
            })
            .state("main.underwriteEndorse", {
                url:"/underwriteEndorse?applyNo?policyNo",
                templateUrl: "components/prpins/underwrite/tpl/underwriteConfirm.html",
                controller:'underwriteEndorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwriteEndorse.ctrl.js',
                            userPath+'/service/underwriteEndorse.serv.js']);
                    }]
                }
            })
            .state("main.underwriteSuc", {
                url:"/underwriteSuc?msg?applyNo?handleType?endorType",
                templateUrl: "components/prpins/underwrite/tpl/underwriteSuc.html",
                controller:'underwriteSucCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/underwriteSuc.ctrl.js',
                            userPath+'/service/underwriteSuc.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busUnderwrite = angular.module('business.prpins.underwrite', []);
    busUnderwrite.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busUnderwrite.controller = $controllerProvider.register;
            busUnderwrite.directive = $compileProvider.directive;
            busUnderwrite.filter = $filterProvider.register;
            busUnderwrite.factory = $provide.factory;
            busUnderwrite.service = $provide.service;
            busUnderwrite.constant = $provide.constant;
        }]);

    /*定义路由*/
    busUnderwrite.config(['$stateProvider',routerFn]);
    return busUnderwrite;
});
