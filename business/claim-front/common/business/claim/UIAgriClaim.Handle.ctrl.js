/**
 * DESC       : 国元农险理赔立案任务处理---种植险/养殖险
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
    app.registerController('UIAgriClaimHandleCtrl', ['$rootScope', '$filter','$scope', '$location', '$$finder', 'regexpConstants', '$state', '$stateParams','$window','$modal','$timeout','FormFocus','commonApiServ',
        function ($rootScope, $filter, $scope, $location, $$finder, regexpConstants, $state, $stateParams, $window,$modal,$timeout,FormFocus,commonApiServ) {
            $scope.codeListData= {};
            $scope.regData = regexpConstants;
            $scope.checkInfo = {};
            $scope.dangerUnit = {};
            var dangerous = 0;
            var kindCode = "";
            var listNo='';
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
                        "riskCode": $stateParams.riskCode
                    }
                ]
            };
            $$finder.post("baseCode", _data).then(function (data) {
                angular.forEach(data.data, function (item, index) {
                    $scope.codeListData[item.codeType] = item.resultobj.action_result;
                })
            }, function (error) {

            });
            $scope.claimQueryDto = {
                claimNo: $stateParams.claimNo,
                editType: $stateParams.editType,
                registNo: $stateParams.registNo,
                flowId: $stateParams.flowId,
                logNo:$stateParams.logNo
                // editType:"ADD",
                // registNo:"431013411002012000054"
            }; // 查询条件
            //初始化出险方式和溃塘程度
            $scope.riskCode=$scope.claimQueryDto.registNo.substring(1,5);
            $scope.updateDamageDegree=function(data){
                if(data==='kt'){
                $scope.damageDegreeFlag='kt';
                }else if(data==='mt'){
                    $scope.damageDegreeFlag='mt';
                }else if(data==='ft'){
                    $scope.damageDegreeFlag='ft';
                }

            }
            $$finder.post('claimPageInit', $scope.claimQueryDto).then(
                function (data) {
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $scope.dtoMessage = data.message || "";
                    if($scope.dtoMessage!=""){
                        layerMsg(data.message);
                    }
                    $scope.mriskSwitch = data.riskType=='H'||data.riskCode=='3224'||data.riskCode=='3237'?true:false;// 种植险为true 养殖为false
                    $scope.claim = data;
                    $scope.riskType=data.riskType;
                    $rootScope.claimDto=data;
                    $scope.registNo=data.prpLClaimDto.registNo;
                    $scope.claim.prpLClaimDto.damageStartDate = $filter("date")(data.prpLClaimDto.damageStartDate, "yyyy-MM-dd");
                    $scope.claim.prpLClaimDto.claimDate = $filter("date")(data.prpLClaimDto.claimDate, "yyyy-MM-dd");
                    // 估损金额列表 被保险人
                    $scope.addLossList();
                    $$finder.post("queryVirturlItemByPolicyNo",
                        {
                            flag:"1",
                            policyNo:data.policyNo,
                            riskCode:data.riskCode
                        }
                    ).then(function (data) {
                        $scope.codeListData.familyNameList =data;
                    });
                    // 查询险别
                    $$finder.post("queryVirturlItemByPolicyNo",
                        {
                            flag:"2",
                            policyNo:data.policyNo,
                            riskCode:data.riskCode
                        }
                    ).then(function (data) {
                        kindCode = data[0].kindCode;
                        $scope.codeListData.kindCodeList =data;
                    }, function (error) {

                    });
                    //查询条款和标的
                    $$finder.post("queryPrpLRegistAndPrpCmainByConditions",
                        {
                            policyNo:data.policyNo,
                            registNo:data.prpLClaimDto.registNo
                        }
                    ).then(function (dat) {
                        //查询生长期
                        $$finder.post("queryPrpLGrowthByConditions",
                            {
                                riskCode:data.riskCode,
                                clauseCode:dat.versionNo,
                                itemCode:dat.lossName
                            }
                        ).then(function (dat1) {
                            console.log("以下是生长期的查询结果")
                            console.log(dat1)
                            $scope.codeListData.GrowthList =dat1;
                        }, function (error) {

                        });

                    }, function (error) {

                    });
                    $scope.editType = $stateParams.editType;
                    $scope.isAquaculture = false;
                    if ($scope.riskType === "H"||data.riskCode==='3224'||data.riskCode==='3237') { // 种植险
                        $scope.isAquaculture = false;
                    } else if ($scope.riskType === "I"&&data.riskCode!='3224'&&data.riskCode!='3237') { // 养植险
                        $scope.isAquaculture = true;
                    }
                }
            );
            ////发起调查
            //$scope.investigate=function(){
            //    var dto = {
            //        "registNo":$scope.claim.prpLClaimDto.registNo,
            //        "flowId":$scope.claim.prpLClaimDto.flowId,
            //        "logNo":$scope.claim.prpLClaimDto.logNo,
            //        "policyNo":$scope.claim.policyNo
            //
            //    };
            //    $$finder.post("submitInvestigation",dto).then(
            //        function (data) {
            //            if(data && data.code =='0000'){
            //                layerMsg(data.message);
            //            }else if(data && data.code == '9999'){
            //                layerMsg("发起调查失败! ");
            //            }else{
            //                layerMsg(data.message);
            //            }
            //        }
            //    );
            //}
            //理赔沟通
            $scope.openCommunicationLayer = function () {
                var registNo=$scope.registNo;
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        claim:function () {
                            return angular.copy($scope.claim)
                        }
                    },
                    controller:function ($scope,$modalInstance,claim) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo": claim.policyNo || '',//保单号
                                "registNo": registNo || '',//报案号
                                "claimNo": claim.claimNo || '',//立案号
                                "riskCode": claim.riskCode || '',//险种代码
                                "nodeType": claim.nodeType || '',//TODO 节点类型
                                "operatorCode": $scope.user.userCode,//TODO 操作员代码  claim.operatorCode || ''
                                "operatorName": $scope.user.userName,//TODO 操作员代码  claim.operatorName || ''
                                "inputDate":"2017-10-27" //TODO 制单日期      claim.inputDate || ''
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
            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.claim.policyNo;
                $$finder.post('relatePolicyInfo', {policyNo:policyNo}).then(
                    function (data) {
                        console.log(data);
                        $scope.relateInfoDto = data;
                        angular.forEach($scope.relateInfoDto.prpLregistDtoList,function(result){
                            result.damageStartDate= $filter("date")(result.damageStartDate, "yyyy-MM-dd");
                        })


                    }
                )
            }
            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                debugger;
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }
            // 电子单证弹层
            $scope.openEleDocumentLayer = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.claim);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            //更新导入返回数量等信息
            $rootScope.$on('updateSumAmount',function (event,data) {
                //$scope.claim.prpLClaimDto.lossesNumber = data.lossEsnumBer; //赔付数量
                //$scope.claim.prpLClaimDto.damageInsured = data.damageInsured; //出险户次
                //$scope.claim.prpLClaimDto.noProductionArea = data.noProductionArea;//绝产面积
                $scope.claim.prpLClaimDto.sumClaim=data.sumAmount;
                $scope.claim.prpLClaimDto.lossQuantity=parseFloat((data.lossEsnumBer).toFixed(2));
            });
            $scope.openInforListLayer = function () {
                $scope.$broadcast("SendInforListLayerSwitch");
            };
            //提交
            $scope.saveClaim = function () {
                   $scope.flag=false;
                if(!FormFocus.requiredVerify('#claim_handle')){
                    layerMsg("请输入必填项!");
                    return;
                }
                if(!$scope. claim.prpLClaimDto.damageCode){
                    layerMsg("请选择出险原因!");
                    return ;
                }
                if($scope.riskCode=='3224'){
                    if(!$scope.claim.prpLClaimDto.damageWay){
                        layerMsg("请选择出险方式!");
                        return;
                    }
                    if($scope.claim.prpLClaimDto.damageWay==='kt'&&!$scope.claim.prpLClaimDto.damageDegree){
                        layerMsg("请选择溃塘程度!");
                        return;
                    }
                    if($scope.claim.prpLClaimDto.damageWay==='mt'&&!$scope.claim.prpLClaimDto.damageDegree){
                        layerMsg("请选择漫塘时间!");
                        return;
                    }
                }
                if(!$scope.gatherSumFalg){
                    layerMsg("请先点击险别估损金额信息'汇总'按钮");
                    return false;
                }
                if(dangerous==0){
                    layerMsg("请先点击危险单位信息'生成危险单位'按钮");
                    return false;
                }
                $scope.claim.prpLclaimStatusDto.status = 4;
                $scope.claim.flowId = $stateParams.flowId;
                $scope.claim.logNo = $stateParams.logNo;
                var dto = angular.copy($scope.claim);
                //if($scope.dtoMessage) {
                //    //layerMsg(dto.message);
                //    $scope.dtoMessage = "";
                //    return false;
                //}
                $$finder.post('saveClaim', dto).then(
                    function (data) {
                        if (typeof(data) != 'undefined' && typeof(data.claimNo) != 'undefined' && data.claimNo != null && data.claimNo != '') {
                            var dto = {
                                "registNo":$scope.claim.registNo,
                                "listNo":listNo,
                                "claimNo":data.claimNo
                            };
                            if($scope.claim.riskType=="H"||$scope.riskCode=='3224'||$scope.riskCode=='3237'){
                                $$finder.post('saveclaimNo',dto).then(
                                    function (data) {
                                    }
                                );
                            }else{
                                $$finder.post('saveBreedclaimNo',dto).then(
                                    function (data) {
                                    }
                                );
                            }
                            $scope.flag=true;
                            $scope.claim.claimNo = data.claimNo;
                            var claim = angular.copy($scope.claim);
                            console.log(claim);
                            $$finder.post('savePrplClaimLoss',claim).then(
                                layerMsg('立案提交成功，立案号为： '+data.claimNo, function(){
                                    $timeout(function () {  $state.go("UIAgriClaimQuery")});
                                })
                            );
                        } else {
                            layer.alert('立案提交失败！');
                        }
                        angular.forEach( $scope.claim.prpLclaimLossDtoList,function(dto){
                            console.log("==============");
                            console.log(data.claimNo);
                            dto.claimNo = data.claimNo;
                        });
                    }
                )
            };
            //关闭模态框
            $scope.closeModal = function () {
                $scope.showRelative = false;
            };
            //关联清单
            $scope.showRelative=false;
            $scope.relevanceLists = function () {
                //查勘当前环节是否导入理赔清单
                var dto = {
                    "registNo":$scope.claim.registNo,
                    "nodeType":$scope.claim.nodeType
                };
                $$finder.post('queryAllByRegistNoAndNodeType',dto).then(
                    function (data) {
                        $scope.nyx=data;
                    }
                );
                $scope.showRelative=true;
                var queryDto=angular.copy($scope.codeListData);
                var data ={
                    "policyNo":$stateParams.policyNo,
                    "bizNo":$stateParams.registNo
                };
                $$finder.post('queryCompareBillByConditions', data).then(
                    function (data){
                        if(data && !data.code){
                            $.each(data,function (index,val) {
                                var listCreateTime = getMyDate(val.listCreateTime);
                                val.listCreateTime = listCreateTime;
                            });
                            $scope.RelevanceList = data;
                            var flag=0;
                            angular.forEach($scope.RelevanceList,function (dto) {
                                if(dto.checkBoxFlag == '1'){
                                    $scope.sendCheckFlag(dto);
                                }else if(flag<=0){
                                    dto.checkBoxFlag='1';
                                    $scope.sendCheckFlag(dto);
                                }
                                flag++;
                            });
                            console.log($scope.RelevanceList);
                        }else {
                            layerMsg(data.message)
                        }
                    }
                );
            };

            /**
             * 理赔清单导入
             */
            var listNo=null;
            $scope.importList = function () {
                var url;
                if (!$scope.claim.prpLClaimDto.growthPeriod && $scope.claim.riskType == 'H'&&$scope.claim.riskCode!='3149') {
                    layerMsg("请选择生长期。");
                    return;
                }
                if($scope.riskCode=='3224'&&!($scope.claim.prpLClaimDto.damageWay)){
                    layerMsg("请选择出险方式");
                    return;
                }
                if($scope.riskCode=='3224'&&!($scope.claim.prpLClaimDto.damageDegree)){
                    if($scope.claim.prpLClaimDto.damageWay=='kt'){
                        layerMsg("请选择溃塘程度");
                        return;
                    }
                    if($scope.claim.prpLClaimDto.damageWay=='mt'){
                        layerMsg("请选择漫塘时间");
                        return;
                    }
                }
                if ($scope.claim.riskType == 'H'||$scope.riskCode=='3224'||$scope.riskCode=='3237') {
                    var keywords =
                    {
                        "registNo": $stateParams.registNo,
                        "policyNo": $stateParams.policyNo

                        // "registNo":"3310103"//报案号
                    };
                    url = 'plantingdownloadlList';
                } else {
                    var keywords =
                    {
                        "registNo": $stateParams.registNo,
                        "policyNo": $stateParams.policyNo

                        // "registNo":"3310103"//报案号
                    };
                    url = 'nyxdownloadlList';
                }
                $scope.dto = $scope.dto ||{}
                $$finder.post(url, keywords).then(
                    function (data) {
                        if (data.length <1) {
                            $scope.dto = 1;
                            layer.alert('请先关联清单！');
                        }
                        if ($scope.dto != 1&& $scope.dto!=undefined) {
                            $modal.open({
                                templateUrl: 'common/business/compenstate/modal/UIAgriCompensate.importList.modal.html',
                                resolve: {
                                    _mriskSwitch: function () {
                                        //险种类型
                                        return $scope.mriskSwitch
                                    },
                                    queryDto: function () {
                                        //页面初始化后的对象
                                        return angular.copy($scope.claim);
                                    }
                                },
                                controller: function ($scope, $modalInstance, _mriskSwitch, queryDto, FileUploader) {
                                    var _needTime = '';
                                    if (queryDto.riskCode == '3149'){
                                        _needTime = "00";
                                    }else {
                                        _needTime =  queryDto.prpLClaimDto.growthPeriod;
                                    }
                                    var _nodeType = queryDto.nodeType;
                                    var uploader = $scope.uploader = new FileUploader({
                                        url: '/fileserver/uploadFile',
                                        formData: [{userCode: $rootScope.user.userCode}, {systemId: 'tempfile'}, {bussType: 'agriclaim_compensatemanage_ui'}],
                                        queueLimit: 1,
                                        autoUpload: false,
                                        removeAfterUpload: false//上传后删除文件
                                    });
                                    uploader.onSuccessItem = function (item, response, status, headers) {
                                        if (response.resultCode == '0000') {
                                            //根据导入成功后的fileid调用保存
                                            //判断导入的理赔清单类型
                                            var keywords = {
                                                "fileId": response.resultObj.fileId,
                                                "comCode": queryDto.prpLClaimDto.comCode,
                                                "growthPeriod": _needTime,//生长期
                                                "nodeType": _nodeType, // 流程节点 用于区分清单数据是什么环节导入。
                                                "damageWay":queryDto.prpLClaimDto.damageWay,//出险方式 淡水鱼
                                                "damageDegree":queryDto.prpLClaimDto.damageDegree,//溃塘程度
                                            };
                                            if (_mriskSwitch) {
                                                //    种植险
                                                var url = 'importPlantingClaimListExcel';
                                            } else if (!_mriskSwitch) {
                                                //    养殖险
                                                var url = 'importBreedClaimListExcel';
                                            }
                                            $$finder.post(url, keywords).then(
                                                function (data) {
                                                    if (data && !data.code && data != 'gateway') {
                                                        var rData = {};
                                                        rData.lossEsnumBer = data.lossEsnumBer; //赔付数量
                                                        rData.damageInsured = data.damageInsured; //出险户次
                                                        rData.noProductionArea = data.noProductionArea;//绝产面积
                                                        rData.sumAmount = data.sumAmount; //赔偿金额
                                                        $rootScope.$broadcast('updateSumAmount', rData);
                                                        listNo=data.listNo;
                                                        layerMsg("导入成功");
                                                        //关闭模态框
                                                        $scope.closeModal();
                                                    } else if (data && data.code == '9999') {
                                                        layerMsg("导入失败! " + data.message);
                                                    } else {
                                                        layerMsg("导入失败");
                                                    }
                                                },
                                                function (e) {
                                                    layerMsg("导入失败");
                                                }
                                            );
                                        }
                                        if (response.code == '9999') {
                                            layerMsg("导入失败" + response.message);
                                        }
                                    };
                                    $scope.uploader.onErrorItem = function (item, response, status, headers) {
                                        layerMsg("导入失败");
                                    };
                                    //初始化
                                    function init() {
                                        $scope.queryDto = queryDto;
                                        //文件上传实例

                                    }

                                    init();

                                    /**
                                     * 更新生长期
                                     * @param needTime
                                     */
                                    $scope.updateNeedTime = function (needTime) {
                                        _needTime = needTime;
                                    };

                                    /**
                                     * 下载方法
                                     * @param _type 类型
                                     */
                                    $scope.download = function (_type) {
                                        var url = '';
                                        //清单下载
                                        if (_type == 'LossRateList') {
                                            //var keywords = {
                                            //    "listNo": queryDto.listNo || '',//理赔清单号
                                            //    "policyNo": queryDto.policyNo || '',//保单号
                                            //    "registNo": queryDto.registNo || '',//报案号
                                            //    "compensateNo": queryDto.compensateNo || '',//计算书号
                                            //    "fCode": queryDto.fCode || '',//农户号
                                            //    "modeType": "1",//导出类型（1有数据，0无数据）
                                            //    "type":"list"
                                            //};
                                            //if (_mriskSwitch) {
                                            //    //种植险理赔清单导出Excel
                                            //    url = 'nyxPlantingClaimListExportExcel';
                                            //} else if (!_mriskSwitch) {
                                            //    //养殖险理赔清单导出Excel
                                            //    url = 'nyxBreedClaimListExportExcel';
                                            //}
                                            //$$finder.post(url,keywords).then(
                                            //    function (data) {
                                            //        if(data && data.url){
                                            //            $window.open(data.url);
                                            //        }else if(data && data.shortLink){
                                            //            $window.open(data.shortLink);
                                            //        }else if(data.code == '9999'){
                                            //            layerMsg("下载失败，"+data.message);
                                            //        }else {
                                            //            layerMsg("下载失败");
                                            //        }
                                            //    },
                                            //    function (e) {
                                            //        layerMsg("下载失败");
                                            //    }
                                            //);
                                        } else if (_type == 'ClaimList') {
                                            //理赔清单下载
                                            var keywords = {
                                                "listNo": queryDto.listNo || '',//理赔清单号
                                                "policyNo": queryDto.policyNo || '',//保单号
                                                "registNo": queryDto.registNo || '',//报案号
                                                //"compensateNo": queryDto.compensateNo || '',//计算书号
                                                "fCode": queryDto.fCode || '',//农户号
                                                "modeType": "1",//导出类型（1有数据，0无数据）
                                                "nodeType":queryDto.nodeType,
                                                "type":"import",
                                            };
                                            if (_mriskSwitch) {
                                                //种植险理赔清单导出Excel
                                                url = 'nyxPlantingClaimListExportExcel';
                                            } else if (!_mriskSwitch) {
                                                //养殖险理赔清单导出Excel
                                                url = 'nyxBreedClaimListExportExcel';
                                            }
                                        } else if (_type == 'policy') {
                                            //关联清单下载
                                            var keywords =
                                            {
                                                "registNo": $stateParams.registNo,
                                                "policyNo": $stateParams.policyNo

                                                // "registNo":"3310103"//报案号
                                            };
                                            url = 'downloadist';
                                        }
                                        $$finder.post(url, keywords).then(
                                            function (data) {
                                                if (data && data.url) {
                                                    $window.open(data.url);
                                                } else if (data && data.shortLink) {
                                                    $window.open(data.shortLink);
                                                } else if (data.code == '9999') {
                                                    layerMsg("下载失败，" + data.message);
                                                } else {
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
                        }
                    }
                )
            };
            //接受单选框数据
            $scope.sendCheckFlag = function (info) {
                $scope.checkInfo = info;
            };
            //开始关联清单
            $scope.goRelevanceList = function () {
                $scope.backList=[];
                $scope.dto={};
                var queryDto=angular.copy($scope.codeListData);
                angular.forEach($scope.RelevanceList,function (dto) {
                    console.log(queryDto);
                    if(dto.checkBoxFlag){
                        $scope.backList.push(dto);
                    }
                });
                if($scope.backList.length<=0){
                    layerMsg("请选择后再提交");
                }else if ( $scope.nyx.length > 0){
                    layerMsg("已导入理赔清单，不可修改！")
                }else{
                    var keyMap = {
                        "lossListCode":$scope.checkInfo.lossListCode,
                        "bizNo":$scope.claimQueryDto.registNo,
                        "checkBoxFlag":$scope.checkInfo.checkBoxFlag,
                        "serialNo":$scope.checkInfo.serialNo
                    };
                    $$finder.post('compareInsurance',keyMap).then(
                        function (data) {
                            if (data.code == '9999'){
                                layerMsg("关联失败，请重试！")
                            }else {
                                layerMsg("关联成功")
                                $scope.showRelative=false
                               if( $scope.checkInfo.affectedArea!=null ||  $scope.checkInfo.deathQuantity!=null ||  $scope.checkInfo.disasterArea!=null ||  $scope.checkInfo.killQuantity!=null ||  $scope.checkInfo.noProductionArea!=null){
                                   $scope.claim.prpLClaimDto.killQuantity=$scope.checkInfo.killQuantity;
                                   $scope.claim.prpLClaimDto.deathQuantity=$scope.checkInfo.deathQuantity;
                                   $scope.claim.prpLClaimDto.noProductionArea=$scope.checkInfo.noProductionArea;
                                   $scope.claim.prpLClaimDto.affectedArea=$scope.checkInfo.affectedArea;
                                   $scope.claim.prpLClaimDto.disasterArea=$scope.checkInfo.disasterArea;
                               }
                            }
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
            ////定损清单下载
            ///**
            // * 清单下载
            // */
            //$scope.downloadList = function () {
            //    $modal.open({
            //        templateUrl:'common/business/compenstate/modal/UIAgriCompensate.downloadList.modal.html',
            //        resolve:{
            //            _mriskSwitch:function () {
            //                //险种类型
            //                return $scope.mriskSwitch
            //            },
            //            queryDto:function () {
            //                //页面初始化后的对象
            //                return angular.copy($scope.claim);
            //            }
            //        },
            //        controller:function ($scope,$modalInstance,_mriskSwitch,queryDto) {
            //            /**
            //             * 下载方法
            //             * @param _type 类型
            //             */
            //            $scope.download = function (_type) {
            //                var url = '';
            //                //定损
            //                if(_type == 'LossRateList') {
            //                    var keywords =
            //                    {
            //                        "registNo": $stateParams.registNo || ''//报案号
            //                        // "registNo":"3310103"//报案号
            //                    };
            //                    url = 'expBreedAndPlantingLossRateList';
            //
            //                }else if(_type == 'ClaimList'){
            //                    //理赔
            //                    var keywords =  {
            //                        "listNo":queryDto.listNo || '',//理赔清单号
            //                        "policyNo":queryDto.policyNo || '',//保单号
            //                        "registNo":queryDto.registNo || '',//报案号
            //                        "compensateNo":queryDto.compensateNo || '',//计算书号
            //                        "fCode":queryDto.fCode || '',//农户号
            //                        "modeType":"1"//导出类型（1有数据，0无数据）
            //                    };
            //                    if(_mriskSwitch){
            //                        //种植险理赔清单导出Excel
            //                        url = 'nyxPlantingClaimListExportExcel';
            //                    }else if(!_mriskSwitch){
            //                        //养殖险理赔清单导出Excel
            //                        url = 'nyxBreedClaimListExportExcel';
            //                    }
            //                }
            //                $$finder.post(url,keywords).then(
            //                    function (data) {
            //                        if(data && data.url){
            //                            $window.open(data.url);
            //                        }else if(data && data.shortLink){
            //                            $window.open(data.shortLink);
            //                        }else{
            //                            layerMsg("下载失败,"+data.message);
            //                        }
            //                    },
            //                    function (e) {
            //                        layerMsg("下载失败");
            //                    }
            //                );
            //            };
            //            //关闭模态框
            //            $scope.closeModal = function () {
            //                $modalInstance.dismiss();
            //            };
            //        }
            //    });
            //};

            //    导入清单
            //var isSuccess=111;
            //$scope.importlist=function(){
            //    $modal.open({
            //        templateUrl: 'common/business/regist/UIAgriRegist.importList.modal.html',
            //        resolve:{
            //            _mriskSwitch:function () {
            //                //险种类型
            //                return $scope.mriskSwitch
            //            },
            //            queryDto:function () {
            //                //页面初始化后的对象
            //                return angular.copy($scope.claim);
            //            }
            //        },
            //        controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
            //            var uploader = $scope.uploader = new FileUploader({
            //                url:'/fileserver-server/uploadFile',
            //                formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
            //                queueLimit:1,
            //                autoUpload:false,
            //                removeAfterUpload:false//上传后删除文件
            //            });
            //            uploader.onSuccessItem = function(item, response, status, headers){
            //                if(response.resultCode == '0000'){
            //                    //根据导入成功后的fileid调用保存
            //                    //判断导入的理赔清单类型
            //                    var keywords = {
            //                        "fileId":response.resultObj.fileId,
            //                        "fileName":"tttt",
            //                        "riskCode":$rootScope.claimDto.riskCode,
            //                        "policyNo":$rootScope.claimDto.policyNo,
            //                        "damageStartDate":$rootScope.claimDto.prpLClaimDto.damageStartDate,
            //                        "damageStartHour":$rootScope.claimDto.prpLClaimDto.damageStartHour,
            //                        "userCode":$rootScope.user.userCode,
            //                        "userName":$rootScope.user.userName,
            //                        "nodeOrigin":$rootScope.claimDto.nodeType,
            //                        "registNo":$rootScope.claimDto.registNo
            //
            //                    };
            //                    console.log(keywords);
            //                    $$finder.post("readBreedingList",keywords).then(
            //                        function (data) {
            //                            if(data && !data.code && data != 'gateway'){
            //                                $rootScope.$broadcast('updateSumAmount',data.sumAmount);
            //                                layerMsg("导入成功");
            //                                isSuccess=222;
            //                                listNo=data.content[0].listNo;
            //                            }else if(data && data.code == '9999'){
            //                                layerMsg("导入失败! "+data.message);
            //                            }else{
            //                                layerMsg("导入失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("导入失败");
            //                        }
            //                    );
            //                }
            //                if(response.code == '9999'){
            //                    layerMsg("导入失败"+response.message);
            //                }
            //            };
            //            $scope.uploader.onErrorItem = function(item, response, status, headers){
            //                layerMsg("导入失败");
            //            };
            //            /**
            //             * 下载方法
            //             * @param _type 类型
            //             */
            //            $scope.download = function (_type) {
            //                var url = '';
            //                //耳标号承保清单下载
            //                if(_type == 'LossRateList'){
            //                    var keywords =
            //                    {
            //                        "policyNo":queryDto.policyNo//报案号
            //                        // "registNo":"3310103"//报案号
            //                    };
            //                    //种植险理赔清单导出Excel
            //                    url = 'earmarkUnderwritingDownload';
            //
            //                    $$finder.post(url,keywords).then(
            //                        function (data) {
            //                            if(data && data.url){
            //                                $window.open(data.url);
            //                            }else if(data && data.shortLink){
            //                                $window.open(data.shortLink);
            //                            }else if(data.code == '9999'){
            //                                layerMsg("下载失败，"+data.message);
            //                            }else {
            //                                layerMsg("下载失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("下载失败");
            //                        }
            //                    );
            //                }else if(_type == 'template'){
            //                    //模板下载
            //                    //养殖险理赔清单空模版下载
            //                    // url = 'nyxBreedClaimLis';
            //                    $window.open('/api/agriclaim/templateFile/download?fileType=dingSunClaimList');
            //
            //                }else if(_type == 'policy'){
            //                    //保单清单下载
            //                    var keywords =
            //                    {
            //                        //"policyNo":queryDto.policyNo//保单号
            //                        "policyNo":"231013418002013000827"
            //                    };
            //                    url = 'NyxPolicyListExportExcel';
            //                    $$finder.post(url,keywords).then(
            //                        function (data) {
            //                            if(data && data.url){
            //                                $window.open(data.url);
            //                            }else if(data && data.shortLink){
            //                                $window.open(data.shortLink);
            //                            }else if(data.code == '9999'){
            //                                layerMsg("下载失败，"+data.message);
            //                            }else {
            //                                layerMsg("下载失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("下载失败");
            //                        }
            //                    );
            //                }
            //            };
            //            //关闭模态框
            //            $scope.closeModal = function () {
            //                $modalInstance.dismiss();
            //            };
            //            //确认按钮
            //            $scope.determine = function () {
            //                if(isSuccess!=222){
            //                    layerMsg("请导入清单！");
            //                }else{
            //                    $modalInstance.dismiss();
            //                }
            //            };
            //        }
            //    });
            //}
            //关联按钮清单下载
            $scope.downloadlist=function(){
                var url = '';
                //定损清单下载
                var keywords =
                {
                    "registNo":$scope.checkInfo.bizNo,
                    "lossListCode":$scope.checkInfo.lossListCode,
                    "policyNo":$scope.checkInfo.policyNo

                    // "registNo":"3310103"//报案号
                };
                url = 'downloadist';
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
            //清单下载
            $scope.down=function(){
                var url = '';
                //清单下载
                    var keywords = {
                        "listNo": $scope.claim.listNo || '',//理赔清单号
                        "policyNo": $scope.claim.policyNo || '',//保单号
                        "registNo": $scope.claim.registNo || '',//报案号
                        "compensateNo": $scope.claim.compensateNo || '',//计算书号
                        "fCode": $scope.claim.fCode || '',//农户号
                        "modeType": "1",//导出类型（1有数据，0无数据）
                        "type":"list",
                        "nodeType":$scope.claim.nodeType
                    };
                    if ( $scope.mriskSwitch) {
                        //种植险理赔清单导出Excel
                        url = 'nyxPlantingClaimListExportExcel';
                    } else {
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

            //// 损失清单数据导入
            //var isSuccess=111;
            //$scope.import=function(){
            //    $modal.open({
            //        templateUrl: 'common/business/regist/UIAgriRegist.Plantingrisk.importList.modal.html',
            //        resolve:{
            //            _mriskSwitch:function () {
            //                //险种类型
            //                return $scope.mriskSwitch
            //            },
            //            queryDto:function () {
            //                //页面初始化后的对象
            //                return angular.copy($scope.claim);
            //            }
            //        },
            //        controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
            //            var uploader = $scope.uploader = new FileUploader({
            //                url:'/fileserver-server/uploadFile',
            //                formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
            //                queueLimit:1,
            //                autoUpload:false,
            //                removeAfterUpload:false//上传后删除文件
            //            });
            //            uploader.onSuccessItem = function(item, response, status, headers){
            //                if(response.resultCode == '0000'){
            //                    //根据导入成功后的fileid调用保存
            //                    //判断导入的理赔清单类型
            //                    var keywords = {
            //                        "fileId":response.resultObj.fileId,
            //                        "fileName":"PlantingList",
            //                        "riskCode":$rootScope.claimDto.riskCode,
            //                        "policyNo":$rootScope.claimDto.policyNo,
            //                        "damageStartDate":$rootScope.claimDto.prpLClaimDto.damageStartDate,
            //                        "damageStartHour":$rootScope.claimDto.prpLClaimDto.damageStartHour,
            //                        "userCode":$rootScope.user.userCode,
            //                        "userName":$rootScope.user.userName,
            //                        "nodeOrigin":$rootScope.claimDto.nodeType,
            //                        "registNo":$rootScope.claimDto.registNo
            //
            //                    };
            //                    $$finder.post("readPlantingList",keywords).then(
            //                        function (data) {
            //                            if(data && !data.code && data != 'gateway'){
            //                                $rootScope.$broadcast('updateSumAmount',data.sumAmount);
            //                                layerMsg("导入成功");
            //                                isSuccess=222;
            //                                listNo=data.content[0].listNo;
            //                            }else if(data && data.code == '9999'){
            //                                layerMsg("导入失败! "+data.message);
            //                            }else{
            //                                layerMsg("导入失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("导入失败");
            //                        }
            //                    );
            //                }
            //                if(response.code == '9999'){
            //                    layerMsg("导入失败"+response.message);
            //                }
            //            };
            //            $scope.uploader.onErrorItem = function(item, response, status, headers){
            //                layerMsg("导入失败");
            //            };
            //            /**
            //             * 下载方法
            //             * @param _type 类型
            //             */
            //            $scope.plantingdownload = function (_type) {
            //                var url = '';
            //                //耳标号承保清单下载
            //                if(_type == 'LossRateList'){
            //                    var keywords =
            //                    {
            //                        "policyNo":queryDto.policyNo//报案号
            //                        // "registNo":"3310103"//报案号
            //                    };
            //                    //种植险理赔清单导出Excel
            //                    url = 'earmarkUnderwritingDownload';
            //
            //                    $$finder.post(url,keywords).then(
            //                        function (data) {
            //                            if(data && data.url){
            //                                $window.open(data.url);
            //                            }else if(data && data.shortLink){
            //                                $window.open(data.shortLink);
            //                            }else if(data.code == '9999'){
            //                                layerMsg("下载失败，"+data.message);
            //                            }else {
            //                                layerMsg("下载失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("下载失败");
            //                        }
            //                    );
            //                }else if(_type == 'template'){
            //                    //模板下载
            //                    //养殖险理赔清单空模版下载
            //                    // url = 'nyxBreedClaimLis';
            //                    $window.open('/api/agriclaim/templateFile/download?fileType=PlantingDingSunList');
            //
            //                }else if(_type == 'policy'){
            //                    //保单清单下载
            //                    var keywords =
            //                    {
            //                        //"policyNo":queryDto.policyNo//保单号
            //                        "policyNo":"231013418002013000827"
            //                    };
            //                    url = 'NyxPolicyListExportExcel';
            //                    $$finder.post(url,keywords).then(
            //                        function (data) {
            //                            if(data && data.url){
            //                                $window.open(data.url);
            //                            }else if(data && data.shortLink){
            //                                $window.open(data.shortLink);
            //                            }else if(data.code == '9999'){
            //                                layerMsg("下载失败，"+data.message);
            //                            }else {
            //                                layerMsg("下载失败");
            //                            }
            //                        },
            //                        function (e) {
            //                            layerMsg("下载失败");
            //                        }
            //                    );
            //                }
            //            };
            //            //关闭模态框
            //            $scope.closeModal = function () {
            //                $modalInstance.dismiss();
            //            };
            //            //确认按钮
            //            $scope.determine = function () {
            //                if(isSuccess!=222){
            //                    layerMsg("请导入清单！");
            //                }else{
            //                    $modalInstance.dismiss();
            //                }
            //            };
            //        }
            //    });
            //}
            //出险原因
            // var _data = {
            //     "initlist": [
            //         {
            //             "codeType": "damageName",
            //             "riskCode": $stateParams.riskCode
            //         }
            //     ]
            // };
            // $$finder.post("baseCode", _data).then(function (data) {
            //
            //     angular.forEach(data.data, function (item, index) {
            //         $scope.codeListData[item.codeType] = item.resultobj.action_result;
            //     })
            // });
            // 添加估损金额
            $scope.addLossList =function () {
                var curDate = new Date();
                curDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                var obj ={
                    familyName:"", //被保险人姓名
                    kindCode: "",  //险别代码
                    kindName: "",  //险别名称
                    itemDetailName: "",  //标的名称
                    currency: "CNY",  //币别
                    sumClaim: "0",  // 预计给付金额
                    lossFeeType: "",  // 类别,
                    inputDate: curDate , // 预计给付金额
                    claimNo: ""  // 预计给付金额
                };
                $scope.claim.prpLclaimLossDtoList.push(obj);
                $scope.gatherSumFalg = false;
            };

            //根据险别带出标的
            $scope.getItemDetailName =function (item, $select) {
                item.itemDetailName=$select.selected.itemdetailName
            };
            // 删除估损金额
            $scope.delLossList = function (index) {
                $scope.claim.prpLclaimLossDtoList.splice(index, 1);
                $scope.gatherSumFalg = false;
            };
            // 删除危险单位
            $scope.delDangerUnit = function (index) {
                $scope.dangerUnit=null;
                dangerous=0;
            };
            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.claim.perilCount===null||$scope.claim.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                }
                var url = '#/PerilCount?policyNo=' + $stateParams.policyNo;
                $window.open(url);
            };

            /**
             *   调查报告按钮
             */
           /* $scope.showSurveyReport = function () {
                var dataDto ={
                  /!*  "policyNo":"231073400002018000465",
                    "bizNo":"431073400002018000516"*!/
                   "policyNo":$scope.claim.policyNo,
                    "bizNo":$scope.claim.prpLClaimDto.registNo
                };
                $$finder.post('findCheckId', dataDto).then(
                    function (datew) {
                        console.log(datew)
                        if(datew.length>0&&datew[0].checkId){
                            $scope.checkId=datew[0].checkId
                            var GISIP="http://36.32.160.60:8888"
                            var classCode=$scope.claim.policyNo.substring(1,3);
                            if(classCode==31) {
                                var urlv = GISIP + '/CallPage/surveyShow/plantingSurvey?surveyID='+$scope.checkId;//种植险：
                                $window.open(urlv);
                            }else if(classCode==32) {
                                var urlv = GISIP + '/CallPage/surveyShow/cultivationSurvey?surveyID='+$scope.checkId;//养殖险：
                                $window.open(urlv);
                            }
                        } else {
                            layerMsg("查勘编号为空不能查询调查报告！");
                            return
                        }
                    }
                )
            };*/
            $scope.showSurveyReport = function (){
                var classCode=$scope.claim.prpLClaimDto.registNo.substring(1,3);
                if(!$scope.claim.prpLClaimDto.registNo){
                    layerMsg("报案号为空不能查询调查报告");
                    return
                } else{
                    if(classCode==31) {
                        $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.plantingSurveyurl+$scope.claim.prpLClaimDto.registNo);
                    }else if(classCode==32) {
                        $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.cultivationSurveyurl+$scope.claim.prpLClaimDto.registNo);
                    }
                }
            }







            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

            /**
             * 汇总
             */
            $scope.gatherSum = function () {
                if(!$scope.calibrateSum()){
                    return false;
                }
                var sumPrim = 0;
                angular.forEach($scope.claim.prpLclaimLossDtoList,function (prpLclaimLossDto,index) {
                    sumPrim = parseFloat(prpLclaimLossDto.sumClaim) + sumPrim;
                });
                $scope.claim.prpLClaimDto.sumClaim = sumPrim;
                $scope.gatherSumFalg = true;
            };

            //放弃任务
            $scope.giveup = function () {
                var dto = {
                    "swfLogFlowID":$stateParams.flowId,
                    "swfLogLogNo":$stateParams.logNo
                };
                var back=function(){
                    $state.go('UIAgriClaimQuery')
                };
                commonApiServ.giveupTemporary(dto,back);
            };

            $scope.makeDangerUnit = function () {
                var sumPrim = 0;
                angular.forEach($scope.claim.prpLclaimLossDtoList,function (prpLclaimLossDto,index) {
                    sumPrim = parseFloat(prpLclaimLossDto.sumClaim) + sumPrim;
                });
                var keyMap = {
                    "registNo":$stateParams.registNo || "",
                    "kindCode":kindCode || ""
                };
                $$finder.post('makeDangerUnitBack',keyMap).then(
                    function (data) {
                        if (data.code == '9999'){
                            layerMsg(data.message)
                        }else {
                            $scope.dangerUnit = data;
                            $scope.dangerUnit.sumLoss = sumPrim;
                           dangerous=1;
                        }
                    }
                );
            };
            
            /**
             * 险别估损金额信息
             */
            $scope.calibrateSum = function () {
                if(!$scope.claim.prpLclaimLossDtoList){
                    layerMsg("请填写险别估损金额信息！");
                    return false;
                }else {
                    var layerMges = "";
                    angular.forEach($scope.claim.prpLclaimLossDtoList,function (prpLclaimLossDto,index) {
                        if(!prpLclaimLossDto.familyName){
                            layerMges = "被保险人";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'被保险人'不能为空！");
                            return false;
                        }
                        if(!prpLclaimLossDto.itemDetailName){
                            layerMges = "险别";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'险别'不能为空！");
                            return false;
                        }
                        if(!prpLclaimLossDto.currency){
                            layerMges = "币别";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'币别'不能为空！");
                            return false;
                        }
                        if(!prpLclaimLossDto.sumClaim){
                            layerMges = "预计给付金额";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'预计给付金额'不能为空！");
                            return false;
                        }
                        if(!prpLclaimLossDto.lossFeeType){
                            layerMges = "类别";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'类别'不能为空！");
                            return false;
                        }

                    });
                    if(!layerMges){
                        return true;
                    }
                }
                
            }
        }]);
});