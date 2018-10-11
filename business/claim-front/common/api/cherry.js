/**
 * DESC       : 阳光车险api-提供了投保处理
 * AUTHOR     : 阳光项目组
 * CREATEDATE : 2016-10-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              yanglei       2016-10-28     api规划
 *              zhaoguangzu   2016-11-22     初始化任务处理
 */
define([
    'angular',
    'codes',
    'config',
    'constants',
    'common/api/cherry.user',
    'common/api/cherry.finder',
    'common/api/mc.filter',
    'common/api/mc.util',
    'common/api/mc.code',
    'common/api/mc.validator',
    'common/api/cherry.commonality'
], function (angular, codes, config, constants) {

    /**
     * @ngdoc service
     * @name $$cherry
     *
     * @description
     * 提供了系统初始化逻辑处理
     *
     */
    angular.module('cherry', [ 'cherry.user', 'cherry.finder', 'mc.filter', 'mc.code', 'mc.validator', 'mc.util','cherry.commonality'])
        .factory('$$cherry', ['$$finder', '$rootScope', '$$code', '$q', '$http','$$user','$$commonality',
            function ($$finder, $rootScope, $$code, $q, $http, $$user) {
                $rootScope.isUndefined = angular.isUndefined;
                $rootScope.isDefined = angular.isDefined;
                /**
                 * 初始化
                 */
                var init = function () {

                    console.log('正在努力初始化系统');

                    var tasks = [
                        getRemoteInitData()
                    ];

                    $q.all(tasks).then(
                        function (data) {
                            $rootScope.$broadcast(constants.EVENTS.APP_READY, data[0]);
                            $rootScope.$broadcast(constants.EVENTS.COMBINE_BEGIN);
                        }
                    );
                                  };
                // 下拉框初始化统一调用 只有下拉框跟险种、权限无关时才可在此调用
                $$code.getRemoteCodes("codeType", "codeTypeInit", [
                    {
                        "codeType": "CheckNature", // 查查勘性质
                        "riskCode": "3101"
                    }, {
                        "codeType": "CatastropheCode", // 巨灾代码
                        "riskCode": "3101"
                    }
                    // {
                    //     "codeType": "Currency", // 币别
                    //     "riskCode": "3101"
                    // }
                ]);


                return {
                    $code: $$code,
                    $finder: $$finder,

                    /**
                     * @ngdoc
                     * @name $$cherry#find
                     * @methodOf $$cherry
                     *
                     * @description
                     * 涉及查询的接口入口
                     * @example
                     * find: function (target, keywords, options, pagination) {
                     * return $$finder.find(target, keywords, options, pagination);
                     * }
                     * @param {string} target 查询类型
                     * @param {object} keywords 入参数据
                     * @param {object} options onSuccess/onError回调
                     * @param {object} pagination 分页信息
                     * @returns {httpPromise} resolve with fetched data, or fails with error description.
                     */
                    post: function (target, keywords) {
                        return $$finder.post(target, keywords);
                    },
                    get: function (target, keywords) {
                        return $$finder.get(target, keywords);
                    }
                };
            }
        ])
});

