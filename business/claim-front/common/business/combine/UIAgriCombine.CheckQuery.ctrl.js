/**
 * DESC       : 国元农险理赔并案查勘定损任务查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017-11-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriCombineCheckQueryCtrl', ['$rootScope', '$scope','$state','$location', '$$finder','$filter','regexpConstants','FormFocus',
        function ($rootScope, $scope,$state, $location, $$finder,$filter, regexpConstants,FormFocus) {
            $scope.regData=regexpConstants;
            $scope.ComCheckQueryInDto = {};//查询条件

            var curDate = new Date();
            $scope.ComCheckQueryInDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.ComCheckQueryInDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

            $scope.PageInfo ={};

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
                var dto = angular.copy($scope.ComCheckQueryInDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                if($scope.ComCheckQueryInDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$scope.ComCheckQueryInDto.flowInTimeEnd+" 23:59:59";
                }
                //提交查询
                $$finder.post('queryByComCheckInDto', dto).then(
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
                if ($scope.ComCheckQueryInDto.registNo || $scope.ComCheckQueryInDto.policyNo ||$scope.ComCheckQueryInDto.combineNo) {
                    $scope.ComCheckQueryInDto.flowInTimeEnd = "";
                    $scope.ComCheckQueryInDto.flowInTimeStart = "";
                } else {
                    $scope.ComCheckQueryInDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.ComCheckQueryInDto.flowInTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            }

            $scope.query= function () {
                var flag = false;
                if($scope.ComCheckQueryInDto.policyNo!=null||$scope.ComCheckQueryInDto.insuredName!=null||$scope.ComCheckQueryInDto.accidentNo!=null||$scope.ComCheckQueryInDto.policyNo!=null||$scope.ComCheckQueryInDto.nodeStatus!=null){
                    flag=true;
                }
              /*  if(!flag){layerMsg("请至少输入一个查询条件！");return}*/
                if ($scope.CombineCheckQueryForm.$valid) {
                    getFileList();
                } else {
                    FormFocus.focusEle('CombineCheckQueryForm')
                }
            };
            //处理跳转页面
            $scope.deal = function (result) {
                go(result,"ADD");
            }
            //修改跳转页面
            $scope.edit = function (result) {
                go(result,"EDIT");
            }
            //查看跳转页面
            $scope.show = function (result) {
                go(result,"SHOW");
            }
            var data=new Array();
            var go=function(result,edit){
                angular.forEach($scope.PageInfo,function(item){
                    if(item.combineNo==result.combineNo){
                        var ComCheck={};
                        ComCheck.editType=edit;
                        ComCheck.combineNo=item.combineNo;
                        ComCheck.checkNo=item.checkNo;
                        ComCheck.riskCode=item.riskCode;
                        ComCheck.swfLogFlowID=item.swfLogFlowID;
                        ComCheck.swfLogLogNo=item.swfLogLogNo;
                        data.push(ComCheck);
                     }
                })
                data=JSON.stringify(data);
                $state.go('UIAgriCombineCheck',{CombineCheck:data});
            }

        }]);
});