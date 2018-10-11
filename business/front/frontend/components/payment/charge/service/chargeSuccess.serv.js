/**
 * Created by COCO on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeSuccessServ = function($http, $q, ApiPath) {
        return {
            // 获取fileId
            getFileId:function (policyNo){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryEpolicyFileId,
                    data:{certiNo:policyNo}
                });
                promise.then(
                    function(answer){
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });
                return deferred.promise;
            },

            //下载
            downloadFile:function (shortLinkId){
                window.open(ApiPath.api.downloadFileByShortLinkId+'?shortLinkId='+shortLinkId);
            }
        }
    };

    moduleApp.service('offLineChargeSuccessServ',['$http','$q','ApiPath',offLineChargeSuccessServ]);
});
