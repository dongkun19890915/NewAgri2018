/**
 * DESC       : 国元农险理赔班表管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.30
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                         调度任务页面控制器搭建
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriRecaseCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','$filter','$$commonality','regexpConstants',
        function ($rootScope, $scope, $location,$state, $$finder,$filter,$$commonality,regexpConstants) {

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [ 5, 10, 20, 50 ],
                    onChange : function () {//值回调
                        getFileList();
                    }
                };
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryReCaseByReCaseDto', dto).then(
                    function (data) {
                        if (data.code == '9999'){
                            layerMsg(data.message);
                        }
                        console.log(data);
                        $scope.recaseList = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                        // console.log($scope.paginationConf.totalItems)
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.queryDto.registNo || $scope.queryDto.policyNo||$scope.queryDto.claimNo ) {
                    $scope.queryDto.flowInTimeDown = "";
                    $scope.queryDto.flowInTimeUp = "";
                } else {
                    $scope.queryDto.flowInTimeUp =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.queryDto.flowInTimeDown =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            }
            $scope.query = function () {
                var querySpecialflag = $$commonality.inspectEmpty('agriRecaseFrom');
                //if($scope.queryDto.undwrtFlag || $scope.queryDto.riskClaimType){
                if( !$scope.queryDto.riskClaimType && !$scope.queryDto.registNo && !$scope.queryDto.flowInTimeDown&& !$scope.queryDto.flowInTimeUp&&!$scope.queryDto.claimNo&&(!$scope.queryDto.undwrtFlag&&$scope.queryDto.undwrtFlag!=null)){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
               /* if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
*/
                if ($scope.agriRecaseFrom.$valid) {
                    // if($scope.queryDto.policyNo){
                    //
                    // }

                  /*  if($scope.queryDto.policyNo||$scope.queryDto.registNo||$scope.queryDto.claimNo){
                        $scope.queryDto.flowInTimeDown = "";
                        $scope.queryDto.flowInTimeUp = "";
                    }*/
                    getFileList();
                }

            };





            // $scope.goRecaseAdd = function () {
            //     console.log(33334)
            //     $state.go('UIAgriRecaseAdd',{state:'regist'})
            // }

            // var go =  function (caseType){
            //     $state.go("UIAgriRecaseSee", {caseType: caseType})
            // }

            $scope.goRecaseApply1 =function(result){
                $state.go('UIAgriRegist', {
                    editType: "SHOW",
                    policyNo: result.policyNo,
                    registNo: result.registNo,
                    riskCode: result.registNo.substring(1,5)
                })
            }; // 申请

            $scope.goRecaseSee =function(codecode){
                go(codecode,"1")
            }; // 查看
            $scope.goRecaseEdit =function(codecode){
                go(codecode,"3")
            }; // 修改
            $scope.goRecaseApply =function(codecode){
                go(codecode,"2")
            }; // 申请
            var go =  function (result,claimNo){
                if(claimNo == '3'){
                    $state.go("UIAgriRecaseAuditoption",
                        {
                            claimNo:result.claimNo
                        }
                    )
                }
                if (claimNo == '1'){
                    $state.go("UIAgriRecaseSee",
                        {
                            claimNo:result.claimNo
                        }
                    )
                }
                if (claimNo == '2'){
                    $state.go("UIAgriRecaseAdd",
                        {
                            claimNo:result.claimNo
                        });
                }
            };


            /**
             * 重置
             */
            // $scope.resetQuery = function () {
            //     init();
            // };

            /**
             * 初始化
             */
            var init = function () {
                $scope.regData = regexpConstants;// 本页面使用正则的集合
                $scope.queryDto = {};//查询条件

                $scope.queryDto = {
                    "policyNo":"",
                    "registNo":"",
                    "claimNo":"",
                    "insuredName":"",
                    "flowInTimeDown":"",
                    "flowInTimeUp":"",
                    "riskClaimType":"",
                    "undwrtFlag":""
                };
                //初始化保险大类默认全部
                // $scope.queryDto.riskClaimType='all';
                $scope.recaseList = null;
                var curDate = new Date();
                $scope.queryDto.flowInTimeUp= $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                curDate.setDate(1);
                $scope.queryDto.flowInTimeDown = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
            init();
            // $scope.goDispatchReassignment = function () {
            //     console.log(44444)
            //     $state.go('UIAgriDispatchReassignment')
            // }

            // $scope.goRegist = function () {
            //     $state.go('UIAgriRegist',{state:'regist'})
            // }
        }]);
});