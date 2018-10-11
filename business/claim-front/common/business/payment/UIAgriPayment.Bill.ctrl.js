/**
 * DESC       : 国元农险理赔支付信息管理查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              zhaowenjie    12.9          清单支付
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPaymentBillCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$modal','$state','$window','$stateParams','localStorageService',
        function ($rootScope, $scope, $location, $$finder, regexpConstants,$modal,$state,$window,$stateParams,localStorageService) {
            $scope.queryDto = {}; // 查询条件
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            // 查询条件
            $scope.compensateDto = {
                editType:'SHOW',
                registNo:$stateParams.registDtoList[0].registNo || '',
                compensateNo:$stateParams.registDtoList[0].compensateNo || ''
            };
            //更新总赔付金额
            $rootScope.$on('updateSumAmount',function (event,data) {
                $scope.queryDto.payAmount = data.sumAccount;
                $scope.queryDto.listNo = data.listNo;//支付清单号
            });
            var initPage = function(){
                $$finder.post("compensatePageInit",$scope.compensateDto).then(
                    function (data) {
                        if(data && !data.code){
                            $scope.queryDto.policyNo = data.policyNo;//保单号
                            $scope.queryDto.registNo = data.registNo;//报案号
                            $scope.queryDto.compensateNo = data.compensateNo;//计算书号
                            $scope.queryDto.billNo = data.billNo;//理赔清单号
                            $scope.queryDto.comCode = data.comCode;//登陆人员机构
                            $scope.queryDto.validDate = data.prpLCompensateDtoExt.damageDate;//出险时间
                            $scope.mriskSwitch = data.riskType == 'H'?true:false;//种植险为true 养殖为false
                            var registDtoList = $stateParams.registDtoList;
                            console.log("=============ADD==============");
                            console.log(registDtoList);
                            $scope.prpLregist = registDtoList;
                            if ($scope.queryDto.msgCode == '9999'){
                                layerMsg($scope.queryDto.message);
                            }
                        }else{
                            layerMsg(data.message);
                            $scope.goBack();
                        }
                    });
                $$finder.post("queryNyxClaimPayListByCompensateNo",$scope.compensateDto).then(
                    function(data){
                        if(data && !data.code){
                            var map = data;
                            $scope.listNo = map.listNo;//支付清单号
                        }else{
                            layerMsg(data.message);
                            $scope.goBack();
                        }
                    }
                )
            };
            initPage();

            // 单选框数据
            $scope.radioList = [
                {
                    "code": 1,
                    "name": "个人账号",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "单位账号",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText=[];
            $scope.radioList1 = [
                {
                    "code": 1,
                    "name": "银行卡",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "存折",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 3,
                    "name": "对公账号",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText1=[];
            $scope.radioList2 = [
                {
                    "code": 1,
                    "name": "第三方支付",
                    "checked": false,
                    "class":"detail-reason"
                }, {
                    "code": 2,
                    "name": "传统方式支付",
                    "checked": false,
                    "class":"detail-reason"
                }
            ];
            $scope.radioText2=[];

            /** 提交暂存 */
            $scope.submit = function (nodeStatus) {
                $scope.flag=false;
                var dto = angular.copy($scope.queryDto);
                dto.thirdPayFlag = nodeStatus;//暂存或提交
                dto.billFlag = "1";
                var payPurposeDtoList = [{}];
                payPurposeDtoList[0].context = $scope.newContext;
                dto.payPurposeDtoList = payPurposeDtoList;
                dto.paymentMessageDtoList = angular.copy($scope.prpLregist);
                dto.comCode = $rootScope.user.loginComCode;
                dto.userCode = $rootScope.user.userCode;
                dto.billNo = $scope.queryDto.listNo;
                $$finder.post('savePayMain', dto).then(//paymentList
                    function (data) {
                        console.log("提交查询");
                        if(!data.message){
                            if(nodeStatus=="2"){
                                layerMsg("暂存成功！");
                            }else{
                                layerMsg("提交成功！");
                                $scope.flag=true;
                            }
                            $state.go('UIAgriPaymentQueryInput');
                        }else{
                            layerMsg(data.message);
                            $scope.flag=true;
                        }
                    }
                )
            };
            /**
             * 返回
             */
            $scope.goBack = function () {
                $state.go('UIAgriPaymentQueryInput');
            };

            /**
             * 清单下载
             */
            $scope.downloadList = function () {
                $modal.open({
                    templateUrl:'common/business/payment/UIAgriPayment.downloadList.model.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.queryDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto) {
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.download = function (_type) {
                            var url = '';
                            //定损清单下载
                            if(_type == 'LossRateList'){
                                var keywords =
                                    {
                                        "policyNo":queryDto.policyNo,
                                        "registNo":queryDto.registNo//报案号
                                    };
                                url = 'expBreedAndPlantingLossRateList';
                            }else if(_type == 'ClaimList'){
                                //理赔
                                var keywords =  {
                                    "listNo":queryDto.billNo || '',//理赔清单号
                                    "policyNo":queryDto.policyNo || '',//保单号
                                    "registNo":queryDto.registNo || '',//报案号
                                    "compensateNo":queryDto.compensateNo || '',//计算书号
                                    "fCode":queryDto.fCode || '',//农户号
                                    "modeType":"1"//导出类型（1有数据，0无数据）
                                };
                                if(_mriskSwitch){
                                    //种植险理赔清单导出Excel
                                    url = 'nyxPlantingClaimListExportExcel';
                                }else if(!_mriskSwitch){
                                    //养殖险理赔清单导出Excel
                                    url = 'nyxBreedClaimListExportExcel';
                                }
                            }else if(_type == 'paymentList'){
                                //支付清单下载
                                if(!queryDto.listNo){
                                    layerMsg("没有支付清单信息!");
                                    return false;
                                }
                                var keywords =
                                    {
                                        "listNo":queryDto.listNo//清单号
                                    };
                                url = 'expNyxClaimPayList';
                            }
                            $$finder.post(url,keywords).then(
                                function (data) {
                                    if(data && data.fileId){
                                        $window.open(data.fileId);
                                    }else if(data && data.url){
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
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };
            /**
             * 清单导入
             */
            $scope.importList = function () {
                $modal.open({
                    templateUrl:'common/business/payment/UIAgriPayment.importList.model.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.queryDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                        /** 下载 */
                        $scope.download = function (_type) {
                            var url = '';
                            if(_type == 'template') {
                                //清单空模版下载
                                //$window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                //支付清单下载
                                if(!queryDto.listNo){
                                    //理赔清单组装
                                    var keywords =  {
                                        "listNo":queryDto.listNo || '',//理赔清单号
                                        "policyNo":queryDto.policyNo || '',//保单号
                                        "registNo":queryDto.registNo || '',//报案号
                                        "compensateNo":queryDto.compensateNo || '',//计算书号
                                        "fCode":queryDto.fCode || '',//农户号
                                        "modeType":"1",//导出类型（1有数据，0无数据）
                                        "nodeType":"compe"
                                    };
                                    url = 'expAssembleClaimPayList';
                                }else{
                                    //支付清单
                                    var keywords =
                                        {
                                            "listNo":queryDto.listNo//清单号
                                        };
                                    url = 'expNyxClaimPayList';
                                }
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                            //layerMsg("下载失败，"+data.message);
                                        }else {
                                            $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                            //layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                        //layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'PolicyList'){
                                var keywords =  {
                                    "policyNo":queryDto.policyNo || '',//保单号
                                    "registNo":queryDto.registNo || '',
                                    "validDate":queryDto.validDate || ''//出险时间
                                };
                                url = 'earmarkUnderwritingDownload';//getInsureListInfoFileId
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.fileId){
                                            $window.open(data.fileId);
                                        }else if(data && data.url){
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
                            }else if(_type == 'ClaimList'){
                                //理赔
                                var keywords =  {
                                    "listNo":queryDto.billNo || '',//理赔清单号
                                    "policyNo":queryDto.policyNo || '',//保单号
                                    "registNo":queryDto.registNo || '',//报案号
                                    "compensateNo":queryDto.compensateNo || '',//计算书号
                                    "fCode":queryDto.fCode || '',//农户号
                                    "validDate":queryDto.validDate || '',//出险时间
                                    "modeType":"1"//导出类型（1有数据，0无数据）
                                };
                                if(_mriskSwitch){
                                    //种植险理赔清单导出Excel
                                    url = 'nyxPlantingClaimListExportExcel';
                                }else if(!_mriskSwitch){
                                    //养殖险理赔清单导出Excel
                                    url = 'nyxBreedClaimListExportExcel';
                                }
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
                        var uploader = $scope.uploader = new FileUploader({
                            url:'/fileserver/uploadFile',
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'agri/tempfile'},{bussType:'agriclaim_paymanage_ui'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                //判断导入的理赔清单类型
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "comCode":queryDto.comCode
                                };
                                var url = 'importNyxClaimPayList';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && !data.code && data != 'gateway'){
                                            $rootScope.listNo = data.listNo;
                                            localStorageService.set(constants.CLAIMLIST,data);
                                            $rootScope.$broadcast('updateSumAmount',data);
                                            layerMsg("导入成功");
                                            //关闭模态框
                                            $scope.closeModal();
                                        }else if(data && data.code == '9999'){
                                            layerMsg("导入失败! "+data.message);
                                        }else{
                                            layerMsg("导入失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("导入失败"+e.message);
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
                        //初始化
                        function init () {
                            $scope.queryDto = queryDto;
                            //文件上传实例
                        }
                        init();
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };

           /* /!** 提交暂存 *!/
            $scope.submit = function (nodeStatus) {
                var paySaveDto = {};
                paySaveDto.billFlag = "1";
                paySaveDto.billNo = $scope.billNo;
                $$finder.post('savePayMain', paySaveDto).then(//paymentList
                    function (data) {
                        if(!data.message){
                            if(nodeStatus=="0"){
                                layerMsg("暂存成功！");
                            }else{
                                layerMsg("提交成功！");
                            }
                            $rootScope.back();
                        }else{
                            layerMsg(data.message);
                        }
                    }
                );
            }*/
        }]);

});