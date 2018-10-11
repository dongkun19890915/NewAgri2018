/**
 * Created by GuoXiangLian on 2016/9/29.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var cusLayerServ = function($http, $q,ApiPath) {
        return {
            //个人客户搜索
            personInit:function (personalData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.getCifIdvList,
                    data:personalData
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

    moduleApp.service('cusLayerServ',['$http','$q','ApiPath',cusLayerServ]);
});
