/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var newEndorseLayerServ = function($http,$q,ApiPath){
        return {
            //批改申请查询
            endorseSearch:function (PolicyQueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.forEndorse,
                    data:PolicyQueryConditionDto
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

    moduleApp.service('newEndorseLayerServ',['$http','$q','ApiPath',newEndorseLayerServ]);
});
