/**
 * DESC       : 国元农险理赔特殊赔案任务查询页面
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
    app.registerController('UIAgriPrepayApplyQueryCtrl', ['$rootScope', '$scope', '$location', '$state','$$finder','$filter','regexpConstants','$$commonality',
        function ($rootScope, $scope, $location,$state, $$finder,$filter, regexpConstants,$$commonality) {
            $scope.PrpLSpeciQueryInDto = {}; // 查询条件
            $scope.SwfLogExtendDto = null; // 查询结果
            $scope.regData = regexpConstants;// 本页面使用正则的集合
            $scope.checkedList = []; // 本页面选中的集合
            $scope.codeListData ={};
            var curDate = new Date();
           // $scope.PrpLSpeciQueryInDto.riskType = "all";
            $scope.PrpLSpeciQueryInDto.riskCode = "";

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [ 5 ,10, 20 ,50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
                $scope.PrpLSpeciQueryInDto.riskType = "";
            };
            initPage();
            // 下拉框初始化
            var getRiskCodeList = function (riskType) {
                /*var _data = {
                    "casecadeConditionList": [
                        {
                            "name": "riskType",
                            "value": riskType
                        }
                    ],
                    "initlist": [
                        {
                            "codeType": "AllRisk",
                            "riskCode": $scope.PrpLSpeciQueryInDto.riskCode
                        }
                    ]
                };
                $$finder.post("baseCode", _data).then(function (data) {
                    angular.forEach(data.data,function(item,index) {
                        item.resultobj.action_result.unshift({
                            codecode:"all",
                            codecname:"全部险种"
                        });
                        $scope.codeListData[item.codeType] = item.resultobj.action_result;
                    })
                },function (error) {

                });*/
                var dto = {
                    "riskType": riskType
                };
                $$finder.post('queryRisk', dto).then(
                    function (data) {
                        $scope.codeListData.AllRisk=data;
                    }
                )
            } ;
            getRiskCodeList('all');
            /*getRiskCodeList('');
            $scope.getRiskCodeList =function () {
                if($scope.PrpLSpeciQueryInDto.riskType == 'all'){var s =''}else {s=$scope.PrpLSpeciQueryInDto.riskType}
                getRiskCodeList(s)
            };*/

            $scope.getRiskCodeList = function () {
                var dto = {
                    "riskType": $scope.PrpLSpeciQueryInDto.riskType,
                };
                $$finder.post('queryRisk', dto).then(
                    function (data) {
                        $scope.codeListData.AllRisk=data;
                    }
                )
            };

            /*分页查询*/
            var getFileList = function(){
                $scope.PrpLSpeciQueryInDto.handlerCode=$scope.user.userCode;
                $scope.PrpLSpeciQueryInDto.nodeType="speci";
                var dto = angular.copy($scope.PrpLSpeciQueryInDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryByTurnSpeciIn', dto).then(
                    function (data) {
                        console.log(data);
                        $scope.SwfLogExtendDto = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };
            $scope.query = function () {
                //上来默认是不选险种大类的,此时默认的查询条件就是全部险种
                if ($scope.PrpLSpeciQueryInDto.riskType == '' || $scope.PrpLSpeciQueryInDto.riskType == undefined){
                    $scope.PrpLSpeciQueryInDto.riskType ='all';
                }
                var querySpecialflag = $$commonality.inspectEmpty('agriPrepayFrom');
                if($scope.PrpLSpeciQueryInDto.riskType || $scope.PrpLSpeciQueryInDto.riskCode){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }

                //if ($scope.agriPrepayFrom.$valid) {
                    getFileList();
                //}
                //查询完后为了避免下拉框无法匹配'all'的问题,将all再设置为'';
                if ($scope.PrpLSpeciQueryInDto.riskType == 'all'){
                    $scope.PrpLSpeciQueryInDto.riskType =''
                }

            };
            //申请跳转页面
            $scope.goPrepayAdd = function (result) {
                goApply(result, "ADD")
            };
            //查看跳转页面
            $scope.goPrepaySee = function (result) {
                goApply(result, "SHOW")
            };

            $scope.seeRegist = function (result) {
                $state.go('UIAgriRegist', {
                    editType: "SHOW",
                    policyNo: result.swfLogDto.policyNo,
                    registNo: result.swfLogDto.registNo,
                    riskCode: result.swfLogDto.riskCode
                })
            };
            var goApply=function(result,edit){
                $state.go('UIAgriPrepayApply',{
                    editType: edit,
                    riskCode:result.swfLogDto.riskCode,
                    claimNo:result.claimNo,
                    nodeType:"speci",
                    logNo:result.swfLogDto.logNo,
                    flowId:result.swfLogDto.flowId,
                    nodeStatus:result.swfLogDto.nodeStatus
                })
            };

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

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);
});