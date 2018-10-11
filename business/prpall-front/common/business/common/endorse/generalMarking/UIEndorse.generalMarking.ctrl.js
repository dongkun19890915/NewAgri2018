define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIEndorseGeneralMarkingCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','commonApiServ','$stateParams',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,commonApiServ,$stateParams) {
            console.log($rootScope.temporaryDto);
            var curDate  = $filter('date')(new Date(), 'yyyy-MM-dd');
            //显示新增客户页面
            ////归属部门
            $$finder.find('queryByPKByMap',{
                comCode:$rootScope.user.loginComCode
            }, {
                success: function (data) {
                    $scope.endorseQueryDto = {
                        logincomcode: $rootScope.user.loginComCode,
                        loginComCodeName: data.content.comCName, // 写死数据，后边要更改为获取
                        applyDate: curDate // 批改申请日期默认为当前日期
                    };
                },
                error: function (e) {
                    options.error(e);
                }
            });

            $scope.check={};
            $scope.prpPheadDto={
                "endorseMessage":"",
                "appliName":""
            }
            //$scope.endorseDate = $filter('date')(new Date(),'yyyy-MM-dd');
            $scope.endorseDate1 = $filter('date')(new Date().getTime()+86400000,'yyyy-MM-dd');
            $scope.endorseQueryDto=$scope.endorseQueryDto||{}
            if(!$rootScope.isEmptyObject($rootScope.temporaryDto)&&$rootScope.temporaryDtoFlag){
                if($rootScope.temporaryDto.endorseQueryDto){
                    $scope.endorseQueryDto.policyNo=$rootScope.temporaryDto.endorseQueryDto.policyNo;
                    $scope.endorseDate1=$rootScope.temporaryDto.endorseDate1;
                    $scope.endorseQueryDto.appliname=$rootScope.temporaryDto.endorseQueryDto.appliname;
                    $scope.endorseQueryDto.applyDate=$rootScope.temporaryDto.endorseQueryDto.applyDate;
                    $scope.prpPheadDto.endorseType=$rootScope.temporaryDto.prpPheadDto.endorseType;
                    $rootScope.temporaryDtoFlag=false;
                    if($rootScope.temporaryDto.prpPheadDto.endorseMessage){
                        $scope.prpPheadDto.endorseMessage=$rootScope.temporaryDto.prpPheadDto.endorseMessage;
                    }
                    $$finder.find('queryCommonEndorse', // 查询保单信息
                        {
                            policyNo: $scope.endorseQueryDto.policyNo,
                            validDate: $scope.endorseQueryDto.applyDate // 批改申请日期查询保单信息时为 validDate
                        }, {
                            success: function (data) {
                                if (data.code === "0000") {
                                    if( !$scope.endorseQueryDto.appliname || $scope.endorseQueryDto.appliname=="" ){
                                        $scope.endorseQueryDto.appliname = data.content.insuredName;
                                    }
                                    $scope.endorseQueryDto.policyNo=$rootScope.temporaryDto.endorseQueryDto.policyNo;
                                    $scope.endorseQueryDto.validDate = data.content.message; // 批改生效日期 反参为message字段  返回的是该保单的起保日期
                                    $scope.endorseQueryDto.riskCode = data.content.riskCode;
                                    $scope.check.policyNo="";

                                } else {
                                    $scope.check.policyNo="保单号系统中不存在，请修改！";
                                }
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                }
            }
            $scope.getCommonEndorse=function ($event) {
                var reg = /^\d{21}$/;
                if ($scope.endorseQueryDto.policyNo) {
                    if (!reg.test($scope.endorseQueryDto.policyNo)) {
                        $scope.check.policyNo='保单号码格式错误，请修改！';
                        $event.target.focus();
                        return
                    }
                }else{
                    $scope.check.policyNo="";
                }

                if (!$scope.endorseQueryDto.applyDate) {
                    layerMsg('请先输入批改日期');
                    $scope.endorseQueryDto.policyNo = "";
                    return
                }
                if (!$scope.endorseQueryDto.applyDate) {
                    layerMsg('请先输入批改日期');
                    $scope.endorseQueryDto.policyNo = "";
                    return
                }
                if ($scope.endorseQueryDto.policyNo) {

                $$finder.find('queryCommonEndorse', // 查询保单信息
                    {
                        policyNo: $scope.endorseQueryDto.policyNo,
                        validDate: $scope.endorseQueryDto.applyDate // 批改申请日期查询保单信息时为 validDate
                    }, {
                        success: function (data) {
                            if (data.code === "0000") {
                                if( !$scope.endorseQueryDto.appliname || $scope.endorseQueryDto.appliname=="" ){
                                    $scope.endorseQueryDto.appliname = data.content.insuredName;
                                }
                                $scope.endorseQueryDto.validDate = data.content.message; // 批改生效日期 反参为message字段  返回的是该保单的起保日期
                                $scope.endorseQueryDto.riskCode = data.content.riskCode;
                                $scope.endorseQueryDto.printNo = data.content.printNo;
                                $scope.check.policyNo="";

                            } else {
                                $scope.check.policyNo="保单号系统中不存在，请修改！";
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            };

            //$scope.insureName="";
            //$scope.changSave=function(insureName){
            //    $scope.insureName=insureName;
            //}

            $scope.stateToNext=function(){
                var reg=/^\d+$/;
                if(!reg.test($scope.endorseQueryDto.policyNo)){
                    layerMsg('保单号码格式错误，请修改！');
                    return
                }else if($scope.endorseQueryDto.policyNo.length<15){
                    layerMsg('保单号码需输入至少15位数！');
                    return
                }
                if(!$scope.endorseQueryDto.applyDate){
                    layerMsg('请先输入批改日期');
                    $scope.endorseQueryDto.policyNo = "";
                    return
                }
                if(!$scope.prpPheadDto.endorseType){
                    layerMsg('请先输入批改方式');
                    $scope.prpPheadDto.endorseType = "";
                    return
                }
                if($scope.prpPheadDto.endorseType=="02"){
                    if(!$scope.prpPheadDto.endorseMessage || $scope.prpPheadDto.endorseMessage==""
                        || $scope.prpPheadDto.endorseMessage==null){
                        layerMsg('请先输入批改原因');
                        $scope.prpPheadDto.endorseMessage = "";
                        return
                    }
                }
                $$finder.find('queryCommonEndorse', // 查询保单信息
                    {
                        policyNo: $scope.endorseQueryDto.policyNo,
                        validDate: $scope.endorseQueryDto.applyDate // 批改申请日期查询保单信息时为 validDate
                    }, {
                        success: function (data) {
                            if (data.code === "0000") {
                              //  $scope.endorseQueryDto.appliname = data.content.insuredName;
                                $scope.endorseQueryDto.validDate = data.content.message; // 批改生效日期 反参为message字段  返回的是该保单的起保日期
                                $scope.endorseQueryDto.riskCode = data.content.riskCode;
                                $scope.endorseQueryDto.printNo = data.content.printNo;
                                $scope.check.policyNo="";

                            } else {
                                $scope.check.policyNo="保单号系统中不存在，请修改！";
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                $$finder.find('checkEndorse', // 调用后端接口校验是否可进入批改；
                    {
                        policyNo:$scope.endorseQueryDto.policyNo,
                        strValidDate:$scope.endorseDate1, // 批改生效日期 validDate校验时入参为 strValidDate
                        loginComCode: $scope.user.loginComCode,
                        logingradeCodes: '111',
                        userCode: $scope.user.userCode
                    }, {
                    success: function (data) {
                        if(commonApiServ.compareFullDate($scope.endorseQueryDto.applyDate,$scope.endorseDate1)==1){
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '批改生效日期不可早于批改日期，请修改！',
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            return false;
                        }else if(commonApiServ.compareFullDate($scope.endorseQueryDto.validDate,$scope.endorseDate1)==1){
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '批改生效日期不可早于起保日期，请修改！',
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            return false;
                        }else{
                            if(data.code === "0000"){
                                $rootScope.temporaryDto={
                                    "endorseQueryDto":$scope.endorseQueryDto,
                                    'endorseDate1':$scope.endorseDate1,
                                    'prpPheadDto':$scope.prpPheadDto
                                }
                                $rootScope.temporaryDtoFlag=false;
                                if(!$scope.endorseQueryDto.printNo){
                                    layer.open({
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: "请先进行打印！",
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                    return
                                }
                                // 提交后跳转
                                $("html,body").css({overflow:"auto"});//出现滚动条
                                $state.go('UIEndorse3107edit', {validDate:$scope.endorseDate1,editType:'init',policyNo:$scope.endorseQueryDto.policyNo,bizType:'ENDORSE_TYPE',applyDate:$scope.endorseQueryDto.applyDate,endorseType:$scope.prpPheadDto.endorseType,endorseMessage:$scope.prpPheadDto.endorseMessage,appliName:$scope.endorseQueryDto.appliname})
                            } else {
                                layerMsg(data.message);
                            }
                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });



            }
            Window.prototype.layerMsg = function(data,target){
                // var icon = target == 'success'?"1":target == 'error'?"2":"0";
                layer.open({
                    offset: ['30%', '40%'],
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    content: data,
                    btn: ['确定'],
                    btn1: function (index) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });

            };

            //返回
            $scope.return=function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('dashboard')
            }
            // $scope.addCustomer = function(){
            //     $scope.showAddCustomer = true;
            // };
            // //关闭新增客户页面
            // $scope.closeAddCustomer = function(){
            //     $scope.showAddCustomer = false;
            // };
            // //新增客户页面中个人按钮的样式切换
            // $scope.show=true;
            // $scope.organizationBtn = function(){
            //     $scope.show=!$scope.show;
            // };
            // //投保人展开按钮的切换
            // $scope.tabBtn = true;
            // $scope.tabBtnChange = function(){
            //     $scope.tabBtn = !$scope.tabBtn;
            // };
            // //被保险人展开按钮的切换
            // $scope.tabBtn1 = true;
            // $scope.tabBtnChangeOne = function(){
            //     $scope.tabBtn1 = !$scope.tabBtn1;
            // };
            // //发票信息展开按钮的切换
            // $scope.tabBtn2 = true;
            // $scope.tabBtnChangeTwo = function(){
            //     $scope.tabBtn2 = !$scope.tabBtn2;
            // };
            // //性别男的按钮样式切换
            // $scope.boyBtn = true;
            // $scope.boyBtnChange = function(){
            //     if($scope.boyBtn){
            //         $scope.boyBtn = $scope.boyBtn;
            //     }else{
            //         $scope.boyBtn = !$scope.boyBtn;
            //         $scope.girlBtn = !$scope.girlBtn;
            //     }
            // };
            // //性别女的按钮样式切换
            // $scope.girlBtn = true;
            // $scope.girlBtnChange = function(){
            //     $scope.girlBtn = !$scope.girlBtn;
            //     $scope.boyBtn = !$scope.boyBtn;
            // };
        }]);
});