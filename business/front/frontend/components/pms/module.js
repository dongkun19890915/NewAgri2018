/**
 * Created by ZhangJiansen on 2016/9/19.
 * pms系统模块入口文件
 */
define([
    'angular',
    'components/pms/areaquota/module',
    'components/pms/communityMember/module',
    'components/pms/expenses/module'
],function (angular
) {
    'use strict';
    /*pms*/
    return angular.module('business.pms', [
        'business.pms.areaquota',
        'business.pms.communityMember',
        'business.pms.expenses'
    ])
});
