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
    app.registerController('UIAgriScheduleCtrl', ['$rootScope', '$scope', '$location','$state','$$finder','$stateParams',
        function ($rootScope, $scope, $location, $state, $$finder,$stateParams) {

            /**
             * 复制时查询上个月是否有值
             */
            $scope.assignmentInit = function (keyword) {
                // $scope.agriSchedule.queryType
                // copy是复制查询
                // personal 是个人查询
                // institution 是机构查询
                //debugger;
                $$finder.post("queryJobManagerDetailByCondition",

                    {
                        "handleDept":$scope.jobManagerDto.handleDept,
                        "month":$scope.jobManagerDto.month,
                        "classCode":$scope.jobManagerDto.classCode,
                        "handlerCode":$scope.jobManagerDto.handlerCode,
                        "queryType":"copy"
                    }

                ).then(
                    function (data) {
                        //debugger;

                        if (data) {
                            console.log(data);
                         //上个月无班表信息，弹出提示终止程序；
                            if (!data.prpLJobManagerDtoList.length) {
                                layerMsg("无上个月班表信息");
                                return false;
                            }
                            //上个月有值就跳转带出上个月值；
                             else {   layer.msg('加载中...', {icon: 1});

                             keyword.queryType = "copy";
                             //调用接口
                             $scope.jumpShow(keyword);
                            }

                        }
                    }
                );
            };


            /**
             * 查询班表主表信息
             */
            $scope.jobInfo = function () {
                //debugger;
             var target = {
             "handleDept": $scope.jobManagerDto.handleDept,
             "month": $scope.jobManagerDto.month,
             "classCode": $scope.jobManagerDto.classCode,
             // "handlerCode":$scope.jobManagerDto.handlerCode
             };

             // 接口请求
             $$finder.post("queryJobManagerByCondition",target).then(

             function (data) {
                 console.log(data);
                 if(data.length){
             layerMsg("已存在该月班表信息不能新增");
             return false;
             }
            else {
                 var keyword = {};
                 var newDate = new Date();
                 var takeDate = newDate.toISOString();
                 keyword.month = takeDate.substring(0,7);
                 //是否复制上月班表
                 layer.confirm('是否复制上月班表？', {
                     btn: ['是','否'], //按钮
                     closeBtn: 0,
                     shade:[0.5]
                 },function(){
                     //点击“是”调用查询上个月是否有值接口
                     $scope.assignmentInit(keyword)

                 },
                     //点击“否”进入跳转页面（不复制上个月班表信息）
                     function(){
                     $scope.jumpShow(keyword);
                 }
                 );

             }

             });

             };
            /**
             * 班表机构改变调用
             */
            $scope.staffInDuty = function () {
                $scope.guardian();
            };

            /**
             * 当班人查询
             */
            $scope.guardian = function () {
                var target = {

                    "handleDept":$scope.jobManagerDto.handleDept || ''

                };


                // 接口请求
                $$finder.post("queryPrplAreaSettingByhandleDept",target).then(
                    function (data) {
                        //debugger;
                        if(data){
                            console.log(data);
                            $scope.HandlerName = data;

                            console.log($scope.HandlerName);
                        }
                    }
                );
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
              // debugger;
                keyword.handlerCode = $scope.jobManagerDto.handlerCode || "";//当班人员---------要改的地方
                keyword.handleDept = $scope.jobManagerDto.handleDept || "";//班表机构
                keyword.classCode = $scope.jobManagerDto.classCode || "";
                keyword.month = $scope.jobManagerDto.month || keyword.month;
                keyword.HandlerNames = $scope.HandlerName;
                $state.go('UIAgriScheduleAdd', {scheduleAdd: JSON.stringify(keyword)});
            };

            /**
             * 班表主列表查询
             */
            $scope.goScheduleShow = function () {
                if(!$scope.jobManagerDto.handleDept){
                    layerMsg("请选择班表机构！");
                    return false;
                }
                if(!$scope.jobManagerDto.month){
                    layerMsg("请选择班表月份！");
                    return false;
                }

                if(!$scope.jobManagerDto.classCode){
                    layerMsg("请选择险类！");
                    return false;
                }
                var target = {
                    "handleDept":$scope.jobManagerDto.handleDept || "",
                    "month": $scope.jobManagerDto.month || "",
                    "classCode": $scope.jobManagerDto.classCode || "",
                    "handlerCode": $scope.jobManagerDto.handlerCode || "",
                    "pageNo": $scope.paginationConf.currentPage || "",
                    "pageSize": $scope.paginationConf.itemsPerPage || ""
                };
                // var target = {
                //     "handleDept": "3414000000",
                //     "month":  "2012-12",
                //     "classCode": "05",
                //     "handlername": "",
                //     "pageNo": "1",
                //     "pageSize": "5"
                // };

                // 接口请求
                $$finder.post("queryPrpLJobManagerByCondition",target).then(
                // $$finder.post("queryJobManagerByCondition",target).then(
                    function (data) {
                        //debugger;
                        console.log(data);
                        if(data){
                            $scope.paginationConf.totalItems = data.totalCount;
                            $scope.dispatchList = data.content;
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
                    perPageOptions :  [5,10,20],
                    onChange : function () {//值回调
                        $scope.goScheduleShow();
                    }
                };

            };
            initPage();
            /*分页查询*/
            var getFileList = function(){
                // var dto = angular.copy($scope.jobManagerDto);
                // dto.pageNo=$scope.paginationConf.currentPage;
                // dto.pageSize=$scope.paginationConf.itemsPerPage;
                // // console.log($scope.paginationConf.currentPage);
                // //提交查询
                // $$finder.post('queryRegionalSetting', dto).then(
                //     function (data) {
                //         console.log(data.totalCount);
                //         $scope.prpLregist = data.content;
                //         $scope.paginationConf.totalItems = data.totalCount||0;
                //
                //     }
                // )
            };

            $scope.goScheduleAdd = function () {

                if(!$scope.jobManagerDto.handleDept){
                    layerMsg("请选择班表机构！");
                    return false;
                }
                if(!$scope.jobManagerDto.month){
                    layerMsg("请选择班表月份！");
                    return false;
                }

                if(!$scope.jobManagerDto.classCode){
                    layerMsg("请选择险类！");
                    return false;
                }

                $scope.jobInfo();


            };

            //初始化
            var init = function () {
                var keyword = {};
                var newDate = new Date();
                var takeDate = newDate.toISOString();
                keyword.month = takeDate.substring(0,7);
                //页面绑定元素
                $scope.jobManagerDto = {
                    "handleDept":$scope.user.loginComCode ||"",
                    "month": keyword.month,
                    "classCode": ""
                };
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
                        //"comCode":3400000000
                        //"comCode":$scope.user.loginComCode || "01000000"
                       "comCode": $rootScope.user.loginComCode|| "01000000"
                    }).then(
                    function (data) {
                        $scope.Deptname = data;
                        console.log($rootScope.user.loginComCode);

                        $rootScope.infoToView = {
                            "Deptname":$scope.Deptname
                        };
                        $scope.jobManagerDto.handleDept =$rootScope.user.loginComCode;
                        $scope.staffInDuty();
                    }
                );

            };
            init();
        }]);
});

