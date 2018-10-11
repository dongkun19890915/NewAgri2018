/**
 * Created by zkr10 on 2016/10/6.
 */
define(['../module'], function (moduleApp) {
    'use strict';
   var areaquotaMaintainCtrlHandler = function ($scope,areaquotaMaintainServ,$state,$timeout,FormFocus) {
        $scope.areaquotaFailLayer=true;
        $scope.areaquotaSuccessLayer=true;
        $scope.areaquotaErrorInfoLayer=true;
        $scope.areaquotaMaintainBackLayer=true;
        $scope.buttonSure=false;
        /*区域销售限额数据初始化*/
        $scope.areaquotaQuery=function(){
            $scope.totalResult=0;
            $scope.col="areaCode";
            areaquotaMaintainServ.areaquotaInit().then(
                function(answer){
                    $scope.areaquotaNewData=answer.data;
                    for(var i=0;i<$scope.areaquotaNewData.length;i++){
                        //$scope.areaquotaNewData[i].areaLimits=parseInt($scope.areaquotaNewData[i].areaLimits);
                        $scope.totalResult += $scope.areaquotaNewData[i].salesLimit;
                    }
                    $scope.totalResult=Math.round($scope.totalResult*100)/100;
                },
                function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        /*输入框失去焦点重新计算*/
        $scope.Calculation=function(){
            $scope.totalResult=parseInt(0);
            for(var i=0;i<$scope.areaquotaNewData.length;i++){
                $scope.totalResult += Number($scope.areaquotaNewData[i].salesLimit);
            }
            $scope.totalResult=Math.round($scope.totalResult*100)/100;
        };

        /*保存-区域销售限额维护*/
        $scope.areaquotaSave= function(){
            if($scope.areaquotaMaintainForm.$valid){

            }else{
                FormFocus.focusEle("areaquotaMaintainForm");
                return;
            }
            $scope.savereaLimitsDto.riskCode="EQ01";
            $scope.savereaLimitsDto.riskName="财产保险";
            var map={
                "areaLimits":$scope.areaquotaNewData,
                "effectDate":$scope.savereaLimitsDto.effectDate,
                "versionNo":$scope.savereaLimitsDto.versionNo,
                "riskName":$scope.savereaLimitsDto.riskName,
                "riskCode":$scope.savereaLimitsDto.riskCode
            };
            //表单是否保存成功
            var data = map;
            areaquotaMaintainServ.areaquotaMaintainSale(data).then(
                function(answer){
                    $scope.areaquotaSaveAnswer=answer.data;
                    if($scope.areaquotaSaveAnswer.resultCode=="Y"){
                        $scope.buttonSure=true;
                        $timeout(function(){
                            $scope.areaquotaSuccessLayer=false;
                        },1000)
                    }else{
                        $scope.buttonSure=false;
                        $scope.areaquotaErrorInfoLayer=false;
                    }
                },function(error){
                    $scope.areaquotaFailLayer=false;
                }
            )
        };
        /*页面返回提示*/
        $scope.areaquotaBack=function(){
            $scope.areaquotaMaintainBackLayer=false;
        };
        $scope.backTrue=function(){
            $scope.areaquotaMaintainBackLayer=true;
            $state.go("main.areaquota");
        };
        $scope.backFalse=function(){
            $scope.areaquotaMaintainBackLayer=true;
        };
        /*弹层直接返回主页面*/
        $scope.layerBack=function(){
                $state.go("main.areaquota");
        };
        /*弹层关闭*/
        $scope.layerClose=function(){
            $scope.areaquotaFailLayer=true;
            $scope.areaquotaErrorInfoLayer=true;
        }
    };

   moduleApp.controller('areaquotaMaintainCtrl',['$scope','areaquotaMaintainServ','$state','$timeout','FormFocus',areaquotaMaintainCtrlHandler]);
});


