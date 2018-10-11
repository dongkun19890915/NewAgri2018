define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnOtherCtrl', ['$rootScope', '$scope', '$$finder', '$http','commonApiServ', '$filter', '$$code',
        function ($rootScope, $scope, $$finder, $http,commonApiServ, $filter, $$code) {
            $scope.coins = {}
            $scope.proposal.prpTcoinsSchema ={}
            $scope.proposal.prpTcoinsSchema.proportionFlag1 ='1';//手续费计入方式，默认全额计入
            $scope.proposal.prpTcoinsSchema.proportionFlag2 ='1';//特殊因子计入方式，默认全额计入
            $scope.proposal.prpTcoinsDtoList = [];
            $scope.proposal.prpTplanCoinsDtoList=$scope.proposal.prpTplanCoinsDtoList||[]
            //初始化数据
            var initData = function (index) {
                $scope.proposal.prpTcoinsDtoList[index].coinsType = '3'
                $scope.proposal.prpTcoinsDtoList[index].chiefFlag = '0'
            }
            var dataObj;
            var initData2 = function (index) {
                dataObj = $scope.proposal.prpTcoinsDtoList[index]
                dataObj.coinsType = '1';
                if(index==0){
                    dataObj.chiefFlag = '2';
                    dataObj.coinsName='共保合计';
                    dataObj.coinsCode='0';
                    dataObj.coinsRate='100';
                }else{
                    dataObj.chiefFlag = '1';
                }
                if(index!=0){ dataObj.coinsName = $scope.proposal.prpTmainDto.comCName;
                    dataObj.coinsCode = $scope.proposal.prpTmainDto.comCode
                    dataObj.coinsSumAmount = 0;
                    dataObj.coinsSumPremium = 0;}
                if (index != 0) {
                    dataObj.coinsSumAmount = $scope.proposal.prpTfeeDto.amount1 || 0;
                    dataObj.coinsSumPremium = $scope.proposal.prpTfeeDto.premium1 || 0
                }
                if (index == 0) {
                    dataObj.coinsType = null;
                }
            }
            //监听投保单录入页面的保额保费是否变化，如果变化则需要把值绑定到共保信息中
            $scope.$watch("proposal.prpTfeeDto.premium1+proposal.prpTfeeDto.amount1",function(){
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                   if(data.serialNo=="2"){//给我方信息赋值
                       data.coinsSumAmount = $scope.proposal.prpTfeeDto.amount1;
                       data.coinsSumPremium = $scope.proposal.prpTfeeDto.premium1;
                   }
                });
            });
            //切换保单缴费类型
            $scope.changeCoinsPremiumType = function () {
                var strCoinsFlag = $scope.proposal.prpTmainDto.coinsFlag;
                var strRiskCode = $scope.proposal.prpTmainDto.riskCode;
                var strCoinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType;
                if (strRiskCode == "0311" && strCoinsFlag == "2") {
                    if (strCoinsPremiumType == "" || strCoinsPremiumType == "1") {
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '至少选择一个条件',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.prpTmainDto.coinsPremiumType = "2";
                    }
                }
                $scope.watchange()
            }

            $scope.dataToSame = function (data, index) {
                $scope.Flag = true
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (info,x) {
                    if (info.coinsCode ==data.reinsCode&& x!=index) {
                        alertErr('coinsCode')
                        $scope.Flag=false;
                        $scope.proposal.prpTcoinsDtoList[index].coinsCode = '';
                        $scope.proposal.prpTcoinsDtoList[index].coinsName = '';
                        return
                    }
                })
                if($scope.Flag!=false)
                {
                    $scope.proposal.prpTcoinsDtoList[index].coinsCode = data.reinsCode;
                    $scope.proposal.prpTcoinsDtoList[index].coinsName = data.shortName
                }
            }

            $$finder.find('queryCoinsComCodeInfo', {reinsCode: '', shortName: ''}, {
                success: function (data) {
                    $scope.coinsComCodeList = data.content
                }
            })
            $scope.watchange = function () {
                $scope.showCoins=false;
                $scope.isHide=false;
                $scope.proposal.otherAgentFeeShow=false;
                if ($scope.PremiumShow==false){
                    $scope.proposal.prpTmainDto.coinsPremiumType="0";
                }
                var coinsFlag = $scope.proposal.prpTmainDto.coinsFlag || '';
                var coinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType || '';
                var comCode = $scope.proposal.prpTmainDto.comCode || '';
                if (!comCode) {
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '请输入归属机构',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    return
                }
                if (coinsFlag != 0) {
                    $scope.PremiumShow = true;
                    $scope.proposal.prpTcoinsDtoList = [];
                } else {
                    $scope.proposal.prpTcoinsDtoList = [];
                    $scope.proposal.prpTcoinsDetailDtoList=[];
                    $scope.proposal.prpTplanCoinsDtoList=[]
                    $scope.proposal.prpTmainDto.coinsPremiumType='0';
                    $scope.PremiumShow = false;
                }
                if (coinsFlag >= 1 && coinsFlag < 4 && (coinsPremiumType=='1'||coinsPremiumType=='2')) {
                    $scope.showCoins = true;
                    for(var i=0;i<3;i++){
                        $scope.addCoins();
                    }
                } else {
                    $scope.showCoins = false;
                }
            }

            //校验输入框的内容是否正确：参数target代表输入框的内容，p代表输入数字的最大位数，s代表输入数字的小数位数，p-s代表整数的位数
            $scope.checkDecimal = function (target, p, s, MinValue, MaxValue) {
                //var strValue = target.value;
                //if (strValue == "")
                //    strValue = "0";
                //var num = Number(strValue);
                //if (isNaN(num)) {
                //    alert("请输入合法的数字");
                //    $scope.proposal.prpTcoinsDtoList.coinsSumAmount = "";
                //    return false;
                //}
                //p = parseInt(p, 10);
                //s = parseInt(s, 10);
                //var pLength;
                //var sLength;
                //var position = strValue.indexOf(".");
                //if (position > -1) {
                //    pLength = position;
                //    sLength = strValue.length - position - 1;
                //}
                //else {
                //    pLength = strValue.length;
                //    sLength = 0;
                //}
                //if (pLength > (p - s) || sLength > s) {
                //    alert("请输入合法的值" + "\n类型为数字,整数位最长为" + (p - s) + ",小数位最长为" + s);
                //    return false;
                //}
                //var value = parseFloat(strValue);
                //if (MaxValue != null && MinValue != null && MaxValue != "" && MinValue != "") {
                //    MinValue = parseFloat(MinValue);
                //    MaxValue = parseFloat(MaxValue);
                //    if (isNaN(value) || value > MaxValue || value < MinValue) {
                //        alert("请输入合法的值" + "\n类型为数字,最小值为" + MinValue + ",最大值为" + MaxValue);
                //        return false;
                //    }
                //}
                //
                //return true;
            }
            //增加按钮--公共保信息录入
            $scope.addCoins = function () {
                //模拟数组
                var falg = false;
                var newObject = {
                    "serialNo": "",//序号（主共保信息录入）
                    "mainProposalNo": $scope.proposal.prpTmainDto.proposalNo,//主保单号码y
                    "coinsType": "",//共保身份y
                    "chiefFlag": "",//是否首席
                    "coinsCode": "",//共保人机构代码 y
                    "coinsName": "",//共保人名称 y
                    "coinsRate": "",//共保份额 y
                    "spanCoinsContent": "",//共保信息内容
                    "spanCoinsPlanContent": "",//共保信息内容
                    "spanCoinsGovPlanContent": "",//共保信息内容
                };
                $scope.proposal.prpTcoinsDtoList.push(newObject);
                $scope.proposal.prpTcoinsDtoList[$scope.proposal.prpTcoinsDtoList.length - 1].policyNo = '1'
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                    data.serialNo = index + 1;
                    if (data.coinsType == 1 && index >= 1) {
                        falg = true
                        initData($scope.proposal.prpTcoinsDtoList.length - 1)
                        return;
                    }
                })
                if (!falg) {
                    initData2($scope.proposal.prpTcoinsDtoList.length - 1)
                }
            };
            //删除按钮--公共保信息录入
            $scope.deleteCoins = function (index) {
                if($scope.proposal.prpTcoinsDtoList[index].chiefFlag=='0'){
                    $scope.proposal.prpTcoinsDtoList[index].coinsCode="";

                }
                $scope.proposal.prpTcoinsDtoList.splice(index, 1);
                $scope.proposal.prpTcoinsDetailDtoList = [];
                $scope.proposal.prpTplanCoinsDtoList = [];
                $scope.proposal.otherAgentFeeShow=false;

            };
            //手续费/经纪费、特殊因子联共保页面的展开收起按钮
            $scope.isHide = true;
            $scope.isShow = function () {
                $scope.isHide = !$scope.isHide;
            }
            //共保标志选择按钮调用的函数
            $scope.changeCoinsFlag = function () {
                var strCoinsFlag = $scope.proposal.prpTmainDto.coinsFlag.value;
                var strRiskCode = $scope.proposal.prpTmainDto.riskCode.value;
                $scope.clearSpanCoinsContent();
                if (strCoinsFlag == "1") {
                    $scope.proposal.prpTcoinsDetailDto.agentFee.value = '0';//将手续费置0
                    $scope.proposal.prpTcoinsDetailDto.middleCostFee.value = '0';//将特殊因子费置0
                }
                $scope.setRefreshFlagCoinsZero();//关联共保信息的项刷新了但共保信息没有随之刷新的标志：0共保信息没有刷新、1共保信息已经刷新过了
            }
            //清除共保信息内容
            $scope.clearSpanCoinsContent = function () {
                $scope.proposal.prpTcoinsDtoList.spanCoinsContent = "";
                $scope.proposal.prpTcoinsDtoList.spanCoinsPlanContent = "";
                $scope.proposal.prpTcoinsDtoList.spanCoinsGovPlanContent = "";
            }
            //关联共保信息的项刷新了但共保信息没有随之刷新的标志：0共保信息没有刷新、1共保信息已经刷新过了
            $scope.setRefreshFlagCoinsZero = function () {
                $scope.proposal.prpTmainDto.refreshFlagCoins = "0";
            }
            $scope.proposal.checkCoins=function(){
                $scope.checkCoinsTreaty();
            }
            //校验是否为协议共保
            $scope.checkCoinsTreaty = function () {
                var strStartDate = $scope.proposal.prpTmainDto.startDate;
                var strComCode = $scope.proposal.prpTmainDto.comCode;
                var strRiskCode = $scope.proposal.prpTmainDto.riskCode;
                var strCoinsFlag = $scope.proposal.prpTmainDto.coinsFlag;
                var strCoinsType = "";
                var strTreatyNo = "";
                var strCoinsPremiumType = "";
                var content = "";
                if (strComCode == "" || strComCode == null) {
                    content = "请先录入归属机构！";
                    $scope.proposal.prpTmainDto.coinsFlag = "0";
                }
                if (strStartDate == "" || strStartDate == null) {
                    content = "请先录入保单起保日期！";
                    $scope.proposal.prpTmainDto.coinsFlag = "0";
                }
                //var vURL = "" + strRiskCode + "&ComCode=" + strComCode + "&StartDate=" + strStartDate;
                //var vXmlText = getResponseXmlText(vURL);
                //if (vXmlText == "Error") {
                //    undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsFlag);
                //    undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsPremiumType);
                //    $scope.proposal.prpTmainDto.coinsFlag.disabled = "";
                //    $scope.proposal.prpTmainDto.coinsPremiumType.disabled = "";
                //    $scope.clearSpanCoinsContent();
                //    $scope.proposal.prpTmainDto.coinsFlag = "0";
                //    $scope.proposal.prpTmainDto.treatyNo.value = "";
                //    return;
                //}
                //else if (vXmlText == "Error1") {
                //    return;
                //}
                //else {
                //    $scope.clearSpanCoinsContent();
                //    if (strCoinsFlag == "1") {
                //        $scope.proposal.prpTcoinsDetailDto.agentFee.value = '0';//将手续费置0
                //        $scope.proposal.prpTcoinsDetailDto.middleCostFee.value = '0';//将特殊因子费置0
                //    }
                //    $scope.setRefreshFlagCoinsZero();//关联共保信息的项刷新了但共保信息没有随之刷新的标志：0共保信息没有刷新、1共保信息已经刷新过了
                //
                //    var arrCoins = vXmlText.split("=");
                //    strTreatyNo = arrCoins[0];
                //    strCoinsType = arrCoins[1];
                //    strCoinsPremiumType = arrCoins[2];
                //    $scope.proposal.prpTmainDto.treatyNo.value = strTreatyNo;
                //    if (strCoinsType != "" && strCoinsType != "0") {
                //        for (var i = 0; i < $scope.proposal.prpTmainDto.coinsFlag.length; i++) {
                //            if ($scope.proposal.prpTmainDto.coinsFlag.options[i].value == strCoinsType) {
                //                $scope.proposal.prpTmainDto.coinsFlag.options[i].selected = true;
                //                $scope.proposal.prpTmainDto.coinsFlag.readOnly = true;
                //                break;
                //            }
                //        }
                //    }
                //    //联供保标志为‘两者皆可’时，可自主选择联供保类型
                //    if (strCoinsType != "" && strCoinsType == "0") {
                //        undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsFlag);
                //        undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsPremiumType);
                //        $scope.proposal.prpTmainDto.coinsFlag.disabled = "";
                //        $scope.clearSpanCoinsContent();
                //    }
                //    if (strCoinsPremiumType != "" && strCoinsType != "0") {
                //        for (i = 0; i < $scope.proposal.prpTmainDto.coinsPremiumType.length; i++) {
                //            if ($scope.proposal.prpTmainDto.coinsPremiumType.options[i].value == strCoinsPremiumType) {
                //                $scope.proposal.prpTmainDto.coinsPremiumType.options[i].selected = true;
                //                $scope.proposal.prpTmainDto.coinsPremiumType.readOnly = true;
                //                break;
                //            }
                //        }
                //    }
                //}
                if(content!=""){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                }else {
                    $$finder.find('findCoinsTreaty', {
                        "startDate":strStartDate,
                        "comCode":strComCode,
                        "riskCode": strRiskCode
                    }, {
                        success: function (data) {
                            var strTreatyNo = data.content.treatyNo;
                            var strCoinsType = data.content.coinsType;
                            var strCoinsPremiumType = data.content.coinsPremiumType;
                            $scope.proposal.prpTmainDto.treatyNo = strTreatyNo;
                            if (strCoinsType != "" && strCoinsType != "0") {
                                $scope.proposal.prpTmainDto.coinsFlag = strCoinsType;
                               // $scope.watchange();
                                $scope.showCoins=false;
                                $scope.isHide=false;
                                $scope.proposal.otherAgentFeeShow=false;
                                $scope.PremiumShow = true;
                                $scope.proposal.prpTcoinsDtoList = [];
                            }

                            //if (strCoinsType != "" && strCoinsType != "0") {
                            //    for (var i = 0; i < $scope.proposal.prpTmainDto.coinsFlag.length; i++) {
                            //        if ($scope.proposal.prpTmainDto.coinsFlag.options[i].value == strCoinsType) {
                            //            $scope.proposal.prpTmainDto.coinsFlag.options[i].selected = true;
                            //            $scope.proposal.prpTmainDto.coinsFlag.readOnly = true;
                            //            break;
                            //        }
                            //    }
                            //}
                            //联供保标志为‘两者皆可’时，可自主选择联供保类型
                            //if (strCoinsType != "" && strCoinsType == "0") {
                            //    undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsFlag);
                            //    undoSetReadonlyOfElement($scope.proposal.prpTmainDto.coinsPremiumType);
                            //    $scope.proposal.prpTmainDto.coinsFlag.disabled = "";
                            //    $scope.clearSpanCoinsContent();
                            //}

                            //if (strCoinsPremiumType != "" && strCoinsType != "0") {
                            //    for (i = 0; i < $scope.proposal.prpTmainDto.coinsPremiumType.length; i++) {
                            //        if ($scope.proposal.prpTmainDto.coinsPremiumType.options[i].value == strCoinsPremiumType) {
                            //            $scope.proposal.prpTmainDto.coinsPremiumType.options[i].selected = true;
                            //            $scope.proposal.prpTmainDto.coinsPremiumType.readOnly = true;
                            //            break;
                            //        }
                            //    }
                            //}
                            if (strCoinsPremiumType != "" && strCoinsType != "0") {
                                $scope.proposal.prpTmainDto.coinsPremiumType = strCoinsPremiumType;
                                var strCoinsFlag = $scope.proposal.prpTmainDto.coinsFlag;
                                var strRiskCode = $scope.proposal.prpTmainDto.riskCode;
                                var strCoinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType;
                                if (strRiskCode == "0311" && strCoinsFlag == "2") {
                                    if (strCoinsPremiumType == "" || strCoinsPremiumType == "1") {
                                        layer.open({
                                            //offset: ['35%', '40%'],
                                            skin: 'large-layer-content',
                                            scrollbar: false,
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: '至少选择一个条件',
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            }
                                        });
                                        $scope.proposal.prpTmainDto.coinsPremiumType = "2";
                                    }
                                }
                                $scope.PremiumShow = true;//显示主共保信息
                            }
                            $$finder.find('getResponseQueryReinsAgreementDtoList',{
                                "TreatyNo": $scope.proposal.prpTmainDto.treatyNo,
                            },{
                                success: function (data) {
                                    var responseQueryReinsAgreementDtoList = data.content;
                                    var coinsFlag = $scope.proposal.prpTmainDto.coinsFlag;
                                    var coinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType;
                                    if (coinsFlag >= 1 && coinsFlag < 4 && (coinsPremiumType=='1'||coinsPremiumType=='2')) {
                                        $scope.showCoins = true;
                                        $scope.TotalInfo();
                                        for(var i=0;i<responseQueryReinsAgreementDtoList.length;i++){
                                            var responseQueryReinsAgreementDto = responseQueryReinsAgreementDtoList[i];
                                            var coinsType;
                                            var coinsSumAmount="";
                                            var coinsSumPremium="";
                                            if("0000000000"==responseQueryReinsAgreementDto.coinsCode){//我方,老系统在此判断死
                                                coinsType = '1';
                                                coinsSumAmount = $scope.proposal.prpTfeeDto.amount1 || 0;
                                                coinsSumPremium = $scope.proposal.prpTfeeDto.premium1 || 0
                                            }else{
                                                coinsType = '3';
                                            }
                                            $scope.reinsInfo(coinsSumAmount,coinsSumPremium,coinsType,responseQueryReinsAgreementDto.coinsCode,responseQueryReinsAgreementDto.coinsName,responseQueryReinsAgreementDto.chiefFlag,responseQueryReinsAgreementDto.shareRate);
                                        }
                                        angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {//添加序号
                                            data.serialNo = index+1;
                                        });
                                    }

                                }, error: function (e) {
                                    options.error(e);
                                }
                            });
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            $scope.TotalInfo = function () {
                var newObject = {
                    "serialNo": "",//序号（主共保信息录入）
                    "mainProposalNo": $scope.proposal.prpTmainDto.proposalNo,//主保单号码y
                    "coinsType": "",//共保身份y
                    "chiefFlag": "2",//是否首席
                    "coinsCode": "0",//共保人机构代码 y
                    "coinsName": "共保合计",//共保人名称 y
                    "coinsRate": "100",//共保份额 y
                    "spanCoinsContent": "",//共保信息内容
                    "spanCoinsPlanContent": "",//共保信息内容
                    "spanCoinsGovPlanContent": "",//共保信息内容
                };
                $scope.proposal.prpTcoinsDtoList.push(newObject);
                  $scope.proposal.prpTcoinsDtoList[$scope.proposal.prpTcoinsDtoList.length - 1].policyNo = '1'
            }
            $scope.reinsInfo = function(coinsSumAmount,coinsSumPremium,coinsType,coinsCode,coinsName,chiefFlag,shareRate){
                var newObject = {
                    "serialNo": "",//序号（主共保信息录入）
                    "mainProposalNo": $scope.proposal.prpTmainDto.proposalNo,//主保单号码y
                    "coinsType": coinsType,//共保身份y
                    "chiefFlag": chiefFlag,//是否首席
                    "coinsCode": coinsCode,//共保人机构代码 y
                    "coinsName": coinsName,//共保人名称 y
                    "coinsRate": shareRate,//共保份额 y
                    "spanCoinsContent": "",//共保信息内容
                    "spanCoinsPlanContent": "",//共保信息内容
                    "spanCoinsGovPlanContent": "",//共保信息内容
                    "coinsSumAmount":coinsSumAmount,
                    "coinsSumPremium":coinsSumPremium
                };
                $scope.proposal.prpTcoinsDtoList.push(newObject);
                $scope.proposal.prpTcoinsDtoList[$scope.proposal.prpTcoinsDtoList.length - 1].policyNo = '1';
            }
            //过程部分可逆,select-one所有附加事件被取消 --OK了
            $scope.undoSetReadonlyOfElement = function (iElement) {
                if (iElement.type == "select-one") {
                    if (iElement.setReadonlyFlag != true) {
                        return;
                    }
                    else {
                        iElement.setReadonlyFlag = false;
                    }

                    var optionTags = iElement.optionTags;
                    var currentValue = iElement.value;
                    for (var i = iElement.options.length - 1; i >= 0; i--) {
                        iElement.remove(i);
                    }
                    for (var i = optionTags.length - 1; i >= 0; i--) {
                        var tag = optionTags[i];
                        var op = document.createElement("OPTION");
                        op.value = tag.value;
                        op.text = tag.text;
                        iElement.add(op);
                    }
                    iElement.value = currentValue;
                }
                else if ((iElement.type == "hidden") ||
                    (iElement.type == "password") ||
                    (iElement.type == "text") ||
                    (iElement.type == "textarea")) {
                    if (iElement.setReadonlyFlag != true) {
                        return;
                    }
                    else {
                        iElement.setReadonlyFlag = false;
                    }

                    iElement.onblur = iElement.oldOnblur;
                    iElement.ondblclick = iElement.oldOndblclick;
                    iElement.onfocus = iElement.oldOnfocus;


                    iElement.readOnly = false;
                    iElement.className = iElement.oldClassName;
                }
                else if (iElement.type == "button") {
                    if (iElement.setReadonlyFlag != true) {
                        return;
                    }
                    else {
                        iElement.setReadonlyFlag = false;
                    }

                    if (iElement.name.indexOf("Delete") > -1 || iElement.name.indexOf("Insert") > -1) {
                        iElement.disabled = false;
                    }
                }

            }

            //得到元素在Form中的同名元素中的顺序,frm默认为当前页面的fm
            //$scope.getElementOrder = function (field) {
            //    var i = 0;
            //    var order = 0;
            //    var elements = document.getElementsByName(field.name);
            //    var elementsCount = elements.length;
            //    for(i = 0; i < elementsCount; i++) {
            //        order++;
            //        if(elements[i] == field) {
            //            break;
            //        }
            //    }
            //    return order;
            //}
            //查找在Form中的同名元素，没有则返回0, frm默认为当前页面的fm
            $scope.getElementCount = function (strFieldName, frm) {
                var intCount = 0;
                var frmForm = (frm == null ? document.fm : frm);
                try {
                    intCount = eval(frmForm.all(strFieldName).length);
                    if (isNaN(intCount)) intCount = 1;
                }
                catch (E) {
                    intCount = 0;
                }

                //select输入域的特殊处理
                if (intCount > 1 && frmForm.all(strFieldName)[0].tagName == "OPTION") {
                    intCount = 1;
                }
                return intCount;
            }
            //public
            //angular里面不要处理DOM元素
            //$scope.setReadonlyOfElement = function setReadonlyOfElement(iElement) {
            //    if(iElement.type=="select-one") {
            //        if(iElement.setReadonlyFlag==true) {
            //            return;
            //        }
            //        else {
            //            iElement.setReadonlyFlag = true;
            //        }
            //        var optionTags = new Array();
            //        var index = 0;
            //        for(var j=iElement.options.length-1;j>=0;j--) {
            //            var tag = new Array();
            //            tag["value"] = iElement.options[j].value;
            //            tag["text"]  = iElement.options[j].text;
            //            optionTags[index++] = tag;
            //            if(iElement.options[j].value!=iElement.value) {
            //                iElement.remove(j);
            //            }
            //        }
            //        iElement.optionTags = optionTags;
            //    }
            //    else if ((iElement.type=="hidden") ||
            //        (iElement.type=="password") ||
            //        (iElement.type=="text") ||
            //        (iElement.type=="textarea")) {
            //        if(iElement.setReadonlyFlag==true) {
            //            return;
            //        }
            //        else {
            //            iElement.setReadonlyFlag = true;
            //        }
            //
            //        //事件存储在oldXXX里
            //        iElement.oldOnblur = iElement.onblur;
            //        iElement.onblur = functionDoNothing;
            //        iElement.oldOndblclick = iElement.ondblclick;
            //        iElement.ondblclick = functionDoNothing;
            //        iElement.oldOnfocus = iElement.onfocus;
            //        iElement.onfocus = functionDoNothing;
            //        iElement.oldClassName = iElement.className;
            //        iElement.readOnly = true;
            //        iElement.className = "readonlyOnly";
            //        if(iElement.style.width=="") {
            //            switch (iElement.oldClassName) {
            //                case "codecode" :
            //                    iElement.style.width="40px";
            //                    break;
            //                case "common" :
            //                    iElement.style.width="160px";
            //                    break;
            //                case "readonly" :
            //                    iElement.style.width="160px";
            //                    break;
            //                default :
            //            }
            //        }
            //
            //    }
            //    else if(iElement.type=="button") {
            //        if(iElement.setReadonlyFlag==true) {
            //            return;
            //        }
            //        else {
            //            iElement.setReadonlyFlag = true;
            //        }
            //        if(iElement.name.indexOf("Delete")>-1 || iElement.name.indexOf("Insert")>-1) {
            //            iElement.disabled = true;
            //        }
            //    }
            //}
            $scope.functionDoNothing = function () {
                //do nothing
            }
            $scope.checkNo = function () {
                if (!$scope.proposal.dellNo) {
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '主保单号码不能为空',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
            }
            //共保保额--计算共保保额
            var setCoinsTreatyAmount = function () {
                //if($scope.proposal.prpTcoinsDtoList.length==0){
                //    alertErr('coins')
                //    return false
                //}
                var totalAmount = $scope.proposal.prpTcoinsDtoList[0].coinsSumAmount;
                var totalPremium = $scope.proposal.prpTcoinsDtoList[0].coinsSumPremium;
                var Amount = 0;
                var Premium = 0;
                var Rate = 0;
                var mm = 0;
                var myMsg = {};
                var myfalg = false
                var coinsCode = []
                var refalg = false
                var breakflag = true
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                    if (data.coinsSumAmount == 0) {
                        alertErr('SumAmount0')
                        refalg = true
                        breakflag = false
                        return false
                    }

                    if (data.coinsSumPremium == 0) {
                        alertErr('SumPremium0')
                        refalg = true;
                        breakflag = false
                        return false
                    }
                    if (breakflag) {
                        if (data.coinsType == 1) {
                            if (myfalg == true) {
                                alertErr('myfalg')
                                return false
                            }
                            myMsg = index;
                            myfalg = true;
                            breakflag = false
                        }


                        if (Math.abs(Math.round(totalAmount * data.coinsRate) / 100 - parseFloat(data.coinsSumAmount))>=10) {
                            if (index != 0) {
                                alertErr('SumAmount_rate', index + 1)
                                refalg = true
                                breakflag = false
                                return false
                            }

                        }

                        if (totalPremium * data.coinsRate / 100 != data.coinsSumPremium*1) {
                            if (index != 0) {
                                alertErr('SumPremium_rate', index + 1)
                                refalg = true
                                breakflag = false
                                return false
                            }
                        }


                    }
                    coinsCode.push(data.coinsCode)
                    if (index != 0) {
                        //国元版本
                        Amount += parseFloat(data.coinsSumAmount);
                        Premium += parseFloat(data.coinsSumPremium);
                        Rate += parseFloat(data.coinsRate)
                        mm += parseFloat(data.coinsRate)
                    }


                })

                if (refalg) {
                    return false
                }
                var cpcoinsCode = angular.copy(coinsCode)
                for (var i = 0; i < cpcoinsCode.length; i++) {
                    var a = cpcoinsCode.splice(0, 1);
                    if (cpcoinsCode.indexOf(a) != -1) {
                        alertErr('cpcoinsCode')
                        return false
                    }
                    i--;
                }
                if (totalAmount != Amount) {
                    alertErr('Amount')
                    return false;
                }
                if (totalPremium != Premium) {
                    alertErr('Premium')
                    return false;
                }
                if (Rate < 100) {
                    alertErr('Rate')
                    return false;
                }
                if (Rate > 100) {
                    alertErr('mm')
                    return false;
                }
                if (!myfalg) {
                    alertErr('myfalg')
                    return false
                }
                if (myfalg && !refalg) {
                    functionrefreshCoinsPlanByPay()
                }
                return true
            }
            var alertErr = function (data, n) {
                var content = ''
                if (data == 'coins') {
                    content = '请录入共保信息！'
                }
                if (data == 'coinsSumAmount') {
                    content = '手续费/经纪费、特殊因子联共保信息，保额输入错误'
                }
                if (data == 'totalnum') {
                    content = '自缴保费信息输入有误'
                }
                if (data == 'Rate') {
                    content = '共保比例总分错误！'
                }
                if (data == 'SumAmount_rate') {
                    content = '共保保额总分不一致'
                }
                if (data == 'SumPremium_rate') {
                    content = '共保保费总分不一致'
                }
                if (data == 'myfalg') {
                    content = '请录入我方信息'
                }
                if (data == 'Amount') {
                    content = '共保保额总分不一致！'
                }
                if (data == 'Premium') {
                    content = '共保保费总分不一致！'
                }
                if (data == 'Rate') {
                    content = '共保方保额与比例不一致！'
                }
                if (data == 'mm') {
                    content = '共保份额比例合不能大于100！'
                }
                if (data == 'cpcoinsCode') {
                    content = '共保人机构代码不能重复！'
                }
                if (data == 'SumAmount0') {
                    content = '共保保额不能为0！'
                }
                if (data == 'SumPremium0') {
                    content = '共保保费不能为0！'
                }
                if(data == 'coinsCode'){
                    content = '共保人机构代码不能重复！'
                }
                if(content){
                    layer.open({
                        //offset: ['35%', '35%'],
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
                    return false
                }
            }

            $scope.tplan = $scope.tplan || {}

            var functionrefreshCoinsPlanByPay = function () {
                $scope.proposal.otherAgentFeeShow = true
                $scope.proposal.prpTplanCoinsDtoList = []
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                    if (index != 0 && data.coinsType != 1) {
                        var prpTsubsidyDtoList = $scope.proposal.prpTsubsidyDtoList
                        var rate = 0;
                        angular.forEach($scope.proposal.prpTplanDtoList, function (data_1, _index_1) {
                            var CoinsGovPayReason;
                            var CoinsGovPayReasonName;
                            if (data_1.payReason == "RS3") {
                                CoinsGovPayReason = "RD3";
                                CoinsGovPayReasonName = "中央财政";
                            } else if (data_1.payReason == "RS4") {
                                CoinsGovPayReason = "RD4";
                                CoinsGovPayReasonName = "省级财政";
                            } else if (data_1.payReason == "RS5") {
                                CoinsGovPayReason = "RD5";
                                CoinsGovPayReasonName = "地市财政";
                            } else if (data_1.payReason == "RS6") {
                                CoinsGovPayReason = "RD6";
                                CoinsGovPayReasonName = "其他来源";
                            } else if (data_1.payReason == "RS7") {
                                CoinsGovPayReason = "RD7";
                                CoinsGovPayReasonName = "县(区)来源";
                            } else {
                                CoinsGovPayReason = "GP81";
                                CoinsGovPayReasonName = "自缴保费";
                            }
                            var planFee = round((data.coinsSumPremium * data_1.planRate / 100), 2);
                            var obj1 = {
                                serialNo: _index_1 + 1,
                                coinsCode: data.coinsCode,
                                coinsName: data.coinsName,
                                payReason: CoinsGovPayReason,
                                reason: CoinsGovPayReasonName,
                                planStartDate: data_1.planStartDate,
                                planDate: data_1.planDate,
                                currency: data_1.currency,
                                planRate: data_1.planRate,
                                planFee: planFee,
                                realPay: 0
                            }
                            $scope.proposal.prpTplanCoinsDtoList.push(obj1)
                        });

                    }
                })

                $scope.proposal.prpTcoinsDetailDtoList=angular.copy($scope.proposal.prpTcoinsDtoList);
                angular.forEach($scope.proposal.prpTcoinsDetailDtoList,function(data,index){
                    data.serialNo=index+1;
                    data.agentFee=0;
                    data.middleCostFee=0;
                    data.operateFee=0;
                    data.flag='';
                    data.currency=$scope.proposal.prpTfeeDto.currency1;
                    data.coinsAmount=data.coinsSumAmount;
                    data.coinsPremium=data.coinsSumPremium
                })
                return true
            }
            $scope.setRefreshFlagDetailZero = function () {
                $scope.proposal.prpTmainDto.RefreshFlagDetail = "0";
            }
            //$scope.coinsuranceCount = true;//计算按钮
            $scope.proposal.otherAgentFeeShow = false;//手续费、经纪费、特殊因子联共保信息表显示隐藏
            $scope.coinsCount = function () {
                var TorF = $scope.coinsurance();
                if (TorF == true) {
                    var coinsSumAmount, coinsSumPremium, totalnum
                    angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                        if (index == 0) {
                            coinsSumAmount = data.coinsSumAmount;
                            coinsSumPremium = data.coinsSumPremium
                        } else {
                            coinsSumAmount -= data.coinsSumAmount;
                            coinsSumPremium -= data.coinsSumPremium
                        }
                        if (data.coinsType == 3) {
                            totalnum = data.coinsSumPremium
                        }

                    })

                    if ($scope.proposal.prpTcoinsDtoList.length == 0) {
                        alertErr('coins')
                        return false;
                    }
                    if (coinsSumAmount != 0) {
                        alertErr('coinsSumAmount')
                        return
                    }
                    if (coinsSumPremium != 0) {
                        alertErr('coinsSumPremium')
                        return
                    }
                    angular.forEach($scope.proposal.prpTplanCoinsDtoList, function (data, index) {
                        totalnum = commonApiServ.Subtr(totalnum, data.planFee);
                    })
                    if (totalnum != 0) {
                        alertErr('totalnum')
                        return
                    }
                    var content = "";
                    for (var i = 0; i < $scope.proposal.prpTcoinsDtoList.length; i++) {
                        if ($scope.proposal.prpTcoinsDtoList[i].coinsCode == '0') {

                        } else if (!$scope.proposal.prpTcoinsDtoList[i].coinsCode) {
                            content = "请先选择共保人机构代码";
                        }
                    }
                    if (content) {
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return false;
                    }
                }
                //共保计算成功时调取此方法置标识，防止 1、点击
                $scope.setCoinsPremiumFlag();
            }

            $scope.coinsurance = function () {
                return  setCoinsTreatyAmount();
            }
            //展示手续费/经纪费、特殊因子联共保信息的内容
            $scope.showpage = function ($event) {
                if($scope.proposal.prpTcoinsDtoList.length>0&&$scope.proposal.prpTcoinsDetailDtoList.length>0&&$scope.proposal.prpTplanCoinsDtoList.length>0){
                    for(var i=0;i<$scope.proposal.prpTcoinsDtoList.length;i++){
                        if ($scope.proposal.prpTcoinsDtoList[i].coinsCode=='0'){

                        }else if (!$scope.proposal.prpTcoinsDtoList[i].coinsCode){
                            $scope.proposal.otherAgentFeeShow=false;
                            $scope.proposal.prpTcoinsDetailDtoList=[];
                            $scope.proposal.prpTplanCoinsDtoList=[];
                            return false;
                        }else{
                            $scope.isHide=true;
                            $scope.proposal.otherAgentFeeShow=true;
                            $scope.showCoins=true;
                        }
                    }
                }

                var i = $scope.proposal.prpTcoinsDtoList.length;//显示行号
                for (var j = 0; j < i; j++) {
                    //从“合同信息”的“币别信息”模块获取支付币别
                    $scope.proposal.prpTcoinsDetailDtoList.currency = $scope.proposal.prpTfeeDto.currency1;
                }

            }

            //初始化$scope.proposal.prpTitemKindDtoList
            //if ($scope.proposal.prpTitemKindDtoList[0] && !$scope.proposal.prpTitemKindDtoList[0].itemKindNo) {
            //    $scope.proposal.prpTitemKindDtoList = []
            //}
            // $scope.adjustMunOther = function (data,attr,type) {
            //     if (attr == 'coinsSumAmount') {
            //         dataObj.coinsSumAmount = commonApiServ.rateNum(data,type)
            //     }else {
            //         dataObj.coinsSumPremium = commonApiServ.rateNum(data,type)
            //     }
            // }
            //输入两位小数时默认保留四位，输入整数时保留两位小数
            //$scope.changecoinsOthrer = function (index, attl,type) {
            //    if(type=="prpTcoinsDtoList"){
            //        if(attl){
            //            $scope.proposal.prpTcoinsDtoList[index][attl]=$rootScope.amount($scope.proposal.prpTcoinsDtoList[index][attl]);
            //        }
            //    }else if(type=="prpTcoinsDetailDtoList"){
            //        if(attl){
            //            $scope.proposal.prpTcoinsDetailDtoList[index][attl]=$rootScope.amount($scope.proposal.prpTcoinsDetailDtoList[index][attl]);
            //        }
            //    }else if(type=="prpTplanCoinsDtoList"){
            //        if(attl){
            //            $scope.proposal.prpTplanCoinsDtoList[index][attl]=$rootScope.amount($scope.proposal.prpTplanCoinsDtoList[index][attl]);
            //        }
            //    }
            //
            //}
            //输入两位小数时默认保留四位，输入整数时保留两位小数
            var changeNum=function(data){
                if(isNaN(data)){
                    return data
                }              //换成数字
                data=data*1;
                if(data.toString().indexOf('.')!=-1){
                    return data.toFixed(4)
                }

            }
            //共保份额不能大于100
            $scope.absuDeduRateForm = function (str){
                if(str){
                    if(str>100){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '共保份额比例不能大于100！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.coins.coinsRate="";
                        return
                    }else if(parseFloat(str)==0){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '共保份额比例不能等于0！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.coins.coinsRate="";
                    }else{
                        $scope.coins.coinsRate= str;
                    }
                }
            };

            //return commonApiServ.rateNum(attr)
            //费率类的数字的校验 保留4位小数
            $scope.changeCoinsType = function (index) {
                //$scope.proposal.prpTcoinsDetailDtoList=angular.copy($scope.proposal.prpTcoinsDtoList)
               $scope.coinsTypeFlag = true
                var obj = $scope.proposal.prpTcoinsDtoList[index]
                console.log(obj.coinsType)
                if (obj.coinsType != 1)return
                angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, x) {
                    if (data.coinsType == 1 && index != x) {
                        alertErr('myfalg')
                        $scope.coinsTypeFlag = false
                    }
                })
                if (!$scope.coinsTypeFlag) return
                obj.coinsName = $scope.proposal.prpTmainDto.comCName
                obj.coinsCode = $scope.proposal.prpTmainDto.comCode
                obj.coinsSumAmount = $scope.proposal.prpTfeeDto.amount || 0;
                obj.coinsSumPremium = $scope.proposal.prpTfeeDto.premium || 0
            }
            //选择手续费
            $scope.checkedBox1 ="";
                $scope.checkedBoxChange1=function(){
                    $scope.proposal.prpTcoinsSchema.proportionFlag1=$scope.checkedBox1;

            }
            //选择特殊因子费
            $scope.checkedBox2="";
            $scope.checkedBoxChange2=function(){
                $scope.proposal.prpTcoinsSchema.proportionFlag2=$scope.checkedBox2;

            };
            //主共保取消
            $scope.cancelCoin=function(){
                $scope.showCoins=false;
                //将共保标志恢复默认值
                $scope.proposal.prpTmainDto.coinsFlag='0';
                //将保单缴费类型隐藏
                $scope.PremiumShow = false;
                //将保单缴费类型恢复为默认值
                $scope.proposal.prpTmainDto.coinsPremiumType='0';
                //$scope.isHide=false;
                $scope.proposal.otherAgentFeeShow=false;
                $scope.proposal.prpTcoinsDtoList=[];
                $scope.proposal.prpTcoinsDetailDtoList = [];
                $scope.proposal.prpTplanCoinsDtoList = [];

            }
            //复制投保单时显示共保信息
            $scope.proposal.showCoinsInfo = function(){
                $scope.lookCoinInformation();
            }
        //    点击查看共保信息
            $scope.lookCoinInformation= function () {
                $scope.showCoins=true;
                $scope.isHideOther=true;
                angular.forEach($scope.proposal.prpTcoinsDtoList,function (data,index) {
                    data.policyNo = '1';
                    data.mainProposalNo= $scope.proposal.prpTmainDto.proposalNo;
                })
                angular.forEach($scope.proposal.prpTcoinsDetailDtoList, function (data,index) {
                    $scope.proposal.prpTcoinsDtoList[index].coinsSumAmount=data.coinsAmount;
                    $scope.proposal.prpTcoinsDtoList[index].coinsSumPremium=data.coinsPremium;

                })
                $scope.coinsCount();
                $scope.showpage()
            }
        //    其它信息  总的收缩按钮
            $scope.isHideOther=true;
            $scope.isShowOther= function () {
                $scope.isHideOther=!$scope.isHideOther;

            }
        //    主共保信息录入收缩按钮
            $scope.isHidcoins=true;
            $scope.coinsIsHide= function () {
                $scope.isHidcoins=!$scope.isHidcoins;
            }
        //    手续费/经纪费、特殊因子联共保信息 收缩按钮
            $scope.isHidcommission=true;
            $scope.commissionIsHide= function () {
                $scope.isHidcommission=!$scope.isHidcommission;
            }
        //    共保方补贴信息 收缩按钮
            $scope.isHidFee=true;
            $scope.feeIsHide= function () {
                $scope.isHidFee=!$scope.isHidFee;
            }
            function round(number, precision) {
                if (isNaN(number))
                    number = 0;
                var prec = Math.pow(10, precision);
                var result = Math.round(number * prec);
                result = result / prec;
                return result;
            }
        }]);
});