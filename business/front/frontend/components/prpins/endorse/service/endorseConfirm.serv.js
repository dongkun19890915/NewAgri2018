/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseConfirmServ = function($http,$q,ApiPath){
        return {
            submitEndorse:function (endorDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.submitEndorse,
                    data:endorDto
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
            deleteApplyNo:function (deleteData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.deleteEndorse,
                    data:deleteData
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
            }
        }
    };

    moduleApp.service('endorseConfirmServ',['$http','$q','ApiPath',endorseConfirmServ]);
});
