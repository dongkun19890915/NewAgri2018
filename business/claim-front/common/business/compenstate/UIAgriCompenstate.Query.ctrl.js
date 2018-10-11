/**
 * DESC       : 国元农险理赔理算任务查询页面
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
    app.registerController('UIAgriCompenstateQueryCtrl', ['$rootScope', '$scope','$filter','$state', '$location', '$$finder','regexpConstants','$$commonality',
        function ($rootScope, $scope, $filter, $state, $location, $$finder, regexpConstants,$$commonality) {
            $scope.queryDto = {}; // 查询条件
            $scope.queryDto.nodeStatus = "all"; // 案件状态默认全部
            var curDate = new Date();
            $scope.queryDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.queryDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号
            $scope.checkFlag = true;
            $scope.regData = regexpConstants;
            $scope.checkedList=[]; // 页面checkBox选中的集合
            // $scope.regData = {}; // 本页面使用正则的集合
            // $scope.regData.hour = regexpConstants.hour;
            $scope.prpLregist = null; // 查询结果
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20 ,50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                dto.handlerCode = $scope.user.userCode;
                dto.nodeType = "compe";
                if($scope.queryDto.flowInTimeStart&&!$scope.queryDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$filter('date')(new Date(),'yyyy-MM-dd');
                }
                //提交查询
                if (dto.riskType == '' || dto.riskType == undefined){
                    dto.riskType = 'all';
                }
                $$finder.post('queryByCompeIn', dto).then(

                    function (data) {
                        console.log("以下是立案的列表查询结果============================== ")
                        console.log(data);
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;

                    }
                )
            };


            $scope.changeendorseNo= function (str) {
                if ($scope.queryDto.claimNo || $scope.queryDto.policyNo ||$scope.queryDto.compensateNo) {
                    $scope.queryDto.flowInTimeEnd = "";
                    $scope.queryDto.flowInTimeStart = "";
                } else {
                    $scope.queryDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.queryDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            };

            $scope.query = function () {
                var flag = true;
                if($scope.queryDto.policyNo == "" && $scope.queryDto.claimNo == "" &&
                    $scope.queryDto.compensateNo == "" && $scope.queryDto.insuredName == "" &&
                    ($scope.queryDto.flowInTimeStart+"") == "" && ($scope.queryDto.flowInTimeEnd+"") == ""){
                    flag = false;
                }
                if(!flag){layerMsg("请至少输入一个查询条件！");return}
                if(!$scope.queryDto.flowInTimeStart && $scope.queryDto.flowInTimeEnd){
                    layerMsg("请输入流入时间起期！");
                    return;
                }
                if ($scope.agriCompenstateFrom.$valid) {
                    getFileList();
                } else {
                    FormFocus.focusEle('agriCompenstateFrom')
                }
                //if ($scope.agriClaimFrom.$valid) { // 校验通过
                    // console.log($scope.registQueryForm);
                    // if ($scope.registQueryForm.$valid) { // 校验通过
                    //
                    // } else { // 校验未通过
                    //
                    // }
                    // 通用规则 用户输入业务号 系统自动清空默认时间
                  /*  if($scope.queryDto.policyNo||$scope.queryDto.compensateNo||$scope.queryDto.claimNo){
                        $scope.queryDto.flowInTimeStart = "";
                        $scope.queryDto.flowInTimeEnd = "";
                    }*/
                    getFileList();
                //}

            };
            var go = function (item,type,flag){
                $state.go('UIAgriCompenstate',{
                    editType: type,
                    riskType: item.riskType,
                    compensateNo: item.compensateNo||null,
                    claimNo: item.claimNo||null,
                    flowId: item.swfLogDto.flowId,
                    logNo: item.swfLogDto.logNo,
                    checkFlag:flag
                })
            };
            $scope.goCompe = function (item) {
                if(item.swfLogDto.nodeStatus=="0"|| item.swfLogDto.nodeStatus=="2"){ // 未处理
                    go(item,"ADD",true)
                }else if(item.swfLogDto.nodeStatus=="4"){ //  已处理
                    go(item,"EDIT",false)
                }
            };
            $scope.edit = function (item) {
                go(item,"EDIT",true)
            };
            $scope.show = function(item){
                go(item,"SHOW",false)
            };
            $scope.add = function(item){
                go(item,"ADD",true)
            };
            // 转交
            $scope.turnTask = function () {
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
            $scope.cancelApply = function () {
                var swfLogDtoList = [];
                var resultShow = {};
                var check = true;
                angular.forEach($scope.checkedList,function(result){
                    check = (result.swfLogDto.nodeStatus == 0);
                    if (!check){
                        layerMsg("案件状态必须为未处理！");
                        $state.goBack("UIAgriCompenstateQuery");
                        // return;
                    }
                    if(result.checked){
                        var compeCancelDto = {};
                        compeCancelDto.editType='CANCEL';
                        compeCancelDto.nodeType = 'compe';
                        compeCancelDto.prpLclaimCancelClaimNo = result.claimNo;//立案号
                        compeCancelDto.registNo = result.swfLogDto.registNo || '';//报案号
                        compeCancelDto.swfLogFlowID = result.swfLogDto.flowId;
                        compeCancelDto.swfLogFlowID = result.swfLogDto.logNo;
                        //转交页面初始化接口入参对象
                        swfLogDtoList.push(compeCancelDto);
                    }
                });
                if (check) {
                    $state.go("UIAgriClaimReject",{data:JSON.stringify(swfLogDtoList)});
                }else{
                    layerMsg("案件状态必须为未处理！");
                }
            };


        }]);
});