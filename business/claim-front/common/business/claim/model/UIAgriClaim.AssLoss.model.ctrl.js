/**
 * DESC       : 国元农险理赔立案任务查询---调整估损金额弹层
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
    app.registerController('UIAgriClaimAssLossModelCtrl', ['$rootScope', '$scope', '$location', '$$finder', 'regexpConstants', '$state', '$filter','$timeout',
        function ($rootScope, $scope, $location, $$finder, regexpConstants, $state, $filter,$timeout) {
            $scope.checkAssLossFlag = false;
            $scope.$on("SendAssLossLayerSwitch", function (d, item) {
                $scope.resuleType = item;
                $scope.checkAssLossFlag = !$scope.checkAssLossFlag; // 弹层显示隐藏
                init();
            });

            var init = function () {
                $scope.codeListData = {};
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
                            "riskCode": $scope.resuleType.swfLogDto.riskCode
                        }
                    ]
                };
                $$finder.post("baseCode", _data).then(function (data) {
                    angular.forEach(data.data, function (item, index) {
                        $scope.codeListData[item.codeType] = item.resultobj.action_result;
                    })
                }, function (error) {

                });
                $scope.claimQueryDto = {
                    editType: $scope.resuleType.editType,
                    claimNo: $scope.resuleType.claimNo,
                    // editType:"ADD",
                    registNo:$scope.resuleType.swfLogDto.registNo
                }; // 查询条件
                $$finder.post('claimPageInit', $scope.claimQueryDto).then(
                    function (data) {
                        console.log("以下是初始化数据=============")
                        console.log(data)
                        $scope.dtoMessage = data.message || "";
                        $scope.claim = data;
                        $scope.claim.prpLClaimDto.startDate = $filter("date")(data.prpLClaimDto.startDate,"yyyy-MM-dd");
                        $scope.claim.prpLClaimDto.endDate = $filter("date")(data.prpLClaimDto.endDate,"yyyy-MM-dd");
                        $scope.claim.prpLClaimDto.damageStartDate = $filter("date")(data.prpLClaimDto.damageStartDate, "yyyy-MM-dd");
                        $scope.claim.prpLClaimDto.claimDate = $filter("date")(data.prpLClaimDto.claimDate, "yyyy-MM-dd");
                        var sumClaimAmount=0;
                        console.log("1111111111")
                        angular.forEach($scope.claim.prpLclaimLossDtoList,function(item){
                            item.inputDate=$filter('date')(item.inputDate,'yyyy-MM-dd')
                            //计算总赔付金额
                            sumClaimAmount=sumClaimAmount+item.sumClaim;
                        });
                        console.log(sumClaimAmount);
                        $scope.claim.prpLClaimDto.sumClaimAmount = sumClaimAmount;
                        // 估损金额列表 被保险人
                        // $scope.addPrpLclaimLossDtoList();
                        $$finder.post("queryVirturlItemByPolicyNo",
                            {
                                flag: "1",
                                policyNo: data.policyNo,
                                riskCode: data.riskCode
                            }
                        ).then(function (data) {
                            $scope.codeListData.familyNameList = data;
                        });
                        // 查询险别
                        $$finder.post("queryVirturlItemByPolicyNo",
                            {
                                flag: "2",
                                policyNo: data.policyNo,
                                riskCode: data.riskCode
                            }
                        ).then(function (data) {
                            $scope.codeListData.kindCodeList = data;
                        }, function (error) {

                        });
                    }
                );
                $scope.editType = $scope.resuleType.editType;
                $scope.isAquaculture = false;
                if ($scope.riskType === "H") { // 种植险
                    $scope.isAquaculture = false;
                } else if ($scope.riskType === "I") { // 养植险
                    $scope.isAquaculture = true;
                }
            };
            /**
             * 险别估损金额信息
             */
            $scope.addPrpLclaimLossDtoList = function (){
                // $scope.claim.prpLClaimLossDtoList = $scope.claim.prpLclaimLossDtoList || [];
                //var sumClaimAmountValue = 0;
                //console.log("=========");
                //console.log($scope.claim.prpLclaimLossDtoList)
                angular.forEach($scope.claim.prpLclaimLossDtoList,function(item){
                    //item.sumClaim = parseFloat(item.sumClaim)
                    //sumClaimAmountValue=sumClaimAmountValue+item.sumClaim;
                    $scope.index=item.serialNo;
                })
                //$scope.claim.prpLClaimDto.sumClaimAmount = sumClaimAmountValue;
                var index=$scope.index;
                if($scope.claim.prpLclaimLossDtoList.length==0){
                    index=0;
                }
                var curDate = new Date();
                curDate = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                var prpLClaimLoss = {
                    claimNo: $scope.claim.claimNo,
                    riskCode: $scope.claim.riskCode,
                    serialNo:index+1,
                    familyName:$scope.claim.prpLClaimDto.insuredNameShow ,
                    kindCode: '',
                    itemDetailName: '',
                    currency: 'CNY',
                    sumPaid: '',
                    lossFeeType: '',
                    inputDate: curDate,
                    remarkFlag:''
                }
                $scope.claim.prpLclaimLossDtoList.push(prpLClaimLoss)
            }
            $scope.deletePrpLclaimLossDto=function(index){
                //if($scope.claim.prpLclaimLossDtoList[index].sumClaim!=undefined ) {
                //    console.log($scope.claim.prpLclaimLossDtoList[index].sumClaim);
                //    $scope.claim.prpLClaimDto.sumClaimAmount = $scope.claim.prpLClaimDto.sumClaimAmount - $scope.claim.prpLclaimLossDtoList[index].sumClaim;
                //}
                $scope.claim.prpLclaimLossDtoList.splice(index,1)
            }
            //根据险别带出标的
            $scope.getItemDetailName = function (item, $select) {
                item.itemDetailName = $select.selected.itemdetailName;
                item.itemCode=$select.selected.itemCode;
            };
            $scope.saveAsslosss=function(){
                var claimAssLoss={};
                console.log("以下是入参===========")
                console.log($scope.claim.prpLclaimLossDtoList);
                claimAssLoss.prpLclaimLossDtoList=$scope.claim.prpLclaimLossDtoList;
                claimAssLoss.claimNo=$scope.claim.claimNo;
                console.log(claimAssLoss);
                for(i=0;i<claimAssLoss.prpLclaimLossDtoList.length;i++){
                    var result=claimAssLoss.prpLclaimLossDtoList[i];
                    var m=i+1;
                    if(!result.kindCode){
                        layerMsg("第"+m+"行"+"险别不能为空！");
                        return false;
                    }
                    if(!result.itemDetailName){
                        layerMsg("第"+m+"行"+"标的名称不能为空！");
                        return false;
                    }
                    if(!result.currency){
                        layerMsg("第"+m+"行"+"币别不能为空！");
                        return false;
                    }
                    if(!result.sumClaim){
                        layerMsg("第"+m+"行"+"险别估损金额不能为空！");
                        return false;
                    }
                    if(!result.lossFeeType){
                        layerMsg("第"+m+"行"+"费用类别不能为空！");
                        return false;
                    }
                    if(!result.inputDate){
                        layerMsg("第"+m+"行"+"输入日期不能为空！");
                        return false;
                    }
                    if(!result.remarkFlag){
                        layerMsg("第"+m+"行"+"调整原因不能为空！");
                        return false;
                    }
                }
                $$finder.post('saveModifyDetail',claimAssLoss).then(function(data){
                    if(data.code&&data.code!='0000'){
                        layerMsg('保存失败')
                    }else{
                        layerMsg('保存成功', function(){
                            $timeout(function(){
                                $scope.checkAssLossFlag=false
                            },500);
                        });
                    }

                })
            };
            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };

        }]);
});
