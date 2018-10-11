/**
 * Created by zkr10 on 2016/10/8.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityMemberMaintainServHandler = function ($http, $q,ApiPath) {
        return {
            //新增页面初始化查询服务
            communityMemberMaintainInit: function (condition) {
                var deferred = $q.defer();
                var promise = $http({
                    method: 'POST',
                    url: ApiPath.api.queryLateCoinsRate,
                    data: condition
                });
                promise.then(
                    function (answer) {
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    function (error) {
                        error.status = false;
                        deferred.reject(error);
                    });
                return deferred.promise;
            },
            //保存
            communityMemberMaintainSave:function (map){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url: ApiPath.api.saveCoinsRateList,
                    data:map
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
    moduleApp.service('communityMemberMaintainServ',['$http','$q','ApiPath',communityMemberMaintainServHandler]);
});
