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
    'common/api/mc.code',
    'common/api/cherry.proposal',
    'common/api/mc.validator',
    'common/api/logout.finder'
], function (angular, codes, config, constants) {

    /**
     * @ngdoc service
     * @name $$cherry
     *
     * @description
     * 提供了系统初始化逻辑处理
     *
     */
    angular.module('cherry', [
        'cherry.user',
        'cherry.finder',
        'mc.code',
        'cherry.proposal',//保单录入
        'mc.validator',
        'logout.finder'
    ])
        .factory('$$cherry', ['$$finder', '$rootScope','$$code',  '$q', '$http','$$proposal','$$user',
            function ( $$finder,$rootScope, $$code, $q, $http,$$proposal,$$user) {
                $rootScope.isUndefined = angular.isUndefined;
                $rootScope.isDefined = angular.isDefined;
                $$code.getCodes('codeType', 'EditType', {}).then(function (data) {
                    codes.prpDcodeListDtoList = data
                });

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
                            $rootScope.$broadcast(constants.EVENTS.APP_READY,data[0]);
                            $rootScope.$broadcast(constants.EVENTS.COMBINE_BEGIN);
                            console.log('==================================');
                            console.log('      国元农险合并录单');
                            console.log('      版本 ' + window.CHERRY.version);
                            console.log('==================================');
                        }
                    );
                };


                return {
                    $code: $$code,
                    $finder: $$finder,
                    $proposal: $$proposal,
                    $user:$$user,
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
                    find: function (target, keywords, options, pagination) {
                        return $$finder.find(target, keywords, options, pagination);
                    }
                };
            }
        ])
        /**
         * @ngdoc directive
         * @name $$cherry.directive:history
         * @description
         * 数据对比，差异颜色变化处理
         * @restrict A
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <input type="text"
         history
         ng-model="proposal.BC.prpTitemCar.vinNo">
         </file>
         </example>
         */
        .directive('history',['$timeout', '$rootScope', '$filter',function($timeout, $rootScope,$filter){
            return {
                restrict: 'A',
                priority: 500,
                require: '^ngModel',
                compile: function () {
                    return function (scope, element, attrs, ngCtrl) {

                        var classElement = element;//获取当前节点dom
                        var original;//对比数据（老数据）
                        var isChangeStatus;//当前数据状态
                        // var endroseFlagObject = {};//批改标志位集合
                        // var endroseFlagValue = "";//批改标志位value值

                        //数据对比，颜色处理
                        var update = function(){

                            var newValue = ngCtrl.$modelValue;
                            newValue = angular.isUndefined(newValue)? '':newValue;
                            newValue = angular.isNumber(newValue)? newValue.toString():newValue;
                            //当前域变色处理   historyChangeColor (true/false  支持／不支持变色)
                            if(attrs.historyChangeColor != 'false'){
                                if (angular.equals(newValue,original)){
                                    if(classElement[0].nodeName.toUpperCase()=== 'SELECT-LIST'){
                                        $(classElement).children("input").eq(0).removeClass('changed');
                                        $(classElement).children("input").eq(1).removeClass('changed');
                                    } else if(classElement.attr("type")==="radio" ) {
                                        $(classElement).parents('label').removeClass('changed')
                                    } else {
                                        classElement.removeClass('changed');
                                    }
                                } else {
                                    if(classElement[0].nodeName.toUpperCase() === 'SELECT-LIST'){
                                        $(classElement).children("input").eq(0).addClass('changed');
                                        $(classElement).children("input").eq(1).addClass('changed');
                                    }else if(classElement.attr("type")==="radio" ) {
                                        $(classElement).parents('label').addClass('changed')
                                    } else{
                                        classElement.addClass('changed');
                                    }

                                }
                            }
                        };

                        $rootScope.$on(constants.EVENTS.ENDORSE_READY, function(){

                            //获取对比数据（老数据）值
                            original = ngCtrl.$modelValue;
                            original = angular.isUndefined(original)? '':original;
                            original = angular.isNumber(original)? original.toString():original;

                            //变化域添加title属性，鼠标悬浮显示老数据
                            $(element).attr("title", ngCtrl.$modelValue);
                            //model变化后，进行数据比对
                            scope.$watch(attrs.ngModel, function () {
                                update();
                            })
                        });
                    }
                }
            }
        }])
});

