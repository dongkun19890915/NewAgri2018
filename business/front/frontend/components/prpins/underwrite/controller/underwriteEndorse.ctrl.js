/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteEndorseCtrl = function($scope,$sce,$state,underwriteEndorseServ,$stateParams) {
        //获取批单申请号
        var applyNo = $stateParams.applyNo;
        var policyNo = $stateParams.policyNo;
        $scope.invoiceSpeFlag = true;
        $scope.invoiceEleFlag = false;
        $scope.invoicePapFlag = false;

        $scope.uwNotionDto = {};
        $scope.uwNotionDto.bussNo=applyNo;

        //初始化界面
        var initFunc = function(){
            $scope.uwNotionDto.handleType=0;
            var data = {};
            data.applyNo = applyNo;
            /*退保批改确认信息查询*/
            underwriteEndorseServ.surrenderConfirm(data).then(
                function(answer){
                    $scope.endorseResultDto = answer.data;
                    $scope.endorseResultDto.endorseText =$sce.trustAsHtml(answer.data.endorseText);
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

        //查看核批记录弹层响应方法
        $scope.endorseNuclearLayer = true;
        $scope.nuclearViewClick = function(){
            $scope.endorseNuclearLayer = false;
        };
        //隐藏弹层
        $scope.newclearViewHide = function(){
            $scope.endorseNuclearLayer = true;
        };
        //不同决裁结果选择不同class
        $scope.invoiceClick = function(){
            $scope.invoiceSpeFlag = true;
            $scope.invoiceEleFlag = false;
            $scope.invoicePapFlag = false;
            $scope.uwNotionDto.handleType = "0";
        };
        $scope.invoiceClick1 = function(){
            $scope.invoiceSpeFlag = false;
            $scope.invoiceEleFlag = true;
            $scope.invoicePapFlag = false;
            $scope.uwNotionDto.handleType = "1";
        };
        $scope.invoiceClick2 = function(){
            $scope.invoiceSpeFlag = false;
            $scope.invoiceEleFlag = false;
            $scope.invoicePapFlag = true;
            $scope.uwNotionDto.handleType = "2";
        };
        /**提示框相关方法**/
        $scope.alert=function(opt){
            $scope.showAlertMsg=opt.msg;
            $scope.showAlertOneLayer=true;
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
        //点击返回按钮
        $scope.goBack = function(){
            if($scope.endorseResultDto.endorType == '01'){
                $state.go("main.underwriteInsured",{"applyNo":applyNo,"policyNo":policyNo});
            }else if($scope.endorseResultDto.endorType == '03'){
                $state.go("main.underwriteBus",{"applyNo":applyNo,"policyNo":policyNo});
            }else{
                $state.go("main.underwriteSur",{"applyNo":applyNo,"policyNo":policyNo});
            }
        };
        $scope.nuclearSubmitClick = function(){
            var uwNotionDto = $scope.uwNotionDto;
            var applyNo = $scope.uwNotionDto.bussNo;
            if(uwNotionDto.handleType=="1"||uwNotionDto.handleType=="2"){
                if(!uwNotionDto.handleText){
                    $scope.alert({msg:"核批决定为返回录入人员补充信息或核批不通过需填写核批意见！"});
                    return;
                }
            }
            underwriteEndorseServ.onSubmits(uwNotionDto).then(
                function (answer) {
                    var msg = answer.data.resultMsg;
                    $state.go("main.underwriteSuc",{"msg":msg,"applyNo":applyNo, handleType:uwNotionDto.handleType,"endorType":$scope.endorseResultDto.endorType});
                }, function (error) {
                    //console.log(JSON.stringify(error.data));
                }
            )
        };
    };
    moduleApp.controller('underwriteEndorseCtrl',['$scope','$sce','$state','underwriteEndorseServ','$stateParams',underwriteEndorseCtrl]);
});
