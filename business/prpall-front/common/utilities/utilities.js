/**
 * DESC       : 国元农险理赔  工具类模块；统一引用和定义服务；在app模块增加依赖
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/11/23
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
/*引入依赖模块的定义文件*/
define([
    'angular',
    'common/utilities/constant/regexpConstants',//正则校验
    'common/utilities/service/commonApiServ',
    'common/utilities/check/checkApiServ',//老系统校验
    'common/utilities/service/city',
    'common/utilities/service/city_func',
    'common/utilities/service/city_arr',
    'common/utilities/service/drag'
], function (angular, regexpConstants, commonApiServ,checkApiServ,city,city_func,city_arr,drag) {
    'use strict';
    console.log("load utilities module");
    /*增加模块依赖*/
    return angular.module('utilities', [])
        .constant('regexpConstants', regexpConstants)
        .service('commonApiServ', commonApiServ)
        .service('checkApiServ', checkApiServ)
        .service('city', city)
        .service('city_func', city_func)
        .service('city_arr', city_arr)
        .service('city_arr', drag)
});