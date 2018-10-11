/**
 * 
 * 清分模块文件
 */
define([
    'angular',
    'components/clearFile/downloadClearFile/module',
    'components/clearFile/uploadClearFile/module',
    'components/clearFile/generateClearFile/module',
    'components/clearFile/dataRectification/module',
    'components/clearFile/settleReport/module',
    'components/clearFile/genSettleReport/module'
],function (angular
) {
    'use strict';
    return angular.module('business.clearFile', [
        'business.clearFile.downloadClearFile',
        'business.clearFile.uploadClearFile',
        'business.clearFile.generateClearFile',
        'business.clearFile.dataRectification',
        'business.clearFile.settleReport',
        'business.clearFile.genSettleReport'
    ])
});