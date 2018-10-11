/**
 * DESC       : 国元农险理赔立案任务查询页面
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
    app.registerController('UIAgriClaimQueryCtrl', ['$rootScope', '$scope', '$location','$filter', '$$finder','regexpConstants','$state','$$commonality',
        function ($rootScope, $scope, $location, $filter, $$finder, regexpConstants, $state,$$commonality) {
            $scope.requestDto = {}; // 查询条件
            // $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData = regexpConstants;
            $scope.prpLregist = null; // 查询结果
            $scope.checkedList=[]; // 页面checkBox选中的集合
            $scope.requestDto.nodeStatus="all";
            var curDate = new Date();
            $scope.requestDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.requestDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

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
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.requestDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                dto.handlerCode=$rootScope.user.userCode;
                dto.nodeType='claim';
                if($scope.requestDto.flowInTimeStart&&!$scope.requestDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$filter('date')(new Date(),'yyyy-MM-dd')
                }
                //提交查询
                if (dto.riskType == '' || dto.riskType == undefined){
                    dto.riskType = 'all'
                }
                if(dto.nodeStatus==''||dto.nodeStatus==undefined){
                    dto.nodeStatus='all'
                }
                $$finder.post('queryByClaimIn', dto).then(
                    function (data) {
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };
            $scope.changeendorseNo= function (str) {
                if ($scope.requestDto.registNo || $scope.requestDto.policyNo||$scope.requestDto.claimNo) {
                    $scope.requestDto.flowInTimeEnd = "";
                    $scope.requestDto.flowInTimeStart = "";
                } else {
                    $scope.requestDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.requestDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }

            }

            $scope.query = function () {
                var querySpecialflag = $$commonality.inspectEmpty('agriClaimFrom');//
                if($scope.requestDto.riskType || $scope.requestDto.nodeStatus){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }

                if(!$scope.requestDto.flowInTimeStart && $scope.requestDto.flowInTimeEnd){
                    layerMsg("请输入流入时间起期！");
                    return;
                }
                console.log($scope.registQueryForm);
                if ($scope.agriClaimFrom.$valid) { // 校验通过
                    // 通用规则 查询条件输入业务号，清空默认时间
                  /*  if($scope.requestDto.policyNo||$scope.requestDto.registNo||$scope.requestDto.claimNo){
                        $scope.requestDto.flowInTimeStart = "";
                        $scope.requestDto.flowInTimeEnd = "";
                    }*/
			        getFileList();
                }
            };

            // 跳转立案任务查询---转交页面
            $scope.goTransfer = function () {
                debugger;
                var list = [];
                var isCheck = true;
                angular.forEach($scope.checkedList,function(result){
                    isCheck = (result.swfLogDto.nodeStatus == 0);
                    var obj = {};
                    if (!isCheck){
                        layerMsg("案件状态必须为未处理！");
                        return;
                    }
                    obj.swfLogFlowID = result.swfLogDto.flowId;
                    obj.swfLogLogNo = result.swfLogDto.logNo;
                    obj. riskCode= result.swfLogDto.riskCode;
                    obj.registNo=result.swfLogDto.registNo;
                    obj.policyNO=result.swfLogDto.policyNo;
                    obj.insuredName=result.swfLogDto.insuredName;
                    obj.lossName=result.lossName;
                    obj.flowTime=result.swfLogDto.flowInTime;
                     //转交页面初始化接口入参对象
                    list.push(obj);
                });
                if (isCheck) {
                    $state.go("UIAgriClaimTransfer",{data:JSON.stringify(list)});
                }else{
                    layerMsg("案件状态必须为未处理！");
                }
            };
            // 跳转立案任务查询---申请注销/拒赔页面
            $scope.goReject = function () {
                var swfLogDtoList = [];
                var resultShow = {};
                var check = true;
                var flag=true;
                var claimNo="";
                angular.forEach($scope.checkedList,function(result){
                    if(result.swfLogDto.nodeType=='cance'){
                        result.swfLogDto.nodeStatus='8'
                    }
                    check = (result.swfLogDto.nodeStatus == 4);
                    flag=(result.swfLogDto.nodeStatus!=8);
                    if(!flag){
                        //layerMsg("立案号:"+result.claimNo+"已注销/拒赔！");
                        claimNo=result.claimNo;
                        return ;
                    }
                    if (!check){
                        //layerMsg("案件状态必须为已处理！");
                        return;
                    }
                    if(result.checked){
                        var ClaimCancelDto = {};
                        ClaimCancelDto.editType='CANCEL';
                        ClaimCancelDto.nodeType = 'claim';
                        ClaimCancelDto.prpLclaimCancelClaimNo = result.claimNo;//立案号
                        ClaimCancelDto.registNo = result.swfLogDto.registNo || '';//报案号
                        ClaimCancelDto.swfLogFlowID = result.swfLogDto.flowId;
                        ClaimCancelDto.swfLogLogNo = result.swfLogDto.logNo;
                        //转交页面初始化接口入参对象
                        swfLogDtoList.push(ClaimCancelDto);
                    }
                });
                // swfLogDtoList = [{
                //     "editType":"CANCEL",
                //     "prpLclaimCancelClaimNo":"531013401232017000002",
                //     "registNo":"431013401232017000002",
                //     "nodeType":"claim",
                //     "BZFlag":""
                //
                //
                // }];
                if (flag) {
                    if(check){
                        $state.go("UIAgriClaimReject",{data:JSON.stringify(swfLogDtoList)});
                    }else{
                        layerMsg("案件状态必须为已处理！");
                    }
                }else{
                    layerMsg("立案号:"+claimNo+"已注销/拒赔！");
                }
            };
            // 跳转立案任务查询---立案录入页面
            $scope.goRisk = function (result) {
                $state.go("UIAgriClaimHandle",{editType: 'ADD',riskCode:result.riskCode,registNo:result.registNo,flowId:result.flowId,logNo:result.logNo,policyNo:result.policyNo}); // 01种植险，02养殖险
            };
            // 跳转立案任务查询---查看页面
            $scope.goShow = function (item) {
                $state.go("UIAgriClaimSee",{editType: 'SHOW',claimNo:item.claimNo,riskCode:item.swfLogDto.riskCode,policyNo:item.swfLogDto.policyNo,flowId:item.swfLogDto.flowId,registNo:item.swfLogDto.registNo});
            };
            // 跳转报案查看页面
            $scope.goRegist = function (item) {
                $state.go("UIAgriRegist",{editType: 'SHOW',registNo:item.registNo,riskCode:item.riskCode,policyNo:item.policyNo});
            };
            // 调整估损金额弹层
            $scope.openAssLossLayer = function (item) {
                item.editType = "EDIT";
                $scope.$broadcast("SendAssLossLayerSwitch",item);
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
        }]);
});