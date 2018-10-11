/**
 * DESC       : 国元农险理赔支付信息管理查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              gaoxioawei      2018.3.7          支付查询
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPaymentChangeQueryCtrl', ['$rootScope', '$scope', '$state', '$$finder', 'regexpConstants',
        function ($rootScope, $scope, $state, $$finder, regexpConstants) {
            $scope.regData.hour = regexpConstants.hour;
            $scope.prplregist = null; // 查询结果
            $scope.queryDto={}
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 10, // 每页展示的数据条数
                    perPageOptions : [ 10, 20, 30, 40,50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();
            /**
             *列表查询
             */
            var getFileList = function () {
                var dto = angular.copy($scope.queryDto)
                dto.nodeType = "BACKUP";
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                $$finder.post('queryPrplsumpay', dto).then(function (data) {
                    $scope.prplregist = data.content;
                    $scope.paginationConf.totalItems = data.totalCount;
                })
            }
            $scope.query = function () {
                getFileList();
            };
            $scope.go = function (item) {
                var data = {
                    editType:'EDIT',
                    nodeType:'BACKUP',//节点类型（提交传BACKUP、审核传VERIFY）
                    riskCode:item.riskCode,
                    claimNo:item.claimNo,
                    serialNo:item.serialNo
                };
                data=JSON.stringify(data)
                $state.go('UIAgriPaymentChange', {data: data})
            }
            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);

});