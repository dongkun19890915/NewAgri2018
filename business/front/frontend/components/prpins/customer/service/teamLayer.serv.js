/**
 * Created by GuoXiangLian on 2016/9/29.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var teamLayerServ = function($http, $q,ApiPath) {
        return {
            //团体客户搜索
            teamInit:function (teamData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.getCifUnitList,
                    data:teamData
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
    moduleApp.service('teamLayerServ',['$http','$q','ApiPath',teamLayerServ]);
});
