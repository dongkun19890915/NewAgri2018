/**
 * Created by COCO on 2016/9/17.
 * Modify by SunLexi on 2016/10/07.
 * 待处理批单查询控制器
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var suspendEndorseCtrl = function($scope,$state,suspendEndorseServ,$filter,FormFocus) {
        /*待处理批单查询*/
        var searchFlalg=false;
        var getSuspendList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.EndorseQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.EndorseQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            suspendEndorseServ.suspendEndorseQuery($scope.EndorseQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.suspendData=answer.data.list;
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

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getSuspendList);

            //设置批改申请日 默认值
            var date=new Date();
            $scope.EndorseQueryConditionDto.endorDateEnd=$filter("date")(date, "yyyy-MM-dd");
            date.setMonth(date.getMonth()-1);
            $scope.EndorseQueryConditionDto.endorDateStart=$filter("date")(date, "yyyy-MM-dd");
            /*待处理批单查询方法响应事件*/
            $scope.suspendQuery = function(){
                //如果录入证件号码，那么证件类型必须有值
                if($scope.EndorseQueryConditionDto.applyIdentifyNumber){
                    if(!$scope.EndorseQueryConditionDto.applyIdentifyType){
                        $scope.alert("使用证件号码进行查询时，请先选择证件类型！");
                    }
                }
                searchFlalg = true;
                getSuspendList();
            };

            /*重置*/
            $scope.resetForm = function(){
                $scope.EndorseQueryConditionDto={}
            };

            /*点击操作的响应事件*/
            $scope.suspendClick = function(suspendData, event) {
                var applyNo = suspendData.applyNo;
                if("查看" == event.innerHTML) {
                    $state.go("main.endorseConfirm",{"applyNo":applyNo,'pageDir':suspendData.endorType,"policyNo":suspendData.policyNo,'oper':'view'});
                }
                else if("继续" == event.innerHTML) {
                    if(suspendData.endorType=='01'){
                        $state.go("main.endorseInsured",{"applyNo":applyNo,'oper':'update',"policyNo":suspendData.policyNo});
                    }else if(suspendData.endorType=='02'){
                        $state.go("main.endorseSurrend",{"applyNo":applyNo,'oper':'update',"policyNo":suspendData.policyNo});
                    }else{
                        $state.go("main.endorseBusiness",{"applyNo":applyNo,'oper':'update',"policyNo":suspendData.policyNo});
                    }
                }else if("删除" == event.innerHTML) {
                    $scope.applyNoTemp=suspendData.applyNo;
                    $scope.deleteLayer = false;

                }
            }
        };
        initFunc();
        //不显示删除弹层
        $scope.deleteLayer = true;
        //删除批单返回后台
        $scope.delReasonFlag = true;
        $scope.endorseUpdateConditionDto = {};
        $scope.$watch("endorseUpdateConditionDto.delReasonCode",function(){
            if($scope.endorseUpdateConditionDto.delReasonCode == '03'){
                $scope.delReasonFlag = false;
            }else{
                $scope.delReasonFlag = true;
            }
        });
        $scope.surrendDeleteConfirm = function(){
            if(!this.deleteEndorseForm.$valid){
                FormFocus.focusEle("deleteEndorseForm");
                return
            }
            var endorseUpdateConditionDto = {};
            endorseUpdateConditionDto.applyNo = $scope.applyNoTemp;
            endorseUpdateConditionDto.delReasonCode = this.endorseUpdateConditionDto.delReasonCode;
            endorseUpdateConditionDto.delReasonDesc = this.endorseUpdateConditionDto.delReasonDesc;
            suspendEndorseServ.deleteApplyNo(endorseUpdateConditionDto).then(
                function(answer){
                    var data = answer.data.endorseUpdateConditionDto;
                    if(answer.data.resultCode != '00'){
                      /*  $state.go("main.endorseDeleteFail",{"applyNo":$scope.applyNoTemp})*/
                        $scope.alert(answer.data.resultMessage);
                        $scope.showAlertOneLayer=true;
                        $scope.deleteLayer = true;
                        return;
                    }else{
                        $state.go("main.endorseDeleteSuccess",{"applyNo":$scope.applyNoTemp})
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        /**提示框相关方法**/
        $scope.alert=function(msg){
            $scope.showAlertMsg=msg;
            $scope.showAlertOneLayer=true;
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        };
        //关闭删除批单弹层
        $scope.surrendDeleteClose = function(){
            $scope.deleteLayer = true;
            $scope.endorseUpdateConditionDto = {};
            $(".validation-errorText").css('display','none');
        };
        /*退出*/
        $scope.onEdit = function(){
            $state.go("main.index");
        }
    };
    moduleApp.controller('suspendEndorseCtrl',['$scope','$state','suspendEndorseServ','$filter','FormFocus',suspendEndorseCtrl]);
});
