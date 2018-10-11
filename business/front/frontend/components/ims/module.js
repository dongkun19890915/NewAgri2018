/**
 * Created by ZhangJiansen on 2016/9/19.
 * ims系统模块入口文件
 */
define([
    'angular',
    './community/module',
    './user/module',
    './passWord/module',
    './underwriting/module'
],function (angular) {
    'use strict';
    /*ims*/
    return angular.module('business.ims', [
        'business.ims.community',
        'business.ims.user',
        'business.ims.passWord',
        'business.ims.underwriting'
    ]);
});
