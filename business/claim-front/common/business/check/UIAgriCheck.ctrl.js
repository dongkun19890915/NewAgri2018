/**
 * DESC       : 国元农险理赔查勘定损任务查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'common/business/electronicsDocuments/UIAgriElectronics.examine.model.ctrl'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriCheckCtrl', ['$rootScope', '$timeout', '$scope', '$state','$location', '$stateParams','$filter','$$finder','regexpConstants','commonApiServ','$modal','$window',
        function ($rootScope, $timeout, $scope, $state, $location, $stateParams, $filter, $$finder, regexpConstants, commonApiServ,$modal,$window) {
            $scope.CheckPageResponseDto = {}; // 查询结果
            $rootScope.Dto={};
            $scope.checkInfo = {};
            var listNo ='';
            $scope.regData = regexpConstants;
            $scope.codeListData = {DamageCode:[]};
            // 页面状态标志 查勘定损登记 修改 查看
            $scope.showFlag = true;
            $scope.mriskSwitch = false;
            // 页面是否展示耳标号 以及定损登记内容
            $scope.isAquaculture=false;
            //更新出险户次
            $rootScope.$on('updateDamageInsured',function (event,data) {
                $scope.CheckPageResponseDto.prpLverifyLossDto.damageInsured = data;
            });
            $scope.CheckPageRequestDto = {
                editType:$stateParams.editType,
                registNo:$stateParams.registNo,
                flowId:$stateParams.flowId,
                logNo:$stateParams.logNo,
                riskCode:$stateParams.riskCode,
                checkNo:$stateParams.checkNo
                // editType:'EDIT',
                // registNo:'',
                // flowId:'L32203401022017000659',
                // logNo:'3',
                // checkNo:'432203401022017000652'
            }; // 查询条件
            // 调用本页面的下拉框进行初始化 请求回来后统一存放当前scope.codeListData上
            //$scope.classCode=$scope.CheckPageRequestDto.registNo.substring(1,3);
             var editType = $scope.CheckPageRequestDto.editType;//$stateParams.editType;
            if(editType === "ADD" || editType === "EDIT"){
                $scope.showFlag = false;
                $scope.mriskSwitch = true;
            }else if(editType === 'SHOW' ){
                $scope.showFlag = true;
            }
            //初始化查询
            $$finder.post("checkPageInit", $scope.CheckPageRequestDto).then(
                function (data) {
                 // 日期格式转换
                    var curDate=new Date();
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    data.prpLcheckDto.damageStartDate = $filter("date")(data.prpLcheckDto.damageStartDate, "yyyy-MM-dd");
                    data.prpLcheckDto.checkDate = $filter("date")(data.prpLcheckDto.checkDate, "yyyy-MM-dd");
                    //初始化金禾清单
                    if(editType==="ADD"){
                        var _dto = {
                            "registNo":data.prpLcheckDto.registNo,
                            "policyNo":data.prpLcheckDto.policyNo
                        };
                        $$finder.post("queryBreedAndPlantingLossRateListPageInit", _dto).then(function (data1) {
                            if(data1.code!='0000'&&data1.code!='9999'){
                                if(data1.underWriteEndDate){
                                    $scope.CheckPageResponseDto.prpLverifyLossDto.underWriteEndDate=$filter("date")(data1.underWriteEndDate, "yyyy-MM-dd");
                                }
                                $scope.CheckPageResponseDto.prpLverifyLossDto.lossEsnumBer=data1.lossEsnumBer;
                                $scope.CheckPageResponseDto.prpLverifyLossDto.damageInsured=data1.damageInsured;
                                if(data1.checkContext){
                                    $scope.CheckPageResponseDto.context=data1.checkContext;
                                }
                                if(_dto.policyNo.substring(1,3)==='31'){
                                    if(data1.disasterArea){
                                        $scope.CheckPageResponseDto.prpLverifyLossDto.disasterArea=data1.disasterArea;
                                    }
                                    if(data1.affectEDarea){
                                        $scope.CheckPageResponseDto.prpLverifyLossDto.affectEDarea=data1.affectEDarea;
                                    }
                                    if(data1.noProductionArea){
                                        $scope.CheckPageResponseDto.prpLverifyLossDto.noProductionArea=data1.noProductionArea;
                                    }
                                }else{
                                    if(data1.deathQuantity){
                                        $scope.CheckPageResponseDto.prpLverifyLossDto.deathQuantity=data1.deathQuantity;
                                    }
                                    if(data1.killQuantity){
                                        $scope.CheckPageResponseDto.prpLverifyLossDto.killQuantity=data1.killQuantity;
                                    }
                                }
                            }
                        },function (error) {

                        });
                    }
                    if(data.prpLverifyLossDto.underWriteEndDate==null){
                        data.prpLverifyLossDto.underWriteEndDate = $filter("date")(curDate, "yyyy-MM-dd");
                    }else{
                        data.prpLverifyLossDto.underWriteEndDate = $filter("date")(data.prpLverifyLossDto.underWriteEndDate, "yyyy-MM-dd");
                    }
                    console.log(data)
                    $scope.CheckPageResponseDto = data;
                    $rootScope.Dto=data;
                    $scope.registNo=data.registNo;
                    $scope.prpLclaimStatusDto = data.prpLclaimStatusDto;

                    if($scope.CheckPageResponseDto.riskType==="H"||$scope.CheckPageResponseDto.riskCode==='3224'||$scope.CheckPageResponseDto.riskCode==='3237'){//种植险
                        $scope.isAquaculture=false;
                    }else if($scope.CheckPageResponseDto.riskType==="I"&&$scope.CheckPageResponseDto.riskCode!='3224'&&$scope.CheckPageResponseDto.riskCode!='3237'){//养殖险
                        $scope.isAquaculture=true;
                    }
                    // 下拉框初始化
                    var _data = {
                        "casecadeConditionList": [
                            {
                                "name": "",
                                "value": ''
                            }
                        ],
                        "initlist": [
                            {
                                "codeType": "DamageCode",
                                "riskCode": $scope.CheckPageResponseDto.riskCode
                            }
                        ]
                    };
                    $$finder.post("baseCode", _data).then(function (data) {
                        angular.forEach(data.data,function(item,index) {
                            $scope.codeListData[item.codeType] = item.resultobj.action_result;
                        });
                    },function (error) {

                    });
                });
            //发起调查
            $scope.investigate=function(){
                    var dto = {
                        "registNo":$scope.CheckPageRequestDto.registNo,
                        "policyNo":$scope.CheckPageResponseDto.prpLcheckDto.policyNo
                    };
                    $$finder.post("submitInvestigation",dto).then(
                        function (data) {
                            if(data && data.code =='0000'){
                                layerMsg(data.message);
                            }else if(data && data.code == '9999'){
                                layerMsg("发起调查失败! ");
                            }else{
                                layerMsg(data.message);
                            }
                        }
                    );
            }


            //    养殖险导入清单
            var isSuccess=111;
            $scope.importlist=function(){
                $modal.open({
                    templateUrl: 'common/business/regist/UIAgriRegist.importList.modal.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.CheckPageResponseDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                        var uploader = $scope.uploader = new FileUploader({
                            url:'/fileserver/uploadFile',
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response, status, headers){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                //判断导入的理赔清单类型
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "fileName":"tttt",
                                    "riskCode":$rootScope.Dto.riskCode,
                                    "policyNo":$rootScope.Dto.prpLcheckDto.policyNo,
                                    "damageStartDate":$rootScope.Dto.prpLcheckDto.damageStartDate,
                                    "damageStartHour":$rootScope.Dto.prpLcheckDto.damageStartHour,
                                    "userCode":$rootScope.user.userCode,
                                    "userName":$rootScope.user.userName,
                                    "nodeOrigin":$rootScope.Dto.nodeType,
                                    "registNo": $rootScope.Dto.registNo
                                };
                                console.log(keywords);
                                $$finder.post("readBreedingList",keywords).then(
                                    function (data) {
                                        if(data && !data.code && data != 'gateway'){
                                            $rootScope.$broadcast('updateDamageInsured',data.damageInsured);
                                            layerMsg("导入成功");
                                            isSuccess=222;
                                            listNo=data.listNo;
                                        }else if(data && data.code == '9999'){
                                            layerMsg("导入失败! "+data.message);
                                        }else{
                                            layerMsg("导入失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("导入失败");
                                    }
                                );
                            }
                            if(response.code == '9999'){
                                layerMsg("导入失败"+response.message);
                            }
                        };
                        $scope.uploader.onErrorItem = function(item, response, status, headers){
                            layerMsg("导入失败");
                        };
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.download = function (_type) {
                            var url = '';
                            //耳标号承保清单下载
                            if(_type == 'LossRateList'){
                                var keywords =
                                {
                                    "policyNo":queryDto.prpLcheckDto.policyNo,
                                    "registNo":queryDto.prpLcheckDto.registNo
                                    // "registNo":"3310103"//报案号
                                };
                                //种植险承保清单导出Excel
                                url = 'earmarkUnderwritingDownload';

                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'template'){
                                //模板下载
                                //养殖险理赔清单空模版下载
                                // url = 'nyxBreedClaimLis';
                                /*$window.open('/api/agriclaim/templateFile/download?fileType=dingSunClaimList');*/
                                var keywords =
                                {
                                    "registNo":queryDto.prpLcheckDto.registNo,
                                    "policyNo":queryDto.prpLcheckDto.policyNo,
                                };
                                $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'policy'){
                                //保单清单下载
                                var keywords =
                                {
                                    //"policyNo":queryDto.policyNo//保单号
                                    "policyNo":"231013418002013000827"
                                };
                                url = 'NyxPolicyListExportExcel';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                        //确认按钮
                        $scope.determine = function () {
                            if(isSuccess!=222){
                                layerMsg("请导入清单！");
                            }else{
                                $modalInstance.dismiss();
                            }
                        };
                    }
                });
            }
            //清单下载
            $scope.downloadlist=function(){
                var keywords =
                {
                    "registNo":$scope.CheckPageResponseDto.prpLcheckDto.registNo,
                    "policyNo":$scope.CheckPageResponseDto.prpLcheckDto.policyNo,
                    "origin":"0"
                };
                $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                    function (data) {
                        if(data && data.url){
                            $window.open(data.url);
                        }else if(data && data.shortLink){
                            $window.open(data.shortLink);
                        }else if(data.code == '9999'){
                            layerMsg("下载失败，"+data.message);
                        }else {
                            layerMsg("不存在GIS系统推送的定损数据，请稍后再进行下载！")
                        }
                    },
                    function (e) {
                        layerMsg("下载失败");
                    }
                );
            }

            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.CheckPageResponseDto.prpLcheckDto.policyNo;
                $$finder.post('relatePolicyInfo', {policyNo:policyNo}).then(
                    function (data) {
                        console.log(data);
                        $scope.relateInfoDto = data;
                        angular.forEach($scope.relateInfoDto.prpLregistDtoList,function(result){
                            result.damageStartDate= $filter("date")(result.damageStartDate, "yyyy-MM-dd");
                        })

                        angular.forEach($scope.relateInfoDto.prpPheadDtoList,function (dto){
                            dto.underwriteEndDate = $filter("date")(dto.underwriteEndDate, "yyyy-MM-dd");
                        })

                    }
                )
            }
            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }

            // 损失种植险清单数据导入
            var isSuccess=111;
            $scope.import=function(){
                $modal.open({
                    templateUrl: 'common/business/regist/UIAgriRegist.Plantingrisk.importList.modal.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.CheckPageResponseDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                        var uploader = $scope.uploader = new FileUploader({
                            url:'/fileserver/uploadFile',
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response, status, headers){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                //判断导入的理赔清单类型
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "fileName":"plantingList",
                                    "riskCode":$rootScope.Dto.riskCode,
                                    "policyNo":$rootScope.Dto.prpLcheckDto.policyNo,
                                    "damageStartDate":$rootScope.Dto.prpLcheckDto.damageStartDate,
                                    "damageStartHour":$rootScope.Dto.prpLcheckDto.damageStartHour,
                                    "userCode":$rootScope.user.userCode,
                                    "userName":$rootScope.user.userName,
                                    "nodeOrigin":$rootScope.Dto.nodeType,
                                    "registNo": $rootScope.Dto.registNo

                                };
                                debugger;
                                $$finder.post("readPlantingList",keywords).then(
                                    function (data) {
                                        if(data && !data.code && data != 'gateway'){
                                            $rootScope.$broadcast('updateDamageInsured',data.damageInsured);
                                            layerMsg("导入成功");
                                            isSuccess=222;
                                            listNo=data.listNo;
                                            //listNo=data.content[0].listNo;
                                        }else if(data && data.code == '9999'){
                                            layerMsg("导入失败! "+data.message);
                                        }else{
                                            layerMsg("导入失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("导入失败");
                                    }
                                );
                            }
                            if(response.code == '9999'){
                                layerMsg("导入失败"+response.message);
                            }
                        };
                        $scope.uploader.onErrorItem = function(item, response, status, headers){
                            layerMsg("导入失败");
                        };
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.plantingdownload = function (_type) {
                            var url = '';
                            //承保清单下载
                            if(_type == 'LossRateList'){
                                var keywords =
                                {
                                    "policyNo":queryDto.prpLcheckDto.policyNo,
                                    "registNo":queryDto.prpLcheckDto.registNo
                                };
                                //种植险承保清单导出Excel
                                url = 'earmarkUnderwritingDownload';

                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'template'){
                                //模板下载
                                //养殖险理赔清单空模版下载
                                // url = 'nyxBreedClaimLis';
                                /*$window.open('/api/agriclaim/templateFile/download?fileType=PlantingDingSunList');*/
                                var keywords =
                                {
                                    "registNo":queryDto.prpLcheckDto.registNo,
                                    "policyNo":queryDto.prpLcheckDto.policyNo,
                                };
                                $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'policy'){
                                //保单清单下载
                                var keywords =
                                {
                                    //"policyNo":queryDto.policyNo//保单号
                                    "policyNo":"231013418002013000827"
                                };
                                url = 'NyxPolicyListExportExcel';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                        //确认按钮
                        $scope.determine = function () {
                            if(isSuccess!=222){
                                layerMsg("请导入清单！");
                            }else{
                                $modalInstance.dismiss();
                            }
                        };
                    }
                });
            }
            // if ($stateParams.riskCode == "37011") { // 种植为true
            //     $scope.mriskSwitch = true
            // }
            /**
             * 理赔沟通
             */

            $scope.showCompensateComm = function () {
                var policyNo=$scope.CheckPageResponseDto.prpLcheckDto.policyNo;
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        __CheckPageResponseDto:function () {
                            return angular.copy($scope.CheckPageResponseDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,__CheckPageResponseDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo":policyNo || '',//保单号
                                "registNo": __CheckPageResponseDto.registNo || '',//报案号
                                "claimNo": __CheckPageResponseDto.claimNo || '',//立案号
                                "riskCode": __CheckPageResponseDto.riskCode || '',//险种代码
                                "nodeType": __CheckPageResponseDto.nodeType,//TODO 节点类型  __CheckPageResponseDto.nodeType || ''
                                "operatorCode": __CheckPageResponseDto.userCode,//TODO 操作员代码  __CheckPageResponseDto.operatorCode || ''
                                "operatorName":  __CheckPageResponseDto.operatorName,//TODO 操作员代码  __CheckPageResponseDto.operatorName || ''
                                "inputDate":"2017-10-27" //TODO 制单日期      __CheckPageResponseDto.inputDate || ''
                            };
                            $$finder.post('queryClaimCommunicationByCondition',keywords).then(
                                function (data){
                                    if(data && !data.code){
                                        $scope.communication = data;
                                        $scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        $scope.closeModal();
                                        layerMsg(data.message);
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                    $scope.closeModal();
                                }
                            );
                        }
                        init();
                        //重置
                        $scope.resetContext = function () {
                            $scope.communication.context = '';
                        };
                        //提交
                        $scope.submitCommuication = function () {
                            var keywords2 = {
                                "policyNo": $scope.communication.policyNo || '',
                                "registNo": $scope.communication.registNo || '',
                                "claimNo": $scope.communication.claimNo || '',
                                "riskCode": $scope.communication.riskCode || '',
                                "inputDate": $scope.communication.inputDate || '',
                                "nodeTypeName": $scope.communication.nodeTypeName || '',
                                "nodeType": $scope.communication.nodeType || '',
                                "operatorCode": $scope.communication.operatorCode || '',
                                "operatorName": $scope.communication.operatorName || '',
                                "context": $scope.communication.context || ''
                            };
                            $$finder.post('saveClaimCommunicationInfo',keywords2).then(
                                function (data) {
                                        if(data){
                                            layer.open({
                                                offset: ['35%', '40%'],
                                                skin: 'large-layer-content',
                                                closeBtn: 0,
                                                content: data.message,
                                                btn: ['确定'],
                                                btn1: function (index, layero) {
                                                    layer.close(index);
                                                    init();
                                                }
                                            });
                                        }
                                },function (e) {
                                    layerMsg("提交失败");
                                }
                            );
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };

                    }
                });
            };
            $scope.goback = function () {
                window.history.back();
            };

            //关闭模态框
            $scope.closeModal = function () {
                $scope.showRelative = false;
            };
            //关联清单
            $scope.showRelative=false;
            $scope.relevanceLists = function () {
                $scope.showRelative=true;
                var queryDto=angular.copy($scope.CheckPageResponseDto);
                var data ={
                    "policyNo":$scope.CheckPageResponseDto.prpLcheckDto.policyNo,
                    "bizNo":queryDto.registNo
                };
                $$finder.post('queryCompareBillByConditions', data).then(
                    function (data){
                        if(data && !data.code){
                            $.each(data,function (index,val) {
                                var listCreateTime = getMyDate(val.listCreateTime);
                                val.listCreateTime = listCreateTime;
                            });
                            $scope.RelevanceList = data;
                            console.log($scope.RelevanceList);
                        }else {
                            layerMsg(data.message)
                        }
                    }
                );
            };
            //接受单选框数据
            $scope.sendCheckFlag = function (info) {
                $scope.checkInfo = info;
            };
            //开始关联清单
            $scope.goRelevanceList = function () {
                $scope.backList=[];
                $scope.dto={};
                var queryDto=angular.copy($scope.CheckPageResponseDto);
                angular.forEach($scope.RelevanceList,function (dto) {
                    console.log(queryDto);
                    if(dto.checkBoxFlag){
                        $scope.backList.push(dto);
                    }
                });
                if($scope.backList.length<=0){
                    layerMsg("请选择后点击确认");
                }else{
                    var keyMap = {
                        "lossListCode": $scope.checkInfo.lossListCode,
                        "bizNo":queryDto.registNo,
                        "checkBoxFlag": $scope.checkInfo.checkBoxFlag,
                        "serialNo":$scope.checkInfo.serialNo
                    };
                    $$finder.post('compareInsurance',keyMap).then(
                        function (data){
                            if (data.code=='0000'){
                                layerMsg("关联成功");
                            }else {
                                layerMsg(data.message);
                            }
                            $scope.showRelative=false;
                        }
                    );
                }

            };
            //时间格式处理
            function getMyDate(str){
                var oDate = new Date(str),
                    oYear = oDate.getFullYear(),
                    oMonth = oDate.getMonth()+1,
                    oDay = oDate.getDate(),
                    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) ;//最后拼接时间
                return oTime;
            };
            //补0操作
            function getzf(num){
                if(parseInt(num) < 10){
                    num = '0'+num;
                }
                return num;
            };
            //定损清单下载
            /**
             * 清单下载
             */
            $scope.downloadList = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.downloadList.modal.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.CheckPageResponseDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto) {
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.download = function (_type) {
                            var url = '';
                            //定损
                            if(_type == 'LossRateList') {
                                var keywords =
                                {
                                    "registNo": queryDto.registNo || '',//报案号
                                    "policyNo":queryDto.policyNo,//保单号
                                };
                                url = 'expBreedAndPlantingLossRateList';
                            }
                            //}else if(_type == 'ClaimList'){
                            //    //理赔
                            //    var keywords =  {
                            //        "listNo":queryDto.listNo || '',//理赔清单号
                            //        "policyNo":queryDto.policyNo || '',//保单号
                            //        "registNo":queryDto.registNo || '',//报案号
                            //        "compensateNo":queryDto.compensateNo || '',//计算书号
                            //        "fCode":queryDto.fCode || '',//农户号
                            //        "modeType":"1"//导出类型（1有数据，0无数据）
                            //    };
                            //    if(_mriskSwitch){
                            //        //种植险理赔清单导出Excel
                            //        url = 'nyxPlantingClaimListExportExcel';
                            //    }else if(!_mriskSwitch){
                            //        //养殖险理赔清单导出Excel
                            //        url = 'nyxBreedClaimListExportExcel';
                            //    }
                            //}
                            $$finder.post(url,keywords).then(
                                function (data) {
                                    if(data && data.url){
                                        $window.open(data.url);
                                    }else if(data && data.shortLink){
                                        $window.open(data.shortLink);
                                    }else{
                                        layerMsg("下载失败");
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                }
                            );
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };
            /**
             * 电子单证
             */
            $scope.showElectronicDocu = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.CheckPageResponseDto);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            $scope.del=function(index){
                $scope.CheckPageResponseDto.prpLpropDtoList.splice(index,1);
            };

            $scope.add=function(index){
                $scope.CheckPageResponseDto.prpLpropDtoList.push({});
            };
            //提交时校验是否有金禾清单或者导入清单
            $scope.submitCheck = function (item) {
                if (item === "sub") {
                    var _dto = {
                        "policyNo": $scope.CheckPageResponseDto.prpLcheckDto.policyNo,
                        "registNo": $scope.CheckPageResponseDto.prpLcheckDto.registNo,
                    }
                    if(_dto.policyNo.substring(1,3)=='31'||_dto.policyNo.substring(1,5)=='3224'||_dto.policyNo.substring(1,5)=='3237'){
                        $$finder.post('queryPlantingLossRateListByLossListCode', _dto).then(
                            function (data) {
                                if(data.length>0){
                                    $scope.submitCheck1(item);
                                }else{
                                    layerMsg("请先导入定损清单!");
                                }
                            }
                        )
                    }else{
                        $$finder.post('queryBreedLossRateListByLossListCode', _dto).then(
                            function (data) {
                                if(data.length>0){
                                    $scope.submitCheck1(item);
                                }else{
                                    layerMsg("请先导入定损清单!");
                                }
                            }
                        )
                    }
                }
                //暂存
                if(item === "save"){
                    $scope.submitCheck1(item);
                }
            }
            //暂存、提交
            $scope.submitCheck1 = function (item) {
                    $scope.flag=false;
                if(!$scope.CheckPageResponseDto.prpLcheckDto.checkDate){
                    layerMsg("查勘日期不能为空！");
                    return false;
                }
                if(!$scope.CheckPageResponseDto.prpLcheckDto.checkSite){
                    layerMsg("查勘地点不能为空！");
                    return false;
                }
                if(!$scope.CheckPageResponseDto.prpLcheckDto.checker1){
                    layerMsg("查勘人1不能为空！");
                    return false;
                }
                if(!$scope.CheckPageResponseDto.prpLcheckDto.damageCode){
                    layerMsg("出险原因不能为空！");
                    return false;
                }


                if(item==="save"){
                    $scope.prpLclaimStatusDto.status=2;
                }else if(item==="sub"){
                    $scope.prpLclaimStatusDto.status=4;
                }
                $$finder.post('saveCheckLoss', $scope.CheckPageResponseDto).then(
                    function (data) {
                        console.log(data)
                        // $scope.Map = data;
                        if(data&&!data.code){
                            if(item==="save"){
                                layerMsg('查勘定损信息暂存成功!<br/>报案号： '+data.registNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCheckQuery');})
                                },{skin:'layer-success'});
                            }else if(item==="sub"){
                                layerMsg('查勘定损信息提交成功!<br/>报案号： '+data.registNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCheckQuery');})
                                },{skin:'layer-success'});
                                $scope.flag=true;
                            }
                        }

                    }
                )
            };

            $scope.giveup = function () {
                var dto = {
                    "swfLogFlowID":$stateParams.flowId,
                    "swfLogLogNo":$stateParams.logNo
                }
                var back=function(){
                    $state.go('UIAgriCheckQuery')
                }
                commonApiServ.giveupTemporary(dto,back);
            }

            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.CheckPageResponseDto.perilCount===null||$scope.CheckPageResponseDto.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                };
                var url = '#/PerilCount?policyNo=' + $scope.CheckPageResponseDto.prpLcheckDto.policyNo ;
                $window.open(url);
            };


            /**
             *   调查报告按钮
             */
          /*  $scope.showSurveyReport = function () {
                  debugger;
                var dataDto ={
                    "policyNo":$scope.CheckPageResponseDto.prpLcheckDto.policyNo,
                    "bizNo":$scope.CheckPageResponseDto.prpLcheckDto.registNo
                };
                $$finder.post('findCheckId', dataDto).then(
                    function (date) {
                        console.log(date)
                        if(date.length>0&&date[0].checkId){
                            $scope.checkId=date[0].checkId
                            var GISIP="http://36.32.160.60:8888"
                            var classCode=$scope.CheckPageResponseDto.prpLcheckDto.policyNo.substring(1,3);
                            if(classCode==31) {
                                var urlv = GISIP + '/CallPage/surveyShow/plantingSurvey?surveyID='+$scope.checkId;//种植险：
                                $window.open(urlv);
                            }else if(classCode==32) {
                                var urlv = GISIP + '/CallPage/surveyShow/cultivationSurvey?surveyID='+$scope.checkId;//养殖险：
                                $window.open(urlv);
                            }
                            } else {
                                  layerMsg("查勘编号为空不能查询调查报告");
                                  return
                                   }
                    }
                )
            };*/
            $scope.showSurveyReport = function (){
                var classCode=$scope.CheckPageResponseDto.prpLcheckDto.registNo.substring(1,3);
                if(!$scope.CheckPageResponseDto.prpLcheckDto.registNo){
                    layerMsg("报案号为空不能查询调查报告");
                    return
                } else{
                    if(classCode==31) {
                        $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.plantingSurveyurl+$scope.CheckPageResponseDto.prpLcheckDto.registNo);
                    }else if(classCode==32) {
                        $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.cultivationSurveyurl+$scope.CheckPageResponseDto.prpLcheckDto.registNo);
                    }
                }
            }

            // 取消
            $scope.cancel = function () {
                $state.go("UIAgriCheckQuery")
            }

        }]);
});