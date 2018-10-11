/**
 * Created by Guoxianglian on 2016/9/19.
 * payment系统模块入口文件
 */
define([
    'angular',
    'components/payment/charge/module',
    'components/payment/chargeConfirm/module',
    'components/payment/chargeFail/module',
    'components/payment/receipt/module'
],function (angular
) {
    'use strict';
    /*payment*/
    return angular.module('business.payment', [
        'business.payment.charge',
        'business.payment.chargeConfirm',
        'business.payment.chargeFail',
        'business.payment.receipt'
    ])
});
