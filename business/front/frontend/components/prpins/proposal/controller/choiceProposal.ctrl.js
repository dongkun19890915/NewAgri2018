/**
 * Created by GuoXiangLian on 2016/11/28.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var choiceProposalCtrl = function($scope,$stateParams,$state,choiceProposalServ,indexServ) {
        $scope.fileDto = {};
        //header部位调取服务
        $scope.RiskQueryConditionDto={};
        var condition=$scope.RiskQueryConditionDto;
        indexServ.insuranceProductsInit(condition).then(
            function(answer){
                $scope.riskList = answer.data;
            },function(error){
            }
        );
        //点击确定
        $scope.indexApplication = function(){
            var proposalDto = {};
            proposalDto.riskCode = 'EQ01';// 此参数 无意思。只为后台校验权限
            indexServ.newProposalMenu(proposalDto).then(
                function(answer){
                    if(!$scope.fileDto.riskCode == ''){
                        $state.go("main.application",{"riskCode":$scope.fileDto.riskCode})
                    }else{
                        angular.alert("请先选择需要投保的产品");
                    }
                },function(error){

                }
            );
        };
    };
    moduleApp.controller('choiceProposalCtrl',['$scope','$stateParams','$state','choiceProposalServ','indexServ',choiceProposalCtrl]);
});
