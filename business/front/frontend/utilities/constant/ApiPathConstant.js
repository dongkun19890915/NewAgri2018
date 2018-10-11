/**
 * Created by ZhangJiansen on 2016/10/10.
 */
define([], function () {
    'use strict';
    //配置应用的path
    var app= {
        //commWeb:"/gscore-pa-web",
        commWeb:"/api/pa",
        commFileServer: "/comm-fileserver",
        sso:"/api/sso"
    };

    //配置公共模块服务的path
    var api={
        //框架使用api
        getLoginUesr:app.commWeb+"/login/userInfo",
        getMenus:app.commWeb+"/menu/tree",
        logout:app.sso+"/logout",

        //公共模块api
        getDictCode:app.commWeb+"/commonSelect/initSelectTag",

        //文件上传服务
        uploadFile: app.commFileServer + "/uploadFile",
        downloadFile: app.commFileServer + "/downloadFile",

        //文件下载服务
        downloadFileByShortLinkId: app.commFileServer + "/downloadFileByShortLinkId",

        //ecif 模块
        getCifIdvList: app.commWeb + "/CIFCustomerInfo/getCifIdvList",
        getCifUnitList: app.commWeb + "/CIFCustomerInfo/getCifUnitList",

        //ims服务地址
        queryCompany: app.commWeb + "/company/queryCompany",
        queryCompanyIdType: app.commWeb + "/company/queryCompanyIdType",
        queryUpperCompany: app.commWeb + "/company/queryUpperCompany",
        qeuryPrpDCompanyList: app.commWeb + "/company/qeuryPrpDCompanyList",
        queryCompanyByComcode: app.commWeb + "/company/queryCompanyByComcode",
        saveCompany: app.commWeb + "/company/saveCompany",
        updateCompany: app.commWeb + "/company/updateCompany",
        passwdUpdate: app.commWeb + "/user/updatePasswd",
        userUpdate: app.commWeb + "/user/updateUser",
        userSave: app.commWeb + "/user/saveUser",
        queryUserInfo: app.commWeb + "/user/queryUserInfo",
        checkUserCode: app.commWeb + "/user/checkUserCode",
        queryDownComCode: app.commWeb + "/user/queryDownComCode",
        queryHeadComCode: app.commWeb + "/user/queryHeadComCode",
        configUserGrade: app.commWeb + "/user/configUserGrade",
        queryGradeList: app.commWeb + "/user/queryGradeList",
        queryUserList: app.commWeb + "/user/queryUserList",
        userImportExcel: app.commWeb + "/user/importExcelUser",
        downUserInfo: app.commWeb + "/user/downUserInfo",
        downloadExcelTemplate: app.commWeb + "/user/downloadExcelTemplate",
        checkePwd: app.commWeb + "/user/checkePwd",
        getCompanyTree: app.commWeb + "/underwriting/getCompanyTree",
        configUserPermitCompany: app.commWeb + "/underwriting/configUserPermitCompany",

        //pms 服务地址
        queryAreaLimitList: app.commWeb + "/areaLimit/queryAreaLimitList",
        saveAreaLimit: app.commWeb + "/areaLimit/saveAreaLimit",
        queryLateAreaLimit: app.commWeb + "/areaLimit/queryLateAreaLimit",
        quereyCoinsRateList: app.commWeb + "/coinsRate/quereyCoinsRateList",
        queryLateCoinsRate: app.commWeb + "/coinsRate/queryLateCoinsRate",
        saveCoinsRateList: app.commWeb + "/coinsRate/saveCoinsRateList",
        quereySalesRateList: app.commWeb + "/saleRate/quereySalesRateList",
        saveSalesRate: app.commWeb + "/saleRate/saveSalesRate",
        getRiskList: app.commWeb+'/risk/getRiskList',
        //EQ02
        getSubsidyDetail: app.commWeb+'/subsidy/getSubsidyDetail',
        //产品组装
        getProductConfig: app.commWeb+'/pms/prodConfig',

        //index 模块
        statDataQuery: app.commWeb+'/stat/statDataQuery',
        summaryProposalQuantity: app.commWeb+'/proposal/summaryProposalQuantity',
        newProposalMenu: app.commWeb+'/proposal/newProposalMenu',
        suspendProposalMenu: app.commWeb+'/proposal/suspendProposalMenu',
        suspendEndorseMenu: app.commWeb+'/endorse/suspendEndorseMenu',
        summaryEndorseQuantity: app.commWeb+'/endorse/summaryEndorseQuantity',

        //document模块
        queryEpolicyPage: app.commWeb+'/epolicy/queryEpolicyPage',
        queryEendorsePage: app.commWeb+'/epolicy/queryEendorsePage',
        queryEpolicyFileId: app.commWeb+'/epolicy/queryEpolicyFileId',
        downloadFileDoc: app.commWeb+'/file/downloadFile',
        sendToEpolicyEmail: app.commWeb+'/epolicy/sendToEpolicyEmail',

        //clearFile 模块
        dealExceptionData: app.commWeb+'/clearFile/dealExceptionData',
        checkExceptionData: app.commWeb+'/clearFile/checkExceptionData',
        downLoadClearFile: app.commWeb+'/clearFile/downLoadClearFile',
        genClearFileShortLink:app.commWeb+'/clearFile/genClearFileShortLink',
        checkReclear: app.commWeb+'/clearFile/checkReclear',
        reclear: app.commWeb+'/clearFile/reclear',
        buildReport: app.commWeb+'/report/buildReport',
        downloadReport: app.commWeb+'/report/downloadReport',
        importClaimExcel: app.commWeb+'/clearFile/importClaimExcel',



        //payment 支付模块
        queryPayInfo: app.commWeb+'/proposal/queryPayInfo',
        createPayNoticeEdocByKey: app.commWeb+'/epolicy/createPayNoticeEdocByKey',
        onLineGoToPay: app.commWeb+'/proposal/onLineGoToPay',
        createProposalEdocByKey: app.commWeb+'/epolicy/createProposalEdocByKey',
        queryOnLinePayStatus: app.commWeb+'/policy/queryOnLinePayStatus',
        queryOffLinePayPageInfo: app.commWeb+'/proposal/queryOffLinePayPageInfo',
        proposalOffLindDoPay: app.commWeb+'/proposal/proposalOffLindDoPay',
        savePayExch: app.commWeb+'/payexch/savePayExch',
        queryTranPolicyInsured: app.commWeb+'/proposal/queryTranPolicyInsured',
        queryTranPolicy: app.commWeb+'/proposal/queryTranPolicy',
        queryReceiptPage: app.commWeb+'/commonquery/queryReceiptPage',
        saveInvoice: app.commWeb+'/policy/saveInvoice',
        //BCP 模块
        queryPayBack: app.commWeb+'/bcp/queryPayBack',
        savePayBack: app.commWeb+'/bcp/savePayBack',
        //material模块
        queryFile: app.commWeb+'/prpfile/queryFile',
        deleteFile: app.commWeb+'/prpfile/deleteFile',
        saveFileId: app.commWeb+'/prpfile/saveFileId',

        //prpins 模块
        forEndorse: app.commWeb + "/commonquery/forEndorse",
        validatePolicyForEndorse: app.commWeb + "/endorse/validatePolicyForEndorse",
        saveInitEndorse: app.commWeb + "/endorse/saveInitEndorse",
        backUpdateEndorse: app.commWeb + "/endorse/backUpdateEndorse",
        saveEndorse: app.commWeb + "/endorse/saveEndorse",
        deleteEndorse: app.commWeb + "/endorse/deleteEndorse",
        submitEndorse: app.commWeb + "/endorse/submitEndorse",
        checkIDUpload: app.commWeb + "/endorse/checkIDUpload",
        queryImgFilePage: app.commWeb + "/file/queryImgFilePage",
        saveImageFile: app.commWeb + "/file/saveImageFile",
        deleteImgFile: app.commWeb + "/file/deleteImgFile",
        initEdit: app.commWeb + "/customer/initEdit",
        proInitEdit: app.commWeb + "/proposal/initEdit",
        saveSingleInsured: app.commWeb + "/insured/saveSingleInsured",
        queryInsuredPageInfo: app.commWeb + "/insured/queryInsuredPageInfo",
        deleteTinsuredPropByPK: app.commWeb + "/insured/deleteTinsuredPropByPK",
        saveBatchInsureds: app.commWeb + "/insured/saveBatchInsureds",
        queryBatchImportErr: app.commWeb + "/insured/queryBatchImportErr",
        downloadModel: app.commWeb + "/file/downloadModel",
        queryImportResult: app.commWeb + "/insured/queryImportResult",
        downloadInsuredsAll: app.commWeb + "/insured/downloadInsuredsAll",
        queryImportErrHis: app.commWeb + "/insured/queryImportErrHis",
        deleteInsured: app.commWeb + "/insured/deleteInsured",
        queryTInsuredPropInfo: app.commWeb + "/insured/queryTInsuredPropInfo",
        summaryItemProp: app.commWeb + "/proposal/summaryItemProp",
        createProposalEdocByDto: app.commWeb + "/epolicy/createProposalEdocByDto",
        save: app.commWeb + "/proposal/save",
        submitUndwrt: app.commWeb + "/proposal/submitUndwrt",
        queryProposalByPK: app.commWeb + "/proposal/queryProposalByPK",
        copyProposalOrPolicy: app.commWeb + "/proposal/copyProposalOrPolicy",
        deleteProposal: app.commWeb + "/proposal/deleteProposal",
        searchUnderWrtStat:app.commWeb+"/proposal/searchUnderWrtStat",
        checkTInsuredPropData: app.commWeb + "/insured/checkTInsuredPropData",
        queryPageInfo: app.commWeb + "/commonquery/queryPageInfoByPower",
        queryEndorseHistory: app.commWeb + "/endorse/queryEndorseHistory",
        queryPreEndorse: app.commWeb + "/endorse/queryPreEndorse",
        queryEndorseTranPolicy: app.commWeb + "/endorse/queryEndorseTranPolicy",
        queryPolicyInsured: app.commWeb + "/endorse/queryPolicyInsured",
        poQueryPolicyInsured: app.commWeb + "/policy/queryPolicyInsured",
        queryPolicy: app.commWeb + "/policy/queryPolicy",
        querySuspend: app.commWeb + "/endorse/querySuspend",
        querySuspendProposalPageInfo: app.commWeb + "/proposal/querySuspendProposalPageInfo",
        queryApproval: app.commWeb + "/endorse/queryApproval",
        validateApproval: app.commWeb + "/endorse/validateApproval",
        surrenderConfirm: app.commWeb + "/endorse/surrenderConfirm",
        queryAllOpinions: app.commWeb + "/endorse/queryAllOpinions",
        updateEndorseDecide: app.commWeb + "/endorse/updateEndorseDecide",
        querySurrender: app.commWeb + "/endorse/querySurrender",
        surrenderGiveUp: app.commWeb + "/endorse/surrenderGiveUp",
        recalculateFpremium: app.commWeb + "/proposal/recalculateFpremium",
        checkMaxSubsidy: app.commWeb + "/proposal/checkMaxSubsidy",
        delBatchTInsured: app.commWeb + "/proposal/delBatchTInsured",
        queryPrpPpayeeAccount:app.commWeb+"/endorse/queryPrpPpayeeAccount"
    };
    var exceptUrl=[
        app.commWeb + "/insured/queryImportResult"
    ];



    var ApiPathConstant = {
        app:app,
        api:api,
        exceptUrl:exceptUrl
    };

    return ApiPathConstant;
});
