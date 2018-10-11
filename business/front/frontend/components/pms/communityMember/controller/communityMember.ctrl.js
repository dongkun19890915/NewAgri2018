/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var communityMemberCtrl = function ($scope,communityMemberServ,$state) {
        $scope.communityMemberMaintainBackLayer=true;
        /*分页初始化*/
        var searchFlalg=false;
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            /*默认排序*/
            $scope.col=['-versionNo','coinsRate'];
            var conditionDto = {};
            $scope.conditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.conditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            conditionDto = $scope.conditionDto;
            communityMemberServ.communityMemberInit(conditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.communityMemberData1=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*共同体成员公司下拉框初始化*/
        var companyMemberInitialize=function(){
            $scope.parameter = {"upperComCode": "000000","comType":"01"};
            var PrpDCompanyDto = $scope.parameter;
            communityMemberServ.companyMemberInit(PrpDCompanyDto).then(
                function(answer){
                    $scope.communityCompany=answer.data;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*初始化产品列表*/
        var riskQuery = function () {
            var conditionDto = {};
            communityMemberServ.riskQuery(conditionDto).then(
                function (answer) {
                    $scope.riskList = answer.data;
                }
            );
        };
        var initPage = function(){
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 0,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30,40,50]   // 可选择显示条数的数组
            };
            $scope.conditionDto = {
                pageNo: $scope.paginationConf.currentPage,
                pageSize: $scope.paginationConf.itemsPerPage
            };

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);
            /*共同体成员公司下拉框初始化*/
            companyMemberInitialize();
            riskQuery();
        };
        initPage();

        /*搜索按钮*/
        $scope.communityMemberQuery = function(){
            searchFlalg = true;
            $scope.paginationConf.currentPage=1;
            getInsuredList();
        };
        /*弹层-版次号查看*/
        $scope.communityMemberDetailsLayer=true;
        $scope.communityMemberDetails=function(versionNo,riskCode){
           // $scope.communityMemberDetailsLayer=false;
            var conditionDto={};
            conditionDto.versionNo=versionNo;
            conditionDto.riskCode=riskCode;
            conditionDto.pageSize=99;
            communityMemberServ.communityMemberInit(conditionDto).then(
                function(answer){
                   $scope.list="coinsRate";
                   $scope.versionNumber=answer.data.list;
                    $scope.communityMemberDetailsLayer=false;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*退出弹层*/
        $scope.communityMember=function(){
            $scope.communityMemberMaintainBackLayer=false;
        };
        $scope.backTrue=function(){
            $state.go("main.communityMember",{reload:true});
            $state.go("main.communityMember");
            $scope.communityMemberMaintainBackLayer=true;

        };
        $scope.backFalse=function(){
            $scope.communityMemberMaintainBackLayer=true;
        };
        /*新增版次页面跳转*/
        $scope.communityMemberNew = function() {
            $state.go("main.communityMemberMaintain");
        };
        /*重置按钮*/
        $scope.communityMemberReset = function(){
            $scope.conditionDto.versionNo="";
            $scope.conditionDto.issueDate="";
            $scope.conditionDto.comCode="";
            $scope.conditionDto.riskCode="";
        };
        /*退出按钮*/
        $scope.communityMemberExit = function(){
            $state.go("main.index");
        };
        /*弹层关闭*/
        $scope.communityMemberDetailsClose=function(){
            $scope.communityMemberDetailsLayer=true;
        }
    };

    moduleApp.controller('communityMemberCtrl',['$scope','communityMemberServ','$state',communityMemberCtrl]);
});