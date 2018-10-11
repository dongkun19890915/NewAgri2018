/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'jquery',
    'angular',
    'angular-couch-potato',
    'angular-local-storage',
    'cherry',
    'angular-ui-router',
    'ui-bootstrap',
    'ui-select',
    'backend-mocks',
    'angular-jedate',
    'tmPagination',
    'angular-ui-tree',
    'utilities',//工具类
    'angular-file-upload'// 文件上传
], function ($, angular, couchPotato) {

    'use strict';

    /**
     * @desc 创建主模块,注入配置模块
     * @type {module}
     */
    var app = angular.module('mc.cherry', [
       'scs.couch-potato',
        'LocalStorageModule',
        'cherry',
        'ui.router',
        'ui.bootstrap',
        'ui.tree',
        'ui.select',
        'backend-mocks',//这里注释掉的话就不能请求本地的模拟数据了
        'angular-jedate',
        'tm.pagination',
        'utilities', //工具类
        'angularFileUpload'// 文件上传
    ]);

    couchPotato.configureApp(app);

    return app;

});