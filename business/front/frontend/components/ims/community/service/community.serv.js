/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityServ = function($http, $q,ApiPath) {
        return {
            /*机构查询*/
            queryCompany:function(CompanyConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryCompany,
                    data:CompanyConditionDto
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
            /*上级机构查询*/
            upperCompanyQuery:function(UserDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryUpperCompany,
                    data:UserDto
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

    moduleApp.service('communityServ',['$http', '$q','ApiPath',communityServ]);
});

