/**
 * Created by Jarvis on 2018/1/16.
 */
define(['app','layer','constants'],function (app) {
    'use strict';
    app.registerController('regionalSettingCtrl',['$rootScope','$scope','$location','$$finder','regexpConstants','$state','$stateParams',
        function ($rootScope,$scope,$location,$$finder,regexpConstants,$state,$stateParams) {

            $scope.regData = regexpConstants;
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
        /**
         * 获取人员姓名
         */
        $scope.personnelName = function () {

            var target = {
                "comCode":$scope.regional.handleDept || '',
                "codeType":"StaffNameCode"
            };
            // 接口请求
            $$finder.post("initSelectClaim",target).then(
                function (data) {
                    if(data){
                        $scope.PersonnelName = data.codeData;
                        // $scope.showSearch = true;//区域查询默认显示
                    }
                }
            );
        };

        /**
         * 班表机构改变调用
         */
        $scope.staffInDuty = function () {
            $scope.guardian();
        };

        /**
         * 被维护人查询
         */
        $scope.guardian = function () {
            var target = {

                "codeType":"CertaJobCode",
                "comCode":$scope.regional.handleDept || ''

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
         *
         * @param data
         */
        $scope.tableClassShow = function (handleDept,handlerCode) {
            //把handleDept和handlerCode传过去
            var keyword = {};
            prplAreaSettingDtoHandlercode=handlerCode;
            prplAreaSettingDtoHandleDept=handleDept;
            $scope.jumpAddregional(keyword);
        };

        /**
         * 添加
         */
        $scope.addRegionalPerson = function () {
            var savePrplAreaSetting = {
                "id": "",
                "handlerCode": "",
                "handCode":"",
                "handleDept": $scope.regional.handleDept,
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
                "prplAreaSettingDtoHandlercode": "",
                "prplAreaSettingDtoHandleDept": ""
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
         * 区域新增
         */
        $scope.addRegional = function () {
            //新增初始化
            prplAreaSettingDtoHandlercode="";
            prplAreaSettingDtoHandleDept="";
            if($scope.regional.handleDept==''){
                layerMsg("请选择区域机构！");
                return false;
            }
            var keyword = {};
            $scope.savePrplAreaSetting = [
                {
                    "id": "",
                    "handlerCode": "",
                    "handleDept": $scope.regional.handleDept,
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
                    "prplAreaSettingDtoHandlercode": "",
                    "prplAreaSettingDtoHandleDept": ""
                }
            ];
            $scope.jumpAddregional(keyword);
        };
            /**
             * 页面跳转
             */
            $scope.jumpAddregional = function (keyword) {
                keyword.handleDept = $scope.regional.handleDept || "";//班表机构
                keyword.prplAreaSettingDtoHandlercode=prplAreaSettingDtoHandlercode;
                keyword.prplAreaSettingDtoHandleDept=prplAreaSettingDtoHandleDept;
                $state.go('regionalSettingAdd', {regionalAdd: JSON.stringify(keyword)});
            };

        var initPage = function(){
            $scope.paginationConf = {
                currentPage : 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage : 5, // 每页展示的数据条数
                perPageOptions : [5, 10, 20, 30, 40,50 ],
                onChange : function () {//值回调
                    $scope.searchRegional();
                }
            };
        };
        initPage();

        /**
         * 区域查询
         */
        $scope.searchRegional = function () {

            if($scope.regional.handleDept==''){
                layerMsg("请选择区域机构！");
                return false;
            }

            $scope.regional.pageNo = $scope.paginationConf.currentPage;
            $scope.regional.pageSize = $scope.paginationConf.itemsPerPage;

            var target = $scope.regional;
            // 接口请求
            $$finder.post("queryPrplAreaSettingByCondition",target).then(
                function (data) {
                    if(data){
                        $scope.regionalList = data.content;
                        $scope.totalItems= data.totalCount;
                        $scope.paginationConf.totalItems=$scope.totalItems;
                        $scope.showSearch = true;//区域查询默认显示
                    }
                }
            );

        };

        var initPage = function(){
            $scope.paginationConf = {
                currentPage : 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage : 10, // 每页展示的数据条数
                perPageOptions : [5, 10, 20, 30, 40,50 ],
                onChange : function () {//值回调
                    $scope.searchRegional();
                }
            };
        };

        /**
         * 初始化
         */
        var init = function () {
            initPage();
            $scope.regional = {
                "handleDept":$scope.user.loginComCode || "",//班表机构
                "handlerCode":"",//被维护人
                "classCode":"99",//险种
                "pageNo":$scope.paginationConf.currentPage || '',
                "pageSize":$scope.paginationConf.itemsPerPage || ''
            };
            $scope.savePrplAreaSetting = [
                {
                    "id": "",
                    "handlerCode": "",
                    "handleDept": $scope.regional.handleDept,
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
                    "prplAreaSettingDtoHandlercode": "",
                    "prplAreaSettingDtoHandleDept": ""
                }
            ];




            //班表机构
            $$finder.post("initSelectClaim",
                {
                    "codeType": "JobComCode",
                    "comCode":$scope.user.loginComCode || "01000000"//班表机构
                }).then(
                function (data) {
                    if(data){
                        // console.log(data.codeData[0].codeCode);
                        $scope.Deptname = data.codeData[0].selectClaimList;
                        $scope.regional.handleDept = $scope.Deptname[0].codeCode;
                        $scope.guardian();
                    }

                }
            );

        };

        init();
    }]);
});