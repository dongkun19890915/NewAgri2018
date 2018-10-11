/**
 * Created by ZhangJiansen on 2016/9/18.
 * 保单综合查询模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*保单综合查询*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/report';
        var proposalPath = 'components/prpins/proposal';
        $stateProvider
            .state("main.report", {
                url:"/report",
                templateUrl: "components/prpins/report/tpl/report.html",
                controller:'reportCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/report.ctrl.js',
                            userPath+'/service/report.serv.js']);
                    }]
                }
            })
            .state("main.reportTab", {
                url:"/reportTab?policyNo?bussType",
                templateUrl: "components/prpins/report/tpl/reportTab.html",
                controller:'reportTabCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/reportTab.ctrl.js']);
                    }]
                }
            })
            .state("main.reportTab.proposal", {
                url:"/reportProposal?policyDetailParam",
                templateUrl: "components/prpins/report/tpl/reportProposal.html",
                controller:'reportProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/reportProposal.ctrl.js',
                            userPath+'/controller/reportInsuredLayer.ctrl.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            userPath+'/service/reportProposal.serv.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js']);
                    }]
                }
            })
            .state("main.reportTab.endorse", {
                url:"/reportEndorse",
                templateUrl: "components/prpins/report/tpl/reportEndorse.html",
                controller:'reportEndorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/reportEndorse.ctrl.js',
                            userPath+'/controller/reportProposal.ctrl.js',
                            userPath+'/controller/reportInsuredLayer.ctrl.js',
                            userPath+'/service/reportEndorse.serv.js',
                            userPath+'/service/reportProposal.serv.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js']);
                    }]
                }
            })
            .state("main.proposal", {
                url:"/reportProposal?policyDetailParam?policyNo?bussType",
                templateUrl: "components/prpins/report/tpl/reportProposal.html",
                controller:'reportProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/reportProposal.ctrl.js',
                            userPath+'/controller/reportInsuredLayer.ctrl.js',
                            proposalPath+'/controller/applicationFileUploadLayer.ctrl.js',
                            userPath+'/service/reportProposal.serv.js',
                            proposalPath+'/service/applicationFileUploadLayer.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busReport = angular.module('business.prpins.report', []);
    busReport.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busReport.controller = $controllerProvider.register;
            busReport.directive = $compileProvider.directive;
            busReport.filter = $filterProvider.register;
            busReport.factory = $provide.factory;
            busReport.service = $provide.service;
            busReport.constant = $provide.constant;
        }]);

    /*定义路由*/
    busReport.config(['$stateProvider',routerFn]);
    return busReport;
});

