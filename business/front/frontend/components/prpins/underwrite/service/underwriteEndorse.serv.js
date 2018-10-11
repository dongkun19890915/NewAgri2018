/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteEndorseServ = function($http,$q,ApiPath) {
        return {
            //退保批改确认信息查询
            surrenderConfirm: function (EndorseQueryConditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.surrenderConfirm,
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

            //查看核批记录
            uwNotionSeach: function (EndorseQueryConditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.queryAllOpinions,
                    data:EndorseQueryConditionDto
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
            },
            onSubmits: function (uwNotionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.updateEndorseDecide,
                    data:uwNotionDto
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
    moduleApp.service('underwriteEndorseServ',['$http','$q','ApiPath',underwriteEndorseServ]);
});


