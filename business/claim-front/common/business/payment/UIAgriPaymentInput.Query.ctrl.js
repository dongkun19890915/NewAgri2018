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
    app.registerController('UIAgriPaymentQueryInputCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','regexpConstants','$$commonality',
        function ($rootScope, $scope, $location,$state, $$finder, regexpConstants,$$commonality) {

            $scope.checkedList = []; // 本页面选中的集合
            /**
             * 分页查询
             */
            var getFileList = function(){
                //查询条件
                var dto = angular.copy($scope.paymentMent);
                dto.pageNum = $scope.paginationConf.currentPage;
                dto.pageCount = $scope.paginationConf.itemsPerPage;
                dto.payRefReason=$scope.paymentMent.payRefReason.codeType;
                //提交查询
                $$finder.post('queryPrpJPlanFeePageMsgDto', dto).then(
                    function (data) {
                        $scope.prpLregist = data.prpJplanFeeDtoList;
                        $scope.paginationConf.totalItems = data.pageSize;
                    }
                )
            };

            /**
             * 重置
             */
            $scope.resetInformation = function () {
                $state.go($state.current.name,{},{reload:true});
                // init();
            };

            /**
             * 查询
             */
            $scope.query = function () {
                var querySpecialflag = $$commonality.inspectEmpty('agriPaymentForm');
                if($scope.paymentMent.payRefReason || $scope.paymentMent.thirdPayFlag){
                    querySpecialflag = true;
                }
                if($scope.infoToView.typeCase.typeCaseComCode || $scope.infoToView.typeCase.typeCaseNot || $scope.infoToView.typePayment.typePaymentP3 || $scope.infoToView.typePayment.typePaymentP1){
                    querySpecialflag = true;
                }
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }

                if ($scope.agriPaymentForm.$valid) {
                    //案件类型入参判断
                    if($scope.infoToView.typeCase.typeCaseComCode){
                        $scope.paymentMent.comCode = $rootScope.user.loginComCode;//案件类型  本机构
                    }else if($scope.infoToView.typeCase.typeCaseNot){
                        $scope.paymentMent.comCode = "not" + $rootScope.user.loginComCode;//案件类型  代查勘
                    }
                    if($scope.infoToView.typeCase.typeCaseComCode && $scope.infoToView.typeCase.typeCaseNot){
                        $scope.paymentMent.comCode = "";
                    }

                    //支付类型入参判断
                    else if($scope.infoToView.typePayment.typePaymentP3){
                        $scope.paymentMent.certiType = "C";
                    }else if($scope.infoToView.typePayment.typePaymentP1){
                        $scope.paymentMent.certiType = "Y";
                    }
                    if($scope.infoToView.typePayment.typePaymentP3 && $scope.infoToView.typePayment.typePaymentP1){
                        $scope.paymentMent.certiType = "C','Y";//支付类型
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

            /** 返回 */
            $scope.goBack = function () {
                $rootScope.back();
            };
            $scope.goPaymentFull = function(){
                if(!$scope.checkedList.length){
                    layerMsg("请选择至少一条支付信息！");
                    return;
                }
                var editType = "ADD";
                var registDtoList = [];
                angular.forEach($scope.checkedList, function (item) {
                    if(item.checked){
                        var dto = {};
                        dto.registNo = item.registNo;
                        dto.policyNo = item.policyNo;
                        dto.insuredName = item.insuredName;
                        dto.compensateNo = item.certiNo;
                        dto.paymentType = item.payRefReason;
                        dto.payTotalAmount = item.planFee;
                        dto.havePayAmount = item.payAmount;
                        dto.payAmount = item.thisPayAmount;
                        registDtoList.push(dto);
                    }
                });
                $state.go('UIAgriPaymentFull',{editType:editType,registDtoList:JSON.stringify(registDtoList)});//registDtoList:registDtoList
            };
            $scope.goPaymentBill = function(){
                if(!$scope.checkedList.length || $scope.checkedList.length>1){
                    layerMsg("请选择一条支付信息！");
                    return;
                }
                var editType = "ADD";
                var registDtoList = [];
                angular.forEach($scope.checkedList, function (item) {
                    if(item.checked){
                        var dto = {};
                        dto.registNo = item.registNo;
                        dto.policyNo = item.policyNo;
                        dto.insuredName = item.insuredName;
                        dto.compensateNo = item.certiNo;
                        dto.paymentType = item.payRefReason;
                        dto.payTotalAmount = item.planFee;
                        dto.havePayAmount = item.payAmount;
                        dto.payAmount = item.thisPayAmount;
                        registDtoList.push(dto);
                    }
                });
                $state.go('UIAgriPaymentBill',{editType:editType,registDtoList:registDtoList});
            };
            /** 初始化 */
            var init = function () {
                $scope.paymentMent = {
                    "certiNo":"",//计算书号
                    "registNo":"",//报案号码
                    "policyNo":"",//保单号码
                    "certiType":"",//支付类型
                    "payRefReason":"",//赔款类型
                    "insuredName":"",//被保险人
                    "comCode":"",//案件类型（本机构、代查勘）
                    "flowStartDate":"",//流入时间
                    "flowEndDate":""//流出时间
                };

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
                $scope.payRefReason = [
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
                initPage();//分页初始化
            };
            init();
        }]);
});