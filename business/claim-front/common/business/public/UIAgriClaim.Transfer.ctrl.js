/**
 * DESC       : 国元农险理赔立案任务查询---转交页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriClaimTransferCtrl', ['$rootScope','$modal', '$scope', '$location', '$$finder', 'regexpConstants', '$stateParams','$timeout','$state',
        function ($rootScope, $modal, $scope, $location, $$finder, regexpConstants, $stateParams,$timeout, $state) {
            var initData=$scope.initData = JSON.parse($stateParams.data);
            $scope.printlist=[];
            // $scope.checkHandle=function () {
            //     $modal.open(
            //         {
            //             backdrop: false,
            //             animation: true,
            //             templateUrl: "common/business/public/comcodeTree.modal.tpl.html",
            //             controller: function ($scope, $$finder) {
            //                 $$finder.post("comcode",{}).then(function (data) {
            //                     $scope.data = data.childList;
            //
            //                 })
            //             },
            //             size: 'sm'
            //         }
            //
            //     )
            // };
            $scope.printListShow=false;
            $scope.showprintListShow= function () {
                $scope.printListShow=true;

            }
            $scope.showprintListHide= function () {
                $scope.printListShow=false;
            }
            var swflogList;

            $$finder.post("turnPageByPrimary", initData).then(
                function (data) {
                    debugger;
                    swflogList = data;
                    console.log(data);
                    $scope.swflogDto = {};
                    $scope.swflogDto.nodeName =  data[0].nodeName; // 转交类型
                    $scope.swflogDto.handleName =  ''; // 受理机构
                    $scope.swflogDto.handleCode =  ''; // 受理机构
                    $scope.swflogDto.handlerCode = ''; // 受理人
                    $scope.swflogDto.handlerName = ''; // 受理人
                    $scope.swflogDto.registNo = data[0].registNo; // 报案号码
                    $scope.swflogDto.inputDate = data[0].inputDate; // 转交时间
                    $scope.swflogDto.operatorCode = data[0].operatorCode; // 转交人
                    $scope.swflogDto.operatorName = $scope.user.userName; // 转交人

                }
            );
            $scope.paginationConf = {
                currentPage : 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage : 5, // 每页展示的数据条数
                perPageOptions : [ 5,10, 20, 50 ],
                onChange:function() {
                    $scope.printlist = [];
                    for (var i = ($scope.paginationConf.currentPage - 1) * $scope.paginationConf.itemsPerPage; i <$scope.paginationConf.currentPage * $scope.paginationConf.itemsPerPage; i++) {
                        if($scope.initData[i]){
                            $scope.printlist.push($scope.initData[i]);
                        }

                    }
                }
            };
            for (var i = 0; i < 5; i++) {
                if ($scope.initData[i]) {
                    $scope.printlist.push($scope.initData[i]);
                }
            }
            $scope.paginationConf.totalItems=$scope.initData.length;

            $scope.submitTransfer = function () {
                $scope.flag=false;
                angular.forEach(swflogList, function (swflog) {
                    swflog.handleName = $scope.swflogDto.handleName;
                    swflog.handleCode = $scope.swflogDto.handleCode;

                    swflog.handlerName  = $scope.swflogDto.handlerName; // 受理人
                    swflog.handlerCode  = $scope.swflogDto.handlerCode; // 受理人

                    swflog.context  = $scope.swflogDto.context; // 描述
                });
                $$finder.post('workRoveByRovePage', swflogList).then(
                    function (data) {
                        if(data && data.code==="0000"){
                            layer.open({
                                offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                content: "转交成功",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                    if ($scope.swflogDto.nodeName=='查勘'){
                                        $state.go("UIAgriCheckQuery")
                                    }else {
                                    $state.go("UIAgriClaimQuery");
                                    }
                                }
                            });
                            $scope.flag=true;
                        }else if(data && data.code === '9999'){
                            layerMsg("转交失败!")
                        }
                    })
            }

            // 受理人
            $scope.queryCheckSurveyPeople = function () {
                var dto = {
                    "comCode": $scope.swflogDto.handleCode,
                    "taskCode": "claim.check"
                };
                $$finder.post('queryCheckAndLossPeople', dto).then(
                    function (data) {
                        $scope.handlerList=data;
                    }
                )
            };

            $scope.textChange = function (e) {
                $scope.swflogDto.context = '由' + $scope.swflogDto.operatorName + '转交给' + e + '处理。';
            };
            $scope.giveUp = function () {
                $state.go("UIAgriCheckQuery")
            };
            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);
});