/**
 * Created by sen on 2017/11/17.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIProposalAdminCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state',
        function ($rootScope,$scope,$$finder,$http,$filter,$state) {
            //提交查询信息
            $scope.totalItems=0;
            $scope.submit=function(){
                $$finder.find('proposalState',{}, {
                    success: function (data) {
                        $scope.proposal.prpTmain=data.data.proposal.prpTmain;
                        $scope.cpproposal.prpTmain=$scope.proposal.prpTmain;
                        $scope.totalItems=$scope.cpproposal.prpTmain.QueryList.length;
                        //查询结果条数
                        $scope.paginationConfmm.totalItems =  $scope.totalItems;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //获取后台数据
            $scope.proposal={};
            $scope.cpproposal={};
            $$finder.find('proposalState',{}, {
                success: function (data) {
                    $scope.proposal.prpTmain=data.data.proposal.prpTmain;
                    $scope.cpproposal.prpTmain=$scope.proposal.prpTmain;
                    $scope.cpproposal.prpTmain.QueryList={};
                },
                error: function (e) {
                    options.error(e);
                }
            });
            //获取投保单信息
            $scope.QueryList=function(){}
            //展开更多查询条件
            $scope.SRC="common/images/chenpeng/展开.png";
            $scope.conditionShow=false;
            $scope.addFrom=function(){
                $scope.conditionShow=!$scope.conditionShow;
                $scope.SRC=!$scope.conditionShow?"common/images/chenpeng/展开.png":"common/images/chenpeng/收起.png";
            };
            //重置表单
            $scope.reset=function(){
                $scope.proposal.prpTmain={};
                $scope.$apply();
                $scope.proposal.prpTmain.underWriteFlag=$scope.cpproposal.prpTmain.underWriteFlag;
                $scope.proposal.prpTmain.BusinessType1=$scope.cpproposal.prpTmain.BusinessType1
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50]
                };
            };
            initPage2();
            $scope.paginationConfmm.totalItems =  $scope.totalItems;
            if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
                $scope.paginationConfmm.totalItems=0;
            }

            //    总保险金额的数字校验
            $scope.pressDecimal=function($event){
                if(($event.keyCode>=48 && $event.keyCode<=57) || $event.keyCode==46){
                    return true;
                }else{
                    $event.preventDefault();
                }
            }
            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.proposal.prpTmain.QueryList,function(info){
                        info.checked=true;
                        $scope.checked1.push (info.id);
                    })
                } else {
                    angular.forEach($scope.proposal.prpTmain.QueryList,function(info){
                        info.checked=false;
                        $scope.checked1 = [];
                    })
                }
            }
            $scope.selectOne=function(){
                angular.forEach($scope.proposal.prpTmain.QueryList , function (info) {
                    var index = $scope.checked1.indexOf(info.id);
                    if(info.checked && index === -1) {
                        $scope.checked1.push(info.id);
                    } else if (!info.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.proposal.prpTmain.QueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }
            //投保单查询页面的查看与修改
            $scope.revise=function(type){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposaledit',{type:type})
            }
            //隐藏险种方案
            //$scope.showRiskScheme=false;
            //$scope.riskNameHide=false;
        }]);
});