/**
 * DESC       : 国元农险理赔特殊赔案任务申请页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */

define([
    'app', 'constants', 'layer', 'jsonDB', 'utilities', 'codes','config',
    'common/business/electronicsDocuments/UIAgriElectronics.examine.model.ctrl',
    'common/business/compenstate/UIAgriCompenstate.ctrl'
], function (app, constants, layer, jsonDB, utilities, codes,config) {
    'use strict';
    app.registerController('UIAgriPrepayHandleCtrl', ['$rootScope', '$scope', '$filter', '$location', '$$finder','$stateParams','regexpConstants','$state','$modal','$http','$window','commonApiServ','localStorageService',
        function ($rootScope, $scope, $filter, $location, $$finder,$stateParams, regexpConstants,$state,$modal,$http,$window,commonApiServ,localStorageService) {
            var editType=$stateParams.editType;
            $scope.prepayPageInit = {}; // 查询条件
            $scope.prepayPageInit.sumPaid = 0.00;
                //更新总赔付金额
            $rootScope.$on('updateSumAmount',function (event,data) {
                var sum = 0;
                if($scope.prepayPageInit.prpLpreChargeDtoList.length){
                    angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function (prpLPreChargeDto,index) {
                        if(prpLPreChargeDto.sumprePaid&&parseFloat(prpLPreChargeDto.sumprePaid)){
                            sum += parseFloat(prpLPreChargeDto.sumprePaid);
                        }
                    });
                }
                $scope.prepayPageInit.sumPaid = data.settleAmount.toFixed(2);
                $scope.prepayPageInit.prePaid =(data.settleAmount+sum).toFixed(2);
                $scope.prepayPageInit.listNo = data.listNo;
            });
            $scope.communication = function () { //理赔沟通弹层
                $modal.open({
                    templateUrl:'common/business/prepay/handle/modal/UIAgriPrepay.communicate.modal.html',
                    resolve:{
                        queryDto:function () {
                            return angular.copy($scope.prepayPageInit)
                        }
                    },
                    //controller:'UIAgriCompenstateCtrl'//claimCommunicateCtrl
                    controller:function ($scope,$modalInstance,queryDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo": queryDto.policyNo || '',//保单号
                                "registNo": queryDto.registNo || '',//报案号
                                "claimNo": queryDto.claimNo || '',//立案号
                                "riskCode": queryDto.prpLClaimDto.riskCode || '',//险种代码
                                "nodeType": 'speci',//节点类型queryDto.nodeType ||
                                "operatorCode": $scope.user.userCode || '',// 操作员代码
                                "operatorName": $scope.user.userName || '',// 操作员代码
                                "inputDate":'2017-10-27'//后端已获取当前时间，但加了非空校验所以此处写死
                            };
                            $$finder.post('queryClaimCommunicationByCondition',keywords).then(
                                function (data){
                                    if(data && !data.code){
                                        $scope.communication = data;
                                        $scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        layerMsg(data.message);
                                        $scope.closeModal();
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
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
                                    layerMsg("保存失败");
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
             * 电子单证弹层
             */
            $scope.electronic = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            var item = angular.copy($scope.prepayPageInit);
                            item.nodeType = "speci";
                            item.riskCode = $scope.prepayPageInit.prpLClaimDto.riskCode;
                            return item;
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            /**
             * 清单下载
             */
            $scope.downloadList = function () {
                $modal.open({
                    templateUrl:'common/business/prepay/handle/modal/UIAgriPrepay.downloadList.modal.html',
                    resolve:{
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.prepayPageInit);
                        }
                    },
                    controller:function ($scope,$modalInstance,queryDto) {
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.download = function (_type) {
                            var url = '';
                            //定损
                            if (!queryDto.listNo) {
                                layerMsg("请先导入清单!");
                            } else {
                            if (_type == 'prepayList') {
                                var keywords =
                                {
                                    "listNo": queryDto.listNo || ''//清单号
                                };
                                url = 'expSpecCaseList';
                                $$finder.post(url, keywords).then(
                                    function (data) {
                                        if (data && data.url) {
                                            $window.open(data.url);
                                        } else if (data && data.shortLink) {
                                            $window.open(data.shortLink);
                                        } else {
                                            layerMsg("下载失败," + data.message);
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }
                        }
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
                    templateUrl:'common/business/prepay/handle/modal/UIAgriPrepay.importList.modal.html',
                    resolve:{
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.prepayPageInit);
                        }
                    },
                    controller:function ($scope,$modalInstance,queryDto,FileUploader) {
                        /** 下载 */
                        $scope.download = function (_type) {
                            var url = '';
                            if (_type == 'template') {
                                if($scope.listNo){
                                    //有清单号查询预赔清单
                                    var keywords =
                                        {
                                            "listNo":$scope.listNo || ''//清单号
                                        };
                                    url = 'expSpecCaseList';
                                }else {
                                    //没有预赔号查询承保清单拼接
                                    var keywords =  {
                                        "policyNo":queryDto.policyNo || '',//保单号
                                        "validDate":$filter("date")(queryDto.prpLClaimDto.damageEndDate,"yyyy-MM-dd") || '',//出险时间
                                        "registNo":queryDto.prpLClaimDto.registNo || '',//出险时间
                                        "claimNo":queryDto.prpLClaimDto.claimNo || ''//出险时间
                                    };
                                    url = 'expSpecCaseModelList';
                                }
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else{
                                            //layerMsg("下载失败,"+data.message);
                                            $window.open('/api/agriclaim/templateFile/download?fileType=specCaseList');
                                        }
                                    },
                                    function (e) {
                                        // layerMsg("下载失败");
                                        $window.open('/api/agriclaim/templateFile/download?fileType=specCaseList');
                                    }
                                );
                            }else if(_type == 'PolicyList'){
                                var keywords =  {
                                    "policyNo":queryDto.policyNo || '',//保单号
                                    "validDate":$filter("date")(queryDto.prpLClaimDto.damageEndDate,"yyyy-MM-dd") || ''//出险时间
                                };
                                url = 'getInsureListInfoFileId';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.fileId){
                                            $window.open(data.fileId);
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
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_prepaymanage_ui'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response, status, headers){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "comCode":queryDto.comCode
                                };
                                var url = 'importSpecCaseListExcel';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        debugger;
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
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };


            //放弃任务
            $scope.giveup = function () {
                var dto = {
                    "swfLogFlowID":$stateParams.flowID,
                    "swfLogLogNo":$stateParams.logNo
                };
                var back=function(){
                    $state.go('UIAgriPrepayHandleQuery')
                };
                commonApiServ.giveupTemporary(dto,back);
            };

            /**
             * 计算
             */
            $scope.additionSum = function () {
                var sum = 0;
                if($scope.prepayPageInit.prpLpreChargeDtoList.length){
                    angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function (prpLPreChargeDto,index) {
                        if(prpLPreChargeDto.sumprePaid&&parseFloat(prpLPreChargeDto.sumprePaid)){
                            sum += parseFloat(prpLPreChargeDto.sumprePaid);
                        }
                    });
                }
                if($scope.prepayPageInit.sumPaid){
                    $scope.prepayPageInit.prePaid = parseFloat($scope.prepayPageInit.sumPaid) + sum;
                }else{
                    $scope.prepayPageInit.prePaid = sum;
                }
            };

            /**
             * 删除
             */
            $scope.deleteListWhear = function (index) {
                debugger;
                var sum = 0;
                if($scope.prepayPageInit.prpLpreChargeDtoList.length>0){
                    $scope.prepayPageInit.prpLpreChargeDtoList.splice(index,1);
                }
                if($scope.prepayPageInit.prpLpreChargeDtoList.length){
                    angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function (prpLPreChargeDto) {
                        if(prpLPreChargeDto.sumprePaid&&parseFloat(prpLPreChargeDto.sumprePaid)){
                            sum += parseFloat(prpLPreChargeDto.sumprePaid);
                        }
                    });
                }
                if($scope.prepayPageInit.sumPaid){
                    $scope.prepayPageInit.prePaid = parseFloat($scope.prepayPageInit.sumPaid) + sum;
                }else{
                    $scope.prepayPageInit.prePaid = sum;
                }
            };

            /**
             * 添加
             */
            $scope.addListWhear = function () {
                var target = {
                    "chargeCode": "",
                    "chargeName": "",
                    "currency": "",
                    "kindCode": "",
                    "sumprePaid": ""
                };
                $scope.prepayPageInit.prpLpreChargeDtoList.push(target);
                //计算总付金额
                angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function (index,val) {
                    if(val.sumprePaid){
                        $scope.prepayPageInit.sumPaid += parseFloat(val.sumprePaid);
                    }
                });
            };

            $scope.applySave = function(index){
                 $scope.flag=false;
                if(!$scope.prepayPageInit.sumPaid||$scope.prepayPageInit.sumPaid=="null"){
                    layerMsg("请导入特殊赔案清单生成总赔付金额！");
                    return false;
                }
                $scope.prepayPageInit.prpLclaimStatusDto=$scope.prepayPageInit.prpLclaimStatusDto||{};
                $scope.prepayPageInit.prpLclaimStatusDto.status = index;



                var chargeCodeCheck = true;
                var sumprePaidCheck = true;
                angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function (prpLPreChargeDto) {
                    if(prpLPreChargeDto && !prpLPreChargeDto.sumprePaid){
                        sumprePaidCheck = false;
                    }
                    if(prpLPreChargeDto && !prpLPreChargeDto.chargeCode){
                        chargeCodeCheck = false;
                    }
                });


                if(!chargeCodeCheck){
                    layerMsg("费用列表中费用名称不可出现空值！");
                    return false;
                }
                if(!sumprePaidCheck){
                    layerMsg("费用列表中费用金额不可出现空值！");
                    return false;
                }
                //提交
                var content='';
                if(index==2){
                    content='暂存'
                }
                if(index==4){
                    content='保存'
                }
                var dto = angular.copy($scope.prepayPageInit);
                dto.prpLPrepayDto.sumPrepaid = $scope.prepayPageInit.sumPaid;
                var sums=0;
                angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function(dmp){
                    sums+=parseFloat(dmp.sumprePaid);
                })
                dto.prpLPrepayDto.sumTotalPrepaid=$scope.prepayPageInit.prePaid;
                debugger;
                $$finder.post('savePrepay',dto).then(
                    function (data) {
                        if(data.preCompensateNo){
                            layerMsg(content+'成功，预赔计算书号为'+data.preCompensateNo);
                            $state.go('UIAgriPrepayHandleQuery');
                            $scope.flag=true;
                        }else{
                            layerMsg(content+'失败，'+data.message);
                        }
                    }
                )
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $scope.prepayMessage=false;
                $state.go("UIAgriPrepayHandleQuery");
            };
            /*$scope.goBack = function () {
                window.history.back();
            };*/
            /**
             * 初始化
             */
            var init = function () {
                //初始化数据
                if (editType == "SHOW") {
                    $scope.seeFlag = true;
                    $scope.showFlag = true;
                }
                $scope.regData = regexpConstants || {};
                $scope.swfLogDto = {}; // 查询结果
                $scope.seeFlag=false;
                $scope.seeFlage_communication=false;
                $scope.seeFlag_electronic=false;
                var prepayPageInit =function () {
                    var  initData = angular.copy($stateParams);
                    initData.businessNo = initData.claimNo;
                    initData.prepayNo = $stateParams.prepayNo;
                    $$finder.post('prepayPageInit', initData).then(
                        function (data) {
                            debugger;
                            if (data.message) {
                                if (data.message.substring(26, 27) == "8") {
                                    layerMassage(data.message);
                                } else {
                                    layerMsg(data.message);
                                    $state.go('UIAgriPrepayHandleQuery');
                                }
                            }

                            $scope.prepayPageInit = data;
                            var newDate = new Date();
                            newDate.setTime($scope.prepayPageInit.prpLPrepayDto.statisticSym);
                            $scope.prepayPageInit.prpLPrepayDto.statisticSym = $filter("date")(newDate, "yyyy-MM-dd");
                            //$scope.prepayPageInit.prePaid = data.sumPaid;
                            //$scope.prepayPageInit.prePaid = data.prpLPrepayDto.sumPrepaid;
                            $scope.prepayPageInit.prePaid=data.prpLPrepayDto.sumTotalPrepaid;
                            $scope.prepayPageInit.prpLpreChargeDtoList = data.prpLPreChargeDtoList;
                            $scope.prepayPageInit.sumPaid = data.sumPaid;
                            angular.forEach($scope.prepayPageInit.prpLpreChargeDtoList,function(dto){
                                if(dto.chargeCode=='03'||dto.chargeCode=='04'||dto.chargeCode=='05'||dto.chargeCode=='07'||dto.chargeCode=='04'||dto.chargeCode=='05'){
                                    dto.chargeCode.codecode = dto.chargeCode;
                                }else{
                                    dto.chargeCode.codecode = "99";
                                }
                            });

                            if(!$scope.prepayPageInit.prpLpreChargeDtoList){
                                $scope.prepayPageInit.prpLpreChargeDtoList = [
                                    {
                                        "chargeCode": "",
                                        "chargeName": "",
                                        "currency": "",
                                        "kindCode": "",
                                        "sumprePaid": ""
                                    }
                                ];
                            }
                        }
                    );
                };
                //初始化数据
                $scope.authSystemFlag = $stateParams.authSystemFlag;
                if ($scope.authSystemFlag==true) {
                    $$finder.post("queryByBusinessNo", $stateParams).then(
                        function (dto) {
                            console.log(dto)
                            console.log("以下是报案节点的相关数据内容")
                            console.log(dto)
                            $stateParams.policyNo = dto.policyNo;
                            $stateParams.riskCode = dto.riskCode;
                            $stateParams.claimNo = $stateParams.claimNo;
                            $stateParams.flowId = dto.flowId;
                            $stateParams.logNo = dto.logNo;
                            $stateParams.prepayNo = $stateParams.businessNo;
                            prepayPageInit();
                        }
                    )
                }
                else {
                    prepayPageInit();
                }
            };
            init();
            $scope.addDtoExt=function(){
                $scope.prepayPageInit=$scope.prepayPageInit||[]
                $scope.prepayPageInit.prpLsumpayDtoList=$scope.prepayPageInit.prpLsumpayDtoList||[]
                var prpLsumpayDto = {
                    "comCode":$scope.prepayPageInit.comCode,//归属机构
                    "nodeType":"compe",//节点类型
                    "policyNo":$scope.prepayPageInit.policyNo,//保单号
                    "registNo":$scope.prepayPageInit.registNo,//报案号
                    "claimNo": $scope.prepayPageInit.claimNo,//立案号
                    serialNo:($scope.prepayPageInit.prpLsumpayDtoList.length) + 1,//序号
                    accountBank:'',//银行名称
                    accountCode:'',//银行代码
                    accountName:'',//账户名
                    taxdentifId:'',//第三方机构ID
                    accountNo_first:'',//账号
                    accountNo:'',//账号确认(请再次输入账号)
                    payType:'',//赔款类型
                    sumthisPay:'',//赔款金额
                    currency:'CNY',//币别
                    chargeCode:'',//费用代码
                    cardType:'',//卡/折标识
                    presidial:'',//省
                    cantonal:'',//市
                    settlementMode:'',//结算方式
                    remarkInfo:''//付款备注信息
                };
                $scope.prepayPageInit.prpLsumpayDtoList.push(prpLsumpayDto);
            };
            $scope.delDtoExt=function(index){
                $scope.prepayPageInit.prpLsumpayDtoList.splice(index,1);
            };
            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.prepayPageInit.perilCount===null||$scope.prepayPageInit.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                }
                var url = '#/PerilCount?policyNo=' + $scope.prepayPageInit.policyNo;
                $window.open(url);
            };
            $scope.changePayType=function(){
                angular.forEach($scope.queryDto.prpLsumpayDtoList,function(result){
                    if(result.payType=='01'){
                        result.taxdentifId="";
                        result.chargeName="";
                        result.chargeCode="";
                        result.positiveNumber="";
                        $scope.nonePayType=true
                    }
                })
            };
            Window.prototype.layerMassage = function(data){
                $scope.errMsg = data.substring(0,26);
                $scope.businessNo = data.substring(26);
                $scope.prepayMessage=true;
            };
            $scope.goPrepaySee = function (result) {
                goApply(result, "SHOW")
            };
            var goApply=function(result,edit){
                $state.go('UIAgriPrepayHandle',{
                    editType: edit,
                    prepayNo:$scope.businessNo
                })
            };
        }]);

});