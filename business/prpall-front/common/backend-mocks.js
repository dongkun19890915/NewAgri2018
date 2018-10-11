/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'angular-mocks',
    'config',
    'codes',
    'jsonDB'
], function (ngMock, config, codes, jsonDB) {
    'use strict';
    angular.module('backend-mocks', ['ngMockE2E'])
        .run(function ($httpBackend) {
            console.log('模拟后台启动....');
            // 菜单
            //config.backend.menuData&&$httpBackend.whenPOST(config.backend.ip + config.backend.menuData).respond(function (method, url, data) {
            //    //var _data = JSON.parse(data);
            //    return [200, jsonDB['menuData']];
            //});
            // 普通批改初始化
            //config.backend.generalEndorseInit&&$httpBackend.whenPOST(config.backend.ip +config.backend.generalEndorseInit).respond(function (method, url, data) {
            //    return [200, jsonDB['generalEndorseInit']];
            //});
            // 普通批改查看初始化
            // config.backend.queryEndorseInfo&&$httpBackend.whenPOST(config.backend.ip +config.backend.queryEndorseInfo).respond(function (method, url, data) {
            //     return [200, jsonDB['queryEndorseInfo']];
            // });
            // 投保单录入
            config.backend.proposal&&$httpBackend.whenPOST(config.backend.proposal).respond(function (method, url, data) {
                //var _data = JSON.parse(data);
                return [200, jsonDB['mainHead']];
            });
            //合同信息
            config.backend.mainAgri&&$httpBackend.whenPOST(config.backend.mainAgri).respond(function (method, url, data) {
                return [200, jsonDB['mainAgri']];
            });
            //其他信息
            config.backend.penses&&$httpBackend.whenPOST(config.backend.penses).respond(function (method, url, data) {
                return [200, jsonDB['penses']];
            });
            //投保单查询
            config.backend.proposalState&&$httpBackend.whenPOST(config.backend.proposalState).respond(function (method, url, data) {
                return [200, jsonDB['proposalState']];
            });
            //影像资料查询
            config.backend.uploadfile&&$httpBackend.whenPOST(config.backend.uploadfile).respond(function (method, url, data) {
                return [200, jsonDB['uploadfile']];
            });
            //短信发送查询
            config.backend.sendmessagequery&&$httpBackend.whenPOST(config.backend.sendmessagequery).respond(function (method, url, data) {
                return [200, jsonDB['sendmessagequery']];
            });
            //条款版本管理
            //config.backend.clausemanage&&$httpBackend.whenPOST(config.backend.clausemanage).respond(function (method, url, data) {
            //    return [200, jsonDB['clausemanage']];
            //});
            //支付信息管理
            config.backend.paymanage&&$httpBackend.whenPOST(config.backend.paymanage).respond(function (method, url, data) {
                return [200, jsonDB['paymanage']];
            });
            ////客户设置
            //config.backend.customer&&$httpBackend.whenPOST(config.backend.customer).respond(function (method, url, data) {
            //    return [200, jsonDB['customer']];
            //});
            //保单查询
            config.backend.guarantee&&$httpBackend.whenPOST(config.backend.guarantee).respond(function (method, url,data) {
                return [200, jsonDB['guarantee']];
            });
            //批单查询
            config.backend.endorse&&$httpBackend.whenPOST(config.backend.endorse).respond(function (method, url, data) {
                return [200, jsonDB['endorse']];
            });
            //批单查询
            config.backend.endorseProposal&&$httpBackend.whenPOST(config.backend.endorseProposal).respond(function (method, url, data) {
                return [200, jsonDB['endorseProposal']];
            });
            config.backend.customerInfo&&$httpBackend.whenPOST(config.backend.customerInfo).respond(function (method, url, data) {
                return [200, jsonDB['customerInfo']];
            });
            //修改方案
            config.backend.riskScheme&&$httpBackend.whenPOST(config.backend.riskScheme).respond(function (method, url, data) {
                return [200, jsonDB['riskScheme']];
            });
            //特殊批改待批改的查询列表
            config.backend.selectedGuaranteeDetails&&$httpBackend.whenPOST(config.backend.selectedGuaranteeDetails).respond(function (method, url, data) {
                return [200, jsonDB['selectedGuaranteeDetails']];
            });
            //全单退保
            config.backend.fullSurrender&&$httpBackend.whenPOST(config.backend.fullSurrender).respond(function (method, url, data) {
                return [200, jsonDB['fullSurrender']];
            });
            //保单注销
            config.backend.CancellationPolicy&&$httpBackend.whenPOST(config.backend.CancellationPolicy).respond(function (method, url, data) {
                return [200, jsonDB['CancellationPolicy']];
            });
            //恐怖分子查询
            config.backend.checkTerrorist&&$httpBackend.whenPOST(config.backend.checkTerrorist).respond(function (method, url,data) {
                return [200, jsonDB['checkTerrorist']];
            });

            config.backend.BusinessCategory&&$httpBackend.whenPOST(config.backend.BusinessCategory).respond(function (method, url,data) {
                return [200, jsonDB['BusinessCategory']];
            });
            //检查单证号码是否可用
            // config.backend.BusinessCategory&&$httpBackend.whenPOST(config.backend.checkVisaCodeValid).respond(function (method, url,data) {
            //     return [200, jsonDB['checkVisaCodeValid']];
            // });
			//投保模版管理
            //config.backend.proposalManagement&&$httpBackend.whenPOST(config.backend.proposalManagement).respond(function (method, url, data) {
             //   return [200, jsonDB['proposalManagement']];
            //});
            //业务清单查询
            // config.backend.prpbusinoesslist&&$httpBackend.whenPOST(config.backend.prpbusinoesslist).respond(function (method, url, data) {
            //     return [200, jsonDB['prpbusinoesslist']];
            // });
            //特殊批改页面初始化
            // config.backend.endorseinit&&$httpBackend.whenPOST(config.backend.endorseinit).respond(function (method, url, data) {
            //     return [200, jsonDB['endorseinit']];
            // });
            // //批单列表查询
            // config.backend.querySpecial&&$httpBackend.whenPOST(config.backend.querySpecial).respond(function (method, url, data) {
            //     return [200, jsonDB['querySpecial']];
            // });
            // //特殊批改生成批文
            // config.backend.endorseapproval&&$httpBackend.whenPOST(config.backend.endorseapproval).respond(function (method, url, data) {
            //     return [200, jsonDB['endorseapproval']];
            // });
            // // 特批批文保存
            // config.backend.endorsesave&&$httpBackend.whenPOST(config.backend.endorsesave).respond(function (method, url, data) {
            //     return [200, jsonDB['endorsesave']];
            // });
            // // 提交核批
            // config.backend.saveUndwrtByEndorseNo&&$httpBackend.whenPOST(config.backend.saveUndwrtByEndorseNo).respond(function (method, url, data) {
            //     return [200, jsonDB['saveUndwrtByEndorseNo']];
            // });

/***********************************/
            // config.backend.queryEndorsListInfo&&$httpBackend.whenPOST(config.backend.queryEndorsListInfo).respond(function (method, url,data) {
            //     return [200, jsonDB['queryEndorsListInfo']];
            // });
/***********************************/


            $httpBackend.whenGET(/.*/).passThrough();
            $httpBackend.whenPOST(/.*/).passThrough();

        })

});