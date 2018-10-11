/**
 */
define([
    'angular',
    'config',
    'constants'
], function (angular, config, constants) {
    /**
     * @ngdoc service
     * @name $$cherry.$$finder
     *
     * @description
     * cherry.finder 提供了对各种信息的查询
     *
     */
    angular.module('cherry.finder', [])
    //    .config(function ($httpProvider) {
    //    $httpProvider.defaults.transformRequest = function(data){
    //        if (data === undefined) {
    //            return data;
    //        }
    //        return $.param(data);
    //    }
    //    $httpProvider.defaults.headers.post= {
    //        'Content-Type':'application/x-www-form-urlencoded'
    //    }
    //})
        .constant(
        'finderConfig', {
            TARGET: {
                MENUDATA: 'menuData',
                //常用功能
                QUERYUSERMENUINFO:'queryUserMenuInfo',//常用功能查询
                SAVEUSERMENU:'saveUserMenu',//常用功能保存
                DELETEUSERMENUINFO:'deleteUserMenuInfo',//常用功能删除
                //投保单录入
                UPLOADFILE:'uploadfile',//影像资料管理
                SENDMESSAGEQUERY:'sendmessagequery',//短信发送查询
                CLAUSEMANAGE:'clausemanage',//条款版本管理

                QUERYBYPKANDTRANSLATE:'queryByPkAndTranslate',//根据条款查询相应的政策性
                QUERYALLCLASS:'queryAllClass',//查询所有险类
                PAYMANAGE:'paymanage',//支付信息管理
                CUSTOMER:'customer',//客户设置
                QUERYPOLICYlISTBYCONDITON: 'queryPolicyListByConditon',//保单查询相关信息
                GETVISATYPEDATA: 'GetVisaTypeData',//保单打印设置下的单证类型查询
                QUERYENDORDERLISTINFO: 'queryEnorderListInfo',//批改查询
                ENDORSE: 'endorse',
                endorseProposal: 'endorseProposal',//批改查询
                SELECTEDGUARANTEEDETAIL: 'selectedGuaranteeDetails',//特殊批改被选中的保单详
                CREATPROPOSAL: 'creatProposal',//生成投保单号  生成清单号
                fullSurrender:'fullSurrender',//全单退保
                CancellationPolicy:'CancellationPolicy',//保单注销
                CHECKTERRORIST:'checkTerrorist',//查询恐怖分子
                PROPOSALMANAGEMENT:'proposalManagement',//投保模版查询
                PRPBUSINOESSLIST:'prpbusinoesslist',//业务清单查询
                BUSINESSLISTEXCEL:'prpbusinoesslistexcel',//业务清单导出
                SAVEPRPDCUSTOMERIDVUNIT: 'savePrpDcustomerIdvUnit',//保存客户新增信息
                GETOPTIONCODETWO: "getOptionCodeTwo",//页面初始化信息
                QUERYTERRORISTINFO: "queryTerroristInfo",//恐怖分子列表查询
                QUERYPROPOSALLISTINFOBYCONDITON: "queryProposalListInfoByConditon",//投保单查询
                PRPDCLAUSECODE: 'prpdClauseCode',//选择条款
                QUERYITEMBYRISKCODEANDCOM:'queryItemByRiskCodeAndCom',//模板出单向导的条款
                PRPMMODELMAINBYRISKCODE: 'prpMmodelMainByRiskCode',//选择模块
                QUERYCLAUSEBYRISKCODE: 'queryClauseByRiskCode',//特
                riskCode: 'riskCode',//险种接口
                queryKindCodeInfo:'queryKindCodeInfo',
                QUERYPLANTINGEXCELBYCONNECTION:"queryPlantingExcelByConnection",//分户清单查询
                WITHDRAWPROPOSALNOSUBMIT:"withdrawProposalnoSubmit",//投保单撤销，
                FINDGISINSUREMAINLISTS:'findGisInsureMainLists',//清单号查询
                QUERYPRPDCURRENCYBYCONDITION:'queryPrpDcurrencyByCondition',//查询币别的接口
                ENGAGEQUERYCLAUSEBYRISKCODE:'engageQueryClauseByRiskCode',//特约及附加信息查询服务接
                QUERYINSUREPRELIMINARYCONFIRM:'queryInsurePreliminaryConfirm',//清单号详细信息
                CURRENCYENSURE:'currencyEnsure',//币别信息中的保费计算
                QUERYBYRISKCODE: 'queryByRiskCode',//保费计算中的费率除数
                GETEXCHANGERATE:'getExchangeRate',//币别兑换率
                DEALTMAINFORYGZFROMPAGE:'dealTMainForYGZFromPage',//价税分离服务
                QUERYPREMIUMINFO:'queryPremiumInfo',
                QUERYBYRISKCODE1:'queryByRiskCode1',//条款新建里的查询险别代码
                QUERYPRPDITEMINFODTO:'queryPrpDitemInfoDto',//条款新建里得查询标的代码
                QUERYBYKINDCONTEXT:'queryByKindContext',//条款新建里的查询险别内容queryByRiskCode1
                QUERYPRPDCLAUSEINFO:'queryPrpdclauseInfo',
                QUERYPRPDCLAUSEINFOBYCONDITION:'queryPrpdclauseInfoByCondition',
                QUERYMYJOBBYCONDITION:'queryMyJobByCondition',//待处理任务数据显示
                GETVIEWTRACE:'getViewTrace',//核保信息查询
                CLAUSECODEDLE:'clauseCodeDel',//删除
                CLAUSECODEDLEALL:'clauseCodeDelAll',//多个删除
                DISABLECLAUSE:"disableClause",//根据条款代码停用启用条款
                PRPMODELMANDEL: "prpModelMainDel",//根据模板代码删除模板信息
                STATESETTINGS:'StateSettings',
                UIPROPOSALMANAGEMENT:'UIProposalManagement',//查询模板列表
                SUBMITUNDWRTBYPROPOSAL:'submitUndwrtByProposal',//提交核保
                QUERYPROPOSALINFO:'queryProposalInfo',//投保单详情
                QUERYNOTICEMODELPAGING:'queryNoticeModelPaging',//短信模板分页
                DISABLENOTICEMODEL:"disableNoticeModel",//短信模板停用启用
                DELETEUTILNOTICEMODEL:"deleteUtilNoticeModel",//短信模板删除
                QUERYSPECIAL: 'querySpecial',//特殊批改保单查询
                ENDORSEAPPROVAL: 'endorseapproval',//特殊批改生成批文
                ENDORSESAVE: 'endorsesave',//特殊批保存
                SPECIALENDORINI: 'specialEndorIni',//特殊批改初始化
                MODIFYPRPPTEXT:"modifyPrpPtext",//修改批文
                QUERYPRPPTEXTBYENDORSENO:"queryPrpPtextByEndorseNo",//查询批文
                SENDNOTICE: 'sendNotice',//短信和邮件发送
                SAVECLAUSEBYCOMBYKIND:'saveClauseByComByKind',//条款保存和暂存
                QUERYCOMPANYTREE: 'queryCompanyTree',// 机构树
                GETCOMPANYTREE:'getCompanyTree',//模板详细信息查询的机构树查询
                RESENDNOTICE:'resendNotice',//短信重新发送
                //SAVEPASSWORD:"savaPassword",//客户密码设置
                QUERYIDENTIFYTYPE:'queryIdentifyType',//客户证件类型
                QUERYBYPK:"queryByPK",//客户风险等级设置
                SAVEBYCUSTOMERRISKLEVEL:"saveByCustomerRiskLevel",//客户风险等级设置保存
                QUERYPRPMMODELMAINBYHYPERLINK:"queryPrpMmodelMainByHyperLink",//新建模板初始化
                GETSENDNUMBER:'getSendNumber',//获得短信发送数量
                FINDNOTICECONTENT:'findNoticeContent',//通过短信模板获得短信内容
                SAVEUNDWRTBYENDORSENO:'saveUndwrtByEndorseNo',//提交核批
                SAVEGISPLANTUPLOADLIST:'saveGisPlantUpLoadList',//清单文件信息上传
                SAVEGISLIST:'saveGisList',//清单文件信息保存
                QUERYAREASBYCONDITION:'queryAreasByCondition',//清单地址下拉框
				QUERYPLANTUPLOADLIST:'queryPlantUpLoadList',//清单上传信息分页展示
				QUERYPOLICYINFOBYPOLICYNO:'queryPolicyInfoByPolicyNo',//保单详情查询
                GETUNDWRTRACKRESPONSDATA:"getUndwrtTrackResponsData",//投保核查
                CHECKVISACODEVALID:"checkVisaCodeValid",//检查单证号码是否可用
                VERIFDISDATA:"VerifDisData",//单证核销
		        EXPORTEXCEL:'exportExcel',//清单模版导出
                FINDUTILNOTICEMODEL:'findUtilNoticeModel',//查询短信模板详细
                QUERYSMSLISTBYCONDITION: "querySmsListByCondition",//短信列表分页
                QUERYCOINSTREATY:"queryCoinsTreaty",//共保协议查询
                ADDUTILNOTICEMODEL:"addUtilNoticeModel",//短信模板新增
                UPDATEUTILNOTICEMODEL: 'updateUtilNoticeModel',//修改短信模板
                GETUSERINFO:"getUserInfo",//用户信息初始化
                MODIFYUSERINFO:"modifyUserInfo",//修改用户信息
                ISININSUREMAINLIST:'isInInsureMainList',//查询清单是否存在的接口
                MODIFYPWD:"modifypwd",//修改
                GETPROPERTYRULETOFRONT:'getPropertyRuleToFront',//险种配置查询
                CHECKBUSINESSCOMCODEINFO :'CheckBusinessComCodeInfo',//归属机构录入权限的校验
                QUERYCLAUSECODEBYCOMBYKIND:"queryClauseCodeByComByKind",//根据条款代码查询条款详细信息
                MODIFYCLAUSEBYCOMBYKIND:"modifyClauseByComByKind",//条款修改
                QUERYMARKEDLIST:'queryMarkedList',//标的清单查询
                QUERYINPUTPAYINFO:'queryInputPayInfo',// 支付信息录入查询
                QUERYMODIFYPAYINFO:'queryModifyPayInfo',// 支付信息查看、修改列表信息查询接口
                SAVESINGLEPAYINFO:'saveSinglePayInfo',// 整单支付信息保存服务
                SYNCHRONIZEACCOUNT:'synchronizeAccount',// 整单支付同步账户信息
                EXPORTINSURELISTEXCEL:'exportInsureListExcel',// 清单支付下载支付清单excel
                EXPORTENDORSELIST:'exportEndorseList',// 清单支付下载批改变化量清单excel
                SELECTFIND:'selectfind',
                QUERYITEMLISTCODEBYPK:'queryItemListCodeByPK',//清单标的代码查询
                QUERYVISACODESANDVISASERIALNOS:'queryVisaCodesAndVisaSerialNos',//流水号
                TRASHTRANSVISA:'trashTransVisa',//流水号作废
                VIDEOCHECKUPLOADING:"videoCheckUploading",//影像管理的上传与查看
                IMPORTPAYINFOEXCEL:'importPayInfoExcel',// 清单支付下载批改变化量清单excel
                QUERYPAYINFODETAILS:'queryPayInfoDetails',// 查询支付信息明细
                MODIFYSINGLEPAYINFO:'modifySinglePayInfo',// 修改整单支付信息
                MODIFYLISTPAYINFO:'modifyListPayInfo',// 修改整单支付信息
                GETSMSCONTENT:'getSmsContent',//短信发送内容
                QUERYCOMCODEINFO:'queryComCodeInfo',//归属机构查询
                SAVEBUTTON:'saveButton',//投保模板暂存保存
                GETPRPMMODELMAININFO:'getPrpmmodelmainInfo',//投保单保存判断模板是否失效
                QUERYENDORSLISTINFO:'queryEndorsListInfo',//批单列表查询
                QUERYENDORSLISTINFOIMAGE:'queryEndorsListInfoImage',//影像批单列表信息查询
                DELETEENDORSE:'deleteEndorse',//批量删除批单
                INITSELECT:'initSelect',
                FINDGISTFARMERLISTBYINSURELISTCODEANDSERIALNO:"findGisFarmerListByInsureListCodeAndserialNo",//清单农户查询
                CHECKURLPOWER:'checkURLPower',//URL权限校验
                QUERYCOMMONENDORSE:'queryCommonEndorse',
                QUERYGISFARMERITEMINFODETAIL:'queryGisFarmerItemInfoDetail',//根据清单号，序列号和标的清单号集合查询对应的标的列表信息
                QUERYGISFIELDLIST:'queryGisFieldList',//根据清单号查询田块信息
                QUERYHERDGISFIELDLIST:"queryHerdGisFieldList",//查询耳标号信息
                QUERYPAYINFOTYPE:"queryPayInfoType",
                GETPLANTINGEXCEL:"getPlantingExcel",
                GETPRPDCLAUSECODEINFO:'getPrpDclauseCodeInfo',//获取条款信息
                TRANSPORTXML:"transportXML",//信雅达影像上传与查看
                MARKLISTDOWNLOAD:"markListDownload",//标的清单列表下载
                QUERYPRINTNO:"queryPrintNo",//判断保单是否已经打印
                GETUSERREGION:"getUserRegion",//获取用户区域权限 核心段获取用户区域权限，五级联选
                DELETEALLUTILNOTICEMODEL:"deleteAllUtilNoticeModel",
                PAGEFINDBYCONDITIONS:'pageFindByConditions',//清单补全查询接口
                QUERYMAKEUPLISTBYINSURELISTCODE:'queryMakeUpListByInsureListCode',
                IMPORTEARLABELLIST:'importEarLabelList',
                SAVEENDORSEINFO:"saveEndorseInfo",
                QUERYRELATEBYPROPOSALNO:"queryRelateByProposalNo",
                POLICYPRINTSTATUS:"policyPrintStatus",
                QUERYUSERCODE:"queryUserCode",
                TRANSPORTXML:"transportXML",
                MARKLISTDOWNLOAD:"markListDownload",
                DELETEALLUTILNOTICEMODEL:"deleteAllUtilNoticeModel",
                GENERALENDORSEINIT:"generalEndorseInit",
                DEALENDORSEINFO:"dealEndorseInfo",
                QUERYENDORSEINFO:"queryEndorseInfo",
                QUERYCPOLICYINFO:"queryCPolicyInfo",
                CHECKENDORSE:"checkEndorse",
                INITSELECT:"initSelect",
                QUERYCOINSCOMCODEINFO:"queryCoinsComCodeInfo",
                FINDCOINSTREATY:"findCoinsTreaty",//查询共保协议
                GETRESPONSEQUERYREINSAGREEMENTDTOLIST:"getResponseQueryReinsAgreementDtoList",//获取再保协议业务数据方法
                CHANGEPASSWORD:"changePassword",//客户密码设置
                SAVEENDORSEINFO:"saveEndorseInfo",//普通批改
                ENDORSEPRINTSTATUS:"endorsePrintStatus",
                TRANSLATECODEBYPK:"getOperatorCode",//根据员工代码查询员工姓名
                QUERYBYITEMCODE:"queryByItemCode",//根据标的查询险种（快速出单）
                QUERYRISKCODEINFOQUICK: "queryRiskCodeInfoQuick",//快速出单查询
                QUERYFLAG:"queryFlag",//查询险别标的关联表查询是否计入承保数量
                QUERYPRPCMAININFO:'queryPrpCmainInfo',//根据清单编号进行重复性校验
                QUERYBYPRPNOPRPCMAININFO:'queryByPrpNoPrpCmainInfo',//疑似投保校验
                QUERYBYRISKCODEANDITEMCODE:"queryByRiskCodeAndItemCode",//查询短期费率
                GETEXDOREXCEL:"getEndorExcel",
                GETCHGENDOREXCEL:"getChgEndorExcel",
                GETAFTERENDOREXCEL:"getAfterEndorExcel",
                "QUERYBYPKBYMAP":"queryByPKByMap",//根据机构代码查询机构名称
                QUERYYBYPRPNOPRPCMAININFOLIST:'queryByPrpNoPrpCmainInfoList',//工作台疑似投保校验
                DOWNLOADEARLABELLIS:'downloadEarLabelList',// 下载带有农户信息的耳标号清单模板
                DOWNLOADJOINTINSURED:'downloadJointInsured',// 下载带有农户信息的连带被保险人清单模板
                MATCHGISITEMLIST:'matchGisItemList',// 匹配险种和所选清单的标的
                DOWNLOADPAYLISTTEMPLATE:'downloadPayListTempLate',//下载支付清单模板文件
                CALFEE:'calFee',
                CHECKDOESITEXIST:'checkDoesItExist',
                GETBANKINFO:'getBankInfo',// 查询开户银行信息
                FRONTEND:'frontEnd',
                CHECKITEMCODELISTMETHOD:'CheckItemCodeListMethod',//保费计算时校验标的清单与标的是否匹配（除新单外）
                SENDMAIL:'sendMail',
                QUERYBYPOLICYNO:'queryByPolicyNo',
            }
        })
        .factory('$$finder', ['finderConfig', '$http','$rootScope',
            function (finderConfig, $http,$rootScope) {
                angular.extend(constants.TARGET, finderConfig.TARGET);
                return {
                    find: function (target, keywords, options, pagination) {
                        /**
                         * @ngdoc
                         * @name $$cherry.$$finder#find:if(target == 'PROPOSAL')
                         * @methodOf $$cherry.$$finder
                         *
                         * @description
                         * 投保单查询列表查询接口
                         * @example
                         * $$finder.find('proposal',keywords,options,pagination)
                         * @param {string} type 查询类型
                         * @param {object} keywords 入参数据
                         * @param {object} options onSuccess/onError回调
                         * @param {object} pagination 分页信息
                         * @returns {httpPromise} resolve with fetched data, or fails with error description.
                         */
                        var getKeyWords = function () {
                            method.data = method.data || {};
                            for (var val in keywords) {
                                method.data.val = keywords.val
                            }
                        };
                        var method = {
                            method: "POST",
                            dataType: "JSON",
                            contentType: "application/json; charset=UTF-8",
                            headers: {}
                        };
                        //归属机构录入权限的校验
                        if (target == constants.TARGET.CHECKBUSINESSCOMCODEINFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.CheckBusinessComCodeInfo;
                        }
                        //前端地址后端配置
                        if (target == constants.TARGET.FRONTEND) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.FrontEnd;
                        }
                        if(target == constants.TARGET.CALFEE){
                            method.data =keywords
                            method.url =config.backend.ip + config.backend.calFee;
                        }
                        if(target == constants.TARGET.GETEXDOREXCEL){
                            method.data =keywords
                            method.url =config.backend.ip + config.backend.getEndorExcel;
                        }

                        if(target == constants.TARGET.GETCHGENDOREXCEL){
                            method.data =keywords
                            method.url =config.backend.ip + config.backend.getChgEndorExcel;
                        }
                        if(target == constants.TARGET.GETAFTERENDOREXCEL){
                            method.data =keywords
                            method.url =config.backend.ip + config.backend.getAfterEndorExcel;
                        }
                        if (target == constants.TARGET.SELECTFIND) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.selectfind;
                        }
                        if (target == constants.TARGET.QUERYITEMLISTCODEBYPK)  {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryItemListCodeByPK;
                        }
                        //险种配置查询
                        if (target == constants.TARGET.GETPROPERTYRULETOFRONT) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getPropertyRuleToFront;
                        }
                        //查询条款信息
                        if (target == constants.TARGET.GETPRPDCLAUSECODEINFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getPrpDclauseCodeInfo;
                        }
                        //查询清单是否存在的接口
                        if (target == constants.TARGET.ISININSUREMAINLIST) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.isInInsureMainList;
                        }
                        //根据清单编号进行重复性校验
                        if (target == constants.TARGET.QUERYPRPCMAININFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryPrpCmainInfo;
                        }
                        //清单补全查询列表接口
                        if (target == constants.TARGET.PAGEFINDBYCONDITIONS) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.pageFindByConditions;
                        }
                        //投保单保存疑似重复投保校验
                        if (target == constants.TARGET.QUERYBYPRPNOPRPCMAININFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryByPrpNoPrpCmainInfo;
                        }
                        if (target == constants.TARGET.QUERYMAKEUPLISTBYINSURELISTCODE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryMakeUpListByInsureListCode;
                        }
                        //常用功能保存
                        if (target == constants.TARGET.SAVEUSERMENU) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.saveUserMenu;
                        }
                        //工作台疑似投保校验
                        if (target == constants.TARGET.QUERYYBYPRPNOPRPCMAININFOLIST) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryByPrpNoPrpCmainInfoList;
                        }
                        //根据员工代码查询员工姓名
                        if (target == constants.TARGET.TRANSLATECODEBYPK) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getOperatorCode;
                        }
                        //保费计算时校验标的清单与标的是否匹配（除新单外）
                        if (target == constants.TARGET.CHECKITEMCODELISTMETHOD) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.CheckItemCodeListMethod;
                        }
                        //清单补全 上传
                        if (target == constants.TARGET.IMPORTEARLABELLIST) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.importEarLabelList;
                        }
                        //常用功能查询
                        if (target == constants.TARGET.QUERYUSERMENUINFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryUserMenuInfo;
                        }
                        //常用功能删除
                        if (target == constants.TARGET.DELETEUSERMENUINFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.deleteUserMenuInfo;
                        }
                        //清单农户查询
                        if (target == constants.TARGET.FINDGISTFARMERLISTBYINSURELISTCODEANDSERIALNO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.findGisFarmerListByInsureListCodeAndserialNo;
                        }
                        //提交核保
                        if (target == constants.TARGET.SUBMITUNDWRTBYPROPOSAL) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.submitUndwrtByProposal
                        }
                        //核保信息查询
                        if (target == constants.TARGET.GETVIEWTRACE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getViewTrace
                        }
                        //价税分离
                        if (target == constants.TARGET.DEALTMAINFORYGZFROMPAGE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.dealTMainForYGZFromPage
                        }
                        //币别兑换率
                        if (target == constants.TARGET.GETEXCHANGERATE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getExchangeRate
                        }
                        //查询模板
                        if (target == constants.TARGET.UIPROPOSALMANAGEMENT) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.UIProposalManagement
                        }
                        //特约及附加信息查询服务接
                        if (target == constants.TARGET.ENGAGEQUERYCLAUSEBYRISKCODE) {
                            method.data = {
                                "codeType": "ClauseCode",
                                "riskCode": "3107"
                            };
                            method.url = config.backend.ip + config.backend.engageQueryClauseByRiskCode
                        }
                        //币别查询接口
                        if (target == constants.TARGET.QUERYPRPDCURRENCYBYCONDITION) {
                            method.data = {
                                "codeMethod": "like",
                                "codeClass": "codeCode",
                                "codeValue": ""
                            }
                            method.url = config.backend.ip + config.backend.queryPrpDcurrencyByCondition
                        }
                        //根据条款代码删除条款信息
                        if (target == constants.TARGET.CLAUSECODEDLE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.clauseCodeDel
                        }
                        //根据条款代码删除多条款信息
                        if (target == constants.TARGET.CLAUSECODEDLEALL) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.clauseCodeDelAll
                        }
                        //根据条款代码停用启用条款
                        if (target == constants.TARGET.DISABLECLAUSE) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.disableClause
                        }
                        //根据条款查询相应的政策性标志
                        if (target == constants.TARGET.QUERYBYPKANDTRANSLATE) {
                            method.data =keywords
                            method.url = config.backend.ip + config.backend.queryByPkAndTranslate
                        }
                        //查询所有的险类
                        if (target == constants.TARGET.QUERYALLCLASS) {
                            method.data =keywords
                            method.url = config.backend.ip + config.backend.queryAllClass
                        }
                        //根据投保模板代码删除模板信息
                        if (target == constants.TARGET.PRPMODELMANDEL) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.prpModelMainDel
                        }
                        //投保模板代码启用或停用
                        if (target == constants.TARGET.STATESETTINGS) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.StateSettings
                        }
                        //投保单保存判断模板是否失效
                        if (target == constants.TARGET.GETPRPMMODELMAININFO) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.getPrpmmodelmainInfo
                        }
                        //业务清单查询
                        if (target == constants.TARGET.PRPBUSINOESSLIST) {
                            method.data = keywords
                            method.url= config.backend.ip + config.backend.prpbusinoesslist
                        }
                        //归属机构查询
                        if (target == constants.TARGET.QUERYCOMCODEINFO) {
                            method.data = keywords
                            method.url= config.backend.ip + config.backend.queryComCodeInfo
                        }
                        //业务清单导出
                        if (target == constants.TARGET.BUSINESSLISTEXCEL) {
                            method.data = keywords
                            method.url= config.backend.ip + config.backend.prpbusinoesslistexcel
                        }
                        //查询所有险种类型
                        if (target == constants.TARGET.riskCode) {
                            method.data = keywords
                            method.url= config.backend.ip + config.backend.riskCode
                        }
                        if (target == constants.TARGET.riskCode) {

                            method.url = config.backend.ip + config.backend.riskCode;
                            method.data = keywords

                        }
                        //根据清单号查询
                        if(target == constants.TARGET.QUERYGISFARMERITEMINFODETAIL){
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryGisFarmerItemInfoDetail
                        }
                        //查询田块信息
                        if(target == constants.TARGET.QUERYGISFIELDLIST){
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryGisFieldList
                        }
                        //查询耳标号信息
                        if(target == constants.TARGET.QUERYHERDGISFIELDLIST){
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryHerdGisFieldList
                        }
                        //选择条款
                        if (target == constants.TARGET.PRPDCLAUSECODE) {
                            method.data = {
                                "riskCode": keywords.riskCode || "",//险种
                                "comCode": keywords.comCode,//机构代码
                            };
                            method.url = config.backend.ip + config.backend.prpdClauseCode

                        }
                        //模板出单向导的条款
                        if(target == constants.TARGET.QUERYITEMBYRISKCODEANDCOM){
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryItemByRiskCodeAndCom
                        }
                        //投保单查询撤单
                        if (target == constants.TARGET.WITHDRAWPROPOSALNOSUBMIT) {
                            method.url = config.backend.ip + config.backend.withdrawProposalnoSubmit
                            method.data = {
                                "proposalNo": keywords,
                            };

                        }
                        //分户清单下载,投保单录入页面分户清单下载
                        if (target === constants.TARGET.GETPLANTINGEXCEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getPlantingExcel;
                        }
                        //分户清单下载
                        if (target == constants.TARGET.QUERYPLANTINGEXCELBYCONNECTION) {
                            method.data = {
                                "inusreListCode": "13190340102150616172617",
                                "pageNo": "2",
                                "pageSize": "10"
                            };
                            method.url = config.backend.ip + config.backend.queryPlantingExcelByConnection
                        }
                        //保单查询相关信息
                        if (target == constants.TARGET.QUERYPOLICYlISTBYCONDITON) {
                            var prpTmain = keywords || {};//个人信息
                            var BusinessType1 = prpTmain.BusinessType1 || {};
                            method.data = {
                                "riskCode": "",
                                "policyNo": prpTmain.policyNo,//保单号
                                "policyNoRan":prpTmain.policyNoRan,//保单号数组
                                "policyNoEnd": prpTmain.policyNoEnd,//保单号截止
                                "proposalNo": prpTmain.proposalNo,//投保单号
                                "printFlag": prpTmain.printFlag,//打印状态 0/1
                                "appliCode": prpTmain.appliCode,//投保人代码
                                "queryFlag":prpTmain.queryFlag,//如果是保单查询是1，批改是2
                                "appliName": prpTmain.appliName,//投保人名称
                                "insuredCode": prpTmain.insuredCode,//被保人代码
                                "insuredName": prpTmain.insuredName,//被保人名称
                                "startDate":prpTmain.startDate,//起保日期
                                "startDateEnd":prpTmain.startDateEnd ,//起保日期止期
                                "endDate": prpTmain.endDate,//终保日期
                                "endStartDate":prpTmain.endStartDate ,//终保日期止期
                                "sumAmount": prpTmain.sumAmount,//总保额
                                "sumPremium": prpTmain.sumPremium,//总保费
                                "handlerCode": prpTmain.handlerCode,//业务员代码
                                "operatorCode": prpTmain.operatorCode,//操作员代码
                                "operateDateStart":prpTmain.operateDateStart,//制单日期起期
                                "operateDateEnd": prpTmain.operateDateEnd,//制单日期止期
                                "businessType1": prpTmain.BusinessType1,//政策商业标志
                                "underWriteFlag": prpTmain.underWriteFlag,//投保状态
                                "fName": prpTmain.fName,//投保状态
                                "fCode": prpTmain.fCode,//投保状态
                                // "userCode": "0537",
                                // "loginComCode": "3400000000",
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "loginGradeCodes": "111",
                                "tableName": "PrpDcompany",
                                "userCodeFields": "userCode",
                                "comCodeFields": "comCode",
                                "comCode": prpTmain.comCode,//归属机构
                                "pageNo": prpTmain.pageNo,
                                "pageSize": prpTmain.pageSize,
                                "imagingSystemFlag":prpTmain.imagingSystemFlag

                            };
                            method.url = config.backend.ip + config.backend.queryPolicyListByConditon

                        }
                        //投保单查询与打印查询
                        if (target == constants.TARGET.QUERYPROPOSALLISTINFOBYCONDITON) {
                            var prpTmain = keywords || {};//个人信息
                            var BusinessType1 = prpTmain.BusinessType1 || {};
                            method.data=
                                {
                                    "proposalNo": prpTmain.proposalNo,//投保单号//prpTmain.proposalNo,//"132203400002008000045"//3101
                                    "riskCode": "3107", //险种代码
                                    "printNo": prpTmain.printFlag,//打印状态//proposal.prpTmain.printFlag
                                    "appliCode": prpTmain.appliCode,//投保人代码
                                    "appliName": prpTmain.appliName,//投保人名称
                                    "insuredCode": prpTmain.insuredCode,//被保险人代码
                                    "insuredName": prpTmain.insuredName,//被保险人名称
                                    "startDate": prpTmain.startDate,//起保开始时间
                                    "startDateEnd": prpTmain.startEndDate,//起保截止时间
                                    "endDate": prpTmain.endDate,//终保截止日期
                                    "endStartDate": prpTmain.endStartDate,//终保开始日期
                                    "sumAmount": prpTmain.sumAmount,//总保额
                                    "sumPremium": prpTmain.sumPremium,//总保费
                                    "makeCom": prpTmain.comCode,//出单机构//这里应该给的是出单机构
                                    "handlerCode": prpTmain.handler1Code,//业务员代码
                                    "operatorCode": prpTmain.operatorCode,//操作员代码
                                    "operateStartDate": prpTmain.operateStartDate,//制单起期
                                    "operateDateEnd": prpTmain.operateEndDate,//制单止期
                                    //"inputDate": "",//操作日期
                                    //"underwriteCode": "",//核保人代码
                                    //"underwriteName": "",//核保人名称
                                    //"underwriteEndDate": "",//核保通过日期
                                    "businessType1": prpTmain.BusinessType1,//商业标识
                                    "underWriteFlag": prpTmain.underWriteFlag,//投保状态
                                    "pageNo": prpTmain.pageNo,// 1,
                                    "pageSize": prpTmain.pageSize,//5,
                                    "userCodeFields": "userCode",
                                    "comCodeFields": "comCode",
                                    "userCode": $rootScope.user.userCode,//用户代码
                                    "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                    "loginGradeCodes": "111",//用户登录岗位代码//111
                                    "tableName": "PrpDcompany"//表名////PrpTcoins
                                };
                            method.url = config.backend.ip + config.backend.queryProposalListInfoByConditon
                        }
                        //批单删除
                        if (target == constants.TARGET.DELETEENDORSE)  {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.deleteEndorse;
                        }
                        //查询批文
                        if (target == constants.TARGET.QUERYPRPPTEXTBYENDORSENO)  {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryPrpPtextByEndorseNo;
                        }
                        //批单列表查询
                        if (target == constants.TARGET.QUERYENDORSLISTINFO) {
                            var prpTmain = keywords.prpTmain || {};//个人信息
                            method.data =
                                {
                                    "hpFlag": "",
                                    "userCode": $rootScope.user.userCode,//用户代码
                                    "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                    "loginGradeCodes": "111",
                                    "tableName": "PrpPhead",
                                    "userCodeFields": "userCode",
                                    "comCodeFields": "comCode",
                                    "riskCode": "3101",
                                    "policyNo": prpTmain.policyNo,//保单号//prpTmain.proposalNo,//"231013400002008000269"
                                    "endorseNo": prpTmain.endorseNo,//批单号
                                     "comCode":prpTmain.comCode,//归属机构代码
                                     "endorType":prpTmain.EndorType,//批改类型
                                     "handlerCode": prpTmain.handler1Code,//业务员代码
                                     "operatorCode": prpTmain.operatorCode,//操作员代码
                                     "appliName": prpTmain.appliName,//批改申请人
                                     "endorDateStart": prpTmain.endorDateStart,//批改日期起期
                                     "endorDateEnd": prpTmain.endorDateEnd,//批改日期止期
                                     "validDateStart": prpTmain.validDateStart,//生效日期起期
                                     "validDateEnd": prpTmain.validDateEnd,//生效日期止期
                                     "underwriteFlag":prpTmain.underwriteFlag,//核批标志，0-新批改,1-通过，2-不通过，3-无需核批，9-待核批
                                     "businessType1":prpTmain.BusinessType1,//01-中央政策性，02-地方政策性，00-商业性标志
                                    "pageNo": prpTmain.pageNo,// 1,页码
                                    "pageSize": prpTmain.pageSize,//5,页数

                                };
                            method.url = config.backend.ip + config.backend.queryEndorsListInfo
                        }

                        //影像批单列表信息查询
                        if (target == constants.TARGET.QUERYENDORSLISTINFOIMAGE) {
                            var prpTmain = keywords;//个人信息
                            method.data =
                                {
                                    "hpFlag": "",
                                    "userCode": $rootScope.user.userCode,//用户代码
                                    "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                    "loginGradeCodes": "111",
                                    "tableName": "PrpPhead",
                                    "userCodeFields": "userCode",
                                    "comCodeFields": "comCode",
                                    "riskCode": "3101",
                                    "policyNo": prpTmain.policyNo,//保单号//prpTmain.proposalNo,//"231013400002008000269"
                                    "endorseNo": prpTmain.endorseNo,//批单号
                                    "comCode": prpTmain.comCode,//归属机构代码
                                    "endorType": prpTmain.EndorType,//批改类型
                                    "handlerCode": prpTmain.handler1Code,//业务员代码
                                    "operatorCode": prpTmain.operatorCode,//操作员代码
                                    "appliName": prpTmain.appliName,//批改申请人
                                    "endorDateStart": prpTmain.endorDateStart,//批改日期起期
                                    "endorDateEnd": prpTmain.endorDateEnd,//批改日期止期
                                    "validDateStart": prpTmain.validDateStart,//生效日期起期
                                    "validDateEnd": prpTmain.validDateEnd,//生效日期止期
                                    "underwriteFlag": prpTmain.underwriteFlag,//核批标志，0-新批改,1-通过，2-不通过，3-无需核批，9-待核批
                                    "businessType1": prpTmain.BusinessType1,//01-中央政策性，02-地方政策性，00-商业性标志
                                    "pageNo": prpTmain.pageNo,// 1,页码
                                    "pageSize": prpTmain.pageSize,//5,页数
                        }
                            method.url = config.backend.ip + config.backend.queryEndorsListInfoImage;
                        }
                        //恐怖分子列表
                        if (target == constants.TARGET.QUERYTERRORISTINFO) {
                            method.data = {
                                "pageNo": 1,
                                "pageSize": 5
                            };
                            method.url = config.backend.ip + config.backend.queryTerroristInfo

                        }
                        //保存新的客户信息
                        if (target == constants.TARGET.SAVEPRPDCUSTOMERIDVUNIT) {
                            var prpDcustomerIdvDto = keywords.prpDcustomeridvDto || {};//个人信息
                            var prpDcustomerUnitDto = keywords.prpDcustomerUnitDto || {};//组织信息
                            var prpDcustomerTaxPayInfoDto = keywords.prpDcustomerTaxPayInfoDto || {};//纳税信息
                            var customerName;
                            if (keywords.customerType == 1) {//如果客户类型是个人，客户名称是个人名
                                customerName = prpDcustomerIdvDto.customerCName;
                            } else {//入股客户类型是组织，那么客户名称是组织名
                                customerName = prpDcustomerUnitDto.customerCName;
                            }
                            method.data = {
                                // "userCode": "0537",
                                // "comCode": "3400000400",
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "customerType": keywords.customerType,//客户类型
                                "prpDcustomerIdvDto": {
                                    "customerCode": "",
                                    "customerCName": prpDcustomerIdvDto.customerCName || '',//客户中文名称
                                    "addressCName": prpDcustomerIdvDto.linkAddress || '',//中文地址
                                    "identifyType": "02",//证件类型
                                    "identifyNumber": prpDcustomerIdvDto.identifyNumber || '',//证件号码
                                    "sex": "1",//性别
                                    "phoneNumber": prpDcustomerIdvDto.phoneNumber || '',//电话号码
                                    "occupationCode": "0123",//职业代码
                                    "customerkind": "01",//客户类型
                                    "customerFlag": "1",//Y	客户标志(0:临时/1:正式)
                                    "linkAddress": prpDcustomerIdvDto.linkAddress || '',//通信地址
                                    "lowerviewFlag": "0",//下级机构是否允许查看 1/是 0/否,待确认
                                    "riskLevel": "01",//风险等级
                                    "nationality": prpDcustomerIdvDto.nationality || ''//国籍
                                },
                                "prpDcustomerUnitDto": {
                                    "customerCName": prpDcustomerUnitDto.customerCName,//客户中文名称
                                    "addressCName": prpDcustomerUnitDto.postAddress,//客户中文地址
                                    "mobile": prpDcustomerUnitDto.mobile,//手机
                                    "linkerName": prpDcustomerUnitDto.customerCName,//联系人姓名
                                    "validStatus": "1",//效力状态,默认传1
                                    "handlerCode": "",//归属业务员代码
                                    "comCode": "",//归属机构代码
                                    "otherCodeNo": "",//其他证件号码
                                    "comType": "",//公司性质
                                    "socialCode": "",//组织机构代码
                                    "businesssSurce": ""//行业代码
                                },
                                "prpDcustomerTaxPayInfoDto": {
                                    "address": prpDcustomerTaxPayInfoDto.address,//纳税人地址
                                    "phone": prpDcustomerTaxPayInfoDto.phone,//纳税人电话
                                    "taxpayerType": "01",//prpDcustomerTaxPayInfoDto.taxpayerType,//纳税人身份
                                    "customerName": customerName//客户姓名
                                }
                            };
                            method.url = config.backend.ip + config.backend.savePrpDcustomerIdvUnit

                        }
                        //菜单
                        if (target == constants.TARGET.MENUDATA) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.menuData
                        }
                        //页面初始化
                        if (target == constants.TARGET.BusinessCategory) {
                            method.data = {};
                            method.url = config.backend.ip + config.backend.BusinessCategory
                        }
                        //影像资料
                        if (target == constants.TARGET.UPLOADFILE) {
                            method.data = {
                                "proposalNo": "132203400002008000045",//投保单号
                                "riskCode": "3220", //险种代码
                                "printNo": "",//打印状态
                                "queryPrintNoMethod": "",
                                "appliCode": "",//投保人代码
                                "appliName": "",//投保人名称
                                "insuredCode": "",//被保险人代码
                                "insuredName": "",//被保险人名称
                                "startDate": "",//起保日
                                "endDate": "",//终保日
                                "sumAmount": "",//总保额
                                "sumPremium": "",//总保费
                                "makeCom": "",//出单机构
                                "handlerCode": "",//
                                "operatorCode": "",//操作员代码
                                "operateStartDate": "",//制单起期
                                "operateEndDate": "",//制单止期
                                "inputDate": "",//操作日期
                                "underwriteCode": "",
                                "underwriteName": "",
                                "underwriteEndDate": "",
                                "businessType": "",//商业标识
                                "underWriteFlag": "",//投保状态
                                "pageNo": 1,
                                "pageSize": 1,
                                // "userCode": "0537",//用户代码
                                // "loginComCode": "3400000000",//用户登录机构
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "loginGradeCodes": "111",//用户登录岗位代码
                                "tableName": "PrpTcoins"//表名
                            };
                            method.url = config.backend.ip + config.backend.uploadfile
                        }
                        //短信发送查询
                        if (target == constants.TARGET.SENDMESSAGEQUERY) {
                            method.data = {
                                "proposalNo": "132203400002008000045",//投保单号
                                "riskCode": "3220", //险种代码
                                "printNo": "",//打印状态
                                "queryPrintNoMethod": "",
                                "appliCode": "",//投保人代码
                                "appliName": "",//投保人名称
                                "insuredCode": "",//被保险人代码
                                "insuredName": "",//被保险人名称
                                "startDate": "",//起保日
                                "endDate": "",//终保日
                                "sumAmount": "",//总保额
                                "sumPremium": "",//总保费
                                "makeCom": "",//出单机构
                                "handlerCode": "",//
                                "operatorCode": "",//操作员代码
                                "operateStartDate": "",//制单起期
                                "operateEndDate": "",//制单止期
                                "inputDate": "",//操作日期
                                "underwriteCode": "",
                                "underwriteName": "",
                                "underwriteEndDate": "",
                                "businessType": "",//商业标识
                                "underWriteFlag": "",//投保状态
                                "pageNo": 1,
                                "pageSize": 1,
                                // "userCode": "0537",//用户代码
                                // "loginComCode": "3400000000",//用户登录机构
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "loginGradeCodes": "111",//用户登录岗位代码
                                "tableName": "PrpTcoins"//表名
                            };
                            method.url = config.backend.ip + config.backend.sendmessagequery
                        }
                        //条款版本处理
                        if (target == constants.TARGET.CLAUSEMANAGE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.clausemanage

                        }
                        //支付信息处理
                        if (target == constants.TARGET.PAYMANAGE) {
                            method.data = {
                                "proposalNo": "132203400002008000045",//投保单号
                                "riskCode": "3220", //险种代码
                                "printNo": "",//打印状态
                                "queryPrintNoMethod": "",
                                "appliCode": "",//投保人代码
                                "appliName": "",//投保人名称
                                "insuredCode": "",//被保险人代码
                                "insuredName": "",//被保险人名称
                                "startDate": "",//起保日
                                "endDate": "",//终保日
                                "sumAmount": "",//总保额
                                "sumPremium": "",//总保费
                                "makeCom": "",//出单机构
                                "handlerCode": "",//
                                "operatorCode": "",//操作员代码
                                "operateStartDate": "",//制单起期
                                "operateEndDate": "",//制单止期
                                "inputDate": "",//操作日期
                                "underwriteCode": "",
                                "underwriteName": "",
                                "underwriteEndDate": "",
                                "businessType": "",//商业标识
                                "underWriteFlag": "",//投保状态
                                "pageNo": 1,
                                "pageSize": 1,
                                // "userCode": "0537",//用户代码
                                // "loginComCode": "3400000000",//用户登录机构
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "loginGradeCodes": "111",//用户登录岗位代码
                                "tableName": "PrpTcoins"//表名
                            };
                            method.url = config.backend.ip + config.backend.paymanage

                        }
                        //客户设置
                        if (target == constants.TARGET.CUSTOMER) {
                            method.data = keywords;
                            // {
                            //    "proposalNo": "132203400002008000045",//投保单号
                            //    "riskCode": "3220", //险种代码
                            //    "printNo": "",//打印状态
                            //    "queryPrintNoMethod": "",
                            //    "appliCode": "",//投保人代码
                            //    "appliName": "",//投保人名称
                            //    "insuredCode": "",//被保险人代码
                            //    "insuredName": "",//被保险人名称
                            //    "startDate": "",//起保日
                            //    "endDate": "",//终保日
                            //    "sumAmount": "",//总保额
                            //    "sumPremium": "",//总保费
                            //    "makeCom": "",//出单机构
                            //    "handlerCode": "",//
                            //    "operatorCode": "",//操作员代码
                            //    "operateStartDate": "",//制单起期
                            //    "operateEndDate": "",//制单止期
                            //    "inputDate": "",//操作日期
                            //    "underwriteCode": "",
                            //    "underwriteName": "",
                            //    "underwriteEndDate": "",
                            //    "businessType": "",//商业标识
                            //    "underWriteFlag": "",//投保状态
                            //    "pageNo": 1,
                            //    "pageSize": 1,
                            //    "userCode":"0537",//用户代码
                            //    "loginComCode":"3400000000",//用户登录机构
                            //    "loginGradeCodes":"111",//用户登录岗位代码
                            //    "tableName":"PrpTcoins"//表名
                            //};
                            method.url = config.backend.ip + config.backend.customer

                        }
                        if (target == constants.TARGET.SELECTEDGUARANTEEDETAIL) {
                            method.data = {};
                            method.url = config.backend.ip + config.backend.selectedGuaranteeDetails

                        }
                        if (target == constants.TARGET.ENDORSE) {
                            method.data = {};
                            var target = {
                                "method": "V0201",
                                "auth": {},
                                "log": {},
                                "param": _data,
                                "version": "",
                                "channel": {}
                            };
                            method.url = config.backend.ip + config.backend.endorse
                        }
                        //批改查询
                        if (target == constants.TARGET.endorseProposal) {
                            method.data = {
                                "selectQueryConfine": keywords.queryConfine || "",
                                "proposalNo": keywords.proposalNo || "",
                                "appliName": keywords.appliName || "",//投保人名称
                                "licenseNo": keywords.licenseNo || "",//号牌号码
                                "inputStartDate": keywords.inputStartDate || "",
                                "inputEndDate": keywords.inputEndDate || "",
                                "underWriteFlag": keywords.underWriteFlag || "",//核保标示
                                "requestType": keywords.queryType || "",//请求类型
                                "selectUserCode": keywords.handler2Code || "",
                                "selectUserName": keywords.handler2Name || "",
                                "selectComName": keywords.comName || "",
                                "selectComCode": keywords.comCode || ""
                            };
                            method.url = config.backend.ip + config.backend.endorseProposal
                        }
                        //生成投保单号  生成清单号creatProposal   creatProposal //获得条款保险责任代码
                        if (target == constants.TARGET.CREATPROPOSAL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.creatProposal
                        }
                        //选择模板
                        if (target == constants.TARGET.PRPMMODELMAINBYRISKCODE) {
                            method.data = {
                                "riskCode": keywords.riskCode || "",//险种
                                "comCode": keywords.comCode,//机构代码
                            };
                            method.url = config.backend.ip + config.backend.prpMmodelMainByRiskCode

                        }
                        if (target == constants.TARGET.fullSurrender) {
                            method.data = {
                                "selectQueryConfine": keywords.queryConfine || "",
                                "proposalNo": keywords.proposalNo || "",
                                "appliName": keywords.appliName || "",//投保人名称
                                "licenseNo": keywords.licenseNo || "",//号牌号码
                                "inputStartDate": keywords.inputStartDate || "",
                                "inputEndDate": keywords.inputEndDate || "",
                                "underWriteFlag": keywords.underWriteFlag || "",//核保标示
                                "requestType": keywords.queryType || "",//请求类型
                                "selectUserCode": keywords.handler2Code || "",
                                "selectUserName": keywords.handler2Name || "",
                                "selectComName": keywords.comName || "",
                                "selectComCode": keywords.comCode || ""
                            };
                            method.url = config.backend.ip + config.backend.fullSurrender

                        }
                        if (target == constants.TARGET.CancellationPolicy) {
                            method.data = {
                                "selectQueryConfine": keywords.queryConfine || "",
                                "proposalNo": keywords.proposalNo || "",
                                "appliName": keywords.appliName || "",//投保人名称
                                "licenseNo": keywords.licenseNo || "",//号牌号码
                                "inputStartDate": keywords.inputStartDate || "",
                                "inputEndDate": keywords.inputEndDate || "",
                                "underWriteFlag": keywords.underWriteFlag || "",//核保标示
                                "requestType": keywords.queryType || "",//请求类型
                                "selectUserCode": keywords.handler2Code || "",
                                "selectUserName": keywords.handler2Name || "",
                                "selectComName": keywords.comName || "",
                                "selectComCode": keywords.comCode || ""
                            };
                            method.url = config.backend.ip + config.backend.CancellationPolicy
                        }
                        if (target == constants.TARGET.queryKindCodeInfo) {
                            method.params = keywords;
                            method.url = config.backend.ip + config.backend.queryKindCodeInfo
                        }
                        //清单查询
                        if (target == constants.TARGET.FINDGISINSUREMAINLISTS) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.findGisInsureMainLists
                        }
                        //清单号详细信息
                        if (target == constants.TARGET.QUERYINSUREPRELIMINARYCONFIRM) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryInsurePreliminaryConfirm
                        }
                        //公用方法
                        if (target ==constants.TARGET.INITSELECT) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.initSelect
                        }
                        if (target == constants.TARGET.QUERYCOINSCOMCODEINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryCoinsComCodeInfo
                        }
                        //查询共保协议
                        if (target ==constants.TARGET.FINDCOINSTREATY) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.findCoinsTreaty
                        }
                        //获取再保协议业务数据方法
                        if (target ==constants.TARGET.GETRESPONSEQUERYREINSAGREEMENTDTOLIST) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getResponseQueryReinsAgreementDtoList
                        }
                        //币别信息中的保费计算
                        if (target == constants.TARGET.CURRENCYENSURE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.currencyEnsure;
                        }
                        //保费计算中的费率除数
                        if (target == constants.TARGET.QUERYBYRISKCODE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByRiskCode;
                        }
                        if (target == constants.TARGET.QUERYPREMIUMINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPremiumInfo;
                        }
                        //判断保单是否已经打印-+
                        if (target == constants.TARGET.QUERYPRINTNO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPrintNo;
                        }
                        if (target == constants.TARGET.QUERYPRPDCLAUSEINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPrpdclauseInfo;
                        }
                        if (target == constants.TARGET.QUERYPRPDCLAUSEINFOBYCONDITION) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.ByCondition;
                        }
                        //条款详细信息查询
                        if (target == constants.TARGET.QUERYCLAUSECODEBYCOMBYKIND) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryClauseCodeByComByKind;
                        }
                        //条款修改
                        if (target == constants.TARGET.MODIFYCLAUSEBYCOMBYKIND) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifyClauseByComByKind;
                        }
                        //条款信息的保存与暂存
                        if (target == constants.TARGET.SAVECLAUSEBYCOMBYKIND) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.saveClauseByComByKind;
                        }
                        //待处理任务数显示
                        if (target == constants.TARGET.QUERYMYJOBBYCONDITION) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryMyJobByCondition;
                        }
                        //条款新建里的查询险别代码
                        if (target == constants.TARGET.QUERYBYRISKCODE1) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByRiskCode1;
                        }
                        //条款新建里的查询标的代码
                        if (target == constants.TARGET.QUERYPRPDITEMINFODTO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPrpDitemInfoDto;
                        }
                        //条款新建里的查询险别内容
                        if (target == constants.TARGET.QUERYBYKINDCONTEXT) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByKindContext;
                        }
                        if (target == constants.TARGET.QUERYPRPDCLAUSEINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPrpdclauseInfo;
                        }
                        if (target == constants.TARGET.QUERYPRPDCLAUSEINFOBYCONDITION) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPrpdclauseInfoByCondition;
                        }
                        if (target ===constants.TARGET.GENERALENDORSEINIT) { // 普通批改初始化
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.generalEndorseInit;
                        }
                        if (target === constants.TARGET.DEALENDORSEINFO) { // 普通批点击下一步
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.dealEndorseInfo;
                        }
                        if (target === constants.TARGET.QUERYENDORSEINFO) { // 普通批改查看初始化
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryEndorseInfo;
                        }
                        if (target ===constants.TARGET.QUERYCPOLICYINFO) { // 普通批改获取保单信息
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryCPolicyInfo;
                        }
                        if (target ===constants.TARGET.CHECKENDORSE) { // 普通批改校验
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.checkEndorse;
                        }

                        //短信模板列表分页查询
                        if (target == constants.TARGET.QUERYNOTICEMODELPAGING) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryNoticeModelPaging;
                        }
                        //短信模板启用停用
                        if (target == constants.TARGET.DISABLENOTICEMODEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.disableNoticeModel;
                        }
                        //短信模板删除
                        if (target == constants.TARGET.DELETEUTILNOTICEMODEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.deleteUtilNoticeModel;
                        }
                        //短信列表分页
                        if (target == constants.TARGET.QUERYSMSLISTBYCONDITION) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.querySmsListByCondition;
                        }
                        //页面初始化加载
                        if(target==constants.TARGET.GETOPTIONCODETWO){

                            method.data=keywords;
                            method.url=config.backend.ip + config.backend.getOptionCodeTwo;
                        }
                        //页面初始化加载
                        if(target==constants.TARGET.INITSELECT){

                            method.data=keywords;
                            method.url=config.backend.ip + config.backend.initSelect;
                        }
                        // 支付信息录入列表信息查询
                        if (target === constants.TARGET.QUERYINPUTPAYINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryInputPayInfo;
                        }
                        // 获取投保单详情
                        if (target === constants.TARGET.QUERYPROPOSALINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryProposalInfo;
                        }
                        //特殊批改保单列表查询
                        if (target == constants.TARGET.QUERYSPECIAL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.querySpecial;//请求地址待确认
                        }
                        //特殊批改初始化
                        if (target == constants.TARGET.SPECIALENDORINI) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.specialEndorIni;//请求地址待确认
                        }
                        //特殊批改生成批文
                        if (target == constants.TARGET.ENDORSEAPPROVAL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.endorseapproval;//请求地址待确认
                        }
                        //根据机构代码查询机构名称
                        if (target == constants.TARGET.QUERYBYPKBYMAP) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByPKByMap;//请求地址待确认
                        }
                        //特殊批改保存
                        if (target == constants.TARGET.ENDORSESAVE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.endorsesave;//请求地址待确认
                        }
                        //修改批文
                        if (target == constants.TARGET.MODIFYPRPPTEXT) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifyPrpPtext;//请求地址待确认
                        }
                        //短信和邮件发送
                        if (target == constants.TARGET.SENDNOTICE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.sendNotice;
                        }
                        // 机构树

                        if (target == constants.TARGET.QUERYCOMPANYTREE) {
                            method.data = {
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "gradeCodes":"111"
                            };
                            method.url = config.backend.ip + config.backend.queryCompanyTree;
                        }
                        //模板详细信息查询的机构树查询
                        if (target == constants.TARGET.GETCOMPANYTREE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getCompanyTree;
                        }
                        // 短信重新发送
                        if (target == constants.TARGET.RESENDNOTICE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.resendNotice;
                        }

                        //客户密码设置
                        //if(target==constants.TARGET.SAVEPASSWORD){
                        //    method.data=keywords;
                        //    method.url=config.backend.ip + config.backend.savaPassword;
                        //}
                        //客户证件类型
                        if (target == constants.TARGET.QUERYIDENTIFYTYPE) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.queryIdentifyType
                        }
                        //客户风险等级设置
                        if (target == constants.TARGET.QUERYBYPK) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.queryByPK
                        }
                        //客户风险等级设置保存
                        if (target == constants.TARGET.SAVEBYCUSTOMERRISKLEVEL) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.saveByCustomerRiskLevel
                        }
                        //新建模板初始化//根据模板代码查询模板详细信息
                        if (target == constants.TARGET.QUERYPRPMMODELMAINBYHYPERLINK) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.queryPrpMmodelMainByHyperLink
                        }

                        //获得短信发送数量
                        if (target == constants.TARGET.GETSENDNUMBER) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.getSendNumber
                        }

                        //通过短信模板获得短信内容
                        if (target == constants.TARGET.FINDNOTICECONTENT) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.findNoticeContent
                        }
                        //清单信息保存
                        if(target==constants.TARGET.SAVEGISLIST){
                            console.log(keywords);
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.saveGisList;
                        }
                        //清单信息保存
                        if(target==constants.TARGET.QUERYAREASBYCONDITION){
                            console.log(keywords);
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.queryAreasByCondition;
                        }
			           //清单模版导出
                        if(target==constants.TARGET.EXPORTEXCEL){
                            console.log(keywords);
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.exportExcel;
                        }
                        if(target == constants.TARGET.QUERYPOLICYINFOBYPOLICYNO){//保单详情
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPolicyInfoByPolicyNo;//请求地址待确认
                        }
                        //检查单证号码是否可用
                        if(target == constants.TARGET.CHECKVISACODEVALID){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.checkVisaCodeValid;//请求地址待确认
                        }
                        //单证核销
                        if(target == constants.TARGET.VERIFDISDATA){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.VerifDisData;//请求地址待确认
                        }

                        //查询短信模板详细
                        if(target == constants.TARGET.FINDUTILNOTICEMODEL){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.findUtilNoticeModel;
                        }

                        //短信模板新增
                        if(target == constants.TARGET.ADDUTILNOTICEMODEL){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.addUtilNoticeModel;
                        }

                        //修改短信模板
                        if(target == constants.TARGET.UPDATEUTILNOTICEMODEL){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.updateUtilNoticeModel;
                        }

                        //投保模板暂存保存
                        if(target == constants.TARGET.SAVEBUTTON){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.saveButton;//请求地址待确认
                        }
                        //用户信息初始化
                        if(target == constants.TARGET.GETUSERINFO){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getUserInfo;//请求地址待确认
                        }
                        //修改用户信息
                        if(target == constants.TARGET.MODIFYUSERINFO){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifyUserInfo;//请求地址待确认
                        }
                        //修改密码
                        if(target == constants.TARGET.MODIFYPWD){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifypwd;//请求地址待确认
                        }
                        //标的清单查询
                        if(target == constants.TARGET.QUERYMARKEDLIST){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryMarkedList;
                        }
                        // 提交核批
                        if(target == constants.TARGET.SAVEUNDWRTBYENDORSENO){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.saveUndwrtByEndorseNo;//请求地址待确认
                        }

                        //清单信息上传
                        if(target==constants.TARGET.SAVEGISPLANTUPLOADLIST){
                            console.log(keywords);
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.saveGisPlantUpLoadList;
                        }
                       //影像管理的上传与查看
                        if(target == constants.TARGET.VIDEOCHECKUPLOADING){
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.videoCheckUploading;
                        }
                        // 支付信息查看、修改列表信息查询接口
                        if(target === constants.TARGET.QUERYMODIFYPAYINFO){
                            method.data=keywords;
                            method.url=config.backend.ip + config.backend.queryModifyPayInfo;
                        }
                        // 支付信息查看、修改列表信息查询接口
                        if(target === constants.TARGET.QUERYMODIFYPAYINFO){
                            method.data=keywords;
                            method.url=config.backend.ip + config.backend.queryModifyPayInfo;
                        }
                        // 整单支付信息保存
                        if (target === constants.TARGET.SAVESINGLEPAYINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.saveSinglePayInfo;
                        }
                        // 整单支付同步账户信息
                        if (target === constants.TARGET.SYNCHRONIZEACCOUNT) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.synchronizeAccount;
                        }
                        // 清单支付下载支付清单
                        if (target === constants.TARGET.EXPORTINSURELISTEXCEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.exportInsureListExcel;
                        }
                        // 清单支付下载批改变化量清单
                        if (target === constants.TARGET.EXPORTENDORSELIST) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.exportEndorseList;
                        }
                        //流水号
                        if (target == constants.TARGET.QUERYVISACODESANDVISASERIALNOS) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.queryVisaCodesAndVisaSerialNos
                        }
                        //流水号
                        if (target == constants.TARGET.TRASHTRANSVISA) {
                            method.data = keywords
                            method.url = config.backend.ip + config.backend.trashTransVisa;
                        }
                        ///短信发送内容
                        if (target == constants.TARGET.GETSMSCONTENT) {
                            method.data = keywords;
                            method.url=config.backend.ip + config.backend.getSmsContent
                        }

                        // 清单支付下载批改变化量清单
                        if (target === constants.TARGET.IMPORTPAYINFOEXCEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.importPayInfoExcel;
                        }
                        // 查询支付信息明细
                        if (target === constants.TARGET.QUERYPAYINFODETAILS) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPayInfoDetails;
                        }
                        // 修改清单单支付信息
                        if (target === constants.TARGET.MODIFYSINGLEPAYINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifySinglePayInfo;
                        }
                        // 查询批单的支付信息类型
                        if (target === constants.TARGET.QUERYPAYINFOTYPE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryPayInfoType;
                        }
                        // 修改整单支付信息
                        if (target === constants.TARGET.MODIFYLISTPAYINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.modifyListPayInfo;
                        // URL权限校验
                        }if (target === constants.TARGET.CHECKURLPOWER) {
                            method.url = config.backend.ip + config.backend.checkURLPower+"?"+keywords;
                        }
                        //普通批改带出投保申请人
                        if (target === constants.TARGET.QUERYCOMMONENDORSE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryCommonEndorse;
                        }
                        //普通批改保存
                        if (target ===constants.TARGET.SAVEENDORSEINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.saveEndorseInfo;
                        }
                        //通过投保单号关联查询其他单号
                        if (target === constants.TARGET.QUERYRELATEBYPROPOSALNO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryRelateByProposalNo;
                        }
                        //查询已打印的保单号
                        if (target === constants.TARGET.POLICYPRINTSTATUS) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.policyPrintStatus;
                        }
                        if (target === constants.TARGET.QUERYUSERCODE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryUserCode;
                        }
                        //信雅达影像上传与查看
                        if (target === constants.TARGET.TRANSPORTXML) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.transportXML;
                        }
                        //获取用户区域权限 核心段获取用户区域权限，五级联选
                        if (target === constants.TARGET.GETUSERREGION) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getUserRegion;
                        }
                        //根据标的查询险类（快速出单）
                        if (target === constants.TARGET.QUERYBYITEMCODE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByItemCode;
                        }
                        //根据标的集合、险类查询险种（快速出单）
                        if (target === constants.TARGET.QUERYRISKCODEINFOQUICK) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryRiskCodeInfoQuick;
                        }
                        //标的清单列表下载
                        if (target === constants.TARGET.MARKLISTDOWNLOAD) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.markListDownload;
                        }
                        //客户密码设置
                        if (target === constants.TARGET.CHANGEPASSWORD) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.changePassword;
                        }
                        //批量删除短信模板
                        if (target === constants.TARGET.DELETEALLUTILNOTICEMODEL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.deleteAllUtilNoticeModel;
                        }
                        if (target === constants.TARGET.ENDORSEPRINTSTATUS) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.endorsePrintStatus;
                        }
                        //查询险别标的关联表查询是否计入承保数量
                        if (target === constants.TARGET.QUERYFLAG) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryFlag;
                        }
                        //查询短期费率
                        if (target === constants.TARGET.QUERYBYRISKCODEANDITEMCODE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByRiskCodeAndItemCode;
                        }
                        // 下载带有农户信息的耳标号清单模板
                        if (target === constants.TARGET.DOWNLOADEARLABELLIS) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.downloadEarLabelList;
                        }
                        // 下载带有农户信息的连带被保险人清单模板
                        if (target === constants.TARGET.DOWNLOADJOINTINSURED) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.downloadJointInsured;
                        }
                        // 匹配险种和所选清单的标的
                        if (target === constants.TARGET.MATCHGISITEMLIST) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.matchGisItemList;
                        }
                        // 下载支付清单模板文件
                        if (target === constants.TARGET.DOWNLOADPAYLISTTEMPLATE) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.downloadPayListTempLate;
                        }
                        // 校验要补录的耳标号或者连带被保险人是否存在
                        if (target === constants.TARGET.CHECKDOESITEXIST) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.checkDoesItExist;
                        }
                        // 查询开户银行信息
                        if (target === constants.TARGET.GETBANKINFO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.getBankInfo;
                        }
                        //发送电子保单
                        if (target === constants.TARGET.SENDMAIL) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.sendMail;
                        }
                        //查询电子邮箱
                        if (target === constants.TARGET.QUERYBYPOLICYNO) {
                            method.data = keywords;
                            method.url = config.backend.ip + config.backend.queryByPolicyNo;
                        }

                            $http(method)
                            .success(function (data) {
                                if (options && options.success && typeof(options.success) == 'function')
                                    options.success(data);
                            })
                            .error(function (e, code) {
                                if (options && options.error && typeof(options.error) == 'function')
                                    options.error(e);
                            })
                    }
                };
            }
        ]);

});