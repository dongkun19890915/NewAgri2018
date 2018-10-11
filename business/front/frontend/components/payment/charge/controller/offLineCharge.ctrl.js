/**
 * Created by COCO on 2016/9/18.
 * 线下支付控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeCtrl = function($scope,offLineChargeServ,$stateParams,FormFocus) {

        var proposalNo = {};
        var riskCode = "";
        var proposal = $stateParams.proposalNo;
        proposalNo.proposalNo = proposal;

        if(proposalNo == null || proposalNo == ""){
            //throw new Exception("投保单号不能为空");
        }
        var initFunc = function(){
            offLineChargeServ.offLineChargeinitEdit(proposalNo).then(
                function(answer){
                    $scope.proposalNo = answer.data.proposalDto.prpTmain.proposalNo;
                    $scope.sumPremium = answer.data.proposalDto.prpTmain.sumPremium;
                    $scope.riskName =answer.data.proposalDto.riskName;
                    riskCode = answer.data.proposalDto.riskCode;
                    $scope.applyName = answer.data.proposalDto.prpTmain.applyName;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        initFunc();
        //下载付款通知书
        $scope.downAdviceNote = function(){
            var prpTmainKeyDto={};
            prpTmainKeyDto.proposalNo= $stateParams.proposalNo;
            offLineChargeServ.downAdviceNote(prpTmainKeyDto).then(
                function(answer){
                    var fileId=answer.data.shortLinkId;
                    window.open('/comm-fileserver/downloadFileByShortLinkId?shortLinkId='+fileId);
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        $scope.onEmailLayer = true;
        $scope.insuredOnlyOneLayer = true;
        //发送邮件弹层关闭方法
        $scope.receiptOpenClose = function(){
            $scope.onEmailLayer = true;
        };
        //发送邮件弹层关闭方法
        $scope.receiptOpenShow = function(){
            $scope.onEmailLayer = false;
        };
        $scope.insuredOnlyOneClose=function(){
                $scope.insuredOnlyOneLayer = true;
        };
        // 发送邮件付款通知书
        $scope.onSubmits = function(){
            if(!this.emailForm.$valid){
                FormFocus.focusEle("emailForm");
                return
            }
            var prpTmainKeyDto={};
            var prpCinvoiceDto=this.prpCinvoiceDto;
            prpTmainKeyDto.proposalNo= $stateParams.proposalNo;
            prpTmainKeyDto.receivedEmail = prpCinvoiceDto.invoceEmail;
            offLineChargeServ.downAdviceNote(prpTmainKeyDto).then(
                function(answer){
                    $scope.receiptOpenClose();
                    angular.alert("发送成功！");
                },function(error){
                    angular.alert("发送出错，请联系管理员！");
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        //上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            if(!$stateParams.proposalNo)
            {
                angular.alert("不存在投保单号,无法上传！");
                return ;
            }
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$stateParams.proposalNo,
                bussType:"T",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$stateParams.proposalNo
            }});
            $scope.FileLayer = true;
            $scope.imgFileTypeT = true;

        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
        };
    };

    moduleApp.controller('offLineChargeCtrl',['$scope','offLineChargeServ','$stateParams','FormFocus',offLineChargeCtrl]);
});


