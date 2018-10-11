/**
 * Created by COCO on 2016/9/17.
 * Modify by SunLexi on 2016/10/9.
 * 退保批改数据查询控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteSurCtrl = function($scope,$state,underwriteSurServ,$stateParams) {
        $scope.surrendStartFlag = true;
        $scope.surrendCenFlag = true;
        //保单详情弹层默认不显示
        $scope.policyDetail=true;
        //公共弹层默认不显示
        $scope.insuredOnlyOneLayer = true;
        //渠道信息默认不显示
        $scope.agentFlag = true;
        //获取批单申请号
        var applyNo = $stateParams.applyNo;
        var policyNo = $stateParams.policyNo;
        //初始化界面
        var initFunc = function(){
            var data = {};
            data.applyNo = applyNo;
            /*退保批改数据查询*/
            underwriteSurServ.surrenderSearch(data).then(
                function(answer){
                    if(answer.data.resultCode != '0000'){
                        $scope.msg=answer.data.resultMsg;
                        $scope.insuredOnlyOneLayer = false;
                        return;
                    }
                    $scope.surrenderData = answer.data;
                    if($scope.surrenderData.prpPpayeeAccountDtoList[0].isPrivate == "1"){
                        $scope.surrenderData.prpPpayeeAccountDtoList[0].isPrivate="对公";
                    }else{
                        $scope.surrenderData.prpPpayeeAccountDtoList[0].isPrivate="对私";
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        initFunc();

        //关闭公共弹层
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        //点击下一步进入确认页面响应操作
        $scope.nuclearSurClick = function(){
            $state.go("main.underwriteEndorse",{"applyNo":applyNo,"policyNo":policyNo})
        };
        $scope.giveUpClick = function(){
            var data = {};
            data.applyNo = applyNo;
            underwriteSurServ.giveUpClick(data).then(
                function(answer){
                    if(answer.data.resultCode != '0000'){
                        $scope.msg=answer.data.resultMsg;
                        $scope.insuredOnlyOneLayer = false;
                    }
                    $scope.surrenderData = answer.data;
                },function(error){
                    console.log(JSON.stringify(error.data));
                }
            );
            $state.go("main.underwrite")
        };

        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        };

        //控制是否显示渠道信息
        function businessInit(bussinessNature){
            if(bussinessNature.substr(0,1)=='2' || bussinessNature=='300' || bussinessNature=='122' || bussinessNature=='123'){
                $scope.agentFlag = false;
            }else{
                $scope.agentFlag = true;
            }
        }

//上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            if(!applyNo)
            {
                angular.alert("不存在批单申请号,无法上传！");
                return ;
            }
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:applyNo,
                bussType:"E",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:applyNo
            }});
            $scope.FileLayer = true;
            $scope.imgFileTypeT = true;
        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
        };

    };
    moduleApp.controller('underwriteSurCtrl',['$scope','$state','underwriteSurServ','$stateParams',underwriteSurCtrl]);
});
