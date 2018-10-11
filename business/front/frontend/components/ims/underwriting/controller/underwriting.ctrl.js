/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwritingCtrlHandler =    function ($scope,$state, underwritingServ) {

        //-----ui-tree------

        //开关触发器
        $scope.toggleNode = function (scope,node) {
            if(node.nodes && node.collapsed && node.nodes.length == 0){
                $scope.getCompanyTree(node);
                scope.toggle();
            }
            node.collapsed = !node.collapsed;
            scope.toggle();
        };

        //折叠所有节点
        $scope.collapseAll = function () {
            $scope.$broadcast('angular-ui-tree:collapse-all');
        };
        //打开所有节点
        $scope.expandAll = function () {
            $scope.$broadcast('angular-ui-tree:expand-all');
        };

        //当checked发生变化 执行本方法
        $scope.changeNode = function (node, parent, parentNode) {
            $scope.copyData = [];
            changeChildrenNodeStatus(node);
            checkBrotherNodeStatus(parentNode);
            getCheckedData($scope.data);

        };
        //改变兄弟级的状态
        function changeChildrenNodeStatus(node) {
            angular.forEach(node.nodes, function (childrenNode) {
                childrenNode.checked = node.checked;
                $scope.nodeData = childrenNode.title;
                //如果还有子集
                if (childrenNode.nodes && childrenNode.nodes.length > 0) {
                    changeChildrenNodeStatus(childrenNode);
                }
            })
        }

        //获取选中的节点
        function getCheckedData(data) {
            angular.forEach(data, function (childData) {
                if (childData.checked) {
                    var PrpDCompanyDto={};
                    PrpDCompanyDto.comCode = childData.comCode;
                    PrpDCompanyDto.upperComCode = childData.upperComCode;
                    $scope.copyData.push(PrpDCompanyDto)
                }
                if (childData.nodes && childData.nodes.length > 0) {
                    getCheckedData(childData.nodes);
                }
            })
        }

        //检查兄弟级的状态
        function checkBrotherNodeStatus(nodeScope) {
            //判断是否到达了顶级
            if (!nodeScope) {
                return false;
            }
            //父节点的值
            var parentNodeValue = nodeScope.$modelValue;
            //父节点上次的状态
            var lastStatus = parentNodeValue.checked;

            var checkedAll = true;

            angular.forEach(parentNodeValue.nodes, function (brotherNode) {
                if (!brotherNode.checked) {
                    checkedAll = false;
                    return false
                }
            });
            parentNodeValue.checked = checkedAll;

            if (lastStatus == parentNodeValue.checked) {
            } else {
                //如果状态改变了，则要继续向上延伸
                if (parentNodeValue.checked) {
                } else {
                }
                checkBrotherNodeStatus(nodeScope.$parentNodeScope);
            }

        }
        //-----ui-tree end------
        $scope.underwritingSucLayer = true;
        $scope.underwritingFailLayer = true;
        $scope.underwritingTree = true;

        $scope.PowerConditionDto = {"taskId":"B000000000000000002"};
        // 获取机构树
        $scope.getCompanyTree = function (node){
            if($scope.PowerConditionDto.userCode ==""||$scope.PowerConditionDto.userCode ==null){
                angular.alert("登录账号不允许为空！");
                return;
            }
            var powerConditionDto = {};
            powerConditionDto.userCode = $scope.PowerConditionDto.userCode;
            powerConditionDto.taskId = $scope.PowerConditionDto.taskId;
            if(node ){
                powerConditionDto.comCode = node.comCode;
                powerConditionDto.checked = node.checked;
            }
            underwritingServ.getCompanyTree( powerConditionDto).then(
                function(answer){
                    if(node){
                        node.nodes = answer.data[0].nodes;
                    }else{
                        $scope.data = answer.data;
                    }
                    if($scope.data){
                        $scope.underwritingTree=false;
                    }else{
                        $scope.underwritingTree=true;
                    }
                },function(error){
                    $scope.message = "系统异常，请联系管理员";
                    //angular.alert("系统异常，请联系管理员！");
                    //暂时隐藏
                    /*$scope.underwritingFailLayer=false;*/
                }
            );
        };
        // 配置用户允许机构
        $scope.configUserPermitCompany = function () {
            $scope.PowerConditionDto.companyList=$scope.copyData;
            underwritingServ.configUserPermitCompany( $scope.PowerConditionDto).then(
                function(answer){
                   $scope.underwritingSucLayer=false;
                },function(error){
                    $scope.message = "系统异常，请联系管理员";
                    //$scope.underwritingFailLayer=false;
                }
            );
        };
        /*退出首页*/
        $scope.editClick = function(){
            $state.go("main.index")
        };
        // 关闭弹层
        $scope.underwritingClose = function(){
            $scope.underwritingSucLayer = true;
            $scope.underwritingFailLayer = true;
            $scope.underwritingNullFailLayer = true;
            $scope.underwritingTree = true;
            $scope.PowerConditionDto.userCode = "";
        };
    };
    moduleApp.controller('underwritingCtrl',['$scope','$state','underwritingServ',underwritingCtrlHandler]);
});
