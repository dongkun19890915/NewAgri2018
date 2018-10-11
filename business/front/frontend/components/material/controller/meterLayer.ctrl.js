/**
 * Created by GuoXiangLian on 2016/12/9.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var meterLayerCtrl = function($scope,materialServ,$state,FileUploader,FormFocus) {
        $scope.newMaterialLayer = true;
        var deleteFileId ="";
        if(!$scope.imgFile){
            $scope.imgFile={prpImgFileIndexDto:{},prpImgFileMainDto:{}};
            $scope.prpImgFile={}
        }
        $scope.showFilePath="";
        if(!$scope.prpImgFile){
            $scope.prpImgFile={};
        }

        var fileUploader;
        var initUploader = function(){
            if(angular.isDefined(fileUploader)){
                return;
            }
            fileUploader = $scope.fileUploader = new FileUploader({
                url: '/comm-fileserver/uploadFile',
                formData : [{userCode:$scope.currentUser.userCode},{systemId:'PA'},{bussType:'POLICY'}],
                queueLimit: 2,   //文件个数
                autoUpload:false,
                removeAfterUpload: true  //上传后从队列中清除
            });
            fileUploader.onErrorItem = function(fileItem, response, status, headers) {
                angular.alert("文件上传失败:"+fileItem.file.name);
            };
            fileUploader.onSuccessItem = function(fileItem, response, status, headers) {
                //console.info('文件上传完成');
                processInsuredData(response.resultObj);
            };
            fileUploader.onAfterAddingFile = function(fileItem) {
                var queueLength = fileUploader.queue.length;
                if( 1 != queueLength){
                    var index = fileUploader.getIndexOfItem(fileItem);
                    if(angular.isDefined(fileUploader.queue[index-1])){
                        fileUploader.removeFromQueue(index-1);
                    }
                }
                //文件大小限制
                if(fileItem.file.size>(20*1024*1024)){
                    angular.alert("文件大小不能超过20MB");
                    return;
                }
                $scope.imgFile.showFilePath = fileItem.file.name;
            };

        };

        //初始化uploader
        initUploader();

        $scope.clearItems = function(){
            fileUploader.clearQueue();
            $scope.imgFile.showFilePath = "";
        };

        $scope.submitUploadFile = function(){
            if(fileUploader.queue.length == 0){
                angular.alert("请选择文件");
                return;
            }
            if(!$scope.meterfileUploadForm.$valid){
                FormFocus.focusEle("meterfileUploadForm");
                return;
            }
            if(angular.isDefined(fileUploader) && fileUploader.isUploading){
                angular.alert("文件正在上传中");
                return;
            }
            fileUploader.uploadAll();

        };

        var processInsuredData = function(uploadResp){
            var imgFileData=$scope.imgFile;
            imgFileData.prpImgFileIndexDto.typePathName=$("#uploadWjlx"+imgFileData.prpImgFileMainDto.bussType).find(".ui-select-match-text").text();
            $scope.processImport = true;
            $scope.isActive=true;

            if(uploadResp.resultCode=='0000'){
                imgFileData.fileId = uploadResp.fileId;
                imgFileData.riskCode=$scope.fileDto.riskCode;
                imgFileData.fileType = $scope.fileDto.fileType;
                imgFileData.globalUserCode = $scope.user.userCode;
                materialServ.saveFileId(imgFileData).then(
                    function(answer){
                        if(answer.data.resultCode=="0000"){
                            $scope.textField="";
                            angular.alert("上传成功");
                            $scope.uploadDisabled = false;
                            $scope.exitMask();
                            $scope.fileDto.riskCode = '';
                            $scope.fileDto.fileType = '';
                            $scope.meterfileUploadForm.$setPristine();
                            $scope.clearItems();
                        }else{
                            $scope.message=answer.data.resultMsg;
                            $scope.materialFailLayer = false;
                            $scope.uploadDisabled = false;
                        }
                        $scope.processImport = false;
                    },
                    function(error){
                        angular.alert("出现异常，联系管理员");
                        $scope.uploadDisabled = false;
                    }
                );
            }else{
                angular.alert(uploadResp.resultMsg)
            }
        };
    };
    moduleApp.controller('meterLayerCtrl',['$scope','materialServ','$state','FileUploader','FormFocus',meterLayerCtrl]);
});
