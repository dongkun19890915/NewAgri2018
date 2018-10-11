/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'codes'
], function (app, codes) {
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
            $urlRouterProvider
                .when('', '/');

            $urlRouterProvider.otherwise('/dashboard');
            /*login*/
            /*dashboard*/

            $stateProvider
                //登录
                .state('login', {
                    url: '/login',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/frame/login/login.ctrl'])
                    },
                    views: {
                        'login': {
                            templateUrl: 'common/frame/login/login.tpl.html',
                            controller: 'loginCtrl'
                        }
                    }
                })
                //首页
                .state('dashboard', {
                    url: '/dashboard',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/frame/dashboard/dashboard.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/frame/dashboard/dashboard.tpl.html',
                            controller: 'dashboardCtrl'
                        }
                    }
                })
                //公共信息提示页面
                .state('message', {
                    url: '/message?message&authSystemFlag',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/frame/message/message.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/frame/message/message.tpl.html',
                            controller: 'message'
                        }
                    }
                })
                //投保单查询
                .state('UIPrPoEnQuery', {
                    url: '/UIPrPoEnQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/query/UIPrPoEn.query.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/query/UIPrPoEn.query.tpl.html',
                            controller: 'UIPrPoEnQueryCtrl'
                        }
                    }
                })
                //批单查询
                .state('UIPrPoEnOrderQuery', {
                    url: '/UIPrPoEnOrderQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/query/UIPrPoEn.orderQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/query/UIPrPoEn.orderQuery.tpl.html',
                            controller: 'UIPrPoEnOrderQueryCtrl'
                        }
                    }
                })
                //保单管理查询
                .state('UIPrPoEnGuaranteeQuery', {
                    url: '/UIPrPoEnGuaranteeQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/guaranteeManagement/UIPrPoEn.guaranteeQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/guaranteeManagement/UIPrPoEn.guaranteeQuery.tpl.html',
                            controller: 'UIPrPoEnGuaranteeQueryCtrl'
                        }
                    }
                })
                //投保单打印
                .state('UIPrPoEnInsuranceQuery', {
                    url: '/UIPrPoEnInsuranceQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/documentPrinting/UIPrPoEn.insuranceQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/documentPrinting/UIPrPoEn.insuranceQuery.tpl.html',
                            controller: 'UIPrPoEnInsuranceQueryCtrl'
                        }
                    }
                })

                //保单打印
                .state('UIPrPoEnPolicyQuery', {
                    url: '/UIPrPoEnPolicyQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/documentPrinting/UIPrPoEn.policyQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/documentPrinting/UIPrPoEn.policyQuery.tpl.html',
                            controller: 'UIPrPoEnPolicyQueryCtrl'
                        }
                    }
                })
                //批单打印
                .state('UIPrPoEnEndorsementQuery', {
                    url: '/UIPrPoEnEndorsementQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/documentPrinting/UIPrPoEn.endorsementQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/documentPrinting/UIPrPoEn.endorsementQuery.tpl.html',
                            controller: 'UIPrPoEnEndorsementQueryCtrl'
                        }
                    }
                })
                //打印凭证
                .state('UIPrPoEnVoucherQuery', {
                    url: '/UIPrPoEnVoucherQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/documentPrinting/UIPrPoEn.voucherQuery.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/documentPrinting/UIPrPoEn.voucherQuery.tpl.html',
                            controller: 'UIPrPoEnVoucherQueryCtrl'
                        }
                    }
                })
                //普通批改查询
                .state('UIEndorseGeneralMarking', {
                    url: '/UIEndorseGeneralMarking',
                    views: {
                        'main': {
                            template: '<div ui-view></div>',
                        }
                    }
                })
                .state('UIEndorseGeneralMarking.main', {
                    url: '/main',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/endorse/generalMarking/UIEndorse.generalMarking.ctrl',
                        ])
                    },
                    templateUrl: 'common/business/common/endorse/generalMarking/UIEndorse.generalMarking.tpl.html',
                    controller: 'UIEndorseGeneralMarkingCtrl'
                })
                .state('UIEndorseGeneralMarking.ModifyDetails', {
                    url: '/ModifyDetails',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/endorse/ModifyDetails/UIEndorse.ModifyDetails.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/common/endorse/ModifyDetails/UIEndorse.ModifyDetails.tpl.html',
                    controller: 'UIEndorseModifyDetailsCtrl'
                })
                .state('UIEndorseGeneralMarking.GenerateApproval', {
                    url: '/GenerateApproval',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/endorse/GenerateApproval/UIEndorse.generateApproval.ctrl'
                        ])
                    },
                    templateUrl: 'common/business/common/endorse/GenerateApproval/UIEndorse.generateApproval.tpl.html',
                    controller: 'UIEndorseCancellationPolicyCtrl'
                })
                //批改入口
                .state('UIEndorseSpecial', {
                    url: '/UIEndorseSpecial',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/specialEndorse/UIEndorse.special.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/endorse/specialEndorse/UIEndorse.special.tpl.html',
                            controller: 'UIEndorseSpecialCtrl'
                        }
                    }
                })
                //特殊批改变更保险期限
                .state('UIEndorseAgriculturalUpdate', {
                    url: '/UIEndorseAgriculturalUpdate/:endorse',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/specialExamine/UIEndorse.AgriculturalUpdate.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorseAgriculturalUpdateCtrl'
                        }
                    }
                })
                //特殊批改之注销批改
                .state('UIEndorseLogoutUpdate', {
                    url: '/UIEndorseLogoutUpdate',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/logoutExamine/UIEndorse.Logout.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/endorse/logoutExamine/UIEndorse.Logout.tpl.html',
                            controller: 'UIEndorseLogoutUpdateCtrl'
                        }
                    }
                })
                //全单退保
                .state('UIEndorseFullSurrender', {
                    url: '/UIEndorseFullSurrender/:endorse',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.tpl.html',
                            controller: 'cancellationAndFullSurrendPolicyCtrl'
                        }

                    }
                })
                //保单注销
                .state('UIEndorseCancellationPolicy', {
                    url: '/UIEndorseCancellationPolicy/:endorse',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.tpl.html',
                            controller: 'cancellationAndFullSurrendPolicyCtrl'
                        }

                    }
                })
                //业务员批改
                .state('UIEndorsehandler1Code', {
                    url: '/UIEndorsehandler1Code',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/handler1Code/UIEndorse.handler1Code.ctrl'])
                    },
                    views: {
                        "main": {

                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorsehandler1CodeCtrl'
                        }
                    }
                })
                //见费出单保单注销
                .state('UIEndorseeExpenseCancelPolicy', {
                    url: '/UIEndorseeExpenseCancelPolicy:endorse',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/cancellationAndFullSurrendPolicy/UIEndorse.cancellationAndFullSurrendPolicy.tpl.html',
                            controller: 'cancellationAndFullSurrendPolicyCtrl'
                        }
                    }
                })
                //业务来源批改
                .state('UIEndorseBusinesSourcesModified', {
                    url: '/UIEndorseBusinesSourcesModified/:endorse',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/specialExamine/UIEndorse.AgriculturalUpdate.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorseAgriculturalUpdateCtrl'
                        }
                    }
                })
                //调整费率
                .state('UIEndorseAdjustRate', {
                    url: '/UIEndorseAdjustRate',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/AdjustRate/UIEndorse.adjustRate.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorseAdjustRateCtrl'
                        }
                    }
                })
                //调整补贴信息
                .state('UIEndorseAdjustSubsidy', {
                    url: '/UIEndorseAdjustSubsidy',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/AdjustSubsidy/UIEndorse.adjustSubsidy.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorseAdjustSubsidyCtrl'
                        }
                    }
                })
                //影像资料上传
                .state('UIPrPoEnUploadFile', {
                    url: '/UIPrPoEnUploadFile',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/UploadFile/UIPrPoEn.uploadfile.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/UploadFile/UIPrPoEn.uploadfile.tpl.html',
                            controller: 'UIPrPoEnUploadfileCtrl'
                        }
                    }
                })
                //凭证短信发送--短信发送查询
                .state('UIPrPoEnSendMessageQuery', {
                    url: '/UIPrPoEnSendMessageQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/SendMessage/UIPrPoEn.sendMessageQuery.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/SendMessage/UIPrPoEn.sendMessageQuery.tpl.html',
                            controller: 'UIPrPoEnSendMessageQueryCtrl'
                        }
                    }
                })
                //条款版本管理
                .state('UIPrPoEnClauseManage', {
                    url: '/UIPrPoEnClauseManage',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/ClauseManage/UIPrPoEn.clauseManage.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/ClauseManage/UIPrPoEn.clauseManage.tpl.html',
                            controller: 'UIPrPoEnClauseManageCtrl'
                        }
                    }
                })
                //支付信息管理
                .state('UIPrPoEnPayManage', {
                    url: '/UIPrPoEnPayManage',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payManage.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payManage.tpl.html',
                            controller: 'UIPrPoEnPayManageCtrl'
                        }
                    }
                })
                //支付信息录入UIPrPoEnPayManageQueryCtrl
                .state('UIPrPoEnPayManageEnter', {
                    url: '/UIPrPoEnPayManageEnter',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payManageEnter.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payManageEnter.tpl.html',
                            controller: 'UIPrPoEnPayManageEnterCtrl'
                        }
                    }
                })
                //支付信息维护UIPrPoEnPayManageMaintCtrl
                .state('UIPrPoEnPayManageMaint', {
                    url: '/UIPrPoEnPayManageMaint',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payManageMaint.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payManageMaint.tpl.html',
                            controller: 'UIPrPoEnPayManageMaintCtrl'
                        }
                    }
                })
                //支付信息查询UIPrPoEnPayManageQueryCtrl
                .state('UIPrPoEnPayManageQuery', {
                    url: '/UIPrPoEnPayManageQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payManageQuery.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payManageQuery.tpl.html',
                            controller: 'UIPrPoEnPayManageQueryCtrl'
                        }
                    }
                })
                //清单支付 UIPrPoEnPayDetailCtrl
                .state('UIPrPoEnPayDetail', {
                    url: '/UIPrPoEnPayDetail?endorseNo?policyNo?costType?viewType',
                    params: {
                        "endorseNo": null,
                        "policyNo": null,
                        "costType": null,
                        "viewType": null,
                        "endorseInfo": null,
                        "endorse": null
                    },
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payDetail.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payDetail.tpl.html',
                            controller: 'UIPrPoEnPayDetailCtrl'
                        }
                    }
                })
                //整单支付
                .state('UIPrPoEnPayWhole', {
                    url: '/UIPrPoEnPayWhole?endorseNo?costType?viewType?endorseNo_show?policyNo?insuredName?costTypeName?chgPremium',
                    params: {
                        "endorseNo": null,
                        "costType": null,
                        "viewType": null,
                        "endorseNo_show": null,
                        "policyNo": null,
                        "insuredName": null,
                        "costTypeName": null,
                        "chgPremium": null,
                        "endorseInfo": null
                    },
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/PayManage/UIPrPoEn.payWhole.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/PayManage/UIPrPoEn.payWhole.tpl.html',
                            controller: 'UIPrPoEnPayWholeCtrl'
                        }
                    }
                })
                //客户设置
                .state('UIPrPoEnCustomer', {
                    url: '/UIPrPoEnCustomer',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/Customer/UIPrPoEn.customer.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/Customer/UIPrPoEn.customer.tpl.html',
                            controller: 'UIPrPoEnCustomerCtrl'
                        }
                    }
                })
                //调整单位保额
                .state('UIEndorseAdjustUnitInsured', {
                    url: '/UIEndorseAdjustUnitInsured',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/AdjustUnitInsured/UIEndorse.adjustUnitInsured.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/model/UIEndorse.model.tpl.html',
                            controller: 'UIEndorseAdjustUnitInsuredCtrl'
                        }
                    }
                })
                //3107小麦种植险 投保单录入/修改
                .state('UIproposal3107edit', {
                    url: '/UIproposal3107edit?GisInsureListCode?proposalNo?addEditExamine?authSystemFlag',
                    //params:{data:null},
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                            'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                            'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                            'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                            'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl',
                            'common/business/risk/proposal/UIProposal.3107edit.ctrl'])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/risk/proposal/UIProposal.3107edit.html',
                            controller: 'UIProposal3107editCtrl'
                        },
                        //险种方案
                        'UIPrPoEnRiskScheme@UIproposal3107edit': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIproposal3107edit': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIproposal3107edit': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIproposal3107edit': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIproposal3107edit': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                // 普通批改
                .state('UIEndorse3107edit', {
                    url: '/UIEndorse3107edit?editType?bizNo?validDate?policyNo?bizType?applyDate?endorseType?endorseMessage?appliName?authSystemFlag',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                            'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                            'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                            'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                            'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl',
                            'common/business/risk/endorse/UIEndorse.3107edit.ctrl'])
                        // init: ['$$code', function ($$code) {
                        //     $$code.getCodes('codeType', 'EditType', {}).then(function (data) {
                        //         codes.prpDcodeListDtoList = data
                        //     })
                        // }]
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/risk/endorse/UIEndorse.3107edit.html',
                            controller: 'UIEndorse3107editCtrl'
                        },
                        //险种方案
                        'UIPrPoEnRiskScheme@UIEndorse3107edit': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIEndorse3107edit': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIEndorse3107edit': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIEndorse3107edit': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIEndorse3107edit': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                //投保单查询结果的详细信息、保单查询结果的详细信息
                .state('UIproposal3107show', {
                    url: '/UIproposal3107show',
                    params:{data:null},
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/risk/proposal/UIProposal.3107show.ctrl',
                            'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                            'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                            'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                            'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                            'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl'
                        ])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/risk/proposal/UIProposal.3107show.html',
                            controller: 'UIProposal3107showCtrl'
                        },
                        //险种方案
                        'UIPrPoEnRiskScheme@UIproposal3107show': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            //controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIproposal3107show': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIproposal3107show': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIproposal3107show': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIproposal3107show': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                //凭证短信发送
                .state('UIEndorseSendIng', {
                    url: '/UIEndorseSendIng',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/SendIng/UIEndorse.sendIng.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/SendIng/UIEndorse.sendIng.tpl.html',
                            controller: 'UIEndorseSendIngCtrl'
                        }
                    }
               })
                //短信模版管理
                .state('UIEndorseTemplate', {
                    url: '/UIEndorseTemplate',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/Template/UIEndorse.template.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/Template/UIEndorse.template.tpl.html',
                            controller: 'UIEndorseTemplateCtrl'
                        }
                    }
                })
                //投保单模版新建详情页面
                .state('UIproposaledit', {
                    url: '/UIproposaledit',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/proposal/proManagement/UIProposal.managementEdit.ctrl',
                            'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl',
                            'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                            'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                            'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                            'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                        ])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/proManagement/UIProposal.managementEdit.tpl.html',
                            controller: 'UIproposaleditCtrl'
                        },
                        //险种方案
                        'UIPrPoEnRiskScheme@UIproposaledit': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIproposaledit': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIproposaledit': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIproposaledit': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIproposaledit': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                .state('UIProposalManagement', {
                    url: '/UIProposalManagement',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/proManagement/UIProposal.management.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/proposal/proManagement/UIProposal.management.tpl.html',
                            controller: 'UIProposalManagement'
                        }
                    }
                })
                //投保单模版信息详情查看
                .state('UIproposalshow', {
                    url: '/UIproposalshow?modelCode?userCode?comCode?flag?mm?copyModel',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'common/business/common/proposal/proManagement/UIProposal.managementShow.ctrl',
                            'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                            'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                            'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                            'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                            //'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl'
                            'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl',
                        ])
                    },
                    views: {
                        'main': {
                            templateUrl: 'common/business/common/proposal/proManagement/UIProposal.managementShow.tpl.html',
                            controller: 'UIProposalshowCtrl'
                        },
                        //险种方案
                        'UIPrPoEnAdminrisk@UIproposalshow': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIproposalshow': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIproposalshow': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIproposalshow': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIproposalshow': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                //业务清单查询
                .state('UIPrPoEnBusinessQuery', {
                    url: '/UIPrPoEnBusinessQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/endorse/BusinessQuery/UIPrPoEn.businessQuery.ctrl'])
                    },
                    views: {
                        "main": {
                            templateUrl: 'common/business/common/endorse/BusinessQuery/UIPrPoEn.businessQuery.tpl.html',
                            controller: 'UIPrPoEnBusinessQuery'
                        }
                    }
                })
                //清单导入
                .state('UIPrPoEnAgriInventoryUpload',{
                    url:'/UIPrPoEnAgriInventoryUpload',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/agriInventory/UIPrPoEn.agriInventoryUpload.ctrl'])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/common/proposal/agriInventory/UIPrPoEn.agriInventoryUpload.tpl.html',
                            controller: 'UIPrPoEnAgriInventoryUpload'
                        }
                    }
                })
                //清单查询
                .state('gisListQuery',{
                    url:'/UIPrPoEnAgriInventoryQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/agriInventory/UIPrPoEn.agriInventoryQuery.ctrl'])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/common/proposal/agriInventory/UIPrPoEn.agriInventoryQuery.tpl.html',
                            controller: 'UIPrPoEnAgriInventoryQuery'
                        }
                    }
                })
                //流程查询
                .state('UIProcessQuery',{
                    url:'/UIProcessQuery',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/process/UIPrPoEn.processQuery.ctrl.js'])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/common/proposal/process/UIPrPoEn.processQuery.tpl.html',
                            controller: 'UIProcessQuery'
                        }
                    }
                })
                .state('UIPolicy3107show',{
                    url:'/UIPolicy3107show?policyNo?authSystemFlag?norepeat',
                    resolve:{
                    dummy: $couchPotatoProvider.resolveDependencies([
                        'common/business/risk/policy/UIPolicy.3107show.ctrl.js',
                        'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.ctrl',
                        'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.ctrl',
                        'common/business/common/proposal/other/UIPrPoEn.other.ctrl',
                        'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.ctrl',
                        'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.ctrl'
                    ])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/risk/proposal/UIProposal.3107edit.html',
                            controller: 'UIPolicy3107show'
                        },
                        //险种方案
                        'UIPrPoEnRiskScheme@UIPolicy3107show': {
                            templateUrl: 'common/business/common/proposal/riskScheme/UIPrPoEn.riskScheme.tpl.html',
                            controller: 'UIPrPoEnRiskSchemeCtrl'
                        },
                        //基本方案
                        'UIPrPoEnMainHead@UIPolicy3107show': {
                            templateUrl: 'common/business/common/proposal/mainHead/UIPrPoEn.mainHead.tpl.html',
                            controller: 'UIPrPoEnMainHeadCtrl'
                        },
                        //合同方案
                        'UIPrPoEnMainAgri@UIPolicy3107show': {
                            templateUrl: 'common/business/common/proposal/mainAgri/UIPrPoEn.mainAgri.tpl.html',
                            controller: 'UIPrPoEnMainAgriCtrl'
                        },
                        //客户信息
                        'UIPrPoEnAgriInsured@UIPolicy3107show': {
                            templateUrl: 'common/business/common/proposal/agriInsured/UIPrPoEn.agriInsured.tpl.html',
                            controller: 'UIPrPoEnAgriInsuredCtrl'
                        },
                        //其他信息
                        'UIPrPoEnOther@UIPolicy3107show': {
                            templateUrl: 'common/business/common/proposal/other/UIPrPoEn.other.tpl.html',
                            controller: 'UIPrPoEnOtherCtrl'
                        }
                    }
                })
                //清单补全
                .state('UIPrPoEnCompleteList',{
                    url:'/UIPrPoEnCompleteList',
                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies(['common/business/common/proposal/completeList/UIPrPoEn.completeList.ctrl.js'])
                    },
                    views:{
                        "main": {
                            templateUrl: 'common/business/common/proposal/completeList/UIPrPoEn.completeList.tpl.html',
                            controller: 'UIPrEnCompleteListCtrl'
                        }
                    }
                })
        }
    ]);
});