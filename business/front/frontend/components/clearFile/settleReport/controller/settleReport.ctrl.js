/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var settleReportCtrl = function($scope,$state,$filter,settleReportServ,FormFocus) {
        /*下载结算表*/
        $scope.downloadSettleReport = function(){
            //校验日期是否输入
           if($scope.downloadSettleReportForm.$valid){
           }else{
               FormFocus.focusEle("downloadSettleReportForm");
               return;
           }
            var stringArr=$scope.settleReportDate.split("-");
            var condition={};
            condition.year=stringArr[0];
            condition.month=stringArr[1];
            settleReportServ.queryTable(condition).then(
              function(answer){
                 var fileId=answer.data;
                  console.log(fileId);
                  if(fileId){
                      settleReportServ.downLoadDocument(fileId);
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

    moduleApp.controller('settleReportCtrl',['$scope','$state','$filter','settleReportServ','FormFocus',settleReportCtrl]);
});