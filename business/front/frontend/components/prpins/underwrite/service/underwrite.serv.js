/**
 * Created by Guoxianglian on 2016/9/17.
 * Modify by SunLexi on 2016/10/06.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteServ = function($http,$q,ApiPath) {
        return {
            /*待处理核批查询*/
            approvalSearch:function (EndorseQueryConditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.queryApproval,
                    data:EndorseQueryConditionDto
                });
                promise.then(
                    //通讯成功
                    function (answer) {
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    //通讯失败
                    function (error) {
                        error.status = false;
                        deferred.reject(error);
                    }
                );
                return deferred.promise;
            },

            //校验当前待处理批单是否被占用
            approvalValidate:function (approvalData) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.validateApproval,
                    data:approvalData
                });
                promise.then(
                    function (answer) {
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    function (error) {
                        error.status = false;
                        deferred.reject(error);
                    }
                );
                return deferred.promise;
            }
        }
    };

    moduleApp.service('underwriteServ',['$http','$q','ApiPath',underwriteServ]);
});


