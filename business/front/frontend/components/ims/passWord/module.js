/**
 * Created by zkr22 on 2016/10/20.
 */
define(['angular'],
    function (angular) {
    'use strict';
    /*密码模块*/
    var routerFn = function ($stateProvider) {
        var passWordPath = 'components/ims/passWord';
        $stateProvider
            .state("main.passWord", {
                url:"/passWord",
                resolve:{
                    loadCommunity:['$ocLazyLoad',function($ocLazyLoad){
                        return $ocLazyLoad.load([
                            passWordPath+'/controller/passwd.ctrl.js',
                            passWordPath+'/service/passwd.serv.js']);
                    }]
                },
                templateUrl: "components/ims/passWord/tpl/passwd.html",
                controller:"passwdCtrl"
            });
    };

    var businessImsPassWord = angular.module('business.ims.passWord', []);

    businessImsPassWord.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
        function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
            businessImsPassWord.controller = $controllerProvider.register;
            businessImsPassWord.directive = $compileProvider.directive;
            businessImsPassWord.filter = $filterProvider.register;
            businessImsPassWord.factory = $provide.factory;
            businessImsPassWord.service = $provide.service;
            businessImsPassWord.constant = $provide.constant;
        }]);

    /*定义路由*/
    businessImsPassWord.config(['$stateProvider',routerFn]);

    return businessImsPassWord;
});
