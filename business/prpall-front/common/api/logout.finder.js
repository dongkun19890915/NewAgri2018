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
    angular.module('logout.finder', [])
        .constant(
            'loginConfig', {
                TARGET: {
                    LOGOUT:"logout",//注销
                    LOGINTODO:"loginToDo"//登录
                }
            })
        .factory('$$logout', ['loginConfig', '$http',
            function (loginConfig, $http) {
                angular.extend(constants.LOGIN, loginConfig.TARGET);
                return {
                    find: function (target,keywords,options) {
                        var getKeyWords = function () {
                            method.data=method.data||{}
                            for (var val in keywords) {
                                method.data.val = keywords.val
                            }
                        }
                        var method = {
                            method: "GET",
                            contentType: "application/json; charset=UTF-8",
                            headers: {},
                        }
                        //注销
                        if (target == constants.LOGIN.LOGOUT) {
                            method.url = '/logout';//config.backend.ip + config.backend.logout;
                            console.log("____________________________________")
                        }
                        //登录
                        if (target == constants.LOGIN.LOGINTODO) {
                            method.url = 'http://192.168.0.53:9005/login?ReturnUrl=http://127.0.0.1:8888'
                            console.log("++++++++++++++++++++++++++++")
                        }

                        $http(method).then(function(a,b,c,d){
                            console.log(a)
                            console.log(b)
                            console.log(c)
                            console.log(d)
                        })


                    }
                }
            }
        ])
})