/**
 * DESC       : 国元农险理赔立案任务查询---申请注销/拒赔页面
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
    app.registerController('UIAgriClaimRejectCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$stateParams',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $stateParams) {


            $$finder.post("queryClaimCancelDetail",$stateParams.cancelDto).then(
                function (data) {
                    console.log(data);
                    $scope.rejectList = data.content;
                }
            );
            // 电子单证弹层
            /**
             * 电子单证
             */
            $scope.showElectronicDocu = function () {
                $modal.open({
                    templateUrl:'common/business/claim/model/UIAgriClaim.EleDocument.model.html',
                    resolve:{
                        items : function(){
                            return '';
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };



        }]);
});