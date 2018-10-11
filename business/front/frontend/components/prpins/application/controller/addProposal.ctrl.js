/**
 * Created by ZhangJiansen on 2017/3/8.
 * Controller层只处理视图数据绑定，后端交互在service处理
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var addProposalCtrl = function($q,$rootScope,$scope,$modal,$stateParams,$state,FormFocus,$controller,productConfigServ)
    {
        $scope.disStyle = $stateParams.disStyle;

        var riskCode = $stateParams.riskCode;
        console.info("初始化[%s]产品录单页面",riskCode);
        var vm=$scope.vm={};
        vm.policy={};

        //获取模板url及模板数据
        $scope.getTemplate=function() {
            var promise = productConfigServ.getProductConfig({});
            promise.then(
                function (data) {
                    var cfgInfo = data;
                    angular.forEach(cfgInfo,function(m){
                        console.info("resolve %s module,name is", m.index,m.name);
                        if(m.type == 'F'){
                            m.url = moduleApp.basePath+"/tpl/"+ m.url;
                        }else if(m.type == 'S'){
                            m.url = moduleApp.basePath+"/tpl/"+ m.url;
                        }else if(m.type == 'D'){
                            m.url = productConfigServ.generateDynamicDom({});
                        }


                        if(angular.isDefined(m.bizType)){
                            m.ctrl = m.bizType+"Ctrl";
                            m.ctrl = $controller(m.bizType+"Ctrl",{$scope:$scope.$new(false)}).constructor;
                        }else{
                            m.ctrl = $controller("baseInfoCtrl",{$scope:$scope.$new(false)}).constructor;
                        };
                    });

                    $scope.moduleList = cfgInfo;
                },
                function (error) {
                    angular.alert("加载产品配置信息失败");
                }
            );
        };

        $scope.onSubmit = function() {
            //获取到表单是否验证通过
            if ($scope.proposalForm.$valid) {
                console.log(JSON.stringify(vm.policy));
                angular.alert("提交成功");
            }else{
                FormFocus.focusEle("proposalForm");
                return;
            }
        };

        $scope.getTemplate();

        vm.insType = true;
        vm.policy.prpTmain={};
        vm.policy.prpTmain.sumPremium = "150";

    };
    moduleApp.controller('addProposalCtrl',['$q','$rootScope','$scope','$modal','$stateParams','$state','FormFocus','$controller','productConfigServ',addProposalCtrl]);
});