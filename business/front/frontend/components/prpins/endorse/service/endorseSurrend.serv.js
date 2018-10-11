/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseSurrendServ = function($http,$q,ApiPath){
        return {
            /*surInit:*/
            surInit:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/saveInitEndorse',
                    data:surDto
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
            //退保初始化
            surUpdate:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/backUpdateEndorse',
                    data:surDto
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
            /*退保保存*/
            surSave:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/saveEndorse',
                    data:surDto
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

            /*退保校验身份证*/
            checkIDUpload:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/checkIDUpload',
                    data:surDto
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

            deleteApplyNo:function (deleteData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:'/gscore-pa-web/endorse/deleteEndorse',
                    data:deleteData
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
            /*退款银行初始化*/
            rebackBankInit:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:'/gscore-pa-web/commonSelect/initSelectTag',
                    data:conditionDto
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

    moduleApp.service('endorseSurrendServ',['$http','$q','ApiPath',endorseSurrendServ]);
});
