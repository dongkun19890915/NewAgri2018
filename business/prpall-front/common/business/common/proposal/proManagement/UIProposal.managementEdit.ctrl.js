/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIproposaleditCtrl',
        ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$$cherry', '$$finder', '$stateParams', '$state','$$proposalAPI','$filter',
            function ($rootScope, $scope, $http, $anchorScroll, $location, $$cherry, $$finder, $stateParams, $state,$$proposalAPI,$filter) {
                $scope.endorHide=true;//批改时删除和修改按钮隐藏
                //去掉模板必填标志
                $scope.hideStar = true;
                //将归属机构隐藏
                $scope.handler1CodeShow="true";
                $scope.queryHide0=true;
                $scope._calculatePremium="0";
                $scope.showRiskScheme = true;  //出单向导弹窗

                //投保方式初始化
                //级联获取下拉列表***************************************start
                $scope.initFlag = false;// 初始化标志  初始化完成后置为 false  默认true初始化状态
                $$proposalAPI.initAPI($scope);
                $scope.return=function(){
                    window.history.back();
                }
                //级联获取下拉列表***************************************end
                //关闭模板向导
                $scope.$on('closeRiskScheme', function (event, data) {
                    $scope.showRiskScheme = data;
                });
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
                };

                var getModelCode=function(){
                    $scope._modelCode=$scope.proposal.prpTmainDto.modelCode;
                }
                $$cherry.$proposal.Proposal({}, {
                    success: function (_proposal) {
                        if (_proposal) {
                            $scope.proposal = _proposal;
                        }
                    }
                });

                //修改方案
                $scope.riskScheme = function () {
                    $rootScope.comTreeCtrlCommentFlag=false;
                    $rootScope.comTreeCtrlFlag=false;
                    $scope.showRiskScheme = true;
                }
                //$scope.proposal.calculatePremium="0";
                //获取归属机构
                $scope.selectListData = {};
                $scope.getComCode = function () {
                    $$finder.find('queryComCodeInfo',{
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "userCode": $scope.user.userCode,
                        "loginComCode": $scope.user.loginComCode,
                        "gradeCodes": "",
                        "comCode": "",
                        "comCName": ""
                    }, {
                        success: function (data) {
                            $scope.selectListData.comCodeList = data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    })
                }

                //    保存按钮
                var keyword = {};
                $$cherry.$proposal.Proposal(keyword, {
                    // clauseType: 'F57',
                    success: function (_proposal) {
                        if (_proposal) {
                            $scope.proposal = _proposal;
                        }
                    }
                });

                    //获取费率除数
                $scope.getrateDivisor = function (data) {
                    $scope.rateDivisor = data;
                };
                //获取适用机构
                $scope.getComCodeTree=function(data){
                    $rootScope.treecheck=data;
                };
                $scope.showSave = false;

                //模板保存，暂存 a==1是保存 a==0是暂存
                $scope.showSaveSuccess = function (a) {
                    $scope.prpMmodelMainDto=$scope.proposal.prpMmodelMainDtoTem;
                    $scope.saveTemporaryDisabled=true;
                   console.log($scope.totalAmount);
                    $scope.proposal.prpMmodelMainDto = $scope.proposal.prpMmodelMainDto || {};
                    var createDate=$filter('date')(new Date(),'yyyy-MM-dd');
                    $scope.proposal.prpMmodelMainDto.createDate=createDate;
                    if (a=="1"){
                        $scope.proposal.prpMmodelMainDto.flag="1";
                    }else if(a=="0"){
                        $scope.proposal.prpMmodelMainDto.flag="0";
                    }
                    //如果原币为空，默认为RMB
                    if (!$scope.proposal.prpTfeeDto.currency){
                        $scope.proposal.prpTfeeDto.currency='CNY'
                    }

                    //模板配置主表
                    $scope.proposal.prpMmodelMainDto.remark = $scope.prpMmodelMainDto.riskScheme,//模板创建类型
                    $scope.proposal.prpMmodelMainDto.operatorCode = $rootScope.user.userCode,//操作人
                    $scope.proposal.prpMmodelMainDto.updateOpCode = $rootScope.user.userCode,//最近修改人
                    $scope.proposal.prpMmodelMainDto.modelName = $scope.prpMmodelMainDto.modelName,//模板名称,
                    $scope.proposal.prpMmodelMainDto.riskCode = $scope.proposal.prpTmainDto.riskCode,//险种代码
                    $scope.proposal.prpMmodelMainDto.startDate = $scope.prpMmodelMainDto.startDate,//有效起期
                    $scope.proposal.prpMmodelMainDto.endDate = $scope.prpMmodelMainDto.endDate,//有效止期
                    $scope.proposal.prpMmodelMainDto.validStatus = $scope.prpMmodelMainDto.validstatus;//模板状态
                    $scope.proposal.prpMmodelMainDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
                    //模板机构配置表
                    $scope.proposal.prpMmodelComDto = $scope.proposal.prpMmodelComDto || {};
                    //$scope.proposal.prpMmodelComDto.comCode =$scope.prpMmodelMainDto.institutions//适用机构
                    //$scope.proposal.prpMmodelComDto.comCode = $scope.proposal.prpTmainDto.com//适用机构
                    $scope.proposal.prpMmodelComDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
                    $scope.prpMmodelComDtolist=[];
                    $rootScope.treecheck=$rootScope.treecheck||[];
                    angular.forEach($rootScope.treecheck,function(item,index){
                        if(item.id){
                            $scope.prpMmodelComDtolist.push({
                                "comCode": item.id,
                                "comName": item.n,
                                "flag":"1",
                                "modelCode":$scope.prpMmodelMainDto.modelCode,
                                "containFlag":"" //是否包含下级机构
                            });
                        }else{
                            $scope.prpMmodelComDtolist.push({
                                "comCode": item.comCode,
                                "comName": item.n,
                                "flag":"1",
                                "modelCode":$scope.prpMmodelMainDto.modelCode,
                                "containFlag":"" //是否包含下级机构
                            });
                        }

                    });
                    // 模板保险地址表
                    $scope.proposal.prpModelAddressSubDto = $scope.proposal.prpModelAddressSubDto || {};
                    $scope.proposal.prpModelAddressSubDto.addressNo = $scope.proposal.prpTaddressDto.addressNo,//地址序号
                    $scope.proposal.prpModelAddressSubDto.addressName = $scope.proposal.prpTaddressDto.addressName,//地址
                    $scope.proposal.prpModelAddressSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    $scope.proposal.prpModelAddressSubDto.addressCode = "10000",//地址编码
                    $scope.proposal.prpModelAddressSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码


                        //模板农业险保单信息
                        $scope.proposal.prpModelMainAgriSubDto = $scope.proposal.prpModelMainAgriSubDto || {};
                    $scope.proposal.prpModelMainAgriSubDto.remark = $scope.proposal.prpTmainAgriDto.remark,//保险金额确定方式
                        $scope.proposal.prpModelMainAgriSubDto.raiseDate = $scope.proposal.prpTmainAgriDto.raiseDate,//种植时间
                        $scope.proposal.prpModelMainAgriSubDto.riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                    $scope.proposal.prpModelMainAgriSubDto.raiseSite = $scope.proposal.prpTaddressDto.addressName;//养殖地点
                    $scope.proposal.prpModelMainAgriSubDto.observeStartHour = 0,
                    $scope.proposal.prpModelMainAgriSubDto.observeEndHour = 24,
                    $scope.proposal.prpModelMainAgriSubDto.modelCode=$scope.prpMmodelMainDto.modelCode;//模版号码
                    $scope.proposal.prpModelMainAgriSubDto.relationListNo=$scope.proposal.prpTmainAgriDto.relationListNo;//我方清单号
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
                    $scope.proposal.prpModelMainSubDto.endDate = $scope.proposal.prpTmainDto.endDate;//保险期间
                    $scope.proposal.prpModelMainSubDto.endHour = $scope.proposal.prpTmainDto.endHour,//保险期间
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
                    $scope.proposal.prpModelMainSubDto.statQuantity = $scope.proposal.prpTmainDto.statQuantity//承保数量
                    $scope.proposal.prpModelMainSubDto.sumInsured = $scope.proposal.prpTmainDto.sumInsured,//参保农户户次
                    //$scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount,//总保额
                    //$scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay,//总保费
                    $scope.proposal.prpModelMainSubDto.currency = $scope.proposal.prpTfeeDto.currency2,//汇总币别
                    $scope.proposal.prpModelMainSubDto.payTimes = $scope.proposal.prpTmainDto.payTimes,//缴费期次
                    $scope.proposal.prpModelMainSubDto.coinsFlag = $scope.proposal.prpTmainDto.coinsFlag,//共保标志
                    $scope.proposal.prpModelMainSubDto.coinsPremiumType = $scope.proposal.prpTmainDto.coinsPremiumType,//保单缴费类型
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
                    $scope.proposal.prpModelMainSubDto.policySort = $scope.proposal.prpTmainDto.policySort,//保单种类
                    $scope.proposal.prpModelMainSubDto.underwriteEndDate=$scope.proposal.prpTmainDto.underwriteEndDate,//核保通过日期
                    $scope.proposal.prpModelMainSubDto.underwriteName=$scope.proposal.prpTmainDto.underwriteName,//核保人
                    //$scope.proposal.prpModelMainSubDto.makeCom = $scope.proposal.prpTmainDto.comCode;//出单机构代码
                    $scope.proposal.prpModelMainSubDto.makeCom = $rootScope.user.makeCom;//出单机构代码
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
                    var prpModelItemKindDtoListCopy = [];
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
                        prpModelItemKindDtoListCopy.push(data);
                    })
                    $scope.proposal.prpModelItemKindDtoList=prpModelItemKindDtoListCopy;

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
                    $scope.proposal.prpModelItemKindAgriDtoList = prpModelItemKindAgriDtoListCopy
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
                    if ($scope. proposal.engageQueryClause.absuDedu) {
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
                        obj1.clauses = $scope. proposal.engageQueryClause.absuDedu;
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



                    //被保险人
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
                        "prpMmodelComDtoList": $scope.prpMmodelComDtolist,
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
                            $scope.saveTemporaryDisabled=false;
                            if (data.code == "0000") {
                            var content="";
                            if (a=="1"){
                                content="保存成功，模板号为："+$scope.prpMmodelMainDto.modelCode;
                            }else if (a=="0"){
                                content="暂存成功，模板号为："+$scope.prpMmodelMainDto.modelCode;
                            }
                                layer.open({
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
                                $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go('UIProposalManagement');

                            } else {
                                var content="";
                                if (a=="1"){
                                    content="保存失败";
                                }else if (a=="0"){
                                    content="暂存失败";
                                }
                                layer.open({
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
                            }

                        },
                        error: function (e) {
                            console.log(e);
                        }
                    });


                };
                //投保单模版弹层显示隐藏
                $scope.closeRiskScheme = function () {
                    $scope.showAdminRisk = true;
                }
                //提交核保
                $scope.commitUnderwrite = function () {
                    $scope.showSave = !$scope.showSave;
                    layer.open({
                        area: ['37%', '318px'],
                        offset: ['28%', '30%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '提交核保成功',
                        content: '提交核保成功',
                        btn: ['再录一单', '返回主页']
                        , btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go("UIproposal3107edit", {}, {reload: true});
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
    }]);
});