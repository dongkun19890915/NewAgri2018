/**
 * DESC       : 国元农险理赔并案管理---电子单证弹层
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'config',
    'encodeUrl'
], function (app, constants, layer,config) {
    'use strict';
    app.registerController('UIAgriElectronicsCtrl', ['$rootScope', '$scope', '$location', '$$finder','$state','$modal','$modalInstance','items','$filter',
        function ($rootScope, $scope, $location, $$finder, $state,$modal,$modalInstance,items,$filter) {
            //单证查看 Documentary view
            //单证上传 Document uploading
            //索赔须知 Claim
            //删除 delete
            //添加 increase
            var saveKeywords = {};//索赔清单保存入参
            /**
             * 单证查看
             */
            $scope.documentaryView = function () {
                console.log("以下是理赔所需要的参数=============")
                console.log($rootScope.frontEnd)
                $$finder.post("transportXML", {
                    "businessNo": items.registNo, //业务单号
                    "loginUserCode": $rootScope.user.userCode,
                    "loginUserName": $rootScope.user.userName,
                    "loginComCode": $rootScope.user.loginComCode,
                    "loginComName": $rootScope.loginComCName
                }).then(
                        function (data) {
                                console.log("transportXML", data);
                                var responseXML = data;
                                var factoryUrl = $rootScope.frontEnd.claimSunECMUrl + "/SunECM/servlet/RouterServlet";
                                ECM_POST(factoryUrl, {
                                    format: 'xml',
                                    code: 'ECM0002',
                                    xml: responseXML
                                }, 1000, $rootScope.frontEnd.claimSunECMKeys); // 其他参数详见接口文档
                            ;
                        }

                );
            };

            /**
             * 单证上传
             */
            $scope.documentUploading = function () {
                // $scope.uploadDocFlag = true;
                $scope.showDocFlag = false;
                $$finder.post("transportXML", {
                    "businessNo": items.registNo, //业务单号
                    "loginUserCode": $rootScope.user.userCode,
                    "loginUserName": $rootScope.user.userName,
                    "loginComCode": $rootScope.user.loginComCode,
                    "loginComName": $rootScope.loginComCName
                }).then(
                    function (data) {
                            console.log("transportXML", data);
                            var responseXML = data;
                            var factoryUrl = $rootScope.frontEnd.claimSunECMUrl + "/SunECM/servlet/RouterServlet";
                            ECM_POST(factoryUrl, {
                                format: 'xml',
                                code: 'ECM0001',
                                xml: responseXML
                            }, 1000, $rootScope.frontEnd.claimSunECMKeys); // 其他参数详见接口文档

                        ;
                    }

                );
            };

            /**
             * 索赔须知
             */
            $scope.claimNotice = function () {
                window.open(config.backend.ip + config.backend.claimCertifyPrint+'?registNo='+items.registNo);
            };

            /**
             * 删除
             */
            $scope.removeInformation = function (index) {
                $scope.communication.prpLMessageDtoList.splice(index,1);
            };

            /**
             * 添加
             */
            $scope.appendFrom = function () {
                var prpLMessageDto = {
                    serialNo:$scope.communication.prpLMessageDtoList.length==0?1:2,//序号
                    inputDate:new Date(),//时间
                    operatorName:$scope.communication.operatorName,//操作员姓名
                    context:''//内容
                };
                if(angular.isUndefined($scope.communication.prpLMessageDtoList) || $scope.communication.prpLMessageDtoList.length ==0){
                    $scope.communication.prpLMessageDtoList = [];
                }
                if($scope.communication.prpLMessageDtoList.length>1){
                    layerMsg("只能添加一条记录");
                    return;
                }
                $scope.communication.prpLMessageDtoList.push(prpLMessageDto);
            };

            $scope.saveCommunicate = function () {
                var keywords = {
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
                $$finder.post('saveClaimCommunicationInfo',keywords).then(function (data) {
                    if(data && !data.code){
                        layerMsg("理赔联系记录保存成功！");
                    }else if(data.code=='9999'){
                        layerMsg(data.message);
                    }else{
                        layerMsg("理赔联系记录保存失败！");
                    }
                });
            };
            /**
             * 关闭
             */
            $scope.closeModal = function () {
                if($scope.uploadDocFlag == true){
                    $scope.uploadDocFlag =false;
                    $scope.showDocFlag = true;
                }else {
                    $modalInstance.dismiss('cancel');
                }
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

            //信雅达影像生成返参
            function generateXYD() {
                var keywords = {
                    "businessNo":items.registNo,//业务号
                    "businessType":"CL070",//业务号类型（写死）
                    "type":"ImageModify",//类型（上传或查看）ImageQuery，ImageModify，taxRegistImage
                    "userCode":items.userCode
                };
                $$finder.post('transportXML',keywords).then(function (data) {
                    if(data && data.code!='9999'){
                        formSubmitXYD({
                            'format':'xml',
                            'code':data.code,
                            'xml':data.xmlString
                        });
                    }
                });
            }

            /**
             * 表单提交到信雅达
             * @param params 入参
             */
            function formSubmitXYD(params) {
                var form = document.createElement('form');
                form.action = $rootScope.frontEnd.claimSunECMUrl+constants.EXTERNALSYSTEMURL.url;
                form.method = 'post';
                form.target = '_blank';
                form.style.display = 'none';
                $.each(params,function (key,val) {
                    var input = document.createElement('input');
                    input.type = 'hidden';
                    input.name = key;
                    input.value = val;
                    form.appendChild(input);
                });
                document.body.appendChild(form);
                form.submit();
            }
            /**
             * 上传单证
             */
            $scope.uploadDocument = function () {
                if(saveKeywords.imageTypeList.length == 0){
                    layerMsg("请至少选择一个单证类型进行上传！");
                    return
                }
                $$finder.post('saveCertify',saveKeywords).then(function (data) {
                    if(data && data.code=='0000'){
                        generateXYD();
                    }else if(data.code == '9999'){
                        layerMsg(data.message);
                    }else{
                        layerMsg('上传失败');
                    }
                });
            };

            /**
             * 添加单证类型
             * @param imageType 单证类型对象
             */
            $scope.addImageType = function (imageType) {
                if (imageType.choosed){
                    var temp = angular.copy(imageType);
                    delete temp.choosed;
                    saveKeywords.imageTypeList.push(temp);
                }else{
                    $.each(saveKeywords.imageTypeList,function (index,val) {
                        if(val.codeCode == imageType.codeCode){
                            saveKeywords.imageTypeList.splice(index,1);
                            return false;
                        }
                    });
                }
            };

            /**
             * 理赔联系记录 初始化
             */
            function initCommunicate() {
                //根据nodeType判断是哪个任务的
                if(jQuery.isArray(items)==false) {
                    if (items.nodeType == 'check') {
                        //查勘
                        var keywords = {
                            "policyNo": items.prpLcheckDto.policyNo || '',//保单号
                            "registNo": items.registNo || '',//报案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": items.nodeType || '',//节点类型
                            "operatorCode": items.userCode || '',//TODO 操作员代码  queryDto.operatorCode || ''
                            "inputDate": $filter('date')(new Date(), 'yyyy-MM-dd') || ''// 制单日期 items.prpLCompensateDtoExt.inputDate
                        };
                    } else if (items.nodeType == 'compe') {
                        //理算
                        var keywords = {
                            "policyNo": items.policyNo || '',//保单号
                            "registNo": items.registNo || '',//报案号
                            "claimNo": items.claimNo || '',//立案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": items.nodeType || '',//节点类型
                            "operatorCode": items.prpLCompensateDtoExt.operatorCode || '',//操作员代码
                            "inputDate": items.prpLCompensateDtoExt.inputDate || ''//制单日期
                        };
                    } else if (items.nodeType == 'claim') {
                        //立案登记
                        var keywords = {
                            "policyNo": items.policyNo || '',//保单号
                            "registNo": items.prpLClaimDto.registNo || '',//报案号
                            "claimNo": items.claimNo || '',//立案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": items.nodeType || '',//节点类型
                            "operatorCode": items.prpLClaimDto.operatorCode || '',//操作员代码
                            "inputDate": items.prpLClaimDto.inputDate || ''//制单日期
                        };
                    } else if (items.nodeType == 'speci') {
                        //特殊赔案处理
                        var keywords = {
                            "policyNo": items.policyNo || '',//保单号
                            "registNo": items.registNo || '',//报案号
                            "claimNo": items.claimNo || '',//立案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": items.nodeType || '',//节点类型
                            "operatorCode": items.userCode || '',//操作员代码
                            "inputDate": $filter('date')(new Date(), 'yyyy-MM-dd') || ''//制单日期
                        };
                    }else if(items.nodeType == 'check1'){
                        //查勘
                        var keywords = {
                            "policyNo": items.policyNo || '',//保单号
                            "registNo": items.registNo || '',//报案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": 'check' || '',//节点类型
                            "operatorCode": '0537' || '',//TODO 操作员代码  queryDto.operatorCode || ''
                            "inputDate": $filter('date')(new Date(),'yyyy-MM-dd') || ''// 制单日期 items.prpLCompensateDtoExt.inputDate
                        };
                    } else if (items.nodeType == 'claim1') {
                        //立案登记
                        var keywords = {
                            "policyNo": items.policyNo || '',//保单号
                            "registNo": items.registNo || '',//报案号
                            "claimNo": items.claimNo || '',//立案号
                            "riskCode": items.riskCode || '',//险种代码
                            "nodeType": 'claim' || '',//节点类型 todo
                            "operatorCode": items.operatorCode || '',//操作员代码
                            "inputDate": items.inputDate || ''//制单日期
                        };
                    }
                    $$finder.post('queryClaimCommunicationByCondition', keywords).then(function (data) {
                        if (data && !data.code) {
                            $scope.communication = data;
                        } else if (data.code == '9999') {
                            layerMsg(data.message);
                        } else {
                            layerMsg("理赔联系记录查询失败！");
                        }
                    });
                }else{
                    $scope.communication={};
                    $scope.communication.prpLMessageDtoList=[];
                    for(var i=0;i<items.length;i++){
                        if (items[i].nodeType == 'check') {
                            //查勘
                            var keywords = {
                                "policyNo": items[i].prpLcheckDto.policyNo || '',//保单号
                                "registNo": items[i].registNo || '',//报案号
                                "riskCode": items[i].riskCode || '',//险种代码
                                "nodeType": items[i].nodeType || '',//节点类型
                                "operatorCode": items[i].userCode || '',//TODO 操作员代码  queryDto.operatorCode || ''
                                "inputDate": $filter('date')(new Date(), 'yyyy-MM-dd') || ''// 制单日期 items.prpLCompensateDtoExt.inputDate
                            };
                        } else if (items[i].nodeType == 'compe') {
                            //理算
                            var keywords = {
                                "policyNo": items[i].policyNo || '',//保单号
                                "registNo": items[i].registNo || '',//报案号
                                "claimNo": items[i].claimNo || '',//立案号
                                "riskCode": items[i].riskCode || '',//险种代码
                                "nodeType": items[i].nodeType || '',//节点类型
                                "operatorCode": items[i].prpLCompensateDtoExt.operatorCode || '',//操作员代码
                                "inputDate": items[i].prpLCompensateDtoExt.inputDate || ''//制单日期
                            };
                        } else if (items[i].nodeType == 'claim') {
                            //立案登记
                            var keywords = {
                                "policyNo": items[i].prpLClaimDto.policyNo || '',//保单号
                                "registNo": items[i].prpLClaimDto.registNo || '',//报案号
                                "claimNo": items[i].claimNo || '',//立案号
                                "riskCode": items[i].prpLClaimDto.riskCode || '',//险种代码
                                "nodeType": items[i].nodeType || '',//节点类型
                                "operatorCode": items[i].prpLClaimDto.operatorCode || '',//操作员代码
                                "inputDate": items[i].prpLClaimDto.inputDate || ''//制单日期
                            };
                        } else if (items[i].nodeType == 'speci') {
                            //特殊赔案处理
                            var keywords = {
                                "policyNo": items[i].policyNo || '',//保单号
                                "registNo": items[i].registNo || '',//报案号
                                "claimNo":  items[i].claimNo || '',//立案号
                                "riskCode": items[i].riskCode || '',//险种代码
                                "nodeType": items[i].nodeType || '',//节点类型
                                "operatorCode": items.userCode || '',//操作员代码
                                "inputDate": $filter('date')(new Date(), 'yyyy-MM-dd') || ''//制单日期
                            };
                        }
                        $$finder.post('queryClaimCommunicationByCondition', keywords).then(function (data) {
                            if (data && !data.code) {
                                for(var y=0;y<data.prpLMessageDtoList.length;y++){
                                    $scope.communication.prpLMessageDtoList.push(data.prpLMessageDtoList[y]);
                                }
                                console.log($scope.communication.prpLMessageDtoList);
                                console.log(data);
                            } else if (data.code == '9999') {
                                layerMsg(data.message);
                            } else {
                                layerMsg("理赔联系记录查询失败！");
                            }
                        });
                    }

                }
            }

            /**
             * 初始化
             */
            var init = function () {
                $scope.uploadDocFlag = false;
                $scope.showDocFlag = true;
                initCommunicate();
            };
            init();
        }]);
});
