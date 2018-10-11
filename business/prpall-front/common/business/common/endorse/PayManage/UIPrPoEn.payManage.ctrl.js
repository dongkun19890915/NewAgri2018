/**
 * Created by sen on 2017/11/17.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayManageCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state',
        function ($rootScope,$scope,$$finder,$http,$filter,$state) {
            $scope.isQueryFlag=true;
            $scope.payInfoCondition = {
                endorseNo: null,
                policyNo: null,
                insuredName: null,
                appliName: null,
                pageNo:0,
                pageSize:0
            };
            //提交查询信息
            $scope.totalItems=0;
            $scope.submit=function(){
                if($scope.isQueryFlag){
                    $scope.payInfoCondition.pageNo=$scope.paginationConfmm.currentPage=1;
                    $scope.payInfoCondition.pageSize=$scope.paginationConfmm.itemsPerPage=5;
                }else{
                    $scope.payInfoCondition.pageNo=$scope.paginationConfmm.currentPage;
                    $scope.payInfoCondition.pageSize=$scope.paginationConfmm.itemsPerPage;
                    $scope.isQueryFlag=true;
                }
                $$finder.find('queryInputPayInfo',$scope.payInfoCondition, {
                    success: function (data) {
                        $scope.QueryList = data.content.content;
                        $scope.totalItems = data.content.totalCount;
                        //查询结果条数
                        $scope.paginationConfmm.totalItems =  $scope.totalItems;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //重置表单
            $scope.reset=function(){
                $scope.payInfoCondition = {
                    endorseNo: null,
                    policyNo: null,
                    insuredName: null,
                    appliName: null
                };
                $scope.$apply();
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange : function () {
                        if ($scope.paginationConfmm.totalItems != 0){
                            $scope.isQueryFlag=false;
                            $scope.submit();
                        }
                    }
                };
            };
            initPage2();
            $scope.paginationConfmm.totalItems =  $scope.totalItems;
            if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
                $scope.paginationConfmm.totalItems=0;
            }

            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.QueryList,function(info){
                        info.checked=true;
                        $scope.checked1.push (info.id);
                    })
                } else {
                    angular.forEach($scope.QueryList,function(info){
                        info.checked=false;
                        $scope.checked1 = [];
                    })
                }
            }
            $scope.selectOne=function(){
                angular.forEach($scope.QueryList , function (info) {
                    var index = $scope.checked1.indexOf(info.id);
                    if(info.checked && index === -1) {
                        $scope.checked1.push(info.id);
                    } else if (!info.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.QueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }

            //清单支付详情弹出
            $scope.inventoryShow = false;
            $scope.configPrintSet = function() {
                $scope.inventoryShow = !$scope.inventoryShow;
            };
            //整单支付详情弹出
            $scope.allinventoryShow = false;
            $scope.configPrintSet1 = function() {
                $scope.allinventoryShow = !$scope.allinventoryShow;
            };
            $scope.message2 = function () {
                alert("保存成功！");
            }
            //双数行改变背景颜色(待增加数组时修改，暂时未实现)
            $scope.addPayManage = function(){
                $scope.changecolor = true;
            }

            //清单列表信息新增(没有绑定model，暂时未实现)
            $scope.addList = function() {
                var newObject = {

                };
                $scope.proposal.prpTmain.MessageQueryList.push(newObject); //后续添加model后再修改
            };
            $scope.deleteCoins2 = function (index) {
                $scope.proposal.prpTmain.clausemanageQueryList1.splice(index, 1);
            }
            $scope.addCoins1 = function () {
                //模拟数组
                var newObject = {
                    'a':'',//险别代码
                    'b':'附加病虫害',//险别名称
                    'c':'附加病虫害',//主险/附加险
                    'd':'',//标的
                };
                $scope.proposal.prpTmain.clausemanageQueryList1.push(newObject);

            };

        }]);
});