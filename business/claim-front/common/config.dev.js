define({
    backend: {
        ip: "/api/", //http://192.168.1.23:9011
        // ip: "", //http://192.168.1.23:9011
        // ip: "/api/agriclaim/", //http://192.168.1.23:9011
        queryPrpCitemKind:"agriprpall/prpCitemKind/queryPrpCitemKind",//报案登记页面查询
        relatePolicyInfo:"agriclaim/relatePolicyInfo/showRelateInfo",//关联承保后端服务
        queryByBusinessNo:"agriclaim/swfLog/queryByBusinessNo",//根据业务号查询相应的节点的数据
        queryMyJobDetail:"agriclaim/workflowRove/queryMyJobDetail",//工作台任务查询
        messageInit:"agriclaim/messageInit/messageInit",//短信页面初始化
        sendMessage:"notice/sendNotice/sendSms",//发送短信功能
        queryReportType1:"agriclaim/initSelectClaim/queryReportType",//报案方式查询
        showMenu: "ims/queryMenu/showMenu",
        queryUserMenuInfo: "ims/userMenuManage/queryUserMenuInfo",//查询用户的常用菜单
        saveUserMenu:"ims/userMenuManage/saveUserMenu",//保存用户的常用菜单
        deleteUserMenuInfo:"ims/userMenuManage/deleteUserMenuInfo",//删除常用菜单
        queryReportType:"dms/prpDcode/queryCodeInfoByCodeTypeAndRiskCode",//查询报案方式下拉框
        initSelect: 'agriprpall/initSelect/initSelect',//报案登记页面受损标的查询
        //logout: '/logout',// 注销登录
        frontEnd:'dms/frontEnd/queryFrontEnd',//前端配置后端化
        logout: 'sso/api/logout',//注销的接口
        userInfo:'sso/api/userInfo', // 用户登录信息获取
        getUserInfo:'ims/prpDuser/getUserInfo', // 个人信息获取
        modifyUserInfo:'ims/prpDuser/modifyUserInfo', // 个人信息修改
        modifypwd:'ims/login/modifypwd', // 个人信息修改
        // giveupTemporary: "workflowRove/giveupTemporary", // 放弃任务公共接口
        baseCode: "agriclaim/common/queryAllClaimBox",
        queryPolicyListInfo: "agriclaim/regist/queryPolicyListInfo", // 报案登记查询
        registPageInit: "agriclaim/regist/registPageInit", // 报案登记页面初始化
        saveReport: "agriclaim/regist/saveReport", // 报案登记页面提交 暂存
        queryPrpLregistList: "agriclaim/regist/queryPrpLregistList", // 报案任务查询
        cancelReport: "agriclaim/regist/cancelReport", // 报案任务查询---撤销
        querySchedulByCondition: "agriclaim/schedule/querySchedulByCondition",//调度任务查询
        querySchedulDetail:"agriclaim/schedule/querySchedulDetail",//调度任务详情展示／编辑
        scheduleSaveDeal:"agriclaim/schedule/scheduleSaveDeal", //调度、改派按钮保存
        querySchedulEditByCondition: "agriclaim/prpLRegist/querySchedulEditByCondition",//调度任务编辑-班表查询
        queryEndCaseByCondition:"agriclaim/swfLog/queryEndCaseByCondition",//结案任务查询
        queryEndCaseDetailByCondition: "agriclaim/prpLClaim/queryEndCaseDetailByCondition",//结案任务初始化
        saveEndCaseInfo: "agriclaim/prpLClaim/saveEndCaseInfo",//保存结案登记信息
        queryFlowList: "agriclaim/prpLRegist/queryFlowList",//调度查询
        queryRegionalSetting: "agriclaim/prpLRegist/queryRegionalSetting",// 区域配置页面查询
        checkBox: "agriclaim/prpLRegist/checkBox", // 多选
        radio: "agriclaim/prpLRegist/radio", // 单选
        queryByComCaseInDto: "agriclaim/prpLCombine/queryByComCaseInDto",//合并案件
        saveCombine: "agriclaim/prpLCombine/saveCombine",//合并案件--新增合并
        logicRemoveCombine: "agriclaim/prpLCombine/logicRemoveCombine",//合并案件--删除合并
        queryByComCheckInDto:"agriclaim/prpLCombine/queryByComCheckInDto",//并案查勘定损任务
        comCheckPageInit:"agriclaim/prpLCombine/comCheckPageInit",//并案查勘定损初始化
        saveSubmitComCheck:"agriclaim/prpLCombine/saveSubmitComCheck",//并案查勘定损暂存、提交
        queryByComClaimInDto:"agriclaim/prpLCombine/queryByComClaimInDto", //并案管理---立案任务处理
        comClaimPageInit:"agriclaim/prpLCombine/comClaimPageInit", //并案管理---立案任务初始化
        saveSubmitComClaim:"agriclaim/prpLCombine/saveSubmitComClaim", //并案管理---立案任务暂存、提交
        queryByCheckIn: "agriclaim/check/queryByCheckIn",// 查勘定损查询
        checkPageInit:"agriclaim/check/checkPageInit",//查勘定损处理初始化
        saveCheckLoss:"agriclaim/check/saveCheckLoss",//查勘定损处理提交、暂存
        querySwfLogList:"agriclaim/prpLRegist/querySwfLogList",//并案查勘定损任务
        queryByCompeIn:"agriclaim/compensate/queryByCompeIn", //理算任务查询
        compensatePageInit:"agriclaim/compensate/compensatePageInit", //理算任务初始化
        saveSubmitBySaveIn:"agriclaim/compensate/saveSubmitBySaveIn", //理算暂存提交
        queryClaimCancelDetail:"agriclaim/claim/queryClaimCancelDetail", // 申请拒赔初始化
        claimCancelSubmit:"agriclaim/claim/claimCancelSubmit", // 申请拒赔提交
        paymentList:"agriclaim/prpLRegist/paymentList", //支付信息管理
        workflow:"agriclaim/prpLRegist/workflow", //工作流管理页面
        queryByClaimIn:"agriclaim/claim/queryByClaimIn", //立案任务查询
        rejectList:"agriclaim/prpLRegist/rejectList", //立案任务查询---申请注销/拒赔
        prpList:"agriclaim/prpLRegist/prpList", //立案任务查询---电子单证
        checkBoxList:"agriclaim/prpLRegist/checkBoxList", //立案任务查询---索赔清单
        claimPageInit:"agriclaim/claim/claimPageInit", //立案任务查询---查看界面初始化
        saveClaim:"agriclaim/claim/saveClaim", //立案任务查询-立案提交保存
        savePrplClaimLoss:"agriclaim/prpLClaimLoss/saveCLaimLoss",
        turnPageByPrimary:"agriclaim/workflowRove/turnPageByPrimary", //转交页面初始化
        workRoveByRovePage:"agriclaim/workflowRove/workRoveByRovePage", //转交提交
        assessment:"agriclaim/prpLRegist/assessment", //立案任务查看---险别估损金额信息
        dangerUnit:"agriclaim/prpLRegist/dangerUnit", //立案任务查看---危险单位信息
        processingList:"agriclaim/prpLRegist/processingList", //工作台---处理数据
        dispatchList:"agriclaim/prpLRegist/dispatchList", //工作台---调度任务处理
        taskHandleList:"agriclaim/prpLRegist/taskHandleList", //并案管理---立案任务处理
        queryReCaseByReCaseDto:"agriclaim/prpLRecase/queryReCaseByReCaseDto", //重开赔案---按条件列表查询
        querySwfModelMainByCondition:"agriclaim/workflow/querySwfModelMainByCondition", //工作流管理---按条件列表查询
        saveSwfModelUse:"agriclaim/workflow/saveSwfModelUse", //工作流管理---模板分配
        queryByValidStatus:"agriclaim/workflow/initSwfModelUseSave", //工作流管理---模板分配的机构和险种
        saveWorkFlowModelInfo:"agriclaim/workflow/saveWorkFlowModelInfo", //工作流管理---保存新创建的模板
        initWorkFlowModel:"agriclaim/workflow/initWorkFlowModel", //工作流管理---新创建的模板初始化
        modifyWorkFlowModelInfo:"agriclaim/workflow/modifyWorkFlowModelInfo", //工作流管理---修改的模板初始化
        queryWorkProcessByConditions:"agriclaim/workProcess/queryWorkProcessByConditions", //流程查询---条件查询
        querySwfLogAndSwfLogStoreByConditions:"agriclaim/workProcess/querySwfLogAndSwfLogStoreByConditions", //流程查询---案件流程节点列表信息查询
        queryByTurnSpeciIn:"agriclaim/prepay/queryByTurnSpeciIn",//特殊赔案申请查询
        queryPrepayApplyInfo:"agriclaim/prepay/queryPrepayApplyInfo",//特殊赔案申请初始化
        savePrepayApplication:"agriclaim/prepay/savePrepayApplication",//特殊赔案申请提交

        prepayPageInit:"agriclaim/prepay/prepayPageInit", //特殊赔案初始化
        savePrepay:"agriclaim/prepay/savePrepay",//特殊赔案暂存、提交
        queryBySpeciIn:"agriclaim/prepay/queryBySpeciIn",//特殊赔案处理查询
        expSpecCaseList:"agriclaim/lossList/expSpecCaseList",//特殊赔案清单下载
        expSpecCaseModelList:"agriclaim/lossList/expSpecCaseModelList",//特殊赔案清单模板下载
        importSpecCaseListExcel:"agriclaim/lossList/importSpecCaseListExcel",//特殊赔案清单上传
        // queryReCaseByReCaseDto:"/queryReCaseByReCaseDto",//重开赔案查询
        queryReCaseByClaimNo:"agriclaim/prpLRecase/queryReCaseByClaimNo",//重开赔案查看、修改、申请查询
        saveReCaseCommittedByReCaseDto:"agriclaim/prpLRecase/saveReCaseCommittedByReCaseDto",//重开赔案提交审批
        queryListByPrintType:"agriclaim/prpLClaim/queryListByPrintType",// 理赔打印
        comcode:"agriclaim/comcode",// 机构树
        queryPerilInfo:"agriclaim/regist/queryPerilInfo",// 已出险信息记录
        queryJobManagerByCondition:"agriclaim/prpLJobManager/queryJobManagerByCondition",// 班表主表列表
        queryJobManagerDetailByCondition:"agriclaim/prpLJobManager/queryJobManagerDetailByCondition",// 班表详情
        queryPrpLJobManagerByCondition:"agriclaim/prpLJobManager/queryPrpLJobManagerByCondition",// 班表Info（分页）
        // queryPrpLJobManagerByCondition:"prpLJobManager/queryPrpLJobManagerByCondition",// 班表保存及修改
        queryUnit:"ims/prpDcompany/queryUnit",// 查询机构（调度任务-编辑页面）
        queryCheckAndLossPeople:"ims/prpDuser/queryCheckAndLossPeople",// 查询人员（调度任务-编辑页面）
        queryRisk:"pms/prpDrisk/queryRiskByRiskType",//查询险种
        queryPrpDcompanyByComCodePrivate:"ims/prpDcompany/queryPrpDcompanyByComCodePrivate",//班表机构
        savePrpLJobManager:"agriclaim/prpLJobManager/savePrpLJobManager",//班表保存／修改
        queryPrpDuserByHandleDept:"ims/prpduser/queryPrpDuserByHandleDept",//被维护人查询
        queryPrplAreaSettingByCondition:"agriclaim/prplAreaSetting/queryPrplAreaSettingByCondition",//区域设置分页查询
        queryPrplAreaSettingByHandleDeptAndHandlerCode:"agriclaim/prplAreaSetting/queryPrplAreaSettingByHandleDeptAndHandlerCode",//班表机构或者被维护人查询
        checkPrplAreaSettingByHandlerCode:"agriclaim/prplAreaSetting/checkPrplAreaSettingByHandlerCode",//校验查勘人
        queryPrpDcompanyByHandleDept:"agriclaim/prpDcompany/queryPrpDcompanyByHandleDept",//查询作业区域
        batchSavePrplAreaSetting:"agriclaim/prplAreaSetting/batchSavePrplAreaSetting",//区域设置人员信息保存
        queryPrpLJobManagerByPolicyNoAndHandleDept:"agriclaim/prpLJobManager/queryPrpLJobManagerByPolicyNoAndHandleDept",//当天班表信息查询
        initSelectClaim:"agriclaim/initSelectClaim/initSelectClaim",//
        queryDispatcherPrpLJobManagerByCondition:"agriclaim/prpLJobManager/queryDispatcherPrpLJobManagerByCondition",//
        queryPrplAreaSettingByhandleDept:"agriclaim/prplAreaSetting/queryPrplAreaSettingByhandleDept",//班表机构下得出当班人

		giveupTemporary:"agriclaim/workflowRove/giveupTemporary",//放弃任务（通用）
        exportExcel:"agriclaim/importRateListing/exportExcel",//清单模板下载
        readBreedingList:"agriclaim/importRateListing/readBreedingList",//解析养殖险险并存入数据库
        readPlantingList:"agriclaim/importRateListing/readPlantingList",//解析种植险并存入数据库
        queryPlantingLossRateListByListNo:"txnlist/plantingLossRateList/queryPlantingLossRateListByListNo",//分页查询种植险清单信息
        queryBreedLossRateListDtoByListNo:"txnlist/breedLossRateList/queryBreedLossRateListDtoByListNo",//分页查询养殖险清单信息
        deleteByListNo:"agriclaim/importRateListing/deleteByListNo",//清单撤销

        nyxPlantingClaimListExportExcel:"agriclaim/lossList/nyxPlantingClaimListExportExcel",//种植险理赔清单下载将数据生成excel
        nyxBreedClaimListExportExcel:"agriclaim/lossList/nyxBreedClaimListExportExcel",//养殖险理赔清单下载将数据生成excel
        expBreedLossRateList:"agriclaim/lossList/expBreedLossRateList",//定损清单（养殖险）下载
        expPlantingLossRateList:"agriclaim/lossList/expPlantingLossRateList",//定损清单（种植险）下载
        expBreedAndPlantingLossRateList:"agriclaim/lossList/expBreedAndPlantingLossRateList",
        downloadist:"agriclaim/lossList/downloadist",//定损清单下载
        earmarkUnderwritingDownload:"agriclaim/prpLCompensate/expNyxPolicyList",//耳标号承保清单下载
        importPlantingClaimListExcel:"agriclaim/lossList/importPlantingClaimListExcel",//种植险理赔清单excel导入保存
        importBreedClaimListExcel:"agriclaim/lossList/importBreedClaimListExcel",//养殖险理赔清单excel导入保存
        saveregistNo:"txnlist/lossRateMainList/compareInsurance",//根据清单号会写报案号
        saveclaimNo:"txnlist/nyxPlantingClaimList/saveclaimNo",//根据报案号，清单号回写立案号  种植
        saveBreedclaimNo:"txnlist/nyxBreedClaimList/saveclaimNo",//根据报案号，清单号回写立案号 养殖
        queryClaimCommunicationByCondition:"agriclaim/prpLMessage/queryClaimCommunicationByCondition",//理赔沟通查询
        saveClaimCommunicationInfo:"agriclaim/prpLMessage/saveClaimCommunicationInfo",//理赔沟通保存
        NyxPolicyListExportExcel:"agriclaim/prpLCompensate/expNyxPolicyList",//承保分户清单的下载
        nyxPlantingClaimList:"agriclaim/templateFile/download?fileType=nyxPlantingClaimList",//种植险理赔清单空模版下载
        nyxBreedClaimLis:"agriclaim/templateFile/download?fileType=nyxBreedClaimLis",//养殖险理赔清单空模版下载
        selectfind:'ims/login/queryComCodeList',//登陆机构
        uploadBreedingList:"agriclaim/importRateListing/uploadBreedingList",//清单导入
        queryCompareBillByConditions:"txnlist/lossRateMainList/queryByConditions",//关联清单
        nyxdownloadlList:"txnlist/lossRateMainList/downloadlList",//查询养殖险定损清单
        plantingdownloadlList:"txnlist/lossRateMainList/plantingdownloadlList",//查询种殖险定损清单
        compareInsurance:"txnlist/lossRateMainList/compareInsurance",//开始关联清单
        queryVirturlItemByPolicyNo:"agriprpall/prpCvirturlItem/queryVirturlItemByPolicyNo",// 查询被保险人列表
        saveModifyDetail:'agriclaim/claim/saveModifyDetail',// 估损金额保存
        queryClaimBillSummary:"txnlist/nyxPlantingClaimList/queryClaimBillSummary",// 赔款计算过程生成
        queryBreedProcess:"txnlist/nyxBreedClaimList/queryBreedProcess",//养殖险计算过程生成
        copyPrint:"agriclaim/print/copyPrint",// 抄单打印
        queryByConditions:"dms/prpDatsCode/queryByConditions",// 银行、省市查询
        prpLexternalAgency:"dms/prpLexternalAgency/queryByConditions ",//第三方机构ID
        transportXML:"agriclaim/systemToImage/transportXML",//信雅达影像上传与查看
        queryClaimList:"agriclaim/prpLDoc/queryClaimList",//索赔清单查询
        saveClaimCommunicationInfo:"agriclaim/prpLMessage/saveClaimCommunicationInfo",//理赔沟通保存
        claimCertifyPrint:"agriclaim/print/claimCertifyPrint",//索赔须知打印的接口
        saveCertify:"agriclaim/prpLDoc/saveCertify",//索赔清单（单证）保存
        queryAllByRegistNoAndNodeType:"txnlist/nyxPlantingClaimList/queryByRegistNoAndNodeType",//根据报案号和节点类型查询数据
        makeDangerUnitBack:"agriclaim/claim/makeDangerUnit",//生成危险单位
        //支付信息相关接口
        queryPrpJPlanFeePageMsgDto:"agriclaim/prplPay/queryPrpJPlanFeePageMsgDto",//查询支付录入信息(带分页)
        queryPrplPayDtoByCondition:"agriclaim/prplPay/queryPrplPayDtoByCondition",//支付管理信息查询（带分页）
        savePayMain:"agriclaim/prplPay/savePayMain",//支付录入整单支付暂存与提交,清单支付提交
        updateCancelFlagByPaymentNo:"agriclaim/prplPay/updateCancelFlagByPaymentNo",//支付单作废
        queryInitEntirePay:"agriclaim/prplPay/queryInitEntirePay",//整单支付修改按钮查询
        syncyAccount:"agriclaim/prplPay/synchAccount",//账户同步按钮
        queryPaymentStatistics:"agriclaim/prplPay/queryPaymentStatistics",//支付情况统计表
        paymentStatisticsExportExcel:"agriclaim/prplPay/paymentStatisticsExportExcel",//支付情况统计表导出excel
        queryPayDetail:"agriclaim/prplPay/queryPayDetail",//支付情况统计详细信息
        queryOnTheWayList:"agriclaim/prplPay/queryOnTheWayList",//支付信息统计表在途金额飘窗
        queryPrpLGrowthByConditions:"agriclaim/prpLGrowth/queryPrpLGrowthByConditions",//查询生长期
        queryPrpLRegistAndPrpCmainByConditions:"agriclaim/prpLGrowth/queryPrpLRegistAndPrpCmainByConditions",//查询条款和标的
        getInsureListInfoFileId:"agriprpall/plantingexcel/getInsureListInfoFileId",//承保清单下载
        download:"agriclaim/templateFile/download",//支付清单模板下载
        expNyxClaimPayList:"agriclaim/prplPay/expNyxClaimPayList",//支付清单下载
        expAssembleClaimPayList:"agriclaim/prplPay/expAssembleClaimPayList",//最新支付清单模板下载
        importNyxClaimPayList:"agriclaim/prplPay/importNyxClaimPayList",//支付清单导入
        downloadReceipt:"agriclaim/prplPay/downloadReceipt",//电子回执单下载
        queryNyxClaimPayListByCompensateNo:"txnlist/nyxClaimPayList/queryNyxClaimPayListByCompensateNo",//根据理算书号查询支付清单信息
        submitInvestigation:"agriclaim/prpLInvestigate/submitInvestigation",//发起调查
        queryPrpLMessageByRegistNo:"agriclaim/prpLMessage/queryPrpLMessageByRegistNo",//查看留言
        queryBreedAndPlantingLossRateListPageInit:"agriclaim/lossList/queryBreedAndPlantingLossRateListPageInit",//查勘定损页面初始化查询金禾清单
        queryPlantingLossRateListByLossListCode:"txnlist/lossRateMainList/queryPlantingLossRateListByLossListCode",//查询种植险的定损清单
        queryBreedLossRateListByLossListCode:"txnlist/lossRateMainList/queryBreedLossRateListByLossListCode",//查询养殖险的定损清单
        //findCheckId:"txnlist/lossRateMainList/findCheckId",//通过保单号和报案号查询查勘编号CheckId
        updateLossRateMainListByLossListCode:"txnlist/lossRateMainList/updateLossRateMainListByLossListCode",//通过清单号和保单号回写报案号
        querySwfNotionByFlowId:"agriclaim/swfNotion/querySwfNotionByFlowId",//查询审核意见
    }
});



