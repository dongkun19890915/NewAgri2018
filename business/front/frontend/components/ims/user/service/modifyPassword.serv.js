/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var modifyPasswordServ =  function ($http, $q,ApiPath) {
        return {
        /*确定按钮*/
            updatePassWord:function(userDto){
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
                    }
                );
                return deferred.promise;
            }
        }
    };
    moduleApp.service('modifyPasswordServ',['$http','$q','ApiPath',modifyPasswordServ]);
});

