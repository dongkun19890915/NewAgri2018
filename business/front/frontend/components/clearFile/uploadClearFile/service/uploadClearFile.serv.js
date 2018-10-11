/**
 * 
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var uploadClearFileServ = function($http, $q, ApiPath) {
        return {
           saveImgInfo:function (clearExcelDto){
                console.log(JSON.stringify(clearExcelDto));
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.importClaimExcel,
                    data:clearExcelDto
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
    moduleApp.service('uploadClearFileServ',['$http','$q','ApiPath',uploadClearFileServ]);
});
