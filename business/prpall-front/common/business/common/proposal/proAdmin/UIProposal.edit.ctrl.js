/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIproposaleditCtrl',
        ['$rootScope', '$scope', '$http', '$anchorScroll', '$location', '$$cherry', '$$finder', '$stateParams', '$state',
            function ($rootScope, $scope, $http, $anchorScroll, $location, $$cherry, $$finder, $stateParams, $state) {
                $scope.init = false;
                $scope.changeinit = function () {
                    $scope.init = true;
                }
                if ($stateParams.type === 'type') {
                    $scope.showRiskScheme = false;
                } else {
                    $scope.showRiskScheme = true;
                }
                $scope.goBasic = function () {
                    $location.hash("basic");
                    $anchorScroll();
                };
                $scope.goContract = function () {
                    $location.hash("contract");
                    $anchorScroll();
                };
                $scope.goClient = function () {
                    $location.hash("client");
                    $anchorScroll();
                };
                $scope.goOthers = function () {
                    $location.hash("others");
                    $anchorScroll();
                }
                //    保存按钮
                var keyword = {};
                $$cherry.$proposal.Proposal(keyword, {
                    // clauseType: 'F57',
                    success: function (_proposal) {
                        if (_proposal) {
                            $scope.proposal = _proposal;
                        }
                    }
                })
                $scope.showSave = false;
                $scope.showSaveSuccess = function () {
                    $scope.proposal.save('proposalSave', {
                        success: function (data) {
                            console.log('保存成功');
                            console.log(data);
                        },
                        error: function (e) {
                        }
                    });
                };


                //险种方案修改按钮显示隐藏 start
                $scope.showPage = true;
                $scope.showPage1 = function(){
                    $scope.showPage = !$scope.showPage;
                    $scope.modol = true;
                }
                $scope.showPage2 = function(){
                    $scope.modol = false;
                    $scope.showPage = !$scope.showPage;

                }
                //险种方案修改按钮显示隐藏 end
                //投保单模版弹层显示隐藏
                $scope.closeRiskScheme=function(){
                    $scope.showAdminRisk=true;
                    console.log($scope.showAdminRisk);
                }
                //提交核保
                $scope.commitUnderwrite = function () {
                    $scope.showSave = !$scope.showSave;
                    layer.open({
                        area: ['37%', '318px'],
                        /*offset: ['28%', '30%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '提交核保成功',
                        content: '提交核保成功',
                        btn: ['再录一单', '返回主页']
                        , btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go("UIproposal3107edit", {}, {reload: true});
                            //$state.reload('UIproposal3107edit');
                            layer.close(index);
                            //console.log(1111)
                        }
                        , btn2: function (index, layero) {
                            //按钮【按钮二】的回调
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go('dashboard');
                            //return false 开启该代码可禁止点击该按钮关闭
                        }
                    });
                }
                //显示编辑类型、“投保日期”、“制单日期”、“承保清单归属区域"字段
                $scope.queryHide = true;
                //$scope.child=function(){
                //    $scope.showRiskScheme=true;
                //}

            }]);


});