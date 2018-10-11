/**
 * DESC       : 国元农险理赔调度任务-编辑页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.30
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                         调度任务-改派页面控制器搭建
 */
// define([
//     'app',
//     'constants',
//     'layer'
// ], function (app, constants, layer) {
//     'use strict';
//     app.registerController('UIAgriDispatchReassignmentCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams',
//         function ($rootScope, $scope, $location, $$finder, $stateParams) {
//             $scope.queryDto={};
//             $scope.state = $stateParams.state;
//
//
//
//
//
//         }]);
// });
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriDispatchReassignmentCtrl', ['$rootScope', '$scope', '$location','$stateParams', '$$finder','$state','$filter','regexpConstants','$timeout',
        function ($rootScope, $scope, $location,$stateParams, $$finder, $state,$filter,regexpConstants,$timeout) {
            $scope.regData = regexpConstants;
           /* var initPage = function(){
                // console.log(22)
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 90, // 总共有多少条记录
                    itemsPerPage : 10, // 每页展示的数据条数
                    perPageOptions : [ 10, 20, 30, 40,50 ]
                };
            };
            initPage();*/
            $scope.editType = $stateParams.editType;
            $scope.seeFlag = false;
            if($scope.editType === 'ADD'){
                $scope.seeFlag = false;
            }else if($scope.editType === 'SHOW'){
                $scope.seeFlag = true;
                $scope.showbtu=false;
            }else if ($scope.editType === 'GETBACKEDIT'){
                $scope.seeFlag = false;
                $scope.showbtu=true;
            }
            $scope.SchedulDetailInDto = {
                scheduleID:1,
                editType:$stateParams.editType,
                riskCode:$stateParams.riskCode,
                registNo:$stateParams.registNo
            }; // 查询条件
            // console.log($stateParams.editType)
            $scope.TaskSchedulingDetailedOutDto={};
            // console.log( $scope.SchedulDetailInDto)
            // $scope.queryDto.radioText = 1; // 单选
            // $scope.queryDto.checkList = [1,2]; // 多选
            // $scope.queryDto.flag = true; // 多选
            //

            //查勘人员和定损人员联动
            $scope.change = function () {
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].nextHandlerCode=$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode
            }
            $$finder.post("querySchedulDetail",$scope.SchedulDetailInDto).then(
                function (data) {
                    console.log('以下是调度查询的初始化data结果')
                    console.log("=================")
                    console.log(data)
                    console.log("-----------------")
                    console.log(data.scheduleDto);
                    $scope.TaskSchedulingDetailedOutDto = data;

                    console.log($scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].exigencegree);

                    //默认查勘调度处理的 标的默认选上
                    $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.target = ["1"];

                    //默认定损调度任务处理的 标的默认选上
                    $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].target = ["1"]

                    //调度时间初始化
                    data.prpLregistDto.inputDate = $filter("date")(data.prpLregistDto.inputDate, "yyyy-MM-dd");
                   $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.inputDate=$filter("date")(data.prpLregistDto.inputDate, "yyyy-MM-dd");
                    $scope.queryCheckSurveyPeople();

                    if ($scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId == "") {
                        $scope.prpLscheduleMainWFDto.scheduleObjectId = data.prpLscheduleMainWFDto.claimcomCode;
                    }

                    //如果是改派
                    if($stateParams.editType==="GETBACKEDIT"){
                        // $scope.queryCheckAssessPeople()
                        // $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.scheduleObjectName="";
                        // $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectName="";


                    }
                    //如果是查询
                    if($scope.editType === 'SHOW'){
                        //查看的情况下不需要像改派一样,处理到多余的数据

                        console.log('以下是时间=========');
                        // console.log($scope.TaskSchedulingDetailedOutDto.prpLregistExtDto.prpLRegistExtDtoList[0].inputDate)

                        // $scope.queryCheckAssessPeople()

                        // $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.scheduleObjectId = data.scheduleDto.prpLscheduleMainWFDto.scheduleObjectId
                    }
                }
            );
            $scope.openSendMessageLayer = function () { // 点击改派按钮

                $scope.$broadcast("SendMessageLayerSwitch")
            };
            $scope.openScheduleQueryLayer = function () { // 点击班表查询按钮
                if(!$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId){
                    layerMsg("请选择查勘处理单位！");
                    return ;
                }
                //$scope.goScheduleShow();
                $scope.queryRegional = true;
            };

            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.policyNo;
                $$finder.post('relatePolicyInfo', {policyNo:policyNo}).then(
                    function (data) {
                        console.log(data);
                        $scope.relateInfoDto = data;
                        angular.forEach($scope.relateInfoDto.prpLregistDtoList,function(result){
                            result.damageStartDate= $filter("date")(result.damageStartDate, "yyyy-MM-dd");
                        })
                        angular.forEach($scope.relateInfoDto.prpPheadDtoList,function (dto){
                            dto.underwriteEndDate = $filter("date")(dto.underwriteEndDate, "yyyy-MM-dd");
                        })


                    }
                )
            }

            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }


            $scope.saveDeal=function() {
                $scope.TaskSchedulingDetailedOutDto.oldScheduleLastAccessedTime="";
                $scope.TaskSchedulingDetailedOutDto.swflogFlowId=$stateParams.swflogFlowId;
                $scope.TaskSchedulingDetailedOutDto.swflogLogNo=$stateParams.swflogLogNo;
                $scope.TaskSchedulingDetailedOutDto.saveType=$stateParams.editType;
                if(!$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.checkSite){
                    layerMsg("请录入查勘地址！");
                    return ;
                }
                if(!$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].checkSite){
                    layerMsg("请录入定损地址！");
                    return ;
                }
                $$finder.post("scheduleSaveDeal", $scope.TaskSchedulingDetailedOutDto).then(
                    function (data) {
                        if(data.code === "9999"){
                            layerMsg('改派失败!');
                        }else{
                            layerMsg('改派成功!<br/>报案号： '+data.registNo, function(){
                                $timeout(function () {  $state.go('UIAgriDispatch');})
                            });
                            $state.go("UIAgriDispatch")
                        }
                        // $scope.openSendMessageLayer();
                        // data.message
                        // console.log($scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto)
                        // console.log(data)
                        $scope.Map = data;
                        console.log($scope.Map)
                    }
                );
            };

            /**
             * 派工
             * @param target
             */
            $scope.dispatching = function (target) {
               // $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.handlerName = target || '';
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode=target||'';
                $scope.scheduleQuery = false;
            };

            /**
             * 班表按钮
             */
            $scope.scheduleQueryShow = function () {
                    //debugger;
                var target = {

                    "policyNo":$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.policyNo,
                    //"handleDept":$scope.user.loginComCode || "3401020000"
                    "handleDept":$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId

                };
                // target = {
                //     "policyNo": "2322013401022017000056",
                //     "handleDept": "01126104"
                // };
                // 接口请求
                $$finder.post("queryPrpLJobManagerByPolicyNoAndHandleDept",target).then(
                    function (data) {
                       //debugger;
                        if(data){
                            $scope.dispatchList = data;
                         if  ( $scope.dispatchList.length){
                               $scope.open=true;
                         }
                            $scope.scheduleQuery = true;
                        }
                    }
                );
            };

            /**************************************************************************
             * 班表查询按钮
             */
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
                $scope.jobManagerDto.pageNo=$scope.paginationConf.currentPage ;
                $scope.jobManagerDto.pageSize=$scope.paginationConf.itemsPerPage;
                $scope.jobManagerDto.handleDept=$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId
                // 接口请求
                $$finder.post("queryDispatcherPrpLJobManagerByCondition",$scope.jobManagerDto).then(
                    function (data) {
                       // debugger;
                        if(data){
                            $scope.paginationConf.totalItems = data.totalCount;
                            $scope.dispatchList1 = data.content;

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
                    "handleDept":"",
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
           /* $scope.goBack = function () {
                $rootScope.back();
            };*/
            $scope.goBack = function () {
                window.history.back();
            };

            init();


            // 查勘人员
            $scope.queryCheckSurveyPeople = function () {
                //点击更换机构后,清空查勘人员和定损人员 如果是在新增调度的情况下再清空
                if($stateParams.editType==="ADD") {
                    $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode = "";
                    $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].nextHandlerCode = "";
                }

                var dto = {
                    "comCode": $scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId,
                    "taskCode": "claim.check"
                };
                $$finder.post('queryCheckAndLossPeople', dto).then(
                    function (data) {
                        $scope.handlerList=data;
                    }
                )
                //这是查勘处理机构和定损处理机构的相互联动 选择查勘处理机构,定损处理机构也会相应改变
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectName=$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectName;
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectId=$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId;
            };
            // // 定损人员
            // $scope.queryCheckAssessPeople = function () {
            //     var dto = {
            //         "comCode": $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectId,
            //         "taskCode": "claim.certainloss"
            //     };
            //     $$finder.post('queryCheckAndLossPeople', dto).then(
            //         function (data) {
            //             $scope.codeListData=data;
            //         }
            //     )
            // };

            /**
             * 返回
             */
          /*  $scope.goBack = function () {
                $state.go("UIAgriDispatch")
               // $rootScope.back();
            };*/
            $scope.goBack = function () {
                window.history.back();
            };


            $scope.investigate=function(){
                var dto = {
                    "registNo":$stateParams.registNo,
                    "flowId":$stateParams.flowId,
                    "logNo":$stateParams.logNo,
                    "policyNo":$stateParams.policyNo

                };
                $$finder.post("submitInvestigation",dto).then(
                    function (data) {
                        if(data && data.code =='0000'){
                            layerMsg(data.message);
                        }else if(data && data.code == '9999'){
                            layerMsg("发起调查失败! ");
                        }else{
                            layerMsg(data.message);
                        }
                    }
                );
            }


        }]);
});
