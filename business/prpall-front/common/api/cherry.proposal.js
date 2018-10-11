/**
 * DESC       : 阳光车险api-提供了合并录单处理
 * AUTHOR     : 阳光项目组
 * CREATEDATE : 2016-10-28
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *              zhudongbo       2016-11-1     api规划
 *              zhaoguangzu     2016-11-18    费用信息接口
 *              zhaoguangzu     2016-11-21    商业险规则封装
 *              zhaoguangzu     2016-11-23    车辆信息规则封装
 *              zhaoguangzu     2016-12-07    proposal迭代
 */
define([
    'angular',
    'config',
    'codes',
    'constants'
], function (angular, config, codes, constants) {

    /**
     * @ngdoc service
     * @name $$cherry.$$proposal
     *
     * @description
     * cherry.proposal 提供了合并录单处理
     *
     */
    angular.module('cherry.proposal', [])
        .constant(
            'proposalConfig', {
                TARGET: {
                    //投保单录入
                    proposalSave:'proposalSave',
                }
            }
        )
        .factory('$$proposal', ['proposalConfig', '$http','$rootScope', '$timeout','$q','$$code',
            function ( proposalConfig,$http,$rootScope,$timeout,$q,$$code) {
                angular.extend(constants.TARGET, proposalConfig.TARGET);
                /**
                 *
                 * @param _proposal
                 * @param riskCode
                 * @param clauseType
                 * @param keywords
                 * @constructor
                 */
                var Proposal = function (_proposal, riskCode, clauseType, keywords) {
                    //proposal初始化数据模版
                    var PROPOSAL_TEMPLATE = {
                        "addEditExamine":"",//区分是录入的保存还是修改的保存
                        "isSaveFlag":"",//y
                        "editType":"",//y
                        "prpTmainDto":{
                            "systemFlag":'',//新老数据区分
                            "proposalNo":"",//投保单号131013400002008000463
                            "classCode":"",//险类
                            "riskCode":"",//险种
                            "versionNo":"",//条款
                            "policySort":"0",//保单种类
                            //基本信息
                            "comCode":"",//归属机构代码  有隐藏域 有
                            "handler1Code":"",//归属业务员代码  有隐藏域 有
                            "businessProvince":"",//归属区域  省 有
                            "businessTown":"",//归属区域  市 有
                            "businessCountry":"",//归属区域  区县 有
                            "businessAreaName":"",//归属区域：乡镇 有
                            "businessArea":"",//归属区域：村 有

                            "businessNature":"",//业务来源 y
                            "groupFlag":"",//业务大类 y
                            "businessType1":"",//政策/商业标志 y
                            "inceptionFlag":"",//是否验标 y
                            "notificationFlag":"",//是否承保公示 y
                            "businessType":"01",//业务类型 y00-非农险 ，01-农业险 ，02-涉农险
                            "thirdKnow":"",//是否通过第三方通识 y
                            "autoTransRenewFlag1":"",//缴纳方式 y
                            "startDate":"",//保险期间 y
                            "startHour":"",//y
                            "endDate":"",//保险期间 y
                            "endHour":"",//y
                            "operateDate":"",//投保日期 y
                            "signDate":"",//制单日期
                            "policyNo":"",//保单号 y
                            "operatorCode":"",//操作人  y
                            "inputDate":"",//操作日期

                            "updaterCode":"",//最近修改人  y
                            "updateDate":"",//最近修改日期  y
                            "eccFlag":"",//是否贫困标识
                            //合同信息
                            "policyType":"",//投保方式
                            "statQuantity":"",//承保数量 y
                            "statUnitCode":"",//承保数量单位
                            "sumInsured":"",//参保农户户次 y
                            "modelCode":"",//选择模块
                            "coinsFlag":"",//联共保标志 y
                            //后来要加的字段
                            "judicalCode":"1",//交费方式
                            "judicalScope":"1",//司法管辖,默认为1
                            "shareHolderFlag":"0",//股东业务标识下拉框，默认为0-否，1-是
                            "remark":"",//对应页面的出单员意见
                            "argueSolution":"1",//合同争议解决方式
                            "sumQuantity":"0",//被保险总数量/人数/户数--** 压力容器总
                            //隐藏域
                            "inputHour":"",//操作日期小时
                            "updateHour":"",//最近修改日期的小时
                            "appliCode":"",//投保人代码
                            "appliName":"",//投保人名称
                            "appliAddress":"",//投保人地址
                            "insuredCode":"",//被保险人代码
                            "insuredName":"",//被保险人名称
                            "insuredAddress":"",//被保险人地址
                            "pureRate":"0.00",//净费率
                            "discount":"100.00",//总折扣率
                            "currency":"",//币别代码获取的是币别信息中的保单汇总币别代码
                            "sumValue":"0.00",//总保险价值
                            "sumAmount":"",//总保险金额
                            "sumDiscount":"0.00",//总折扣金额
                            "sumPremium":"",//总保险费
                            "arbitBoardName":"",//仲裁单位名称
                            "payTimes":"",//缴费次数
                            "language":"C",//语种标志
                            "endorseTimes":"0",//批改次数
                            "claimTimes":"0",//理赔次数
                            "makeCom":"",//出单机构代码 隐藏域
                            "operateSite":"",//签单地点
                            "handlerCode":"",//经办人  隐藏域
                            "allinsFlag":"2",//统保标志
                            "underwriteFlag":"0",//核保标志
                            "othFlag":"000000YY000000000000",//其它标志字段
                            "flag":"",//状态字段
                            "businessFlag":"0",//页面默认值为1
                            "payMode":"0",//
                            "unitCode":"",//承保数量的计量单位代码
                            "articleType":"01",//专项业务
                            "startMinute":"0",//起保分钟
                            "endMinute":"0",//终保分钟
                            "validCountDate":"9999-12-31",//统计日期
                            "clauseType":"",//条款版本
                        },
                        //投保人y
                        "appliInsuredDto":{
                            "insuredFlag":'2',//被保人是1投保人事2
                            "proposalNo":"",//投保单号
                            "riskCode":"",//险种代码
                            "serialNo":"1",//序号
                            "insuredType":"",//客户类型
                            "identifyType":"",//证件类型
                            "identifyNumber":"",//证件号码
                            "insuredName":"",//客户名称
                            "insuredCode":"",//客户代码
                            "mobile":"",//移动电话
                            "validPeriod3":"",//证件有效期
                            "insuredAddress":"",//客户地址
                            "phoneNumber":"",//固定电话
                            "account":"",//开户账号
                            "bank":"",//开户行
                            "postCode":"",//邮政编码
                            "email":"",//电子邮件
                            "isCareClaim":"",//客户是否关注审计、理赔、退保信息
                            "cashFocus":"",//行业现金密度
                            "riskLevel":"",//风险等级
                            "nationality":"",//国籍//这个没有，以前是在新增里面的
                            "jobTitle":"",//职业//这个同上
                            "sex":"",//性别//这个同上
                        },
                        //被保人y
                        "insuredDto":{
                            "insuredFlag":'1',
                            "proposalNo":"",//投保单号
                            "riskCode":"",//险种代码
                            "serialNo":"2",//序号
                            "insuredType":"",//客户类型
                            "identifyType":"",//证件类型
                            "identifyNumber":"",//证件号码
                            "insuredName":"",//客户名称
                            "insuredCode":"",//客户代码
                            "mobile":"",//移动电话
                            "validPeriod3":"",//证件有效期
                            "phoneNumber":"",//固定电话
                            "insuredAddress":"",//客户地址
                            "businessSort":"",//公司性质
                            "linkerName":"",//联系人姓名
                            "account":"",//开户账号
                            "bank":"",//开户行
                            "postCode":"",//邮政编码
                            "email":"",//电子邮件
                            "isCareClaim":"",//客户是否关注审计、理赔、退保信息
                            "cashFocus":"",//行业现金密度
                            "riskLevel":"",//风险等级
                        },
                        //种植地点y
                        "prpTaddressDto":{
                            "proposalNo":"",//投保单号
                            "riskCode":"",//险种代码
                            "addressNo":"1",//序号
                            "addressCode":"10000",//邮政编码
                            "addressName":"",//地址
                        },
                        //币别信息 y
                        "prpTfeeDto":{
                            "proposalNo":"",//投保单号
                            "riskCode":"",//险种代码
                            "currency2":"",//汇总币别1
                            "currency1":"",//支付币别1
                            "currency":"",//币别1
                            "amount":"",//保额1
                            "premium":"",//保费1
                            "noTaxPremium":"",//原币不含税保费
                            "taxFee":"",//原币税额
                            "exchangeRate2":"",//汇总兑换率1
                            "amount2":"",//汇总币别保额1
                            "premium2":"",//汇总币别保费1
                            "noTaxPremium2":"",//汇总币别不含税保费
                            "taxFee2":"",//汇总币别税额1
                            //支付币别兑换率
                            "exchangeRate1":"",//汇总兑换率1
                            "amount1":"",//支付币别保额1
                            "premium1":"",//支付币别保费1
                            "noTaxPremium1":"",//汇总币别不含税保费
                            "taxFee1":"",//汇总币别税额1
                        },
                        //农险险种独有的主险附加险 y
                        "prpTitemKindAgriDtoList":[],
                        //主险附加险 y
                        "prpTitemKindDtoList":[],
                        //合同信息 y
                        "prpTmainAgriDto":{
                            "proposalNo":"",
                            "riskCode":"",
                            "raiseSite":"",//养殖地点
                            "remark":"",//按何种方式确定保险金额 y
                            "raiseDate":"",//种植时间
                            "relationListNo":"",//隐藏的我方清单号
                            "relationListNoRemark":"",//清单备注  y
                            //页面上没有的东西
                            "insureArea":"",//总投保面积
                            "flag":"",
                            "observeStartHour":0,
                            "observeEndHour":24,
                            "selfPremium":"",
                            "raiseType":"",//养殖户类型
                        },
                        //缴费计划y
                        "prpTplanDtoList":[],
                        //补贴y
                        "prpTsubsidyDtoList":[],
                        //客户信息中的发票购货方信息
                        "prpDcustomerTaxPayInfoDto":{
                            "payInfoObject":"",//开票对象
                            "customerName":"",//发票抬头
                            "invoiceType":"",//发票类型
                            "taxpayerNo":"",//税务登记证号
                            "taxpayerType":"",//纳税人身份
                            "address":"",//购方地址
                            "phone":"",//购方电话
                            "accountBank":"",//购方开户银行
                            "accountNo":"",//购方银行账号
                            "postName":"",//邮寄名称
                            "postPhone":"",//邮寄电话
                            "postAddress":"",//邮寄地址
                            "remark":"",//备注
                        },
                        "prpTrenewalDto":{
                            "proposalNo":"",
                            "oldPolicyNo":"",
                        },
                        //清单表格y
                        "insureMainListDto":[{
                            "listTypeFlag":"",//清单类型
                            "remark":"",//清单备注
                            "insureListCode":"",//清单号
                        }],

                        //y
                        "prpDcustomerunitDto":{
                            "postAddress":"",//联系地址
                        },
                        //y
                        "prpTcoinsDtoList":[
                        //    {
                        //    "serialNo":"",//序号（主共保信息录入）
                        //    "mainProposalNo":"",//主保单号码 y
                        //    "coinsType":"",//共保身份 y
                        //    "chiefFlag":"",//是否首席
                        //    "coinsCode":"",//共保人机构代码 y
                        //    "coinsName":"",//共保人名称 y
                        //    "coinsRate":"",//共保份额 y
                        //    "proportionFlag":"0",//页面隐藏域，手续费+特殊因子费：ProportionFlag1+ProportionFlag2
                        //    "coinsTreatyNo":""//共保协议号
                        //}
                        ],
                        //y
                        "prpTcoinsDetailDtoList":[
                        //    {
                        //    "serialNo":"",//序号（联共保信息）
                        //    "coinsCode":"",//共保人机构代码
                        //    "coinsName":"",//共保人名称
                        //    "currency":"",//币别
                        //    "coinsAmount":"", //额保
                        //    "coinsPremium":"",//保费
                        //    "agentFee":"",//手续费/经济费
                        //    "middleCostFee":"",//特殊因子费
                        //    "operateFee":"",//出单费
                        //}
                        ],
                        "prpTplanCoinsDtoList":[
                            //{
                            //"proposalNo":'',//投保单号
                            //"endorseNo":'',//批单号码
                            //"coinsCode":'',//共保人代码
                            //"serialNo":'',//交费次数序号
                            //"payNo":'',//交费期次
                            //"payReason":'',//交费原因
                            //"planDate":'',//计划交费截止日期
                            //"currency":'',//币别
                            //"planFee":'',//应交费金额
                            //"delinquentFee":'',//拖欠金额
                            //"flag":'',//标志字段
                            //"planStartDate":'',//计划交费开始日期
                            //"planRate":'',
                            ////"noTaxPremium":'',
                            ////"taxFee":''//税额

                        //}
                    ],
                        //特约信息表
                        "prpTengageDtoList":[],
                    };
                    _proposal.id = _proposal.id || '';// 单号
                    _proposal.type = _proposal.type || ''; //类型
                    _proposal.status = _proposal.status || ''; // 状态
                    //初始化投保单模版
                    if(_proposal.id == ''){
                        this.isSaveFlag=PROPOSAL_TEMPLATE.isSaveFlag;
                        this.editType=PROPOSAL_TEMPLATE.editType;
                        //this.clauseType=PROPOSAL_TEMPLATE.clauseType;//条款
                        this.prpTmainDto = PROPOSAL_TEMPLATE.prpTmainDto;//投保单录入
                        this.appliInsuredDto=PROPOSAL_TEMPLATE.appliInsuredDto;//投保人
                        this.insuredDto=PROPOSAL_TEMPLATE.insuredDto;//被保人
                        this.prpTaddressDto=PROPOSAL_TEMPLATE.prpTaddressDto;//种植地点
                        this.prpTfeeDto=PROPOSAL_TEMPLATE.prpTfeeDto;//币别信息
                        this.prpTitemKindAgriDtoList=PROPOSAL_TEMPLATE.prpTitemKindAgriDtoList;//农险险种独有的主险附加险
                        this.prpTitemKindDtoList=PROPOSAL_TEMPLATE.prpTitemKindDtoList;//主险附加险
                        this.prpTmainAgriDto=PROPOSAL_TEMPLATE.prpTmainAgriDto;//合同信息
                        this.prpTplanDtoList=PROPOSAL_TEMPLATE.prpTplanDtoList; //缴费计划
                        this.prpTsubsidyDtoList=PROPOSAL_TEMPLATE.prpTsubsidyDtoList;  //补贴
                        this.prpDcustomerTaxPayInfoDto=PROPOSAL_TEMPLATE.prpDcustomerTaxPayInfoDto;//客户信息的发票购货方信息
                        this.prpTcoinsDtoList = PROPOSAL_TEMPLATE.prpTcoinsDtoList;//投保单录入
                        this.prpTcoinsDetailDto = PROPOSAL_TEMPLATE.prpTcoinsDetailDto;//投保单录入
                        this.prpTengageDtoList=PROPOSAL_TEMPLATE.prpTengageDtoList;
                        this.prpDcustomerunitDto = PROPOSAL_TEMPLATE.prpDcustomerunitDto;//投保单录入
                        this.insureMainListDto=PROPOSAL_TEMPLATE.insureMainListDto;//清单表格
                        this.PrpTplanCoinsDtoList=PROPOSAL_TEMPLATE.PrpTplanCoinsDtoList//共保信息缴费计划
                    }
                    //prepareBIMainTemplate();
                    //prepareBISubTemplate();
                    //updateReadonlyStatus();
                };
                Proposal.prototype = {
                    /**
                     * 保存，暂存
                     * @param target
                     * @param options
                     * @param keywords
                     */
                    save: function (target, options, keywords) {
                        target = target || '';
                        //保存
                        if (target == constants.TARGET.proposalSave) {
                            var _data = this;
                            console.log('投保单保存begin'+ new Date);
                            $http({
                                method: "POST",
                                dataType: "JSON",
                                contentType: "application/json; charset=UTF-8",
                                url: config.backend.ip + config.backend.proposalSave,
                                headers: {},
                                data: _data
                            })
                                .success(function (data) {
                                    console.log('投保单保存end'+ new Date);
                                    $rootScope.$broadcast(constants.EVENTS.COMBINE_WAIT_END);
                                    //data = $$adapter.imports('proposalSave', data);
                                    if (options && options.success && typeof(options.success) == 'function')
                                        options.success(data);
                                })
                                .error(function (e) {
                                    console.log('投保单保存error'+ new Date);
                                    if (options && options.error && typeof(options.error) == 'function')
                                        options.error(e);
                                });

                        }
                    }
                };
                var _proposals = [];    //预留将来同时处理多投保单
                var _activeIndex = -1;
                /**
                 * 根据id匹配是否已经存在投保单数组中
                 * @param id
                 * @returns {number}
                 */
                //var matchProposal = function (id) {
                //    if (_proposals.length == 0)
                //        return -1;
                //
                //    var _index = -1;
                //    $.each(_proposals, function (index, _proposal) {
                //        if (_proposal.id == id) {
                //            _index = index;
                //            _activeIndex = index;
                //            return false;
                //        }
                //    });
                //
                //    return _index;
                //};

                /**
                 * 根据type匹配,类型（新保、投保单修改、暂存单继续录单、协议下录单）, 根据status匹录单初始化接口
                 * @param proposalObj
                 */
                /**
                 * 往数组中添加
                 * @param _proposal
                 */
                var pushProposal = function (_proposal) {
                    _proposals.push(_proposal);
                    _activeIndex = _proposals.length - 1;
                };
                //系统初始化完成开始录单初始化
                return{
                    /**
                     * @ngdoc
                     * @name $$cherry.$$proposal#Proposal
                     * @methodOf $$cherry.$$proposal
                     *
                     * @description
                     * 创建新投保单或者根据ID处理合并录单初始化操作
                     * @example
                     * $$cherry.$proposal.Proposal(proposalObj, options);
                     *
                     * @param {object} proposalObj 入参数据
                     * @param {object} options onSuccess/onError回调
                     *
                     * @returns {httpPromise} resolve with fetched data, or fails with error description.
                     */
                    Proposal: function (proposalObj, options) {
                        proposalObj = proposalObj || {};
                        options = options || {};
                        if (angular.isUndefined(proposalObj.id) || proposalObj.id == '') {
                            console.log('新建投保单');
                            pushProposal(new Proposal(proposalObj));
                            if (options && options.success && typeof(options.success) == 'function') {
                                options.success(_proposals[_activeIndex]);
                            }
                            return _proposals[_activeIndex];
                        } else {
                            //var matchIndex = matchProposal(proposalObj.id);
                            if (matchIndex >= 0) {
                                //return _proposals[matchIndex];
                            } else {
                                var _data = proposalObj;
                                var target={
                                    "method": "v0326",
                                    "auth": {},
                                    "log": {},
                                    "param": _data,
                                    "version": "",
                                    "channel": {}
                                };
                                //_data = $$adapter.exports('combineInputInit',target);

                                $http({
                                    method: "POST",
                                    dataType: "JSON",
                                    contentType: "application/json; charset=UTF-8",
                                    url: config.backend.ip + config.backend.combineInputInit,
                                    headers: {},
                                    data: _data
                                })
                                    .success(function (data) {
                                        if (options && options.success && typeof(options.success) == 'function') {
                                            if(data.data && data.data[10000]){
                                                options.success(data);
                                            }else {

                                            }
                                        }
                                    })
                                    .error(function (e, code) {
                                        if (options && options.error && typeof(options.error) == 'function')
                                            options.error(e);
                                    });
                            }
                        }
                    }
                }
            }])
        .service('$$proposalAPI', [ '$http','$rootScope', '$timeout','$location', '$q','$$code', '$$finder', '$anchorScroll', function ($http, $rootScope, $timeout, $location, $q, $$code, $$finder, $anchorScroll) {
            var $scope = null;
            var initAPI = function (scope) {
                $scope = scope || {};
                $scope.selectListData={};// 级联下拉列表数据
                // 投保方式下拉
                $scope.mulitSelectPolicyType = function (reqData,selectCode) {
                    selectCode = selectCode || '';
                    if(!$scope.initFlag){
                        $scope.proposal.prpTmainDto.policyType = '';
                        $scope.selectListData.policyTypeList= [];
                    }
                    $$finder.find('getOptionCodeTwo',{
                        prpDcodeListDtoList:[{
                            "codeType": "PolicyType",
                            "riskCode": reqData,//险种方案,
                            "hpFlag":0,//贫困标志TODO
                        }]
                    }, {
                        success: function (data) {
                            data.content.prpDcodeListDtoList[0].prpDcodeDtoList.unshift({codeCode:'',codeCName:'--请选择--'});//添加默认值
                            $scope.selectListData.policyTypeList=data.content.prpDcodeListDtoList[0].prpDcodeDtoList;
                            $scope.proposal.prpTmainDto.policyType = selectCode;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                };
                //证件类型下拉框初始化
                $scope.getIdentity=function(reqData,selectCode){
                    selectCode = selectCode || '';
                    $$finder.find('queryIdentifyType', {
                        "flag":  reqData
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.printFlagList1 = data.content.queryPrpDcodeDtoList;
                            $scope.proposal.appliInsuredDto.identifyType=selectCode;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
                /**
                 * 归属机构选择调归属业务员初始化或查看修改
                 * @param reqData
                 * {
                 *      codeCode:归属机构选中代码
                 *      comCName:归属机构选中名称
                 *  }
                 * @param selectCode：归属业务员选中代码，当手动选择时可不传
                 */
                $scope.prpMmodelMainDto={};
                $scope.getHanCode=function(reqData, selectCode){
                    //归属机构下拉初始化传参
                    var handCodeData={
                        "userCode": $rootScope.user.userCode,
                        "userName": $rootScope.user.userName,
                        "loginComCode":  $rootScope.user.loginComCode,
                        "loginGradeCodes": "111",
                        "tableName": "prpduser",
                        "userCodeFields": "userCode",
                        "comCodeFields": $scope.proposal.prpTmainDto.comCode,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode
                    };
                    selectCode = selectCode || '';
                    if(!$scope.initFlag){ // 手动录入归属机构时 清空归属业务员 生成投保单接口
                        $scope.proposal.prpTmainDto.handler1Code = '';
                        $scope.selectListData.handCodeList =[];
                        //$scope.createProposal(); //生成投保单接口
                    }
                    $scope.proposal.prpTmainDto.comCName=reqData.comCName;
                    //$scope.handCodeData.comCodeFields= $scope.proposal.prpTmainDto.comCode;
                    // handCodeList归属业务员下拉列表
                    $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                        $scope.selectListData.handCodeList = data;
                        $scope.proposal.prpTmainDto.handler1Code = selectCode;
                    });
                }
                //comCodeList获取归属机构下拉列表
                $scope.getComCodeList=function(){
                    var comCodeData={
                        comCode: '',
                        comCName: '',
                        riskCode: $scope.proposal.prpTmainDto.riskCode,
                        gradeCodes: '111',
                        userCode: $rootScope.user.userCode,
                        loginComCode: $rootScope.user.loginComCode
                    };
                    $$code.getCodes('codeType', 'queryComCodeInfo', { },comCodeData).then(function (data) {
                        $scope.selectListData.comCodeList = data;
                    });
                };
                //生成投保单号--将投保单号生成移到点击下一步方法中
                // $scope.createProposal=function(){
                //     $scope.proposal.prpTmainDto.comCode&&$$finder.find('creatProposal', {
                //         "tableName": "prptmain",//表名
                //         "iYear": new Date().getFullYear(),//当前年份
                //         "riskCode":$scope.proposal.prpTmainDto.riskCode,
                //         "iComCode":$scope.proposal.prpTmainDto.comCode,
                //         "userCode": $rootScope.user.userCode
                //     }, {
                //         success: function (data) {
                //             console.log(data)
                //             $scope.proposal.prpTmainDto.proposalNo=data.content.billNo;
                //         },
                //         error: function (e) {
                //             options.error(e);
                //         }
                //     });
                // };
                //承保数量计数单位
                $scope.mulitSelectUnit = function (reqData) {
                    $$finder.find('getOptionCodeTwo',{
                        prpDcodeListDtoList:[{
                            "codeType": "Unit",
                            "riskCode": reqData,//险种方案,
                        }]
                    }, {
                        success: function (data) {
                            var datas=data.content.prpDcodeListDtoList[0]
                            $scope.selectListData.unitList=datas.prpDcodeDtoList;
                            $scope.proposal.prpTmainDto.statUnitCode=datas.prpDcodeDtoList[0].codeCode;//默认承保数量单位第一个
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                };
                //养殖方式
                $scope.mulitSelectRaiseType = function (reqData,selectCode) {
                    selectCode = selectCode || '';
                    $$finder.find('getOptionCodeTwo',{
                        prpDcodeListDtoList:[{
                            "codeType": "RaiseType",
                            "riskCode": reqData,//险种方案,
                        }]
                    }, {
                        success: function (data) {
                            data.content.prpDcodeListDtoList[0].prpDcodeDtoList.unshift({codeCode:'',codeCName:'--请选择--'});//添加默认值
                            $scope.selectListData.raiseTypeList=data.content.prpDcodeListDtoList[0].prpDcodeDtoList;
                            $scope.proposal.prpTmainAgriDto.raiseType = selectCode;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                };
                //滚动条控制
                $scope.goScroll = function (id) {
                    //$location.hash(id);

                    var top=document.getElementById(id).offsetTop;
                    $(window).scrollTop(top-130);

                    //var top=0;
                    //switch (id){
                    //    case "basic":{
                    //        top=200;
                    //        break;
                    //    }
                    //    case "contract":{
                    //        top=800;
                    //        break;
                    //    }
                    //    case "client":{
                    //        top=2088;
                    //        break;
                    //    }
                    //    case "others":{
                    //        top=2595;
                    //        break;
                    //    }
                    //}
                    //$(window).scrollTop(top);
                    //alert(top);
                    //$anchorScroll();
                };

            };
            return {
                initAPI: initAPI
            }
        }])
});