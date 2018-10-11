/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var settleReportServ = function($http, $q, ApiPath) {
        return {
            //下载结算表
            queryTable:function(condition){
                console.log(condition);
            var deferred = $q.defer();
            var promise = $http({
                method:"Post",
                url:ApiPath.api.downloadReport,
                data:condition
            });
            promise.then(
                function(answer){
                    answer.status = true;
                    deferred.resolve(answer);
                },
                //通讯失败
                function(error){
                    error.status = false;
                    deferred.reject(error);
                });
            //返回promise对象，交由Controller处理
            return deferred.promise;
            },
            downLoadDocument:function(fileId){
                window.open("/comm-fileserver/downloadFile?fileId="+fileId);
            }
        }
    };

    moduleApp.service('settleReportServ',['$http','$q','ApiPath',settleReportServ]);
});
