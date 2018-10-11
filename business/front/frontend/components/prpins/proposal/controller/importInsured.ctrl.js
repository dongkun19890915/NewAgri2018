/**
 * Created by GuoXiangLian on 2016/9/29.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var importInsuredCtrl = function($scope,FileUploader)
    {
        if(!$scope.excelFile){
            $scope.excelFile={prpExcelFileIndexDto:{},prpExcelFileMainDto:{}};
            $scope.prpExcelFile={}
        }
        var insuredUploader;
        var initInsuredUploader = function(){
            if(angular.isDefined(insuredUploader)){
                return;
            }
            //console.log("usercode="+$scope.currentUser.userCode);
            insuredUploader = $scope.insuredUploader = new FileUploader({
                url: '/comm-fileserver/uploadFile',
                formData : [{userCode:$scope.currentUser.userCode},{systemId:'PA'},{bussType:'PROPOSAL'}],
                queueLimit: 2,   //文件个数
                autoUpload:false,
                removeAfterUpload: true  //上传后从队列中清除
            });
            insuredUploader.onErrorItem = function(fileItem, response, status, headers) {
                angular.alert("文件上传失败:"+fileItem.file.name);
            };
            insuredUploader.onSuccessItem = function(fileItem, response, status, headers) {
                console.info('文件上传完成');
                $scope.processInsuredData(response.resultObj);
            };
            insuredUploader.onCompleteAll = function() {
                console.info('全部上传完成，队列长度:'+insuredUploader.queue.length);
            };
            insuredUploader.onWhenAddingFileFailed = function(){
                console.log("添加失败");
            };
            insuredUploader.onAfterAddingFile = function(fileItem) {
                var queueLength = insuredUploader.queue.length;
                if( 1 != queueLength){
                    var index = insuredUploader.getIndexOfItem(fileItem);
                    if(angular.isDefined(insuredUploader.queue[index-1])){
                        insuredUploader.removeFromQueue(index-1);
                    }
                }
                var fileName = fileItem.file.name;
                var ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
                //扩展名教研
                if(ext != "xlsx") {
                    angular.alert("上传文件必须为xlsx格式！");
                    return;
                }
                //文件大小限制
                if(fileItem.file.size>(300*1024*1024)) {
                    angular.alert("单次上传的文件请小于超过300MB，若文件过大请分批上传")
                    $scope.clearItems();
                    return;
                }
                $scope.excelFile.textfield = fileItem.file.name;
            };

            };
            var destroyInsuredUploader = function(){
                if(angular.isDefined(insuredUploader)){
                    console.info("insuredUploader destroy");
                    insuredUploader.destroy();
                }
            };
            $scope.hideImport = function(){
                if(angular.isDefined(insuredUploader) && insuredUploader.isUploading){
                    angular.alert("文件正在上传中");
                    return;
                }
                $scope.hideBatchImport();
            };
            $scope.showImport = function(){
                $scope.showBatchImport();
            };
            $scope.InsuredSaveA = function(){
                $scope.InsuredSaveALL();
            };
            //初始化uploader
            initInsuredUploader();

            $scope.clearItems = function(){
                insuredUploader.clearQueue();
                $scope.excelFile.textfield = "";
            };

            $scope.InsuredSaveALL = function(){
                if(angular.isDefined(insuredUploader) && insuredUploader.isUploading){
                    angular.alert("文件正在上传中");
                    return;
                }
                insuredUploader.uploadAll();
            };
            /*下载保保险人导入模板*/
            $scope.downLoadExcel = function(){
                $scope.downLoadExcelModel();
            };
        };
    moduleApp.controller('importInsuredCtrl',['$scope','FileUploader',importInsuredCtrl]);
});