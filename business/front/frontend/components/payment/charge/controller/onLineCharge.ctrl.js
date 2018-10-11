/**
 * Created by GuoXiangLian on 2016/9/18.
 * 在线支付控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var onLineChargeCtrl = function($q,$scope,onLineChargeServ,$stateParams,$window,$interval) {


        $scope.onLineChargeFailLayer = false;
        $scope.cannotSubmit=false;
        $scope.proposalPdfDto = {};
        var initFunc = function(){
            var proposalNo = {};
            var proposal = $stateParams.proposalNo;
            proposalNo.proposalNo = proposal;
            $scope.proposalPdfDto.proposalNo = proposal;
            if(proposalNo == null || proposalNo == ""){
                //throw new Exception("投保单号不能为空");
                console.log("投保单号不能为空");
            }
            onLineChargeServ.onLineChargeinitEdit(proposalNo).then(
                function(answer){
                    $scope.proposalNo = answer.data.proposalDto.prpTmain.proposalNo;
                    $scope.sumPremium = answer.data.proposalDto.prpTmain.sumPremium;
                    $scope.riskName =answer.data.proposalDto.riskName;
                    $scope.applyName = answer.data.proposalDto.prpTmain.applyName;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        initFunc();
        /*支付弹层*/

        var timer;
        function startTimer(){
            timer = $interval(function(){
                console.log("查询后台");
            },1000,false);
        }
        function endTimer(){
            $scope.cancel = function(){
                $interval.cancel(timer);
            }
        }
        /*$scope.$watch($scope.onLineLayer,function(){
            if($scope.onLineLayer == true){
                $interval.cancel($scope.timer);
            }else{
                timer = $interval(function(){
                    console.log("查询后台");
                },1000);
            }
        });
*/
        $scope.onLineLayer = false;

        // 关闭或者 返回
        $scope.chargeFaileClose = function(){
            $scope.onLineChargeFailLayer = false;
        };


        // 确认支付
        $scope.onLineSubmit = function(){
            $scope.cannotSubmit=true;
            var proposalNo = $scope.proposalNo;
            var proposalDto = {};
            proposalDto.proposalNo = proposalNo;
            onLineChargeServ.onLineGoToPay(proposalDto).then(
                function(answer){
                    if(answer.data.resultCode == '0000'){
                        var shorturl = answer.data.payInfoDto.shortURL;
                        if (answer.data.payInfoDto.msgCode == '0000'){
                            if(shorturl != undefined && shorturl != null){
                                $window.open(answer.data.payInfoDto.shortURL);
                                $scope.cannotSubmit=false;
                            }
                            $scope.onLineLayer = true;
                        } else{
                            $scope.msg = answer.data.payInfoDto.msgInfo;
                            $scope.onLineChargeFailLayer = true;
                            $scope.cannotSubmit=false;
                        }
                    }else{
                        $scope.msg = answer.data.reslutMessage;
                        $scope.cannotSubmit=false;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                    $scope.applicationFailLayer = false;
                    $scope.cannotSubmit=false;
                }
            );
        };

        $scope.doOnLineClose = function(){
            $scope.onLineLayer = false;
        };

        //查看电子保单前，获取短连接id
        $scope.beforePdfView = function(){
            var deffer = $q.defer();
            console.log("开始获取短连接id",new Date());
            onLineChargeServ.viewEproposal($scope.proposalPdfDto).then(
                function(answer){
                    if(answer.data != null){
                        var fileId = answer.data.shortLinkId;
                        $scope.pdfUrl = '#/pdf?fileId='+fileId;
                        console.log("获取短连接id成功:",$scope.pdfUrl,new Date());
                        deffer.resolve();
                    }else{
                        angular.alert("很抱歉，投保单预览失败！");
                        deffer.reject();
                    }
                },function(error){
                    angular.alert("服务异常，请联系管理员！");
                    deffer.reject();
                }
            );
            return deffer.promise;
        };


    };

    moduleApp.controller('onLineChargeCtrl',['$q','$scope','onLineChargeServ','$stateParams','$window','$interval',onLineChargeCtrl]);
});
