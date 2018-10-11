/**
 * Created by zkr10 on 2016/10/8.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityMemberMaintainCtrlHandler = function ($scope,communityMemberMaintainServ,$state,$timeout,FormFocus) {
        $scope.communityMemberMaintainFailLayer=true;
        $scope.communityMemberMaintainSuccessLayer=true;
        $scope.communityMemberMaintainErrorInfoLayer=true;
        $scope.communityMemberMaintainBackLayer=true;
        $scope.communityMemberMaintainDelLayer=true;
        $scope.memberMaintain=true;
        $scope.buttonSure=true;
        $scope.coinsRatesDto = {};
        /* 初始化共保公司*/
        $scope.communityMemberMaintainInit = function(){
            $scope.maintainAnswer=0;
            communityMemberMaintainServ.communityMemberMaintainInit( $scope.coinsRatesDto).then(
                function(answer){
                    $scope.communityMemberNewData = answer.data;
                    for(var i=0;i< $scope.communityMemberNewData.length;i++){
                        $scope.maintainAnswer += $scope.communityMemberNewData[i].coinsRate;
                    }
                    $scope.maintainAnswer=Math.round($scope.maintainAnswer * 100) / 100;
                    $scope.memberMaintain=false;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };

        /*输入框失去焦点重新计算*/
        $scope.totalPlus=function(){
            $scope.maintainAnswer=parseInt(0);
            for(var i=0;i<$scope.communityMemberNewData.length;i++){
                $scope.maintainAnswer += Number($scope.communityMemberNewData[i].coinsRate);
            }
            $scope.maintainAnswer=Math.round($scope.maintainAnswer * 100) / 100;
            if($scope.maintainAnswer != 100){
                angular.alert("您好，总计数据必须为100！");
            }else {
                $scope.textTipShow=false;
            }
        };

        $scope.communityMemberDelete = function($index) {
            $scope.communityMemberMaintainDelLayer=false;
            $scope.deleteSure=function() {
                $scope.communityMemberNewData.splice($index, 1);
                $scope.maintainAnswer = parseInt(0);
                for (var i = 0; i < $scope.communityMemberNewData.length; i++) {
                    $scope.maintainAnswer += Number($scope.communityMemberNewData[i].coinsRate);
                }
                $scope.maintainAnswer=Math.round($scope.maintainAnswer * 100) / 100;
                $scope.communityMemberMaintainDelLayer = true;
                if ($scope.maintainAnswer != 100) {
                    angular.alert("您好，总计数据必须为100！");
                } else {
                    $scope.textTipShow = false;
                }
            };
            $scope.deleteFalse=function(){
                $scope.communityMemberMaintainDelLayer=true;
            }
        };
    

        /*保存-版次号*/
        $scope.buttonSure=false;
        $scope.textTipShow=false;
        $scope.communityMemberMaintainSaveIn = function(){
            if($scope.communityMemberMaintainForm.$valid){
                if($scope.maintainAnswer != 100){
                    angular.alert("您好，总计数据必须为100！");
                    return;
                }else{
                    $scope.textTipShow=false;
                }
            }else{
                FormFocus.focusEle("communityMemberMaintainForm");
                return;
            }
            angular.forEach($scope.riskList, function (risk) {
                if(risk.riskCode == $scope.coinsRatesDto.riskCode ){
                    $scope.coinsRatesDto.riskName = risk.riskCName;
                }
            });
            communityMemberMaintainServ.communityMemberMaintainSave( $scope.coinsRatesDto).then(
                function(answer){
                    $scope.communityMemberMaintainAnswer=answer.data;
                    if($scope.communityMemberMaintainAnswer.resultCode=="Y"){
                        $scope.buttonSure=true;
                        $timeout(function(){
                            $scope.communityMemberMaintainSuccessLayer=false;
                        },1000)
                    }else {
                        $scope.buttonSure = false;
                        $scope.message= $scope.communityMemberMaintainAnswer.resultMsg;
                        $scope.communityMemberMaintainErrorInfoLayer=false;
                    }
                },function(error){
                    $scope.buttonSure=false;
                    $scope.communityMemberMaintainFailLayer=false;

                }
            )
        };
        $scope.communityMemMaintainberBack=function(){
            $scope.communityMemberMaintainBackLayer=false;
        };
        $scope.backTrue=function(){
            $scope.communityMemberMaintainBackLayer=true;
            $state.go("main.communityMember");
        };
        $scope.backFalse=function(){
            $scope.communityMemberMaintainBackLayer=true;
        };
        /*添加行按钮*/
        $scope.trIncrease=function(){
            $scope.communityMemberNewData.push({
                "comCName":"",
                "coinsRate":""
            })
        };
        /*返回主页面*/
        $scope.layerBack=function(){
            $state.go("main.communityMember");
        };
        /*弹层关闭*/
        $scope.layerClose=function(){
            $scope.communityMemberMaintainFailLayer=true;
            $scope.communityMemberMaintainErrorInfoLayer=true;
        };
        /*初始化产品列表*/
        $scope.initRisk = function () {
            var conditionDto = {};
            communityMemberMaintainServ.riskQuery(conditionDto).then(
                function (answer) {
                    $scope.riskList = answer.data;
                    $scope.coinsRatesDto.riskCode = $scope.riskList[0].riskCode;
                }
            );
        };
    };
    moduleApp.controller('communityMemberMaintainCtrl',['$scope','communityMemberMaintainServ','$state','$timeout','FormFocus',communityMemberMaintainCtrlHandler]);
});
