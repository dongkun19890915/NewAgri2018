/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportServ = function($http,$q,ApiPath) {
        return {
            //保单综合查询-查询
            reportSearch:function (PolicyQueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryPageInfo,
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
    moduleApp.service('reportServ',['$http','$q','ApiPath',reportServ]);
});


