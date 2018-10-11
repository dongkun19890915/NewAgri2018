/**
 * DESC       : 国元农险理赔  流程查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *         zhaowenjie        2017.12.7          流程查询控制器
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIAgriFlowQueryCtrl', ['$rootScope', '$scope', '$location', '$state', '$$finder','regexpConstants','$filter',
        function ($rootScope, $scope, $location, $state, $$finder, regexpConstants,$filter) {
            $scope.flowQueryDto = {};//查询条件
            $scope.flowQueryDto = {
                "policyNo":"", //保单号码
                "registNo":"", //报案号
                "claimNo":"", //立案号
                "compensateNo":"", //赔款计算书号
                "caseNo":"", //结案号
            }
            var curDate = new Date();
            $scope.flowQueryDto.outTime = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.flowQueryDto.inTime = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号
            ;//查询条件
            // var initFun = function () {
                // $scope.flowQueryDto.classCode="all"; // 险种大类默认全部
            // };
            // initFun();
            $scope.flowList = null;
            $scope.regData = regexpConstants;
            var initPage = function () {
                $scope.paginationConf = {
                    currentPage: 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage: 20, // 每页展示的数据条数
                    perPageOptions: [5,10, 20, 50],
                    onChange: function () {//值回调
                        getFileList();
                    }
                };
            };
            initPage();
            /*分页查询*/
            var getFileList = function () {
                var dto = angular.copy($scope.flowQueryDto);
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                if($scope.flowQueryDto.outTime){
                    dto.outTime=$scope.flowQueryDto.outTime+" 23:59:59";
                }
                if($scope.flowQueryDto.inTime&&!$scope.flowQueryDto.outTime){
                    dto.outTime=$filter("date")(new Date(),"yyyy-MM-dd")+" 23:59:59";
                }
                //提交查询

                $$finder.post('queryWorkProcessByConditions', dto).then(
                    function (data) {
                        console.log(data.totalCount);
                        console.log(data.content);
                        console.log(data);
                        $scope.flowList = data.content;
                        $scope.paginationConf.totalItems = data.totalCount || 0;

                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                debugger;
                if ($scope.flowQueryDto.policyNo || $scope.flowQueryDto.registNo||$scope.flowQueryDto.claimNo|| $scope.flowQueryDto.compensateNo ||$scope.flowQueryDto.caseNo) {
                    $scope.flowQueryDto.inTime = "";
                    $scope.flowQueryDto.outTime = "";
                } else {

                    $scope.flowQueryDto.outTime =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.flowQueryDto.inTime =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            }

            $scope.query = function () {
                var flag = false;
                /*angular.forEach($scope.flowQueryDto, function(value, key) {
                    // if(key!='modelStatus'){
                    if(value){
                        flag = true
                    }
                    // }
                });*/
                if ($scope.flowQueryDto.classCode == undefined || $scope.flowQueryDto.classCode == ''){
                    $scope.flowQueryDto.classCode = 'all';
                }
                if($scope.flowQueryDto.policyNo!=""||$scope.flowQueryDto.registNo!=""||$scope.flowQueryDto.claimNo!="" ||
                $scope.flowQueryDto.compensateNo!=""||$scope.flowQueryDto.caseNo!=""||$scope.flowQueryDto.classCode!=null||$scope.flowQueryDto.caseType!=null){
                    flag = true;
                }
                if(!flag){layerMsg("请至少输入一个查询条件！");return}
                if($scope.flowQueryDto.outTime&&!$scope.flowQueryDto.inTime){
                    layerMsg("请输入流入时间起期！");
                    return;
                }
                if ($scope.FlowQueryForm.$valid) {
                    if ( $scope.flowQueryDto.classCode == 'all'){
                        $scope.flowQueryDto.classCode = '';
                    }
                    getFileList();
                } else {
                    FormFocus.focusEle('FlowQueryForm')
                }
            };

            $scope.goFlowSee = function (item) {
                $state.go('UIAgriFlowSee', {registNo: item.registNo})
            }
            // 重置
            $scope.reset = function() {
                $scope.flowQueryDto = {};
                $scope.flowList = null;
                $scope.paginationConf.totalItems = 0;
            }
        }]);


});