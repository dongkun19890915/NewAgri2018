/**
 * Created by guoxianglian on 2016/10/21.
 */
define(['../module','angular'], function (moduleApp,angular) {
    'use strict';
    var pdfLayerCtrl = function($scope,$stateParams,ApiPath) {

        var fileId = $stateParams.fileId;
        if(angular.isDefined(fileId)){
            $scope.fileUrl = ApiPath.api.downloadFileByShortLinkId+'?shortLinkId=' + fileId + '&type=view&abc.pdf';
            console.log("获取pdf文件地址:",$scope.fileUrl);
        }
    };
    moduleApp.controller('pdfLayerCtrl',['$scope','$stateParams','ApiPath',pdfLayerCtrl]);
});





