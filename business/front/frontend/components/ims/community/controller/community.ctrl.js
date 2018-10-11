/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';

    var communityCtrlHandler = function($scope,communityServ,$state){
        /*查询标志*/
        var searchFlalg=false;
        /*分页查询机构*/
        var queryCompanyPage = function(){
            if(!searchFlalg){
                return;
            }
            if(!checkSearchCondition()){
                return;
            }
            $scope.CompanyConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.CompanyConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            var CompanyConditionDto = $scope.CompanyConditionDto;
            communityServ.queryCompany(CompanyConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.companyData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };

        /*查询条件校验*/
        var checkSearchCondition=function(){
            return true;
        };


        /*查询上级机构列表*/
        var queryUpperCompany = function(UserDto){
            communityServ.upperCompanyQuery(UserDto).then(
                function(answer){
                    $scope.upperCompanyList=answer.data;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        $scope.CompanyConditionDto = {};
        $scope.UserDto = {};
        //初始化界面
        var initFunc = function() {
            /*加载上级机构*/
            var UserDto = $scope.UserDto;
            queryUpperCompany(UserDto);
        };

        initFunc();
        //机构搜索分页
        $scope.paginationConf = {
            currentPage: 1,     //当前所在的页
            totalItems: 0,      //总共有多少条记录
            itemsPerPage: 10,   //每页展示的数据条数
            pagesLength: 10,    //分页条目的长度（如果设置建议设置为奇数）
            perPageOptions: [10, 20,30,40,50]   // 可选择显示条数的数组
        };
        $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', queryCompanyPage);
        /*排序*/
        $scope.col = 'comCName';
        $scope.desc = 0;

        /*点击新增*/
        $scope.communityNew = function(){
            $state.go("main.communityInform")
        };
        /*点击修改*/
        $scope.communityModify = function(company){
            $state.go("main.communityInform",{"continueData":company.comCode});
        };
        /*点击搜索机构*/
        $scope.companyQuery = function(){
            searchFlalg = true;
            queryCompanyPage();
        };
        /*重置*/
        $scope.resetForm = function(){
            $scope.CompanyConditionDto={}
        };
        /*点击退出*/
        $scope.communityExit = function(){
            $state.go("main.index")
        };
    };

    moduleApp.controller('communityCtrl',['$scope','communityServ','$state',communityCtrlHandler]);
});

