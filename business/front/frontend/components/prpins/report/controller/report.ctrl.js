/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportCtrl = function($scope,$state,reportServ,FormFocus) {
        var preBizType='C';
        /*查询被保人清单*/
        /*tab切换响应方法*/
        var sortFlag=true;
        $scope.reportLeft = true;
        $scope.reportRight = true;
        $scope.proposalName = false;
        $scope.reportTable = false;
        $scope.reportTable1 = false;
        $scope.reportTable2 = false;
        $scope.bizTypeT = false;
        $scope.bizTypeC = true;
        var policyNoSort=function(){
            $scope.desc1=true;
            $scope.col='policyNo';
            $scope.desc=$scope.desc1;
            $scope.resultSort(1);
        };
        /*排序图标方法*/
        $scope.resultSort=function(num) {
            for(var i=0;i<=4;i++){
                if(i !=num){
                    eval("("+"$scope.desc"+i+"=''"+")");
                }
            }
        };
        $scope.reportRadioClick = function () {
           $scope.PolicyQueryConditionDto.bizType = 'C';
           $scope.bizTypeT = false;
           $scope.bizTypeC = true;
            preBizType=$scope.PolicyQueryConditionDto.bizType;
            $scope.reportLeft = true;
            $scope.reportRight = true;
            $scope.proposalName = false;
            $scope.reportTable = false;
            $scope.reportTable1 = false;
            $scope.reportTable2 = false;
            $scope.PolicyQueryConditionDto.status="";
            $scope.PolicyQueryConditionDto.statusName="";
            $scope.PolicyQueryConditionDto.bizNo="";
        };

        $scope.reportRadioClick1 = function () {
            $scope.PolicyQueryConditionDto.bizType = 'T';
            $scope.bizTypeT = true;
            $scope.bizTypeC = false;
            $scope.reportLeft = false;
            $scope.reportRight = false;
            $scope.proposalName = true;
            $scope.reportTable = true;
            $scope.reportTable1 = true;
            $scope.reportTable2 = true;
            $scope.PolicyQueryConditionDto.bizNo="";
        };
        var searchFlalg=false;
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            if(!$scope.reportSearchForm.$valid){
                FormFocus.focusEle("reportSearchForm");
                return;
            }
            var policyDto = {};
            if($scope.PolicyQueryConditionDto.startDateBegin==undefined){
                $scope.PolicyQueryConditionDto.startDateBegin='';
            }
            if($scope.PolicyQueryConditionDto.startDateEnd==undefined){
                $scope.PolicyQueryConditionDto.startDateEnd='';
            }

            policyDto.bizNo = $scope.PolicyQueryConditionDto.bizNo;
            policyDto.applyName = $scope.PolicyQueryConditionDto.applyName;
            policyDto.identifyType = $scope.PolicyQueryConditionDto.identifyType;
            policyDto.identifyNumber = $scope.PolicyQueryConditionDto.identifyNumber;
            policyDto.status = $scope.PolicyQueryConditionDto.status;
            policyDto.startDateBegin = $scope.PolicyQueryConditionDto.startDateBegin;
            policyDto.startDateEnd = $scope.PolicyQueryConditionDto.startDateEnd;
            policyDto.operatorCode = $scope.PolicyQueryConditionDto.operatorCode;
            policyDto.handler1Code = $scope.PolicyQueryConditionDto.handler1Code;
            if((policyDto.bizNo == '' || policyDto.bizNo == undefined )
                && (policyDto.applyName == '' || policyDto.applyName == undefined)
                && (policyDto.identifyType == '' || policyDto.identifyType == undefined )
                && (policyDto.identifyNumber== '' || policyDto.identifyNumber== undefined )
                && (policyDto.startDateBegin== '' || policyDto.startDateBegin== undefined )
                && (policyDto.startDateEnd== '' || policyDto.startDateEnd== undefined )
                && (policyDto.operatorCode== '' || policyDto.operatorCode== undefined )
                && (policyDto.status== '' || policyDto.status== undefined )
                && (policyDto.handler1Code== '' || policyDto.handler1Code== undefined)){
                angular.alert("必须输入至少一项搜索条件。");
                return
            }else if((policyDto.bizNo == '' || policyDto.bizNo == undefined )
                && (policyDto.applyName == '' || policyDto.applyName == undefined)
                && (policyDto.identifyType != '' || policyDto.identifyType != undefined
                    || policyDto.status != undefined|| policyDto.status != undefined)
                && (policyDto.identifyNumber== '' || policyDto.identifyNumber== undefined )
                && (policyDto.startDateBegin== '' || policyDto.startDateBegin== undefined )
                && (policyDto.startDateEnd== '' || policyDto.startDateEnd== undefined )
                && (policyDto.operatorCode== '' || policyDto.operatorCode== undefined )
                && (policyDto.handler1Code== '' || policyDto.handler1Code== undefined)){
                angular.alert("请输入至少一项其他保单信息。");
                return
            }else if(policyDto.startDateBegin== ''&& policyDto.startDateEnd !=''){
                angular.alert('请输入保单生效日（开始）。');
                return
            }else if(policyDto.startDateBegin!= ''&& policyDto.startDateEnd == ''){
                angular.alert('请输入保单生效日（结束）。');
                return
            }
            if($scope.PolicyQueryConditionDto.startDateBegin && $scope.PolicyQueryConditionDto.startDateEnd){
                var beginTime=$scope.PolicyQueryConditionDto.startDateBegin.replace(/\-/g,"/");
                var endTime=$scope.PolicyQueryConditionDto.startDateEnd.replace(/\-/g,"/");
                var d1=new Date(beginTime);
                var d2=new Date(endTime);
                if(d1.getTime()>d2.getTime()){
                    angular.alert("保单生效日（开始）不能大于保单生效日（结束）！");
                    return;
                }
                if(d1&&d2){
                    d1.setMonth(d1.getMonth()+6);
                    if(d2>d1)
                    {
                        angular.alert("保单生效日（结束）不能晚于保单生效日（开始）之后6个月。");
                        return;
                    }
                }
            }
            if(!$scope.PolicyQueryConditionDto.identifyType&&$scope.PolicyQueryConditionDto.identifyNumber){
                angular.alert("投保人证件号码必须和投保人证件类型一起录才能进行查询！");
                return;
            }
            $scope.PolicyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.PolicyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            var PolicyQueryConditionDto = $scope.PolicyQueryConditionDto;
            //statusRange
            if($scope.PolicyQueryConditionDto.bizType=='T'){
                PolicyQueryConditionDto.statusRange=['1','2','3'];
            }else if($scope.PolicyQueryConditionDto.bizType == 'C'){
                PolicyQueryConditionDto.statusRange=['4','5','6'];
            }
            reportServ.reportSearch(PolicyQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.reportData=answer.data.list;
                    if($scope.reportData.length!=0){
                        if(sortFlag){
                            policyNoSort();
                            sortFlag=false;
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        //初始化界面
        var initFunc = function(){
            //初始化分页
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 10,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20,30,40,50]   // 可选择显示条数的数组
            };
            $scope.PolicyQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage,bizType:"C"};

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);
        };
        initFunc();
        $scope.resetSearchForm=function(){
            $(".validation-errorText").css('display','none');
            $scope.reportSearchForm.$setPristine();
            $scope.PolicyQueryConditionDto = {};
           $scope.PolicyQueryConditionDto.bizNo = '';
           $scope.PolicyQueryConditionDto.identifyNumber = '';
           $scope.PolicyQueryConditionDto.operatorCode = '';
           $scope.PolicyQueryConditionDto.handler1Code = '';
        };
        /*保单综合查询方法响应事件*/
        $scope.reportQuery = function(){
            searchFlalg = true;
            getInsuredList();
        };
        /*投保单号码*/
        $scope.reportProposal = function(d){
            if($scope.reportTable2){
                $state.go("main.proposal",{"policyNo": d.proposalNo,'policyDetailParam':'proposal',"bussType":"T"})
            }else{
                $state.go("main.reportTab",{"policyNo": d.policyNo,"bussType":"C"})
            }

        };
        /*保单号码*/
        $scope.reportPolicy = function(policyNo){
            $state.go("main.reportTab",{"policyNo":policyNo,"bussType":"C"})
        };
        /**提示框相关方法**/
        $scope.alert=function(opt){
            $scope.showAlertMsg=opt.msg;
            $scope.showAlertOneLayer=true;
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        };

        var parseDate=function(str){
            if(typeof str == 'string'){
                var results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);
                if(results && results.length>3)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]));
                results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);
                if(results && results.length>6)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]));
                results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);
                if(results && results.length>7)
                    return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]),parseInt(results[7]));
            }
            return null;
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
    };

    moduleApp.controller('reportCtrl',['$scope','$state','reportServ','FormFocus',reportCtrl]);

});
