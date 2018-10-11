/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var genSettleReportCtrl = function($scope,$state,$filter,genSettleReportServ,FormFocus) {
        /*生成结算表*/
        $scope.createReport = function(){
            //校验日期是否输入
            if($scope.genSettleReportForm.$valid){
            }else{
                FormFocus.focusEle("genSettleReportForm");
                return;
            }
            var stringArr=$scope.settleReportDate.split("-");
            var condition={};
            condition.year=stringArr[0];
            condition.month=stringArr[1];
            genSettleReportServ.createTable(condition).then(

                function(answer){
                    var answerData = answer.data;
                    if(angular.isDefined(answerData)){
                        angular.alert(condition.year+"年"+condition.month+"月"+"结算表生成成功！")
                    }

                },
                function(error){
                }
            );
        };
        /*清分文件重置*/
        $scope.clearFileReset=function(){
            $scope.businessType1();
            $scope.clearDate="";
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
    };

    moduleApp.controller('genSettleReportCtrl',['$scope','$state','$filter','genSettleReportServ','FormFocus',genSettleReportCtrl]);
});