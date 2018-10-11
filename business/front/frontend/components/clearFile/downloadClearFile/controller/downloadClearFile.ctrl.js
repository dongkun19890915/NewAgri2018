/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var downloadClearFileCtrl = function($scope,$state,$filter,downloadClearFileServ,FormFocus) {
        $scope.policySelected=true;
        $scope.endorseSelected=false;
        $scope.claimsSelected=false;
        $scope.clearType="1";
        $scope.initDatalist=true;
        $scope.withoutData=false;
        $scope.existingData=false;
        $scope.businessType1=function(){
            $scope.policySelected=true;
            $scope.endorseSelected=false;
            $scope.claimsSelected=false;
        };
        $scope.businessType2=function(){
            $scope.policySelected=false;
            $scope.endorseSelected=true;
            $scope.claimsSelected=false;
        };
        $scope.businessType3=function(){
            $scope.policySelected=false;
            $scope.endorseSelected=false;
            $scope.claimsSelected=true;
        };
        var conditionDto={};
        /*监听日期变化，不符合条件清空*/
        $scope.$watch('clearDate',function(){
            if($scope.clearDate !="" && $scope.clearDate !=undefined){
                var chooseTime=$scope.clearDate.replace(/\-/g,"/");
                var a1=new Date(chooseTime).getTime();
                var a2=new Date().getTime();
                if(a1>a2){
                    $scope.clearDate="";
                }
            }
        });
        /*清分日期最大化设置*/
        var today=new Date();
        $scope.maxDate = $filter('date')(today, 'yyyy-MM-dd');
        /*下载清分表按钮*/
        $scope.clearFileSearch = function(){
            //校验日期是否输入
           if($scope.downLoadClearFileForm.$valid){
           }else{
               FormFocus.focusEle("downLoadClearFileForm");
               return;
           }
           conditionDto.clearType=$scope.clearType;
           conditionDto.clearDate=$scope.clearDate;
           /*查询清分表*/
           downloadClearFileServ.queryTable(conditionDto).then(
              function(answer){
                 $scope.answerData=answer.data;
                  if($scope.answerData.length != 0 ){
                      $scope.withoutData=false;
                      $scope.existingData=true;
                      $scope.initDatalist=false;
                  }else{
                      $scope.withoutData=true;
                      $scope.existingData=false;
                      $scope.initDatalist=false;
                  }
                  return answer;
              },
              function(error){
              }
           );
        };
        /*文件下载*/
        $scope.downLoadTable=function(data){
            conditionDto.fileId=data.fileId;
            downloadClearFileServ.downLoadTableList(conditionDto).then(
                function(answer){
                    var shortLink=answer.data.replace(/\"/g,"");
                    downloadClearFileServ.downLoadTable(shortLink);

                    return answer;
                },
                function(error){
                }
            );
        };
        /*清分文件重置*/
        $scope.clearFileReset=function(){
            $scope.businessType1();
            $scope.clearDate="";
            $scope.initDatalist=true;
            $scope.existingData=false;
            $scope.withoutData=false;
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
    };
    moduleApp.controller('downloadClearFileCtrl',['$scope','$state','$filter','downloadClearFileServ','FormFocus',downloadClearFileCtrl]);
});