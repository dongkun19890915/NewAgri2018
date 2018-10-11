/**
 * Created by GuoXiangLian on 2016/9/18.
 * 在线支付控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorsePublicSuccessCtrl = function($scope,$sce,$state,endorseSuccessServ,$stateParams) {
        //$scope.title='新增批改';
        $scope.msg =$sce.trustAsHtml($stateParams.msg);
        var applyNo = $stateParams.applyNo;
        var endorType = $stateParams.endorType;
        $scope.showAlertOneLayer = false;
        /*$scope.iconFlag = true;

        if(endorType == '02'){
            $scope.iconFlag = false;
        }*/

        /*if (endorType == '03' || endorType == '02'){
            $scope.downLoadFileButton = false;
        }else{
            $scope.downLoadFileButton = true;
        }*/

        $scope.showAlertOnlyOneClose=function() {
            $scope.showAlertOneLayer = false;
        };


        // 下载电子批单
        $scope.dowloadEndorseFile=function(idType){
            var data = {};
            data.certiNo = applyNo;
            data.idType = idType;
            endorseSuccessServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    console.log("shortLinkId==="+shortLinkId);
                    if(shortLinkId){
                        endorseSuccessServ.downloadFile(shortLinkId);
                    }else{
                        $scope.showAlertMsg = '正在生成电子批单，请稍后再试';
                        $scope.showAlertOneLayer = true;
                    }
                },
                function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        $scope.exitEndorse=function(){
            $state.go("main.index");
        }
    };
    moduleApp.controller('endorsePublicSuccessCtrl',['$scope','$sce','$state',
        'endorseSuccessServ','$stateParams',endorsePublicSuccessCtrl]);
});
