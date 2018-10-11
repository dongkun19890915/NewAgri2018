/**
 * Created by ZhouJianLong on 2016/9/28.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var documentServ = function($http,$q,ApiPath) {
        return {
            /*电子保单*/
            documentSearch:function (EpolicyQueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryEpolicyPage,
                    data:EpolicyQueryConditionDto
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
            /*下载文件*/
            downloadFile:function(fileId){
                window.open(ApiPath.api.downloadFileDoc+'?fileId='+fileId);
            },
            /*电子批单查询*/
            documentEndorseSearch:function (EendorseQueryConditionDto){
            var deferred = $q.defer();
            var promise  = $http({
                method:"POST",
                url:ApiPath.api.queryEendorsePage,
                data:EendorseQueryConditionDto
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
            }
        }
    };
    moduleApp.service('documentServ',['$http','$q','ApiPath',documentServ]);
});


