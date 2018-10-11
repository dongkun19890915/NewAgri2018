/**
 * DESC       : 国元农险理赔立案任务---电子单证弹层
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
    app.registerController('UIAgriClaimEleDocumentModelCtrl', ['$rootScope', '$scope', '$location', '$$finder', 'regexpConstants', '$state', '$interval', '$filter', 'FormFocus',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state, $interval, $filter, FormFocus) {
            $scope.checkEleDocumentFlag = false;
            $scope.$on("SendEleDocumentLayerSwitch", function (event) {
                $scope.checkEleDocumentFlag = !$scope.checkEleDocumentFlag; // 弹层显示隐藏
            })
            $scope.close = function () {
                $scope.checkEleDocumentFlag = false;
            };
            // $$finder.post("prpList",{}).then(
            //     function (data) {
            //         $scope.prpList = data.content;
            //     }
            // )
            // 理赔联系记录
            $scope.prpList = [];
            //添加
            $scope.add = function () {
                var today = new Date();
                $scope.prpList.push({
                    now: $filter('date')(today, 'yyyy-MM-dd hh:mm:ss')
                });
            }
            //删除
            $scope.del = function ($index) {
                $scope.prpList.splice($index, 1);
            }
            //单证上传弹层显示
            $scope.goUpload = function () {
                $scope.checkShowFlag = true;
                $scope.checkEleDocumentFlag = false;
            }
            $scope.checkShowFlag = false;
            // 隐藏单证上传弹层
            $scope.closeShow = function () {
                $scope.checkShowFlag = false;
            };
            // //单证类型
            // $$finder.post("checkBox", {}).then(
            //     function (data) {
            //         console.log(data.content);
            //         $scope.checkBox = data.content;
            //         console.log($scope.checkBox);
            //     }
            // )
            //点击上传
            // $scope.upload = function () {
            //     if ($scope.uploadForm.$valid) { // 校验通过
            //         if ($scope.checkedList === null || $scope.checkedList.length == 0) {
            //             return false;
            //         }
            //     } else { // 校验未通过
            //         return false;
            //     }
            // }

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };


        }]);
});