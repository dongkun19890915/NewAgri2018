/**
 * Created by guoxianglian on 2016/9/10.
 * 退保模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseSurrendCtrl = function($scope,$state,endorseSurrendServ,QuerySelectCode,$filter,$stateParams,
                                       commFactory,FormFocus) {
        /*初始化*/
        $scope.endorseReturnDto = {};
        $scope.endorseReturnDto.prpPheadDto = {};
        $scope.endorseReturnDto.prpPpayeeAccountDto={};
        $scope.endorseReturnDto.prpPheadDto.surrenderType = '1';
        $scope.policyDetailParam='policy';
        $scope.surrendStartFlag = true;
        $scope.surrendCenFlag = true;
        $scope.emptyIdentifyNo= true;
        var identifyType;
        //批单生效日 只能在正负7天
        var scopeDate=new Date();
        scopeDate.setDate(scopeDate.getDate()+7);
        $scope.validDateMAX=$filter("date")(scopeDate, "yyyy-MM-dd");
        scopeDate=new Date();
        scopeDate.setDate(scopeDate.getDate()-7);
        $scope.validDateMin=$filter("date")(scopeDate, "yyyy-MM-dd");

        $scope.nowDate=$filter("date")(new Date(), "yyyy-MM-dd");

        //渠道信息不显示
        $scope.agentFlag = true;
        //保单详情弹层默认不显示
        $scope.policyDetail=true;
        //默认显示批单生效日
        $scope.validDateHide=false;
        $scope.startDateHide=true;
        var policyNo = $stateParams.policyNo;
        var endorType = $stateParams.endorType;
        var endorDate = $stateParams.endorDate;
        var validDate = $stateParams.validDate;

        function init(){
            var surrendData = {
                policyNo:policyNo,
                endorType:endorType,
                endorDate:endorDate,
                validDate:validDate
            };

            if($stateParams.oper=='update'){
                var endorseQueryConditionDto={};
                endorseQueryConditionDto.applyNo=$stateParams.applyNo;
                endorseSurrendServ.surUpdate(endorseQueryConditionDto).then(
                    function(anwser){
                        $scope.endorseReturnDto = anwser.data;
                        var validDate = $scope.endorseReturnDto.prpPheadDto.validDate;//标注日期
                        //businessInit方法会给validDate重新赋初始值，这里需要把之前用户录入的值再重新赋值
                        $scope.endorseReturnDto.prpPheadDto.validDate=validDate;
                        var endorseReturnDto = angular.copy($scope.endorseReturnDto);
                        $scope.writeBackWritePay($scope.endorseReturnDto.prpPpayeeAccountDtoList);
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }else{
                endorseSurrendServ.surInit(surrendData).then(
                    function(anwser){
                        $scope.endorseReturnDto = anwser.data.endorseReturnDto;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }

        }
        init();

        $scope.autoPpayeeAccountFlag=false;
        $scope.autoPpayeeAccount=function(){
            $scope.autoPpayeeAccountFlag=true;
        };
        $scope.changeIdentifyType=function(){
            $scope.autoPpayeeAccountFlag=true;
            /*收款人证件类型*/
            $scope.$watch("endorseReturnDto.prpPpayeeAccountDto.identifyType",function(newValue,oldValue, $scope){
                if(!$scope.autoPpayeeAccountFlag){
                    return;
                }
                if(oldValue == newValue){
                }else {
                    if($scope.endorseReturnDto.prpPpayeeAccountDto && $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredFlag=='1' &&  $scope.endorseReturnDto.prpPpayeeAccountDto.accountType=='00' ){
                        if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType){
                            $scope.endorseReturnDto.prpPpayeeAccountDto.accountName = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;//收款人姓名/名称
                            /*团体*/
                            //组织机构代码
                            if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='71'){
                                $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtiDto.organizeCode;
                            }
                            //税务登记证
                            else if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='72'){
                                $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtiDto.revenueRegistNo;
                            }
                            //营业执照
                            else if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='73'){
                                $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtiDto.businessCode;
                            }
                            //社会统一信用代码
                            else if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='74'){
                                $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.prpCopyInsuredArtiDto.creditCode;
                            }
                            //其他
                            else{
                                if($scope.emptyIdentifyNo){
                                    identifyType=oldValue;
                                    $scope.emptyIdentifyNo=false;
                                }
                                if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType==identifyType){
                                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identifyNumber;
                                }else{
                                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo='';
                                }
                            }
                        }
                    }else{
                        //收款人证件号码
                        $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = "";
                    }
                }
            });
        };
        /*收款人与投保人关系*/
        $scope.$watch("endorseReturnDto.prpPpayeeAccountDto.accountType",function(){
            if(!$scope.autoPpayeeAccountFlag){
                return;
            }
            if($scope.endorseReturnDto.prpPpayeeAccountDto && $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredFlag=='1'){
                if($scope.endorseReturnDto.prpPpayeeAccountDto.accountType && $scope.endorseReturnDto.prpPpayeeAccountDto.accountType=='00' ){
                    //收款人证件号码
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identifyNumber;
                    //收款人姓名/名称
                    $scope.endorseReturnDto.prpPpayeeAccountDto.accountName = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.insuredName;
                    //收款人证件类型
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType = $scope.endorseReturnDto.copyPolicyDto.prpCopyInsuredDto.identifyType;

                }else{
                    //收款人姓名/名称
                    $scope.endorseReturnDto.prpPpayeeAccountDto.accountName = "";
                    //收款人证件类型
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType ="";
                    //收款人证件号码
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo = "";
                }
            }
        });

        //控制是否显示渠道信息
        function businessInit(bussinessNature,type){
            if(bussinessNature.substr(0,1)=='2' || bussinessNature=='300' || bussinessNature=='122' || bussinessNature=='123'){
                $scope.agentFlag = false;
            }else{
                $scope.agentFlag = true;
            }
            if(type){
                if(type.prpPheadDto.surrenderType=='0'){
                    $scope.radioSurrendClick();
                }else{
                    $scope. radioSurrendClick1();
                }
            }
        }
        //回写退费收款人信息
        $scope.writeBackWritePay=function(persions){
            if(!persions){
                return;
            }

            if(!$scope.endorseReturnDto.prpPpayeeAccountDto){
                $scope.endorseReturnDto.prpPpayeeAccountDto={};
            }

            for(var i=0;i<persions.length;i++){
                if(!persions[i]){
                    continue;
                }
                if(persions[i].accountType){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.accountType=persions[i].accountType;
                }
                if(persions[i].accountName){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.accountName=persions[i].accountName;
                }
                if(persions[i].identifyType){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=persions[i].identifyType;
                }
                if(persions[i].identifyNo){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.identifyNo=persions[i].identifyNo;
                }
                if(persions[i].basicBankCode){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.basicBankCode=persions[i].basicBankCode;
                }
                if(persions[i].accountNo){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.accountNo=persions[i].accountNo;
                }
                //向后添加银行信息写回
                if(persions[i].recBankProvinceName){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceName=persions[i].recBankProvinceName;
                }
                if(persions[i].recBankProvinceCode){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode=persions[i].recBankProvinceCode;
                    doSelect($scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode,$scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceName,"","CapitalProvince")
                }
                    //级联动后加载值
                if(persions[i].recBankCityName){
                    if($scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceName && $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode){
                        $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityName=persions[i].recBankCityName;
                    }
                }
                if(persions[i].recBankCityCode){
                    if($scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceName && $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode){
                        $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode=persions[i].recBankCityCode;
                        doSelect($scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode,$scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityName,"","CapitalCity")
                    }
                }
                if(persions[i].cnapsName){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.cnapsName=persions[i].cnapsName;
                }
                if(persions[i].isPrivate){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.isPrivate=persions[i].isPrivate;
                }
                if(persions[i].cnaps){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps=persions[i].cnaps;
                    $scope.endorseReturnDto.prpPpayeeAccountDto.cnapsName=persions[i].cnapsName;
                    $scope.capitalBank();
                    var conditionDto={};
                    conditionDto.codeType="CapitalCnaps";
                    conditionDto.codeCode=$scope.endorseReturnDto.prpPpayeeAccountDto.basicBankCode;
                    conditionDto.upperCode=$scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode;
                    conditionDto.newCodeCode=$scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode;
                    endorseSurrendServ.rebackBankInit(conditionDto).then(
                        function(answer){
                            $scope.rebackBanklist = answer.data.codeData;
                            doSelect($scope.endorseReturnDto.prpPpayeeAccountDto.cnaps,$scope.endorseReturnDto.prpPpayeeAccountDto.cnapsName,"","rebackBankType");
                        },function(error){
                            //cconsole.log(JSON.stringify(error.data));
                        }
                    );
                }
            }
            $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps = $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps;
        };

        /*被保险人住宅类型*/
        $scope.radioSurrendClick = function () {
            $scope.endorseReturnDto.prpPheadDto.surrenderType = '0';
            $scope.surrendStartFlag = false;
            $scope.surrendCenFlag = false;
            $scope.validDateHide=true;
            $scope.startDateHide=false;
            if($scope.surrenderTypeSwitch()){
                $scope.radioSurrendClick1();
                angular.alert("保险责任已开始，不可从起期退保。");
                return;
            }
            //起期退保 批单生效日 为保单起保日期。
            $scope.endorseReturnDto.prpPheadDto.validDate=$scope.endorseReturnDto.policyDto.prpCmainDto.startDate;
        };
        $scope.radioSurrendClick1 = function () {
            $scope.surrendStartFlag = true;
            $scope.surrendCenFlag = true;
            $scope.validDateHide=false;
            $scope.startDateHide=true;
            $scope.endorseReturnDto.prpPheadDto.surrenderType = '1';
            // 为明天
            var scopeDate=new Date();
            scopeDate.setDate(scopeDate.getDate()+1);
            $scope.endorseReturnDto.prpPheadDto.validDate=$filter("date")(scopeDate, "yyyy-MM-dd");
        };
        /*批单保存*/
        $scope.insuredOnlyOneLayer = true;

        $scope.surrendSave = function(){
            var endorseReturnDto= $scope.endorseReturnDto;
            var prpPpayeeAccountDtoList = [];
            prpPpayeeAccountDtoList[0] =$scope.endorseReturnDto.prpPpayeeAccountDto;
            endorseReturnDto.prpPpayeeAccountDtoList = prpPpayeeAccountDtoList;
            var data = endorseReturnDto;
            endorseSurrendServ.surSave(data).then(
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

        $scope.exitEndorse=function(){
            $state.go("main.index");
        };


        /*点击下一步*/
        $scope.surrendNext = function(){
            if($scope.endorseSurrendForm.$valid){
                var flagRadio = $scope.endorseReturnDto.prpPheadDto.surrenderType;
                if(flagRadio == '1'){
                    var vaildDate=$scope.endorseReturnDto.prpPheadDto.validDate;
                    var start=$scope.endorseReturnDto.policyDto.prpCmainDto.startDate;
                    var end=$scope.endorseReturnDto.policyDto.prpCmainDto.endDate;
                    vaildDate=new Date(vaildDate.replace(/-/g,"/") );
                    start=new Date(start.replace(/-/g,"/") );
                    end=new Date(end.replace(/-/g,"/") );
                    end.setHours(0);
                    end.setMinutes(0);
                    end.setSeconds(0);
                    if(vaildDate<start ||vaildDate>end ){
                        angular.alert("批改生效日必须在保单承保期间之内。");
                        return ;
                    }
                    if($scope.endorseReturnDto.policyDto.prpCmainDto.startDate== $scope.endorseReturnDto.prpPheadDto.validDate){
                        angular.alert("中途退保，批单生效日期需晚于保单生效日期。");
                        return ;
                    }
                }
                if($scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='71' ||
                   $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='72' ||
                   $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='73' ||
                   $scope.endorseReturnDto.prpPpayeeAccountDto.identifyType=='74'){
                    $scope.endorseReturnDto.prpPpayeeAccountDto.isPrivate='1';
                }else{
                    $scope.endorseReturnDto.prpPpayeeAccountDto.isPrivate='2';
                }
                var endorseReturnDto= $scope.endorseReturnDto;
                var prpPpayeeAccountDtoList = [];
                prpPpayeeAccountDtoList[0] =$scope.endorseReturnDto.prpPpayeeAccountDto;
                endorseReturnDto.prpPpayeeAccountDtoList = prpPpayeeAccountDtoList;
                var endorseData = endorseReturnDto;
                var endorseQueryDtoUpload={};
                endorseQueryDtoUpload.applyNo=$scope.endorseReturnDto.prpPheadDto.applyNo;
                endorseData.policyNo = $stateParams.policyNo;
                endorseData.validDate = $scope.endorseReturnDto.prpPheadDto.validDate;
                endorseSurrendServ.checkIDUpload(endorseData).then(
                    function(anwser){
                        if(anwser.data.resultCode=='0000'){
                            endorseSurrendServ.surSave(endorseData).then(
                                function(anwser){
                                    if(anwser.data.delMsg!=undefined&&anwser.data.delMsg!=null){
                                        $scope.msg=anwser.data.delMsg;
                                        $scope.insuredOnlyOneLayer = false;
                                        return;
                                    }
                                    var applyNo = anwser.data.endorseReturnDto.applyNo;
                                    $state.go("main.endorseConfirm",{"applyNo":applyNo,"pageDir":'02','policyNo':$stateParams.policyNo})
                                },function(error){
                                    angular.alert("非常抱歉，提交失败！");
                                }
                            )
                        }else{
                            $scope.msg = anwser.data.resultMsg;
                            $scope.insuredOnlyOneLayer = false;
                        }

                    },function(error){
                        angular.alert("非常抱歉，提交失败！");
                    }
                )
            }else{
                FormFocus.focusEle("endorseSurrendForm");
                return;
            }
        };
        /*文件上传*/
        $scope.surrendFileLayer = false;
        $scope.surrendFileUploadClick = function(){
            $scope.surrendFileLayer = true;
        };
        $scope.surrendFileUploadClose = function(){
            $scope.surrendFileLayer = false;
        };
        /*删除批单监听*/
        $scope.delReasonFlag = true;
        $scope.endorseUpdateConditionDto = {};
        $scope.$watch("endorseUpdateConditionDto.delReasonCode",function(){
            if($scope.endorseUpdateConditionDto.delReasonCode == '03'){
                $scope.delReasonFlag = false;
            }else{
                $scope.delReasonFlag = true;
            }
        });
        /*删除批单*/
        $scope.surrendDeleteLayer = false;
        $scope.surrendDeleteClick = function(){
            $scope.surrendFileLayer = true;
        };


        //退保类型切换验证
        $scope.surrenderTypeSwitch=function(){
            var shenqing=$scope.endorseReturnDto.prpPheadDto.endorDate;
            var vaildDate=$scope.endorseReturnDto.policyDto.prpCmainDto.startDate;
            shenqing=new Date(shenqing.replace(/-/g,"/") );
            vaildDate=new Date(vaildDate.replace(/-/g,"/") );
            if(shenqing>=vaildDate){
                $scope.surrendStartFlag = true;
                $scope.surrendCenFlag = true;
                $scope.validDateHide=false;
                $scope.startDateHide=true;
                $scope.endorseReturnDto.prpPheadDto.surrenderType="1";
                return true;
            }
            return false;
        };

        //批单删除
        $scope.deleteLayer = true;
        $scope.deleteshowInsure = function(){
            $scope.deleteLayer = false;
        };

        //删除批单返回后台
        $scope.surrendDeleteConfirm = function(){
            if(!this.deleteEndorseForm.$valid){
                FormFocus.focusEle("deleteEndorseForm");
                return
            }
            var endorseUpdateConditionDto = {};
            endorseUpdateConditionDto.applyNo = $scope.endorseReturnDto.prpPheadDto.applyNo;
            endorseUpdateConditionDto.delReasonCode = this.endorseUpdateConditionDto.delReasonCode;
            endorseUpdateConditionDto.delReasonDesc = this.endorseUpdateConditionDto.delReasonDesc;
            endorseSurrendServ.deleteApplyNo(endorseUpdateConditionDto).then(
                function(answer){
                    var data = answer.data.endorseUpdateConditionDto;
                    if(answer.data.resultCode != '00'){
                        $state.go("main.endorseDeleteFail",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})
                    }else{

                        $state.go("main.endorseDeleteSuccess",{"applyNo":$scope.endorseReturnDto.prpPheadDto.applyNo})
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        //显示保单详情
        $scope.policyDetailShow=function(){
            $scope.policyDetail=false;
        };
        //关闭显示保单详情
        $scope.policyDetailClose=function(){
            $scope.policyDetail=true;
        };
        //关闭删除批单弹层
        $scope.surrendDeleteClose = function(){
            $scope.deleteLayer = true;
            $scope.surrendFileLayer = false;
            $scope.endorseUpdateConditionDto = {};
            $(".validation-errorText").css('display','none');
        };

        //退保原因说明是否必录
        $scope.requiredReason=function(){

        };
        //上传配置
        /*文件上传*/
        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        $scope.FileshowInsure = function(){
            $scope.imgFileTypeT = true;
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$scope.endorseReturnDto.prpPheadDto.applyNo,
                bussType:"E",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$scope.endorseReturnDto.prpPheadDto.applyNo
            }});
            $scope.FileLayer = true;
        };
        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
        };

        var queryData = function(condition){
            var promise = QuerySelectCode.getData(condition);
            promise.then(
                function(answer){
                    //console.log("data:"+JSON.stringify(answer.data));
                },function(error){
                    //console.log("error:"+JSON.stringify(error));
                }
            );
            return promise;
        };
        /*监听开户行变化*/
        $scope.watchChange=function(){
            $scope.$watch("endorseReturnDto.prpPpayeeAccountDto.basicBankCode",function(){
                $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps="";//清空银行
            })
        };
        /**
         * 处理下拉框选中赋值
         * @author ZhangJiansen
         * @param upperCode 上级下拉框值
         * @param codeCode  要给下拉框赋的值
         * @param flag 被选中的下拉框
         */
        var doSelect = function(upperCode,codeCode,codeName,flag){
            var condition = {codeType:flag,upperCode:upperCode,upperName:codeCode};
            if (flag == "CapitalProvince"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode = "";//清空市
                $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps="";//清空银行
                $scope.cityList = [];

                condition = {codeType:'CapitalCity',upperCode:upperCode,upperName:codeCode};
                queryData(condition).then(
                    function (answer) {
                        $scope.cityList = answer.data.codeData;
                        $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceName = codeCode;
                    }, function (error) {
                        $scope.cityList = [];
                        //console.log(error.data);
                    }
                );
            }else if(flag == "rebackBankType"){
               $scope.endorseReturnDto.prpPpayeeAccountDto.cnapsName = codeCode;
            }else{
                $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps="";//清空银行
                $scope.rebackBanklist=[];
                condition = {codeType:'CapitalProvince'};
                queryData(condition).then(
                    function (answer) {
                        $scope.provinceList = answer.data.codeData;
                        $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityName = codeCode;
                    }, function (error) {
                        $scope.provinceList = [];
                        //console.log(error.data);
                    }
                );
            }
        };

        $scope.selectCode = function (item, flag) {
            doSelect(item.codeCode,item.codeName,"",flag);
        };
        $scope.capitalBank=function(){
            if(!$scope.transmissionForm.$valid){
                FormFocus.focusEle("transmissionForm");
                $scope.tipInfo=true;
                return;
            }else {
                $scope.tipInfo = false;
            }
            var conditionDto={};
            conditionDto.codeType="CapitalCnaps";
            conditionDto.codeCode=$scope.endorseReturnDto.prpPpayeeAccountDto.basicBankCode;
            conditionDto.upperCode=$scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode;
            conditionDto.newCodeCode=$scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode;
            endorseSurrendServ.rebackBankInit(conditionDto).then(
                function(answer){
                    $scope.rebackBanklist = answer.data.codeData;
                    doSelect($scope.endorseReturnDto.prpPpayeeAccountDto.cnaps,$scope.endorseReturnDto.prpPpayeeAccountDto.cnapsName,"","rebackBankType");
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        /**
         * 界面初始化为省市区下拉框赋值
         * @author ZhangJiansen
         */
        var initSelect = function(){

            if(!angular.isDefined($scope.endorseReturnDto.prpPpayeeAccountDto)){
                $scope.endorseReturnDto.prpPpayeeAccountDto = {};
            }
            if(!angular.isDefined($scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode)){
                $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode = "";
            }
            if(!angular.isDefined($scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode)){
                $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode = "";
            }

            var cityCode = $scope.endorseReturnDto.prpPpayeeAccountDto.recBankCityCode;
            var provinceCode = $scope.endorseReturnDto.prpPpayeeAccountDto.recBankProvinceCode;
            var cnaps = $scope.endorseReturnDto.prpPpayeeAccountDto.cnaps;

            doSelect("000000",'',""); //省下拉框的上级默认为000000 CapitalCity
            //doSelect(provinceCode,cityCode,"CapitalProvince");
            //doSelect(provinceCode,cityCode,"CapitalCity");
            //doSelect(provinceCode,cityCode,"rebackBankType");

        };

        initSelect();
    };
    moduleApp.controller('endorseSurrendCtrl',['$scope','$state','endorseSurrendServ','QuerySelectCode','$filter','$stateParams','commFactory','FormFocus',endorseSurrendCtrl]);
});