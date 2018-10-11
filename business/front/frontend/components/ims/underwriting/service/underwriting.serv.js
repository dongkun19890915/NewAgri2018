/**
 * Created by guoxianglian on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwritingServHandler = function ($http,$q,ApiPath) {
        return {
            /*根据用户获取机构树*/
            getCompanyTree:function(PowerConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.getCompanyTree,
                    data:PowerConditionDto
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
            /*配置用户允许机构*/
            configUserPermitCompany:function(PowerConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.configUserPermitCompany,
                    data:PowerConditionDto
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
    moduleApp.service('underwritingServ',['$http','$q','ApiPath',underwritingServHandler])

});


