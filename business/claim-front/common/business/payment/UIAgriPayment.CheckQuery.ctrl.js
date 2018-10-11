/**
 * DESC       : 国元农险理赔支付信息管理查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              zhaowenjie      12.9          清单支付
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPaymentCheckQueryCtrl', ['$rootScope', '$scope', '$location', '$$finder', '$state', '$filter',
        function ($rootScope, $scope, $location, $$finder, $state, $filter) {
            $scope.queryDto = {};
            $scope.prpLregist=null
            var initPage = function () {
                $scope.paginationConf = {
                    currentPage: 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage: 10, // 每页展示的数据条数
                    perPageOptions: [10, 20, 30, 40, 50],
                    onChange: function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();
            /*分页查询*/
            var getFileList = function () {
                var dto = angular.copy($scope.queryDto);
                dto.nodeType = 'VERIFY';
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryPrplsumpay', dto).then(
                    function (data) {
                        console.log("提交查询");
                        console.log(data + "swdaw");
                        $scope.prpLregist = data.content;
                        angular.forEach($scope.prpLregist,function(item){
                            item.handleTime = $filter('date')(item.handleTime,'yyyy-MM-dd')

                        });
                            $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };
            $scope.query = function () {
                getFileList();
            };
            $scope.go = function (item) {
                var data = {
                    editType: 'EDIT',
                    nodeType: 'VERIFY',//节点类型（提交传BACKUP、审核传VERIFY）
                    riskCode: item.riskCode,
                    claimNo: item.claimNo,
                    serialNo: item.serialNo
                };
                data = JSON.stringify(data)
                $state.go('UIAgriPaymentCheck', {data: data})
            }
        }]);

});