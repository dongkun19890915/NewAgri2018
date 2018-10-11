/**
 * Created by zkr10 on 2016/10/6.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var expensesMaintainServHandler = function ($http, $q,ApiPath) {
        return {
            /*保存*/
            expensesSave:function (data){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url: ApiPath.api.saveSalesRate,
                    data:data
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
    moduleApp.service('expensesMaintainServ',['$http','$q','ApiPath',expensesMaintainServHandler]);
});
