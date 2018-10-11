/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var expensesCtrlHandler =function ($scope,expensesServ,$state) {
        $scope.expensesMaintainBackLayer=true;
        /*分页初始化*/
        var searchFlalg=false;
        var getInsuredList = function(){
            /*初始化排序*/
           $scope.col=['-versionNo','salesRate'];
            if(!searchFlalg){
                return;
            }
            var conditionDto = $scope.conditionDto;
            $scope.conditionDto.pageNo = $scope.paginationConf.currentPage;
            $scope.conditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            if(conditionDto == '' || conditionDto == null){
            }
            expensesServ.expensesInit(conditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.expensesData=answer.data.list;

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        var riskQuery = function () {
            var conditionDto = {};
            expensesServ.riskQuery(conditionDto).then(
                function (answer) {
                    $scope.riskList = answer.data;
                }
            );
        };
        var initPage = function(){
            // 初始化产品
            riskQuery();
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
        };
        initPage();
        /*跳转到下一个页面*/
        $scope.expensesNew = function(){
            $state.go("main.expensesMaintain");

        };
        /*退出*/
        $scope.expensesBack=function(){
           $state.go("main.index");
        };
        $scope.backTrue=function(){
            $scope.expensesMaintainBackLayer=true;

        };
        $scope.backFalse=function(){
            $scope.expensesMaintainBackLayer=true;
        };
        /*搜索按钮*/
        $scope.expensesQuery = function(){
            searchFlalg = true;
            $scope.paginationConf.currentPage=1;
            getInsuredList();
        };
        /*重置按钮*/
        $scope.expensesReset = function(){
            $scope.conditionDto.businessNature="";
            $scope.conditionDto.issueDate="";
            $scope.conditionDto.businessName="";
            $scope.conditionDto.riskCode="";
        };
    };
    moduleApp.controller('expensesCtrl',['$scope','expensesServ','$state',expensesCtrlHandler]);
});