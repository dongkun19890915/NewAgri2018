/**
 * 
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var dataRectificationServ = function($http, $q, ApiPath) {
        return {
            dataCheck:function(conditionDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.checkExceptionData,
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
            /*异常数据矫正*/
            dataPost:function(conditionDto1){
            var deferred = $q.defer();
            var promise = $http({
                method:"Post",
                url:ApiPath.api.dealExceptionData,
                data:conditionDto1
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

    moduleApp.service('dataRectificationServ',['$http','$q','ApiPath',dataRectificationServ]);
});
