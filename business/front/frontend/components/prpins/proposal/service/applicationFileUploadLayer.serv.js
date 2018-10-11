/**
 *文件上传
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var applicationFileUploadLayerServ = function($http, $q, ApiPath) {
        return {
            uploadFile:function (teamData){
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
                    //通讯失败
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });
                //返回promise对象，交由Controller继续处理
                return deferred.promise;
            },
            /*文件上传*/
            queryUploadFileList:function (imgFileData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryImgFilePage,
                    data:imgFileData
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
                //返回promise对象，交由Controller继续处理
                return deferred.promise;
            },
            /**/
            saveImgInfo:function (imgFileData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.saveImageFile,
                    data:imgFileData
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
            /*个人客户搜索*/
            deleteImgFile:function (d){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.deleteImgFile,
                    data:d
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
                    url:'/gscore-pa-web/epolicy/createPayNoticeEdocByKey',
                    data:prpTmainKeyDto
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
                //返回promise对象，交由Controller继续处理
                return deferred.promise;
            }
        }
    };
    moduleApp.service('applicationFileUploadLayerServ',['$http','$q','ApiPath',applicationFileUploadLayerServ]);
});
