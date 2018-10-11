/**
 * Created by ZhangJiansen on 2017/3/9.
 */
define(['../module'], function (moduleApp) {
    'use strict';

    var productConfigService = function($http,$q,ApiPath){

        var template = {
            moduleTitleHead:'<div class="index_tit"><h6>',
            moduleTitleTail:'</h6></div>'
        };

        return{
            getProductConfig:function(cond){
                var url= ApiPath.api.getProductConfig;
                //moduleApp.basePath+"/controller/riskModule.json";
                var deferred = $q.defer();
                var promise = $http({
                    method: 'GET',
                    url: url,
                    params: cond
                });
                promise.then(
                    function(resp){
                        deferred.resolve(resp.data);
                    },function(error){
                        error.status = false;
                        deferred.reject(error);
                    }
                );
                return deferred.promise;
            },
            getModuleDetail:function(moduleID){
                return "";
            },
            generateDynamicDom:function(metaData){
                var insuredDom =
                    //'<div class="index_tit"><h6>业务相关信息</h6></div>'+
                    '<ul class="list_ul">'+
                    '    <li><em>*</em><span>业务来源：</span></li>'+
                    '    <li>'+
                    '        <div class="ui-select">'+
                    '            <code-type base-code="BusinessNature" class="seletc_bor" is-fuzzy="false" ng-model="vm.policy.prpTmain.businessNature"  ng-disabled="false" required warn-text="" ></code-type>'+
                    '        </div>'+
                    '    </li>'+
                    '    <li><em ng-if="companyRequired">*</em><span>出单省级机构：</span></li>'+
                    '    <li>'+
                    '        <div class="ui-select">'+
                    '            <code-type base-code="Company" class="seletc_bor" is-fuzzy="true" ng-model="vm.policy.prpTmain.comCode" ng-disabled="false" ng-required="companyRequired" warn-text=""></code-type>'+
                    '        </div>'+
                    '    </li>'+
                    '    <li><em>*</em><span>出单分支机构代码：</span></li>'+
                    '    <li>'+
                    '        <input type="text" class="fl" ng-model="vm.policy.prpTmain.cityCode" mc-placeholder="影响业务清分，请正确填写" required ng-maxlength="20" maxlength="20" ng-pattern="/^[A-Za-z0-9]*$/" warn-text="{\'NonEmpty\':\'出单分支机构不能为空\',\'ErrPattern\':\'出单分支机构只能输入字母和数字\'}"/>'+
                    '    </li>'+
                    '    <li><span>业务归属机构代码：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.makeCom" ng-maxlength="20" maxlength="20" ng-pattern="/^[A-Za-z0-9]*$/" warn-text="{\'ErrPattern\':\'业务归属机构代码只能输入字母和数字\'}"/></li>'+
                    '    <li><span>渠道代码：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.handlerCode" ng-maxlength="30" maxlength="30" ng-pattern="/^[A-Za-z0-9]*$/" /></li>'+
                    '    <li><span>渠道名称：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.handlerName" maxlength="25"/></li>'+
                    '    <li><span>协议代码：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.contractNo" ng-maxlength="22" maxlength="22" ng-pattern="/^[A-Za-z0-9_-]*$/"/></li>'+
                    '    <li></li>'+
                    '    <li></li>'+
                    '    <li><em>*</em><span>归属业务员代码：</span></li>'+
                    '    <li>'+
                    '        <input type="text" class="fl" ng-model="vm.policy.prpTmain.handler1Code" ng-maxlength="20" maxlength="20" ng-pattern="/^[A-Za-z0-9]*$/" required/>'+
                    '    </li>'+
                    '    <li><em>*</em> <span>归属业务员姓名：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.handler1Name" ng-maxlength="25" maxlength="25" warn-text="归属业务员姓名" required/></li>'+
                    '    <li><em>*</em><span>录单人员代码：</span></li>'+
                    '    <li><input type="text" required class="fl" ng-model="vm.policy.prpTmain.operatorCode" ng-maxlength="20" maxlength="20" ng-pattern="/^[A-Za-z0-9]*$/" /></li>'+
                    '    <li><em>*</em><span>录单人员姓名：</span></li>'+
                    '    <li><input type="text" class="fl" ng-model="vm.policy.prpTmain.operatorName" ng-maxlength="25" maxlength="25" required warn-text=""/></li>'+
                    '    <li class="hide"><input type="text" ng-model="vm.policy.prpTmain.companyCode" /></li>'+
                    '</ul>';
                return insuredDom;
            }
        };
    };

    moduleApp.service('productConfigServ',['$http','$q','ApiPath',productConfigService]);
});