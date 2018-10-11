/**
 * DESC       : 国元农险理赔并案管理-立案任务处理页面
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
    app.registerController('UIAgriCombineTaskHandleCtrl', ['$rootScope','$timeout', '$scope','$state','$filter', '$location', '$$finder','regexpConstants','$stateParams','$modal','$window',
        function ($rootScope,$timeout, $scope,$state,$filter, $location, $$finder, regexpConstants, $stateParams,$modal,$window) {

            /**
             * 电子单证
             */
            $scope.openEleDocumentLayer = function () {
                $scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto.nodeType="claim1";
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };
            $scope.openCommunicationLayer = function () {
                var policyNo=$scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto.policyNo;
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        __CheckPageResponseDto:function () {
                            return angular.copy($scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,__CheckPageResponseDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo":policyNo || '',//保单号
                                "registNo": __CheckPageResponseDto.registNo || '',//报案号
                                "claimNo": __CheckPageResponseDto.claimNo || '',//立案号
                                "riskCode": __CheckPageResponseDto.riskCode || '',//险种代码
                                "nodeType": "claim",//TODO 节点类型  __CheckPageResponseDto.nodeType || ''
                                "operatorCode": $rootScope.user.userCode,
                                "operatorName": $rootScope.user.userName,
                                "inputDate":$filter("date")(new Date(),"yyyy-MM-dd") //TODO 制单日期      __CheckPageResponseDto.inputDate || ''
                            };
                            $$finder.post('queryClaimCommunicationByCondition',keywords).then(
                                function (data){
                                    if(data && !data.code){
                                        $scope.communication = data;
                                        $scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        $scope.closeModal();
                                        layerMsg(data.message);
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                    $scope.closeModal();
                                }
                            );
                        }
                        init();
                        //重置
                        $scope.resetContext = function () {
                            $scope.communication.context = '';
                        };
                        //提交
                        $scope.submitCommuication = function () {
                            var keywords2 = {
                                "policyNo": $scope.communication.policyNo || '',
                                "registNo": $scope.communication.registNo || '',
                                "claimNo": $scope.communication.claimNo || '',
                                "riskCode": $scope.communication.riskCode || '',
                                "inputDate": $scope.communication.inputDate || '',
                                "nodeTypeName": $scope.communication.nodeTypeName || '',
                                "nodeType": $scope.communication.nodeType || '',
                                "operatorCode": $scope.communication.operatorCode || '',
                                "operatorName": $scope.communication.operatorName || '',
                                "context": $scope.communication.context || ''
                            };
                            $$finder.post('saveClaimCommunicationInfo',keywords2).then(
                                function (data) {
                                    if(data){
                                        layerMsg(data.message);
                                    }
                                },function (e) {
                                    layerMsg("提交失败");
                                }
                            );
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };

                    }
                });
            };
            $rootScope.user=$rootScope.user
            $scope.codeListData= {};
            var ComClaimDetailQueryDto=$stateParams.TaskHandle;
            ComClaimDetailQueryDto=JSON.parse(ComClaimDetailQueryDto);// 查询条件
            console.log(ComClaimDetailQueryDto);
            // 下拉框初始化
            var _data = {
                "casecadeConditionList": [
                    {
                        "name": "",
                        "value": ''
                    }
                ],
                "initlist": [
                    {
                        "codeType": "DamageCode",
                        "riskCode": ComClaimDetailQueryDto[0].riskCode
                    },{
                        "codeType": "Unit",
                        "riskCode": ComClaimDetailQueryDto[0].riskCode
                    }
                ]
            };
            $$finder.post("baseCode", _data).then(function (data) {
                angular.forEach(data.data, function (item, index) {
                    $scope.codeListData[item.codeType] = item.resultobj.action_result;
                    console.log($scope.codeListData);
                })
            }, function (error) {

            });
            $scope.regData = regexpConstants; // 本页面使用正则的集合
            $scope.regData.hour = regexpConstants.hour;
            $scope.regData.number=regexpConstants.number;
            $scope.ComClaimDetailResDto = {}; // 查询结果
            $scope.seeFlag=false;
            $scope.editType=ComClaimDetailQueryDto[0].editType;

            if($scope.editType==='SHOW'){
                $scope.seeFlag=true;
            }
            //提交查询
            $$finder.post('comClaimPageInit', ComClaimDetailQueryDto).then(
                function (data) {
                    if(data &&!data.code){
                        console.log(data);
                        angular.forEach(data,function(result,index){
                            data[index]=result;
                            // 日期格式转换
                            result.prpLClaimDtoExt.prpLClaimDto.damageStartDate = $filter("date")(result.prpLClaimDtoExt.prpLClaimDto.damageStartDate, "yyyy-MM-dd");
                            result.prpLClaimDtoExt.prpLClaimDto.claimDate = $filter("date")(result.prpLClaimDtoExt.prpLClaimDto.claimDate, "yyyy-MM-dd");
                            result.prpLClaimDtoExt.prpLClaimDto.lossesUnitCode =result.prpLClaimDtoExt.prpLClaimDto.lossesUnitCode;
                            angular.forEach(result.prpLclaimLossDtoList,function(a,index){
                                a.prpLClaimLossDto.inputDate=$filter("date")(a.prpLClaimLossDto.inputDate, "yyyy-MM-dd");
                            })

                        });
                        $scope.ComClaimList=data;
                        $scope.ComClaimDetailResDto = $scope.ComClaimList[0];
                        console.log($scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto.damageName)
                        debugger
                        $scope.testComClaimDetailResDtolistdata=$scope.ComClaimList[0];


                        if($scope.editType=="ADD") {
                            //估损金额信息
                            $scope.addLossList();
                        }
                        $$finder.post("queryVirturlItemByPolicyNo",
                            {
                                flag: "1",
                                policyNo: $scope.ComClaimDetailResDto.policyNo || $scope.ComClaimDetailResDto.prpLRegistDto.policyNo ,
                                riskCode: $scope.ComClaimDetailResDto.riskCode
                            }
                        ).then(function (data) {
                            $scope.codeListData.familyNameList = data;
                        });
                        // 查询险别
                        $$finder.post("queryVirturlItemByPolicyNo",
                            {
                                flag: "2",
                                policyNo: $scope.ComClaimDetailResDto.policyNo || $scope.ComClaimDetailResDto.prpLRegistDto.policyNo,
                                riskCode: $scope.ComClaimDetailResDto.riskCode
                            }
                        ).then(function (data) {
                            $scope.codeListData.kindCodeList = data;
                        }, function (error) {

                        });
                    }else if(data.code='9999'){
                        layerMsg(data.message,function () {
                            $state.go("UIAgriCombineTaskHandleQuery")
                        });
                    }else{
                        layerMsg(data.message||"初始化失败！",function () {
                            $state.go("UIAgriCombineTaskHandleQuery")
                        });
                    }
                }
            );
            //下拉框选择报案号，显示不同的报案信息
            $scope.showRegist=function(data){
                $scope.ComClaimDetailResDto=data;
                if($scope.ComClaimDetailResDto.prpLclaimLossDtoList.length<1){
                    $scope.addLossList();
                }

            }
            //提交 、暂存
            $scope.saveComClaim=function(target){
                $scope.flag=false;
                var layerMsgs="";
                //  传给后台暂存或提交的标志 , 4是所有提交，种植险暂存3,养殖险暂存2
                if(target=='save'){
                    // angular.forEach($scope.ComClaimList,function(result,index){
                    for(i=0;i<$scope.ComClaimList.length;i++){
                        var result=$scope.ComClaimList[i];
                        result.prpLclaimStatusDto={};
                        result.prpLclaimStatusDto.status=4;
                        console.log(result.gatherSumFalg);
                        if(!result.gatherSumFalg){
                         layerMsgs="汇总按钮";
                            layerMsg("报案号 "+result.registNo+" 页面， 请先点击险别估损金额信息'汇总'按钮");
                            return false;
                         }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.damageStartDate){
                            layerMsgs="出险时间";
                            layerMsg("报案号 ："+result.registNo+" 出险时间不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.damageAddress){
                            layerMsgs="出险地点";
                            layerMsg("报案号 ："+result.registNo+" 出险地点不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.currency){
                            layerMsgs="币别";
                            layerMsg("报案号 ："+result.registNo+" 币别不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.sumAmount){
                            layerMsgs="保险金额";
                            layerMsg("报案号 ："+result.registNo+" 保险金额不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.damageName){
                            layerMsgs="出险金额";
                            layerMsg("报案号 ："+result.registNo+" 出险原因不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.lossesNumber){
                            layerMsgs="赔付数量";
                            layerMsg("报案号 ："+result.registNo+" 赔付数量不能为空！");
                            return false;
                        }
                      /*  if(!result.prpLClaimDtoExt.prpLClaimDto.lossesUnitCode){
                            layerMsgs="计量单位";
                            layerMsg("报案号 ："+result.registNo+" 的计量单位不能为空！");
                            return false;
                        }*/
                        if(!result.prpLClaimDtoExt.prpLClaimDto.damageInsured){
                            layerMsgs="出险户次";
                            layerMsg("报案号 ："+result.registNo+" 出险户次不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.deathQuantity){
                            layerMsgs="死亡数量";
                            layerMsg("报案号 ："+result.registNo+" 死亡数量不能为空！");
                            return false;
                        }
                        if(!result.prpLClaimDtoExt.prpLClaimDto.killQuantity){
                            layerMsgs="扑杀数量";
                            layerMsg("报案号 ："+result.registNo+" 扑杀数量不能为空！");
                            return false;
                        }

                    }
                    if(layerMsgs!=""){
                        return false;
                    }
                    $scope.flag=true;
                }else if(target === 'sub') {
                    angular.forEach($scope.ComClaimList,function(result){
                        result.prpLclaimStatusDto={};
                        result.prpLclaimStatusDto.status=2;
                    });
                }
                $$finder.post('saveSubmitComClaim', $scope.ComClaimList).then(
                    function (data) {
                        console.log(data);
                        $scope.Map = data;
                        if(data && data.code=='0000'){
                            if(target=='save'){
                                layerMsg(data.message+'<br/>并案号：'+data.combineNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCombineTaskHandleQuery');})
                                },{skin:'layer-success'});
                            }else if (target=='sub'){
                                layerMsg(data.message+'<br/>并案号：'+data.combineNo, function(){
                                    $timeout(function () {  $state.go('UIAgriCombineTaskHandleQuery');})
                                },{skin:'layer-success'});
                            }
                        }else if(data.code=='9999'){
                            layerMsg('立案并案处理失败！');
                        }
                    }
                )
            };
            // 理赔沟通弹层
           /* $scope.openCommunicationLayer = function () {
                $modal.open({
                    templateUrl:'common/business/modal/communicate/UIAgriCommunicate.modal.html',
                    resolve:{
                        queryDto:function () {
                            $scope.ComClaimDetailResDto.nodeType='claim';
                            $scope.ComClaimDetailResDto.prpLClaimDto={}
                            $scope.ComClaimDetailResDto.prpLClaimDto.operatorCode=$rootScope.user.loginComCode;
                            $scope.ComClaimDetailResDto.prpLClaimDto.inputDate=$filter('date')(new Date(),'yyyy-MM-dd');
                            return angular.copy($scope.ComClaimDetailResDto);
                        }
                    },
                    controller:'claimCommunicateCtrl'
                });
            };*/
            // 电子单证弹层
          /*  $scope.openEleDocumentLayer = function () {
                $modal.open({
                    templateUrl:'common/business/modal/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            $scope.ComClaimDetailResDto.nodeType='claim';
                            if(!$scope.ComClaimDetailResDto.claimNo){
                                $scope.ComClaimDetailResDto.claimNo = '';
                            }
                            $scope.ComClaimDetailResDto.prpLClaimDto={}
                            $scope.ComClaimDetailResDto.prpLClaimDto.operatorCode=$rootScope.user.loginComCode;
                            $scope.ComClaimDetailResDto.prpLClaimDto.inputDate=$filter('date')(new Date(),'yyyy-MM-dd');
                            angular.forEach(ComClaimDetailQueryDto,function(item,index){
                                if(item.registNo==$scope.ComClaimDetailResDto.registNo){
                                    $scope.ComClaimDetailResDto.flowId=item.swfLogFlowID;
                                }
                            })
                            return angular.copy($scope.ComClaimDetailResDto);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };*/

            // 添加估损金额
            $scope.addLossList =function () {
                var curDate = new Date();
                curDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                console.log(curDate);
                var obj ={
                    prpLClaimLossDto:{
                        familyName:"", //被保险人姓名
                        kindCode: "",  //险别代码
                        kindName: "",  //险别名称
                        itemDetailName: "",  //标的名称
                        currency: "CNY",  //币别
                        sumClaim: "0",  // 预计给付金额
                        lossFeeType: "",  // 类别,
                        inputDate: curDate , // 预计给付金额
                        riskCode: $scope.ComClaimDetailResDto.riskCode  // 险种代码
                    }
                };
                $scope.ComClaimDetailResDto.prpLclaimLossDtoList.push(obj);
                $scope.ComClaimDetailResDto.gatherSumFalg =false;
                console.log($scope.gatherSumFalg);
                console.log(!$scope.gatherSumFalg)
                console.log($scope.ComClaimDetailResDto.prpLclaimLossDtoList);

            };
            // 删除估损金额
            $scope.delLossList = function (index,name) {

                $scope.ComClaimDetailResDto.prpLclaimLossDtoList.splice(index, 1);
                $scope.ComClaimDetailResDto.gatherSumFalg =false;
            };
            //根据险别带出标的
            $scope.getItemDetailName =function (item, $select) {
                item.prpLClaimLossDto.itemDetailName=$select.selected.itemdetailName
            };

            // 出险次数信息记录查看
            $scope.openPerilCount = function () {

                if($scope.ComClaimDetailResDto.intRecentCount===null||$scope.ComClaimDetailResDto.intRecentCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                }
                var url = '#/PerilCount?policyNo=' + $scope.ComClaimDetailResDto.policyNo;
                $window.open(url);
            };

            /**
             * 汇总
             */
            $scope.gatherSum = function () {
                if(!$scope.calibrateSum()){
                    return false;
                }
                var sumPrim = 0;
                angular.forEach($scope.ComClaimDetailResDto.prpLclaimLossDtoList,function (prpLclaimLossDto,index) {
                    sumPrim = parseFloat(prpLclaimLossDto.prpLClaimLossDto.sumClaim) + sumPrim;
                });
                $scope.ComClaimDetailResDto.prpLClaimDtoExt.prpLClaimDto.sumClaim = sumPrim ;
                $scope.ComClaimDetailResDto.gatherSumFalg = true;
            };
            /**
             * 险别估损金额信息
             */
            $scope.calibrateSum = function () {
                if(!$scope.ComClaimDetailResDto.prpLclaimLossDtoList||!$scope.ComClaimDetailResDto.prpLclaimLossDtoList){
                    layerMsg("请填写险别估损金额信息！");
                    return false;
                }else {
                    var layerMges = "";
                     angular.forEach($scope.ComClaimDetailResDto.prpLclaimLossDtoList,function (prpLclaimLossDto,index) {
                    for(var index=0;index<$scope.ComClaimDetailResDto.prpLclaimLossDtoList.length;index++) {
                        var prpLclaimLossDto=$scope.ComClaimDetailResDto.prpLclaimLossDtoList[index].prpLClaimLossDto;
                        if (!prpLclaimLossDto.familyName) {
                            layerMges = "被保险人";
                            layerMsg("险别估损金额中，第" + (index + 1) + "行'被保险人'不能为空！");
                            return false;
                        }
                        if (!prpLclaimLossDto.itemDetailName) {
                            layerMges = "险别";
                            layerMsg("险别估损金额中，第" + (index + 1) + "行'险别'不能为空！");
                            return false;
                        }
                        if (!prpLclaimLossDto.currency) {
                            layerMges = "币别";
                            layerMsg("险别估损金额中，第" + (index + 1) + "行'币别'不能为空！");
                            return false;
                        }
                        if(!prpLclaimLossDto.sumClaim){
                            layerMges = "预计给付金额";
                            layerMsg("险别估损金额中，第"+(index+1)+"行'预计给付金额'不能为空！");
                            return false;
                        }

                        if (!prpLclaimLossDto.lossFeeType) {
                            layerMges = "类别";
                            layerMsg("险别估损金额中，第" + (index + 1) + "行'类别'不能为空！");
                            return false;
                        }
                    }
                    });
                    if(layerMges==""){
                        return true;
                    }
                }

            }

            /**
             * 返回
             */
            $scope.goBack = function () {
                // $rootScope.back();
                $state.go("UIAgriCombineTaskHandleQuery");
            };
            // 取消
            $scope.cancel = function () {
                $state.go("UIAgriCombineTaskHandleQuery")
            };
        }]);
});