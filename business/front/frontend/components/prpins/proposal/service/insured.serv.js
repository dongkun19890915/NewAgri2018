/**
 * Created by ZhangJiansen on 2016/9/13.
 * 被保险人服务
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var insuredServ = function($http,$q,ApiPath){
        return{
            //新增被保险人初始化
            initInsured:function (policy){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.initEdit,
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
            //city
            getLowerAreaCode:function (upperAreaCode){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    dateType:'json',
                    contentType:'application/json',
                    url:ApiPath.api.initSelectTag,
                    params:upperAreaCode
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
            //新增被保险人-确定
            saveInsure:function (insuredProp){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveSingleInsured,
                    data:insuredProp
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
            //被保人查询
            queryInsuredPrp:function (insuredProp){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryInsuredPageInfo,
                    data:insuredProp
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
            //被保人删除
            deleteInsured:function (proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.deleteTinsuredPropByPK,
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
            //被保险人批量导入
            insertInsuredAll:function (insuredImportDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.saveBatchInsureds,
                    data:insuredImportDto
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
            //下载失败信息
            downloadErrFile:function(insuredErrQueryDto){
                var deferred = $q.defer();
                var promise = $http({
                   method:"POST",
                   url:ApiPath.api.queryBatchImportErr,
                   data: insuredErrQueryDto
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
            //下载被保险人模板
            downloadExcModel:function(riskCode){
                var deferred = $q.defer();
                var modelType = 'insuredsImport';
                var promise = $http({
                    method:"POST",
                    url:ApiPath.api.downloadModel+'?modelType='+modelType+"&riskCode="+riskCode
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
            //查询导入进度
            queryImportResult:function(insuredImportDto){
                var deferred = $q.defer();
                var promise = $http({
                    method:"POST",
                    url:ApiPath.api.queryImportResult,
                    data: insuredImportDto
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
            /*被保险人清单上传*/
            uploadFile:function (teamData){
                var deferred = $q.defer();
                var promise  = $http({
                    method:"POST",
                    url:ApiPath.api.uploadFile,
                    enctype:'multipart/form-data',
                    data:teamData,
                    headers: {
                        'Content-Type': undefined
                    },transformRequest:function(data, headersGetter){
                        var formData = new FormData();
                        angular.forEach(data, function (value, key) {
                            formData.append(key, value);
                        });
                        return formData;
                    }
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
            queryImportErrHis:function(queryErrConditionDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryImportErrHis,
                    data:queryErrConditionDto
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
            //被保险人模板下载
            downloadExcelModel:function (){
                var modelType = 'insuredsImport';
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.downloadModel,
                    enctype:'multipart/form-data',
                    data:modelType
                });
                promise.then(
                    function(answer){
                        if(undefined != answer.resultCode && '0000' == answer.resultCode){
                            answer.status = true;
                            var shortLinkId = answer.data.shortLinkId;
                            downloadExcel(shortLinkId);
                        }else{
                            angular.alert(answer.resultMessage);
                        }
                        deferred.resolve(answer);
                    },
                    function(error){
                        error.status = false;
                        deferred.reject(error);
                    });
                return deferred.promise;
            },
            //被保险人批量删除
            deleteInsuredAll:function (prpTinsuredPropDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.deleteInsured,
                    data:prpTinsuredPropDto
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
            //被保险人修改
            queryInsure:function (prpTinsuredPropDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryTInsuredPropInfo,
                    data:prpTinsuredPropDto
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
            //更新获取最新保额保费信息
            calAmountAndPremium:function (proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.summaryItemProp,
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
            //EQ02缴费计划
            subsidyPlan:function (proposalDto){
                var deferred = $q.defer();
                var promise  = $http({
                    method:'POST',
                    url:ApiPath.api.queryPayInfo,
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
        };
    };
    moduleApp.service('insuredServ',['$http','$q','ApiPath',insuredServ]);
});
