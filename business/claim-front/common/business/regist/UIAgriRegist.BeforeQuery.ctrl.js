/**
 * DESC       : 国元农险理赔报案登记查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017-11-21
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIAgriRegistBeforeQueryCtrl', ['$rootScope', '$scope', '$location','$filter', '$state', '$$finder', 'FormFocus','regexpConstants',
        function ($rootScope, $scope, $location, $filter, $state, $$finder, FormFocus, regexpConstants) {
            $scope.queryConditionDto = {
                "policyNo":"", //保单号码
                "insuredName":"", //被保人姓名
                "identifyNumber":"", //身份证号
                "earLabel":"", //耳标号
                "fname":"", //农户姓名
                "startDate":"", //保险起期
                "endDate":"" ,//保险止期
                "startEndDate":"", //保险起期起期
                "endEndDate":"" //保险止期止期
            };//查询条件
            var initFun = function () {//保险起期的起期
                var startDate = new Date();
                startDate.setDate(1); // 查询保险起期 默认本年本月1日
                // startDate = startDate.setFullYear(new Date().getFullYear()-1);
                //var endDate = startDate; // 查询保险起期 默认当前日期
                // endDate = endDate.setFullYear(new Date().getFullYear()+1);
                //保险起期的止期
                var startEndDate=new Date();
                //保险止期的起期
                var endDate = new Date();
                endDate.setFullYear(endDate.getFullYear()+1);
                endDate.setDate(1);
                //保险止期的止期
                var endEndDate=new Date();
                endEndDate.setFullYear(endEndDate.getFullYear()+1);
                $scope.queryConditionDto.startDate = $filter("date")(startDate, "yyyy-MM-dd");
                $scope.queryConditionDto.endDate = $filter("date")(endDate, "yyyy-MM-dd");
                $scope.queryConditionDto.startEndDate = $filter("date")(startEndDate, "yyyy-MM-dd");
                $scope.queryConditionDto.endEndDate = $filter("date")(endEndDate, "yyyy-MM-dd");
            };
            initFun();
            $scope.indextifyType ='01'; // 身份证 证件类型01
            // 本页面使用正则的集合
            $scope.regData = regexpConstants;

            $scope.prplregist = null; //  查询结果列表 默认值为null
            $scope.riskType = true;
            $scope.changeRiskType=function () {
                //如果是种植险,隐藏耳标号
                if ($scope.queryConditionDto.riskType=='H'){
                    $scope.riskType=false;
                }else {
                    $scope.riskType=true;
                }

            }
            var initPage = function () {
                $scope.paginationConf = {
                    currentPage: 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage: 20, // 每页展示的数据条数
                    perPageOptions: [5 , 10, 20, 50],
                    onChange: function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();


            /*分页查询*/
            var getFileList = function () {
                var dto = angular.copy($scope.queryConditionDto);
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;

                if (dto.riskType == '' || dto.riskType == undefined){
                    dto.riskType = 'all';
                }

                //提交查询
                $$finder.post('queryPolicyListInfo', dto).then(
                    function (data) {
                        console.log('以下是报案登记的查询结果')
                        console.log($scope.prplregist)
                        $scope.prplregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.queryConditionDto.identifyNumber || $scope.queryConditionDto.policyNo ) {
                    $scope.queryConditionDto.startDate = "";
                    $scope.queryConditionDto.endDate = "";
                    $scope.queryConditionDto.startEndDate = "";
                    $scope.queryConditionDto.endEndDate = "";
                } else {
                    $scope.queryConditionDto.startDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//保险起期
                    $scope.queryConditionDto.startEndDate =$filter('date')(new Date(),'yyyy-MM-dd');

                    var endDate = new Date();
                    endDate.setFullYear(endDate.getFullYear()+1);
                    endDate.setDate(1);
                    $scope.queryConditionDto.endDate =$filter('date')(endDate,'yyyy-MM-dd');//保险止期

                    $scope.queryConditionDto.endEndDate =$filter('date')(new Date().setFullYear(new Date().getFullYear()+1),'yyyy-MM-dd');

                }

            }
            $scope.query = function () {
                var flag = false;
                angular.forEach($scope.queryConditionDto, function(value, key) {
                    // if(key!='modelStatus'){
                        if(value){
                            flag = true
                        }
                    // }
                });
                if(!flag){layerMsg("请至少输入一个查询条件！");return}

                if ($scope.queryConditionForm.$valid) {
                   /* if ($scope.queryConditionDto.endDate){
                        if(!$scope.queryConditionDto.startDate){
                            layerMsg("请选择保险起期!");
                            return false
                        }
                    }*/
                    // 通用规则 查询条件输入业务号，清空默认时间
                 /*   if($scope.queryConditionDto.policyNo){
                        $scope.queryConditionDto.startDate = "";
                        $scope.queryConditionDto.endDate = "";
                        $scope.queryConditionDto.startEndDate="";
                        $scope.queryConditionDto.endEndDate="";
                    }
                    console.log('以下是起始日期')
                    console.log($scope.queryConditionDto.startDate);
                    console.log('以下是终止日期')
                    console.log($scope.queryConditionDto.endDate)*/




                    getFileList();
                } else {
                    FormFocus.focusEle('queryConditionForm')
                }
            };
            $scope.goRegist = function (item) {
                var obj = validGoRegist(item.othFlag, item.underwriteFlag);
                if (obj.tipMsg) {
                    layerMsg(obj.tipMsg, function () {
                        if (obj.flag) {
                            go(item, 'ADD')
                        }
                    })
                } else {
                    if (obj.flag = true) {
                        go(item, 'ADD')
                    }
                }
            };
            var go = function (item,type) {
                $state.go('UIAgriRegist', {
                    editType: type,
                    policyNo: item.policyNo,
                    registNo: item.registNo,
                    riskCode: item.riskCode
                    // damageDate: item.damageDate, // 出险时间
                    // swfLogFlowID: item.swfLogFlowID,
                    // swfLogLogNo: item.swfLogLogNo,
                    // modelNo: item.modelNo,
                    // nodeNo: item.nodeNo,
                    // status: item.status
                })
            };
            var validGoRegist = function (otherFlag, underwriteFlag) {
                var tipMsg = null;
                var flag = true;  // 校验暂时去除
                // if (otherFlag.length > 2 && otherFlag.substring(2, 3) == "1") {
                //     if (fm.validDate.value != "") {
                //         tipMsg = "此保单已全单退保,请慎重处理";
                //     }
                // }
                // if (otherFlag.length > 2 && otherFlag.substring(2, 3) == "2") {
                //     tipMsg = "此保单已满期退保，请慎重处理。";
                // }
                // if (otherFlag.length > 3 && otherFlag.substring(3, 4) == "1") {
                //     tipMsg = "此保单已被注销，不能报案";
                //     flag = false
                // }
                // if (otherFlag.length > 4 && otherFlag.substring(4, 5) == "1") {
                //     tipMsg = "此保单已遗失，请慎重处理。";
                // }
                // if (otherFlag.length > 5 && otherFlag.substring(5, 6) == "1") {
                //     tipMsg = "此保单已终止合同，请慎重处理。";
                // }
                // if (underwriteFlag != "1" && underwriteFlag != "3") {
                //     tipMsg = "该保单为无效保单，不能报案";
                //     flag = false
                // }
                return {tipMsg: tipMsg, flag: flag};
            }

            // 重置

        }]);
});