/**
 * Created by COCO on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeSuccessCtrl = function($scope,offLineChargeSuccessServ,$stateParams,$state) {
        /*线下收费待确认-确认收费*/
        console.log($stateParams.policyNo);
        $scope.policyNo = $stateParams.policyNo;
        $scope.riskName="出单成功";
        /*返回*/
        $scope.onEdit = function(){
            $state.go("main.index")
        };


        $scope.insuredOnlyOneLayer = true;
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

        //提交申请弹层关闭
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
    

    };

    moduleApp.controller('offLineChargeSuccessCtrl',['$scope','offLineChargeSuccessServ','$stateParams','$state',offLineChargeSuccessCtrl]);
});
