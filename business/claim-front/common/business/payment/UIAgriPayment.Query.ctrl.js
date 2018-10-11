/**
 * DESC       : 国元农险理赔支付信息管理查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 * sunyaohui
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPaymentQueryCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','$filter','regexpConstants','$$commonality','$window',
        function ($rootScope, $scope, $location,$state, $$finder,$filter, regexpConstants,$$commonality,$window) {

            /**
             * 分页查询
             */
            var getFileList = function(){
                //查询条件
                var dto = angular.copy($scope.paymentMent);//prplPayDto
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                dto.paymentType=$scope.paymentMent.paymentType.codeType;
                dto.thirdPayFlag=$scope.paymentMent.thirdPayFlag.codeType;
                $scope.regData = regexpConstants;
                if($scope.paymentMent.flowStartDate&&!$scope.paymentMent.flowEndDate){
                    dto.flowEndDate=$filter('date')(new Date(),'yyyy-MM-dd')
                }
                //提交查询
                $$finder.post('queryPrplPayDtoByCondition', dto).then(
                    function (data) {
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };

            /**
             * 重置
             */
            $scope.resetInformation = function () {
                init();
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.paymentMent.policyNo || $scope.paymentMent.registNo||$scope.paymentMent.compensateNo) {
                    $scope.paymentMent.flowStartDate = "";
                    $scope.paymentMent.flowEndDate = "";
                } else {
                    $scope.paymentMent.flowEndDate =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.paymentMent.flowStartDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }

            }

            /**
             * 查询
             */
            $scope.query = function () {
                var querySpecialflag = $$commonality.inspectEmpty('agriPaymentForm');
                if ($scope.paymentMent.paymentType || $scope.paymentMent.thirdPayFlag){
                    querySpecialflag = true;
                }
                if ($scope.infoToView.typeCase.typeCaseComCode || $scope.infoToView.typeCase.typeCaseNot ||
                    $scope.infoToView.typePayment.typePaymentP3 || $scope.infoToView.typePayment.typePaymentP1){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
               if(!$scope.paymentMent.flowStartDate && $scope.paymentMent.flowEndDate){
                  layerMsg("请输入流入时间起期！");
                  return;
               }

                if ($scope.agriPaymentForm.$valid) {
                    //案件类型入参判断
                    if($scope.infoToView.typeCase.typeCaseComCode){
                        $scope.paymentMent.comCode = $scope.user.userCode;//案件类型
                    }else if($scope.infoToView.typeCase.typeCaseNot){
                        $scope.paymentMent.comCode = "not" + $scope.user.userCode;//案件类型
                    }
                    if($scope.infoToView.typeCase.typeCaseComCode && $scope.infoToView.typeCase.typeCaseNot){
                        $scope.paymentMent.comCode = "";
                    }
                    //支付类型入参判断
                    else if($scope.infoToView.typePayment.typePaymentP3){
                        $scope.paymentMent.payType = "'P3'";
                    }else if($scope.infoToView.typePayment.typePaymentP1){
                        $scope.paymentMent.payType = "'P1'";
                    }
                    if($scope.infoToView.typePayment.typePaymentP3 && $scope.infoToView.typePayment.typePaymentP1){
                        $scope.paymentMent.payType = "'P3','P1'";//支付类型
                    }
                    getFileList();
                }
            };

            /**
             * 分页初始化
             */
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

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

            $scope.goNext = function(){
                $state.go('UIAgriPaymentQueryInput')
            };
            $scope.goModify = function(result,edit){
                $state.go('UIAgriPaymentFull',{
                    editType: edit,
                    paymentNo: result.serialNo
                })
            };
            $scope.goSee = function(result,edit) {
                $state.go('UIAgriPaymentFull', {
                    editType: edit,
                    paymentNo: result.serialNo
                });
            };
            $scope.goDownload = function(result) {
                var url = 'downloadReceipt';
                var keywords = {
                    paymentNo:result.serialNo
                };
                $$finder.post(url,keywords).then(
                    function (data) {
                        if(data && data.url){
                            $window.open(data.url);
                        }else if(data && data.shortLink){
                            $window.open(data.shortLink);
                        }else if(data.code == '9999'){
                            layerMsg("下载失败，"+data.message);
                        }else {
                            layerMsg("下载失败");
                        }
                    }
                )
            };

            /**
             * 初始化
             */
            var init = function () {
                $scope.paymentMent = {
                    "compensateNo":"",//计算书号
                    "registNo":"",//报案号码
                    "policyNo":"",//保单号码
                    "billNo":"",//批次号
                    "serialNo":"",//支付单号
                    "payType":"",//支付类型
                    "paymentType":"",//赔款类型
                    "insuredName":"",//被保险人
                    "thirdPayFlag":"",//处理状态
                    "comCode":"",//案件类型（本机构、代查勘）
                    "payRefReason":"",//赔款类型
                    "flowStartDate":"",//流入时间
                    "flowEndDate":""//流出时间
                };
                $scope.paymentMent.flowEndDate =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                $scope.paymentMent.flowStartDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
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

                //赔款类型
                $scope.PAYMENTTYPE = [
                    // {"codeType":"","codeName":"请选择"},
                    {"codeType":"P60","codeName":"赔款"},
                    {"codeType":"GS60","codeName":"代付共保赔款"},
                    {"codeType":"P63","codeName":"施救费"},
                    {"codeType":"P62","codeName":"查勘费"},
                    {"codeType":"P64","codeName":"诉讼费"},
                    {"codeType":"P61","codeName":"检验鉴定费"},
                    {"codeType":"F67","codeName":"公估费"},
                    {"codeType":"P65","codeName":"系统内代查勘"},
                    {"codeType":"P68","codeName":"律师费"},
                    {"codeType":"else","codeName":"其他"}
                ];

                //处理状态
                $scope.THIRDPAYFLAG = [
                    // {"codeType":"","codeName":"请选择"},
                    {"codeType":"0","codeName":"正在处理"},
                    {"codeType":"1","codeName":"已处理"},
                    {"codeType":"2","codeName":"审核退回"},
                    {"codeType":"3","codeName":"审核通过"},
                    {"codeType":"2","codeName":"审核不通过"},
                    {"codeType":"6","codeName":"支付中心处理中"},
                    {"codeType":"4","codeName":"支付中心退回"},
                    {"codeType":"9","codeName":"支付成功"},
                    {"codeType":"8","codeName":"已作废"}
                ];

                initPage();//分页初始化

            };
            init();
        }]);
});