/**
 * DESC       : 国元农险理赔打印查询页面
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
    app.registerController('UIAgriPrintQueryCtrl', ['$rootScope', '$filter', '$scope','$state', '$location', '$$finder','regexpConstants','$window', '$$code',
        function ($rootScope, $filter, $scope, $state, $location, $$finder, regexpConstants,$window, $$code) {
            $scope.queryDto = {}; // 查询条件
            $scope.regData = regexpConstants;
            $scope.printList = null; // 查询结果
            $$code.getCodes("code-type","printType").then(function (data) {
                $scope.checkBoxData = data
            });  // 打印类型数据
            $scope.checkedList=[]; // 页面checkBox选中的集合

            $scope.queryDto.printType = [];
            var curDate = new Date();
            $scope.queryDto.handleTimeEnd = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
            curDate.setDate(1);
            $scope.queryDto.handleTimeStart = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20 ,50 ],
                    onChange : function () { // 值回调
                        $scope.queryDto.pageNo=$scope.paginationConf.currentPage;;
                        $scope.queryDto.pageSize=$scope.paginationConf.itemsPerPage;
                        getFileList();
                    }
                };
            };
            initPage();
            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                if(!$scope.queryDto.handleTimeEnd&& $scope.queryDto.handleTimeStart){
                dto.handleTimeEnd=$filter("date")(new Date(),"yyyy-MM-dd");
                }
                //提交查询
                $$finder.post('queryListByPrintType', dto).then(
                    function (data) {
                        if (data.code=='9999'){
                            layerMsg("打印查询报错，请联系管理员！")
                        }
                        $scope.printList = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                        $scope.paginationConf.currentPage=dto.pageNo;
                    }
                )
            };


            $scope.changeendorseNo= function (str) {
                if ($scope.queryDto.policyNo || $scope.queryDto.claimNo|| $scope.queryDto.registNo|| $scope.queryDto.caseNo|| $scope.queryDto.compensateNo ) {
                    $scope.queryDto.handleTimeEnd = "";
                    $scope.queryDto.handleTimeStart = "";
                } else {
                    $scope.queryDto.handleTimeEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.queryDto.handleTimeStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            };
            $scope.query = function () {
                console.log($scope.printQueryForm);
                var printTypes = $scope.queryDto.printType;

                if(printTypes.length==0){
                    layerMsg("请选择打印类型！");
                    return false;
                }

                if(!$scope.queryDto.handleTimeStart && $scope.queryDto.handleTimeEnd){
                    layerMsg("请输入流入时间起期！");
                    return;
                }
                if ($scope.printQueryForm.$valid) {
                    $scope.queryDto.pageNo=1;
                    $scope.queryDto.pageSize=20;
                    getFileList();
                } else {
                    FormFocus.focusEle('printQueryForm')
                }
               /* if($scope.queryDto.policyNo||$scope.queryDto.registNo||$scope.queryDto.compensateNo||$scope.queryDto.claimNo||$scope.queryDto.caseNo){
                    $scope.queryDto.handleTimeStart = "";
                    $scope.queryDto.handleTimeEnd = "";
                }*/
                getFileList();
            };
            $scope.pdfPrint=function () {
                console.log($location);
                var list=[]; // 路径传参
                $$code.getCodes("code-type","printType").then(function (data) {
                    angular.forEach($scope.checkedList, function (item) {
                            var obj = {};
                            obj.compensateNo = item.compensateNo || "$";
                            obj.claimNo = item.businessNo ||"$"; // 业务号就是理立案号
                            obj.policyNo = item.policyNo ||"$";
                            obj.registNo = item.registNo ||"$";
                            obj.allowedPrintType =[];
                            obj.flag=true;
                            for (var i=0;i<item.allowedPrintType.length; i++){
                                for(var j = 0; j<$scope.checkBoxData.length; j++){
                                    if(item.allowedPrintType[i] === $scope.checkBoxData[j].codecname){
                                        obj.allowedPrintType.push($scope.checkBoxData[j].id);
                                        break
                                    }
                                }
                            }
                            list.push(obj)
                        }
                    )
                    $state.go("pdf",{data:JSON.stringify(list)});
                });  // 打印类型数据
            }


          /**
           * 点击打印类型可以查看超链接方法
           */
            $scope.pdfPrintSee=function (item) {
                            var list=[]; // 路径传参
                            var obj = {};
                            obj.compensateNo = item.compensateNo || "$";
                            obj.claimNo = item.businessNo ||"$"; // 业务号就是理立案号
                            obj.policyNo = item.policyNo ||"$";
                            obj.registNo = item.registNo ||"$";
                            obj.allowedPrintType =[];
                            obj.flag=false;
                            for (var i=0;i<item.allowedPrintType.length; i++){
                                        obj.allowedPrintType.push(item.allowedPrintType[i]);
                            }
                            list.push(obj)
                    $state.go("pdf",{data:JSON.stringify(list)
                    });
                }

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
        }]);
});