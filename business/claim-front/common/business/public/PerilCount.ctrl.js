/**
 * DESC       : 国元农险理赔系统出险次数弹层（公共）
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
    app.registerController('PerilCountCtrl', ['$rootScope', '$scope', '$location', '$state', '$$finder', 'FormFocus', '$window','$stateParams',
        function ($rootScope, $scope, $location, $state, $$finder, FormFocus, $window ,$stateParams) {
            $scope.RiskInfoResponseList = {};
            //获取已出险信息
            var dto = {
                policyNo: $stateParams.policyNo
            };
            $$finder.post("queryPerilInfo", dto).then(
                function (data) {
                    console.log(data);
                    $scope.RiskInfoResponseList = data.prpLRegistDtoExtList;
                }
            );
            //关闭页面
            $scope.close = function () {
                $window.close();
            };
            // 跳转报案登记页面
            $scope.goRegist=function (item) {
                console.log(item.registNo);
                $state.go("UIAgriRegist",{registNo:item.registNo,editType:"SHOW",policyNo:item.policyNo})
            };

        }]);
});