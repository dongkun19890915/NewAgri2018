/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'utilities'
], function (app) {
    'use strict';
    app.registerController('UIProposal3107showCtrl', ['$rootScope', '$scope','$http','$anchorScroll','$location','$$cherry','$$finder','$state','$stateParams', 'commonApiServ', 'regexpConstants', '$$code',
        function ($rootScope, $scope,$http,$anchorScroll,$location,$$cherry,$$finder,$state,$stateParams,commonApiServ,regexpConstants,$$code){
            //131073400002018000107
            var keyword={};
            $$cherry.$proposal.Proposal(keyword, {
                // clauseType: 'F57',
                success: function (_proposal) {
                    if(_proposal){
                        $scope.proposal =_proposal;
                    }
                }
            });
            console.log( $scope.proposal)
            //投保单详细信息详情
            $$finder.find('queryProposalInfo', {
                    "proposalNo":$stateParams.data.proposalNo,
                    "familyNos":$stateParams.data.familyNos
                },{
                success:function(data){
                    console.log(data)
                    var _data=data.content;
                    $scope.proposal.appliInsuredDto=_data.customerDto.appliInsuredDto;//客户信息中的投保人信息
                    $scope.proposal.insuredDto=_data.customerDto.insuredDto;//客户信息中的被保人信息
                    $scope.proposal.prpTmainDto=_data.prpTmainDto;//基本信息（不完全）
                    $scope.proposal.prpTaddressDto.addressName=_data.contractinfoDto.addressName;//种植地址
                    $scope.proposal.prpTitemKindDtoList=_data.contractinfoDto.prpTitemKindList;//主险附加险(不完全)
                    $scope.proposal.prpTplanDtoList=_data.contractinfoDto.prpTplanList;//缴费计划（不完全）
                    $scope.proposal.prpTsubsidyDtoList=_data.contractinfoDto.prpTsubsidyList;//补贴信息
                    $scope.proposal.prpTfeeDto.amount=_data.contractinfoDto.amount;//币别信息的保额
                    $scope.proposal.prpTfeeDto.amount1=_data.contractinfoDto.amount1;//支付币别保额
                    $scope.proposal.prpTfeeDto.amount2=_data.contractinfoDto.amount2;//汇总币别保额
                    $scope.proposal.prpTfeeDto.currency=_data.contractinfoDto.currency;//币别
                    $scope.proposal.prpTfeeDto.currency1=_data.contractinfoDto.currency1;//支付币别
                    $scope.proposal.prpTfeeDto.currency2=_data.contractinfoDto.currency2;//汇总币别
                    $scope.proposal.prpTfeeDto.exchangeRate1=_data.contractinfoDto.exchangeRate1;//汇总兑换率
                    $scope.proposal.prpTfeeDto.exchangeRate2=_data.contractinfoDto.exchangeRate2;//支付兑换率
                    $scope.proposal.prpTfeeDto.premium=_data.contractinfoDto.premium;//保费
                    $scope.proposal.prpTfeeDto.premium1=_data.contractinfoDto.premium1;//支付币别保费
                    $scope.proposal.prpTfeeDto.premium2=_data.contractinfoDto.premium2;//汇总币别保费
                }
            })

            // 将页面的input变成只读状态
            //$scope.proposal.prpTmainDto.businessType1='1'
            $scope.proposalQueryHide=true;
            $scope.endorseFlag=false;
            //楼梯导航
            $scope.goBasic=function(){
                $location.hash("basic");
                $anchorScroll();
            };
            $scope.goContract=function(){
                $location.hash("contract");
                $anchorScroll();
            };
            $scope.goClient=function(){
                $location.hash("client");
                $anchorScroll();
            };
            $scope.goOthers=function(){
                $location.hash("others");
                $anchorScroll();
            };

            //$scope.showSave=false;
            //投保单查询页面的基本信息展开收起按钮
            $scope.isHide=true;
            $scope.isShow=function(){
                $scope.isHide=!$scope.isHide;
            }
            //隐藏编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
            $scope.queryHide=false;

           $scope.showRiskScheme=false;
            //说明文字展示隐藏
            $scope.explain=false;
            $scope.explainClick=function(){
                $scope.explain=!$scope.explain;
            };
        }]);
});