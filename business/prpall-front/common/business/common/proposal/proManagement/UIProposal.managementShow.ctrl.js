/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
	'app',
	'constants',
	'layer'
], function (app) {
	'use strict';
	app.registerController('UIProposalshowCtrl', ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$$cherry', '$$finder', '$state', '$$code', 'commonApiServ', '$$proposalAPI', '$stateParams', '$filter',
		function ($rootScope, $scope, $http, $anchorScroll, $location, $$cherry, $$finder, $state, $$code, commonApiServ, $$proposalAPI, $stateParams, $filter) {
			$scope.endorHide=true;//批改时删除和修改按钮隐藏
			//去掉模板必填标志
			$scope.hideStar = true;
			//模板页面隐藏关联按钮
			$scope.hideRelativeBtn = true;
			//将归属机构隐藏
			$scope.handler1CodeShow="true";
			//投保模板查看的返回
			$scope.infoReturn = true;
			$scope._calculatePremium="0";
			var flag=$stateParams.flag;
			if (flag=="1"){
				$scope.proposalQueryHide=false;
				$scope.temporarySave=true;
				$scope.allSave=true;
				//显示模板的修改方案
				$scope.riskSchemeModel=true;
			}else{
				//    将页面的input变成只读状态
				$scope.proposalQueryHide = true;
				$scope.temporarySave=false;
				$scope.allSave=false;
			}

			$scope.$on('closeRiskScheme', function(event,data){
				$scope.showRiskScheme=data;
			});
			//把语种隐藏
			$scope.queryHide0 = true;
			$scope.initFlag = false;// 初始化标志  初始化完成后置为 false  默认true初始化状态
			$$proposalAPI.initAPI($scope);
			$scope.return = function () {
				window.history.back();
			}
			//查询机构树
			$$finder.find('getCompanyTree', {
				"modelCode": $stateParams.modelCode,
				"userCode":$rootScope.user.userCode,
				"comCode":$rootScope.user.loginComCode
			}, {
				success: function (data) {
					$rootScope.modelComDtoList = data.content.companyListDtoList;//适用机构
				},
				error: function () {

				}
			})
			$$finder.find('queryPrpMmodelMainByHyperLink', {
				"modelCode": $stateParams.modelCode,
				"userCode":$rootScope.user.userCode,
				"comCode":$rootScope.user.loginComCode
			}, {
				success: function (data) {
					console.log(data);

						//$rootScope.modelComDtoList = data.content.companyListDtoList;//适用机构
						console.log("123")
						console.log(data.content)
						$scope.proposal.prpMmodelComDtoList = data.content.prpMmodelComDtoList;
						$scope.proposal.editType = "";
						data.content.prpModelAddressSubDto = data.content.prpModelAddressSubDto || {};
						data.content.prpModelCoinsDetailDtoList = data.content.prpModelCoinsDetailDtoList || {};
						data.content.prpModelCoinsSubDtoList = data.content.prpModelCoinsSubDtoList || {};
						data.content.prpModelEngageSubDtoList = data.content.prpModelEngageSubDtoList || {};
						data.content.prpModelItemKindAgriDtoList = data.content.prpModelItemKindAgriDtoList || {};
						data.content.prpModelItemKindDtoList = data.content.prpModelItemKindDtoList || {};
						data.content.prpModelPlanCoinsDtoList = data.content.prpModelPlanCoinsDtoList || {};
						data.content.prpModelPlanSubDtoList = data.content.prpModelPlanSubDtoList || {};
						data.content.prpModelSubsidyDtoList = data.content.prpModelSubsidyDtoList || {};
						data.content.queryModelPrpTengageDtoList = data.content.queryModelPrpTengageDtoList || {};
						data.content.prpModelMainAgriSubDto = data.content.prpModelMainAgriSubDto || {};
						$scope.proposal.prpTmainDto = data.content.prpModelMainSubDto;//基本信息（不完全）
						$scope.proposal.appliInsuredDto = data.content.appliInsuredDto;
						$scope.proposal.insuredDto = data.content.insuredDto;
						$scope.prpMmodelMainDto = $scope.prpMmodelMainDto || {};
						$scope.prpMmodelMainDto.startDate = data.content.prpMmodelMainDto.startDate;//有效起期
						$scope.prpMmodelMainDto.endDate = data.content.prpMmodelMainDto.endDate;//有效止期
						$scope.prpMmodelMainDto.validstatus = data.content.prpMmodelMainDto.validStatus;//模板状态
						$scope.prpMmodelMainDto.modelName = data.content.prpMmodelMainDto.modelName;//模板名称
						$scope.prpMmodelMainDto.modelCode = data.content.prpMmodelMainDto.modelCode;//模板代码
						$rootScope.getModelCode = data.content.prpMmodelMainDto.modelCode;
						$scope.proposal.createDate = data.content.prpMmodelMainDto.createDate;
						$scope.prpMmodelMainDto.riskScheme = data.content.prpMmodelMainDto.remark //模板创建类型
					    if($stateParams.copyModel){
							$$finder.find('creatProposal', {
								"tableName": "prpmmodelmain",//表名
								"iYear": new Date().getFullYear(),//当前年份
								"riskCode": $scope.proposal.prpTmainDto.riskCode,
								"iComCode": $rootScope.user.loginComCode,
								"userCode": $rootScope.user.userCode
							}, {
								success: function (data) {
									$scope.prpMmodelMainDto.modelCode = data.content.billNo;
								},
								error: function (e) {
									options.error(e);
								}
							});
						}

						$scope.proposal.prpTmainDto.riskCodeName = data.content.riskCname;//险种
						$scope.proposal.prpTmainDto.contractType = data.content.prpModelMainSubDto.argueSolution;//合同争议解决方式
						$scope.proposal.prpTmainDto.comCode = data.content.prpModelMainSubDto.comCode,//归属机构
						$scope.proposal.prpTmainDto.handler1Code = data.content.prpModelMainSubDto.handler1Code,//归属业务人员
						$scope.proposal.prpTmainDto.businessCategory = data.content.prpModelMainSubDto.groupFlag;//业务大类
						$scope.proposal.prpTaddressDto.addressName = data.content.prpModelAddressSubDto.addressName;
						$scope.proposal.prpTitemKindDtoList = data.content.prpModelItemKindDtoList;//主险附加险(不完全)
						$scope.proposal.prpTitemKindAgriDtoList = data.content.prpModelItemKindAgriDtoList;
						$scope.proposal.prpTmainAgriDto = data.content.prpModelMainAgriSubDto;
						$scope.proposal.prpTmainAgriDto.raiseDate = $filter('date')(data.content.prpModelMainAgriSubDto.raiseDate, 'yyyy-MM-dd');


					//-------------------------------------养殖方式下拉框--------------------------------------
					$scope.mulitSelectUnit($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainAgriDto.statUnitCode);//承保数量计数单位--种植险
					$scope.mulitSelectRaiseType($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainAgriDto.raiseType);//承保数量计数单位--养殖险
					//----------------------------------页面个性化开始----------------------------------------------------
					if($scope.proposal.prpTmainDto.riskCode=='3220'||  $scope.proposal.prpTmainDto.riskCode=='3233'){
						$scope.isAgriUnitCostMain = false;//隐藏单位生产成本
						$scope.isProportion = true;
					}else if ($scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
						|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
						$rootScope.isTrue();
					}
					if($scope.proposal.prpTmainDto.riskCode=='3224'||$scope.proposal.prpTmainDto.riskCode=='3237' ) {
						$scope.trRaiseName = "养殖时间";
						$scope.addressTitle = "养殖地点";
						$scope.isTriggerPoint = true;
						$scope.isTotalLossRatio = true;
					}else if($scope.proposal.prpTmainDto.riskCode=='3233'){
						$scope.trRaiseName = "养殖时间";
						$scope.addressTitle = "养殖地点";
					}else{
						$scope.trRaiseName="种植时间";
						$scope.addressTitle="种植地点";
					}
					$scope.isTriggerPoint = false;
					$scope.isTotalLossRatio = false;
					if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
						|| $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108' || $scope.proposal.prpTmainDto.riskCode=='3224'
						|| $scope.proposal.prpTmainDto.riskCode=='3130'|| $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
						|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'|| $scope.proposal.prpTmainDto.riskCode=='3101'
						|| $scope.proposal.prpTmainDto.riskCode=='3114'|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
						|| $scope.proposal.prpTmainDto.riskCode=='3161'){
						//显示起赔点、全损损失率
						$scope.isTriggerPoint = true;
						$scope.isTotalLossRatio = true;
					}
					$scope.isRaiseType = false;
					$scope.isProposalType = false;
					if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
						|| $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
						|| $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
						|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'
                        || $scope.proposal.prpTmainDto.riskCode=='3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
						|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
						|| $scope.proposal.prpTmainDto.riskCode=='3161'){
						$scope.isProposalType = true;
					}else if($scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'){
						$scope.isRaiseType = true;
					}else if($scope.proposal.prpTmainDto.riskCode=='3237'){
						$scope.isIndemnity=true;
						$scope.isRaiseDate = true;
						$scope.isTriggerPoint = true;
						$scope.isTotalLossRatio = true;
						$scope.isAgriUnitCostMain=true;
						$scope.deductibleRateType=true;//每次事故免赔率置灰
						$scope.totalLossRatioType = true;//全损损失率置灰
					}else if($scope.proposal.prpTmainDto.riskCode=='3129'){
						$scope.isRaiseDate=false;
						$scope.isProposalType=false;
						$scope.isTriggerPoint = true;
						$scope.isTotalLossRatio = true;
						$scope.ZHshow=true;
						$scope.isAgriUnitCostMain=false;
						$scope.showprice=false;
					}
					//------------------------------------页面个性化结束------------------------------------------------




					$scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;//缴费计划（不完全）
						$scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;//补贴信息
						$scope.proposal.prpTfeeDto = data.content.prpModelFeeSubDto,//币别信息
						$scope.proposal.prpTfeeDto.currency2 = data.content.prpModelMainSubDto.currency;//汇总币别
						$scope.proposal.prpDcustomerTaxPayInfoDto = data.content.prpModelCustomerTaxPayInfoSubDto;
						$scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;
						$scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;
						$scope.currency2Name = data.content.currency2Name;
						$scope.totalAmount = data.content.prpModelMainSubDto.sumAmount//总保额
						$scope.totalPay = data.content.prpModelMainSubDto.sumPremium;//总保费
						$scope.proposal.prpTmainDto.updaterName = data.content.updaterName;//最近修改人
						$scope.proposal.prpTmainDto.operatorName = data.content.operatorName;//操作员名称
						$scope.proposal.prpDcustomerTaxPayInfoDto.postCode = data.content.insuredDto.postCode;//邮政编码
						$scope.proposal.appliInsuredDto.certificateName = data.content.appliInsuredDto.certificatEName;//客户代码
						$scope.proposal.insuredDto.certificateName = data.content.insuredDto.certificatEName;//客户代码
						$scope.proposal.appliInsuredDto.isCareClaim = data.content.appliInsuredDto.iscareClaim,//客户是否关注审计、理赔、退保信息
						$scope.proposal.insuredDto.isCareClaim = data.content.insuredDto.iscareClaim//客户是否关注审计、理赔、退保信息
						$scope.proposal.prpTmainDto.reMark = data.content.prpModelMainSubDto.remark//*出单员意见
						$scope.proposal.prpTmainDto.class = $scope.proposal.prpTmainDto.classCode;
						//$scope.proposal.prpTmainDto.classCode = data.content.className;//险类
						$scope.proposal.prpTmainDto.className = data.content.className;//险类
						$scope.proposal.insureMainListDto.insureListCode = data.content.gisInsureListCode,//清单编号
						$scope.proposal.insureListCode1 = data.content.insureListCode;
						$scope.proposal.prpTmainAgriDto.relationListNoRemark = data.content.remark,//清单备注
						$scope.proposal.insureMainListDto.listTypeFlag = data.content.listTypeFlag,//清单类型
						$scope.proposal.prpTmainDto.businessProvinceName = data.content.fProvinceName;//归属区域:省
						$scope.proposal.prpTmainDto.businessCityName = data.content.fCityName;//归属区域:市
						$scope.proposal.prpTmainDto.businessCountyName = data.content.fCountyName;//归属区域:区(县)
						$scope.proposal.prpTmainDto.businessTownName = data.content.fTownName;//归属区域:乡/镇
						$scope.proposal.prpTmainDto.businessAreaName = data.content.fVillageName;//归属区域:村
						$scope.proposal.prpTcoinsDtoList = data.content.prpModelCoinsSubDtoList;
						$scope.proposal.prpTcoinsDetailDtoList = data.content.prpModelCoinsDetailDtoList;
						$scope.proposal.prpTplanCoinsDtoList = data.content.prpModelPlanCoinsDtoList;
						$scope.proposal.prpTmainAgriDto.relationListNo = data.content.prpModelMainAgriSubDto.relationListNo;//我方清单号
						$scope.proposal.insureMainListDto.serialNo = data.content.serialNo;//清单序列号

						if (data.content.listTypeFlag == 'D') {
							$scope.proposal.insureMainListDto.listTypeFlag = '大户';
						}
						if (data.content.listTypeFlag == 'S') {
							$scope.proposal.insureMainListDto.listTypeFlag = '散户';
						}
						$$finder.find('queryMarkedList', {
							"insureListCode":$scope.proposal.insureMainListDto.insureListCode,
							"serialNo":$scope.proposal.insureMainListDto.serialNo//标的清单序号
						}, {
							success: function (data) {
								$scope.queryMarkedList=data.content
							},
							error: function (e) {
								options.error(e);
							}
						});
						$scope.proposal.prpTengageDtoCopy = $scope.proposal.prpTengageDtoCopy || [];
						angular.forEach(data.content.queryModelPrpTengageDtoList, function (data, index) {
							var obj = {
								clauseCode: data.clauseCode,//特约代码
								clauses: data.clauseName,//特约名称
								clausesContent: data.clausesContent//特约内容
							};
							$scope.proposal.prpTengageDtoCopy.push(obj)
						});
						angular.forEach(data.content.prpModelCoinsSubDtoList, function (data, index) {
							data.mainProposalNo = data.mainPolicyNo;//主保单号码
							data.coinsSumAmount = $scope.proposal.prpTcoinsDetailDtoList[index].coinsAmount//共保保额
							data.coinsSumPremium = $scope.proposal.prpTcoinsDetailDtoList[index].coinsPremium//共保保费
							data.policyNo = "1";
						});
						//共保方补贴信息
						angular.forEach(data.content.prpModelPlanCoinsDtoList, function (data, index) {
							data.realPay = data.planFee - data.delinquentFee;//实缴金额
							if (data.payReason == '03') {
								data.reason = '中央财政';//缴费原因
							}
							if (data.payReason == '04') {
								data.reason = '省级财政';//缴费原因
							}
							if (data.payReason == '07') {
								data.reason = '县(区)财政';//缴费原因
							}
							if (data.payReason == '06') {
								data.reason = '其他来源';//缴费原因
							}
							if (data.payReason == '05') {
								data.reason = '地市财政';//缴费原因
							}
							if (data.payReason == 'GP81') {
								data.reason = '自缴保费';//缴费原因
							}
							if ($scope.proposal.prpTcoinsDetailDtoList.length >= 3) {
								data.coinsName = $scope.proposal.prpTcoinsDetailDtoList[2].coinsName;
							}

						});
						//绝对免赔率
						$scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
						angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
							if (data.clauseCode == 'TX001') {
								$scope.proposal.engageQueryClause.absuDedu = $scope.proposal.prpTengageDtoCopy.splice(index, 1)[0].clausesContent;

							}
						});
						//客户信息中被保险人中的  同投保人选择按钮
						data.content.appliInsuredDto.insuredCode == data.content.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
						//发票购货方信息  选择同投保人、被投保人
						if (data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1") {
							$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
						} else if (data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "2") {
							$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
						} else {
							$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
						}
						//data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1" ? $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1" : $scope.tdInsuredIdentityInput = "";
						angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
							if (data.payReason == 'R10') {
								data.payReasonName = '签单收保费'
							}
							if (data.payReason == 'R20') {
								data.payReasonName = '分期收保费'
							}
							if (data.payReason == 'RS3') {
								data.payReasonName = '中央财政'
							}
							if (data.payReason == 'RS4') {
								data.payReasonName = '省级财政'
							}
							if (data.payReason == 'RS7') {
								data.payReasonName = '县(区)财政'
							}
							if (data.payReason == 'RS6') {
								data.payReasonName = '其他来源'
							}
							if (data.payReason == 'RS5') {
								data.payReasonName = '地市财政'
							}
							data.payreFee = data.planFee - data.delinquentFee
							if (!isNaN(data.planDate)) {
								data.planDate = $filter('date')(data.planDate, 'yyyy-MM-dd');
								data.planStartDate = $filter('date')(data.planStartDate, 'yyyy-MM-dd');
							}

						})
						//主险附加险
						angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
							data.shortRate=round(data.shortRate,2);
							data.amount=round(data.amount,2);
							data.premium=round(data.premium,2)
							$scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMaintitle='单位保险产量'
							$scope.proposal.prpTitemKindDtoList[index].agriUnitCostMaintitle = '单位生产成本'
							$scope.proposal.prpTitemKindDtoList[index].radioType = data.flag == 1 ? 'Y' : 'N';
							//$scope.proposal.engageQueryClause.absuDedu = data.deductibleRate;
							$scope.proposal.prpTitemKindDtoList[index].premiumCalMethod = data.premiumcalMethod//保费计算方式


						})
					//茬次信息赋值
					var prpTitemKindAgriDtoListCopy = []
					var prpModelItemKindAgriDtoList1=[]
					if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
						|| $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
						angular.forEach(data.content.prpModelItemKindAgriDtoList, function (_data) {
							if ((_data.distributingRate != null && _data.distributingRate != undefined)
								&& (_data.timesAmount != null && _data.timesAmount != undefined)
								&& (_data.stratDate != null && _data.stratDate != undefined)
								&& (_data.endDate != null && _data.endDate != undefined)
								&& _data.times>0) {
								prpTitemKindAgriDtoListCopy.push(_data);
							}else{
								prpModelItemKindAgriDtoList1.push(_data)
							}
						});
						$scope.proposal.prpTitemKindAgriDtoListCopy = prpTitemKindAgriDtoListCopy;
						data.content.prpModelItemKindAgriDtoList=prpModelItemKindAgriDtoList1;
					}

						angular.forEach(data.content.prpModelItemKindAgriDtoList, function (data, index) {
							$scope.proposal.prpTitemKindDtoList[index].agriUnitCostMain = data.unitCost;//单位生产成本
							$scope.proposal.prpTitemKindDtoList[index].unitCostName = '元';
							$scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMain = data.unitCost;//单位保险产量
							$scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMainName="公斤";
							$scope.proposal.prpTitemKindDtoList[index].unitAmount = data.unitAmount;//单位保险金额
							$scope.proposal.prpTitemKindDtoList[index].agriGrossQuantityMain = data.grossQuantity// 投保面积
							$scope.proposal.prpTitemKindDtoList[index].agriTimesAmount = data.timesAmount;//约定单价

						})


						//政策性
						if (data.content.prpModelMainSubDto.businessType1 == '00') {
							$scope.proposal.prpTmainDto.businessType1Name = "商业性"
						} else if (data.content.prpModelMainSubDto.businessType1 == '01') {
							$scope.proposal.prpTmainDto.businessType1Name = "中央政策性"
						} else if (data.content.prpModelMainSubDto.businessType1 == '02') {
							$scope.proposal.prpTmainDto.businessType1Name = "地方政策性"
						}
						//
						$$finder.find('queryByRiskCode', {
							riskCode: data.content.prpModelMainSubDto.riskCode,//险种
						}, {
							success: function (data) {
								$scope.rateDivisor = data.content;
								$scope.getrateDivisor($scope.rateDivisor)
							},
							error: function (e) {
								options.error(e);
							}
						});
						//业务大类
						$scope.parameterConvert.businessCategoryInit();
						//归属机构
						$scope.getComCodeList()

						//归属业务员
						$scope.getHanCode({comCName: $scope.proposal.prpTmainDto.comCName}, $scope.proposal.prpTmainDto.handler1Code);
						//投保方式
						$scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, data.content.prpModelMainSubDto.policyType);//投保方式下拉初始化获取
						//显示证件类型
						$scope.getIdentity($scope.proposal.appliInsuredDto.insuredType, $scope.proposal.appliInsuredDto.identifyType);
						//共保不显示就粘这一段
						if ($scope.proposal.prpTmainDto.coinsFlag != '0') {
							$scope.PremiumShow = true;
							$scope.showCoins = true;
							$scope.proposal.otherAgentFeeShow = true;
						}
					$$finder.find('queryInsurePreliminaryConfirm', {
						"insureListCode": $scope.proposal.insureMainListDto.insureListCode,//金禾清单号
						"serialNo":$scope.proposal.insureMainListDto.serialNo,//标的清单序号

					}, {
						success: function (data) {
							//投保人客户类型置灰
							if($scope.proposal.appliInsuredDto.insuredType!=null&&$scope.proposal.appliInsuredDto.insuredType!=""&&$scope.proposal.appliInsuredDto.insuredType!=undefined){
								$rootScope.kelei=true;
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

				},
				error: function (e) {
					options.error(e);
				}

			});
			//获取适用机构
			$scope.getComCodeTree=function(data){
				$rootScope.treecheck=data;
			};
			//暂存保存
			$scope.infoShowSaveSuccess= function (a){
				//模板配置主表
				$scope.proposal.prpMmodelMainDto = $scope.proposal.prpMmodelMainDto || {};
				if (a=="1"){
					$scope.proposal.prpMmodelMainDto.flag="1";
				}else if(a=="0"){
					$scope.proposal.prpMmodelMainDto.flag="0"
				}
				//如果原币为空，默认为RMB
				if (!$scope.proposal.prpTfeeDto.currency){
					$scope.proposal.prpTfeeDto.currency='CNY'
				}
				$scope.proposal.prpMmodelMainDto.remark = $scope.prpMmodelMainDto.riskScheme,//模板创建类型
				$scope.proposal.prpMmodelMainDto.operatorCode = $rootScope.user.userCode,//操作
				$scope.proposal.prpMmodelMainDto.updateOpCode = $rootScope.user.userCode,//最近修改人
				$scope.proposal.prpMmodelMainDto.modelName = $scope.prpMmodelMainDto.modelName,//模板名称,
				$scope.proposal.prpMmodelMainDto.riskCode = $scope.proposal.prpTmainDto.riskCode,//险种代码
				$scope.proposal.prpMmodelMainDto.startDate = $scope.prpMmodelMainDto.startDate,//有效起期
				$scope.proposal.prpMmodelMainDto.endDate = $scope.prpMmodelMainDto.endDate,//有效止期
				$scope.proposal.prpMmodelMainDto.validStatus = $scope.prpMmodelMainDto.validstatus;//模板状态
				$scope.proposal.prpMmodelMainDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$scope.proposal.prpMmodelMainDto.createDate = $scope.proposal.createDate;//模板创建时间

				$scope.proposal.insureMainListDto.insureListCode=$scope.proposal.insureListCode1;
				//模板机构配置表
				$scope.proposal.prpMmodelComDto = $scope.proposal.prpMmodelComDto || {};
				$scope.proposal.prpMmodelComDtoList=$scope.proposal.prpMmodelComDtoList||[];
				angular.forEach($rootScope.treecheck,function(item,index){
					if(index=='0'){
						$scope.proposal.prpMmodelComDtoList=[];
					}
					$scope.proposal.prpMmodelComDtoList.push({
						"comCode": item.id,
						"comName": item.n,
						"flag":"1",
						"modelCode":$scope.prpMmodelMainDto.modelCode,
						"containFlag":"" //是否包含下级机构
					});
				});
				$scope.proposal.prpMmodelComDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				// 模板保险地址表
				$scope.proposal.prpModelAddressSubDto = $scope.proposal.prpModelAddressSubDto || {};
				$scope.proposal.prpModelAddressSubDto.addressNo = $scope.proposal.prpTaddressDto.addressNo,//序号
				$scope.proposal.prpModelAddressSubDto.addressName = $scope.proposal.prpTaddressDto.addressName,//地址
				$scope.proposal.prpModelAddressSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
				$scope.proposal.prpModelAddressSubDto.addressCode = "10000",//地址编码
				$scope.proposal.prpModelAddressSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码


				//模板农业险保单信息
				$scope.proposal.prpModelMainAgriSubDto = $scope.proposal.prpModelMainAgriSubDto || {};
				$scope.proposal.prpModelMainAgriSubDto.remark = $scope.proposal.prpTmainAgriDto.remark,//保险金额确定
				$scope.proposal.prpModelMainAgriSubDto.raiseDate = $scope.proposal.prpTmainAgriDto.raiseDate,//种植
				$scope.proposal.prpModelMainAgriSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
				$scope.proposal.prpModelMainAgriSubDto.raiseSite = $scope.proposal.prpTaddressDto.addressName;//养殖地点
				$scope.proposal.prpModelMainAgriSubDto.observeStartHour = 0,$scope.proposal.prpModelMainAgriSubDto.observeEndHour = 24,
				$scope.proposal.prpModelMainAgriSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$scope.proposal.prpModelMainAgriSubDto.relationListNo=$scope.proposal.prpTmainAgriDto.relationListNo//我方清单号



				//模板保单基本信息表
				$scope.proposal.prpModelMainSubDto = $scope.proposal.prpModelMainSubDto || {};
				$scope.proposal.prpModelMainSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$scope.proposal.prpModelMainSubDto.classCode = $scope.proposal.prpTmainDto.classCode,//险类代码
				$scope.proposal.prpModelMainSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode,//险种代码
				$scope.proposal.prpModelMainSubDto.comCode = $scope.proposal.prpTmainDto.comCode,//归属机构
				$scope.proposal.prpModelMainSubDto.handler1Code=$scope.proposal.prpTmainDto.handler1Code,//归属业务人员
				$scope.proposal.prpModelMainSubDto.businessProvince = $scope.proposal.prpTmainDto.businessProvince,//归属区域:省
				$scope.proposal.prpModelMainSubDto.businessTown = $scope.proposal.prpTmainDto.businessTown,//归属区域：市
				$scope.proposal.prpModelMainSubDto.businessCountry = $scope.proposal.prpTmainDto.businessCountry,//归属区域：区/县
				$scope.proposal.prpModelMainSubDto.businessAreaName = $scope.proposal.prpTmainDto.businessAreaName,//归属区域：乡/镇
				$scope.proposal.prpModelMainSubDto.businessArea = $scope.proposal.prpTmainDto.businessArea,//归属区域：村
				$scope.proposal.prpModelMainSubDto.businessNature = $scope.proposal.prpTmainDto.businessNature,//业务来源
				$scope.proposal.prpModelMainSubDto.versionNo = $scope.proposal.prpTmainDto.versionNo,//条款
				//$scope.proposal.prpModelMainSubDto.groupFlag=$scope.proposal.prpTmainDto.businessCategory,//业务大类
				$scope.proposal.prpModelMainSubDto.groupFlag=$scope.proposal.prpTmainDto.groupFlag
				$scope.proposal.prpModelMainSubDto.businessType1 = $scope.proposal.prpTmainDto.businessType1,//政策/商业标志
				$scope.proposal.prpModelMainSubDto.inceptionFlag = $scope.proposal.prpTmainDto.inceptionFlag,//是否验标
				$scope.proposal.prpModelMainSubDto.notificationFlag = $scope.proposal.prpTmainDto.notificationFlag,//是否承保公示$scope.proposal.prpModelMainSubDto.businessType=$scope.proposal.prpTmainDto.businessType,//业务类型
				$scope.proposal.prpModelMainSubDto.eccFlag = $scope.proposal.prpTmainDto.eccFlag;
				$scope.proposal.prpModelMainSubDto.thirdKnow = $scope.proposal.prpTmainDto.thirdKnow,//是否通过第三方识别
				$scope.proposal.prpModelMainSubDto.autoTransRenewFlag = $scope.proposal.prpTmainDto.autoTransRenewFlag,//缴费方式
				$scope.proposal.prpModelMainSubDto.startDate = $scope.proposal.prpTmainDto.startDate,//保险期间
				$scope.proposal.prpModelMainSubDto.startHour = $scope.proposal.prpTmainDto.startHour,//保险期间
				$scope.proposal.prpModelMainSubDto.endDate = $scope.proposal.prpTmainDto.endDate,//保险期间
				$scope.proposal.prpModelMainSubDto.EndHour = $scope.proposal.prpTmainDto.EndHour,//保险期间
				$scope.proposal.prpModelMainSubDto.operateDate = $scope.proposal.prpTmainDto.operateDate,//投保日期
				$scope.proposal.prpModelMainSubDto.signDate = $scope.proposal.prpTmainDto.signDate,//制单日期
				$scope.proposal.prpModelMainSubDto.proposalNo = $scope.proposal.prpTmainDto.proposalNo,//投保单号
				//$scope.proposal.prpModelMainSubDto.operatorCode = $scope.proposal.prpTmainDto.operatorCode,//操作员
				$scope.proposal.prpModelMainSubDto.operatorCode = $rootScope.user.userCode,
				$scope.proposal.prpModelMainSubDto.inputDate = $scope.proposal.prpTmainDto.inputDate,//操作日期
				//$scope.proposal.prpModelMainSubDto.updaterCode = $scope.proposal.prpTmainDto.updaterCode,//最近修改人
				$scope.proposal.prpModelMainSubDto.updaterCode = $rootScope.user.userCode,
				$scope.proposal.prpModelMainSubDto.updateDate = $scope.proposal.prpTmainDto.updateDate,//最近修改日期
				$scope.proposal.prpModelMainSubDto.policyType = $scope.proposal.prpTmainDto.policyType,//投保方式
				$scope.proposal.prpModelMainSubDto.statQuantity = $scope.proposal.prpTmainDto.statQuantity,//承保数量
				$scope.proposal.prpModelMainSubDto.sumInsured = $scope.proposal.prpTmainDto.sumInsured,//参保农户户次
				//$scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount,//总保额
				//$scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay,//总保费
				$scope.proposal.prpModelMainSubDto.currency = $scope.proposal.prpTfeeDto.currency2,//汇总币别
				$scope.proposal.prpModelMainSubDto.payTimes = $scope.proposal.prpTmainDto.payTimes,//缴费期次
				$scope.proposal.prpModelMainSubDto.coinsFlag = $scope.proposal.prpTmainDto.coinsFlag,//共
				$scope.proposal.prpModelMainSubDto.coinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType,//保单缴费类
				$scope.proposal.prpModelMainSubDto.appliCode = $scope.proposal.appliInsuredDto.insuredCode;//投保人代码
				$scope.proposal.prpModelMainSubDto.appliName = $scope.proposal.appliInsuredDto.insuredName;//投保人名称
				$scope.proposal.prpModelMainSubDto.appliAddress = $scope.proposal.appliInsuredDto.insuredAddress;//投保人地址
				$scope.proposal.prpModelMainSubDto.insuredCode = $scope.proposal.insuredDto.insuredCode;//被保人代码
				$scope.proposal.prpModelMainSubDto.insuredName = $scope.proposal.insuredDto.insuredName;//被保险人名称
				$scope.proposal.prpModelMainSubDto.insuredAddress = $scope.proposal.insuredDto.insuredAddress;//被保险人地址
				$scope.proposal.prpModelMainSubDto.judicalCode = $scope.proposal.prpTmainDto.judicalScope,//司法管辖
				$scope.proposal.prpModelMainSubDto.judicalScope = "1",//交费方式
				$scope.proposal.prpModelMainSubDto.shareHolderFlag = "0",//股东业务标识下拉框，默认为0-否，1-是
				$scope.proposal.prpModelMainSubDto.remark = $scope.proposal.prpTmainDto.reMark,//对应页面的出单员意见
				$scope.proposal.prpModelMainSubDto.argueSolution = $scope.proposal.prpTmainDto.contractType,//合同争议解决方式
				$scope.proposal.prpModelMainSubDto.language= $scope.proposal.prpTmainDto.language,//语种
				$scope.proposal.prpModelMainSubDto.policySort =$scope.proposal.prpTmainDto.policySort,//保单种类
				$scope.proposal.prpModelMainSubDto.underwriteEndDate=$scope.proposal.prpTmainDto.underwriteEndDate,//核保通过日期
				$scope.proposal.prpModelMainSubDto.underwriteName=$scope.proposal.prpTmainDto.underwriteName,//核保人
				$scope.proposal.prpModelMainSubDto.makeCom = $scope.proposal.prpTmainDto.comCode;//出单机构代码
				$scope.proposal.prpModelMainSubDto.pureRate = "0.00",//净费率
				$scope.proposal.prpModelMainSubDto.discount = "100.00",//总折扣
				$scope.proposal.prpModelMainSubDto.sumValue = "0.00",//总保险价值
				$scope.proposal.prpModelMainSubDto.sumDiscount = "0.00",//总折扣金额
				$scope.proposal.prpModelMainSubDto.language = $scope.proposal.prpTmainDto.language,//语种标志
				$scope.proposal.prpModelMainSubDto.endorseTimes = "0",//批改次数
				$scope.proposal.prpModelMainSubDto.claimTimes = "0",//理赔次数
				$scope.proposal.prpModelMainSubDto.inputHour = "11",//计算机输单小
				$scope.proposal.prpModelMainSubDto.allinsFlag = "2",//统保标志
				$scope.proposal.prpModelMainSubDto.underwriteFlag = "0",//核保标志
				$scope.proposal.prpModelMainSubDto.othFlag = "000000YY000000000000",//其它标志字段
				$scope.proposal.prpModelMainSubDto.businessFlag = "0",//页面默认值为1
				$scope.proposal.prpModelMainSubDto.payMode = "0",//
				$scope.proposal.prpModelMainSubDto.articleType = "0",//专项业务
				$scope.proposal.prpModelMainSubDto.startMinute = "0",//起保分钟
				$scope.proposal.prpModelMainSubDto.endMinute = "0",//终保分钟
				$scope.proposal.prpModelMainSubDto.validCountDate = "9999-12-31",//统计日期
				//$scope.proposal.prpModelMainSubDto.handlerCode=$scope.proposal.prpTmainDto.handler1Code,//经办人代码
				$scope.proposal.prpModelMainSubDto.remark= $scope.proposal.prpTmainDto.reMark;//*出单员意见
				//$scope.proposal.prpModelMainSubDto.handlerCode = "th"
				//标的子险信息
				//$scope.proposal.prpModelItemKindDtoList=$scope.proposal.prpTitemKindDtoList;
				var prpModelItemKindDtoList = [];
				$scope.prpTitemKind=$scope.prpTitemKind||{};
				//用于茬次信息
				var riskCode="";
				//var itemKindNo="";
				var kindCode="";
				angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
					data.riskCode = $scope.proposal.prpTmainDto.riskCode,//险种代码
						//这里赋值的
						riskCode=data.riskCode;
						kindCode=data.kindCode;
						data.premiumcalMethod=data.premiumCalMethod
					data.itemKindNo =index+1//标的序号
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					//data.premiumcalMethod=data.premiumCalMethod//保费计算方式
					prpModelItemKindDtoList.push(data);
				})
				$scope.proposal.prpModelItemKindDtoList=prpModelItemKindDtoList;

				var prpModelItemKindAgriDtoListCopy =[];
				angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					data.riskCode = $scope.proposal.prpTmainDto.riskCode//险种代码
					data.itemKindNo =index+1//标的序号
					data.discountType = "2";
					if(data.agriUnitCostMain){
						data.unitCost = data.agriUnitCostMain;//对应页面生成成本
					}
					if(data.agriUnitOutputMain){
						data.unitCost = data.agriUnitOutputMain;//对应页面单位保险产量
					}
					data.unitAmount = data.unitAmount,//单位保险金额
						data.grossQuantity=data.agriGrossQuantityMain//投保面积
					if(data.agriTimesAmount){
						data.timesAmount=data.agriTimesAmount//约定单价
					}

					data.depreciationRate = "";//折旧率/树龄(林木险)
					prpModelItemKindAgriDtoListCopy.push(data)
				})
				$scope.proposal.prpModelItemKindAgriDtoList = prpModelItemKindAgriDtoListCopy;
				//茬次信息 如果险种是3134或者3147就走
				if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
					|| $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
					var times = 0
					angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
						dto.modelCode = $scope.prpMmodelMainDto.modelCode;
						dto.riskCode = riskCode;
						//dto.itemKindNo=itemKindNo;
						dto.kindCode = kindCode;
						if (isNaN(dto.times)) {
							dto.times = 0;
						}
						times = times + 1;
						dto.times = times;
						$scope.proposal.prpModelItemKindAgriDtoList.push(dto);
					});
				}


				//特约信息
				$scope.proposal.prpModelEngageSubDtoList = $scope.proposal.prpModelEngageSubDtoList || [];
				$scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {}
				if ($scope.proposal.engageQueryClause.absuDedu) {
					var obj = {};
					obj.riskCode=$scope.proposal.prpTmainDto.riskCode;
					obj.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					obj.serialNo = 1;//序号不能从0开始所以加1
					obj.lineNo = 1;//换行
					obj.titleFlag = 0;
					obj.flag = 0;
					obj.clauseCode = 'TX001';
					obj.clauses = '绝对免赔率';
					$scope.proposal.prpModelEngageSubDtoList.push(obj);
					var obj1 = {}
					obj1.riskCode=$scope.proposal.prpTmainDto.riskCode;
					obj1.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					obj1.serialNo = 1;//序号不能从0开始所以加1
					obj1.lineNo = 2;//换行
					obj1.titleFlag = 1;
					obj1.flag = 1;
					obj1.clauseCode = 'TX001';
					obj1.clauses = $scope.proposal.engageQueryClause.absuDedu;
					$scope.proposal.prpModelEngageSubDtoList.push(obj1);
				}
				angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
					if (index >= 0) {
						var obj = angular.copy(data);
						obj.riskCode=$scope.proposal.prpTmainDto.riskCode;
						obj.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
						obj.serialNo = index + 1;//序号不能从0开始所以加1
						obj.lineNo = 1;//换行
						obj.titleFlag = 0;
						obj.flag = 0;
						$scope.proposal.prpModelEngageSubDtoList.push(obj);
						if (data.clausesContent) {//如果内容里有东西
							var obj = angular.copy(data);
							obj.riskCode=$scope.proposal.prpTmainDto.riskCode;
							obj.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
							obj.serialNo = index + 1;
							obj.lineNo = 2;//换行
							obj.titleFlag = 1;
							obj.flag = 1;
							obj.clauses = obj.clausesContent;//把内容放入名称属性中
							$scope.proposal.prpModelEngageSubDtoList.push(obj);
						}
					}
				});
				//币别信息
				$scope.proposal.prpModelFeeSubDto= $scope.proposal.prpModelFeeSubDto||{}
				$scope.proposal.prpModelFeeSubDto = angular.copy($scope.proposal.prpTfeeDto);
				$scope.proposal.prpModelFeeSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode;
				$scope.proposal.prpModelFeeSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码

				//投保人
				$scope.proposal.appliInsuredDto = $scope.proposal.appliInsuredDto || {};
				$scope.proposal.appliInsuredDto = angular.copy($scope.proposal.appliInsuredDto);
				$scope.proposal.appliInsuredDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$scope.proposal.appliInsuredDto.serialNo = "1",
				$scope.proposal.appliInsuredDto.insuredFlag = "2",
				$scope.proposal.appliInsuredDto.riskCode = $scope.proposal.prpTmainDto.riskCode//险种
				$scope.proposal.appliInsuredDto.certificatEName= $scope.proposal.appliInsuredDto.certificateName,//客户代码
				$scope.proposal.appliInsuredDto.iscareClaim=$scope.proposal.appliInsuredDto.isCareClaim,//客户是否关注审计、理赔、退保信息


				$scope.proposal.insuredDto = $scope.proposal.insuredDto || {};
				$scope.proposal.insuredDto = angular.copy($scope.proposal.insuredDto);
				$scope.proposal.insuredDto.insuredFlag = "1",
				$scope.proposal.insuredDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$scope.proposal.insuredDto.riskCode = $scope.proposal.prpTmainDto.riskCode,//险种
				$scope.proposal.insuredDto.serialNo = "2",
				$scope.proposal.insuredDto.certificatEName=$scope.proposal.insuredDto.certificateName//客户代码
				$scope.proposal.insuredDto.iscareClaim=$scope.proposal.insuredDto.isCareClaim//客户是否关注审计、理赔、退保信息



				//共保信息
				if ($scope.proposal.prpTcoinsDtoList.length) {
					$scope.proposal.prpTcoinsDtoList[0].coinsType = '0'
				}
				$scope.proposal.prpModelCoinsSubDtoList = $scope.proposal.prpModelCoinsSubDtoList || [];
				angular.forEach($scope.proposal.prpTcoinsDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					data.mainPolicyNo=data.mainProposalNo;
					data.proportionFlag = 0;
					data.coinsTreatyNo = '';
					data.coinsFlag = '';
					data.reinsCiflag = ''
					$scope.proposal.prpModelCoinsSubDtoList.push(data)
				})
				//
				$scope.proposal.prpModelPlanCoinsDtoList= $scope.proposal.prpModelPlanCoinsDtoList||[]
				angular.forEach($scope.proposal.prpTplanCoinsDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					data.delinquentFee = data.planFee - data.realPay,//拖欠金额
					data.endorseNo = '',
					data.payNo = '1'
					$scope.proposal.prpModelPlanCoinsDtoList.push(data)
				})
				//
				$scope.proposal.prpModelSubsidyDtoList= $scope.proposal.prpModelSubsidyDtoList||[]
				angular.forEach( $scope.proposal.prpTsubsidyDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					$scope.proposal.prpModelSubsidyDtoList.push(data)
				})
				//缴费计划
				$scope.proposal.prpModelPlanSubDtoList=$scope.proposal.prpModelPlanSubDtoList||[]
				angular.forEach( $scope.proposal.prpTplanDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					$scope.proposal.prpModelPlanSubDtoList.push(data)
				})
				angular.forEach($scope.proposal.prpModelPlanSubDtoList,function (data,index) {
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
				})
				//
				$scope.proposal.prpModelCoinsDetailDtoList= $scope.proposal.prpModelCoinsDetailDtoList||[]
				angular.forEach( $scope.proposal.prpTcoinsDetailDtoList, function (data, index) {
					data.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
					$scope.proposal.prpModelCoinsDetailDtoList.push(data)
				})
				//发票购货方信息
				$scope.proposal.prpModelCustomerTaxPayInfoSubDto=angular.copy($scope.proposal.prpDcustomerTaxPayInfoDto);
				$scope.proposal.prpModelCustomerTaxPayInfoSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
				$$finder.find('saveButton', {
					"prpMmodelMainDto": $scope.proposal.prpMmodelMainDto,
					"prpMmodelComDtoList": $scope.proposal.prpMmodelComDtoList,
					"prpModelAddressSubDto": $scope.proposal.prpModelAddressSubDto,
					"prpModelSubsidyDtoList": $scope.proposal.prpModelSubsidyDtoList,
					"prpModelFeeSubDto": $scope.proposal.prpModelFeeSubDto,//币别信息
					"prpModelPlanSubDtoList": $scope.proposal.prpModelPlanSubDtoList,//缴费计划
					"prpModelCoinsSubDtoList": $scope.proposal.prpModelCoinsSubDtoList,//共保信息
					"prpModelCoinsDetailDtoList": $scope.proposal.prpModelCoinsDetailDtoList,
					"prpModelPlanCoinsDtoList": $scope.proposal.prpModelPlanCoinsDtoList,
					"prpModelCustomerTaxPayInfoSubDto": $scope.proposal.prpModelCustomerTaxPayInfoSubDto,//发票购货方信息
					"prpModelEngageSubDtoList": $scope.proposal.prpModelEngageSubDtoList,
					"prpModelMainAgriSubDto": $scope.proposal.prpModelMainAgriSubDto,
					"prpModelMainSubDto": $scope.proposal.prpModelMainSubDto,
					"prpModelItemKindDtoList": $scope.proposal.prpModelItemKindDtoList,
					"prpModelItemKindAgriDtoList": $scope.proposal.prpModelItemKindAgriDtoList,
					"appliInsuredDto": $scope.proposal.appliInsuredDto,
					"insuredDto": $scope.proposal.insuredDto

				}, {
					success: function (data) {
						if (data.code == "0000") {
							var context=''
							if($scope.proposal.prpMmodelMainDto.flag==="1"){//保存
								context="保存成功,模板号为:"+$scope.prpMmodelMainDto.modelCode;
							}else {
								context="暂存成功,模板号为:"+$scope.prpMmodelMainDto.modelCode;
							}
						$("html,body").css({overflow:"auto"});//出现滚动条
							$state.go('UIProposalManagement');
							console.log("0000");
							layer.open({
								offset: ['35%', '29%'],
								skin: 'large-layer-content',
								closeBtn: 0,
								title: '温馨提示',
								content: context,
								btn: ['确定'],
								btn1: function (index, layero) {
									//按钮【按钮一】的回调
									layer.close(index);
								}
							});

						} else {
						//	console.log("1111");
							var context=''
							if($scope.proposal.prpMmodelMainDto.flag==="1"){//保存
								context="保存失败!";
							}else {
								context="暂存失败!";
							}
							layer.open({
								offset: ['35%', '29%'],
								skin: 'large-layer-content',
								closeBtn: 0,
								title: '温馨提示',
								content:context,
								btn: ['确定'],
								btn1: function (index, layero) {
									//按钮【按钮一】的回调
									layer.close(index);
								}
							});
						}

					},
					error: function (e) {
						console.log(e);
					}
				});

			}
			////投保模板查看的返回
			$scope.infoShowReturn = function(){
				if ($stateParams.mm=="1"){
					$("html,body").css({overflow:"auto"});//出现滚动条
					$state.go('UIproposaledit');
				}else{
					$("html,body").css({overflow:"auto"});//出现滚动条
					$state.go('UIProposalManagement');
				}

			}
			//楼梯导航
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
			var keyword = {}
			$$cherry.$proposal.Proposal(keyword, {
				// clauseType: 'F57',
				success: function (_proposal) {
					if (_proposal) {
						$scope.proposal = _proposal;
					}
				}
			})
			$scope.showSave = false;
			$scope.showSaveSuccess = function () {
				$scope.saveTemporaryDisabled=true;
				$scope.showSave = !$scope.showSave;
				$scope.proposal.save('proposalSave', {
					success: function (data) {
						$scope.saveTemporaryDisabled=true;
						console.log('保存成功');
						console.log(data);
					},
					error: function (e) {
					}
				});
			};
			//投保单查询页面的基本信息展开收起按钮
			$scope.isHide = true;
			$scope.isShow = function () {
				$scope.isHide = !$scope.isHide;
			}
			//隐藏编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
			$scope.queryHide = false;
			//angular.element("#riskCode_Class").addClass('currency_information');


			//说明文字展示隐藏
			$scope.explain = false;
			$scope.explainClick = function () {
				$scope.explain = !$scope.explain;
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
		}]);
});