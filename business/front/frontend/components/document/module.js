/**
 * Created by ZhangJiansen on 2016/9/19.
 * 单证模块
 */
define(['angular'],function (angular) {
    'use strict';
    /*单证模块*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/document';
        $stateProvider
            .state("main.document", {
                url:"/document",
                templateUrl: "components/document/tpl/document.html",
                controller:'documentCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/document.ctrl.js',
                            userPath+'/service/document.serv.js',
                            userPath+'/controller/documentProposal.ctrl.js',
                            userPath+'/service/documentProposal.serv.js',
                            userPath+'/controller/documentEndorse.ctrl.js',
                            userPath+'/service/documentEndorse.serv.js']);
                    }]
                }
            })
            /*.state("main.document.endorse", {
                url:"/documentEndorse",
                templateUrl: "components/document/tpl/documentEndorse.html",
                controller:'documentEndorseCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/documentEndorse.ctrl.js',
                            userPath+'/service/documentEndorse.serv.js']);
                    }]
                }
            })
            .state("main.document.proposal", {
                url:"/documentProposal",
                templateUrl: "components/document/tpl/documentProposal.html",
                controller:'documentProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/documentProposal.ctrl.js',
                            userPath+'/service/documentProposal.serv.js']);
                    }]
                }
            })*/
            .state("main.documentSuc", {
                url:"/documentSuccess",
                templateUrl: "components/document/tpl/documentSuc.html",
                controller:'documentDelSucCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/documentDelSuc.ctrl.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var busDocument = angular.module('business.document', []);
    busDocument.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busDocument.controller = $controllerProvider.register;
            busDocument.directive = $compileProvider.directive;
            busDocument.filter = $filterProvider.register;
            busDocument.factory = $provide.factory;
            busDocument.service = $provide.service;
            busDocument.constant = $provide.constant;
        }]);

    /*定义路由*/
    busDocument.config(['$stateProvider',routerFn]);
    return busDocument;
});