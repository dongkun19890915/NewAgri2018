/**
 * Created by COCO on 2016/9/17.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var suspendProposalCtrl = function($scope,$sce,$state,suspendProposalServ,FormFocus) {

        $scope.selectIDType = function (item) {
            console.log("selectIDType1="+JSON.stringify(item));
        };

        /*查询被保人清单*/
        var searchFlalg=false;
        $scope.showAlertConfirmLayer = false;
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.proposalInfoDto.pageNo=$scope.paginationConf.currentPage;
            $scope.proposalInfoDto.pageSize=$scope.paginationConf.itemsPerPage;
            suspendProposalServ.supendProposalQuery($scope.proposalInfoDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    //console.log(JSON.stringify(answer));
                    $scope.proposalData=answer.data.content;
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
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 15,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            searchFlalg=true;
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);


            /*待处理投保单查询方法响应事件*/
            $scope.suspendProposalQuery = function(){
                if(!$scope.suspendProposalForm.$valid){
                    var Ele = $("[name=suspendProposalForm] .ng-invalid:not(ng-form)");
                    $.each(Ele, function (index, ele) {
                        $(ele).addClass('ng-dirty');
                    });
                    if(angular.isDefined(Ele[0]))
                        Ele[0].focus();
                    return;
                }
                if($scope.proposalInfoDto.startDateBegin&&$scope.proposalInfoDto.startDateEnd){
                    var d1=parseDate($scope.proposalInfoDto.startDateBegin);
                    var d2=parseDate($scope.proposalInfoDto.startDateEnd);
                    if(d1.getTime()>d2.getTime()){
                        $scope.showAlertMsg="日期开始时间不能大于结束时间！";
                        $scope.showAlertOneLayer=true;
                        return;
                    }
                }

                searchFlalg = true;
                getInsuredList();
            };

            $scope.resetProposalQuery = function(){
                $scope.proposalInfoDto = {};
            }
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        };
        $scope.showAlertConfirmClose =function(){
            $scope.showAlertConfirmLayer=false;
        };
        initFunc();
        $scope.underWrtErrMsg = "";
        /*待处理投保单继续按钮*/
        $scope.proposalNo="";
        $scope.continueProposal = function(proposalNo){
            var proposalDto = {};
            proposalDto.proposalNo = proposalNo;
            $scope.proposalNo = proposalNo;
            suspendProposalServ.searchUnderWrtStat(proposalDto).then(
                function(answer){
                    var hasProcess = answer.data.hasProcess;
                    var hasErr = answer.data.hasErr;
                    if(answer.data.resultCode == '0000'){
                        if("true" == hasProcess){
                            $scope.showAlertOneLayer = true;
                            $scope.showAlertMsg = "正在处理投保单数据，请稍后再重试。";
                        }else if("false" == hasProcess){
                            if("false" == hasErr){
                                $scope.editProposal(proposalNo);
                            }else if("true" == hasErr){
                                $scope.underWrtErrMsg = $sce.trustAsHtml(answer.data.underWrtErrMsg);
                                $scope.showAlertConfirmLayer = true;
                            }
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        /*编辑投保单界面*/
        $scope.editProposal = function(proposalNo){
            $state.go("main.application",{"continueData":proposalNo,"editType":'editProposal'});
        };

        /*待处理投保单 继续支付按钮*/
        $scope.gotoPay = function(prpTmainDto) {
            if (prpTmainDto.payMode == '02') {
                $state.go("main.offLineCharge", {"proposalNo": prpTmainDto.proposalNo});
            } else {
                $state.go("main.onLineCharge", {"proposalNo": prpTmainDto.proposalNo});
            }
        };

        /*重置*/
        $scope.suspendProposalReset = function(){
            $scope.proposalInfoDto = '';
        };
        /*待处理投保单 删除 */
        $scope.deleteLayer = false;
        $scope.delReasonFlag = true;
        $scope.proposalDelConditionDto = {};
        $scope.deleteProposal=function(proposalNo){
            $scope.deleteLayer = true;
            $scope.proposalDelConditionDto = {};
            $scope.proposalDelConditionDto.proposalNo = proposalNo;
        };
        $scope.$watch("proposalDelConditionDto.delReasonCode",function(){
            if($scope.proposalDelConditionDto.delReasonCode == '04'){
                $scope.delReasonFlag = false;
            }else{
                $scope.delReasonFlag = true;
            }
        });
        $scope.deleteConfirm = function(){
            //判断弹层表单是否通过验证
            if(this.deleteProposalForm.$valid){
                var proposalNo = this.proposalDelConditionDto.proposalNo;
                var proposalDelConditionDto = {};
                proposalDelConditionDto.proposalNo = proposalNo;
                proposalDelConditionDto.delReasonCode = this.proposalDelConditionDto.delReasonName;
                proposalDelConditionDto.delReasonDesc = this.proposalDelConditionDto.delReasonDesc;
                suspendProposalServ.deleteProposal(proposalDelConditionDto).then(
                    function(answer){
                        //$scope.deleteLayer = true;
                        var data = answer.data.proposalNo;
                        if(answer.data.resultCode=="2222") {
                            angular.alert("已删除，不允许重复删除！");
                            $scope.deleteLayer = false;
                        }else if(answer.data.resultCode != '0000'){
                            $state.go("main.applicationDeleteFail",{"proposalNo":data})
                        }else{
                            $state.go("main.applicationDeleteSuccess",{"proposalNo":data})
                        }
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }else{
                FormFocus.focusEle("deleteProposalForm");
                return;
            }
        };

        /* 删除取消*/
        $scope.deletehideInsure = function(){
            $scope.deleteLayer = false;
            $scope.proposalDelConditionDto = {};
            this.deleteProposalForm.$setPristine();
            $(".validation-errorText").css('display','none');
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

    moduleApp.controller('suspendProposalCtrl',['$scope','$sce','$state','suspendProposalServ','FormFocus',suspendProposalCtrl]);
});
