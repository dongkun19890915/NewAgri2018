/**
 * DESC       : 国元农险理赔合并案件查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017-11-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIAgriCombineBeforeQueryCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$filter','FormFocus','regexpConstants',
        function ($rootScope, $scope, $location, $state, $$finder,$filter,FormFocus,regexpConstants) {
            $scope.regData = regexpConstants;
            $scope.ComCaseQueryInDto = {};//查询条件
            $scope.PageInfo = {};
            var ComCaseInDtoList=new Array();
            var curDate = new Date();
            curDate.setDate(1);
            $scope.ComCaseQueryInDto.startDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            $scope.ComCaseQueryInDto.riskCode='3220';
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    Combine: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [ 5,10, 20,50 ],
                    onChange : function () {//值回调
                        getFileList();
                    }
                };
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.ComCaseQueryInDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryByComCaseInDto', dto).then(
                    function (data) {
                        console.log(1);
                        console.log(data);
                        console.log(1);
                        $scope.PageInfo = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                debugger;
                if ($scope.ComCaseQueryInDto.policyNo || $scope.ComCaseQueryInDto.accidentNo) {
                    $scope.ComCaseQueryInDto.startDate ="";
                } else {
                    $scope.ComCaseQueryInDto.startDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            }
            $scope.query= function () {
                var flag = false;
                if($scope.ComCaseQueryInDto.policyNo!=null||$scope.ComCaseQueryInDto.insuredName!=null||$scope.ComCaseQueryInDto.accidentNo!=null||$scope.ComCaseQueryInDto.riskCode!=null){
                    flag=true;
                }
                if(!flag){layerMsg("请至少输入一个查询条件！");return}
                if ($scope.CombineQueryForm.$valid) {
                    getFileList();
                } else {
                    FormFocus.focusEle('CombineQueryForm')
                }
            };
            //全选  非全选
            $scope.doCheckedAll = function (){
                debugger
                $scope.checkedAll=!$scope.checkedAll;
                angular.forEach($scope.PageInfo,function(result){
                    result.checked=$scope.checkedAll;
                });
            }
            $scope.doChecked = function (result) {
                result.checked=!result.checked;
                if(!result.checked){
                    $scope.checkedAll=false;
                }
            }
            $scope.ComCaseInDto={}//被选中的两条数据
            // 合并案件查询---删除合并服务
            $scope.goDel = function () {
                $scope.ComCaseInDtoList=[];
                    // var ComCaseInDto = {
                    //     registNo:"432204116262016000015"
                    // };
                    // var ComCaseIn= {
                    //     registNo:"432204116262016000019"
                    // };
                angular.forEach($scope.PageInfo,function(result){
                    if(result.checked){
                        var ComCaseInDto = {};
                        ComCaseInDto.registNo = result.registNo;
                        ComCaseInDto.combineNo=result.accidentNo;
                        //转交页面初始化接口入参对象
                        $scope.ComCaseInDtoList.push(ComCaseInDto);
                    }
                })
                    // ComCaseInDtoList.push(ComCaseInDto);
                    // ComCaseInDtoList.push(ComCaseIn);
                    ComCaseInDtoList=JSON.stringify($scope.ComCaseInDtoList);
                if($scope.ComCaseInDtoList.length<2){
                    layerMsg('请至少选择两条案件！');
                    return
                }
                $$finder.post('logicRemoveCombine',ComCaseInDtoList).then(
                    function (data) {
                        console.log(data);
                        $scope.Map = data;
                        //layerMsg(data.message);
                        if(data.code=="0000"){
                            layerMsg(data.message);
                            $scope.resetForm();
                        }else if(data.code='9999'){
                            layerMsg(data.message || '删除合并失败！' );
                        }else{
                            layerMsg('删除合并失败！')
                        }
                    }
                )
            }
            //合并案件查询---新增合并服务
            $scope.goAdd = function () {
                $scope.ComCaseInDtoList=[];
                console.log($scope.PageInfo.length);
                // var ComCaseInDto = {
                //     registNo:"432204116262016000015"
                // };
                // var ComCaseIn= {
                //     registNo:"432204116262016000019"
                // };
                angular.forEach($scope.PageInfo,function(result){
                    if(result.checked){
                        debugger
                        var ComCaseInDto={};
                        ComCaseInDto.registNo = result.registNo;
                        //初始化接口入参对象
                        $scope.ComCaseInDtoList.push(ComCaseInDto);
                    }
                })
                 // ComCaseInDtoList.push(ComCaseInDto);
                 // ComCaseInDtoList.push(ComCaseIn);
                ComCaseInDtoList=JSON.stringify($scope.ComCaseInDtoList);
                $$finder.post('saveCombine',ComCaseInDtoList).then(
                    function (data) {
                        console.log(data);
                        $scope.Map = data;
                        layerMsg(data.message);
                    }
                )
            }
        }]);
});