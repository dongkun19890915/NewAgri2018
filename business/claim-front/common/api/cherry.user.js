/**
 * DESC       : 国元农险用户权限
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2018/1/8
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define(['angular','config', 'constants'], function (angular, config, constants) {
    angular.module('cherry.user', [])
        .factory('$$user', ['$rootScope', '$http','$location', '$timeout', '$q', 'localStorageService', '$state',
            function ($rootScope, $http, $location, $timeout, $q, localStorageService, $state) {
                var User = function () {
                    this.userCode = '';
                    this.userName = '';
                    this.loginComCode = '';
                    this.roles = [];
                    this.rememberMe = false;
                    this.token = '';
                };
                User.prototype.logout = function () {
                    var _self = this;
                    if (!_self.rememberMe) {
                        _self.userCode = _self.loginComCode = '';
                        _self.userName = '';
                    }
                    _self.token = '';
                    updateUserInLocalStorage(_self);
                    clearCookies();
                    refreshUser(_self);
                };

                User.prototype.isLogin = function () {
                    return (!this.userCode) ? false : true;
                };
                var clearCookies = function () {
                    console.log("清除cookie:" + localStorageService.cookie.get(constants.HEADERS.COOKIE));
                    localStorageService.cookie.clearAll();
                };
                var updateUserInLocalStorage = function (_user) {
                    var _userInLocalStorage = {};
                    _userInLocalStorage.userCode = _user.userCode;
                    _userInLocalStorage.userName = _user.userName;
                    _userInLocalStorage.loginComCode = _user.loginComCode;
                    _userInLocalStorage.roles = _user.roles;
                    _userInLocalStorage.rememberMe = _user.rememberMe;
                    _userInLocalStorage.token = _user.token;
                    localStorageService.set(constants.STOREUSER.USER, _userInLocalStorage);
                };
                var user = new User();

                var refreshUser = function (_user) {
                    if (_user) {
                        user.userCode = _user.userCode;
                        user.userName = _user.userName;
                        user.loginComCode = _user.loginComCode;
                        user.roles = _user.roles;
                        user.rememberMe = _user.rememberMe;
                        user.token = _user.token;
                    }
                    $rootScope.user = user;
                };

                var init = function () {
                    var _userInLocalStorage = localStorageService.get(constants.STOREUSER.USER);
                    refreshUser(_userInLocalStorage);
                };

                init();

                var setStorages = function (key, data) {
                    localStorageService.set(key, data);
                };
                return {
                    //获取本地用户信息
                    getUser: function () {
                        return user;
                    },

                    //配合单点登录，从后台获取已登录的用户信息
                    getLoginUser: function () {
                        var deferred = $q.defer();
                        var promise = $http({
                            method: 'GET',
                            url: config.backend.ip + config.backend.userInfo
                        }).then(
                            //通讯成功
                            function (data) {

                                if(data.data.content){
                                    var _user = data.data.content.userInfo;
                                    user.userCode = _user.userCode;
                                    user.userName = _user.userName;
                                    user.loginComCode = _user.loginComCode;
                                    // user.roles = [constants.ROLE.NB];
                                    user.token = data.data.token;
                                    updateUserInLocalStorage(user);
                                    refreshUser(user);
                                    deferred.resolve(data);
                                }

                            },
                            //通讯失败
                            function (error) {
                                deferred.reject(error);
                            }
                        );
                        return deferred.promise
                    },
                    //登出
                    logout: function () {
                        var deferred = $q.defer();
                        $http({
                            method: 'GET',
                            url:  config.backend.ip + config.backend.logout
                        }).then(
                            function (data) {
                                user.logout(); //清除本地存储
                                deferred.resolve(data);
                            }, function (error) {
                                user.logout(); //清除本地存储
                                deferred.reject(error);
                           }
                        );
                        return deferred.promise
                    },
                    //清除token
                    clearToken: function () {
                        user.token = '';
                        setStorages(constants.STOREUSER.USER, user);//更新缓存
                        clearCookies();
                    }
                };
            }]);
})