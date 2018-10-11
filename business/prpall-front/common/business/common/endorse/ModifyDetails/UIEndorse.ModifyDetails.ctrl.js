/**
 * Created by sen on 2017/11/28.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIEndorseModifyDetailsCtrl', ['$rootScope', '$scope','$location','$anchorScroll', '$$finder', '$http', '$filter', '$$cherry','$state',
        function ($rootScope, $scope, $location,$anchorScroll,$$finder, $http, $filter, $$cherry,$state) {

            $scope.stateToNext=function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIEndorseGeneralMarking.GenerateApproval')
            }
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
            var keyword = {

            };
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
            $$finder.find('mainAgri',{}, {
                success: function (data) {
                    //投保方式(老系统“保单类型”)
                    $scope.PolicyType=data.data.PolicyType;
                    //按何种方式确定保险金额
                    $scope.proposalType=data.data.proposalType;
                    //补贴信息表格
                    //补贴类型
                    $scope.subsidyCode=data.data.subsidyCode;
                    //补贴方式
                    $scope.subsidytype=data.data.subsidytype
                },
                error: function (e) {
                    options.error(e);
                }
            });

            //说明文字展示隐藏
            $scope.explain=false;
            $scope.explainClick=function(){
                $scope.explain=!$scope.explain;
            };
            //当前日期
            $scope.year=new Date().getFullYear();
            $scope.month=new Date().getMonth()+1;
            $scope.day=new Date().getDate();
            $scope.signDate=$scope.year+'-'+$scope.month+'-'+$scope.day;

            //投保单录入页面的展开收起按钮
            $scope.isHide=true;
            $scope.isShow=function(){
                $scope.isHide=!$scope.isHide;
            }
            //后台请求数据
            $$finder.find('proposal',{}, {
                success: function (data) {
                    //归属区域  省
                    $scope.businessProvince=data.data.businessProvince;
                    //市
                    $scope.businessTown=data.data.businessTown;
                    //区
                    $scope.businessCounty=data.data.businessCounty;
                    //县
                    $scope.businessCity=data.data.businessCity;
                    //乡
                    $scope.businessAreaName=data.data.businessAreaName;
                    //业务来源
                    $scope.BusinessNature=data.data.mianHeadBusinessNature;
                    //业务归属员
                    $scope.handlerl=data.data.handlerl;
                    //业务大类
                    $scope.BusinessCategory=data.data.BusinessCategory;
                    //政策商业标识
                    $scope.BusinessType1=data.data.BusinessType1;
                    //缴纳方式
                    $scope.AutoTransRenewFlag1=data.data.AutoTransRenewFlag1;


                },
                error: function (e) {
                    options.error(e);
                }
            });
            //业务大类
            $scope.checked = [];
            $scope.selectOne=function(){
                //console.log($scope.BusinessCategory);
                angular.forEach($scope.BusinessCategory,function(BusinessCategory){
                    //console.log(BusinessCategory);
                    var index = $scope.checked .indexOf(BusinessCategory.codeCode);
                    if($scope.checked && index === -1) {
                        $scope.checked.push(BusinessCategory.codeCode);
                    } else if (!$scope.checked && index !== -1){
                        $scope.checked.splice(index, 1);
                    };
                })
            }
            $$finder.find('penses',{}, {
                success: function (data) {
                    //联共保标志
                    $scope.coinsFlag=data.data.coinsFlag;
                    //    保单缴费类型
                    $scope.coinsPremiumType=data.data.coinsPremiumType;
                    //主保单号码
                    $scope.mainProposalNo=data.data.mainProposalNo;
                    //    共保身份
                    $scope.coinsType=data.data.coinsType;
                },
                error: function (e) {
                    options.error(e);
                }
            });

            //显示编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
            $scope.queryHide=true;
        }]);


});