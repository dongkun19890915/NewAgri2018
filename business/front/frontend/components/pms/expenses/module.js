/**
 * Created by ZhangJiansen on 2016/9/19.
 * 销售费用率维护模块定义
 */
define([ 'angular'],function (angular) {
    'use strict';

    /*路由定义实现方法*/
    var routerFn = function ($stateProvider) {
        var expensesPath = 'components/pms/expenses';
        $stateProvider
            .state("main.expenses", {
                url:"/expenses",
                templateUrl:expensesPath+ "/tpl/expenses.html",
                controller:'expensesCtrl',
                resolve:{
                    loadExpenses:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            expensesPath+'/controller/expenses.ctrl.js',
                            expensesPath+'/service/expenses.serv.js']);
                    }]
                }
            })
            .state("main.expensesMaintain", {
                url:"/expensesMaintain",
                templateUrl:expensesPath+ "/tpl/expensesMaintain.html",
                controller:'expensesMaintainCtrl',
                resolve:{
                    loadExpensesMaintain:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            expensesPath+'/controller/expensesMaintain.ctrl.js',
                            expensesPath+ '/service/expensesMaintain.serv.js']);
                    }]
                }
            });
    };

    /*模块定义*/
    var businessPmsExpenses = angular.module('business.pms.expenses', []);
    businessPmsExpenses.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessPmsExpenses.controller = $controllerProvider.register;
            businessPmsExpenses.directive = $compileProvider.directive;
            businessPmsExpenses.filter = $filterProvider.register;
            businessPmsExpenses.factory = $provide.factory;
            businessPmsExpenses.service = $provide.service;
            businessPmsExpenses.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessPmsExpenses.config(['$stateProvider',routerFn]);
    return businessPmsExpenses;
});