/**
 * 支付信息录入查询页面的Controller层
 */
define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayManageEnterCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state',
        function ($rootScope, $scope, $$finder, $http, $filter, $state) {
            $scope.isQueryFlag = true;
            $scope.check = {};
            $scope.payInfoCondition = {
                endorseNo: null,
                policyNo: null,
                insuredName: null,
                appliName: null,
                costType: -1,
                pageNo: 0,
                pageSize: 0
            };

            var showMessage = function (message) {
                layer.open({
                    offset: ['35%', '40%'],
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    content: message,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                })
            };

            //查询校验
            $scope.checkpolicyNo = function ($event, str) {
                //保单号码
                if (str) {
                    var reg = /^\d+$/;
                    if (!reg.test(str)) {
                        $scope.check.policyNo = "保单号码格式错误，请修改！";
                        $event.target.focus();
                    } else if (str.length < 15) {
                        $scope.check.policyNo = "保单号码需输入至少15位数！";
                        $event.target.focus();
                    } else {
                        $scope.check.policyNo = "";
                    }
                } else {
                    $scope.check.policyNo = "";
                }
            };

            //批单号校验
            $scope.checkendorseNo = function ($event, str) {
                //批单号码
                if (str) {
                    var endorseNoReger = /^(\d{15,})||(\d{21,}[-]*\d*)$/;
                    var regg = /^\d+$/;
                    if (!endorseNoReger.test(str)) {
                        $scope.check.endorseNo = "批单号码格式错误，请修改！";
                        $event.target.focus();
                    } else if (regg.test(str) && str.length < 15) {
                        $scope.check.endorseNo = "批单号码需输入至少15位数！";
                        $event.target.focus();
                    }
                    else {
                        $scope.check.endorseNo = "";
                    }
                } else {
                    $scope.check.endorseNo = "";
                }
            };

            //返回
            $scope.return = function () {
                $("html,body").css({overflow: "auto"});//出现滚动条
                $state.go('UIPrPoEnPayManageMaint')
            };

            //投保人姓名校验
            $scope.checkinsuredName = function ($event, str) {
                //投保人名称
                var appliNameReg = /^[\u4E00-\u9FA50-9]+$/;
                if (str) {
                    if (!appliNameReg.test(str)) {
                        $scope.check.insuredName = "投保人名称格式错误，请修改！";
                        $event.target.focus();
                    }
                } else {
                    $scope.check.insuredName = ""
                }
            };

            //被保险人校验
            $scope.checkappliName = function ($event, str) {
                //被保险人名称
                var insuredNameReg = /^[\u4E00-\u9FA50-9]+$/;
                if (str && !insuredNameReg.test(str)) {
                    $scope.check.appliName = "被保险人格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.appliName = "";
                }
            };

            //提交查询信息
            $scope.totalItems = 0;
            $scope.submit = function () {
                $scope.endorseInfo = [];
                if ($scope.isQueryFlag) {
                    $scope.payInfoCondition.pageNo = $scope.paginationConfmm.currentPage = 1;
                    $scope.payInfoCondition.pageSize = $scope.paginationConfmm.itemsPerPage = 20;
                } else {
                    $scope.payInfoCondition.pageNo = $scope.paginationConfmm.currentPage;
                    $scope.payInfoCondition.pageSize = $scope.paginationConfmm.itemsPerPage;
                    $scope.isQueryFlag = true;
                }
                //用户登录机构代码
                $scope.payInfoCondition.loginComCode = $rootScope.user.loginComCode;
                //用户登录岗位代码
                $scope.payInfoCondition.loginGradeCodes = '111';
                $$finder.find('queryInputPayInfo', $scope.payInfoCondition, {
                    success: function (data) {
                        if (data.code == "0000" && data.content.content.length > 0) {
                            $scope.QueryList = data.content.content;
                            for (var i = 0; i < $scope.QueryList.length; i++) {
                                $scope.QueryList[i].checked = false;
                            }
                            $scope.totalItems = data.content.totalCount;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                            $scope.select_all = "";
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //重置表单
            $scope.reset = function () {
                $scope.payInfoCondition = {
                    endorseNo: null,
                    policyNo: null,
                    insuredName: null,
                    appliName: null,
                    costType: -1
                };

                $scope.paginationConfmm.totalItems = ""
                $scope.QueryList = {}
            };

            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmm.totalItems != 0) {
                            $scope.isQueryFlag = false;
                            $scope.submit();
                        }
                    }
                };
            };

            initPage2();

            $scope.paginationConfmm.totalItems = $scope.totalItems;
            if ($scope.paginationConfmm.totalItems <= $scope.paginationConfmm.perPageOptions) {
                $scope.paginationConfmm.totalItems = 0;
            }

            //全选
            $scope.endorseInfo = [];
            $scope.selectAll = function () {
                if ($scope.select_all) {
                    $scope.endorseInfo = [];
                    angular.forEach($scope.QueryList, function (info) {
                        info.checked = true;
                        $scope.endorseInfo.push(info);
                    })
                } else {
                    angular.forEach($scope.QueryList, function (info) {
                        info.checked = false;
                        $scope.endorseInfo = [];
                    })
                }
            };

            // 单选
            $scope.selectOne = function (info) {
                var index = $scope.endorseInfo.indexOf(info);
                if (!info.checked && index === -1) {
                    $scope.endorseInfo.push(info);
                } else if (info.checked && index !== -1) {
                    $scope.endorseInfo.splice(index, 1);
                }
                if ($scope.QueryList.length == $scope.endorseInfo.length) {
                    $scope.select_all = true;
                } else {
                    $scope.select_all = false;
                }
            };

            // 清单支付
            $scope.gopayDetail = function () { // 改派
                if ($scope.endorseInfo.length == 1) {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('UIPrPoEnPayDetail', {
                        viewType: 'input',
                        endorseInfo: $scope.endorseInfo[0]
                    })
                } else {
                    var errorMsg;
                    if ($scope.endorseInfo.length == 0) {
                        errorMsg = '请选择要录入的清单支付信息的记录！';
                    } else {
                        errorMsg = '清单支付信息不能批量录入！';
                    }
                    showMessage(errorMsg);
                }
            };

            // 整单支付
            $scope.gopayWhole = function () { // 改派
                if ($scope.endorseInfo.length < 1) {
                    showMessage('请至少选择一条要录入整单支付信息的记录！');
                } else {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('UIPrPoEnPayWhole', {
                        viewType: 'input',
                        endorseInfo: $scope.endorseInfo,
                    })
                }
            };

        }]);
});