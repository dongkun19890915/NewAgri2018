/**
 * DESC       : 国元农险理赔并案管理-立案任务处理查询页面
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
    app.registerController('UIAgriCombineTaskHandleQueryCtrl', ['$rootScope', '$scope', '$location', '$$finder','$filter','regexpConstants','$state','FormFocus',
        function ($rootScope, $scope, $location, $$finder,$filter, regexpConstants,$state,FormFocus) {
            $scope.ComClaimQueryInDto = {}; // 查询条件
            $scope.regData = regexpConstants; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            $scope.PageInfo ={}; // 查询结果

            var curDate = new Date();
            $scope.ComClaimQueryInDto.flowInTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.ComClaimQueryInDto.flowInTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [ 5,10, 20,50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.ComClaimQueryInDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                if($scope.ComClaimQueryInDto.flowInTimeEnd){
                    dto.flowInTimeEnd=$scope.ComClaimQueryInDto.flowInTimeEnd+" 23:59:59";
                }
                //提交查询
                $$finder.post('queryByComClaimInDto', dto).then(
                    function (data) {
                        console.log(data);
                        $scope.PageInfo = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };


            $scope.changeendorseNo= function (str) {
                if ($scope.ComClaimQueryInDto.registNo || $scope.ComClaimQueryInDto.policyNo||$scope.ComClaimQueryInDto.combineno ) {
                    $scope.ComClaimQueryInDto.flowInTimeEnd = "";
                    $scope.ComClaimQueryInDto.flowInTimeStart = "";
                } else {
                    $scope.ComClaimQueryInDto.flowInTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.ComClaimQueryInDto.flowInTimeStart=$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            }

            $scope.query = function () {
                console.log($scope.registQueryForm);
               /* // if ($scope.registQueryForm.$valid) { // 校验通过
                    getFileList();
                // } else { // 校验未通过

                // }*/
                var flag = false;
                if($scope.ComClaimQueryInDto.policyNo!=null||$scope.ComClaimQueryInDto.insuredName!=null||$scope.ComClaimQueryInDto.combineno!=null||$scope.ComClaimQueryInDto.policyNo!=null||$scope.ComClaimQueryInDto.nodeStatus!=null){
                    flag=true;
                }
              /*  if(!flag){layerMsg("请至少输入一个查询条件！");return}*/
                if ($scope.CombineTaskQueryForm.$valid) {
                    getFileList();
                } else {
                    FormFocus.focusEle('CombineTaskQueryForm')
                }
            };
            $scope.goTaskHandle = function (item) {
                //$scope.$state.go("UIAgriCombineTaskHandle",{editType: '02'}) // 01种植险，02养殖险
                $state.go("UIAgriRegist",{editType: 'SHOW',registNo:item.registNo,riskCode:item.riskCode,policyNo:item.policyNo});
            }

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
            /*var go=function(result,edit){
                $state.go('UIAgriCombineTaskHandle',{
                    editType:edit,
                    combineNo:result.combineNo,
                    claimNo:result.checkNo
                })
            }*/
            var data=new Array();
            var go=function(result,edit){
                angular.forEach($scope.PageInfo,function(item){
                    if(item.combineNo==result.combineNo){
                        var ComCheck={};
                        ComCheck.editType=edit;
                        ComCheck.combineNo=item.combineNo;
                        //ComCheck.claimNo=item.claimNo;
                        ComCheck.riskCode=item.riskCode;
                        ComCheck.swfLogFlowID=item.swfLogFlowID;
                        ComCheck.swfLogLogNo=item.swfLogLogNo;
                        data.push(ComCheck);
                    }
                })
                data=JSON.stringify(data);
                $state.go('UIAgriCombineTaskHandle',{TaskHandle:data});
            }

        }]);
});