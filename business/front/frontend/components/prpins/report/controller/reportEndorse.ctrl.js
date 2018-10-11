/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportEndorseCtrl = function($scope,$sce,$state,reportEndorseServ,reportProposalServ,$stateParams) {
        
        $scope.showExit=false;
        $scope.subsidyFlag = false;
        $scope.policyDetailParam="endorse";
        $scope.PolicyQueryConditionDto = new Object();
        $scope.PolicyQueryConditionDto.pageNo = 0;
        $scope.PolicyQueryConditionDto.pageSize = 100;
        $scope.PolicyQueryConditionDto.policyNo = $stateParams.policyNo;
        var PolicyQueryConditionDto = $scope.PolicyQueryConditionDto;
        reportEndorseServ.endorseSearch(PolicyQueryConditionDto).then(
            function(answer){
                $scope.reportData = answer.data;
                if($scope.reportData && $scope.reportData.length ){
                    for(var i=0;i<$scope.reportData.length;i++){
                        $scope.reportData[i].pText=$sce.trustAsHtml($scope.reportData[i].pText);
                    }
                }
            },function(error){
                //cconsole.log(JSON.stringify(error.data));
            }
        );
        $scope.policyDetail=true;
        $scope.reBack=function(){
            $state.go('main.report');
        };
        /*查询上一次 批单*/
        $scope.queryPrePolicy=function(data){
            $scope.PolicyQueryConditionDto = new Object();
            $scope.PolicyQueryConditionDto.pageNo = 0;
            $scope.PolicyQueryConditionDto.pageSize = 100;
            $scope.PolicyQueryConditionDto.policyNo = $stateParams.policyNo;
            $scope.PolicyQueryConditionDto.applyNo = data.applyNo;
            var PolicyQueryConditionDto = $scope.PolicyQueryConditionDto;
            reportEndorseServ.endorsequeryPrePolicy(PolicyQueryConditionDto).then(
                function(answer){
                    var applyNo=answer.data.applyNo;
                    if(applyNo){
                        queryPreCopyMain(applyNo);
                    }else{
                        queryPreCopyMain($stateParams.policyNo);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        $scope.agentFlagOther=true;
        function queryPreCopyMain(applyNo){
            $scope.policyDto = {};
            $scope.reportInsuredSwitch = new Array();

            $scope.policyDetailShow();
            var prpCopyMainKeyDto = {};
            prpCopyMainKeyDto.applyNo=applyNo;
            reportEndorseServ.queryEndorseTranPolicy(prpCopyMainKeyDto).then(
                function(answer){
                    var policyDto = answer.data;
                    var riskCode = answer.data.prpCmainDto.riskCode;
                    reportProposalServ.moduleInit().then(
                        function (answer) {
                            $scope.riskList = answer.data.riskConfig[riskCode];
                            $scope.policyDto = policyDto;
                            $scope.subsidyTypeName = $scope.policyDto.subsidyTypeName;
                            $scope.subsidyList = $scope.policyDto.prpCSubsidyDtos;
                            $scope.planDtos = $scope.policyDto.prpCplanDtos;
                            if ($scope.policyDto.subsidyType == '' || $scope.policyDto.subsidyType == undefined) {
                                $scope.subsidyFlag = false;
                                return;
                            }else{
                                $scope.subsidyFlag = true;
                            }
                        },function(error){
                            //cconsole.log(JSON.stringify(error.data));
                        }
                    );
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
            var getReportEndorseList = function(){
                var InsuredFuzzyQueryConditionDto = {};
                InsuredFuzzyQueryConditionDto.applyNo= applyNo;
                InsuredFuzzyQueryConditionDto.pageNo=$scope.reportPaginationConf.currentPage;
                InsuredFuzzyQueryConditionDto.pageSize=$scope.reportPaginationConf.itemsPerPage;
                InsuredFuzzyQueryConditionDto.insuredName=$scope.insuredName;
                InsuredFuzzyQueryConditionDto.address=$scope.address;
                InsuredFuzzyQueryConditionDto.identifyNumber=$scope.idNum;
                $scope.applyNo=applyNo;
                reportEndorseServ.queryReportEndorseTranPolicy(InsuredFuzzyQueryConditionDto).then(
                    function(answer){
                        var reportInsuredSwitch= answer.data;
                        $scope.reportInsuredSwitch= reportInsuredSwitch.list;
                        $scope.queryEndorseTempTotalItems = reportInsuredSwitch.totalCount;
                        //$scope.reportPaginationConf.pageNo = answer.data.pageNum;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            };
            var getReportList = function(){
                //初始化分页
                $scope.reportPaginationConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                    //onChange: getInsuredList
                };
                $scope.proposalInfoDto = {pageNo:$scope.reportPaginationConf.currentPage,
                    pageSize:$scope.reportPaginationConf.itemsPerPage};
                $scope.$watch('reportPaginationConf.currentPage + reportPaginationConf.itemsPerPage', getReportEndorseList);
            };
            getReportList();
        }
        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        }
    };

    moduleApp.controller('reportEndorseCtrl',['$scope','$sce','$state','reportEndorseServ','reportProposalServ','$stateParams',reportEndorseCtrl]);
});
