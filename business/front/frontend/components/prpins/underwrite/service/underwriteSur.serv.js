/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteSurServ = function($http,$q,ApiPath) {
        return {
            //退保批改数据查询
            surrenderSearch: function (EndorseQueryConditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.querySurrender,
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
            /*下载被保险人清单*/
            downloadInsureds:function(InsuredExportQueryDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"POST",
                    url:'/gscore-pa-web/insured/downloadInsuredsAll',
                    data: InsuredExportQueryDto
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
            /*下载清单*/
            downloadExcel:function(shortLinkId){
                window.open('/comm-fileserver/downloadFileByShortLinkId?shortLinkId='+shortLinkId);
            },
            //核批放弃
            giveUpClick: function (EndorseQueryConditionDto) {
                var deferred = $q.defer();
                var promise = $http({
                    method:'POST',
                    url:ApiPath.api.surrenderGiveUp,
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
            }
        }
    };
    moduleApp.service('underwriteSurServ',['$http','$q','ApiPath',underwriteSurServ]);
});


