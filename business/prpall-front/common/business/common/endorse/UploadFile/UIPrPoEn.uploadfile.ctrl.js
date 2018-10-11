/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB', 'config', 'encodeUrl'], function (app, constants, layer, jsonDB, config) {
    'use strict';
    app.registerController('UIPrPoEnUploadfileCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','$$code',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,$$code) {
            $scope.proposal={};
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.totalItems = 0;
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 20;
            $scope.proposal.prpTmain.proposalType = '1';//默认保单  业务类型
            //$scope.proposal.prpTmain.operateStartDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//制单开始日期
            //$scope.proposal.prpTmain.operateEndDate = $filter('date')(new Date(),'yyyy-MM-dd');//制单截止日期
            $scope.selectListData = {};// 级联下拉列表数据
            // 获取归属机构下拉列表
            $scope.getComCodeList = function () {
                var comCodeData = {
                    comCode: '',
                    comCName: '',
                    riskCode: '',
                    gradeCodes: '111',
                    userCode: $scope.user.userCode,
                    loginComCode: $scope.user.loginComCode
                };
                $$code.getCodes('codeType', 'queryComCodeInfo', {}, comCodeData).then(function (data) {
                    $scope.selectListData.comCodeList = data;
                });
            };

            //提交查询信息
            function queryProposalListInfoByConditon() {
                var req = angular.copy($scope.proposal);
                var requestDto = req.prpTmain;
                $$finder.find($scope.target, requestDto, {
                    success: function (data) {
                        if (data.code == "0000" && data.content.content.length > 0) {
                            var list = data.content.content;
                            $scope.proposal.QueryList = list;
                            $scope.totalItems = data.content.totalCount;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                        } else if (data.code == "9999") {
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
                        } else {
                            $scope.proposal.QueryList = [];
                            $scope.paginationConfmm.totalItems = 0;
                        }
                        $scope.select_all = "";
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //音像资料查询按钮
            $scope.submit = function () {
                if (($scope.proposal.prpTmain.proposalNo != null && $scope.proposal.prpTmain.proposalNo != "")
                    || ($scope.proposal.prpTmain.appliName != "" && $scope.proposal.prpTmain.appliName != undefined)
                    || ($scope.proposal.prpTmain.appliCode != "" && $scope.proposal.prpTmain.appliCode != undefined)
                    || ($scope.proposal.prpTmain.insuredName != "" && $scope.proposal.prpTmain.insuredName != undefined)
                    || ($scope.proposal.prpTmain.insuredCode != "" && $scope.proposal.prpTmain.insuredCode != undefined)
                    || ($scope.proposal.prpTmain.sumAmount != "" && $scope.proposal.prpTmain.sumAmount != undefined)
                    || ($scope.proposal.prpTmain.handler1Code != "" && $scope.proposal.prpTmain.handler1Code != undefined)
                    || ($scope.proposal.prpTmain.operatorCode != "" && $scope.proposal.prpTmain.operatorCode != undefined)
                    || ($scope.proposal.prpTmain.operateStartDate != "" && $scope.proposal.prpTmain.operateStartDate != undefined)
                    || ($scope.proposal.prpTmain.proposalType != "" && $scope.proposal.prpTmain.proposalType != undefined)
                    || ($scope.proposal.prpTmain.operateEndDate != "" && $scope.proposal.prpTmain.operateEndDate != undefined)) {
                    var content = "";
                    var proposalNoReg = /^\d{15,}$/;//至少15位数字
                    var appliNameReg = /^[\u4E00-\u9FA50-9]+$/;// 数字汉子
                    var sumAmountRge = /^\d+$/;//数字
                    var appliCodeReg = /^[A-Za-z0-9]+$/;//数字  字母
                    // if($scope.proposal.prpTmain.proposalNo&&!proposalNoReg.test($scope.proposal.prpTmain.proposalNo)){
                    //     //业务号码
                    //     content="业务号码格式错误，请修改！";
                    //     $scope.proposal.prpTmain.proposalNo="";
                    // }else

                    if ($scope.proposal.prpTmain.appliName && !appliNameReg.test($scope.proposal.prpTmain.appliName)) {
                        //投保人名称
                        content = "投保人名称格式错误，请修改！";
                        $scope.proposal.prpTmain.appliName = "";
                    } else if ($scope.proposal.prpTmain.appliCode && !appliCodeReg.test($scope.proposal.prpTmain.appliCode)) {
                        content = "投保人代码格式错误，请修改！";
                        $scope.proposal.prpTmain.appliCode = "";
                    } else if ($scope.proposal.prpTmain.insuredName && !appliNameReg.test($scope.proposal.prpTmain.insuredName)) {
                        content = "被保人名称格式错误，请修改！";
                        $scope.proposal.prpTmain.insuredName = "";
                    } else if ($scope.proposal.prpTmain.insuredCode && !appliCodeReg.test($scope.proposal.prpTmain.insuredCode)) {
                        content = "被保人代码格式错误，请修改！";
                        $scope.proposal.prpTmain.insuredCode = "";
                    } /*else if ($scope.proposal.prpTmain.sumAmount && !appliNameReg.test($scope.proposal.prpTmain.sumAmount)) {
                        content = "出单机构格式错误，请修改！";
                        $scope.proposal.prpTmain.sumAmount = "";
                    }*/ else if ($scope.proposal.prpTmain.handler1Code && !sumAmountRge.test($scope.proposal.prpTmain.handler1Code)) {
                        content = "业务员代码格式错误，请修改！";
                        $scope.proposal.prpTmain.handler1Code = "";
                    } else if ($scope.proposal.prpTmain.operatorCode && !sumAmountRge.test($scope.proposal.prpTmain.operatorCode)) {
                        content = "操作员代码格式错误，请修改！";
                        $scope.proposal.prpTmain.operatorCode = "";
                    }

                    if (content) {
                        layer.open({
                            scrollbar: false,
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    } else {
                        if ($scope.proposal.prpTmain.proposalType === '1') {
                            $scope.target = 'queryProposalListInfoByConditon';//投保单
                        } else if ($scope.proposal.prpTmain.proposalType === '2') {
                            $scope.target = 'queryPolicyListByConditon';//保单
                            $scope.proposal.prpTmain.policyNo = $scope.proposal.prpTmain.proposalNo;
                            $scope.proposal.prpTmain.queryFlag = '1';
                            $scope.proposal.prpTmain.imagingSystemFlag = 'imagingSystemFlag';
                        } else {
                            $scope.target = 'queryEndorsListInfoImage';//批单
                            $scope.proposal.prpTmain.endorseNo = $scope.proposal.prpTmain.proposalNo;
                        }
                        queryProposalListInfoByConditon();
                    }

                } else {
                    var content;
                    content = '至少输入一个查询条件！';
                    layer.open({
                        scrollbar: false,
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }

            };
            $scope.changeproposalNo = function (str) {
                if (str) {
                    $scope.proposal.prpTmain.operateStartDate = "";//制单开始日期
                    $scope.proposal.prpTmain.operateEndDate = "";//制单截止日期
                } else {
                    $scope.proposal.prpTmain.operateStartDate = $filter('date')(new Date().setDate('01'), 'yyyy-MM-dd');//制单开始日期
                    $scope.proposal.prpTmain.operateEndDate = $filter('date')(new Date(), 'yyyy-MM-dd');//制单截止日期
                }
            }

            //失去焦点校验
            $scope.check = {};
            // $scope.checkproposalNo= function ($event,str) {
            //     //业务号码
            //     var reg=/^\d{15,}$/;
            //     if(str&&!reg.test(str)){
            //         $scope.check.proposalNo="业务号码格式错误，请修改！";
            //         $event.target.focus();
            //     }else{
            //         $scope.check.proposalNo="";
            //     }
            // }
            $scope.checkappliName = function ($event, str) {
                //投保人名称
                var reg = /^[\u4E00-\u9FA50-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.appliName = "投保人名称格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.appliName = "";
                }
            }
            $scope.checkappliCode = function ($event, str) {
                //投保人代码
                var reg = /^[A-Za-z0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.appliCode = "投保人代码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.appliCode = "";
                }
            }
            $scope.checkinsuredName = function ($event, str) {
                //被保险人名称
                var reg = /^[\u4E00-\u9FA50-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.insuredName = "被保险人名称格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.insuredName = "";
                }
            }
            $scope.checkinsuredCode = function ($event, str) {
                //被保险人代码
                var reg = /^[A-Za-z0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.insuredCode = "被保险人代码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.insuredCode = "";
                }
            }
            $scope.checksumAmount = function ($event, str) {
                //出单机构
                var reg = /^[\u4E00-\u9FA50-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.sumAmount = "出单机构格式错误，请修改!";
                    $event.target.focus();
                } else {
                    $scope.check.sumAmount = "";
                }
            }
            $scope.checkhandler1Code = function ($event, str) {
                //业务员代码
                var reg = /^[A-Za-z0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.handler1Code = "业务员代码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.handler1Code = "";
                }
            }
            $scope.checkoperatorCode = function ($event, str) {
                //操作员代码
                var reg = /^[A-Za-z0-9]+$/;
                if (str && !reg.test(str)) {
                    $scope.check.operatorCode = "操作员代码格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.operatorCode = "";
                }
            }
            //重置表单
            $scope.reset = function () {
                $scope.businessNo = undefined;
                $scope.proposal.prpTmain = {};
                $scope.proposal.QueryList = {};//接口查询回来的
                $scope.totalItems = 0;
                $scope.proposal.prpTmain.pageNo = 1;
                $scope.proposal.prpTmain.pageSize = 20;
                $scope.proposal.prpTmain.proposalType = '1';//默认保单  业务类型
                //$scope.proposal.prpTmain.operateStartDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//制单开始日期
                //$scope.proposal.prpTmain.operateEndDate = $filter('date')(new Date(),'yyyy-MM-dd');//制单截止日期
                $scope.paginationConfmm.totalItems = "";
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {//如果当前页有变动
                        if ($scope.paginationConfmm.totalItems == 0 || $scope.paginationConfmm.totalItems == undefined) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.proposal.prpTmain.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.proposal.prpTmain.pageSize = $scope.paginationConfmm.itemsPerPage;
                            queryProposalListInfoByConditon();
                        }
                    }
                }
            };
            initPage2();
            //展开更多查询条件
            $scope.uploadfileShow = false;
            $scope.addFrom = function () {
                $scope.uploadfileShow = !$scope.uploadfileShow;
            };

            // 总保险金额的数字校验
            $scope.pressDecimal = function ($event) {
                if (($event.keyCode >= 48 && $event.keyCode <= 57) || $event.keyCode == 46) {
                    return true;
                } else {
                    $event.preventDefault();
                }
            }
            //单选
            //$scope.checked1 = [];
            $scope.selectOne = function (index) {
                if ($scope.proposal.prpTmain.proposalType === '1') {
                    $scope.businessNo = $scope.proposal.QueryList[index].proposalNo;
                    $scope.businessType = "UW150"
                } else if ($scope.proposal.prpTmain.proposalType === '2') {
                    $scope.businessNo = $scope.proposal.QueryList[index].policyNo;
                    $scope.businessType = "PRPALL_CB"
                } else {
                    $scope.businessNo = $scope.proposal.QueryList[index].endorseNo;
                    $scope.businessType = "PRPALL_PG"
                }
            };

            //上传影像
            $scope.upLoading = function () {
                console.log("影像上传");
                if (!$scope.businessNo || $scope.businessNo == null || $scope.businessNo == '') {
                    layer.open({
                        scrollbar: false,
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择一个业务号！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            layer.close(index);
                        }
                    });
                    return;
                }
                $$finder.find("transportXML", {
                    "businessNo": $scope.businessNo,
                    "loginUserCode": $rootScope.user.userCode,
                    "loginUserName": $rootScope.user.userName,
                    "loginComCode": $rootScope.user.loginComCode,
                    "loginComName": $rootScope.loginComCName
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            console.log("transportXML", data);
                            var responseXML = data.content.responseXML;
                            var factoryUrl = $rootScope.frontEnd.prpallSunECMUrl + "/SunECM/servlet/RouterServlet";
                            ECM_POST(factoryUrl, {
                                format: 'xml',
                                code: 'ECM0001',
                                xml: responseXML
                            }, 1000, $rootScope.frontEnd.prpallSunECMKeys); // 其他参数详见接口文档
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //查看影像
            $scope.checkVideo = function (index) {
                console.log("影像查看");
                var businessNo = '';
                if ($scope.proposal.prpTmain.proposalType === '1') {
                    businessNo = $scope.proposal.QueryList[index].proposalNo;
                } else if ($scope.proposal.prpTmain.proposalType === '2') {
                    businessNo = $scope.proposal.QueryList[index].policyNo;
                } else {
                    businessNo = $scope.proposal.QueryList[index].endorseNo;
                }
                $$finder.find("transportXML", {
                    "businessNo": businessNo, //业务单号
                    "loginUserCode": $rootScope.user.userCode,
                    "loginUserName": $rootScope.user.userName,
                    "loginComCode": $rootScope.user.loginComCode,
                    "loginComName": $rootScope.loginComCName
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            console.log("transportXML", data);
                            var responseXML = data.content.responseXML;
                            var factoryUrl = $rootScope.frontEnd.prpallSunECMUrl + "/SunECM/servlet/RouterServlet";
                            ECM_POST(factoryUrl, {
                                format: 'xml',
                                code: 'ECM0002',
                                xml: responseXML
                            }, 1000, $rootScope.frontEnd.prpallSunECMKeys); // 其他参数详见接口文档
                        }
                        ;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //    查看详情
            $scope.otherpage = function (businessNo, addEditExamine) {
                if (businessNo.substring(0, 1) == 1) {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('UIproposal3107edit', {proposalNo: businessNo, addEditExamine: addEditExamine})
                } else if (businessNo.substring(0, 1) == 2) {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('UIPolicy3107show', {'policyNo': businessNo, 'norepeat': true})
                } else if (businessNo.substring(0, 1) == 3) {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('UIEndorse3107edit', {
                        editType: 'show',
                        bizNo: businessNo,
                    })
                }
            }
        }]);
});