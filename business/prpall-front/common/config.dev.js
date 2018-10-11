/**
 * Created by colorfulcat on 2017/11/12.
 */
define({
    systemConfig:{
        systemFlag:'prpall',//系统
        printFile:'/pdf/newpdf.html',//打印文件
        prpallClaimUrl:'192.168.0.5',//承保调用理赔页面地址
        GYCoreUrl:'http://36.32.160.60:8888/CallPage/ListShow/Index?listcode',//金禾地址
        sunECMUrl:'http://220.178.31.50:9200',
    },
    backend: {
        ip: "",
        // 注销登录
        // logout: '/logout',
        // 用户登录信息获取
        userInfo:'/api/sso/api/userInfo',
        //菜单模块
        menuData: "/api/ims/queryMenu/showMenu",
        //常用功能模块
        saveUserMenu:"/api/ims/userMenuManage/saveUserMenu", //常用功能保存
        queryUserMenuInfo:"/api/ims/userMenuManage/queryUserMenuInfo",//常用功能初始化
        deleteUserMenuInfo:"/api/ims/userMenuManage/deleteUserMenuInfo",//常用功能删除
        //投保单录入
        queryPolicyListByConditon: "/api/agriprpall/policyQuery/queryPolicyListByConditon",//保单查询
        uploadfile: 'uploadfile',//影像资料查询
        saveGisList:'/api/agriprpall/importListing/saveGisList',//清单上传保存预投保表信息
        sendmessagequery: 'sendmessagequery',//短信发送查询
        clausemanage: '/api/pms/PrpDclauseCode/QureyClauseCodeCondition',//条款版本管理查询
        queryByPkAndTranslate:'/api/pms/PrpDclauseCode/queryByPkAndTranslate',//根据条款代码查询该条款相应的信息
        clauseCodeDel: '/api/pms/PrpDclauseCode/removeByClause',//单个删除
        clauseCodeDelAll: '/api/pms/PrpDclauseCode/removeBatchByClause',//多个删除
        disableClause: "/api/pms/PrpDclauseCode/motifyenableOrDisableClause",//根据条款代码停用启用条款
        prpbusinoesslist:'/api/agriprpall/businessList/queryBusinessListByCondition',//业务清单查询
        prpbusinoesslistexcel:'/api/agriprpall/businessList/businessListExportExcel',//业务清单导出
        paymanage: 'paymanage',//支付信息管理
        customer: '/api/dms/prpDcustomer/queryCustomerInfoByCondition',//客户设置
        //信达版本
        //queryEnorderListInfo: "/api/agriprpall/QueryEndors/queryEndorsListInfo",//批单查询
        //国元版本
        queryEndorsListInfo: "/api/agriprpall/QueryEndors/queryEndorsListInfo",//批单查询
        queryEndorsListInfoImage: "/api/agriprpall/QueryEndors/queryEndorsListInfo",//批单查询
        deleteEndorse:"/api/agriprpall/deleteEndorse/deleteEndorse",//批单删除
        endorseProposal: 'endorseProposal',
        fullSurrender: 'fullSurrender',//退保保单
        CancellationPolicy: 'CancellationPolicy',//全单注销
        proposalSave: '/api/agriprpall/proposalSave/save',//投保单录入的保存按钮
        creatProposal: '/api/dms/billno/getBillNo',//生成投保单号确定按钮  生成清单号
        selectedGuaranteeDetails: 'selectedGuaranteeDetails/selectedGuaranteeDetails',//查询保单详情
        proposalManagement: 'proposalManagement',//投保模版查询
        savePrpDcustomerIdvUnit: '/api/dms/customer/savePrpDcustomerIdvUnit',//新增和修改的客户信息，都用这个
        queryTerroristInfo: '/api/agriprpall/queryTerrorist/queryTerroristInfo',//恐怖分子列表查询
        queryProposalListInfoByConditon: '/api/agriprpall/proposalmanage/queryProposalListInfoByConditon',//投保单查询
        BusinessCategory: 'BusinessCategory',
        getOptionCodeTwo: '/api/dms/prpDcode/getOptionCodeTwo',//投保单录入初始化街口
        queryComCodeInfo: '/api/ims/prpDcompany/queryComCodeInfo',//归属机构查询
        prpdClauseCode: '/api/pms/PrpDclauseCode/queryByRiskCodeAndCom',//条款
        queryItemByRiskCodeAndCom: '/api/pms/PrpDclauseCode/queryItemByRiskCodeAndCom',//模板出单向导的条款
        prpMmodelMainByRiskCode: '/api/dms/prpMmodelMain/queryPrpMmodelMainByRiskCodeAndComCode',//模板
        queryClauseByRiskCode: "api/dms/engage/queryClauseByRiskCode",//特约及附加险
        getPrpDclauseCodeInfo: '/api/pms/PrpDclauseCode/getPrpDclauseCodeInfo',//获取条款信息
        queryHandler1CodeInfo: '/api/ims/prpDuser/queryHandler1CodeInfo',//获取业务员
        getOperatorCode:'/api/ims/prpDuser/getOperatorCode',//根据员工代码查询员工姓名
        queryAreasProvinceInfo: '/api/dms/prpDcode/queryAreasProvinceInfo',
        queryPlantingExcelByConnection: '/api/txnlist/plantingexcel/queryPlantingExcelByConnection',//清单查询接口
        withdrawProposalnoSubmit: '/api/agriprpall/submitform/withdrawProposal',//投保单撤销
        queryAllClass: '/api/pms/prpdclass/queryAllClass',
        riskCode: '/api/pms/prpDrisk/queryRiskCodeInfo',//险种
        queryRiskCodeInfoQuick: '/api/pms/prpDrisk/queryRiskCodeInfoQuick',//快速出单查询
        queryKindCodeInfo: '/api/pms/prpdkind/queryKindCodeInfo',
        findGisInsureMainLists: '/api/txnlist/gisInsureListApi/findGisInsureMainLists', //清单号查询
        queryPrpDcurrencyByCondition: '/api/dms/prpDcurrency/queryPrpDcurrencyByCondition',//币别查询
        engageQueryClauseByRiskCode: '/api/agriprpall/initSelect/initSelect',//特约及附加信息查询
        queryInsurePreliminaryConfirm: '/api/txnlist/gisInsureListApi/findGisFarmerListByInsureListCodeAndserialNo',//清单号详细信息
        initSelect: '/api/agriprpall/initSelect/initSelect',//公共接口
        checkInsuranceCode: '/api/agriprpall/calPremium/checkInsuranceCode',//币别信息中的保费计算
        logout: '/api/sso/api/logout',//注销的接口
        loginToDo: 'login',//登录接口
        CustomerByPK: '/api/demo/customer/queryCustomerByPK',
        queryCoinsComCodeInfo: '/api/agriprpall/prpDReins/queryCoinsComCodeInfo',
        findCoinsTreaty:'/api/agriprpall/prpDReins/findCoinsTreaty',//查询共保协议
        getResponseQueryReinsAgreementDtoList:'/api/agriprpall/prpDReins/getResponseQueryReinsAgreementDtoList',//获取再保协议业务数据方法
        currencyEnsure: '/api/agriprpall/calPremium/CurrencyEnsure',//币别信息中的保费计算
        queryByRiskCode: '/api/pms/prpDrisk/queryByRiskCode',//保费计算中的费率除
        getExchangeRate: '/api/dms/prpDexch/getExchangeRate',//币别兑换率
        dealTMainForYGZFromPage: '/api/agriprpall/leviedfee/dealTMainForYGZFromPage',//价税分离
        modifyClauseByComByKind: '/api/pms/PrpDclauseCode/modifyClauseByComByKind',//条款修改
        saveClauseByComByKind: '/api/pms/PrpDclauseCode/saveClauseByComByKind',//条款信息的保存与暂存
        UIProposalManagement: "/api/dms/prpMmodelMain/queryPrpMmodelMainByCondition",//查询模板
        prpModelMainDel: "/api/dms/prpMmodelMain/removeAllByModelCode",//根据模板代码删除模板信息
        StateSettings: "/api/dms/prpMmodelMain/modifyValidstatusByModelCode",//启用
        POLICYPRINT: "/api/agriprpall/print/PolicyPrint",//保单正本全打
        GetVisaTypeData: "/api/agriprpall/VisaVerifDisInfo/GetVisaTypeData",//保单打印设置下的单证类型查询
        queryMyJobByCondition: '/api/agriprpall/QueryMyJob/queryMyJobByCondition',//待处理任务数量显示
        queryPremiumInfo: '/api/agriprpall/businessList/queryPremiumInfo', //签单保额保费查询
        queryPrpdclauseInfo: '/api/pms/prpDclause/queryPrpdclauseInfo',//根据条款代码查询条款代码和条款名称
        queryPrpdclauseInfoByCondition: '/api/pms/prpDclause/queryPrpdclauseInfoByCondition',//条款代码查询条款信息表
        getViewTrace: '/api/agriprpall/viewtrace/getViewTrace',//投保单核保信息查询
        queryByRiskCode1: "/api/pms/prpdkindagri/queryByRiskCode",//条款新建里的查询险别代码
        queryPrpDitemInfoDto: "/api/pms/prpditemagri/queryPrpDitemInfoDto",//条款新建里得查询标的代码
        queryByKindContext: "/api/pms/prpDclause/queryByKindContext", //条款新建里的查询险别内容
        generalEndorseInit: '/api/agriprpall/endorse/queryCommonEndorInfo',// 普通批改初始化
        dealEndorseInfo:'/api/agriprpall/commonEndorse/dealEndorseInfo ',//普通批改点击下一步
        saveEndorseInfo:'/api/agriprpall/commonEndorse/saveEndorseInfo',//普通批改保存
        checkEndorse: '/api/agriprpall/checkEndorse/checkNext',// 进入普通批改的校验
        //信达版本
         queryCommonEndorse: '/api/agriprpall/endorse/queryCommonEndorse',// 普通批改前查询保单信息
        //国元版本
        queryCPolicyInfo: '/api/agriprpall/endorse/queryCPolicyInfo',// 普通批改前查询保单信息
        submitUndwrtByProposal: '/api/agriprpall/undwrtsubmit/submitUndwrtByProposal',//提交核保
        queryNoticeModelPaging: '/api/notice/utilNoticeModel/queryNoticeModelPaging',//短信模板列表分页查询
        disableNoticeModel: '/api/notice/utilNoticeModel/changeStatus', //短信模板启用停用
        deleteUtilNoticeModel: '/api/notice/utilNoticeModel/deleteUtilNoticeModel',//短信模板删除
        querySpecial:'/api/agriprpall/policyQuery/queryPolicyListByConditon',//特殊批改保单列表查询
        specialEndorIni:'/api/agriprpall/endorsemanage/specialEndorIni',//特殊批改初始化
        modifyPrpPtext:"/api/agriprpall/prpPtext/modifyPrpPtext",//修改批文
        queryPrpPtextByEndorseNo:"/api/agriprpall/prpPtext/queryPrpPtextByEndorseNo",//查询批文
        //信达版本
         endorseapproval:'/api/agriprpall/endorsemanage/specialEndorse',//特殊批改生产批文
        // endorsesave:'/api/agriprpall/commonEndorse/saveEndorseList',//特殊批改保存
        //国元版本
        //endorseapproval:'/api/notice/utilNoticeModel/deleteUtilNoticeModel',//特殊批改生产批文
        endorsesave:'/api/agriprpall/commonEndorse/saveEndorseList',//特殊批改保存
        queryEndorseInfo: '/api/agriprpall/endorsemanage/queryEndorseInfo',//普通批单详细信息查看初始化
        //与批单查询接口冲突
       // queryEndorsListInfo:'/api/notice/utilNoticeModel/queryEndorsListInfo',//短信模板列表分页查询
        queryProposalInfo:'/api/agriprpall/proposalmanage/queryProposalInfoByProposalNoAndFamilyNos',//投保单查询详细信息查询
        saveGisPlantUpLoadList:'/api/agriprpall/importListing/saveGisPlantUpLoadList',//清单信息上传
        queryAreasByCondition:'/api/dms/areas/queryAreasByCondition',//清单地址下拉框
        queryPlantUpLoadList:'/api/txnlist/plantUpLoad/queryPlantUpLoadList',//清单上传信息分页展示
        checkVisaCodeValid:'/api/agriprpall/VisaVerifDisInfo/checkVisaCodeValid',//检查单证号码是否可用
        VerifDisData:'/api/agriprpall/VisaVerifDisInfo/VerifDisData',//单证核销
        exportExcel:'/api/agriprpall/importListing/exportExcel',//清单模版导出
        queryPolicyInfoByPolicyNo:'/api/agriprpall/policyQuery/queryPolicyInfoByPolicyNo',//保单详情查询
        querySmsListByCondition:'/api/notice/smsContent/querySmsListByCondition',//短信列表分页查询
        sendNotice:'/api/notice/sendNotice/sendNotice',//短信和邮件发送
        queryCompanyTree:"/api/ims/prpDcompany/queryCompanyTree",// 机构树
        getCompanyTree:'/api/dms/prpMmodelMain/getCompanyTree',//模板详细信息查询的机构树查询
        resendNotice:'/api/notice/sendNotice/resendNotice',//短信重新发送
        //savaPassword: "/api/dms/prpDcustomerIdv/savaPassword",//客户密码设置
        queryIdentifyType:'/api/dms/prpDcode/queryIdentifyType',//客户证件类型
        queryByPK:"/api/dms/prpDcustomerIdv/queryByPK",//客户风险等级设置
        saveByCustomerRiskLevel:"/api/dms/prpDcustomerIdv/saveByCustomerRiskLevel",//客户风险等级设置保存
        queryPrpMmodelMainByHyperLink:"/api/dms/prpMmodelMain/queryPrpMmodelMainByHyperLink",//新建模板初始化//根据模板代码查询模板详细信息
        getSendNumber:'/api/agriprpall/vouchersms/getSendNumber',//获得短信发送数量
        findNoticeContent:'/api/notice/utilNoticeModel/findNoticeContent',//通过短信模板获得短信内容
        getSmsContent:'/api/agriprpall/vouchersms/getSmsContent',//短信发送内容
        queryCoinsTreaty:'/api/agriprpall/proposalmanage/queryCoinsTreaty',//共保协议查询
        addUtilNoticeModel: '/api/notice/utilNoticeModel/addUtilNoticeModel',//短信模板新增
        queryClauseCodeByComByKind:'/api/pms/PrpDclauseCode/queryClauseCodeByComByKind',//根据条款代码查询条款详细信息
        modifypwd:'/api/ims/login/modifypwd',//修改密码
        findUtilNoticeModel: '/api/notice/utilNoticeModel/findUtilNoticeModel',//查询短信模板详细
        isInInsureMainList:'/api/txnlist/insureMainList/isInInsureMainList',//查询清单是否存在的接口
	    updateUtilNoticeModel: '/api/notice/utilNoticeModel/updateUtilNoticeModel',//修改短信模板
        getUserInfo:'/api/ims/prpDuser/getUserInfo', //用户信息初始化
        modifyUserInfo:'/api/ims/prpDuser/modifyUserInfo',// 修改用户信息
        getPropertyRuleToFront:'/api/ims/utiPlatConfigRule/getPropertyRuleToFront',//险种配置查询
        CheckBusinessComCodeInfo:'/api/ims/prpDcompany/CheckBusinessComCodeInfo',//归属机构录入权限的校验
        FrontEnd:'/api/dms/frontEnd/queryFrontEnd',//前端配置后端化
        queryByPKByMap:"/api/ims/prpDcompany/queryByPKByMap",//根据机构代码查询机构名称
        queryMarkedList:'/api/txnlist/gisInsureListApi/findGisItemListByInsureListCodeAndserialNo',//标的清单查询
        queryInputPayInfo:'/api/agriprpall/payinfo/queryInputPayInfo',// 支付信息录入查询
        queryModifyPayInfo:'/api/agriprpall/payinfo/queryModifyPayInfo',// 支付信息查看、修改列表信息查询接口
        saveSinglePayInfo:'/api/agriprpall/payinfo/saveSinglePayInfo',// 整单支付信息保存服务
        synchronizeAccount:'/api/agriprpall/payinfo/synchronizeAccount',// 整单支付同步账户信息
        exportInsureListExcel:'/api/agriprpall/payinfo/exportExcel',// 清单支付下载支付清单excel
        exportEndorseList:'/api/agriprpall/payinfo/exportEndorseList',// 清单支付批改变化量清单excel
        selectfind:'/api/ims/login/queryComCodeList',//登陆机构
        queryItemListCodeByPK:'/api/txnlist/gisInsureListApi/queryItemListCodeByPK',//清单标的代码查询
        queryVisaCodesAndVisaSerialNos:'/api/agriprpall/visa/queryVisaCodesAndVisaSerialNos',//流水号
        trashTransVisa:'/api/agriprpall/visa/trashTrans',//作废流水号
        importPayInfoExcel:'/api/agriprpall/payinfo/inputImportExcel',// 导入支付清单excel
        queryPayInfoDetails:'/api/agriprpall/payinfo/queryPayInfoDetails',// 查询支付清单详细信息
        modifySinglePayInfo:'/api/agriprpall/payinfo/modifySinglePayInfo',// 修改整单支付信息
        modifyListPayInfo:'/api/agriprpall/payinfo/modifyListPayInfo',// 修改整单支付信息
        findGisFarmerListByInsureListCodeAndserialNo:"/api/txnlist/gisInsureListApi/findGisFarmerListByInsureListCodeAndserialNo",//清单农户查询
        checkURLPower:'/api/ims/power/checkURLPower',// 修改整单支付信息
        saveUndwrtByEndorseNo:'/api/agriprpall/undwrtendorsubmit/saveUndwrtByEndorseNo',//提交核批
        queryGisFarmerItemInfoDetail:'/api/txnlist/gisInsureListApi/queryGisFarmerItemInfoDetail',//根据清单号，序列号和标的清单号集合查询对应的标的列表信息
        queryGisFieldList:'/api/txnlist/gisInsureListApi/queryGisFieldList',//查询田块
        queryHerdGisFieldList:'/api/txnlist/gisInsureListApi/queryHerdGisFieldList',//查询耳标号
        CheckItemCodeListMethod:'/api/txnlist/gisInsureListApi/CheckItemCodeListMethod',//保费计算时校验标的清单与标的是否匹配（除新单外）
        saveButton:'/api/dms/prpMmodelMain/saveButton',//投保模板暂存保存
        getPrpmmodelmainInfo:'/api/dms/prpMmodelMain/getPrpmmodelmainInfo',//投保单保存判断模板是否失效
        queryPayInfoType:'/api/agriprpall/payinfo/queryPayInfoType',// 查询批单的支付信息类型
        getPlantingExcel:'/api/agriprpall/plantingexcel/getPlantingExcel',// 分户清单下载
        queryRelateByProposalNo:'/api/agriprpall/QueryRelation/queryRelateByProposalNo',
        transportXML:"/api/agriprpall/imageData/findImageData",//信雅达影像上传与查看
        markListDownload:"/api/txnlist/gisInsureListApi/markListDownload",//标的清单列表下载
        policyPrintStatus:"/api/agriprpall/print/policyPrintStatus",//查询已打印的保单号
        queryUserCode:"/api/ims/utiUserGradePower/queryUserCode",//查询业务员特殊批改所有机构下的业务员名称
        queryPrintNo:"/api/agriprpall/prpCmain/queryPrintNo",//判断保单是否已经打印
        getUserRegion:"/api/agriprpall/GYcoreUtil/getUserRegion",//获取用户区域权限 核心段获取用户区域权限，五级联选
        deleteAllUtilNoticeModel: '/api/notice/utilNoticeModel/deleteAllUtilNoticeModel',//短信模板批量删除
        pageFindByConditions:'/api/txnlist/makeUpList/pageFindByConditions',//清单补全查询列表接口
        queryMakeUpListByInsureListCode:'/api/txnlist/makeUpList/queryMakeUpListByInsureListCode',//根据清单查询投保单信息
        importEarLabelList:'/api/txnlist/makeUpList/importEarLabelList',//清单补全上传
        changePassword:'/api/agriprpall/policyQuery/changePassword',//客户密码设置
        endorsePrintStatus:'/api/agriprpall/print/endorsePrintStatus',//查询批单打印状态
        queryByItemCode: '/api/pms/prpDrisk/queryByItemCode',//根据标的查询险种（快速出单）
        queryFlag:'/api/pms/prpDkindItem/queryFlag',//查询险别标的关联表查询是否计入承保数量
        queryPrpCmainInfo:'/api/agriprpall/prpCmain/queryPrpCmainInfo',//根据清单编号进行重复性校验
        queryByPrpNoPrpCmainInfo:'/api/agriprpall/prpCmain/queryByPrpNoPrpCmainInfo',//投保单疑似重复投保校验
        queryByRiskCodeAndItemCode:"/api/pms/prpDshortRate/queryByRiskCodeAndItemCode",//查询短期费率
        getEndorExcel:'/api/agriprpall/plantingexcel/getEndorExcel',//批改清单下载
        getChgEndorExcel:'/api/agriprpall/plantingexcel/getChgEndorExcel',//批改清单下载
        getAfterEndorExcel:'/api/agriprpall/plantingexcel/getAfterEndorExcel',
        queryByPrpNoPrpCmainInfoList:'/api/agriprpall/prpCmain/queryByPrpNoPrpCmainInfoList',//工作台上的提交核保疑似重复投保校验
        downloadEarLabelList:'/api/txnlist/makeUpList/downloadEarLabelList',// 下载带有农户信息的耳标号清单模板
        downloadJointInsured:'/api/txnlist/makeUpList/downloadJointInsured',// 下载带有农户信息的连带被保险人清单模板
        matchGisItemList:'/api/txnlist/gisInsureListApi/matchGisItemList',// 匹配险种和所选清单的标的
        calFee:'/api/agriprpall/calEndorPremium/calFee',//普通批改点击计算，计算保费
        downloadPayListTempLate:'/api/agriprpall/payinfo/downloadPayListTempLate',//下载支付清单模板文件
        checkDoesItExist:'/api/txnlist/makeUpList/checkDoesItExist',// 校验要补录的耳标号或者连带被保险人是否存在
        getBankInfo:'/api/agriprpall/payinfo/getBankInfo',// 查询开户银行信息
        sendMail:'/api/notice/sendNotice/sendMail',//发送电子保单
        queryByPolicyNo:'/api/agriprpall/prpCinsured/queryByPolicyNo',//查询电子邮箱
    }
});