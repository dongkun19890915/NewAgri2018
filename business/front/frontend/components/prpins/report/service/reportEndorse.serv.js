/**
 * Created by Guoxianglian on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportEndorseServ = function($http,$q,ApiPath) {
        return {
            endorseSearch:function (EndorseHistoryDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryEndorseHistory,
                    data:EndorseHistoryDto
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
            endorsequeryPrePolicy:function (EndorseHistoryDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryPreEndorse,
                    data:EndorseHistoryDto
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
            //保单信息
            queryEndorseTranPolicy:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryEndorseTranPolicy,
                    data:prpCmain
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
            queryReportEndorseTranPolicy:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryPolicyInsured,
                    data:prpCmain
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

    moduleApp.service('reportEndorseServ',['$http','$q','ApiPath',reportEndorseServ]);
});


