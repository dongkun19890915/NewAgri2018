/**
 * DESC       : 国元农险理赔结案任务查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriEndcaseSeeCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams','regexpConstants','$state','$filter','$modal','commonApiServ',
        function ($rootScope, $scope, $location, $$finder, $stateParams,regexpConstants ,$state,$filter,$modal,commonApiServ) {



            //提交
            $scope.submitEndCase = function () {
                $scope.flag=false;
                $scope.PrpLClaimEndCaseDto.endCaseDate = new Date(Date.parse($scope.PrpLClaimEndCaseDto.endCaseDate.replace(/-/g,   "/"))).getTime();
                $$finder.post('saveEndCaseInfo', $scope.PrpLClaimEndCaseDto).then(
                    function (data) {
                        layerMsg(data.message);
                        $state.go("UIAgriEndcaseQuery");
                        $scope.flag=true;
                    }
                )
            };

            /**
             * 初始化
             */
            var init = function () {
                $scope.prpLClaimDto = JSON.parse($stateParams.endcaseSee);
                // $scope.prpLClaimDto = {
                //     registNo:$stateParams.registNo || '',
                //     policyNo:$stateParams.policyNo || '',
                //     claimNo:$stateParams.claimNo || '',
                //     edit:$stateParams.edit || ''
                //
                //     // registNo:"431013400002017000039",
                //     // policyNo:"231013400002017000008",
                //     // claimNo:"531013400002017000033"
                // }; // 查询条件

                var editType = $scope.prpLClaimDto.edit;//$stateParams.editType;
                if(editType === "ADD" || editType === "EDIT"){
                    $scope.showFlag = true;
                    // $scope.mriskSwitch = true;
                }else if(editType === 'SHOW' ){
                    $scope.showFlag = false;
                }
                $scope.PrpLClaimEndCaseDto = null; // 查询结果

                var dto = angular.copy($scope.prpLClaimDto);
                console.log("以下是初始化的发送数据")
                console.log(dto);
                //提交查询
                dto.editType = editType;
                $$finder.post('queryEndCaseDetailByCondition', dto).then(
                    function (data) {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $scope.PrpLClaimEndCaseDto = data;
                        console.log('以下是结案初始化初始化的结果')
                        console.log(data)
                        $scope.PrpLClaimEndCaseDto.endCaserName=$rootScope.user.userName
                        $scope.PrpLClaimEndCaseDto.endCaseDate= $filter('date')( (new Date()).valueOf(), 'yyyy-MM-dd');
                        console.log(dto.editType)
                    }
                );

            };
            init();



            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.PrpLClaimEndCaseDto.policyNo;
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


            //放弃任务Up
            $scope.giveUp = function () {
                var dto = {
                    "swfLogFlowID":$stateParams.flowId,
                    "swfLogLogNo":$stateParams.logNo,
                    "registNo":$scope.PrpLClaimEndCaseDto.registNo
                }
                var back=function(){
                    $state.go('UIAgriEndcaseQuery')
                }
                commonApiServ.giveupTemporary(dto,back);
            }

            /**
             * 理赔沟通
             */
            $scope.showCompensateComm = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        PrpLClaimEndCaseDto:function () {
                            return angular.copy($scope.PrpLClaimEndCaseDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,PrpLClaimEndCaseDto) {
                        $scope.PrpLClaimEndCaseDto=$scope.PrpLClaimEndCaseDto || {}
                        console.log($scope.PrpLClaimEndCaseDto)
                        console.log('以下是入参')
                        console.log('=================')
                        console.log(PrpLClaimEndCaseDto.policyNo)
                        console.log(PrpLClaimEndCaseDto.registNo)
                        console.log(PrpLClaimEndCaseDto.claimNo)
                        console.log(PrpLClaimEndCaseDto.riskCode)
                        console.log(PrpLClaimEndCaseDto.nodeType)
                        console.log(PrpLClaimEndCaseDto.operatorCode)
                        console.log(PrpLClaimEndCaseDto.operatorName)
                        console.log("=================")
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo": PrpLClaimEndCaseDto.policyNo || '',//保单号
                                "registNo": PrpLClaimEndCaseDto.registNo || '',//报案号
                                "claimNo": PrpLClaimEndCaseDto.claimNo || '',//立案号
                                "riskCode": PrpLClaimEndCaseDto.riskCode || '',//险种代码
                                "nodeType": 'endca',
                                "operatorCode": PrpLClaimEndCaseDto.operatorCode || '',
                                "operatorName":PrpLClaimEndCaseDto.operatorName || '',
                                "inputDate":"2017-10-27" //TODO 制单日期      queryPrepayApplyInfo.inputDate || ''
                            };
                            $$finder.post('queryClaimCommunicationByCondition',keywords).then(
                                function (data){
                                    console.log('以下是理赔的理赔沟通查询结果页面的查询结果')
                                    console.log(data);
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
                        init();//TODO
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
                                        init();//TODO
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

        }]);
});