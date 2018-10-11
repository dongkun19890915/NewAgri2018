/**
 * DESC       : 国元农险理赔过滤器模块
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017/12/14
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define(['angular'], function (angular) {
    angular.module('mc.filter', [])
    /**
     * @ngdoc filter
     * @name $$cherry.filter:mcCode
     * @description
     * 过滤数据字典，根据code值，获取value值
     * @param {string} code code值
     * @param {string} codetype 数据字典类型
     * @example
     <example module="cherry.filter">
     <file name="index.html">
     <span>{{proposal.BC.prpTinsured.appliIdentifyType | mcCode: 'IdentifyTypeHX'}}</span>
     </file>
     </example>
     */
        .filter("mcCode", ['$$code', function ($$code) {

            return function (code, codetype) {

                codetype = codetype || '';

                var result = $$code.getLocalCode(code, codetype);

                return result;
            }
        }])
        /**
         * @ngdoc filter
         * @name $$cherry.filter:propsFilter
         * @description
         * 根据数据字典，进行模糊查询过滤
         * @param {Array} items 数据列表
         * @param {object} props 查询条件
         * @example
         <example module="cherry.filter">
         <file name="index.html">
         <div ng-repeat="code.codecode as code in codeList | propsFilter: {codecode: $select.search, codecname: $select.search}">
         <div/>
         </file>
         </example>
         */
        .filter('propsFilter', function () {
            return function (items, props) {
                var out = [];

                if (angular.isArray(items)) {
                    var keys = Object.keys(props);

                    items.forEach(function (item) {
                        var itemMatches = false;

                        for (var i = 0; i < keys.length; i++) {
                            var prop = keys[i];
                            var text = props[prop].toString().toLowerCase();
                            if (item[prop] && item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                                itemMatches = true;
                                break;
                            }
                        }

                        if (itemMatches) {
                            out.push(item);
                        }
                    });
                } else {
                    // Let the output be the input untouched
                    out = items;
                }

                return out;
            };
        })
       //  放大镜效果过滤器
        .filter('engine', function () {
            return function (text) {
                if (typeof text == 'string') {
                    return text.replace(/\s/g, '').replace(/(.{4})/g, "$1 ").toUpperCase();
                }
            }
        })
        .filter('phone', function () {
            return function (text) {
                if (typeof text == 'string') {
                    return text.replace(/(\d{3})(\d{0,4})/, "$1 $2 ");
                }
            }
        })
        .filter('idCard', function () {
            return function (text) {
                if (typeof text == 'string') {
                    return text.replace(/(\d{6})(\d{0,4})(\d{0,2})(\d{0,2})(\d{0,4})/, "$1 $2 $3 $4 $5");
                }
            }
        })
        // 节点状态过滤器
        .filter('statusFilter', function () {
            return function (text) {
                var obj = {
                    0: "未处理",
                    1: "未处理",
                    2: "正在处理",
                    3: "回退处理",
                    4: "已处理",
                    5: "已回退",
                    6: "已撤销",
                    8: "注销拒赔",
                    all: "全部状态"
                };
                return obj[text]
            }
        })
        //将时间戳转换为yyyy-mm-dd
        .filter('timeFilter',function () {
            return function (timestamp) {
                var date = new Date(timestamp);
                var time = date.getFullYear()+ '-' + (date.getMonth() +1) +'-'+ date.getDate();
                return time;
            }
        });
});