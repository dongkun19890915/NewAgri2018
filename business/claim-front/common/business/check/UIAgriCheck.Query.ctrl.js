/**
 * DESC       : 国元农险理赔查勘定损任务查询页面
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
    app.registerController('UIAgriCheckQueryCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants', '$state','$filter','$$commonality',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state,$filter,$$commonality) {
            $scope.PrpLCheckQueryInDto = {}; // 查询条件
            // $scope.regData = {}; // 本页面使用正则的集合
            // $scope.regData.hour = regexpConstants.hour;
            $scope.SwfLogExtendDto = null; // 查询结果
            $scope.checkedList = []; // 本页面选中的集合
            $scope.regData = regexpConstants;
            $scope.PrpLCheckQueryInDto.nodeStatus="all";
            var curDate = new Date();
            $scope.PrpLCheckQueryInDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.PrpLCheckQueryInDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [ 5,10, 20, 50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                //$scope.PrpLCheckQueryInDto.handlerCode="0000000000";
                $scope.PrpLCheckQueryInDto.handlerCode=$rootScope.user.userCode;
                var dto = angular.copy($scope.PrpLCheckQueryInDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                if($scope.PrpLCheckQueryInDto.flowInTimeStart &&!$scope.PrpLCheckQueryInDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$filter('date')(new Date(),'yyyy-MM-dd')
                }
                //提交查询
                if (dto.riskType == '' || dto.riskType == undefined){
                    dto.riskType = 'all';
                }
                $$finder.post('queryByCheckIn', dto).then(
                    function (data) {
                        console.log(data);
                        $scope.SwfLogExtendDto = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                        console.log($scope.SwfLogExtendDto)

                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.PrpLCheckQueryInDto.registNo || $scope.PrpLCheckQueryInDto.policyNo ) {
                    $scope.PrpLCheckQueryInDto.flowInTimeEnd = "";
                    $scope.PrpLCheckQueryInDto.flowInTimeStart = "";
                } else {
                    $scope.PrpLCheckQueryInDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.PrpLCheckQueryInDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }

            }

            $scope.query = function () {
                if ($scope.PrpLCheckQueryInDto.riskType == '' || $scope.PrpLCheckQueryInDto.riskType == undefined){
                    $scope.PrpLCheckQueryInDto.riskType = 'all';
                }
                var querySpecialflag = $$commonality.inspectEmpty('agriCheckfrom');

                if($scope.PrpLCheckQueryInDto.nodeStatus || $scope.PrpLCheckQueryInDto.riskType){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
                if(!$scope.PrpLCheckQueryInDto.flowInTimeStart && $scope.PrpLCheckQueryInDto.flowInTimeEnd){
                    layerMsg("请输入流入时间起期！");
                    return;
                }

                if($scope.agriCheckfrom.$valid){
                    // console.log($scope.registQueryForm);
                    // if ($scope.registQueryForm.$valid) { // 校验通过
                    // 通用规则 查询条件输入业务号，清空默认时间
                   /* if($scope.PrpLCheckQueryInDto.policyNo||$scope.PrpLCheckQueryInDto.registNo){
                        $scope.PrpLCheckQueryInDto.flowInTimeStart = "";
                        $scope.PrpLCheckQueryInDto.flowInTimeEnd = "";
                    }*/
                    if ($scope.PrpLCheckQueryInDto.riskType== 'all') {
                        $scope.PrpLCheckQueryInDto.riskType = '';
                    }
                    getFileList();
                    // } else { // 校验未通过
                    //
                    // }
                }

            };
            //超链接跳转到报案信息页面
            $scope.goRegist = function (result) {
                $state.go('UIAgriRegist', {
                    editType: "SHOW",
                    policyNo: result.swfLogDto.policyNo,
                    registNo: result.swfLogDto.registNo,
                    riskCode: result.swfLogDto.riskCode
                })
            };

            //查看定损跳转页面
            $scope.check = function (item) {
                go(item, "ADD")
            };
            //修改按钮跳转页面
            $scope.edit = function (item) {
                go(item, "EDIT")
            };
            //查看跳转页面
            $scope.show = function (item) {
                go(item, "SHOW")
            };
            var go =  function (item,edit){

                console.log(item.swfLogDto.flowId);
                $state.go("UIAgriCheck",
                    {
                        editType: edit,
                        riskCode: item.riskCode,
                        registNo:item.swfLogDto.registNo,
                        flowId: item.swfLogDto.flowId,
                        logNo: item.swfLogDto.logNo,
                        checkNo: item.swfLogDto.businessNo
                    }
                )
            }
            //转交跳转页面
            $scope.turnTask = function () {
                debugger;
                var data = [];
                var isCheck = true;
                angular.forEach($scope.checkedList, function (item) {
                    isCheck = (item.swfLogDto.nodeStatus == 0 || item.swfLogDto.nodeStatus == 2);
                    console.log(isCheck);
                    if (!isCheck){
                        layerMsg("案件状态必须为未处理或正在处理！");
                        return;
                    }
                    var obj = {};
                    obj.swfLogFlowID = item.swfLogDto.flowId;
                    obj.swfLogLogNo = item.swfLogDto.logNo;
                    obj. riskCode= item.swfLogDto.riskCode;
                    obj.registNo=item.swfLogDto.registNo;
                    obj.policyNO=item.swfLogDto.policyNo;
                    obj.insuredName=item.swfLogDto.insuredName;
                    obj.lossName=item.lossName;
                    obj.flowTime=item.swfLogDto.flowInTime;
                    data.push(obj);
                });
                if (isCheck) {
                    $state.go('UIAgriClaimTransfer', {data: JSON.stringify(data)})
                }else{
                    layerMsg("案件状态必须为未处理或正在处理！");
                }
            };

        }]);
});