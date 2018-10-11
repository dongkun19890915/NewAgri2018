/**
 * DESC       : 国元农险理赔班表管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.29
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                      班表管理页面控制器搭建
 */
define([
    'app',
    'codes',
    'constants',
    'layer'
], function (app,codes) {
    'use strict';
    app.registerController('UIAgriQueryScheduleCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$filter','$stateParams','$$commonality',
        function ($rootScope, $scope, $location, $state, $$finder,$filter,$stateParams,$$commonality) {

            /**
             * 返回
             */
            $scope.backDispatch = function () {
                $state.go('UIAgriDispatchEdit');
            };

            /**
             * 页面跳转匹配
             */
            $scope.regionalAdd = function (queryType,viewType) {
                var keyword = {};
                keyword.queryType = queryType;
                keyword.viewType = viewType;
                $scope.jumpShow(keyword);
            };

            /**
             * 页面跳转
             */
            $scope.jumpShow = function (keyword) {
                keyword.handlername = $scope.jobManagerDto.handlername || "";//当班人员
                keyword.handleDept = $scope.jobManagerDto.deptname || "";//班表机构
                keyword.classCode = $scope.jobManagerDto.classCode || "99";
                keyword.month = $scope.jobManagerDto.month || keyword.month;
                keyword.Handlername = $scope.Handlername || [];
                $state.go('UIAgriScheduleAdd', {scheduleAdd: JSON.stringify(keyword)});
            };

            /**
             * 班表主列表查询
             */
            $scope.goScheduleShow = function (target) {

                //判断查询条件是否为空校验
               // var querySpecialflag = $$commonality.inspectEmpty('myForm');
                //循环遍历表单下节点
                // for(var i=0;i<document.myForm.elements.length-1;i++)
                // {
                //     if(document.myForm.elements[i].value!=""&&document.myForm.elements[i].value!="?"&&document.myForm.elements[i].value!="0")
                //     {
                //         querySpecialflag = true;
                //     }
                // }
                // if($scope.endorse.businessType1||$scope.endorse.underWriteFlag){
                //     querySpecialflag = true;
                // }
                //querySpecialflag为false判断无填写查询条件
               // if (!querySpecialflag){
               //     layerMsg("请至少输入一项查询条件！");
                 //   return false;
              //  }
                // if(!($scope.jobManagerDto.classCode||$scope.jobManagerDto.handleDept||$scope.jobManagerDto.time1||$scope.jobManagerDto.time2)){
                //     layerMsg("请至少输入一项查询a3条件！");
                //     return false;
                // }

                // 接口请求
                $$finder.post("queryDispatcherPrpLJobManagerByCondition",$scope.jobManagerDto).then(
                    function (data) {
                       //debugger;
                        if(data){
                            $scope.paginationConf.totalItems = data.totalCount;
                            $scope.dispatchList = data.content;
                            $scope.jobManagerDto.pageNo=$scope.paginationConf.currentPage ;
                            $scope.jobManagerDto.pageSize=$scope.paginationConf.itemsPerPage;
                            $scope.queryRegional = true;
                        }

                    }
                )
            };




            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 5, // 每页展示的数据条数
                    perPageOptions : [5, 10, 20 ],
                    onChange : function () {//值回调
                        //debugger;
                        $scope.goScheduleShow();
                    }
                };
            };
            initPage();


            /**
             * 当班人员
             */
          /*  $scope.staffInDuty = function () {
                var target = {
                    "handleDept": $scope.jobManagerDto.deptname,
                    "month": $scope.jobManagerDto.month,
                    "classCode": $scope.jobManagerDto.classCode
                };

                // 接口请求
                $$finder.post("queryJobManagerByCondition",target).then(
                    function (data) {
                        if(data){
                            $scope.Handlername = data;
                        }
                    }
                );


            };
*/



            //初始化
            var init = function () {
                //debugger;
                var keyword = {};
                var newDate = new Date();
                var takeDate = newDate.toISOString();
                keyword.month = takeDate.substring(0,7);
                //页面绑定元素
                $scope.jobManagerDto = {
                    "handleDept":$stateParams.handleDept,
                    "classCode":"",
                    "time1":"",
                    "time2":"",
                    "pageNo":$scope.paginationConf.currentPage || '',
                    "pageSize":$scope.paginationConf.itemsPerPage || ''
                };
                var curDate = new Date();
                $scope.jobManagerDto.time2 = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                curDate.setDate(1);
                $scope.jobManagerDto.time1 = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

                    $scope.ClassCode = [
                    {
                        "codecode": "",
                        "codecname": "请选择"
                    },
                    {
                        "codecode": "31",
                        "codecname": "种植保险类"
                    },
                    {
                        "codecode": "32",
                        "codecname": "养殖保险类"
                    }
                ];
                //初始化接口
                //接口请求
                //班表机构
                $$finder.post("queryPrpDcompanyByComCodePrivate",
                    {
                        "comCode":$scope.user.loginComCode || "01000000"
                    }).then(
                    function (data) {
                       // debugger;
                        $scope.Deptname = data;
                        $rootScope.infoToView = {
                            "Deptname":$scope.Deptname
                        };
                        $scope.jobManagerDto.deptname = $scope.Deptname[0].comCode;
                       // $scope.staffInDuty();
                    }
                );

            };

            /**
             * 返回
             */
            $scope.goBack = function () {
                $rootScope.back();
            };
            init();
        }]);
});

