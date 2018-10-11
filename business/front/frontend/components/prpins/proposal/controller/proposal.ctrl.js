/**
 * Created by ZhangJiansen on 2016/9/10.
 * Controller层只处理视图数据绑定，后端交互在service处理
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var proposalCtrl = function($q,$rootScope,$scope,$filter,$state,proposalServ,insuredServ,
                                    cusLayerServ,teamLayerServ,$stateParams,$timeout,
                                    FormFocus,QuerySelectCode,$interval,FileUploader,$location,$sce)
    {
        $scope.policy = {};
        $scope.policy.prpTmain = {};
        $scope.policy.prpTinsured = {};
        $scope.policy.prpTinsured.insuredType = "1";
        $scope.agentFlag = true;
        $scope.insTypeLeft = true;
        $scope.insTypeRight = true;
        $scope.personalFlag = true;
        $scope.SexManFlag = true;
        $scope.SexWomanFlag = true;
        $scope.stuFlag = true;
        $scope.stuZFlag = true;
        $scope.onlineFlag = true;
        $scope.lineFlag = true;
        /*性别初始化设置*/
        $scope.insuredSexManFlag = true;
        $scope.insuredSexWomanFlag = false;

        $scope.houseCityFlag = true;
        $scope.houseCountryFlag = true;
        /*是否整修初始化设置*/
        $scope.refurbishedYesFlag = true;
        $scope.refurbishedNoFlag = true;

        /*建筑类型初始化设置*/
        $scope.buildTypeFlag =true;
        $scope.buildTypeSqueryFlag =false;

        $scope.payType = true;
        $scope.changeInsureType = 'components/prpins/proposal/tpl/applicationPersonal.html';
        $scope.publicDeleteLayer = false;
        $scope.publicDeleteLayerOne = false;
        $scope.publicOnLineLayer = false;
        $scope.publicOffLineLayer = false;
        $scope.insuredOnlyOneLayer = true;
        $scope.publicHtmlLayer = true;
        $scope.insuredMustOneLayer = false;
        $scope.insuredBatchOnlyGroupLayer = false;
        $scope.insuredStructrueLayer = false;
        /*默认出单省级机构必填*/
        $scope.companyRequired=true;
        /*仲裁机构名称*/
        $scope.argues=false;
        $scope.processImport = false;
        $scope.showErrMsg = false;
        $scope.partsFailure = false;
        $scope.downloadSpan = false;
        $scope.uploadSuc = false;
        $scope.insuredsHasErrLayer = false;
        $scope.downloadHistoryLayer = false;
        $scope.amountFlag = false;
        //EQ02
        $scope.SubsidyQueryConditionDto = {};
        $scope.PrpDSubsidyDetailDto = {};
        $scope.subsidyFlag = false;
        $scope.readFlag = false;
        $scope.maskLayer = false;
        $scope.indexFlag = false;
        var dataValue;
        var _windowH = $(window).height();
        if(!$scope.excelFile){
            $scope.excelFile={prpExcelFileIndexDto:{},prpExcelFileMainDto:{}};
            $scope.prpExcelFile={}
        }

        var clauseCode;

        /*投保日期应该为当前日期*/
        var operateDate = new Date();
        $scope.maxOperateDate = $filter("date")(operateDate, "yyyy-MM-dd");
        /*建筑结构*/
        $scope.structureClick = function(){
            $scope.insuredStructrueLayer = true;
        };
        $scope.structureClose = function(){
            $scope.insuredStructrueLayer = false;
        };

        var parmasRiskCode = $stateParams.riskCode;
        $rootScope.riskCode = parmasRiskCode;

        //if(!parmasRiskCode){
        //    parmasRiskCode = "EQ01";
        //}
        $scope.emailRequiredFlag = true;
        function proposalInit(){
            if(parmasRiskCode == 'EQ02'){
                $scope.emailRequiredFlag = false;
                //保险起期应在当前日期前后两个月
                var minDate = new Date();
                minDate.setMonth(minDate.getMonth()-2);
                var maxDate = new Date();
                maxDate.setMonth(maxDate.getMonth()+2);
                $scope.minStartDate = $filter("date")(minDate, "yyyy-MM-dd");
                $scope.maxStartDate = $filter("date")(maxDate, "yyyy-MM-dd");
            }else{
                //保险起期应在当前日期前后七天内
                var minDate = new Date();
                minDate.setDate(minDate.getDate()-7);
                var maxDate = new Date();
                maxDate.setDate(maxDate.getDate()+7);
                $scope.minStartDate = $filter("date")(minDate, "yyyy-MM-dd");
                $scope.maxStartDate = $filter("date")(maxDate, "yyyy-MM-dd");
            }
        }
        proposalInit();

        /*监听投保日期变化，不符合条件清空*/
        $scope.$watch('policy.prpTmain.operateDate',function(){
            if($scope.policy.prpTmain.operateDate !="" && $scope.policy.prpTmain.operateDate !=undefined){
                var chooseTime=$scope.policy.prpTmain.operateDate.replace(/\-/g,"/");
                var a1=new Date(chooseTime).getTime();
                var a2=new Date().getTime();
                if(a1>a2){
                    $scope.policy.prpTmain.operateDate="";
                }
            }
        });
       /*监听保单生效日变化，不符合条件清空*/
        $scope.$watch('policy.prpTmain.startDate',function(){
            if($scope.policy.prpTmain.startDate !="" && $scope.policy.prpTmain.startDate !=undefined){
                var chooseTime=$scope.policy.prpTmain.startDate.replace(/\-/g,"/");
                var minDate=$scope.minStartDate.replace(/\-/g,"/");
                var maxDate=$scope.maxStartDate.replace(/\-/g,"/");
                var a1=new Date(chooseTime).getTime();
                var a2=new Date(minDate).getTime();
                var a3=new Date(maxDate).getTime();
                if(a1<a2 || a1>a3){
                    $scope.policy.prpTmain.startDate="";
                }
            }
        });
        //获取待处理投保单数据
        if($stateParams.continueData == null ||$stateParams.continueData == ''){
            //初始化界面
            var initMain = function(){
                proposalServ.moduleInit().then(
                    function(answer){
                        var parmasRisk= parmasRiskCode;
                        $scope.riskList = answer.data.riskConfig[parmasRisk];
                        /*投保录入页面初始化*/
                        var prptmain = new Object();
                        prptmain.riskCode = parmasRiskCode;
                        prptmain.classCode = '01';
                        prptmain.proposalNo = '';
                        var proposalDTO = {"prpTmain":prptmain};
                        proposalServ.initProposal(proposalDTO).then(
                            function(answer){
                                $scope.policyCodeMap = answer.data;
                                var proposalNo = answer.data.proposalDto.prpTmain.proposalNo;
                                var prptmain = {};
                                var startDate=answer.data.proposalDto.prpTmain.startDate;
                                var endDate=answer.data.proposalDto.prpTmain.endDate;
                                prptmain.proposalNo = proposalNo;
                                prptmain.riskCode = answer.data.proposalDto.prpTmain.riskCode;
                                prptmain.startDate = $filter("date")(startDate, "yyyy-MM-dd").substr(0,10);
                                prptmain.endDate =  $filter("date")(endDate, "yyyy-MM-dd").substr(0,10);
                                prptmain.operateDate = answer.data.proposalDto.prpTmain.operateDate;
                                prptmain.companyCode = answer.data.proposalDto.prpTmain.companyCode;
                                prptmain.comCode = answer.data.proposalDto.prpTmain.comCode;
                                prptmain.cityCode = answer.data.proposalDto.prpTmain.cityCode;
                                prptmain.makeCom = answer.data.proposalDto.prpTmain.makeCom;
                                prptmain.handler1Code = answer.data.proposalDto.prpTmain.handler1Code;
                                prptmain.handler1Name = answer.data.proposalDto.prpTmain.handler1Name;
                                prptmain.operatorCode = answer.data.proposalDto.prpTmain.operatorCode;
                                prptmain.operatorName = answer.data.proposalDto.prpTmain.operatorName;
                                prptmain.handlerCode = '';
                                prptmain.handlerName = '';
                                prptmain.contractNo = '';
                                clauseCode = answer.data.proposalDto.clauseCode;
                                var prpinsured = {};
                                prpinsured.insuredType = '1';
                                prptmain.arguesolution = '1';
                                prptmain.payMode = '01';
                                prptmain.proposalNo = proposalNo;
                                //投保人性别赋值
                                var prpTinsuredNatureDto ={};
                                prpTinsuredNatureDto.sex = '1';
                                prpinsured.prpTinsuredNatureDto = prpTinsuredNatureDto;
                                //给组织四证赋默认值
                                var prpTinsuredArtifDto ={};
                                prpTinsuredArtifDto.organizeCode = '';
                                prpTinsuredArtifDto.businessCode= '';
                                prpTinsuredArtifDto.revenueRegistNo= '';
                                prpTinsuredArtifDto.creditCode= '';
                                prpinsured.prpTinsuredArtifDto = prpTinsuredArtifDto;
                                $scope.policy = {"prpTmain":prptmain,"prpTinsured":prpinsured};
                                $scope.identifyTypeInit = function(){
                                    $scope.policy.prpTinsured.identifyType = "01";
                                };
                                var proposalDatas_COPY = angular.copy($scope.policy);
                                $timeout(function(){
                                    $scope.policy = proposalDatas_COPY;
                                },1000);
                                $scope.indexFlag = true;
                            },function(error){
                                //console.log(JSON.stringify(error.data));
                            }
                        );
                    },function(error){
                        console.log(JSON.stringify(error.data));
                    }
                );
            };
            initMain();
        }else if (editType == 'copy'){
            var copyObjectId = $stateParams.copyObjectId;
            var proposalDto = new Object();
            proposalDto.proposalNo = proposalNo;
            proposalDto.copyObjectId = copyObjectId;
            proposalServ.copyPrpoposalOrPolicy(proposalDto).then(
                function(answer){
                    if (answer.data.resultCode == '0000'){
                        if(answer.data.prpTinsured.insuredType == '1'){
                            if(answer.data.prpTinsured.prpTinsuredNatureDto.sex == '1'){
                                $scope.SexManFlag = true;
                                $scope.SexWomanFlag = true;
                            }else{
                                $scope.SexManFlag = false;
                                $scope.SexWomanFlag = false;
                            }
                        }
                        if(answer.data.prpTmain.arguesolution == '1'){
                            $scope.stuFlag = true;
                            $scope.stuZFlag = true;
                        }else{
                            $scope.stuFlag = false;
                            $scope.stuZFlag = false;
                        }
                        if(answer.data.prpTinsured.insuredType == 2){
                            $scope.insTypeLeft = false;
                            $scope.insTypeRight = false;
                            $scope.payType = false;
                            $scope.changeInsureType = 'components/prpins/proposal/tpl/applicationGroup.html';
                        }
                        if(answer.data.prpTmain.payMode == '02'){
                            $scope.onlineFlag = false;
                            $scope.lineFlag = false;
                        }
                        $scope.identifyTypeInit = function(){
                            if(answer.data.prpTinsured.identifyType == undefined){
                                answer.data.prpTinsured.identifyType = '01';
                            }
                            $scope.policy.prpTinsured.identifyType = answer.data.prpTinsured.identifyType;
                        };
                        $scope.policy = answer.data;
                        $scope.copyObjectId = copyObjectId;
                        $scope.insureDatas = $scope.policy.prpTinsuredPropDtos;
                    }else{
                        console.log(answer.data.resultMsg);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        }else{
            var editType = $stateParams.editType;
            var proposalNo = $stateParams.continueData;
            if (editType == 'editProposal'){
                var prpTmainKeyDto = {};
                prpTmainKeyDto.proposalNo = proposalNo;
                prpTmainKeyDto.editType = editType;
                prpTmainKeyDto.pageSize = '5';
                prpTmainKeyDto.pageNo = '1';
                proposalServ.queryProposalInfo(prpTmainKeyDto).then(
                    function(answer){
                        var proposalDatas = answer.data;
                        var riskCode = answer.data.prpTmain.riskCode;
                        parmasRiskCode = riskCode;
                        if(parmasRiskCode == 'EQ02') {
                            $scope.emailRequiredFlag = false;
                        }
                        $rootScope.riskCode = parmasRiskCode;
                        proposalInit();
                        proposalServ.moduleInit(riskCode).then(
                            function(answer) {
                                var parmasRisk = riskCode;
                                $scope.riskList = answer.data.riskConfig[parmasRisk];
                                if(proposalDatas.prpTinsured.insuredType == '1' || proposalDatas.prpTinsured.insuredType == undefined){
                                    proposalDatas.prpTinsured.insuredType = '1';
                                    $scope.policy.prpTinsured.insuredType = proposalDatas.prpTinsured.insuredType;
                                    $scope.insTypeRight = true;
                                    $scope.personalFlag = true;
                                    if(undefined == proposalDatas.prpTinsured.prpTinsuredNatureDto || proposalDatas.prpTinsured.prpTinsuredNatureDto.sex == '1'){
                                        $scope.SexManFlag = true;
                                        $scope.SexWomanFlag = true;
                                    }else{
                                        $scope.SexManFlag = false;
                                        $scope.SexWomanFlag = false;
                                    }
                                }else if($scope.policy.prpTinsured.insuredType == '2'){
                                    $scope.policy.prpTinsured.insuredType = proposalDatas.prpTinsured.insuredType;
                                }
                                if(proposalDatas.prpTmain.arguesolution == undefined || proposalDatas.prpTmain.arguesolution == ''){
                                    $scope.stuFlag = true;
                                    $scope.stuZFlag = true;
                                    $scope.policy.prpTmain.arguesolution = '1';
                                }else{
                                    if(proposalDatas.prpTmain.arguesolution == '1'){
                                        $scope.stuFlag = true;
                                        $scope.stuZFlag = true;
                                    }else{
                                        $scope.stuFlag = false;
                                        $scope.stuZFlag = false;
                                    }
                                }
                                if(proposalDatas.prpTinsured.insuredType == '2'){
                                    $scope.insTypeLeft = false;
                                    $scope.insTypeRight = false;
                                    $scope.payType = false;
                                    $scope.changeInsureType = 'components/prpins/proposal/tpl/applicationGroup.html';
                                    $scope.insTypeRight = false;
                                    $scope.personalFlag = false;
                                }
                                if(proposalDatas.prpTmain.payMode == '02'){
                                    $scope.onlineFlag = false;
                                    $scope.lineFlag = false;
                                }
                                if(proposalDatas.prpTinsured.identifyType == undefined){
                                    proposalDatas.prpTinsured.identifyType = '01';
                                    $scope.policy.prpTinsured.identifyType = proposalDatas.prpTinsured.identifyType;
                                    $scope.identifyTypeInit = function(){
                                        if(!$scope.policy.prpTinsured.identifyType){
                                            $scope.policy.prpTinsured.identifyType = proposalDatas.prpTinsured.identifyType;
                                        }
                                    };
                                }
                                $scope.policy = proposalDatas;
                                $scope.insureDatas = $scope.policy.prpTinsuredPropDtos;
                                $scope.subsidyList = $scope.policy.prpTSubsidyDtos;
                                $scope.SubsidyQueryConditionDto.subsidyType = $scope.policy.subsidyType;
                                $scope.planDtos = $scope.policy.prpTplanDtos;
                                $scope.paginationConf.totalItems = proposalDatas.totalCount;
                                clauseCode = $scope.policy.clauseCode;
                                if(proposalDatas.prpTmain.arguesolution == undefined || proposalDatas.prpTmain.arguesolution == ''){
                                    $scope.stuFlag = true;
                                    $scope.stuZFlag = true;
                                    $scope.policy.prpTmain.arguesolution = '1';
                                }else {
                                    if(proposalDatas.prpTmain.arguesolution == '1'){
                                        $scope.stuFlag = true;
                                        $scope.stuZFlag = true;
                                        $scope.argues=false;
                                    }else{
                                        $scope.stuFlag = false;
                                        $scope.stuZFlag = false;
                                        $scope.argues=true;
                                    }
                                }
                                if(undefined != proposalDatas.hasProcess && 'true'==proposalDatas.hasProcess){
                                    $scope.processImport = true;
                                    $scope.beginQueryImport(null,proposalDatas.progressList);
                                }
                                if(undefined != proposalDatas.hasErr && 'true'==proposalDatas.hasErr){
                                    $scope.insuredsHasErrLayer = false;
                                    $scope.uploadSuc = false;
                                    $scope.downloadSpan = true;
                                }else if('true'== proposalDatas.hasErr){
                                    $scope.insuredsHasErrLayer = true;
                                }
                                if(null == $scope.policy.prpTmain.payMode || undefined == $scope.policy.prpTmain.payMode){
                                    $scope.policy.prpTmain.payMode = '01';
                                }
                                var proposalDatas_COPY = angular.copy(proposalDatas);
                                $timeout(function(){
                                    checkFlag = true;
                                    $scope.policy = proposalDatas_COPY;
                                    $scope.subsidyList =proposalDatas_COPY.prpTSubsidyDtos;
                                    $scope.SubsidyQueryConditionDto.subsidyType = proposalDatas_COPY.subsidyType;
                                    $scope.planDtos = $scope.policy.prpTplanDtos;

                                    calSumAmountAndSumPremium();
                                    var DetailDtosTemp = $scope.subsidyList;
                                    var subsidyList = [];
                                    if($scope.SubsidyQueryConditionDto.subsidyType != '' || $scope.SubsidyQueryConditionDto.subsidyType != undefined) {
                                        angular.forEach(DetailDtosTemp, function (data, index, array) {
                                            if (data.subsidyTyp == '03') {
                                                data.readFlag = true;
                                            } else {
                                                if (data.subsidyCode == '03' || data.subsidyCode == '04') {
                                                    data.readFlag = false;
                                                } else {
                                                    data.readFlag = true;
                                                }
                                            }
                                            subsidyList.push(data);
                                        });
                                        $scope.subsidyList = subsidyList;
                                    }
                                    dataValue = $scope.SubsidyQueryConditionDto.subsidyType;
                                },1000);
                                $scope.indexFlag = true;
                            },function(error){
                                console.log(JSON.stringify(error.data));
                            }
                        );
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }
        }

        /* 复制 保单 或者 投保单*/
        $scope.copyProposalOrPolicy = function(){
            var copyObjectId = $scope.copyObjectId;
            var proposalNo = $scope.policy.prpTmain.proposalNo;
            var editType = 'copy';
            $state.go("main.application",{"continueData":proposalNo,"editType":editType,"copyObjectId":copyObjectId});
        };
        /*查询被保人清单*/
        var searchFlalg = false;
        var getInsuredList = function(){
            var insuredQueryConditionDto = {};
            insuredQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            insuredQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            insuredQueryConditionDto.proposalNo = $scope.policy.prpTmain.proposalNo;
            var currentPageNum=$scope.paginationConf.currentPage;
            var pageListLength=$scope.paginationConf.itemsPerPage;
            insuredServ.queryInsuredPrp(insuredQueryConditionDto).then(
                function(answer){
                    if(answer.data == null){
                        return;
                    }else{
                        $scope.paginationConf.totalItems = answer.data.totalCount;
                        $scope.insureDatas = answer.data.list;
                        for(var i=0;i<$scope.insureDatas.length;i++){
                            $scope.insureDatas[i].listNum=(i+1)+(currentPageNum-1)*pageListLength;
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        //初始化界面
        var initFunPageInfo = function(){
            //初始化分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);
        };
        initFunPageInfo();

        /*投保单提交*/
        $scope.cannotSubmit=false;
        function onSub(){
            $scope.cannotSubmit=true;
            var data = angular.copy($scope.policy);
            var sum = 0;
            //sumAmount的单位是万元，这里要乘以10000
            data.prpTmain.sumAmount = data.prpTmain.sumAmount * 10000;
            data.riskCode = $scope.policy.prpTmain.riskCode;
            if(parmasRiskCode == 'EQ02'){
                var DetailDtosTemp = $scope.subsidyList;
                data.prpTSubsidyDtos = $scope.subsidyList;
                data.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                //var arr = [];
                angular.forEach(DetailDtosTemp, function (data,index,array) {
                    if(!data.subsidyRate){
                        data.subsidyRate = 0;
                    }
                    if(data.subsidyType == '02'){
                        if (data.subsidyCode  == '02' || data.subsidyCode  == '03' || data.subsidyCode  == '04'){
                            //arr.push(data);
                            sum += parseInt(data.subsidyRate);
                        }
                    }else{
                        sum += parseInt(data.subsidyRate);
                    }
                });
                //$scope.subsidyList = arr;
                var result=recalculateTotal();
                if(result=="1111"){
                    return;
                }
            }
            proposalServ.savePolicy(data).then(
                function(answer){
                    if(answer.data.resultCode == '0000'){
                        if(answer.data.syncValidFlag == "1"){
                            $state.go("main.syncValidMsg",{"proposalNo":$scope.policy.prpTmain.proposalNo,"sumPremium":$scope.policy.prpTmain.sumPremium,"applyName":$scope.policy.prpTinsured.insuredName});
                            $scope.cannotSubmit=false;
                        }else if($scope.policy.prpTmain.payMode == "02"){
                            $scope.publicOffLineLayer = false;
                            $state.go("main.offLineCharge",{"proposalNo":$scope.policy.prpTmain.proposalNo});
                            $scope.cannotSubmit=false;
                        }else{
                            $scope.publicOnLineLayer = false;
                            $state.go("main.onLineCharge",{"proposalNo":$scope.policy.prpTmain.proposalNo});
                            $scope.cannotSubmit=false;
                        }
                    }else if(answer.data.resultCode == '1104'){
                        $scope.publicOffLineLayer = false;
                        $scope.publicOnLineLayer = false;
                        $state.go("main.applicationSuc", {"policyNo":answer.data.policyNo});
                        $scope.cannotSubmit=false;
                    }else{
                        $scope.publicOffLineLayer = false;
                        $scope.publicOnLineLayer = false;
                        if(""!=answer.data.resultMessage){
                            $scope.msg = $sce.trustAsHtml('提交核保失败：'+answer.data.resultMessage);
							$scope.publicHtmlLayer = false;
                            $scope.cannotSubmit=false;
                        }else{
                            angular.alert("提交核保失败");
                            $scope.cannotSubmit=false;
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                    $scope.cannotSubmit=false;
                }
            );
        }
        $scope.onSubmit = function(){
            //获取到表单是否验证通过
            if($scope.proposalForm.$valid){
                if($scope.policy.prpTmain.handlerCode == undefined || $scope.policy.prpTmain.contractNo == undefined){
                    $scope.policy.prpTmain.handlerCode = '';
                    $scope.policy.prpTmain.contractNo = '';
                }
                if($scope.policy.prpTmain.handlerCode == '' && $scope.policy.prpTmain.contractNo == ''){
                    angular.alert("渠道代码及协议代码必须填入至少一项");
                    return;
                }
                if($scope.policy.prpTinsured.insuredType == '2'){
                    if(undefined == $scope.policy.prpTinsured.prpTinsuredArtifDto
                        || ((""==$scope.policy.prpTinsured.prpTinsuredArtifDto.organizeCode
                        ||null == $scope.policy.prpTinsured.prpTinsuredArtifDto.organizeCode
                        ||undefined == $scope.policy.prpTinsured.prpTinsuredArtifDto.organizeCode )
                        && ($scope.policy.prpTinsured.prpTinsuredArtifDto.businessCode == ''
                        ||undefined == $scope.policy.prpTinsured.prpTinsuredArtifDto.businessCode
                        ||null == $scope.policy.prpTinsured.prpTinsuredArtifDto.businessCode)
                        && ($scope.policy.prpTinsured.prpTinsuredArtifDto.revenueRegistNo == ''
                        ||undefined == $scope.policy.prpTinsured.prpTinsuredArtifDto.revenueRegistNo
                        ||null == $scope.policy.prpTinsured.prpTinsuredArtifDto.revenueRegistNo)
                        && ($scope.policy.prpTinsured.prpTinsuredArtifDto.creditCode == ''
                        ||  undefined == $scope.policy.prpTinsured.prpTinsuredArtifDto.creditCode
                        ||null == $scope.policy.prpTinsured.prpTinsuredArtifDto.creditCode))){
                        angular.alert("组织机构代码证号、税务登记证号、营业执照号及社会统一信用代码必须填入至少一项");
                        return;
                    }
                }
                    var insuredLen = $scope.insureDatas;
                    if(!insuredLen || insuredLen.length == 0){
                        $scope.insuredMustOneLayer = true;
                        return;
                    }else{
                        if($scope.policy.prpTmain.arguesolution == '1'){
                            $scope.argues =false;
                        }else{
                            $scope.argues =true;
                        }
                        if($scope.policy.prpTinsured.insuredType == '2'){
                            if($scope.policy.prpTmain.payMode == '01'){
                                $scope.publicOnLineLayer = true;
                                $scope.publicOnLineConfirm = function(){
                                    onSub();
                                }
                            }else{
                                $scope.publicOffLineLayer = true;
                                $scope.publicOffLineConfirm = function(){
                                    onSub();
                                    $scope.publicOffLineLayer = false;
                                };
                            }
                        }else{
                            if(insuredLen.length > 1){
                                angular.alert("个人投保人只能有一个被保险人！");
                                return;
                            }else{
                                onSub();
                            }
                        }
                    }
            }else{
                FormFocus.focusEle("proposalForm");
                return;
            }

        };
        $scope.publicOnLinehide = function(){
            $scope.publicOnLineLayer = false;
        };
        $scope.publicOffLinehide = function(){
            $scope.publicOffLineLayer = false;
        };
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        $scope.publicHtmlLayerClose = function(){
            $scope.publicHtmlLayer = true;
        };


        $scope.insuredBatchOnlyGroupClose = function(){
            $scope.insuredBatchOnlyGroupLayer = false;
        };
        $scope.insuredMustOneClose = function(){
            $scope.insuredMustOneLayer = false;
        };
        $scope.insuredsHasErrClose = function(){
            $scope.insuredsHasErrLayer = false;
        };
        /*投保单暂存*/
        var cannotSave=false;
        var doSavePause = function(){
            var promise;
            if(!cannotSave){
                cannotSave=true;
                var data = $scope.policy;
                data.prpTinsuredPropDtos=null;
                if($scope.policy.prpTmain.riskCode == 'EQ02'){
                    data.prpTSubsidyDtos = $scope.subsidyList;
                    data.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                    var result=recalculateTotal();
                    if(result=="1111"){
                        return;
                    }
                }
                data.riskCode = $scope.policy.prpTmain.riskCode;
                promise = proposalServ.savePause(data);
                promise.then(
                    function(answer){
                        console.log("暂存成功,重置标志");
                        cannotSave=false;
                    },function(error){
                        console.log("暂存失败,重置标志");
                        cannotSave=false;
                    }
                );
            }else{
                var deffer = $q.defer();
                deffer.reject();
                promise = deffer.promise;
            }
            return promise;
        };

        $scope.savePause = function(){
            doSavePause().then(
                function(answer){
                    angular.alert("暂存成功");
                },function(error){
                    console.error("暂存失败");
                }
            );
        };
        /*投保单退出*/
        $scope.onEdit = function(){
            $state.go("main.index")
        };
        /*删除投保*/
        $scope.deleteLayer = false;
        //$scope.deleteText = false;
        var cannotDelete=false;
        $scope.deleteshowInsure = function(){
            if(!cannotDelete){
                $scope.cannotDelete=true;
                $scope.deleteLayer = true;
                this.proposalDelConditionDto = {};
                this.proposalDelConditionDto.delReasonCode = '';
                cannotDelete=true;
            }
        };
        $scope.delReasonFlag = true;
        $scope.proposalDelConditionDto = {};
        $scope.$watch("proposalDelConditionDto.delReasonCode",function(){
            if($scope.proposalDelConditionDto.delReasonCode == '04'){
                $scope.delReasonFlag = false;
            } else{
                $scope.delReasonFlag = true;
            }
        });
        $scope.deleteConfirmFlag=false;
        $scope.deleteConfirm = function(){
            var proposalNo = $scope.policy.prpTmain.proposalNo;
            var proposalDelConditionDto = {};
            proposalDelConditionDto.proposalNo = proposalNo;
            if(!this.deleteProposalForm.$valid){
                FormFocus.focusEle("deleteProposalForm");
                return;
            }else{
                if(!$scope.deleteConfirmFlag){
                    $scope.deleteConfirmFlag=true;
                    proposalDelConditionDto.delReasonCode = this.proposalDelConditionDto.delReasonName;
                    proposalDelConditionDto.delReasonDesc = this.proposalDelConditionDto.delReasonDesc;
                    proposalServ.deletePolicy(proposalDelConditionDto).then(
                        function(answer){
                            var data = answer.data.proposalNo;
                            if(answer.data.resultCode != '0000'){
                                $state.go("main.applicationDeleteFail",{"proposalNo":data})
                                $scope.deleteConfirmFlag=false;
                            }else{
                                $state.go("main.applicationDeleteSuccess",{"proposalNo":data})
                                $scope.deleteConfirmFlag=false;
                            }
                        },function(error){
                            //cconsole.log(JSON.stringify(error.data));
                            $scope.deleteConfirmFlag=false;
                        }
                    );
                }
            }
        };
        $scope.deletehideInsure = function(){
            $scope.deleteLayer = false;
            this.deleteProposalForm.$setPristine();
            $(".validation-errorText").css('display','none');
            $scope.cannotDelete=false;
            cannotDelete=false;
        };
       

        /*添加被保险人*/
        $scope.addLayer = false;

        /*双浏览器校验个单情况下被保险人重复性*/
        var checkTInsuredPropData=function(){
            var conditionDto={};
            conditionDto.proposalNo=$scope.policy.prpTmain.proposalNo;
            proposalServ.checkTInsuredProp(conditionDto).then(
                function(answer){
                    var responseData=answer.data;
                    if(responseData.returnCode=='9999'){
                        angular.alert("个人投保人只能有一个被保险人");
                        return;
                    }else{
                        addshowTInsureProp();
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        var addshowTInsureProp = function(){
            $scope.addLayer = true;
            var prpTinsuredPropDto = {};
            prpTinsuredPropDto.houseType = '02';
            $scope.houseCityFlag = true;
            $scope.houseCountryFlag = true;
            /*建筑类型*/
            prpTinsuredPropDto.buildType = '';
            $scope.buildTypeFlag =true;
            $scope.buildTypeSqueryFlag = false;
            /*是否整修*/
            prpTinsuredPropDto.repairFlag = '';
            $scope.refurbishedYesFlag =true;
            $scope.refurbishedNoFlag = false;
            $scope.buildTime = false;

            prpTinsuredPropDto.identifyName = '居民身份证';
            prpTinsuredPropDto.identifyType = '01';
            /*被保险人性别*/
            prpTinsuredPropDto.sex = '';
            $scope.insuredSexManFlag = true;
            $scope.insuredSexWomanFlag = false;

            $scope.PrpTinsuredPropDto = prpTinsuredPropDto;
            if($scope.SubsidyQueryConditionDto.subsidyType == '01'){
                if($scope.PrpTinsuredPropDto.houseType == '02'){
                    $scope.PrpTinsuredPropDto.amount = '2';
                }else{
                    $scope.PrpTinsuredPropDto.amount = '5';
                }
                $scope.amountFlag = true;
            }else{
                $scope.amountFlag = false;
            }
            //设置默认【同投保人】为不勾选
            $scope.toggle = !$scope.toggle;
            $scope.toggle = true;
            var layerH = $(".layerOver").height()+37;
            if(layerH > _windowH){
                $(".layerOver").css("height","500px");
                $(".revise_insurant").css("margin-top","-260px");
            }
        };
         /*被保险人初始化*/
         $scope.addshowInsure = function(){
             if(parmasRiskCode == 'EQ02'){
                 if($scope.SubsidyQueryConditionDto.subsidyType == '' || $scope.SubsidyQueryConditionDto.subsidyType == undefined){
                     angular.alert("请选择财政补贴比例类型");
                     return;
                 }
                 var result=recalculateTotal();
                 if(result=="1111"){
                     return;
                 }
             }
            if($scope.policy.prpTinsured.insuredType == '1'){
                //投保人为个人只能增加一个被保险人
                var insuredLen = $scope.insureDatas;
                if(insuredLen){
                    if(insuredLen.length >= 1){
                        angular.alert("个人投保人只能有一个被保险人");
                        return;
                    }
                }
                checkTInsuredPropData();
                //只有投保人为个人才显示【同投保人】
                $scope.InsuredSameShows = true;
            }else{
                $scope.InsuredSameShows = false;
                addshowTInsureProp();
            }
        };
        $scope.addhideInsure = function(){
            $scope.addLayer = false;
            this.insuredForm.$setPristine();
            $(".validation-errorText").css('display','none');
        };
        /*监听业务来源设置出单省级机构*/
        $scope.$watch("policy.prpTmain.businessNature",function(){
            if($scope.policy.prpTmain.businessNature=='122' || $scope.policy.prpTmain.businessNature=='123'){
                $scope.companyRequired=false;
            }else{
                $scope.companyRequired=true;
            }
        });
        /*添加被保险人-确定*/
        //$scope.buttonSure=true;
        $scope.structFlag = false;
        function amountFun(){
            if($scope.PrpTinsuredPropDto.houseType == '01'){
                if($scope.PrpTinsuredPropDto.amount < 5){
                    $scope.PrpTinsuredPropDto.msg = '城市住宅最小保额是5万元';
                    return
                }else{
                    $scope.PrpTinsuredPropDto.msg = '';
                }
            }else if($scope.PrpTinsuredPropDto.houseType == '02'){
                if($scope.PrpTinsuredPropDto.amount < 2){
                    $scope.PrpTinsuredPropDto.msg = '农村住宅最小保额是2万元';
                    return;
                }else{
                    $scope.PrpTinsuredPropDto.msg = '';
                }
            }
            if($scope.PrpTinsuredPropDto.buildStructure == '05'){
                $scope.structFlag = false;
                $scope.PrpTinsuredPropDto.buildStructureDes ='';
                if($scope.PrpTinsuredPropDto.amount > 10){
                    $scope.PrpTinsuredPropDto.msg = '砖木结构住宅保额最高不超过10万元';
                    return;
                }
            }else if($scope.PrpTinsuredPropDto.buildStructure == '99'){
                $scope.structFlag = true;
                if($scope.PrpTinsuredPropDto.amount > 6){
                    $scope.PrpTinsuredPropDto.msg = '其他结构住宅保额最高不超过6万元';
                    return;
                }
            }else{
                $scope.structFlag = false;
                $scope.PrpTinsuredPropDto.buildStructureDes ='';
                if($scope.PrpTinsuredPropDto.buildStructure == '01'){
                    if($scope.PrpTinsuredPropDto.amount > 100){
                        $scope.PrpTinsuredPropDto.msg = '钢结构住宅保额最高不超过100万元';
                        return;
                    }
                }else if($scope.PrpTinsuredPropDto.buildStructure == '02'){
                    if($scope.PrpTinsuredPropDto.amount > 100){
                        $scope.PrpTinsuredPropDto.msg = '钢和钢筋混凝土结构住宅保额最高不超过100万元';
                        return;
                    }
                }else if($scope.PrpTinsuredPropDto.buildStructure == '03'){
                    if($scope.PrpTinsuredPropDto.amount > 100){
                        $scope.PrpTinsuredPropDto.msg = '钢筋混凝土结构住宅保额最高不超过100万元';
                        return;
                    }
                }else if($scope.PrpTinsuredPropDto.buildStructure == '04'){
                    if($scope.PrpTinsuredPropDto.amount > 100){
                        $scope.PrpTinsuredPropDto.msg = '混合结构住宅保额最高不超过100万元';
                        return;
                    }
                }else{
                    if($scope.PrpTinsuredPropDto.amount > 100){
                        $scope.PrpTinsuredPropDto.msg = '保额最高不超过100万元';
                        return;
                    }
                }
            }

        }
        $scope.amountBlur = function(){
            amountFun();
        };
        /*建筑结构*/
        $scope.$watch("PrpTinsuredPropDto.buildStructure",function(){
            amountFun();
        });

        /*被保险人保存*/
        $scope.InsuredSave = function(form){
            amountFun();
            var prpoposalDto = {};
            var prpTmain = $scope.policy.prpTmain;
            this.PrpTinsuredPropDto.proposalNo=prpTmain.proposalNo;
            prpoposalDto.proposalNo = prpTmain.proposalNo;
            prpoposalDto.riskCode = prpTmain.riskCode;
            prpoposalDto.comCode = prpTmain.comCode;
            prpoposalDto.prpTmain = prpTmain;
            prpoposalDto.prpTinsuredPropDto = this.PrpTinsuredPropDto;
            prpoposalDto.prpTinsuredPropDto.riskCode = parmasRiskCode;
            prpoposalDto.prpTinsuredPropDto.clauseCode = clauseCode;
            prpoposalDto.prpTinsuredPropDto.currency ='CNY';

            //获取到表单是否验证通过
            if(this.insuredForm.$valid){
                if(undefined !=$scope.PrpTinsuredPropDto.msg && $scope.PrpTinsuredPropDto.msg != ''){
                    return;
                }else{
                    //var data = angular.copy(prpoposalDto);
                    var data = {};
                    data.prpTinsuredPropDto = this.PrpTinsuredPropDto;
                    //amount 的单位是万元，这里要乘以10000
                    data.prpTinsuredPropDto.amount  =  data.prpTinsuredPropDto.amount * 10000;
                    // data.prpTSubsidyDtos = $scope.subsidyList;
                    insuredServ.saveInsure(data).then(
                        function(answer){
                            if(answer.data.returnCode != '00'){
                                $scope.msg=answer.data.returnMessage;
                                $scope.insuredOnlyOneLayer = false;
                            }else {
                                $scope.addLayer = false;
                                getInsuredList();
                                calSumAmountAndSumPremium();
                                if(parmasRiskCode == 'EQ02'){

                                    subsidyPlan();
                                }
                                form.$setPristine();
                            }
                        },function(error){
                            //cconsole.log(JSON.stringify(error.data));
                        }
                    );
                }

            }else{
                FormFocus.focusEle("insuredForm");
                return;
            }
        };

        var getImportHis = function(){
            var queryErrConditionDto = {};
            var prpTmain = $scope.policy.prpTmain;
            queryErrConditionDto.proposalNo = prpTmain.proposalNo;
            queryErrConditionDto.pageNo=$scope.pagInsuredErrConf.currentPage;
            queryErrConditionDto.pageSize=$scope.pagInsuredErrConf.itemsPerPage;
            insuredServ.queryImportErrHis(queryErrConditionDto).then(
                function(answer){
                    if(answer.data.returnCode =='0000'){
                        $scope.progressDatas = answer.data.progressDatas.list;
                        angular.forEach($scope.progressDatas, function(data){
                            data.errorMsg = $sce.trustAsHtml(data.errorMsg);
                        });
                        $scope.pagInsuredErrConf.totalItems = answer.data.progressDatas.totalCount;
                    }else{
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        var initErrHisPage = function(){

            $scope.pagInsuredErrConf = {
                currentPage : 1, // 当前所在的页
                totalItems: 1, // 总共有多少条记录
                itemsPerPage : 5, // 每页展示的数据条数
                pagesLength : 5, // 分页条目的长度（如果设置建议设置为奇数）
                perPageOptions : [5,10,15, 20,25 ]
            /*下载被保险人导入错误信息*/
            };
            $scope.$watch('pagInsuredErrConf.currentPage + pagInsuredErrConf.itemsPerPage', getImportHis);
        };

        initErrHisPage();
        //显示下载失败信息列表
        $scope.showDownloadErrTable = function(){
            getImportHis();
            $scope.downloadHistoryLayer = true;
        };

        //隐藏下载失败信息列表
        $scope.closeDownloadErrTable = function(){
            $scope.downloadHistoryLayer = false;
        };
        /*下载被保险人导入错误信息*/
        $scope.downloadInsErrMsg = function(batchNo){
            var insuredErrQueryDto = {};
            var prpTmain = $scope.policy.prpTmain;
            insuredErrQueryDto.proposalNo=prpTmain.proposalNo;
            insuredErrQueryDto.batchNo = batchNo;
            insuredErrQueryDto.riskCode = parmasRiskCode;
            insuredServ.downloadErrFile(insuredErrQueryDto).then(
                function(answer){
                    if($scope.processImport){
                        $scope.processImport = false;
                    }
                    if(answer.data.returnCode=='0000'){
                        var shortLink = answer.data.shortLink;
                        /*下载文件*/
                        insuredServ.downloadExcel(shortLink);
                    }else{
                        angular.alert(answer.data.returnMessage);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*下载保保险人导入模板*/
        $scope.downLoadExcelModel = function(){
            var riskCode = parmasRiskCode;
            insuredServ.downloadExcModel(riskCode).then(
              function(answer){
                  if(answer.data.resultCode=='0000'){
                      var shortLinkId = answer.data.shortLinkId;
                      /*下载文件*/
                      insuredServ.downloadExcel(shortLinkId);
                  }else{
                      angular.alert(answer.data.returnMessage);
                  }
              },function(error){
                  //cconsole.log(JSON.stringify(error.data));
              }
            );
        };
        /*被保险人批量导出*/
        $scope.downloadInsuredAll = function(){
            var InsuredExportQueryDto = {};
            var filePath = $scope.filePath;
            var prpTmain = $scope.policy.prpTmain;
            InsuredExportQueryDto.proposalNo=prpTmain.proposalNo;
            InsuredExportQueryDto.riskCode = prpTmain.riskCode;
            InsuredExportQueryDto.exportType='Insured';
            insuredServ.downloadInsureds(InsuredExportQueryDto).then(
            function(answer){
                if(answer.data.returnCode=='0000'){
                    var shortLinkId = answer.data.shortLinkId;
                    /*下载文件*/
                    insuredServ.downloadExcel(shortLinkId);
                }else{
                    $scope.insuredsHasErrLayer = true;
                    $scope.importErrMsg = answer.data.returnMessage;
                }
            },function(error){
                //cconsole.log(JSON.stringify(error.data));
            })
        };

        /**==============================================================================================================**/
        $scope.importProcessClose = function(){
            $scope.stopImportProgress();
            $scope.doImportProcessCloseClose();
        };
        $scope.doImportProcessCloseClose = function(){
            $scope.processImport = false;
        };

        // 被保险人导入轮训
        $scope.queryImportResult=function(batchNo,progressList){
            var prpTmain = $scope.policy.prpTmain;
            var insuredImportDto = {};
            insuredImportDto.proposalNo = prpTmain.proposalNo;
            insuredImportDto.progressList = progressList;
            insuredImportDto.batchNo = batchNo;
            insuredServ.queryImportResult(insuredImportDto).then(
                function(answer){
                    if(undefined != answer.data.hasProcess && 'true' == answer.data.hasProcess){
                        $scope.beginQueryImport(batchNo,answer.data.progressList);
                        $scope.processImport = true;
                    }else if (undefined != answer.data.hasProcess && 'false' == answer.data.hasProcess){
                        $scope.importProcessClose();
                        getInsuredList();
                        calSumAmountAndSumPremium();
                        $scope.showErrMsg = true;
                        if(answer.data.hasErr == 'true'){
                            $scope.importErrMsg = answer.data.returnMessage;
                            //$scope.importErrMsg = "导入被保险人清单部分失败，请下载失败记录";
                            $scope.insuredsHasErrLayer = true;
                            $scope.partsFailure = true;
                            $scope.uploadSuc = false;
                        }else if(answer.data.hasErr == 'false'){
                            $scope.importErrMsg = answer.data.returnMessage;
                            $scope.insuredsHasErrLayer = true;
                            $scope.partsFailure = false;
                            $scope.uploadSuc = true;
                        }else{
                            $scope.partsFailure = false;
                            $scope.uploadSuc = true;
                        }
                        if(answer.data.hasErrHis == "false"){
                            $scope.downloadSpan = false;
                        }else if(answer.data.hasErrHis == "true"){
                            $scope.downloadSpan = true;
                        }else{
                            $scope.downloadSpan = true;
                        }
                        insuredImportDto.progressList = null;
                        getInsuredList();
                        calSumAmountAndSumPremium();
                        subsidyPlan();
                    }else{
                        $scope.importProcessClose();
                        getInsuredList();
                        calSumAmountAndSumPremium();
                        subsidyPlan();
                    }
                },function(error){
                    $scope.importProcessClose();
                }
            );
        };

        // 导入成功
        $scope.importSucc=function(){
            console.log("click success begin to decide");
            // 关闭轮训
            $scope.importProcessClose();
        };

        // 导入失败
        $scope.importFail=function(){
            console.log("click fail begin to decide");
            // 关闭轮训
            $scope.importProcessClose();
        };

        // 轮训
        var stop;
        var count = 0;
        var queryImportStatus = function(batchNo,progressList){
            $scope.queryImportResult(batchNo,progressList);
        };
        $scope.beginQueryImport = function(batchNo,progressList){
            //console.log("轮训开始");
            if(angular.isDefined(stop)){
                return;
            }
            stop = $interval(function(){
                $scope.queryImportResult(batchNo,progressList);
            },2000,1000*60*30/2000); //1000*60*30/3000 轮训 30分钟
        };

        $scope.stopImportProgress = function(){
            if(angular.isDefined(stop)){
                $interval.cancel(stop);
                stop = undefined;
            }
        };

        $scope.$on('$destroy',function(){
            $scope.stopImportProgress();
        });

        /**
         * 执行后台处理导入文件操作
         * @param uploadResp 文件上传返回的结果对象
         */
        $scope.processInsuredData = function(uploadResp){
            console.log("uploadResp="+JSON.stringify(uploadResp));
            if(uploadResp.resultCode != "0000"){
                $scope.importErrMsg = "导入被保险人清单部分失败:"+uploadResp.resultMsg;
                $scope.insuredsHasErrLayer = true;
                return;
            }
            //清除文件选择栏内容
            //$scope.clearItems();
            var prpTmain = $scope.policy.prpTmain;
            var insuredImportDto = {};
            insuredImportDto.clauseCode = clauseCode;
            insuredImportDto.currency = 'CNY';
            insuredImportDto.riskCode = parmasRiskCode;
            insuredImportDto.comCode = prpTmain.companyCode;
            insuredImportDto.proposalNo=prpTmain.proposalNo;
            insuredImportDto.startDate = prpTmain.startDate;
            insuredImportDto.endDate = prpTmain.endDate;
            insuredImportDto.fileId = uploadResp.fileId;
            insuredImportDto.batchNo = uploadResp.fileId;
            insuredImportDto.prpTSubsidyDtos = $scope.subsidyList;

            $scope.BatchImport = false;    //关闭碳层
            $scope.processImport = true; //显示遮罩

            //开始定时器，轮训查询后台处理情况
            $scope.beginQueryImport(insuredImportDto.fileId,null);
            //调用后台处理服务
            insuredServ.insertInsuredAll(insuredImportDto);
        };

        /*更新汇总页面保额保费信息*/
        var calSumAmountAndSumPremium = function(){
            var proDto = {};
            proDto.proposalNo = $scope.policy.prpTmain.proposalNo;
            insuredServ.calAmountAndPremium(proDto).then(
                function(answer){
                    var summaryItemPropReturnDto = answer.data;
                    // 总户数
                    if(summaryItemPropReturnDto.sumQuantity){
                        $scope.policy.prpTmain.insuredCount =summaryItemPropReturnDto.sumQuantity;
                    }else{
                        $scope.policy.prpTmain.insuredCount ='';
                    }
                    //总保额：
                    if(summaryItemPropReturnDto.sumAmount){
                        $scope.policy.prpTmain.sumAmount = (summaryItemPropReturnDto.sumAmount/10000).toFixed(2);
                    }else{
                        $scope.policy.prpTmain.sumAmount ='';
                    }
                    //不含税保费
                    if(summaryItemPropReturnDto.sumNoTaxPremium){
                        $scope.policy.prpTmain.noTaxPremium =(summaryItemPropReturnDto.sumNoTaxPremium).toFixed(2);
                    }else{
                        $scope.policy.prpTmain.noTaxPremium ='';
                    }
                    //保费增值税额
                    if(summaryItemPropReturnDto.sumTaxAmount){
                        $scope.policy.prpTmain.taxAmount =(summaryItemPropReturnDto.sumTaxAmount).toFixed(2);
                    }else{
                        $scope.policy.prpTmain.taxAmount ='';
                    }
                    //总保费
                    if(summaryItemPropReturnDto.sumPremium){
                        $scope.policy.prpTmain.sumPremium =(summaryItemPropReturnDto.sumPremium).toFixed(2);
                    }else{
                        $scope.policy.prpTmain.sumPremium ='';
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*缴费计划*/
        var subsidyPlan = function(){
            var proDto = {};
            proDto.proposalNo = $scope.policy.prpTmain.proposalNo;
            proDto.riskCode = parmasRiskCode;
            insuredServ.subsidyPlan(proDto).then(
                function(answer) {
                    $scope.planDtos = answer.data.proposalDto.prpTplanDtos;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        /*删除被保险人单条数据*/
        $scope.deleteInsure = function(proposalNo,serialNo){
            if(parmasRiskCode == 'EQ02'){
                if($scope.SubsidyQueryConditionDto.subsidyType == '' || $scope.SubsidyQueryConditionDto.subsidyType == undefined){
                    angular.alert("请选择财政补贴比例类型");
                    return;
                }
            }
            $scope.publicDeleteLayerOne = true;
            $scope.publicDeleteConfirmOne = function(){
                var proposalDto = $scope.policy;
                var prpTinsuredPropDto = {};
                prpTinsuredPropDto.serialNo = serialNo;
                proposalDto.proposalNo = proposalNo;
                proposalDto.prpTinsuredPropDto = prpTinsuredPropDto;
                proposalDto.riskCode = parmasRiskCode;
                proposalDto.prpTinsuredPropDtos=null;
                if(parmasRiskCode == 'EQ02'){
                    proposalDto.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                    proposalDto.prpTSubsidyDtos = $scope.subsidyList;
                }
                insuredServ.deleteInsured(proposalDto).then(
                    function(answer){
                        getInsuredList();
                        calSumAmountAndSumPremium();
                        if(parmasRiskCode == 'EQ02'){
                            subsidyPlan();
                        }
                        $scope.publicDeleteLayerOne = false;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            };
        };
        $scope.publicDeletehideOne = function(){
            $scope.publicDeleteLayerOne = false;
        };
        /*被保险人批量删除*/
        $scope.deleteInsureAll = function(){
            //$scope.publicDeleteLayer = true;
            if(parmasRiskCode == 'EQ02'){
                if($scope.SubsidyQueryConditionDto.subsidyType == '' || $scope.SubsidyQueryConditionDto.subsidyType == undefined){
                    angular.alert("请选择财政补贴比例类型");
                    return;
                }
            }
            angular.comfirm("确定要删除吗？",{okCallback:function(ok){
                var prpTinsuredPropDto = $scope.policy;
                prpTinsuredPropDto.proposalNo = $scope.policy.prpTmain.proposalNo;
                prpTinsuredPropDto.riskCode = $scope.policy.prpTmain.riskCode;
                if(parmasRiskCode == 'EQ02'){
                    prpTinsuredPropDto.prpTSubsidyDtos = $scope.subsidyList;
                    prpTinsuredPropDto.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                }
                insuredServ.deleteInsuredAll(prpTinsuredPropDto).then(
                    function(answer){
                        getInsuredList();
                        calSumAmountAndSumPremium();
                        if(parmasRiskCode == 'EQ02'){
                            subsidyPlan();
                        }
                        $scope.policy.prpTmain.insuredCount = "";
                        //总保额：
                        $scope.policy.prpTmain.sumAmount = "";
                        //不含税保费
                        $scope.policy.prpTmain.noTaxPremium ="";
                        //保费增值税额
                        $scope.policy.prpTmain.taxAmount ="";
                        //总保费
                        $scope.policy.prpTmain.sumPremium ="";
                        $scope.publicDeleteLayer = false;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )


            },closeCallback:function(cancel){
                //关闭弹层
            }});
        };
        /*被保险人修改*/
        $scope.editInsure = function(proposalNo,serialNo){
            if($scope.policy.prpTinsured.insuredType == '1'){
                $scope.InsuredSameShows = true;
            }else{
                $scope.InsuredSameShows = false
            }
            var layerH = $(".layerOver").height()+37;
            if(layerH > _windowH){
                $(".layerOver").css("height","500px");
                $(".revise_insurant").css("margin-top","-260px");
            }
            var prpTinsuredPropDto = {};
            prpTinsuredPropDto.proposalNo = proposalNo;
            prpTinsuredPropDto.serialNo = serialNo;
            insuredServ.queryInsure(prpTinsuredPropDto).then(
                function(answer){
                    $scope.PrpTinsuredPropDto = answer.data;
                    /*被保险人性别导入*/
                    if(answer.data.sex == '2'){
                        $scope.insuredSexManFlag = true;
                        $scope.insuredSexWomanFlag = true;
                    }else if(answer.data.sex == '1'){
                        $scope.insuredSexManFlag = false;
                        $scope.insuredSexWomanFlag = false;
                    }else{
                        $scope.insuredSexManFlag = true;
                        $scope.insuredSexWomanFlag = false;
                    }
                    if(answer.data.houseType == '01'){
                        $scope.houseCityFlag = false;
                        $scope.houseCountryFlag = false;
                    }else{
                        $scope.houseCityFlag = true;
                        $scope.houseCountryFlag = true;
                    }
                    /*建筑类型读取设置*/
                    if(answer.data.buildType == '02'){
                        $scope.buildTypeFlag = false;
                        $scope.buildTypeSqueryFlag = false;
                    }else if(answer.data.buildType == '01'){
                        $scope.buildTypeFlag = true;
                        $scope.buildTypeSqueryFlag = true;
                    }else{
                        $scope.buildTypeFlag =true;
                        $scope.buildTypeSqueryFlag = false;
                    }
                    if(answer.data.repairFlag == 'Y'){
                        $scope.refurbishedYesFlag = false;
                        $scope.refurbishedNoFlag = false;
                        $scope.buildTime = true;
                    }else if(answer.data.repairFlag == 'N'){
                        $scope.refurbishedYesFlag = true;
                        $scope.refurbishedNoFlag = true;
                        $scope.buildTime = false;
                    }else{
                        $scope.refurbishedYesFlag =true;
                        $scope.refurbishedNoFlag = false;
                        $scope.buildTime = false;
                    }
                    $scope.PrpTinsuredPropDto.amount =  $scope.PrpTinsuredPropDto.amount/10000;
                    $scope.addLayer = true;
                    if($scope.SubsidyQueryConditionDto.subsidyType != '01'){
                        $scope.amountFlag = false;
                    }else{
                        $scope.amountFlag = true;
                    }
                },function(error){
                    //console.log(JSON.stringify(error.data));
                }
            )
        };
        /*个人客户搜索*/
        $scope.personnalSearchLayer = false;
        $scope.num = 0;
        $scope.CusTrRadio = function(num){
             $scope.personNum(num); 
        };
        $scope.personNum = function (num) {
            $scope.num = num;
        };
        function customerFun(){
            var data = $scope.customerDatas[$scope.num];
            var prpTinsured = {};
            var prpTinsuredNatureDto = {};
            prpTinsured.insuredName = data.customerName;//姓名
            prpTinsured.identifyType = data.credentialsType;//证件类型
            prpTinsured.identifyNumber = data.credentialsNumber;//证件号码
            prpTinsured.prpTinsuredNatureDto = prpTinsuredNatureDto;//性别
            prpTinsured.email = data.email;//邮件
            prpTinsured.insuredAddress = data.address;//地址
            prpTinsured.insuredType = $scope.policy.prpTinsured.insuredType;
            $scope.policy.prpTinsured = prpTinsured;
            prpTinsuredNatureDto.sex = data.sexCode;
            if (prpTinsuredNatureDto.sex == '1') {
                $scope.SexManFlag = true;
                $scope.SexWomanFlag = true;
            } else {
                $scope.SexManFlag = false;
                $scope.SexWomanFlag = false;
            }
            $scope.personnalSearchLayer = false;
            $scope.$broadcast("changeValue");
            //eventBus['scopeInitOver'].pub({ctlName: "application"});
        }
        var getCustomerList = function(){
            var insuredName= $scope.policy.prpTinsured.insuredName;
            var insuredType= $scope.policy.prpTinsured.insuredType;
            var personalData = {};
            personalData.pageNum=$scope.customerConf.currentPage;
            personalData.pageSize=$scope.customerConf.itemsPerPage;
            personalData.customerName = insuredName;
            personalData.customerType = insuredType;
            personalData.isHaveoth = 'Y';
            personalData.isFlat = 'Y';
            cusLayerServ.personInit(personalData).then(
                function(answer){
                    if(answer.data.totalCount == 0){
                        $scope.personnalSearchLayer = false;
                    }else if(answer.data.totalCount == 1){
                        $scope.personnalSearchLayer = false;
                        $scope.customerConf.totalItems = answer.data.totalCount;
                        $scope.customerConf.pageNo = answer.data.pageNum;
                        $scope.customerDatas = answer.data.cifIDVCustomers;
                        customerFun();
                        $(".validation-errorText").css('display','none');
                    }else{
                        $scope.personnalSearchLayer = true;
                        $scope.customerConf.totalItems = answer.data.totalCount;
                        $scope.customerConf.pageNo = answer.data.pageNum;
                        $scope.customerDatas = answer.data.cifIDVCustomers;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        $scope.personnalSearch = function(){
            var insuredName= $scope.policy.prpTinsured.insuredName;
            $scope.personNum(0);
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
                //初始化分页
                $scope.customerConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                };
                $scope.personalInfo = {pageNo:$scope.customerConf.currentPage,
                    pageSize:$scope.customerConf.itemsPerPage};
                $scope.$watch('customerConf.currentPage + customerConf.itemsPerPage', getCustomerList);

            }else{
                $scope.personnalSearchLayer = false;
            }
        };
        $scope.personnalSearchClose = function(){
            $scope.personnalSearchLayer = false;
        };
        /*个人客户搜索确定*/
        $scope.customerConfirm = function () {
            customerFun();
             $(".validation-errorText").css('display','none');
        };
        /*团体客户搜索*/
        $scope.groupSearchLayer = false;
        function teamFun(){
            if($scope.teamConf.totalItems == 0){
                $scope.groupSearchLayer = false;
            }else if($scope.teamConf.totalItems == 1){
                $scope.groupSearchLayer = false;
                var dataTeamOne= $scope.teamDatas[0];
                $scope.policy.prpTinsured.insuredName = dataTeamOne.customerName;//名称
                $scope.policy.prpTinsured.linkerName = dataTeamOne.linkManName;//联系人
                var prpTinsured = {};
                prpTinsured.organizeCode = dataTeamOne.organizeCode;//组织机构代码
                prpTinsured.businessCode = dataTeamOne.businessLicence;//营业执照
                prpTinsured.revenueRegistNo = dataTeamOne.revenueCode;//税务登记号
                prpTinsured.creditCode = dataTeamOne.socialCredit;//社会统一信用代码
                $scope.policy.prpTinsured.email = dataTeamOne.linkManEmail;//email
                $scope.policy.prpTinsured.insuredAddress = dataTeamOne.linkManAddress;//地址
                $scope.policy.prpTinsured.prpTinsuredArtifDto = prpTinsured;
                $scope.$broadcast("changeValue");
            }else{
                var data= $scope.teamDatas[$scope.num1];
                $scope.policy.prpTinsured.insuredName = data.customerName;//名称
                $scope.policy.prpTinsured.linkerName = data.linkManName;//联系人
                var prpTinsuredArtifDto = {};
                prpTinsuredArtifDto.organizeCode = data.organizeCode;//组织机构代码
                prpTinsuredArtifDto.businessCode = data.businessLicence;//营业执照
                prpTinsuredArtifDto.revenueRegistNo = data.revenueCode;//税务登记号
                prpTinsuredArtifDto.creditCode = data.socialCredit;//社会统一信用代码
                $scope.policy.prpTinsured.email = data.linkManEmail;//email
                $scope.policy.prpTinsured.insuredAddress = data.linkManAddress;//地址
                $scope.policy.prpTinsured.prpTinsuredArtifDto = prpTinsuredArtifDto;
                $scope.groupSearchLayer = false;
                $scope.$broadcast("changeValue");
            }
        }
        var getTeamList = function(){
            var insuredName= $scope.policy.prpTinsured.insuredName;
            var teamData = {};
            teamData.pageNum=$scope.teamConf.currentPage;
            teamData.pageSize=$scope.teamConf.itemsPerPage;
            teamData.customerName = insuredName;
            teamData.isHaveoth = 'Y';
            teamData.isFlat = 'Y';
            teamLayerServ.teamInit(teamData).then(
                function(answer){
                    if(answer.data.totalCount == 0){
                        $scope.groupSearchLayer = false;
                    }else if(answer.data.totalCount == 1){
                        $scope.groupSearchLayer = false;
                        $scope.teamConf.totalItems = answer.data.totalCount;
                        $scope.teamDatas = answer.data.cifUnitCustomers;
                        teamFun();
                        $(".validation-errorText").css('display','none');
                    }else{
                        $scope.groupSearchLayer = true;
                        $scope.teamConf.totalItems = answer.data.totalCount;
                        $scope.teamDatas = answer.data.cifUnitCustomers;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        $scope.num1 = 0;
        $scope.teamTrRadio = function(num){
            $scope.teamNum(num);
        };
        $scope.teamNum = function (num) {
            $scope.num1 = num;
        };
        $scope.groupSearch = function(){
            var insuredName= $scope.policy.prpTinsured.insuredName;
            $scope.teamNum(0);
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
               // $scope.groupSearchLayer = true;
                //初始化分页
                $scope.teamConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]    // 可选择显示条数的数组
                };
                $scope.proposalInfoDto = {pageNo:$scope.teamConf.currentPage,
                    pageSize:$scope.teamConf.itemsPerPage};
                $scope.$watch('teamConf.currentPage + teamConf.itemsPerPage', getTeamList);
            }else{
                $scope.groupSearchLayer = false;
            }
        };
        /*团体客户搜索点击确定*/
        $scope.teamConfirm = function () {
            teamFun();
            $(".validation-errorText").css('display','none');
        };
        $scope.groupSearchClose = function(){
            $scope.groupSearchLayer = false;
        };
        /*被保险人客户搜索*/
        $scope.insuredPersonSearchLayer = false;
        $scope.num2 = 0;
        $scope.insuredTdRadio = function(num){
            $scope.insuredNum(num);
        };
        $scope.insuredNum = function (num) {
            $scope.num2 = num;
        };
        function insuredCusFun(){
            if($scope.insuredCusConf.totalItems == 0){
                $scope.insuredPersonSearchLayer = false;
            }else if($scope.insuredCusConf.totalItems == 1){
                var data= $scope.insuredDatas[0];
                $scope.insuredPersonSearchLayer = false;
                $scope.PrpTinsuredPropDto.insuredName = data.customerName;//名称
                $scope.PrpTinsuredPropDto.identifyType = data.credentialsType;//证件类型
                $scope.PrpTinsuredPropDto.identifyNumber = data.credentialsNumber;//证件号码
                $scope.PrpTinsuredPropDto.email = data.email;//邮件
                $scope.PrpTinsuredPropDto.insuredAddress = data.address;//地址
                if(data.sexCode == '1'){
                    $scope.insuredSexManFlag = false;
                    $scope.insuredSexWomanFlag = false;
                }else{
                    $scope.insuredSexManFlag = true;
                    $scope.insuredSexWomanFlag = true;
                }
                $scope.$broadcast("changeValue");
               // eventBus['scopeInitOver'].pub({ctlName:"application"});
            }else{
                var data= $scope.insuredDatas[$scope.num2];
                $scope.insuredPersonSearchLayer = false;
                $scope.PrpTinsuredPropDto.insuredName = data.customerName;//名称
                $scope.PrpTinsuredPropDto.identifyType = data.credentialsType;//证件类型
                $scope.PrpTinsuredPropDto.identifyNumber = data.credentialsNumber;//证件号码
                $scope.PrpTinsuredPropDto.email = data.email;//邮件
                $scope.PrpTinsuredPropDto.insuredAddress = data.address;//地址
                if(data.sexCode == '1'){
                    $scope.insuredSexManFlag = false;
                    $scope.insuredSexWomanFlag = false;
                }else{
                    $scope.insuredSexManFlag = true;
                    $scope.insuredSexWomanFlag = true;
                }
                $scope.$broadcast("changeValue");
               // eventBus['scopeInitOver'].pub({ctlName:"application"});
            }
        }
        var getInsuredNameList = function(){
            var insure= $scope.PrpTinsuredPropDto.insuredName;
            if(insure != null && insure != '' && insure != undefined ){
                //$scope.insuredPersonSearchLayer = true;
                var insuredCusDatas = {};
                insuredCusDatas.pageNum=$scope.insuredCusConf.currentPage;
                insuredCusDatas.pageSize=$scope.insuredCusConf.itemsPerPage;
                insuredCusDatas.customerName = insure;
                insuredCusDatas.isHaveoth = 'Y';
                cusLayerServ.personInit(insuredCusDatas).then(
                    function(answer){
                        if(answer.data.totalCount == 0){
                            $scope.insuredPersonSearchLayer = false;
                        }else if(answer.data.totalCount == 1){
                            $scope.insuredPersonSearchLayer = false;
                            $scope.insuredCusConf.totalItems = answer.data.totalCount;
                            $scope.insuredCusConf.pageNo = answer.data.pageNum;
                            $scope.insuredDatas = answer.data.cifIDVCustomers;
                            insuredCusFun();
                            $(".validation-errorText").css('display','none');
                        }else{
                            $scope.insuredPersonSearchLayer = true;
                            $scope.insuredCusConf.totalItems = answer.data.totalCount;
                            $scope.insuredCusConf.pageNo = answer.data.pageNum;
                            $scope.insuredDatas = answer.data.cifIDVCustomers;
                        }
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }else{
                $scope.insuredPersonSearchLayer = false;
            }
        };
        $scope.insuredNewBlur = function(){
            var insuredName= this.PrpTinsuredPropDto.insuredName;
            $scope.insuredNum(0);
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
                //$scope.insuredPersonSearchLayer = true;
                //初始化分页
                $scope.insuredCusConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]    // 可选择显示条数的数组
                    //onChange: getInsuredList
                };
                $scope.insuredCusInfo = {pageNo:$scope.insuredCusConf.currentPage,
                    pageSize:$scope.insuredCusConf.itemsPerPage};
                $scope.$watch('insuredCusConf.currentPage + insuredCusConf.itemsPerPage', getInsuredNameList);
            }else{
                $scope.insuredPersonSearchLayer = false;
            }
        };
        /*被保险人客户搜索确定*/
        $scope.insuredConfirm = function () {
            insuredCusFun();
            $(".validation-errorText").css('display','none');
        };
        $scope.insuredNewBlurClose = function(){
            $scope.insuredPersonSearchLayer = false;
        };

        /*批量导入*/
        $scope.BatchImport = false;
        $scope.showBatchImport = function(){
            if(parmasRiskCode == 'EQ02'){
                if($scope.SubsidyQueryConditionDto.subsidyType == '' || $scope.SubsidyQueryConditionDto.subsidyType == undefined){
                    angular.alert("请选择财政补贴比例类型");
                    return;
                }
            }
            if($scope.policy.prpTinsured.insuredType == '1'){
                //投保人为个人不允许批量导入
                $scope.msg ='个人投保人不允许批量导入';
                $scope.insuredBatchOnlyGroupLayer = true;
                return;
            }
            var startDate = $scope.policy.prpTmain.startDate;
            var endDate = $scope.policy.prpTmain.endDate;
            if(undefined == startDate || undefined == endDate){
                $("#startDate_date").focus();
                return;
            }
            $("#textfield").val("");
            $scope.excelFile.textfield = '';
            $scope.BatchImport = true;
        };
        $scope.hideBatchImport = function(){
            $("#textfield").val("");
            $scope.excelFile.textfield = '';
            $scope.BatchImport = false;
        };
        /*被保险人及标的*/
        $scope.toggle = true;
        $scope.InsuredSame = function(){
            $scope.toggle = !$scope.toggle;
            if($scope.toggle == true){
                 //取消
                 //$scope.PrpTinsuredPropDto.insuredName = "";
                 //$scope.PrpTinsuredPropDto.identifyType = '01';
                    //$scope.PrpTinsuredPropDto.identifyNumber = "";
                    //$scope.PrpTinsuredPropDto.mobile = "";
                    //$scope.PrpTinsuredPropDto.email = "";
                }else{
                    //同投保人
                    if("1" == $scope.policy.prpTinsured.insuredType){
                        $(".validation-errorText").css('display','none');
                      //投保人是个人才可以进行同步投保人
                      $scope.PrpTinsuredPropDto.insuredName = $scope.policy.prpTinsured.insuredName;
                      if( $scope.policy.prpTinsured.prpTinsuredNatureDto.sex  == '1'){
                             //性别是男
                             $scope.insuredSexManFlag = false;
                             $scope.insuredSexWomanFlag = false;
                             $scope.PrpTinsuredPropDto.sex = '1';
                      }else{
                             //性别是女
                             $scope.insuredSexManFlag = true;
                             $scope.insuredSexWomanFlag = true;
                             $scope.PrpTinsuredPropDto.sex = '2';
                      }
                      $scope.PrpTinsuredPropDto.identifyType =  $scope.policy.prpTinsured.identifyType;
                      $scope.PrpTinsuredPropDto.identifyName=  $scope.policy.prpTinsured.identifyName;
                      $scope.PrpTinsuredPropDto.identifyNumber = $scope.policy.prpTinsured.identifyNumber;
                      $scope.PrpTinsuredPropDto.identityEndDate = $scope.policy.prpTinsured.identityEndDate;
                      $scope.PrpTinsuredPropDto.mobile =   $scope.policy.prpTinsured.mobile;
                      $scope.PrpTinsuredPropDto.email = $scope.policy.prpTinsured.email;
                      $scope.PrpTinsuredPropDto.insuredAddress = $scope.policy.prpTinsured.insuredAddress;

                    //eventBus['scopeInitOver'].pub({ctlName:"application"});
                }
            }
        };
        /*radio-个人组织*/
        $scope.radioClick = function () {
            $scope.onlineClick();
            $scope.policy.prpTmain.payMode = "01";
            $scope.insTypeLeft = true;
            $scope.insTypeRight = true;
            $scope.personalFlag = true;
            $scope.payType = true;
            $scope.policy.prpTinsured={insuredType:$scope.policy.prpTinsured.insuredType};
            $scope.policy.prpTinsured.prpTinsuredNatureDto={};
            $scope.policy.prpTinsured.prpTinsuredNatureDto.sex=1;
            $scope.policy.prpTinsured.insuredType = '1';
            $scope.changeInsureType = 'components/prpins/proposal/tpl/applicationPersonal.html';
            $scope.radioSexClick();
        };
        $scope.radioClick1 = function () {
            $scope.insTypeLeft = false;
            $scope.insTypeRight = false;
            $scope.personalFlag = false;
            $scope.payType = false;
            $scope.policy.prpTinsured={insuredType:$scope.policy.prpTinsured.insuredType};
            $scope.policy.prpTinsured.insuredType = '2';
            $scope.changeInsureType = 'components/prpins/proposal/tpl/applicationGroup.html';
        };
        /*投保男女*/
        $scope.radioSexClick = function () {
            $scope.SexManFlag = true;
            $scope.SexWomanFlag = true;
            $scope.policy.prpTinsured.prpTinsuredNatureDto.sex = '1';
        };
        $scope.radioSexClick1 = function () {
            $scope.SexManFlag = false;
            $scope.SexWomanFlag = false;
            $scope.policy.prpTinsured.prpTinsuredNatureDto.sex = '2';
        };
        /*被保险人男女*/
        $scope.radioSexClick2 = function () {
            $scope.insuredSexManFlag = false;
            $scope.insuredSexWomanFlag = false;
            $scope.PrpTinsuredPropDto.sex = "1";
        };
        $scope.radioSexClick3 = function () {
            $scope.insuredSexManFlag = true;
            $scope.insuredSexWomanFlag = true;
            $scope.PrpTinsuredPropDto.sex = "2";
        };
        /*被保险人住宅类型*/
        $scope.radioHouseClick = function () {
            $scope.houseCityFlag = false;
            $scope.houseCountryFlag = false;
            $scope.PrpTinsuredPropDto.houseType = '01';
            if($scope.SubsidyQueryConditionDto.subsidyType == '01'){
                $scope.amountFlag = true;
                $scope.PrpTinsuredPropDto.amount = '5';
            }
            if($scope.PrpTinsuredPropDto.amount < 5){
                $scope.PrpTinsuredPropDto.msg = '城市住宅最小保额是5万元';
                return;
            }else{
                $scope.PrpTinsuredPropDto.msg = '';
            }
        };
        $scope.radioHouseClick1 = function () {
            $scope.houseCityFlag = true;
            $scope.houseCountryFlag = true;
            $scope.PrpTinsuredPropDto.houseType = '02';
            if($scope.SubsidyQueryConditionDto.subsidyType == '01'){
                $scope.amountFlag = true;
                $scope.PrpTinsuredPropDto.amount = '2';
            }
            if($scope.PrpTinsuredPropDto.amount < 2){
                $scope.PrpTinsuredPropDto.msg = '农村住宅最小保额是2万元';
                return;
            }else{
                $scope.PrpTinsuredPropDto.msg = '';
            }
        };
        /*被保险人是否整修*/
        $scope.buildTime = false;
        $scope.refurbishedClick = function () {
            $scope.refurbishedYesFlag = false;
            $scope.refurbishedNoFlag = false;
            $scope.PrpTinsuredPropDto.repairFlag = 'Y';
            $scope.buildTime = true;
            $scope.PrpTinsuredPropDto.repairDate = '';
        };
        $scope.refurbishedClick1 = function () {
            $scope.refurbishedYesFlag = true;
            $scope.refurbishedNoFlag = true;
            $scope.PrpTinsuredPropDto.repairFlag = 'N';
            $scope.buildTime = false;
            $scope.PrpTinsuredPropDto.repairDate = '';
        };
        /*被保险人建筑类型*/
        $scope.buildTypeClick = function () {
            $scope.buildTypeFlag = false;
            $scope.buildTypeSqueryFlag = false;
            $scope.PrpTinsuredPropDto.buildType = '02';
            $scope.PrpTinsuredPropDto.buildFloor = '';
        };
        $scope.buildTypeClick1 = function () {
            $scope.buildTypeFlag = true;
            $scope.buildTypeSqueryFlag = true;
            $scope.PrpTinsuredPropDto.buildType = '01';
        };
        /*诉讼仲裁*/
        $scope.stuClick = function () {
            $scope.stuFlag = true;
            $scope.stuZFlag = true;
            $scope.argues = false;
            $scope.policy.prpTmain.arbitBoardName = '';
            $scope.policy.prpTmain.arguesolution = '1';
        };
        $scope.stuClick1 = function () {
            $scope.stuFlag = false;
            $scope.stuZFlag = false;
            $scope.argues=true;
            $scope.policy.prpTmainolution = '2';
        };
        /*线上支付-线下支付*/
        $scope.onlineClick = function () {
            $scope.onlineFlag = true;
            $scope.lineFlag = true;
            $scope.policy.prpTmain.payMode = '01';
        };
        $scope.lineClick = function () {
            $scope.onlineFlag = false;
            $scope.lineFlag = false;
            $scope.policy.prpTmain.payMode = '02';
        };

        /*保险起期监听*/
        $scope.$watch("policy.prpTmain.startDate",function(){
            if($scope.policy.prpTmain.startDate == ''){
                $scope.policy.prpTmain.endDate = '';
            }else{
                 //生效日期改变，止期自动加1年
                var startdate = $scope.policy.prpTmain.startDate;
                var startDate = new Date(startdate);
                var ensDate = new Date(startDate);
                ensDate.setFullYear(ensDate.getFullYear()+1);
                ensDate.setDate(ensDate.getDate()-1);
                $scope.policy.prpTmain.endDate =  $filter("date")(ensDate, "yyyy-MM-dd");
            }
         });

        //查看电子保单前，获取短连接id
        $scope.beforePdfView = function(){
            var deffer = $q.defer();
            console.log("开始获取短连接id",new Date());
            proposalServ.viewEproposal($scope.policy).then(
                function(answer){
                    if(answer.data != null){
                        var fileId = answer.data.shortLinkId;
                        $scope.pdfUrl = '#/pdf?fileId='+fileId;
                        console.log("获取短连接id成功:",$scope.pdfUrl,new Date());
                        deffer.resolve();
                    }else{
                        angular.alert("很抱歉，投保单预览失败！");
                        deffer.reject();
                    }
                },function(error){
                    angular.alert("服务异常，请联系管理员！");
                    deffer.reject();
                }
            );
            return deffer.promise;
        };

        //上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            if(!$scope.policy.prpTmain.proposalNo)
            {
                angular.alert("不存在投保单号,无法上传！");
                return ;
            }
            $scope.FileLayer = true;
            $scope.imgFileTypeT = true;
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$scope.policy.prpTmain.proposalNo,
                bussType:"T",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$scope.policy.prpTmain.proposalNo
            }});
        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
            this.fileUploadForm.$setPristine();
            $(".validation-errorText").css('display','none');
        };

        /*
         *以下代码请勿修改
         *级联下拉菜单
         * *
         * */
        var queryData = function(condition){
            var promise = QuerySelectCode.getData(condition);
            promise.then(
                function(answer){
                    console.log("data:"+JSON.stringify(answer.data));
                },function(error){
                    //console.log("error:"+JSON.stringify(error));
                }
            );
            return promise;
        };

        /*界面初始化为省市区下拉框赋值*/
        var initSelect = function(){
            var townCode = $scope.PrpTinsuredPropDto.townCode;
            var cityCode = $scope.PrpTinsuredPropDto.cityCode;
            var provinceCode = $scope.PrpTinsuredPropDto.provinceCode;
            doSelect("000000",provinceCode,""); //省下拉框的上级默认为000000
            doSelect(provinceCode,cityCode,"province");
            doSelect(cityCode,townCode,"city");

        };
        /**
         * controller数据初始化总方法
         */
        var initArea = function(){

            if(!angular.isDefined($scope.PrpTinsuredPropDto)){
                $scope.PrpTinsuredPropDto = {};
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.provinceCode)){
                $scope.PrpTinsuredPropDto.provinceCode = "";
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.cityCode)){
                $scope.PrpTinsuredPropDto.cityCode = "";
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.townCode)){
                $scope.PrpTinsuredPropDto.townCode = "";
            }

            /**
             * 页面打开时，初始化完给下拉框赋值
             */
            $scope.$watch('addLayer',function(){
                //console.log("watch:"+$scope.addLayer);
                if($scope.addLayer == true){
                    initSelect();
                }
            });

        };

        /**
         * 处理下拉框选中赋值
         * @author ZhangJiansen
         * @param upperCode 上级下拉框值
         * @param codeCode  要给下拉框赋的值
         * @param flag 被选中的下拉框
         */
        var doSelect = function(upperCode,codeCode,flag){
            var condition = {codeType:"AreaCode",upperCode:upperCode,riskCode:parmasRiskCode};

            if(flag == "town"){
            } else if(flag == "city"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.PrpTinsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.townList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.townCode = codeCode;
                    }, function (error) {
                        $scope.townList = [];
                        //console.log(error.data);
                    }
                );

            }else if(flag == "province"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.PrpTinsuredPropDto.cityCode = "";//清空市
                $scope.cityList = [];
                $scope.PrpTinsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.cityList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.cityCode = codeCode;
                    }, function (error) {
                        $scope.cityList = [];
                        //console.log(error.data);
                    }
                );

            }else{
                $scope.townList = [];
                $scope.cityList = [];
                $scope.provinceList = [];
                queryData(condition).then(
                    function (answer) {
                        $scope.provinceList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.provinceCode = codeCode;
                    }, function (error) {
                        $scope.provinceList = [];
                    }
                );
                //console.log("flag为空");
            }
        };

        /**
         * 区域下拉框选择响应方法
         */
        $scope.selectCode = function (item, flag) {
            doSelect(item.codeCode,"",flag);
        };

        /*$scope.InsuredSave = function(){
         if(!$scope.proposalForm.$valid) {
         FormFocus.focusEle("insuredForm");
         }
         };*/

        initArea();
        /*
        * EQ02校验补贴类型为全额补贴的时候
        * */
        /*var validSub = function (subsifyDto) {
            var sum = 0;
            var arr = [];
            var insuredLen = $scope.insureDatas;
            angular.forEach(subsifyDto, function (data,index,array) {
                if(!data.subsidyRate){
                    data.subsidyRate = 0;
                }
                if(data.subsidyType == '02'){
                    if (data.subsidyCode  == '02' || data.subsidyCode  == '03' || data.subsidyCode  == '04'){
                        arr.push(data);
                        sum += parseInt(data.subsidyRate);
                    }
                }else{
                    sum += parseInt(data.subsidyRate);
                }
            });
            if(subsifyDto[0].subsidyType == '02'){
                if(sum == 60){
                    $scope.subsidyFlag = true;
                    return;
                }else{
                    $scope.publicOffLineLayer = false;
                    $scope.publicOnLineLayer = false;
                    angular.alert("省市县比例不能少于或者大于60%");
                    return;
                }
            }else{
                if(sum == 100){
                    $scope.subsidyFlag = true;
                    return;
                }else{
                    $scope.publicOffLineLayer = false;
                    $scope.publicOnLineLayer = false;
                    angular.alert("比例合计不能少于或者大于100%");
                    return;
                }
            }
        };*/

        function changeSubsidy(subsifyDto){
            proposalServ.subsidyInit(subsifyDto).then(
                function(answer){
                    $scope.subsidyFlag = true;
                    var DetailDtosTemp = answer.data;
                    var subsidyList = [];
                    angular.forEach(DetailDtosTemp, function(data,index,array){
                        if (data.subsidyCode  == '02' || data.subsidyCode  == '03' || data.subsidyCode  == '04' || data.subsidyCode  == '10'){
                            if(data.subsidyType == '03') {
                                data.readFlag = true;
                            }else{
                                if(data.subsidyCode  == '03' ||data.subsidyCode  == '04' ){
                                    data.readFlag = false;
                                }else{
                                    data.readFlag = true;
                                }
                            }
                            data.subsidyRate = data.subsidyRate * 100;
                            subsidyList.push(data);
                        }
                    });
                    $scope.subsidyList = subsidyList;
                },function(error){
                    console.log(JSON.stringify(error.data));
                }
            );
        }
        var checkFlag = true;
        $scope.$watch('SubsidyQueryConditionDto.subsidyType',function(newValue,oldValue,scope){
            var editType = $stateParams.editType;
            if(checkFlag == false){
                checkFlag = true;
                return;
            }
            var subsifyDto = {};
            subsifyDto.riskCode = $scope.policy.prpTmain.riskCode;
            subsifyDto.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
            if(subsifyDto.subsidyType == '' || subsifyDto.subsidyType == undefined){
                $scope.subsidyFlag = false;
                return;
            }else{
                if(oldValue == '' || oldValue == undefined){
                    if(editType == 'editProposal'){
                        $scope.subsidyFlag = true;
                        if(dataValue == '' || dataValue == undefined){
                            changeSubsidy(subsifyDto);
                        }
                    }else{
                        changeSubsidy(subsifyDto);
                    }
                }else {
                    if ($scope.SubsidyQueryConditionDto.subsidyType == '01') {
                        angular.comfirm("是否变更补贴类型?",{okCallback:function(ok){
                            var subsifyDto = {};
                            subsifyDto.riskCode = $scope.policy.prpTmain.riskCode;
                            subsifyDto.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                            var insuredLen = $scope.insureDatas;
                            if(insuredLen) {
                                if (insuredLen.length >= 1) {
                                    var proposalNo = $scope.policy.prpTmain.proposalNo;
                                    proposalServ.checkSubsidy(proposalNo).then(
                                        function (answer) {
                                            if (answer.data.resultCode == '0000') {
                                                angular.comfirm("投保标的保额超限，需要重新录入标的信息。是否确认删除所有标的数据?", {
                                                    okCallback: function (ok) {
                                                        var dataDel = $scope.policy;
                                                        dataDel.prpTSubsidyDtos = $scope.subsidyList;
                                                        dataDel.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
                                                        dataDel.riskCode = $scope.policy.prpTmain.riskCode;
                                                        dataDel.proposalNo = $scope.policy.prpTmain.proposalNo;
                                                        proposalServ.delInsured(dataDel).then(
                                                            function (answer) {
                                                                getInsuredList();
                                                                calSumAmountAndSumPremium();
                                                                subsidyPlan();
                                                                $timeout(function () {
                                                                    $scope.planDtos = '';
                                                                }, 500);
                                                                changeSubsidy(subsifyDto);
                                                            }, function (error) {
                                                                console.log(JSON.stringify(error.data));
                                                            }
                                                        )
                                                    }, closeCallback: function (cancel) {
                                                        checkFlag = false;
                                                        $scope.SubsidyQueryConditionDto.subsidyType = oldValue;
                                                    }
                                                });
                                            } else {
                                                changeSubsidy(subsifyDto);
                                                angular.alert("补贴类型变更，请重新计算");
                                                return;
                                            }
                                        }, function (error) {
                                            console.log(JSON.stringify(error.data));
                                        }
                                    );
                                } else {
                                    changeSubsidy(subsifyDto);
                                    return;
                                }
                            }else{
                                changeSubsidy(subsifyDto);
                                return;
                            }
                        },closeCallback:function(cancel){
                            checkFlag = false;
                            $scope.SubsidyQueryConditionDto.subsidyType = oldValue;
                        }});
                    }else{
                        changeSubsidy(subsifyDto);
                        var insuredLen = $scope.insureDatas;
                        if(insuredLen) {
                            if (insuredLen.length >= 1) {
                                angular.alert("补贴类型变更，请重新计算");
                                return;
                            }
                        }

                    }
                }
            }
        });

        /*重新计算*/
        $scope.reckon = function(){
            var data = $scope.policy;
            data.prpTSubsidyDtos = $scope.subsidyList;
            data.subsidyType = $scope.SubsidyQueryConditionDto.subsidyType;
            data.riskCode = $scope.policy.prpTmain.riskCode;
            data.proposalNo = $scope.policy.prpTmain.proposalNo;
            var startDate = $scope.policy.prpTmain.startDate;
            var endDate = $scope.policy.prpTmain.endDate;
            if(undefined == startDate || undefined == endDate){
                $("#startDate_date").focus();
                return;
            }
            if($scope.SubsidyQueryConditionDto.subsidyType == '' || $scope.SubsidyQueryConditionDto.subsidyType == undefined){
                angular.alert("请选择财政补贴比例类型");
                return;
            }else{
                var result=recalculateTotal();
                if(result=="1111"){return;
                }
                $scope.maskLayer = true;
                proposalServ.recalculate(data).then(
                    function(answer){
                        $scope.maskLayer = false;

                        if(answer.data.resultCode == '0000'){
                            subsidyPlan();
                        }
                    },function(error){
                        $scope.maskLayer = false;
                    }
                );
            }

        };
        /*结果重新计算*/
        var recalculateTotal=function(){
            var totalVaule=0;
            for(var i=0;i<$scope.subsidyList.length;i++){
                totalVaule+=Number($scope.subsidyList[i].subsidyRate);
            }
            if(totalVaule != 100){
                if($scope.SubsidyQueryConditionDto.subsidyType == '02'){
                        $scope.publicOffLineLayer = false;
                        $scope.publicOnLineLayer = false;
                        angular.alert("省市县比例不能少于或者大于60%");
                        $scope.cannotSubmit=false;
                        return "1111";

                }else{
                        $scope.publicOffLineLayer = false;
                        $scope.publicOnLineLayer = false;
                        angular.alert("比例合计不能少于或者大于100%");
                        $scope.cannotSubmit=false;
                        return "1111";
                }

            }
        };
        $scope.recalculate=function(){
            recalculateTotal();
        }
    };
    moduleApp.controller('proposalCtrl',['$q','$rootScope','$scope','$filter','$state','proposalServ','insuredServ','cusLayerServ','teamLayerServ','$stateParams','$timeout','FormFocus','QuerySelectCode','$interval','FileUploader','$location','$sce',proposalCtrl]);
});
