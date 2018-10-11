/**
 * DESC       : 国元农险理赔工作流管理---工作流模板路径编辑弹层
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017/12/18
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriWorkFlowTemplatePathModelCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','FormFocus','regexpConstants',
        function ($rootScope, $scope, $location,$state, $$finder, FormFocus,regexpConstants) {
            $scope.checkTemplatePathFlag = false;
            var editType;
            var $$index;
            $scope.$on("SendTemplatePathLayerSwitch",function (event,data) {
                editType =null;
                $$index = null;
                $$index = data.index;
                editType = data.type;
                $scope.regData = regexpConstants; // 本页面使用正则的集合
                if(editType == "modify"){
                    for(var key in $scope.SwfpathList[$$index]){
                        $scope.layerDto[key] = $scope.SwfpathList[$$index][key]
                    }
                    console.log($scope.layerDto)
                }
                if(editType === "add"){
                    $scope.layerDto.pathNo = $scope.SwfpathList.length>0?($scope.SwfpathList[$scope.SwfpathList.length-1].pathNo+1):1;
                }
                $scope.checkTemplatePathFlag = !$scope.checkTemplatePathFlag; // 弹层显示隐藏
            });
            $scope.close = function () {
                $scope.checkTemplatePathFlag = false;
                $scope.layerDto = {};
                $scope.workFlowPathForm.$setPristine();

                console.log($scope.workFlowPathForm);
            };
            $scope.confim = function () {
                if(!$scope.layerDto.pathName){
                    layerMsg("请输入路径名称！");
                    return false;
                }
                if(!$scope.layerDto.startNodeNo){
                    layerMsg("请选择起始节点！");
                    return false;
                }
                if(!$scope.layerDto.endNodeNo){
                    layerMsg("请选择终止节点！");
                    return false;
                }
                if(!$scope.layerDto.priority){
                    layerMsg("请录入优先级！");
                    return false;
                }
                if(!$scope.layerDto.defaultFlag){
                    layerMsg("请选择缺省路径！");
                    return false;
                }
                if ($scope.workFlowPathForm.$valid) {
                    angular.forEach($scope.SwfNodeList, function (item) {
                        if($scope.layerDto.startNodeNo === item.nodeNo){
                            $scope.layerDto.startNodeName = item.nodeName;
                        }
                        if($scope.layerDto.endNodeNo === item.nodeNo){
                            $scope.layerDto.endNodeName = item.nodeName;
                        }
                    });
                    if(editType === "add"){
                        $scope.SwfpathList.push($scope.layerDto);
                    } else if(editType === "modify"){
                        for(var key in $scope.layerDto){
                            $scope.SwfpathList[$$index][key] = $scope.layerDto[key]
                        }
                    }
                    $scope.close();
                } else {
                    FormFocus.focusEle('workFlowPathForm')
                }

            }
        }]);
});