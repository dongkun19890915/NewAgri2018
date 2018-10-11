/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保模块定义
 */
define(['angular'],function (angular) {
    'use strict';
    /*待处理投保、批改*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/suspendProposal';
        var proposalPath = 'components/prpins/proposal';
        $stateProvider
            .state("main.suspendProposal",{
                url:"/suspendProposal",
                templateUrl: "components/prpins/suspendProposal/tpl/suspendProposal.html",
                controller:'suspendProposalCtrl',
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            userPath+'/controller/suspendProposal.ctrl.js',
                            userPath+'/service/suspendProposal.serv.js']);
                    }]
                }
            });

    };
    /*模块定义*/
    var busProposal = angular.module('business.prpins.suspendProposal', []);
    busProposal.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            busProposal.controller = $controllerProvider.register;
            busProposal.directive = $compileProvider.directive;
            busProposal.filter = $filterProvider.register;
            busProposal.factory = $provide.factory;
            busProposal.service = $provide.service;
            busProposal.constant = $provide.constant;
        }]);

    /*定义路由*/
    busProposal.config(['$stateProvider',routerFn]);
    return busProposal;
});

