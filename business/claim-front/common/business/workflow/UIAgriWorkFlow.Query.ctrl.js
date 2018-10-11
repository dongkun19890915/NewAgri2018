/**
 * DESC       : 国元农险理赔工作流管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE : 2017-12-7
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer'
], function (app) {
    'use strict';
    app.registerController('UIAgriWorkFlowQueryCtrl', ['$rootScope', '$scope', '$location', '$state', '$$finder', 'FormFocus','regexpConstants','$filter',
        function ($rootScope, $scope, $location, $state, $$finder, FormFocus, regexpConstants, $filter) {
           //查询条件
            $scope.workFlowQueryDto = {
                modelNo: '',
                modelName: '',
                authorCode: '',
                createDate:'',
                modelStatus:''
            };
            $scope.querySwfModelList = null; //  查询结果列表 默认值为null
            // 本页面使用正则的集合
            $scope.regData = regexpConstants;

            var initPage = function () {
                $scope.paginationConf = {
                    currentPage: 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage: 20, // 每页展示的数据条数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();


            /*分页查询*/
            var getFileList = function () {
                var dto = angular.copy($scope.workFlowQueryDto);
                dto.pageNo = $scope.paginationConf.currentPage;
                dto.pageSize = $scope.paginationConf.itemsPerPage;
                //提交查询
                $$finder.post('querySwfModelMainByCondition', dto).then(
                    function (data) {
                        console.log(data);
                        $scope.querySwfModelList = data.content;
                        angular.forEach($scope.querySwfModelList,function (data) {
                            data.createDate= $filter('date')(data.createDate, 'yyyy-MM-dd');
                        });
                        $scope.paginationConf.totalItems = data.totalCount;
                    }
                )

            };

            $scope.query = function () {
                var flag = true;
                if($scope.workFlowQueryDto.modelNo == "" && $scope.workFlowQueryDto.modelName == "" &&
                    $scope.workFlowQueryDto.authorCode == "" && $scope.workFlowQueryDto.createDate == "" &&
                    ($scope.workFlowQueryDto.modelStatus+"") == "" ){
                    flag = false;
                }
                if(!flag){layerMsg("请至少输入一个查询条件！");return}
                if ($scope.workFlowQueryForm.$valid) {
                    getFileList();
                } else {
                    FormFocus.focusEle('workFlowQueryForm')
                }
            };
            // 新建模板
            $scope.build = function () {
                $state.go('UIAgriWorkFlowNew', {type: 'NEW'})
            };
            // 修改模板信息
            $scope.goEdit = function (item) {
                $state.go('UIAgriWorkFlowNew', {type: 'EDIT', item: item})
            };
            // 模板分配
            $scope.openDistributionLayer = function (msg1,msg2) {
                $scope.$broadcast("SendDistributionLayerSwitch", msg1,msg2);
            };

        }]);
});