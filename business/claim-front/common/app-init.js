/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'routeDefs',
    'angular-ui-tree'
], function (app, constants, layer) {

    /**
     * @desc 主模块的运行块
     */
    app.run(['$couchPotato', '$state', '$stateParams', '$rootScope',
        function ($couchPotato, $state, $stateParams, $rootScope) {

            app.lazy = $couchPotato;//懒装载
            $rootScope.$state = $state;//根scope获取路由信息
            $rootScope.$stateParams = $stateParams;//根scope获取路由参数信息
        }
    ]);
    /**
     * @desc 离开时做拦截
     */
    app.run(['$state', '$stateParams', '$rootScope', '$location',
        function ($state, $stateParams, $rootScope, $location) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
            $rootScope.SHOWMENU = true; // 控制菜单显示隐藏
            /*离开页面时做提示*/
            $rootScope.$on('$stateChangeStart',
                function (event, toState, toParams, fromState, fromParams, options) {
                if("pdf" ===toState.name||"PerilCount"===toState.name){
                    $rootScope.SHOWMENU = false;
                }else {
                    $rootScope.SHOWMENU = true;

                }


                }
            );
            $rootScope.$on('$stateChangeSuccess',
                function (event, toState, toParams, fromState, fromParams, options) {
                    console.log("跳转成功:",toState)
                }
            );
        }
    ]);
    //禁用ie的 ajax request caching
    app.config(['$httpProvider','treeConfig',function($httpProvider,treeConfig){
        if (!$httpProvider.defaults.headers.get) {
            $httpProvider.defaults.headers.get = {};
        }
        treeConfig.defaultCollapsed = true;     //true折叠，false展开
        // Enables Request.IsAjaxRequest()
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        $httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
        $httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
        $httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
    }]);
    /*初始化本地存储服务*/
    app.config(['localStorageServiceProvider',function(localStorageServiceProvider){
        localStorageServiceProvider.setPrefix(""); //constants.APP.APP_CODE
    }]);
    /**
     * @desc 主模块的初始配置
     */
    app.config(['$httpProvider', function ($httpProvider) {

        //解决跨域问题
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];

        //拦截器
        $httpProvider.interceptors.push(function ($rootScope, $location, $window, $timeout) {

            return {
                'request': function (config) {
                        return config;
                },
                'requestError': function (rejection) {

                    return rejection;
                },
                'response': function (response) {
                    return response;
                },
                'responseError': function (rejection) {
                    if(rejection.status === 401) {
                        redirectURL = rejection.headers(constants.HEADERS.AUTH_URL_NAME);
                        if(redirectURL) {
                            console.log("未被授权的操作,准备跳转:"+redirectURL+ $location.absUrl());
                            $window.location.href = redirectURL+ $location.absUrl();
                        }else{
                            layerMsg("未被授权的操作");
                        }
                    }else if (rejection.status === 300){
                        $timeout(function () { // 等待cookie清除
                            redirectURL = rejection.headers(constants.HEADERS.AUTH_OUT_URL_NAME);
                            if(redirectURL) {
                                // 用户退出登录
                                $window.location.href = redirectURL + '?ReturnUrl='+ $location.absUrl();
                            }else{
                                layerMsg("系统异常")
                            }
                        })

                    }else if (rejection.status === 404){

                    }else if (rejection.status === 405){

                    }else if (rejection.status === 504){

                    }
                    // 服务器异常
                    $rootScope.$broadcast(constants.EVENTS.BACKEND_EXCEPTION, {
                        code: 500,
                        message: rejection.config.data.method + '服务器系统异常，请联系管理员'
                    });

                    return rejection;
                }
            };
        });

        layer.config({
            path: 'common/js/layer/'      //layer.js所在的目录，可以是绝对目录，也可以是相对目录
        });

    }]);

});