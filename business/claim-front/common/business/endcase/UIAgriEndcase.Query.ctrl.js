/**
 * DESC       : 国元农险理赔结案任务查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIAgriEndcaseQueryCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$filter','regexpConstants',
        function ($rootScope, $scope, $location, $state, $$finder,$filter,regexpConstants) {


            /**
             * 重置
             */
            // $scope.resetBack = function () {
            //     init();
            // };
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20, 50 ],
                    onChange : function () {//值回调
                        getFileList($scope.paginationConf);
                    }
                };
            };
            initPage();
            /*分页查询*/
            var getFileList = function(data){
                // $scope.requestQueryEndCaseDto.policyNo="";
                // $scope.requestQueryEndCaseDto.registNo="";
                // $scope.requestQueryEndCaseDto.claimNo="";
                // $scope.requestQueryEndCaseDto.insuredName="";
                // $scope.requestQueryEndCaseDto.handlerCode="";
                // $scope.requestQueryEndCaseDto.flowInStartDate="2016-12-20";
                // $scope.requestQueryEndCaseDto.flowInEndDate="2017-12-25";
                var dto = angular.copy($scope.requestQueryEndCaseDto);
                if (data == null || data == undefined){
                    dto.pageNo=1;
                    $scope.paginationConf.currentPage=1;
                }
                $scope.requestQueryEndCaseDto.nodeType="endca";
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                // console.log($scope.paginationConf.currentPage);
                //提交查询
                console.log(dto.flowInEndDate)
                if(dto.flowInEndDate){
                    dto.flowInEndDate=dto.flowInEndDate+" 23:59:59";
                }
                if($scope.requestQueryEndCaseDto.flowInStartDate&&!$scope.requestQueryEndCaseDto.flowInEndDate){
                    dto.flowInEndDate=$filter('date')(new Date(),'yyyy-MM-dd')
                }

                console.log("以下是结案登记列表查询的报案登记")
                console.log(dto)
                dto.userCode = $rootScope.user.userCode;
                $$finder.post('queryEndCaseByCondition', dto).then(
                    function (data) {
                        console.log('以下是结案的查询结果')
                        console.log(data);
                        if(data != null) {
                            $scope.responseQueryEndCaseDtoList = data.responseQueryEndCaseDtoList;
                            $scope.paginationConf.totalItems = data.totalCount;
                        }
                        if (data.code==='9999'){
                            $scope.responseQueryEndCaseDtoList=[];
                        }
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.requestQueryEndCaseDto.policyNo || $scope.requestQueryEndCaseDto.registNo|| $scope.requestQueryEndCaseDto.claimNo ) {
                    $scope.requestQueryEndCaseDto.flowInEndDate = "";
                    $scope.requestQueryEndCaseDto.flowInStartDate = "";
                } else {
                    $scope.requestQueryEndCaseDto.flowInEndDate =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.requestQueryEndCaseDto.flowInStartDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }

            }
            $scope.query = function () {

              /*  // 通用规则 查询条件输入业务号(保单号,报案号,立案号)，清空默认时间
                if($scope.requestQueryEndCaseDto.policyNo||$scope.requestQueryEndCaseDto.claimNo||$scope.requestQueryEndCaseDto.registNo){
                    $scope.requestQueryEndCaseDto.flowInStartDate = "";
                    $scope.requestQueryEndCaseDto.flowInEndDate = "";
                }*/
                //判断查询条件是否为空校验
                var querySpecialflag = false;
                //循环遍历表单下节点
                for(var i=0;i<document.myForm.elements.length-1;i++)
                {
                    if(document.myForm.elements[i].value!=""&&document.myForm.elements[i].value!="?"&&document.myForm.elements[i].value!="0")
                    {
                        querySpecialflag = true;
                    }
                }
                if($scope.requestQueryEndCaseDto.riskClaimType&&$scope.requestQueryEndCaseDto.state){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
                if(!$scope.requestQueryEndCaseDto.flowInStartDate&&$scope.requestQueryEndCaseDto.flowInEndDate){
                    layerMsg("请输入流入时间起期！");
                    return;
                }
                if ($scope.myForm.$valid) {
                    // 通用规则 用户输入业务号 系统自动清空默认时间
                 /*   if($scope.requestQueryEndCaseDto.policyNo||$scope.requestQueryEndCaseDto.registNo||$scope.requestQueryEndCaseDto.claimNo){
                        $scope.requestQueryEndCaseDto.flowInTimeStart = "";
                        $scope.requestQueryEndCaseDto.flowInTimeEnd = "";
                    }*/
                    getFileList();
                }
            };

            $scope.goRegistSee = function (result,editType) {
                $state.go('UIAgriRegist',
                    {
                        registNo:result.registNo,
                        policyNo:result.policyNo,
                        riskCode:result.riskCode,
                        editType:"SHOW"
                    });
            };

            $scope.goEndcaseSee = function (result,edit) {
                var target = {
                    registNo:result.registNo,
                    policyNo:result.policyNo ,
                    claimNo:result.claimNo,
                    edit:edit
                };
                $state.go('UIAgriEndcaseSee',{endcaseSee:JSON.stringify(target)});
            };

            /**
             * 初始化
             */
            var init = function () {
                $scope.regData = regexpConstants;// 本页面使用正则的集合
                $scope.responseQueryEndCaseDtoList = null;
                $scope.requestQueryEndCaseDto={
                    policyNo:'',
                    registNo:'',
                    claimNo:'',
                    insuredName:'',
                    flowInStartDate:'',
                    flowInEndDate:'',
                    riskClaimType:'',
                    state:''
                };
                var curDate = new Date();
                $scope.requestQueryEndCaseDto.flowInEndDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                curDate.setDate(1);
                $scope.requestQueryEndCaseDto.flowInStartDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号
            };
            init();
        }]);

});