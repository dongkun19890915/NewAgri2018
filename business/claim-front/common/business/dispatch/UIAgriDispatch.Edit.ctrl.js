/**
 * DESC       : 国元农险理赔调度任务-编辑页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.30
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                         调度任务-编辑页面控制器搭建
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriDispatchEditCtrl', ['$rootScope', '$scope', '$location','$state', '$$finder','$stateParams','$filter','FormFocus','$timeout','regexpConstants',
        function ($rootScope, $scope, $location,$state, $$finder, $stateParams,$filter, FormFocus, $timeout,regexpConstants) {
        $scope.editType = $stateParams.editType;
        $scope.checkSendMessageFlag=false;
        $scope.handlerExist = false;

        //短信默认全部为勾选
            $scope.message = $scope.message || {}
            if ($scope.handlerExist==true) {
                $scope.message.sendHandlerFlag = true;
                $scope.message.sendReportFlag = true;
            }
            else {
                $scope.message.sendHandlerFlag = false;
                $scope.message.sendReportFlag = false;
            }
            $scope.message.sendInsuredFlag = true;


        $scope.swfLogFlowID = $stateParams.swflogFlowId;
        $scope.swfLogLogNo = $stateParams.swflogLogNo;
        $scope.seeFlag = false;
        $scope.regData = regexpConstants;
        if($scope.editType === 'ADD'){
            $scope.seeFlag = false;
        }else if($scope.editType === 'SHOW'){
            $scope.seeFlag = true;
        }

        $scope.SchedulDetailInDto = {
            scheduleID:1,
            editType:$stateParams.editType,
            riskCode:$stateParams.riskCode,
            registNo:$stateParams.registNo,
            policyNo:$stateParams.policyNo,
            nodeType:$stateParams.nodeType,
            modelNo:$stateParams.modelNo,
            nodeNo:$stateParams.nodeNo
        }; // 查询条件
            $scope.TaskSchedulingDetailedOutDto=$scope.TaskSchedulingDetailedOutDto || {};
        // console.log( $scope.SchedulDetailInDto)
        // $scope.queryDto.radioText = 1; // 单选
        // $scope.queryDto.checkList = [1,2]; // 多选
        // $scope.queryDto.flag = true; // 多选

            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true
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

            //调度页面初始化
            $$finder.post("querySchedulDetail",$scope.SchedulDetailInDto).then(
            function (data) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                console.log('以下是报案登记初始化的查询结果')
                console.log(data)
                // console.log(data)
                // 日期格式转换
                data.scheduleDto.prpLscheduleMainWFDto.inputDate = $filter("date")(data.scheduleDto.prpLscheduleMainWFDto.inputDate, "yyyy-MM-dd");
                $scope.TaskSchedulingDetailedOutDto = data;
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.scheduleObjectName="";
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectName="";

                if ($scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId == "") {
                    $scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId = data.prpLscheduleMainWFDto.claimcomCode;
                }


                //调度任务初始化的时候后端查询返回了过多的信息(以前的),现在处理掉
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode='';

                //初始化时 默认定损处理单位和查勘处理单位保持同一个值
                //ng-value同步
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectName=$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectName;
                //ng-model同步
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectId = $scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId;

                //默认查勘调度处理的 标的默认选上
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.target = ["1"];

                //默认定损调度任务处理的 标的默认选上
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].target = ["1"]
            }
        ); //调度初始化服务
        $scope.openSendMessageLayer = function () { // 点击调度按钮发送短信
            $scope.$broadcast("SendMessageLayerSwitch")
        };
        $scope.openScheduleQueryLayer = function () { // 点击班表查询按钮
            if(!$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId){
                layerMsg("请选择查勘处理单位！");
                return ;
            }
            //$scope.goScheduleShow();
            $scope.queryRegional = true;

          // $state.go('UIAgriScheduleQuery',{"handleDept":$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId});
           // $scope.$broadcast("ScheduleQueryLayerSwitch")
        };
        //添加
        $scope.add=function () {
            var inputDate = new Date();
            inputDate = $filter("date")(inputDate, "yyyy-MM-dd");
            $scope.TaskSchedulingDetailedOutDto.prpLregistExtDto.prpLRegistExtDtoList.push({
                inputDate:inputDate,
                operatorName:$scope.user.userName,
                operatorCode:$scope.user.userCode
            });
        };
        //删除
        $scope.del = function ($index) {
            $scope.TaskSchedulingDetailedOutDto.prpLregistExtDto.prpLRegistExtDtoList.splice($index, 1);
        };

        $scope.change = function () {
            $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].nextHandlerCode=$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode

        }

        var messageInit =function () {
            //短信内容初始化
                $scope.checkSendMessageFlag = true;
                var dto = {};
                console.log("以下是短信发送的入参===============")
                console.log($scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.policyNo);
                dto.policyNo = $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.policyNo;
                dto.registNo = $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.registNo;
                dto.handlerCode = $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode;
                dto.handlerName = $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerName;
                if (dto.handlerCode != "") {
                    $scope.handlerExist = true
                }
                $$finder.post("messageInit", dto).then(
                    function (message) {
                        console.log("以下是短信的初始化内容")
                        console.log(message)
                        $scope.message = $scope.message || {};
                        $scope.message.handler = $scope.message.handler || {};
                        $scope.message.reportor = $scope.message.reportor || {};
                        $scope.message.insured = $scope.message.insured || {};


                        $scope.message.handler.handlerMessage = message.message[0];
                        $scope.message.reportor.reportMessage = message.message[1];
                        $scope.message.insured.insuredMessage = message.message[2];
                        //查勘人员姓名
                        $scope.message.handler.handlerName = message.handlerName;
                        //查勘人员手机号码
                        $scope.message.handler.handlerPhoneNumber = message.handlerPhoneNumber;
                        //报案人员姓名
                        $scope.message.reportor.reportorName = message.reportorName;
                        //报案人员手机号码
                        $scope.message.reportor.reportorPhoneNumber = message.reportorPhoneNumber;
                        //被保险人姓名
                        $scope.message.insured.insuredName = message.insuredName;
                        //被保险人手机号码
                        $scope.message.insured.insuredPhoneNumber = message.insuredPhoneNumber;
                    }
                )
            }


            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }

            $scope.saveDeal=function() {
            $scope.flag=false;
            console.log("===============")
            console.log($scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].target);
            console.log($scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].target);
            if ($scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].target[0] != "1" && $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.target[0] != "1" ){
                layerMsg('请选中标的选项!');
                return false;
            }
            if ($scope.registForm.$valid) {
                $scope.TaskSchedulingDetailedOutDto.swflogFlowId=$stateParams.swflogFlowId;
                $scope.TaskSchedulingDetailedOutDto.swflogLogNo=$stateParams.swflogLogNo;
                $scope.TaskSchedulingDetailedOutDto.saveType="";
                // $scope.TaskSchedulingDetailedOutDto.swflogFlowId = $stateParams.swflogFlowId;
                // $scope.TaskSchedulingDetailedOutDto.swflogLogNo = $stateParams.swflogLogNo;
                $scope.TaskSchedulingDetailedOutDto.checkSelectSend = "1";
                $scope.TaskSchedulingDetailedOutDto.oldScheduleLastAccessedTime = "";
                $scope.TaskSchedulingDetailedOutDto.prpLregistExtDto=$scope.TaskSchedulingDetailedOutDto.prpLregistExtDto || {}

                //为了让后端接收到,页面上补充说明对象的结构要符合后端的结构
                $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLRegistExtDtoList=$scope.TaskSchedulingDetailedOutDto.prpLregistExtDto.prpLRegistExtDtoList
                console.log('以下是补充说明对象')
                console.log($scope.TaskSchedulingDetailedOutDto.prpLregistExtDto.prpLRegistExtDtoList)

                console.log('以下是要调度要保存的对象')
                console.log($scope.TaskSchedulingDetailedOutDto)
                $$finder.post("scheduleSaveDeal", $scope.TaskSchedulingDetailedOutDto).then(
                    function (data) {
                        // console.log(data)
                        $scope.Map = data;
                        console.log($scope.Map);
                        if(data.code === "9999"){
                            layerMsg(data.message);
                            $scope.flag=true;
                        }else{
                            layerMsg('调度成功!<br/>报案号： '+data.registNo, function(){
                                messageInit();
                                $timeout(function () {
                                })
                            },{skin:'layer-success'});
                            //调度成功推送案件信息给金禾
                            $scope.investigate();
                            $scope.flag=true;
                        }

                    }
                );
            }else{
                // 表单校验不通过 定位到第一个不通过的元素
                FormFocus.focusEle('registForm')
            }
        };//调度、改派按钮保存提交服务



        // 查勘人员
        $scope.queryCheckSurveyPeople = function () {
            //点击更换机构后,清空查勘人员和定损人员
            $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode="";
            $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].nextHandlerCode="";


            console.log('以下是查看处理单位的代码')
            console.log($scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId);
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
         // $scope.queryCheckSurveyPeople();
        // 定损人员 (现在定损人员的查询和查勘人员是同一个人) 所以这个方法等于废弃了
            $scope.closeMessage = function () {
                $scope.checkSendMessageFlag = false;
                $state.go('UIAgriDispatch');
            }
        $scope.queryCheckAssessPeople = function () {
            var dto = {
                "comCode": $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleItemDtoList[0].scheduleObjectId,
                "taskCode": "claim.certainloss"
            };
            $$finder.post('queryCheckAndLossPeople', dto).then(
                function (data) {
                    $scope.codeListData=data;
                }
            )
        };
         // $scope.queryCheckAssessPeople();

            /**
             * 派工
             * @param target
             */
            $scope.dispatching = function (target) {
               // debugger;
               //  $scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.handlerName = target || '';
                  $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode=target||'';
                  $scope.scheduleQuery = false;
            };

            /**
             * 班表按钮
             */
            $scope.scheduleQueryShow = function (  ) {
                if(!$scope.TaskSchedulingDetailedOutDto.prpLscheduleMainWFDto.scheduleObjectId){
                    layerMsg("请选择查勘处理单位！");
                    return ;
                }
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
           /* $scope.jumpShow = function (keyword) {
                keyword.handlername = $scope.jobManagerDto.handlername || "";//当班人员
                keyword.handleDept = $scope.jobManagerDto.deptname || "";//班表机构
                keyword.classCode = $scope.jobManagerDto.classCode || "99";
                keyword.month = $scope.jobManagerDto.month || keyword.month;
                keyword.Handlername = $scope.Handlername || [];
                $state.go('UIAgriScheduleAdd', {scheduleAdd: JSON.stringify(keyword)});
            };
*/
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
                        if(data){
                            $scope.paginationConf.totalItems = data.totalCount;
                            $scope.dispatchList1= data.content;
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
                    onChange : function () {//值回
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

            $scope.cancel = function () {
                $state.go("UIAgriDispatch")
            };

            /**
             * 返回
             */
         /*   $scope.goBack = function () {
                $state.go("UIAgriDispatch")
               // $rootScope.back();
            };*/

            $scope.goBack = function () {
                window.history.back();
            };


            $scope.investigate=function(){
                var dto = {
                    "registNo":$stateParams.registNo,
                    "policyNo":$stateParams.policyNo,
                    "nextHandlerCode":$scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerCode,
                    "nextHandlerName": $scope.TaskSchedulingDetailedOutDto.scheduleDto.prpLscheduleMainWFDto.nextHandlerName
                };
                $$finder.post("submitInvestigation",dto).then(
                    function (data) {
                        if(data && data.code =='0000'){
                            console.log(data.message);
                        }else if(data && data.code == '9999'){
                            console.log("案件信息推送失败! ");
                        }else{
                            console.log(data.message);
                        }
                    }
                );
            }

            $scope.sendMessage = function () {
                debugger;
                console.log("是否发送查勘人员的短信");
                console.log($scope.message.sendHandlerFlag);
                console.log("是否发送报案人员短信");
                console.log($scope.message.sendReportFlag);
                console.log("是否发送被保险人短信");
                console.log($scope.message.sendInsuredFlag);


                var message = {};
                message.messageSendDtoList = [];
                if ($scope.message.sendHandlerFlag == false && $scope.message.sendReportFlag==false && $scope.message.sendInsuredFlag == false){
                    layerMsg('请选择要发送的短信对象');
                    return false
                }
                if ($scope.message.sendHandlerFlag == true){
                    if($scope.message.handler.handlerPhoneNumber=="(未查询到该人员的手机号码)"){
                        layerMsg('请输入查勘人员手机号码');
                        return false;
                    }
                    $scope.message.handler.mobilePhones=$scope.message.handler.handlerPhoneNumber;
                    $scope.message.handler.content = $scope.message.handler.handlerMessage;
                    //为1时代表发送短信 为2时代表发送邮件
                    $scope.message.handler.noticeType = '1';

                    message.messageSendDtoList.push($scope.message.handler)
                }
                if ($scope.message.sendReportFlag == true){
                    if($scope.message.reportor.reportorPhoneNumber==undefined){
                        layerMsg('请输入报案人手机号码');
                        return false;
                    }
                    $scope.message.reportor.mobilePhones=$scope.message.reportor.reportorPhoneNumber;
                    $scope.message.reportor.content = $scope.message.reportor.reportMessage;                    //为1时代表发送短信 为2时代表发送邮件
                    //为1时代表发送短信 为2时代表发送邮件
                    $scope.message.reportor.noticeType = '1';
                    message.messageSendDtoList.push($scope.message.reportor)
                }
                if ($scope.message.sendInsuredFlag == true){
                    if($scope.message.insured.insuredPhoneNumber==undefined){
                        layerMsg('请输入被保险人手机号码');
                        return false;
                    }
                    $scope.message.insured.mobilePhones=$scope.message.insured.insuredPhoneNumber;
                    $scope.message.insured.content = $scope.message.insured.insuredMessage;
                    //为1时代表发送短信 为2时代表发送邮件
                    $scope.message.insured.noticeType = '1';
                    message.messageSendDtoList.push($scope.message.insured)
                }
                console.log("以下是要发送的短信内容")
                console.log(message)
                $$finder.post("sendMessage",message).then(
                    function (data) {
                        console.log("以下是短信发送的结果")
                        console.log(data);
                        layerMsg('短信发送成功',function () {
                           $state.go('UIAgriDispatch');
                        })

                    }
                )
            }

        }]);
});