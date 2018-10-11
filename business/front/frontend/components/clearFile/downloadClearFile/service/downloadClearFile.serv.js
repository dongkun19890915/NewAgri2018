/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var downloadClearFileServ = function($http, $q, ApiPath) {
        return {
            /*查询清分列表*/
            queryTable:function(conditionDto){
            var deferred = $q.defer();
            var promise = $http({
                method:"Post",
                url:ApiPath.api.downLoadClearFile,
                data:conditionDto
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
            /*根据返回值下载文件*/
            downLoadTableList:function(conditionDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.genClearFileShortLink,
                    data:conditionDto
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
            /*下载文件*/
           downLoadTable:function(shortLink){
               window.open("/comm-fileserver/downloadFileByShortLinkId?shortLinkId="+shortLink);
            }
        }
    };
    moduleApp.service('downloadClearFileServ',['$http','$q','ApiPath',downloadClearFileServ]);
});
