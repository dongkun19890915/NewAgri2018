/**
 * DESC       : 国元农险理赔支付情况统计表页面
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
    app.registerController('UIAgriPaymentStatisticsDetailListCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$stateParams','regexpConstants','$$commonality',
        function ($rootScope, $scope, $location, $state, $$finder,$stateParams, regexpConstants,$$commonality) {
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    Combine: 0, // 总共有多少条记录
                    itemsPerPage : 10, // 每页展示的数据条数
                    perPageOptions : [ 10, 20, 30, 40,50 ],
                    onChange : function () {//值回调
                    }
                };
                var compensateNo = $stateParams.compensateNo;
                var payrefReason = $stateParams.payrefReason;
                var keyMap = {
                    "compensateNo": compensateNo,
                    "payrefReason": payrefReason,
                    "page": $scope.paginationConf.currentPage,
                    "size": $scope.paginationConf.itemsPerPage
                };
                $$finder.post('queryPayDetail', keyMap).then(
                    function (data) {
                        console.log("===========EDIT/SHOW=============");
                        console.log(data);
                        $scope.paymentList = data.content;
                    }
                );
                //临时变量
                $scope.infoToView = {
                    "typeCase":{//案件类型
                        typeCaseComCode:false,
                        typeCaseNot:false
                    },
                    "typePayment":{//支付类型
                        typePaymentP3:false,
                        typePaymentP1:false
                    }
                };
            };

            $scope.goSee = function(result,edit) {
                $state.go('UIAgriPaymentFull', {
                    editType: edit,
                    paymentNo: result.paymentNo
                });
            };

            initPage();
            /** 返回 */
            $scope.goBack = function () {
                $rootScope.back();
            };
        }]);
});