/**
 * 支付信息录入查询页面的Controller层
 */
define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayManageQueryCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state',
        function ($rootScope,$scope,$$finder,$http,$filter,$state) {
            $scope.isQueryFlag=true;
            $scope.check={};
            $scope.payInfoCondition = {
                endorseNo: null,
                policyNo: null,
                insuredName: null,
                appliName: null,
                costType:-1,
                pageNo:0,
                pageSize:0
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
            $scope.checkpolicyNo= function ($event,str) {
                //保单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.policyNo="保单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.policyNo="保单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.policyNo="";
                    }
                }else{
                    $scope.check.policyNo="";
                }
            }
            //返回
            $scope.return=function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('dashboard')
            }


            //批单号校验
            $scope.checkendorseNo= function ($event,str) {
                //批单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.endorseNo="批单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.endorseNo="批单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.endorseNo="";
                    }
                }else{
                    $scope.check.endorseNo="";
                }
            }
            //投保人姓名校验
            $scope.checkinsuredName= function ($event,str) {
                //投保人名称
                var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str){
                    if(!appliNameReg.test(str)){
                        $scope.check.insuredName="投保人名称格式错误，请修改！";
                        $event.target.focus();
                    }
                }else{
                    $scope.check.insuredName=""
                }
            }
            //被保险人校验
            $scope.checkappliName= function ($event,str) {
                //被保险人名称
                var insuredNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!insuredNameReg.test(str)){
                    $scope.check.appliName="被保险人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.appliName="";
                }
            }
            //提交查询信息
            $scope.totalItems=0;
            $scope.submit=function(){
                if($scope.isQueryFlag){
                    $scope.payInfoCondition.pageNo=$scope.paginationConfmm.currentPage=1;
                    $scope.payInfoCondition.pageSize=$scope.paginationConfmm.itemsPerPage=20;
                }else{
                    $scope.payInfoCondition.pageNo=$scope.paginationConfmm.currentPage;
                    $scope.payInfoCondition.pageSize=$scope.paginationConfmm.itemsPerPage;
                    $scope.isQueryFlag=true;
                }
                if ($scope.payInfoCondition.costType == -1){
                    showMessage('费用类型不能为空！');
                    return;
                }
                $$finder.find('queryModifyPayInfo',$scope.payInfoCondition, {
                    success: function (data) {
                        $scope.QueryList = data.content.content;
                        $scope.totalItems = data.content.totalCount;
                        //查询结果条数
                        $scope.paginationConfmm.totalItems =  $scope.totalItems;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //重置表单
            $scope.reset=function(){
                $scope.payInfoCondition = {
                    endorseNo: null,
                    policyNo: null,
                    insuredName: null,
                    appliName: null,
                    costType:-1
                };
            };

            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange : function () {
                        if ($scope.paginationConfmm.totalItems != 0){
                            $scope.isQueryFlag=false;
                            $scope.submit();
                        }
                    }
                };
            };

            initPage2();

            $scope.paginationConfmm.totalItems =  $scope.totalItems;
            if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
                $scope.paginationConfmm.totalItems=0;
            }

            // 查看支付详细信息
            $scope.showView = function (endorseInfo) {
                getPayInfoDetails(endorseInfo, function (data) {
                    var payType = data.prpPaySubDto.payType;
                    if (payType == '0') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayWhole', {
                            viewType: 'view',
                            endorseInfo: [endorseInfo],
                            endorse: data.prpPayMainDtos[0]
                        })
                    } else if (payType == '1') {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPrPoEnPayDetail', {
                            viewType: 'view',
                            endorseInfo: endorseInfo,
                            endorse: data.prpPayMainDtos
                        })
                    } else {
                        showMessage('该支付信息的支付类型有误！' + payType);
                    }
                })
            };

            // 查询支付详细信息
            var getPayInfoDetails = function (endorseInfo, success) {
                $$finder.find('queryPayInfoDetails', {
                    endorseNo: endorseInfo.endorseNo,
                    costType: endorseInfo.costTypeCode
                }, {
                    success: function (data) {
                        if (data.code == '0000'){
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