/**
 * Created by Guoxianglian on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportProposalServ = function($http,$q,ApiPath) {

        var moduleInitData = {
            "riskConfig": {
                "EQ01":[
                    {
                        "name": "bus",
                        "url": "components/prpins/report/tpl/module/busInfo.html",
                        "index": 1
                    },
                    {
                        "name": "base",
                        "url": "components/prpins/report/tpl/module/baseInfo.html",
                        "index": 2
                    },
                    {
                        "name": "apply",
                        "url": "components/prpins/report/tpl/module/applyInfo.html",
                        "index": 3
                    },
                    {
                        "name": "insured",
                        "url": "components/prpins/report/tpl/module/insuredInfo.html",
                        "index": 4
                    },
                    {
                        "name": "fee",
                        "url": "components/prpins/report/tpl/module/feeInfo.html",
                        "index": 5
                    }
                ],
                "EQ02":[
                    {
                        "name": "bus",
                        "url": "components/prpins/report/tpl/module/busInfo.html",
                        "index": 1
                    },
                    {
                        "name": "base",
                        "url": "components/prpins/report/tpl/module/baseInfo.html",
                        "index": 2
                    },
                    {
                        "name": "fina",
                        "url": "components/prpins/report/tpl/module/finaInfo.html",
                        "index": 3
                    },
                    {
                        "name": "apply",
                        "url": "components/prpins/report/tpl/module/applyInfo.html",
                        "index": 4
                    },
                    {
                        "name": "insured",
                        "url": "components/prpins/report/tpl/module/insuredInfo.html",
                        "index": 5
                    },
                    {
                        "name": "fee",
                        "url": "components/prpins/report/tpl/module/feeInfo.html",
                        "index": 6
                    },
                    {
                        "name": "plan",
                        "url": "components/prpins/report/tpl/module/planInfo.html",
                        "index": 7
                    }
                ]
            }
        };

        return {
            //动态获取险种初始化
            moduleInit:function (params){
                var deferred = $q.defer();
                var response = {};
                response.data = moduleInitData;
                deferred.resolve(response);
                /*var urlGetData = "data/reportModule.json";
                var promise  = $http({
                    method:'GET',
                    url:urlGetData,
                    params:params
                });
                promise.then(
                    function(answer){
                        answer.status = true;
                        deferred.resolve(answer);
                    },
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });*/
                return deferred.promise;
            },
            //分页
            queryReportProposal:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.poQueryPolicyInsured,
                    data:prpCmain
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
            //分页
            queryReportTProposal:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryTranPolicyInsured,
                    data:prpCmain
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
            //保单信息
            queryReportPolicyNo:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryPolicy,
                    data:prpCmain
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
            //下载被保险人清单
            downloadInsureds:function(InsuredExportQueryDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"POST",
                    url:ApiPath.api.downloadInsuredsAll,
                    data: InsuredExportQueryDto
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
            //下载导入被保险人错误信息
            downloadExcel:function(shortLinkId){
                window.open(ApiPath.api.downloadFileByShortLinkId+'?shortLinkId='+shortLinkId);
            },
            //投保单信息
            queryReportProposalNo:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryTranPolicy,
                    data:prpCmain
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
            queryReportEndorseTranPolicy:function (prpCmain){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryPolicyInsured,
                    data:prpCmain
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
    moduleApp.service('reportProposalServ',['$http','$q','ApiPath',reportProposalServ]);
});


