
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteSucCtrl = function($scope,$state,underwriteSucServ,$stateParams,$sce) {

       // $scope.msg = $stateParams.msg;
        $scope.msg =$sce.trustAsHtml($stateParams.msg);
        var applyNo = $stateParams.applyNo;
        var handleType = $stateParams.handleType;
        var endorType = $stateParams.endorType;
        $scope.downLoadFileButton = true;
        $scope.showAlertOneLayer = false;

        if(endorType){
            if(endorType == '03'){
                $scope.downLoadFileButton = false;
            }
        }
        if(handleType == '1' || handleType == '2'){
            $scope.downLoadFileButton = false;
        }

        $scope.nuclearTitl="批单成功";
        $scope.nuclearPic=true;
        if(handleType=="2" || handleType=="1"  ){
            $scope.nuclearTitl="核批完成";
            $scope.nuclearPic=false;
        }

        //点击返回跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };

        $scope.showAlertOnlyOneClose=function() {
            $scope.showAlertOneLayer = false;
        };
        
        // 下载电子批单
        $scope.dowloadEndorseFile=function(idType){
            var data = {};
            data.certiNo = applyNo;
            data.idType = idType;
            underwriteSucServ.getFileId(data).then(
                function(answer){
                    var shortLinkId = answer.data.shortLinkId;
                    if(shortLinkId){
                        underwriteSucServ.downloadFile(shortLinkId);
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
    };

    moduleApp.controller('underwriteSucCtrl',['$scope','$state','underwriteSucServ','$stateParams','$sce',underwriteSucCtrl]);
});