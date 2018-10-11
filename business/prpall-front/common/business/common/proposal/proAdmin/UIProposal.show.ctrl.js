/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIProposalshowCtrl', ['$rootScope', '$scope','$http','$anchorScroll','$location','$$cherry','$$finder','$state','$stateParams',
        function ($rootScope, $scope,$http,$anchorScroll,$location,$$cherry,$$finder,$state,$stateParams){
            //    将页面的input变成只读状态
            $scope.proposalQueryHide=true;
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
            }
            var keyword={}
            $$cherry.$proposal.Proposal(keyword, {
                // clauseType: 'F57',
                success: function (_proposal) {
                    if(_proposal){
                        $scope.proposal =_proposal;
                    }
                }
            })
            $scope.showSave=false;
            $scope.showSaveSuccess=function(){
                $scope.showSave=!$scope.showSave;
                $scope.proposal.save('proposalSave',{
                    success: function (data) {
                        console.log('保存成功');
                        console.log(data);
                    },
                    error: function (e) {
                    }
                });
            };
            //投保单查询页面的基本信息展开收起按钮
            $scope.isHide=true;
            $scope.isShow=function(){
                $scope.isHide=!$scope.isHide;
            }
            //隐藏编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
            $scope.queryHide=false;

            //angular.element("#riskCode_Class").addClass('currency_information');


            //说明文字展示隐藏
            $scope.explain=false;
            $scope.explainClick=function(){
                $scope.explain=!$scope.explain;
            };
        }]);
});