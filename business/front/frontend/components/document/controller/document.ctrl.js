/**
 * Created by zhoujianlong on 2016/9/28.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var documentCtrl = function($scope) {

        //初始化界面
        var initFunc = function(){
            /*tab切换响应方法*/
            $scope.documentEndorseTab = function(){
                $scope.curActive='endorse';
                $scope.documentTabInclude = 'components/document/tpl/documentEndorse.html';
                //$state.go('main.document.endorse');
            };
            $scope.documentProposalTab=function(){
                $scope.curActive='proposal';
                //$state.go('main.document.proposal');
                $scope.documentTabInclude = 'components/document/tpl/documentProposal.html';
            };
        };
        initFunc();

        $scope.curActive='proposal';
        $scope.documentTabInclude = 'components/document/tpl/documentProposal.html';
        //$state.go("main.document.proposal");

        /*重置*/
        $scope.resetForm = function(){
            $scope.EpolicyQueryConditionDto={};
        };
        $scope.reseteEndorseForm = function(){
            $scope.EendorseQueryConditionDto={};
        };

    };

    moduleApp.controller('documentCtrl',['$scope',documentCtrl]);
});
