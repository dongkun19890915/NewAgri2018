/**
 * Created by GuoXiangLian on 2016/10/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var genSettleReportServ = function($http, $q, ApiPath) {
        return {
            //生成结算表
            createTable:function(condition1){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:'/gscore-pa-web/report/buildReport',
                    data:condition1
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

    moduleApp.service('genSettleReportServ',['$http','$q','ApiPath',genSettleReportServ]);
});
