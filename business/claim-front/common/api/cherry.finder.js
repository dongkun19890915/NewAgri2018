/**
 */
define([
    'angular',
    'config',
    'constants'
], function (angular, config, constants) {
    /**
     * @ngdoc service
     * @name $$cherry.$$finder
     *
     * @description
     * cherry.finder 提供了对各种信息的查询
     *
     */
    angular.module('cherry.finder', [])
        .constant(
            'finderConfig', {
                TARGET: {
                    //投保单录入
                    PROPOSAL: 'proposal',  //基本信息
                    MAINAGRI: 'mainAgri',   //合同信息
                    PENSES: 'penses'     //其他信息
                }
            }
        )
        .factory('$$finder', ['finderConfig', '$http','$q',
            function (finderConfig, $http, $q) {
                angular.extend(constants.TARGET, finderConfig.TARGET);
                // return {
                //     find: function (target, keywords, options, pagination) {
                //         $http({
                //             method: "POST",
                //             dataType: "JSON",
                //             contentType: "application/json; charset=UTF-8",
                //             url: config.backend.ip + config.backend.proposal,
                //             headers: {},
                //             data: _data
                //         })
                //     }
                // };
                return {
                    get: function (url, params) {
                        var deferred = $q.defer();
                        var promise = $http({
                            method: 'GET',
                            url: config.backend.ip + config.backend[url],
                            params: params
                        });
                        promise.then(
                            //通讯成功
                            function (answer) {
                                answer.status = true;
                                deferred.resolve(answer.data);
                            },
                            //通讯失败
                            function (error) {
                                error.status = false;
                                deferred.reject(error);
                            });
                        //返回promise对象，交由Controller继续处理
                        return deferred.promise;
                    },
                    post: function (url, params) {
                        var deferred = $q.defer();
                        var promise = $http({
                            method: 'POST',
                            url: config.backend.ip + config.backend[url],
                            data: params
                        });
                        promise.then(
                            //通讯成功
                            function (answer) {
                                answer.status = true;
                                if(!answer.data.content){
                                    deferred.resolve(answer.data);
                                }else{
                                    deferred.resolve(answer.data.content);
                                }
                            },
                            //通讯失败
                            function (error) {
                                error.status = false;
                                deferred.reject(error);
                            }
                        );
                        //返回promise对象，交由Controller继续处理
                        return deferred.promise;
                    }
                };
            }])
})
;