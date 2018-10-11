/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityInformServ = function($http, $q,ApiPath) {
        return {
            /*机构查询*/
            queryCompany:function(CompanyConditionDto){
                console.log(CompanyConditionDto);
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
            /*机构查询*/
            loadCompany:function(CompanyConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryCompanyByComcode,
                    data:CompanyConditionDto
                });
                promise.then(
                    function(answer){
                        console.log(answer);
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    function(error){
                        console.log(error);
                        error.status = false;
                        deferred.reject(error);
                    });
                return deferred.promise;
            },
            /*机构保存*/
            saveCompany:function(PrpDCompanyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveCompany,
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
            /*机构更新*/
            updateCompany:function(PrpDCompanyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.updateCompany,
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
            /*上级机构查询*/
            queryUpperCompany:function(UserDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryUpperCompany,
                    data:UserDto
                });
                promise.then(
                    //通讯成功
                    function(answer){
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    //通讯失败
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });
                return deferred.promise;
            }
        }
    };

    moduleApp.service('communityInformServ',['$http', '$q','ApiPath',communityInformServ]);
});

