/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseBusinessServ = function($http,$q,ApiPath){
        return {
            //surInit:
            surInit:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveInitEndorse,
                    data:surDto
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
            //返回修改
            surUpdate:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.backUpdateEndorse,
                    data:surDto
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
            //保存
            surSave:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveEndorse,
                    data:surDto
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

    moduleApp.service('endorseBusinessServ',['$http','$q','ApiPath',endorseBusinessServ]);
});
