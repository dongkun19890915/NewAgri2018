/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityInformCtrl = function ($scope,communityInformServ,$state,$stateParams,FormFocus) {
       /*修改标志*/
        var modifyFlag = false;
        /*加载上级机构*/
        var queryUpperCompany = function(UserDto,comCode){
            communityInformServ.queryUpperCompany(UserDto).then(
                function(answer){
                    if(comCode){
                        var comList = new Array();
                        answer.data.forEach(
                            function(company){
                                if(company.comCode !=comCode){
                                    comList.push(company);
                                }
                            }
                        );
                        $scope.upperCompanyList=comList;
                    }else{
                        $scope.upperCompanyList=answer.data;
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*机构保存*/
        var saveCompany = function(PrpDCompanyDto){
            /*禁用保存按钮*/
            $scope.saveDisableFlag=true;
            communityInformServ.saveCompany(PrpDCompanyDto).then(
                function(answer){
                    if(answer.data && answer.data.resultCode=="0000"){
                        //保存成功
                        $scope.communitySucLayer = false;
                        $scope.communityFailLayer = true;
                    }else{
                        $scope.communitySucLayer = true;
                        $scope.communityFailLayer = false;
                        $scope.message=answer.data.resultMsg?answer.data.resultMsg:"未知异常，请联系管理员！";
                        /*启用保存按钮*/
                        $scope.saveDisableFlag=true;
                    }
                },function(error){
                    //$scope.communitySucLayer = true;
                    //$scope.communityFailLayer = false;
                    $scope.message=JSON.stringify(error.data);
                    /*启用保存按钮*/
                    $scope.saveDisableFlag=true;
                }
            );
        };
        /*机构更新*/
        var updateCompany = function(PrpDCompanyDto){
            /*禁用保存按钮*/
            $scope.saveDisableFlag=true;
            communityInformServ.updateCompany(PrpDCompanyDto).then(
                function(answer){
                    if(answer.data.resultCode=="0000"){
                        //更新成功
                        $scope.communitySucLayer = false;
                        $scope.communityFailLayer = true;
                    }else{
                        $scope.communitySucLayer = true;
                        $scope.communityFailLayer = false;
                        $scope.message=answer.data.resultMsg?answer.data.resultMsg:"未知异常，请联系管理员！";
                        /*启用保存按钮*/
                        $scope.saveDisableFlag=true;
                    }
                },function(error){
                    //$scope.communitySucLayer = true;
                    //$scope.communityFailLayer = false;
                    $scope.message=JSON.stringify(error.data);
                    /*启用保存按钮*/
                    $scope.saveDisableFlag=true;
                }
            );
        };
        // 初始化上级机构代码
        var initUpperComCode = "";
        /*加载机构信息*/
        var loadCompany = function(CompanyConditionDto){
            communityInformServ.loadCompany(CompanyConditionDto).then(
                function(answer){
                    $scope.PrpDCompanyDto=answer.data;
                    // 保存初始化上级机构代码
                    initUpperComCode = $scope.PrpDCompanyDto.upperComCode;
                    if($scope.PrpDCompanyDto.isHeadOffice == "0"){
                        $scope.headClick1();
                    }else{
                        $scope.headClick();
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        // 是总公司
        $scope.headClick = function () {
            $scope.isHeadOfficeLeft = false;
            $scope.isHeadOfficeRight = false;
            $scope.PrpDCompanyDto.isHeadOffice="1";
            $scope.upperDisabled= true;
            // 清空upperComCode校验信息
            $("[name=upperComCode].validation-errorText").hide();
            $scope.PrpDCompanyDto.upperComCode =  "000000";
            $scope.changeIsHeadOffice='components/ims/community/tpl/communityIsHeadLayer.html';
        };
        //不是总公司
        $scope.headClick1 = function () {
            $scope.isHeadOfficeLeft = true;
            $scope.isHeadOfficeRight = true;
            $scope.upperDisabled = false;
            $scope.UserDto.isHeadOffice = false;
            $scope.PrpDCompanyDto.isHeadOffice="0";
            $scope.PrpDCompanyDto.upperComCode =  initUpperComCode;
            if(! modifyFlag){
                /*加载上级机构*/
                queryUpperCompany( $scope.UserDto );
                $scope.PrpDCompanyDto.upperComCode =  "";
            }

            $scope.changeIsHeadOffice='components/ims/community/tpl/communityNotHeadLayer.html';
        };

        /*点击确定*/
        $scope.save = function(){
            if(this.saveForm.$invalid){
                FormFocus.focusEle("saveForm");
                return;
            }
            var PrpDCompanyDto = $scope.PrpDCompanyDto;
            //当上级机构为空时，设置总公司
            PrpDCompanyDto.upperComCode = PrpDCompanyDto.upperComCode?PrpDCompanyDto.upperComCode:"000000";
            if(modifyFlag){//更新
                updateCompany(PrpDCompanyDto);
            }else{//新增
                saveCompany(PrpDCompanyDto);
            }
        };
        /*点击关闭弹层,禁用保存按钮*/
        $scope.communityClose = function(){
            $scope.communitySucLayer = true;
            $scope.communityFailLayer = true;
            $scope.saveDisableFlag=false;
        };
        /*点击关闭弹层，启用保存按钮*/
        $scope.communityClose1 = function(){
            $scope.communitySucLayer = true;
            $scope.communityFailLayer = true;
            $scope.saveDisableFlag=false;
        };
        /*点击退出*/
        $scope.exit = function(){
            $scope.communityExitLayer=false;
        };
        /*点击取消*/
        $scope.communityCancel = function(){
            $scope.communityExitLayer=true;
        };
        /*点击确认退出*/
        $scope.communityExit = function(){
            $state.go('main.community');
        };

        /*公共成功错误提示*/
        $scope.communitySucLayer = true;
        $scope.communityFailLayer = true;
        /*退出确认弹层*/
        $scope.communityExitLayer=true;
        /*readonly 是否只读*/
        $scope.comCodeReadonly=false;
        $scope.upperComCodeReadonly=false;
        $scope.readnoly = false;
        /*disabled 是否取消select*/
        $scope.upperDisabled = false;
        /*radio-是否是总公司成员*/
        $scope.isHeadOfficeLeft =false;
        $scope.isHeadOfficeRight =false;
        /*确定按钮是否禁用*/
        $scope.saveDisableFlag=false;

        //初始化界面
        $scope.PrpDCompanyDto = {};
        $scope.UserDto = {};
        var initFunc = function() {
            var comCode =  $stateParams.continueData;
            if(comCode){
                //修改页面，加载机构信息
                modifyFlag = true;
                //取消select
                $scope.upperDisabled = true;
                //只读
                $scope.readonly = true;
                $scope.upperComCodeReadonly=true;
                var CompanyConditionDto =   $scope.PrpDCompanyDto;
                /*加载上级机构*/
                queryUpperCompany( $scope.UserDto ,comCode);
                CompanyConditionDto.comCode = comCode;
                /*加载机构信息*/
                loadCompany(CompanyConditionDto);
                $scope.comCodeReadonly=true;

            }else{
                //新增默认不是总公司
                $scope.headClick1();
                //默认有效
                $scope.PrpDCompanyDto.validStatus = "1";
            }
        };
        initFunc();
    };

    moduleApp.controller('communityInformCtrl',['$scope','communityInformServ','$state','$stateParams','FormFocus',communityInformCtrl]);
});

