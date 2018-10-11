/**
 * DESC       : 国元农险理赔立案任务查看
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
    app.registerController('UIAgriClaimSeeCtrl', ['$rootScope', '$scope', '$location', '$$finder', 'regexpConstants', '$stateParams','$modal','$window','$filter',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $stateParams,$modal, $window,$filter) {
            $scope.codeListData ={};
            $scope.dangerUnit = {};
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



            var claimPageInit =function () {
                $scope.claimQueryDto = {
                    editType: $stateParams.editType,
                    claimNo: $stateParams.claimNo,
                    registNo:$stateParams.registNo,
                    flowId:$stateParams.flowId
                    //editType:"SHOW",
                    //claimNo:"432203416002012002020"
                }; // 查询条件
                $$finder.post("claimPageInit", $scope.claimQueryDto).then(
                    function (data) {
                        console.log("================以下是立案初始化页面");
                        console.log(data);
                        $scope.dangerUnit = data.dangerUnitBackDto;
                        $scope.assessment = data.prpLclaimLossDtoList;
                        $scope.dangerUnit.sumLoss = 0;
                        angular.forEach($scope.assessment, function (date) {
                            date.inputDate = $filter('date')(date.inputDate, 'yyyy-MM-dd');
                            $scope.dangerUnit.sumLoss += date.sumClaim;
                        });
                        // $scope.dangerUnit = $scope.resultObj.content;
                        $scope.claim = data;
                        $scope.riskType = data.riskType;
                        $scope.registNo = data.prpLClaimDto.registNo;
                        $scope.claim.prpLClaimDto.damageStartDate = $filter("date")(data.prpLClaimDto.damageStartDate, "yyyy-MM-dd");
                        $scope.claim.prpLClaimDto.claimDate = $filter("date")(data.prpLClaimDto.claimDate, "yyyy-MM-dd");
                        if ($scope.riskType === "H"||data.riskCode==='3224'||data.riskCode==='3237') { // 种植险
                            $scope.isAquaculture = false;
                        } else if ($scope.riskType === "I"&&data.riskCode!='3224'&&data.riskCode!='3237') { // 养植险
                            $scope.isAquaculture = true;
                        }
                    }
                );
            };

            $scope.authSystemFlag = $stateParams.authSystemFlag;
            //承保关联跳过来的页面缺少入参,在这里进行处理
            if ($scope.authSystemFlag==true) {
                $$finder.post("queryByBusinessNo", $stateParams).then(
                    function (dto) {
                        console.log(dto);
                        console.log("以下是报案节点的相关数据内容");
                        console.log(dto);
                        $stateParams.policyNo = dto.policyNo;
                        $stateParams.riskCode = dto.riskCode;
                        $stateParams.claimNo = $stateParams.businessNo;
                        $stateParams.flowId = dto.flowId;
                        claimPageInit();
                    }
                )
            }
            else {
                claimPageInit();
            }


            /**
             * 理赔沟通
             */

            $scope.showCompensateComm = function () {
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
             * 电子单证
             */
            $scope.showElectronicDocu = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.claim);
                    }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            $scope.openInforListLayer = function () {
                $scope.$broadcast("SendInforListLayerSwitch");
            };
            $scope.editType = $stateParams.editType;
            $scope.isAquaculture = false;
            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.claim.perilCount===null||$scope.claim.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                };
                var url = '#/PerilCount?policyNo=' + $stateParams.policyNo;
                $window.open(url);
            };

            /**
             *   调查报告按钮
             */
          /*  $scope.showSurveyReport = function () {
                       //debugger;
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
                            layerMsg("查勘编号为空不能查询调查报告");
                            return
                        }
                    }
                )
            };
*/
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
                window.history.back();
            };

        }]);
});