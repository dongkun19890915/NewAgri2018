/**
 * Created by zkr22 on 2016/10/20.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var passwdServHandler = function($http,$q,ApiPath){
        return{
        /*校验原密码*/
            checkPasswd:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.checkePwd,
                    data:userDto
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

            /*修改密码*/
            updatePasswd:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.passwdUpdate,
                    data:userDto
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
            /*获取用户信息*/
            querInfoUser:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.queryUserInfo,
                    data:userDto
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

    moduleApp.service('passwdServ',['$http','$q','ApiPath',passwdServHandler]);
});
