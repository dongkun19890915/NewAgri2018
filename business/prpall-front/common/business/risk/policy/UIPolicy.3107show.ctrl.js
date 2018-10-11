/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'utilities',
    'encodeUrl'
], function (app) {
    'use strict';
    app.registerController('UIPolicy3107show', ['$rootScope', '$scope','$http','$anchorScroll','$location','$$cherry','$$finder','$state','$stateParams', 'commonApiServ', 'regexpConstants', '$$code','$$proposalAPI','$filter','$window',
        function ($rootScope, $scope,$http,$anchorScroll,$location,$$cherry,$$finder,$state,$stateParams,commonApiServ,regexpConstants,$$code,$$proposalAPI,$filter,$window){
            $scope.endorHide=true;//批改时删除和修改按钮隐藏
            $$proposalAPI.initAPI($scope);
            //131073400002018000107
            var keyword={};
            //隐藏保存、暂存、提交核保、上传影像、上一步
            $scope.hideUploadImage = true;
            $scope.showInfoHide = true;
            $scope.pereviousButton = true;
            if($rootScope.systemFlag=="claim"){
                $scope.showClaim=true;
                $scope.policyScheme=true;
            }
            if($rootScope.systemFlag=="undwrt"){
             }
            //分户清单下载不置灰
            $scope.DownloadHouseholdList = false
            //查看核保信息不置灰
            $scope.ViewUnderWriteInfo = false;
            //隐藏核保通过日期、核保人
            $scope.queryHide0 = true;
            $scope.languagePolicySort = true;
            $$cherry.$proposal.Proposal(keyword, {
                // clauseType: 'F57',
                success: function (_proposal) {
                    if (_proposal) {
                        $scope.proposal = _proposal;
                    }
                }
            });
            $scope.return=function(){
                window.history.back();
            }
            //日期为MS应该转为日期
            var msTodata=function(ms){
                return $filter('date')(ms, 'yyyy-MM-dd');
            }
            $scope.disabledContent=true;//特约查看详情不可编辑
            //保单详细信息详情
            $$finder.find('queryPolicyInfoByPolicyNo', {
                "policyNo":$stateParams.policyNo,
                "languageFlag":"zh-CN"
            },{
                success:function(data){
                    $scope.checkedBoxInsured=false;//详细信息隐藏被保险人同投保人按钮
                    console.log(data);
                    var _data=data.content;
                    var obj={}
                    angular.forEach(_data,function(data,index){
                        var n=index.replace(/prpC/,'prpT')
                        obj[n]=data;
                    })
                        $scope.proposal=obj
                        console.log(obj)
                        if(obj.prpTmainDto.policySort=="0"){
                            obj.prpTmainDto.policySort="普通"
                        }else if(obj.prpTmainDto.policySort=="1"){
                            obj.prpTmainDto.policySort="定额"
                        }
                        if(obj.prpTmainDto.language=="C"){
                            obj.prpTmainDto.language="中文"
                        }else if(obj.prpTmainDto.language=="E"){
                            obj.prpTmainDto.language="英文"
                        }else if(obj.prpTmainDto.language=="Z"){
                            obj.prpTmainDto.language="其他语种"
                        }
                        //核保通过日期转换
                        $scope.proposal.prpTmainDto.underwriteEndDate = $filter("date")($scope.proposal.prpTmainDto.underwriteEndDate, "yyyy-MM-dd");
                        //时间格式转换
                        $scope.proposal.prpTmainDto.startDate=msTodata($scope.proposal.prpTmainDto.startDate)
                        $scope.proposal.prpTmainDto.endDate=msTodata($scope.proposal.prpTmainDto.endDate)
                        $scope.proposal.prpTmainDto.operateDate=msTodata($scope.proposal.prpTmainDto.operateDate);
                        $scope.proposal.prpTmainDto.signDate=msTodata($scope.proposal.prpTmainDto.signDate);
                        $scope.proposal.prpTmainDto.inputDate=msTodata($scope.proposal.prpTmainDto.inputDate)
                        $scope.proposal.prpTmainDto.updateDate=msTodata($scope.proposal.prpTmainDto.updateDate)
                        $scope.proposal.prpTmainDto.riskCodeName=obj.prpTmainDto.riskCodeName;
                        $scope.proposal.prpTmainDto=obj.prpTmainDto;//基本信息（不完全）
                        $scope.proposal.prpTmainDto.modelCode=obj.prpTmainDto.groupNo//groupno 模板号码
                        $scope.proposal.prpTmainDto.contractType=obj.prpTmainDto.argueSolution //arguesolution 合同争议解决方式
                        $scope.proposal.prpTmainDto.reMark=obj.prpTmainDto.remark//出单员意见remark
                        $scope.proposal.prpTmainAgriDto=obj.prpTmainAgriDto
                        $scope.proposal.prpDcustomerTaxPayInfoDto=obj.prpDcustomerTaxPayInfoDto//发票购货方信息
                        if (data.content.prpDcustomerTaxPayInfoDto.payInfoObject == "1" ){
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                        }else if(data.content.prpDcustomerTaxPayInfoDto.payInfoObject == "2" ){
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
                        }else {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }
                        //险类名称
                        $scope.proposal.prpTmainDto.className=obj.prpTmainDto.classCodeName
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
							|| $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode=='3149'){
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
							|| $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode=='3149'){
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
                        //茬次次信息赋值
                        var prpTitemKindAgriDtoListCopy=[]
                        if($scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
                            || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102') {
                            angular.forEach(obj.prpTitemKindAgriDtoList, function (_data) {
                                if((_data.distributingRate!=null&&_data.distributingRate!=undefined)
                                    && (_data.timesAmount!=null&&_data.timesAmount!=undefined)
                                    && (_data.stratDate!=null&&_data.stratDate!=undefined)
                                    && (_data.endDate!=null&&_data.endDate!=undefined)){
                                    _data.distributingRate=round(_data.distributingRate,2);
                                    _data.timesAmount=round(_data.timesAmount,2);
                                    prpTitemKindAgriDtoListCopy.push(_data);
                                }
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy=prpTitemKindAgriDtoListCopy;
                        }

                       //政策性
                        if(obj.prpTmainDto.businessType1=='00'){
                            $scope.proposal.prpTmainDto.businessType1Name="商业性"
                        }else if(obj.prpTmainDto.businessType1=='01'){
                            $scope.proposal.prpTmainDto.businessType1Name="中央政策性"
                        }else if(obj.prpTmainDto.businessType1=='02'){
                            $scope.proposal.prpTmainDto.businessType1Name="地方政策性"
                        }
                        //业务大类
                        $scope.parameterConvert.businessCategoryInit();
                        //当时企业团体时证件类型 证件号码不是必填
                        if(obj.prpTinsuredDtoList[0].insuredType=='3'){
                            $scope.feiqiyetuanti=true;
                        }else{
                            $scope.feiqiyetuanti=false;
                        }
                        //客户信息
                        angular.forEach(obj.prpTinsuredDtoList, function (data,index) {
                            //data.businessName=data.businessSource;//行业名称
                            //data.BusinessSort=data.businessSort;//公司性质
                            data.certificateName=data.insuredCode//客户代码
                            $scope.getIdentity(data.insuredType ,data.identifyType);
                            if (data.insuredFlag === "2") {
                                $scope.proposal.appliInsuredDto= data;
                            } else if (data.insuredFlag === "1") {
                                $scope.proposal.insuredDto = data;
                            }
                        });

                        //清单信息
                        $scope.proposal.insureMainListDto=$scope.proposal.insureMainListDto||{}
                        if( obj.gisInsureListDto.gisInsureMainListDto){
                            $scope.proposal.insureMainListDto=obj.gisInsureListDto.gisInsureMainListDto;
                            $scope.proposal.insureMainListDto.insureListCode = obj.gisInsureListDto.gisInsureMainListDto.insureListCode;
                            $scope.proposal.prpTmainDto.businessProvinceName=obj.gisInsureListDto.gisInsureMainListDto.fProvinceName
                            $scope.proposal.prpTmainDto.businessCityName=obj.gisInsureListDto.gisInsureMainListDto.fCityName
                            $scope.proposal.prpTmainDto.businessCountyName=obj.gisInsureListDto.gisInsureMainListDto.fCountyName
                            $scope.proposal.prpTmainDto.businessTownName=obj.gisInsureListDto.gisInsureMainListDto.fTownName
                            $scope.proposal.prpTmainDto.businessAreaName=obj.gisInsureListDto.gisInsureMainListDto.fVillageName

                            if(obj.gisInsureListDto.gisInsureMainListDto.listType=="D"){
                                $scope.proposal.insureMainListDto.listTypeFlag="大户"
                            }else if($scope.proposal.gisInsureListDto.gisInsureMainListDto.listType=="S"){
                                $scope.proposal.insureMainListDto.listTypeFlag="散户"
                            }
                        }
                        $scope.proposal.insureMainListDto.insureListCode= obj.insureListCode//
                        $scope.proposal.prpTaddressDto=obj.prpTaddressDtoList[0];//种植地址
                        $scope.proposal.prpTaddressDto.addressName=$scope.proposal.prpTaddressDto.addressName.replace(/-undefined$/,'')
                        $scope.proposal.prpTplanDtoList=obj.prpTplanDtoList;//缴费计划（不完全）
                        angular.forEach($scope.proposal.prpTplanDtoList,function(data){
                            if(data.payReason=='R10'){
                                data.payReasonName='签单收保费'
                            }else if(data.payReason=='R20'){
                                data.payReasonName='分期收保费'
                            }else if(data.payReason=='RS3'){
                                data.payReasonName='中央财政'
                            }else if(data.payReason=='RS4'){
                                data.payReasonName='省级财政'
                            }else if(data.payReason=='RS5'){
                                data.payReasonName='地市财政'
                            }else if(data.payReason=='RS6'){
                                data.payReasonName='其他来源'
                            }else if(data.payReason=='RS7'){
                                data.payReasonName='县(区)财政'
                            }
                            data.palnRealFee=round(parseFloat(data.planFee-data.delinquentFee),2)
                            data.currency2Name=data.planCurrencyName
                            if(!isNaN(data.planDate)){
                                data.planDate=$filter('date')(data.planDate, 'yyyy-MM-dd');
                                data.planStartDate=$filter('date')(data.planStartDate, 'yyyy-MM-dd');
                            }
                        })
                        $scope.proposal.prpTfeeDto=obj.prpTfeeDtoList[0];//币别信息
                        $scope.currency2Name=obj.prpTfeeDtoList[0].feeCurrencyName2;//支付币别保额

                        //特约信息
                        var prpTengageDtoList=[]
                        angular.forEach(obj.queryProposalPrpTengageDtoList,function(_data){
                            if(_data.clauseCode!="TX001"&&_data.clauseCode!="TX004"){
                                var obj1={
                                    clauses:"",
                                    clauseCode:"",
                                    clausesContent:""
                                }
                                obj1.clauses=_data.clauseName,//特约名称
                                    obj1.clauseCode=_data.clauseCode,//特约代码
                                    obj1.clausesContent=_data.clausesContent//特约内容
                                prpTengageDtoList.push(obj1)
                            }
                        });
                        $scope.proposal.prpTengageDtoCopy=prpTengageDtoList;//特约及附加信息
                        $scope.proposal.engageQueryClause=$scope.proposal.engageQueryClause||{};
                        angular.forEach(obj.queryProposalPrpTengageDtoList,function(data,index){
                            var clausesContent = data.clausesContent;
                            // 绝对免赔率
                            if(data.clauseCode==='TX001'){
                                console.log(clausesContent);
                                $scope.proposal.engageQueryClause.absuDedu = clausesContent;
                            }
                            // 免赔说明
                            if (data.clauseCode==='TX004'){
                                $scope.proposal.engageQueryClause.deduText = clausesContent;
                            }
                        })

                        $scope.totalAmount=$scope.proposal.prpTmainDto.sumAmount;
                        $scope.totalPay=$scope.proposal.prpTmainDto.sumPremium;
                        // 3130保险期间内草莓采收期起始日期begin
                        $scope.proposal.prpTitemKindAgri = $scope.proposal.prpTitemKindAgri || {};
                        if (obj.prpTitemKindAgriDtoList[0].stratDate) {
                            $scope.proposal.prpTitemKindAgri.stratDate = obj.prpTitemKindAgriDtoList[0].stratDate;
                        }
                        if (obj.prpTitemKindAgriDtoList[0].endDate) {
                            $scope.proposal.prpTitemKindAgri.endDate = obj.prpTitemKindAgriDtoList[0].endDate;
                        }
                        // 3130保险期间内草莓采收期起始日期end
                        angular.forEach(obj.prpTitemKindDtoList,function(data,index){
                            data.radioType = data.flag.substr(1,2)== 1?'Y':'N';//给页面主险、附加险按钮赋值
                            data.shortRate=round(data.shortRate,2);
                            data.amount=round(data.amount,2);
                            data.premium=round(data.premium,2)
                            data.unitPremium=round(data.unitPremium,2)
                            if($scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'){
                                data.agriUnitCostMaintitle = '何价投保';
                                data.unitCostName = '元/头';
                                data.proportionName = '%';
                                data.untilName = "元";
                                data.untilName1 = '头';
                                data.untilKindName = "投保头数";
                            }else if ($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                                || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                                || $scope.proposal.prpTmainDto.riskCode=='3130'|| $scope.proposal.prpTmainDto.riskCode=='3129'
                                || $scope.proposal.prpTmainDto.riskCode=='3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
								|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
								|| $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode=='3149'){
                                data.agriUnitCostMaintitle = '单位生产成本';
                                data.unitCostName = '元';
                                data.untilKindName = "投保面积";
                                data.agriUnitOutputMaintitle="单位保险产量";
                                data.agriUnitOutputMainName="公斤";
                                if(data.unitPremium=='0'){
                                    data.unitPremium='';//如果单位保费为0，则置为空
                                }
                            }else if( $scope.proposal.prpTmainDto.riskCode=='3224'){
                                data.untilKindName = "投保面积";
                                data.agriUnitCostMaintitle = '单位保险产量';
                                data.unitCostName = '公斤';
                                data.agriUnitOutputMainName="公斤";
                                data.untilName = "元/亩";//单位名称
                                data.untilName1 = '亩';
                            }else if($scope.proposal.prpTmainDto.riskCode=='3237'){
                                data.untilName = "元/亩";
                                data.untilKindName = "投保面积";
                                data.untilName1 = '亩';
                            }else if($scope.proposal.prpTmainDto.riskCode=='3237'||$scope.proposal.prpTmainDto.riskCode=='3134'
                                ||$scope.proposal.prpTmainDto.riskCode=='3147'||$scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
                                data.untilName = "元/亩";
                                data.untilKindName = "投保面积";
                                data.untilName1 = '亩';
                            }
                            if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                                || $scope.proposal.prpTmainDto.riskCode == '3141'|| $scope.proposal.prpTmainDto.riskCode=='3102') {
                                angular.forEach(obj.prpTitemKindDtoList, function (data_1, index) {
                                    angular.forEach(obj.prpTitemKindAgriDtoList, function (_data, index) {
                                        if (_data.times<=0 && data_1.itemKindNo==_data.itemKindNo) {
                                            data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                        }
                                    });
                                });
                            } else {
                                angular.forEach(obj.prpTitemKindDtoList, function (data_1, index) {
                                    angular.forEach(obj.prpTitemKindAgriDtoList, function (_data) {
                                        if (data.itemKindNo == _data.itemKindNo) {
                                            data_1.agriGrossQuantityMain = _data.grossQuantity;//投保面积
                                            data_1.agriUnitCostMain = _data.unitCost;//单位生产成本
                                            if(_data.unitOutput){
                                                data_1.agriUnitOutputMain=_data.unitOutput//单位保险产量
                                            }
                                            data_1.agriTimesAmount = _data.timesAmount;//约定单价
                                            data_1.proportion = _data.proportion;//投保成数
                                        }
                                    })
                                });
                            }
                        })
                        //归属机构
                        $scope.getComCodeList();
                        //归属业务员
                        $scope.getHanCode({comCName:$scope.proposal.prpTmainDto.comName},$scope.proposal.prpTmainDto.handler1Code);
                        //投保方式
                    //if($rootScope.systemFlag=='claim'){
                        $scope.policy=true;
                        $scope.proposal.prpTmainDto.handler1Code1=$scope.proposal.prpTmainDto.tHandler1Name;
                        $scope.proposal.prpTmainDto.comCodename1= $scope.proposal.prpTmainDto.comName;
                    //}
                        $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode,obj.prpTmainDto.policyType)//投保方式下拉初始化获取
                    //      共保
                    //        if(obj.prpTmainDto.coinsFlag!=0){
                    //            $scope.proposal.prpTmainDto.coinsFlag=obj.prpTmainDto.coinsFlag;
                    //            $scope.proposal.prpTmainDto.coinsPremiumType=obj.prpTmainDto.coinsPremiumType;
                    //            $scope.PremiumShow=true;
                    //            $scope.proposal.prpTcoinsDtoList=_data.prpCcoinsDtoList;
                    //            $scope.proposal.prpTcoinsDetailDtoList=_data.prpCcoinsDetailDtoList;
                    //        }else{
                    //            $scope.PremiumShow=false;
                    //        }
                    //共保信息
                    $scope.otherQueryHide=true;
                    if ($scope.proposal.prpTplanCoinsDtoList && $scope.proposal.prpTplanCoinsDtoList.length > 0
                        && $scope.proposal.prpTcoinsDetailDtoList && $scope.proposal.prpTcoinsDetailDtoList.length > 0
                        && $scope.proposal.prpTplanCoinsDtoList.length > 0) {
                        $scope.PremiumShow = true;
                        $scope.showCoins = false;
                        $scope.isHide = false;
                        $scope.proposal.otherAgentFeeShow = false;
                        //$scope.proposal.showCoinsInfo();//显示共保信息
                        //$rootScope.$emit("proposal.showCoinsInfo()",{});
                    }
                }
                })
            //返回按钮
            $scope.returnButton = function(){
               if($stateParams.norepeat){
                   $window.history.back();
                }else{
                   window.close();
                }
            }
             //点击上一步
            $scope.perevious=function($event){

                if($scope.proposalQueryHide){
                    $rootScope.goBackDashboard();
                }
                if($scope.endorseFlag){
                    $event.preventDefault();
                }
                else{
                    $scope.$emit('closeRiskScheme',true);
                }
            }

            // 将页面的input变成只读状态
            //隐藏编辑类型字段
            $scope.initFlag = true;// 初始化标志  初始化完成后置为 false  默认true初始化状态
            $scope.showRiskScheme = false; //出单向导弹窗
            $scope.queryHide = true;//显示编辑类型字段
            $scope.proposalQueryHide=true;//设置只读
            //楼梯导航
            $scope.goBasic=function(){
                $location.hash("basic");
                $anchorScroll();
            };
            $scope.goContract=function(){
                $location.hash("contract");
                $anchorScroll();
            };
            $scope.goClient=function(){
                $location.hash("client");
                $anchorScroll();
            };
            $scope.goOthers=function(){
                $location.hash("others");
                $anchorScroll();
            };
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
                            $("html,body").css({overflow:"hidden"});//隐藏滚动条
                        }else{
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                scrollbar: false,
                                title: '温馨提示',
                                content: '未查询到核保信息',
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
            //$scope.showSave=false;
            //投保单查询页面的基本信息展开收起按钮
            $scope.isHide=true;
            $scope.isShow=function(){
                $scope.isHide=!$scope.isHide;
            }

            //说明文字展示隐藏
            $scope.explain=false;
            $scope.explainClick=function(){
                $scope.explain=!$scope.explain;
            };

            //上传影像
            $scope.upLoading = function () {
                console.log("影像上传")
                $$finder.find("transportXML", {
                    "businessNo": $scope.proposal.prpTmainDto.policyNo,
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
                    "businessNo": $scope.proposal.prpTmainDto.policyNo, //业务单号
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
        }]);
});