/*
*文件上传
* */
define(['../module'], function (moduleApp) {
    'use strict';
    var applicationFileUploadLayerCtrl = function($scope,applicationFileUploadLayerServ,FormFocus,FileUploader) {
        if(!$scope.imgFile){
            $scope.imgFile={prpImgFileIndexDto:{},prpImgFileMainDto:{}};
            $scope.prpImgFile={}
        }
        $scope.showFilePath="";
        if(!$scope.prpImgFile){
            $scope.prpImgFile={};
            //$scope.prpImgFile.filePath="c://asfa.xtx"
        }
        $scope.insuredOnlyOneClose = function(){
            $scope.insuredOnlyOneLayer = true;
        };
        $scope.insuredOnlyOneLayer = true;
        $scope.processImport = false;
        $scope.imgFileT = true;
        $scope.imgFileE = false;
        $scope.$on("uploadFileShow",function (event, msg) { //监听来自父controller的信息
            if(msg.prpImgFileMainDto.bussType == 'T'){
                $scope.imgFileT = true;
                $scope.imgFileE = false;
            }else{
                $scope.imgFileT = false;
                $scope.imgFileE = true;
            }
            $scope.imgFile=msg;
            $scope.imgFile.prpImgFileIndexDto.typePath = "";
            $scope.queryImgFileList();
        });

        $scope.queryImgFileList=function(){
            var uploadFileCond={};
            uploadFileCond.bussType=$scope.imgFile.prpImgFileMainDto.bussType;
            uploadFileCond.bussNo=$scope.imgFile.prpImgFileMainDto.bussNo;
            uploadFileCond.pageSize=1000;
            uploadFileCond.pageNo=1;
            uploadFileCond.userCode=$scope.user.userCode;
            applicationFileUploadLayerServ.queryUploadFileList(uploadFileCond).then(
                function(answer){
                    $scope.uploadFileList=answer.data.list;
                    for(var i = 0;i<answer.data.list.length; i++) {
                        var upload = $scope.uploadFileList[i];
                        if ("jpg,png,bmp,ico,gif,jpeg,PNG,JPG,BMP,ICO,GIF,JPEG".indexOf(upload.fileExtentName) > -1) {
                            upload.isImg = true;
                            upload.imgUrl = "/comm-fileserver/downloadFile?type=view&fileId=" + upload.fileId + "&img.jpg";
                        } else {
                            upload.isImg = false;
                            upload.fileUrl = "/comm-fileserver/downloadFileByShortLinkId?shortLinkId=" + upload.fileShortId;
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }

            )
        };
        var isImgInit=false;
        $scope.showImgFile=function(d){
            window.open("/comm-fileserver/downloadFileByShortLinkId?shortLinkId="+ d.fileShortId);
        };
        $scope.publicDeleteLayerOne = false;
        $scope.deleteImgFile=function(d){
            $scope.publicDeleteLayerOne = true;
            $scope.publicDeleteConfirmOne = function() {
                var deleteImgFile = {};
                deleteImgFile.imgId = d.imgId;

            applicationFileUploadLayerServ.deleteImgFile(d).then(
                    function (answer) {
                        if(answer.data.resultCode!="0000"){
                            $scope.msg = answer.data.resultCode;
                            $scope.publicDeleteLayerOne = false;
                            $scope.insuredOnlyOneLayer = false;
                            return;
                        }
                        $scope.publicDeleteLayerOne = false;
                        $scope.queryImgFileList();
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }
        };
        //删除按钮关闭
        $scope.publicDeletehideOne = function(){
            $scope.publicDeleteLayerOne = false;
        };
        $scope.isActive=false;

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
            if(!$scope.fileUploadForm.$valid){
                FormFocus.focusEle("fileUploadForm");
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
                imgFileData.prpImgFileIndexDto.fileId=uploadResp.fileId;
                applicationFileUploadLayerServ.saveImgInfo(imgFileData).then(
                    function(answer){
                        $scope.processImport = false;
                        $scope.isActive=false;
                        $scope.queryImgFileList();
                        $scope.imgFile.prpImgFileIndexDto.fileName="";
                        $scope.imgFile.prpImgFileIndexDto.typePath="";
                        $scope.imgFile.prpImgFileIndexDto.remark="";
                        $scope.fileUploadForm.$setPristine();
                        $scope.clearItems();
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }else{
                angular.alert(uploadResp.resultMsg)
            }
        };

        /**提示框相关方法**/
        $scope.alert=function(opt){
            $scope.showAlertMsg=opt.msg;
            $scope.showAlertOneLayer=true;
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        }

    };

    moduleApp.controller('applicationFileUploadLayerCtrl',['$scope','applicationFileUploadLayerServ','FormFocus','FileUploader',applicationFileUploadLayerCtrl]);
});
