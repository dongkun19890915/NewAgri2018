/**
 * Created by zkr10 on 2016/10/6.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var expensesMaintainCtrlHandler = function ($scope,expensesMaintainServ,$state,$timeout,FormFocus) {
        /*新增销售费用率页面*/
        $scope.expensesSuccessLayer=true;
        $scope.expensesFailLayer=true;
        $scope.expensesErrorInfoLayer=true;
        $scope.expensesMaintainBackLayer=true;
        $scope.buttonSure=false;
        $scope.saleRatesDto = {};
        $scope.expensesSave= function(){
            //获取到表单是否验证通过
            if($scope.expensesMaintainForm.$invalid){
                FormFocus.focusEle("expensesMaintainForm");
                return;
            }
            var saleRatesDto = $scope.saleRatesDto;
            angular.forEach($scope.riskList, function (risk) {
                if(risk.riskCode == saleRatesDto.riskCode ){
                    saleRatesDto.riskName = risk.riskCName;
                }
            });
            expensesMaintainServ.expensesSave(saleRatesDto).then(
                function(answer){
                    //$scope.buttonSure=true;     //按钮禁用
                    $scope.expensesSaveAnswer=answer.data;
                    if($scope.expensesSaveAnswer.resultCode=="Y"){
                        $scope.buttonSure=true;
                        $scope.expensesSuccessLayer=false;
                    }else{
                        $scope.buttonSure=false;
                        $scope.expensesErrorInfoLayer=false;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                    $scope.expensesFailLayer=false;

                }
            )
        };
        $scope.expensesBack=function(){
            $scope.expensesMaintainBackLayer=false;
        };
        $scope.backTrue=function(){
            $scope.expensesMaintainBackLayer=true;
            $state.go("main.expenses");
        };
        $scope.backFalse=function(){
            $scope.expensesMaintainBackLayer=true;
        };
        /*退回到主页面*/
        $scope.layerBack=function(){
                $state.go("main.expenses");
        };
        /*弹层关闭*/
        $scope.layerClose=function(){
            $scope.expensesErrorInfoLayer=true;
            $scope.expensesFailLayer=true;
        };
        var riskQuery = function () {
            var conditionDto = {};
            expensesMaintainServ.riskQuery(conditionDto).then(
                function (answer) {
                    $scope.riskList = answer.data;
                    $scope.saleRatesDto.riskCode = $scope.riskList[0].riskCode;
                }
            );
        };
        var initPage = function(){
            // 初始化产品
            riskQuery();
        };
        initPage();
    };
    moduleApp.controller('expensesMaintainCtrl',['$scope','expensesMaintainServ','$state','$timeout','FormFocus',expensesMaintainCtrlHandler]);
});
