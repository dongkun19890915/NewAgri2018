/**
 * Created by Guoxianglian on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeConfirmProposalCtrl = function($scope,offLineChargeConfirmProposalServ,reportProposalServ,$state,$filter,FormFocus) {

        $scope.zezaoceng=true;
        $scope.insuredOnlyOneLayer = true;
        $scope.proposalInfoDto = {};
        $scope.policyDetailParam='proposalOffLine';
        $scope.policyDetail=true;
        $scope.subsidyFlag = true;
        $scope.emailRequiredFlag = true;
        var searchFlalg = false;
        /*查询方法*/
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            if(!$scope.chargeConfirmSearchForm.$valid){
                FormFocus.focusEle("chargeConfirmSearchForm");
                return
            }
            $scope.proposalInfoDto.pageNo=$scope.paginationConf.currentPage;
            $scope.proposalInfoDto.pageSize=$scope.paginationConf.itemsPerPage;
            var proposalInfoDto=$scope.proposalInfoDto;
            /**
            if(proposalInfoDto.startDateBegin){

                proposalInfoDto.startDateBegin+=" 00:00:00"
            }
            if(proposalInfoDto.startDateEnd){
                proposalInfoDto.startDateBegin+=" 23:59:59"

            }**/
            offLineChargeConfirmProposalServ.comfirmQuery($scope.proposalInfoDto).then(
                function(answer){
                    $scope.zezaoceng=true;
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.pendingdata=answer.data.list;
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
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 15,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30, 40, 50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf.currentPage,
                                      pageSize:$scope.paginationConf.itemsPerPage};
            /*监控翻页按钮变化*/
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);

            /*保单生效日应该为当前日期*/
            var operateDate = new Date();
            $scope.proposalInfoDto.startDateBegin = $filter("date")(operateDate, "yyyy-MM-dd");

        };
        initFunc();
        /*查询方法响应事件*/
        $scope.offLineChargeConfirmQuery = function(){
            $scope.zezaoceng=false;
            searchFlalg = true;
            getInsuredList();
        };
        $scope.agentFlagOther=true;
        $scope.queryProposal=function(bussNo){
            $scope.proposalOffLine=bussNo;
            $scope.policyDetailShow();
            document.getElementById("policyTitleShow").innerHTML="投保单详情预览";
            var prpCmainKeyDto = {};
            prpCmainKeyDto.policyNo= bussNo;
            offLineChargeConfirmProposalServ.queryReportProposalNo(prpCmainKeyDto).then(
                function(answer){
                    var policyDto = answer.data;
                    var riskCode = answer.data.prpCmainDto.riskCode;
                    reportProposalServ.moduleInit().then(
                        function (answer) {
                            $scope.riskList = answer.data.riskConfig[riskCode];
                            $scope.policyDto = policyDto;
                            if(riskCode == 'EQ02'){
                                $scope.emailRequiredFlag = false;
                                $scope.subsidyTypeName = $scope.policyDto.subsidyTypeName;
                                $scope.subsidyList = $scope.policyDto.prpCSubsidyDtos;
                                $scope.planDtos = $scope.policyDto.prpCplanDtos;
                                if ($scope.policyDto.subsidyType == '' || $scope.policyDto.subsidyType == undefined) {
                                    $scope.subsidyFlag = false;
                                    return;
                                }else{
                                    $scope.subsidyFlag = true;
                                }
                            }else{
                                $scope.emailRequiredFlag = true;
                            }

                        },function(error){
                            //cconsole.log(JSON.stringify(error.data));
                        }
                    );
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );

            //初始化分页
            $scope.reportPaginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                //onChange: getInsuredList
            };
            var InsuredFuzzyQueryConditionDto = {};
            InsuredFuzzyQueryConditionDto.proposalNo= bussNo;
            offLineChargeConfirmProposalServ.queryReportTProposal(InsuredFuzzyQueryConditionDto).then(
                function(answer){
                    //$scope.reportPaginationConf.totalItems = answer.data.totalCount;
                    $scope.reportInsured = answer.data.list;
                    $scope.queryEndorseTempTotalItems = answer.data.totalCount;

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        };
        /*重置*/
        $scope.resetForm = function(){
            $scope.proposalInfoDto={}
        };

        //关闭弹层
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        /*确认收费*/



        $scope.checkBoxChange = function (item) {
            if (item.checked) {
                if (!$scope.selected) $scope.selected = item;
                if ($scope.selected !== item) item.checked = false;
            } else {
                $scope.selected = '';
            }
        };
        /**/

        $scope.comfirmCharge = function(dataJson,otherFun){
            var proposalDto = {};

            proposalDto.proposalNo = dataJson.bussNo;
            // payBankaccount  planFee payDate payPostScript
            var prpJPayExchDtos = $scope.prpJPayExchDto;
            prpJPayExchDtos.certiType=dataJson.certiType;

            var payExchDto={prpJPayExchDto: prpJPayExchDtos};
            payExchDto.prpJPayExchSubDtos=[{bussNo:dataJson.bussNo,
                payReason:dataJson.payReason,
                planFee:dataJson.planFee,
                certiType:dataJson.certiType,
                serialNo:dataJson.serialNo}];

            proposalDto.payExchDto = payExchDto;

            offLineChargeConfirmProposalServ.confirmSave(proposalDto).then(
                function(answer){
                    if(answer.data.returnCode != '0000'){
                        $scope.msg=answer.data.returnMessage;
                        $scope.insuredOnlyOneLayer = false;
                    }else {
                        var policyNo =  answer.data.policyNo;
                        if(otherFun)
                        {
                            otherFun(answer.data);
                            return;
                        }
                        $state.go('main.offLineChargeSuccess',{"policyNo":policyNo});
                    }
                },function(error){
                }
            );
        };
        /*保单生效日期开始监听*/
        $scope.$watch("proposalInfoDto.startDateBegin",function(){

            var startdate = $scope.proposalInfoDto.startDateBegin;
            if(!startdate)
            {
                return;
            }
            var startDate = new Date(startdate);
            var ensDate = new Date(startDate);
            ensDate.setMonth(ensDate.getMonth()+6);
            $scope.proposalInfoDto.startDateEnd =  $filter("date")(ensDate, "yyyy-MM-dd");
        });
        /*退出*/
        $scope.confirmProposalEdit = function(){
            $state.go("main.index");
        };
        $scope.radioSelectClick=function(){
            var dataJson=JSON.parse($("#offlineTable [name='radioCheck']:checked").val());
            if(!$scope.prpJPayExchDto)
            {
                $scope.prpJPayExchDto={}
            }
            $scope.prpJPayExchDto.planFee=dataJson.planFee;
        };
        /*确认收费*/
        $scope.confirmProposalSubmit = function(){
            if($("#offlineTable [name='radioCheck']:checked").size()==0){
                angular.alert("请选择一条投保单");
                return;
            }
            //获取到表单是否验证通过
            if($scope.chargeConfirmProposalForm.$valid){
                console.log('表单通过验证');
            }else{
                FormFocus.focusEle("chargeConfirmProposalForm");
                return
            }

            var dataJson=JSON.parse($("#offlineTable [name='radioCheck']:checked").val());

            $scope.comfirmCharge(dataJson);
        }


    };

    moduleApp.controller('offLineChargeConfirmProposalCtrl',['$scope','offLineChargeConfirmProposalServ','reportProposalServ','$state','$filter','FormFocus',offLineChargeConfirmProposalCtrl]);
});
