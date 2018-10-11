/**
 * Created by Jarvis on 2018/1/16.
 */
define(['app','layer','constants'],function (app) {
    'use strict';
    app.registerController('regionalSettingAddCtrl',['$rootScope','$scope','$location','$$finder','regexpConstants','$stateParams','$state','FormFocus','$$commonality','$timeout',
        function ($rootScope,$scope,$location,$$finder,regexpConstants,$stateParams,$state,FormFocus,$$commonality,$timeout) {
            $scope.regData = regexpConstants;
        /**
         * 路由跳转
         */
        $scope.jumpWark = function () {
            $state.go('regionalSetting');
        };
        $scope.result={};
        var prplAreaSettingDtoHandlercode="";
        var prplAreaSettingDtoHandleDept="";
        $scope.check={};
        /**
         * 作业区域
         */
        $scope.areaCheck = function (index,areaCode) {
            $scope.savePrplAreaSetting[index].areaName = areaCode.codeName;
            $scope.savePrplAreaSetting[index].area = areaCode.codeCode;
        };
        //校验
        $scope.save=function(){
            //如果删除的时候一条数据都没有的话给他一条数据
            if(prplAreaSettingDtoHandleDept!=null &&prplAreaSettingDtoHandleDept!=undefined &&prplAreaSettingDtoHandleDept!=""&&$scope.savePrplAreaSetting.length==0){
                var result = {
                    "id": "",
                    "handlerCode": "",
                    "handleDept": "",
                    "handlerName": "",
                    "area": "",
                    "tel": "",
                    "operator": "",
                    "operatorId": "",
                    "flowinTime": "",
                    "modifyTime": "",
                    "classCode": "",
                    "remark": "",
                    "areaName": "",
                    "comCName": "",
                    "prplAreaSettingDtoHandlercode": prplAreaSettingDtoHandlercode,
                    "prplAreaSettingDtoHandleDept": prplAreaSettingDtoHandleDept
                };
                $scope.savePrplAreaSetting[0]=result;
                $scope.savePrplArea();
                return;
            }
            //删除的时候handleDept为空，保存的时候，修改的时候handleDept都不为空！

            var flag = false;
            angular.forEach($scope.savePrplAreaSetting, function(value) {
                if(value.handlerCode){
                    flag = true
                }
            });
            if(!flag){layerMsg("工号不能为空！");return}
            if(!$scope.regionalForm.$valid){
                FormFocus.focusEle('regionalForm');
            }
            if(!FormFocus.requiredVerify('#reginalAdd')){
                return
            }
            $scope.savePrplArea();
        }
        /**
         * 保存
         */
        $scope.savePrplArea = function () {
            console.log($scope.result.areaCode);
            //先遍历 再赋值
            angular.forEach($scope.savePrplAreaSetting, function(obj){
                $scope.areas="";
                if(obj.areaCode!=null &&obj.areaCode!="" &&obj.areaCode!=undefined){
                    //数组转为字符串
                    $scope.areas=obj.areaCode.join(";");
                }
                /*if(obj.area!=null&&obj.areaCode!="" &&obj.areaCode!=undefined){
                    obj.area=";"+$scope.areas;
                }else{
                    obj.area= $scope.areas;
                }*/
                obj.area= $scope.areas;
            });
            // 接口请求
            $$finder.post("batchSavePrplAreaSetting",$scope.savePrplAreaSetting).then(
                function (data) {
                    if(data){
                        layerMsg(data.message, function(){
                            $timeout(function () {  $state.go('regionalSetting');})
                        },{skin:'layer-success'});

                    }
                }
            );
        };
            /**
         * 校验查勘人
         */
        $scope.personCheck = function (index,hander) {
            $scope.savePrplAreaSetting[index].handlerName = hander.codeName;
            $scope.savePrplAreaSetting[index].handlerCode = hander.codeCode;
            var target = {
                "handleDept":$scope.handleDept || '',
                "handlerCode":hander.codeCode,
                "classCode":"99"
            };
            $$finder.post("checkPrplAreaSettingByHandlerCode",target).then(
                function (data) {
                    if(data){
                        if(data.message){
                            layerMsg(data.message+"已添加作业区域");
                            $scope.savePrplAreaSetting[index].handlerName="";
                            $scope.savePrplAreaSetting[index].handCode="";
                            $scope.savePrplAreaSetting[index].handlerCode="";
                        }
                    }
                }
            );

        };
        /**
         * 作业区域查询
         */
        $scope.checkBox=[];
        $scope.areaOperation = function () {

            var target = {
                "comCode":$scope.handleDept || '',
                "codeType":"AreaCode"
            };
            // 接口请求
            $$finder.post("initSelectClaim",target).then(
                function (data) {
                    if(data){
                         $scope.checkBox = data.codeData;
                        // $scope.showSearch = true;//区域查询默认显示
                    }
                }
            );
        };
        /**
         * 显示姓名
         */
        $scope.showhandName = function (index,target) {
            $scope.savePrplAreaSetting[index].handlerName =  target;
        };


        /**
         * 被维护人查询
         */
        $scope.guardian = function () {
            var target = {

                "codeType":"CertaJobCode",
                "comCode":$scope.handleDept || ''

            };


            // 接口请求
            $$finder.post("initSelectClaim",target).then(
                function (data) {
                    if(data){
                        $scope.HandlerName = data.codeData;
                        console.log("$scope.HandlerName");
                        console.log($scope.HandlerName);
                    }
                }
            );
        };



        /**
         * 添加
         */
        $scope.addRegionalPerson = function () {
            $scope.flag=false;
            var savePrplAreaSetting = {
                "id": "",
                "handlerCode": "",
                "handCode":"",
                "handleDept": $scope.handleDept,
                "handlerName": "",
                "area": "",
                "tel": "",
                "operator": "",
                "operatorId": "",
                "flowinTime": "",
                "modifyTime": "",
                "classCode": "",
                "remark": "",
                "areaName": "",
                "comCName": "",
                "prplAreaSettingDtoHandlercode": prplAreaSettingDtoHandlercode,
                "prplAreaSettingDtoHandleDept": prplAreaSettingDtoHandleDept
            };
            $scope.savePrplAreaSetting.push(savePrplAreaSetting);
        };

        /**
         * 删除
         */

        $scope.delRegionalPerson = function (index) {
            if($scope.savePrplAreaSetting.length!=0){
                if($scope.savePrplAreaSetting[index].prplAreaSettingDtoHandleDept!=null){
                    prplAreaSettingDtoHandlercode=$scope.savePrplAreaSetting[index].prplAreaSettingDtoHandlercode;
                    prplAreaSettingDtoHandleDept=$scope.savePrplAreaSetting[index].prplAreaSettingDtoHandleDept;
                }
                $scope.savePrplAreaSetting.splice(index,1);
            }
        };
            /**
         * 初始化
         */
        var init = function () {
             $scope.flag=false;
            var proposalObj;
            //获取路由参数信息
            console.log($stateParams.regionalAdd);
            if($stateParams.regionalAdd){
                proposalObj = JSON.parse($stateParams.regionalAdd);
                $scope.handleDept = proposalObj.handleDept;
                prplAreaSettingDtoHandlercode=proposalObj.prplAreaSettingDtoHandlercode;
                prplAreaSettingDtoHandleDept=proposalObj.prplAreaSettingDtoHandleDept;
            }
            $scope.guardian();
            $scope.areaOperation();
            if(prplAreaSettingDtoHandleDept!=null &&prplAreaSettingDtoHandleDept!=undefined &&prplAreaSettingDtoHandleDept!=""){
                $scope.flag=true;
                var target = {
                    "handleDept":"",
                    "classCode":"99",
                    "handlerCode":""
                };
                target.handleDept = prplAreaSettingDtoHandleDept || "";
                target.handlerCode = prplAreaSettingDtoHandlercode ||  "";
                $scope.flag=true;
                // 接口请求
                $$finder.post("queryPrplAreaSettingByHandleDeptAndHandlerCode",target).then(
                    function (data) {
                        if(data){
                            angular.forEach(data, function(obj){
                                obj.prplAreaSettingDtoHandlercode=prplAreaSettingDtoHandlercode ||"";
                                if(obj.area!=null&&obj.area!=""&&obj.area!=undefined){
                                    //把字符串转化为数组","分割
                                    obj.areaCode=obj.area.split(";");
                                }
                                obj.prplAreaSettingDtoHandleDept=prplAreaSettingDtoHandleDept||"";
                            });
                            $scope.savePrplAreaSetting = data;
                        }
                    }

                );
            }
            $scope.savePrplAreaSetting = [
                {
                    "id": "",
                    "handlerCode": "",
                    "areaCode":[],
                    "handleDept": $scope.handleDept,
                    "handlerName": "",
                    "area": "",
                    "tel": "",
                    "operator": "",
                    "operatorId": "",
                    "flowinTime": "",
                    "modifyTime": "",
                    "classCode": "",
                    "remark": "",
                    "areaName": "",
                    "comCName": "",
                    "prplAreaSettingDtoHandlercode": prplAreaSettingDtoHandlercode,
                    "prplAreaSettingDtoHandleDept": prplAreaSettingDtoHandleDept
                }
            ];

        };
        init();

    }]);
});