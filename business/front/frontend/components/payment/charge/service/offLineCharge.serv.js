/**
 * Created by COCO on 2016/9/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeServ = function($http,$q,ApiPath){
        return {
            /*初始化*/
            offLineChargeinitEdit:function (proposalNo){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryPayInfo,
                    data:proposalNo
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

            downAdviceNote:function (prpTmainKeyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.createPayNoticeEdocByKey,
                    data:prpTmainKeyDto
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

    moduleApp.service('offLineChargeServ',['$http','$q','ApiPath',offLineChargeServ]);
});
