/**
 * Created by zkr22 on 2016/10/21.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var materialCtrl = function($scope,materialServ,$state) {

        /*初始化数据*/
        var globalUserCode =$scope.user.userCode;
        $scope.materialSucLayer = true;
        $scope.materialFailLayer = true;
        $scope.newMaterialLayer = true;
        $scope.fileDto = {"createBy":globalUserCode};
        $scope.RiskQueryConditionDto={};
        $scope.uploadDisabled = false;
        $scope.deleteLayer = true;
        /*分页查询*/
        var searchFlag = false;
        var getFileList = function(){
            if(!searchFlag){
                return;
            }
            $scope.fileDto.pageNo=$scope.paginationConf.currentPage;
            $scope.fileDto.pageSize=$scope.paginationConf.itemsPerPage;
            var data = $scope.fileDto;
            materialServ.fileQuery(data).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.queryFileData =answer.data.list;
                },
                function(error){
                    console.log(JSON.stringify(error.date));
                }
            )
        };
        /*获取险种产品*/
        var queryRisk = function(){
            materialServ.riskQuery($scope.RiskQueryConditionDto).then(
                function(answer){
                    $scope.riskList = answer.data;
                },function(error){
                    console.log(JSON.stringify(error.date));
                }
            );
        };
        /* 分页初始化 */
        var initPage = function(){
            $scope.paginationConf = {
                currentPage : 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage : 10, // 每页展示的数据条数
                pagesLength : 10, // 分页条目的长度（如果设置建议设置为奇数）
                perPageOptions : [ 10, 20, 30,40,50 ]
                // 可选择显示条数的数组
            };
            queryRisk();
            $scope.fileDto = {
                pageNo : $scope.paginationConf.currentPage,
                pageSize : $scope.paginationConf.itemsPerPage
            };
            //searchFlag = true;
            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage',getFileList);
        };
        initPage();

        /*搜索按钮*/
        $scope.queryFile =function(){
            searchFlag = true;
            getFileList();
        };
        /*重置按钮*/
        $scope.restFile= function(){
            $scope.fileDto.fileType="";
            $scope.fileDto.riskCode="";
        };

        /*下载按钮*/
        $scope.downloadFileInfo = function(shortLinkId){
            console.log(shortLinkId);
            if(!shortLinkId){
                angular.alert("未找到下载文件");
                return;
            }
            window.open('/comm-fileserver/downloadFileByShortLinkId?shortLinkId='+shortLinkId);

        };

        var deleteFileId ="";
        /*删除按钮*/
        $scope.fileDelete = function(id){
            $scope.deleteLayer = false;
            deleteFileId =  id;
        };
        /*删除弹层确定按钮*/
        $scope.deleteSure= function(){
            var fileDto ={"id":deleteFileId};
            materialServ.deleteFile(fileDto).then(
                function(answer){
                    if(answer.data.resultCode =="0000"){
                        //弹层：删除成功
                        $scope.deleteLayer = true;
                        $scope.message = answer.data.resultMsg;
                        $scope.materialSucLayer = false;
                        $scope.queryFile();
                    }else{
                        //弹层：删除失败
                        $scope.deleteLayer = true;
                        //$scope.message = answer.data.resultMsg;
                        //$scope.materialFailLayer = false;
                    }
                },function(error){
                    $scope.deleteLayer = true;
                    //$scope.message = "出现异常，联系管理员"
                    //$scope.materialFailLayer = false;
                }
            )
        };

        /*新增文件按钮*/
        $scope.addFile = function(){
            $scope.newMaterialLayer = false;
        };

        /*退出上传弹层按钮*/
        $scope.exitMask = function(){
            $scope.newMaterialLayer = true;
        };
        /*失败弹层退出按钮*/
        $scope.failClose = function(){
            $scope.materialFailLayer = true;
        };
        /*成功弹层退出按钮*/
        $scope.sucClose = function(){
            $scope.materialSucLayer = true;
            $scope.newMaterialLayer = true;
        };
        /*退出按钮*/
        $scope.exit = function(){
            $state.go("main.index");
        };
        /*删除退出按钮*/
        $scope.deleteCancel = function(){
            $scope.deleteLayer = true;
        }
    };

    moduleApp.controller('materialCtrl',['$scope','materialServ','$state',materialCtrl]);
});