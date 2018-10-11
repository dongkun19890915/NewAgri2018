/**
 * Created by zkr10 on 2016/10/6.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var areaquotaMaintainServHandler = function ($http, $q,ApiPath) {
        return {
            //弹层数据初始化服务
            areaquotaInit:function (condition){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryLateAreaLimit,
                    data:condition
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
            areaquotaMaintainSale:function (condition){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveAreaLimit,
                    data:condition
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
    moduleApp.service('areaquotaMaintainServ',['$http','$q','ApiPath',areaquotaMaintainServHandler]);
});

