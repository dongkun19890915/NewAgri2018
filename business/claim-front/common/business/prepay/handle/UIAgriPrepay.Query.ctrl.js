/**
 * DESC       : 国元农险理赔特殊赔案处理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */


define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPrepayHandleQueryCtrl', ['$rootScope', '$scope', '$location', '$filter', '$$finder','$stateParams','regexpConstants','$state','$$commonality',
        function ($rootScope, $scope, $location, $filter, $$finder,$stateParams, regexpConstants,$state,$$commonality) {
            $scope.checkedList = []; // 本页面选中的集合
            //处理跳转页面
            $scope.go = function(result,editType){
                result.editType = editType;
                $state.go(
                    'UIAgriPrepayHandle',{
                        editType:       editType,
                        claimNo:        result.claimNo,
                        prepayNo:       result.swfLogDto.keyOut,
                        flowID:         result.swfLogDto.flowId,
                        logNo:          result.swfLogDto.logNo,
                        modelNo:        result.modelNo,
                        nodeNo:         result.nodeNo
                    }
                )
            };

            $scope.getRiskCodeList = function () {
                var dto = {
                    "riskType": $scope.PrpLSpeciQueryInDto.riskType
                };
                $$finder.post('queryRisk', dto).then(
                    function (data) {
                        $scope.codeListData.AllRisk=data;
                    }
                )
            };
            /**
             * 查看报案信息
             */
            $scope.seeRegist = function (result) {
                $state.go('UIAgriRegist', {
                    editType: "SHOW",
                    policyNo: result.swfLogDto.policyNo,
                    registNo: result.swfLogDto.registNo,
                    riskCode: result.swfLogDto.riskCode
                })
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.PrpLSpeciQueryInDto.registNo || $scope.PrpLSpeciQueryInDto.policyNo || $scope.PrpLSpeciQueryInDto.claimNo || $scope.PrpLSpeciQueryInDto.businessNo) {
                    $scope.PrpLSpeciQueryInDto.flowInTimeEnd = "";
                    $scope.PrpLSpeciQueryInDto.flowInTimeStart = "";
                } else {
                    $scope.PrpLSpeciQueryInDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.PrpLSpeciQueryInDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            };

            /**registNo  policyNo claimNo  businessNo
             * 查询
             * @returns {boolean}
             */
            $scope.query =function(){ //点击查询调用
                if ($scope.PrpLSpeciQueryInDto.riskType == undefined || $scope.PrpLSpeciQueryInDto.riskType ==''){
                    $scope.PrpLSpeciQueryInDto.riskType = 'all';
                }
                var querySpecialflag = $$commonality.inspectEmpty('agriPrepayFrom');
                if($scope.PrpLSpeciQueryInDto.riskType || $scope.PrpLSpeciQueryInDto.riskCode || $scope.PrpLSpeciQueryInDto.nodeStatus){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
                if(!$scope.PrpLSpeciQueryInDto.flowInTimeStart && $scope.PrpLSpeciQueryInDto.flowInTimeEnd){
                    layerMsg("请输入申请时间起期！");
                    return;
                }

                    getFileList();
                $scope.PrpLSpeciQueryInDto.riskType = '';

            };

            /**
             * 分页查询
             */
            var getFileList = function() {
                $scope.PrpLSpeciQueryInDto.handlerCode = $scope.user.userCode;
                $scope.PrpLSpeciQueryInDto.nodeType = "speci";
                var dto = angular.copy($scope.PrpLSpeciQueryInDto);
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                if($scope.PrpLSpeciQueryInDto.flowInTimeStart&&!$scope.PrpLSpeciQueryInDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$filter('date')(new Date(),'yyyy-MM-dd');
                }

                $$finder.post('queryBySpeciIn', dto).then(
                    function (data) {
                        console.log(data);
                        $scope.SwfLogExtendDto = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

            /**
             * 分页初始化
             */
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20, 50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
                $scope.PrpLSpeciQueryInDto.riskType = '';
            };

            /**
             * 下拉域初始化
             * @param riskType
             */
            var getRiskCodeList = function (riskType) {
                var dto = {
                    "riskType": riskType
                };
                $$finder.post('queryRisk', dto).then(
                    function (data) {
                        $scope.codeListData.AllRisk=data;
                    }
                )
            } ;

            /**
             * 初始化
             */
            var init = function () {
                $scope.PrpLSpeciQueryInDto = {};//查询条件
                $scope.SwfLogExtendDto={};//返回查询结果
                $scope.codeListData ={};
                $scope.regData = regexpConstants; // 本页面使用正则的集合
               // $scope.PrpLSpeciQueryInDto.riskType="all";
                $scope.PrpLSpeciQueryInDto.nodeStatus="all";
                var curDate = new Date();
                $scope.PrpLSpeciQueryInDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                curDate.setDate(1);
                $scope.PrpLSpeciQueryInDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号
                initPage();
                getRiskCodeList('all');
            };
            init();
            //转交跳转页面
            $scope.goTransfer = function () {
                var data = [];
                angular.forEach($scope.checkedList, function (item) {
                    var obj = {};
                    obj.swfLogFlowID = item.swfLogDto.flowId;
                    obj.swfLogLogNo = item.swfLogDto.logNo;
                    obj.state=$location.path().replace(/\//,'')
                    data.push(obj);
                });
                $state.go('UIAgriClaimTransfer', {data: JSON.stringify(data)})
            };

        }]);

});