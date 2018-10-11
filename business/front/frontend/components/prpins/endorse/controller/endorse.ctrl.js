/**
 * Created by ZhangJiansen on 2016/9/10.
 * 批改模块控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var endorseCtrl = function($scope,$state,endorseServ,$filter,commFactory,FormFocus) {
        $scope.insuredOnlyOneLayer = true;
        /*批改申请查询*/
        var searchFlalg=false;
        var getPolicyList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.policyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.policyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            var data = $scope.policyQueryConditionDto;
            var dataUrl = '/gscore-pa-web/commonquery/forEndorse';
            commFactory.postObject(dataUrl,data).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.endorseData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );

        };
        var minDate = new Date();
        $scope.endorDateMax = $filter("date")(minDate, "yyyy-MM-dd");
        //设置批改生效日可以选择 当前日期 前后一个月 即
        var date=new Date();
        date.setMonth(date.getMonth()+1);
        $scope.validDateMAX=$filter("date")(date, "yyyy-MM-dd");
        date=new Date();
        date.setMonth(date.getMonth()-1);
        $scope.validDateMin=$filter("date")(date, "yyyy-MM-dd");

        //初始化界面
        var initFunc = function(){
            //初始化分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 10,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30, 40, 50]   // 可选择显示条数的数组
            };
            $scope.policyQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            //设置 保单生效日 默认值
            var date=new Date();
            //$scope.policyQueryConditionDto.startDateBegin= $filter("date")(date, "yyyy-MM-dd");
            $scope.policyQueryConditionDto.startDateBegin='';
            date.setMonth(date.getMonth()+6);
            //$scope.policyQueryConditionDto.startDateEnd= $filter("date")(date, "yyyy-MM-dd");
            $scope.policyQueryConditionDto.startDateEnd='';
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getPolicyList);
        };
        initFunc();

        /*批改申请查询方法响应事件*/
        $scope.endorseQuery = function(){
            var policyDto = {};
            policyDto.policyNo = $scope.policyQueryConditionDto.policyNo;
            policyDto.applyName = $scope.policyQueryConditionDto.applyName;
            policyDto.identifyType = $scope.policyQueryConditionDto.identifyType;
            policyDto.identifyNumber = $scope.policyQueryConditionDto.identifyNumber;
            policyDto.startDateBegin = $scope.policyQueryConditionDto.startDateBegin;
            policyDto.startDateEnd = $scope.policyQueryConditionDto.startDateEnd;
            policyDto.operatorCode = $scope.policyQueryConditionDto.operatorCode;
            policyDto.handler1Code = $scope.policyQueryConditionDto.handler1Code;
            if((policyDto.policyNo == '' || policyDto.policyNo == undefined )
                && (policyDto.applyName == '' || policyDto.applyName == undefined)
                && (policyDto.identifyType == '' || policyDto.identifyType == undefined )
                && (policyDto.identifyNumber== '' || policyDto.identifyNumber== undefined )
                && (policyDto.startDateBegin== '' || policyDto.startDateBegin== undefined )
                && (policyDto.startDateEnd== '' || policyDto.startDateEnd== undefined )
                && (policyDto.operatorCode== '' || policyDto.operatorCode== undefined )
                && (policyDto.handler1Code== '' || policyDto.handler1Code== undefined)){
                angular.alert("必须输入至少一项搜索条件。");
                return
            }else if((policyDto.policyNo == '' || policyDto.policyNo == undefined )
                && (policyDto.applyName == '' || policyDto.applyName == undefined)
                && (policyDto.identifyType != '' || policyDto.identifyType != undefined )
                && (policyDto.identifyNumber== '' || policyDto.identifyNumber== undefined )
                && (policyDto.startDateBegin== '' || policyDto.startDateBegin== undefined )
                && (policyDto.startDateEnd== '' || policyDto.startDateEnd== undefined )
                && (policyDto.operatorCode== '' || policyDto.operatorCode== undefined )
                && (policyDto.handler1Code== '' || policyDto.handler1Code== undefined)){
                angular.alert("请输入至少一项其他保单信息。");
                return;
            }else if(!policyDto.policyNo && !policyDto.applyName && !policyDto.identifyType && !policyDto.identifyNumber
            && !policyDto.operatorCode && !policyDto.handler1Code && policyDto.startDateBegin && !policyDto.startDateEnd ){
                    angular.alert("请输入保单生效日（结束）。");
                    return;
            }else if(!policyDto.policyNo && !policyDto.applyName && !policyDto.identifyType && !policyDto.identifyNumber
                && !policyDto.operatorCode && !policyDto.handler1Code && policyDto.startDateEnd && !policyDto.startDateBegin){
                angular.alert("请输入保单生效日（开始）。");
                return;
            }else{
                //日期 控制在6个月范围。
                var  sdate=$scope.policyQueryConditionDto.startDateBegin;
                var endate=$scope.policyQueryConditionDto.startDateEnd;
                if(sdate!=undefined&&endate!=undefined){
                    sdate=new Date(sdate.replace(/-/g,"/") );
                    endate=new Date(endate.replace(/-/g,"/") );
                    sdate.setMonth(sdate.getMonth()+6);
                    if(endate>sdate){
                        angular.alert("批单生效日（结束）不能晚于批单生效日（开始）之后6个月!");
                        return ;
                    }
                }
                searchFlalg = true;
                getPolicyList();
            }
        };

        /*重置*/
        $scope.resetForm = function(){
            $scope.policyQueryConditionDto={}
        };

        /*新增批改*/
        $scope.newEndorseLayer = true;
        $scope.newEndorseClick = function(endorseData) {
            if(endorseData.status=="退保"){
                angular.alert("保单状态不为生效或到期，不能进行批改!");
                return;
            }
            var data = {};
            data.policyNo= endorseData.policyNo;
            var dataUrl = '/gscore-pa-web/endorse/validatePolicyForEndorse';
            commFactory.postObject(dataUrl,data).then(
                function(answer){
                    if(answer.data.resultCode=='0000'){
                        $scope.validataAfter(endorseData);
                    }else{
                        $scope.msg = answer.data.resultMessage;
                        $scope.insuredOnlyOneLayer = false;
                    }
             },function(error){

             });
        };
        $scope.validataAfter=function(endorseData){
            $scope.newEndorseLayer = false;
            /*新增弹层*/
            $scope.newEndorseConfirm = function(){

                var start=endorseData.startDate;
                var end=endorseData.endDate;
                var  tbFlag=false;
                if(this.endorseDto.endorType=='02'){
                    tbFlag=true;
                }

                if((!start || !end)&& !tbFlag ){
                    angular.alert("获取不到保单的起保日期和终保日期!");
                    return ;
                }

                var sDate = new Date(start.replace(/-/g,"/") );
                var eDate = new Date(end.replace(/-/g,"/") );
                var tDate=new Date(this.endorseDto.validDate.replace(/-/g,"/") );
                sDate.setHours(0);
                sDate.setMinutes(0);
                sDate.setSeconds(0);

                eDate.setHours(0);
                eDate.setMinutes(0);
                eDate.setSeconds(0);

                if((tDate<sDate || tDate>eDate) && !tbFlag ){
                    angular.alert("批改生效日必须在保单承保期间之内!");
                    return ;
                }

                if(this.newEndorseLayerForm.$valid){
                    var selectVal = this.endorseDto.endorType;
                    var policyNo = endorseData.policyNo;
                    var endorDate = this.endorseDto.endorDate;
                    var validDate = this.endorseDto.validDate;
                    if(selectVal == '01'){
                        $state.go("main.endorseInsured",{"policyNo":policyNo,"endorType":selectVal,"endorDate":endorDate,"validDate":validDate});
                    }else if(selectVal == '02'){
                        var data = this.endorseDto;
                        data.policyNo = policyNo;
                        $state.go("main.endorseSurrend",{"policyNo":policyNo,"endorType":selectVal,"endorDate":endorDate,"validDate":validDate})
                    }else{
                        //无序批改校验
                        var data = {};
                        data.policyNo = endorseData.policyNo;
                        data.validDate = this.endorseDto.validDate;
                        data.endorType = this.endorseDto.endorType;
                        var dataUrl = '/gscore-pa-web/endorse/validateStatusForEndorse';
                        commFactory.postObject(dataUrl,data).then(
                            function(answer){
                                if(answer.data.resultCode!='0000'){
                                    $scope.msg = answer.data.resultMsg;
                                    $scope.insuredOnlyOneLayer = false;
                                    return;
                                }else{
                                    $state.go("main.endorseBusiness",{"policyNo":policyNo,"endorType":selectVal,"endorDate":endorDate,"validDate":validDate})
                                }
                            },function(error){
                                console.log(JSON.stringify(error.data));
                            });
                    }
                }else{
                    FormFocus.focusEle("newEndorseLayerForm");
                    return
                }
            };
            $scope.validDateFlag=false;
            $scope.$watch("endorseDto.endorType",function(){
               if($scope.endorseDto && $scope.endorseDto.endorType)
                if($scope.endorseDto.endorType=='02'){
                    $scope. validDateFlag=true;
                }else{
                    $scope.validDateFlag=false;
                }

            });

            //批改生效日的默认值
            var minDate = new Date();
            minDate.setDate(minDate.getDate()+1);
            $scope.endorseDto ={};
            $scope.endorseDto.validDate= $filter("date")(minDate, "yyyy-MM-dd");

            //设置批改申请日的 默认值
            minDate=new Date();
            $scope.endorseDto.endorDate= $filter("date")(minDate, "yyyy-MM-dd");


        };
        $scope.newEndorsehide = function(){
            $scope.newEndorseLayer = true;
        };

        $scope.insuredOnlyOneClose=function(){
            $scope.insuredOnlyOneLayer = true;
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };


    };
    moduleApp.controller('endorseCtrl',['$scope','$state','endorseServ','$filter','commFactory','FormFocus',endorseCtrl]);
});