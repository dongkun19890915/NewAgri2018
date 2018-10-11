/**
 * Created by ZhangJiansen on 2016/9/20.
 * upload by Guoxianglian on 2016/10/10.
 * url处理工具
 */
define([], function () {
    'use strict';
    function commFactoryHandler($http,$q) {
        return {
            getData:function (url,params){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'GET',
                    url:url,
                    param:params
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
            postObject:function (url,params){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:url,
                    data:params
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
            postData:function (url,params){
            var deferred = $q.defer();
            var promise  = $http({
                method:'POST',
                url:url,
                param:params
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
        };
    }

    return commFactoryHandler;
});