/**
 * DESC       : 国元农险理赔工作流模板分配弹层
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017/12/18
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriWorkFlowDistributionModelCtrl', ['$rootScope', '$scope', '$location', '$state', '$timeout', '$$finder', 'FormFocus',
        function ($rootScope, $scope, $location, $state, $timeout, $$finder, FormFocus) {
            $scope.workFlowDisDto = {};
            $scope.checkDistributionFlag = false;
            $scope.$on("SendDistributionLayerSwitch", function (event, msg1, msg2) {
                $scope.checkDistributionFlag = !$scope.checkDistributionFlag; // 弹层显示隐藏
                $scope.workFlowDisDto.modelNoHtm = msg1 +"-" +msg2; // 模板
                $scope.workFlowDisDto.modelNo = msg1;  // 后台数据
            });
            //隐藏弹层
            $scope.close = function () {
                $scope.checkDistributionFlag = false;
                $scope.workFlowDisDto.riskCodes={};
                $scope.workFlowDisDto.comCodes={};
            };
            // 确定按钮
            $scope.workFlowDisDto.modelStatus = "1";
            $scope.save = function () {
                if ($scope.workFlowDistributionForm.$valid) {
                    $$finder.post('saveSwfModelUse', $scope.workFlowDisDto).then(
                        function (data) {
                            if(data.code === "9999"){
                                layerMsg("模板分配失败！");
                            }else{
                                layerMsg("模板分配成功！");
                            }
                            FormFocus.focusEle('workFlowDistributionForm');
                        }
                    )
                } else {
                    FormFocus.focusEle('workFlowDistributionForm');
                }
            };
            $scope.insurance=[];

            //模板分配弹层
            $$finder.post("queryByValidStatus", {}).then(
                function (data) {
                    console.log(data);
                    $scope.riskInfos = data.riskInfos;
                    $scope.companyInfos = data.companyInfos;
                    if($scope.riskInfos) {
                        for (var i = 0; i < $scope.riskInfos.length; i++) {
                            $scope.riskInfos[i].codecname = data.riskInfos[i].codecname;
                            $scope.riskInfos[i].codecode = data.riskInfos[i].codecode;
                        }
                    }
                    if($scope.companyInfos) {
                        for (var i = 0; i < $scope.companyInfos.length; i++) {
                            $scope.companyInfos[i].codecname = data.companyInfos[i].codecname;
                            $scope.companyInfos[i].codecode = data.companyInfos[i].codecode;
                        }
                    }
                }
            );

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);
});