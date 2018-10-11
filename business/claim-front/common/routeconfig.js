/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app'
], function (app) {
    app.registerProvider('routeDefs', [
        '$stateProvider',
        '$urlRouterProvider',
        '$couchPotatoProvider',
        '$locationProvider',
        '$provide',
        function ($stateProvider,
                  $urlRouterProvider,
                  $couchPotatoProvider) {
            this.$get = function () {
                return {};
            };
            $urlRouterProvider.when('', '/');
            $urlRouterProvider.otherwise('/dashboard');
            $stateProvider
            //登录
                .state('login', {
                    url: '/login',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/frame/login/login.ctrl'])
                    },
                    templateUrl: 'common/frame/login/login.tpl.html',
                    controller: 'loginCtrl'
                })
                .state("pdf", {
                    url:"/pdf?data",
                    templateUrl: 'common/business/public/pdfPrint.html',
                    controller:'pdfPrintCtrl',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/public/pdfPrint.ctrl.js'
                        ])
                    }
                })
                // 首页
                .state('dashboard', {
                    url: '/dashboard',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/frame/dashboard/dashboard.ctrl',
                            'common/frame/dashboard/model/dashboard.ComFun.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/frame/dashboard/dashboard.tpl.html',
                            controller: 'dashboardCtrl'
                        },
                        "comFun@dashboard":{
                            templateUrl: 'common/frame/dashboard/model/dashboard.ComFun.model.html',
                            controller: 'dashboardComFunModelCtrl'
                        }
                    }
                })
                // 工作台---调度任务处理
                .state('dashboardDispatch', {
                    url: '/dashboardDispatch',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/frame/dashboard/dashboard.Diapatch.ctrl',
                        ])
                    },
                    templateUrl: 'common/frame/dashboard/dashboard.Dispatch.tpl.html',
                    controller: 'dashboardDiapatchCtrl'
                })
                // 报案登记查询
                .state('UIAgriRegistBeforeQuery', {
                    url: '/UIAgriRegistBeforeQuery?authSystemFlag',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/regist/UIAgriRegist.BeforeQuery.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/regist/UIAgriRegist.BeforeQuery.tpl.html',
                    controller: 'UIAgriRegistBeforeQueryCtrl'
                })
                // 报案任务查询
                .state('UIAgriRegistQuery', {
                    url: '/UIAgriRegistQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/regist/UIAgriRegist.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/regist/UIAgriRegist.Query.tpl.html',
                    controller: 'UIAgriRegistQueryCtrl'
                })
                // 报案任务编辑
                .state('UIAgriRegist', {
                    url: '/UIAgriRegist?authSystemFlag?editType?policyNo?registNo?riskCode?businessNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/regist/UIAgriRegist.ctrl',
                            // 'common/business/public/PerilCount.model.ctrl'
                        ])
                    },
                    // views:{
                    //     main:{
                            templateUrl: 'common/business/regist/UIAgriRegist.tpl.html',
                            controller: 'UIAgriRegistCtrl'
                        // },
                        // "perilCount@UIAgriRegist":{ // 出险次数弹层（公共）
                        //     templateUrl: 'common/business/public/PerilCount.model.html',
                        //     controller: 'PerilCountCtrl'
                        // }
                    // }
                })
                // 出险次数弹层（公共）
                .state('PerilCount', {
                    url: '/PerilCount?policyNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/public/PerilCount.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/public/PerilCount.html',
                    controller: 'PerilCountCtrl'
                })
                // 查勘定损任务查询
                .state('UIAgriCheckQuery', {
                    url: '/UIAgriCheckQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/check/UIAgriCheck.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/check/UIAgriCheck.Query.tpl.html',
                    controller: 'UIAgriCheckQueryCtrl'
                })
                // 查勘定损
                .state('UIAgriCheck', {
                    url: '/UIAgriCheck?editType?riskCode?registNo?flowId?logNo?checkNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/check/UIAgriCheck.ctrl'
                            // 'common/business/check/model/UIAgriCheck.Connect.model.ctrl',
                            // 'common/business/check/model/UIAgriCheck.Document.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/check/UIAgriCheck.tpl.html',
                            controller: 'UIAgriCheckCtrl'
                        }
                        // "connect@UIAgriCheck":{
                        //     templateUrl: 'common/business/check/model/UIAgriCheck.Connect.model.html',
                        //     controller: 'UIAgriCheckConnectCtrl'
                        // },
                        // "document@UIAgriCheck":{
                        //     templateUrl: 'common/business/check/model/UIAgriCheck.Document.model.html',
                        //     controller: 'UIAgriCheckDocumentCtrl'
                        // }
                    }



                    // documen
                })
                //班表管理
                .state('UIAgriSchedule', {
                    url: '/UIAgriSchedule',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/schedule/UIAgriSchedule.ctrl'])
                    },
                    templateUrl: 'common/business/schedule/UIAgriSchedule.tpl.html',
                    controller: 'UIAgriScheduleCtrl'
                })
                //班表管理-查询
                .state('UIAgriScheduleQuery', {
                    url: '/UIAgriScheduleQuery?handleDept',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/schedule/UIAgriSchedule.query.ctrl'])
                    },
                    templateUrl: 'common/business/schedule/UIAgriSchedule.query.tpl.html',
                    controller: 'UIAgriQueryScheduleCtrl'
                })
                //班表管理-新增
                .state('UIAgriScheduleAdd', {
                    url: '/UIAgriScheduleAdd/:scheduleAdd',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/schedule/UIAgriSchedule.Add.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/schedule/UIAgriSchedule.Add.tpl.html',
                    controller: 'UIAgriScheduleAddCtrl'
                })
                //区域设置-新增
                .state('regionalSettingAdd', {
                    url: '/regionalSettingAdd/:regionalAdd',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/schedule/regionalSetting.add.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/schedule/regionalSetting.add.tpl.html',
                    controller: 'regionalSettingAddCtrl'
                })
                //区域设置
                .state('regionalSetting', {
                    url: '/regionalSetting',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/schedule/regionalSetting.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/schedule/regionalSetting.tpl.html',
                    controller: 'regionalSettingCtrl'
                })
                //调度任务查询
                .state('UIAgriDispatch', {
                    url: '/UIAgriDispatch',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/dispatch/UIAgriDispatch.ctrl',
                        ])
                    },
                    templateUrl: 'common/business/dispatch/UIAgriDispatch.tpl.html',
                    controller: 'UIAgriDispatchCtrl'
                })
                // 调度任务-编辑
                .state('UIAgriDispatchEdit', {
                    url: '/UIAgriDispatchEdit?editType?riskCode?registNo?scheduleID?policyNo?nodeType?modelNo?nodeNo?commiFlag?schedFlag?swflogFlowId?swflogLogNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/dispatch/UIAgriDispatch.Edit.ctrl',
                            'common/business/dispatch/model/UIAgriDispatch.SendMessage.model.ctrl',
                            'common/business/dispatch/model/UIAgriDispatch.ScheduleQuery.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/dispatch/UIAgriDispatch.Edit.tpl.html',
                            controller: 'UIAgriDispatchEditCtrl'
                        },
                        "sendMessage@UIAgriDispatchEdit":{
                            templateUrl: 'common/business/dispatch/model/UIAgriDispatch.SendMessage.model.html',
                            controller: 'UIAgriDispatchSendMessageModelCtrl'
                        },
                        "scheduleQuery@UIAgriDispatchEdit":{
                            templateUrl: 'common/business/dispatch/model/UIAgriDispatch.ScheduleQuery.model.html',
                            controller: 'UIAgriDispatchScheduleQueryModelCtrl'
                        }
                    }
                })
                //调度任务-改派
                .state('UIAgriDispatchReassignment', {
                    url: '/UIAgriDispatchReassignment?editType?riskCode?registNo?scheduleID?policyNo?nodeType?modelNo?nodeNo?commiFlag?schedFlag?swflogFlowId?swflogLogNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/dispatch/UIAgriDispatch.Reassignment.ctrl',
                            'common/business/dispatch/model/UIAgriDispatch.SendMessage.model.ctrl',
                            'common/business/dispatch/model/UIAgriDispatch.ScheduleQuery.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/dispatch/UIAgriDispatch.Reassignment.tpl.html',
                            controller: 'UIAgriDispatchReassignmentCtrl'
                        },
                        "sendMessage@UIAgriDispatchEdit":{
                            templateUrl: 'common/business/dispatch/model/UIAgriDispatch.SendMessage.model.html',
                            controller: 'UIAgriDispatchSendMessageModelCtrl'
                        },
                        "scheduleQuery@UIAgriDispatchEdit":{
                            templateUrl: 'common/business/dispatch/model/UIAgriDispatch.ScheduleQuery.model.html',
                            controller: 'UIAgriDispatchScheduleQueryModelCtrl'
                        }
                    }
                })
                // 立案任务查询
                .state('UIAgriClaimQuery', {
                    url: '/UIAgriClaimQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/claim/UIAgriClaim.Query.ctrl',
                            'common/business/claim/model/UIAgriClaim.AssLoss.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/claim/UIAgriClaim.Query.tpl.html',
                            controller: 'UIAgriClaimQueryCtrl'
                        },
                        "AssLoss@UIAgriClaimQuery":{ //调整估损金额弹层
                            templateUrl: 'common/business/claim/model/UIAgriClaim.AssLoss.model.html',
                            controller: 'UIAgriClaimAssLossModelCtrl'
                        }
                    }
                })
                // 转交页面 公共页面)
                .state('UIAgriClaimTransfer', {
                    url: '/UIAgriClaimTransfer?data',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/public/UIAgriClaim.Transfer.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/public/UIAgriClaim.Transfer.tpl.html',
                    controller: 'UIAgriClaimTransferCtrl'
                })
                // 立案任务查看页面
                .state('UIAgriClaimSee', {
                    url: '/UIAgriClaimSee?authSystemFlag?editType?claimNo?riskCode?policyNo?flowId?registNo?businessNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/claim/UIAgriClaim.See.ctrl',
                            // 'common/business/claim/model/UIAgriClaim.Communication.model.ctrl',
                            // 'common/business/claim/model/UIAgriClaim.EleDocument.model.ctrl',
                            'common/business/claim/model/UIAgriClaim.InforList.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/claim/UIAgriClaim.See.tpl.html',
                            controller: 'UIAgriClaimSeeCtrl'
                        },
                        // "communication@UIAgriClaimSee":{ // 理赔沟通弹层
                        //     templateUrl: 'common/business/claim/model/UIAgriClaim.Communication.model.html',
                        //     controller: 'UIAgriClaimCommunicationModelCtrl'
                        // },
                        // "eleDocument@UIAgriClaimSee":{ // 电子单证弹层
                        //     templateUrl: 'common/business/claim/model/UIAgriClaim.EleDocument.model.html',
                        //     controller: 'UIAgriClaimEleDocumentModelCtrl'
                        // },
                        "inforList@UIAgriClaimSee":{ // 索赔资料清单弹层
                            templateUrl: 'common/business/claim/model/UIAgriClaim.InforList.model.html',
                            controller: 'UIAgriClaimInforListModelCtrl'
                        }
                    }
                })
                // 申请注销/拒赔页面 (立案和理算公共页面)
                .state('UIAgriClaimReject', {
                    url: '/UIAgriClaimReject?data',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/claim/UIAgriClaim.Reject.ctrl',
                            'common/business/claim/model/UIAgriClaim.EleDocument.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/claim/UIAgriClaim.Reject.tpl.html',
                            controller: 'UIAgriClaimRejectCtrl'
                        },
                        "eleDocument@UIAgriClaimReject":{ // 电子单证弹层
                            templateUrl: 'common/business/claim/model/UIAgriClaim.EleDocument.model.html',
                            controller: 'UIAgriClaimEleDocumentModelCtrl'
                        }
                    }
                })
                // 立案编辑---种植险/养殖险页面
                .state('UIAgriClaimHandle', {
                    url: '/UIAgriClaimHandle?editType?claimNo?registNo?flowId?logNo?riskCode?policyNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/claim/UIAgriClaim.Handle.ctrl',
                            // 'common/business/claim/model/UIAgriClaim.Communication.model.ctrl',
                            // 'common/business/claim/model/UIAgriClaim.EleDocument.model.ctrl',
                            'common/business/claim/model/UIAgriClaim.InforList.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/claim/UIAgriClaim.Handle.tpl.html',
                            controller: 'UIAgriClaimHandleCtrl'
                        },
                        // "communication@UIAgriClaimHandle":{ // 理赔沟通弹层
                        //     templateUrl: 'common/business/claim/model/UIAgriClaim.Communication.model.html',
                        //     controller: 'UIAgriClaimCommunicationModelCtrl'
                        // },
                        // "eleDocument@UIAgriClaimHandle":{ // 电子单证弹层
                        //     templateUrl: 'common/business/claim/model/UIAgriClaim.EleDocument.model.html',
                        //     controller: 'UIAgriClaimEleDocumentModelCtrl'
                        // },
                        "inforList@UIAgriClaimHandle":{ // 索赔资料清单弹层
                            templateUrl: 'common/business/claim/model/UIAgriClaim.InforList.model.html',
                            controller: 'UIAgriClaimInforListModelCtrl'
                        }
                    }
                })
                // 特殊赔案申请查询
                .state('UIAgriPrepayApplyQuery', {
                    url: '/UIAgriPrepayApplyQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/prepay/apply/UIAgriPrepay.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/prepay/apply/UIAgriPrepay.Query.tpl.html',
                    controller: 'UIAgriPrepayApplyQueryCtrl'
                })
                // 特殊赔案申请
                .state('UIAgriPrepayApply', {
                    url: '/UIAgriPrepayApply?editType?riskCode?claimNo?nodeType?logNo?flowId?nodeStatus',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/prepay/apply/UIAgriPrepay.Apply.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/prepay/apply/UIAgriPrepay.Apply.tpl.html',
                    controller: 'UIAgriPrepayApplyCtrl'
                })
                //特殊赔案处理查询
                .state('UIAgriPrepayHandleQuery', {
                    url: '/UIAgriPrepayHandleQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/prepay/handle/UIAgriPrepay.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/prepay/handle/UIAgriPrepay.Query.tpl.html',
                    controller: 'UIAgriPrepayHandleQueryCtrl'
                })
                //特殊赔案处理
                .state('UIAgriPrepayHandle', {
                    url: '/UIAgriPrepayHandle?editType?claimNo?prepayNo?flowID?logNo?modelNo?nodeNo?authSystemFlag?businessNo?registNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/prepay/handle/UIAgriPrepay.Handle.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/prepay/handle/UIAgriPrepay.Handle.tpl.html',
                    controller: 'UIAgriPrepayHandleCtrl'
                })
                // 理算任务查询
                .state('UIAgriCompenstateQuery', {
                    url: '/UIAgriCompenstateQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/compenstate/UIAgriCompenstate.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/compenstate/UIAgriCompenstate.Query.tpl.html',
                    controller: 'UIAgriCompenstateQueryCtrl'
                })
                // 结案任务查询
                .state('UIAgriEndcaseQuery', {
                    url: '/UIAgriEndcaseQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/endcase/UIAgriEndcase.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/endcase/UIAgriEndcase.Query.tpl.html',
                    controller: 'UIAgriEndcaseQueryCtrl'
                })
                // 结案任务查看
                .state('UIAgriEndcaseSee', {
                    url: '/UIAgriEndcaseSee/:endcaseSee',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/endcase/UIAgriEndcase.See.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/endcase/UIAgriEndcase.See.tpl.html',
                    controller: 'UIAgriEndcaseSeeCtrl'
                })
                //理算任务--修改--查看
                .state('UIAgriCompenstate', {
                    url: '/UIAgriCompenstate?editType?compensateNo?riskType?claimNo?flowId?logNo?checkFlag?authSystemFlag?businessNo?registNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/compenstate/UIAgriCompenstate.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/compenstate/UIAgriCompenstate.tpl.html',
                    controller: 'UIAgriCompenstateCtrl'
                })
                //理算任务-申请注销/拒赔页面
                // .state('UIAgriCompenstateClaimCancle', {
                //     url: '/UIAgriCompenstateClaimCancle?state',
                //     resolve: {
                //         dummy: $couchPotatoProvider.resolveDependencies([
                //             'common/business/compenstate/UIAgriCompenstate.ClaimCancle.ctrl'
                //         ])
                //     },
                //     templateUrl: 'common/business/compenstate/UIAgriCompenstate.ClaimCancle.tpl.html',
                //     controller: 'UIAgriCompenstateClaimCancleCtrl'
                // })
                //理算任务-缮制理赔清单页面
                .state('UIAgriCompenstateSettleList', {
                    url: '/UIAgriCompenstateSettleList?state',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/compenstate/UIAgriCompenstate.SettleList.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/compenstate/UIAgriCompenstate.SettleList.tpl.html',
                    controller: 'UIAgriCompenstateSettleListCtrl'
                })

                //重开赔案任务查询
                .state('UIAgriRecase', {
                    url: '/UIAgriRecase',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/recase/UIAgriRecase.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/recase/UIAgriRecase.tpl.html',
                    controller: 'UIAgriRecaseCtrl'
                })
                //重开赔案-新增
                .state('UIAgriRecaseAdd', {
                    url: '/UIAgriRecaseAdd?claimNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/recase/UIAgriRecase.Add.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/recase/UIAgriRecase.Add.tpl.html',
                    controller: 'UIAgriRecaseAddCtrl'
                })
                //重开赔案-查看
                .state('UIAgriRecaseSee', {
                    url: '/UIAgriRecaseSee?claimNo',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/recase/UIAgriRecase.See.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/recase/UIAgriRecase.See.tpl.html',
                    controller: 'UIAgriRecaseSeeCtrl'
                })
                //重开赔案-审核意见
                .state('UIAgriRecaseAuditoption', {
                    url: '/UIAgriRecaseAuditoption',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/recase/UIAgriRecase.Auditoption.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/recase/UIAgriRecase.Auditoption.tpl.html',
                    controller: 'UIAgriRecaseAuditoptionCtrl'
                })
                //重开赔案-重新审核
                .state('UIAgriRecaseReaudit', {
                    url: '/UIAgriRecaseReaudit',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/recase/UIAgriRecase.Reaudit.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/recase/UIAgriRecase.Reaudit.tpl.html',
                    controller: 'UIAgriRecaseReauditCtrl'
                })
                // 流程查询
                .state('UIAgriFlowQuery', {
                    url: '/UIAgriFlowQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/flow/UIAgriFlow.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/flow/UIAgriFlow.Query.tpl.html',
                    controller: 'UIAgriFlowQueryCtrl'
                })
                // 流程查询-查看
                .state('UIAgriFlowSee', {
                    url: '/UIAgriFlowSee?registNo?authSystemFlag',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/flow/UIAgriFlow.See.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/flow/UIAgriFlow.See.tpl.html',
                    controller: 'UIAgriFlowSeeCtrl'
                })
                //理赔打印
                .state('UIAgriPrintQuery', {
                    url: '/UIAgriPrintQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/print/UIAgriPrint.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/print/UIAgriPrint.Query.tpl.html',
                    controller: 'UIAgriPrintQueryCtrl'
                })
                //支付信息管理查询
                .state('UIAgriPaymentQuery', {
                    url: '/UIAgriPaymentQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPayment.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPayment.Query.tpl.html',
                    controller: 'UIAgriPaymentQueryCtrl'
                })
                //支付信息录入查询
                .state('UIAgriPaymentQueryInput', {
                    url: '/UIAgriPaymentQueryInput',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPaymentInput.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPaymentInput.Query.tpl.html',
                    controller: 'UIAgriPaymentQueryInputCtrl'
                })
                //支付信息管理-整单支付
                .state('UIAgriPaymentFull', {
                    url: '/UIAgriPaymentFull?editType?paymentNo?registDtoList',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPayment.Full.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPayment.Full.tpl.html',
                    controller: 'UIAgriPaymentFullCtrl'
                })
                //支付信息管理-清单支付
                .state('UIAgriPaymentBill', {
                    url: '/UIAgriPaymentBill?editType?registDtoList',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPayment.Bill.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPayment.Bill.tpl.html',
                    controller: 'UIAgriPaymentBillCtrl'
                })

                //支付管理-支付情况统计表页面
                .state('UIAgriPaymentStatisticsList', {
                    url: '/UIAgriPaymentStatisticsList',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPayment.StatisticsList.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPayment.StatisticsList.tpl.html',
                    controller: 'UIAgriPaymentStatisticsListCtrl'
                })
                //支付情况统计详细信息页面
                .state('UIAgriPaymentStatisticsDetailList', {
                    url: '/UIAgriPaymentStatisticsDetailList?compensateNo?payrefReason',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/payment/UIAgriPayment.StatisticsDetailList.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/payment/UIAgriPayment.StatisticsDetailList.tpl.html',
                    controller: 'UIAgriPaymentStatisticsDetailListCtrl'
                })
                //工作流管理页面
                .state('UIAgriWorkFlowQuery', {
                    url: '/UIAgriWorkFlowQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/workflow/UIAgriWorkFlow.Query.ctrl',
                            'common/business/workflow/model/UIAgriWorkFlow.Distribution.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/workflow/UIAgriWorkFlow.Query.tpl.html',
                            controller: 'UIAgriWorkFlowQueryCtrl'
                        },
                        "distribution@UIAgriWorkFlowQuery":{ // 工作流模板分配弹层
                            templateUrl: 'common/business/workflow/model/UIAgriWorkFlow.Distribution.model.html',
                            controller: 'UIAgriWorkFlowDistributionModelCtrl'
                        }
                    }
                })
                //工作流管理--新建页面
                .state('UIAgriWorkFlowNew', {
                    url: '/UIAgriWorkFlowNew?type?item',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/workflow/UIAgriWorkFlow.New.ctrl',
                            'common/business/workflow/model/UIAgriWorkFlow.TemplatePath.model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/workflow/UIAgriWorkFlow.New.tpl.html',
                            controller: 'UIAgriWorkFlowNewCtrl'
                        },
                        "templatePath@UIAgriWorkFlowNew":{ // 工作流模板路径编辑弹层
                            templateUrl: 'common/business/workflow/model/UIAgriWorkFlow.TemplatePath.model.html',
                            controller: 'UIAgriWorkFlowTemplatePathModelCtrl'
                        }
                    }
                })
                // 合并案件查询
                .state('UIAgriCombineBeforeQuery', {
                    url: '/UIAgriCombineBeforeQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/combine/UIAgriCombine.BeforeQuery.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/combine/UIAgriCombine.BeforeQuery.tpl.html',
                    controller: 'UIAgriCombineBeforeQueryCtrl'
                })
                // 并案查勘定损查询
                .state('UIAgriCombineCheckQuery', {
                    url: '/UIAgriCombineCheckQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/combine/UIAgriCombine.CheckQuery.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/combine/UIAgriCombine.CheckQuery.tpl.html',
                    controller: 'UIAgriCombineCheckQueryCtrl'
                })
                // 并案查勘定损编辑页面
                .state('UIAgriCombineCheck', {
                    url: '/UIAgriCombineCheck/:CombineCheck',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/combine/UIAgriCombineCheck.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/combine/UIAgriCombineCheck.tpl.html',
                    controller: 'UIAgriCombineCheckCtrl'
                })
                // 并案管理-立案任务处理查询页面
                .state('UIAgriCombineTaskHandleQuery', {
                    url: '/UIAgriCombineTaskHandleQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/combine/UIAgriCombine.TaskHandle.Query.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/combine/UIAgriCombine.TaskHandle.Query.tpl.html',
                    controller: 'UIAgriCombineTaskHandleQueryCtrl'
                })
                // 并案管理-立案任务处理页面
                .state('UIAgriCombineTaskHandle', {
                    url: '/UIAgriCombineTaskHandle/:TaskHandle',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/combine/UIAgriCombine.TaskHandle.ctrl',
                            //'common/business/combine/model/UIAgriCombine.Communication.Model.ctrl',
                            //'common/business/combine/model/UIAgriCombine.EleDocument.Model.ctrl'
                        ])
                    },
                    views:{
                        main:{
                            templateUrl: 'common/business/combine/UIAgriCombine.TaskHandle.tpl.html',
                            controller: 'UIAgriCombineTaskHandleCtrl'
                        }
                       /* "communication@UIAgriCombineTaskHandle":{ // 理赔沟通弹层
                            templateUrl: 'common/business/combine/model/UIAgriCombine.Communication.model.html',
                            controller: 'UIAgriCombineCommunicationModelCtrl'
                        },
                        "eleDocument@UIAgriCombineTaskHandle":{ // 电子单证弹层
                            templateUrl: 'common/business/combine/model/UIAgriCombine.EleDocument.model.html',
                            controller: 'UIAgriCombineEleDocumentModelCtrl'
                        }*/
                    }
                })
                //清单导入
                .state('UIAgriInventoryUpload',{
                    url:'/UIAgriInventoryUpload',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/agriInventory/UIAgriInventoryUpload.ctrl'])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/agriInventory/UIAgriInventoryUpload.tpl.html',
                            controller: 'UIAgriInventoryUpload'
                        }
                    }
                })

        }
    ])
        .run(function($rootScope, $state, $stateParams) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
            $rootScope.$on("$stateChangeSuccess",  function(event, toState, toParams, fromState, fromParams) {
                $rootScope.previousState_name = fromState.name;
                $rootScope.previousState_params = fromParams;
            });
            $rootScope.back = function() {//实现返回的函数直接调用$rootScope.back();
                $state.go($rootScope.previousState_name,$rootScope.previousState_params);
            };
        });
});