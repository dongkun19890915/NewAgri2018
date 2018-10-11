/**
 * Created by guoxianglian on 2016/9/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var onLineChargeLayerServ = function($http,$q,ApiPath){
        return {
            //查询支付结果
            queryPayResult:function (policyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryOnLinePayStatus,
                    data:policyDto
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

    moduleApp.service('onLineChargeLayerServ',['$http','$q','ApiPath',onLineChargeLayerServ]);
});

