/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityMemberServHandler =function ($http, $q,ApiPath) {
        return {
            communityMemberInit: function (condition) {
                var deferred = $q.defer();
                var promise = $http({
                    method: 'POST',
                    url: ApiPath.api.quereyCoinsRateList,
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

            //成员公司下拉框服务
            companyMemberInit:function(PrpDCompanyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.qeuryPrpDCompanyList,
                    data:PrpDCompanyDto
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
    moduleApp.service('communityMemberServ',['$http','$q','ApiPath',communityMemberServHandler]);
});
