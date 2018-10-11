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
    'layer',
    'config'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriDispatchCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','$filter','FormFocus','$$commonality','regexpConstants',
        function ($rootScope, $scope, $location,$state, $$finder,$filter, FormFocus,$$commonality,regexpConstants) {
            $scope.regData = regexpConstants;
            $scope.InParameterSchedulDto = {};//查询条件
            $scope.OutParameterTaskSchedulingDto = null;
            $scope.InParameterSchedulDto = {
                "status":"all",
                "registNo":"",
                "policyNo":"",
                "insuredName":"",
                "userCode": $rootScope.user.userCode,//用户代码
                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                "loginGradeCodes": "111",
                "tableName": "PrpDcompany",
                "userCodeFields": "userCode",
                "comCodeFields": "comCode",
            }

            var curDate = new Date();
            $scope.InParameterSchedulDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.InParameterSchedulDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20, 50 ],
                    onChange : function () {//值回调
                        getFileList();
                    }
                };
            };
            initPage();


            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.InParameterSchedulDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                console.log('以下是调度的查询条件大对象')
                console.log(dto)
                if($scope.InParameterSchedulDto.flowInTimeStart&&!$scope.InParameterSchedulDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$filter('date')(new Date(),'yyyy-MM-dd')
                }
                //提交查询
                if (dto.riskType == ''|| dto.riskType == undefined){
                    dto.riskType='all';
                }
                $$finder.post('querySchedulByCondition', dto).then(
                    function (data) {
                        console.log('以下是调度前的查询结果');
                        console.log(data);
                        console.log(data.content);
                        $scope.OutParameterTaskSchedulingDto = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                        console.log('以下是查询出来的总条数');
                        console.log($scope.paginationConf.totalItems)
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.InParameterSchedulDto.registNo || $scope.InParameterSchedulDto.policyNo ) {
                    $scope.InParameterSchedulDto.flowInTimeEnd = "";
                    $scope.InParameterSchedulDto.flowInTimeStart = "";
                } else {
                    $scope.InParameterSchedulDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.InParameterSchedulDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }

            }
            $scope.query = function () {
                var querySpecialflag =false;
             /*   var querySpecialflag = $$commonality.inspectEmpty('dispatchQueryForm');*/
                if($scope.InParameterSchedulDto.registNo==""&& $scope.InParameterSchedulDto.policyNo==""&& $scope.InParameterSchedulDto.insuredName==""){
                    querySpecialflag = false;
                }
                if (querySpecialflag){
                    layerMsg("请至少输入一个查询条件！");
                    return false;
                }

                if(!$scope.InParameterSchedulDto.flowInTimeStart && $scope.InParameterSchedulDto.flowInTimeEnd){
                    layerMsg("请输入流入时间起期！");
                    return;
                }


                if ($scope.dispatchQueryForm.$valid) {
                    // 通用规则 查询条件输入业务号，清空默认时间
                  /*  if($scope.InParameterSchedulDto.policyNo||$scope.InParameterSchedulDto.registNo){
                        $scope.InParameterSchedulDto.flowInTimeStart = "";
                        $scope.InParameterSchedulDto.flowInTimeEnd = "";
                    }*/
                    getFileList();
                } else {
                    FormFocus.focusEle('dispatchQueryForm')
                }
            };

            $scope.goRegist = function (result) {
                var obj = validGoRegist(result.othFlag, result.underwriteFlag);
                if (obj.tipMsg) {
                    layerMsg(obj.tipMsg, function () {
                        if (obj.flag) {
                            goto(result, 'SHOW')
                        }
                    })
                } else {
                    if (obj.flag = true) {
                        goto(result, 'SHOW')
                    }
                }
            };
            var goto = function (result,type) {
                $state.go('UIAgriRegist', {
                    editType: type,
                    policyNo: result.policyNo,
                    registNo: result.registNo,
                    riskCode: result.riskCode
                    // damageDate: item.damageDate, // 出险时间
                    // swfLogFlowID: item.swfLogFlowID,
                    // swfLogLogNo: item.swfLogLogNo
                    // modelNo: item.modelNo,
                    // nodeNo: item.nodeNo,
                    // status: item.status
                })
            };
            var validGoRegist = function (otherFlag, underwriteFlag) {
                var tipMsg = null;
                var flag = true;  // 校验暂时去除
                return {tipMsg: tipMsg, flag: flag};
            }
            $scope.edit = function (item) {
                go(item, "ADD")
            };
            $scope.show = function (item) {
                goTo(item, "SHOW")
            };

            $scope.backEdit =function(item){
                  goTo(item,"GETBACKEDIT")
            }
            //调度按钮跳转页面
            var go =  function (result,edit){
                $state.go("UIAgriDispatchEdit",
                    {
                        editType: edit,
                        riskCode: result.riskCode,
                        registNo: result.registNo,
                        scheduleID: result.scheduleID,
                        policyNo: result.policyNo,
                        nodeType: result.nodeType,
                        modelNo: result.modelNo,
                        nodeNo: result.nodeNo,
                        swflogFlowId: result.swflogFlowId,
                        swflogLogNo: result.swflogLogNo
                    }
                )
            }


            // $scope.goDispatchReassignment = function () { // 改派
            //     $state.go('UIAgriDispatchReassignment')
            // }
            //改派 、查看 按钮跳转页面
            var goTo =  function (result,edit){
                $state.go("UIAgriDispatchReassignment",
                    {
                        editType: edit,
                        riskCode: result.riskCode,
                        registNo: result.registNo,
                        scheduleID: result.scheduleID,
                        policyNo: result.policyNo,
                        nodeType: result.nodeType,
                        modelNo: result.modelNo,
                        nodeNo: result.nodeNo,
                        commiFlag: result.commiFlag,
                        schedFlag: result.schedFlag,
                        swflogFlowId: result.swflogFlowId,
                        swflogLogNo: result.swflogLogNo
                    }
                )
            }
            // $scope.goRegist = function () {
            //     $state.go('UIAgriRegist',{state:'regist'})
            // }
        }]);
});