/**
 * 
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var uploadClearFileCtrl = function($scope,$state,uploadClearFileServ,FormFocus,FileUploader) {
        $scope.showAbnormal=false;
        var initUploadFun=function(){
            //初始化设置
            if(!$scope.imgFile){
                $scope.imgFile={prpImgFileIndexDto:{},prpImgFileMainDto:{}};
                $scope.prpImgFile={}
            }
            $scope.showFilePath="";
            if(!$scope.prpImgFile){
                $scope.prpImgFile={};
                //$scope.prpImgFile.filePath="c://asfa.xtx"
            }
            //清分文件上传
            var fileUploader;
            var initUploader = function(){
                if(angular.isDefined(fileUploader)){
                    return;
                }
                fileUploader = $scope.fileUploader = new FileUploader({
                    url: '/comm-fileserver/uploadFile',
                    formData : [{userCode:$scope.currentUser.userCode},{systemId:'PA'},{bussType:'POLICY'}],
                    queueLimit: 1,   //文件个数
                    autoUpload:false,
                    removeAfterUpload: true  //上传后从队列中清除
                });
                fileUploader.onErrorItem = function(fileItem, response, status, headers) {
                    angular.alert("文件上传失败:"+fileItem.file.name);
                };
                fileUploader.onSuccessItem = function(fileItem, response, status, headers) {
                    console.info('文件上传完成');
                    processInsuredData(response.resultObj);
                };

                fileUploader.onAfterAddingFile = function(fileItem) {
                    //上传必须为xlsx
                    var fileName = fileItem.file.name;
                    var ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
                    if(ext != "xlsx"  && ext != "xls") {
                        angular.alert("上传文件必须为excel！");
                        $scope.clearItems();
                        return;
                    }
                    $scope.imgFile.showFilePath = fileItem.file.name;
                };

            };
        };

        //初始化设置
        if(!$scope.imgFile){
            $scope.imgFile={prpImgFileIndexDto:{},prpImgFileMainDto:{}};
            $scope.prpImgFile={}
        }
        $scope.showFilePath="";
        if(!$scope.prpImgFile){
            $scope.prpImgFile={};
            //$scope.prpImgFile.filePath="c://asfa.xtx"
        }
        //清分文件上传
        var fileUploader;
        var initUploader = function(){
            if(angular.isDefined(fileUploader)){
                return;
            }
            fileUploader = $scope.fileUploader = new FileUploader({
                url: '/comm-fileserver/uploadFile',
                formData : [{userCode:$scope.currentUser.userCode},{systemId:'PA'},{bussType:'POLICY'}],
                queueLimit: 1,   //文件个数
                autoUpload:false,
                removeAfterUpload: true  //上传后从队列中清除
            });
            fileUploader.onErrorItem = function(fileItem, response, status, headers) {
                angular.alert("文件上传失败:"+fileItem.file.name);
            };
            fileUploader.onSuccessItem = function(fileItem, response, status, headers) {
                console.info('文件上传完成');
                processInsuredData(response.resultObj);
            };
            
            fileUploader.onAfterAddingFile = function(fileItem) {
                //上传必须为xlsx
                var fileName = fileItem.file.name;
                var ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
                 if(ext != "xlsx"  && ext != "xls") {
                    angular.alert("上传文件必须为excel！");
                    $scope.clearItems();
                    return;
                }
                $scope.imgFile.showFilePath = fileItem.file.name;
            };

        };
        //初始化uploader
        initUploader();
        $scope.clearItems = function(){
            //window.location.reload();
            fileUploader.clearQueue();
            initUploadFun();
           // $scope.imgFile.showFilePath = "";

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
            imgFileData.prpImgFileIndexDto.typePathName=$("#uploadWjlx"+imgFileData.prpImgFileMainDto.bussType).find(".ui-select-match-text").text()
            $scope.processImport = true;
            $scope.isActive=true;
            if(uploadResp.resultCode=='0000'){
                imgFileData.prpImgFileIndexDto.fileId=uploadResp.fileId;
                var clearExcelDto={};
                clearExcelDto.fileId=imgFileData.prpImgFileIndexDto.fileId;
                var fileName=imgFileData.showFilePath;
                var ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
                if(ext=="xlsx"){
                    clearExcelDto.fileName=fileName.substring(0,fileName.lastIndexOf("."));
                    clearExcelDto.ext=".xlsx"

                }else if(ext== "xls"){
                    clearExcelDto.fileName=fileName.substring(0,fileName.lastIndexOf("."));
                    clearExcelDto.ext=".xls"
                }
                uploadClearFileServ.saveImgInfo(clearExcelDto).then(
                    function(answer){
                        $scope.answerData=answer.data;
                       if ($scope.answerData.flag == 1 && $scope.answerData.list.length== 0){
                          angular.alert("数据上传成功！");
                          $scope.showAbnormal=false;
                       } else if($scope.answerData.flag == 1 && $scope.answerData.list.length != 0){
                           angular.alert("上传成功，但存在异常数据，详情请查看异常单号文本框！");
                           $scope.showAbnormal=true;
                       } else if ($scope.answerData.flag == 0){
                            angular.alert("系统异常，请联系管理员！");
                            $scope.showAbnormal=false;
                       }

                    },function(error){
                       //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }else{
                angular.alert(uploadResp.resultMsg)
            }
        };
        /*点击退出跳转主页面*/
        $scope.onEdit = function(){
            $state.go("main.index");
        };
    };

    moduleApp.controller('uploadClearFileCtrl',['$scope','$state','uploadClearFileServ','FormFocus','FileUploader',uploadClearFileCtrl]);
});
