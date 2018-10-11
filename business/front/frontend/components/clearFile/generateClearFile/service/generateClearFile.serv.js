/**
 * Created by GuoXiangLian on  2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var generateClearFileServ = function($http, $q, ApiPath) {
        return {
            generateClearCheck:function(conditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method: "Post",
                    url:ApiPath.api.checkReclear,
                    data: conditionDto
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
            generateClearSearchTable:function(conditionDto1) {
                var deferred = $q.defer();
                var promise = $http({
                    method: "Post",
                    url:ApiPath.api.reclear,
                    data: conditionDto1
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
            }
        }
    };

    moduleApp.service('generateClearFileServ',['$http','$q','ApiPath',generateClearFileServ]);
});
