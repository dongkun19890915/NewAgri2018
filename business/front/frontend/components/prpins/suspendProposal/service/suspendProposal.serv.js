/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var suspendProposalServ = function($http,$q,ApiPath) {
        return {
            //待处理投保单-查询
            supendProposalQuery:function (proposalInfoDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.querySuspendProposalPageInfo,
                    data:proposalInfoDto
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

            //删除投保单
            deleteProposal:function (deleteData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.deleteProposal,
                    data:deleteData
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
            searchUnderWrtStat:function(proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.searchUnderWrtStat,
                    data:proposalDto
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

    moduleApp.service('suspendProposalServ',['$http','$q','ApiPath',suspendProposalServ]);
});


