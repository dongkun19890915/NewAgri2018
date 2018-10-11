/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'jquery',
    'angular',
    'angular-couch-potato',
    'angular-local-storage',
    'tm.pagination',
    'angular-ui-router',
    'ui-bootstrap',
    'backend-mocks',
    'ui-select',
    'angular-jedate',
    'cherry',
    'utilities',
    'angular-file-upload'
    // 'raphael'
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
        'angular-jedate',
        'ui.select',
        'tm.pagination',
        'utilities',
        'backend-mocks',
        'angularFileUpload'
    ]);

    couchPotato.configureApp(app);

    return app;

});