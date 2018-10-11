/**
 * Created by colorfulcat on 2017/11/12.
 */
require.config({
    baseUrl: '',
    urlArgs: 'v=' + window.CHERRY.version,
    paths: {
        'jquery':'common/js/jquery/jquery.min',
        'angular':'common/js/angular/angular1.2.20.min',
        'angular-ui-router':'common/js/angular-ui-router/angular-ui-router.min',//路由
        'angular-couch-potato':'common/js/angular-couch-potato/angular-couch-potato',
        'angular-ui-tree':'common/js/angular-ui-tree/angular-ui-tree.min',  //机构树插件
        'ui-bootstrap':'common/js/ui-bootstrap/ui-bootstrap.min',
        'ui-bootstrap-tpls':'common/js/ui-bootstrap/ui-bootstrap-tpls-0.11.2',
        'angular-local-storage':'common/js/angular-local-storage/angular-local-storage.min',
        'ui-select' : 'common/js/angular-ui-select/select',
        'jedate':'common/js/angular-jedate/jedate',
        'angular-jedate':'common/js/angular-jedate/angular-jedate',
        'tm.pagination':'common/js/angular-tm-pagination/tm.pagination',
        'base64':'common/js/plupload/Base64',
        'json2':'common/js/plupload/json2',
        'base_64':'common/js/plupload/base_64',
        'md5':'common/js/plupload/md5',
        'plupload':'common/js/plupload/plupload.full.min',
        'layer':'common/js/layer/layer',
        'app':'common/app',             //angular的主moudle路口
        'app-init':'common/app-init',   //angular的主moudle初始化
        'routeDefs':'common/routeconfig', //路由配置
        'mainCtrl':'common/controller/main.ctrl', //angular的控制器总路口
        'constants':'common/constants',
        // 'raphael':'common/js/raphael/raphael',
    // 工具模块
        'utilities': 'common/utilities/utilities',
    //    业务api
        'cherry':'common/api/cherry',
    //    数据
        'angular-mocks':'common/js/angular-mocks/angular-mocks',
        'backend-mocks':'common/mock/backend-mocks',
        'codes':'common/codes.' + window.CHERRY.runMode,
        'config':'common/config.' + window.CHERRY.runMode,
        'jsonDB':'common/mock/data/data',
        'angular-file-upload':'common/js/angular-file-upload/angular-file-upload',
        'encodeUrl':'common/js/sunECM/EncodeUrl.min' // 信雅达影像系统页面调用脚本
    },
    shim: {
        'jquery': {
            exports: 'jquery'
        },
        'angular': {
            exports: 'angular'
        },
        'cherry.finder': {
            exports: 'angular'
        },
        'app': {
            deps: ['angular']
        },
        'app-init': {
            deps: ['angular']
       },
         'mainCtrl': {
            deps: ['angular']
        },
        'routeDefs': {
            deps: ['angular']
        },
        'angular-jedate': {
            deps: ['angular']
        },
        'angular-ui-router': {
            deps: ['angular']
        },
        'angular-couch-potato': {
             deps: ['angular']
         },
        'ui-bootstrap': {
            deps: ['angular']
        },
        'ui-bootstrap-tpls': {
            deps: ['angular']
        },
        'angular-mocks': {
            deps: ['angular']
        },
        'angular-ui-select': ['angular'],
        'jedate': {
            deps: ['jquery']
        },
        'plupload': {
            deps: ['jquery']
        },
        'layer': {
            deps: ['jquery']
         },
        'angular-ui-tree': {
            deps: ['angular']
        },
        'angular-file-upload':{
            deps:['angular']
        },
        // 信雅达影像系统页面调用脚本
        'encodeUrl':{
            deps:['angular']
        }
    },
    priority: [
        'jquery',
        'angular',
        'app-init',
        'mainCtrl',
    ],
    waitSeconds: 250
});

require([
    'jquery',
    'angular',
    'app-init',
    'mainCtrl',
    // 'raphael'
], function ($, angular) {
    angular.element().ready(function () {
        angular.bootstrap(document, ["mc.cherry"]);
    })
});