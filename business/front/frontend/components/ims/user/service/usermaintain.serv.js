/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var  usermaintainServ = function ($http, $q,ApiPath) {
        return {
            /*修改*/
            updateUser:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.userUpdate,
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
                    }
                );
                return deferred.promise;
            },
            /*保存*/
           saveUser:function(userDto){
               var deferred = $q.defer();
               var promise = $http({
                   method:'POST',
                   url:ApiPath.api.userSave,
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
                   }
               );
               return deferred.promise;
            },
            /*获取用户信息*/
            queryInfoUser:function(userDto){
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
            },
            /*校验账号*/
            checkUserCode:function(userDto){
              var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.checkUserCode,
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
                    }
                );
                //返回promise对象，交由Controller处理
                return deferred.promise;
            },
            //省级机构查询
            proviceComCodeQuery:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.queryDownComCode,
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
            //所属保险公司
            queryHeacComCode: function (userDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.queryHeadComCode,
                    data:userDto
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
            //配置岗位服务
            configGrade: function(UserGradeConditionDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.configUserGrade,
                    data:UserGradeConditionDto
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
            //岗位查询
            queryListGrade: function (userDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.queryGradeList,
                    data:userDto
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
            /*查询现有岗位*/
            gradeQuery:function(userDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"Post",
                    url:ApiPath.api.queryGradeList,
                    data:userDto
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
            }
        }
    };
    moduleApp.service('usermaintainServ',['$http','$q','ApiPath',usermaintainServ]);
});

