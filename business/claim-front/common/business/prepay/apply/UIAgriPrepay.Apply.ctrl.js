/**
 * DESC       : 国元农险理赔特殊赔案任务查询申请页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */


define([
    'app',
    'constants',
    'layer',
    'common/business/electronicsDocuments/UIAgriElectronics.examine.model.ctrl',
    'common/business/compenstate/UIAgriCompenstate.ctrl'
    //'common/business/modal/communicate/UIAgriCommunicate.modal.ctrl'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriPrepayApplyCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams','regexpConstants','$state','$modal',
        function ($rootScope, $scope, $location, $$finder,$stateParams, regexpConstants,$state,$modal) {
            $scope.queryPrepayApplyInfo = {}; // 查询条件
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            $scope.swfLogDto = {}; // 查询结果
            var editType=$stateParams.editType;
            $scope.seeFlag=false;
            $scope.seeFlage_communication=false;
            $scope.seeFlag_electronic=false;
            $scope.queryPrepayApplyInfo.applyType = 0;

            if(editType==='SHOW'){
                $scope.seeFlag=true;
            }
            //初始化数据
            var  initData = angular.copy($stateParams);
            initData.businessNo = initData.claimNo;
            initData.prepayNo = $stateParams.prepayNo;
            $$finder.post('queryPrepayApplyInfo',initData).then(function (data) {
                    console.log(1111);
                    console.log("提交查询");
                    console.log(data);
                    if(data.message){
                        if(data.message.substring(26,27)=="8"){
                            layerMassage(data.message);
                        }else{
                            layerMsg(data.message);
                            $state.go('UIAgriPrepayApplyQuery');
                        }
                    }
                    $scope.queryPrepayApplyInfo = data;
                    $scope.queryPrepayApplyInfo.typeFlag = "5";
                }
            );

            $scope.submitApply = function(){
                $scope.flag=false;
                if(!$scope.queryPrepayApplyInfo.titleStr){
                    layerMsg("请录入申请原因！");
                    return false;
                }
                //提交
                var subData = angular.copy($scope.queryPrepayApplyInfo);
                subData.claimNo = subData.businessNo;
                subData.flowID = subData.flowId;
                subData.content = subData.titleStr;
                $$finder.post('savePrepayApplication',subData).then(
                    function (data) {
                        //console.log("提交查询");
                        // data.claimNo
                        layerMsg(data.claimNo+'提交成功！');
                        //$rootScope.back();
                        $state.go("UIAgriPrepayApplyQuery");
                        $scope.Map = data;
                        $scope.flag=true;
                    }
                )
            };

            /**
             * 理赔沟通
             */
            $scope.showCompensateComm = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        queryDto:function () {
                            return angular.copy($scope.queryPrepayApplyInfo)
                        }
                    },
                    controller:'UIAgriCompenstateCtrl'//claimCommunicateCtrl
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
                            return angular.copy($scope.queryPrepayApplyInfo);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $scope.prepayMessage=false;
                $state.go("UIAgriPrepayApplyQuery");
                //$rootScope.back();
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
                $state.go('UIAgriPrepayApply',{
                    editType: edit,
                    prepayNo:$scope.businessNo
                })
            };
        }]);

});