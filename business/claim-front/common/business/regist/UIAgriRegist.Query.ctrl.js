/**
 * DESC       : 国元农险理赔报案任务查询页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'config'
], function (app, constants, layer,config) {
    'use strict';
    app.registerController('UIAgriRegistQueryCtrl', ['$rootScope', '$scope', '$location','$filter', '$state','$$finder','regexpConstants','FormFocus','$window','$$commonality','$timeout',
        function ($rootScope, $scope, $location, $filter,  $state, $$finder, regexpConstants, FormFocus,$window,$$commonality,$timeout) {
            $scope.queryDto = {
                policyNo: '',
                registNo: '',
                insuredName: '',
                strfCardID: '',
                earLabel: '',
                fname: '',
                damageDate: '',
                damageHour: '',
                startDate: '',
                endDate: '',
                startEndDate:'',
                endEndDate:'',
                damageEndDate:'',
                "userCode": $rootScope.user.userCode,//用户代码
                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                "loginGradeCodes": "111",
                "tableName": "PrpDcompany",
                "userCodeFields": "userCode",
                "comCodeFields": "comCode",
            }; // 查询条件
            $scope.indextifyType ='01'; // 身份证 证件类型01
            // $scope.queryDto.radioText = 1; // 单选
            // $scope.queryDto.checkList = [1,2]; // 多选
            // $scope.queryDto.flag = true; // 多选
            // $$finder.post("checkBox",{}).then(
            //     function (data) {
            //         $scope.queryDto.checkBox = data.content;
            //     }
            // );
            // $$finder.post("radio",{}).then(
            //     function (data) {
            //         $scope.radioList = data.content;
            //         console.log($scope.radioList);
            //     }
            // );
            var initFun = function () {
                $scope.queryDto.status = "all"; // 案件状态默认全部状态
                    // 出险日期为当前本月一号
          /*          var damageDate = new Date().setDate(1);
                $scope.queryDto.damageDate = $filter("date")(damageDate, "yyyy-MM-dd");
                var damageEndDate= new Date();
                $scope.queryDto.damageEndDate = $filter("date")(damageEndDate, "yyyy-MM-dd");
                // 查询保险起期 默认当期日期的前一年
                var startDate = new Date().setDate(1);
                 // 查询保险起期 默认当前日期
                $scope.queryDto.startDate = $filter("date")(startDate, "yyyy-MM-dd");
                var startEndDate =new Date;
                $scope.queryDto.startEndDate = $filter("date")(startEndDate, "yyyy-MM-dd");
                // 查询保险起期 默认后一年度当前日期为止期。修改其中一项不做联动
                var endDate = startDate;
                // endDate = endDate.setFullYear(endDate.getFullYear()+1);
                $scope.queryDto.endDate = $filter("date")(endDate, "yyyy-MM-dd");
                var endEndDate = new Date();
                // endDate = endDate.setFullYear(endDate.getFullYear()+1);
                $scope.queryDto.endEndDate = $filter("date")(endEndDate, "yyyy-MM-dd");
*/

                //保险起期的起期
                var startDate = new Date();
                startDate.setDate(1); // 查询保险起期 默认本年本月1日
                // startDate = startDate.setFullYear(new Date().getFullYear()-1);
                //var endDate = startDate; // 查询保险起期 默认当前日期
                // endDate = endDate.setFullYear(new Date().getFullYear()+1);
                //保险起期的止期
                var startEndDate=new Date();
                //保险止期的起期
                var endDate = new Date();
                endDate.setFullYear(endDate.getFullYear()+1);
                endDate.setDate(1);
                //保险止期的止期
                var endEndDate=new Date();
                endEndDate.setFullYear(endEndDate.getFullYear()+1);
                $scope.queryDto.startDate = $filter("date")(startDate, "yyyy-MM-dd");
                $scope.queryDto.endDate = $filter("date")(endDate, "yyyy-MM-dd");
                $scope.queryDto.startEndDate = $filter("date")(startEndDate, "yyyy-MM-dd");
                $scope.queryDto.endEndDate = $filter("date")(endEndDate, "yyyy-MM-dd");

                $scope.queryDto.damageStartDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd hh:mm:ss');//出险日期起期
                $scope.queryDto.damageEndDate = $filter('date')(new Date().setFullYear(new Date().getFullYear()+1),'yyyy-MM-dd hh:mm:ss');//出险日期止期

                var damageDate= new Date();

                $scope.queryDto.damageDate =$filter('date')(damageDate,'yyyy-MM-dd');//出险日期

                // $scope.queryDto.startDate =$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//保险起期
                // $scope.queryDto.endDate =$filter('date')(new Date(),'yyyy-MM-dd');//保险止期


            };
            initFun();
            // 本页面使用正则的集合
            $scope.regData = regexpConstants;
            $scope.prpLregist = null; // 查询结果
            var go = function (item,type) {
                $state.go('UIAgriRegist', {
                    editType: type,
                    policyNo: item.relatepolicyNos[0],
                    registNo: item.registNo,
                    riskCode: item.riskCode
                    // damageDate: item.damageDate, // 出险时间
                    // swfLogFlowID: item.swfLogFlowID,
                    // swfLogLogNo: item.swfLogLogNo,
                    // modelNo: item.modelNo,
                    // nodeNo: item.nodeNo,
                    // status: item.status
                })
            };
            $scope.modifyRegist=function (item) { // 修改报案
                // $state.go('UIAgriRegist', {state: 'EDIT'})
                go(item,'EDIT')
            };

            $scope.seeRegist=function (item) { // 查看报案
                // $state.go('UIAgriRegist', {state: 'SHOW'})
                go(item,'SHOW')
            };
            var initPage = function(){
                $scope.paginationConf = {
                    currentPage : 1, // 当前所在的页
                    totalItems: 0, // 总共有多少条记录
                    itemsPerPage : 20, // 每页展示的数据条数
                    perPageOptions : [5 ,10, 20, 50 ],
                    onChange : function () { // 值回调
                        getFileList();
                    }
                };
            };
            initPage();

            $scope.riskType1=true;
            $scope.changeRiskType=function () {
                //如果是种植险,隐藏耳标号
                if ($scope.queryDto.riskCategory=='H'){
                    $scope.riskType1=false;
                }else {
                    $scope.riskType1=true;
                }

            }

            /*分页查询*/
            var getFileList = function(){
                var dto = angular.copy($scope.queryDto);
                dto.pageNo=$scope.paginationConf.currentPage;
                dto.pageSize=$scope.paginationConf.itemsPerPage;

                // if($scope.queryDto.startDate && !$scope.queryDto.endDate) {
                //     dto.endDate = $filter('date')(new Date(), 'yyyy-MM-dd');//保险止期
                // }

                    // 提交查询
                if(dto.riskCategory == '' || dto.riskCategory==undefined){
                    dto.riskCategory='all';
                }
                $$finder.post('queryPrpLregistList', dto).then(
                    function (data) {
                        console.log("==================");
                        console.log(data)
                        $scope.prpLregist = data.content;
                        $scope.paginationConf.totalItems = data.totalCount;
                        //查询状态转换 因为后端已撤销的情况下status也是4 , 所以如果是4并且撤销情况不为空的情况下就是已撤销的状态,转换为6(已撤销)
                        angular.forEach($scope.prpLregist,function (dat) {
                            if (dat.cancelDate != null && (dat.status=='4'||dat.status=='2')){
                                dat.status = '6';
                            }
                        })
                        console.log("==========");
                        console.log($scope.prpLregist)
                    }
                )
            };
            /**
             * 当有业务单号时消除时间和恢复时间
             */
            $scope.changeendorseNo = function (str) {
                if($scope.queryDto.policyNo||$scope.queryDto.registNo||$scope.queryDto.identifyNumber){
                    //出险日期
                    $scope.queryDto.damageStartDate = "";//出险日期起期
                    $scope.queryDto.damageEndDate ="";//出险日期止期
                    //保险起期
                    $scope.queryDto.startDate = "";//保险起期的开始日期
                    $scope.queryDto.startEndDate= "";//保险起期的结束日期
                    //保险止期
                    $scope.queryDto.endDate = "";//保险止期的开始日期
                    $scope.queryDto.endEndDate = "";//保险止期的结束日期
                } else {
                    //出险日期
                    $scope.queryDto.damageStartDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd hh:mm:ss');//出险日期起期
                    $scope.queryDto.damageEndDate = $filter('date')(new Date().setFullYear(new Date().getFullYear()+1),'yyyy-MM-dd hh:mm:ss');//出险日期止期
                    //保险起期
                    $scope.queryDto.startDate = $filter("date")( new Date().setDate(1), "yyyy-MM-dd");
                    $scope.queryDto.startEndDate = $filter("date")(new Date(), "yyyy-MM-dd");
                    //保险止期
                    var endDate1 = new Date();
                    endDate1.setFullYear(endDate1.getFullYear()+1);
                    endDate1.setDate(1);
                    $scope.queryDto.endDate = $filter("date")(endDate1, "yyyy-MM-dd");
                    $scope.queryDto.endEndDate = $filter("date")(new Date().setFullYear(new Date().getFullYear()+1), "yyyy-MM-dd");

                }
            }

            $scope.query = function (target) {
                if($scope.queryDto.riskCategory == '' || $scope.queryDto.riskCategory==undefined){
                    $scope.queryDto.riskCategory='all';
                }
                var querySpecialflag = $$commonality.inspectEmpty(target);
                if($scope.queryDto.status||$scope.queryDto.riskCategory){
                    querySpecialflag = true;
                }

                //循环遍历表单下节点
                if (!querySpecialflag){
                    layerMsg("请至少输入一项查询条件！");
                    return false;
                }
                if ($scope.registQueryForm.$valid) { // 校验通过
                   /* if ($scope.queryDto.endDate){
                        if(!$scope.queryDto.startDate){
                            layerMsg("请选择保险起期!");
                            return false
                        }
                    }
                    // 通用规则 查询条件输入业务号，清空默认时间
                    if($scope.queryDto.policyNo||$scope.queryDto.registNo){
                        $scope.queryDto.startDate = "";
                        $scope.queryDto.endDate = "";
                        $scope.queryDto.damageDate = "";
                        $scope.queryDto.damageEndDate ='';
                        $scope.queryDto.startEndDate ='';
                        $scope.queryDto.endEndDate ='';
                    }*/
                    if(!$scope.queryDto.startDate && $scope.queryDto.endDate){
                        layerMsg("请输入保险起期！");
                        return;
                    }

                    getFileList();
                    if ($scope.queryDto.riskCategory == 'all'){
                        $scope.queryDto.riskCategory = '';
                    }

                } else { // 校验未通过
                    FormFocus.focusEle('registQueryForm')
                }
            };

            //重置
            // $scope.resetForm=function () {
            //     angular.forEach($scope.queryDto,function (value, key) {
            //         $scope.queryDto[key] = ''
            //     });
            //     $scope.registQueryForm.$setPristine();
            //     initFun();
            //     $('.validation-errorText').hide(500)
            // }
            // 撤销弹层
            $scope.registLayerDto={};
            $scope.cancelReportFlag = false;
            $scope.showCancelLayer = function (result) {
                $scope.cancelReportFlag =! $scope.cancelReportFlag;
                $scope.registLayerDto.registNo = result.registNo;
            }
            $scope.close = function () {
                $scope.cancelReportFlag = false;
            };
            $scope.cancelReport = function () {
                var dto = {
                    "registNo":$scope.registLayerDto.registNo,
                    "context":$scope.registLayerDto.context
                }
                $$finder.post("cancelReport",dto).then(
                    function (data) {
                        console.log(data);
                        layerMsg(data.message, function(){
                            $timeout(function () {$scope.cancelReportFlag =! $scope.cancelReportFlag;})
                            $state.go('UIAgriRegistQuery');
                            $scope.prpLregist = "";
                            $scope.paginationConf.totalItems = 0;
                        });

                    }
                )
            }

            /**
             * 返回
             */
            $scope.goBack = function () {
                $scope.cancelReportFlag=false;
            };

            /**
             * 保单打印
             * @param _registNo 报案号
             */
            $scope.policyPrint = function (_registNo) {
                $window.open(constants.EXTERNALSYSTEMURL.PRINTURL+$location.$$protocol+"://"+$location.$$host+":"+$location.$$port+config.backend.ip+config.backend.copyPrint+'?registNo='+_registNo);
            }
    }]);
});