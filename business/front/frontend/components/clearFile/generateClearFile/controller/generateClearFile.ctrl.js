/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var generateClearFileCtrl = function($scope,$filter,$state,generateClearFileServ,FormFocus) {
          $scope.policySelected=true;
          $scope.endorseSelected=false;
          $scope.claimsSelected=false;
          $scope.formDataType="1";
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
        $scope.generateTable = function() {
            //校验日期是否输入
            if ($scope.generateClearFileForm.$valid) {
                console.log('通过验证可以提交表单');
            } else {
                FormFocus.focusEle("generateClearFileForm");
                return;
            }
            var conditionDto = {};
            conditionDto.clearDate = $scope.clearDate;
            conditionDto.clearType = $scope.formDataType;
            /*查询清分表*/
            generateClearFileServ.generateClearCheck(conditionDto).then(
                function (answer) {
                    var answerData = answer.data;
                    /*answerData=answerData.replace("[]")*/
                    if (answerData == '"success"') {
                        angular.alert("重清分已启动，完成后会上传到sftp。 可关闭此信息，进行其他操作。");
                        var conditionDto1 = {};
                        conditionDto1.clearDate = $scope.clearDate;
                        conditionDto1.clearType = $scope.formDataType;
                        generateClearFileServ.generateClearSearchTable(conditionDto1);
                        $state.reload("main.generateClearFile");
                    }
                },
            function (error) {

            }
            )
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
    };

    moduleApp.controller('generateClearFileCtrl',['$scope','$filter','$state','generateClearFileServ','FormFocus',generateClearFileCtrl]);
});
