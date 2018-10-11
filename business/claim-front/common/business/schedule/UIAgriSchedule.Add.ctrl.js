/**
 * DESC       : 国元农险理赔班表管理页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :2017.11.29
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 *          ZhaoWenjie                      班表管理-新增班表页面控制器搭建
 */
define([
    'app',
    'constants',
    'layer'
], function (app, constants, layer) {
    'use strict';
    app.registerController('UIAgriScheduleAddCtrl', ['$rootScope', '$scope', '$location', '$$finder','$stateParams','$state',
        function ($rootScope, $scope, $location, $$finder, $stateParams,$state) {
            $scope.proposal={};
            /**
             * 校验
             */
            $scope.internalSelect = function (target) {
                if($scope.prpLJobLinkerDtoList[0].staffPosition==$scope.prpLJobLinkerDtoList[1].staffPosition){
                    layerMsg("岗位已经存在，请重新选择！");
                    $scope.prpLJobLinkerDtoList[target].staffPosition = '';
                }
            };

            /**
             * 路由跳转
             */
            $scope.jumpWark = function () {
                $state.go('UIAgriSchedule');

            };

            $scope.different=function() {
                for (var i = 0; i < $scope.prpLJobManagerDtoList.length; i++) {
                    $scope.prpLJobManagerDtoList[i].handlerCode;
                    for (var j =i+1; j < $scope.prpLJobManagerDtoList.length; j++) {
                        if ($scope.prpLJobManagerDtoList[i].handlerCode == $scope.prpLJobManagerDtoList[j].handlerCode) {
                            layerMsg ("此查勘人员已经选择，请重新选择！");
                            $scope.prpLJobManagerDtoList[j].handlerCode=''
                        }
                    }
                }
            }

            /**
             * 保存*********************************************
             */
            $scope.saveSchedule = function () {
                $scope.flag=false;
                //循环遍历从人员信息HandlerNames得到人员名字，从机构信息Deptname得到机构名字
                for(var i=0;i< $scope.prpLJobManagerDtoList.length;i++){
                    $scope.prpLJobManagerDtoList[i].handlerCode;
                    console.log($scope.HandlerNames);
                    //得到prpLJobManagerDtoList中handlerName
                    for(var j=0;j<$scope.HandlerNames.length;j++){
                        if($scope.HandlerNames[j].handlerCode==$scope.prpLJobManagerDtoList[i].handlerCode){
                            $scope.prpLJobManagerDtoList[i].handlerName=$scope.HandlerNames[j].handlerName;
                        }
                      /*  if(!$scope.prpLJobManagerDtoList[i].handlerName){
                            layerMsg ("请选择查勘人员！");
                            return
                        }*/

                    }
                    //得到prpLJobManagerDtoList中deptName
                    for(var k=0;k<$scope.Deptname.length;k++){
                        if($scope.Deptname[k].comCode==$scope.prpLJobManagerDtoList[i].handleDept ){
                            $scope.prpLJobManagerDtoList[i].deptName=$scope.Deptname[k].comCName;
                        }
                        /*if(!$scope.prpLJobManagerDtoList[i].deptName){
                            layerMsg ("所在机构不能为空！");
                            return
                        }*/
                    }
                }

               //得到prpLJobLinkerDtoList中staffName
                for(var m=0;m<$scope.prpLJobLinkerDtoList.length;m++){
                    for(var n=0;n<$scope.HandlerName.length;n++){
                        if($scope.HandlerName[n].codeCode==$scope.prpLJobLinkerDtoList[m].staffUserCode){
                            $scope.prpLJobLinkerDtoList[m].staffName=$scope.HandlerName[n].codeName;
                        }
                    }
                }

                if(!$scope.prpLJobLinkerDtoList[0].staffName){
                    layerMsg ("请输入人员姓名！");
                    return
                }
                if(!$scope.prpLJobLinkerDtoList[1].staffName){
                    layerMsg ("请输入人员姓名！");
                    return
                }
                if(!$scope.prpLJobLinkerDtoList[0].staffPhone){
                    layerMsg ("请输入手机号码！");
                    return
                }
                if(!$scope.prpLJobLinkerDtoList[1].staffPhone){
                    layerMsg ("请输入手机号码！");
                    return
                }
                var svarJbo = {
                    "prpLJobManagerDtoList": $scope.prpLJobManagerDtoList,
                    "prpLJobLinkerDtoList": $scope.prpLJobLinkerDtoList,
                };
               // svarJbo.prpLJobManagerDtoList.handlerName=$scope.prpLJobManagerDtoList.handlerName;
                //debugger;

                $$finder.post("savePrpLJobManager", svarJbo).then(

                    function (data) {
                        console.log(data);
                        debugger;
                        layerMsg('保存成功',function () {
                            $state.go('UIAgriSchedule');
                        })
                             $scope.flag=true;
                    }

                );

            };



            //************************查询详情带出值
            /**
             * 模版赋值
             */
             $scope.assignmentInit = function () {
                // $scope.agriSchedule.queryType
                // copy是复制查询
                // personal 是个人查询
                // institution 是机构查询
                //debugger;
                $$finder.post("queryJobManagerDetailByCondition",

                    // {
                    //     "handleDept": "0000000000",
                    //     "month": "2017-11",
                    //     "classCode": "99",
                    //     "handlerName": "",
                    //     "queryType": "copy"
                    // }
                    {
                        "handleDept":$scope.agriSchedule.handleDept,
                        "month":$scope.agriSchedule.month,
                        "classCode":$scope.agriSchedule.classCode,
                        "handlerCode":$scope.agriSchedule.handlerCode,
                        "queryType":$scope.agriSchedule.queryType
                    }
                    ).then(
                    function (data) {
                       // debugger;
                        if ($scope.agriSchedule.queryType === "copy") {

                            if (data) {
                                console.log(data);

                                if (data.prpLJobManagerDtoList) {
                                       console.log(data.prpLJobManagerDtoList);
                                    // $scope.oldPrpLJobManagerDtoList = data.prpLJobManagerDtoList;
                                    for (var i = 0; i < data.prpLJobManagerDtoList.length; i++) {
                                        if (data.prpLJobManagerDtoList.length != $scope.prpLJobManagerDtoList.length) {
                                            $scope.addTimeDtoList();
                                        }
                                        /* $scope.prpLJobManagerDtoList[i].handlerCode = data.prpLJobManagerDtoList[i].handlerCode || $scope.agriSchedule.handlername;
                                         $scope.prpLJobManagerDtoList[i].handleDept = data.prpLJobManagerDtoList[i].handleDept || $scope.agriSchedule.deptname;
                                         $scope.prpLJobManagerDtoList[i].id = data.prpLJobManagerDtoList[i].id;*/
                                        $scope.prpLJobManagerDtoList[i].handlerCode = data.prpLJobManagerDtoList[i].handlerCode;
                                        $scope.prpLJobManagerDtoList[i].handleDept = data.prpLJobManagerDtoList[i].handleDept;
                                        $scope.prpLJobManagerDtoList[i].handlerName = data.prpLJobManagerDtoList[i].handlerName;
                                        $scope.prpLJobManagerDtoList[i].deptName = data.prpLJobManagerDtoList[i].deptName;
                                        $scope.prpLJobManagerDtoList[i].id = "";
                                        angular.forEach(data.prpLJobManagerDtoList[i].amList, function (amList, index) {
                                            angular.forEach($scope.prpLJobManagerDtoList[i].amList, function (managerAm, index) {
                                                if (parseInt(managerAm.time.substring(8, 10)) == parseInt(amList.time.substring(8, 10))) {
                                                    managerAm.checkFlag = true;
                                                    managerAm = amList;
                                                }
                                            });
                                        });
                                        angular.forEach(data.prpLJobManagerDtoList[i].pmList, function (pmList, index) {
                                            angular.forEach($scope.prpLJobManagerDtoList[i].pmList, function (managerPm, index) {
                                                if (parseInt(managerPm.time.substring(8, 10)) == parseInt(pmList.time.substring(8, 10))) {
                                                    managerPm.checkFlag = true;
                                                    // managerPm.fid = pmList.fid ;
                                                    managerPm = pmList;
                                                }
                                            });
                                        });
                                    }
                                }

                                if (data.prpLJobLinkerDtoList) {
                                    // $scope.oldPrpLJobLinkerDtoList = data.prpLJobLinkerDtoList;
                                    $scope.prpLJobLinkerDtoList = data.prpLJobLinkerDtoList;
                                    for (var j = 0; j < data.prpLJobLinkerDtoList.length; j++) {
                                        $scope.prpLJobLinkerDtoList[j].staffId = "";
                                        $scope.prpLJobLinkerDtoList[j].month=$scope.agriSchedule.month
                                    }
                                }

                                if ($scope.agriSchedule.viewType && $scope.agriSchedule.viewType == '1') {
                                    $scope.pageDisplay = true;
                                }


                            }


                        }


                        else {
                            if (data) {
                                console.log(data);
                                if (data.prpLJobLinkerDtoList) {
                                    // $scope.oldPrpLJobLinkerDtoList = data.prpLJobLinkerDtoList;
                                    $scope.prpLJobLinkerDtoList = data.prpLJobLinkerDtoList;
                                }
                                if (data.prpLJobManagerDtoList) {

                                    // $scope.oldPrpLJobManagerDtoList = data.prpLJobManagerDtoList;
                                    for (var i = 0; i < data.prpLJobManagerDtoList.length; i++) {
                                        if (data.prpLJobManagerDtoList.length != $scope.prpLJobManagerDtoList.length) {
                                            $scope.addTimeDtoList();
                                        }
                                        /* $scope.prpLJobManagerDtoList[i].handlerCode = data.prpLJobManagerDtoList[i].handlerCode || $scope.agriSchedule.handlername;
                                         $scope.prpLJobManagerDtoList[i].handleDept = data.prpLJobManagerDtoList[i].handleDept || $scope.agriSchedule.deptname;
                                         $scope.prpLJobManagerDtoList[i].id = data.prpLJobManagerDtoList[i].id;*/
                                        $scope.prpLJobManagerDtoList[i].handlerCode = data.prpLJobManagerDtoList[i].handlerCode;
                                        $scope.prpLJobManagerDtoList[i].handleDept = data.prpLJobManagerDtoList[i].handleDept;
                                        $scope.prpLJobManagerDtoList[i].handlerName = data.prpLJobManagerDtoList[i].handlerName;
                                        $scope.prpLJobManagerDtoList[i].deptName = data.prpLJobManagerDtoList[i].deptName;
                                        $scope.prpLJobManagerDtoList[i].id = data.prpLJobManagerDtoList[i].id;
                                        angular.forEach(data.prpLJobManagerDtoList[i].amList, function (amList, index) {
                                            angular.forEach($scope.prpLJobManagerDtoList[i].amList, function (managerAm, index) {
                                                if (parseInt(managerAm.time.substring(8, 10)) == parseInt(amList.time.substring(8, 10))) {
                                                    managerAm.checkFlag = true;
                                                    managerAm.fid = amList.fid;
                                                }
                                            });
                                        });
                                        angular.forEach(data.prpLJobManagerDtoList[i].pmList, function (pmList, index) {
                                            angular.forEach($scope.prpLJobManagerDtoList[i].pmList, function (managerPm, index) {
                                                if (parseInt(managerPm.time.substring(8, 10)) == parseInt(pmList.time.substring(8, 10))) {
                                                    managerPm.checkFlag = true;
                                                    // managerPm.fid = pmList.fid ;
                                                    managerPm = pmList;
                                                }
                                            });
                                        });
                                    }

                                }


                                if ($scope.agriSchedule.viewType && $scope.agriSchedule.viewType == '1') {
                                    $scope.pageDisplay = true;
                                }
                            }
                        }

                    }
                );
            };

            /**
             * 增加****排班时间（ addTimeDtoList（））********************************************************************
             */
            $scope.addTimeDtoList = function () {
                if(!$scope.pageDisplay){
                    var prpLJobManagerTimeDtoList = initDotList();
                    var DtoList = {

                        "queryType": null,
                        "id": "",
                        "jobRole": "",
                        "handlerCode":  $scope.agriSchedule.handlerCode|| '',
                        "handlerName": $scope.agriSchedule.handlerName || '',
                        "handleDept": $scope.agriSchedule.handleDept || '',
                        "deptName": "",
                        "flowInTime": "",
                        "modifyTime": "",
                        "month": $scope.monthDate,
                        "operator": "",
                        "operatorId": "",
                        "classCode": $scope.agriSchedule.classCode || '',
                        "systemCode": "",
                        "prpLJobManagerTimeDtoList":[],
                        "pmList":prpLJobManagerTimeDtoList.pmList,
                        "amList":prpLJobManagerTimeDtoList.amList

                    };
                    $scope.prpLJobManagerDtoList.push(DtoList);
                }
            };

            /**
             * 删除
             */
            $scope.deleteTimeDtoList = function (indexDto) {
                if(!$scope.pageDisplay){

                    $scope.prpLJobManagerDtoList.splice(indexDto,1);
                }
            };

            /**
             * 全选／取消
             * @param indexDto
             * @param target
             */
            $scope.choseall = function (indexDto,target) {
                if(!$scope.pageDisplay){
                    for (var i = 0;i< $scope.prpLJobManagerDtoList[indexDto].pmList.length;i++){
                        if(target){

                            $scope.prpLJobManagerDtoList[indexDto].pmList[i].checkFlag = true;
                            $scope.prpLJobManagerDtoList[indexDto].amList[i].checkFlag = true;
                        }else {
                            $scope.prpLJobManagerDtoList[indexDto].pmList[i].checkFlag = false;
                            $scope.prpLJobManagerDtoList[indexDto].amList[i].checkFlag = false;
                        }
                    }
                }

            };

            /**
             * 获取每月天数
             * @param getDateTime
             */
            var mGetDate = function (getDateTime) {
                var year = getDateTime.substring(0,4);
                var month = getDateTime.substring(5,8);
                var d = new Date(year, month,'0');
                return d.getDate();
            };

            // $scope.queryDto={};
            // $scope.prpLregist={};
            // $scope.state = $stateParams.state;
            // console.log($scope.state);
            // console.log(888);
            //


            var getFileList = function(){
                var dto = angular.copy($scope.jobManagerDto);
                //提交查询
                // $$finder.post('queryRegionalSetting', dto).then(
                //     function (data) {
                //         console.log(data.resultObj.totalCount);
                //         $scope.prpLregist = data.resultObj.content;
                //
                //
                //     }
                // )
            };

            getFileList();
            $scope.selected = [];
            var updateSelected = function (action, id) {
                if (action == 'add' & $scope.selected.indexOf(id) == -1) $scope.selected.push(id);
                if (action == 'remove' && $scope.selected.indexOf(id) != -1) $scope.selected.splice($scope.selected.indexOf(id), 1);
            };

            $scope.selectAll = function ($event) {
                var checkbox = $event.target;
                var action = (checkbox.checked ? 'add' : 'remove');
                for (var i = 0; i < $scope.entities.length; i++) {
                    var entity = $scope.entities[i];
                    updateSelected(action, entity.id);
                }
            };

            //*******initDotList（）增加排班时间函数***********************************

            var initDotList = function () {
                //debugger;
                if($rootScope.infoToView){
                    $scope.Deptname = $rootScope.infoToView.Deptname;
                }
                var proposalObj;
                //获取路由参数信息
                if($stateParams.scheduleAdd){
                    proposalObj = JSON.parse($stateParams.scheduleAdd);
                    $scope.agriSchedule = proposalObj;
                    $scope.HandlerNames = proposalObj.HandlerNames;
                    $scope.handleDept=proposalObj.handleDept;
                    $scope.classCode=proposalObj.classCode;


                }
                var key = {};
                var newDate = new Date();
                var takeDate = newDate.toISOString();
                key.month = takeDate.substring(0,7);


                $scope.monthDate = proposalObj.month || key.month;

                var monthDateNum = mGetDate($scope.monthDate);

                //班表初始化模版
                var prpLJobManagerTimeDtoList = {

                    "queryType": null,
                    "id": "",
                    "jobRole": "",
                    "handlerCode":  $scope.agriSchedule.handlerCode|| '',
                    "handlerName": $scope.agriSchedule.handlerName || '',
                    "handleDept": $scope.agriSchedule.handleDept|| '',
                    "deptName": "",
                    "flowInTime": "",
                    "modifyTime": "",
                    "month": $scope.monthDate,
                    "operator": "",
                    "operatorId": "",
                    "classCode": $scope.agriSchedule.classCode || '',
                    "systemCode": "",
                    "prpLJobManagerTimeDtoList":[],
                    "amList": [],
                    "pmList": []
                };
                var target = {};
                for (var i = 1;i<= monthDateNum;i++){
                    target = {
                        "fid": "",
                        "dateType": "AM",
                        "time": "",
                        "checkFlag":false
                    };
                    if(i.toString().length==1){
                        target.time = $scope.monthDate +"-0"+ i.toString();
                    }else {
                        target.time = $scope.monthDate +"-"+ i.toString();
                    }
                    prpLJobManagerTimeDtoList.amList.push(target);
                }
                for (var i = 1;i<= monthDateNum;i++){
                    target = {
                        "fid": "",
                        "dateType": "PM",
                        "time": "",
                        "checkFlag":false
                    };
                    if(i.toString().length==1){
                        target.time = $scope.monthDate +"-0"+ i.toString();
                    }else {
                        target.time = $scope.monthDate +"-"+ i.toString();
                    }
                    prpLJobManagerTimeDtoList.pmList.push(target);
                }
               return prpLJobManagerTimeDtoList;
            };


            //***************************************************

            /**
             * 获取本机构下---人员姓名
             */
            $scope.personnelName = function () {

                var target = {
                    "comCode":$scope.handleDept || '',
                    "codeType":"StaffNameCode"
                };
                // 接口请求
                $$finder.post("initSelectClaim",target).then(
                    function (data) {
                        if(data){
                            console.log(data);
                            $scope.HandlerName = data.codeData;
                            // $scope.showSearch = true;//区域查询默认显示
                        }
                    }
                );
            };


          //******************初始化联系人prpLJobLinkerDtoList*************************************************
            /**
             * 初始化
             */
            var init = function () {

                //班表表格
                $scope.prpLJobManagerDtoList = [];
                $scope.pageDisplay = false;
                var prpLJobManagerTimeDtoList = initDotList();
                $scope.prpLJobLinkerDtoList = [
                    {

                        "staffId": "",
                        "staffPosition": "",
                        "staffUserCode": "",
                        "staffName": "",
                        "staffPhone": "",
                        "staffType": "",
                        "handleDept": $scope.handleDept,
                        "month": $scope.monthDate,
                        "flowInTime": "",
                        "modifyTime": null,
                        "classCode": $scope.classCode

                    },
                    {

                        "staffId":"",
                        "staffPosition": "",
                        "staffUserCode": "",
                        "staffName": "",
                        "staffPhone": "",
                        "staffType": "",
                        "handleDept": $scope.handleDept,
                        "month": $scope.monthDate,
                        "flowInTime": "",
                        "modifyTime": null,
                        "classCode": $scope.classCode
                    }
                ];
                $scope.StaffPosition = [
                    {
                        "codecode": "",
                        "codecname": "请选择"
                    },
                    {
                        "codecode": "1",
                        "codecname": "对接人"
                    },
                    {
                        "codecode": "0",
                        "codecname": "转接报案人"
                    }
                ];
                $scope.agriSchedule = {};

                $scope.StaffType = [
                    {
                        "codecode": "",
                        "codecname": "请选择"
                    },
                    {
                        "codecode": "1",
                        "codecname": "非机构人员"
                    },
                    {
                        "codecode": "0",
                        "codecname": "本机构人员"
                    }
                ];
                var prpLJobManagerTimeDtoList = initDotList();
                $scope.personnelName();
                var DtoList = {

                    "queryType": null,
                    "id": "",
                    "jobRole": "",
                    "handlerCode":  $scope.agriSchedule.handlerCode || '',
                    "handlerName": $scope.agriSchedule.handlerName || '',
                    "handleDept": $scope.agriSchedule.handleDept || '',
                    "deptName": "",
                    "flowInTime": "",
                    "modifyTime": "",
                    "month": $scope.monthDate,
                    "operator": "",
                    "operatorId": "",
                    "classCode": $scope.agriSchedule.classCode || '',
                    "systemCode": "",
                    "prpLJobManagerTimeDtoList":[],
                    "pmList":prpLJobManagerTimeDtoList.pmList,
                    "amList":prpLJobManagerTimeDtoList.amList

                };

                if( $scope.agriSchedule.handlerCode){
                    DtoList.handlerCode = $scope.agriSchedule.handlerCode;
                  // $scope.indexDto.handlerCode= $scope.agriSchedule.handlerCode;
                }
                $scope.prpLJobManagerDtoList.push(DtoList);
                //初始化模版赋值
                if($scope.agriSchedule&&$scope.agriSchedule.queryType){
                    $scope.assignmentInit();
                }

            };





            init();
        }]);
});