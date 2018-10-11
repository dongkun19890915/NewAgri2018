/**
 * Created by guoxianglian on 2016/9/23.
 */
define([ 'angular'],function (angular) {
    'use strict';
    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var userPath = 'components/prpins/customer';
    };

    /*模块定义*/
    var prpinsCustomer = angular.module('business.prpins.customer', []);

    prpinsCustomer.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            prpinsCustomer.controller = $controllerProvider.register;
            prpinsCustomer.directive = $compileProvider.directive;
            prpinsCustomer.filter = $filterProvider.register;
            prpinsCustomer.factory = $provide.factory;
            prpinsCustomer.service = $provide.service;
            prpinsCustomer.constant = $provide.constant;
        }]);

    /*定义路由*/
    prpinsCustomer.config(['$stateProvider',routerFn]);
    return prpinsCustomer;
});
