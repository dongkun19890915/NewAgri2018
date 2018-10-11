/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var receiptServ = function($http,$q,ApiPath){
        return {
            //索要发票
            receiptSearch:function (PolicyQueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryReceiptPage,
                    data:PolicyQueryConditionDto
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
            onSubmits:function (prpCinvoiceDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.saveInvoice,
                    data:prpCinvoiceDto
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
    moduleApp.service('receiptServ',['$http','$q','ApiPath',receiptServ]);
});
