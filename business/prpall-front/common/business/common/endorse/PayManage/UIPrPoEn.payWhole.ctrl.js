/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayWholeCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state', '$stateParams', '$timeout', '$$code',
        function ($rootScope, $scope, $$finder, $http, $filter, $state, $stateParams, $timeout, $$code) {
            var loginComCode = $rootScope.user.loginComCode;
            $scope.isEdit = false;
            // 批单号码集合
            var endorseNos = $stateParams.endorseNo;
            // 费用类型
            var costType = $stateParams.costType;
            // 页面类型
            var viewType = $stateParams.viewType;
            // 退款信息总金额
            $scope.sumChgPremium = 0;
            // 退费信息明细
            var endorseInfo = $stateParams.endorseInfo;
            $scope.endorseInfo = {};

            if (viewType === 'view') {
                $scope.isEdit = false;
            } else if (viewType === 'modify' || viewType === 'input') {
                $scope.isEdit = true;
            }

            // 取消
            $scope.cancel = function () {
                window.history.back();
            };

            // 弹出信息
            var showMessage = function (message, isBack) {
                layer.open({
                    scrollbar: false,
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    content: message,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        $scope.$apply(function () {
                            $scope.saveTemporaryDisabled = false;
                        });
                        //按钮【按钮一】的回调
                        layer.close(index);
                        if (isBack) {
                            $scope.cancel();
                        }
                    }
                })
            };

            // 页面数据对象
            $scope.endorse = {
                costType: costType,
                endorseNos: endorseNos,
                loginComCode: loginComCode,
                bank: null,
                subInfo: [{
                    endorseNo: endorseNos,
                    costType: costType
                }],
                prpPayMainDto: {
                    // 基本信息
                    receiverType: null,// 领款人类型*
                    receiverName: null,// 领款人名称*
                    certifyType: null,// 领款人证件类型*
                    certifyNo: null,// 证件号码*
                    ugentType: null,// 紧急程度
                    fName: null,// 客户姓名*
                    // 账户信息
                    bankProv: null,// 省份名称*
                    bankCity: null,// 城市名称*
                    accountType: null,// 账户属性*
                    bankType: null,// 银行大类*
                    bank: null,// 开户银行*
                    bankAccount: null,// 银行账号*
                    bankAccount1: null,// 账号确认*
                    accountFlag: null,// 账号类型*
                    // 领款人信息
                    mobilePhone: null,// 手机号码*
                    familyPhone: null,// 家庭电话
                    officePhone: null,// 办公号码
                    address: null,// 详细地址*
                    qqNumber: null,// QQ号码
                    email: null,// 电子邮箱
                    unitLink: null,// 单位联系人
                    postCode: null,// 邮政编码
                    payPurpose: null,// 用途说明
                    routeNum: null,// 支付行号
                    payType: null
                }
            };


            // 如果参数列表中的endorseInfo是对象则接收展示参数
            if ((typeof endorseInfo) === (typeof {})) {
                $scope.endorseInfo = $stateParams.endorseInfo;
                endorseNos = [];
                $scope.endorse.subInfo = [];
                angular.forEach(endorseInfo, function (info) {
                    endorseNos.push(info.endorseNo);
                    var subInfo = {
                        endorseNo: info.endorseNo,
                        costType: info.costTypeCode
                    };
                    $scope.endorse.subInfo.push(subInfo);
                    $scope.sumChgPremium += info.chgPremium;
                })
            } else {
                if (viewType === 'input') {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go("UIPrPoEnPayManageEnter");
                } else if (viewType === 'modify' || viewType === 'view') {
                    $scope.endorseInfo = [{
                        endorseNo: endorseNos,
                        policyNo: $stateParams.policyNo,
                        insuredName: $stateParams.insuredName,
                        costType: $stateParams.costTypeName,
                        chgPremium: Number($stateParams.chgPremium)
                    }];
                    $scope.sumChgPremium = Number($stateParams.chgPremium);
                }
            }
            $scope.selectListData = {
                bankList: []
            };

            $scope.selectBank = function (bankInfo) {
                $scope.endorse.prpPayMainDto.bank = bankInfo.bankName;
                $scope.endorse.prpPayMainDto.routeNum = bankInfo.bankNumber;
            };

            $scope.bankChange = function (value) {
                $timeout.cancel($scope.timer);
                $scope.timer = $timeout(function () {
                    if (value && value != '' && value != null) {
                        $scope.getBankList(value);
                    }
                }, 500);
            };
            $scope.getBankList = function (value) {
                $$finder.find('getBankInfo', {
                    bank: value
                }, {
                    success: function (data) {
                        if (data.code === '0000') {
                            $scope.selectListData.bankList = data.content;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            $scope.getBankList();

            // 查询支付详细信息
            var getPayInfoDetails = function (endorseNos, costType, success) {
                $$finder.find('queryPayInfoDetails', {
                    endorseNo: endorseNos,
                    costType: costType
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

            // 查看或修改页面需要查询
            if (viewType === 'view' || viewType === 'modify') {
                if (endorseNos !== undefined && costType !== undefined) {
                    getPayInfoDetails(endorseNos, costType, function (data) {
                        $scope.endorse.prpPayMainDto = data.prpPayMainDtos[0];
                        $scope.endorse.prpPayMainDto.bankAccount1 = $scope.endorse.prpPayMainDto.bankAccount;
                    });
                } else {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go("UIPrPoEnPayManageMaint");
                }
            }

            // 省/市/银行标准化修改后需要在保存时赋值
            var regionsChg = function () {
                // 省份名称赋值
                $scope.endorse.prpPayMainDto.bankProv = $("#pro").val();
                // 城市名称赋值
                $scope.endorse.prpPayMainDto.bankCity = $("#btn_hukou").val();
                // 银行大类名称赋值
                $scope.endorse.prpPayMainDto.bankType = $("#bankType").val();
            };

            // 保存方法
            var message = null;
            $scope.save = function () {
                regionsChg();
                $scope.saveTemporaryDisabled = true;
                if (!$scope.endorse.prpPayMainDto.receiverType) {
                    message = '请录入领款人类型！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.receiverName) {
                    message = '请录入领款人姓名！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.certifyType) {
                    message = '请录入领款人证件类型！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.certifyNo) {
                    message = '请录入证件号码！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.fName) {
                    message = '请录入客户姓名！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bankProv) {
                    message = '请录入省份名称！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bankCity) {
                    message = '请录入城市名称！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.accountType) {
                    message = '请录入账户属性！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bankType) {
                    message = '请录入银行大类！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bank) {
                    message = '请录入开户银行！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bankAccount) {
                    message = '请录入银行账号！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.payType) {
                    message = '请录入支付方式！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.bankAccount1) {
                    message = '请录入请确认银行账号!';
                    showMessage(message);
                    return;
                } else if ($scope.endorse.prpPayMainDto.bankAccount1 !== $scope.endorse.prpPayMainDto.bankAccount) {
                    message = '两次输入的银行账号不一致！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.accountFlag) {
                    message = '请录入账号类型！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.mobilePhone) {
                    message = '请录入手机号码！';
                    showMessage(message);
                    return;
                }
                if (!$scope.endorse.prpPayMainDto.address) {
                    message = '请录入详细地址！';
                    showMessage(message);
                    return;
                }
                if (viewType === 'input') {
                    $$finder.find('saveSinglePayInfo', $scope.endorse, {
                        success: function (data) {
                            if (data.code === "0000") {
                                showMessage("保存成功！", true);
                            } else {
                                showMessage("保存失败！");
                            }
                        },
                        error: function (e) {
                            $scope.$apply(function () {
                                $scope.saveTemporaryDisabled = false;
                            });
                            options.error(e);
                        }
                    });
                } else if (viewType === 'modify') {
                    $scope.endorse.endorseNo = endorseNos;
                    $scope.endorse.endorseNos = null;
                    $$finder.find('modifySinglePayInfo', $scope.endorse, {
                        success: function (data) {
                            if (data.code === "0000") {
                                showMessage("修改成功！", true);
                            } else {
                                showMessage("修改失败！");
                            }
                        },
                        error: function (e) {
                            $scope.$apply(function () {
                                $scope.saveTemporaryDisabled = false;
                            });
                            options.error(e);
                        }
                    });
                } else {
                    $scope.$apply(function () {
                        $scope.saveTemporaryDisabled = false;
                    });
                }
            };

            // 失去焦点校验
            $scope.check = {};
            // 领款人名称
            $scope.checkReceiverName = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;//汉字
                if (str && !reg.test(str)) {
                    $scope.check.receiverName = "领款人格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.receiverName = "";
                }
            };
            // 证件号码
            $scope.checkCertifyNo = function ($event, str) {
                var x = $scope.endorse.prpPayMainDto.certifyType;
                switch (x) {
                    case "01":
                        var idReg = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                        if (str && !idReg.test(str)) {
                            $scope.check.certifyNo = "身份证号码格式不正确，请修改！";
                            $event.target.focus();
                        } else {
                            $scope.check.certifyNo = "";
                        }
                        break;
                }
            };
            // 客户姓名
            $scope.checkFName = function ($event, str) {
                var reg = /^[\u4E00-\u9FA50-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.fName = "客户姓名格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.fName = "";
                }
            };
            // 省份名称
            $scope.checkBankProv = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.bankProv = "省份名称格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bankProv = "";
                }
            };
            // 城市名称
            $scope.checkBankCity = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.bankCity = "城市名称格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bankCity = "";
                }
            };
            // 银行大类
            $scope.checkBankType = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;//汉字
                if (str && !reg.test(str)) {
                    $scope.check.bankType = "银行大类格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bankType = "";
                }
            };
            // 银行账号
            $scope.checkBankAccount = function ($event, str) {
                var reg = /^[0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.bankAccount = "银行账号格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bankAccount = "";
                }
            };
            // 账号确认
            $scope.checkBankAccount1 = function ($event, str) {
                var reg = /^[0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.bankAccount1 = "账号确认格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bankAccount1 = "";
                }
            };
            // 开户银行
            $scope.checkBank = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;//汉字
                if (str && !reg.test(str)) {
                    $scope.check.bank = "开户银行格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.bank = "";
                }
            };
            // 手机号码
            $scope.checkMobilePhone = function ($event, str) {
                var reg = /^0?(13|14|15|18|17)[0-9]{9}$/;
                if (str && !reg.test(str)) {
                    $scope.check.mobilePhone = "手机号码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.mobilePhone = "";
                }
            };
            // 办公号码
            $scope.checkOfficePhone = function ($event, str) {

                if (str) {
                    var reg = /^[0-9]{1,}$/;
                    if (reg.test(str)) {
                        if (str.length >= 7 && str.length <= 18) {
                            $scope.check.officePhone = "";
                        } else {
                            $scope.check.officePhone = "办公号码长度为7到18位，请修改！";
                            $event.target.focus();
                        }

                    } else {
                        $scope.check.officePhone = "办公号码格式错误，请修改！";
                        $event.target.focus();
                    }
                } else {
                    $scope.check.officePhone = "";
                }
            };
            // 家庭电话
            $scope.checkFamilyPhone = function ($event, str) {
                var reg = /^[0-9-()（）]{7,18}$/;
                if (str && !reg.test(str)) {
                    $scope.check.familyPhone = "家庭电话格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.familyPhone = "";
                }
            };
            // QQ号码
            $scope.checkQqNumber = function ($event, str) {
                var reg = /^[1-9]([0-9]{5,11})$/;
                if (str && !reg.test(str)) {
                    $scope.check.qqNumber = "QQ号码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.qqNumber = "";
                }
            };
            // 单位联系人
            $scope.checkUnitLink = function ($event, str) {
                var reg = /^[\u4E00-\u9FA5]+$/;//汉字
                if (str && !reg.test(str)) {
                    $scope.check.unitLink = "单位联系人格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.unitLink = "";
                }
            };
            // 电子邮箱
            $scope.checkEmail = function ($event, str) {
                var reg = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
                if (str && !reg.test(str)) {
                    $scope.check.email = "电子邮箱格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.email = "";
                }
            };

            // 邮政编码
            $scope.checkPostCode = function ($event, str) {
                var reg = /^\d{6}$/;
                if (str && !reg.test(str)) {
                    $scope.check.postCode = "邮政编码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.postCode = "";
                }
            };
            // 同步账户信息
            $scope.synchronize = function () {
                if ($scope.endorse.prpPayMainDto.receiverType == null) {
                    message = '请选择领款人类型！';
                    showMessage(message);
                    return;
                }
                if ($scope.endorse.prpPayMainDto.certifyType == null) {
                    message = '请选择领款人证件类型！';
                    showMessage(message);
                    return;
                }
                if ($scope.endorse.prpPayMainDto.certifyNo == null) {
                    message = '请填写证件号码！';
                    showMessage(message);
                    return;
                }
                // 支付信息修改时，endorseNos 是 string类型，需要放到数组中
                var _endorseArr = null;
                if ((typeof endorseNos) === (typeof '')) {
                    _endorseArr = [endorseNos];
                } else {
                    _endorseArr = endorseNos;
                }
                console.log(typeof _endorseArr);
                $$finder.find('synchronizeAccount', {
                    endorseNos: _endorseArr,
                    receiverType: $scope.endorse.prpPayMainDto.receiverType,
                    certiType: $scope.endorse.prpPayMainDto.certifyType,
                    certifyNo: $scope.endorse.prpPayMainDto.certifyNo
                }, {
                    success: function (data) {
                        if (data.code === '0000') {
                            var content = data.content;
                            var bank = null;
                            var bankAccount = null;
                            var accountType = null;
                            angular.forEach(content, function (info) {
                                if (bank == null) {
                                    $scope.endorse.prpPayMainDto.bank = info.bank;
                                    bank = info.bank;
                                }
                                if (bankAccount == null || bankAccount1 == null) {
                                    $scope.endorse.prpPayMainDto.bankAccount = info.account;
                                    $scope.endorse.prpPayMainDto.bankAccount1 = info.account;
                                    bankAccount = info.account;
                                }
                                if (accountType == null) {
                                    $scope.endorse.prpPayMainDto.accountType = info.insuredType;
                                    accountType = info.insuredType;
                                }
                                if (bank != null && bankAccount != null && accountType != null) {
                                    return;
                                }
                            })
                        } else {
                            showMessage('同步账户信息失败！' + data.message);
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
        }]);
});