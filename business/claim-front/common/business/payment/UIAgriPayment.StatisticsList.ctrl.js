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
    app.registerController('UIAgriPaymentStatisticsListCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$filter','regexpConstants','$$commonality','$window',
        function ($rootScope, $scope, $location, $state, $$finder,$filter, regexpConstants,$$commonality,$window) {
            $scope.payment = {
                prplpay:{},
                prplregist:{},
                prpLcompensate:{},
                prplpaymain:{},
                payStatistics:{}
            };//查询条件
            $scope.paymentList = null;

            var initPage = function(){
                $scope.queryDto = {
                    "compensateNo":"",//计算书号
                    "registNo":"",//报案号码
                    "policyNo":"",//保单号码
                    "payType":"",//支付类型
                    "paymentType":"",//赔款类型
                    "insuredName":"",//被保险人
                    "thirdPayFlag":"",//处理状态
                    "caseType":"",//案件类型（本机构、代查勘）
                    "payRefReason":"",//赔款类型
                    "underWriteEndDateStart":"",//核赔通过时间
                    "underWriteEndDateEnd":""//核赔通过时间
                };
                $scope.queryDto.underWriteEndDateEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                $scope.queryDto.underWriteEndDateStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                $scope.hover = false;
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
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    Combine: 0, // 总共有多少条记录
                    itemsPerPage : 10, // 每页展示的数据条数
                    perPageOptions : [ 10, 20, 30, 40,50 ],
                    onChange : function () {//值回调
                        getFileList();
                    }
                };
            };
            initPage();
            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                if (dto.paymentType){
                    if("else"==dto.paymentType.codeType){
                        dto.paymentType = "not in ('P60','GS60','P63','P62','P64','P61','F67','P65','P68')";

                    }else{
                        dto.paymentType = "='"+dto.paymentType.codeType+"'";
                    }
                }
                if(dto.thirdPayFlag){
                    dto.thirdPayFlag = dto.thirdPayFlag.codeType;
                }
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                if( dto.underWriteEndDateStart&&!dto.underWriteEndDateEnd) {
                    dto.underWriteEndDateEnd = $filter('date')(new Date(), 'yyyy-MM-dd')
                }
                //提交查询
                $$finder.post('queryPaymentStatistics', dto).then(
                    function (data) {
                        $scope.paymentList = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };

            $scope.changeendorseNo= function (str) {
                if ($scope.queryDto.policyNo || $scope.queryDto.registNo||$scope.queryDto.compensateNo) {
                    $scope.queryDto.underWriteEndDateStart = "";
                    $scope.queryDto.underWriteEndDateEnd = "";
                } else {
                    $scope.queryDto.underWriteEndDateEnd =$filter('date')(new Date(),'yyyy-MM-dd');//申请时间止期
                    $scope.queryDto.underWriteEndDateStart =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//申请时间起期
                }
            };
            $scope.query= function () {
                var querySpecialflag = $$commonality.inspectEmpty('agriPaymentForm');
                if($scope.queryDto.thirdPayFlag){
                    $scope.queryDto.thirdPayFlag = $scope.queryDto.thirdPayFlag.codeType;
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
                if(!$scope.queryDto.underWriteEndDateStart && $scope.queryDto.underWriteEndDateEnd){
                    layerMsg("请输入核赔通过时间起期！");
                    return;
                }
                if ($scope.agriPaymentForm.$valid) {
                    //案件类型入参判断
                    if ($scope.infoToView.typeCase.typeCaseComCode) {
                        $scope.queryDto.caseType = "='" + $scope.user.loginComCode + "'";//案件类型
                    } else if ($scope.infoToView.typeCase.typeCaseNot) {
                        $scope.queryDto.caseType = "<>'" + $scope.user.loginComCode + "'";//案件类型
                    }
                    if ($scope.infoToView.typeCase.typeCaseComCode && $scope.infoToView.typeCase.typeCaseNot) {
                        $scope.queryDto.caseType = "";
                    }
                    //支付类型入参判断
                    else if ($scope.infoToView.typePayment.typePaymentP3) {
                        $scope.queryDto.payType = "C";
                    } else if ($scope.infoToView.typePayment.typePaymentP1) {
                        $scope.queryDto.payType = "Y";
                    }
                    if ($scope.infoToView.typePayment.typePaymentP3 && $scope.infoToView.typePayment.typePaymentP1) {
                        $scope.queryDto.payType = "C','Y";//支付类型
                    }
                }
                getFileList();
            };

            // 多选框数据
            $scope.checkBoxData = [
                {
                    "code": 1,
                    "name": "核赔通过未支付",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "待提交",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 3,
                    "name": "待审核",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 4,
                    "name": "审核不通过",
                    "checked": false,
                    "class":"detail-reason"
                },{
                    "code": 5,
                    "name": "支付中心待处理",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 6,
                    "name": "支付中心待退回",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 7,
                    "name": "已打包审核",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 8,
                    "name": "打包审核通过待发送",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 9,
                    "name": "已提交银行",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 10,
                    "name": "银行打回",
                    "checked": false,
                    "class":"detail-reason"
                },{
                    "code": 11,
                    "name": "支付成功",
                    "checked": false,
                    "class":"detail-reason"
                },{
                    "code": 12,
                    "name": "默认成功",
                    "checked": false,
                    "class":"detail-reason"
                },{
                    "code": 13,
                    "name": "银行退回支付中心",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            /** 下拉选 */
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
            $scope.checkedList=[];
            /** 查看更多 */
            $scope.goSee = function(result) {
                $state.go('UIAgriPaymentStatisticsDetailList', {
                    compensateNo: result.compensateNo,
                    payrefReason: result.paymentType
                });
            };
            //说明文字展示隐藏
            //$scope.explain=false;
            $scope.indexFlag=-1;
            $scope.showDetail = function ($event,result,index) {
                var dto={};
                dto.compensateNo = result.compensateNo;
                dto.paymentType = result.paymentType;
                $$finder.post("queryOnTheWayList",dto).then(
                    function(onTheWayList){
                        $scope.onTheWayList = onTheWayList;
                        //$scope.hover = true;
                        $scope.indexFlag=index;
                        var styleElement = document.getElementsByName('onTheWay')[index];
                        if (!styleElement) {
                            debugger;
                            styleElement = document.createElement('style');
                            //styleElement.type = 'text/css';
                            styleElement.top = styleElement.top;
                            document.getElementById('onTheWayDiv').appendChild(styleElement);
                        }
                });
            };
            $scope.hideDetail = function ($event) {
                //$scope.hover = false;
                $scope.indexFlag=-1;
            };

            $scope.exp = function (){
                var dto = angular.copy($scope.queryDto);
                if (dto.paymentType){
                    if("else"==dto.paymentType.codeType){
                        dto.paymentType = "not in ('P60','GS60','P63','P62','P64','P61','F67','P65','P68')";

                    }else{
                        dto.paymentType = "='"+dto.paymentType.codeType+"'";
                    }
                }
                if(dto.thirdPayFlag){
                    dto.thirdPayFlag = dto.thirdPayFlag.codeType;
                }
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                if( dto.underWriteEndDateStart&&!dto.underWriteEndDateEnd) {
                    dto.underWriteEndDateEnd = $filter('date')(new Date(), 'yyyy-MM-dd')
                }
                $$finder.post("paymentStatisticsExportExcel",dto).then(
                    function (data) {
                        if(data.shortLinkId){
                            $window.open(data.shortLinkId);
                        }else {
                            layerMsg("导出失败！");
                        }
                    })
            };
            /** 返回 */
            $scope.goBack = function () {
                $rootScope.back();
            };
            //
        }]);
});