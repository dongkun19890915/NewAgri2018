/**
 * Created by COCO on 2016/9/19.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var offLineChargeConfirmEndorseCtrl = function($scope,offLineChargeConfirmEndorseServ,$stateParams,$state,$filter) {

        var searchFlalg = false;
        /*查询方法*/
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.proposalInfoDto.pageNo=$scope.paginationConf.currentPage;
            $scope.proposalInfoDto.pageSize=$scope.paginationConf.itemsPerPage;
            offLineChargeConfirmEndorseServ.comfirmQuery($scope.proposalInfoDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.pendingdata=answer.data.list;
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
                pagesLength: 15,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30, 40, 50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.paginationConf.currentPage,
                                      pageSize:$scope.paginationConf.itemsPerPage};

            /*监控翻页按钮变化*/
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);

            /*保单生效日应该为当前日期*/
            var operateDate = new Date();
            $scope.proposalInfoDto.startDateBegin = $filter("date")(operateDate, "yyyy-MM-dd");
        };
        initFunc();
        $scope.comfirmCharge = function(proposalNo){
            var proposalDto = {};
            var prptmain = {};
            prptmain.riskCode = 'EQ01';
            prptmain.classCode = '01';
            prptmain.proposalNo = proposalNo;
            proposalDto.prpTmain = prptmain;
            proposalDto.proposalNo = proposalNo;
            offLineChargeConfirmEndorseServ.confirmSave(proposalDto).then(
                function(answer){
                    var policyNo =  answer.data.policyNo;
                    $state.go('main.offLineChargeSuccess',{"policyNo":policyNo})
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*查询方法响应事件*/
        $scope.offLineChargeConfirmQuery = function(){
            searchFlalg = true;
            getInsuredList();
        };
        /*重置*/
        $scope.resetForm = function(){
            $scope.proposalInfoDto={}
        };
        /*退出*/
        $scope.confirmEndorseEdit = function(){
            $state.go("main.index")
        };
        /*确认收费*/
        $scope.confirmEndorseSubmit = function(){
            //获取到表单是否验证通过
            if($scope.chargeConfirmEndorseForm.$valid){
                console.log('表单通过验证');
            }else{
                FormFocus.focusEle("chargeConfirmEndorseForm");
                return
            }
        }
    };
    moduleApp.controller('offLineChargeConfirmEndorseCtrl',['$scope','offLineChargeConfirmEndorseServ','$stateParams','$state','$filter',offLineChargeConfirmEndorseCtrl]);
});
