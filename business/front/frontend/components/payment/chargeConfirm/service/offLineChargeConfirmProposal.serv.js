/**
 * Created by COCO on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeConfirmProposalServ = function($http, $q, ApiPath) {
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
            },

            //缴费确认
            savePayExch:function (payExchDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/payexch/savePayExch',
                    data:payExchDto
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

            //分页
            queryReportTProposal:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryTranPolicyInsured,
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

            //投保单信息
            queryReportProposalNo:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryTranPolicy,
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

    moduleApp.service('offLineChargeConfirmProposalServ',['$http','$q','ApiPath',offLineChargeConfirmProposalServ]);
});
