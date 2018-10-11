/**
 * DESC       : 国元农险理赔班表管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.29
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                      班表管理-新增班表页面控制器搭建
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriRecaseSeeCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams','$state','$modal',
        function ($rootScope, $scope, $location, $$finder, $stateParams, $state,$modal) {



           /* $scope.saveRecase = function () {
                $$finder.post('saveReCaseCommittedByReCaseDto', $scope.recaseDto).then(//提交
                    function (data) {

                        layerMsg(data.message);
                        console.log(data);
                       // $scope.String = data.content;
                    }
                );
            };*/

            //审核意见
            /**
             * 审核意见
             */
            $scope.showTraceInfo = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.commonTraceInfo.modal.html',
                    resolve:{
                        queryDto:function () {
                            return angular.copy($scope.recaseDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,queryDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "businessNo": queryDto.claimNo || '',//业务号
                            };
                            $$finder.post('querySwfNotionByFlowId',keywords).then(
                                function (data){
                                    if(data && !data.code&&data.length>0){
                                        $scope.communication = data;
                                        //$scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        layerMsg(data.message);
                                        $scope.closeModal();
                                    }else{
                                        layerMsg("无审核意见！");
                                        $scope.closeModal();
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                }
                            );
                        }
                        init();
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };

            var init = function () {
                $scope.recaseDto={
                    claimNo:$stateParams.claimNo || ""  //立案号
                    // riskCName:"",                    //险种名称
                    // registNo:"",               //报案号
                    // policyNo:"",               //保单号
                    // reCaseReason:"",           //重开赔案原因
                    // compensateNo:""            //赔款计算书号
            };

                if($stateParams.codecode){
                    $scope.codecode = $stateParams.codecode;
                }
                $scope.seeFlag = false;
                if($scope.codecode === "1"){
                    $scope.seeFlag = true;
                }else if($scope.codecode === "3"){
                    $scope.seeFlag = false;
                }

                $$finder.get('queryReCaseByClaimNo', $scope.recaseDto).then(//初始化
                    function (data) {
                        console.log(data);
                        $scope.recaseDto = data.content;
                    }
                );
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                /*$rootScope.back();*/
                $state.go("UIAgriRecase");
            };
            init();

        }]);
});