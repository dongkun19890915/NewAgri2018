/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'encodeUrl'
], function (app, constants) {
    'use strict';
    app.registerController('UIEndorse3107editCtrl',
        ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$timeout', '$filter','$$proposalAPI', '$$cherry', '$$finder', '$stateParams', '$state', '$$code','$modal','$window',
            function ($rootScope, $scope, $http, $anchorScroll, $location, $timeout, $filter, $$proposalAPI, $$cherry, $$finder, $stateParams, $state, $$code,$modal,$window) {
                $scope.approvalPageFlag = false; // 批文页面显示隐藏标志
                $scope.endorseFlag = true; // 批改标志
                $scope.proposalQueryHide = false; // 保单查看禁用标志
                $scope.showEndrose={};
                $scope.showEndrose.index="1",//批单隐藏字段
                    $scope.riskScheme1=false;//修改方案
                $scope.disabledContent=true;//特约查看详情不可编辑
                //隐藏核保通过日期、核保人
                $scope.queryHide0 = true;
                $scope.languagePolicySort = false;
                //$scope.endorHide=true;//批改时删除和修改按钮隐藏
                //$scope.editEndrose={};
                //$scope.editEndrose.index="1",//出单方案显示

                    //级联获取下拉列表***************************************start
                    $scope.initFlag = true;// 初始化标志  初始化完成后置为 false  默认true初始化状态
                $$proposalAPI.initAPI($scope); // 级联公共api注入
                //级联获取下拉列表***************************************end
                //获取费率除数
                $scope.getrateDivisor = function (data) {
                    $scope.rateDivisor = data;
                }
                //延迟初始化接口
                $scope.init = true;
                if ($stateParams.type === 'type') {
                    $scope.showRiskScheme = false;
                } else {
                    $scope.showRiskScheme = true;
                }
                $scope.initdata = false
                //滚动条控制
                $scope.goBasic = function () {
                    $location.hash("basic");
                    $anchorScroll();
                };
                $scope.goContract = function () {
                    $location.hash("contract");
                    $anchorScroll();
                };
                $scope.goClient = function () {
                    $location.hash("client");
                    $anchorScroll();
                };
                $scope.goOthers = function () {
                    $location.hash("others");
                    $anchorScroll();
                }

                //查看批文
                $scope.showReviseOfficial=false;
                $scope.reviseOfficial= function () {
                    $scope.showReviseOfficial=true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    $$finder.find("queryPrpPtextByEndorseNo",{
                        "endorseNo":$stateParams.bizNo
                    },{
                        success: function (data) {
                            console.log(data);
                            var list=data.content;
                            $scope.endorseText="";
                            for(var i=0;i<list.length;i++){
                                $scope.endorseText+=list[i].endorseText+'\n';
                            }
                            $scope.policyNo=data.content[0].policyNo;//获取保单号
                            if($scope.endorseText){
                                $("#textOfficial").val($scope.endorseText);
                            }
                        }
                    })
                }
                $scope.cancel= function () {
                    $scope.showReviseOfficial=false;
                    $("html,body").css({overflow:"auto"});//显示滚动条
                }

                //核批详情查询
                $scope.policyInfo = false;
                $scope.getViewTrace = function () {
                    $$finder.find('getViewTrace', {//getViewTrace这个是国元的
                        "proposalNo": $scope.proposal.prpTmainDto.proposalNo//proposalNo同上
                    }, {
                        success: function (data) {
                            //
                            if (data.content.length > 0) {
                                $scope.examineList = data.content;
                                $scope.policyInfo = true;
                                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            }else{
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,
                                    title: '温馨提示',
                                    content: '未查询到核批信息',
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
                //关闭详情
                $scope.closepolicyInfoShow = function () {
                    $scope.policyInfo = false;
                    $("html,body").css({overflow:"auto"});//显示滚动条
                }
                //分户清单下载按钮
                $scope.PlantingExcelDto={}
                $scope.DownLoadButton = function () {
                    $scope.PlantingExcelDto.inusreListCode = $scope.proposal.prpTmainAgriDto.relationListNo;
                    $scope.PlantingExcelDto.proposalNo =  $scope.proposal.prpTmainDto.proposalNo;
                    $scope.PlantingExcelDto.userCode = $rootScope.user.userCode;
                    $scope.PlantingExcelDto.riskCode = $scope.proposal.prpTmainDto.riskCode;
                    $scope.PlantingExcelDto.payNo = 1;
                    $scope.PlantingExcelDto.pageSize = 10;
                    $$finder.find('getPlantingExcel', $scope.PlantingExcelDto, {
                        success: function (data) {
                            console.log(data);
                            window.open(data.content.fileId);
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
                //    保存按钮
                var keyword = {};
                // $$cherry.$proposal.Proposal(keyword, {
                //     // clauseType: 'F57',
                //     success: function (_proposal) {
                //         if (_proposal) {
                //             $scope.proposal = _proposal;
                //         }
                //     }
                // })
                $scope.proposal = {
                    "isSaveFlag": "",//y
                    "editType": "",//y
                    "currency2Name":"",//汇总币别名称
                    //y
                    "prpTmainDto": {
                        "systemFlag": '1',//新老数据区分
                        "proposalNo": "",//投保单号131013400002008000463
                        "classCode": "",//险类
                        "riskCode": "",//险种
                        "versionNo": "",//条款
                        "policySort": "",//保单种类
                        //基本信息
                        "comCName":"",
                        "comCode": "",//归属机构代码  有隐藏域 有
                        "handler1Code": "",//归属业务员代码  有隐藏域 有
                        "businessProvince": "",//归属区域  省 有
                        "businessTown": "",//归属区域  市 有
                        "businessCountry": "",//归属区域  区县 有
                        "businessAreaName": "",//归属区域：乡镇 有
                        "businessArea": "",//归属区域：村 有
                        "businessNature": "",//业务来源 y
                        "groupFlag": "",//业务大类 y
                        "businessType1": "",//政策/商业标志 y
                        "inceptionFlag": "",//是否验标 y
                        "notificationFlag": "",//是否承保公示 y
                        "businessType": "",//业务类型 y
                        "thirdKnow": "",//是否通过第三方通识 y
                        "autoTransRenewFlag1": "",//缴纳方式 y
                        "startDate": "",//保险期间 y
                        "startHour": "",//y
                        "endDate": "",//保险期间 y
                        "endHour": "",//y
                        "operateDate": "",//投保日期 y
                        "signDate": "",//制单日期
                        "policyNo": "",//保单号 y
                        "operatorCode": $rootScope.user.userCode,//操作人  y
                        "inputDate": "",//操作日期

                        "updaterCode": "",//最近修改人  y
                        "updateDate": "",//最近修改日期  y
                        //合同信息
                        "policyType": "",//投保方式
                        "statQuantity": "",//承保数量 y
                        "sumInsured": "",//参保农户户次 y
                        "modelCode": "",//选择模块
                        "coinsFlag": "",//联共保标志 y
                        //后来要加的字段
                        "judicalCode": "",//司法管辖
                        "judicalScope": "",//交费方式
                        "shareHolderFlag": "",//股东业务标识下拉框，默认为0-否，1-是
                        "reMark": "",//对应页面的出单员意见
                        //隐藏域
                        "appliCode": "",//投保人代码
                        "appliName": "",//投保人名称
                        "appliAddress": "",//投保人地址
                        "insuredCode": "",//被保险人代码
                        "insuredName": "",//被保险人名称
                        "insuredAddress": "",//被保险人地址
                        "pureRate": "",//净费率
                        "discount": "",//总折扣率
                        "currency": "",//币别代码获取的是币别信息中的保单汇总币别代码
                        "sumValue": "",//总保险价值
                        "sumAmount": "",//总保险金额
                        "sumDiscount": "",//总折扣金额
                        "sumPremium": "",//总保险费
                        "arbitBoardName": "",//仲裁单位名称
                        "payTimes": "",//缴费次数
                        "language": "",//语种标志
                        "endorseTimes": "",//批改次数
                        "claimTimes": "",//理赔次数
                        "makeCom": "",//出单机构代码 隐藏域
                        "operateSite": "",//签单地点
                        "handlerCode": "",//经办人  隐藏域
                        "inputHour": "",//计算机输单小时
                        "allinsFlag": "",//统保标志
                        "underwriteFlag": "",//核保标志
                        "othFlag": "",//其它标志字段
                        "flag": "",//状态字段
                        "businessFlag": "",//页面默认值为1
                        "updateHour": "",//
                        "payMode": "",//
                        "unitCode": "",//承保数量的计量单位代码
                        "articleType": "",//专项业务
                        "startMinute": "",//起保分钟
                        "endMinute": "",//终保分钟
                        "validCountDate": "",//统计日期
                        "clauseType": "",//条款版本
                    },
                    //投保人y
                    "appliInsuredDto": {
                        "proposalNo": "",//投保单号
                        "riskCode": "",//险种代码
                        "serialNo": "",//序号
                        "insuredType": "",//客户类型
                        "identifyType": "",//证件类型
                        "identifyNumber": "",//证件号码
                        "insuredName": "",//客户名称
                        "insuredCode": "",//客户代码
                        "certificateName":"",//借用存金禾客户代码
                        "mobile": "",//移动电话
                        "validPeriod3": "",//证件有效期
                        "insuredAddress": "",//客户地址
                        "phoneNumber": "",//固定电话
                        "account": "",//开户账号
                        "bank": "",//开户行
                        "postCode": "",//邮政编码
                        "email": "",//电子邮件
                        "isCareclaim": "",//客户是否关注审计、理赔、退保信息
                        "cashFocus": "",//行业现金密度
                        "riskLevel": "",//风险等级
                        "nationality": "",//国籍//这个没有，以前是在新增里面的
                        "jobTitle": "",//职业//这个同上
                        "sex": "",//性别//这个同上
                    },
                    //被保人y
                    "insuredDto": {
                        "proposalNo": "",//投保单号
                        "riskCode": "",//险种代码
                        "serialNo": "",//序号
                        "insuredType": "",//客户类型
                        "identifyType": "",//证件类型
                        "identifyNumber": "",//证件号码
                        "certificateName":"",//借用存金禾客户代码
                        "insuredName": "",//客户名称
                        "insuredCode": "",//客户代码
                        "mobile": "",//移动电话
                        "validPeriod3": "",//证件有效期
                        "phoneNumber": "",//固定电话
                        "insuredAddress": "",//客户地址
                        "businessSort": "",//公司性质
                        "linkerName": "",//联系人姓名
                        "account": "",//开户账号
                        "bank": "",//开户行
                        "postCode": "",//邮政编码
                        "email": "",//电子邮件
                        "isCareclaim": "",//客户是否关注审计、理赔、退保信息
                        "cashFocus": "",//行业现金密度
                        "riskLevel": "",//风险等级
                    },
                    //种植地点y
                    "prpTaddressDto": {
                        "proposalNo": "",//投保单号
                        "riskCode": "",//险种代码
                        "addressNo": "",//序号
                        "addressCode": "",//邮政编码
                        "addressName": "",//地址
                    },
                    //币别信息 y
                    "prpTfeeDto": {
                        "proposalNo": "",//投保单号
                        "riskCode": "",//险种代码
                        "currency2": "",//汇总币别
                        "currency1": "",//支付币别
                        "currency": "",//币别
                        "amount": "",//保额
                        "premium": "",//保费
                        "noTaxPremium": "",//原币不含税保费
                        "taxFee": "",//原币税额
                        "exchangeRate2": "",//汇总兑换率
                        "amount2": "",//汇总币别保额
                        "premium2": "",//汇总币别保费
                        "noTaxPremium2": "",//汇总币别不含税保费
                        "taxFee2": "",//汇总币别税额
                        //支付币别兑换率
                        "exchangeRate1": "",//汇总兑换率
                        "amount1": "",//支付币别保额
                        "premium1": "",//支付币别保费
                        "noTaxPremium1": "",//汇总币别不含税保费
                        "taxFee1": "",//汇总币别税额
                    },
                    //农险险种独有的主险附加险 y
                    "prpTitemKindAgriDtoList": [],
                    //主险附加险 y
                    "prpTitemKindDtoList": [{
                        "agriUnitCostMain":"",
                        "agriTimesAmount":"",
                        "unitAmount":"",
                        "agriGrossQuantityMain":"",
                    }],
                    //合同信息 y
                    "prpTmainAgriDto": {
                        "proposalNo": "",
                        "riskCode": "",
                        "raiseSite": "",//养殖地点
                        "remark": "",//按何种方式确定保险金额 y
                        "raiseDate": "",//种植时间
                        "relationListNo": "",//隐藏的我方清单号
                        "relationListNoRemark": "",//清单备注  y
                        //隐藏域
                        "benchmarkPremium":"",//基准保费
                        //页面上没有的东西
                        "insureArea": "",//总投保面积
                        "flag": "",
                        "observeStartHour": "",
                        "observeEndHour": "",
                        "selfPremium": "",
                        "raiseType": "",//养殖户类型
                    },
                    //缴费计划y
                    "prpTplanDtoList": [],
                    //补贴y
                    "prpTsubsidyDtoList": [],
                    //客户信息中的发票购货方信息
                    "prpDcustomerTaxPayInfoDto": {
                        "payInfoObject": "",//开票对象
                        "customerName": "",//发票抬头
                        "invoiceType": "",//发票类型
                        "taxpayerNo": "",//税务登记证号
                        "taxpayerType": "",//纳税人身份
                        "address": "",//购方地址
                        "phone": "",//购方电话
                        "accountBank": "",//购方开户银行
                        "accountNo": "",//购方银行账号
                        "postName": "",//邮寄名称
                        "postPhone": "",//邮寄电话
                        "postAddress": "",//邮寄地址
                        "postCode": "",//邮寄编码
                        "remark": "",//备注
                    },

                    //清单表格y
                    "insureMainListDto": [{
                        "listTypeFlag": "",//清单类型
                        "remark": "",//清单备注
                        "insureListCode": "",//清单号
                    }],

                    //y
                    "prpDcustomerunitDto": {
                        "postAddress": "",//联系地址
                    },
                    //y
                    "prpTcoinsDtoList": [{
                        "serialNo": "",//序号（主共保信息录入）
                        "mainProposalNo": "",//主保单号码 y
                        "coinsType": "",//共保身份 y
                        "chiefFlag": "",//是否首席
                        "coinsCode": "",//共保人机构代码 y
                        "coinsName": "",//共保人名称 y
                        "coinsRate": "",//共保份额 y
                    }],
                    //联共保明细应该是数组
                    "prpTcoinsDetailDto": [{
                        "serialNo": "",//序号（联共保信息）
                        "coinsCode": "",//共保人机构代码
                        "coinsName": "",//共保人名称
                        "currency": "",//币别
                        "coinsAmount": "", //额保
                        "coinsPremium": "",//保费
                        "agentFee": "",//手续费/经济费
                        "middleCostFee": "",//特殊因子费
                        "operateFee": "",//出单费
                    }],
                    //联共保缴费计划
                    "prpCplanCoinsDtoList": [{
                        "serialNo": "",//序号（联共保信息）
                        "coinsCode": "",//共保人机构代码
                        "coinsName": "",//共保人名称
                        "currency": "",//币别
                        "coinsAmount": "", //额保
                        "coinsPremium": "",//保费
                        "agentFee": "",//手续费/经济费
                        "middleCostFee": "",//特殊因子费
                        "operateFee": "",//出单费
                    }],
                    //y
                    "prpTengageDto": [{
                        "proposalNo": "",//投保单号
                        "riskCode": "",//险种代码
                        "serialNo": "",//序号（特约及附加信息）
                        "clauseCode": "",//代码
                        "clauses": "",//名称
                        "lineNo": "",//行号
                        "clausesContent": "",//内容  000
                        "titleFlag":"",//标题标志，如果是0则是名称，1是内容
                        "flag": "",//状态字段
                    }],
                    //茬次信息
                    "prpTitemKindAgriDtoListCopy":[{

                    }],
                    "prpTexpenseDto": {
                        "proposalNo": "",
                        "riskCode": "",
                        "manageFeeRate": null,
                        "maxManageFeeRate": null,
                        "flag": "",
                        "salvationRate": null,
                        "salvationFee": null,
                        "currency": null,
                        "basePerformanceRate": null,
                        "basePerformance": null,
                        "encouragePerformanceRate": null,
                        "encouragePerformance": null,
                        "noTaxFee": null,
                        "taxRate": null,
                        "taxFee": null,
                        "dutyRatio": null,
                        "transferTax": null
                    },
                    "engageQueryClause":{
                        "absuDedu":"",//绝对免赔率
                        "deduText":"",//免赔说明
                    },
                    "prpPheadDto":{
                        "endorseNo":"",
                        "policyNo":"",
                        "endorType":"",//批改类型
                        "endorDate":"",//批改日期
                        "validDate":"",//批改生效日期
                        "endorseType":"",//批改原因
                        "endorseMessage":""//批改原因描述
                    }
                };

                $scope.DownloadHouseholdListFn = function () {//点击币别确定之后放开分户清单下载按钮
                    $scope.DownloadHouseholdList = false;
                }
                //点击计算时将flag置为true,保存时方便校验共保信息
                $scope.setPremiumFlag = function () {
                    $scope.PremiumFlag = true;
                    $scope.coinsPremiumFlag = false;
                }
                //保单数据转换
                var copyOrangeProposalInit = angular.copy($scope.proposal);
                var endorseDtoConvertProposalDto = function (endorseDto,type) {
                    var proposalDto = angular.copy(copyOrangeProposalInit);
                    endorseDto = angular.copy(endorseDto)
                    if (endorseDto) {
                        if(prpPheadDto){
                            proposalDto.prpPheadDto=prpPheadDto;
                            proposalDto.prpPheadDto.validDate=$filter("date")(prpPheadDto.validDate, 'yyyy-MM-dd');
                            proposalDto.prpPheadDto.endorDate=$filter("date")(prpPheadDto.endorDate, 'yyyy-MM-dd');
                            if(proposalDto.prpPheadDto.endorseType=='00'){
                                proposalDto.prpPheadDto.endorType="客户申请";
                            }else if(proposalDto.prpPheadDto.endorseType=='01'){
                                proposalDto.prpPheadDto.endorType="录入错误";
                            }else if(proposalDto.prpPheadDto.endorseType=='02'){
                                proposalDto.prpPheadDto.endorType="其他";
                            }
                        }
                        //基本信息转换
                        if(endorseDto.prpCmainDto){
                            proposalDto.prpTmainDto = endorseDto.prpCmainDto;
                            proposalDto.prpTmainDto.operateDate = $filter("date")(endorseDto.prpCmainDto.operateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.signDate = $filter("date")(endorseDto.prpCmainDto.signDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.inputDate = $filter("date")(endorseDto.prpCmainDto.inputDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.updateDate = $filter("date")(endorseDto.prpCmainDto.updateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.autoTransRenewFlag=endorseDto.prpCmainDto.autoTransRenewFlag//缴费方式
                            proposalDto.prpTmainDto.statQuantity=endorseDto.prpCmainDto.statQuantity
                            proposalDto.prpTmainDto.sumInsured=endorseDto.prpCmainDto.sumInsured;
                            //核保通过日期转换
                            proposalDto.prpTmainDto.underwriteEndDate = $filter("date")(endorseDto.prpCmainDto.underwriteEndDate, "yyyy-MM-dd");
                            //业务大类
                            $scope.parameterConvert.businessCategoryInit();
                            //险类名称
                            proposalDto.prpTmainDto.className=endorseDto.prpCmainDto.classCodeName
                            if(proposalDto.prpTmainDto.businessType1=="00"){
                                proposalDto.prpTmainDto.businessType1Name='商业性'
                            }else if(proposalDto.prpTmainDto.businessType1=="01"){
                                proposalDto.prpTmainDto.businessType1Name='中央政策性'
                            }else if(proposalDto.prpTmainDto.businessType1=="02"){
                                proposalDto.prpTmainDto.businessType1Name='地方政策性'
                            }
                            if(proposalDto.prpTmainDto.policySort=="0"){
                                proposalDto.prpTmainDto.policySort="普通"
                            }else if(proposalDto.prpTmainDto.policySort=="1"){
                                proposalDto.prpTmainDto.policySort="定额"
                            }
                            if(proposalDto.prpTmainDto.language=="C"){
                                proposalDto.prpTmainDto.language="中文"
                            }else if(proposalDto.prpTmainDto.language=="E"){
                                proposalDto.prpTmainDto.language="英文"
                            }else if(proposalDto.prpTmainDto.language=="Z"){
                                proposalDto.prpTmainDto.language="其他语种"
                            }
                            proposalDto.prpTmainDto.contractType=endorseDto.prpCmainDto.argueSolution//合同争议解决方式
                            if(endorseDto.prpCmainDto.remark){
                                proposalDto.prpTmainDto.reMark=endorseDto.prpCmainDto.remark;//出单员意见
                            }
                            if(endorseDto.prpCmainDto.groupNo){
                                proposalDto.prpTmainDto.modelCode=endorseDto.prpCmainDto.groupNo//模板号
                            }
                            proposalDto.prpTmainDto.className=endorseDto.prpCmainDto.classCodeName;//险类
                            proposalDto.prpTmainDto.riskCodeName=endorseDto.prpCmainDto.riskCodeName;//险种
                            if(endorseDto.prpCmainDto.othFlag.substring(0,1)==0){
                                proposalDto.editTypeName='新保'
                            }else if(endorseDto.prpCmainDto.othFlag.substring(0,1)==1){
                                proposalDto.editTypeName='复制投保单'
                            }
                            proposalDto.prpTmainDto.operatorName=endorseDto.prpCmainDto.operatorName;
                            proposalDto.prpTmainDto.updaterName=endorseDto.prpCmainDto.updaterName;
                        }
                        ////归属机构
                        //$scope.getComCodeList();
                        $scope.policy=true;
                        proposalDto.prpTmainDto.handler1Code1=proposalDto.prpTmainDto.tHandler1Name;
                        proposalDto.prpTmainDto.comCodename1= proposalDto.prpTmainDto.comName;
                        //投保方式
                        $scope.mulitSelectPolicyType(proposalDto.prpTmainDto.riskCode,proposalDto.prpTmainDto.policyType) //投保方式下拉初始化获取

                        //合同信息
                        if(endorseDto.prpCmainAgriDto){
                            proposalDto.prpTmainAgriDto = endorseDto.prpCmainAgriDto;
                            proposalDto.prpTmainAgriDto.raiseDate = $filter("date")(endorseDto.prpCmainAgriDto.raiseDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainAgriDto.policyNo = endorseDto.prpCmainAgriDto.policyNo;
                            //-------------------------------------养殖方式下拉框--------------------------------------
                            $scope.mulitSelectUnit(proposalDto.prpTmainDto.riskCode,proposalDto.prpTmainAgriDto.statUnitCode);//承保数量计数单位--种植险
                            $scope.mulitSelectRaiseType(proposalDto.prpTmainDto.riskCode,proposalDto.prpTmainAgriDto.raiseType);//承保数量计数单位--养殖险
                        }
                        //----------------------------------页面个性化开始----------------------------------------------------
                        if(proposalDto.prpTmainDto.riskCode=='3220' || proposalDto.prpTmainDto.riskCode=='3233'){
                            $scope.isAgriUnitCostMain = false;//隐藏单位生产成本
                            $scope.isProportion = true;
                        }else if ( proposalDto.prpTmainDto.riskCode=='3134'|| proposalDto.prpTmainDto.riskCode=='3147'
                            || proposalDto.prpTmainDto.riskCode=='3141'||proposalDto.prpTmainDto.riskCode=='3102'){
                            $rootScope.isTrue();
                        }

                        //赔付明细
                        $scope.isTriggerPoint = false;
                        $scope.isTotalLossRatio = false;
                        if(proposalDto.prpTmainDto.riskCode=='3107'|| proposalDto.prpTmainDto.riskCode=='3162'
                            || proposalDto.prpTmainDto.riskCode=='3155'|| proposalDto.prpTmainDto.riskCode=='3108' || proposalDto.prpTmainDto.riskCode=='3224'
                            || proposalDto.prpTmainDto.riskCode=='3130'|| proposalDto.prpTmainDto.riskCode=='3134'|| proposalDto.prpTmainDto.riskCode=='3147'
                            || proposalDto.prpTmainDto.riskCode=='3141'||proposalDto.prpTmainDto.riskCode=='3102'|| proposalDto.prpTmainDto.riskCode=='3101'
                            || proposalDto.prpTmainDto.riskCode=='3114'||proposalDto.prpTmainDto.riskCode=='3122'|| proposalDto.prpTmainDto.riskCode=='3126'
                            || proposalDto.prpTmainDto.riskCode=='3161'|| proposalDto.prpTmainDto.riskCode=='3149'){
                            //显示起赔点、全损损失率
                            $scope.isTriggerPoint = true;
                            $scope.isTotalLossRatio = true;
                        }

                        //种植方式
                        $scope.isRaiseType = false;
                        $scope.isProposalType = false;
                        if(proposalDto.prpTmainDto.riskCode=='3107'|| proposalDto.prpTmainDto.riskCode=='3162'
                            || proposalDto.prpTmainDto.riskCode=='3155'|| proposalDto.prpTmainDto.riskCode=='3108'
                            || proposalDto.prpTmainDto.riskCode=='3134'|| proposalDto.prpTmainDto.riskCode=='3147'
                            || proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'
                            || proposalDto.prpTmainDto.riskCode=='3101' || proposalDto.prpTmainDto.riskCode=='3114'
                            || proposalDto.prpTmainDto.riskCode=='3122'|| proposalDto.prpTmainDto.riskCode=='3126'
                            || proposalDto.prpTmainDto.riskCode=='3161'|| proposalDto.prpTmainDto.riskCode=='3149'){
                            $scope.isProposalType = true;
                        }else if(proposalDto.prpTmainDto.riskCode=='3220'||proposalDto.prpTmainDto.riskCode=='3233'){
                            $scope.isRaiseType = true;
                        }
                        if(proposalDto.prpTmainDto.riskCode=='3224'||proposalDto.prpTmainDto.riskCode=='3233'||proposalDto.prpTmainDto.riskCode=='3237'||proposalDto.prpTmainDto.riskCode=='3220'){
                            $scope.trRaiseName="养殖时间";
                            $scope.addressTitle="养殖地点";
                            //$scope.isTriggerPoint = true;
                            //$scope.isTotalLossRatio = true;
                        }else{
                            $scope.trRaiseName="种植时间";
                            $scope.addressTitle="种植地点";
                        }
                        //------------------------------------页面个性化结束------------------------------------------------
                        //清单信息
                        if(endorseDto.gisInsureListDto){
                            proposalDto.insureMainListDto=endorseDto.gisInsureListDto.gisInsureMainListDto;
                            proposalDto.insureMainListDto.insureListCode = endorseDto.gisInsureListDto.gisInsureMainListDto.insureListCode;
                            proposalDto.prpTmainDto.businessProvinceName=endorseDto.gisInsureListDto.gisInsureMainListDto.fProvinceName
                            proposalDto.prpTmainDto.businessCityName=endorseDto.gisInsureListDto.gisInsureMainListDto.fCityName
                            proposalDto.prpTmainDto.businessCountyName=endorseDto.gisInsureListDto.gisInsureMainListDto.fCountyName
                            proposalDto.prpTmainDto.businessTownName=endorseDto.gisInsureListDto.gisInsureMainListDto.fTownName
                            proposalDto.prpTmainDto.businessAreaName=endorseDto.gisInsureListDto.gisInsureMainListDto.fVillageName

                            if(endorseDto.gisInsureListDto.gisInsureMainListDto.listType=="D"){
                                proposalDto.insureMainListDto.listTypeFlag="大户"
                            }else if(endorseDto.gisInsureListDto.gisInsureMainListDto.listType=="S"){
                                proposalDto.insureMainListDto.listTypeFlag="散户"
                            }
                        }
                        $$finder.find('queryInsurePreliminaryConfirm', {
                            "insureListCode": proposalDto.insureMainListDto.insureListCode,//金禾清单号
                            "serialNo":proposalDto.insureMainListDto.serialNo,//标的清单序号

                        }, {
                            success: function (data) {
                                //投保人客户类型置灰
                                if($scope.proposal.appliInsuredDto.insuredType!=null&&$scope.proposal.appliInsuredDto.insuredType!=""&&$scope.proposal.appliInsuredDto.insuredType!=undefined){
                                    $rootScope.kelei=true;
                                    if($scope.proposal.appliInsuredDto.insuredType=='3'){//当是非企业团体时
                                        $rootScope.zhenglei=true;
                                        $rootScope.zhenghao=true;
                                        $rootScope.feiqiyetuanti=true;
                                    }else{
                                        $rootScope.feiqiyetuanti=false;
                                    }
                                }
                                //被保险人客户类型置灰
                                if($scope.proposal.insuredDto.insuredType!=null&&$scope.proposal.insuredDto.insuredType!=""&&$scope.proposal.insuredDto.insuredType!=undefined){
                                    $rootScope.kelei1=true;
                                }
                                $scope.proposal.certificate = false;
                                $scope.proposal.certificate1 = false;
                                if (data.content.gisFarmerListDtoList.length > 1) {//是散户的情况

                                }else{
                                    if(($scope.proposal.appliInsuredDto.insuredName == data.content.gisFarmerListDtoList[0].fName)&&$scope.proposal.appliInsuredDto.insuredName){//客户名称
                                        $scope.keming = true;
                                    }
                                    if(($scope.proposal.appliInsuredDto.identifyType == data.content.gisFarmerListDtoList[0].fIdType)&&$scope.proposal.appliInsuredDto.identifyType){//证件类型
                                        $scope.zhenglei = true;
                                    }
                                    if($scope.proposal.appliInsuredDto.identifyNumber&&($scope.proposal.appliInsuredDto.identifyNumber == data.content.gisFarmerListDtoList[0].fIdCard)){//证件号码
                                        $scope.zhenghao  =true;
                                    }
                                    if($scope.proposal.appliInsuredDto.mobile&&($scope.proposal.appliInsuredDto.mobile == data.content.gisFarmerListDtoList[0].fPhone)){//移动电话
                                        $scope.yidian =true;
                                    }
                                    if($scope.proposal.appliInsuredDto.phoneNumber&&($scope.proposal.appliInsuredDto.phoneNumber == data.content.gisFarmerListDtoList[0].fPhone)){//固定电话
                                        $scope.gudian = true;
                                    }
                                    if($scope.proposal.appliInsuredDto.insuredAddress&&($scope.proposal.appliInsuredDto.insuredAddress == data.content.gisFarmerListDtoList[0].fAddress)){//客户地址
                                        $scope.kedi = true;
                                    }
                                    if($scope.proposal.appliInsuredDto.account&&($scope.proposal.appliInsuredDto.account== data.content.gisFarmerListDtoList[0].accountNo)){//银行账号
                                        $scope.yinzhang = true;
                                    }
                                    if($scope.proposal.appliInsuredDto.bank&&($scope.proposal.appliInsuredDto.bank == data.content.gisFarmerListDtoList[0].bankName)){//开户行
                                        $scope.kaihu = true;
                                    }
                                    //被保险人
                                    if($scope.proposal.insuredDto.insuredName&&($scope.proposal.insuredDto.insuredName == data.content.gisFarmerListDtoList[0].fName)){//客户名称
                                        $scope.keming1 = true;
                                    }
                                    if($scope.proposal.insuredDto.identifyType&&($scope.proposal.insuredDto.identifyType == data.content.gisFarmerListDtoList[0].fIdType)){//证件类型
                                        $scope.zhenglei1 = true;
                                    }
                                    if($scope.proposal.insuredDto.identifyNumber&&($scope.proposal.insuredDto.identifyNumber == data.content.gisFarmerListDtoList[0].fIdCard)){//证件号码
                                        $scope.zhenghao1  =true;
                                    }
                                    if($scope.proposal.insuredDto.mobile&&($scope.proposal.insuredDto.mobile == data.content.gisFarmerListDtoList[0].fPhone)){//移动电话
                                        $scope.yidian1 =true;
                                    }
                                    if($scope.proposal.insuredDto.phoneNumber&&($scope.proposal.insuredDto.phoneNumber == data.content.gisFarmerListDtoList[0].fPhone)){//固定电话
                                        $scope.gudian1 = true;
                                    }
                                    if($scope.proposal.insuredDto.insuredAddress&&($scope.proposal.insuredDto.insuredAddress == data.content.gisFarmerListDtoList[0].fAddress)){//客户地址
                                        $scope.kedi1 = true;
                                    }
                                    if($scope.proposal.insuredDto.account&&($scope.proposal.insuredDto.account== data.content.gisFarmerListDtoList[0].accountNo)){//银行账号
                                        $scope.yinzhang1 = true;
                                    }
                                    if($scope.proposal.insuredDto.bank&&($scope.proposal.insuredDto.bank == data.content.gisFarmerListDtoList[0].bankName)){//开户行
                                        $scope.kaihu1 = true;
                                    }
                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                        //种植地点
                        if(endorseDto.prpCaddressDtoList && endorseDto.prpCaddressDtoList.length>0){
                            proposalDto.prpTaddressDto = endorseDto.prpCaddressDtoList[0];
                        }
                        //主险附加险
                        if(endorseDto.prpCitemKindDtoList&&endorseDto.prpCitemKindDtoList.length>0){
                            proposalDto.prpTitemKindDtoList = endorseDto.prpCitemKindDtoList;
                            angular.forEach(endorseDto.prpCitemKindDtoList,function(data,index){
                                if(data.flag) {
                                    data.radioType = data.flag.substr(1, 2) == 1 ? 'Y' : 'N';
                                }
                                data.shortRate=round(data.shortRate,2);
                                data.amount=round(data.amount,2);
                                data.premium=round(data.premium,2)
                                data.unitPremium=round(data.unitPremium,2)
                            })
                        }
                        //茬次信息赋值
                        if(endorseDto.prpCitemKindAgriDtoList && endorseDto.prpCitemKindAgriDtoList.length>0){
                            var prpTitemKindAgriDtoListCopy=[]
                            if(proposalDto.prpTmainDto.riskCode=='3134'|| proposalDto.prpTmainDto.riskCode=='3147'
                                || proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102') {
                                angular.forEach(endorseDto.prpCitemKindAgriDtoList, function (_data) {
                                    if((_data.distributingRate!=null&&_data.distributingRate!=undefined)
                                        && (_data.timesAmount!=null&&_data.timesAmount!=undefined)
                                        && (_data.stratDate!=null&&_data.stratDate!=undefined)
                                        && (_data.endDate!=null&&_data.endDate!=undefined)){
                                        _data.timesAmount=round(_data.timesAmount,2);
                                        prpTitemKindAgriDtoListCopy.push(_data);
                                    }
                                });
                                proposalDto.prpTitemKindAgriDtoListCopy=prpTitemKindAgriDtoListCopy;
                            }
                        }
                        if(endorseDto.prpCitemKindDtoList && endorseDto.prpCitemKindDtoList.length>0){
                            proposalDto.prpTitemKindDtoList = endorseDto.prpCitemKindDtoList;
                            proposalDto.prpTitemKindAgriDtoList=endorseDto.prpCitemKindAgriDtoList;
                            angular.forEach(proposalDto.prpTitemKindDtoList,function(data,index){
                                if(proposalDto.prpTmainDto.riskCode=='3220'||proposalDto.prpTmainDto.riskCode=='3233'){
                                    data.agriUnitCostMaintitle = '何价投保';
                                    data.unitCostName = '元/头';
                                    data.proportionName = '%';
                                    data.untilName = "元";
                                    data.untilName1 = '头';
                                    data.untilKindName = "投保头数";
                                }else if (proposalDto.prpTmainDto.riskCode=='3107'|| proposalDto.prpTmainDto.riskCode=='3162'
                                    ||proposalDto.prpTmainDto.riskCode=='3155'|| proposalDto.prpTmainDto.riskCode=='3108'
                                    || proposalDto.prpTmainDto.riskCode=='3130'|| proposalDto.prpTmainDto.riskCode=='3101'
                                    || proposalDto.prpTmainDto.riskCode=='3114'|| proposalDto.prpTmainDto.riskCode=='3122'
                                    || proposalDto.prpTmainDto.riskCode=='3126'|| proposalDto.prpTmainDto.riskCode=='3161'
                                    || proposalDto.prpTmainDto.riskCode=='3149'){
                                    data.agriUnitCostMaintitle = '单位生产成本';
                                    data.unitCostName = '元';
                                    data.untilKindName = "投保面积";
                                    data.agriUnitOutputMaintitle="单位保险产量";
                                    data.agriUnitOutputMainName="公斤";
                                }else if(proposalDto.prpTmainDto.riskCode=='3224'){
                                    data.untilKindName = "投保面积";
                                    data.agriUnitCostMaintitle = '单位保险产量';
                                    data.unitCostName = '公斤';
                                    data.agriUnitOutputMainName="公斤";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }else if(proposalDto.prpTmainDto.riskCode=='3134'|| proposalDto.prpTmainDto.riskCode=='3147'
                                    || proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'){
                                    data.untilKindName = "投保面积";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }
                                if (proposalDto.prpTmainDto.riskCode == '3134' || proposalDto.prpTmainDto.riskCode == '3147'
                                    || proposalDto.prpTmainDto.riskCode == '3141' || proposalDto.prpTmainDto.riskCode=='3102') {
                                    angular.forEach(proposalDto.prpTitemKindDtoList, function (data_1, index) {
                                        angular.forEach(proposalDto.prpTitemKindAgriDtoList, function (_data, index) {
                                            if (_data.times<=0 && data.itemKindNo == _data.itemKindNo ) {
                                                data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                                data_1.unitAmount = _data.unitAmount;//单位保险金额
                                            }
                                        });
                                    });
                                }else{
                                    angular.forEach(proposalDto.prpTitemKindDtoList, function (data_1, index) {
                                        angular.forEach(proposalDto.prpTitemKindAgriDtoList, function (_data) {
                                            if (data_1.itemKindNo == _data.itemKindNo) {
                                                data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                                data_1.unitAmount = _data.unitAmount;//单位保险金额
                                                data_1.agriUnitCostMain = _data.unitCost;//单位生产成本
                                                data_1.agriTimesAmount = _data.timesAmount;//约定单价
                                                if(_data.unitOutput){
                                                    data_1.agriUnitOutputMain=_data.unitOutput//单位保险产量
                                                }
                                                data_1.proportion = _data.proportion;//投保成数
                                            }
                                        })
                                    });
                                }
                            });
                        }

                        //补贴信息
                        if(endorseDto.prpCsubsidyDtoList&&endorseDto.prpCsubsidyDtoList.length>0){
                            angular.forEach(endorseDto.prpCsubsidyDtoList,function(_data){
                                _data.subsidyPremium=round( _data.subsidyPremium,2)
                            });
                            proposalDto.prpTsubsidyDtoList =endorseDto.prpCsubsidyDtoList ;
                        }
                        //币别信息
                        if(endorseDto.prpCfeeDtoList && endorseDto.prpCfeeDtoList.length>0){
                            proposalDto.prpTfeeDto = endorseDto.prpCfeeDtoList[0];
                            $scope.currency2Name=proposalDto.prpTfeeDto.currency2Name+"";
                        }
                        $scope.totalAmount = round(endorseDto.prpCmainDto.sumAmount,2);
                        $scope.totalPay = round(endorseDto.prpCmainDto.sumPremium,2);
                        //特约信息
                        if(endorseDto.queryProposalPrpTengageDtoList && endorseDto.queryProposalPrpTengageDtoList.length>0){
                            var prpTengageDtoList=[]
                            angular.forEach(endorseDto.queryProposalPrpTengageDtoList,function(_data){
                                if(_data.clauseCode!="TX001"&&_data.clauseCode!="TX004"){
                                    var obj={
                                        clauses:"",
                                        clauseCode:"",
                                        clausesContent:"",
                                        flag:""
                                    }
                                    obj.clauses=_data.clauseName,//特约名称
                                    obj.clauseCode=_data.clauseCode,//特约代码
                                    obj.clausesContent=_data.clausesContent//特约内容
                                    obj.flag=_data.flag,
                                    prpTengageDtoList.push(obj)
                                }
                            });

                            proposalDto.prpTengageDtoCopy = prpTengageDtoList;

                            //绝对免赔率和免赔说明
                            proposalDto.engageQueryClause=proposalDto.engageQueryClause||{};
                            angular.forEach(endorseDto.queryProposalPrpTengageDtoList,function(data,index){
                                var clausesContent = data.clausesContent;
                                // 绝对免赔率
                                if(data.clauseCode==='TX001'){
                                    proposalDto.engageQueryClause.absuDedu = clausesContent;
                                }
                                // 免赔说明
                                if (data.clauseCode==='TX004'){
                                    proposalDto.engageQueryClause.deduText = clausesContent;
                                }
                            });
                        }
                        // 3130保险期间内草莓采收期起始日期begin
                        proposalDto.prpTitemKindAgri = proposalDto.prpTitemKindAgri || {};
                        $scope.proposal.prpTitemKindAgri = $scope.proposal.prpTitemKindAgri || {};
                        if(endorseDto.prpCitemKindAgriDtoList.length>0){
                            if (endorseDto.prpCitemKindAgriDtoList[0].stratDate) {
                                proposalDto.prpTitemKindAgri.stratDate = endorseDto.prpCitemKindAgriDtoList[0].stratDate;
                            }
                            if (endorseDto.prpCitemKindAgriDtoList[0].endDate) {
                                proposalDto.prpTitemKindAgri.endDate = endorseDto.prpCitemKindAgriDtoList[0].endDate;
                            }
                        }
                        // 3130保险期间内草莓采收期起始日期end
                        //缴费计划信息
                        if(endorseDto.prpCplanDtoList&&endorseDto.prpCplanDtoList.length>0){
                            proposalDto.prpTplanDtoList = endorseDto.prpCplanDtoList;
                            angular.forEach(proposalDto.prpTplanDtoList, function (data, index) {
                                data.planFee=round(data.planFee,2);
                                data.planStartDate =
                                    $filter("date")(data.planStartDate, 'yyyy-MM-dd');
                                data.planDate =
                                    $filter("date")(data.planDate, 'yyyy-MM-dd');
                                //从表里面查询有03，04，这里转换一下
                                if (data.payReason=='03'){//中央财政
                                    data.payReason='RS3'
                                }
                                if (data.payReason=='04'){//省级财政
                                    data.payReason='RS4'
                                }
                                if (data.payReason=='05'){//地市财政
                                    data.payReason='RS5'
                                }
                                if (data.payReason=='06'){//其他来源
                                    data.payReason='RS6'
                                }
                                if (data.payReason=='07'){//县(区)财政
                                    data.payReason='RS7'
                                }
                                //if(data.payReason==='R10'){
                                //    data.payReasonName='签单收保费';
                                //}else if(data.payReason==='R20'){
                                //    data.payReasonName='分期收保费'
                                //}else if(data.payReason==='RS3'){
                                //    data.payReasonName='中央财政'
                                //}else if(data.payReason==='RS4'){
                                //    data.payReasonName='省级财政'
                                //}else if(data.payReason==='RS5'){
                                //    data.payReasonName='地市财政'
                                //}else if(data.payReason==='RS6'){
                                //    data.payReasonName='其他来源'
                                //}else if(data.payReason==='RS7'){
                                //    data.payReasonName='县(区)财政'
                                //}else if(data.payReason==='PS3'){
                                //    data.payReasonName='中央财政补贴批改'
                                //}else if(data.payReason==='R30'){
                                //    data.payReasonName='加保/加费-保费'
                                //}
                                data.palnRealFee=round(parseFloat(data.planFee-data.delinquentFee),2);//实缴金额 = 应缴金额 - 拖欠金额
                                data.currency2Name=data.planCurrencyName+""
                            });
                        }
                        //客户信息
                        if(endorseDto.prpCinsuredDtoList&&endorseDto.prpCinsuredDtoList.length>0){
                            angular.forEach(endorseDto.prpCinsuredDtoList, function (data) {
                                //data.businessName=data.businessSource;//行业名称
                                //data.businessSort=data.businessSort;//公司性质
                                data.identifyType=data.identifyType;//客户代码
                                data.certificateName=data.insuredCode
                                $scope.getIdentity(data.insuredType,data.identifyType);
                                if (data.insuredFlag === "2") {
                                    proposalDto.appliInsuredDto = data;
                                } else if (data.insuredFlag === "1") {
                                    proposalDto.insuredDto = data;
                                }
                            });
                        }else{
                            proposalDto.appliInsuredDto=[];
                            proposalDto.insuredDto=[]
                        }
                        //发票购货方信息
                        if(endorseDto.prpDcustomerTaxPayInfoDto){
                            proposalDto.prpDcustomerTaxPayInfoDto = endorseDto.prpDcustomerTaxPayInfoDto;
                        }

                        //户信息中被保险人中的  同投保人选择按钮
                        if(type=="init") {
                            proposalDto.appliInsuredDto.insuredCode == proposalDto.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                        }
                        //发票购货方信息  选择同投保人、被投保人
                        //if(proposalDto.prpDcustomerTaxPayInfoDto){
                        //    proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject=="1"?proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput="1":proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput="";
                        //}
                        //发票购货方信息  选择同投保人、被投保人
                        if (proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject == "1" ){
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                        }else if(proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject == "2" ){
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
                        }else {
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }

                        //其他信息转换
                        proposalDto.prpTcoinsDtoList = endorseDto.prpCcoinsDtoList;
                        proposalDto.prpTcoinsDetailDtoList = endorseDto.prpCcoinsDetailDtoList;
                        proposalDto.prpTplanCoinsDtoList = endorseDto.prpCplanCoinsDtoList;
                        if(proposalDto.prpTcoinsDtoList.length>0 && proposalDto.prpTcoinsDetailDtoList.length>0&&proposalDto.prpTplanCoinsDtoList.length>0){
                            $scope.otherQueryHide=true;
                            $scope.PremiumShow = true;
                            $scope.showCoins=false;
                            $scope.isHide=false;
                            $scope.proposal.otherAgentFeeShow=false;
                        }
                        proposalDto.prpTexpenseDto=endorseDto.prpCexpenseDto;
                    }
                    proposalDto.doSaveFlag=true;//普通批改保费计算检查有误保额保费变化使用
                    if(type=='init'){
                        var date1='';
                        var date2='';
                        angular.forEach(proposalDto.prpTplanDtoList, function (item1,inde1) {
                            if(item1.payReason=="R10"){
                                date1=item1.planDate;
                            }else if("PS3,PS4,PS5,PS6,PS7,R30,R20,R81,R82,P10,P40,R10".indexOf(item1.payReason)==-1){

                                date2=item1.planDate ;
                            };
                        });
                        angular.forEach(proposalDto.prpTplanDtoList, function (item,inde) {
                            var startDate;
                            var str;
                            item.planFee=round(item.planFee,2);
                            if(item.planStartDate==undefined){
                                item.planStartDate=$filter("date")(new Date(), 'yyyy-MM-dd');
                            }
                            if("PS3,PS4,PS5,PS6,PS7".indexOf(item.payReason)>-1){
                                item.planDate= date2;
                            }else if(item.payReason=="R30"||item.payReason=="R20"||item.payReason=="R30"||item.payReason=="R81"||item.payReason=="R82"||item.payReason=="P10"||item.payReason=="P40"){
                                item.planDate=date1;
                            }
                            item.palnRealFee=round(parseFloat(item.planFee-item.delinquentFee),2)
                        });
                    }
                    return proposalDto
                };

                //保存时获取的老数据
                var proposalDtoConvertEndorseDto = function (proposalDto) {
                    var endorseDto = {};
                    proposalDto = angular.copy(proposalDto);
                    if (proposalDto) {
                        //var responseQueryPolicyInfoDto =  data.responseQueryPolicyInfoDto;
                        endorseDto.prpCinsuredDtoList=[];
                        endorseDto.prpCaddressDtoList=[];
                        endorseDto.prpCfeeDtoList=[];
                        //基本信息转换
                        endorseDto.prpCmainDto = proposalDto.prpTmainDto;
                        endorseDto.prpCmainDto.sumPremium=0;
                        angular.forEach(proposalDto.prpTitemKindDtoList,function(item,index){
                            endorseDto.prpCmainDto.sumPremium+= parseFloat(item.premium);
                        });
                        endorseDto.prpCmainDto.operateDate = proposalDto.prpTmainDto.operateDate;
                        $scope.parameterConvert.businessCategorySubmit();
                        //合同信息
                        endorseDto.prpCmainAgriDto=proposalDto.prpTmainAgriDto;
                        endorseDto.prpCmainAgriDto.raiseDate=proposalDto.prpTmainAgriDto.raiseDate;
                        endorseDto.prpCmainAgriDto.policyNo=proposalDto.prpTmainAgriDto.policyNo;
                        endorseDto.prpCaddressDtoList[0]=proposalDto.prpTaddressDto;
                        if(proposalDto.plantingPolicyListDtoList!=undefined){
                            endorseDto.plantingPolicyListDtoList=proposalDto.plantingPolicyListDtoList;
                        }
                        endorseDto.prpCitemKindDtoList=proposalDto.prpTitemKindDtoList;
                        //用于茬次信息
                        var riskCode="";
                        //var itemKindNo="";
                        var kindCode="";
                        angular.forEach($scope.proposal.prpTitemKindDtoList,function(data,index){
                            data.calculateFlag=data.radioType;//prpTitemKindDtoList标识位
                            if(data.radioType==='Y') {
                                riskCode = data.riskCode;
                                //itemKindNo = data.itemKindNo;
                                kindCode = data.kindCode;
                            }
                        })

                        var prpTitemKindAgriDtoList=prpTitemKindAgriDtoList||[];
                        angular.forEach(proposalDto.prpTitemKindAgriDtoList,function(item){
                            if (item.times<=0) {
                                prpTitemKindAgriDtoList.push(item);
                            }

                        })

                        endorseDto.prpCitemKindAgriDtoList=prpTitemKindAgriDtoList;

                        angular.forEach(endorseDto.prpCitemKindDtoList, function (data_1, index) {
                            angular.forEach(endorseDto.prpCitemKindAgriDtoList, function (_data) {
                                if (data_1.itemKindNo == _data.itemKindNo) {
                                    _data.grossQuantity=data_1.agriGrossQuantityMain;//投保面积
                                    _data.unitAmount=data_1.unitAmount ;//单位保险金额
                                    _data.unitCost=data_1.agriUnitCostMain ;//单位生产成本
                                    _data.timesAmount= data_1.agriTimesAmount ;//约定单价
                                    if(data_1.agriUnitOutputMain){
                                        _data.unitOutput=data_1.agriUnitOutputMain//单位保险产量
                                    }
                                    _data.proportion=data_1.proportion;//投保成数
                                }
                            })
                        })
                        endorseDto.prpCsubsidyDtoList=proposalDto.prpTsubsidyDtoList;
                        endorseDto.prpCfeeDtoList[0]=proposalDto.prpTfeeDto;
                        //endorseDto.prpCitemKindAgriDtoList[0].flag='U1';
                        //endorseDto.prpPheadDto.makeCom=$rootScope.user.makeCom;
                        endorseDto.prpCmainDto.makeCom=$rootScope.user.makeCom;

                        //endorseDto.endorseConditionDto.endoretype=$stateParams.endorseType;
                        endorseDto.prpCmainAgriDto.raiseSite=proposalDto.prpTaddressDto.addressName;
                        endorseDto.prpCmainDto.systemFlag='agri';
                        //特约信息
                        var prpCengageDtoList=prpCengageDtoList||[]
                        angular.forEach(proposalDto.prpTengageDtoCopy,function(item,index){
                            var obj = angular.copy(item);
                            obj.serialNo = proposalDto.prpTengageDtoCopy.length;//序号不能从0开始所以加1
                            obj.lineNo = 1;//换行
                            obj.titleFlag = 0;
                            obj.policyNo= endorseDto.prpCmainDto.policyNo;
                            obj.riskCode= endorseDto.prpCmainDto.riskCode;
                            obj.flag = obj.flag;
                            prpCengageDtoList.push(obj);
                            if(item.clausesContent) {//如果内容里有东西
                                var obj = angular.copy(item);
                                obj.serialNo = proposalDto.prpTengageDtoCopy.length - 1;
                                obj.lineNo = 2;//换行
                                obj.titleFlag = 1;
                                obj.flag = obj.flag;
                                obj.clauses = obj.clausesContent;//把内容放入名称属性中
                                obj.policyNo = endorseDto.prpCmainDto.policyNo;
                                obj.riskCode = endorseDto.prpCmainDto.riskCode;
                                prpCengageDtoList.push(obj);
                            }
                        })

debugger
                        // 免赔率信息生成
                        if ($scope.proposal.engageQueryClause.absuDedu) {
                            var obj = {};
                            obj.serialNo = 1;//序号不能从0开始所以加1
                            obj.lineNo = 1;//换行
                            obj.titleFlag = 0;
                            obj.flag = 0;
                            obj.clauseCode = 'TX001';
                            obj.clauses = '绝对免赔率';
                            obj.policyNo = endorseDto.prpCmainDto.policyNo;
                            obj.riskCode = endorseDto.prpCmainDto.riskCode;
                            prpCengageDtoList.push(obj);
                            var obj1 = {};
                            obj1.serialNo = 1;//序号不能从0开始所以加1
                            obj1.lineNo = 2;//换行
                            obj1.titleFlag = 1;
                            obj1.flag = 1;
                            obj1.clauseCode = 'TX001';
                            obj1.clauses = $scope.proposal.engageQueryClause.absuDedu;
                            obj1.policyNo = endorseDto.prpCmainDto.policyNo;
                            obj1.riskCode = endorseDto.prpCmainDto.riskCode;
                            prpCengageDtoList.push(obj1);
                        }
                        // 免赔说明信息生成
                        if ($scope.proposal.engageQueryClause.deduText) {
                            var obj = {};
                            obj.serialNo = 1;//序号不能从0开始所以加1
                            obj.lineNo = 1;//换行
                            obj.titleFlag = 0;
                            obj.flag = 0;
                            obj.clauseCode = 'TX004';
                            obj.clauses = '免赔说明';
                            obj.policyNo =endorseDto.prpCmainDto.policyNo;
                            obj.riskCode = endorseDto.prpCmainDto.riskCode;
                            prpCengageDtoList.push(obj);
                            var obj1 = {};
                            obj1.serialNo = 1;//序号不能从0开始所以加1
                            obj1.lineNo = 2;//换行
                            obj1.titleFlag = 1;
                            obj1.flag = 1;
                            obj1.clauseCode = 'TX004';
                            obj1.clauses = $scope.proposal.engageQueryClause.deduText;
                            obj1.policyNo = endorseDto.prpCmainDto.policyNo;
                            obj1.riskCode = endorseDto.prpCmainDto.riskCode;
                            prpCengageDtoList.push(obj1);
                        }

                        if(prpCengageDtoList.length>0){
                            endorseDto.prpCengageDtoList=prpCengageDtoList;
                        }
                        endorseDto.prpCplanDtoList=proposalDto.prpTplanDtoList;
                        if(proposalDto.prpTexpenseDto){
                            endorseDto.prpCexpenseDto=proposalDto.prpTexpenseDto;
                        }
                        angular.forEach(endorseDto.prpCplanDtoList,function(data,index){
                            endorseDto.prpCplanDtoList[index].planStartDate = proposalDto.prpTplanDtoList[index].planStartDate;
                            //endorseDto.prpCplanDtoList[index].planDate = proposalDto.prpCplanDtoList[index].planDate;
                        });
                        //客户信息
                        endorseDto.prpCinsuredDtoList[0]=proposalDto.appliInsuredDto;
                        endorseDto.prpCinsuredDtoList[1]=proposalDto.insuredDto;
                        // angular.forEach(proposalDto.prpTinsuredDtoList,function(data){
                        //     //          data.proposalNo= proposalDto.prpTfeeDto.proposalNo
                        //     // data.riskCode= proposalDto.prpTfeeDto.riskCode
                        //     // if(data.insuredFlag === "2"){
                        //     //     endorseDto.appliInsuredDto = data;
                        //     // }else if(data.insuredFlag === "1"){
                        //     //     endorseDto.insuredDto = data;
                        //     // }
                        // });
                        if(proposalDto.prpDcustomerTaxPayInfoDto!=undefined){
                            endorseDto.prpDcustomerTaxPayInfoDto = proposalDto.prpDcustomerTaxPayInfoDto;
                        }
                        //其他信息转换

                        endorseDto.prpCcoinsDtoList = proposalDto.prpTcoinsDto;
                        endorseDto.prpCcoinsDetailDtoList = proposalDto.prpTcoinsDetailDto;
                        endorseDto.prpCplanCoinsDtoList = proposalDto.prpTplanCoinsDtoList;
                        if($scope.approvalPageFlag==true){
                            if(proposalDto.prpTmainDto.policySort=="普通"){
                                proposalDto.prpTmainDto.policySort="0"
                            }else if(proposalDto.prpTmainDto.policySort=="定额"){
                                proposalDto.prpTmainDto.policySort="1"
                            }
                            if(proposalDto.prpTmainDto.language=="中文"){
                                proposalDto.prpTmainDto.language="C"
                            }else if(proposalDto.prpTmainDto.language=="英文"){
                                proposalDto.prpTmainDto.language="E"
                            }else if(proposalDto.prpTmainDto.language=="其语种他"){
                                proposalDto.prpTmainDto.language="Z"
                            }
                        }
                        //茬次此信息
                        //var prpCitemKindAgriDtoList=prpCitemKindAgriDtoList||[]
                        if(proposalDto.prpTmainDto.riskCode=='3134' || proposalDto.prpTmainDto.riskCode=='3147'||proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'){
                            var times=0
                            angular.forEach(proposalDto.prpTitemKindAgriDtoListCopy,function(dto){
                                dto.policyNo=proposalDto.prpTmainDto.policyNo;
                                dto.riskCode=riskCode;
                                //dto.itemKindNo=itemKindNo;
                                dto.kindCode=kindCode;
                                if(isNaN(dto.times)){
                                    dto.times=0;
                                }
                                times=times+1;
                                dto.times=times;
                                dto.flag=dto.flag
                                endorseDto.prpCitemKindAgriDtoList.push(dto);
                            });
                        }

                    }
                    return endorseDto
                };
                //批单数据转换
                var prpPheadDto=prpPheadDto||{}
                var endorsePmainDtoConvertProposalDto = function (endorseDto) {
                    var proposalDto = angular.copy(copyOrangeProposalInit);
                    endorseDto = angular.copy(endorseDto)
                    if (endorseDto) {
                        //批改信息表
                        if(endorseDto.prpPheadDto){
                            prpPheadDto=endorseDto.prpPheadDto;
                            proposalDto.prpPheadDto=endorseDto.prpPheadDto;
                            proposalDto.prpPheadDto.validDate=$filter("date")(endorseDto.prpPheadDto.validDate, 'yyyy-MM-dd');
                            proposalDto.prpPheadDto.endorDate=$filter("date")(endorseDto.prpPheadDto.endorDate, 'yyyy-MM-dd');
                        }else if(endorseDto.prpPheadCopyDto){
                            //若p表没有值，则从copy表取数据
                            prpPheadDto=endorseDto.prpPheadCopyDto;
                            proposalDto.prpPheadDto=endorseDto.prpPheadCopyDto;
                            proposalDto.prpPheadDto.validDate=$filter("date")(endorseDto.prpPheadCopyDto.validDate, 'yyyy-MM-dd');
                            proposalDto.prpPheadDto.endorDate=$filter("date")(endorseDto.prpPheadCopyDto.endorDate, 'yyyy-MM-dd');
                        }

                        //基本信息转换
                        if(endorseDto.prpPmainDto){
                            proposalDto.prpTmainDto = endorseDto.prpPmainDto;
                            proposalDto.prpTmainDto.operateDate = $filter("date")(endorseDto.prpPmainDto.operateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.signDate = $filter("date")(endorseDto.prpPmainDto.signDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.inputDate = $filter("date")(endorseDto.prpPmainDto.inputDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.updateDate = $filter("date")(endorseDto.prpPmainDto.updateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.autoTransRenewFlag=endorseDto.prpPmainDto.autoTransRenewFlag//缴费方式
                            //业务大类
                            $scope.parameterConvert.businessCategoryInit();
                            //险类名称
                            proposalDto.prpTmainDto.className=endorseDto.prpPmainDto.classCodeName
                            if(proposalDto.prpTmainDto.businessType1=="00"){
                                proposalDto.prpTmainDto.businessType1Name='商业性'
                            }else if(proposalDto.prpTmainDto.businessType1=="01"){
                                proposalDto.prpTmainDto.businessType1Name='中央政策性'
                            }else if(proposalDto.prpTmainDto.businessType1=="02"){
                                proposalDto.prpTmainDto.businessType1Name='地方政策性'
                            }
                            if(proposalDto.prpTmainDto.policySort=="0"){
                                proposalDto.prpTmainDto.policySort="普通"
                            }else if(proposalDto.prpTmainDto.policySort=="1"){
                                proposalDto.prpTmainDto.policySort="定额"
                            }
                            if(proposalDto.prpTmainDto.language=="C"){
                                proposalDto.prpTmainDto.language="中文"
                            }else if(proposalDto.prpTmainDto.language=="E"){
                                proposalDto.prpTmainDto.language="英文"
                            }else if(proposalDto.prpTmainDto.language=="Z"){
                                proposalDto.prpTmainDto.language="其他语种"
                            }
                            proposalDto.prpTmainDto.contractType=endorseDto.prpPmainDto.argueSolution//合同争议解决方式
                            if(endorseDto.prpPmainDto.remark){
                                proposalDto.prpTmainDto.reMark=endorseDto.prpPmainDto.remark;//出单员意见
                            }
                            if(endorseDto.prpPmainDto.groupNo){
                                proposalDto.prpTmainDto.modelCode=endorseDto.prpPmainDto.groupNo//模板号
                            }
                            //归属机构
                            $scope.getComCodeList();
                            //归属业务员
                            $scope.getHanCode({comName:proposalDto.prpTmainDto.comName},proposalDto.prpTmainDto.handler1Code);
                            //投保方式
                            $scope.mulitSelectPolicyType(proposalDto.prpTmainDto.riskCode,proposalDto.prpTmainDto.policyType)//投保方式下拉初始化获取
                            $scope.totalAmount =round(endorseDto.prpPmainDto.sumAmount,2);
                            $scope.totalPay = round(endorseDto.prpPmainDto.sumPremium,2);

                        }else if(endorseDto.prpPmainCopyDto){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTmainDto = endorseDto.prpPmainCopyDto;
                            proposalDto.prpTmainDto.operateDate = $filter("date")(endorseDto.prpPmainCopyDto.operateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.signDate = $filter("date")(endorseDto.prpPmainCopyDto.signDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.inputDate = $filter("date")(endorseDto.prpPmainCopyDto.inputDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.updateDate = $filter("date")(endorseDto.prpPmainCopyDto.updateDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainDto.autoTransRenewFlag=endorseDto.prpPmainCopyDto.autoTransRenewFlag//缴费方式
                            //业务大类
                            $scope.parameterConvert.businessCategoryInit();
                            //险类名称
                            proposalDto.prpTmainDto.className=endorseDto.prpPmainCopyDto.classCodeName
                            if(proposalDto.prpPmainCopyDto.businessType1=="00"){
                                proposalDto.prpTmainDto.businessType1Name='商业性'
                            }else if(proposalDto.prpTmainDto.businessType1=="01"){
                                proposalDto.prpTmainDto.businessType1Name='中央政策性'
                            }else if(proposalDto.prpTmainDto.businessType1=="02"){
                                proposalDto.prpTmainDto.businessType1Name='地方政策性'
                            }
                            if(proposalDto.prpTmainDto.policySort=="0"){
                                proposalDto.prpTmainDto.policySort="普通"
                            }else if(proposalDto.prpTmainDto.policySort=="1"){
                                proposalDto.prpTmainDto.policySort="定额"
                            }
                            if(proposalDto.prpTmainDto.language=="C"){
                                proposalDto.prpTmainDto.language="中文"
                            }else if(proposalDto.prpTmainDto.language=="E"){
                                proposalDto.prpTmainDto.language="英文"
                            }else if(proposalDto.prpTmainDto.language=="Z"){
                                proposalDto.prpTmainDto.language="其他语种"
                            }
                            proposalDto.prpTmainDto.contractType=endorseDto.prpPmainCopyDto.argueSolution//合同争议解决方式
                            if(endorseDto.prpPmainCopyDto.remark){
                                proposalDto.prpTmainDto.reMark=endorseDto.prpPmainCopyDto.remark;//出单员意见
                            }
                            if(endorseDto.prpPmainCopyDto.groupNo){
                                proposalDto.prpTmainDto.modelCode=endorseDto.prpPmainCopyDto.groupNo//模板号
                            }
                            $scope.handler1Code= proposalDto.prpTmainDto.handler1Code;
                            //归属机构
                            //$scope.getComCodeList();
                            //归属业务员
                            //$scope.getHanCode({comName:proposalDto.prpPmainCopyDto.comName},proposalDto.prpPmainCopyDto.handler1Code);
                            //归属机构下拉初始化传参
                            //var handCodeData={
                            //    "userCode": $scope.user.userCode,
                            //    "userName": $scope.user.userName,
                            //    "loginComCode":  $scope.user.loginComCode,
                            //    "loginGradeCodes": "111",
                            //    "tableName": "prpduser",
                            //    "userCodeFields": "userCode",
                            //    "comCodeFields": proposalDto.prpTmainDto.comCode,
                            //    "riskCode": proposalDto.prpTmainDto.riskCode
                            //};
                            //// handCodeList归属业务员下拉列表
                            //$$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                            //    $scope.selectListData.handCodeList = data;
                            //    proposalDto.prpTmainDto.handler1Code = $scope.handler1Code;
                            //});

                            $scope.policy=true;
                            proposalDto.prpTmainDto.handler1Code1=proposalDto.prpTmainDto.tHandler1Name;
                            proposalDto.prpTmainDto.comCodename1= proposalDto.prpTmainDto.comName;
                            //投保方式
                            $scope.mulitSelectPolicyType(proposalDto.prpPmainCopyDto.riskCode,proposalDto.prpPmainCopyDto.policyType)//投保方式下拉初始化获取
                            $scope.totalAmount = round(endorseDto.prpPmainCopyDto.sumAmount,2);
                            $scope.totalPay = round(endorseDto.prpPmainCopyDto.sumPremium,2);
                        }
                        //合同信息
                        if(endorseDto.prpPmainAgriDto){
                            proposalDto.prpTmainAgriDto = endorseDto.prpPmainAgriDto;
                            proposalDto.prpTmainAgriDto.raiseDate = $filter("date")(endorseDto.prpPmainAgriDto.raiseDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainAgriDto.policyNo = endorseDto.prpPmainAgriDto.policyNo;
                        }else  if(endorseDto.prpPmainAgriCopyDto){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTmainAgriDto = endorseDto.prpPmainAgriCopyDto;
                            proposalDto.prpTmainAgriDto.raiseDate = $filter("date")(endorseDto.prpPmainAgriCopyDto.raiseDate, 'yyyy-MM-dd');
                            proposalDto.prpTmainAgriDto.policyNo = endorseDto.prpPmainAgriCopyDto.policyNo;
                        }

                        //种植地点
                        if(endorseDto.prpPaddressDtoList && endorseDto.prpPaddressDtoList.length>0){
                            proposalDto.prpTaddressDto = endorseDto.prpPaddressDtoList[0];
                        }else if(endorseDto.prpPaddressCopyDtoList && endorseDto.prpPaddressCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTaddressDto = endorseDto.prpPaddressCopyDtoList[0];
                        }
                        //清单信息
                        if(endorseDto.gisInsureListDto){
                            proposalDto.insureMainListDto=endorseDto.gisInsureListDto.gisInsureMainListDto;
                            proposalDto.insureMainListDto.insureListCode = endorseDto.gisInsureListDto.gisInsureMainListDto.insureListCode;
                            proposalDto.prpTmainDto.businessProvinceName=endorseDto.gisInsureListDto.gisInsureMainListDto.fProvinceName
                            proposalDto.prpTmainDto.businessCityName=endorseDto.gisInsureListDto.gisInsureMainListDto.fCityName
                            proposalDto.prpTmainDto.businessCountyName=endorseDto.gisInsureListDto.gisInsureMainListDto.fCountyName
                            proposalDto.prpTmainDto.businessTownName=endorseDto.gisInsureListDto.gisInsureMainListDto.fTownName
                            proposalDto.prpTmainDto.businessAreaName=endorseDto.gisInsureListDto.gisInsureMainListDto.fVillageName
                            if(endorseDto.gisInsureListDto.gisInsureMainListDto.listType=="D"){
                                proposalDto.insureMainListDto.listTypeFlag="大户"
                            }else if(endorseDto.gisInsureListDto.gisInsureMainListDto.listType=="D"){
                                proposalDto.insureMainListDto.listTypeFlag="散户"
                            }
                        }

                        //主险附加险
                        if(endorseDto.prpPitemKindDtoList&&endorseDto.prpPitemKindDtoList.length>0){
                            proposalDto.prpTitemKindDtoList = endorseDto.prpPitemKindDtoList;
                            angular.forEach(endorseDto.prpPitemKindDtoList,function(data){
                                data.shortRate=round(data.shortRate,2);
                                data.amount=round(data.amount,2);
                                data.premium=round(data.premium,2);
                                data.unitPremium=round(data.unitPremium,2)
                                if(data.flag) {
                                    data.radioType = data.flag.substr(1, 2) == 1 ? 'Y' : 'N';//给页面主险、附加险按钮赋值
                                }
                                if(proposalDto.prpTmainDto.riskCode=='3220'){
                                    data.agriUnitCostMaintitle = '何价投保';
                                    data.unitCostName = '元/头';
                                    data.proportionName = '%';
                                    data.untilName = "元";
                                    data.untilName1 = '头';
                                    data.untilKindName = "投保头数";
                                }else if (proposalDto.prpTmainDto.riskCode=='3107'|| proposalDto.prpTmainDto.riskCode=='3162'
                                    ||proposalDto.prpTmainDto.riskCode=='3155'|| proposalDto.prpTmainDto.riskCode=='3108'
                                    || proposalDto.prpTmainDto.riskCode=='3101'|| proposalDto.prpTmainDto.riskCode=='3114'
                                    || proposalDto.prpTmainDto.riskCode=='3122'|| proposalDto.prpTmainDto.riskCode=='3126'
                                    || proposalDto.prpTmainDto.riskCode=='3161' || proposalDto.prpTmainDto.riskCode=='3149'){
                                    data.agriUnitCostMaintitle = '单位生产成本';
                                    data.unitCostName = '元';
                                    data.untilKindName = "投保面积";
                                    data.agriUnitOutputMaintitle="单位保险产量";
                                    data.agriUnitOutputMainName="公斤";
                                }else if(proposalDto.prpTmainDto.riskCode=='3224'){
                                    data.untilKindName = "投保面积";
                                    data.agriUnitCostMaintitle = '单位保险产量';
                                    data.unitCostName = '公斤';
                                    data.agriUnitOutputMainName="公斤";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }else if(proposalDto.prpTmainDto.riskCode=='3134'||proposalDto.prpTmainDto.riskCode=='3147'
                                    || proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'){
                                    data.untilKindName = "投保面积";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }

                            })
                        }else if(endorseDto.prpPitemKindCopyDtoList && endorseDto.prpPitemKindCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTitemKindDtoList = endorseDto.prpPitemKindCopyDtoList;
                            angular.forEach(endorseDto.prpPitemKindCopyDtoList,function(data){
                                data.shortRate=round(data.shortRate,2);
                                data.amount=round(data.amount,2);
                                data.premium=round(data.premium,2);
                                data.unitPremium=round(data.unitPremium,2);
                                if(data.flag) {
                                    data.radioType = data.flag.substr(1, 2) == 1 ? 'Y' : 'N';
                                }
                                if(proposalDto.prpTmainDto.riskCode=='3220'){
                                    data.agriUnitCostMaintitle = '何价投保';
                                    data.unitCostName = '元/头';
                                    data.proportionName = '%';
                                    data.untilName = "元";
                                    data.untilName1 = '头';
                                    data.untilKindName = "投保头数";
                                }else if (proposalDto.prpTmainDto.riskCode=='3107'|| proposalDto.prpTmainDto.riskCode=='3162'
                                    ||proposalDto.prpTmainDto.riskCode=='3155'|| proposalDto.prpTmainDto.riskCode=='3108'
                                    || proposalDto.prpTmainDto.riskCode=='3101'|| proposalDto.prpTmainDto.riskCode=='3114'
                                    || proposalDto.prpTmainDto.riskCode=='3122'|| proposalDto.prpTmainDto.riskCode=='3126'
                                    || proposalDto.prpTmainDto.riskCode=='3161'|| proposalDto.prpTmainDto.riskCode=='3149'){
                                    data.agriUnitCostMaintitle = '单位生产成本';
                                    data.unitCostName = '元';
                                    data.untilKindName = "投保面积";
                                    data.agriUnitOutputMaintitle="单位保险产量";
                                    data.agriUnitOutputMainName="公斤";
                                }else if(proposalDto.prpTmainDto.riskCode=='3224'){
                                    data.untilKindName = "投保面积";
                                    data.agriUnitCostMaintitle = '单位保险产量';
                                    data.unitCostName = '公斤';
                                    data.agriUnitOutputMainName="公斤";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }else if(proposalDto.prpTmainDto.riskCode=='3134'||proposalDto.prpTmainDto.riskCode=='3147'
                                    || proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'){
                                    data.untilKindName = "投保面积";
                                    data.untilName = "元/亩";//单位名称
                                    data.untilName1 = '亩';
                                }

                            })
                        }

                        //茬次信息赋值
                        //if(endorseDto.prpPitemKindDtoList && endorseDto.prpPitemKindDtoList.length>0){
                        //    var prpTitemKindAgriDtoListCopy=[]
                        //    if(endorseDto.prpPmainDto.riskCode=='3134'|| endorseDto.prpPmainDto.riskCode=='3147'
                        //        || endorseDto.prpPmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102') {
                        //        angular.forEach(endorseDto.prpPitemKindDtoList, function (data_1, index) {
                        //            angular.forEach(endorseDto.prpPitemKindAgriDtoList, function (_data, index) {
                        //                if ((_data.distributingRate != null && _data.distributingRate != undefined)
                        //                    && (_data.timesAmount != null && _data.timesAmount != undefined)
                        //                    && (_data.stratDate != null && _data.stratDate != undefined)
                        //                    && (_data.endDate != null && _data.endDate != undefined)) {
                        //                    _data.timesAmount=round(_data.timesAmount,2);
                        //                    prpTitemKindAgriDtoListCopy.push(_data);
                        //                } else {
                        //                    if(data_1.itemKindNo==_data.itemKindNo){
                        //                        data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                        //                        data_1.unitAmount = _data.unitAmount;//单位保险金额
                        //                    }
                        //
                        //                }
                        //            });
                        //        });
                        //        proposalDto.prpTitemKindAgriDtoListCopy=prpTitemKindAgriDtoListCopy;
                        //    }else{
                        //            angular.forEach(endorseDto.prpPitemKindDtoList, function (data_1, index) {
                        //                angular.forEach(endorseDto.prpPitemKindAgriDtoList, function (_data, index) {
                        //                    if (data_1.itemKindNo == _data.itemKindNo) {
                        //                        data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                        //                        data_1.unitAmount = _data.unitAmount;//单位保险金额
                        //                        data_1.agriUnitCostMain = _data.unitCost;//单位生产成本
                        //                        data_1.agriTimesAmount = _data.timesAmount;//约定单价
                        //                        if(_data.unitOutput){
                        //                            data_1.agriUnitOutputMain=_data.unitOutput//单位保险产量
                        //                        }
                        //                        data_1.proportion = _data.proportion;//投保成数
                        //                    }
                        //                })
                        //            });
                        //    }
                        //}else
                        if(endorseDto.prpPitemKindCopyDtoList && endorseDto.prpPitemKindCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            var prpTitemKindAgriDtoListCopy=[]
                            if(endorseDto.prpPmainCopyDto.riskCode=='3134'|| endorseDto.prpPmainCopyDto.riskCode=='3147'
                                || endorseDto.prpPmainCopyDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102') {
                                angular.forEach(endorseDto.prpPitemKindCopyDtoList, function (data_1, index) {
                                    angular.forEach(endorseDto.prpPitemKindAgriCopyDtoList, function (_data, index) {
                                        if ((_data.distributingRate != null && _data.distributingRate != undefined)
                                            && (_data.timesAmount != null && _data.timesAmount != undefined)
                                            && (_data.stratDate != null && _data.stratDate != undefined)
                                            && (_data.endDate != null && _data.endDate != undefined)) {
                                            _data.timesAmount=round(_data.timesAmount,2);
                                            prpTitemKindAgriDtoListCopy.push(_data);
                                        } else {
                                            if (data_1.itemKindNo == _data.itemKindNo) {
                                                data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                                data_1.unitAmount = _data.unitAmount;//单位保险金额
                                            }
                                        }
                                    });
                                })
                                proposalDto.prpTitemKindAgriDtoListCopy=prpTitemKindAgriDtoListCopy;
                            }else{
                                angular.forEach(endorseDto.prpPitemKindCopyDtoList, function (data_1, index) {
                                    angular.forEach(endorseDto.prpPitemKindAgriDtoList, function (_data, index) {
                                        if (data_1.itemKindNo == _data.itemKindNo) {
                                            data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                            data_1.unitAmount = _data.unitAmount;//单位保险金额
                                            data_1.agriUnitCostMain = _data.unitCost;//单位生产成本
                                            data_1.agriTimesAmount = _data.timesAmount;//约定单价
                                            if(_data.unitOutput){
                                                data_1.agriUnitOutputMain=_data.unitOutput//单位保险产量
                                            }
                                            data_1.proportion = _data.proportion;//投保成数
                                        }
                                    })
                                })
                            }
                        }

                        //补贴信息
                        if(endorseDto.prpPsubsidyDtoList && endorseDto.prpPsubsidyDtoList.length>0){
                            angular.forEach(endorseDto.prpPsubsidyDtoList,function(_data){
                                _data.subsidyPremium=round( _data.subsidyPremium,2)
                            });
                            proposalDto.prpTsubsidyDtoList = endorseDto.prpPsubsidyDtoList;
                        }else  if(endorseDto.prpPsubsidyCopyDtoList && endorseDto.prpPsubsidyCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            angular.forEach(endorseDto.prpPsubsidyCopyDtoList,function(_data){
                                _data.subsidyPremium=round( _data.subsidyPremium,2)
                            });
                            proposalDto.prpTsubsidyDtoList = endorseDto.prpPsubsidyCopyDtoList;
                        }

                        //币别信息
                        if(endorseDto.prpPfeeDtoList && endorseDto.prpPfeeDtoList.length>0){
                            proposalDto.prpTfeeDtoList = endorseDto.prpPfeeDtoList;
                            if(endorseDto.prpPfeeDtoList && endorseDto.prpPfeeDtoList.length>0){
                                proposalDto.prpTfeeDto = endorseDto.prpPfeeDtoList[0];
                                $scope.currency2Name= proposalDto.prpTfeeDto.currency2Name+"";
                            }
                        }else if(endorseDto.prpPfeeCopyDtoList && endorseDto.prpPfeeCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTfeeDtoList = endorseDto.prpPfeeCopyDtoList;
                            if(endorseDto.prpPfeeDtoList && endorseDto.prpPfeeCopyDtoList.length>0){
                                proposalDto.prpTfeeDto = endorseDto.prpPfeeCopyDtoList[0];
                                $scope.currency2Name= proposalDto.prpTfeeDto.currency2Name+"";
                            }
                        }

                        //特约信息
                        if(endorseDto.queryProposalPrpTengageDtoList && endorseDto.queryProposalPrpTengageDtoList.length>0){
                            var prpTengageDtoList=[];
                            angular.forEach(endorseDto.queryProposalPrpTengageDtoList,function(_data){

                                if(_data.clauseCode!="TX001"&&_data.clauseCode!="TX004"){
                                    var obj={
                                        clauses:"",
                                        clauseCode:"",
                                        clausesContent:"",
                                        flag:""
                                    }
                                        obj.clauses=_data.clauseName,//特约名称
                                        obj.clauseCode=_data.clauseCode,//特约代码
                                        obj.clausesContent=_data.clausesContent,//特约内容
                                        obj.flag=_data.flag
                                    prpTengageDtoList.push(obj)
                                }
                            });
                            proposalDto.prpTengageDtoCopy = prpTengageDtoList;
                            proposalDto.prpTengageDtoCopy = prpTengageDtoList;
                            //绝对免赔率和免赔说明
                            proposalDto.engageQueryClause=proposalDto.engageQueryClause||{};
                            angular.forEach(endorseDto.queryProposalPrpTengageDtoList,function(data,index){
                                var clausesContent = data.clausesContent;
                                // 绝对免赔率
                                if(data.clauseCode==='TX001'){
                                    proposalDto.engageQueryClause.absuDedu = clausesContent;
                                }
                                // 免赔说明
                                if (data.clauseCode==='TX004'){
                                    proposalDto.engageQueryClause.deduText = clausesContent;
                                }
                            });
                        }else  if(endorseDto.queryProposalPrpTengageCopyDtoList && endorseDto.queryProposalPrpTengageCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            var prpTengageDtoList=[];
                            angular.forEach(endorseDto.queryProposalPrpTengageCopyDtoList,function(_data){
                                if(_data.clauseCode!="TX001"&&_data.clauseCode!="TX004"){
                                    var obj={
                                        clauses:"",
                                        clauseCode:"",
                                        clausesContent:"",
                                        flag:""
                                    }
                                        obj.clauses=_data.clauseName,//特约名称
                                        obj.clauseCode=_data.clauseCode,//特约代码
                                        obj.clausesContent=_data.clausesContent,//特约内容
                                        obj.flag=_data.flag
                                    prpTengageDtoList.push(obj)
                                }
                            });
                            proposalDto.prpTengageDtoCopy = prpTengageDtoList;
                            //绝对免赔率和免赔说明
                            proposalDto.engageQueryClause=proposalDto.engageQueryClause||{};
                            angular.forEach(endorseDto.queryProposalPrpTengageCopyDtoList,function(data,index){
                                var clausesContent = data.clausesContent;
                                // 绝对免赔率
                                if(data.clauseCode==='TX001'){
                                    proposalDto.engageQueryClause.absuDedu = clausesContent;
                                }
                                // 免赔说明
                                if (data.clauseCode==='TX004'){
                                    proposalDto.engageQueryClause.deduText = clausesContent;
                                }
                            });
                        }


                        //缴费计划信息
                        if(endorseDto.prpPplanDtoList&&endorseDto.prpPplanDtoList.length>0){
                            proposalDto.prpTplanDtoList = endorseDto.prpPplanDtoList;
                            angular.forEach(proposalDto.prpTplanDtoList, function (data, index) {
                                data.planFee=round(data.planFee,2);
                                data.planStartDate =
                                    $filter("date")(data.planStartDate, 'yyyy-MM-dd');
                                data.planDate =
                                    $filter("date")(data.planDate, 'yyyy-MM-dd');
                                //if(data.payReason==='R10'){
                                //    data.payReasonName='签单收保费';
                                //}else if(data.payReason==='R20'){
                                //    data.payReasonName='分期收保费'
                                //}else if(data.payReason==='RS3'){
                                //    data.payReasonName='中央财政'
                                //}else if(data.payReason==='RS4'){
                                //    data.payReasonName='省级财政'
                                //}else if(data.payReason==='RS5'){
                                //    data.payReasonName='地市财政'
                                //}else if(data.payReason==='RS6'){
                                //    data.payReasonName='其他来源'
                                //}else if(data.payReason==='RS7'){
                                //    data.payReasonName='县(区)财政'
                                //}else if(data.payReason==='PS3'){
                                //    data.payReasonName='中央财政补贴批改'
                                //}else if(data.payReason==='R30'){
                                //    data.payReasonName='加保/加费-保费'
                                //}
                                data.palnRealFee=round(parseFloat(data.planFee-data.delinquentFee),2);//实缴金额 = 应缴金额 - 拖欠金额
                                data.currency2Name=data.planCurrencyName+""
                            });
                        }else  if(endorseDto.prpPplanCopyDtoList && endorseDto.prpPplanCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTplanDtoList = endorseDto.prpPplanCopyDtoList;
                            angular.forEach(proposalDto.prpTplanDtoList, function (data, index) {
                                data.planFee=round(data.planFee,2);
                                data.planStartDate =
                                    $filter("date")(data.planStartDate, 'yyyy-MM-dd');
                                data.planDate =
                                    $filter("date")(data.planDate, 'yyyy-MM-dd');
                                if(data.payReason==='R10'){
                                    data.payReasonName='签单收保费';
                                }else if(data.payReason==='R20'){
                                    data.payReasonName='分期收保费'
                                }else if(data.payReason==='RS3'){
                                    data.payReasonName='中央财政'
                                }else if(data.payReason==='RS4'){
                                    data.payReasonName='省级财政'
                                }else if(data.payReason==='RS5'){
                                    data.payReasonName='地市财政'
                                }else if(data.payReason==='RS6'){
                                    data.payReasonName='其他来源'
                                }else if(data.payReason==='RS7'){
                                    data.payReasonName='县(区)财政'
                                }else if(data.payReason==='PS3'){
                                    data.payReasonName='中央财政补贴批改'
                                }else if(data.payReason==='R30'){
                                    data.payReasonName='加保/加费-保费'
                                }
                                data.palnRealFee=round(parseFloat(data.planFee-data.delinquentFee),2);//实缴金额 = 应缴金额 - 拖欠金额
                                data.currency2Name=data.planCurrencyName+""
                            });
                        }
                        //客户信息
                        if(endorseDto.prpPinsuredDtoList&&endorseDto.prpPinsuredDtoList.length>0){
                            angular.forEach(endorseDto.prpPinsuredDtoList, function (data) {
                                //data.businessName=data.businessSource;//行业名称
                                //data.BusinessSort=data.businessSort;//公司性质
                                data.certificateName=data.insuredCode;//客户代码
                                data.identifyType=data.identifyType
                                if (data.insuredFlag === "2") {
                                    proposalDto.appliInsuredDto = data;
                                } else if (data.insuredFlag === "1") {
                                    proposalDto.insuredDto = data;
                                }
                            });
                        }else  if(endorseDto.prpPinsuredCopyDtoList && endorseDto.prpPinsuredCopyDtoList.length>0){
                            //若p表没有值，则从copy表取数据
                            angular.forEach(endorseDto.prpPinsuredCopyDtoList, function (data) {
                                //data.businessName=data.businessSource;//行业名称
                                //data.BusinessSort=data.businessSort;//公司性质
                                data.certificateName=data.insuredCode;//客户代码
                                data.identifyType=data.identifyType
                                if (data.insuredFlag === "2") {
                                    proposalDto.appliInsuredDto = data;
                                } else if (data.insuredFlag === "1") {
                                    proposalDto.insuredDto = data;
                                }
                            });
                        }

                        //发票购货方信息
                        if(endorseDto.prpDcustomerTaxPayInfoDto.customerCode){
                            proposalDto.prpDcustomerTaxPayInfoDto = endorseDto.prpDcustomerTaxPayInfoDto;
                        }else if(endorseDto.prpDcustomerTaxPayInfoCopyDto){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpDcustomerTaxPayInfoDto = endorseDto.prpDcustomerTaxPayInfoCopyDto;
                        }
                        //发票购货方信息  选择同投保人、被投保人
                        if (proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject == "1" ){
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                        }else if(proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject == "2" ){
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
                        }else {
                            proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }
                        //客户信息中被保险人中的  同投保人选择按钮
                        //proposalDto.appliInsuredDto.insuredCode== proposalDto.insuredDto.insuredCode?$scope.checkedBox=["1"]:$scope.checkedBox=[];
                        //发票购货方信息  选择同投保人、被投保人
                        //proposalDto.prpDcustomerTaxPayInfoDto.payInfoObject=="1"?proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput="1":proposalDto.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput="";

                        //其他信息转换
                        if(endorseDto.prpPcoinsDtoList){
                            proposalDto.prpTcoinsDto = endorseDto.prpPcoinsDtoList;
                        }else if(endorseDto.prpPcoinsDtoList){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTcoinsDto = endorseDto.prpPcoinsCopyDtoList;
                        }
                        if(endorseDto.prpPcoinsDetailDtoList){
                            proposalDto.prpTcoinsDetailDto =endorseDto.prpPcoinsDetailDtoList
                        } else if(endorseDto.prpPcoinsDetailCopyDtoList){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTcoinsDetailDto =endorseDto.prpPcoinsDetailCopyDtoList
                        }
                        if(endorseDto.prpPplanCoinsDtoList){
                            proposalDto.prpTplanCoinsDtoList = endorseDto.prpPplanCoinsDtoList;
                        }else if(endorseDto.prpPplanCoinsCopyDtoList){
                            //若p表没有值，则从copy表取数据
                            proposalDto.prpTplanCoinsDtoList = endorseDto.prpPplanCoinsCopyDtoList;
                        }

                    }
                    return proposalDto
                };
                $scope.endorseScheme=false;
                $scope.showClaim=false;
                if($stateParams.systemFlag=="undwrt"){

                }
                var plantingPolicyListDtoList=[];
                var nyxPolicyListDtoList=[];
                var herdPolicyListDtoList=[];
                var planting31PolicyListDtoList=[];
                // 普通批改查看初始化
                if ($stateParams.editType === "show") {
                    $scope.hideLast = true;
                    $scope.proposalQueryHide = true;
                    var endorseShowInitDto = {
                        "bizNo": $stateParams.bizNo,
                        "bizType": "BIZTYPE_ENDORSE"
                    };
                    $$finder.find("queryEndorseInfo", endorseShowInitDto,
                        {
                            success: function (data) {
                                $scope.endorHide=true;
                                $scope.checkedBoxInsured=false;//详细信息隐藏被保险人同投保人按钮
                                var content = data.content;
                                var blPolicyInfoOriginDTO = content.blPolicyInfoDtoNew;  // 批改后的数据
                                //$scope.queryHide=false;
                                $scope.blPolicyInfoOriginConvertCopyDTO = {};          // 新数据（已转换为投保单对象；用于用户查看的数据）
                                var blPolicyInfoListingDTO = content.blEndorseDto; // 老数据（未转换为投保单对象）
                                $scope.blPolicyInfoListingConvertCopyDTO = {}; // 老数据
                                // 首先初始化P表数据
                                $scope.blPolicyInfoListingConvertCopyDTO = $scope.proposal = endorsePmainDtoConvertProposalDto(blPolicyInfoListingDTO);
                                $timeout(function () {
                                    // 然后通知指令进行记录
                                    $rootScope.$broadcast(constants.EVENTS.ENDORSE_READY);
                                    $timeout(function () {
                                        // 更新清单数据 指令进行对比
                                        $scope.blPolicyInfoOriginConvertCopyDTO = $scope.proposal = endorseDtoConvertProposalDto(blPolicyInfoOriginDTO,"show");
                                    })

                                    //业务大类
                                    $scope.parameterConvert.businessCategoryInit();

                                    console.log("老数据")
                                    console.log( blPolicyInfoListingDTO )
                                    console.log("新数据")
                                    console.log(blPolicyInfoOriginDTO)
                                })
                            }
                        });
                } else if ($stateParams.editType === "init") {
                    $scope.checkedBoxInsured=true;//普通批改初始化展示被保险人同投保人按钮
                    // 批改录入页面初始化
                    $scope.queryHide=false;
                    //$scope.endorseFlag = false;
                    $scope.DownloadHousehold1 = true;
                    $scope.DownloadHousehold2 = true;
                    $scope.DownloadHousehold3 = true;
                    $scope.planAmount=true;
                    var endorseInputInitDto = {
                        //"policyNo":"62801011800118000040",//$stateParams.policyNo,
                        //"validDate":"2011-05-1",//$stateParams.validDate
                        "policyNo": $stateParams.policyNo,
                        "validDate": $stateParams.validDate,
                        "bizType": $stateParams.bizType,
                        "editType": $stateParams.editType
                    };
                    $$finder.find("generalEndorseInit", endorseInputInitDto,
                        {
                            success: function (data) {
                                console.log($stateParams.endorseMessage)
                                console.log($scope.endorseMessage)
                                //
                                //var content = data.content;
                                if(data.code && data.code == '0000') {
                                    console.log("--初始化返回--");
                                    console.log(data);
                                    if(data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3134'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3147'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3224'
                                        ||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3141'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3129'){
                                        $scope.proposalShow=true;
                                        $scope.endorseShow='1';
                                        $scope.mainOrSubMain=false;
                                        $scope.amountShow='1';
                                        $scope.amountAmount=false;
                                        $scope.endorHide=false;
                                        $scope.mainSubFlag=false;
                                        //$scope.endorseFlag = false;
                                        //$scope.disabledFlag=false;
                                        $scope.proposalQueryHide=false;
                                    }else if(data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3107'|| data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3162'
                                        || data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3155'|| data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3108'
                                        || data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3220'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3233'
                                        ||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3237'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3101'
                                        ||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3114'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3122'
                                        ||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3126'||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3161'
                                        ||data.content.blPolicyInfoDtoNew.prpCmainDto.riskCode=='3149'){
                                        $scope.endorHide=false;
                                        $scope.deleteFlag=true
                                        $scope.mainOrSubMain=true;
                                        $scope.endorseFlag=true;
                                        //$scope.disabledFlag=true
                                        //$scope.proposalQueryHide=true
                                        //if(data.content.blPolicyInfoDtoNew.prpCmainAgriDto.remark=='1'){
                                        //    $scope.endorShow=false;
                                        //}else if(data.content.blPolicyInfoDtoNew.prpCmainAgriDto.remark=='2'){
                                        //    $scope.endorShow=true;
                                        //}
                                    }
                                    prpPheadDto.endorseMessage=$stateParams.endorseMessage;
                                    prpPheadDto.validDate=$stateParams.validDate
                                    prpPheadDto.endorseType=$stateParams.endorseType
                                    plantingPolicyListDtoList=data.content.blPolicyInfoDtoNew.plantingPolicyListDtoList;
                                    nyxPolicyListDtoList=data.content.blPolicyInfoDtoNew.nyxPolicyListDtoList;
                                    herdPolicyListDtoList=data.content.blPolicyInfoDtoNew.herdPolicyListDtoList;
                                    planting31PolicyListDtoList=data.content.blPolicyInfoDtoNew.planting31PolicyListDtoList;
                                    $scope.blEndorseDto = data.content.blEndorseDto;//批单数据
                                    var blPolicyInfoOriginDTO = data.content.blPolicyInfoDtoOld;  // 保单数据（未转换为投保单对象）
                                    $scope.blPolicyInfoOriginConvertCopyDTO = {};          // 保单数据转换后（已转换为投保单对象）

                                    var blPolicyInfoListingDTO = data.content.blPolicyInfoDtoNew; // 清单数据
                                    //判断清单是否保费改变
                                    if(blPolicyInfoListingDTO.plantingPolicyListDtoList){
                                        angular.forEach(blPolicyInfoListingDTO.plantingPolicyListDtoList,function(item1){
                                            $scope.plantingNewSum+=item1.sumPremium;
                                        });
                                        angular.forEach(blPolicyInfoOriginDTO.plantingPolicyListDtoList,function(item2){
                                            $scope.plantingOldSum+=item2.sumPremium;
                                        });
                                        $scope.plantingChgSum=$scope.plantingNewSum-$scope.plantingOldSum
                                    }
                                    $scope.blPolicyInfoListingConvertCopyDTO = {}; // 清单数据已转换（已转换为投保单对象；用于用户更改的数据）
                                    $scope.blPolicyInfoConvertCopy = $scope.blPolicyInfoOriginConvertCopyDTO = endorseDtoConvertProposalDto(blPolicyInfoOriginDTO,"init");//保单数据用做批改保费计算使用
                                    $scope.blPolicyInfoListingConvertCopyRestoreDTO = {}; // 清单数据已转换的缓存（用于用户删除数据后进行还原）

                                    if (!data.content.blEndorseDto.prpPheadDto.endorType) {
                                        blPolicyInfoListingDTO = angular.copy(blPolicyInfoOriginDTO);// 如果未返回清单数据 copy 一份数据作为清单数据

                                        // 初始化保单数据--清单数据(用户更改的数据)
                                        $scope.blPolicyInfoListingConvertCopyDTO = $scope.proposal = endorseDtoConvertProposalDto(blPolicyInfoListingDTO,"init");
                                        /***************下拉框初始化***************/
                                            //归属机构
                                        $scope.getComCodeList();
                                        //归属业务员
                                        $scope.getHanCode({comCName: $scope.proposal.prpTmainDto.comCName}, $scope.proposal.prpTmainDto.handler1Code);
                                        //投保方式
                                        $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, $scope.proposal.prpTmainDto.policyType);
                                        //业务大类
                                        $scope.parameterConvert.businessCategoryInit();

                                        /***************下拉框初始化结束***************/


                                            // 缓存一份数据 用作恢复使用
                                        $scope.blPolicyInfoListingConvertCopyRestoreDTO = angular.copy($scope.blPolicyInfoListingConvertCopyDTO)
                                        $timeout(function () {
                                            $rootScope.$broadcast(constants.EVENTS.ENDORSE_READY);
                                            $scope.initFlag = false
                                        })
                                    } else {
                                        // 首先初始化保单数据
                                        $scope.proposal = endorseDtoConvertProposalDto(blPolicyInfoOriginDTO,"init");
                                        //业务大类
                                        $scope.parameterConvert.businessCategoryInit();
                                        // 调用投保方式初始化列表
                                        $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, $scope.proposal.prpTmainDto.policyType);
                                        $timeout(function () {
                                            // 然后通知指令进行记录
                                            $rootScope.$broadcast(constants.EVENTS.ENDORSE_READY);
                                            $timeout(function () {
                                                // 更新清单数据 指令进行对比
                                                $scope.blPolicyInfoListingConvertCopyDTO = $scope.proposal = endorseDtoConvertProposalDto(blPolicyInfoListingDTO,"init");
                                                $scope.parameterConvert.businessCategoryInit();
                                                // 缓存一份数据 用作恢复使用
                                                $scope.blPolicyInfoListingConvertCopyRestoreDTO = angular.copy($scope.blPolicyInfoListingConvertCopyDTO)
                                                $scope.initFlag = false

                                            })

                                        })
                                    }

                                    //其他数据初始化
                                    $scope.baseDataInit();
                                    //gettotalAmount();
                                    //angular.forEach($scope.proposal.prpTitemKindDtoList,function(){
                                    //
                                    //});
                                }else{
                                    layer.open({
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '批单保存',
                                        content: '数据加载失败！',
                                        btn: ["关闭"],
                                        btn1: function (index, layero) {
                                            layer.close(index);
                                            //$state.go('UIPrPoEnOrderQuery');
                                        }
                                    });
                                }
                            }
                        });
                    //debugger
                    //$scope.proposal.doSaveFlag=true;
                }
                $scope.baseDataInit = function(){
                    //保费计算中的费率除数
                    $$finder.find('queryByRiskCode',{
                        riskCode:$scope.proposal.prpTmainDto.riskCode//险种
                    }, {
                        success: function (data) {
                            $scope.rateDivisor=data.content;
                            $scope.getrateDivisor( $scope.rateDivisor)
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
                $scope.nextStep=function(){
                    if (!$scope.proposal.doSaveFlag) {
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
                            title: '温馨提示',
                            content: '检测到影响保额保费数据有变化请重新计算',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        })
                        return;
                    }
                    if($scope.proposal.prpTmainDto.riskCode=='3134' || $scope.proposal.prpTmainDto.riskCode=='3147'
                        ||$scope.proposal.prpTmainDto.riskCode=='3141' || $scope.proposal.prpTmainDto.riskCode=='3102') {
                        var contentFlag = true;
                        if (!$scope.proposal.prpTitemKindAgriDtoListCopy || $scope.proposal.prpTitemKindAgriDtoListCopy.length <= 0) {
                            contentFlag = false;
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: "请录入茬次信息!",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return false;
                        }

                        //茬次起止日期在保险期间内
                        for (var i = 0; i < $scope.proposal.prpTitemKindAgriDtoListCopy.length; i++) {
                            var startDate = parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].stratDate.replace(/-/g, ""), 10);
                            var endDate = parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].endDate.replace(/-/g, ""), 10);
                            if ($scope.getDate(startDate, endDate) == -1) {
                                contentFlag = false;
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: "第[" + (i + 1) + "]条茬次起止日期必须在保险期间内!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                });
                                return;
                            }
                        }
                        var kindCodeList = [];//险别集合
                        var itemCodeList = [];//标的代码集合
                        angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                            kindCodeList.push(data.kindCode);//险别集合
                            itemCodeList.push(data.itemCode);//标的代码集合
                        })
                        //查询标的险别关系表
                        $$finder.find('queryFlag', {
                            "riskCode": $scope.proposal.prpTmainDto.riskCode,
                            "itemCodeList": itemCodeList,//标的代码集合itemListCodes
                            "kindCodeList": kindCodeList//险别
                        }, {
                            success: function (data) {
                                //获取主险信息
                                var sumAmount = 0;
                                var listMain = [];
                                angular.forEach($scope.proposal.prpTitemKindDtoList, function (dto) {
                                    angular.forEach(data.content, function (dto1) {
                                        if (dto.riskCode == dto1.riskCode && dto.kindCode == dto1.kindCode
                                            && dto.itemCode == dto1.itemCode && dto1.mainTimes == '1') {
                                            listMain.push(dto);
                                            sumAmount = sumAmount + dto.amount;
                                        }
                                    });
                                });
                                if (listMain.length <= 0) {
                                    contentFlag = false;
                                    layer.open({
                                        /* offset: ['35%', '40%'],*/
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        scrollbar: false,
                                        content: '主险中没有录入“蔬菜作物”标的信息时，不能录入茬次信息!',
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        },
                                    });
                                    return;
                                } else {
                                    if ($scope.sumDistributingRate() == false) {
                                        contentFlag = false;
                                        return;
                                    }
                                }
                                var sum = 0;
                                angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
                                    if (dto.flag && dto.flag == "D") {
                                    } else if (!dto.flag || dto.flag == "I") {
                                        sum += parseFloat(dto.timesAmount)
                                    }
                                });
                                if (sum != sumAmount) {
                                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto, index) {
                                        if (dto.flag && dto.flag == "D") {
                                        } else if (!dto.flag || dto.flag == "I") {
                                            $scope.proposal.prpTitemKindAgriDtoListCopy[index].timesAmount = round(((parseFloat($scope.proposal.prpTitemKindAgriDtoListCopy[index].distributingRate) / 100) * sumAmount), 2);
                                        }
                                    })
                                }
                                if(contentFlag==true){
                                    var endorseDto={};
                                    $scope.blEndorseInfoOriginConvertCopyDTO = {}; // 转回来的老数据
                                    $scope.blEndorseInfoListingConvertCopyDTO = {};// 转回来的新数据
                                    //$scope.parameterConvert.businessCategorySubmit();
                                    $scope.approvalPageFlag=true;

                                    endorseDto = $scope.blEndorseInfoListingConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoListingConvertCopyDTO);
                                    endorseDto.prpCmainDto.validTime=$stateParams.validDate;
                                    $scope.blEndorseInfoOriginConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoOriginConvertCopyDTO);

                                    //对比数据
                                    compareData();
                                    if(!$scope.blEndorseDto.prpPheadDto.endorType||$scope.blEndorseDto.prpPheadDto.endorType==""
                                        ||!$scope.blEndorseDto.prpPheadDto.endorType==null){
                                        layer.open({
                                            //area: ['26%', '200px'],
                                            //offset: ['30%', '33%'],
                                            skin: 'large-layer-content',
                                            scrollbar: false,
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: '没有进行批改，请重新批改！',
                                            btn: ["关闭"],
                                            btn1: function (index, layero) {
                                                layer.close(index);
                                            }
                                        });
                                        $scope.approvalPageFlag=false;
                                        return
                                    }


                                    //添加属性，后端用此做判断，前端无法获取的暂写死
                                    $scope.blEndorseDto.endorseConditionDto = {
                                        hpFlag: "",//扶贫险种专用flag
                                        loginComCode: $rootScope.user.loginComCode,
                                        businessFlag: "",//区分分入险种，分入不送收付
                                        ShareHolderName: "0",//股东业务标识下拉框，默认为0-否，1-是
                                        businessCategory$scope: $scope.proposal.prpTmainDto.businessCategory,//业务大类
                                        inusreListCode: $scope.proposal.insureMainListDto.insureListCode+"",//清单号
                                        benMarkPremiumMainEqualFlag : "",//批改是否保费变化标识,没有变化：Y ，有变化：N

                                    };
                                    var endorseNewDto = {
                                        blPolicyInfoDtoNew:endorseDto,
                                        blPolicyInfoDtoOld:$scope.blEndorseInfoOriginConvertCopyDTO,
                                        blEndorseDto: $scope.blEndorseDto
                                    }
                                    endorseNewDto.blEndorseDto.endorseConditionDto.remark=$scope.proposal.prpTmainDto.reMark;
                                    endorseNewDto.blEndorseDto.prpPheadDto.endorseType=$stateParams.endorseType;
                                    endorseNewDto.blEndorseDto.prpPheadDto.appliName=$stateParams.appliName;
                                    endorseNewDto.blEndorseDto.prpPheadDto.policyType = $scope.proposal.prpTmainDto.policyType;
                                    endorseNewDto.blEndorseDto.prpPheadDto.policyNo=$stateParams.policyNo;
                                    endorseNewDto.blEndorseDto.prpPheadDto.endorseMessage=$stateParams.endorseMessage;
                                    if($stateParams.applyDate){
                                        endorseNewDto.blEndorseDto.prpPheadDto.endorDate = $stateParams.applyDate;//批改日期
                                        endorseNewDto.blEndorseDto.prpPheadDto.updateDate = $stateParams.applyDate;//最后一次修改的日期
                                    }
                                    $scope.inputDate = $filter('date')(new Date(),'yyyy-MM-dd');
                                    endorseNewDto.blEndorseDto.prpPheadDto.inputDate= $scope.inputDate;
                                    endorseNewDto.blEndorseDto.prpPheadDto.validDate = $stateParams.validDate//批改生效日期
                                    endorseNewDto.blEndorseDto.prpPheadDto.validHour = '0';//生效小时
                                    endorseNewDto.blEndorseDto.prpPheadDto.operatorCode = $rootScope.user.userCode;//操作人员代码
                                    endorseNewDto.blEndorseDto.prpPheadDto.updateCode = $rootScope.user.userCode;//信息修改人代码
                                    endorseNewDto.blEndorseDto.prpPheadDto.riskCode=$stateParams.policyNo.substring(1,5);
                                    if($scope.proposal.prpTfeeDto.premium2 != $scope.blPolicyInfoConvertCopy.prpTfeeDto.premium2){
                                        endorseNewDto.blEndorseDto.endorseConditionDto.benMarkPremiumMainEqualFlag = 'Y';
                                    }else{
                                        endorseNewDto.blEndorseDto.endorseConditionDto.benMarkPremiumMainEqualFlag = 'N';
                                    }
                                    endorseNewDto.blEndorseDto.endorseConditionDto.validHour='0';
                                    endorseNewDto.blEndorseDto.nyxEndorHeadDto={};
                                    console.log("---点下一步--发送批改后的数据---");
                                    console.log(endorseNewDto);
                                    endorseNewDto.blEndorseDto.prpPtextDtoList=[];
                                    $scope.endorseText = "";
                                    angular.forEach(endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList,function(item){
                                        if(item.policyNo==null||item.policyNo==""||item.policyNo==undefined){
                                            endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList=[];
                                            endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDtoList=[];
                                        }
                                    });
                                    angular.forEach(endorseNewDto.blPolicyInfoDtoNew.prpCitemKindDtoList,function(item){
                                        if(item.policyNo==""||item.policyNo==undefined){
                                            item.policyNo=endorseNewDto.blPolicyInfoDtoNew.prpCitemKindDtoList[0].policyNo;
                                        }
                                    });
                                    endorseNewDto.blPolicyInfoDtoNew.plantingPolicyListDtoList=plantingPolicyListDtoList;
                                    endorseNewDto.blPolicyInfoDtoNew.nyxPolicyListDtoList=nyxPolicyListDtoList;
                                    endorseNewDto.blPolicyInfoDtoNew.herdPolicyListDtoList=herdPolicyListDtoList;
                                    endorseNewDto.blPolicyInfoDtoNew.planting31PolicyListDtoList=planting31PolicyListDtoList;
                                    endorseNewDto.blPolicyInfoDtoNew.prpCmainDto.argueSolution=endorseDto.prpCmainDto.contractType;
                                    $$finder.find("dealEndorseInfo",endorseNewDto,
                                        {
                                            success: function (data) {
                                                // var blEndorseDto =  data.blEndorseDto;
                                                if(data.code == "0000"){
                                                    $scope.PolicyEndorseDto = data.content;
                                                    console.log("--批文返回成功-数据处理完成--");
                                                    console.log($scope.PolicyEndorseDto);
                                                    $scope.blEndorseDto=$scope.PolicyEndorseDto.blEndorseDto;
                                                    console.log($scope.blEndorseDto);
                                                    $scope.strEndorseText="";
                                                    angular.forEach($scope.blEndorseDto.prpPtextDtoList,function(item){
                                                        $scope.strEndorseText+=(item.endorseText+"\r\n")
                                                    });
                                                }else{
                                                    layer.open({
                                                        skin: 'large-layer-content',
                                                        scrollbar: false,
                                                        closeBtn: 0,
                                                        title: '温馨提示',
                                                        content: '生成批文失败!',
                                                        btn: ["关闭"],
                                                        btn1: function (index, layero) {
                                                            layer.close(index);
                                                        }
                                                    });
                                                }

                                            }});
                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }else{
                        var endorseDto={};
                        $scope.blEndorseInfoOriginConvertCopyDTO = {}; // 转回来的老数据
                        $scope.blEndorseInfoListingConvertCopyDTO = {};// 转回来的新数据
                        //$scope.parameterConvert.businessCategorySubmit();
                        $scope.approvalPageFlag=true;

                        endorseDto = $scope.blEndorseInfoListingConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoListingConvertCopyDTO);
                        endorseDto.prpCmainDto.validTime=$stateParams.validDate;
                        $scope.blEndorseInfoOriginConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoOriginConvertCopyDTO);

                        //对比数据
                        compareData();
                        if(!$scope.blEndorseDto.prpPheadDto.endorType){
                            layer.open({
                                //area: ['26%', '200px'],
                                //offset: ['30%', '33%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '没有进行批改，请重新批改！',
                                btn: ["关闭"],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                            $scope.approvalPageFlag=false;
                            return
                        }


                        //添加属性，后端用此做判断，前端无法获取的暂写死
                        $scope.blEndorseDto.endorseConditionDto = {
                            hpFlag: "",//扶贫险种专用flag
                            loginComCode: $rootScope.user.loginComCode,
                            businessFlag: "",//区分分入险种，分入不送收付
                            ShareHolderName: "0",//股东业务标识下拉框，默认为0-否，1-是
                            businessCategory$scope: $scope.proposal.prpTmainDto.businessCategory,//业务大类
                            inusreListCode: $scope.proposal.insureMainListDto.insureListCode+"",//清单号
                            benMarkPremiumMainEqualFlag : "",//批改是否保费变化标识,没有变化：Y ，有变化：N

                        };
                        var endorseNewDto = {
                            blPolicyInfoDtoNew:endorseDto,
                            blPolicyInfoDtoOld:$scope.blEndorseInfoOriginConvertCopyDTO,
                            blEndorseDto: $scope.blEndorseDto
                        }
                        endorseNewDto.blEndorseDto.endorseConditionDto.remark=$scope.proposal.prpTmainDto.reMark;
                        endorseNewDto.blEndorseDto.prpPheadDto.endorseType=$stateParams.endorseType;
                        endorseNewDto.blEndorseDto.prpPheadDto.appliName=$stateParams.appliName;
                        endorseNewDto.blEndorseDto.prpPheadDto.policyType = $scope.proposal.prpTmainDto.policyType;
                        endorseNewDto.blEndorseDto.prpPheadDto.policyNo=$stateParams.policyNo;
                        endorseNewDto.blEndorseDto.prpPheadDto.endorseMessage=$stateParams.endorseMessage;
                        if($stateParams.applyDate){
                            endorseNewDto.blEndorseDto.prpPheadDto.endorDate = $stateParams.applyDate;//批改日期
                            endorseNewDto.blEndorseDto.prpPheadDto.updateDate = $stateParams.applyDate;//最后一次修改的日期
                        }
                        $scope.inputDate = $filter('date')(new Date(),'yyyy-MM-dd');
                        endorseNewDto.blEndorseDto.prpPheadDto.inputDate= $scope.inputDate;
                        endorseNewDto.blEndorseDto.prpPheadDto.validDate = $stateParams.validDate//批改生效日期
                        endorseNewDto.blEndorseDto.prpPheadDto.validHour = '0';//生效小时
                        endorseNewDto.blEndorseDto.prpPheadDto.operatorCode = $rootScope.user.userCode;//操作人员代码
                        endorseNewDto.blEndorseDto.prpPheadDto.updateCode = $rootScope.user.userCode;//信息修改人代码
                        endorseNewDto.blEndorseDto.prpPheadDto.riskCode=$stateParams.policyNo.substring(1,5);
                        if($scope.proposal.prpTfeeDto.premium2 != $scope.blPolicyInfoConvertCopy.prpTfeeDto.premium2){
                            endorseNewDto.blEndorseDto.endorseConditionDto.benMarkPremiumMainEqualFlag = 'Y';
                        }else{
                            endorseNewDto.blEndorseDto.endorseConditionDto.benMarkPremiumMainEqualFlag = 'N';
                        }
                        endorseNewDto.blEndorseDto.endorseConditionDto.validHour='0';
                        endorseNewDto.blEndorseDto.nyxEndorHeadDto={};
                        console.log("---点下一步--发送批改后的数据---");
                        console.log(endorseNewDto);
                        endorseNewDto.blEndorseDto.prpPtextDtoList=[];
                        $scope.endorseText = "";
                        angular.forEach(endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList,function(item){
                            if(item.policyNo==null||item.policyNo==""||item.policyNo==undefined){
                                endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList=[];
                                endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDtoList=[];
                            }
                        });
                        angular.forEach(endorseNewDto.blPolicyInfoDtoNew.prpCitemKindDtoList,function(item){
                            if(item.policyNo==""||item.policyNo==undefined){
                                item.policyNo=endorseNewDto.blPolicyInfoDtoNew.prpCitemKindDtoList[0].policyNo;
                            }
                        });
                        endorseNewDto.blPolicyInfoDtoNew.plantingPolicyListDtoList=plantingPolicyListDtoList;
                        endorseNewDto.blPolicyInfoDtoNew.nyxPolicyListDtoList=nyxPolicyListDtoList;
                        endorseNewDto.blPolicyInfoDtoNew.herdPolicyListDtoList=herdPolicyListDtoList;
                        endorseNewDto.blPolicyInfoDtoNew.planting31PolicyListDtoList=planting31PolicyListDtoList;
                        endorseNewDto.blPolicyInfoDtoNew.prpCmainDto.argueSolution=endorseDto.prpCmainDto.contractType;
                        $$finder.find("dealEndorseInfo",endorseNewDto,
                            {
                                success: function (data) {
                                    // var blEndorseDto =  data.blEndorseDto;
                                    if(data.code == "0000"){
                                        $scope.PolicyEndorseDto = data.content;
                                        console.log("--批文返回成功-数据处理完成--");
                                        console.log($scope.PolicyEndorseDto);
                                        $scope.blEndorseDto=$scope.PolicyEndorseDto.blEndorseDto;
                                        console.log($scope.blEndorseDto);
                                        $scope.strEndorseText="";
                                        angular.forEach($scope.blEndorseDto.prpPtextDtoList,function(item){
                                            $scope.strEndorseText+=(item.endorseText+"\r\n")
                                        });
                                    }else{
                                        layer.open({
                                            skin: 'large-layer-content',
                                            scrollbar: false,
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: '生成批文失败!',
                                            btn: ["关闭"],
                                            btn1: function (index, layero) {
                                                layer.close(index);
                                            }
                                        });
                                    }

                                }});
                    }
                }

                var compareData = function () {
                    // $scope.proposal.isSaveFlag = a;
                    // //主表
                    // $scope.proposal.prpTmainDto.appliCode=$scope.proposal.appliInsuredDto.insuredCode;//投保人代码
                    // $scope.proposal.prpTmainDto.appliName=$scope.proposal.appliInsuredDto.insuredName;//投保人名称
                    // $scope.proposal.prpTmainDto.appliAddress=$scope.proposal.appliInsuredDto.insuredAddress;//投保人地址
                    // $scope.proposal.prpTmainDto.insuredCode=$scope.proposal.insuredDto.insuredCode;//被保人代码
                    // $scope.proposal.prpTmainDto.insuredName=$scope.proposal.insuredDto.insuredName;//被保险人名称
                    // $scope.proposal.prpTmainDto.insuredAddress=$scope.proposal.insuredDto.insuredAddress;//被保险人地址
                    // $scope.proposal.prpTmainDto.sumAmount=$scope.proposal.prpTfeeDto.amount;//总保费
                    // $scope.proposal.prpTmainDto.sumPremium=$scope.proposal.prpTfeeDto.premium;//总保额
                    // //客户信息
                    // $scope.proposal.appliInsuredDto.proposalNo=$scope.proposal.prpTmainDto.proposalNo;//投保单号
                    // $scope.proposal.appliInsuredDto.riskCode=$scope.proposal.prpTmainDto.riskCode;//险种
                    // $scope.proposal.insuredDto.proposalNo=$scope.proposal.prpTmainDto.proposalNo;//投保单号
                    // $scope.proposal.insuredDto.riskCode=$scope.proposal.prpTmainDto.riskCode;//险种
                    // //种植地点
                    // $scope.proposal.prpTaddressDto.proposalNo=$scope.proposal.prpTmainDto.proposalNo;//投保单号
                    // $scope.proposal.prpTaddressDto.riskCode=$scope.proposal.prpTmainDto.riskCode;//险种
                    // //合同信息
                    // $scope.proposal.prpTmainAgriDto.proposalNo=$scope.proposal.prpTmainDto.proposalNo;//投保单号
                    // $scope.proposal.prpTmainAgriDto.riskCode=$scope.proposal.prpTmainDto.riskCode;//险种
                    // $scope.proposal.prpTmainAgriDto.raiseSite=$scope.proposal.prpTaddressDto.addressName;//养殖地点
                    // //币别信息
                    // $scope.proposal.prpTfeeDto.proposalNo=$scope.proposal.prpTmainDto.proposalNo;//投保单号
                    // $scope.proposal.prpTfeeDto.riskCode=$scope.proposal.prpTmainDto.riskCode;//险种
                    // //主险附加险
                    // $scope.proposal.prpTitemKindAgriDtoList=angular.copy($scope.proposal.prpTitemKindDtoList);
                    //     angular.forEach($scope.proposal.prpTitemKindAgriDtoList,function(data,index){
                    //         data.unitCost=data.unitCost;//对应页面生成成本
                    //         data.depreciationRate="";//折旧率/树龄(林木险)
                    //         data.grossQuantity="";//种养总量
                    //         data.discountType="2";
                    //
                    //     })
                    // //缴费期次
                    // angular.forEach($scope.proposal.prpTplanDtoList,function(data,index){
                    //         data.proposalNo= $scope.proposal.prpTfeeDto.proposalNo
                    //         data.riskCode= $scope.proposal.prpTfeeDto.riskCode
                    // })
                    //页面规则校验

                    //批单保存入参转换
                    var endorseDto = {};
                    endorseDto = $scope.blEndorseInfoListingConvertCopyDTO;
                    var strEndorseType = "";
                    //基本信息对比、缴费计划期次、其他信息
                    if (endorseDto.prpCmainDto.groupFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.groupFlag ||
                        endorseDto.prpCmainDto.notificationFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.notificationFlag ||
                        endorseDto.prpCmainDto.thirdKnow != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.thirdKnow ||
                        endorseDto.prpCmainDto.autoTransRenewFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.autoTransRenewFlag ||
                        endorseDto.prpCmainDto.operateDate != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.operateDate ||
                        endorseDto.prpCmainDto.inceptionFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.inceptionFlag ||
                        endorseDto.prpCmainDto.policyType != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.policyType ||
                        endorseDto.prpCmainDto.payTimes != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.payTimes ||
                        endorseDto.prpCmainDto.coinsFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.coinsFlag ||
                        endorseDto.prpCmainDto.coinsPremiumType != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.coinsPremiumType ||
                        endorseDto.prpCmainDto.businessNature != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.businessNature ||
                        endorseDto.prpCmainDto.startDate != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.startDate ||
                        endorseDto.prpCmainDto.endDate != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.endDate ||
                        endorseDto.prpCmainDto.eccFlag != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.eccFlag ||
                        endorseDto.prpCmainDto.contractType != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.contractType ||
                        endorseDto.prpCmainDto.judicalScope != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.judicalScope ||
                        endorseDto.prpCmainDto.reMark != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainDto.reMark
                    ) {
                        endorseDto.prpCmainDto.flag = "U";
                        strEndorseType += "15,";
                    }
                    if (endorseDto.prpCmainAgriDto.raiseDate != $scope.blEndorseInfoOriginConvertCopyDTO.prpCmainAgriDto.raiseDate) {
                        endorseDto.prpCmainAgriDto.flag = "U";
                        strEndorseType+="15,"
                    }
                    //主险、附加险信息对比
                    if (endorseDto.prpCitemKindDtoList && endorseDto.prpCitemKindDtoList.length > 0) {
                        if (endorseDto.prpCitemKindDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCitemKindDtoList.length) {
                            strEndorseType += "05,";
                        } else {
                            angular.forEach(endorseDto.prpCitemKindDtoList, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCitemKindDtoList, function (result) {
                                    if (item.itemKindNo == result.itemKindNo) {
                                        if (item.flag.substr(0,1) != "I" && item.flag.substr(0,1) != "D" && item.flag.substr(0,1) != "B") {
                                            if (item.itemKindNo === result.itemKindNo) {
                                                if (item.kindCode != result.kindCode || item.itemCode != result.itemCode ||
                                                    item.model != result.model || item.currency != result.currency ||
                                                    item.shortRateFlag != result.shortRateFlag || item.shortRateFlagName != result.shortRateFlagName ||
                                                    item.shortRate != result.shortRate || item.deductibleRate != result.deductibleRate ||
                                                    item.triggerPoint != result.triggerPoint || item.totalLossRatio != result.totalLossRatio ||
                                                    item.agriUnitCostMain != result.agriUnitCostMain ||
                                                    item.unitAmount != result.unitAmount || item.grossQuantity != result.grossQuantity ||
                                                    item.agriTimesAmount != result.agriTimesAmount ||
                                                    item.price != result.price || item.rate != result.rate) {
                                                    item.flag = "U" + result.flag.substr(1, 1);
                                                    strEndorseType += "05,";
                                                }
                                            }
                                        }else if(item.flag.substr(0,1) != "D"){
                                            strEndorseType += "05,";
                                        }
                                    }
                                })
                            });
                        }
                    }

                    //茬次信息
                    if (endorseDto.prpCitemKindAgriDtoList && endorseDto.prpCitemKindAgriDtoList.length > 0) {

                        //if (endorseDto.prpCmainDto.riskCode == '3134' || endorseDto.prpCmainDto.riskCode == '3147' || endorseDto.prpCmainDto.riskCode == '3141' || endorseDto.prpCmainDto.riskCode == '3102') {
                        angular.forEach(endorseDto.prpCitemKindAgriDtoList, function (item, index1) {
                            angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCitemKindAgriDtoList, function (result, index2) {
                                if (item.flag != "I" && item.flag != "D" && (item.newAddFlag == undefined)) {
                                    if (item.times === result.times) {
                                        if (item.times > 0 && result.times > 0) {
                                            if (item.stratDate != result.stratDate || item.endDate != result.endDate
                                                || item.distributingRate != result.distributingRate) {
                                                item.flag = "U";
                                                strEndorseType += "22,";
                                            }
                                        }else{
                                            if(item.timesAmount!=result.timesAmount){
                                                item.flag = "U";
                                                if(strEndorseType.indexOf('05')==-1){
                                                    strEndorseType += "05,";
                                                }
                                            }
                                        }
                                    }
                                } else if (item.flag != "D") {
                                    strEndorseType += "22,";
                                }
                            });
                            item.serialNo = index1 + 1;
                        })


                    }

                    //种植地点
                    if (endorseDto.prpCaddressDtoList && endorseDto.prpCaddressDtoList.length > 0) {
                        if (endorseDto.prpCaddressDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCaddressDtoList.length) {
                            strEndorseType += "07,";
                        } else {
                            angular.forEach(endorseDto.prpCaddressDtoList, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCaddressDtoList, function (result) {
                                    if (item.flag != "I" && item.flag != "D") {
                                        if (item.addressName != result.addressName) {
                                            item.flag = "U";
                                            strEndorseType += "07,";
                                        }
                                    } else if (item.flag != "D") {
                                        strEndorseType += "07,";
                                    }
                                })
                            });
                        }
                    }

                    //补贴信息对比
                    //    if(endorseDto.prpCsubsidyDtoList && endorseDto.prpCsubsidyDtoList.length>0){
                    //        if(endorseDto.prpCsubsidyDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCsubsidyDtoList.length) {
                    //            strEndorseType += "05,";
                    //        } else {
                    //            angular.forEach(endorseDto.prpCsubsidyDtoList, function (item) {
                    //                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCsubsidyDtoList, function (result) {
                    //                    if (item.operationFlag != "I" && item.operationFlag != "D") {
                    //                        if (item.subsidyType === result.subsidyType) {
                    //                            if (item.subsidyDepartment != result.subsidyDepartment || item.subsidyRate != result.subsidyRate
                    //                                || item.subsidyPremium != result.subsidyPremium) {
                    //                                item.operationFlag = "U";
                    //                                strEndorseType += "05,";
                    //                            }
                    //                        }
                    //                    }else if(item.flag != "D"){
                    //                        strEndorseType += "05,";
                    //                    }
                    //
                    //                })
                    //            });
                    //    }
                    //}
                    //币别信息
                    if(endorseDto.prpCfeeDtoList && endorseDto.prpCfeeDtoList.length>0){
                        if(endorseDto.prpCfeeDtoList.length!=$scope.blEndorseInfoOriginConvertCopyDTO.prpCfeeDtoList.length) {
                            strEndorseType += "05,";
                        } else {
                            angular.forEach(endorseDto.prpCfeeDtoList, function (item, index1) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCfeeDtoList, function (result, index2) {
                                    if (item.flag != "I" && item.flag != "D") {
                                        if (item.amount != result.amount || item.premium != result.premium || item.noTaxPremium != result.noTaxPremium
                                            || item.taxFee != result.taxFee || item.exchangeRate2 != result.exchangeRate2 || item.amount2 != result.amount2
                                            || item.premium2 != result.premium2 || item.noTaxPremium2 != result.noTaxPremium2 || item.taxFee2 != result.taxFee2
                                            || item.noTaxPremium1 != result.noTaxPremium1 || item.exchangeRate1 != result.exchangeRate1 || item.amount1 != result.amount1
                                            || item.premium1 != result.premium1 || item.taxFee1 != result.taxFee1) {
                                            item.flag = "U";
                                            if(strEndorseType.indexOf('05')==-1){
                                                strEndorseType += "05,";
                                            }

                                        }
                                    }else if(item.flag != "D"){
                                        if(strEndorseType.indexOf('05')==-1) {
                                            strEndorseType += "05,";
                                        }
                                    }
                                });
                            });
                        }
                    }
                    //缴费计划信息对比
                    if(endorseDto.prpCplanDtoList && endorseDto.prpCplanDtoList.length>0) {
                        if (endorseDto.prpCplanDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCplanDtoList.length) {
                            strEndorseType += "25,";
                        } else {
                            angular.forEach(endorseDto.prpCplanDtoList, function (item, index1) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCplanDtoList, function (result, index2) {
                                    if (item.flag != "I" && item.flag != "D" && (item.newAddFlag == undefined)) {
                                        if (item.subsidyType === result.subsidyType && item.payNo === result.payNo && item.payReason === result.payReason) {
                                            if (item.planStartDate != result.planStartDate || item.planDate != result.planDate
                                                || item.planFee != result.planFee || item.palnRealFee != result.palnRealFee) {
                                                item.flag = "U";
                                                if(strEndorseType.indexOf('05')==-1) {
                                                    strEndorseType += "25,";
                                                }
                                            }
                                        }
                                    }else if(item.flag != "D"){
                                        if(strEndorseType.indexOf('05')==-1) {
                                            strEndorseType += "25,";
                                        }
                                    }
                                });
                                item.serialNo = index1 + 1;
                            })
                        }
                    }



                    //茬次信息
                    //    if(endorseDto.prpCitemKindAgriDtoList && endorseDto.prpCitemKindAgriDtoList.length>0) {
                    //        if (endorseDto.prpCitemKindAgriDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCitemKindAgriDtoList.length) {
                    //            strEndorseType += "22,";
                    //        } else {
                    //            if (endorseDto.prpCmainDto.riskCode == '3134' || endorseDto.prpCmainDto.riskCode == '3147' || endorseDto.prpCmainDto.riskCode == '3141') {
                    //                angular.forEach(endorseDto.prpCitemKindAgriDtoList, function (item, index1) {
                    //                    angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCitemKindAgriDtoList, function (result, index2) {
                    //                        if (item.flag != "I" && item.flag != "D" && (item.newAddFlag == undefined)) {
                    //                            if (item.times === result.times) {
                    //                                if (item.stratDate != result.stratDate || item.endDate != result.endDate
                    //                                    || item.distributingRate != result.distributingRate) {
                    //                                    item.flag = "U";
                    //                                    strEndorseType += "22,";
                    //                                }
                    //                            }
                    //                        }
                    //                    });
                    //                    item.serialNo = index1 + 1;
                    //                })
                    //            }
                    //    }
                    //}



                    //strEndorseType+=str1;

                    var prpCengageDtoList = [];
                    var engageQueryClause=$scope.proposal.engageQueryClause||{};
                    //特约及附加信息
                    if(endorseDto.prpCengageDtoList && endorseDto.prpCengageDtoList.length>0) {
                        if ((endorseDto.prpCengageDtoList!=undefined&& $scope.blEndorseInfoOriginConvertCopyDTO.prpCengageDtoList==undefined)
                            ||(endorseDto.prpCengageDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCengageDtoList.length)) {
                            strEndorseType += "17,";
                        } else {
                            angular.forEach(endorseDto.prpCengageDtoList, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCengageDtoList, function (result) {
                                    if (item.flag != "I" && item.flag != "D" && (item.absuDedu != "TX001" || item.absuDedu != "TX004")) {
                                        if (item.lineNo === result.lineNo && item.serialNo === result.serialNo && item.titleFlag === result.titleFlag) {
                                            if (item.clauseCode != result.clauseCode || item.clauses != result.clauses || item.clausesContent != result.clausesContent) {
                                                item.flag = "U";
                                                strEndorseType += "17,";
                                            }
                                        }
                                    }else if(item.flag != "D"){
                                        strEndorseType += "17,";
                                    }
                                })
                            })
                        }
                    }
                    // endorseDto.prpCengageDtoList=prpCengageDtoList;
                    //客户信息--投保人、被保人
                    if(endorseDto.prpCinsuredDtoList && endorseDto.prpCinsuredDtoList.length>0) {
                        if (endorseDto.prpCinsuredDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCinsuredDtoList.length) {
                            strEndorseType += "04,";
                        } else {
                            angular.forEach(endorseDto.prpCinsuredDtoList, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCinsuredDtoList, function (result) {
                                    if (item.insuredFlag === result.insuredFlag && item.insuredCode === result.insuredCode) {
                                        if (item.identifyNumber != result.identifyNumber || item.mobile != result.mobile ||
                                            item.validityCertificate != result.validityCertificate || item.validPeriod3 != result.validPeriod3 ||
                                            item.insuredAddress != result.insuredAddress || item.phoneNumber != result.phoneNumber ||
                                            item.InsuredLinkerName != result.InsuredLinkerName || item.account != result.account ||
                                            item.bank != result.bank || item.email != result.email || item.postCode != result.postCode ||
                                            item.isCareclaim != result.isCareclaim || item.cashFocus != result.cashFocus ||
                                            item.riskLevel != result.riskLevel || item.insuredName != result.insuredName
                                            || item.businessSort != result.businessSort
                                            ||item.businessSource!=result.businessSource) {
                                            item.flag = "U";
                                            if(strEndorseType.indexOf('04')==-1){
                                                strEndorseType += "04,";
                                            }


                                        }
                                    }
                                })

                            });
                        }
                    }
                    //发票购货方信息
                    if(endorseDto.prpDcustomerTaxPayInfoDto){
                        if($scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto==undefined){
                            $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto={};
                        }
                        if (endorseDto.prpDcustomerTaxPayInfoDto.payInfoObject != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.payInfoObject ||
                            endorseDto.prpDcustomerTaxPayInfoDto.customerName != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.customerName ||
                            endorseDto.prpDcustomerTaxPayInfoDto.invoiceType != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.invoiceType ||
                            endorseDto.prpDcustomerTaxPayInfoDto.taxpayerNo != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.taxpayerNo ||
                            endorseDto.prpDcustomerTaxPayInfoDto.taxpayerType != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.taxpayerType ||
                            endorseDto.prpDcustomerTaxPayInfoDto.address != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.address ||
                            endorseDto.prpDcustomerTaxPayInfoDto.phone != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.phone ||
                            endorseDto.prpDcustomerTaxPayInfoDto.accountBank != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.accountBank ||
                            endorseDto.prpDcustomerTaxPayInfoDto.accountNo != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.accountNo ||
                            endorseDto.prpDcustomerTaxPayInfoDto.postName != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.postName ||
                            endorseDto.prpDcustomerTaxPayInfoDto.postPhone != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.postPhone ||
                            endorseDto.prpDcustomerTaxPayInfoDto.postAddress != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.postAddress ||
                            endorseDto.prpDcustomerTaxPayInfoDto.postCode != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.postCode ||
                            endorseDto.prpDcustomerTaxPayInfoDto.remark != $scope.blEndorseInfoOriginConvertCopyDTO.prpDcustomerTaxPayInfoDto.remark) {
                            endorseDto.prpDcustomerTaxPayInfoDto.flag = "U";
                            if(strEndorseType.indexOf('05')==-1) {
                                strEndorseType += "05,";
                            }
                        }

                    }

                    //其他信息
                    if(endorseDto.prpCcoinsDto && endorseDto.prpCcoinsDto.length>0) {
                        if (endorseDto.prpCcoinsDto.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCcoinsDto.length) {
                            strEndorseType += "78,";
                        } else {
                            angular.forEach(endorseDto.prpCcoinsDto, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCcoinsDto, function (result) {
                                    if (item.flag != "I" && item.flag != "D") {
                                        if (item.serialNo === result.serialNo) {
                                            if (item.policyNo != result.policyNo || item.coinsType != result.coinsType || item.chiefFlag != result.chiefFlag ||
                                                item.coinsCode != result.coinsCode || item.coinsName != result.coinsName || item.coinsRate != result.coinsRate ||
                                                item.coinsSumAmount != result.coinsSumAmount || item.coinsSumPremium != result.coinsSumPremium ||
                                                item.agentFee != result.agentFee || item.middleCostFee != result.middleCostFee ||
                                                item.operateFee != result.operateFee) {
                                                item.flag = "U";
                                                strEndorseType += "78,";
                                            }
                                        }
                                    }else if(item.flag != "D"){
                                        strEndorseType += "78,";
                                    }
                                })
                            });
                        }
                    }
                    if(endorseDto.prpCplanCoinsDtoList && endorseDto.prpCplanCoinsDtoList.length>0) {
                        if (endorseDto.prpCplanCoinsDtoList.length != $scope.blEndorseInfoOriginConvertCopyDTO.prpCplanCoinsDtoList.length) {
                            strEndorseType += "78,";
                        } else {
                            angular.forEach(endorseDto.prpCplanCoinsDtoList, function (item) {
                                angular.forEach($scope.blEndorseInfoOriginConvertCopyDTO.prpCplanCoinsDtoList, function (result) {
                                    if (item.flag != "I" && item.flag != "D") {
                                        if (item.serialNo === result.serialNo) {
                                            if (item.pay != result.pay || item.realPay != result.realPay) {
                                                item.flag = "U";
                                                strEndorseType += "78,";
                                            }
                                        }
                                    }else if(item.flag != "D"){
                                        strEndorseType += "78,";
                                    }
                                })
                            });
                        }
                    }
                    $scope.blEndorseDto.prpPheadDto.endorType=strEndorseType;

                }
                $scope.saveEndorse = function () {
                    console.log("-批改保存-");
                    console.log($scope.PolicyEndorseDto)
                    $scope.PolicyEndorseDto.blEndorseDto.endorseConditionDto.strText=$scope.strEndorseText;

                    $$finder.find("saveEndorseInfo",$scope.PolicyEndorseDto,
                        {
                            success: function (data) {
                                console.log(data);
                                if (data.code == '0000') {
                                    var contentList = {
                                        endorseList: [
                                            data.content.endorseNo
                                        ]
                                    }

                                    $modal.open({
                                        templateUrl: 'common/business/common/endorse/model/UIEdorse.saveApproval.model.tpl.html',
                                        resolve: {
                                            batch: function () {
                                                return contentList
                                            }
                                        },
                                        backdrop: 'static',
                                        controller: function ($scope, $modalInstance, batch) {
                                            $scope.batch = batch;
                                            console.log("生成批单信息：" + batch);
                                            $("html,body").css({overflow: "hidden"});//隐藏滚动条
                                            $scope.canSubmitEndorse = true;//提交核批按钮
                                            $scope.lookEndorseBtn = true;
                                            /**
                                             * 提交核批
                                             */
                                            $scope.submitEndorse = function () {
                                                var keywords = {
                                                    "dLComCode": $rootScope.user.loginComCode,
                                                    "endorseNos": [$scope.batch.endorseList[0]],
                                                    "userCode": $rootScope.user.userCode
                                                };
                                                $$finder.find('saveUndwrtByEndorseNo', keywords, {
                                                    success: function (data) {
                                                        if (data && data.content) {
                                                            console.log(data);
                                                            layer.open({
                                                                //area: ['37%', '318px'],
                                                                //offset: ['28%', '30%'],
                                                                skin: 'large-layer-content',
                                                                scrollbar: false,
                                                                closeBtn: 0,
                                                                title: '提交核批成功',
                                                                content: data.content[0],
                                                                btn: ["关闭"],
                                                                btn1: function (index, layero) {
                                                                    layer.close(index);
                                                                    $scope.quit();
                                                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                                                    $state.go('UIPrPoEnOrderQuery');
                                                                }
                                                            });
                                                            $scope.canSubmitEndorse = false;//提交核批按钮
                                                        }
                                                    },
                                                    error: function (e) {
                                                        console.log(e);
                                                    }
                                                });
                                            };
                                            /**
                                             * 查看批单
                                             */
                                            $scope.lookEndorse = function () {
                                                $modalInstance.dismiss();
                                                $("html,body").css({overflow: "auto"});//出现滚动条
                                                $state.go('UIPrPoEnOrderQuery');
                                            };
                                            /**
                                             * 关闭弹框
                                             */
                                            $scope.quit = function () {
                                                $modalInstance.dismiss();
                                                $("html,body").css({overflow: "auto"});//出现滚动条
                                                $state.go('UIPrPoEnOrderQuery');
                                            };
                                        }
                                    });
                                } else {
                                    layer.open({
                                        area: ['26%', '200px'],
                                        //offset: ['30%', '33%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '批单保存',
                                        content: '批单保存失败，请重新批改',
                                        btn: ["关闭"],
                                        btn1: function (index, layero) {
                                            layer.close(index);
                                            //$state.go('UIPrPoEnOrderQuery');
                                        }
                                    });
                                }
                            }
                        });
                };
                //提交核保
                $scope.commitUnderwrite = function () {
                    $scope.showSave = !$scope.showSave;
                    layer.open({
                        area: ['37%', '318px'],
                        //offset: ['28%', '30%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '提交核保成功',
                        content: '提交核保成功',
                        btn: ['再录一单', '返回主页']
                        , btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go("UIproposal3107edit", {}, {reload: true});
                            //$state.reload('UIproposal3107edit');
                            layer.close(index);
                        }
                        , btn2: function (index, layero) {
                            //按钮【按钮二】的回调
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go('dashboard');
                            //return false 开启该代码可禁止点击该按钮关闭
                        }
                    });
                };
                //显示编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
                $scope.queryHide = true;
                $scope.showRiskScheme=false;
                $scope.getreserve1 = function (index, data) {
                    $scope.clauseCode = data.clauseCode
                };
                $scope.goBack = function () { // 上一步
                    $scope.approvalPageFlag = false;
                }
                //返回按钮
                $scope.returnButton=function(){
                    $window.history.back();
                }
                $scope.last=function(){
                    $scope.queryHide=true;
                    //$location.path('/UIproposal3107edit');
                    $rootScope.temporaryDtoFlag=true;
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $state.go('UIEndorseGeneralMarking.main')
                }
                $scope.return=function(){
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $location.path('/UIPrPoEnOrderQuery');
                }

                //茬次信息控制茬次信息中的“保险金额分布比例”之和必须等于100
                $scope.sumDistributingRate=function(){
                    var sum=0;
                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto) {
                        if(isNaN(dto.distributingRate)){
                            dto.distributingRate=0;
                        }
                        //sum+=parseFloat(dto.distributingRate)
                        if(dto.flag && dto.flag=="D"){
                            //sum+=parseFloat(dto.distributingRate)
                        }else if(!dto.flag || dto.flag=="I"){
                            sum+=parseFloat(dto.distributingRate)
                        }
                    });
                    if(sum!=100){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '茬次信息中的“保险金额分布比例”之和必须等于100！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        });
                        return false
                    }
                    return true
                }

                //校验茬次信息
                $scope.checkItemKindAgri=function(){
                    if(!$scope.proposal.prpTitemKindAgriDtoListCopy || $scope.proposal.prpTitemKindAgriDtoListCopy.length<=0){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "请录入茬次信息!",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        });
                        return false;
                    }

                    //茬次起止日期在保险期间内
                    for(var i = 1;i < $scope.proposal.prpTitemKindAgriDtoListCopy.length;i++){
                        var startDate=parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].stratDate.replace(/-/g,""),10);
                        var endDate=parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].endDate.replace(/-/g,""),10);
                        if($scope.getDate(startDate,endDate)==-1){
                            layer.open({
                                //offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: "第[" + (i+1) + "]条茬次起止日期必须在保险期间内!",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return false;
                        }
                    }

                    //获取主险信息
                    var list=[];
                    angular.forEach($scope.proposal.prpTitemKindDtoList,function(dto) {
                        if(dto.radioType=='Y'){
                            list.push(dto);
                        }
                    });
                    if(list.length<=0){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '主险中没有录入“蔬菜作物”标的信息时，不能录入茬次信息!',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        });
                        return false
                    }else{
                        if($scope.sumDistributingRate()==false){
                            return false
                        };
                    }

                    var sum=0;
                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto) {
                        if(dto.flag && dto.flag=="D"){
                        }else if(!dto.flag || dto.flag=="I"){
                            sum+=parseFloat(dto.timesAmount)
                        }

                    });

                    if(sum!=$scope.totalAmount){
                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto,index) {
                            if(dto.flag && dto.flag=="D"){
                            }else if(!dto.flag || dto.flag=="I") {
                                dto.timesAmount = round(((parseFloat(dto.distributingRate) / 100) * $scope.totalAmount), 2);
                            }
                        })
                    }

                    //验证茬次保险金额不能为空或0
                    var AgriTimesAmount=0;
                    for(var i=0;i<$scope.proposal.prpTitemKindAgriDtoListCopy.length;i++) {
                        if($scope.proposal.prpTitemKindAgriDtoListCopy[i].flag && $scope.proposal.prpTitemKindAgriDtoListCopy[i].flag=="D"){
                        }else if(!$scope.proposal.prpTitemKindAgriDtoListCopy[i].flag || $scope.proposal.prpTitemKindAgriDtoListCopy[i].flag=="I") {
                            AgriTimesAmount = parseFloat($scope.proposal.prpTitemKindAgriDtoListCopy[i].timesAmount);
                            if (AgriTimesAmount == 0 || isNaN(AgriTimesAmount)) {
                                layer.open({
                                    //offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "第[" + (i + 1) + "]条茬次保险金额不能为空或0!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                });
                                return false;
                            }
                        }
                    }

                    return true
                }
                //茬次信息需获得的保险期间方法
                $scope.getDate=function(startDate,endDate){
                    if(($scope.proposal.prpTmainDto.startDate==undefined||$scope.proposal.prpTmainDto.startDate==null||$scope.proposal.prpTmainDto.startDate=='')
                        ||($scope.proposal.prpTmainDto.endDate==undefined||$scope.proposal.prpTmainDto.endDate==null||$scope.proposal.prpTmainDto.endDate=='')){
                        return 1
                    }
                    var startDate1=parseInt($scope.proposal.prpTmainDto.startDate.replace(/-/g,""),10);
                    var endDate1=parseInt($scope.proposal.prpTmainDto.endDate.replace(/-/g,""),10);
                    if(startDate<startDate1||endDate>endDate1){
                        return -1
                    }
                    return 0
                }
                //计算总保额总保费
                var gettotalAmount = function () {
                    $scope.totalAmount = 0;
                    $scope.totalPay = 0;
                    for (var i = 0; i < $scope.proposal.prpTitemKindDtoList.length; i++) {
                        if ($scope.proposal.prpTitemKindDtoList[i].calculateFlag == "Y") {
                            $scope.totalAmount += parseFloat($scope.proposal.prpTitemKindDtoList[i].amount * 1);
                        }
                        $scope.totalPay += parseFloat($scope.proposal.prpTitemKindDtoList[i].premium * 1);

                    }
                    $scope.totalPay=round($scope.totalPay ,2);
                    $scope.totalAmount=round($scope.totalAmount,2);
                    //$scope.totalAmount = $rootScope.amount($scope.totalAmount);
                    //$scope.totalPay = $rootScope.amount($scope.totalPay);
                    if ($scope.proposal.prpModelMainSubDto) {
                        $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                        $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                    }
                    if ($scope.proposal.prpTmainDto) {
                        $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay;
                        $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                    }
                }

                //上传影像
                $scope.upLoading = function () {
                    console.log("影像上传");
                    $$finder.find("transportXML", {
                        "businessNo": $stateParams.bizNo,
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
                $scope.checkVideo = function () {
                    console.log("影像查看");
                    $$finder.find("transportXML", {
                        "businessNo": $stateParams.bizNo, //业务单号
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

                //对数字四舍五入
                //数值,精度

                function round(number, precision) {
                    if (isNaN(number))
                        number = 0;
                    var prec = Math.pow(10, precision);
                    var result = Math.round(number * prec);
                    /* modify by xiaojian 20051219 reason：恢复20050711此函数的文件，如下处理有问题 */
                    //if(Math.round((result-number*prec)*10)==-5)
                    //  result = result+1;
                    result = result / prec;

                    //小数点后只有一位数时，自动补零
                    var xsd=result.toString().split(".");
                    if(xsd.length>1){
                        if(xsd[1].length<2){
                            result=result.toString()+"0";
                        }
                    }
                    if(xsd.length==1){
                        result=result+".00";
                    }
                    return result;
                }
                //茬次信息需获得的保险期间方法
                $scope.getDate=function(startDate,endDate){
                    if(($scope.proposal.prpTmainDto.startDate==undefined||$scope.proposal.prpTmainDto.startDate==null||$scope.proposal.prpTmainDto.startDate=='')
                        ||($scope.proposal.prpTmainDto.endDate==undefined||$scope.proposal.prpTmainDto.endDate==null||$scope.proposal.prpTmainDto.endDate=='')){
                        return 1
                    }
                    var startDate1=parseInt($scope.proposal.prpTmainDto.startDate.replace(/-/g,""),10);
                    var endDate1=parseInt($scope.proposal.prpTmainDto.endDate.replace(/-/g,""),10);
                    if(startDate<startDate1||endDate>endDate1){
                        return -1
                    }
                    return 0
                }
            }]);
})