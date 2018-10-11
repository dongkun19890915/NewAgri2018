/**
 * Created by GuoXiangLian on 2016/9/18.
 * 在线支付弹层控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var onLineChargeLayerCtrl = function($scope,onLineChargeLayerServ,$interval,$state) {

        $scope.onLineClose = function(){
            $scope.stopQuery();
            $scope.doOnLineClose();
        };


        // 手动处理 支付结果，需要跳转，轮训事没有结果不关闭弹层
        $scope.operatorPayResult=function(){
            console.log(" operatorPayResult begin");
            var proposalNo =  $scope.proposalNo;
            var proposalDto = {};
            proposalDto.proposalNo = proposalNo;
            onLineChargeLayerServ.queryPayResult(proposalDto).then(
                function(answer){
                    var prpCmainDto = answer.data.prpCmainDto;
                    if(prpCmainDto==null||angular.equals({}, prpCmainDto)){
                        $state.go('main.onLineCharge',{"proposalNo":proposalNo});
                    }else{
                        var policyNo = prpCmainDto.policyNo;
                        if(policyNo){
                            $state.go('main.offLineChargeSuccess',{"policyNo":policyNo});
                        }else{
                            $state.go('main.onLineCharge',{"proposalNo":proposalNo});
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        // 轮训，只跳转 成功页面
        $scope.queryPayResult=function(){
            console.log(" Training in rotation begin");
            var proposalNo =  $scope.proposalNo;
            var proposalDto = {};
            proposalDto.proposalNo = proposalNo;
            onLineChargeLayerServ.queryPayResult(proposalDto).then(
                function(answer){
                    var prpCmainDto = answer.data.prpCmainDto;
                    //if(prpCmainDto === null || prpCmainDto === ''){
                    //
                    //}else{
                    //    var policyNo = prpCmainDto.policyNo;
                    //    if (policyNo === null || policyNo === ''){
                    //
                    //    }else{
                    //        $state.go('main.offLineChargeSuccess',{"policyNo":policyNo});
                    //    }
                    //}
                    if(prpCmainDto==null||angular.equals({}, prpCmainDto)){

                    }else{
                        var policyNo = prpCmainDto.policyNo;
                        if(policyNo){
                            $state.go('main.offLineChargeSuccess',{"policyNo":policyNo});
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };


        // 支付成功
        $scope.onLinePaySucc=function(){
            console.log("click success begin to decide");
            // 关闭轮训
            $scope.onLineClose();
            $scope.operatorPayResult();

        };

        // 支付失败
        $scope.onLinePayFail=function(){
            console.log("click fail begin to decide");
            // 关闭轮训
            $scope.onLineClose();

            $scope.operatorPayResult();

        };

        // 轮训
        var stop;
        var count = 0;
        var queryStatus = function(){
            console.log("轮训查询"+(count++));
            $scope.queryPayResult();
        };
        $scope.beginQuery = function(){
            if(angular.isDefined(stop)){
                return;
            }
            stop = $interval(queryStatus,3000,1000*60*30/3000); //1000*60*30/3000 轮训 30分钟
        };

        $scope.stopQuery = function(){
            if(angular.isDefined(stop)){
                $interval.cancel(stop);
                stop = undefined;
            }
        };

        $scope.$on('$destroy',function(){
            $scope.stopQuery();
        });

        $scope.beginQuery();

    };

    moduleApp.controller('onLineChargeLayerCtrl',['$scope','onLineChargeLayerServ','$interval','$state',onLineChargeLayerCtrl]);
});
