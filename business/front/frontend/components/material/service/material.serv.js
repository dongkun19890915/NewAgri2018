/**
 * Created by zkr22 on 2016/10/21.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var materialServ = function($http, $q,ApiPath) {
        return {
        /*查询服务*/
            fileQuery:function(fileDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.queryFile,
                    data:fileDto
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
            },

            /*删除服务*/
            deleteFile:function(fileDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.deleteFile,
                    data:fileDto
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

            /*上传文件服务*/
            uploadFile:function(teamData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.uploadFile,
                    enctype:'multipart/form-data',
                    data:teamData,
                    headers: {
                        'Content-Type': undefined
                    },transformRequest:function(data, headersGetter){
                        var formData = new FormData();
                        angular.forEach(data, function (value, key) {
                            formData.append(key, value);
                        });
                        return formData;
                    }
                });
                promise.then(
                    //通讯成功
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

            /*保存fileId服务*/
            saveFileId:function(fileDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.saveFileId,
                    data:fileDto
                });
                promise.then(
                    function(answer){
                        console.log(answer);
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

    moduleApp.service('materialServ',['$http','$q','ApiPath',materialServ]);
});
