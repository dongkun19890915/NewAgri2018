/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'encodeUrl'
], function (app) {
    'use strict';
    app.registerController('UIProposal3107editCtrl',
        ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$$cherry', '$$finder', '$stateParams', '$state', '$$code', 'commonApiServ', '$$proposalAPI', '$filter', '$window',
            function ($rootScope, $scope, $http, $anchorScroll, $location, $$cherry, $$finder, $stateParams, $state, $$code, commonApiServ, $$proposalAPI, $filter, $window) {
                $scope.endorHide=true;//批改时删除和修改按钮隐藏
                $scope.checkedBoxInsured=true;//普通批改初始化展示被保险人同投保人按钮
                //投保方式初始化
                //$scope.policyType={};
                //归属机构禁止输入
                //投保单修改和详细信息查询的返回按钮
                $scope.hideReturn = false;
                //投保单录入的时候把返回隐藏
                if (!$stateParams.addEditExamine) {
                    $scope.hideReturn = true;
                }

                $scope.continue = true;
                if ($stateParams.addEditExamine === 'Examine') {//投保单查看
                    $scope.languagePolicySort = true;
                    if($rootScope.systemFlag=="undwrt"){
                     }
                }
                //级联获取下拉列表***************************************start
                $scope.initFlag = false;// 初始化标志  初始化完成后置为 false  默认true初始化状态
                //投保单录入页面设置提交核保等按钮禁用
                $scope.underSubmitHide = true;
                $scope.UploadImage = true;
                $scope.ImageView = true;
                $scope.DownloadHouseholdList = true;
                $scope.PremiumFlag = false;
                $scope.coinsPremiumFlag = false;
                $scope.ViewUnderWriteInfo = true;
                $scope.isAgriUnitCostMain = false;
                $scope.queryHide0 = true;
                $$proposalAPI.initAPI($scope);
                $scope.return = function () {
                    window.history.back();
                }
                $scope.DownloadHouseholdListFn = function () {//点击币别确定之后放开分户清单下载按钮
                    $scope.DownloadHouseholdList = false;
                }
                $scope.SetTimes = function(){//点击计算成功后设置times保存次数+1
                    var times = parseInt($scope.proposal.times) +1;
                    $scope.proposal.times = times;
                }
                //点击计算时将flag置为true,保存时方便校验共保信息
                $scope.setPremiumFlag = function () {
                    $scope.PremiumFlag = true;
                    $scope.coinsPremiumFlag = false;
                }
                //共保计算时调取置标识
                $scope.setCoinsPremiumFlag = function () {
                    $scope.coinsPremiumFlag = true;
                }
                //级联获取下拉列表***************************************end
                //关闭出单向导
                $scope.$on('closeRiskScheme', function (event, data) {
                    $scope.showRiskScheme = data;
                });
                $scope.getAmount = function (obj) {
                    $scope.totalAmount = obj.totalAmount;//总保额
                    $scope.totalPay = obj.totalPay;
                };
                $$cherry.$proposal.Proposal({}, {
                    success: function (_proposal) {
                        if (_proposal) {
                            $scope.proposal = _proposal;
                        }
                    }
                });
                $scope.showRiskScheme = true;  //出单向导弹窗
                $scope.queryHide = true;  //显示编辑类型字段
                //获取费率除数
                $scope.getrateDivisor = function (data) {
                    $scope.rateDivisor = data;
                };
                //延迟初始化接口
                $scope.init = false;
                $scope.changeinit = function () {
                    $scope.init = true;
                };
                if ($stateParams.type === 'type') {
                    $scope.showRiskScheme = false;
                } else {
                    $scope.showRiskScheme = true;
                }
                $scope.queryHide = true;  //显示编辑类型字段
                //日期格式化
                var msTodata = function (ms) {
                    return $filter('date')(ms, 'yyyy-MM-dd');
                };
                //投保单查询结果  投保单详细信息以及投保单详细修改***************************************start
                $scope.proposalQueryMessage = function (data, flag) {
                    $scope.disabledContent = true;//特约查看详情不可编辑
                    var _data = data.content;
                    $scope.proposal.prpTmainDto = _data.prpTmainDto;//基本信息（不完全）
                    if(flag=="Edit"){
                        $scope.checkedBoxInsured=true;//详细信息隐藏被保险人同投保人按钮
                        //客户信息中被保险人中的  同投保人选择按钮
                        _data.customerDto.appliInsuredDto.insuredCode == _data.customerDto.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                        $scope.proposalShow = false;//修改时放开 主险，附加险按钮
                        //茬次信息赋值
                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            angular.forEach(_data.contractinfoDto.prpTitemKindAgriDtoList, function (_data) {
                                _data.timesAmount=round(_data.timesAmount,2);
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy = _data.contractinfoDto.prpTitemKindAgriDtoList
                        }
                    }else if(flag=='COPY_PROPOSAL'){
                        $scope.checkedBoxInsured=true;//详细信息隐藏被保险人同投保人按钮
                        //客户信息中被保险人中的  同投保人选择按钮
                        _data.customerDto.appliInsuredDto.insuredCode == _data.customerDto.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102'
                            || $scope.proposal.prpTmainDto.riskCode == '3224') {
                            $scope.proposalShow = false;//修改时放开 主险，附加险按钮
                        }else{
                            $scope.proposalShow = false;//修改时放开 主险，附加险按钮
                            $scope.mainOrSubMain=true;
                        }
                        //茬次信息赋值
                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            $scope.proposalShow = false;//无需隐藏主险，附加险按钮支持复制完修改
                            angular.forEach(_data.contractinfoDto.prpTitemKindAgriDtoList, function (_data) {
                                _data.stratDate = "";
                                _data.endDate = "";
                                _data.timesAmount=round(_data.timesAmount,2);
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy = _data.contractinfoDto.prpTitemKindAgriDtoList
                        }
                    }else{
                        $scope.checkedBoxInsured=false;//详细信息隐藏被保险人同投保人按钮
                        $scope.proposalShow = true;//隐藏主险，附加险按钮
                        $scope.otherQueryHide=true;
                        //茬次信息赋值
                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            angular.forEach(_data.contractinfoDto.prpTitemKindAgriDtoList, function (_data) {
                                _data.timesAmount=round(_data.timesAmount,2);
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy = _data.contractinfoDto.prpTitemKindAgriDtoList
                        }
                    }

                    $scope.proposal.modelcodeValidate = $scope.proposal.prpTmainDto.modelCode;//将模板取出来用于投保单修改的时候判断有没有重新选择模板，没有重新选择保存的时候就不用校验，如果重新选择了保存的时候要校验模板是否有效
                    if ($scope.proposal.prpTmainDto.underwriteFlag == "0" || $scope.proposal.prpTmainDto.underwriteFlag == "8" || $scope.proposal.prpTmainDto.underwriteFlag == "9") {
                        //隐藏查看核保信息
                        $scope.ViewUnderWriteInfoButton = true;
                    } else {
                        //查看核保信息不置灰
                        $scope.ViewUnderWriteInfo = false;
                    }
                    //----------------------------------页面个性化开始----------------------------------------------------
                    if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.isAgriUnitCostMain = false;//隐藏单位生产成本
                        $scope.isProportion = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                        $rootScope.isTrue();
                    }
                    //赔付明细
                    $scope.isTriggerPoint = false;
                    $scope.isTotalLossRatio = false;
                    if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                        || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                        || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3134'
                        || $scope.proposal.prpTmainDto.riskCode == '3147' || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3129' || $scope.proposal.prpTmainDto.riskCode == '3102'
                        || $scope.proposal.prpTmainDto.riskCode == '3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
							|| $scope.proposal.prpTmainDto.riskCode=='3161'||$scope.proposal.prpTmainDto.riskCode == '3149') {
                        //显示起赔点、全损损失率
                        $scope.isTriggerPoint = true;
                        $scope.isTotalLossRatio = true;
                    }
                    //种植方式
                    $scope.isRaiseType = false;
                    $scope.isProposalType = false;
                    if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                        || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                        || $scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102'
                        || $scope.proposal.prpTmainDto.riskCode == '3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
						|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
							|| $scope.proposal.prpTmainDto.riskCode=='3161'||$scope.proposal.prpTmainDto.riskCode == '3149') {
                        $scope.isProposalType = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.isRaiseType = true;
                        $scope.isRaiseDate = false;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3237') {
                        $scope.isIndemnity = true;
                        $scope.isRaiseDate = true;
                        $scope.isAgriUnitCostMain = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3129') {
                        $scope.isRaiseDate = false;
                        $scope.isProposalType = false;
                    }

                    //------------------------------------页面个性化结束------------------------------------------------
                    $scope.proposal.prpTmainDto.policySort = '0';//基本信息（不完全）
                    //$scope.proposal.prpTmainDto.othFlag='000000YY000000000000';//基本信息（不完全）
                    if ($scope.proposal.prpTmainDto.othFlag.substring(0, 1) == '0') {
                        $scope.proposal.editTypeName = '新保';
                    } else if ($scope.proposal.prpTmainDto.othFlag.substring(0, 1) == '1') {
                        $scope.proposal.editTypeName = '续保'
                    }
                    $scope.proposal.prpTmainDto.updaterName = _data.prpTmainDto.updaterName;//最近修改人
                    $scope.proposal.prpTmainDto.contractType = _data.prpTmainDto.argueSolution;//合同争议解决方式
                    $scope.proposal.prpTmainDto.reMark = _data.prpTmainDto.remark;//出单员意见
                    $scope.proposal.prpTmainDto.policyNo = _data.prpTmainDto.policyNo;
                    //业务大类转换
                    $scope.parameterConvert.businessCategoryInit();
                    //合同信息
                    $scope.proposal.prpTmainAgriDto.raiseDate = _data.contractinfoDto.raiseDate;//种植时间
                    $scope.proposal.prpTmainAgriDto.remark = _data.contractinfoDto.proposalType;//保险金额确定方式--种植险
                    $scope.proposal.prpTmainAgriDto.raiseType = _data.contractinfoDto.raiseType;//养殖方式--养殖险
                    $scope.proposal.prpTmainAgriDto.relationListNoRemark = _data.contractinfoDto.remark;//清单备注
                    $scope.proposal.prpTmainAgriDto.relationListNo = _data.contractinfoDto.insureListCode;

                    //if ($scope.proposal.prpTaddressDtoList) {
                    //    $scope.proposal.prpTaddressDto.addressName = $scope.proposal.prpTaddressDtoList[0].addressName;
                    //}
                    if ($scope.proposal.prpTaddressDto) {
                        $scope.proposal.prpTaddressDto.addressName = _data.contractinfoDto.addressName;//种植地址
                    }
                    //标的清单列表
                    if ($scope.proposal.editType == 'COPY_PROPOSAL') {
                        $scope.disabledContent=false;
                        $scope.proposal.prpTmainDto.policyNo = '';//复制投保单时保单号不该带到页面
                        $scope.proposal.prpTmainDto.printNo='';

                        //核保状态初始化
                        $scope.proposal.prpTmainDto.underwriteFlag = '0';
                        $scope.proposal.prpTmainDto.othFlag='000000YY000000000000';//复制投保单将othflag置为默认值
                        var currentDate = commonApiServ.getCurrentDate();
                        $scope.proposal.prpTmainDto.signDate=currentDate;
                        $scope.proposal.prpTmainDto.inputDate = currentDate;
                        $scope.proposal.prpTmainDto.updateDate = currentDate;
                    } else {
                        $$finder.find('queryMarkedList', {
                            // "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode,//金禾清单号
                            "insureListCode": _data.gisInsureMainListDto.insureListCode,
                            "serialNo": _data.gisInsureMainListDto.serialNo//标的清单序号
                        }, {
                            success: function (data) {
                                $scope.queryMarkedList = data.content
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                        if (flag == 'Edit') {//投保单修改时我方清单带出赋值
                            $scope.proposal.prpTmainAgriDto.relationListNo = _data.contractinfoDto.insureListCode;
                            //保费计算中的费率除数
                            $$finder.find('queryByRiskCode', {
                                riskCode: $scope.proposal.prpTmainDto.riskCode,//险种
                            }, {
                                success: function (data) {
                                    $scope.rateDivisor = data.content;
                                    $scope.getrateDivisor($scope.rateDivisor)
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        }
                        $scope.proposal.insureMainListDto.insureListCode = _data.contractinfoDto.gisInsureListCode;//金禾清单号
                        $scope.proposal.insureMainListDto.serialNo = _data.gisInsureMainListDto.serialNo;
                        //客户信息
                        $scope.proposal.appliInsuredDto = _data.customerDto.appliInsuredDto;//客户信息中的投保人信息
                        //当时非企业团体时  证件类型和证件号码去掉必填
                        if ($scope.proposal.appliInsuredDto.insuredType == '3') {
                            $scope.feiqiyetuanti = true;
                        } else {
                            $scope.feiqiyetuanti = false;
                        }
                        $scope.proposal.insuredDto = _data.customerDto.insuredDto;//客户信息中的被保人信息
                        $scope.proposal.appliInsuredDto.BusinessSort = _data.customerDto.appliInsuredDto.businessSort;//公司性质
                        $scope.proposal.insuredDto.BusinessSort = _data.customerDto.insuredDto.businessSort;//公司性质
                        $scope.getIdentity($scope.proposal.appliInsuredDto.insuredType, $scope.proposal.appliInsuredDto.identifyType);
                        $scope.getIdentity($scope.proposal.insuredDto.insuredType, $scope.proposal.insuredDto.identifyType);
                        $scope.proposal.prpDcustomerTaxPayInfoDto = _data.customerDto.customerTaxPayInfoDtoList[0];//客户信息中的发票购货方信息
                        //发票购货方信息  选择同投保人、被投保人
                        if (_data.customerDto.customerTaxPayInfoDtoList[0].payInfoObject == "1") {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                        } else if (_data.customerDto.customerTaxPayInfoDtoList[0].payInfoObject == "2") {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2";
                        } else {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }
                    }
                    //-------------------------------------养殖方式下拉框--------------------------------------
                    $scope.mulitSelectUnit($scope.proposal.prpTmainDto.riskCode, $scope.proposal.prpTmainAgriDto.statUnitCode);//承保数量计数单位--种植险
                    $scope.mulitSelectRaiseType($scope.proposal.prpTmainDto.riskCode, $scope.proposal.prpTmainAgriDto.raiseType);//承保数量计数单位--养殖险
                    //政策商业标志
                    if (_data.prpTmainDto.businessType1 == '01') {
                        $scope.proposal.prpTmainDto.businessType1Name = '中央政策性'
                    } else if (_data.prpTmainDto.businessType1 == '02') {
                        $scope.proposal.prpTmainDto.businessType1Name = '地方政策性'
                    } else {
                        $scope.proposal.prpTmainDto.businessType1Name = '商业性'
                    }
                    if (_data.prpTmainDto.policySort == "0") {
                        $scope.proposal.prpTmainDto.policySort = "普通"
                    } else if (_data.prpTmainDto.policySort == "1") {
                        $scope.proposal.prpTmainDto.policySort = "定额"
                    }
                    if (_data.prpTmainDto.language == "C") {
                        $scope.proposal.prpTmainDto.language = "中文"
                    } else if (_data.prpTmainDto.language == "E") {
                        $scope.proposal.prpTmainDto.language = "英文"
                    } else if (_data.prpTmainDto.language == "Z") {
                        $scope.proposal.prpTmainDto.language = "其他语种"
                    }
                    //清单相关的信息
                    //清单类型
                    //_data.contractinfoDto.listTypeFlag === "P" ? $scope.proposal.insureMainListDto.listTypeFlag = "保单" : $scope.proposal.insureMainListDto.listTypeFlag = "清单";
                    $scope.proposal.prpTmainDto.businessProvinceName = _data.gisInsureMainListDto.fProvinceName;//归属区域:省
                    $scope.proposal.prpTmainDto.businessCityName = _data.gisInsureMainListDto.fCityName;//归属区域:市
                    $scope.proposal.prpTmainDto.businessCountyName = _data.gisInsureMainListDto.fCountyName;//归属区域:区/县
                    $scope.proposal.prpTmainDto.businessTownName = _data.gisInsureMainListDto.fTownName;//归属区域:镇
                    $scope.proposal.prpTmainDto.businessAreaName = _data.gisInsureMainListDto.fVillageName;//归属区域:村
                    if (_data.contractinfoDto.listTypeFlag == "D") {
                        $scope.proposal.insureMainListDto.listTypeFlag = "大户";
                    }
                    if (_data.contractinfoDto.listTypeFlag == "S") {
                        $scope.proposal.insureMainListDto.listTypeFlag = "散户";
                    }
                    $scope.totalAmount = _data.prpTmainDto.sumAmount;//总保额
                    $scope.totalPay = _data.prpTmainDto.sumPremium;//总保费
                    $scope.proposal.prpTplanDtoList = _data.contractinfoDto.prpTplanList;//缴费计划（不完s全）
                    //缴费计划
                    //angular.forEach(_data.contractinfoDto.prpTplanList,function(data,index){
                    //    if(data.payReason==='R10'){
                    //        data.payReasonName='签单收保费';
                    //    }
                    //    if(data.payReason=='R20'){
                    //        data.payReasonName='分期收保费'
                    //    }
                    //});
                    $scope.proposal.prpTsubsidyDtoList = _data.contractinfoDto.prpTsubsidyList;//补贴信息
                    $scope.proposal.prpTfeeDto = _data.contractinfoDto;//币别信息
                    $scope.proposal.prpTfeeDto.amount=round($scope.proposal.prpTfeeDto.amount,2);
                    $scope.proposal.prpTfeeDto.premium=round($scope.proposal.prpTfeeDto.premium,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium=round($scope.proposal.prpTfeeDto.noTaxPremium,2);
                    $scope.proposal.prpTfeeDto.taxFee=round($scope.proposal.prpTfeeDto.taxFee,2);
                    $scope.proposal.prpTfeeDto.amount2=round($scope.proposal.prpTfeeDto.amount2,2);
                    $scope.proposal.prpTfeeDto.premium2=round($scope.proposal.prpTfeeDto.premium2 ,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium2=round($scope.proposal.prpTfeeDto.noTaxPremium2,2);
                    $scope.proposal.prpTfeeDto.taxFee2=round($scope.proposal.prpTfeeDto.taxFee2,2);
                    $scope.proposal.prpTfeeDto.amount1=round($scope.proposal.prpTfeeDto.amount1,2);
                    $scope.proposal.prpTfeeDto.premium1=round($scope.proposal.prpTfeeDto.premium1,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium1=round($scope.proposal.prpTfeeDto.noTaxPremium1,2);
                    $scope.proposal.prpTfeeDto.taxFee1=round($scope.proposal.prpTfeeDto.taxFee1,2);
                    if (!$scope.proposal.prpTfeeDto.amount) {
                        $scope.proposal.prpTfeeDto.currency = "";
                        $scope.proposal.prpTfeeDto.noTaxPremium = "";
                        $scope.proposal.prpTfeeDto.taxFee = "";
                        $scope.proposal.prpTfeeDto.noTaxPremium2 = "";
                        $scope.proposal.prpTfeeDto.taxFee2 = "";
                        $scope.proposal.prpTfeeDto.noTaxPremium1 = "";
                        $scope.proposal.prpTfeeDto.taxFee1 = "";
                        if ($stateParams.addEditExamine === 'Examine') {
                            $scope.DownloadButton = true;
                        } else if ($stateParams.addEditExamine === 'Edit') {

                        }
                    } else {
                        $scope.DownloadHouseholdList = false;
                    }
                    $scope.proposal.prpTfeeDto.feeCurrencyName2 = _data.contractinfoDto.currency2Name;//汇总币别
                    //特约信息表
                    $scope.proposal.prpTengageDtoCopy = $scope.proposal.prpTengageDtoCopy || [];
                    var prpTengageDtoList = []
                    angular.forEach(_data.otherInfoDto.prpTengageList, function (_data) {
                        if (_data.clauseCode != "TX001" && _data.clauseCode != "TX004") {
                            var obj1 = {
                                clauses: "",
                                clauseCode: "",
                                clausesContent: ""
                            }
                            obj1.clauses = _data.clauseName,//特约名称
                                obj1.clauseCode = _data.clauseCode,//特约代码
                                obj1.clausesContent = _data.clausesContent//特约内容
                            prpTengageDtoList.push(obj1)
                        }
                    });
                    $scope.proposal.prpTengageDtoCopy = prpTengageDtoList;//特约及附加信息

                    //绝对免赔率和免赔说明
                    $scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
                    angular.forEach(_data.otherInfoDto.prpTengageList, function (data, index) {
                        var clausesContent = data.clausesContent;
                        // 绝对免赔率
                        if (data.clauseCode === 'TX001') {
                            $scope.proposal.engageQueryClause.absuDedu = clausesContent;
                        }
                        // 免赔说明
                        if (data.clauseCode === 'TX004') {
                            $scope.proposal.engageQueryClause.deduText = clausesContent;
                        }
                    });
                    //归属机构
                    $scope.getComCodeList();
                    //归属业务员
                    $scope.getHanCode({comCName: $scope.proposal.prpTmainDto.comCName}, $scope.proposal.prpTmainDto.handler1Code);
                    //投保方式
                    $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, _data.prpTmainDto.policyType);//投保方式下拉初始化获取
                    //标的类型
                    //$scope.itemCodeType(_data.contractinfoDto.prpTitemKindList[0].kindCode);
                    //$scope.createRiskCode();//保费计算中的费率除数
                    //$scope.createRiskCode();//保费计算中的费率除数
                    // 主险、附加险的总保额 总保费
                    if ($scope.proposal.prpTmainDto.riskCode == '3224' || $scope.proposal.prpTmainDto.riskCode == '3237') {
                        $scope.trRaiseName = "养殖时间";
                        $scope.addressTitle = "养殖地点";
                        $scope.isTriggerPoint = true;
                        $scope.isTotalLossRatio = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.trRaiseName = "养殖时间";
                        $scope.addressTitle = "养殖地点";
                    } else {
                        $scope.trRaiseName = "种植时间";
                        $scope.addressTitle = "种植地点";
                    }
                    if ($scope.proposal.prpTmainDto.riskCode == '3129') {
                        $scope.isRaiseDate = false;
                        $scope.isProposalType = false;
                        $scope.isTriggerPoint = true;
                        $scope.isTotalLossRatio = true;
                        $scope.ZHshow = true;
                        $scope.isAgriUnitCostMain = false;
                        $scope.showprice = false;
                    }
                    //共保信息
                    $scope.proposal.prpTplanCoinsDtoList = _data.otherInfoDto.prpTplanCoinsDtoList;
                    $scope.proposal.prpTcoinsDetailDtoList = _data.otherInfoDto.prpTcoinsDetailDtoList;
                    $scope.proposal.prpTcoinsDtoList = _data.otherInfoDto.prpTcoinsDtoList;
                    if ($scope.proposal.prpTplanCoinsDtoList && $scope.proposal.prpTplanCoinsDtoList.length > 0
                        && $scope.proposal.prpTcoinsDetailDtoList && $scope.proposal.prpTcoinsDetailDtoList.length > 0
                        && $scope.proposal.prpTplanCoinsDtoList.length > 0) {
                        $scope.PremiumShow = true;
                        $scope.showCoins = false;
                        $scope.isHide = false;
                        $scope.proposal.otherAgentFeeShow = false;
                        $scope.proposal.showCoinsInfo();//显示共保信息
                    }
                    $scope.proposal.prpTitemKindDtoList = _data.contractinfoDto.prpTitemKindList;//主险附加险(不完全)
                    $scope.proposal.prpTitemKindAgri = $scope.proposal.prpTitemKindAgri || {};
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        data.shortRate=round(data.shortRate,2);
                        data.amount=round(data.amount,2);
                        data.premium=round(data.premium,2)
                        data.unitPremium=round(data.unitPremium,2)
                        data.radioType = data.flag.substr(1,2)== 1?'Y':'N';//给页面主险、附加险按钮赋值
                        if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                            data.agriUnitCostMaintitle = '何价投保';
                            data.unitCostName = '元/头';
                            data.proportionName = '%';
                            data.untilName = "元";
                            data.untilName1 = '头';
                            data.untilKindName = "投保头数";
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                            || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                            || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3129'
                            || $scope.proposal.prpTmainDto.riskCode == '3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
							|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
							|| $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode=='3149') {
                            data.agriUnitCostMaintitle = '单位生产成本';
                            data.unitCostName = '元';
                            data.untilKindName = "投保面积";
                            data.agriUnitOutputMaintitle = "单位保险产量";
                            data.agriUnitOutputMainName = "公斤";
                            data.untilName = "元/亩";//单位名称
                            data.untilName1 = '亩';
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3129') {
                            data.untilKindName = "投保面积";
                            data.agriUnitCostMaintitle = '单位保险产量';
                            data.unitCostName = '公斤';
                            data.agriUnitOutputMainName = "斤";
                            data.untilName = "元/亩";//单位名称
                            data.untilName1 = '亩';
                        }
                        else if ($scope.proposal.prpTmainDto.riskCode == '3224') {
                            data.untilKindName = "投保面积";
                            data.agriUnitCostMaintitle = '单位保险产量';
                            data.unitCostName = '斤';
                            data.agriUnitOutputMainName = "斤";
                            data.untilName = "元/亩";//单位名称
                            data.untilName1 = '亩';
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3237' || $scope.proposal.prpTmainDto.riskCode == '3134'
                            || $scope.proposal.prpTmainDto.riskCode == '3147' || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            data.untilName = "元/亩";
                            data.untilKindName = "投保面积";
                            data.untilName1 = '亩';
                        }
                        if (data.agriStartDate) {
                            $scope.proposal.prpTitemKindAgri.stratDate = data.agriStartDate;
                        }
                        if (data.agriEndDate) {
                            $scope.proposal.prpTitemKindAgri.endDate = data.agriEndDate;
                        }

                    });
                    $$finder.find('queryInsurePreliminaryConfirm', {
                        "insureListCode": $scope.proposal.insureMainListDto.insureListCode,//金禾清单号
                        "serialNo": $scope.proposal.insureMainListDto.serialNo,//标的清单序号

                    }, {
                        success: function (data) {
                            //投保人客户类型置灰
                            if ($scope.proposal.appliInsuredDto.insuredType != null && $scope.proposal.appliInsuredDto.insuredType != "" && $scope.proposal.appliInsuredDto.insuredType != undefined) {
                                $rootScope.kelei = true;
                            }
                            //被保险人客户类型置灰
                            if ($scope.proposal.insuredDto.insuredType != null && $scope.proposal.insuredDto.insuredType != "" && $scope.proposal.insuredDto.insuredType != undefined) {
                                $rootScope.kelei1 = true;
                            }
                            $scope.proposal.certificate = false;
                            $scope.proposal.certificate1 = false;
                            if (data.content.gisFarmerListDtoList.length > 1) {//是散户的情况

                            } else {
                                if (($scope.proposal.appliInsuredDto.insuredName == data.content.gisFarmerListDtoList[0].fName) && $scope.proposal.appliInsuredDto.insuredName) {//客户名称
                                    $scope.keming = true;
                                }
                                if (($scope.proposal.appliInsuredDto.identifyType == data.content.gisFarmerListDtoList[0].fIdType) && $scope.proposal.appliInsuredDto.identifyType) {//证件类型
                                    $scope.zhenglei = true;
                                }
                                if ($scope.proposal.appliInsuredDto.identifyNumber && ($scope.proposal.appliInsuredDto.identifyNumber == data.content.gisFarmerListDtoList[0].fIdCard)) {//证件号码
                                    $scope.zhenghao = true;
                                }
                                if ($scope.proposal.appliInsuredDto.mobile && ($scope.proposal.appliInsuredDto.mobile == data.content.gisFarmerListDtoList[0].fPhone)) {//移动电话
                                    $scope.yidian = true;
                                }
                                if ($scope.proposal.appliInsuredDto.phoneNumber && ($scope.proposal.appliInsuredDto.phoneNumber == data.content.gisFarmerListDtoList[0].fPhone)) {//固定电话
                                    $scope.gudian = true;
                                }
                                if ($scope.proposal.appliInsuredDto.insuredAddress && ($scope.proposal.appliInsuredDto.insuredAddress == data.content.gisFarmerListDtoList[0].fAddress)) {//客户地址
                                    $scope.kedi = true;
                                }
                                if ($scope.proposal.appliInsuredDto.account && ($scope.proposal.appliInsuredDto.account == data.content.gisFarmerListDtoList[0].accountNo)) {//银行账号
                                    $scope.yinzhang = true;
                                }
                                if ($scope.proposal.appliInsuredDto.bank && ($scope.proposal.appliInsuredDto.bank == data.content.gisFarmerListDtoList[0].bankName)) {//开户行
                                    $scope.kaihu = true;
                                }
                                //被保险人
                                if ($scope.proposal.insuredDto.insuredName && ($scope.proposal.insuredDto.insuredName == data.content.gisFarmerListDtoList[0].fName)) {//客户名称
                                    $scope.keming1 = true;
                                }
                                if ($scope.proposal.insuredDto.identifyType && ($scope.proposal.insuredDto.identifyType == data.content.gisFarmerListDtoList[0].fIdType)) {//证件类型
                                    $scope.zhenglei1 = true;
                                }
                                if ($scope.proposal.insuredDto.identifyNumber && ($scope.proposal.insuredDto.identifyNumber == data.content.gisFarmerListDtoList[0].fIdCard)) {//证件号码
                                    $scope.zhenghao1 = true;
                                }
                                if ($scope.proposal.insuredDto.mobile && ($scope.proposal.insuredDto.mobile == data.content.gisFarmerListDtoList[0].fPhone)) {//移动电话
                                    $scope.yidian1 = true;
                                }
                                if ($scope.proposal.insuredDto.phoneNumber && ($scope.proposal.insuredDto.phoneNumber == data.content.gisFarmerListDtoList[0].fPhone)) {//固定电话
                                    $scope.gudian1 = true;
                                }
                                if ($scope.proposal.insuredDto.insuredAddress && ($scope.proposal.insuredDto.insuredAddress == data.content.gisFarmerListDtoList[0].fAddress)) {//客户地址
                                    $scope.kedi1 = true;
                                }
                                if ($scope.proposal.insuredDto.account && ($scope.proposal.insuredDto.account == data.content.gisFarmerListDtoList[0].accountNo)) {//银行账号
                                    $scope.yinzhang1 = true;
                                }
                                if ($scope.proposal.insuredDto.bank && ($scope.proposal.insuredDto.bank == data.content.gisFarmerListDtoList[0].bankName)) {//开户行
                                    $scope.kaihu1 = true;
                                }
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });

                }
                //投保单修改
                if ($stateParams.addEditExamine === 'Edit') {
                    $scope.initFlag = true;// 初始化标志  初始化完成后置为 false  默认true初始化状态
                    $scope.showRiskScheme = false; //出单向导弹窗
                    $scope.riskScheme1 = true;
                    $scope.queryHide = false;//显示编辑类型字段
                    $scope.proposalQueryHide = false;//设置字段可以修改
                    //投保单详细信息修改
                    $$finder.find('queryProposalInfo', {
                        "proposalNo": $stateParams.proposalNo,
                        "familyNos": null
                    }, {
                        success: function (data) {
                            $scope.proposalQueryMessage(data, 'Edit');
                            if ($scope.proposal.prpTmainDto.policySort == "普通") {
                                $scope.proposal.prpTmainDto.policySort = "0"
                            } else if ($scope.proposal.prpTmainDto.policySort == "定额") {
                                $scope.proposal.prpTmainDto.policySort = "1"
                            }
                            if ($scope.proposal.prpTmainDto.language == "中文") {
                                $scope.proposal.prpTmainDto.language = "C"
                            } else if ($scope.proposal.prpTmainDto.language == "英文") {
                                $scope.proposal.prpTmainDto.language = "E"
                            } else if ($scope.proposal.prpTmainDto.language == "其语种他") {
                                $scope.proposal.prpTmainDto.language = "Z"
                            }
                            //-----------------投保单修改生成我方清单干什么，不明白，这是谁写的，开始--------------------------------------
                            //我方清单号生成
                            //$$finder.find('creatProposal', {
                            //    "tableName": "insureMainList",
                            //    "iYear": new Date().getFullYear(),//当前年份
                            //    "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种  "3101"
                            //    "iComCode": $scope.proposal.prpTmainDto.comCode,//归属机构 "3400000000"
                            //    "userCode": $rootScope.user.userCode
                            //}, {
                            //    success: function (data) {
                            //        $scope.proposal.prpTmainAgriDto.relationListNo = data.content.billNo;
                            //        console.log(data.content.billN)
                            //    },
                            //    error: function (e) {
                            //        options.error(e);
                            //    }
                            //});
                            //-----------------投保单修改生成我方清单干什么，不明白，这是谁写的，结束--------------------------------------
                            $scope.proposal.editType = "NEW";//编辑类型

                        }
                    })
                } else if ($stateParams.addEditExamine === 'Examine') {//投保单查看
                    //隐藏上一步
                    $scope.pereviousButton = true;
                    //分户清单下载不置灰
                    $scope.DownloadHouseholdList = false
                    //影像查看不置灰
                    $scope.ImageView = false;

                    $scope.hideUploadImage = true;
                    $scope.showInfoHide = true;
                    $scope.initFlag = true;// 初始化标志  初始化完成后置为 false  默认true初始化状态
                    $scope.showRiskScheme = false; //出单向导弹窗
                    $scope.queryHide = false;//显示编辑类型字段
                    $scope.proposalQueryHide = true;//设置只读
                    //投保单详细信息详情
                    $$finder.find('queryProposalInfo', {
                        "proposalNo": $stateParams.proposalNo,
                        "familyNos": null
                    }, {
                        success: function (data) {
                            $scope.proposalQueryMessage(data);
                        }
                    })
                }
                //    保存按钮
                $scope.proposal = $scope.proposal || {}
                $scope.proposal.prpTmainDto = $scope.proposal.prpTmainDto || {}
                $scope.showSave = false;


                //归属机构录单权限的方法
                function CheckBusinessComCodeInfo(flag) {
                    $$finder.find('CheckBusinessComCodeInfo', {
                        'comCode': $scope.proposal.prpTmainDto.comCode,
                        'flag': flag
                    }, {
                        success: function (data) {
                            return data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

                //查询险种配置清单
                $scope.nyxMultipleFarmerListFlag = [];
                function getPropertyRuleToFront(paramCode) {
                    $$finder.find('getPropertyRuleToFront', {//utiPlatConfigRule/,getPropertyRuleToFront
                        "paramCode": paramCode,//"NYX_MULTIPLE_FARMER_LIST_FLAG",//这里写活了，通过传参写成公共方法
                        "systemCode": "prpall"//承保系统就传prpall,理赔是claim
                    }, {
                        success: function (data) {
                            return data.content.message;
                            //$scope.nyxMultipleFarmerListFlag = data.content.message;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

                //查询当前险种是否存在于配置的险种当中，这里用传参的方法写活了
                function checkSingleKindMultiItemAgri(strRiskCode, paramCode) {
                    var nyxMultipleFarmerListFlag = getPropertyRuleToFront(paramCode);//$scope.nyxMultipleFarmerListFlag;
                    if (nyxMultipleFarmerListFlag && nyxMultipleFarmerListFlag.indexOf(strRiskCode) > -1)
                        return true;
                    else return false;
                }

                //返回按钮
                $scope.returnButton = function () {
                    $window.history.back();
                }
                //点击上一步
                $scope.perevious = function ($event) {

                    if ($scope.proposalQueryHide) {
                        $rootScope.goBackDashboard();
                    }
                    if ($scope.endorseFlag) {
                        $event.preventDefault();
                    } else {
                        $scope.$emit('closeRiskScheme', true);
                    }
                };
                //清单查询测试用勿删，周琦提
                // $scope.isInInsureMainFlag = "";
                function isInInsureMainList() {
                    $$finder.find('isInInsureMainList', {
                        //"insureListCode":"QDBH310734000020180103000036"
                        "insureListCode": $scope.proposal.insureMainListDto.insureListCode
                    }, {
                        success: function (data) {
                            $scope.isInInsureMainFlag = data.content.message;
                            return $scope.isInInsureMainFlag;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

                //投保单号保存时每个表需要的字段
                function proposalSaveTurnData(a) {
                    var getHour = new Date().getHours();
                    $scope.parameterConvert.businessCategorySubmit();
                    $scope.proposal.isSaveFlag = a;
                    //主表
                    $scope.proposal.prpTmainDto.currency = $scope.proposal.prpTfeeDto.currency2;//币别代码
                    $scope.proposal.prpTmainDto.appliCode = $scope.proposal.appliInsuredDto.insuredCode;//投保人代码
                    $scope.proposal.prpTmainDto.appliName = $scope.proposal.appliInsuredDto.insuredName;//投保人名称
                    $scope.proposal.prpTmainDto.appliAddress = $scope.proposal.appliInsuredDto.insuredAddress;//投保人地址
                    $scope.proposal.prpTmainDto.insuredCode = $scope.proposal.insuredDto.insuredCode;//被保人代码
                    $scope.proposal.prpTmainDto.insuredName = $scope.proposal.insuredDto.insuredName;//被保险人名称
                    //-------------------------------续保对象组装开始----------------------------------------------
                    if($scope.proposal.editType=="RENEWAL"){
                        $scope.proposal.prpTrenewalDto={};
                        $scope.proposal.prpTrenewalDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//给续保对象赋值
                        $scope.proposal.prpTrenewalDto.oldPolicyNo =  $scope.proposal.prpTmainDto.copyOldNo;//被续保的保单号
                    }
                    //-------------------------------续保对象组装结束----------------------------------------------
                    //-----------------------------避免复制投保单、保单时值转不过来开始--------------------------------------
                    if ($scope.proposal.prpTmainDto.policySort == "普通") {
                        $scope.proposal.prpTmainDto.policySort = "0"
                    } else if ($scope.proposal.prpTmainDto.policySort == "定额") {
                        $scope.proposal.prpTmainDto.policySort = "1"
                    }
                    if ($scope.proposal.prpTmainDto.language == "中文") {
                        $scope.proposal.prpTmainDto.language = "C"
                    } else if ($scope.proposal.prpTmainDto.language == "英文") {
                        $scope.proposal.prpTmainDto.language = "E"
                    } else if ($scope.proposal.prpTmainDto.language == "其语种他") {
                        $scope.proposal.prpTmainDto.language = "Z"
                    }
                    //-----------------------------避免复制投保单、保单时值转不过来结束--------------------------------------
                    $scope.proposal.prpTmainDto.insuredAddress = $scope.proposal.insuredDto.insuredAddress;//被保险人地址
                    $scope.proposal.prpTmainDto.handlerCode = $scope.proposal.prpTmainDto.handler1Code;//经办人代码
                    //$scope.proposal.prpTmainDto.sumAmount=$scope.proposal.prpTfeeDto.amount;//总保费
                    //$scope.proposal.prpTmainDto.sumPremium=$scope.proposal.prpTfeeDto.premium;//总保额
                    //todo这个地方注意一下,这个出单机构应该是从登陆返回的user对象中取得makecom
                    //$scope.proposal.prpTmainDto.makeCom=$scope.proposal.prpTmainDto.comCode;
                    $scope.proposal.prpTmainDto.makeCom = $rootScope.user.loginComCode;//出单机构代码
                    $scope.proposal.prpTmainDto.updateHour = getHour;//最近修改日期的小时
                    $scope.proposal.prpTmainDto.inputHour = getHour;//最近操作人的小时
                    $scope.proposal.prpTmainDto.sumNoTaxPremium = $scope.proposal.prpTfeeDto.noTaxPremium;//总不含税保费
                    $scope.proposal.prpTmainDto.argueSolution = $scope.proposal.prpTmainDto.contractType;//合同争议解决方式
                    $scope.proposal.prpTmainDto.remark = $scope.proposal.prpTmainDto.reMark;//出单员意见
                    $scope.proposal.prpTmainDto.groupNo = $scope.proposal.prpTmainDto.modelCode;//模板号
                    $scope.proposal.gisInsureListCode = $scope.proposal.insureMainListDto.insureListCode;
                    $scope.proposal.serialNo = $scope.proposal.insureMainListDto.serialNo;
                    //客户信息
                    $scope.proposal.appliInsuredDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//投保单号
                    $scope.proposal.appliInsuredDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    //$scope.proposal.appliInsuredDto.businessSort=$scope.proposal.appliInsuredDto.BusinessSort//公司性质
                    //$scope.proposal.appliInsuredDto.businessSource=$scope.proposal.appliInsuredDto.businessName;//行业名称
                    $scope.proposal.appliInsuredDto.insuredFlag = '2';
                    $scope.proposal.insuredDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//投保单号
                    $scope.proposal.insuredDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    //$scope.proposal.insuredDto.businessSort=$scope.proposal.insuredDto.BusinessSort//公司性质
                    //$scope.proposal.insuredDto.businessSource=$scope.proposal.insuredDto.businessName;//行业名称
                    $scope.proposal.insuredDto.insuredFlag = '1';
                    //种植地点
                    $scope.proposal.prpTaddressDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//投保单号
                    $scope.proposal.prpTaddressDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    //合同信息
                    $scope.proposal.prpTmainAgriDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//投保单号
                    $scope.proposal.prpTmainAgriDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    $scope.proposal.prpTmainAgriDto.raiseSite = $scope.proposal.prpTaddressDto.addressName;//养殖地点
                    //防止暂存时未点击币别确定导致selfPremium未定义的场景
                    if ($scope.proposal.prpTitemKindDtoList.length > 0) {
                        if ($scope.proposal.prpTitemKindDtoList[0].selfPremium != 'undefined') {
                            $scope.proposal.prpTaddressDto.selfPremium = $scope.proposal.prpTitemKindDtoList[0].selfPremium;//自缴保费
                        }
                    }
                    //币别信息
                    $scope.proposal.prpTfeeDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;//投保单号
                    $scope.proposal.prpTfeeDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    //----此处加校验是为了防止暂存时没有点击计算按钮，导致prpTfeeDto.currency为空，而表中又是非空报错，与钱总确认，为空时，默认为CNY-start---
                    if ($scope.proposal.prpTfeeDto.currency == null || $scope.proposal.prpTfeeDto.currency == 'undefined'
                        || $scope.proposal.prpTfeeDto.currency == '') {
                        $scope.proposal.prpTfeeDto.currency = 'CNY';
                    }
                    //----此处加校验是为了防止暂存时没有点击计算按钮，导致prpTfeeDto.currency为空，而表中又是非空报错，与钱总确认，为空时，默认为CNY-end---
                    //清单类型
                    if ($scope.proposal.insureMainListDto.listTypeFlag == '大户') {
                        $scope.proposal.prpTmainDto.listTypeFlag = 'D'
                    }
                    if ($scope.proposal.insureMainListDto.listTypeFlag == '散户') {
                        $scope.proposal.prpTmainDto.listTypeFlag = 'S'
                    }
                    //主险附加险
                    //用于茬次信息
                    var riskCode="";
                    //var itemKindNo="";
                    var kindCode="";
                    angular.forEach($scope.proposal.prpTitemKindDtoList,function(data,index){
                        data.calculateFlag=data.radioType;//prpTitemKindDtoList标识位
                        if(data.radioType==='Y'){
                            riskCode=data.riskCode;
                            //itemKindNo=data.itemKindNo;
                            kindCode=data.kindCode;
                            data.flag=' 1';
                        }else if(data.radioType==='N'){
                            data.flag=' 2';
                        }
                        data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                        data.riskCode = $scope.proposal.prpTmainDto.riskCode;
                        data.startDate = $scope.proposal.prpTmainDto.startDate;//起始日期
                        data.startHour = $scope.proposal.prpTmainDto.startHour;//起始小时
                        data.endDate = $scope.proposal.prpTmainDto.endDate;//终止日期
                        data.endHour = $scope.proposal.prpTmainDto.endHour;//终止小时
                        data.addressNo = $scope.proposal.prpTaddressDto.addressNo;//种植地址序号
                    });
                    $scope.proposal.prpTitemKindAgriDtoList = angular.copy($scope.proposal.prpTitemKindDtoList);
                    $scope.proposal.prpTitemKindAgri = $scope.proposal.prpTitemKindAgri || {};
                    angular.forEach($scope.proposal.prpTitemKindAgriDtoList, function (data, index) {
                        //if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        //    || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'){
                        //    if ($scope.proposal.prpTmainAgriDto.remark=='2'){
                        //        //参照一定的产量和价格确定
                        //        data.unitOutput=data.agriUnitOutputMain;
                        //    }else{
                        //        //参照生产成本确定
                        //        data.unitCost=data.agriUnitCostMain;//对应页面生成成本
                        //    }
                        //}else if($scope.proposal.prpTmainDto.riskCode=='3220'){
                        //    data.unitCost = data.agriUnitCostMain;//养殖险对应的是何价投保
                        //}
                        data.unitOutput = data.agriUnitOutputMain;
                        data.unitCost = data.agriUnitCostMain;
                        data.grossQuantity = data.agriGrossQuantityMain;//种养总量,养殖险就是投保数量
                        data.timesAmount = data.agriTimesAmount;
                        data.unitOutput = data.agriUnitOutputMain;
                        data.agriGrossQuantityMain = data.agriGrossQuantityMain;//
                        data.discountType = "2";
                        data.depreciationRate = "";//折旧率/树龄(林木险)
                        data.remark = $scope.proposal.prpTmainAgriDto.remark;
                        if ($scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3129') {
                            data.stratDate = $scope.proposal.prpTitemKindAgri.stratDate;
                            data.endDate = $scope.proposal.prpTitemKindAgri.endDate;
                        }
                    });
                    //茬次信息 如果险种是3134或者3147就走
                    if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                        var times = 0
                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
                            dto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                            dto.riskCode = riskCode;
                            //dto.itemKindNo=itemKindNo;
                            dto.kindCode = kindCode;
                            if (isNaN(dto.times)) {
                                dto.times = 0;
                            }
                            times = times + 1;
                            dto.times = times;
                            $scope.proposal.prpTitemKindAgriDtoList.push(dto);
                        });
                    }

                    //angular.forEach($scope.proposal.prpTplanDtoList,function (data,index) {//为了方便校验，位置移动到校验里面
                    //    if (data.payReason=='03'){//中央财政
                    //        data.payReason='RS3'
                    //    }
                    //    if (data.payReason=='04'){//省级财政
                    //        data.payReason='RS4'
                    //    }
                    //    if (data.payReason=='05'){//地市财政
                    //        data.payReason='RS5'
                    //    }
                    //    if (data.payReason=='06'){//其他来源
                    //        data.payReason='RS6'
                    //    }
                    //    if (data.payReason=='07'){//县(区)财政
                    //        data.payReason='RS7'
                    //    }
                    //})
                    //补贴信息
                    angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data1, index1) {
                        angular.forEach($scope.proposal.prpTitemKindDtoList, function (data2, index2) {
                            if (index1 == index2) {
                                data1.benchmarkPremium = data2.benchmarkPremium;
                            }
                        });
                        if (!data1.proposalNo) {
                            data1.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                        }
                    });
                    //主共保
                    //$scope.proposal.prpTcoinsDetailDtoList=$scope.proposal.prpTcoinsDtoList
                    //$scope.proposal.prpTcoinsDetailDtoList[0].coinsType='0'
                    angular.forEach($scope.proposal.prpTcoinsDetailDtoList, function (data, index) {
                        data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                    })
                    if ($scope.proposal.prpTcoinsDtoList.length) {
                        $scope.proposal.prpTcoinsDtoList[0].coinsType = '0'
                    }
                    angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
                        data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                        data.proportionFlag = $scope.proposal.prpTcoinsSchema.proportionFlag1 + $scope.proposal.prpTcoinsSchema.proportionFlag2;
                        data.coinsTreatyNo = '';
                        data.coinsFlag = '';
                        data.reinsCiflag = ''
                    });
                    angular.forEach($scope.proposal.prpTplanCoinsDtoList, function (data, index) {
                        data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                        data.delinquentFee = data.planFee
                        data.endorseNo = '',
                            data.payNo = '1'
                    })
                    //缴费期次
                    angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                        data.proposalNo = $scope.proposal.prpTfeeDto.proposalNo
                        data.riskCode = $scope.proposal.prpTfeeDto.riskCode
                    })
                    //特约信息
                    $scope.proposal.prpTengageDtoList = [];
                    $scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
                    // 免赔率信息生成
                    if ($scope.proposal.engageQueryClause.absuDedu) {
                        var obj = {};
                        obj.serialNo = 1;//序号不能从0开始所以加1
                        obj.lineNo = 1;//换行
                        obj.titleFlag = 0;
                        obj.flag = 0;
                        obj.clauseCode = 'TX001';
                        obj.clauses = '绝对免赔率';
                        obj.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                        obj.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                        $scope.proposal.prpTengageDtoList.push(obj);
                        var obj1 = {};
                        obj1.serialNo = 1;//序号不能从0开始所以加1
                        obj1.lineNo = 2;//换行
                        obj1.titleFlag = 1;
                        obj1.flag = 1;
                        obj1.clauseCode = 'TX001';
                        obj1.clauses = $scope.proposal.engageQueryClause.absuDedu;
                        obj1.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                        obj1.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                        $scope.proposal.prpTengageDtoList.push(obj1);
                    } else {
                        $scope.proposal.prpTengageDtoList = []
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
                        obj.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                        obj.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                        $scope.proposal.prpTengageDtoList.push(obj);
                        var obj1 = {};
                        obj1.serialNo = 1;//序号不能从0开始所以加1
                        obj1.lineNo = 2;//换行
                        obj1.titleFlag = 1;
                        obj1.flag = 1;
                        obj1.clauseCode = 'TX004';
                        obj1.clauses = $scope.proposal.engageQueryClause.deduText;
                        obj1.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                        obj1.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                        $scope.proposal.prpTengageDtoList.push(obj1);
                    }
                    //特约信息
                    angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
                        var obj = angular.copy(data);
                        obj.serialNo = $scope.proposal.prpTengageDtoList.length;//序号不能从0开始所以加1
                        obj.lineNo = 1;//换行
                        obj.titleFlag = 0;
                        obj.flag = 0;
                        obj.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                        obj.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                        $scope.proposal.prpTengageDtoList.push(obj);
                        if (data.clausesContent) {//如果内容里有东西
                            var obj = angular.copy(data);
                            obj.serialNo = $scope.proposal.prpTengageDtoList.length - 1;
                            obj.lineNo = 2;//换行
                            obj.titleFlag = 1;
                            obj.flag = 1;
                            obj.clauses = obj.clausesContent;//把内容放入名称属性中
                            obj.proposalNo = $scope.proposal.prpTfeeDto.proposalNo;
                            obj.riskCode = $scope.proposal.prpTfeeDto.riskCode;
                            $scope.proposal.prpTengageDtoList.push(obj);
                        }
                    });
                }

                //投保单号保存时的字段校验
                function proposalRegexData() {
                    var sRiskCode = $scope.proposal.prpTmainDto.riskCode;
                    var configRiskcode = '3101-3107-3108-3114-3122-3126-3186-3149-3151-3152-3153-3154-3155-3156-3187-3172-3194-3193-3161-3149'; //棉花、水稻种植险
                    var sPolicyType = $scope.proposal.prpTmainDto.policyType;//投保方式
                    var sComCode = $scope.proposal.prpTmainDto.comCode;//归属机构号
                    var strLoginComCode = $rootScope.user.loginComCode;//登录机构，老版本这里是登录机构号，但是这个值为什么写死了
                    var businessType1 = $scope.proposal.prpTmainDto.businessType1;//政策类型
                    var business = $scope.proposal.prpTmainDto.business;//业务分类
                    var newDate = $filter('date')(new Date(), 'yyyy-MM-dd');
                    var startDate = $scope.proposal.prpTmainDto.startDate;//起保日期
                    var endDate = $scope.proposal.prpTmainDto.endDate;//终保日期
                    var operateDate = $scope.proposal.prpTmainDto.operateDate;//投保日期
                    var signDate = $scope.proposal.prpTmainDto.signDate;//制单日期
                    var content = "";
                    //校验清单号的方法之一
                    function checkInsuranceCode() {
                        var strInsuranceCode = $scope.proposal.insureMainListDto.insureListCode;//清单号
                        var strInsuranceCodebak = angular.copy($scope.proposal.insureMainListDto.insureListCode);
                        if (strInsuranceCode == "") {
                            if (sRiskCode != '0311') {
                                content = "请选择分户清单号！";
                                return false;
                            } else {
                                if ($scope.proposal.prpTmainDto.coinsFlag == '0') {
                                    content = "请选择分户清单号！";
                                    return false;
                                }
                            }
                        }
                        if (strInsuranceCodebak != strInsuranceCode) {
                            if (sRiskCode != '0311') {
                                content = "请不要手工修改分户清单号！";
                                $scope.proposal.insureMainListDto.insureListCode = " ";
                                return false;
                            } else {
                                if ($scope.proposal.prpTmainDto.coinsFlag == '0') {
                                    content = "请不要手工修改分户清单号！";
                                    $scope.proposal.insureMainListDto.insureListCode = " ";
                                    return false;
                                }
                            }


                        }
                        return true;
                    }

                    //校验缴费计划
                    $scope.checkPlan = function () {
                        //财产险页面调整后，缴费计划的币别取支付保费币别信息，所以只能为单币别
                        var intRowsCount = $scope.proposal.prpTplanDtoList.length;//缴费计划的集合长度
                        var list = $scope.proposal.prpTplanDtoList;
                        //校验是否有缴费计划信息
                        if (intRowsCount <= 0) {
                            content = "没有缴费计划信息，请点击币别信息的\"确定\"按钮生成！";
                            return false;
                        }
                        //校验
                        for (var i = 0; i < intRowsCount; i++) {
                            console.log(list[i])
                            if (!list[i].planStartDate) {
                                content = "缴费起期不能为空！";
                                return false;
                            }
                            if (!list[i].planDate) {
                                content = "缴费止期不能为空！";
                                return false;
                            }
                            if (compareFullDate(list[i].planStartDate, list[i].planDate) > 0) {
                                content = "缴费起期不能大于缴费止期！";
                                return false;
                            }
                            if (!list[i].planFee) {
                                content = "应缴金额不能为空！";
                                return false;
                            }
                            if (!list[i].payReason || list[i].payReason == " ") {
                                content = "缴费原因不能为空！";
                                return false;
                            }
                            /* if(i != 1) {
                             if(compareFullDate(list[i].planStartDate, list[i - 1].planDate) < 0) {
                             content = "缴费止期不能大于下期的缴费起期！";
                             return false;
                             }
                             }*/
                        }
                        //校验缴费计划各个缴费原因与补贴信息里各个补贴类型的金额要保持一致
                        angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                            if (data.payReason == 'RS3') {//中央财政
                                data.payReason = '03'
                            }
                            if (data.payReason == 'RS4') {//省级财政
                                data.payReason = '04'
                            }
                            if (data.payReason == 'RS5') {//地市财政
                                data.payReason = '05'
                            }
                            if (data.payReason == 'RS6') {//其他来源
                                data.payReason = '06'
                            }
                            if (data.payReason == 'RS7') {//县(区)财政
                                data.payReason = '07'
                            }
                        });
                        angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                            var flag = false;
                            angular.forEach($scope.proposal.prpTplanDtoList, function (data1, index1) {
                                if (data.subsidyCode == data1.payReason) {
                                    flag = true;
                                }
                            });
                            if (!flag) {
                                content = "缴费计划中补贴类型要与补贴信息中的补贴类型一致！"
                            }
                        });
                        var resultsum = 0;
                        var resultType = "";
                        angular.forEach($scope.proposal.prpTsubsidyDtoList, function (item1) {
                            angular.forEach(list, function (item2) {
                                if (item1.subsidyCode == item2.payReason) {
                                    //resultsum+=parseFloat(item2.planFee);
                                    resultsum = commonApiServ.accAdd(resultsum, item2.planFee);
                                    resultType = item2.payReason;
                                }
                            });
                            if (item1.subsidyCode == resultType) {
                                if (item1.subsidyPremium - resultsum != 0) {
                                    content = "每个类型缴费原因的应缴总额必须等于其对应补贴类型的补贴金额！";
                                    return false;
                                }
                                resultsum = 0;
                                resultType = "";
                            }
                        });
                        angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                            if (data.payReason == '03') {//中央财政
                                data.payReason = 'RS3'
                            }
                            if (data.payReason == '04') {//省级财政
                                data.payReason = 'RS4'
                            }
                            if (data.payReason == '05') {//地市财政
                                data.payReason = 'RS5'
                            }
                            if (data.payReason == '06') {//其他来源
                                data.payReason = 'RS6'
                            }
                            if (data.payReason == '07') {//县(区)财政
                                data.payReason = 'RS7'
                            }
                        })
                        return true;
                    };
                    $scope.CheckPaymentPlan = function () {
                        if (!$scope.PremiumFlag || !$scope.coinsPremiumFlag) {
                            content = "请重新点击共保计算按钮进行计算!";
                        }
                    }
                    //校验特别约定
                    $scope.checkEngage = function () {
                        var length = $scope.proposal.prpTengageDtoCopy.length;
                        var list = $scope.proposal.prpTengageDtoCopy;
                        console.log(length)
                        console.log(list)
                        if (length > 0) {
                            for (var i = 0; i < length; i++) {
                                if (!list[i].clauseCode) {
                                    content = "特约代码不能为空!";
                                    return false;
                                }
                                if (!list[i].clauses) {
                                    content = "特约名称不能为空!";
                                    return false;
                                }
                                if (!list[i].clausesContent) {
                                    content = "特约内容不能为空,请点击“查看详情”按钮添加特约内容!";
                                    return false;
                                }
                            }
                        }
                        //重复性校验
                        if (checkEngageTwo() == false) {
                            return false;
                        }
                        return true;
                    };

                    //校验是否有重复的特别约定
                    function checkEngageTwo() {
                        var strClauseCode = "";
                        var intCounter = 0;
                        var i = 0;
                        var j = 0;
                        var length = $scope.proposal.prpTengageDtoCopy.length;
                        var list = $scope.proposal.prpTengageDtoCopy;
                        for (i = 0; i < length; i++) {
                            for (j = 0; j < length; j++) {
                                strClauseCode = list[j].clauseCode;
                                if (list[j].clauseCode == list[i].clauseCode) {
                                    intCounter++;
                                    if (intCounter > 1)
                                        break;
                                }
                            }
                            if (intCounter > 1 && strClauseCode != "T9999") {
                                content = "特别约定中有代码为：" + list[j].clauseCode + "的重复记录！";
                                return false;
                            } else {
                                intCounter = 0;
                            }
                        }
                        return true;
                    }

                    //将归属业务员拿出来，是为了暂存时表中校验是非空的
                    if ($scope.proposal.prpTmainDto.handler1Code == "") {//归属业务员
                        content = "请先录入【归属业务员】！";
                    }
                    //将纳税人身份拿出来，是为了暂存时表中校验是非空的
                    if (!$scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType) {//纳税人身份
                        content = "请先录入【纳税人身份】！"
                    }

                    //归属机构
                    if ($scope.proposal.isSaveFlag == 1) {
                        if (sComCode == "") {
                            content = "请先录入【归属机构】！";
                        } else if (strLoginComCode.indexOf("YL") != -1 && sComCode.indexOf("YL") == -1) {
                            content = "登录机构和归属机构事业部类型不一致";
                        } else if (strLoginComCode.indexOf("YL") == -1 && sComCode.indexOf("YL") != -1) {
                            content = "登录机构和归属机构事业部类型不一致";
                            // } else if ($scope.proposal.prpTmainDto.handler1Code == "") {//归属业务员
                            //     content = "请先录入【归属业务员】！";
                        }
                        /*   else if($scope.proposal.prpTmainDto.businessNature == ""){//业务来源
                         content="请先录入【业务来源】！";
                         }*/
                        else if (!$scope.proposal.prpTmainDto.businessCategory) {
                            content = "请先录入【业务大类】！";
                        } else if (!$scope.proposal.prpTmainDto.eccFlag) {
                            content = "请先录入【是否扶贫项目】！";
                        } else if (businessType1 == "") {//政策/商业标志
                            content = "请先录入【政策/商业标志】！";
                        } else if ((sRiskCode == '3194' || sRiskCode == '3193' || sRiskCode == '3151' || sRiskCode == '3229' || sRiskCode == '3176' || sRiskCode == '3230' || sRiskCode == '0311' || sRiskCode == '3196') && businessType1 == '01') {
                            content = sRiskCode + " 保险，【政策/商业标志】不能为中央政策性。";
                        } else if (sRiskCode == '0311' && businessType1 != '00') {
                            content = sRiskCode + " 保险，【政策/商业标志】只能为商业性，无补贴。";
                        }  else if ($scope.proposal.prpTmainDto.inceptionFlag == "") {//是否验标
                            content = "请先录入【是否验标】！";
                        } else if ($scope.proposal.prpTmainDto.notificationFlag == "") {//是否承保公示
                            content = "请先录入【是否承保公示】！";
                        }
                        //else if($scope.proposal.prpTmainDto.povertyFlag == undefined) {//是否扶贫项目
                        //    content="请先录入【是否扶贫项目】！";
                        //}
                        else if ($scope.proposal.prpTmainDto.thirdKnow == "") {//是否通过第三方识别
                            content = "请先录入【是否通过第三方识别】！";
                        } else if ($scope.proposal.prpTmainDto.policyType == "" && $scope.proposal.prpTmainDto.riskCode != '3129') {//投保方式
                            content = "请先录入【投保方式】！";
                        } else if ($scope.proposal.prpTmainAgriDto.remark == "" && ($scope.proposal.prpTmainDto.riskCode == "3107" || $scope.proposal.prpTmainDto.riskCode == '3162'
                            || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'||$scope.proposal.prpTmainDto.riskCode == "3101"
							|| $scope.proposal.prpTmainDto.riskCode=='3114'|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
							|| $scope.proposal.prpTmainDto.riskCode=='3161'||$scope.proposal.prpTmainDto.riskCode == '3149')) {//保险金额确定方式
                            content = "请先录入【保险金额确定方式】！";
                        } else if ($scope.proposal.prpTmainAgriDto.raiseType == "" && ($scope.proposal.prpTmainDto.riskCode.substring(0, 2) == "32" && $scope.proposal.prpTmainDto.riskCode != "3237" && $scope.proposal.prpTmainDto.riskCode != "3224")) {//保险金额确定方式
                            content = "请先录入【养殖方式】！";
                        }
                        //else if ($scope.proposal.prpTmainAgriDto.raiseDate == "" && $scope.proposal.prpTmainDto.riskCode.substring(0, 2) == "31" && $scope.proposal.prpTmainDto.riskCode != "3129") {//种植时间
                        //    content = "请先录入【种植时间】！";
                        //} else if ($scope.proposal.prpTmainAgriDto.raiseDate == "" && $scope.proposal.prpTmainDto.riskCode == "3224") {//养殖时间
                        //    content = "请先录入【养殖时间】！";
                        //}
                        else if ($scope.proposal.prpTaddressDto.addressName == "") {//种植地点
                            content = "请先录入【种植地点】！";
                        } else if ($scope.proposal.prpTitemKindDtoList.length <= 0) {//主险附加险
                            content = "请先录入【主险附加险】！";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.stratDate === undefined || $scope.proposal.prpTitemKindAgri.stratDate === "")) {
                            content = "请先录入【保险期间内草莓采收期起期】！";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.stratDate < $scope.proposal.prpTmainDto.startDate)) {
                            content = "【保险期间内草莓采收期起期】不能早于保险起期";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.stratDate > $scope.proposal.prpTmainDto.endDate)) {
                            content = "【保险期间内草莓采收期起期】不能晚于保险止期";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.endDate === undefined || $scope.proposal.prpTitemKindAgri.endDate === "")) {
                            content = "请先录入【保险期间内草莓采收期止期】！";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.stratDate >= $scope.proposal.prpTitemKindAgri.endDate)) {
                            content = "保险期间内草莓采收期起期应早于止期！";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.endDate < $scope.proposal.prpTmainDto.startDate)) {
                            content = "【保险期间内草莓采收期止期】不能早于保险起期";
                        } else if (($scope.proposal.prpTmainDto.riskCode === "3130" || $scope.proposal.prpTmainDto.riskCode === "3129") && ($scope.proposal.prpTitemKindAgri.endDate > $scope.proposal.prpTmainDto.endDate)) {
                            content = "【保险期间内草莓采收期止期】不能晚于保险止期";
                        } else if ($scope.proposal.prpTsubsidyDtoList.length <= 0 && $scope.proposal.prpTmainDto.businessType1 != '00') {//补贴信息
                            content = "请先录入【补贴信息】！";
                        } else if ($scope.proposal.prpTfeeDto.currency2 == "") {//汇总币别
                            content = "请先录入【汇总币别】！";
                        } else if ($scope.proposal.prpTfeeDto.currency1 == "") {
                            content = "请先录入【支付币别】！";
                        } else if (!$scope.proposal.prpTfeeDto.noTaxPremium) {//币别信息计算
                            content = "请先进行币别计算！";
                        } else if ($scope.proposal.prpTplanDtoList.length <= 0) {
                            content = "请先录入【缴费计划】！";
                        } else if ($scope.proposal.prpTmainAgriDto.remark == '2' && (!$scope.proposal.prpTitemKindDtoList[0].agriTimesAmount)&&($scope.proposal.prpTmainDto.riskCode!= "3141"&&$scope.proposal.prpTmainDto.riskCode!= "3147"&&$scope.proposal.prpTmainDto.riskCode!= "3134"&&$scope.proposal.prpTmainDto.riskCode!= "3102")) {
                            content = "请先录入【请录入主险/附加险的必填项】！";
                        } else if ($scope.proposal.appliInsuredDto.insuredType == "") {//客户类型
                            content = "请先录入【投保人客户类型】！";
                        } else if ($scope.proposal.appliInsuredDto.identifyType == "" && $scope.proposal.appliInsuredDto.insuredType != '3') {//证件类型
                            content = "请先录入【投保人证件类型】！";
                        } else if ($scope.proposal.appliInsuredDto.identifyNumber == "" && $scope.proposal.appliInsuredDto.insuredType != '3') {//证件号码
                            content = "请先录入【投保人证件号码】！";
                        } else if ($scope.proposal.appliInsuredDto.insuredName == "") {//客户名称
                            content = "请先录入【投保人客户名称】！";
                            //  } else if($scope.proposal.appliInsuredDto.insuredCode == ""){//客户代码
                            //    content="请先录入【投保人客户代码】！";
                        } else if ($scope.proposal.appliInsuredDto.insuredType == '1' && !$scope.proposal.appliInsuredDto.nationality) {
                            content = "请先录入【投保人国籍】！";
                        }
                        //else if (!$scope.proposal.appliInsuredDto.mobile) {
                        //    content = "请先录入【投保人固定电话】！";
                        //}
                        else if (!$scope.proposal.appliInsuredDto.phoneNumber) {
                            content = "请先录入【投保人移动定电话】！";
                        } else if (!$scope.proposal.insuredDto.phoneNumber) {
                            content = "请先录入【被保险人移动电话】！";
                        } else if ($scope.proposal.appliInsuredDto.insuredType == '1' && !$scope.proposal.appliInsuredDto.businessSource) {
                            content = "请先录入【投保人行业名称】！";
                        } else if ($scope.proposal.insuredDto.insuredType == "") {//客户类型
                            content = "请先录入【被保险人客户类型】！";
                        } else if ($scope.proposal.insuredDto.identifyType == "" && $scope.proposal.insuredDto.insuredType != '3') {//证件类型
                            content = "请先录入【被保险人证件类型】！";
                        } else if ($scope.proposal.insuredDto.identifyNumber == "" && $scope.proposal.insuredDto.insuredType != '3') {//证件号码
                            content = "请先录入【被保险人证件号码】！";
                        } else if ($scope.proposal.insuredDto.insuredName == "") {//客户名称
                            content = "请先录入【被保险人客户名称】！";
                            // } else if($scope.proposal.insuredDto.insuredCode == ""){//客户代码
                            //     content="请先录入【被保险人客户代码】！";
                        } else if ($scope.proposal.insuredDto.insuredType == '1' && !$scope.proposal.insuredDto.nationality) {
                            content = "请先录入【被保险人国籍】！";
                        }
                        //else if (!$scope.proposal.insuredDto.mobile) {
                        //    content = "请先录入【被保险人固定电话】！";
                        //}
                        else if ($scope.proposal.insuredDto.insuredType == '1' && !$scope.proposal.insuredDto.businessSource) {
                            content = "请先录入【被保险人行业名称】！";
                        } else if (!$scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType) {//纳税人身份
                            content = "请先录入【纳税人身份】！";
                        } else if ($scope.proposal.prpTmainDto.coinsFlag != 0 && $scope.proposal.prpTmainDto.coinsPremiumType == 0) {
                            content = "请先选择保单缴费类型！";
                        } else if ($scope.proposal.prpTmainDto.coinsPremiumType != 0 && $scope.proposal.prpTmainDto.coinsPremiumType && $scope.proposal.prpTcoinsDtoList.length == 0) {
                            content = "请先填写共保信息！";
                        } else if (($scope.proposal.prpTmainDto.coinsFlag == '1' || $scope.proposal.prpTmainDto.coinsFlag == '2') && $scope.proposal.prpTcoinsDtoList.length > 0 && ($scope.proposal.prpTcoinsDetailDtoList.length == '0' || $scope.proposal.prpTplanCoinsDtoList.length == '0')) {
                            content = "请先计算主共保信息！";
                        } else if (!$scope.checkClauseCodeDto) {
                            content = "您选择的条款不可用，请重新选择！";
                        } else if ($stateParams.addEditExamine === 'Edit' && ($scope.proposal.prpTmainDto.modelCode != $scope.proposal.modelcodeValidate) && !$scope.checkModelCodeDto && $scope.proposal.prpTmainDto.modelCode) {//投保单修改的保存校验
                            content = "您选择的模板不可用，请重新选择！";
                        } else if ($stateParams.addEditExamine != 'Edit' && !$scope.checkModelCodeDto && $scope.proposal.prpTmainDto.modelCode) {
                            content = "您选择的模板不可用，请重新选择！";
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3141'
                            || $scope.proposal.prpTmainDto.riskCode == '3147' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            if ($scope.proposal.prpTitemKindDtoList.length > 0) {
                                var flag = false
                                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                                    if (data.radioType == 'Y') {
                                        flag = true;
                                    }
                                })
                                if (flag == false) {
                                    content = "请至少录入一条主险信息！";
                                }
                            }
                        } else if ($scope.proposal.prpTplanDtoList.length > 0) {
                            $scope.checkPlan();
                            if ($scope.proposal.prpTengageDtoCopy != undefined) {
                                $scope.checkEngage();
                            }
                        }
                        if (businessType1 == '01') {
                            var flag=false;
                            angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                                if (data.subsidyCode == '03') {
                                    flag=true;
                                }
                            });
                            if(flag==false){
                                content = "请录入中央政策性补贴信息";
                            }
                        }
                        if ($scope.proposal.prpTcoinsDtoList && $scope.proposal.prpTcoinsDtoList.length > 0) {
                            $scope.CheckPaymentPlan();
                        }
                        /*  if (startDate <= newDate) {
                         content = "此投保单的起保日期小于或等于当前日期，请确认是否录入正确!";
                         }*/
                        /* if(compareFullDate(getNextYearFullDate(startDate,1),endDate) <= 0) {
                         console.log(startDate, 20)
                         console.log(endDate, 30)
                         content="此投保单的保险期超过了一年，请确认是否录入正确!";
                         }*/
                        if (!$scope.proposal.prpTmainDto.startDate || !$scope.proposal.prpTmainDto.endDate) {
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '起保日期和终保日期都不能为空！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return
                        } else if (commonApiServ.compareFullDate(endDate, newDate) <= 0) {
                            content = "终保日期<=当前日期，保险责任已经终止，请确认是否录入正确!";
                        }
                        //农险平台二期改造 加是否验标和公示 保费计算公式
                        if ((sRiskCode.substr(0, 2) == '31' || sRiskCode.substr(0, 2) == '32') && sRiskCode != "3129") {
                            var editType = $scope.proposal.editType;//编辑类型
                            if ($scope.proposal.insureMainListDto.insureListCode == "") {//对应我们自己生成的清单号码
                                content = "请录入清单投保!";
                            }
                            // 新录入投保单/复制单时都要校验, 续保/修改时不需要校验
                            // 修改投保单时只有农险二期改造险种需要校验,因为他们要重新导入清单
                            if (editType == 'NEW' || editType == 'COPY_PROPOSAL' || editType == 'COPY_POLICY' ||
                                (editType == 'UPDATE' && (checkSingleKindMultiItemAgri(sRiskCode, 'NYX_MULTIPLE_FARMER_LIST_FLAG')
                                || checkSingleKindMultiItemAgri(sRiskCode, 'NYX_SINGLE_FARMER_LIST_FLAG') ))) {
                                if (isInInsureMainList() == "Y") {
                                    content = "投保清单号已存在，请重新清理浏览器缓存";
                                }
                            }
                            if (isInInsureMainList() == "N") {
                                content = "投保清单号与险种号不匹配，请勿重复登陆系统";
                            }
                        }
                        //专门针对特困农户的单子,检查是否录入了自缴保费的特约
                        if (sRiskCode.substr(0, 2) == '31' || sRiskCode.substr(0, 2) == '32') {
                            var hasEngage = "0";
                            if (sPolicyType == 'H23' || sPolicyType == 'I27' || sPolicyType == 'E1' || sPolicyType == 'Q1') {
                                //特约信息
                                angular.forEach($scope.proposal.prpTengageDtoList, function (data, index) {
                                    if (data.clauses == "T10004") {
                                        hasEngage = "1";
                                    }
                                });
                                if (hasEngage == "0") {
                                    content = "投保方式为【团体投保---贫困户】时，必须录入代码为T10004的特别约定。";
                                }
                            }
                            hasEngage = "0";
                            if (sPolicyType != 'H23' && sPolicyType != 'I27' && sPolicyType != 'E1' && sPolicyType != 'Q1') {
                                //特约信息
                                angular.forEach($scope.proposal.prpTengageDtoList, function (data, index) {
                                    if (data.clauses == "T10004") {
                                        hasEngage = "1";
                                    }
                                });
                                if (hasEngage == "1") {
                                    content = "投保方式不为【团体投保---贫困户】时，不允许录入代码为T10004的特别约定。";
                                }
                            }
                        }
                        //3163食用菌
                        /* if(sRiskCode=='3163' && $scope.proposal.DeptName == '') {//天气指数发布
                         content = "请填写生长期赔偿标准!";
                         }
                         if(sRiskCode=='3163' && $scope.proposal.DeptAddress == '') {//天气指数发布部门地址
                         content = "请填写单位标准产量!";
                         }
                         if(sRiskCode == '3163') {
                         var SumRate = 0;
                         var SumAmount3163 = 0;
                         for(var i = 1;i < getElementCount("AgriDistributingRate");i++){
                         var SumAgriDistributingRate = parseFloat(fm.all("AgriDistributingRate")[i].value);
                         var SumAgriDistributingAmount3163 = parseFloat(fm.all("AgriTimesAmount")[i].value);
                         if(isNaN(SumAgriDistributingRate))
                         SumAgriDistributingRate = 0;
                         SumRate = SumRate + SumAgriDistributingRate;
                         if(isNaN(SumAgriDistributingAmount3163))
                         SumAgriDistributingAmount3163 = 0;
                         SumAmount3163 = SumAmount3163 + SumAgriDistributingAmount3163;
                         }

                         if(SumRate != 100){
                         alert("茬次信息中的比例之和必须等于100");
                         return false;
                         }
                         if(SumAmount3163 > fm.AmountMain[1].value || SumAmount3163 < fm.AmountMain[1].value){
                         alert("茬次信息中的保额之和必须等于投保食用菌的保额");
                         return false;
                         }
                         }*/

                        var strComCodeFlag = sComCode;
                        if (strComCodeFlag != null && strComCodeFlag.length >= 2) {
                            strComCodeFlag = strComCodeFlag.substring(0, 2);
                        }
                        // added by GYIC 李杨 20110821 养殖险能繁母猪，奶牛 加入对关联清单的验证。 End
                        if (CheckBusinessComCodeInfo(2) && businessType1 != "01" && strComCodeFlag != '41') {
                            content = "归属机构为政策性农险部时，政策/商业标志应选择“中央政策性”!";
                        }
                        if (CheckBusinessComCodeInfo(1)) {
                            content = "归属机构不可选择中支公司!";
                        }
                        //added by GYIC 李杨 20110821 养殖险能繁母猪，奶牛 加入对关联清单的验证。 Start
                        /* var breedingRiskCode = checkSingleKindMultiItemAgri(sRiskCode,'BREEDING_FARMER_LIST_FLAG');
                         if(breedingRiskCode.indexOf(sRiskCode)>-1 && sRiskCode != '3225'){
                         if(checkInsuranceCode() == false){
                         return false;
                         }
                         }
                         if(sRiskCode == '3225') {
                         var policytype3225 = fm.PolicyCategory3225.value;//养殖险才有的投保类型
                         if(policytype3225 == "44") {
                         var checkInsuranceCodeResult = checkInsuranceCode();
                         if(true != checkInsuranceCodeResult){
                         return false;
                         }
                         }
                         if(policytype3225 == "45") {
                         var code2 = fm.InsuranceCode.value;
                         if(code2 != null && code2 != "") {
                         // 农险二期平台改造:要求都要录清单,所以只能选择批次投保
                         //  alert("年出栏量投保不能录入清单，请选择批次投保,并重新单击币别确定按钮！");
                         //   return false;
                         }
                         }
                         }*/
                        //此处是3231险种开始
                        /* if(sRiskCode == '3231') {
                         if(sPolicyType != "I10" && sPolicyType != "I22" && sPolicyType != "I12" && sPolicyType != "I24" &&
                         sPolicyType != "I27" && sPolicyType != "I28") {
                         content = "请选择投保方式！";
                         }
                         if($scope.proposal.RaiseType == '0') {//养殖户类型现在没有暂时注释调
                         content = "请选择养殖方式！";
                         }
                         for(var i = 1; i <= getRowsCount("ItemKindMain"); i++) {
                         if(fm.DeductibleRateMain[i].value == null || trim(fm.DeductibleRateMain[i].value) == '') {
                         alert("请录入【主险】一栏中的绝对免赔率!");
                         return false;
                         }
                         }
                         }*/
                    }
                    //    补贴信息
                    angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                        if (!$scope.proposal.prpTsubsidyDtoList[index].subsidyDepartment) {
                            $scope.proposal.prpTsubsidyDtoList[index];
                            content = '补贴单位不能为空';
                        }
                    });
                    //茬次信息
                    if ( $scope.proposal.isSaveFlag=="1"&&($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102')) {
                        var sum = 0;
                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
                            if (isNaN(dto.distributingRate)) {
                                dto.distributingRate = 0;
                            }
                            sum += parseFloat(dto.distributingRate)
                        });
                        if (sum != 100) {
                            layer.open({
                                //offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '茬次信息中的“保险金额分布比例”之和必须等于100！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return false
                        }
                        var dateFlag = false;
                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
                            if (dto.stratDate == null || !dto.stratDate || dto.endDate == null || !dto.endDate) {
                                dateFlag = true;
                            }
                            return
                        });

                        if (dateFlag == true) {
                            layer.open({
                                //offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '茬次信息中的起止日期不可为空！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return false
                        }
                        //验证茬次保险金额不能为空或0
                        var AgriTimesAmount=0;
                        for(var i=0;i<$scope.proposal.prpTitemKindAgriDtoListCopy.length;i++) {
                            if($scope.proposal.prpTitemKindAgriDtoListCopy[i].flag && $scope.proposal.prpTitemKindAgriDtoListCopy[i].flag=="D"){
                            }else if(!$scope.proposal.prpTitemKindAgriDtoListCopy[i].flag || $scope.proposal.prpTitemKindAgriDtoListCopy[i].flag=="I") {
                                AgriTimesAmount = parseFloat($scope.proposal.prpTitemKindAgriDtoListCopy[i].timesAmount);
                                if (AgriTimesAmount == 0 || isNaN(AgriTimesAmount)) {
                                        content= "第[" + (i + 1) + "]条茬次保险金额不能为空或0!";
                                }
                            }
                        }
                    }
                    if (content != "") {
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: content,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return false;
                    } else if (!$scope.proposal.doSaveFlag && $scope.proposal.isSaveFlag == 1) {
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
                        return false;
                    }
                    return true;
                }

                $scope.relativeInsureListCode = false;//重复投保的弹框
                $scope.showDetailRelativeInsure = false;//造成重复投保的有效保单的弹框
                //校验保存的时候模板是否可用
                $scope.getModelMainInfo = function (a) {
                    $$finder.find('getPrpmmodelmainInfo', {
                        modelCode: $scope.proposal.prpTmainDto.modelCode//模板代码
                    }, {
                        success: function (data) {

                            $scope.checkModelCodeDto = data.content;
                            proposalSaveTurnData(a);//投保单号保存时每个表需要的字段
                            var result = proposalRegexData(); //投保单号保存必录字段的校验
                            if (result) {
                                if(a=='1'){//保存
                                    //保存之前进行重复性校验
                                    queryByPrpNoPrpCmainInfo();
                                }else{//暂存
                                    $scope.relationListNoLayer = false;
                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                    $scope.proposal.addEditExamine = $stateParams.addEditExamine,////区分是录入的保存还是修改的保存
                                    proposalSave();
                                }

                            }else{
                                $scope.saveTemporaryDisabled=false;
                            }
                        },
                        error: function (e) {
                        }
                    });
                }
                $scope.lookDetailRelativeInsureList = function () {
                    $scope.showDetailRelativeInsure = true;
                }
                $scope.closeDetailRelativeInsureList = function () {
                    $scope.showDetailRelativeInsure = false;
                }

                //投保单录入保存
                function proposalSave(){
                    $scope.proposal.save('proposalSave', {
                            success: function (data) {
                                $scope.saveTemporaryDisabled=false;
                                if (data.code == "0000") {
                                    if (data.content.proposalNo) {
                                        if ($scope.proposal.isSaveFlag == 1) {
                                            $scope.showSave = !$scope.showSave;
                                        }
                                        if ($scope.proposal.isSaveFlag == 0) {
                                            $scope.showSave1 = !$scope.showSave1;
                                        }
                                        $scope.proposalNo = data.content.proposalNo;
                                    }
                                } else if (data.message) {
                                    layer.open({
                                        //offset: ['35%', '31%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: data.message,
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                } else {
                                    var content = "";
                                    content = "保存失败";
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
                                }

                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                }
                //关闭重复性校验弹框
                $scope.closeRelativeInsureListCode = function () {
                    $scope.saveTemporaryDisabled=false;
                    $scope.relativeInsureListCode = false;
                    $("html,body").css({overflow: "auto"});//出现滚动条
                }
                $scope.goRelativeInsureListCode = function () {
                    $scope.relativeInsureListCode = false;
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $scope.proposal.addEditExamine = $stateParams.addEditExamine;////区分是录入的保存还是修改的保存
                    if (!$scope.hebaoFlag) {
                        proposalSave();
                    } else {
                        $$finder.find('submitUndwrtByProposal', {
                            "proposalno": [$scope.proposal.prpTmainDto.proposalNo],//保单号//国元的proposalno
                            "userCode": $rootScope.user.userCode,//用户编号//
                            "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                        }, {
                            success: function (data) {
                                var content;
                                if (data.code == "0000") {
                                    content = data.content[0];
                                } else {
                                    content =data.message;
                                }
                                if (content) {
                                    layer.open({
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '提交核保',
                                        scrollbar: false,
                                        content: content,
                                        btn: ['再录一单', '返回主页']
                                        , btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            $("html,body").css({overflow: "auto"});//出现滚动条
                                            $state.go("UIproposal3107edit", {}, {reload: true});
                                            //$state.reload('UIproposal3107edit');
                                            layer.close(index);
                                        }
                                        , btn2: function (index, layero) {
                                            //按钮【按钮二】的回调
                                            $("html,body").css({overflow: "auto"});//出现滚动条
                                            $state.go('dashboard');
                                            //return false 开启该代码可禁止点击该按钮关闭
                                        }
                                    });
                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }
                }
                $scope.getPolicyInfo = function (policyNo) {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    //$state.go('UIPolicy3107show',{'policyNo':policyNo});
                    var url = $state.href('UIPolicy3107show', {'policyNo': policyNo,authSystemFlag:'claim'});
                    window.open(url, "_blank");
                }
                var queryByPrpNoPrpCmainInfo = function () {
                    $$finder.find('queryByPrpNoPrpCmainInfo', {
                        gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode,
                        "startDate": $scope.proposal.prpTmainDto.startDate,
                        'endDate': $scope.proposal.prpTmainDto.endDate,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "businessType1": $scope.proposal.prpTmainDto.businessType1,
                        pageNo: $scope.paginationConfmm4.currentPage,
                        pageSize: $scope.paginationConfmm4.itemsPerPage
                    }, {
                        success: function (data) {
                            console.log(data);
                            if (data.code == '0000' && data.content.content.length > 0) {
                                $scope.relativeInsureListCode = true;
                                $("html,body").css({overflow: "hidden"});//隐藏滚动条
                                $scope.detailRelativeInsureList = data.content.content;
                                $scope.paginationConfmm4.totalItems = data.content.totalCount;
                            } else if (data.code == '9999') {
                                layer.open({
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: data.message,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                })
                            } else {
                                $scope.relationListNoLayer = false;
                                $("html,body").css({overflow: "auto"});//出现滚动条
                                $scope.proposal.addEditExamine = $stateParams.addEditExamine,////区分是录入的保存还是修改的保存
                                    proposalSave();
                            }
                        }
                    })
                }
                var indexPage3 = function () {
                    $scope.paginationConfmm4 = {
                        currentPage: 1,//当前页
                        totalItems: 0,//总条数
                        itemsPerPage: 20,//每页条数
                        pagesLength: 5,//总页数
                        perPageOptions: [5, 10, 20, 50],
                        onChange: function () {
                            $$finder.find('queryByPrpNoPrpCmainInfo', {
                                gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode,
                                "startDate": $scope.proposal.prpTmainDto.startDate,
                                'endDate': $scope.proposal.prpTmainDto.endDate,
                                "riskCode": $scope.proposal.prpTmainDto.riskCode,
                                "businessType1": $scope.proposal.prpTmainDto.businessType1,
                                pageNo: $scope.paginationConfmm4.currentPage,
                                pageSize: $scope.paginationConfmm4.itemsPerPage
                            }, {
                                success: function (data) {
                                    console.log(data);
                                    if (data.code == '0000' && data.content.content.length > 0) {
                                        $scope.relativeInsureListCode = true;
                                        $("html,body").css({overflow: "hidden"});//隐藏滚动条
                                        $scope.detailRelativeInsureList = data.content.content;
                                        $scope.paginationConfmm4.totalItems = data.content.totalCount;
                                    } else if (data.code == '9999') {
                                        layer.open({
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: data.message,
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            },
                                        })
                                    }
                                }
                            })
                        }
                    }
                };
                indexPage3();
                //投保单录入保存
                $scope.showSaveSuccess = function (a) {
                    $scope.saveTemporaryDisabled=true;
                    var result = "";
                    //校验条款是否可用
                    $$finder.find('getPrpDclauseCodeInfo', {
                        clauseCode: $scope.proposal.prpTmainDto.versionNo//条款代码
                    }, {
                        success: function (data) {
                            $scope.checkClauseCodeDto = data.content;
                            $scope.getModelMainInfo(a);

                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });

                };
                //保存关闭按钮
                $scope.closeShowSave = function () {
                    $scope.showSave = !$scope.showSave;
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go("UIproposal3107edit", {}, {reload: true});
                };
                //获取保单信息
                $scope.queryPolicyInfo = function (data, flag) {
                    var _data = data.content;
                    var obj = {};
                    var copyPolicy = $scope.proposal.editType;
                    angular.forEach(_data, function (data, index) {
                        var n = index.replace(/prpC/, 'prpT');
                        obj[n] = data;
                    });
                    console.log("objStart");
                    console.log(obj);
                    console.log("objEnd");
                    //$scope.proposal.appliInsuredDto = obj.appliInsuredDto;
                    $scope.proposal.articleTypeNameList = obj.articleTypeNameList
                    $scope.proposal.businessNatureNameList = obj.businessNatureNameList
                    $scope.proposal.businessTypeNameList = obj.businessTypeNameList
                    $scope.proposal.businessTypeNameList1 = obj.businessTypeNameList1
                    $scope.proposal.cattleTypeNameList = obj.cattleTypeNameList
                    $scope.proposal.editType = obj.editType
                    $scope.proposal.editTypeName = obj.editTypeName
                    $scope.proposal.engageQueryClause = obj.engageQueryClause
                    $scope.proposal.gisInsureListDto = obj.gisInsureListDto
                    $scope.proposal.insureListCode = obj.insureListCode
                    $scope.proposal.insureMainListDto = obj.insureMainListDto
                    $scope.proposal.insurePreliminaryConfirmDto = obj.insurePreliminaryConfirmDto
                    //$scope.proposal.insuredDto = obj.insuredDto
                    $scope.proposal.languageNameList = obj.languageNameList
                    $scope.proposal.listTypeFlag = obj.listTypeFlag
                    $scope.proposal.policySortNameList = obj.policySortNameList
                    $scope.proposal.prpTaddressDto = obj.prpTaddressDto
                    $scope.proposal.prpTaddressDtoList = obj.prpTaddressDtoList
                    $scope.proposal.prpTcoinsDetailDtoList = obj.prpTcoinsDetailDtoList
                    $scope.proposal.prpTcoinsDtoList = obj.prpTcoinsDtoList
                    $scope.proposal.prpTengageDtoCopy = obj.prpTengageDtoCopy
                    $scope.proposal.prpTengageDtoList = obj.prpTengageDtoList
                    $scope.proposal.prpTfeeDto = obj.prpTfeeDto
                    $scope.proposal.prpTfeeDtoList = obj.prpTfeeDtoList
                    $scope.proposal.prpTfeildDtoList = obj.prpTfeildDtoList
                    $scope.proposal.prpTinsuredDtoList = obj.prpTinsuredDtoList
                    $scope.proposal.prpTitemKindAgriDtoList = obj.prpTitemKindAgriDtoList
                    $scope.proposal.prpTitemKindDtoList = obj.prpTitemKindDtoList
                    $scope.proposal.prpTmainAgriDto = obj.prpTmainAgriDto
                    $scope.proposal.prpTmainDto = obj.prpTmainDto
                    $scope.proposal.prpTplanCoinsDtoList = obj.prpTplanCoinsDtoList
                    $scope.proposal.prpTplanDtoList = obj.prpTplanDtoList
                    $scope.proposal.prpTsubsidyDtoList = obj.prpTsubsidyDtoList
                    $scope.proposal.queryProposalPrpTengageDtoList = obj.queryProposalPrpTengageDtoList
                    $scope.proposal.raiseTypeNameList = obj.raiseTypeNameList
                    $scope.proposal.riskCodeNameList = obj.riskCodeNameList
                    $scope.proposal.statUnitCodeNameList = obj.statUnitCodeNameList

                    $scope.proposal.prpTmainAgriDto.relationListNoRemark = '';
                    $scope.proposal.insureMainListDto = {};
                    //核保状态初始化
                    $scope.proposal.prpTmainDto.underwriteFlag = '0';
                    //时间格式转换
                    $scope.proposal.prpTmainDto.startDate = msTodata($scope.proposal.prpTmainDto.startDate)
                    $scope.proposal.prpTmainDto.endDate = msTodata($scope.proposal.prpTmainDto.endDate)
                    $scope.proposal.prpTmainDto.operateDate = msTodata($scope.proposal.prpTmainDto.operateDate);
                    //业务大类
                    $scope.parameterConvert.businessCategoryInit();
                    $scope.proposal.prpTmainDto.contractType = $scope.proposal.prpTmainDto.argueSolution;//合同争议解决方式

                    if (flag != "copy") {//不是复制保单与续保
                        //客户信息
                        if ($scope.proposal.prpTinsuredDtoList[0].insuredFlag == '2') {
                            $scope.proposal.appliInsuredDto = $scope.proposal.prpTinsuredDtoList[0];//客户信息中的投保人信息
                            $scope.proposal.insuredDto = $scope.proposal.prpTinsuredDtoList[1]
                        } else {
                            $scope.proposal.appliInsuredDto = $scope.proposal.prpTinsuredDtoList[1];//客户信息中的投保人信息
                            $scope.proposal.insuredDto = $scope.proposal.prpTinsuredDtoList[0]
                        }
                        //客户信息中被保险人中的  同投保人选择按钮
                        $scope.proposal.appliInsuredDto.insuredCode == $scope.proposal.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                        $scope.proposal.insureMainListDto.insureListCode = obj.insureListCode;
                        //客户信息insuredDto
                        $scope.getIdentity($scope.proposal.appliInsuredDto.insuredType, $scope.proposal.appliInsuredDto.identifyType);
                        $scope.getIdentity($scope.proposal.insuredDto.insuredType, $scope.proposal.insuredDto.identifyType);
                        //发票购货方信息  选择同投保人、被投保人
                        $scope.proposal.prpDcustomerTaxPayInfoDto = obj.prpDcustomerTaxPayInfoDto
                        if (obj.prpDcustomerTaxPayInfoDto.payInfoObject == "1") {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                        } else if (obj.prpDcustomerTaxPayInfoDto.payInfoObject == "2") {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2";
                        } else {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }
                        //不是复制保单与续保 操作时间、修改时间带出
                        $scope.proposal.prpTmainDto.inputDate = msTodata($scope.proposal.prpTmainDto.inputDate);
                        $scope.proposal.prpTmainDto.updateDate = msTodata($scope.proposal.prpTmainDto.updateDate);
                        $scope.proposal.prpTmainDto.signDate = msTodata($scope.proposal.prpTmainDto.signDate);
                    } else {
                        var currentDate = commonApiServ.getCurrentDate();
                        $scope.proposal.prpTmainDto.signDate=currentDate;
                        $scope.proposal.prpTmainDto.inputDate = currentDate;
                        $scope.proposal.prpTmainDto.updateDate = currentDate;
                        $scope.proposal.prpTmainDto.policyNo = '';//复制保单与续保页面得保单号不该带出
                        $scope.proposal.prpTmainDto.printNo = "";
                        $scope.proposal.prpTmainDto.othFlag='000000YY000000000000';//复制保单将othflag置为默认值
                    }
                    $scope.proposal.prpTmainDto.policySort = '0';//基本信息（不完全）
                    if ($scope.proposal.prpTmainDto.othFlag.substring(0, 1) == '0') {
                        $scope.proposal.editTypeName = '新保';
                    } else if ($scope.proposal.prpTmainDto.othFlag.substring(0, 1) == '1') {
                        $scope.proposal.editTypeName = '续保'
                    }
                    if ($scope.proposal.prpTaddressDtoList) {
                        $scope.proposal.prpTaddressDto = $scope.proposal.prpTaddressDtoList[0];
                    }
                    //标的清单列表
                    if (copyPolicy == 'COPY_POLICY' || copyPolicy == 'RENEWAL') {
                        $$finder.find('queryMarkedList', {
                            // "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode,//金禾清单号
                            "insureListCode": _data.gisInsureListDto.gisInsureMainListDto.insureListCode,
                            "serialNo": _data.gisInsureListDto.gisInsureMainListDto.serialNo//标的清单序号
                        }, {
                            success: function (data) {
                                console.log(data)
                                $scope.queryMarkedList = data.content
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                        if (flag == 'Edit') {//投保单修改时我方清单带出赋值
                            $scope.proposal.prpTmainAgriDto.relationListNo = _data.contractinfoDto.insureListCode;
                            //保费计算中的费率除数
                            $$finder.find('queryByRiskCode', {
                                riskCode: $scope.proposal.prpTmainDto.riskCode,//险种
                            }, {
                                success: function (data) {
                                    $scope.rateDivisor = data.content;
                                    $scope.getrateDivisor($scope.rateDivisor)
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        }
                        //$scope.proposal.insureMainListDto.insureListCode=_data.insureListCode;//金禾清单号
                        $scope.proposal.insureMainListDto.serialNo = _data.gisInsureListDto.gisInsureMainListDto.serialNo;

                        $scope.proposal.renewalEndTime = $scope.proposal.prpTmainDto.endDate;//取保单时间，续保保险期间判断使用
                        //$scope.proposal.appliInsuredDto.BusinessSort=_data.customerDto.appliInsuredDto.businessSort;//公司性质
                        //$scope.proposal.insuredDto.BusinessSort = _data.customerDto.insuredDto.businessSort;//公司性质
                    } else {
                        $scope.disabledContent=false;
                        $scope.proposal.prpTmainDto.policyNo = '';//复制投保单时保单号不该带到页面
                    }
                    $scope.proposal.prpTmainDto.businessProvinceName = _data.gisInsureListDto.gisInsureMainListDto.fProvinceName;//归属区域:省
                    $scope.proposal.prpTmainDto.businessCityName = _data.gisInsureListDto.gisInsureMainListDto.fCityName;//归属区域:市
                    $scope.proposal.prpTmainDto.businessCountyName = _data.gisInsureListDto.gisInsureMainListDto.fCountyName;//归属区域:区/县
                    $scope.proposal.prpTmainDto.businessTownName = _data.gisInsureListDto.gisInsureMainListDto.fTownName;//归属区域:镇
                    $scope.proposal.prpTmainDto.businessAreaName = _data.gisInsureListDto.gisInsureMainListDto.fVillageName;//归属区域:村
                    $scope.proposal.prpTmainDto.className = $scope.proposal.prpTmainDto.classCodeName;
                    if ($scope.proposal.listTypeFlag == "D") {
                        $scope.proposal.insureMainListDto.listTypeFlag = "大户";
                    }
                    if ($scope.proposal.listTypeFlag == "S") {
                        $scope.proposal.insureMainListDto.listTypeFlag = "散户";
                    }
                    //缴费计划
                    angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                        if (data.payReason === 'R10') {
                            data.payReasonName = '签单收保费';
                        } else if (data.payReason === 'R20') {
                            data.payReasonName = '分期收保费'
                        } else if (data.payReason === 'RS3') {
                            data.payReasonName = '中央财政'
                        } else if (data.payReason === 'RS4') {
                            data.payReasonName = '省级财政'
                        } else if (data.payReason === 'RS5') {
                            data.payReasonName = '地市财政'
                        } else if (data.payReason === 'RS6') {
                            data.payReasonName = '其他来源'
                        } else if (data.payReason === 'RS7') {
                            data.payReasonName = '县(区)财政'
                        }
                    });
                    //----------------------------------页面个性化开始----------------------------------------------------
                    if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.isAgriUnitCostMain = false;//隐藏单位生产成本
                        $scope.isProportion = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                        $rootScope.isTrue();
                    }
                    //赔付明细
                    $scope.isTriggerPoint = false;
                    $scope.isTotalLossRatio = false;
                    if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                        || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                        || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3134'
                        || $scope.proposal.prpTmainDto.riskCode == '3147' || $scope.proposal.prpTmainDto.riskCode == '3141' ||
                        $scope.proposal.prpTmainDto.riskCode == '3129' || $scope.proposal.prpTmainDto.riskCode == '3102'
                        ||$scope.proposal.prpTmainDto.riskCode == '3101'||$scope.proposal.prpTmainDto.riskCode == '3114'
						||$scope.proposal.prpTmainDto.riskCode == '3122'||$scope.proposal.prpTmainDto.riskCode == '3126'
						||$scope.proposal.prpTmainDto.riskCode == '3161'||$scope.proposal.prpTmainDto.riskCode == '3149') {
                        //显示起赔点、全损损失率
                        $scope.isTriggerPoint = true;
                        $scope.isTotalLossRatio = true;
                    }
                    //种植方式
                    $scope.isRaiseType = false;
                    $scope.isProposalType = false;
                    if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                        || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                        || $scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102'
                        ||$scope.proposal.prpTmainDto.riskCode == '3101'||$scope.proposal.prpTmainDto.riskCode == '3114'
						||$scope.proposal.prpTmainDto.riskCode == '3122'||$scope.proposal.prpTmainDto.riskCode == '3126'
						||$scope.proposal.prpTmainDto.riskCode == '3161'||$scope.proposal.prpTmainDto.riskCode == '3149') {
                        $scope.isProposalType = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.isRaiseType = true;
                        $scope.isRaiseDate = false;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3237') {
                        $scope.isIndemnity = true;
                        $scope.isRaiseDate = true;
                        $scope.isAgriUnitCostMain = true;
                    }
                    //------------------------------------页面个性化结束------------------------------------------------
                    if ($scope.proposal.prpTmainDto.riskCode == '3224' || $scope.proposal.prpTmainDto.riskCode == '3237') {
                        $scope.trRaiseName = "养殖时间";
                        $scope.addressTitle = "养殖地点";
                        $scope.isTriggerPoint = true;
                        $scope.isTotalLossRatio = true;
                    } else if ($scope.proposal.prpTmainDto.riskCode == '3233') {
                        $scope.trRaiseName = "养殖时间";
                        $scope.addressTitle = "养殖地点";
                    } else {
                        $scope.trRaiseName = "种植时间";
                        $scope.addressTitle = "种植地点";
                    }

                    //茬次信息赋值
                    var prpTitemKindAgriDtoListCopy = []
                    if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                        || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                        angular.forEach(obj.prpTitemKindAgriDtoList, function (_data) {
                            if ((_data.distributingRate != null && _data.distributingRate != undefined)
                                && (_data.timesAmount != null && _data.timesAmount != undefined)
                                && (_data.stratDate != null && _data.stratDate != undefined)
                                && (_data.endDate != null && _data.endDate != undefined)) {
                                _data.stratDate = "";
                                _data.endDate = "";
                                _data.timesAmount=round(_data.timesAmount,2);
                                prpTitemKindAgriDtoListCopy.push(_data);
                            }
                        });
                        $scope.proposal.prpTitemKindAgriDtoListCopy = prpTitemKindAgriDtoListCopy;
                    }
                    //获取一下
                    //种植地址BUG
                    //$scope.proposal.insureMainListDto=$scope.proposal.insureMainListDto||{}
                    //$scope.proposal.prpTmainAgriDto.relationListNoRemark=obj.insurePreliminaryConfirmDto.gisInsureMainListDto.remark//清单备注
                    //$scope.proposal.insureMainListDto.insureListCode=obj.insurePreliminaryConfirmDto.gisInsureMainListDto.insureListCode//清单号
                    //$scope.proposal.insureMainListDto.listTypeFlag=obj.insurePreliminaryConfirmDto.gisInsureMainListDto.listTypeFlag=='P'?'投保单':'批单'//清单类型
                    //$scope.proposal.prpTaddressDto=obj.prpTaddressDtoList[0];//种植地址
                    //$scope.proposal.prpTaddressDto.addressName=$scope.proposal.prpTaddressDto.addressName.replace(/-undefined$/,'')
                    $scope.proposal.prpTplanDtoList = obj.prpTplanDtoList;//缴费计划（不完全）
                    angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                        if (data.payReason == 'R10') {
                            data.payReasonName = '签单收保费'
                        }
                        if (data.payReason == 'R20') {
                            data.payReasonName = '分期收保费'
                        }
                        data.payreFee = data.planFee - data.delinquentFee
                        if (!isNaN(data.planDate)) {
                            data.planDate = $filter('date')(data.planDate, 'yyyy-MM-dd');
                            data.planStartDate = $filter('date')(data.planStartDate, 'yyyy-MM-dd');
                        }
                    })
                    $scope.proposal.prpTfeeDto = obj.prpTfeeDtoList[0];//币别信息
                    $scope.proposal.prpTfeeDto.amount=round($scope.proposal.prpTfeeDto.amount,2);
                    $scope.proposal.prpTfeeDto.premium=round($scope.proposal.prpTfeeDto.premium,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium=round($scope.proposal.prpTfeeDto.noTaxPremium,2);
                    $scope.proposal.prpTfeeDto.taxFee=round($scope.proposal.prpTfeeDto.taxFee,2);
                    $scope.proposal.prpTfeeDto.amount2=round($scope.proposal.prpTfeeDto.amount2,2);
                    $scope.proposal.prpTfeeDto.premium2=round($scope.proposal.prpTfeeDto.premium2 ,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium2=round($scope.proposal.prpTfeeDto.noTaxPremium2,2);
                    $scope.proposal.prpTfeeDto.taxFee2=round($scope.proposal.prpTfeeDto.taxFee2,2);
                    $scope.proposal.prpTfeeDto.amount1=round($scope.proposal.prpTfeeDto.amount1,2);
                    $scope.proposal.prpTfeeDto.premium1=round($scope.proposal.prpTfeeDto.premium1,2);
                    $scope.proposal.prpTfeeDto.noTaxPremium1=round($scope.proposal.prpTfeeDto.noTaxPremium1,2);
                    $scope.proposal.prpTfeeDto.taxFee1=round($scope.proposal.prpTfeeDto.taxFee1,2);
                    $scope.proposal.prpTfeeDto.currency2Name = obj.prpTfeeDtoList[0].feeCurrencyName2;//支付币别保额
                    //特约及附加信息
                    var prpTengageList = [];
                    angular.forEach(obj.queryProposalPrpTengageDtoList, function (_data) {
                        if (_data.clauseCode != "TX001" && _data.clauseCode != "TX004") {
                            var obj1 = {
                                clauses: "",
                                clauseCode: "",
                                clausesContent: ""
                            }
                                obj1.clauses = _data.clauseName,//特约名称
                                obj1.clauseCode = _data.clauseCode,//特约代码
                                obj1.clausesContent = _data.clausesContent//特约内容
                                prpTengageList.push(obj1)
                        }
                    });
                    $scope.proposal.prpTengageDtoCopy = prpTengageList;
                    $scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
                    angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
                        if (data.clauseCode == 'TX001') {
                            $scope.proposal.engageQueryClause.absuDedu = $scope.proposal.prpTengageDtoCopy.splice(index, 1)[0].clausesContent;
                        }

                    })
                    $scope.totalAmount = $scope.proposal.prpTmainDto.sumAmount;
                    $scope.totalPay = $scope.proposal.prpTmainDto.sumPremium;
                    angular.forEach(obj.prpTitemKindDtoList, function (data, index) {
                        //$scope.proposal.prpTitemKindDtoList[index].radioType = data.flag == 1 ? 'Y' : 'N';
                        data.shortRate=round(data.shortRate,2);
                        data.amount=round(data.amount,2);
                        data.premium=round(data.premium,2)
                        data.unitPremium=round(data.unitPremium,2)
                        data.radioType = data.calculateFlag;
                        if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                            data.agriUnitCostMaintitle = '何价投保';
                            data.unitCostName = '元/头';
                            data.proportionName = '%';
                            data.untilName = "元";
                            data.untilName1 = '头';
                            data.untilKindName = "投保头数";
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                            || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                            || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3129'
                            || $scope.proposal.prpTmainDto.riskCode == '3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
							|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
							|| $scope.proposal.prpTmainDto.riskCode=='3161'||$scope.proposal.prpTmainDto.riskCode == '3149') {
                            data.agriUnitCostMaintitle = '单位生产成本';
                            data.unitCostName = '元';
                            data.untilKindName = "投保面积";
                            data.agriUnitOutputMaintitle = "单位保险产量";
                            data.agriUnitOutputMainName = "公斤";
                            $scope.untilName = "元/亩";//单位名称
                            $scope.untilName1 = '亩';
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3224') {
                            data.untilKindName = "投保面积";
                            data.agriUnitCostMaintitle = '单位保险产量';
                            data.unitCostName = '斤';
                            data.agriUnitOutputMainName = "斤";
                            data.untilName = "元/亩";//单位名称
                            data.untilName1 = '亩';
                        } else if ($scope.proposal.prpTmainDto.riskCode == '3237' || $scope.proposal.prpTmainDto.riskCode == '3134'
                            || $scope.proposal.prpTmainDto.riskCode == '3147' || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            data.untilName = "元/亩";
                            data.untilKindName = "投保面积";
                            data.untilName1 = '亩';
                        }
                        angular.forEach(obj.prpTitemKindAgriDtoList, function (_data, _index) {
                            if (data.itemKindNo == _data.itemKindNo) {
                                data.agriGrossQuantityMain = _data.grossQuantity;
                                data.agriUnitOutputMain = _data.unitOutput;
                                data.agriTimesAmount = _data.timesAmount;
                                data.agriUnitCostMain = _data.unitCost;
                                data.proportion = _data.proportion;
                                data.agriStartDate = _data.stratDate;
                                data.agriEndDate = _data.endDate;
                            }
                        })
                    });
                    //共保信息
                    if ($scope.proposal.prpTplanCoinsDtoList && $scope.proposal.prpTplanCoinsDtoList.length > 0
                        && $scope.proposal.prpTcoinsDetailDtoList && $scope.proposal.prpTcoinsDetailDtoList.length > 0
                        && $scope.proposal.prpTplanCoinsDtoList.length > 0) {
                        $scope.PremiumShow = true;
                        $scope.showCoins = false;
                        $scope.isHide = false;
                        $scope.proposal.otherAgentFeeShow = false;
                        $scope.proposal.showCoinsInfo();//显示共保信息
                    }
                    //归属机构
                    $scope.getComCodeList();
                    //归属业务员
                    $scope.getHanCode({comCName: $scope.proposal.prpTmainDto.comCName}, $scope.proposal.prpTmainDto.handler1Code);
                    //$scope.createRiskCode();//保费计算中的费率除数                    //投保方式
                    $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, obj.prpTmainDto.policyType);//投保方式下拉初始化获取
                };
                //提交核保
                $scope.hebaoFlag = "";
                $scope.commitUnderwrite = function (key, type) {
                    $scope.hebaoFlag = type;
                    $$finder.find('queryByPrpNoPrpCmainInfo', {
                        gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode,
                        "startDate": $scope.proposal.prpTmainDto.startDate,
                        'endDate': $scope.proposal.prpTmainDto.endDate,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "businessType1": $scope.proposal.prpTmainDto.businessType1,
                        pageNo: $scope.paginationConfmm4.currentPage,
                        pageSize: $scope.paginationConfmm4.itemsPerPage
                    }, {
                        success: function (data) {
                            if (data.code == '0000' && data.content.content.length > 0) {
                                $scope.relativeInsureListCode = true;
                                $("html,body").css({overflow: "hidden"});//隐藏滚动条
                                $scope.detailRelativeInsureList = data.content.content;
                                $scope.paginationConfmm4.totalItems = data.content.totalCount;
                            } else if (data.code == '9999') {
                                layer.open({
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: data.message,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                })
                            } else {
                                $scope.showSave = !$scope.showSave;
                                $$finder.find('submitUndwrtByProposal', {
                                    "proposalno": [key],//保单号//国元的proposalno
                                    "userCode": $rootScope.user.userCode,//用户编号//
                                    "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                                }, {
                                    success: function (data) {
                                        var content;
                                        if (data.code == "0000") {
                                            content = data.content[0];
                                        } else {
                                            content = data.message;
                                        }
                                        if (content) {
                                            layer.open({
                                                skin: 'large-layer-content',
                                                closeBtn: 0,
                                                title: '提交核保',
                                                scrollbar: false,
                                                content: content,
                                                btn: ['再录一单', '返回主页']
                                                , btn1: function (index, layero) {
                                                    //按钮【按钮一】的回调
                                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                                    $state.go("UIproposal3107edit", {}, {reload: true});
                                                    //$state.reload('UIproposal3107edit');
                                                    layer.close(index);
                                                }
                                                , btn2: function (index, layero) {
                                                    //按钮【按钮二】的回调
                                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                                    $state.go('dashboard');
                                                    //return false 开启该代码可禁止点击该按钮关闭
                                                }
                                            });
                                        }
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                            }
                        }
                    })

                }
                //投保单录入页面的提交核保按钮
                /* $scope.underSubmit = function () {
                 var proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                 $$finder.find('submitUndwrtByProposal', {
                 "proposalno":[$scope.proposal.prpTmainDto.proposalNo],//保单号//国元的proposalno
                 "userCode":$rootScope.user.userCode,//用户编号//
                 "DLComCode":$rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                 }, {
                 success: function (data) {
                 var content;
                 if (data.code == "0000") {
                 content = data.content[0];
                 } else {
                 content = "提交核保失败！"//data.message;
                 }
                 if (content) {
                 layer.open({
                 area: ['37%', '318px'],
                 //offset: ['28%', '30%'],
                 skin: 'large-layer-content',
                 scrollbar: false,
                 closeBtn: 0,
                 title: '提交核保',
                 content: content,
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
                 }
                 },
                 error: function (e) {
                 options.error(e);
                 }
                 });
                 }*/
                //投保单录入页面的提交核保按钮
                $scope.underSubmit = function () {
                    $$finder.find('queryByPrpNoPrpCmainInfo', {
                        gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode,
                        "startDate": $scope.proposal.prpTmainDto.startDate,
                        'endDate': $scope.proposal.prpTmainDto.endDate,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "businessType1": $scope.proposal.prpTmainDto.businessType1,
                        pageNo: $scope.paginationConfmm4.currentPage,
                        pageSize: $scope.paginationConfmm4.itemsPerPage
                    }, {
                        success: function (data) {
                            if (data.code == '0000' && data.content.content.length > 0) {
                                $scope.relativeInsureListCode = true;
                                $("html,body").css({overflow: "hidden"});//隐藏滚动条
                                $scope.detailRelativeInsureList = data.content.content;
                                $scope.paginationConfmm4.totalItems = data.content.totalCount;
                            } else if (data.code == '9999') {
                                layer.open({
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: data.message,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                })
                            } else {
                                var proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                                $$finder.find('submitUndwrtByProposal', {
                                    "proposalno": [$scope.proposal.prpTmainDto.proposalNo],//保单号//国元的proposalno
                                    "userCode": $rootScope.user.userCode,//用户编号//
                                    "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                                }, {
                                    success: function (data) {
                                        var content;
                                        if (data.code == "0000") {
                                            content = data.content[0];
                                        } else {
                                            content = data.message;
                                        }
                                        if (content) {
                                            layer.open({
                                                area: ['37%', '318px'],
                                                //offset: ['28%', '30%'],
                                                skin: 'large-layer-content',
                                                scrollbar: false,
                                                closeBtn: 0,
                                                title: '提交核保',
                                                content: content,
                                                btn: ['再录一单', '返回主页']
                                                , btn1: function (index, layero) {
                                                    //按钮【按钮一】的回调
                                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                                    $state.go("UIproposal3107edit", {}, {reload: true});
                                                    //$state.reload('UIproposal3107edit');
                                                    layer.close(index);
                                                }
                                                , btn2: function (index, layero) {
                                                    //按钮【按钮二】的回调
                                                    $("html,body").css({overflow: "auto"});//出现滚动条
                                                    $state.go('dashboard');
                                                    //return false 开启该代码可禁止点击该按钮关闭
                                                }
                                            });
                                        }
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                            }
                        }
                    })

                }
                //核保详情查询
                $scope.getViewTrace = function () {
                    $$finder.find('getViewTrace', {//getViewTrace这个是国元的
                        "proposalNo": $scope.proposal.prpTmainDto.proposalNo//投保单号
                    }, {
                        success: function (data) {
                            //
                            if (data.content.length > 0) {
                                $scope.examineList = data.content;
                                $scope.policyInfo = true;
                                $("html,body").css({overflow: "hidden"});//隐藏滚动条
                            } else {
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '未查询到核保信息',
                                    scrollbar: false,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
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

                //上传影像
                $scope.upLoading = function () {
                    console.log("影像上传");
                    $$finder.find("transportXML", {
                        "businessNo": $scope.proposal.prpTmainDto.proposalNo,
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
                        "businessNo": $scope.proposal.prpTmainDto.proposalNo, //业务单号
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
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                };

                //关闭详情
                $scope.closepolicyInfoShow = function () {
                    $scope.policyInfo = false;
                    $("html,body").css({overflow: "auto"});//显示滚动条
                }
                //分户清单下载按钮
                $scope.PlantingExcelDto = {}
                $scope.DownLoadButton = function () {
                    $scope.PlantingExcelDto.inusreListCode = $scope.proposal.prpTmainAgriDto.relationListNo;
                    $scope.PlantingExcelDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
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
                //继续完善按钮
                $scope.resetRisk = function () {
                    $scope.continue = true;
                    $scope.showSave = false;
                    //保存成功后点击继续完善按钮到页面可以点击提交核保按钮
                    $scope.underSubmitHide = false;
                }
                //再录一单
                $scope.issueAgain = function () {
                    $state.go("UIproposal3107edit", {}, {reload: true});
                }
                //投保单暂存的返回按钮
                $scope.goBackDashboard = function () {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                    $state.go('dashboard')
                }
                $scope.resetRisk1 = function () {
                    $scope.showSave1 = false;
                    //保存成功后点击继续完善按钮到页面可以点击提交核保按钮
                    $scope.underSubmitHide = false;
                }
                //显示编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
                $scope.queryHide = true;
                $scope.getreserve1 = function (index, data) {
                    $scope.clauseCode = data.clauseCode
                }
                //俩个日期比较大小的方法
                function compareFullDate(date1, date2) {
                    var strValue1 = date1.split("-");
                    var date1Temp = new Date(strValue1[0], parseInt(strValue1[1], 10) - 1, parseInt(strValue1[2], 10));
                    var strValue2 = date2.split("-");
                    var date2Temp = new Date(strValue2[0], parseInt(strValue2[1], 10) - 1, parseInt(strValue2[2], 10));
                    if (date1Temp.getTime() == date2Temp.getTime())
                        return 0;
                    else if (date1Temp.getTime() > date2Temp.getTime())
                        return 1;
                    else
                        return -1;
                }

                //得到下n个年
                function getNextYearFullDate(strDate, intCount) {
                    var strValue = strDate.split("-");
                    var tempDate = new Date(strValue[0], parseInt(strValue[1], 10) - 1, parseInt(strValue[2], 10));
                    tempDate.setFullYear(tempDate.getFullYear() + intCount);
                    var year = tempDate.getFullYear();
                    var month = tempDate.getMonth() + 1;
                    var day = tempDate.getDate();
                    if (month < 10) {
                        month = "0" + month;
                    }
                    if (day < 10) {
                        day = "0" + day;
                    }
                    var strReturn = year + "-" + month + "-" + day;
                    return strReturn;
                }

                //投保方式初始化
                $scope.policyType = {};
            }]);
    function prpTfeeDtoFun() {
        $scope.proposal.prpTfeeDto.amount=round($scope.proposal.prpTfeeDto.amount,2);
        $scope.proposal.prpTfeeDto.premium=round($scope.proposal.prpTfeeDto.premium,2);
        $scope.proposal.prpTfeeDto.noTaxPremium=round($scope.proposal.prpTfeeDto.noTaxPremium,2);
        $scope.proposal.prpTfeeDto.taxFee=round($scope.proposal.prpTfeeDto.taxFee,2);
        $scope.proposal.prpTfeeDto.amount2=round($scope.proposal.prpTfeeDto.amount2,2);
        $scope.proposal.prpTfeeDto.premium2=round($scope.proposal.prpTfeeDto.premium2 ,2);
        $scope.proposal.prpTfeeDto.noTaxPremium2=round($scope.proposal.prpTfeeDto.noTaxPremium2,2);
        $scope.proposal.prpTfeeDto.taxFee2=round($scope.proposal.prpTfeeDto.taxFee2,2);
        $scope.proposal.prpTfeeDto.amount1=round($scope.proposal.prpTfeeDto.amount1,2);
        $scope.proposal.prpTfeeDto.premium1=round($scope.proposal.prpTfeeDto.premium1,2);
        $scope.proposal.prpTfeeDto.noTaxPremium1=round($scope.proposal.prpTfeeDto.noTaxPremium1,2);
        $scope.proposal.prpTfeeDto.taxFee1=round($scope.proposal.prpTfeeDto.taxFee1,2);
    }

    //对数字四舍五入
    //数值,精度
    function round(number, precision) {
        if (isNaN(number))
            number = 0;
        var prec = Math.pow(10, precision);
        var result = Math.round(number * prec);
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

})