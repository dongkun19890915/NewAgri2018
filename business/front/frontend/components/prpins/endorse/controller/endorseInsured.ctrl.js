/**
 * Created by guoxianglian on 2016/9/10.
 * 更改关系人模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseInsuredCtrl = function($scope,$state,eventBus,endorseInsuredServ,$stateParams,FormFocus,cusLayerServ,teamLayerServ,QuerySelectCode,$filter) {
        var policyNo = $stateParams.policyNo;
        var endorType = $stateParams.endorType;
        var endorDate = $stateParams.endorDate;
        var validDate = $stateParams.validDate;
        $scope.policyDetailParam='policy';
        $scope.endorseReturnDto = {};
        $scope.endorseReturnDto.copyPolicyDto = {};
        $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto = {};
        $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto = {};
        $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto = {};
        $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.flag = 'U';
        var _windowH = $(window).height();

        $scope.agentFlag = true;
        $scope.insuredOnlyOneLayer = true;
        $scope.SexManFlag = true;
        $scope.SexWomanFlag = true;
        /*被保险人性别设置*/
        $scope.insuredSexManFlag = true;
        $scope.insuredSexWomanFlag = false;

        $scope.emailRequiredFlag = true;
        var searchFlalg=false;
        var getReportList = function(){
            //if(!searchFlalg){
            //    return;
            //}
            $scope.insuredFuzzyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.insuredFuzzyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            $scope.insuredFuzzyQueryConditionDto.applyNo= $scope.endorseReturnDto.prpPheadDto.applyNo;
            var data = $scope.insuredFuzzyQueryConditionDto;
            endorseInsuredServ.endorseInsuredSearch(data).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.endorseInsuredData = answer.data.list;

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        //初始化界面
        $scope.personalFlag = true;
        var initFunPageInfo = function(){
            $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identifyType = '01';
            $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identifyName = '居民身份证';
            //初始化分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                //onChange: getInsuredList
            };
            $scope.insuredFuzzyQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            var surrendData = {
                policyNo:policyNo,
                endorType:endorType,
                endorDate:endorDate,
                validDate:validDate
            };

            //存储临时 关系人
            $scope.insuredTypeTemp="";
            if($stateParams.oper=='update' ){
                var endorseQueryConditionDto={};
                endorseQueryConditionDto.applyNo=$stateParams.applyNo;
                endorseInsuredServ.surUpdate(endorseQueryConditionDto).then(
                    function(anwser){
                        $scope.insuredTypeTemp=anwser.data.copyPolicyDto.prpCopyInsuredDto.insuredType;
                        if(anwser.data.copyPolicyDto.prpCopyInsuredDto.insuredType == '1'){
                            $scope.insTypeLeft = true;
                            $scope.insTypeRight = true;
                            $scope.personalFlag = true;
                            if ( anwser.data.copyPolicyDto.prpCopyInsuredDto.identityEndDate != '' && anwser.data.copyPolicyDto.prpCopyInsuredDto.identityEndDate != null){
                                anwser.data.copyPolicyDto.prpCopyInsuredDto.identityEndDate= $filter("date")(anwser.data.copyPolicyDto.prpCopyInsuredDto.identityEndDate, "yyyy-MM-dd").substr(0,10);
                            }
                            $scope.changeInsureType = 'components/prpins/endorse/tpl/endorsePersonal.html';
                            if(anwser.data.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex == "1"){
                                $scope.SexManFlag = true;
                                $scope.SexWomanFlag = true;
                            }else{
                                $scope.SexManFlag = false;
                                $scope.SexWomanFlag = false;
                            }
                        }else{
                            $scope.insTypeLeft = false;
                            $scope.insTypeRight = false;
                            $scope.personalFlag = false;
                            $scope.changeInsureType = 'components/prpins/endorse/tpl/endorseGroup.html';
                        }
                        $scope.endorseReturnDto = anwser.data;
                        if($scope.endorseReturnDto.prpPheadDto.riskCode == 'EQ02'){
                            $scope.emailRequiredFlag = false;
                        }
                        $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getReportList);
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );

            }else{
                endorseInsuredServ.endorseInsuredUpdate(surrendData).then(
                    function(anwser){
                        $scope.endorseReturnDto = anwser.data.endorseReturnDto;
                        if(anwser.data.delMsg != null){
                            return;
                        }
                        $scope.insuredTypeTemp=anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType;
                        if(anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType == '1'){
                            $scope.insTypeLeft = true;
                            $scope.insTypeRight = true;
                            $scope.personalFlag = true;
                            if ( anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identityEndDate != '' && anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identityEndDate != null){
                                anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identityEndDate= $filter("date")(anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identityEndDate, "yyyy-MM-dd").substr(0,10);
                            }
                            $scope.changeInsureType = 'components/prpins/endorse/tpl/endorsePersonal.html';
                            if(anwser.data.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex == "1"){
                                $scope.SexManFlag = true;
                                $scope.SexWomanFlag = true;
                            }else{
                                $scope.SexManFlag = false;
                                $scope.SexWomanFlag = false;
                            }
                        }else{
                            $scope.insTypeLeft = false;
                            $scope.insTypeRight = false;
                            $scope.personalFlag = false;
                            $scope.changeInsureType = 'components/prpins/endorse/tpl/endorseGroup.html';
                        }
                        if($scope.endorseReturnDto.prpPheadDto.riskCode == 'EQ02'){
                            $scope.emailRequiredFlag = false;
                        }
                        $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getReportList);
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }

        };

        initFunPageInfo();

        /*radio-个人组织*/
        $scope.insTypeLeft = true;
        $scope.insTypeRight = true;
        $scope.personalFlag = true;
        $scope.changeInsureType = 'components/prpins/endorse/tpl/endorsePersonal.html';

        $scope.serachInsured=function(){
            searchFlalg = true;
            getReportList();
        };

        //控制是否显示渠道信息
        function businessInit(bussinessNature){
            if(bussinessNature.substr(0,1)=='2' || bussinessNature=='300' || bussinessNature=='122' || bussinessNature=='123'){
                $scope.agentFlag = false;
            }else{
                $scope.agentFlag = true;
            }
        }

        /*删除批单*/
        $scope.deleteLayer = true;
        $scope.deleteshowInsure = function(){
            $scope.deleteLayer = false;
            $scope.endorseUpdateConditionDto = {};
            $(".validation-errorText").css('display','none');
        };
        /*删除监听*/
        $scope.delReasonFlag = true;
        $scope.endorseUpdateConditionDto = {};
        $scope.$watch("endorseUpdateConditionDto.delReasonCode",function(){
            if($scope.endorseUpdateConditionDto.delReasonCode == '03'){
                $scope.delReasonFlag = false;
            }else{
                $scope.delReasonFlag = true;
            }
        });
        /*删除确认*/
        $scope.surrendDeleteConfirm = function(){
            if(!this.deleteEndorseForm.$valid){
                FormFocus.focusEle("deleteEndorseForm");
                return
            }else{
                var endorseUpdateConditionDto = {};
                endorseUpdateConditionDto.applyNo = $scope.endorseReturnDto.prpPheadDto.applyNo;
                endorseUpdateConditionDto.delReasonCode = this.endorseUpdateConditionDto.delReasonCode;
                endorseUpdateConditionDto.delReasonDesc = this.endorseUpdateConditionDto.delReasonDesc;
                endorseInsuredServ.deleteApplyNo(endorseUpdateConditionDto).then(
                    function(answer){
                        if(answer.data.resultCode != '00'){
                            /*$state.go("main.endorseDeleteFail",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})*/
                            $scope.msg=answer.data.resultMessage;
                            $scope.insuredOnlyOneLayer = false;
                            $scope.deleteLayer = true;
                            return
                        }else{

                            $state.go("main.endorseDeleteSuccess",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})
                        }
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }
        };
        $scope.surrendDeleteClose = function(){
            this.endorseUpdateConditionDto={};
            $(".validation-errorText").css('display','none');
            $scope.deleteLayer = true;

        };
        /*被保险人批量导出
        $scope.downloadInsuredAll = function(){
            var exportQueryDto = {};
            var filePath = $scope.filePath;
            exportQueryDto.policyDetailParam='endorse';
            exportQueryDto.bussinessNo=$scope.endorseReturnDto.prpPheadDto.applyNo;
            endorseInsuredServ.downloadInsureds(exportQueryDto).then(
                function(answer){
                    if(answer.data.returnCode=='0000'){
                        var fileId = answer.data.shortLinkId;
                        /*下载文件
                        endorseInsuredServ.downloadExcel(fileId);
                    }else{
                        alert(answer.data.returnMessage);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                })
        };*/
        /*修改被保险人*/
        $scope.insuredLayer = true;
        $scope.structFlag = false;
        $scope.endorseInsuredUpdate = function(serialNo){
            if($scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType == '1'){
                this.InsuredSameShows = true;
                $scope.InsuredSameShows = true;
                 //设置默认【同投保人】为不勾选
                $scope.toggle = !$scope.toggle;
                $scope.toggle = true;
            }else{
                this.InsuredSameShows = false;
                $scope.InsuredSameShows = false;
            }
            var prpPheadDto = {};
            prpPheadDto.applyNo = $scope.endorseReturnDto.prpPheadDto.applyNo;
            prpPheadDto.serialNo = serialNo;
            prpPheadDto.policyNo = $scope.endorseReturnDto.prpPheadDto.policyNo;
            prpPheadDto.validDate = $scope.endorseReturnDto.prpPheadDto.validDate;
            endorseInsuredServ.endorseStatusValid(prpPheadDto).then(
                function(answer){
                    if(answer.data.resultCode != '0000'){
                        $scope.msg=answer.data.resultMsg;
                        $scope.insuredOnlyOneLayer = false;
                        return;
                    }
                    //若不存在无序批改
                    else{
                        endorseInsuredServ.endorseUpdate(prpPheadDto).then(
                            function(answer){
                                if(answer.data.sex == '1'){
                                    $scope.insuredSexManFlag = false;
                                    $scope.insuredSexWomanFlag = false;
                                }else if(answer.data.sex == '2'){
                                    $scope.insuredSexManFlag = true;
                                    $scope.insuredSexWomanFlag = true;
                                }else{
                                    $scope.insuredSexManFlag = true;
                                    $scope.insuredSexWomanFlag = false;
                                }
                                if(answer.data.repairFlag == 'Y'){
                                    $scope.buildTime = true;
                                }else{
                                    $scope.buildTime = false;
                                }
                                if(answer.data.buildStructure == '99'){
                                    $scope.structFlag = true;
                                }else{
                                    $scope.structFlag = false;
                                }
                                $scope.prpCopyInsuredPropDto = answer.data;
                                $scope.prpCopyInsuredPropDto.amount = answer.data.amount/10000;
                                $scope.$broadcast('scopeInitOver',{ctlName:"endorseInsured"});
                                $scope.insuredLayer = false;
                                var layerH = $(".layerOver").height()+37;
                                if(layerH > _windowH){
                                    $(".layerOver").css("height","500px");
                                    $(".revise_insurant").css("margin-top","-260px");
                                }
                            },function(error){
                                //cconsole.log(JSON.stringify(error.data));
                            }
                        )
                    }
                },function(error){
                    cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        $scope.endorseInsuredClose = function(){
            $scope.insuredLayer = true;
        };

        /*被保险人及标的-同投保人*/
        $scope.toggle = true;
        $scope.endorseInsuredSame = function(){
            $scope.toggle = !$scope.toggle;
            if($scope.toggle == true){
            }else{
                //同投保人
                if("1" == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType){
                    $(".validation-errorText").css('display','none');
                    var prpCopyInsuredDto = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto;
                    $scope.prpCopyInsuredPropDto.insuredName = prpCopyInsuredDto.insuredName;
                    if(prpCopyInsuredDto.prpCopyInsuredNatureDto.sex  == '1'){
                        //性别是男
                        $scope.insuredSexManFlag = false;
                        $scope.insuredSexWomanFlag = false;
                        $scope.prpCopyInsuredPropDto.sex = '1';
                    }else if(prpCopyInsuredDto.prpCopyInsuredNatureDto.sex  == '2'){
                        //性别是女
                        $scope.insuredSexManFlag = true;
                        $scope.insuredSexWomanFlag = true;
                        $scope.prpCopyInsuredPropDto.sex = '2';
                    }else{
                        $scope.insuredSexManFlag = false;
                        $scope.insuredSexWomanFlag = true;
                        $scope.prpCopyInsuredPropDto.sex = '2';
                    }
                    $scope.prpCopyInsuredPropDto.identifyType =  prpCopyInsuredDto.identifyType;
                    $scope.prpCopyInsuredPropDto.identifyName=  prpCopyInsuredDto.identifyName;
                    $scope.prpCopyInsuredPropDto.identifyNumber = prpCopyInsuredDto.identifyNumber;
                    $scope.prpCopyInsuredPropDto.mobile =   prpCopyInsuredDto.mobile;
                    $scope.prpCopyInsuredPropDto.email = prpCopyInsuredDto.email;
                    $scope.prpCopyInsuredPropDto.insuredAddress = prpCopyInsuredDto.insuredAddress;
                    $scope.prpCopyInsuredPropDto.identityEndDate = prpCopyInsuredDto.identityEndDate;
                }
            }
        };
        /*被保险人批量导出*/
        $scope.downloadInsuredAll = function(){
            var InsuredExportQueryDto = {};
            var filePath = $scope.filePath;

            //InsuredExportQueryDto.policyNo=policyNo;
            //InsuredExportQueryDto.bussinessNo=policyNo;
            //下载最新的  关系人 
            InsuredExportQueryDto.bussinessNo=$scope.endorseReturnDto.prpPheadDto.applyNo;
            InsuredExportQueryDto.policyDetailParam='endorse';
            InsuredExportQueryDto.exportType='Insured';
            InsuredExportQueryDto.riskCode = $scope.endorseReturnDto.prpPheadDto.riskCode;
            endorseInsuredServ.downloadInsureds(InsuredExportQueryDto).then(
                function(answer){
                    if(answer.data.returnCode=='0000'){
                        var shortLinkId = answer.data.shortLinkId;
                        /*下载文件*/
                        endorseInsuredServ.downloadExcel(shortLinkId);
                    }else{
                        angular.alert(answer.data.returnMessage);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                })
        };
        /*保存*/
        $scope.insuredOnlyOneLayer = true;
        $scope.saveEndorseInsured = function(){
            var endorseData =$scope.endorseReturnDto ;
            endorseData.copyPolicyDto.prpCopyInsuredDto.insuredType= $scope.insuredTypeTemp;
            endorseData.policyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.policyNo;
            endorseData.validDate = $scope.endorseReturnDto.prpPheadDto.validDate;
            endorseInsuredServ.saveEndorseInsure(endorseData).then(
                function(anwser){
                    $scope.msg = '恭喜您，保存成功！';
                    if(anwser.data.delMsg!=undefined&&anwser.data.delMsg!=null){
                        $scope.msg=anwser.data.delMsg;
                    }
                    $scope.insuredOnlyOneLayer = false;
                },function(error){
                    angular.alert("非常抱歉，保存失败！");
                }
            )
        };
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };

        /*下一步*/
        $scope.endorseInsuredNext = function(){
            //获取到表单是否验证通过
            if($scope.endorseInsuredForm.$valid){
                if($scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType == '2'){
                    if(undefined == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto
                        || ((""==$scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.organizeCode
                        ||null == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.organizeCode
                        ||undefined == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.organizeCode )
                        && ($scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.businessCode == ''
                        ||undefined == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.businessCode
                        ||null == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.businessCode)
                        && ($scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.revenueRegistNo == ''
                        ||undefined == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.revenueRegistNo
                        ||null == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.revenueRegistNo)
                        && ($scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.creditCode == ''
                        ||  undefined == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.creditCode
                        ||null == $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto.creditCode))){
                        $scope.msg ='组织机构代码证号、税务登记证号、营业执照号及社会统一信用代码必须填入至少一项';
                      // $scope.insuredOnlyOneLayer = false;
                       // return
                    }
                }
                var endorseReturnDto= $scope.endorseReturnDto;
                var endorseData = endorseReturnDto;
                endorseData.copyPolicyDto.prpCopyInsuredDto.insuredType= $scope.insuredTypeTemp;
                endorseData.policyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyMainDto.policyNo;
                endorseData.validDate = $scope.endorseReturnDto.prpPheadDto.validDate;
                endorseInsuredServ.endorseInsureNext(endorseData).then(
                    function(anwser){
                        if(anwser.data.delMsg!=undefined&&anwser.data.delMsg!=null){
                            $scope.msg=anwser.data.delMsg;
                            $scope.insuredOnlyOneLayer = false;
                            return;
                        }
                        var applyNo = anwser.data.endorseReturnDto.applyNo;
                        $state.go("main.endorseConfirm",{"applyNo":applyNo,"pageDir":'01','policyNo':$stateParams.policyNo})
                    },function(error){
                        angular.alert("非常抱歉，提交失败！");
                    }
                )

            }else{
                FormFocus.focusEle("endorseInsuredForm");
                return;
            }
        };
        /*被保险人点击确定*/
        $scope.endorseInsuredSave = function(){
            var prpoposalDto = {};
            var prpoposalDto = angular.copy($scope.prpCopyInsuredPropDto);
            //amount 的单位是万元，这里要乘以10000
            prpoposalDto.amount  = prpoposalDto.amount * 10000;
            //获取到表单是否验证通过
            if(this.endorseInsuredForm.$valid){
                endorseInsuredServ.endorseInsureOk(prpoposalDto).then(
                    function(answer){
                        if(answer.data.returnCode != '00'){
                            $scope.msg=answer.data.returnMessage;
                            $scope.insuredOnlyOneLayer = false;
                        }else {
                            getReportList();
                            $scope.insuredLayer = true;
                        }
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }else{
                FormFocus.focusEle("endorseInsuredForm");
                return;
            }
        };
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        /*关闭弹层*/
        $scope.addhideInsure = function(){
            $scope.insuredLayer = false;

        };

        /*投保男女*/
        $scope.radioSexClick = function () {
            $scope.SexManFlag = true;
            $scope.SexWomanFlag = true;
            $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex = '1';
        };
        $scope.radioSexClick1 = function () {
            $scope.SexManFlag = false;
            $scope.SexWomanFlag = false;
            $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredNatureDto.sex = '2';
        };

        /*被保险人男女*/
        $scope.radioSexClick2 = function () {
            $scope.insuredSexManFlag = false;
            $scope.insuredSexWomanFlag = false;
            $scope.prpCopyInsuredPropDto.sex = "1";
        };
        $scope.radioSexClick3 = function () {
            $scope.insuredSexManFlag = true;
            $scope.insuredSexWomanFlag = true;
            $scope.prpCopyInsuredPropDto.sex = "2";
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
            var data= $scope.customerDatas[$scope.num];
            var prpCopyinsured = {};
            var prpCopyInsuredNatureDto = {};
            prpCopyinsured.insuredName = data.customerName;//姓名
            prpCopyinsured.identifyType = data.credentialsType;//证件类型
            prpCopyinsured.identifyNumber = data.credentialsNumber;//证件号码
            prpCopyinsured.prpCopyInsuredNatureDto = prpCopyInsuredNatureDto;//性别
            prpCopyinsured.email = data.email;//邮件
            prpCopyinsured.insuredAddress = data.address;//地址
            prpCopyinsured.insuredType = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType;
            $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto = prpCopyinsured;
            prpCopyInsuredNatureDto.sex = data.sexCode;
            if(prpCopyInsuredNatureDto.sex == '1'){
                $scope.SexManFlag = true;
                $scope.SexWomanFlag = true;
            }else{
                $scope.SexManFlag = false;
                $scope.SexWomanFlag = false;
            }
            $scope.personnalSearchLayer = false;
            $scope.$broadcast("changeValue");
            //eventBus['scopeInitOver'].pub({ctlName:"application"});
        }
        var getCustomerList = function(){
            var insuredName= $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;
            var insuredType= $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredType;
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
            //每次搜索给num赋值赋值为0
            $scope.personNum(0);
            var insuredName= $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
                //初始化分页
                $scope.customerConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                    //onChange: getInsuredList
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
        };
        /*团体客户搜索*/
        $scope.groupSearchLayer = false;
        function teamFun(){
            if($scope.teamConf.totalItems == 0){
                $scope.groupSearchLayer = false;
            }else if($scope.teamConf.totalItems == 1){
                $scope.groupSearchLayer = false;
                var dataTeamOne= $scope.teamDatas[0];
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName = dataTeamOne.customerName;//名称
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.linkerName = dataTeamOne.linkManName;//联系人
                var prpCopyinsured = {};
                prpCopyinsured.organizeCode = dataTeamOne.organizeCode;//组织机构代码
                prpCopyinsured.businessCode = dataTeamOne.businessLicence;//营业执照
                prpCopyinsured.revenueRegistNo = dataTeamOne.revenueCode;//税务登记号
                prpCopyinsured.creditCode = dataTeamOne.socialCredit;//社会统一信用代码
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.mobile = '';//联系电话
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.phoneNumber = '';//手机号
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.email = dataTeamOne.linkManEmail;//email
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredAddress = dataTeamOne.linkManAddress;//地址
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtifDto = prpCopyinsured;
                $scope.$broadcast("changeValue");
            }else{
                var data= $scope.teamDatas[$scope.num1];
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName = data.customerName;
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.linkerName = data.linkManName;
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.mobile = '';
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.phoneNumber = '';
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.email = data.linkManEmail;
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredAddress = data.linkManAddress;
                var prpCopyInsured = {};
                prpCopyInsured.organizeCode = data.organizeCode;
                prpCopyInsured.businessCode = data.businessLicence;
                prpCopyInsured.revenueRegistNo = data.revenueCode;
                prpCopyInsured.creditCode = data.socialCredit;
                $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtiDto = prpCopyInsured;
                $scope.groupSearchLayer = false;
                $scope.$broadcast("changeValue");
            }
        }
        var getTeamList = function(){
            var insuredName= $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;
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
            //每次搜索给num赋值赋值为0
            $scope.teamNum(0);
            var insuredName= $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
                // $scope.groupSearchLayer = true;
                //初始化分页
                $scope.teamConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
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
                $scope.prpCopyInsuredPropDto.insuredName = data.customerName;//名称
                $scope.prpCopyInsuredPropDto.identifyType = data.credentialsType;//证件类型
                $scope.prpCopyInsuredPropDto.identifyNumber = data.credentialsNumber;//证件号码
                $scope.prpCopyInsuredPropDto.mobile = '';//手机号码
                $scope.prpCopyInsuredPropDto.email = data.email;//邮件
                $scope.prpCopyInsuredPropDto.insuredAddress = data.address;//地址
                if(data.sexCode == '1'){
                    $scope.insuredSexManFlag = false;
                    $scope.insuredSexWomanFlag = false;
                }else{
                    $scope.insuredSexManFlag = true;
                    $scope.insuredSexWomanFlag = true;
                }
                $scope.$broadcast("changeValue");
                //eventBus['scopeInitOver'].pub({ctlName:"application"});
            }else{
                var data= $scope.insuredDatas[$scope.num2];
                $scope.insuredPersonSearchLayer = false;
                $scope.prpCopyInsuredPropDto.insuredName = data.customerName;//名称
                $scope.prpCopyInsuredPropDto.identifyType = data.credentialsType;//证件类型
                $scope.prpCopyInsuredPropDto.identifyNumber = data.credentialsNumber;//证件号码
                $scope.prpCopyInsuredPropDto.mobile ='';//手机号码
                $scope.prpCopyInsuredPropDto.email = data.email;//邮件
                $scope.prpCopyInsuredPropDto.insuredAddress = data.address;//地址
                if(data.sexCode == '1'){
                    $scope.insuredSexManFlag = false;
                    $scope.insuredSexWomanFlag = false;
                }else{
                    $scope.insuredSexManFlag = true;
                    $scope.insuredSexWomanFlag = true;
                }
                $scope.$broadcast("changeValue");
                //eventBus['scopeInitOver'].pub({ctlName:"application"});
            }
        }
        var getInsuredNameList = function(){
            var insure= $scope.prpCopyInsuredPropDto.insuredName;
            if(insure != null && insure != '' && insure != undefined ){
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
            var insuredName= this.prpCopyInsuredPropDto.insuredName;
            //每次搜索给num赋值赋值为0
            $scope.insuredNum(0);
            if(insuredName != null && insuredName != '' && insuredName != undefined ){
                //$scope.insuredPersonSearchLayer = true;
                //初始化分页
                $scope.insuredCusConf = {
                    currentPage: 1,     //当前所在的页
                    totalItems: 1,      //总共有多少条记录
                    itemsPerPage: 5,   //每页展示的数据条数
                    pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                    perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
                    //onChange: getInsuredList
                };
                $scope.insuredCusInfo = {pageNo:$scope.insuredCusConf.currentPage,
                    pageSize:$scope.insuredCusConf.itemsPerPage};
                $scope.$watch('insuredCusConf.currentPage + insuredCusConf.itemsPerPage', getInsuredNameList);
            }else{
                $scope.insuredPersonSearchLayer = false;
            }
        };
        $scope.insuredConfirm = function () {
            insuredCusFun();
        };
        $scope.insuredNewBlurClose = function(){
            $scope.insuredPersonSearchLayer = false;
        };
        //上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            $scope.imgFileTypeT = true;
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$scope.endorseReturnDto.applyNo,
                bussType:"E",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$scope.endorseReturnDto.applyNo
            }});
            $scope.FileLayer = true;
        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
        };
        /*退出*/
        $scope.onEdit = function(){
            $state.go("main.index");
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
            var townCode = $scope.prpCopyInsuredPropDto.townCode;
            var cityCode = $scope.prpCopyInsuredPropDto.cityCode;
            var provinceCode = $scope.prpCopyInsuredPropDto.provinceCode;
            doSelect("000000",provinceCode,""); //省下拉框的上级默认为000000
            doSelect(provinceCode,cityCode,"province");
            doSelect(cityCode,townCode,"city");

        };

        /**
         * controller数据初始化总方法
         */
        var initArea = function(){

            if(!angular.isDefined($scope.prpCopyInsuredPropDto)){
                $scope.prpCopyInsuredPropDto = {};
            }
            if(!angular.isDefined($scope.prpCopyInsuredPropDto.provinceCode)){
                $scope.prpCopyInsuredPropDto.provinceCode = "";
            }
            if(!angular.isDefined($scope.prpCopyInsuredPropDto.cityCode)){
                $scope.prpCopyInsuredPropDto.cityCode = "";
            }
            if(!angular.isDefined($scope.prpCopyInsuredPropDto.townCode)){
                $scope.prpCopyInsuredPropDto.townCode = "";
            }

            /**
             * 页面打开时，初始化完给下拉框赋值
             */
            $scope.$watch('insuredLayer',function(){
                if($scope.insuredLayer == false){
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

            //console.log("doSelect:"+upperCode+","+codeCode+","+flag);
            var condition = {codeType:"AreaCode",upperCode:upperCode};

            if(flag == "town"){
                console.log("选择town");
            } else if(flag == "city"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.prpCopyInsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.townList = answer.data.codeData;
                        $scope.prpCopyInsuredPropDto.townCode = codeCode;
                    }, function (error) {
                        $scope.townList = [];
                        //console.log(error.data);
                    }
                );

            }else if(flag == "province"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.prpCopyInsuredPropDto.cityCode = "";//清空市
                $scope.cityList = [];
                $scope.prpCopyInsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.cityList = answer.data.codeData;
                        $scope.prpCopyInsuredPropDto.cityCode = codeCode;
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
                        $scope.prpCopyInsuredPropDto.provinceCode = codeCode;
                    }, function (error) {
                        $scope.provinceList = [];
                        //console.log(error.data);
                    }
                );
                console.log("flag为空");
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
    };


    moduleApp.controller('endorseInsuredCtrl',['$scope','$state','eventBus','endorseInsuredServ','$stateParams','FormFocus','cusLayerServ','teamLayerServ','QuerySelectCode','$filter',endorseInsuredCtrl]);
});