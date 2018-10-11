/**
 * DESC       : 国元农险理赔支付信息修改提交页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              gaoxiaowei      12.9          清单支付
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPaymentChangeCtrl', ['$rootScope', '$scope', '$$finder', '$stateParams', '$filter', '$state',
        function ($rootScope, $scope, $$finder, $stateParams, $filter, $state) {
            $scope.prpLaccountBankShow = true;//开户行联行号
            $scope.accountPresidiShow = false;//控制 银行代码，银行名称，省市代码，省市名称，卡折
            $scope.settlementShow = false;//结算方式
            $scope.getBankCode=function(AccountCode,CantonalCode){
                if(!AccountCode||!CantonalCode){
                    return
                }
                $$finder.post('relatebankCode',{
                    prpLsumpayAccountCode:AccountCode,
                    prpLsumpayCantonalCode:CantonalCode
                }).then(function(data){
                    $scope.relatebankList=data;
                    console.log(data)
                })
            }

            //获取省/市代码
            var getPovinceCode=function(){
                $$finder.post('povinceStandardCode').then(function(data){
                    $scope.povinceList=data
                })
            };
            getPovinceCode()
            //获取市/区代码
            $scope.getCantonalList=function(code){
                $$finder.post('povinceStandardCode',{codeCode:code}).then(function(data){
                    $scope.cantonalList=data
                })
            };
            var init = function () {
                var initData = JSON.parse($stateParams.data)
                $$finder.post('execute', initData).then(function (data) {
                    console.log(data)
                    $scope.paymentSetMent = data;
                    var maindto = $scope.paymentSetMent.prpcmainDto;
                    var setMent = $scope.paymentSetMent;
                    $scope.paymentSetMent.date = maindto.startDate + '日' + maindto.startHour + '时起 至' + maindto.endDate + '日' + maindto.endHour + '时止'
                    setMent.prpLClaimDto.damageStartDate = $filter('date')( setMent.prpLClaimDto.damageStartDate , 'yyyy-MM-dd');
                    if(setMent.atsLossSwitchCode==1){
                        $scope.prpLaccountBankShow = false;//开户行联行号
                        $scope.accountPresidiShow = true;//控制 银行代码，银行名称，省市代码，省市名称，卡折
                        $scope.settlementShow = true;//结算方式
                        if(setMent.prpLsumpayDto.payType=='02'){
                            $scope.settlementShow = false;//结算方式
                        }
                    }else{
                        if (setMent.editType=='SHOW'||setMent.centerPaySwitchCode!='1'){
                            $scope.prpLsumpayDtoShow  = false;
                        }
                    }
                    $scope.getBankCode(setMent.prpLsumpayDto.accountCode,setMent.prpLsumpayDto.presidial)
                })
                $$finder.post('aTSAreaCode').then(function (data) {
                    $scope.aTSAreaCodeList = data;
                    debugger
                })
                // 银行
                $$finder.post("queryByConditions",
                    {
                        codeType: 'ATSBankCode'
                    }
                ).then(function (data) {
                        if (data) {
                            $scope.BankList = data;
                        }
                    }, function (error) {

                    });
            };
            init()
            $scope.getModelName = function (name, type) {
                $scope.paymentSetMent.prpLsumpayDto[type] = name
            }

            $scope.save = function (saveType) {
                var paymentSetMent = angular.copy($scope.paymentSetMent)
                var saveDto = {
                    editType: 'EDIT',
                    nodeType: 'VERIFY',
                    saveType: saveType,
                    prpLsumpaySerialNo: paymentSetMent.prpLsumpayDto.serialNo,//序号
                    prpLsumpayClaimNo: paymentSetMent.prpLsumpayDto.claimNo,//立案号
                    prpLaccountBank: paymentSetMent.prpLsumpayDto.accountBank,//开户行
                    prpLaccountName: paymentSetMent.prpLsumpayDto.accountName,//账户名
                    prpLaccountNo: paymentSetMent.prpLsumpayDto.accountNo,//账号
                    accountPropertyFlag: paymentSetMent.prpLsumpayDto.getFlag,//账号属性
                    prplsumpayRemarkInfo: paymentSetMent.prpLsumpayDto.remarkInfo,//付款备注信息
                    atsLossSwitch: paymentSetMent.atsLossSwitch,//资金平台开关
                    atsChargeSwitch: paymentSetMent.atsChargeSwitch,//资金平台开关
                    payTypeCode: paymentSetMent.prpLsumpayDto.PayType,//不清楚by GXW去找-->周科宇
                    cardType: paymentSetMent.prpLsumpayDto.CardType,//卡/折标识
                    settlementMode: paymentSetMent.prpLsumpayDto.SettlementMode,//结算方式
                    prpLsumpayAccountCode: paymentSetMent.prpLsumpayDto.accountCode,//银行代码
                    prpLsumpayPresidialCode: paymentSetMent.prpLsumpayDto.presidial,//省/直辖市代码
                    prpLsumpayPresidialName: paymentSetMent.prpLsumpayDto.presidialName,//省/直辖市名
                    prpLsumpayCantonalCode: paymentSetMent.prpLsumpayDto.presidial,//省市/区号(ps:跟省一样)
                    prpLsumpayCantonalName: paymentSetMent.prpLsumpayDto.presidialName,//省市/区名
                    prpLsumpayAccountName: paymentSetMent.prpLsumpayDto.accountName,//集中支付
                    prpLsumpayRelatebankCode: paymentSetMent.prpLsumpayDto.relatebankCode,//联行号
                    prpLsumpayRelatebankName: paymentSetMent.prpLsumpayDto.relatebankName,//集中支付
                    handleText: paymentSetMent.prpLsumpayDto.opinions,//支付信息审核退回意见
                    PayMutiObject: null//集中支付修改“支付信息修改模块”不要了
                }
                $$finder.post('prplsubmitform', saveDto).then(function (data) {
                    if (data.RESULTTYPE == 200) {
                        layerMsg("提交成功");
                        $state.go('UIAgriPaymentChangeQuery')
                    }
                })
            }
        }]);

});