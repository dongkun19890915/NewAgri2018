/**
 * Created by ZhangJiansen on 2016/9/11.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var proposalServ = function($http,$q,ApiPath){

        /*后期改为从后台获取数据*/
        var moduleData = {
            "riskConfig": {
                "EQ01":[
                    {
                        "name": "bus",
                        "url": "components/prpins/proposal/tpl/module/busInfo.html",
                        "index": 1
                    },
                    {
                        "name": "base",
                        "url": "components/prpins/proposal/tpl/module/baseInfo.html",
                        "index": 2
                    },
                    {
                        "name": "apply",
                        "url": "components/prpins/proposal/tpl/module/applyInfo.html",
                        "index": 3
                    },
                    {
                        "name": "insured",
                        "url": "components/prpins/proposal/tpl/module/insuredInfo.html",
                        "index": 4
                    },
                    {
                        "name": "fee",
                        "url": "components/prpins/proposal/tpl/module/feeInfo.html",
                        "index": 5
                    }
                ],
                "EQ02":[
                    {
                        "name": "bus",
                        "url": "components/prpins/proposal/tpl/module/busInfo.html",
                        "index": 1
                    },
                    {
                        "name": "base",
                        "url": "components/prpins/proposal/tpl/module/baseInfo.html",
                        "index": 2
                    },
                    {
                        "name": "fina",
                        "url": "components/prpins/proposal/tpl/module/finaInfo.html",
                        "index": 3
                    },
                    {
                        "name": "apply",
                        "url": "components/prpins/proposal/tpl/module/applyInfo.html",
                        "index": 4
                    },
                    {
                        "name": "insured",
                        "url": "components/prpins/proposal/tpl/module/insuredInfo.html",
                        "index": 5
                    },
                    {
                        "name": "fee",
                        "url": "components/prpins/proposal/tpl/module/feeInfo.html",
                        "index": 6
                    },
                    {
                        "name": "plan",
                        "url": "components/prpins/proposal/tpl/module/planInfo.html",
                        "index": 7
                    }
                ]
            }
        };

        return {
            /*动态获取险种初始化*/
            moduleInit:function (params){
                var deferred = $q.defer();
                var response = {};
                response.data = moduleData;
                deferred.resolve(response);
                /*var urlGetData = "data/module.json";
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
            downloadFile:function(fileId){
                window.open(ApiPath.api.downloadFile+'?fileId='+fileId);
            },
            // 查看电子投保单
            viewEproposal:function (proposal){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.createProposalEdocByDto,
                    data:proposal
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
            
            //投保单暂存
            savePause:function (proposal){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.save,
                    data:proposal
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
            //投保单提交
            savePolicy:function (policy){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.submitUndwrt,
                    data:policy
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
            //投保单页面初始化
            initProposal:function (riskCode){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.proInitEdit,
                    data:riskCode
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
            //待处理投保单修改
            supendEdit:function(supendProposalNo){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.initEdit,
                    data:supendProposalNo
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
            //待处理投保单-继续-查询
            queryProposalInfo:function (prpTmainKeyDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.queryProposalByPK,
                    data:prpTmainKeyDto
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
            //待处理投保单-继续-查询
            copyPrpoposalOrPolicy:function (proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.copyProposalOrPolicy,
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
            },

            //被保险人客户搜索
            InsuredNameInit:function (insuredDatas){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.getCifIdvList,
                    data:insuredDatas
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
            //删除投保单
            deletePolicy:function (deleteData){
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
            //下拉菜单
            selectInit:function (Deduction){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.initSelectTag,
                    data:Deduction
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
            //双浏览器校验个单情况下被保险人重复性
            checkTInsuredProp:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.checkTInsuredPropData,
                    data:conditionDto
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
            //EQ02初始化财政补贴比例
            subsidyInit:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.getSubsidyDetail,
                    data:conditionDto
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
            recalculate:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.recalculateFpremium,
                    data:conditionDto
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
            checkSubsidy:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.checkMaxSubsidy,
                    data: {"proposalNo":conditionDto}
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
            delInsured:function (conditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.delBatchTInsured,
                    data: conditionDto
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
    moduleApp.service('proposalServ',['$http','$q','ApiPath',proposalServ]);
});
