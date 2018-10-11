/**
 * Created by guoxianglian on 2016/9/10.
 * 退保模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseBusinessCtrl = function($scope,$state,endorseBusinessServ,$stateParams,FormFocus) {
        $scope.surrendStartFlag = true;
        $scope.surrendCenFlag = true;
        $scope.policyDetailParam='policy';
        /*初始化*/
        $scope.endorseReturnDto = {};
        $scope.endorseReturnDto.prpPheadDto = {};
        $scope.endorseReturnDto.prpPheadDto.surrenderType = '';
        //保单详情弹层默认不显示
        $scope.policyDetail=true;
        //渠道信息不显示
        $scope.agentFlag = true;
        var policyNo = $stateParams.policyNo;
        var endorType = $stateParams.endorType;
        var endorDate = $stateParams.endorDate;
        var validDate = $stateParams.validDate;
        function init(){
            var surrendData = {
                policyNo:policyNo,
                endorType:endorType,
                endorDate:endorDate,
                validDate:validDate
            };
            if($stateParams.oper=='update' ){

                var endorseQueryConditionDto={};
                endorseQueryConditionDto.applyNo=$stateParams.applyNo;
                endorseBusinessServ.surUpdate(endorseQueryConditionDto).then(
                    function(anwser){
                        $scope.endorseReturnDto = anwser.data;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )

            }else{
                endorseBusinessServ.surInit(surrendData).then(
                    function(anwser){
                        $scope.endorseReturnDto = anwser.data.endorseReturnDto;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }

        }
        init();
        /*被保险人住宅类型*/
        $scope.radioSurrendClick = function () {
            $scope.surrendStartFlag = false;
            $scope.surrendCenFlag = false;
        };
        $scope.radioSurrendClick1 = function () {
            $scope.surrendStartFlag = true;
            $scope.surrendCenFlag = true;
        };
        /*批单保存*/
        $scope.insuredOnlyOneLayer = true;
        $scope.surrendSave = function(){
            var prpPpayeeAccountDto = [];
            prpPpayeeAccountDto[0] =$scope.endorseReturnDto.prpPpayeeAccountDto;
            $scope.endorseReturnDto.prpPpayeeAccountDto = prpPpayeeAccountDto;
            var data = $scope.endorseReturnDto;
            endorseBusinessServ.surSave(data).then(
                function(anwser){
                    $scope.msg = '恭喜您，保存成功！';
                    if(anwser.data.delMsg!=undefined&&anwser.data.delMsg!=null){
                        $scope.msg=anwser.data.delMsg;
                    }
                    $scope.insuredOnlyOneLayer = false;
                },function(error){
                    angular.alert("非常抱歉，保存失败！");
                }
            )
        };
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };

        /*文件上传*/
        $scope.surrendFileLayer = false;
        $scope.surrendFileUploadClick = function(){
            $scope.surrendFileLayer = true;
        };
        $scope.surrendFileUploadClose = function(){
            $scope.surrendFileLayer = false;
        };
        /*删除批单*/
        $scope.surrendDeleteLayer = false;
        $scope.surrendDeleteClick = function(){
            $scope.surrendFileLayer = true;
        };

        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        };
        //批单删除
        $scope.deleteLayer = true;
        $scope.deleteshowInsure = function(){
            $scope.deleteLayer = false;
        };
        //查询保单详情
        $scope.queryPolicy = function(policyNo){
            //window.open("/gscore-front/#/main/components/reportTab/reportProposal.html?policyNo="+$stateParams.policyNo);
        };
        //退出
        $scope.exitEndorse=function(){
            $state.go("main.index");
        };
        /*点击下一步*/
        $scope.surrendNext = function(){
            if($scope.endorseBusinessForm.$valid){
                if($scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.handlerCode == undefined){
                    $scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.handlerCode = '';
                }
                if($scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.contractNo == undefined){
                    $scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.contractNo = '';
                }
                if($scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.handlerCode == '' && $scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.contractNo == ''){
                    angular.alert("渠道代码及协议代码必须填入至少一项");
                    return;
                }
                var data = $scope.endorseReturnDto;
                endorseBusinessServ.surSave(data).then(
                    function(anwser){
                        if(anwser.data.delMsg!=undefined&&anwser.data.delMsg!=null){
                            $scope.msg=anwser.data.delMsg;
                            $scope.insuredOnlyOneLayer = false;
                            return
                        }
                        var applyNo = anwser.data.endorseReturnDto.applyNo;
                        $state.go("main.endorseConfirm",{"applyNo":applyNo,"pageDir":'03','policyNo':$stateParams.policyNo})
                    },function(error){
                        angular.alert("非常抱歉，提交失败！");
                    }
                )
            }else{
                FormFocus.focusEle("endorseBusinessForm");
                return;
            }
        };

        //上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            $scope.imgFileTypeT = true;
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$scope.endorseReturnDto.prpPheadDto.applyNo,
                bussType:"E",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$scope.endorseReturnDto.prpPheadDto.applyNo
            }});
            $scope.FileLayer = true;
        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;

        };
        //删除批单返回后台
        $scope.delReasonFlag = true;
        $scope.endorseUpdateConditionDto = {};
        $scope.$watch("endorseUpdateConditionDto.delReasonCode",function(){
            if($scope.endorseUpdateConditionDto.delReasonCode == '03'){
                $scope.delReasonFlag = false;
            }else{
                $scope.delReasonFlag = true;
            }
        });
        $scope.surrendDeleteConfirm = function(){
            if(!this.deleteEndorseForm.$valid){
                FormFocus.focusEle("deleteEndorseForm");
                return
            }
            var endorseUpdateConditionDto = {};
            endorseUpdateConditionDto.applyNo = $scope.endorseReturnDto.prpPheadDto.applyNo;
            endorseUpdateConditionDto.delReasonCode = this.endorseUpdateConditionDto.delReasonCode;
            endorseUpdateConditionDto.delReasonDesc = this.endorseUpdateConditionDto.delReasonDesc;
            endorseBusinessServ.deleteApplyNo(endorseUpdateConditionDto).then(
                function(answer){
                    var data = answer.data.endorseUpdateConditionDto;
                    if(answer.data.resultCode != '00'){
                        /*$state.go("main.endorseDeleteFail",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})*/
                        $scope.msg=answer.data.resultMessage;
                        $scope.insuredOnlyOneLayer = false;
                        $scope.deleteLayer = true;
                        return
                    }else{
                        $state.go("main.endorseDeleteSuccess",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*删除批单关闭*/
        $scope.surrendDeleteClose = function(){
            $scope.deleteLayer = true;
            $scope.surrendFileLayer = false;
            $scope.endorseUpdateConditionDto = {};
            $(".validation-errorText").css('display','none');
        };
    };

    moduleApp.controller('endorseBusinessCtrl',['$scope','$state','endorseBusinessServ','$stateParams','FormFocus',endorseBusinessCtrl]);
});