/**
 * Created by ZhangJiansen on 2016/9/18.
 * 业务模块总入口
 * 增加新业务模块请在此文件中增加依赖
 */

/*引入依赖模块的定义文件*/
define([
    'angular',
    'components/index/module',
    'components/prpins/module',
    'components/document/module',
    'components/payment/module',
    'components/clearFile/module',
    'components/ims/module',
    'components/pms/module',
    'components/material/module'
],function (angular) {
    'use strict';
    console.log("load business module");
    /*增加模块依赖*/
    return angular.module('business',
        [
            'business.index',
            'business.prpins',
            'business.document',
            'business.payment',
            'business.clearFile',
            'business.ims',
            'business.pms',
            'business.material'
        ]);
});