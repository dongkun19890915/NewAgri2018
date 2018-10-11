/**
 * Created by COCO on 2016/9/17.
 * Modify by SunLexi on 2016/10/06.
 * 待处理核批查询控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var underwriteCtrl = function($scope,$state,underwriteServ) {
        //公共弹层默认不显示
        $scope.insuredOnlyOneLayer = true;
        /*待处理核批查询*/
        var searchFlalg=false;
        var getApprovalList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.EndorseQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.EndorseQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            underwriteServ.approvalSearch($scope.EndorseQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.approvalData=answer.data.list;
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
                perPageOptions: [10, 20, 30, 40, 50]   // 可选择显示条数的数组
            };
            $scope.EndorseQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getApprovalList);

            /*待处理核批查询方法响应事件*/
            $scope.approvalQuery = function(){
                searchFlalg = true;
                getApprovalList();
            };

            /*重置*/
            $scope.resetForm = function(){
                $scope.EndorseQueryConditionDto={}
            };

            /*核批处理*/
            $scope.underwriteClick = function(approvalData){
                underwriteServ.approvalValidate(approvalData).then(
                    function(answer){
                        if(answer.data.resultCode != '0000'){
                            $scope.msg=answer.data.resultMsg;
                            $scope.insuredOnlyOneLayer = false;
                            return;
                        }else{
                            if(answer.data.endorseType == '01'){
                                $state.go("main.underwriteInsured",{"applyNo":approvalData.applyNo,"policyNo":approvalData.policyNo});
                            }else if(answer.data.endorseType == '03'){
                                $state.go("main.underwriteBus",{"applyNo":approvalData.applyNo,"policyNo":approvalData.policyNo});
                            }else{
                                $state.go("main.underwriteSur",{"applyNo":approvalData.applyNo,"policyNo":approvalData.policyNo});
                            }

                        }
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            };
        };
        initFunc();
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
        //关闭公共弹层
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
    };

    moduleApp.controller('underwriteCtrl',['$scope','$state','underwriteServ',underwriteCtrl]);

});
