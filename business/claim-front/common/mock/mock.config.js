/**
 * Created by zhuqianqian on 2017/11/20.
 */
define(
    [
        'config',
        'jsonDB'
    ],function (config,jsonDB) {

        /**
         * 此处定义接口处理回调方法，对于需要特殊处理的接口，定义回调，覆盖默认的返回处理
         * @author admin
         * @date   2017/11/21
         * @param method
         * @param url
         * @param req 请求数据
         * @param res 返回数据
         * @returns {*} api处理结果
         */
        var initSelectTagCallBack = function(method, url, req, res){
            var param = JSON.parse(req);
            if(param.codeType == "PersonalIdentifyType") {
                return [200,res.PersonalIdentifyType]
            }else if(param.codeType == "BusinessNature") {
                return [200,res.BusinessNature]
            }
        };

        /**
         * 此处定义每个接口mock处理的映射表，相同系统接口请放在一起
         * name:接口名,无逻辑判断；desc:接口中文描述; method:接口处理方法(GET/POST); url:接口调用url,对应后台的url; data:接口返回值: callback:回调方法,用在需要对返回值特殊处理时,可空
         * @author admin
         * @date   2017/11/21
         */
        return [
            /** 系统接口 */
            //{"name":"menu", "desc":"菜单查询", "method":"POST", "url":config.backend.ip+config.backend.showMenu, "data":jsonDB['showMenu']},

            // {"name":"queryByTurnSpeciIn", "desc":"特殊赔案申请查询", "method":"POST", "url":config.backend.ip + config.backend.queryByTurnSpeciIn, "data":jsonDB['queryByTurnSpeciIn']},
            // {"name":"queryPolicyListInfo", "desc":"报案登记查询", "method":"POST", "url":config.backend.queryPolicyListInfo, "data":jsonDB['queryPolicyListInfo']},
            // {"name":"queryPrpLregistList", "desc":"报案任务查询", "method":"POST", "url":config.backend.queryPrpLregistList, "data":jsonDB['queryPrpLregistList']},
            // {"name":"querySchedulByCondition", "desc":"调度任务处理查询", "method":"POST", "url":config.backend.querySchedulByCondition, "data":jsonDB['querySchedulByCondition']},
            // {"name":"queryBySpeciInDto", "desc":"特殊赔案处理", "method":"POST", "url":config.backend.ip + config.backend.queryBySpeciInDto, "data":jsonDB['queryBySpeciInDto']},
            // {"name":"prepayPageInit", "desc":"特殊赔案处理-初始化", "method":"POST", "url":config.backend.ip + config.backend.prepayPageInit, "data":jsonDB['prepayPageInit']},
            // {"name":"querySchedulDetail", "desc":"调度任务详情展示", "method":"POST", "url":config.backend.querySchedulDetail, "data":jsonDB['querySchedulDetail']},
            // {"name":"scheduleSaveDeal", "desc":"调度、改派保存", "method":"POST", "url":config.backend.scheduleSaveDeal, "data":jsonDB['scheduleSaveDeal']},
            // {"name":"reportQuery", "desc":"调度任务-班表弹层查询", "method":"POST", "url":config.backend.querySchedulEditByCondition, "data":jsonDB['querySchedulEditByCondition']},
            // {"name":"reportQuery", "desc":"结案任务处理查询", "method":"POST", "url":config.backend.queryEndcaseList, "data":jsonDB['queryEndcaseList']},
            // {"name":"reportQuery", "desc":"调度查询", "method":"POST", "url":config.backend.queryFlowList, "data":jsonDB['queryFlowList']},
            // {"name":"reportTaskQuery", "desc":"区域设置查询", "method":"POST", "url":config.backend.queryRegionalSetting, "data":jsonDB['queryRegionalSetting']},
            // {"name":"checkBox", "desc":"多选", "method":"POS   T", "url":config.backend.checkBox, "data":jsonDB['checkBox']},
            // {"name":"radio", "desc":"单选", "method":"POST", "url":config.backend.radio, "data":jsonDB['radio']},
            // {"name":"combineQuery", "desc":"合并案件", "method":"POST", "url":config.backend.swfLogList, "data":jsonDB['swfLogList']},
            // {"name":"combineCheckQuery", "desc":"并案查勘定损任务", "method":"POST", "url":config.backend.querySwfLogList, "data":jsonDB['querySwfLogList']},
            // {"name":"CompenstateQuery", "desc":"理算任务查询", "method":"POST", "url":config.backend.queryByCompeIn, "data":jsonDB['queryByCompeIn']},
            // {"name":"paymentStatisticsList", "desc":"支付信息管理", "method":"POST", "url":config.backend.paymentList, "data":jsonDB['paymentList']},
            // {"name":"paymentStatisticsList", "desc":"支付情况统计表", "method":"POST", "url":config.backend.paymentList, "data":jsonDB['paymentList']},
            // {"name":"queryByCheckIn", "desc":"查勘定损查询接口", "method":"POST", "url":config.backend.queryByCheckIn, "data":jsonDB['queryByCheckIn']},
            // {"name":"WorkFlowModel", "desc":"工作流管理", "method":"POST", "url":config.backend.workflow, "data":jsonDB['workflow']},
            // {"name":"supInstruct", "desc":"调度任务--补充说明", "method":"POST", "url":config.backend.supInstruct, "data":jsonDB['supInstruct']},
            // {"name":"rejectList", "desc":"立案任务查询---申请注销/拒赔", "method":"POST", "url":config.backend.rejectList, "data":jsonDB['rejectList']},
            // {"name":"queryByClaimInDto", "desc":"立案任务查询---种植险", "method":"POST", "url":config.backend.queryByClaimInDto, "data":jsonDB['queryByClaimInDto']},
            // {"name":"prpList", "desc":"立案任务查询---电子单证", "method":"POST", "url":config.backend.prpList, "data":jsonDB['prpList']},
            // {"name":"checkBoxList", "desc":"立案任务查询---索赔清单", "method":"POST", "url":config.backend.checkBoxList, "data":jsonDB['checkBoxList']},
            // {"name":"assessment", "desc":"立案任务查看", "method":"POST", "url":config.backend.assessment, "data":jsonDB['assessment']},
            // {"name":"dangerUnit", "desc":"立案任务查看---危险单位信息", "method":"POST", "url":config.backend.dangerUnit, "data":jsonDB['dangerUnit']},
            // {"name":"processingList", "desc":"工作台---处理数据", "method":"POST", "url":config.backend.processingList, "data":jsonDB['processingList']},
            // {"name":"dispatchList", "desc":"工作台---调度任务处理", "method":"POST", "url":config.backend.dispatchList, "data":jsonDB['dispatchList']},
            // {"name":"taskHandleList", "desc":"并案管理---立案任务处理", "method":"POST", "url":config.backend.taskHandleList, "data":jsonDB['taskHandleList']},
            // {"name":"recaseList", "desc":"重开赔案---按条件列表查询", "method":"POST", "url":config.backend.recaseList, "data":jsonDB['recaseList']},
            // {"name":"querySwfModelMainByCondition", "desc":"工作流管理---按条件列表查询", "method":"POST", "url":config.backend.querySwfModelMainByCondition, "data":jsonDB['querySwfModelMainByCondition']},
            // {"name":"saveSwfModelUse", "desc":"工作流管理---模板分配", "method":"POST", "url":config.backend.saveSwfModelUse, "data":jsonDB['saveSwfModelUse']},
            // {"name":"saveWorkFlowModelInfo", "desc":"工作流管理---保存新创建的模板", "method":"POST", "url":config.backend.saveWorkFlowModelInfo, "data":jsonDB['saveWorkFlowModelInfo']},
            // {"name":"initWorkFlowModel", "desc":"工作流管理---新创建的模板初始化", "method":"POST", "url":config.backend.initWorkFlowModel, "data":jsonDB['initWorkFlowModel']},
            // {"name":"queryWorkProcessByConditions", "desc":"流程查询---按条件列表查询", "method":"POST", "url":config.backend.queryWorkProcessByConditions, "data":jsonDB['queryWorkProcessList']},
            // {"name":"querySwfLogAndSwfLogStoreByConditions", "desc":"流程查询---案件流程节点列表信息查询", "method":"POST", "url":config.backend.querySwfLogAndSwfLogStoreByConditions, "data":jsonDB['queryByConditionList']},
            // {"name":"comcode", "desc":"机构树treeList", "method":"POST", "url":config.backend.ip + config.backend.comcode, "data":jsonDB['comcode']},
            // {"name":"queryUnit", "desc":"机构树treeList", "method":"POST", "url":config.backend.ip + config.backend.queryUnit, "data":jsonDB['queryUnit']},
            // {"name":"queryListByPrintType", "desc":"理赔打印查询", "method":"POST", "url":config.backend.ip + config.backend.queryListByPrintType, "data":jsonDB['queryListByPrintType']},
            // {"name":"queryBySpeciInDto", "desc":"特殊赔案处理查询", "method":"POST", "url":config.backend.ip + config.backend.queryBySpeciInDto, "data":jsonDB['queryBySpeciInDto']},
            // {"name":"compensatePageInit", "desc":"理赔页面初始化", "method":"POST", "url":config.backend.ip + config.backend.compensatePageInit, "data":jsonDB['compensatePageInit']},
            // {"name":"queryJobManagerByCondition", "desc":"班表查询", "method":"POST", "url":config.backend.ip + config.backend.queryJobManagerByCondition, "data":jsonDB['queryJobManagerByCondition']},
            // {"name":"queryPrpDcompanyByComCodePrivate", "desc":"班表机构", "method":"POST", "url":config.backend.ip + config.backend.queryPrpDcompanyByComCodePrivate, "data":jsonDB['queryPrpDcompanyByComCodePrivate']},
            // {"name":"queryJobManagerDetailByCondition", "desc":"班表详情", "method":"POST", "url":config.backend.ip + config.backend.queryJobManagerDetailByCondition, "data":jsonDB['queryJobManagerDetailByCondition']},
            // {"name":"savePrpLJobManager", "desc":"班表保存", "method":"POST", "url":config.backend.ip + config.backend.savePrpLJobManager, "data":jsonDB['savePrpLJobManager']},
            // {"name":"queryPrpDuserByHandleDept", "desc":"被维护人查询", "method":"POST", "url":config.backend.ip + config.backend.queryPrpDuserByHandleDept, "data":jsonDB['queryPrpDuserByHandleDept']},
            // {"name":"queryPrplAreaSettingByCondition", "desc":"区域设置分页查询", "method":"POST", "url":config.backend.ip + config.backend.queryPrplAreaSettingByCondition, "data":jsonDB['queryPrplAreaSettingByCondition']},
            // {"name":"queryPrplAreaSettingByHandleDeptOrHandlerCode", "desc":"班表机构或者被维护人查询", "method":"POST", "url":config.backend.ip + config.backend.queryPrplAreaSettingByHandleDeptOrHandlerCode, "data":jsonDB['queryPrplAreaSettingByHandleDeptOrHandlerCode']},
            // {"name":"checkPrplAreaSettingByHandlerCode", "desc":"班表机构或者被维护人查询", "method":"POST", "url":config.backend.ip + config.backend.checkPrplAreaSettingByHandlerCode, "data":jsonDB['checkPrplAreaSettingByHandlerCode']},
            // {"name":"queryPrpDcompanyByHandleDept", "desc":"班表机构或者被维护人查询", "method":"POST", "url":config.backend.ip + config.backend.queryPrpDcompanyByHandleDept, "data":jsonDB['queryPrpDcompanyByHandleDept']},
            // {"name":"batchSavePrplAreaSetting", "desc":"区域设置人员信息保存", "method":"POST", "url":config.backend.ip + config.backend.batchSavePrplAreaSetting, "data":jsonDB['batchSavePrplAreaSetting']},
            // {"name":"queryPrpLJobManagerByPolicyNoAndHandleDept", "desc":"区域设置人员信息保存", "method":"POST", "url":config.backend.ip + config.backend.queryPrpLJobManagerByPolicyNoAndHandleDept, "data":jsonDB['queryPrpLJobManagerByPolicyNoAndHandleDept']},
            // {"name":"initSelectClaim", "desc":"归属机构", "method":"POST", "url":config.backend.ip + config.backend.initSelectClaim, "data":jsonDB['initSelectClaim']},
            // {"name":"queryDispatcherPrpLJobManagerByCondition", "desc":"归属机构", "method":"POST", "url":config.backend.ip + config.backend.queryDispatcherPrpLJobManagerByCondition, "data":jsonDB['queryDispatcherPrpLJobManagerByCondition']},
            // {"name":"userInfo", "desc":"归属机构", "method":"POST", "url":config.backend.ip + config.backend.userInfo, "data":jsonDB['userInfo']},

            // {"name":"uploadBreedingList", "desc":"定损清单导入", "method":"POST", "url":'/api/agriclaim/importRateListing/uploadBreedingList', "data":jsonDB['uploadBreedingList']},
            // {"name":"exportExcel", "desc":"清单模板下载", "method":"POST", "url":config.backend.ip + config.backend.exportExcel, "data":jsonDB['exportExcel']},
            // {"name":"readBreedingList", "desc":"解析养殖险险并存入数据库", "method":"POST", "url":config.backend.ip + config.backend.readBreedingList, "data":jsonDB['readBreedingList']},
            // {"name":"readPlantingList", "desc":"解析种植险并存入数据库", "method":"POST", "url":config.backend.ip + config.backend.readPlantingList, "data":jsonDB['readPlantingList']},
            // {"name":"queryPlantingLossRateListByListNo", "desc":"分页查询种植险清单信息", "method":"POST", "url":config.backend.ip + config.backend.queryPlantingLossRateListByListNo, "data":jsonDB['queryPlantingLossRateListByListNo']},
            // {"name":"queryBreedLossRateListDtoByListNo", "desc":"分页查询养殖险清单信息", "method":"POST", "url":config.backend.ip + config.backend.queryBreedLossRateListDtoByListNo, "data":jsonDB['queryBreedLossRateListDtoByListNo']},

            // {"name":"nyxPlantingClaimListExportExcel", "desc":"种植险理赔清单导出Excel", "method":"POST", "url":config.backend.ip + config.backend.nyxPlantingClaimListExportExcel, "data":jsonDB['nyxPlantingClaimListExportExcel']},
            // {"name":"nyxBreedClaimListExportExcel", "desc":"养殖险理赔清单下载将数据生成excel", "method":"POST", "url":config.backend.ip + config.backend.nyxBreedClaimListExportExcel, "data":jsonDB['nyxBreedClaimListExportExcel']},
            // {"name":"expBreedLossRateList", "desc":"定损清单（养殖险）下载", "method":"POST", "url":config.backend.ip + config.backend.expBreedLossRateList, "data":jsonDB['expBreedLossRateList']},
            // {"name":"expPlantingLossRateList", "desc":"定损清单（种植险）下载", "method":"POST", "url":config.backend.ip + config.backend.expPlantingLossRateList, "data":jsonDB['expPlantingLossRateList']},

            // {"name":"queryClaimCommunicationByCondition", "desc":"理赔沟通", "method":"POST", "url":config.backend.ip + config.backend.queryClaimCommunicationByCondition, "data":jsonDB['queryClaimCommunicationByCondition']},
            // {"name":"saveClaimCommunicationInfo", "desc":"理赔沟通保存", "method":"POST", "url":config.backend.ip + config.backend.saveClaimCommunicationInfo, "data":jsonDB['saveClaimCommunicationInfo']},
        ]
    }
);