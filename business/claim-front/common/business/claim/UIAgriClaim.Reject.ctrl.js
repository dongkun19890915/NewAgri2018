/**
 * DESC       : 国元农险理赔立案任务查询---申请注销/拒赔页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'common/business/electronicsDocuments/UIAgriElectronics.examine.model.ctrl'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriClaimRejectCtrl', ['$rootScope', '$scope', '$location', '$$finder','regexpConstants','$stateParams','$modal','$filter','$state',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $stateParams,$modal,$filter,$state) {

            /**
             *
             */
            $scope.caseTypeShow = function (target,index) {
                if(target.caseType.id==1){
                    $scope.rejectList[index].cancelReason = $scope.cancelReasonCancel[0] || '';
                }

            };

            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 10, // 每页展示的数据条数
                    perPageOptions : [ 10, 20, 30, 40,50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };

            /**
             * 提交
             */
            $scope.saveReject = function () {
                $scope.flag=false;
                if(!$scope.oldLastAccessedTime){
                    $scope.cancelSubmitList = [];
                    if($scope.rejectList[0].cancelReason==undefined){
                        layerMsg("请选择注销拒赔原因");
                        return;
                    }
                    angular.forEach($scope.rejectList,function (reject,index) {
                        var target = {
                            "businessNo": reject.prpLclaimCancelClaimNo || '',//立案号
                            "swfLogFlowID": reject.swfLogFlowID || '',//工作流ID：flowID
                            "swfLogLogNo": reject.swfLogLogNo,//logNo
                            "submitType": "0",//写死
                            "prpLclaimContext": $scope.claim.prpLclaim.cancelReason,
                            "prpCancel": "",//注销／拒赔原因
                            "prpExclusions": "",//拒赔原因（不属于保险责任 ：0）
                            "editType": "ADD",//写死
                            "prpLclaimCancelClaimNo": reject.prpLclaimCancelClaimNo || '',//立案号
                            "registNo": reject.registNo || '',//报案号
                            "nodeType": "compe",//节点类型（立案：claim；理算：compe）
                            "caseType": reject.caseType.id,//申请类型（0:注销；1:拒赔）
                            "status": "",//可以不传
                            "LastAccessedTime": "",//传空
                            "oldCancelAccessedTime": "",//点击提交后赋值
                            "cancelReason": reject.cancelReason.id,//注销原因代码
                            "cancelReasonName": reject.cancelReason.name,//注销原因名字
                            "prpLclaimDto": reject.prpLClaimDto
                        };
                        target.prpLclaimDto.cancelDate = $scope.claim.prpLregist.cancelDate;
                        target.prpLclaimDto.dealerCode = $scope.user.userCode;
                        if(reject.caseType.id==0){
                            target.prpCancel = reject.cancelReason.id
                        }else {
                            target.prpExclusions = 0;
                        }
                        $scope.cancelSubmitList.push(target);
                    });
                    $$finder.post("claimCancelSubmit",$scope.cancelSubmitList).then(

                        function (data) {
                            if (data.code === "9999"){
                                layerMsg('提交失败!'+data.message);
                            }else {
                                if(data.oldLastAccessedTime){
                                    $scope.oldLastAccessedTime = data.oldLastAccessedTime;
                                }
                                angular.forEach($scope.cancelSubmitList,function (reject,index) {
                                    reject.oldCancelAccessedTime = data.oldLastAccessedTime;
                                });
                                layerMsg(data.result,function(){
                                    $state.go("UIAgriClaimQuery");
                                });
                                $scope.flag=true;
                            }
                        }
                    );
                }

            };

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('queryPrpLregistList', dto).then(
                    function (data) {
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            };
            $scope.query = function () {
                console.log($scope.registQueryForm);
                if ($scope.registQueryForm.$valid) { // 校验通过

                } else { // 校验未通过

                }
                getFileList();
            };


            // 电子单证弹层
            $scope.openEleDocumentLayer = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.rejectList);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            /**
             * 初始化
             */
            var init = function () {
                initPage();
                $scope.queryDto = {}; // 查询条件
                $scope.regData = {}; // 本页面使用正则的集合
                $scope.regData.hour = regexpConstants.hour;
                $scope.prpLregist = null; // 查询结果
                var curDate = new Date();
                $filter("date")(curDate,"yyyy-MM-dd");
                $scope.claim = {
                    "prpLregist":{
                        cancelDate:$filter("date")(curDate,"yyyy-MM-dd"),//申请时间
                        comName:$scope.user.userName,//申请人
                        cancelReason:""//申请原因
                    }
                };
                $scope.caseTypeArray =[
                    {id: 0, name: '注销' },
                    {id: 1, name: '拒赔' }
                ];
                $scope.cancelReasonArray = [
                    {id: 1, name: '客户报错案' },
                    {id: 2, name: '客户重复报案' },
                    {id: 3, name: '不属于投保险别出险' },
                    {id: 4, name: '业务员操作错误' }
                ];
                $scope.cancelReasonCancel = [
                    {id: 0, name: '不属于保险责任' }
                ];

                if($stateParams.data){
                    $scope.claimCancelDetail = JSON.parse($stateParams.data);
                    $$finder.post("queryClaimCancelDetail",$scope.claimCancelDetail).then(
                        function (data) {
                            $scope.rejectList = data;
                            angular.forEach($scope.rejectList,function (reject,index) {
                                reject.caseType = $scope.caseTypeArray[0];
                            });
                        }
                    );
                }



            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
            init();


        }]);
});