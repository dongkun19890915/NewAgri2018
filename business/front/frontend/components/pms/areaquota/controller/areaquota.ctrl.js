/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var areaquotaCtrlHandler = function ($scope,areaquotaServ,$state,QuerySelectCode) {
        $scope.areaquotaDetailsLayer=true;
        $scope.areaquotaMaintainBackLayer=true;
        /*排序图标方法*/
        $scope.resultSort=function(num) {
            for(var i=0;i<=3;i++){
                if(i !=num){
                    eval("("+"$scope.desc"+i+"=''"+")");
                }
            }
        };
        /*分页初始化*/
        var searchFlalg=false;
        var getInsuredList = function(){
            $scope.col=['-versionNo','salesLimit'];
            if(!searchFlalg){
                return;
            }
            //$scope.conditionDto.areaCode=$scope.PrpTinsuredPropDto.provinceCode;
            $scope.conditionDto.pageNo = $scope.paginationConf.currentPage;
            $scope.conditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            var conditionDto = $scope.conditionDto;
            if(conditionDto == '' || conditionDto == null){
            }
            areaquotaServ.areaquotaInit(conditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.areaquotaData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        var initPage = function(){
            $scope.paginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 10,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30 , 40, 50]   // 可选择显示条数的数组
            };
            $scope.conditionDto = {
                pageNo: $scope.paginationConf.currentPage,
                pageSize: $scope.paginationConf.itemsPerPage
            };
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);
        };
        initPage();
        /*跳转到下一个页面*/
        $scope.areaquotaAdd = function(){
            $state.go("main.areaquotaMaintain",{reload: true});

        };

        /*搜索按钮*/
        $scope.areaquotaQuery = function(){
           $scope.paginationConf.currentPage=1;
            //initPage();
            searchFlalg = true;
            getInsuredList();
        };
        /*弹层--退出*/
        $scope.areaquotaBack=function(){
            $state.go("main.index");
        };
        $scope.backFalse=function(){
            $scope.areaquotaMaintainBackLayer=true;
        };
        /*弹层-版次号查看*/
        $scope.areaquotaDetailsLayer=true;
        $scope.areaquotaDetailsLook=function(number){
            // $scope.communityMemberDetailsLayer=false;
            var conditionDto={};
            conditionDto.versionNo=number;
            conditionDto.pageSize=99;
            areaquotaServ.areaquotaInit(conditionDto).then(
                function(answer){
                    $scope.list="salesLimit";
                    $scope.versionNumber=answer.data.list;
                    $scope.areaquotaDetailsLayer=false;

                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*版次号弹层关闭*/
        $scope.areaquotaDetailsLayerClose=function(){
            $scope.areaquotaDetailsLayer=true;
        };
        /*重置按钮*/
        $scope.areaquotaReset = function(){
            $scope.conditionDto.areaCode="";
            $scope.conditionDto.issueDate="";
            $scope.conditionDto.versionNo="";

        };



        /*
         *以下代码请勿修改
         *级联下拉菜单
         * *
         * */
        var queryData = function(condition){
            var promise = QuerySelectCode.getData(condition);
            promise.then(
                function(answer){
                    console.log("data:"+JSON.stringify(answer.data));
                },function(error){
                    //console.log("error:"+JSON.stringify(error));
                }
            );
            return promise;
        };

        /*界面初始化为省市区下拉框赋值*/
        var initSelect = function(){
            var provinceCode = $scope.conditionDto.areaCode;
            doSelect("000000",provinceCode,""); //省下拉框的上级默认为000000
        };

        /**
         * controller数据初始化总方法
         */
        var initArea = function(){
            if(!angular.isDefined($scope.conditionDto)){
                $scope.conditionDto = {};
            }
            if(!angular.isDefined($scope.conditionDto.areaCode)){
                $scope.conditionDto.areaCode = "";
            }
            /**
             * 页面打开时，初始化完给下拉框赋值
             */
            $scope.$watch('conditionDto.areaCode',function(){
                console.log("watch:"+$scope.conditionDto.areaCode);
                initSelect();
            });
        };

        /**
         * 处理下拉框选中赋值
         * @author ZhangJiansen
         * @param upperCode 上级下拉框值
         * @param codeCode  要给下拉框赋的值
         * @param flag 被选中的下拉框
         */
        var doSelect = function(upperCode,codeCode,flag){
            var condition = {codeType:"AreaCode",upperCode:upperCode};
            $scope.provinceList = [];
            queryData(condition).then(
                function (answer) {
                    $scope.provinceList = answer.data.codeData;
                }, function (error) {
                    $scope.provinceList = [];
                    //console.log(error.data);
                }
            );
        };

        /**
         * 区域下拉框选择响应方法
         */
        $scope.selectCode = function (item, flag) {
            //doSelect(item.codeCode,"",flag);
        };
        initArea();

    };

    moduleApp.controller('areaquotaCtrl',['$scope','areaquotaServ','$state','QuerySelectCode',areaquotaCtrlHandler]);
});