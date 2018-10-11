
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteSucServ = function($http,$q,ApiPath){
        return {

            // 获取fileId
            getFileId:function (dataEpolicy){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryEpolicyFileId,
                    data:dataEpolicy
                });
                promise.then(
                    //通讯成功
                    function(answer){
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    //通讯失败
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });
                //返回promise对象，交由Controller继续处理
                return deferred.promise;
            },
            //下载文件
            downloadFile:function(fileId){
                window.open(ApiPath.api.downloadFileByShortLinkId+'?shortLinkId='+fileId);
            }

        }
    };

    moduleApp.service('underwriteSucServ',['$http','$q','ApiPath',underwriteSucServ]);
});
