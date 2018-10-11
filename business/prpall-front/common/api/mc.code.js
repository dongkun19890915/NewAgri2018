/**
 * DESC       : 车险angular－项目配置文件
 * AUTHOR     : 项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * -------------------------------------------------------
 */
define(['angular', 'config', 'codes','ztree'], function (angular, config, codes,ztree) {
    angular.module('mc.code', [])
        .factory('$$code', ['$http', '$q', '$timeout', '$rootScope',
            function ($http, $q, $timeout, $rootScope) {
                $rootScope.treeInsure=false;
                var localCodes = codes;
                var getLocalCodes = function (target, codetype, options,setdata) {
                    return localCodes[codetype];
                };
                var getLocalCode = function (code, codetype) {
                    if (!localCodes[codetype]) return '';
                    var result = '';
                    $.each(localCodes[codetype], function (index, _code) {
                        if (_code.content === code) {
                            result = _code.codetype;
                            return false;
                        }
                        //双击域
                        if (_code.codeCode === code) {
                            result = _code.codeName;
                            return false;
                        }
                    });
                    return result;
                };

                /**
                 * 远程获取数据字典
                 * @param target
                 * @param codename
                 * @param options
                 * @returns {*}
                 */
                var getRemoteCodes = function (target, codename, options,setdata) {
                    options = options || {
                            conditions: []
                        };
                    var deferred = $q.defer();
                    var _data = {};
                    var _method = "";
                    var _url = "";
                    var falg=false
                    var codedata=['EditType','BusinessNature','BusinessType1','AutoTransRenewFlag1','customerType',
                                   'ProposalType','PremiumCalMethodMain',
                                    'ShortRateFlagMain','SubsidyCode','Subsidytype',
                                    'PaymentReason','EndorsePaymentReason','ShowPaymentReason','IdentifyType','RiskLevel',
                                    'PayInfoPayerType','PayInfoInvoiceType','InsuredType',
                                    'PayInfoObject','CoinsFlag','PolicyPayType',
                                    'CoinsIdentity','IsChief','MainPolicyNo','BusinessCategory','EndorType1','InsuredComtype',
                                    'ReceiverType','CertiType','UgentType','CostType','JudicalScope','ContractType','EndorType']
                    if(codedata.indexOf(codename)!=-1){
                        codename='prpDcodeListDtoList'
                        falg=true
                    }
                    //下拉查询
                    if (target == 'codeType') {
                        _url = config.backend.ip + config.backend[codename];
                        if (!falg) {
                            var _data =setdata||{}

                            var data = {
                                "method": _method,
                                "auth": {},
                                "log": {},
                                "param": _data,
                                "channel": {},
                                "version": ""
                            };
                        } else if(codename='prpDcodeListDtoList') {
                            _url = config.backend.ip + config.backend.getOptionCodeTwo;
                            var _data = {

                                "prpDcodeListDtoList": [
                                    //编辑类型
                                    {
                                        "codeType": "EditType",
                                        "riskCode": ""
                                    },
                                    //业务来源
                                    {
                                        "codeType": "BusinessNature",
                                        "riskCode": ""
                                    },
                                    //政策/商业标志
                                    {
                                        "codeType": "BusinessType1",
                                        "riskCode": ""
                                    },
                                    //缴费方式
                                    {
                                        "codeType": "AutoTransRenewFlag1",
                                        "riskCode": ""
                                    },
                                    //保险金额确定方式
                                    {
                                        "codeType": "ProposalType",
                                        "riskCode": ""
                                    },
                                    //保费计算方式
                                    {
                                        "codeType": "PremiumCalMethodMain",
                                        "riskCode": ""
                                    },
                                    //短期费率方式
                                    {
                                        "codeType": "ShortRateFlagMain",
                                        "riskCode": ""
                                    },
                                    //补贴类型
                                    {
                                        "codeType": "SubsidyCode",
                                        "riskCode": ""
                                    },
                                    //补贴方式
                                    {
                                        "codeType": "Subsidytype",
                                        "riskCode": ""
                                    },
                                    //保单缴费原因-编辑页面
                                    {
                                        "codeType": "PaymentReason",
                                        "riskCode": ""
                                    },
                                    //批改缴费原因-编辑页面
                                    {
                                        "codeType": "EndorsePaymentReason",
                                        "riskCode": ""
                                    },
                                    //缴费原因-查看页面
                                    {
                                        "codeType": "ShowPaymentReason",
                                        "riskCode": ""
                                    },
                                    //证件类型
                                    {
                                        "codeType": "IdentifyType",
                                        "riskCode": ""
                                    },
                                    //风险等级
                                    {
                                        "codeType": "RiskLevel",
                                        "riskCode": ""
                                    },
                                    //纳税人身份
                                    {
                                        "codeType": "PayInfoPayerType",
                                        "riskCode": ""
                                    },
                                    //发票类型
                                    {
                                        "codeType": "PayInfoInvoiceType",
                                        "riskCode": ""
                                    },
                                    //客户类型
                                    {
                                        "codeType": "InsuredType",
                                        "riskCode": ""
                                    },
                                    //开票对象
                                    {
                                        "codeType": "PayInfoObject",
                                        "riskCode": ""
                                    },
                                    //联共保标
                                    {
                                        "codeType": "CoinsFlag",
                                        "riskCode": ""
                                    },
                                    //保单缴费类型
                                    {
                                        "codeType": "PolicyPayType",
                                        "riskCode": ""
                                    },
                                    //共保身份
                                    {
                                        "codeType": "CoinsIdentity",
                                        "riskCode": ""
                                    },
                                    //是否首席
                                    {
                                        "codeType": "IsChief",
                                        "riskCode": ""
                                    },
                                    //主保单号码选项
                                    {
                                        "codeType": "MainPolicyNo",
                                        "riskCode": ""
                                    },
                                    //业务大类
                                    {
                                        "codeType": "BusinessCategory",
                                        "riskCode": ""
                                    },
                                    //企业类型
                                    {
                                        "codeType": "InsuredComtype",
                                        "riskCode": ""
                                    },
                                    //客户类型
                                    {
                                        "codeType": "customerType",
                                        "riskCode": ""
                                    },
                                    //  领款人类型
                                    {
                                        "codeType": "ReceiverType",
                                        "riskCode": ""
                                    },
                                    //  证件类型
                                    {
                                        "codeType": "CertiType",
                                        "riskCode": ""
                                    },
                                    //  紧急程度
                                    {
                                        "codeType": "UgentType",
                                        "riskCode": ""
                                    },
                                    //  费用类型
                                    {
                                        "codeType": "CostType",
                                        "riskCode": ""
                                    },
                                    //  司法管辖
                                    {
                                        "codeType": "JudicalScope",
                                        "riskCode": "",
                                        "hpFlag":"0"
                                    },

                                    //  批改类型
                                    {
                                        "codeType": "EndorType",
                                        "riskCode": ""
                                    },
                                    //  查询页面的批改类型
                                    {
                                        "codeType": "EndorType1",
                                        "riskCode": ""
                                    },
                                    //  合同争议方式
                                    {
                                        "codeType": "ContractType",
                                        "riskCode": "",
                                        "hpFlag":"0"
                                    },
                                ]};

                            var data = {
                                "method": _method,
                                "auth": {},
                                "log": {},
                                "param": _data,
                                "channel": {},
                                "version": ""
                            };
                        }
                        if (_data.flag == '') {
                            delete _data.flag;
                        }
                    }
                    $http({
                        method: 'POST',
                        dataType: "JSON",
                        contentType: 'application/json; charset=UTF-8',
                        url: _url,
                        headers: {},
                        data: _data
                    })
                        .success(function (data) {
                            // 前端修改归属机构时归属业务员也会变，所以归属业务员检索框前端不做缓存
                            if (codename != 'queryHandler1CodeInfo') {
                                localCodes[codename] = data.content;
                            }
                            deferred.resolve(data.content);
                        })
                        .error(function (e, code) {
                            deferred.reject(code);
                        });
                    return deferred.promise;
                };

                var getCodes = function (target, codename, options,setdata) {
                    //初始化公共接口
                    var codedata=['EditType','BusinessNature','BusinessType1','customerType',
                        'AutoTransRenewFlag1','ProposalType','PremiumCalMethodMain',
                        'ShortRateFlagMain','SubsidyCode','Subsidytype','PaymentReason','EndorsePaymentReason','ShowPaymentReason','IdentifyType',
                        'RiskLevel','PayInfoPayerType','PayInfoInvoiceType','InsuredType','PayInfoObject',
                        'CoinsFlag','PolicyPayType','CoinsIdentity','IsChief','MainPolicyNo','BusinessCategory','InsuredComtype',
                        'ReceiverType','CertiType','UgentType','CostType','JudicalScope','ContractType','EndorType','EndorType1']
                    var deferred = $q.defer();
                    if(codename=='AreasProvinceInfo'){
                        return getRemoteCodes(target, codename, options,setdata);
                    }
                    if (localCodes[codename]) {
                        deferred.resolve(getLocalCodes(target, codename, options,setdata));
                    } else if(codedata.indexOf(codename)!=-1&&localCodes.prpDcodeListDtoList){
                        deferred.resolve(getLocalCodes(target, 'prpDcodeListDtoList', options,setdata));
                    } else {
                        //如果本地没有，尝试从远程获取
                        return getRemoteCodes(target, codename, options,setdata);
                    }
                    return deferred.promise;
                };
                return {
                    //获取本地代码值
                    getLocalCode: function (code, codename) {
                        return getLocalCode(code, codename);
                    },
                    getLocalCodes: getLocalCodes,
                    //获取代码数组
                    getCodes: function (target, codename, options,setdata) {
                        return getCodes(target, codename, options,setdata);
                    },

                    //远程获取数据字典
                    getRemoteCodes: function (target, codename, options,setdata) {
                        return getRemoteCodes(target, codename, options,setdata)
                    },
                    //确保数据字典装入本地
                    preloadCodes: function (codetypes) {
                        var deferred = $q.defer();

                        if (!codetypes || !angular.isObject(codetypes))
                            deferred.reject();
                        $q.all(getCodes('codeType', 'codeTypeInit', codetypes)).then(
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
     * @param {string} relationType 级联codeType
     * @param {string} relationCode 级联父级code值
     * @param {string} relationCodeg 级联爷爷级code值
     * @param {string} flag 标志字段
     * @param {string} ngDisabled 是否只读
     * @example
     <example module="cherry.directive">
     <file name="index.html">
         <code-type base-code="BusinessNature" ng-model='proposal.BC.prpTmain.businessNature'></code-type>
     </file>
     </example>
     */
        .directive('codeType', ['$$code', '$compile', '$timeout', '$q', '$$finder', function ($$code, $compile, $timeout, $q, $$finder) {
            return {
                require: '^ngModel',
                restrict: 'E', // 指令是一个元素 (并非属性)
                // replace:true,
                priority: 520,
                scope: { // 设置指令对于的scope
                    flag: '=',         //标志字段
                    riskCode: '=',     // 险种代码
                    relationType: '=', //级联codeType
                    relationCode: '=',// 级联父级code值
                    relationCodeg: '=', //级联爷爷级code值
                    ngDisabled: '=',
                    baseCode: "=",
                    upperCode: "@",
                    ngModel: '=',
                    onSelect: '&', // 选中后的回调
                    onReady: '&',
                    //ngCode: '=',
                    isFuzzy: '=',
                    setdata:'=',
                    reverseData:'=',
                    limit:'=',//限制选中功能：不符合条件的时候model值设为init
                    dfsec:'='

                },
                // template: '<select ng-options="baseCode.codeCode as baseCode.codeName for baseCode in codeList" ></select>',

                template:'<ui-select ng-disabled="ngDisabled">'+
                '<ui-select-match  ng-model="ngModel"  allow-clear="true"  placeholder="查询或选择..." ng-attr-title="{{$select.selected.codeCName}}">' +
                '{{$select.selected.codeCName}}' +
                '</ui-select-match>' +
                '<ui-select-choices repeat="code.codeCode as code in codeList | filter: $select.search" ng-click="reverseData(codeList,$event,type);limt()">' +
                '<span  ng-bind="code.codeCName" ng-attr-title="{{code.codeCName}}" ></span>' +
                '</ui-select-choices>' +
                '</ui-select>',
                compile: function () {
                    var localCodes = codes;
                    var deferred = $q.defer();
                    var _comCode = "";
                    var _switchComCode = false;//切换渠道标志位

                    return function (scope, element, attrs, ngCtrl) {
                        //scope.limit=scope.limit||{}
                        //设置若为require弹出该项必填（基本没啥用）
                        setrequire()
                        function setrequire(){
                            var falsreq=false;
                            var mouseup=false
                            var mouseenter=false
                            if(attrs.required){

                                $(element).on('blur','div .ui-select-search',function(e){
                                    timeout()
                                })
                                function timeout(){

                                    setTimeout(
                                        function(){
                                            if (!scope.ngModel) {
                                                layer.open({
                                                    offset: ['35%', '40%'],
                                                    skin: 'large-layer-content',
                                                    closeBtn: 0,
                                                    title: '温馨提示',
                                                    content: '此项为必填项',
                                                    btn: ['确定'],
                                                    btn1: function (index, layero) {
                                                        //按钮【按钮一】的回调
                                                        layer.close(index);
                                                    }
                                                });
                                            }
                                        },500)

                                }

                            }
                        }
                        scope.limt=function(){
                            if(!scope.limit)return
                           var flag=scope.limit.flag?false:true;
                            if(flag){
                                scope.ngModel=scope.limit.init
                            }
                        }

                        scope.model = attrs.ngModel;
                        scope.reData=attrs.setdata
                        scope.type=attrs.baseCode

                        //临时数据
                        scope.codeList = [];
                        scope.modalValue = '';
                        $timeout(function () {
                            scope.modalValue = ngCtrl.$modelValue;
                        }, 10);

                        //级联关系
                        var conditions = [];
                        var conditionsInitlist = [];
                        var checkData = function (data) {
                            return data.codecode == scope.ngModel;
                        };
                            var codedata=['EditType','customerType','BusinessNature','BusinessType1','AutoTransRenewFlag1',
                                'ProposalType','PremiumCalMethodMain','ShortRateFlagMain','SubsidyCode','Subsidytype',
                                'PaymentReason','EndorsePaymentReason','ShowPaymentReason','IdentifyType','RiskLevel','PayInfoPayerType','PayInfoInvoiceType',
                                'InsuredType','PayInfoObject','CoinsFlag','PolicyPayType','CoinsIdentity','IsChief',
                                'MainPolicyNo','BusinessCategory','InsuredComtype','ReceiverType','CertiType','UgentType',
                                'CostType','JudicalScope','ContractType','EndorType','EndorType1']
                            // var initFlag=''
                            // if(codedata.indexOf(attrs.baseCode)!=-1){
                            //     initFlag='prpDcodeListDtoList'
                            // }
                            if( codedata.indexOf(attrs.baseCode)==-1){

                                $$code.getCodes('codeType', attrs.baseCode, { },scope.setdata).then(function (data) {
                                    scope.codeList = data;
                                    if(attrs.dfsec&&scope.codeList[0].codeCode){
                                        scope.codeList.unshift({codeCode:'',codeCName:'--请选择--'})
                                    }
                                });
                            } else{
                                $timeout(function () {
                                    $$code.getCodes('codeType', attrs.baseCode, { }).then(function (data) {
                                        if ( data.prpDcodeListDtoList) {
                                            angular.forEach(data.prpDcodeListDtoList, function (data) {
                                                if (attrs.baseCode == data.codeType) {
                                                    scope.codeList = data.prpDcodeDtoList
                                                    if(attrs.dfsec&&scope.codeList[0].codeCode){
                                                        scope.codeList.unshift({codeCode:'',codeCName:'--请选择--'})
                                                    }
                                                }
                                            })
                                        } else {
                                            scope.codeList = data
                                        }
                                    });
                                }, 250)

                            }


                        scope.$on('$destroy', function () {
                            element.off();
                        })
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
                            var rowsNumber = 0;//当前列表被选中行数
                            //modify WEB-2523 冻结用例测试-四川 归属业务员双击带出值后，单击归属机构后，归属业务员值为空 by zhaoguangzu begin
                            var checkList = false;//代表当前双击域数据为选中数据
                            var prpDcompany = false;//代表当前查询结果为超出200条
                            //modify WEB-2523 冻结用例测试-四川 归属业务员双击带出值后，单击归属机构后，归属业务员值为空 by zhaoguangzu end
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
                             * 处理级联关系
                             * @param keywords
                             */
                            var handleCascade = function (codeType, keywords) {

                                codeType = codeType || "";
                                keywords = keywords || {};

                                //归属部门
                                if (codeType == 'ComCode') {
                                    fieldExt = "1";
                                    if (typeof(keywords.comCodeFlag) != "undefined") {
                                        fieldExt = "1" + ',' + keywords.comCodeFlag;
                                    }
                                }
                                //归属业务员
                                if (codeType == 'Handler2Code') {
                                    fieldExt = keywords.comCode;
                                    if (keywords.channelType == 'N06') {
                                        fieldExt = keywords.comCode + ',' + keywords.channelType + ',' + keywords.businessNature;
                                    }
                                    //modify PEO-1350 【上海】新系统代理点没有对业务员数量限制 by zhangpei begin
                                    if (scope.$parent.proposal) {
                                        if (scope.$parent.rule.isHandlerChannelN01.indexOf(scope.$parent.proposal.loginComCode.substring(0, 2)) > -1) {
                                            if (['0', '6', '7', '8', 'J', 'K', 'Z'].indexOf(keywords.businessNature) < 0) {
                                                fieldExt = keywords.comCode + ',' + keywords.channelType + ',' + keywords.businessNature + ',' + keywords.agentCode;
                                            }
                                        }
                                    }
                                    //modify PEO-1350 【上海】新系统代理点没有对业务员数量限制 by zhangpei end
                                    //二期车队  【上海】新系统代理点没有对业务员数量限制 by sunjianrong begin
                                    if (scope.$parent.prpMotorcade) {
                                        if (scope.$parent.rule.isHandlerChannelN01.indexOf(scope.$parent.prpMotorcade.comCode.substring(0, 2)) > -1) {
                                            if (['0', '6', '7', '8', 'J', 'K', 'Z'].indexOf(keywords.businessNature) < 0) {
                                                fieldExt = keywords.comCode + ',' + keywords.channelType + ',' + keywords.businessNature + ',' + keywords.agentCode;
                                            }
                                        }
                                    }
                                    //二期车队  【上海】新系统代理点没有对业务员数量限制 by sunjianrong end
                                }
                                //会员卡卡号
                                if (codeType == 'MemberNo') {
                                    fieldExt = keywords.businessNature + ',' + keywords.comCode;
                                }
                                //代理人/经纪人/渠道
                                if (codeType.substring(0, 9) == 'AgentCode') {
                                    fieldExt = keywords.comCode;
                                    // fieldExt='02110000';
                                }
                                //商机编码
                                if (codeType == 'CrmBoCode') {
                                    fieldExt = keywords.handler1Code;
                                    // fieldExt = "02541853";
                                }
                                //行业子类
                                if (codeType == 'BusinessSource4') {
                                    fieldExt = keywords.prpDcustomerUnitBusinessSource;
                                }
                                //机动车损失保险/第三者责任保险/全车盗抢保险/车上人员责任保险（乘客/车上人员责任保险（驾驶员）
                                if (codeType == 'KindCode0New') {
                                    fieldExt = keywords.clauseType;
                                }
                                //服务区域
                                if (codeType == 'ServiceArea') {
                                    fieldExt = keywords.comCode + ';' + keywords.channelType + ';' + keywords.openServiceArea + ';' +
                                        keywords.channelTypeSub + ';' + keywords.businessNature + ';' + '0528';
                                    //fieldExt="15540200,N01";
                                }
                                //私车团购码
                                if (codeType == 'privateCarGroup') {
                                    scope.$parent.riskcode = '';
                                    //isMotorcycleTractor是否摩托车拖拉机录入标识
                                    if (!keywords.isMotorcycleTractor) {
                                        if (keywords.riskCI) {
                                            scope.$parent.riskcode = scope.$parent.riskcode + ',' + keywords.riskCodeCI;
                                        }
                                        if (keywords.riskBI) {
                                            scope.$parent.riskcode = scope.$parent.riskcode + ',' + keywords.riskCodeBI;
                                        }
                                        fieldExt = keywords.licenseNo + ';' + keywords.InsuredName + ';' + keywords.comCode + ';'
                                            + keywords.businessNature + ';' + scope.$parent.riskcode;
                                    }
                                }
                                //统保项目
                                if (codeType == 'ItemCName') {
                                    //loginRiskCode登录险种
                                    fieldExt = keywords.comCode + ';' + keywords.loginRiskCode;
                                    //  fieldExt = keywords.comCode +';'+"0507";
                                }
                                //总对总标示
                                if (codeType == 'generalFlag') {
                                    fieldExt = keywords.serviceArea;//服务区域
                                    // fieldExt = "T02565164";
                                }
                                //银行网点
                                if (codeType == 'BankAgentCode') {
                                    fieldExt = keywords.handler1Code;
                                    // fieldExt = "03602220";
                                }
                                //中介销售人姓名
                                if (codeType == 'AgentSalerName') {
                                    fieldExt = keywords.agentCode;
                                    // fieldExt = 'U0863G000002';//测试
                                }
                                //特别约定
                                if (codeType == 'ClauseCode') {
                                    fieldExt = ''
                                }
                                //认领人
                                if (codeType == 'ClaimCode') {
                                    fieldExt = keywords.comCode;
                                }
                            };

                            /**
                             * 双击触发
                             */
                            scope.modalOpen = function (event) {
                                //add PEO-1350 【上海】新系统代理点没有对业务员数量限制 by zhangpei begin
                                if (scope.$parent.proposal && attrs.baseCode == 'Handler2Code') {
                                    if (scope.$parent.rule.isHandlerChannelN01.indexOf(scope.$parent.proposal.loginComCode.substring(0, 2)) > -1) {
                                        if (['0', '6', '7', '8', 'J', 'K', 'Z'].indexOf(scope.$parent.proposal.BC.prpTmain.businessNature) < 0) {
                                            if (!scope.$parent.proposal.BC.prpTmain.agentCode) {
                                                layerMsg('请输入代理人/经纪人/渠道!');
                                                return false;
                                            }
                                        }
                                    }
                                }
                                //add PEO-1350 【上海】新系统代理点没有对业务员数量限制 by zhangpei end
                                //add 二期车队   【上海】新系统代理点没有对业务员数量限制 by sunjianrong begin
                                if (scope.$parent.prpMotorcade && attrs.baseCode == 'Handler2Code') {
                                    if (scope.$parent.rule.isHandlerChannelN01.indexOf(scope.$parent.prpMotorcade.comCode.substring(0, 2)) > -1) {
                                        if (['0', '6', '7', '8', 'J', 'K', 'Z'].indexOf(scope.$parent.prpMotorcade.businessNature) < 0) {
                                            if (!scope.$parent.prpMotorcade.agentCode) {
                                                layerMsg('请输入代理人/经纪人/渠道!');
                                                return false;
                                            }
                                        }
                                    }
                                }
                                //add 二期车队   【上海】新系统代理点没有对业务员数量限制 by sunjianrong end
                                //add ctrl+enter 触发双击域 by zhaoguangzu begin
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
                                //add ctrl+enter 触发双击域 by zhaoguangzu end
                                if (attrs.displaytype == 'CODE') {
                                    codeValue = $(element).children("input").eq(0).val() ? scope.ngModel : "";
                                    ie11Delete = $(element).children("input").eq(0).val() == (scope.ngModel || '');
                                } else {
                                    //WEB-2780	【UAT】车队协议管理 查询条件不对 投保人代码字段取消 投保人名称应为双击域  by  sunjianrong  begin
                                    if (attrs.baseCode == 'AppliCode1') {
                                        codeValue = $(element).children("input").eq(1).val() || "";
                                        ie11Delete = $(element).children("input").eq(1).val() == (scope.ngValue || '');
                                    } else {
                                        codeValue = $(element).children("input").eq(1).val() ? scope.ngModel : "";
                                        ie11Delete = $(element).children("input").eq(1).val() == (scope.ngValue || '');
                                    }
                                    //WEB-2780	【UAT】车队协议管理 查询条件不对 投保人代码字段取消 投保人名称应为双击域  by  sunjianrong  end
                                }
                                //归属业务员规则校验
                                if (attrs.baseCode == 'Handler2Code' && !scope.selectValue.comCode && /^\d+$/.test(scope.ngModel) && scope.ngModel.length < 4) {
                                    layerMsg('请输入4位以上的归属业务员工号');
                                    return false
                                }
                                if (attrs.baseCode == 'Handler2Code' && !/^\d+$/.test(scope.ngModel) && !scope.selectValue.comCode) {
                                    layerMsg('请输入4位以上的归属业务员工号');
                                    return false
                                }
                                if (attrs.baseCode == 'Handler2Code') {
                                    //二期车队   by  sunjianrong  begin
                                    if (scope.$parent.prpMotorcade) {
                                        scope.$parent.prpMotorcade.handler1ProspectNo = '';
                                    } else {
                                        scope.$parent.proposal.BC.prpTmain.handler1ProspectNo = '';
                                    }
                                    //二期车队   by  sunjianrong  end
                                }
                                if (attrs.baseCode.substring(0, 9) == 'AgentCode' && scope.$parent.proposal) {
                                    scope.$parent.proposal.BC.prpTexpense.prospectNo = '';
                                }
                                scope.codeList = [];//下拉框数据
                                handleCascade(attrs.baseCode, scope.selectValue);
                                scope.openListFlag = true;
                                $$code.getCodes('selectList', attrs.baseCode, {
                                    codeMethod: codeMethod,
                                    fieldExt: fieldExt,
                                    codeValue: codeValue,
                                    riskCode: attrs.riskCode || ''
                                }).then(function (data) {
                                    if (data == 'prpDcompany') {
                                        prpDcompany = true;
                                    } else {
                                        prpDcompany = false;
                                        scope.codeList = data;
                                        //	WEB-2848	【二期-uat车队管理】上海，车队管理，点击新保协议后提示超过200条  by  sunjianrong  begin
                                        if (attrs.baseCode != 'AppliCode1') {
                                            if (!(data && data.length > 0)) {
                                                layerMsg("未查询到数据，请检查录入是否正确");
                                            }
                                        }
                                        //	WEB-2848	【二期-uat车队管理】上海，车队管理，点击新保协议后提示超过200条   by  sunjianrong end
                                    }
                                });
                            };

                            //归属机构与归属业务员级联
                            if (attrs.baseCode == 'ComCode') {
                                //监听归属机构model
                                scope.$parent.$watch(attrs.ngModel, function (newValue, oldValue) {

                                    //只有被赋值时才执行以下操作
                                    if (angular.isDefined(scope.$parent.reQueryComCode)) {
                                        if (!scope.$parent.reQueryComCode.isAssignFlag) {
                                            return false;
                                        }
                                    }
                                    if (angular.isUndefined(scope.$parent.reQueryComCode)) {
                                        return false

                                    }
                                    if ((oldValue !== '' || newValue == oldValue || newValue.length < 8) && oldValue !== undefined || newValue.length < 8) {
                                        return false;
                                    }

                                    // alert('监听到归属业务员变化');
                                    scope.codeList = [];//下拉框数据
                                    handleCascade(attrs.baseCode, scope.selectValue);
                                    scope.openListFlag = false;

                                    $$code.getCodes('selectList', attrs.baseCode, {
                                        codeMethod: codeMethod,
                                        fieldExt: fieldExt,
                                        codeValue: attrs.displaytype == "CODE" ? newValue : scope.ngValue
                                    }).then(function (data) {
                                        if (data == 'prpDcompany') {
                                            prpDcompany = true;
                                        } else {
                                            prpDcompany = false;
                                            scope.codeList = data;
                                            //自动触发一次点击事件
                                            $timeout(function () {
                                                $(".dblclickArea")[0].click();
                                            }, 100);
                                        }

                                    });
                                })
                            }

                            scope.$parent.$watch(attrs.ngModel, function () {
                                checkList = false;
                                prpDcompany = false;
                            });

                            /**
                             * 关闭下拉框
                             */
                            scope.closeList = function () {
                                $timeout(function () {
                                    rowsNumber = 0;
                                    scope.openListFlag = false;
                                    var codeValue = $(element).children("input").eq(0).val();
                                    if ((attrs.displaytype == "CODE" ? scope.ngModel : scope.ngValue) && !checkList && !prpDcompany) {
                                        //投保人双击域离开不需调接口重查数据    by  sunjainrong  begin
                                        if (attrs.baseCode != 'AppliCode1') {
                                            handleCascade(attrs.baseCode, scope.selectValue);
                                            $$code.getCodes('selectList', attrs.baseCode, {
                                                codeMethod: codeMethod,
                                                fieldExt: fieldExt,
                                                codeValue: codeValue
                                            }).then(function (data) {
                                                if (data && data.length == 1) {
                                                    scope.chooseList(data[0]);
                                                } else {
                                                    if (attrs.baseCode != 'ArbitraryBoard') {
                                                        scope.ngValue = scope.ngValue ? scope._value : scope.ngValue;
                                                    }
                                                    scope.ngModel = scope.ngModel ? scope._code : scope.ngModel;
                                                }
                                            });
                                        }
                                    } else {
                                        if (attrs.baseCode != 'ArbitraryBoard' && attrs.baseCode != 'AppliCode1') {
                                            scope.ngValue = scope.ngValue ? scope._value : scope.ngValue;
                                        }
                                        scope.ngModel = scope.ngModel ? scope._code : scope.ngModel;
                                    }

                                }, 200);
                            };

                            /**
                             * 输入域变化
                             */
                            scope.changeList = function () {
                                if (ie11Delete) {
                                    scope.openListFlag = false;
                                    scope._code = "";
                                    scope._value = "";
                                    ie11Delete = false;
                                }
                            };

                            /**
                             * 选中列表
                             * @param item
                             */
                            scope.chooseList = function (item) {

                                scope.ngModel = item.codeCode;
                                scope.ngValue = item.codeName;
                                scope._code = item.codeCode;
                                scope._value = item.codeName;
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
e
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
        /**
         * @ngdoc directive
         * @name $$cherry.directive:radio
         * @description
         * 提供代码的单选
         * @restrict E
         * @scope
         * @param {string} data、base-code 单选数据
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
                '<label class="radio-label" ng-repeat="radio in listData" ng-class="{\'radio-checked\':radio.codeCode == ngModel,\'is-disabled\':ngDisabled || radio.disabled}" ng-click="toggleRadio(radio.codeCode,$event,$index)">' +
                '<span class="radio-main"><span></span></span>' +
                '<em ng-bind="radio.codeCName"></em>' +
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
                        scope.toggleRadio = function (codeCode, $event, index) {
                            $event.preventDefault();
                            if (scope.ngDisabled || scope.listData[index].disabled == true) {
                            return false;
                            }
                            scope.ngModel = codeCode;
                            $timeout(function () {
                                if(attrs.ngChange){
                                    scope.$parent.$eval(attrs.ngChange)
                                }
                            },0);
                            return false;

                        };
                        var init = function () {
                            // try {
                            //     scope.data = JSON.parse(attrs.data);
                            // } catch (e) {
                            //     scope.data = scope.$parent[attrs.data];
                            // }
                            if (attrs.data) {
                                scope.listData = JSON.parse(scope.data);
                                // scope.data = new Function("return this.$parent."+attrs.data).call(scope);
                            } else {
                                if (attrs.baseCode) {
                                    scope.listData = angular.copy($$code.getLocalCodes('', attrs.baseCode));
                            }
                            }
                        };
                        var timer = $timeout(function () {
                            init();
                            if (!scope.listData || scope.listData.length == 0) {
                                scope.$watch("data", function (n, o) {
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
         * @name $$cherry.directive:checkBox
         * @description
         * 提供代码的多选
         * @restrict E
         * @scope
         * @param {string} data、base-code 多选数据
         * @example
         <example module="cherry.directive">
         <file name="index.html">
         <check-box ng-model="queryDto.checkList" data="{{checkBox}}"></check-box>
         <check-box ng-model="queryDto.checkList" base-code="checkBox"></check-box>
         </file>
         </example>
         **/
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
                template: '<div class="check-box" ng-repeat="box in listData" ng-class="{true:box.class}[box.class?true:false]" ng-style="{width:box.width}">' +
                '<label class="checkbox-label" ng-class="{\'checkbox-checked\':box.checked==true,\'is-disabled\':ngDisabled || box.disabled}" ng-click="toggleCheck($index,$event)">' +
                '<span class="check-main"><span></span></span>' +
                '<em ng-bind="box.codeCName"></em>' +
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
                                    scope.listData = angular.copy($$code.getLocalCodes('', attrs.baseCode));
                                }
                            }
                        };
                        var initCheck = function () {
                            if (angular.isArray(scope.ngModel) && angular.isArray(scope.listData)) {
                                for (var i = 0; i < scope.ngModel.length; i++) {
                                    for (var j = 0; j < scope.listData.length; j++) {
                                        if (scope.ngModel[i] === scope.listData[j].codeCode) {
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
                                    //console.log(n, o);
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
                            //console.log("index-checkbox: " + index);
                            //console.log(scope.listData);
                            if (scope.ngDisabled || scope.listData[index].disabled == true) {
                                return false;
                            }
                            scope.listData[index].checked = !scope.listData[index].checked;
                            var arr = [];
                            for (var j = 0; j < scope.listData.length; j++) {
                                if (scope.listData[j].checked == true) {
                                    arr.push(scope.listData[j].codeCode);
                                }
                            }
                            scope.ngModel = arr;
                            $timeout(function () {
                                if(attrs.ngChange){
                                    scope.$parent.$eval(attrs.ngChange)
                                }
                            },0);
                            if (scope.ngRequired) {
                                if (scope.ngModel.length == 0) {
                                    if (!element.attr('errorText')) {
                                        element.after('<div class="validation-errorText"></div>');
                                        // element.attr('errorText', true);
                                        errorTextEle = element.next();
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
         * @name $$cherry.directive:comtreeList
         * @description
         * 机构树选择
         */
//         .directive('comTree', ['$timeout', '$parse', '$$finder', '$rootScope',
//             function ($timeout, $parse, $$finder,$rootScope) {
//                 return {
//                     require: '^ngModel',
//                     restrict: "E",
//                     scope: {
//                         ngModel: '=',
//                         ngValue: '='
//                     },
//                     templateUrl: "template/directive/comcodeTree.html",
//                     compile: function () {
//                         return function ($scope, element, attrs, ctrl) {
//                             $scope.switchFlag = false;
//                             $('#comTree').on("click", function () {
//                                 $scope.$apply(
//                                     function () {
//                                         if (!$scope.data) {
//
//                                             $$finder.find("queryCompanyTree", {
//                                                 // "userCode":"0537",
//                                                 // "loginComCode":"3400000000",
//                                                 "userCode": $rootScope.user.userCode,//用户代码
//                                                 "loginComCode": $rootScope.user.loginComCode,//用户登录机构
//                                                 "gradeCodes":"127"
//
//                                             }, {
//                                                 success:function (data) {
//                                                     console.log(111);
//                                                     console.log(data);
//                                                     //$scope.data = data.content.childs;
//                                                     $scope.data = data.content;
//                                                     console.log($scope.data);
//                                                 }
//                                             })
//                                         }
//
//                                         $scope.switchFlag = !$scope.switchFlag;
//                                     }
//                                 );
//
//                             });
//                             //开关触发器
//                             $scope.toggleNode = function (scope, node) {
//                                 // if (node.nodes && node.collapsed && node.nodes.length == 0) {
//                                 //     // getTree("", node);
//                                 //     scope.toggle();
//                                 // }
//                                 node.collapsed = !node.collapsed;
//                                 scope.toggle();
//                             };
//                             $scope.checked = [];
//                             $scope.checkNode = function (scope,node) {
//                                 console.log(scope)
//
//                                 //console.log($scope.checked());
//
//
//
//
//                                 if (node.isOperate == 1) {
//
//                                     //$scope.ngValue = node.comCName;
//
//
//                                     $scope.ngModel = node.comCode;
//                                     $scope.switchFlag = true;
//
//                                     console.log(node.checked)
//
//                                     if(node.checked == true){
//                                         console.log("选择了");
//                                         console.log(node.comCode);
//                                         $scope.checked.push(node.comCode);
//                                         console.log($scope.checked);
// ;
//                                     }else{
//                                         console.log("未选择");
//                                         console.log($scope.checked);
//                                         angular.forEach($scope.checked, function(list1,index){
//
//
//                                             if(list1 == node.comCode){
//                                                 console.log("删掉这个comcode");
//
//
//                                                 $scope.checked.splice(index,1)
//                                                 console.log(list1);
//                                                 console.log($scope.checked);
//
//                                             }
//
//                                         });
//
//                                     }
//
//                                 }else{
//
//                                     //$scope.ngValue =  "请重新选择！您只能选择颜色为黑色的机构";
//
//                                 }
//                             }
//                         }
//                     }
//                 }
//             }
//         ])


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
        .directive('comTree', ['$timeout', '$parse', '$$finder','$rootScope',
            function ($timeout, $parse, $$finder,$rootScope) {
                return {
                    require: 'ngModel',
                    restrict: "E",
                    scope: {
                        ngModel: '=',
                        ngValue: '=',
                        ngDisabled:'='
                    },
                    contollerAs: 'comTreeCtrl',
                    controller:function ($scope) {
                        $scope.comTreeCtrl = this;
                        //改变子孙级的状态
                        this.changeChildrenNodeStatus =function (node, _this) {
                            var _this = _this || this;
                            angular.forEach(node.childs, function (childrenNode) {
                                if(!childrenNode.ngDisabled&&!childrenNode.disabled){
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
                                    if (childrenNode.childs && childrenNode.childs.length > 0) {
                                        _this.changeChildrenNodeStatus(childrenNode, _this);
                                    }
                                }else {

                                };

                            })
                        };

                        //获取选中的节点
                        this.getCheckedData = function(data, checkAry, _this) {
                            var _this = _this || this;
                            var  checkAry = checkAry || [];
                            angular.forEach(data, function (childData) {
                                if (childData.checked) {
                                    var obj = angular.copy(childData);
                                    obj.childs = null;
                                    checkAry.push(obj);
                                    // checkAry.push(angular.copy(childData).childs = null)
                                }
                                if (childData.childs && childData.childs.length > 0) {
                                    _this.getCheckedData(childData.childs, checkAry, _this);
                                }
                            });
                            return checkAry
                        };

                        //检查兄弟级的状态 改变父级
                        this.checkBrotherNodeStatus = function(nodeScope, _this) {
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

                            angular.forEach(parentNodeValue.childs, function (brotherNode) {
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
                    link: function ($scope, element, attrs, ctrl,ddd) {
                        $scope.switchFlag = false; // 机构树开关
                        var multipleFlag = $scope.multipleFlag = false; //多选单选
                        var upExtend = $scope.upExtend = false; // 是否向上延伸
                        $scope.checkAry = []; // 选中数组
                         //$(element).find('#comTree').on("click", function () {
                        //$scope.openTree = function () {
                        //    if (!$scope.data) {
                        //        $$finder.find(attrs.url,{"type":"checkOrLoss"},{
                        //            success: function (data) {
                        //                console.log(data.content);
                        //                //$scope.treeData = data.content;
                        //                $scope.treeData = angular.copy(data.content);
                        //                if($rootScope.comlist!=undefined&&$rootScope.comlist.length>0){
                        //                    $scope.data=$rootScope.comlist;
                        //                }else if ($rootScope.riskListData!=undefined&&$rootScope.riskListData.length>0) {
                        //                    $scope.data=$rootScope.riskListData;
                        //                }else if($rootScope.modelComDtoList!=undefined&&$rootScope.modelComDtoList.length>0){//投保模板查询机构树
                        //                    $scope.data=$rootScope.modelComDtoList;
                        //                } else {
                        //                    $scope.data = data.content;
                        //                }
                        //                $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry );
                        //                if(multipleFlag) {
                        //
                        //                    angular.forEach($scope.checkAry, function (item) {
                        //                        console.log( $scope.ngValue);
                        //                        $scope.ngValue.push(item.comCName);
                        //                        $scope.ngModel.push(item.comCode);
                        //                    });
                        //                }
                        //                // $timeout(function () {
                        //                //
                        //                //     // $scope.$evalAsync(function () {
                        //                //     $scope.$broadcast('angular-ui-tree:expand-all');
                        //                //     // $scope.$broadcast('angular-ui-tree:collapse-all');
                        //                // })
                        //                // });
                        //            }
                        //
                        //        })
                        //        // $$finder.post(attrs.url, {"type":"checkOrLoss"}).then(function (data) {
                        //        //     $scope.data = data.childList;
                        //        //     $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry );
                        //        //     if(multipleFlag){
                        //        //         angular.forEach($scope.checkAry, function (item) {
                        //        //             $scope.ngValue.push(item.name);
                        //        //             $scope.ngModel.push(item.id);
                        //        //         });
                        //        //     }
                        //        //     $scope.$evalAsync();
                        //        // })
                        //    }
                        //    $scope.switchFlag = !$scope.switchFlag;
                        //    if($rootScope.comlist!=undefined&&$rootScope.comlist.length>0){//条款机构树修改
                        //        $scope.data=$rootScope.comlist;
                        //        $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry );
                        //        if(multipleFlag) {
                        //            angular.forEach($scope.checkAry, function (item) {
                        //                console.log( $scope.ngValue);
                        //                $scope.ngValue.push(item.comCName);
                        //                $scope.ngModel.push(item.comCode);
                        //            });
                        //        }
                        //        $scope.$evalAsync();
                        //    }
                        //    if($rootScope.modelComDtoList!=undefined&&$rootScope.modelComDtoList.length>0){//投保模板机构树修改
                        //        $scope.data=$rootScope.modelComDtoList;
                        //        $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry );
                        //        if(multipleFlag) {
                        //            angular.forEach($scope.checkAry, function (item) {
                        //                console.log( $scope.ngValue);
                        //                $scope.ngValue.push(item.comCName);
                        //                $scope.ngModel.push(item.comCode);
                        //            });
                        //        }
                        //        $scope.$evalAsync();
                        //    }
                        //};
                        //var tree2=[];
                        var zTreeObj;
                        var setting = {
                            check:{
                                enable: true,
                                chkStyle : "checkbox",    //复选框
                                autoCheckTrigger: true,
                                chkDisabledInherit: false,
                                chkboxType: { "Y": "s", "N": "ps" }
                            },
                            data:{
                                key:{
                                    checked:"ck",//是否选中
                                    name:"n",//名称
                                    children:"ch"
                                },
                                simpleData:{
                                    enable: true,
                                    idKey: "id",//code
                                    pIdKey: "pid"//pcode
                                }
                            }
                        };
                        $scope.changeflag=true
                        $scope.openTree=function(){
                            //控制按钮的显示
                            if($rootScope.comTreeCtrlFlag){//只显示返回按钮
                                $scope.backBtnFlag=true;
                            }else{
                                $scope.backBtnFlag=false;
                            }

                            $scope.switchFlag =true;
                            $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            ////页面重复 节点 需要优化
                            //var list=$("ul[name=ztree-dddd]");
                            //if(list!=null && list.size()>=2){
                            //    list.get(0).remove();
                            //}
                            if(!$scope.tree2||$scope.tree2.length==0) {
                                $$finder.find(attrs.url, {"type": "checkOrLoss"}, {
                                    success: function (data) {
                                        if ($rootScope.comlist != undefined && $rootScope.comlist.length > 0) {//条款机构树查询
                                            $scope.tree2 = $rootScope.comlist;
                                        } else if ($rootScope.riskListData != undefined && $rootScope.riskListData.length > 0) {
                                            $scope.tree2 = $rootScope.riskListData;
                                        } else if ($rootScope.modelComDtoList != undefined && $rootScope.modelComDtoList.length > 0) {//投保模板查询机构树
                                            $scope.tree2 = $rootScope.modelComDtoList;
                                        } else {
                                            $scope.tree2 = data.content;
                                        }

                                       /* console.log(window.location.hash);
                                        var hash=window.location.hash;
                                        var obj;
                                        if(hash!=null && hash.length>0){
                                            hash=hash.substr(0,hash.indexOf("?"));
                                        }
                                        switch (hash){
                                            case "#/UIproposalshow":{
                                                obj=$("#comTree").find("ul[name=ztree-dddd]");
                                                break;
                                            }
                                            default :{
                                                console.log("bbbbb");
                                                if($rootScope.comTreeCtrlCommentFlag){
                                                    obj=$("#comTree").find("ul[name=ztree-dddd]");


                                                }else{
                                                    obj=$("#treeDemo");
                                                }

                                                break;
                                            }
                                        }*/
                                       var obj=$("#treeDemo");

                                        zTreeObj = $.fn.zTree.init(obj, setting, $scope.tree2);
                                        if ($rootScope.comlist != undefined && $rootScope.comlist.length > 0) {//条款机构树查询
                                            $scope.tree2 = [];
                                            $rootScope.comlist=[];
                                        } else if ($rootScope.riskListData != undefined && $rootScope.riskListData.length > 0) {
                                            $scope.tree2 = [];
                                            $rootScope.riskListData=[]
                                        } else if ($rootScope.modelComDtoList != undefined && $rootScope.modelComDtoList.length > 0) {//投保模板查询机构树
                                            $scope.tree2 = [];
                                            $rootScope.modelComDtoList=[];
                                        }
                                        /*if($rootScope.comTreeCtrlCommentFlag&&obj==$("#comTree").find("ul[name=ztree-dddd]")){
                                            zTreeObj.checkAllNodes(false);
                                        }*/
                                       /* if($rootScope.treecheck!=null&&$rootScope.treecheck.length>0){
                                            angular.forEach($rootScope.treecheck, function (dto,index) {
                                                var nodes=zTreeObj.getNodeByParam("id",dto.id);
                                                nodes["ck"]=true;
                                            })
                                        }*/
                                    },
                                    error: function (error) {
                                        console.error("机构数获取异常:", angular.fromJson(error));
                                    }
                                });
                            }else if($scope.tree2){
                                //zTreeObj.checkAllNodes(false);
                                console.log($scope.tree2);
                                if($rootScope.clauseflag){
                                    $scope.changeflag=true;
                                    $rootScope.clauseflag=false
                                }
                                if ($rootScope.comlist != undefined && $rootScope.comlist.length > 0&&$scope.changeflag) {//条款机构树查询
                                    //$scope.tree2 = $rootScope.comlist;
                                    $scope.tree3 = $rootScope.comlist;
                                    var obj=$("#treeDemo");
                                    zTreeObj = $.fn.zTree.init(obj, setting, $scope.tree3);
                                    $scope.tree2=[];
                                    //zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, $rootScope.comlist);
                                    $scope.changeflag=false;
                                } else if ($rootScope.riskListData != undefined && $rootScope.riskListData.length > 0) {
                                    $scope.tree3 = $rootScope.riskListData;
                                    var obj=$("#treeDemo");
                                    zTreeObj = $.fn.zTree.init(obj, setting, $scope.tree3);
                                    $scope.tree2=[];
                                    //$scope.tree2 = $rootScope.riskListData;
                                } else if ($rootScope.modelComDtoList != undefined && $rootScope.modelComDtoList.length > 0) {//投保模板查询机构树
                                    $scope.tree3 = $rootScope.modelComDtoList;
                                    var obj=$("#treeDemo");
                                    zTreeObj = $.fn.zTree.init(obj, setting, $scope.tree3);
                                    $scope.tree2=[];
                                }
                             }
                            $("#getSelectedBtn").click(function() {
                                if (zTreeObj != "" && zTreeObj != undefined) {
                                    var nodes = zTreeObj.getCheckedNodes(true);
                                    $rootScope.treecheck = nodes;
                                    console.log(nodes)
                                }
                            });
                            if($scope.backBtnFlag){//禁用

                            }
                            function isIE() {
                                if (!!window.ActiveXObject || "ActiveXObject" in window){
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if(isIE()){
                                document.getElementById("getSelectedBtn").click();
                            }

                        }
                        if(isIE()){
                            $(".comTree-content").click(function () {
                                document.getElementById("getSelectedBtn").click();
                            })
                        }

                        $rootScope.cancelChecked = function(){
                            //zTreeObj.checkAllNodes(false);
                            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, $scope.tree2);
                        }
                        //var box = $('body').on("click",function(e) {
                        //    if($scope.tree2){
                        //        if($scope.switchFlag === false)return;// 关闭状态
                        //        var target = $(e.target);
                        //        if(target.parents("com-tree").length===0){
                        //            $scope.switchFlag = false; // 机构树关
                        //        }
                        //    }
                        //});

                        //重置机构树
                        $scope.refreshTree = function () {
                            console.log("重置")
                            //console.log($scope.treeData)
                            //$scope.data= $scope.treeData;
                          /*  zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, $scope.tree2);
                            $rootScope.treecheck=[];
                            $rootScope.treeInsure=false;*/
                            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                            treeObj.checkAllNodes(false);
                        }
                        if (attrs.multiple || attrs.multiple === ''){ // 区分单选还是多选
                            multipleFlag = $scope.multipleFlag = true;
                        }
                        if (attrs.upExtend || attrs.upExtend === ''){ //  是否向上延伸
                            upExtend = $scope.upExtend = true;
                        }
                        // 单选参数处理
                        if(multipleFlag){
                            if (!angular.isDefined($scope.ngModel)||$scope.ngModel === null){ // 对未定义的参数予以宽容
                                $scope.$evalAsync(function(){  $scope.ngModel = []; });
                            } else {
                                throw (new Error('[comTree dirctive multiple state] ngModel got [0]'))
                            }
                            if (!angular.isDefined($scope.ngValue)||$scope.ngValue === null){ // 对未定义的参数予以宽容
                                $scope.$evalAsync(function(){  $scope.ngValue = []; });
                            } else {
                                throw (new Error('[comTree dirctive multiple state] ngValue got [0]'))
                            }
                        }
                        //开关触发器
                        $scope.toggleNode = function (scope, node) {
                            // if (node.nodes && node.collapsed && node.nodes.length == 0) {
                            //     // getTree("", node);
                            //     scope.toggle();
                            // }
                            node.collapsed = !node.collapsed;
                            scope.toggle();
                        };
                        $scope.checkNode = function (scope, node) {
                            if($scope.ngDisabled||node.disabled)return;
                            console.log(scope, node);
                            if (node.childs.length === 0&&!multipleFlag) {
                                $scope.ngValue = node.comCName;
                                $scope.ngModel = node.comCode;
                                $scope.switchFlag = false;
                                $("html,body").css({overflow:"auto"});//出现滚动条
                                $timeout(function () {
                                    if(attrs.ngChange){
                                        $scope.$parent.$eval(attrs.ngChange)
                                    }
                                });
                            } else if(node.childs.length > 0) {
                                node.collapsed = !node.collapsed;
                                scope.toggle();
                            }
                        };
                        //当多选checked发生变化 执行本方法
                        $scope.changeNodeMult = function (node, parent, parentNode) {
                            if($scope.ngDisabled||node.disabled)return;
                            node.checked = !node.checked;
                            // if(node.checked){
                            //     // 如果为勾选中
                            //     var obj = angular.copy(node);
                            //     obj.childs = null;
                            //     $scope.checkAry.push(obj)
                            // } else {
                            //     angular.forEach($scope.checkAry, function (child, index) {
                            //         if(child.comCode === node.comCode){
                            //             $scope.checkAry.splice(index, 1)
                            //         }
                            //     });
                            // }
                            $scope.comTreeCtrl.changeChildrenNodeStatus(node);
                            if(upExtend){
                                $scope.comTreeCtrl.checkBrotherNodeStatus(parentNode);
                            }
                            $scope.checkAry.length = 0;
                            $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry);
                            $scope.ngValue.length = 0;
                            $scope.ngModel.length = 0;
                            angular.forEach($scope.checkAry, function (item) {
                                $scope.ngValue.push(item.comCName);
                                $scope.ngModel.push(item.comCode);
                            });
                            $timeout(function () {
                                if(attrs.ngChange){
                                    $scope.$parent.$eval(attrs.ngChange)
                                }
                            });
                        };
                        // var box = $('body').on("click",function(e) {
                        //     if($scope.switchFlag === false)return;// 关闭状态
                        //     var target = $(e.target);
                        //     if(target.parents("com-tree").length===0){
                        //         $scope.switchFlag = false; // 机构树关
                        //     }
                        // });

                        // $scope.$on('$destroy', function (event) {
                        //     box.off();
                        // })
                        //关闭机构树
                        $scope.offswitchFlag = function () {
                            $rootScope.treeInsure=true;
                            $scope.switchFlag = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            //if($scope.data){
                            //    $rootScope.modelComDtoList=$scope.data;
                            //}
                        }
                        //机构树返回
                        $scope.returnSwitchFlag = function(){
                            if($rootScope.treeInsure==false){
                                $rootScope.treecheck=[];
                                zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, $scope.tree2);
                            }
                            $scope.switchFlag = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                        }
                    }
                }
            }
        ])
        .directive('comTree2', ['$timeout', '$parse', '$$finder','$rootScope',
            function ($timeout, $parse, $$finder,$rootScope) {
                return {
                    require: 'ngModel',
                    restrict: "E",
                    scope: {
                        ngModel: '=',
                        ngValue: '=',
                        ngDisabled:'='
                    },
                    contollerAs: 'comTreeCtrl',
                    controller:function ($scope) {
                        $scope.comTreeCtrl = this;
                        //改变子孙级的状态
                        this.changeChildrenNodeStatus =function (node, _this) {
                            var _this = _this || this;
                            angular.forEach(node.childs, function (childrenNode) {
                                if(!childrenNode.ngDisabled&&!childrenNode.disabled){
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
                                    if (childrenNode.childs && childrenNode.childs.length > 0) {
                                        _this.changeChildrenNodeStatus(childrenNode, _this);
                                    }
                                }else {

                                };

                            })
                        };

                        //获取选中的节点
                        this.getCheckedData = function(data, checkAry, _this) {
                            var _this = _this || this;
                            var  checkAry = checkAry || [];
                            angular.forEach(data, function (childData) {
                                if (childData.checked) {
                                    var obj = angular.copy(childData);
                                    obj.childs = null;
                                    checkAry.push(obj);
                                    // checkAry.push(angular.copy(childData).childs = null)
                                }
                                if (childData.childs && childData.childs.length > 0) {
                                    _this.getCheckedData(childData.childs, checkAry, _this);
                                }
                            });
                            return checkAry
                        };

                        //检查兄弟级的状态 改变父级
                        this.checkBrotherNodeStatus = function(nodeScope, _this) {
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

                            angular.forEach(parentNodeValue.childs, function (brotherNode) {
                                if (!brotherNode.checked) {
                                    checkedAll = false;
                                    return false
                                }
                            });
                            parentNodeValue.checked = checkedAll;
                            if (lastStatus != parentNodeValue.checked) { // 状态改变
                                //如果状态改变了，则要继续向上延伸
                                _this.checkBrotherNodeStatus(nodeScope.$parentNodeScope, _this);
                            }
                        }
                    },
                    templateUrl: "template/directive/comcodeTree2.html",
                    link: function ($scope, element, attrs, ctrl,ddd) {
                        $scope.switchFlag = false; // 机构树开关
                        var multipleFlag = $scope.multipleFlag = false; //多选单选
                        var upExtend = $scope.upExtend = false; // 是否向上延伸
                        $scope.checkAry = []; // 选中数组
                        //var tree2=[];
                        var zTreeObj;
                        var setting = {
                            check:{
                                enable: true,
                                chkStyle : "checkbox",    //复选框
                                autoCheckTrigger: true,
                                chkDisabledInherit: false,
                                chkboxType: { "Y": "s", "N": "ps" }
                            },
                            data:{
                                key:{
                                    checked:"ck",//是否选中
                                    name:"n",//名称
                                    children:"ch"
                                },
                                simpleData:{
                                    enable: true,
                                    idKey: "id",//code
                                    pIdKey: "pid"//pcode
                                }
                            }
                        };
                        $scope.changeflag=true
                        $scope.openTree=function(){
                            //控制按钮的显示
                            if($rootScope.comTreeCtrlFlag){//只显示返回按钮
                                $scope.backBtnFlag=true;
                            }else{
                                $scope.backBtnFlag=false;
                            }

                            $scope.switchFlag =true;
                            $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            ////页面重复 节点 需要优化
                            //var list=$("ul[name=ztree-dddd]");
                            //if(list!=null && list.size()>=2){
                            //    list.get(0).remove();
                            //}
                            if(!$scope.tree2) {
                                $$finder.find(attrs.url, {"type": "checkOrLoss"}, {
                                    success: function (data) {
                                        if ($rootScope.comlist != undefined && $rootScope.comlist.length > 0) {//条款机构树查询
                                            $scope.tree2 = $rootScope.comlist;
                                        } else if ($rootScope.riskListData != undefined && $rootScope.riskListData.length > 0) {
                                            $scope.tree2 = $rootScope.riskListData;
                                        } else if ($rootScope.modelComDtoList != undefined && $rootScope.modelComDtoList.length > 0) {//投保模板查询机构树
                                            $scope.tree2 = $rootScope.modelComDtoList;
                                        } else {
                                            $scope.tree2 = data.content;
                                        }

                                       /* console.log(window.location.hash);
                                         var hash=window.location.hash;
                                         var obj;
                                         if(hash!=null && hash.length>0){
                                         hash=hash.substr(0,hash.indexOf("?"));
                                         }
                                         switch (hash){
                                         case "#/UIproposalshow":{
                                         obj=$("#comTree").find("ul[name=ztree-dddd]");
                                         break;
                                         }
                                         default :{
                                         console.log("bbbbb");
                                         if($rootScope.comTreeCtrlCommentFlag){
                                         obj=$("#comTree").find("ul[name=ztree-dddd]");


                                         }else{
                                         obj=$("#treeDemo");
                                         }

                                         break;
                                         }
                                         }
                                         */
                                        obj=$("#comTree").find("ul[name=ztree-dddd]");
                                        zTreeObj = $.fn.zTree.init(obj, setting, $scope.tree2);
                                        /*if($rootScope.comTreeCtrlCommentFlag&&obj==$("#comTree").find("ul[name=ztree-dddd]")){
                                         zTreeObj.checkAllNodes(false);
                                         }*/
                                        if($rootScope.comTreeCtrlCommentFlag){
                                            var treeObj = $.fn.zTree.getZTreeObj("treeDemo2");
                                            treeObj.checkAllNodes(false);
                                            if($rootScope.treecheck!=null&&$rootScope.treecheck.length>0){
                                                angular.forEach($rootScope.treecheck, function (dto,index) {
                                                    if(dto.id){
                                                        var nodes=zTreeObj.getNodeByParam("id",dto.id);
                                                    }else{
                                                        var nodes=zTreeObj.getNodeByParam("id",dto.comCode);
                                                    }

                                                    nodes["ck"]=true;
                                                    zTreeObj.updateNode(nodes);
                                                })
                                            }
                                        }

                                    },
                                    error: function (error) {
                                        console.error("机构数获取异常:", angular.fromJson(error));
                                    }
                                });
                            }else if($scope.tree2){
                                //zTreeObj.checkAllNodes(false);
                                console.log($scope.tree2);
                                if($rootScope.clauseflag){
                                    $scope.changeflag=true;
                                    $rootScope.clauseflag=false
                                }
                                if ($rootScope.comlist != undefined && $rootScope.comlist.length > 0&&$scope.changeflag) {//条款机构树查询
                                    //$scope.tree2 = $rootScope.comlist;
                                    zTreeObj = $.fn.zTree.init($("#treeDemo2"), setting, $rootScope.comlist);
                                    $scope.changeflag=false;
                                } else if ($rootScope.riskListData != undefined && $rootScope.riskListData.length > 0) {
                                    $scope.tree2 = $rootScope.riskListData;
                                } else if ($rootScope.modelComDtoList != undefined && $rootScope.modelComDtoList.length > 0) {//投保模板查询机构树
                                    $scope.tree2 = $rootScope.modelComDtoList;
                                }
                                if($rootScope.comTreeCtrlCommentFlag){
                                    var treeObj = $.fn.zTree.getZTreeObj("treeDemo2");
                                    treeObj.checkAllNodes(false);
                                    if($rootScope.treecheck!=null&&$rootScope.treecheck.length>0){
                                        angular.forEach($rootScope.treecheck, function (dto,index) {
                                            if(dto.id){
                                                var nodes=zTreeObj.getNodeByParam("id",dto.id);
                                            }else{
                                                var nodes=zTreeObj.getNodeByParam("id",dto.comCode);
                                            }
                                            nodes["ck"]=true;
                                            zTreeObj.updateNode(nodes);
                                        })
                                    }
                                }

                            }
                           /* $("#getSelectedBtn2").click(function() {
                                if (zTreeObj != "" && zTreeObj != undefined) {
                                    var nodes = zTreeObj.getCheckedNodes(true);
                                    $rootScope.treecheck = nodes;
                                    console.log(nodes)
                                }
                            });*/
                            if($scope.backBtnFlag){//禁用

                            }
                            function isIE() {
                                if (!!window.ActiveXObject || "ActiveXObject" in window){
                                    return true;
                                }else{
                                    return false;
                                }
                            }
                            if(isIE()){
                                document.getElementById("getSelectedBtn2").click();
                            }

                        }
                        if(isIE()){
                            $(".comTree-content").click(function () {
                                document.getElementById("getSelectedBtn2").click();
                            })
                        }

                        $rootScope.cancelChecked = function(){
                            //zTreeObj.checkAllNodes(false);
                            zTreeObj = $.fn.zTree.init($("#treeDemo2"), setting, $scope.tree2);
                        }
                        //var box = $('body').on("click",function(e) {
                        //    if($scope.tree2){
                        //        if($scope.switchFlag === false)return;// 关闭状态
                        //        var target = $(e.target);
                        //        if(target.parents("com-tree").length===0){
                        //            $scope.switchFlag = false; // 机构树关
                        //        }
                        //    }
                        //});

                        //重置机构树
                        $scope.refreshTree = function () {
                            console.log("重置")
                            //console.log($scope.treeData)
                            //$scope.data= $scope.treeData;
                            /*  zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, $scope.tree2);
                             $rootScope.treecheck=[];
                             $rootScope.treeInsure=false;*/
                            var treeObj = $.fn.zTree.getZTreeObj("treeDemo2");
                            treeObj.checkAllNodes(false);
                        }
                        if (attrs.multiple || attrs.multiple === ''){ // 区分单选还是多选
                            multipleFlag = $scope.multipleFlag = true;
                        }
                        if (attrs.upExtend || attrs.upExtend === ''){ //  是否向上延伸
                            upExtend = $scope.upExtend = true;
                        }
                        // 单选参数处理
                      /*  if(multipleFlag){
                            if (!angular.isDefined($scope.ngModel)||$scope.ngModel === null){ // 对未定义的参数予以宽容
                                $scope.$evalAsync(function(){  $scope.ngModel = []; });
                            } else {
                                throw (new Error('[comTree dirctive multiple state] ngModel got [0]'))
                            }
                            if (!angular.isDefined($scope.ngValue)||$scope.ngValue === null){ // 对未定义的参数予以宽容
                                $scope.$evalAsync(function(){  $scope.ngValue = []; });
                            } else {
                                throw (new Error('[comTree dirctive multiple state] ngValue got [0]'))
                            }
                        }*/
                        //开关触发器
                        $scope.toggleNode = function (scope, node) {
                            // if (node.nodes && node.collapsed && node.nodes.length == 0) {
                            //     // getTree("", node);
                            //     scope.toggle();
                            // }
                            node.collapsed = !node.collapsed;
                            scope.toggle();
                        };
                        $scope.checkNode = function (scope, node) {
                            if($scope.ngDisabled||node.disabled)return;
                            console.log(scope, node);
                            if (node.childs.length === 0&&!multipleFlag) {
                                $scope.ngValue = node.comCName;
                                $scope.ngModel = node.comCode;
                                $scope.switchFlag = false;
                                $("html,body").css({overflow:"auto"});//出现滚动条
                                $timeout(function () {
                                    if(attrs.ngChange){
                                        $scope.$parent.$eval(attrs.ngChange)
                                    }
                                });
                            } else if(node.childs.length > 0) {
                                node.collapsed = !node.collapsed;
                                scope.toggle();
                            }
                        };
                        //当多选checked发生变化 执行本方法
                        $scope.changeNodeMult = function (node, parent, parentNode) {
                            if($scope.ngDisabled||node.disabled)return;
                            node.checked = !node.checked;
                            // if(node.checked){
                            //     // 如果为勾选中
                            //     var obj = angular.copy(node);
                            //     obj.childs = null;
                            //     $scope.checkAry.push(obj)
                            // } else {
                            //     angular.forEach($scope.checkAry, function (child, index) {
                            //         if(child.comCode === node.comCode){
                            //             $scope.checkAry.splice(index, 1)
                            //         }
                            //     });
                            // }
                            $scope.comTreeCtrl.changeChildrenNodeStatus(node);
                            if(upExtend){
                                $scope.comTreeCtrl.checkBrotherNodeStatus(parentNode);
                            }
                            $scope.checkAry.length = 0;
                            $scope.comTreeCtrl.getCheckedData($scope.data, $scope.checkAry);
                            $scope.ngValue.length = 0;
                            $scope.ngModel.length = 0;
                            angular.forEach($scope.checkAry, function (item) {
                                $scope.ngValue.push(item.comCName);
                                $scope.ngModel.push(item.comCode);
                            });
                            $timeout(function () {
                                if(attrs.ngChange){
                                    $scope.$parent.$eval(attrs.ngChange)
                                }
                            });
                        };
                        // var box = $('body').on("click",function(e) {
                        //     if($scope.switchFlag === false)return;// 关闭状态
                        //     var target = $(e.target);
                        //     if(target.parents("com-tree").length===0){
                        //         $scope.switchFlag = false; // 机构树关
                        //     }
                        // });

                        // $scope.$on('$destroy', function (event) {
                        //     box.off();
                        // })
                        //关闭机构树
                        $scope.offswitchFlag = function () {
                            $rootScope.treeInsure=true;
                            $scope.switchFlag = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            //if($scope.data){
                            //    $rootScope.modelComDtoList=$scope.data;
                            //}
                        }
                        //机构树返回
                        $scope.returnSwitchFlag = function(){
                            if($rootScope.treeInsure==false){
                                $rootScope.treecheck=[];
                                zTreeObj = $.fn.zTree.init($("#treeDemo2"), setting, $scope.tree2);
                            }
                            $scope.switchFlag = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                        }
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
                            str += '<div class="mesColor cardNumber" ng-show="enlargeText" ng-bind="enlargeText';
                            str += attrs.enlarge ? ' | ' + attrs.enlarge : '';
                            str += '" style="display: none;"></div>';
                            var compileFn = $compile(str);
                            var enlargeEl = $(compileFn($scope));
                            $(element).parent().append(enlargeEl);
                            $(element).focus(function () {
                                $scope.enlargeText = ctrl.$viewValue;
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
        .filter('riskFilter', ['$$code',function ($$code) {
            return function (val) {
                if(val){
                    var list = angular.copy($$code.getLocalCodes('', 'classCode1'));
                    var vv ;
                    angular.forEach(list, function(data){
                        if(data.codeCode == val){
                            vv = data.codeCName
                        }
                    })
                    return vv
                }


            };
        }])

});