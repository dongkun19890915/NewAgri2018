/**
 * Created by Guoxianglian on 2016/9/19.
 * prpins系统模块入口文件
 */
define([
    'angular',
    'components/prpins/proposal/module',
    'components/prpins/endorse/module',
    'components/prpins/underwrite/module',
    'components/prpins/report/module',
    'components/prpins/suspendEndorse/module',
    'components/prpins/suspendProposal/module',
    'components/prpins/application/module'
],function (angular
) {
    'use strict';
    /*prpins*/
    return angular.module('business.prpins', [
        'business.prpins.proposal',
        'business.prpins.endorse',
        'business.prpins.underwrite',
        'business.prpins.report',
        'business.prpins.suspendEndorse',
        'business.prpins.suspendProposal',
        'business.prpins.insure'
    ])
});
