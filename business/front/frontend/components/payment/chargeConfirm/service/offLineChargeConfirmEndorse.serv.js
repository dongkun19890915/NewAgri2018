/**
 * Created by COCO on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeConfirmEndorseServ = function($http, $q,ApiPath) {
        return {
            //分页
            comfirmQuery:function (proposalInfoDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryOffLinePayPageInfo,
                    data:proposalInfoDto
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

            //缴费确认
            confirmSave:function (proposalInfoDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.proposalOffLindDoPay,
                    data:proposalInfoDto
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

    moduleApp.service('offLineChargeConfirmEndorseServ',['$http','$q','ApiPath',offLineChargeConfirmEndorseServ]);
});
