/**
 * Created by guoxianglian on 2016/9/18.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var onLineChargeServ = function($http,$q,ApiPath){
        return {
            /*初始化*/
            onLineChargeinitEdit:function (proposalNo){
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

            /* 在线支付 去支付*/
            onLineGoToPay:function (proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.onLineGoToPay,
                    data:proposalDto
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

            // 查看电子投保单
            viewEproposal:function (proposalNo){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.createProposalEdocByKey,
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

            //pdf预览
            pdfViewEproposal:function (proposalNo){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.createProposalEdocByKey,
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
            }
        }
    };

    moduleApp.service('onLineChargeServ',['$http','$q','ApiPath',onLineChargeServ]);
});

