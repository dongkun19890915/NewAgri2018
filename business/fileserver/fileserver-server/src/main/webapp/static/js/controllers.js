'use strict';


angular


    .module('app', ['angularFileUpload'])


    .controller('AppController', ['$scope', 'FileUploader', function($scope, FileUploader) {
    	
        var uploader = $scope.uploader = new FileUploader({
            url: '/comm-fileserver/uploadFile',
            //formData : {parmA:'123asdfasd'},
            formData : [{userCode:'0000189'},{systemId:'agri/tempfile'},{bussType:'lstas'}],
            queueLimit: 1,   //文件个数
            autoUpload:true,            
            removeAfterUpload: false  //上传后删除文件
        });
        uploader.onSuccessItem = function(fileItem, response, status, headers) {        	
        	debugger;
        	alert(response.resultObj.fileId);
        	console.info('onSuccessItem', fileItem, response, status, headers);
        };
        uploader.onBeforeUploadItem = function(item) {
            console.info('onBeforeUploadItem', item);
        };        
        uploader.onProgressItem = function(fileItem, progress) {        	
            console.info('onProgressItem', fileItem, progress);
        };        
        // FILTERS

/*        uploader.filters.push({
            name: 'customFilter',
            fn: function(item {File|FileLikeObject}, options) {
                return this.queue.length < 10;
            }
        });*/

        // CALLBACKS
/*
        uploader.onWhenAddingFileFailed = function(item {File|FileLikeObject}, filter, options) {
            console.info('onWhenAddingFileFailed', item, filter, options);
        };
        uploader.onAfterAddingFile = function(fileItem) {
            console.info('onAfterAddingFile', fileItem);
        };
        uploader.onAfterAddingAll = function(addedFileItems) {
            console.info('onAfterAddingAll', addedFileItems);
        };


        uploader.onProgressAll = function(progress) {
            console.info('onProgressAll', progress);
        };

        uploader.onErrorItem = function(fileItem, response, status, headers) {
            console.info('onErrorItem', fileItem, response, status, headers);
        };
        uploader.onCancelItem = function(fileItem, response, status, headers) {
            console.info('onCancelItem', fileItem, response, status, headers);
        };
        uploader.onCompleteItem = function(fileItem, response, status, headers) {
            console.info('onCompleteItem', fileItem, response, status, headers);
        };
        uploader.onCompleteAll = function() {
            console.info('onCompleteAll');
        };*/

        //console.info('uploader', uploader);
    }]);
