/**
 * Created by guoxianglian on 2016/10/21.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var chargePdfLayerCtrl = function($rootScope, $scope, $timeout,$window,$stateParams,$state,onLineChargeServ) {
        var init = function(){
            if(angular.isDefined(window.location.href.split('?pdfUrl=')[1])){
                onLineChargeServ.pdfViewEproposal(eval('(' + decodeURIComponent(window.location.href.split('?pdfUrl=')[1])+ ')')).then(
                    function(answer){
                        //applicationServ.downloadFile(answer.data.fileId);
                        if(answer.data != null){
                             $scope.fileUrl = '/comm-fileserver/downloadFileByShortLinkId?shortLinkId=' + answer.data.shortLinkId + '&type=view&abc.pdf';
                            // $rootScope.$broadcast("pdfLayerShow",{"fileId":answer.data.shortLinkId});
                        }else{
                            angular.alert("很抱歉，投保单预览失败！");
                        }
                    },function(error){
                        angular.alert("服务异常，请联系管理员！");
                    }
                );
            }
        };
        init();
    };

    moduleApp.controller('chargePdfLayerCtrl',['$rootScope','$scope','$timeout','$window','$stateParams','$state','onLineChargeServ',chargePdfLayerCtrl]);
});





