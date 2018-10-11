/**
 * DESC       : 国元农险理赔立案任务---索赔资料清单弹层
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
    app.registerController('UIAgriClaimInforListModelCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$state',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state) {
            $scope.checkEleDocumentFlag = false;
            $scope.$on("SendInforListLayerSwitch",function (event) {
                $scope.checkInforListFlag = !$scope.checkInforListFlag; // 弹层显示隐藏
            })
            $scope.close = function () {
                $scope.checkInforListFlag = false;
            };
            // $scope.claim = {prpLcertifyCollect:{}}; // 查询条件
            // $scope.claim.prpLcertifyCollect.checkList = [1,2]; // 多选
            // $scope.claim.prpLcertifyCollect.flag = true; // 多选
            // $$finder.post("checkBoxList",{}).then(
            //     function (data) {
            //         console.log(data);
            //         $scope.claim.prpLcertifyCollect.checkBoxList = data.content;
            //     }
            // );

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
        }]);
});