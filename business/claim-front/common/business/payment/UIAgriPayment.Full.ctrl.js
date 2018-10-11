/**
 * DESC       : 国元农险理赔支付信息管理查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              zhaowenjie    12.8          整单支付
 */
define([
    'app',
    'constants',
    'layer', 'jsonDB'
], function (app, constants, layer,jsonDB) {
    'use strict';
    app.registerController('UIAgriPaymentFullCtrl', ['$rootScope', '$scope', '$$finder','regexpConstants',
        '$stateParams','$state', '$http', '$filter','$compile','$modal',
        function ($rootScope, $scope, $$finder, regexpConstants,$stateParams,$state,$http,$filter,$compile,$modal) {//$location,
            $scope.queryDto = {}; // 查询条件
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData = regexpConstants;
            $scope.prpLregist = {}; // 查询结果
            //赔款信息总金额
            $scope.queryDto.payAmount = 0;
            var editType = $stateParams.editType;
            var paymentNo = $stateParams.paymentNo;
            var initData = function() {
                if (editType == "SHOW") {
                    $scope.showFlag = true;
                }
                //else {$scope.showFlag=false}

                if(editType=="SHOW1"){
                    $scope.showFlag = true;
                }
                //else {$scope.showFlag=false}

                if (editType == "EDIT" || editType == "SHOW"||editType=="SHOW1") {
                    var keyMap = {
                        "paymentNo": paymentNo
                    };
                    $$finder.post('queryInitEntirePay', keyMap).then(
                        function (data) {
                            console.log("===========EDIT/SHOW=============");
                            console.log(data);
                            $scope.prpLregist = data.paymentMessageDtoList;
                            $scope.payPurposeDtoList = data.payPurposeDtoList;
                            $scope.queryDto = data.prpLPayMainDto;
                            $scope.queryDto.bankAccount2 = data.prpLPayMainDto.bankAccount;
                            /*$scope.queryDto.certifType.codeType = data.prpLPayMainDto.certifType;
                            $scope.queryDto.receiverTypeOther.codeType = data.prpLPayMainDto.receiverTypeOther;
                            $scope.queryDto.urgentType.codeType = data.prpLPayMainDto.urgentType;*/
                            var sumPayAmount = 0;
                            angular.forEach(data.paymentMessageDtoList, function (info) {
                                sumPayAmount += Number(info.payAmount);
                            });
                            $scope.queryDto.payAmount = sumPayAmount;
                        }
                    )
                } else if (editType == "ADD") {
                    var registDtoList = JSON.parse($stateParams.registDtoList);
                    console.log("=============ADD==============");
                    console.log(registDtoList);
                    $scope.prpLregist = registDtoList;
                    var sumPayAmount = 0;
                    angular.forEach(registDtoList, function (info) {
                        sumPayAmount += Number(info.payAmount);
                    });
                    $scope.queryDto.payAmount = sumPayAmount;
                }
            };
            initData();
            // 单选框数据
            $scope.radioList = [
                {
                    "code": 1,
                    "name": "个人账号",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "单位账号",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText=[];
            $scope.radioList1 = [
                {
                    "code": 1,
                    "name": "银行卡",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "存折",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 3,
                    "name": "对公账号",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText1=[];
            $scope.radioList2 = [
                {
                    "code": 1,
                    "name": "第三方支付",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "传统方式支付",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText2=[];
            /** 复选框数据 */
            $scope.RECEIVERTYPE = [
                {"codeType":"","codeName":"请选择"},
                {"codeType":"t1","codeName":"被保险人"},
                {"codeType":"t2","codeName":"投保人"},
                {"codeType":"t2","codeName":"收益人"},
                {"codeType":"t2","codeName":"其他个人"},
                {"codeType":"t3","codeName":"其他单位"}
            ];
            $scope.CERTITYPE = [
                {"codeType":"","codeName":"请选择"},
                {"codeType":"01","codeName":"居民身份证"},
                {"codeType":"02","codeName":"居民户口簿"},
                {"codeType":"03","codeName":"驾驶证"},
                {"codeType":"04","codeName":"军官证"},
                {"codeType":"05","codeName":"士兵证"},
                {"codeType":"06","codeName":"军官离退休证"},
                {"codeType":"07","codeName":"中国护照"},
                {"codeType":"08","codeName":"异常身份证"},
                {"codeType":"41","codeName":"港澳通行证"},
                {"codeType":"42","codeName":"台湾通行证"},
                {"codeType":"43","codeName":"回乡证"},
                {"codeType":"51","codeName":"外国护照"},
                {"codeType":"52","codeName":"旅行证"},
                {"codeType":"53","codeName":"居留证件"},
                {"codeType":"71","codeName":"组织机构代码证"},
                {"codeType":"72","codeName":"税务登记证"},
                {"codeType":"73","codeName":"营业执照"},
                {"codeType":"99","codeName":"其他证件"}
            ];
            $scope.URGENTTYPE = [
                {"codeType":"0.5","codeName":"30分钟"},
                {"codeType":"1","codeName":"1小时"},
                {"codeType":"2","codeName":"2小时"},
                {"codeType":"3","codeName":"3小时"},
                {"codeType":"4","codeName":"4小时"},
                {"codeType":"8","codeName":"8小时"},
                {"codeType":"24","codeName":"24小时"},
                {"codeType":"48","codeName":"48小时"}
            ];

            /** 提交暂存 */
            $scope.submit = function (nodeStatus) {
                /*if(!$scope.queryDto.receiverTypeOther){
                    layerMsg("请录入领款人类型！");
                    return false;
                }*/

                $scope.flag=false;
                if(!$scope.queryDto.receiverFullName){
                    layerMsg("请录入领款人名称！");
                    return false;
                }
                if(!$scope.queryDto.certifType){
                    layerMsg("请选择领款人证件类型！");
                    return false;
                }
                if(!$scope.queryDto.certifNo){
                    layerMsg("请录入证件号码！");
                    return false;
                }
                $scope.queryDto.provinceCode = $('#pro').val();
                $scope.queryDto.cityCode = $('#btn_hukou').val();
                $scope.queryDto.bankType = $('#bankType').val();
                if(!$scope.queryDto.provinceCode){
                    layerMsg("请录入省份名称！");
                    return false;
                }
                if(!$scope.queryDto.cityCode){
                    layerMsg("请录入城市名称！");
                    return false;
                }
                /*if(!$scope.queryDto.accountFlag){
                    layerMsg("请选择账号属性！");
                    return false;
                }*/
                if(!$scope.queryDto.bankType){
                    layerMsg("请录入银行大类！");
                    return false;
                }
                if(!$scope.queryDto.bank){
                    layerMsg("请录入开户银行！");
                    return false;
                }
                if(!$scope.queryDto.bankAccount){
                    layerMsg("请录入银行账号！");
                    return false;
                }
                if(!$scope.queryDto.bankAccount2){
                    layerMsg("请录入确认银行账号！");
                    return false;
                }
                if($scope.queryDto.bankAccount != $scope.queryDto.bankAccount2){
                    layerMsg("两次录入的银行账号不同，请重新输入！");
                    return false;
                }
                /*if(!$scope.queryDto.accountType){
                    layerMsg("请选择账号类型！");
                    return false;
                }*/
                if(!$scope.queryDto.mobilePhone){
                    layerMsg("请录入手机号码！");
                    return false;
                }
                if(!$scope.queryDto.address){
                    layerMsg("请录入详细地址！");
                    return false;
                }
                if(!$scope.queryDto.payWay){
                    layerMsg("请选择支付方式！");
                    return false;
                }
                var paySaveDto = {};
                //支付信息对象
                var prpLPayMainDto = angular.copy($scope.queryDto);
                /*prpLPayMainDto.certifType = prpLPayMainDto.certifType.codeType;
                prpLPayMainDto.receiverTypeOther = prpLPayMainDto.receiverTypeOther.codeType;
                prpLPayMainDto.urgentType = prpLPayMainDto.urgentType.codeType;*/
                paySaveDto.prpLPayMainDto = prpLPayMainDto;
                //提交信息
                paySaveDto.billFlag = "0";//整单支付
                paySaveDto.comCode = $rootScope.user.loginComCode;
                paySaveDto.userCode = $rootScope.user.userCode;
                paySaveDto.thirdPayFlag = nodeStatus;//暂存或提交
                //案件信息
                paySaveDto.paymentMessageDtoList = angular.copy($scope.prpLregist);
                //审核信息
                var payPurposeDtoList = [{}];
                payPurposeDtoList[0].context = $scope.newContext;
                paySaveDto.payPurposeDtoList = payPurposeDtoList;
                $$finder.post('savePayMain', paySaveDto).then(
                    function (data) {
                        $scope.queryDto.paymentNo = data.businessNo;
                        if(!data.message){
                            if(nodeStatus=="0"){
                                layerMsg("暂存成功！");
                            }else{
                                layerMsg("提交成功！");
                                $scope.flag=true;
                            }
                            $state.go('UIAgriPaymentQueryInput');
                        }else{
                            layerMsg(data.message);
                           // $scope.flag=true;
                        }
                    }
                );
            };
            /** 返回 */
            $scope.goBack = function () {
                if (editType == "SHOW"||editType=="EDIT") {
                    // $state.go('UIAgriPaymentQueryInput');
                    $state.go("UIAgriPaymentQuery");
                }
                 if(editType=="ADD"){
                    $state.go('UIAgriPaymentQueryInput');
                }
                 if (editType=="SHOW1"){
                    $state.go("UIAgriPaymentStatisticsList");
                } else {
                     $state.go("UIAgriPaymentQuery");
                 }


            }
                ;

            //银行卡开户行默认为银行大类
            var orgBank ;
            var ifDis;
            $scope.proBank = function(){
                var bankType = $("input[name='bankType']").val();
                var accountFlag = $("input:radio[name=accountFlag]:checked").val();//$(obj).val();
                if(accountFlag=="00"){
                    orgBank = $("input[name='bank1']").val();
                    $("input[name='bank1']").val(bankType);
                    $("input[name='bank']").val(bankType);
                    $("input[name='bank1']").attr('disabled','true');
                    ifDis = true;
                }else{

                    if(ifDis){
                        $("input[name='bank1']").val(orgBank);
                        $("input[name='bank']").val(orgBank);
                        orgBank = "";
                    }else{
                        orgBank = $("input[name='bank1']").val();
                        $("input[name='bank1']").val(orgBank);
                        $("input[name='bank']").val(orgBank);
                    }
                    $("input[name='bank1']").attr('disabled','');

                    ifDis = false;
                }
            };
            $scope.SynchAccount = function (){
                $modal.open({
                    templateUrl: 'common/business/payment/UIAgriPayment.SynchAccount.tpl.html',
                    resolve: {
                        registNos: function (){
                            var registNos = [];
                            angular.forEach($scope.prpLregist,function(data){
                                registNos.push(data.registNo);
                            });
                            return registNos;
                        }
                    },
                    controller: function ($scope,$modalInstance,registNos) {
                        var initSynchAccount = function (){
                            $$finder.post('syncyAccount',registNos).then(function(returnValue){
                                if(returnValue &&
                                    typeof(returnValue)!='string'){
                                    $scope.payAccountList = returnValue;
                                }
                            });
                        };
                        initSynchAccount();
                        var ret = new Array();
                        $scope.chooseOne1 = function (obj){
                            ret[0] = "true";
                            var accountName = $(obj).parent().find("input[name='account']").val();
                            ret[1] =accountName;
                            var bank = $(obj).parent().find("input[name='bank']").val();
                            ret[2] =bank;
                            $rootScope.$broadcast('updateAccount',obj);
                            $scope.closeModal();
                        };
                        window.returnValue = ret;

                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };

            $rootScope.$on('updateAccount',function (event,obj) {
                $scope.queryDto.bank = obj.bank;
                $scope.queryDto.bankAccount = obj.account;
                $scope.queryDto.bankAccount2 = obj.account;
                $scope.queryDto.receiverFullName = obj.recei
            });

        }]);
});