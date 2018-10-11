/**
 * DESC       : 国元农险理赔工作流管理新建页面
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
    app.registerController('UIAgriWorkFlowNewCtrl', ['$rootScope', '$scope', '$location', '$$finder', '$stateParams', 'FormFocus', '$filter', 'regexpConstants', '$state',
        function ($rootScope, $scope, $location, $$finder, $stateParams, FormFocus, $filter, regexpConstants, $state) {
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.integer = regexpConstants.integer;
            $scope.workFlow = {
                swfModelMainDto: {},
                swfNodeDtoList: [],
                swfPathDtoList: []
            };
            $scope.SwfNodeList = $scope.workFlow.swfNodeDtoList; // 节点信息
            $scope.SwfpathList = $scope.workFlow.swfPathDtoList; // 路径信息
            $scope.prpLregist = null; // 查询结果
            $scope.regData = regexpConstants; // 本页面使用正则的集合

            var type = $stateParams.type;
            var model = {
                "modelNo": $stateParams.item
            };
            // $scope.modelNo = $stateParams.modelNo; // 模板编号
            $scope.layerDto = {};

            $scope.openTemplatePathLayer = function (index) { // 点击编辑
                // $scope.layerDto = item;
                $scope.$broadcast("SendTemplatePathLayerSwitch", {type: 'modify', index: index})
            };
            /***********************************/
            // $scope.workFlow.swfModelMainDto = {
            //     modelNo:1222,
            //     modifyDate:"1513612800000",
            //     createDate:"1513612800000"
            // }
            // $scope.workFlow.swfModelMainDto.modifyDate = $filter("date")($scope.workFlow.swfModelMainDto.modifyDate,"yyyy-MM-dd");
            // $scope.workFlow.swfModelMainDto.createDate = $filter("date")($scope.workFlow.swfModelMainDto.createDate,"yyyy-MM-dd");
            /***************************************/
            // 保存模板信息
            $scope.save = function () {
                if(!$scope.workFlow.swfModelMainDto.modelName){
                    layerMsg("请录入模板名称！");
                    return false;
                }
                if(!$scope.workFlow.swfModelMainDto.modelStatus){
                    layerMsg("请录入模板状态！");
                    return false;
                }
                if ($scope.workFlowNewForm.$valid) {
                    angular.forEach($scope.workFlow.swfPathDtoList, function (item) {
                        if(!item.nodeName){
                            layerMsg("请录入节点名称！");
                            return false;
                        }
                        /*if(!item.nodeType){
                            layerMsg("请录入节点类型！");
                            return false;
                        }*/
                        item.modelNo = $scope.workFlow.swfModelMainDto.modelNo;
                        item.modelName = $scope.workFlow.swfModelMainDto.modelName;
                    });
                    angular.forEach($scope.workFlow.swfNodeDtoList, function (item) {
                        item.modelNo = $scope.workFlow.swfModelMainDto.modelNo;
                        item.modelName = $scope.workFlow.swfModelMainDto.modelName;
                    });
                    /***************************/
                    // var dto=$scope.workFlow;
                    // console.log(dto);
                    var dto = angular.copy($scope.workFlow);
                    dto.swfModelMainDto.authorCode
                    dto.swfModelMainDto.modifyDate = new Date(dto.swfModelMainDto.modifyDate.substring(0, 19).replace(/-/g, '/')).getTime();
                    dto.swfModelMainDto.createDate = new Date(dto.swfModelMainDto.createDate.substring(0, 19).replace(/-/g, '/')).getTime();
                    console.log(dto);
                    if ($scope.workFlow.swfPathDtoList.length > 0) {
                        $$finder.post('saveWorkFlowModelInfo', dto).then(
                            function (data) {
                                console.log("保存");
                                console.log(data);
                                //layerMsg("保存新创建的模板成功！");
                                layerMsg(data.message);
                                $state.go('UIAgriWorkFlowQuery');
                            }
                        )
                    }else{
                        layerMsg("请录入路径信息！");
                    }
                    /***************************/
                } else {
                    layerMsg("请录入节点信息！");
                    FormFocus.focusEle('workFlowNewForm')
                }
            };
            // 初始化
            if (type === "EDIT") { // 修改模板信息
                console.log("修改模板信息");
                $scope.SwfNodeList.push({});
                console.log(model);
                $$finder.post('modifyWorkFlowModelInfo', model).then(
                    function (data) {
                        console.log("初始化");
                        console.log(data);
                        //$scope.workFlow.swfModelMainDto.modelNo = data.swfModelMainDto.modelNo;
                        $scope.workFlow = data;
                        $scope.workFlow.swfModelMainDto.modifyDate = $filter("date")(data.swfModelMainDto.modifyDate, "yyyy-MM-dd");
                        $scope.workFlow.swfModelMainDto.createDate = $filter("date")(data.swfModelMainDto.createDate, "yyyy-MM-dd");
                        $scope.SwfNodeList = $scope.workFlow.swfNodeDtoList; // 节点信息
                        $scope.SwfpathList = $scope.workFlow.swfPathDtoList; // 路径信息
                        $scope.prpLregist = null; // 查询结果
                        // $scope.querySwfModelList = data.content;
                        // $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            } else if (type === "NEW") { //新建模板信息
                console.log("新建模板信息");
                $scope.SwfNodeList.push({});
                $$finder.post('initWorkFlowModel', {}).then(
                    function (data) {
                        console.log("初始化");
                        console.log(data);
                        $scope.workFlow.swfModelMainDto.modelNo = data.swfModelMainDto.modelNo;
                        $scope.workFlow.swfModelMainDto.modifyDate = $filter("date")(data.swfModelMainDto.modifyDate, "yyyy-MM-dd");
                        $scope.workFlow.swfModelMainDto.createDate = $filter("date")(data.swfModelMainDto.createDate, "yyyy-MM-dd");
                        // $scope.querySwfModelList = data.content;
                        // $scope.paginationConf.totalItems = data.totalCount;
                    }
                )
            }


            // 路径信息
            // $scope.SwfpathList =[];
            // $scope.result = {};

            // 路径信息添加
            $scope.addSwfpath = function (type) {
                $scope.layerDto = {};
                $scope.$broadcast("SendTemplatePathLayerSwitch", {type: type})
            };
            // 路径信息编辑
            $scope.editSwfpath = function (type, $index) {
                $scope.$broadcast("SendTemplatePathLayerSwitch", {type: type, index: $index});
            };
            //路径信息删除一行
            $scope.del = function ($index) {
                $scope.SwfpathList.splice($index, 1);
            };

            // 节点信息
            // $scope.SwfNodeList =[];
            // 节点信息添加
            $scope.addSwfNode = function () {
                // $scope.layerDto = {};
                $scope.SwfNodeList.push({});
                $scope.SwfNodeList.nodeNo =
                    $scope.SwfNodeList.length>0?($scope.SwfNodeList[$scope.SwfNodeList.length-1].nodeNo+1):1;
                // $scope.$broadcast("SendTemplatePathLayerSwitch",{type: 'add'})
                console.log($scope.SwfNodeList.length);
                // $scope.SwfNodeList.nodeno = $scope.SwfNodeList.length>0?($scope.SwfNodeList[$scope.SwfNodeList.length-1].nodeno+1):1;

                console.log("以下是节点信息========")
                console.log($scope.workFlow.swfNodeDtoList)
            };
            //节点信息删除一行
            $scope.delete = function ($index) {
                // if($scope.SwfNodeList.length ==1){
                //     return false;
                // }
                if ($index === 0) {
                    layerMsg("第一个节点不能删除!");
                    return false;
                }
                $scope.SwfNodeList.splice($index, 1);
            };
            //放弃按钮事件
            $scope.reset = function () {
                $scope.workFlow = {
                    swfModelMainDto: {
                        modelNo:$scope.workFlow.swfModelMainDto.modelNo,
                        createDate:$scope.workFlow.swfModelMainDto.createDate,
                        modifyDate:$scope.workFlow.swfModelMainDto.modifyDate
                    },
                    swfNodeDtoList: [],
                    swfPathDtoList: []
                };
                $scope.workFlowNewForm.$setPristine();
            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $state.go('UIAgriWorkFlowQuery');
            };
        }]);
});