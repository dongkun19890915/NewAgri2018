/**
 * Created by weiy on 2016/11/4.
 */
define(  ['../module'], function(moduleApp) {
        'use strict';
        var userImportCtrlHandler = function ($scope,ApiPath,FileUploader, userQueryServ,$timeout) {
            $scope.userExcelFile={};
            $scope.userExcelFile.textfield = "";
            var userUploader;
            var initUserUploader = function(){
                if(angular.isDefined(userUploader)){
                    return;
                }
                console.log("usercode="+$scope.currentUser.userCode);
                userUploader = $scope.userUploader = new FileUploader({
                    url: '/comm-fileserver/uploadFile',
                    formData : [{userCode:$scope.currentUser.userCode},{systemId:'IMS'},{bussType:'USERINFO'}],
                    queueLimit: 2,   //文件个数
                    autoUpload:false,
                    removeAfterUpload: true  //上传后从队列中清除
                });
                userUploader.onErrorItem = function(fileItem, response, status, headers) {
                    angular.alert("文件上传失败:"+fileItem.file.name);
                };
                userUploader.onSuccessItem = function(fileItem, response, status, headers) {
                    console.info('文件上传完成');
                    $scope.processUserData(response.resultObj);
                    $timeout(function () {
                        $scope.closeImport();
                    },2000);
                };
                userUploader.onCompleteAll = function() {
                    console.info('全部上传完成，队列长度:'+userUploader.queue.length);
                };
                userUploader.onAfterAddingFile = function(fileItem) {
                    var queueLength = userUploader.queue.length;
                    if( 1 != queueLength){
                        var index = userUploader.getIndexOfItem(fileItem);
                        if(angular.isDefined(userUploader.queue[index-1])){
                            userUploader.removeFromQueue(index-1);
                        }
                    }
                    var fileName = fileItem.file.name;
                    var ext = fileName.substring(fileName.lastIndexOf("."), fileName.length);
                    //扩展名校验
                    if(ext != ".xls" && ext != ".xlsx" ) {
                        angular. alert("上传文件必须为xls 或 xlsx格式！");
                        return;
                    }
                    //文件大小限制
                    if(fileItem.file.size>(2*1024*1024)){
                        angular.alert("文件大小不能超过2MB");
                        return;
                    }
                    $scope.userExcelFile.textfield = fileName;
                    $scope.UserImportDto.excelType = ext;
                };
            };
            var destroyInsuredUploader = function(){
                if(angular.isDefined(userUploader)){
                    console.info("insuredUploader destroy");
                    userUploader.destroy();
                }
            };
            //初始化uploader
            initUserUploader();
            $scope.clearItems = function(){
                userUploader.clearQueue();
                $scope.userExcelFile.textfield = "";
            };

            $scope.SaveUsers = function(){
                if($scope.userImportALL()) {
                    if(userUploader.queue.length==0){
                        $scope.setMsg("请选择上传文件");
                        $scope.userFailShow();
                        return false;
                    }
                    if(angular.isDefined(userUploader) && userUploader.isUploading){
                        angular.alert("文件正在上传中");
                        return;
                    }
                    userUploader.uploadAll();

                }
            };
            /*校验两次密码是否相同*/
            var checkedPassWd = function(){
                var passwd = $scope.UserImportDto.password;
                var checkPassword = $scope.UserImportDto.checkPassWord;
                console.log(passwd+checkPassword);
                if(passwd){
                    if(passwd==checkPassword){
                        return true;
                    }else{
                        $scope.setMsg("两次输入密码不一致，请重新输入");
                        $scope.userFailShow();
                        return false;
                    }
                }else if("" == passwd || ""==checkPassword){
                    $scope.setMsg("密码不能为空");
                    $scope.userFailShow();
                    return false;
                }else{
                    return false;
                }
            };

            $scope.closeImportWin = function(){
                $scope.closeImport();
            };
            /*保存时岗位校验*/
            var validateGrade = function (grades) {
                var count = 0;
                grades.forEach(
                    function(grade){
                        if (grade.checked  && grade.gradeCode != '006'  && grade.gradeCode != '007')
                            count++;
                    }
                );
                if (count == 0 ){
                    return false;
                }else{
                    return true;
                }
            };
            /*用户信息批量导入*/
            $scope.userImportALL = function(){
                //检查岗位
                if(!validateGrade($scope.grades)){
                    $scope.setMsg("请选择岗位");
                    $scope.userFailShow();
                    return false;
                }else{
                    return checkedPassWd();
                }
            };
            //下载批量导入用户信息模板
            $scope.downloadExcelTemplate = function () {
                var userDto = {};
                userQueryServ.downloadExcelTemplate(userDto).then(
                    function(answer){
                        var fileId = answer.data.fileId;
                        userQueryServ.downLoadTemplate(fileId);
                    },
                    function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    });
            };

        };
        moduleApp.controller('userImportCtrl',['$scope','ApiPath','FileUploader','userQueryServ','$timeout',userImportCtrlHandler]);

    });
