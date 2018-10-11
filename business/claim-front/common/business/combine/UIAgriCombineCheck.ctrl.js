/**
 * DESC       : 国元农险理赔并案查勘定损任务修改页面
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
    app.registerController('UIAgriCombineCheckCtrl', ['$rootScope','$timeout', '$scope','$state', '$location', '$$finder','$stateParams','$filter','$modal','$window','regexpConstants','FormFocus',
        function ($rootScope,$timeout, $scope,$state, $location, $$finder, $stateParams,$filter,$modal,$window,regexpConstants,FormFocus) {

            $rootScope.user=$rootScope.user;
           $scope.user=$rootScope.user;
            $scope.regData = regexpConstants; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            $scope.regData.positiveNumber=regexpConstants.positiveNumber;
            // var initData = JSON.parse($stateParams.data);
            var ComCheckDetailQueryDto=$stateParams.CombineCheck;
            ComCheckDetailQueryDto=JSON.parse(ComCheckDetailQueryDto);
            $("html,body").css({overflow:"auto"});//出现滚动条
            $scope.ResponseDto={};
            $scope.regData = regexpConstants;
            $scope.codeListData = {DamageCode:[]};
            $scope.seeFlag=false;
            $scope.isAquaculture=true;
            var listNo ='';
            angular.forEach(ComCheckDetailQueryDto,function(item){
                $scope.editType=item.editType;
            })
            if($scope.editType==='SHOW'){
                $scope.seeFlag=true;
            }
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
                        "riskCode":ComCheckDetailQueryDto[0].riskCode
                    },{
                        "codeType": "Unit",
                        "riskCode": ComCheckDetailQueryDto[0].riskCode
                    }
                ]
            };
            $$finder.post("baseCode", _data).then(function (data) {
                angular.forEach(data.data,function(item,index) {
                    console.log($scope.codeListData);
                    $scope.codeListData[item.codeType] = item.resultobj.action_result;
                });
            },function (error) {

            });
            //电子单证
            $scope.showElectronicDocu = function () {
                $scope.ResponseDto.nodeType="check1";
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.ResponseDto);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };
            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.ResponseDto.policyNo;
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
            /**
             * 理赔沟通
             */
            $scope.openCommunicationLayer = function () {
                var policyNo=$scope.ResponseDto.policyNo;
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        __CheckPageResponseDto:function () {
                            return angular.copy($scope.ResponseDto)
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
                                "nodeType": "check",//TODO 节点类型  __CheckPageResponseDto.nodeType || ''
                                "operatorCode": $scope.user.userCode,//TODO 操作员代码  __CheckPageResponseDto.operatorCode || ''
                                "operatorName": $scope.user.userName,//TODO 操作员代码  __CheckPageResponseDto.operatorName || ''
                                "inputDate":$filter("date")(new Date(),"yyyy-MM-dd") //TODO 制单日期      __CheckPageResponseDto.inputDate || ''
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
                                        layerMsg(data.message);
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
            var num=0;
            //初始化调用服务
            $$finder.post('comCheckPageInit',ComCheckDetailQueryDto).then(
                function (data) {
                    console.log(data);
                    if(data&&!data.code){
                        angular.forEach(data,function(result,index){
                            data[index]=result;
                            // 日期格式转换
                            result.prpLcheckDtoExt.prpLCheckDto.damageStartDate = $filter("date")(result.prpLcheckDtoExt.prpLCheckDto.damageStartDate, "yyyy-MM-dd");
                            result.prpLcheckDtoExt.prpLCheckDto.damageStartDate = $filter("date")(result.prpLcheckDtoExt.prpLCheckDto.damageStartDate, "yyyy-MM-dd");
                            result.prpLcheckDtoExt.prpLCheckDto.checkDate = $filter("date")(result.prpLcheckDtoExt.prpLCheckDto.checkDate, "yyyy-MM-dd");
                            result.prpLcheckDtoExt.prpLCheckDto.unitType = result.prpLcheckDtoExt.prpLCheckDto.unitType;
                            var curDate=new Date();
                            if(result.prpLverifyLossDto.underWriteEndDate==null){
                                result.prpLverifyLossDto.underWriteEndDate = $filter("date")(curDate, "yyyy-MM-dd");
                            }else{
                                result.prpLverifyLossDto.underWriteEndDate = $filter("date")(result.prpLverifyLossDto.underWriteEndDate, "yyyy-MM-dd");
                            }

                        })
                        num=data.length;
                        $scope.ResponseNewDto = data;
                        $scope.ResponseDto=$scope.ResponseNewDto[0];
                        $scope.testResponseNewDtolistdata=$scope.ResponseNewDto[0];
                        console.log($scope.ResponseNewDto[0].registNo);
                    }else if(data.code == '9999'){
                        layerMsg(data.message,function () {
                            $state.go('UIAgriCombineCheckQuery');
                        });
                    }else{
                        layerMsg(data.message || "初始化失败！",function () {
                            $state.go('UIAgriCombineCheckQuery');
                        });
                    }
                }
            )
            //下拉框选择报案号，显示不同的报案信息
            $scope.showRegist=function(data){
                $scope.ResponseDto=data;

            }
            //更新出险户次
            $rootScope.$on('updateDamageInsured',function (event,data) {
                $scope.ResponseDto.prpLverifyLossDto.damageInsured = data;
            });
            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.ResponseDto.intRecentCount===null||$scope.ResponseDto.intRecentCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                }
                var url = '#/PerilCount?policyNo=' + $scope.ResponseDto.policyNo;
                $window.open(url);
            };
            //提交时校验是否有金禾清单或者导入清单
            var flag=0;
            $scope.submitCheck = function (item) {
                if (item === "sub") {
                    angular.forEach($scope.ResponseNewDto,function(result,index){
                        var _dto = {
                            "policyNo": result.policyNo,
                            "registNo": result.registNo,
                        }
                        $$finder.post('queryBreedLossRateListByLossListCode', _dto).then(
                            function (data) {
                                if((data.length>0)){
                                    flag++;
                                    if(flag===num){
                                        $scope.saveComCheck(item);
                                    }
                                }else{
                                    layerMsg("请先导入报案号:"+result.registNo+"定损清单!");
                                    return;
                                }

                            }
                        )
                    });
                }
                if(item==='save'){
                    $scope.saveComCheck(item);
                }
            }

            /**
             * saveComCheck 并案查勘定损提交、暂存的方法
             *
             * @param btnType 操作按钮类型 sub 为提交，save 为暂存
             */
            $scope.saveComCheck=function(btnType){
                $scope.flag=false;
                // if ($scope.registForm.$valid) {}
                var layerMges=""
                //  传给后台暂存或提交的标志 , 4是所有提交，种植险暂存3,养殖险暂存2
                if(btnType === 'sub'){
                    angular.forEach($scope.ResponseNewDto,function(result,index){
                        // $.each(ComCheckDetailQueryDto,function(item,index){
                        //     if(item.registNo==result.registNo){
                        //         result.swfLogFlowID=item.swfLogFlowID;
                        //         result.swfLogLogNo=item.swfLogLogNo;
                        //     }
                        // });
                        result.prpLverifyLossDto.underWriteEndDate = $filter("date")(result.prpLverifyLossDto.underWriteEndDate, "yyyy-MM-dd");
                        result.prpLclaimStatusDto={};
                        result.prpLclaimStatusDto.status=4;
                        if(!result.prpLcheckDtoExt.prpLCheckDto.checkDate){
                            layerMges="查勘日期";
                            layerMsg("报案号:"+result.registNo+"的查勘日期不能为空！");
                            return false;
                        }
                        if(!result.prpLcheckDtoExt.prpLCheckDto.handleUnit){
                            layerMges="查勘处理单";
                            layerMsg("报案号:"+result.registNo+"查勘处理单位不能为空！");
                            return false;
                        }
                        if(!result.prpLcheckDtoExt.prpLCheckDto.checkSite){
                            layerMges="查勘地点";
                            layerMsg("报案号:"+result.registNo+"查勘地点不能为空！");
                            return false;
                        }
                        if(!result.prpLcheckDtoExt.prpLCheckDto.checker1){
                            layerMges="查勘人1";
                            layerMsg("报案号:"+result.registNo+"查勘人1不能为空！");
                            return false;
                        }
                        if(!result.prpLcheckDtoExt.prpLCheckDto.damageName){
                            layerMges="出险原因";
                            layerMsg("报案号:"+result.registNo+"出险原因不能为空！");
                            return false;
                        }
                        /*if(!result.prpLcheckDtoExt.prpLCheckDto.unitType){
                            layerMges="出险原因";
                            layerMsg("报案号:"+result.registNo+"的计量单位不能为空！");
                            return false;
                        }*/
                        /*if(!$scope.verifyPass){
                            layerMsg('页面有错误',function () {
                                $('#UIAgriCombineCheck_section').find('.ng-invalid')[0].focus();
                            });
                            return false;
                        }*/
                        if(!FormFocus.requiredVerify('#UIAgriCombineCheck_section')){
                            return false;
                        }


                    });
                    if(layerMges!=""){
                        return false;
                    }
                    $scope.flag=true;
                }else if(btnType === 'save'){
                    angular.forEach($scope.ResponseNewDto,function(result,index){
                        // $.each(ComCheckDetailQueryDto,function(item,index){
                        //     if(item.registNo==result.registNo){
                        //         result.swfLogFlowID=item.swfLogFlowID;
                        //         result.swfLogLogNo=item.swfLogLogNo;
                        //     }
                        // })
                        result.prpLclaimStatusDto={};
                        result.prpLclaimStatusDto.status=2;
                    });
                }
                $$finder.post('saveSubmitComCheck',$scope.ResponseNewDto).then(
                    function (data) {
                        console.log(data);
                        // layer(data.message);
                        $scope.Map = data ;
                        if(data&&data.code=='0000'){
                            if(btnType==="save"){
                                // layerMsg(data.message);
                                layerMsg(data.message+'<br/>并案号：'+data.combineNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCombineCheckQuery');})
                                },{skin:'layer-success'});
                            }else if(btnType==="sub"){
                                // layerMsg(data.message);
                                layerMsg(data.message+'<br/>并案号：'+data.combineNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCombineCheckQuery');})
                                },{skin:'layer-success'});
                            }
                        }else if(data.code=='9999'){
                            layerMsg('并案查勘定损失败！');
                        }
                    }
                )
            };
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
                            return angular.copy($scope.ResponseDto);
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
                                    "riskCode":queryDto.riskCode,
                                    "policyNo":queryDto.policyNo,
                                    "damageStartDate":queryDto.prpLRegistDto.damageStartDate,
                                    "damageStartHour":queryDto.prpLRegistDto.damageStartHour,
                                    "userCode":$rootScope.user.userCode,
                                    "userName":$rootScope.user.userName,
                                    "nodeOrigin":'check',
                                    "registNo": queryDto.registNo
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
                                    "policyNo":queryDto.policyNo,
                                    "registNo":queryDto.registNo
                                };
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
                                var keywords =
                                {
                                    "registNo":queryDto.registNo,
                                    "policyNo":queryDto.policyNo,
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
                    "registNo":$scope.ResponseDto.registNo,
                    "policyNo":$scope.ResponseDto.policyNo,
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
                            layerMsg("不存在GIS系统推送的定损数据，请稍后在进行下载！")
                        }
                    },
                    function (e) {
                        layerMsg("下载失败");
                    }
                );
            }
            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
            // 取消
            $scope.cancel = function () {
                $state.go("UIAgriCombineCheckQuery")
            };
        }]);
});