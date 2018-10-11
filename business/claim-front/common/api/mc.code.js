/**
 * DESC       : 国元农险理赔 基础自定义指令组件
 * AUTHOR     : 项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * -------------------------------------------------------
 */
define(['angular', 'config', 'codes'], function (angular, config, codes) {
    angular.module('mc.code', [])
        .factory('$$code', ['$http', '$q', '$timeout', '$rootScope', '$$finder',
            function ($http, $q, $timeout, $rootScope, $$finder) {
                var localCodes = codes;
                var getLocalCodes = function (codeType) {
                    return localCodes[codeType];
                };
                var getLocalCode = function (code, codeType) {
                    if (!localCodes[codeType]) return '';
                    var result = '';
                    $.each(localCodes[codeType], function (index, _code) {
                        if (_code.codecode === code) {
                            result = _code.codecname;
                            return false;
                        }
                        // 双击域
                        if (_code.codecode === code) {
                            result = _code.codecname;
                            return false;
                        }
                    });

                    return result;
                };

                /**
                 * 远程获取数据字典
                 * @param target
                 * @param codeType
                 * @param options
                 * @returns {*}
                 */
                var getRemoteCodes = function (target, codeType, options) {

                    options = options || {
                        conditions: []
                    };

                    var deferred = $q.defer();
                    var _data = {};
                    var _url = "";

                    //下拉查询
                    if (target == 'codeType') {
                        if (codeType == 'codeTypeInit') {
                            //统一调用
                            // _url = config.backend.ip + config.backend.baseCode;
                            _data = {
                                "casecadeConditionList": [
                                    {
                                        "name": "",
                                        "value": ""
                                    }
                                ],
                                "initlist": options
                            };
                        }
                        if (_data.flag == '') {
                            delete _data.flag;
                        }
                        if (codeType !== 'codeTypeInit' && !options.conditionsInitlist) {
                            //单个调用
                            _data = {
                                "casecadeConditionList": [
                                    {
                                        "name": "",
                                        "value": ""
                                    }
                                ],
                                "initlist": [
                                    {
                                        "codeType": codeType || '',
                                        "riskCode": options.riskCode || '' // 注意 指令编译和；riskCode为控制器内调用后的到的如果单独调用时必须保证risk是从上一页面传入；或者跳转路由时传入
                                    }
                                ]
                            };


                            _url = config.backend.ip + config.backend.baseCode;
                            var data = {
                                "log": {},
                                "param": _data,
                                "channel": {},
                                "version": ""
                            };
                        }
                    }
                    //双击域
                    if (target == 'selectList') {
                        _url = config.backend.ip + config.backend.doubleClickService;
                        var data = {
                            "log": {},
                            "param": _data,
                            "version": "",
                            "channel": {}
                        };
                    }
                    console.log('下拉域begin' + new Date);
                    $$finder.post("baseCode", _data).then(
                        function (data) {
                            if (codeType == "codeTypeInit") {
                                angular.forEach(data.data, function (item, index) {
                                    localCodes[item.codeType] = item.resultobj.action_result;
                                })
                            }
                            if (codeType !== "codeTypeInit") { // 单个调用都不缓存
                                deferred.resolve(data.data[0].resultobj.action_result);
                            }

                        },
                        function (error) {
                            deferred.reject(error);
                        }
                    );
                    return deferred.promise;
                };

                var getCodes = function (target, codeType, options) {

                    var deferred = $q.defer();

                    if (localCodes[codeType]) {
                        deferred.resolve(getLocalCodes(codeType));
                    } else {
                        if (target == 'radio') {  // 单选按钮不在调用远程服务
                            return deferred.resolve(undefined)
                        }
                        //如果本地没有，尝试从远程获取
                        return getRemoteCodes(target, codeType, options);
                    }

                    return deferred.promise;
                };

                return {
                    //获取本地代码值
                    getLocalCode: function (code, codeType) {
                        return getLocalCode(code, codeType);
                    },
                    getLocalCodes: getLocalCodes,

                    //获取代码数组
                    getCodes: function (target, codeType, options) {
                        return getCodes(target, codeType, options);
                    },

                    //远程获取数据字典
                    getRemoteCodes: function (target, codeType, options) {
                        return getRemoteCodes(target, codeType, options)
                    },

                    //确保数据字典装入本地
                    preloadCodes: function (codeTypes) {
                        var deferred = $q.defer();

                        if (!codeTypes || !angular.isObject(codeTypes))
                            deferred.reject();
                        $q.all(getCodes('codeType', 'codeTypeInit', codeTypes)).then(
                            function () {
                                deferred.resolve();
                            }
                        );

                        return deferred.promise;
                    }

                };
            }])
        /**
         * @ngdoc directive
         * @name $$cherry.directive:codeType
         * @description
         * 提供代码的下拉列表
         * @restrict E
         * @scope
         * @param {string} ngModel ngModel绑定值
         * @param {string} baseCode codeType类型
         * @param {string} riskCode 险种
         * @param {string} on-select 选中回调
         * @param {string} ng-value 选中name值
         * @param {string} relationType 级联codeType
         * @param {string} relationCode 级联父级code值
         * @param {string} relationCodeg 级联爷爷级code值
         * @param {string} flag 标志字段
         * @param {string} ngDisabled 是否只读
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <code-type base-code="riskType"   ng-value="responseDto.riskName" ng-model="responseDto.riskType">
         </file>
         </example>
         */
        .directive('codeType', ['$$code', '$compile', '$timeout', '$q', '$$finder', function ($$code, $compile, $timeout, $q, $$finder) {
            return {
                require: '^ngModel',
                restrict: 'E', // 指令是一个元素 (并非属性)
                // replace:true,
                // priority: 520,
                scope: { // 设置指令对于的scope
                    // flag: '=',         //标志字段
                    riskCode: '=',     // 险种代码
                    ngRequired: '=',// 必填校验
                    ngDisabled: '=',
                    baseCode: "=",
                    ngModel: '=',
                    onSelect: '&', // 选中后的回调
                    noCache: '&'
                },
                // template: '<select ng-options="baseCode.codeCode as baseCode.codecname for baseCode in codeList" ></select>',
                template:
                '<ui-select ng-disabled="ngDisabled"  on-select="select($select)">' +
                '<ui-select-match  ng-model="ngModel" allow-clear="{{ngRequired?false:true}}" placeholder="查询或选择...">' +
                '{{$select.selected.codecname}}' +
                '</ui-select-match>' +
                '<ui-select-choices repeat="code.codecode as code in codeList | filter: $select.search">' +
                '<span ng-bind="code.codecname"></span>' +
                '</ui-select-choices>' +
                '</ui-select>',
                compile: function () {
                    var localCodes = codes;
                    var deferred = $q.defer();
                    var _comCode = "";
                    var _switchComCode = false;//切换渠道标志位
                    return function (scope, element, attrs, ngCtrl) {
                        scope.model = attrs.ngModel;
                        scope.select = function ($select) {
                            if (attrs.ngValue) {
                                var ary = attrs.ngValue.split(".");
                                var val = ary.pop();
                                if (ary.length > 0) {
                                    var str = ary.join(".");
                                    scope.$parent.$eval(str)[val] = $select.selected.codecname
                                } else {
                                    scope.$parent[val] = $select.selected.codecname
                                }
                                // scope.$parent.$eval(attrs.ngValue)[attrs.ngValue] = $select.selected.codecname;
                            }

                            // if (typeof scope.$parent[scope.onSelect] === "function") {
                            //     scope.$parent[scope.onSelect]()
                            // }
                            if (attrs.onSelect) {
                                scope.$parent.$evalAsync(attrs.onSelect)
                            }
                        };
                        //临时数据
                        scope.codeList = [];
                        scope.modalValue = '';
                        $$code.getCodes('codeType', attrs.baseCode, {
                            riskCode: scope.riskCode || '',
                            noCache: attrs.noCache || ''
                        }).then(function (data) {
                            scope.codeList = data;
                            $timeout(function () {
                                scope.modalValue = ngCtrl.$modelValue;
                            });
                        });
                        scope.$on('$destroy', function () {
                            element.off();
                        })
                    };
                }
            }
        }])

        /**
         * @ngdoc directive
         * @name $$cherry.directive:checkBox
         * @description
         * 提供代码的多选
         * @restrict E
         * @scope
         * @param {string} data 多选数据
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <check-box ng-model="queryDto.checkList" data="{{checkBox}}"></check-box>
         <check-box ng-model="queryDto.checkList" base-code="checkBox"></check-box>
         </file>
         </example>
         */
        // .directive('checkBox', [ '$timeout',  function ( $timeout ) {
        //     return {
        //         required:'^ngModel',
        //         restrict: 'E', // 指令是一个元素 (并非属性)
        //         scope: { // 设置指令对于的scope
        //             data: '=',
        //             ngModel: '='
        //         },
        //         template: '<div class="check-box" ng-repeat="box in data">' +
        //         '<label class="checkbox-label" ng-class="{\'checkbox-checked\':box.checked==true}" ng-click="toggleCheck($index,$event)">' +
        //         '<span></span>' +
        //         '<input type="checkbox" name="checkbox" class="hide" ng-model="box.checked"><em ng-bind="box.name"></em>' +
        //         '</label>' +
        //         '</div>'+
        //         '<input ng-model="ngModel" class="hide">',
        //         compile: function () {
        //             return function (scope, element, attrs, ngCtrl) {
        //                 scope.$watch('ngModel',function () {
        //                     console.log(scope.ngModel);
        //                     initCheck();
        //                 });
        //                 var timer = $timeout(function () {
        //                     initCheck();
        //                     clearTimeout(timer);
        //                 }, 100);
        //                 scope.toggleCheck = function (index,$event) {
        //                     $event.preventDefault();
        //                     scope.data[index].checked =! scope.data[index].checked;
        //                     var arr=[];
        //                     for(var j=0;j<scope.data.length;j++){
        //                         if(scope.data[j].checked==true){
        //                             arr.push(scope.data[j].code);
        //                         }
        //                     }
        //                     scope.ngModel = arr;
        //                     return false;
        //
        //                 };
        //                 var initCheck = function() {
        //                     if(angular.isArray(scope.ngModel) && angular.isArray(scope.data)){
        //                         for(var i=0;i<scope.ngModel.length;i++){
        //                             for(var j=0;j<scope.data.length;j++){
        //                                 if(scope.ngModel[i]===scope.data[j].code){
        //                                     scope.data[j].checked=true;
        //                                     break;
        //                                 }
        //                             }
        //                         }
        //                     }
        //                 }
        //             };
        //         }
        //     }
        // }])
        .directive('checkBox', ['$timeout', '$$code', function ($timeout, $$code) {
            return {
                required: '^ngModel',
                restrict: 'E', // 指令是一个元素 (并非属性)
                scope: { // 设置指令对于的scope
                    ngModel: '=',
                    data: '@data',
                    ngRequired: '=',
                    ngDisabled: '='
                },
                template: '<div class="check-box" ng-repeat="box in listData" ng-class="{true:box.class}[box.class?true:false]" ng-style="{width:box.width}" style="float: left">' +
                '<label class="checkbox-label" ng-class="{\'checkbox-checked\':box.checked==true,\'is-disabled\':ngDisabled || box.disabled}" ng-click="toggleCheck($index,$event)">' +
                '<span style="margin-top: 7px"  class="check-main"><span></span></span>' +
                '<em ng-bind="box.codecname"></em>' +
                '</label>' +
                '</div>' +
                '<input ng-model="ngModel" class="hide">',
                compile: function () {
                    return function (scope, element, attrs, ngCtrl) {
                        var init = function () {
                            if (attrs.data) {
                                scope.listData = JSON.parse(scope.data);
                                // scope.data = new Function("return this.$parent."+attrs.data).call(scope);
                            } else {
                                if (attrs.baseCode) {
                                    scope.listData = angular.copy($$code.getLocalCodes(attrs.baseCode));
                                }
                            }
                        };
                        var initCheck = function () {
                            if (angular.isArray(scope.ngModel) && angular.isArray(scope.listData)) {
                                for (var i = 0; i < scope.ngModel.length; i++) {
                                    for (var j = 0; j < scope.listData.length; j++) {
                                        if (scope.ngModel[i] === scope.listData[j].codecode) {
                                            scope.listData[j].checked = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        };
                        scope.$watch('ngModel', function () {
                            initCheck();
                        });
                        var timer = $timeout(function () {
                            init();
                            if (!scope.listData || scope.listData.length == 0) {
                                scope.$watch("data", function (n, o) {
                                    console.log(n, o);
                                    if (n && n.length > 0) {
                                        init()
                                        initCheck();
                                        clearTimeout(timer);
                                    }
                                })
                            } else {
                                initCheck();
                                clearTimeout(timer);
                            }
                        }, 200);
                        var errorTextEle;
                        scope.toggleCheck = function (index, $event) {
                            $event.preventDefault();
                            console.log("index-checkbox: " + index);
                            console.log(scope.listData);
                            if (scope.ngDisabled || scope.listData[index].disabled == true) {
                                return false;
                            }
                            scope.listData[index].checked = !scope.listData[index].checked;
                            var arr = [];
                            for (var j = 0; j < scope.listData.length; j++) {
                                if (scope.listData[j].checked == true) {
                                    arr.push(scope.listData[j].codecode);
                                }
                            }
                            scope.ngModel = arr;
                            if (attrs.ngChange) {
                                scope.change = $parse(attrs.ngChange)
                            }
                            if (scope.ngRequired) {
                                if (scope.ngModel.length == 0) {
                                    if (!$(element).attr('errorText')) {
                                        $(element).after('<div class="validation-errorText"></div>');
                                        // element.attr('errorText', true);
                                        errorTextEle = $(element).next();
                                    }
                                    errorTextEle.text('该项为必填项');
                                } else {
                                    if (errorTextEle) {
                                        errorTextEle.hide();
                                    }
                                }
                            }
                            return false;
                        };
                    };
                }
            }
        }])






        /**
         * @ngdoc directive
         * @name $$cherry.directive:radio
         * @description
         * 提供代码的单选
         * @restrict E
         * @scope
         * @param {string} data 单选数据
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <radio ng-model="queryDto.radioText" data="{{radioList}}"></radio>
         <radio ng-model="queryDto.radioText" base-code="radioList"></radio>
         </file>
         </example>
         */
        .directive('radio', ['$timeout', '$$code', function ($timeout, $$code) {
            return {
                required: '^ngModel',
                restrict: 'E', // 指令是一个元素 (并非属性)
                scope: { // 设置指令对于的scope
                    data: '@data',
                    ngModel: '=',
                    ngDisabled: '='
                },
                template: '<div class="radio-box">' +
                '<label class="radio-label" ng-repeat="radio in listData" ng-class="{\'radio-checked\':radio.codecode == ngModel,\'is-disabled\':ngDisabled || radio.disabled}" ng-click="toggleRadio(radio.codecode,$event,$index)">' +
                '<span class="radio-main"><span></span></span>' +
                '<em ng-bind="radio.codecname"></em>' +
                '</label>' +
                '</div><input ng-model="ngModel" class="hide">',
                compile: function () {
                    return function (scope, element, attrs, ngCtrl) {

                        // $$code.getCodes('radio', attrs.baseCode).then(function (data) {
                        //     if (data && angular.isArray(data) && data.length > 0) {
                        //         scope.data = data;
                        //     } else { // 如缓存未获取到数据 延时去取传入值
                        //         var timer = $timeout(function () {
                        //             init();
                        //             clearTimeout(timer);
                        //         }, 100);
                        //     }
                        // });
                        scope.toggleRadio = function (codecode, $event, index) {
                            $event.preventDefault();
                            if (scope.ngDisabled || scope.listData[index].disabled == true) {
                                return false;
                            }
                            console.log(codecode);
                            scope.ngModel = codecode;
                            if (attrs.ngChange) {
                                scope.$parent.$evalAsync(attrs.ngChange)
                            }
                            return false;

                        };
                        var init = function () {
                            if (attrs.data) {
                                scope.listData = JSON.parse(scope.data);
                                // scope.data = new Function("return this.$parent."+attrs.data).call(scope);
                            } else {
                                if (attrs.baseCode) {
                                    scope.listData = angular.copy($$code.getLocalCodes(attrs.baseCode));
                                }
                            }
                        };
                        var timer = $timeout(function () {
                            init();
                            if (!scope.listData || scope.listData.length == 0) {
                                scope.$watch("data", function (n, o) {
                                    console.log(n, o);
                                    if (n && n.length > 0) {
                                        scope.listData = JSON.parse(scope.data);

                                    }
                                })
                            }
                            clearTimeout(timer);
                        }, 200);

                    };
                }
            }
        }])

        /**
         * @ngdoc directive
         * @name $$cherry.directive:selectList
         * @description
         * 双击域
         * @restrict E
         * @scope
         * @param {string} ngModel ngModel绑定值
         * @param {string} ngValue ngValue绑定值
         * @param {string} baseCode codeType类型
         * @param {string} ngDisabled 只读
         * @param {string} ngRequired 必填
         * @param {object} selectValue 入参
         * @param {string} displayType 双击域显示值类型
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <select-list base-code="Handler2Code"
         ng-model="proposal.BC.prpTmain.handler1Code"
         ng-value="proposal.BC.prpTmain.handler1Name"
         select-value="{comCode:proposal.BC.prpTmain.comCode,channelType:proposal.BC.prpTmain.channelType,businessNature:proposal.BC.prpTmain.businessNature,agentCode:proposal.BC.prpTmain.agentCode}"
         displayType="CODE"
         ng-disabled="proposal.infoToView.readonlyBC"
         ng-required="true">
         </select-list>
         </file>
         </example>
         */
        .directive('selectList', ['$timeout', '$parse', '$$code',
            function ($timeout, $parse, $$code) {
                return {
                    require: '^ngModel',
                    restrict: "E",
                    scope: {
                        ngModel: '=',
                        ngValue: '=',
                        ngDisabled: '=',
                        ngRequired: '=',
                        selectValue: '=',
                        maxLength: '='
                    },
                    templateUrl: "template/directive/select-list.html",
                    compile: function () {
                        return function (scope, element, attrs, ngCtrl) {
                            scope._code = "";//临时code
                            scope._value = "";//临时value
                            scope.openListFlag = false;//下拉框是否显示
                            scope.codeList = [];//下拉框数据
                            scope.displaytype = attrs.displaytype;//双击域类型
                            var fieldExt = "";//级联
                            var codeMethod = "select";//类型
                            var codeValue = "";//模糊查询
                            var ie11Delete = true;//ie8input默认x，触发特殊处理

                            var changeCallBack = $parse(attrs.waitChange);
                            /**
                             * 对外放出一个接口,触发指令函数
                             * @param waitEvent
                             * @param scope
                             */
                            var validationData = function (waitEvent, scope) {
                                if (waitEvent) {
                                    $timeout(function () {
                                        waitEvent(scope.$parent);
                                    }, 100)
                                }
                            };

                            /**
                             * 双击触发
                             */
                            scope.modalOpen = function (event) {
                                if (event) {
                                    //键盘上键操作
                                    if (event.keyCode == 38) {
                                        if (rowsNumber > 0) {
                                            rowsNumber--;
                                        }
                                        $("#selectDbl" + rowsNumber).addClass('rowSelected');
                                        $("#selectDbl" + (rowsNumber + 1)).removeClass('rowSelected');
                                    }
                                    //键盘下键操作
                                    if (event.keyCode == 40) {
                                        if (rowsNumber < scope.codeList.length - 1) {
                                            rowsNumber++;
                                        }
                                        $("#selectDbl" + rowsNumber).addClass('rowSelected');
                                        $("#selectDbl" + (rowsNumber - 1)).removeClass('rowSelected');
                                    }
                                    //上下键选择，回车键选中
                                    if (!event.ctrlKey && event.keyCode == 13 && scope.openListFlag) {
                                        scope.chooseList(scope.codeList[rowsNumber]);
                                        return false;
                                    }
                                    if (!(event.ctrlKey && event.keyCode == 13)) {
                                        return false;
                                    }
                                }
                                scope.codeList = [];//下拉框数据
                                // handleCascade(attrs.baseCode, scope.selectValue);
                                scope.openListFlag = true;
                                $$code.getCodes('selectList', attrs.baseCode, {
                                    codeMethod: codeMethod,
                                    fieldExt: fieldExt,
                                    codeValue: codeValue,
                                    riskCode: attrs.riskCode || ''
                                }).then(function (data) {
                                    scope.codeList = data;
                                });
                            };


                            /**
                             * 输入域变化
                             */
                            scope.changeList = function () {
                                if (ie11Delete) {
                                    scope.openListFlag = false;
                                    ie11Delete = false;
                                }
                            };

                            /**
                             * 选中列表
                             * @param item
                             */
                            scope.chooseList = function (item) {
                                scope.ngModel = item.codecode;
                                scope.ngValue = item.codecname;
                                scope._code = item.codecode;
                                scope._value = item.codecname;
                                checkList = true;
                                scope.openListFlag = false;


                                validationData(changeCallBack, scope);
                            };

                        }
                    }
                }
            }
        ])
        /**
         * @ngdoc directive
         * @name $$cherry.directive:comtreeList
         * @ngModel 绑定id 多选为Array 单选是为String
         * @ngValue 绑定 name 多选时为 Array 单选是为String
         * @multiple 区分单选多选 指令元素的属性
         * @url 树结构数据 访问后端路径 string
         * @ngChange check发生后的回调 Function
         * @ngDisabled 整体禁用只可查看 Boolean
         * @node.disabled 单个节点禁用 Boolean
         * @node.checked 单个节点选中 Boolean
         * 机构树选择
         */
        .directive('comTree', ['$timeout', '$parse', '$$finder',
            function ($timeout, $parse, $$finder) {
                return {
                    require: 'ngModel',
                    restrict: "E",
                    scope: {
                        ngModel: '=',
                        ngValue: '=',
                        ngDisabled: '=',
                        ngRequired: '='
                    },
                    contollerAs: 'comTreeCtrl',
                    controller: function ($scope) {
                        $scope.comTreeCtrl = this;
                        //改变子孙级的状态
                        this.changeChildrenNodeStatus = function (node, _this) {
                            var _this = _this || this;
                            angular.forEach(node.childList, function (childrenNode) {
                                childrenNode.checked = node.checked;
                                // if(node.checked){
                                //     // 如果为勾选中
                                //     var obj = angular.copy(childrenNode);
                                //     obj.childList = null;
                                //     checkAry.push(obj)
                                // } else {
                                //     angular.forEach(checkAry, function (child, index) {
                                //         if(child.id === childrenNode.id){
                                //             checkAry.splice(index, 1)
                                //         }
                                //     });
                                // }
                                $scope.nodeData = childrenNode.title;
                                //如果还有子集
                                if (childrenNode.childList && childrenNode.childList.length > 0) {
                                    _this.changeChildrenNodeStatus(childrenNode, _this);
                                }
                            })
                        };

                        //获取选中的节点
                        this.getCheckedData = function (data, checkAry, _this) {
                            var _this = _this || this;
                            var checkAry = checkAry || [];
                            angular.forEach(data, function (childData) {
                                if (childData.checked) {
                                    var obj = angular.copy(childData);
                                    obj.childList = null;
                                    checkAry.push(obj);
                                    // checkAry.push(angular.copy(childData).childList = null)
                                }
                                if (childData.childList && childData.childList.length > 0) {
                                    _this.getCheckedData(childData.childList, checkAry, _this);
                                }
                            });
                            return checkAry
                        };

                        //检查兄弟级的状态 改变父级
                        this.checkBrotherNodeStatus = function (nodeScope, _this) {
                            var _this = _this || this;
                            //判断是否到达了顶级
                            if (!nodeScope) {
                                return false;
                            }
                            //父节点的值
                            var parentNodeValue = nodeScope.$modelValue;
                            //父节点上次的状态
                            var lastStatus = parentNodeValue.checked;

                            var checkedAll = true;

                            angular.forEach(parentNodeValue.childList, function (brotherNode) {
                                if (!brotherNode.checked) {
                                    checkedAll = false;
                                    return false
                                }
                            });
                            parentNodeValue.checked = checkedAll;
                            if (lastStatus != parentNodeValue.checked) { // 状态改变
                                // 获取选中值
                                // if(checkedAll){ // 如果为勾选中
                                //     var obj = angular.copy(parentNodeValue);
                                //     obj.childList = null;
                                //     checkAry.push(obj);
                                // } else {
                                //     angular.forEach(checkAry, function (child, index) {
                                //         if(child.id === parentNodeValue.id){
                                //             checkAry.splice(index, 1)
                                //         }
                                //     });
                                // }
                                //如果状态改变了，则要继续向上延伸
                                _this.checkBrotherNodeStatus(nodeScope.$parentNodeScope, _this);
                            }
                        }
                    },
                    templateUrl: "template/directive/comcodeTree.html",
                    link: function ($scope, element, attrs, ctrl, ddd) {
                        $scope.switchFlag = false; // 机构树开关
                        var multipleFlag = $scope.multipleFlag = false; //多选单选
                        var upExtend = $scope.upExtend = false; // 是否向上延伸
                        $scope.checkAry = []; // 选中数组
                        // $(element).find('#comTree').on("click", function () {
                        var getTree = function (data, node) {
                            data.type = 'checkOrLoss';
                            $$finder.post(attrs.url, data).then(function (data) {
                                // 给节点加层级
                                var level = node ? node.level - 0 + 1 : 1;
                                angular.forEach(data, function (item) {
                                    item.level = level;
                                });
                                if (node) {
                                    node.childList = data;
                                    node.loading = false;
                                } else {
                                    $scope.data = data;
                                    if (multipleFlag) {
                                        $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry);
                                        angular.forEach($scope.checkAry, function (item) {
                                            $scope.ngValue.push(item.name);
                                            $scope.ngModel.push(item.id);
                                        });
                                    }
                                    $scope.$evalAsync();
                                }
                            })
                        };
                        $scope.openTree = function () {
                            if ($scope.ngDisabled) return;
                            if (!$scope.data) {
                                getTree({})
                            }
                            $scope.switchFlag = !$scope.switchFlag;

                        };
                        if (attrs.multiple || attrs.multiple === '') { // 区分单选还是多选
                            multipleFlag = $scope.multipleFlag = true;
                        }
                        if (attrs.upExtend || attrs.upExtend === '') { //  是否向上延伸
                            upExtend = $scope.upExtend = true;
                        }
                        // 单选参数处理
                        if (multipleFlag) {
                            if (!angular.isDefined($scope.ngModel) || $scope.ngModel === null) { // 对未定义的参数予以宽容
                                $scope.ngModel = [];
                            }  else if(!angular.isArray($scope.ngModel))  {
                                throw (new Error('[comTree dirctive multiple state] ngModel got [0]'))
                            }
                            if (!angular.isDefined($scope.ngValue) || $scope.ngValue === null) { // 对未定义的参数予以宽容
                                    $scope.ngValue = [];
                            } else if(!angular.isArray($scope.ngValue))  {
                                throw (new Error('[comTree dirctive multiple state] ngValue got [0]'))
                            }
                        }
                        //开关触发器
                        $scope.toggleNode = function (scope, node) {
                            if (node.childList && node.childList.length === 0) {
                                node.loading = true;
                                getTree({"upperComCode": node.id}, node);
                                // scope.toggle();
                            }
                            node.collapsed = !node.collapsed;
                            scope.toggle();
                        };
                        $scope.change = $parse(attrs.ngChange)
                        $scope.checkNode = function (scope, node) {
                            if ($scope.ngDisabled || node.disabled) return;
                            console.log(scope, node);
                            if (!multipleFlag) {
                                $scope.ngValue = node.name;
                                $scope.ngModel = node.id;
                                $scope.switchFlag = false;
                                if (attrs.ngChange) {
                                    $timeout(function () {
                                        $scope.$parent.$evalAsync(attrs.ngChange)
                                    });
                                }
                            }
                            // else if(node.childList.length > 0) {
                            //     node.collapsed = !node.collapsed;
                            //     scope.toggle();
                            // }
                        };
                        //当多选checked发生变化 执行本方法
                        $scope.changeNodeMult = function (node, parent, parentNode) {
                            if ($scope.ngDisabled || node.disabled) return;
                            node.checked = !node.checked;
                            if (node.checked) {
                                // 如果为勾选中
                                var obj = angular.copy(node);
                                obj.childList = null;
                                $scope.checkAry.push(obj)
                            } else {
                                angular.forEach($scope.checkAry, function (child, index) {
                                    if (child.id === node.id) {
                                        $scope.checkAry.splice(index, 1)
                                    }
                                });
                            }
                            $scope.comTreeCtrl.changeChildrenNodeStatus(node);
                            if (upExtend) {
                                $scope.comTreeCtrl.checkBrotherNodeStatus(parentNode);
                            }
                            $scope.checkAry.length = 0;
                            $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry);
                            $scope.ngValue.length = 0;
                            $scope.ngModel.length = 0;
                            angular.forEach($scope.checkAry, function (item) {
                                $scope.ngValue.push(item.name);
                                $scope.ngModel.push(item.id);
                            });
                            if (attrs.ngChange) {
                                $scope.$parent.$evalAsync(attrs.ngChange)
                            }
                        };
                        var box = $('body').on("click", function (e) {
                            if ($scope.switchFlag === false) return;// 关闭状态
                            var target = $(e.target);

                            var parent = target.parents("com-tree");
                            if ((parent.length > 0 && parent[0] !== element[0])) {
                                $scope.switchFlag = false; // 机构树关
                            }else if(parent.length <= 0){
                                $("#comtree-list").hide();
                                $scope.switchFlag = false;
                            }else{
                                $("#comtree-list").show();
                                $scope.switchFlag = true;
                            }

                        });
                        $scope.$on('$destroy', function (event) {
                            box.off();
                        })
                    }
                }
            }
        ])



        /**
         * @ngdoc filter
         * @name $$cherry.filter:propsFilter
         * @description
         * 放大镜效果
         * @example
         <example module="cherry.filter">
         <file name="index.html">
         <input ng-model="responseDto.fname" enlarge="idCard"  type="text" class=""/>
         </file>
         </example>
         */
        .directive("enlarge", [
            '$timeout', '$compile', '$sce',
            function ($timeout, $compile, $sce) {
                return {
                    require: 'ngModel',
                    restrict: 'A',
                    scope: {
                        "ngModel": '='
                    },
                    compile: function () {
                        return function ($scope, element, attrs, ctrl) {
                            ctrl.$formatters.push(function (val) {
                                $scope.enlargeText = val;
                                return val;
                            });
                            ctrl.$parsers.push(function (val) {
                                $scope.enlargeText = ctrl.$viewValue;
                                return val;
                            });
                            var str = '';
                            str += '<div class="enlarge" ng-show="enlargeText" ng-bind="enlargeText';
                            str += attrs.enlarge ? ' | ' + attrs.enlarge : '';
                            str += '" style="display: none;"></div>';
                            var compileFn = $compile(str);
                            var enlargeEl = compileFn($scope);
                            $(element).parent().append(enlargeEl);
                            $(element).focus(function () {
                                enlargeEl.show();
                            });
                            $(element).blur(function () {
                                enlargeEl.hide();
                            });

                        }
                    }
                }
            }
        ])

        /**
         * @ngdoc directive
         * @name $$cherry.directive:multiDrop
         * @description
         * 提供代码的下拉多选
         * @restrict E
         * @scope
         * @param {string} data、base-code 下拉多选数据
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <multi-drop ng-model="queryDto.checkList" data="{{checkBox}}"></multi-drop>
         <multi-drop ng-model="queryDto.checkList" base-code="checkBox"></multi-drop>
         </file>
         </example>
         */
        .directive('multiDrop', ['$timeout', '$$code', '$document', function ($timeout, $$code, $document) {
            return {
                required: '^ngModel',
                restrict: 'E', // 指令是一个元素 (并非属性)
                scope: { // 设置指令对于的scope
                    ngModel: '=',
                    data: '@data',
                    ngRequired: '=',
                    ngDisabled: '='
                },
                template: '<div class="multi-drop" ng-click="dropShow=!dropShow"><span ng-show="array===null||array.length==0">查询或选择...</span><ul class="multi-drop-ul"><li ng-repeat="item in array track by $index"><span ng-bind="item"></span><i ng-click="del($index,$event)"></i></li></ul></div><div class="multi-drop-con" ng-show="dropShow"><div class="check-box" ng-repeat="box in listData" ng-class="{\'checked\':box.checked==true,\'hover-bg\':hover==true}" ng-click="toggleCheck($index,$event)" ng-mouseover="hover = true" ng-mouseleave="hover = false">' +
                '<label class="checkbox-label" ng-class="{\'checkbox-checked\':box.checked==true}">' +
                '<span class="check-main"><span></span></span>' +
                '<em ng-bind="box.codecname"></em>' +
                '</label>' +
                '</div></div>' +
                '<input ng-model="ngModel" class="hide">',
                compile: function () {
                    return function (scope, element, attrs, ngCtrl) {
                        scope.$watch('ngModel', function () {
                            initCheck();
                        });
                        scope.array = [];
                        // var arr = [];
                        var init = function () {
                            if (attrs.data) {
                                scope.listData = JSON.parse(scope.data);
                                // scope.data = new Function("return this.$parent."+attrs.data).call(scope);
                            } else {
                                if (attrs.baseCode) {
                                    scope.listData = angular.copy($$code.getLocalCodes(attrs.baseCode));
                                }
                            }
                        };
                        var initCheck = function () {
                            if (angular.isArray(scope.ngModel) && angular.isArray(scope.listData)) {
                                for (var i = 0; i < scope.ngModel.length; i++) {
                                    for (var j = 0; j < scope.listData.length; j++) {
                                        if (scope.ngModel[i] === scope.listData[j].codecode) {
                                            scope.listData[j].checked = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        };
                        var timer = $timeout(function () {
                            init();
                            if (!scope.listData || scope.listData.length == 0) {
                                scope.$watch("data", function (n, o) {
                                    console.log(n, o);
                                    if (n && n.length > 0) {
                                        init();
                                        initCheck();
                                        clearTimeout(timer);
                                    }
                                })
                            } else {
                                initCheck();
                                clearTimeout(timer);
                            }
                        }, 100);
                        var errorTextEle;
                        scope.toggleCheck = function (index, $event) {
                            $event.preventDefault();
                            // $event.stopPropagation();
                            console.log("index-checkbox: " + index);
                            scope.listData[index].checked = !scope.listData[index].checked;
                            if (scope.listData[index].checked) {
                                scope.array.push(scope.listData[index].codecname);
                            } else {
                                scope.array.splice(scope.array.indexOf(scope.listData[index].codecname), 1);
                            }
                            var arr = [];
                            for (var j = 0; j < scope.listData.length; j++) {
                                if (scope.listData[j].checked == true) {
                                    arr.push(scope.listData[j].codecode);
                                }
                            }
                            scope.ngModel = arr;
                            $timeout(function () {
                                if (attrs.ngChange) {
                                    scope.$parent.$eval(attrs.ngChange)
                                }
                            }, 0);
                            if (scope.ngRequired) {
                                if (scope.ngModel.length == 0) {
                                    if (!$(element).attr('errorText')) {
                                        $(element).after('<div class="validation-errorText"></div>');
                                        // element.attr('errorText', true);
                                        errorTextEle = $(element).next();
                                    }
                                    errorTextEle.text('该项为必填项');
                                } else {
                                    if (errorTextEle) {
                                        errorTextEle.hide();
                                    }
                                }
                            }
                            console.log(arr);
                            console.log(scope.array);
                            return false;
                        };


                        scope.del = function ($index, $event) {
                            for (var j = 0; j < scope.listData.length; j++) {
                                if (scope.array[$index] === scope.listData[j].codecname) {
                                    scope.listData[j].checked = !scope.listData[j].checked;
                                }
                            }
                            scope.array.splice($index, 1);
                            $event.preventDefault();
                            $event.stopPropagation();
                        }

                        function onDocumentClick(e) {
                            if (!scope.dropShow) return;
                            var contains = false;
                            if (window.jQuery) {
                                contains = window.jQuery.contains(element[0], e.target);
                            } else {
                                contains = element[0].contains(e.target);
                            }
                            var multiDrop = $('multi-drop');
                            if (!contains && !multiDrop.clickTriggeredSelect) {
                                var skipFocusser;
                                if (multiDrop.skipFocusser) {
                                    var focusableControls = ['input', 'button', 'textarea', 'select'];
                                    var targetController = angular.element(e.target).controller('multiDrop');
                                    skipFocusser = targetController && targetController !== multiDrop;
                                } else {
                                    skipFocusser = true;
                                }
                                if (scope.dropShow) {
                                    scope.dropShow = !scope.dropShow;
                                }
                                scope.$digest();
                            }
                            multiDrop.clickTriggeredSelect = false;
                        }

                        $document.on('click', onDocumentClick);
                        scope.$on('$destroy', function () {
                            $document.off('click', onDocumentClick);
                        });

                    };
                }
            }
        }
        ])


});