/**
 * Created by ZhangJiansen on 2016/9/18.
 * 投保成功控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var applicationSucCtrl = function($scope,$state,$stateParams,offLineChargeSuccessServ) {
        $scope.riskName = '出单成功';
        $scope.policyNo = $stateParams.policyNo; //P201600E000001

        $scope.onEdit = function(){
            $state.go("main.index")
        };

        $scope.downloadEpolicy=function(){
            var policyNo =  $scope.policyNo;
            offLineChargeSuccessServ.getFileId(policyNo).then(
                function(answer){
                    var shortLinkId=answer.data.shortLinkId;
                    if(shortLinkId){
                        offLineChargeSuccessServ.downloadFile(shortLinkId);
                    }else{
                        angular.alert("正在生成电子保单，请稍后再试")
                    }

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
    };
    moduleApp.controller('applicationSucCtrl',['$scope','$state','$stateParams','offLineChargeSuccessServ',applicationSucCtrl]);
});