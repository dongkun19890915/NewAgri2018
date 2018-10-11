/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var expensesServHandler =function ($http, $q,ApiPath) {
        return {
            //查询
            expensesInit:function (condition){
                console.log(JSON.stringify(condition));
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url: ApiPath.api.quereySalesRateList,
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
            /*获取险种*/
            riskQuery:function(Condition){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.getRiskList,
                    data:Condition
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
    moduleApp.service('expensesServ',['$http','$q','ApiPath',expensesServHandler]);
});