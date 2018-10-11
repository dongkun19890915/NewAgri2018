/**
 * Created by COCO on 2016/9/17.
 * Modify by SunLexi on 2016/10/9.
 * 退保批改数据查询控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteInsuredCtrl = function($scope,$state,underwriteSurServ,endorseInsuredServ,$stateParams,$filter) {
        //公共弹层默认不显示
        $scope.insuredOnlyOneLayer = true;
        $scope.SexManFlag = true;
        $scope.SexWomanFlag = true;
        $scope.surrenderData = {};
        $scope.surrenderData.copyPolicyDto = {};

        //渠道信息默认不显示
        $scope.agentFlag = true;
        //保单详情弹层默认不显示
        $scope.policyDetail=true;

        /*radio-个人组织*/
        $scope.insTypeLeft = true;
        $scope.insTypeRight = true;
        $scope.personalFlag = true;
        $scope.changeInsureType = 'components/prpins/underwrite/tpl/underwritePersonal.html';

        //获取批单申请号
        var applyNo = $stateParams.applyNo;
        var policyNo = $stateParams.policyNo;

        var getReportList = function(){
            //if(!searchFlalg){
            //    return;
            //}
            $scope.insuredFuzzyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.insuredFuzzyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            $scope.insuredFuzzyQueryConditionDto.applyNo= $scope.surrenderData.prpPheadDto.applyNo;
            var data = $scope.insuredFuzzyQueryConditionDto;
            endorseInsuredServ.endorseInsuredSearch(data).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.endorseInsuredData = answer.data.list;

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        //初始化界面
        var initFunc = function(){
            //初始化分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                //onChange: getInsuredList
            };
            $scope.insuredFuzzyQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

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
                    if(answer.data.copyPolicyDto.prpCopyInsuredDto.insuredType == '1'){
                        $scope.insTypeLeft = true;
                        $scope.insTypeRight = true;
                        $scope.personalFlag = true;
                        $scope.changeInsureType = 'components/prpins/underwrite/tpl/underwritePersonal.html';
                        if(answer.data.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex == '1'){
                            $scope.SexManFlag = true;
                            $scope.SexWomanFlag = true;
                            $scope.surrenderData.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex = '1';
                        }else{
                            $scope.SexManFlag = false;
                            $scope.SexWomanFlag = false;
                            $scope.surrenderData.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex = '2';
                        }
                    }else{
                        $scope.insTypeLeft = false;
                        $scope.insTypeRight = false;
                        $scope.personalFlag = false;
                        $scope.changeInsureType = 'components/prpins/underwrite/tpl/underwriteGroup.html';
                    }
                    var maxDate = answer.data.copyPolicyDto.prpCopyInsuredDto.identityEndDate;
                    $scope.surrenderData.copyPolicyDto.prpCopyInsuredDto.identityEndDate = $filter("date")(maxDate, "yyyy-MM-dd").substr(0,10);
                    $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getReportList);
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        initFunc();

        /*查看*/
        $scope.showInsure=function(PrpTinsuredPropDto){
            /*if(PrpTinsuredPropDto && PrpTinsuredPropDto.buildDate){
                try{
                    var date= new Date(PrpTinsuredPropDto.buildDate.replace(/-/,"/"));
                    PrpTinsuredPropDto.buildDate= $filter("date")(date, "yyyy-MM-dd");
                }catch(e){
                    angular.alert("建造日期 转化 出错");
                }
            }*/
            $scope.$broadcast("reportInsuredLayerShow", {PrpTinsuredPropDto:PrpTinsuredPropDto});
        };

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

        /*被保险人批量导出(下载清单)*/
        $scope.downloadInsuredAll = function(){
            var InsuredExportQueryDto = {};
            var filePath = $scope.filePath;

            //InsuredExportQueryDto.policyNo=policyNo;
            //InsuredExportQueryDto.bussinessNo=policyNo;
            //下载最新的  关系人
            console.log(JSON.stringify($scope.surrenderData)+"555555555");
            InsuredExportQueryDto.bussinessNo=$scope.surrenderData.prpPheadDto.applyNo;
            InsuredExportQueryDto.policyDetailParam='endorse';
            InsuredExportQueryDto.exportType='Insured';
            InsuredExportQueryDto.riskCode = $scope.surrenderData.prpPheadDto.riskCode;
            console.log(JSON.stringify(InsuredExportQueryDto));
            endorseInsuredServ.downloadInsureds(InsuredExportQueryDto).then(
                function(answer){
                    if(answer.data.returnCode=='0000'){
                        var shortLinkId = answer.data.shortLinkId;
                        /*下载文件*/
                        endorseInsuredServ.downloadExcel(shortLinkId);
                    }else{
                        angular.alert(answer.data.returnMessage);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                })
        };

        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        };

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
    moduleApp.controller('underwriteInsuredCtrl',['$scope','$state','underwriteSurServ','endorseInsuredServ','$stateParams','$filter',underwriteInsuredCtrl]);
});
