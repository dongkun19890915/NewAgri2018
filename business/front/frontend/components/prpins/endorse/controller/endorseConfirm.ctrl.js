/**
 * Created by guoxianglian on 2016/9/10.
 * 退保模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseConfirmCtrl = function($scope,$sce,$state,endorseConfirmServ,underwriteEndorseServ,$stateParams,FormFocus) {
        $scope.isHiddenConfirm=false;
        $scope.policyInfoShow=false;
        if($stateParams.oper=='view'){
            $scope.isHiddenConfirm=true;
        }
        var applyNo = $stateParams.applyNo;
        $scope.insuredOnlyOneLayer = true;
        //初始化界面
        var initFunc = function(){
            var data = {};
            data.applyNo = applyNo;
            /*退保批改确认信息查询*/
            underwriteEndorseServ.surrenderConfirm(data).then(
                function(answer){
                    $scope.surrenderData = answer.data;
                    if($scope.surrenderData.endorType=='02'){
                        $scope.policyInfoShow=true;
                    }else{
                        $scope.policyInfoShow=false;
                    }
                    $scope.surrenderData.endorseText = $sce.trustAsHtml(answer.data.endorseText);
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
            /*查看核批记录*/
            underwriteEndorseServ.uwNotionSeach(data).then(
                function(answer){
                    $scope.uwNotionData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );

        };
        initFunc();

        /*提交批改*/
        $scope.pageDir=$stateParams.pageDir;
        $scope.endorseConfirmSubmit = function(){
            var surrender = {};
            surrender.applyNo = $scope.surrenderData.applyNo;
            surrender.endorType = $scope.surrenderData.endorType;
            surrender.policyNo = $stateParams.policyNo;
            surrender.validDate = $scope.surrenderData.validDate;
            endorseConfirmServ.submitEndorse(surrender).then(
                function(answer){
                    if(answer.data.delMsg!= undefined &&answer.data.delMsg!=null){
                        $scope.msg=answer.data.delMsg;
                        $scope.insuredOnlyOneLayer = false;
                        return;
                    }else{
                        $state.go("main.endorsePublicSuccess",{"msg":answer.data.endorseReturnDto.resultMsg,"applyNo":surrender.applyNo,"endorType":answer.data.endorseDto.endorType})
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        $scope.returnUpdate=function(){
            var  applyNo = $scope.surrenderData.applyNo;
            if(this.pageDir=='01'){
                $state.go("main.endorseInsured",{'applyNo':applyNo,'oper':'update','policyNo':$stateParams.policyNo})
            }else if(this.pageDir=='02'){
                $state.go("main.endorseSurrend",{'applyNo':applyNo,'oper':'update','policyNo':$stateParams.policyNo})
            }else {
                $state.go("main.endorseBusiness",{'applyNo':applyNo,'oper':'update','policyNo':$stateParams.policyNo})
            }

        };

        $scope.exitEndorse=function(){
            $state.go("main.index");
        };
        //关闭弹层
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        //查看核批记录弹层响应方法
        $scope.endorseNuclearLayer = true;
        $scope.nuclearViewClick = function(){
            $scope.endorseNuclearLayer = false;
        };
        //隐藏弹层
        $scope.newclearViewHide = function(){
            $scope.endorseNuclearLayer = true;
        };
        //批单删除
        $scope.deleteLayer = true;
        $scope.returnDelete = function(){
            $scope.deleteLayer = false;
        };
        //关闭删除批单弹层
        $scope.surrendDeleteClose = function(){
            $scope.deleteLayer = true;
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
            endorseUpdateConditionDto.applyNo = applyNo;
            endorseUpdateConditionDto.delReasonCode = this.endorseUpdateConditionDto.delReasonCode;
            endorseUpdateConditionDto.delReasonDesc = this.endorseUpdateConditionDto.delReasonDesc;
            endorseConfirmServ.deleteApplyNo(endorseUpdateConditionDto).then(
                function(answer){
                    var data = answer.data;
                    if(answer.data.resultCode != '00'){
                       /* $state.go("main.endorseDeleteFail",{"applyNo":applyNo})*/
                        $scope.msg=answer.data.resultMessage;
                        $scope.insuredOnlyOneLayer = false;
                        $scope.deleteLayer = true;
                        return
                    }else{

                        $state.go("main.endorseDeleteSuccess",{"applyNo":applyNo})
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
    };

    moduleApp.controller('endorseConfirmCtrl',['$scope','$sce','$state','endorseConfirmServ','underwriteEndorseServ','$stateParams','FormFocus',endorseConfirmCtrl]);
});