/**
 * DESC       : 国元农险理赔支付信息管理查询页面
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
    app.registerController('UIAgriPaymentInfoManageQueryCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants',
        function ($rootScope, $scope, $location, $$finder, regexpConstants) {
            $scope.queryDto = {}; // 查询条件
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            $scope.prpLregist = null; // 查询结果
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

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryPrpLregistList', dto).then(
                    function (data) {
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };
            $scope.query = function () {
                console.log($scope.registQueryForm);
                if ($scope.registQueryForm.$valid) { // 校验通过
                    getFileList();
                } else { // 校验未通过

                }
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
        }]);
});