/**
 * DESC       : 国元农险理赔并案管理-立案任务处理页面---电子单证弹层
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
    app.registerController('UIAgriCombineEleDocumentModelCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$state',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state) {
            $scope.checkEleDocumentFlag = false;
            $scope.$on("SendEleDocumentLayerSwitch",function (event) {
                $scope.checkEleDocumentFlag = !$scope.checkEleDocumentFlag; // 弹层显示隐藏
            })
            $scope.close = function () {
                $scope.checkEleDocumentFlag = false;
            };
            $$finder.post("prpList",{}).then(
                function (data) {
                    $scope.prpList = data.content;
                }
            )

        }]);
});