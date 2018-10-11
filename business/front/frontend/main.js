/**
 * Created by ZhangJiansen on 2016/9/10.
 * reload by guoxianglian on 2016/9/10.
 * requireJS入口文件
 */
require.config({
    baseUrl: '/frontend',
    urlArgs: 'v='+ window.CACTUS.version,
    paths: {
        /*第三方库文件*/
        'domReady': 'lib/requirejs-domReady/domReady',
        'jquery': 'lib/jquery/jquery.min',
        'angular': 'lib/angular/angular1.2.29.min',
        //'angular': 'lib/angular/angular1.2.20',
        'uiRouter': 'lib/angular-ui-router/angular-ui-router.min',
        'ocLazyLoad':'lib/ocLazyLoad/ocLazyLoad.require.min',
        'ngCookies': 'lib/angular-cookies/angular-cookies',
        'bootstrap': 'lib/bootstrap/bootstrap.min',
        'uiBootstrap': 'lib/ui-bootstrap/ui-bootstrap-tpls.min',
        'ngAnimate': 'lib/angular-animate/angular-animate',
        'tmPagination': 'lib/angular-tm-pagination/tm.pagination.min',
        'jedate': 'lib/angular-jedate/jedate',
        'angular-jeDate': 'lib/angular-jedate/angular-jedate',
        'echarts-all': 'lib/angular-echarts/echarts-all',
        'angular-echarts': 'lib/angular-echarts/angular-echarts',
        'ui-select' : 'lib/angular-ui-select/select',
        'angular-sanitize' : 'lib/angular-sanitize/angular-sanitize.min',
        'angular-file-uplaod':'lib/angular-file-upload/angular-file-upload.min',
        'ngLocalStorage':'lib/angular-local-storage/angular-local-storage.min',
        'angular-ui-tree':'lib/angular-ui-tree/angular-ui-tree.min',  //机构树插件
        //国际化
        'ngTranslate':'lib/angular-translate/angular-translate.min',
        'ngTranslateStorageCookie':'lib/angular-translate-storage-cookie/angular-translate-storage-cookie.min',
        'ngTranslateStorageLocal':'lib/angular-translate-storage-local/angular-translate-storage-local.min',
        'ngTranslateLoaderPartial':'lib/angular-translate-loader-partial/angular-translate-loader-partial.min',
        'ngTranslateLoaderStaticFiles':'lib/angular-translate-loader-static-files/angular-translate-loader-static-files.min',
        'messageformat':'lib/messageformat/messageformat',
        'ngTranslateMessageFormat':'lib/angular-translate-interpolation-messageformat/angular-translate-interpolation-messageformat.min',
        //图片查看
        'lightbox':'lib/lightbox/lightbox',
        'constants':'frame/common/constants',
        'modernizr' : 'lib/modernizr/modernizr-2.0.6.min',
        'placeholder' : 'lib/placeholder',
        'keditor' : 'lib/kindeditor/kindeditor-all-min',
        'keditor-cn' : 'lib/kindeditor/lang/zh-CN',
        /*框架模块入口文件*/
        'framework':'frame/frame.mod',
        'utility': 'utilities/utilities.mod',
        'widget': 'widgets/widgets.mod',
        /*业务模块入口文件*/
        'business': 'components/business.mod',
        'angular-mocks': 'lib/angular-mocks/angular-mocks'
    },
    shim: {
        'angular': {'exports': 'angular'},
        'uiRouter':['angular'],
        'ocLazyLoad':['angular'],
        'ngAnimate':['angular'],
        'ngCookies':['angular'],
        'tmPagination': ['angular'],
        'angular-echarts': ['angular','echarts-all'],
        'angular-sanitize': ['angular'],
        'angular-ui-tree':['angular'],
        'angular-file-uplaod':['angular'],
        'ui-select': ['angular-sanitize'],
        'uiBootstrap':['angular'],
        'ngLocalStorage':['angular'],
        'lightbox':['jquery'],
        'keditor-cn':['keditor'],
        'angular-mocks': ['angular'],
        'ngTranslate': {
            exports: 'ngTranslate',
            deps: ['angular']
        },
        'ngTranslateLoaderStaticFiles': ['angular','ngTranslate'],
        'ngTranslateLoaderPartial':  ['angular','ngTranslate'],
        'ngTranslateStorageLocal': ['angular','ngTranslate'],
        'ngTranslateStorageCookie':['angular','ngTranslate'],
        'messageformat':{exports: 'messageformat'},
        'ngTranslateMessageFormat':['ngTranslate','messageformat']
    },
    priority: [
        'jquery',
        'angular',
        'uiRouter',
        'bootstrap'
    ],
    waitSeconds: 100
});

require([
        'jquery', /*jquery要在前面*/
        'angular',
        'app',
        'route',
        'uiBootstrap',
        'placeholder'
    ],
    function ($, angular) {
        angular.element(document).ready(function () {
            //手工装配Angular APP
            angular.bootstrap(document, ['appIndex']);
            //关闭启动画面
            //$('.splash-window').remove();
        });
    }
);
