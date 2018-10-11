/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块新增批改控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseInsuredServ = function($http,$q){

        return {
            /*被保险人-初始化*/
            endorseInsuredSearch:function (insuredFuzzyQueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:'/gscore-pa-web/insured/queryFuzzyCopyInsuredPropPage',
                    data:insuredFuzzyQueryConditionDto
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
            //返回修改
            surUpdate:function (surDto){
                console.log(JSON.stringify(surDto)+'=======');
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/backUpdateEndorse',
                    data:surDto
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
            deleteApplyNo:function (deleteData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:'/gscore-pa-web/endorse/deleteEndorse',
                    data:deleteData
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
            //更改被保险人初始化
            endorseInsuredUpdate:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/saveInitEndorse',
                    data:surDto
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
            /*被保险人不允许无序批改*/
            endorseStatusValid:function (QueryConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/insured/endorseStatusValid',
                    data:QueryConditionDto
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
            /*被保险人修改*/
            endorseUpdate:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/insured/queryCopyInsuredPropInfo',
                    data:surDto
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
            /*被保险人确定*/
            endorseInsureOk:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/insured/saveEInsuredPropForSingle',
                    data:surDto
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
            /*被保险人保存*/
            saveEndorseInsure:function (surDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:'/gscore-pa-web/endorse/saveEndorse',
                    data:surDto
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
            /*被保险人下一步*/
            endorseInsureNext:function (surDto){
            var deferred = $q.defer();
            var promise  = $http({
                method:'POST',
                url:'/gscore-pa-web/endorse/saveEndorse',
                data:surDto
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
            /*下载导入被保险人错误信息*/
            downloadExcel:function(shortLinkId){
                window.open('/comm-fileserver/downloadFileByShortLinkId?shortLinkId='+shortLinkId);
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
        }

        }
    };

    moduleApp.service('endorseInsuredServ',['$http','$q',endorseInsuredServ]);
});
