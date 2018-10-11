/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayManageMaintCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state',
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
                    scrollbar: false,
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
                    var endorseNoReger = /(^\d{15,}$)||(^\d{21,}[-]*\d*$)/;
                    var regg = /^\d+$/;
                    if (!endorseNoReger.test(str)) {
                        $scope.check.endorseNo = "批单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if (regg.test(str)&&str.length < 15) {
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
            //投保人姓名校验
            var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;
            $scope.checkinsuredName = function ($event, str) {
                //投保人名称
                if (str) {
                    if (!appliNameReg.test(str)) {
                        $scope.check.insuredName = "投保人名称格式错误，请修改！";
                        $event.target.focus();
                    }
                } else {
                    $scope.check.insuredName = ""
                }
            };
            //返回
            $scope.return = function () {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('dashboard')
            };
            $scope.goUIPrPoEnpayManageEnter = function () {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPrPoEnPayManageEnter')
            };
            //被保险人校验
            $scope.checkappliName = function ($event, str) {

                //被保险人名称
                if (str && !appliNameReg.test(str)) {
                    $scope.check.appliName = "被保险人格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.appliName = "";
                }
            };
            //提交查询信息
            $scope.totalItems = 0;
            $scope.submit = function () {
                if ($scope.isQueryFlag) {
                    $scope.payInfoCondition.pageNo = $scope.paginationConfmm.currentPage = 1;
                    $scope.payInfoCondition.pageSize = $scope.paginationConfmm.itemsPerPage = 20;
                } else {
                    $scope.payInfoCondition.pageNo = $scope.paginationConfmm.currentPage;
                    $scope.payInfoCondition.pageSize = $scope.paginationConfmm.itemsPerPage;
                    $scope.isQueryFlag = true;
                }
                if (($scope.payInfoCondition.endorseNo != undefined && $scope.payInfoCondition.endorseNo != '' && $scope.payInfoCondition.endorseNo != null)
                    || ($scope.payInfoCondition.policyNo != undefined && $scope.payInfoCondition.policyNo != '' && $scope.payInfoCondition.policyNo != null)
                    || ($scope.payInfoCondition.insuredName != undefined && $scope.payInfoCondition.insuredName != '' && $scope.payInfoCondition.insuredName != null)
                    || ($scope.payInfoCondition.appliName != undefined && $scope.payInfoCondition.appliName != '' && $scope.payInfoCondition.appliName != null)
                    || ($scope.payInfoCondition.costType != -1)) {

                } else {
                    showMessage('至少输入一个查询条件！');
                    return
                }
                var endorseNoReger =  /^(\d{15,})||(\d{21,}[-]*\d*)$/;;
                var regg = /^\d+$/;
                // 批单
                if ($scope.payInfoCondition.endorseNo != undefined && $scope.payInfoCondition.endorseNo != '' && $scope.payInfoCondition.endorseNo != null) {
                    if (!endorseNoReger.test($scope.payInfoCondition.endorseNo)) {
                        showMessage('批单号码格式错误，请修改！');
                        return
                    } else if ($scope.payInfoCondition.endorseNo.length < 15) {
                        showMessage('批单号码需输入至少15位数！');
                        return
                    }
                }
                var policyNoReger = /^\d+$/;
                // 保单
                if ($scope.payInfoCondition.policyNo != undefined && $scope.payInfoCondition.policyNo != '' && $scope.payInfoCondition.policyNo != null) {
                    if (!policyNoReger.test($scope.payInfoCondition.policyNo)) {
                        showMessage('保单号码格式错误，请修改！');
                        return
                    } else if ($scope.payInfoCondition.policyNo.length < 15) {
                        showMessage('保单号码需输入至少15位数！');
                        return
                    }

                }
                //投保人名称
                var addr = /^[\u4E00-\u9FA50-9]+$/;
                if ($scope.payInfoCondition.insuredName != undefined && $scope.payInfoCondition.insuredName != '' && $scope.payInfoCondition.insuredName != null) {
                    if (!addr.test($scope.payInfoCondition.insuredName)) {
                        showMessage('投保人名称格式错误，请修改！');
                        return
                    }
                }
                //被保险人
                if ($scope.payInfoCondition.appliName != undefined && $scope.payInfoCondition.appliName != '' && $scope.payInfoCondition.appliName != null) {
                    if (!addr.test($scope.payInfoCondition.appliName)) {
                        showMessage('被保险人格式错误，请修改！');
                        return
                    }
                }
                $$finder.find('queryModifyPayInfo', $scope.payInfoCondition, {
                    success: function (data) {
                        if(data.code=="0000"&&data.content.content.length>0){
                            $scope.QueryList = data.content.content;
                            $scope.totalItems = data.content.totalCount;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                        }else if(data.code=="9999"){
                            layer.open({
                                scrollbar: false,
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '系统异常、请联系管理员！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.QueryList=[];
                            $scope.paginationConfmm.totalItems=0;
                        }
                        $scope.select_all="";

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
                $scope.paginationConfmm.totalItems=""
                $scope.QueryList ={}
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

            // 查看支付详细信息
            $scope.showView = function (endorseInfo) {
                getPayInfoType(endorseInfo, function (data) {
                    var payType = data.payType;
                    if (payType === '0') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayWhole', {
                            viewType: 'view',
                            endorseNo: endorseInfo.endorseNo,
                            costType: endorseInfo.costTypeCode,
                            policyNo: endorseInfo.policyNo,
                            insuredName: endorseInfo.insuredName,
                            costTypeName: endorseInfo.costType,
                            chgPremium: endorseInfo.chgPremium
                        })
                    } else if (payType === '1') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayDetail', {
                            viewType: 'view',
                            endorseNo: endorseInfo.endorseNo,
                            policyNo: endorseInfo.policyNo,
                            costType: endorseInfo.costTypeCode
                        })
                    } else {
                        showMessage('该支付信息的支付类型有误！' + payType);
                    }
                })
            };

            // 修改支付信息
            $scope.showModify = function (endorseInfo) {
                getPayInfoType(endorseInfo, function (data) {
                    var payType = data.payType;
                    // 整单支付
                    if (payType === '0') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayWhole', {
                            viewType: 'modify',
                            endorseNo: endorseInfo.endorseNo,
                            costType: endorseInfo.costTypeCode,
                            policyNo: endorseInfo.policyNo,
                            insuredName: endorseInfo.insuredName,
                            costTypeName: endorseInfo.costType,
                            chgPremium: endorseInfo.chgPremium
                        })
                    }
                    // 清单支付
                    else if (payType === '1') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayDetail', {
                            viewType: 'modify',
                            endorseNo: endorseInfo.endorseNo,
                            policyNo: endorseInfo.policyNo,
                            costType: endorseInfo.costTypeCode
                        })
                    }
                    // 支付类型错误
                    else {
                        showMessage('该支付信息的支付类型有误！' + payType);
                    }
                })
            };
            // 查询支付信息类型
            var getPayInfoType = function (endorseInfo, success) {
                $$finder.find('queryPayInfoType', {
                    endorseNo: endorseInfo.endorseNo,
                    costType: endorseInfo.costTypeCode
                }, {
                    success: function (data) {
                        if (data.code === '0000') {
                            success(data.content);
                        } else {
                            showMessage('查询清单详细信息失败！');
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };
        }]);
});