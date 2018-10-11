<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html id="ng-app" ng-app="app"> <!-- id="ng-app" IE<8 -->

    <head>
        <title>Simple example</title>
        <link rel="stylesheet" href="static/css/bootstrap.min.css" />

        <!-- Fix for old browsers -->
        <script src="static/js/es5-shim.min.js"></script>
        <script src="static/js/es5-sham.min.js"></script>
        <script src="static/js/jquery-1.8.3.min.js"></script>
        <script src="static/js/console-sham.min.js"></script> 

        <script src="static/js/bootstrap.min.js"></script>

        <!--<script src="../bower_components/angular/angular.js"></script>-->
        <script src="static/js/angular.min.js"></script>
        <script src="static/js/angular-file-upload.min.js"></script>
		<script type="text/javascript">
		'use strict';
		angular
		    .module('app', ['angularFileUpload'])
		    .controller('AppController', ['$scope', 'FileUploader', function($scope, FileUploader) {
		        var uploader = $scope.uploader = new FileUploader({
		            url: './uploadFile',
		            //formData : {parmA:'123asdfasd'},
		            formData : [{userCode:'0000189'},{systemId:'agri/tempfile'},{bussType:'whoami'}],
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
		    }]);
		
		</script>
        <!-- <script src="static/js/controllers.js"></script> -->

        <style>
            .my-drop-zone { border: dotted 3px lightgray; }
            .nv-file-over { border: dotted 3px red; } /* Default class applied to drop zones on over */
            .another-file-over-class { border: dotted 3px green; }

            html, body { height: 100%; }
        </style>

    </head>

    <!-- 1. nv-file-drop="" uploader="{Object}" options="{Object}" filters="{String}" -->
    <body ng-controller="AppController" nv-file-drop="" uploader="uploader" filters="queueLimit, customFilter">

        <div class="container">

  

            <div class="row">

                <div class="col-md-3">
				
                    <h3>Select files</h3>

                    <div ng-show="uploader.isHTML5">
                        <!-- 3. nv-file-over uploader="link" over-class="className" -->
                        <div class="well my-drop-zone" nv-file-over="" uploader="uploader">
                            Base drop zone
                        </div>

                        <!-- Example: nv-file-drop="" uploader="{Object}" options="{Object}" filters="{String}" -->
                        <div nv-file-drop="" uploader="uploader" options="{ url: '/foo' }">
                            <div nv-file-over="" uploader="uploader" over-class="another-file-over-class" class="well my-drop-zone">
                                Another drop zone with its own settings
                            </div>
                        </div>
                    </div>

                    <!-- Example: nv-file-select="" uploader="{Object}" options="{Object}" filters="{String}" -->
                    多个文件上传
                    <input type="file" nv-file-select="" uploader="uploader" multiple  /><br/>
 
                    单个文件上传
                    <input type="file" nv-file-select="" uploader="uploader" />
                </div>

                <div class="col-md-9" style="margin-bottom: 40px">
					<%--
                    <h3>Upload queue</h3>
                    <p>Queue length: {{ uploader.queue.length }}</p>

                    <table class="table">
                        <thead>
                            <tr>
                                <th width="50%">Name</th>
                                <th ng-show="uploader.isHTML5">Size</th>
                                <th ng-show="uploader.isHTML5">Progress</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="item in uploader.queue">
                                <td><strong>{{ item.file.name }}</strong></td>
                                <td ng-show="uploader.isHTML5" nowrap>{{ item.file.size/1024/1024|number:2 }} MB</td>
                                <td ng-show="uploader.isHTML5">
                                    <div class="progress" style="margin-bottom: 0;">
                                        <div class="progress-bar" role="progressbar" ng-style="{ 'width': item.progress + '%' }"></div>
                                    </div>
                                </td>
                                <td class="text-center">
                                    <span ng-show="item.isSuccess"><i class="glyphicon glyphicon-ok"></i></span>
                                    <span ng-show="item.isCancel"><i class="glyphicon glyphicon-ban-circle"></i></span>
                                    <span ng-show="item.isError"><i class="glyphicon glyphicon-remove"></i></span>
                                </td>
                                <td nowrap>
                                    <button type="button" class="btn btn-success btn-xs" ng-click="item.upload()" ng-disabled="item.isReady || item.isUploading || item.isSuccess">
                                        <span class="glyphicon glyphicon-upload"></span> Upload
                                    </button>
                                    <button type="button" class="btn btn-warning btn-xs" ng-click="item.cancel()" ng-disabled="!item.isUploading">
                                        <span class="glyphicon glyphicon-ban-circle"></span> Cancel
                                    </button>
                                    <button type="button" class="btn btn-danger btn-xs" ng-click="item.remove()">
                                        <span class="glyphicon glyphicon-trash"></span> Remove
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                         --%>

                    <div>
                        <div>
                           	上传进度:
                            <div class="progress" style="">
                                <div class="progress-bar" role="progressbar" ng-style="{ 'width': uploader.progress + '%' }"></div>
                            </div>
                        </div>
                        <!-- 
                        <button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()" ng-disabled="!uploader.getNotUploadedItems().length">
                            <span class="glyphicon glyphicon-upload"></span> Upload all
                        </button>
                        <button type="button" class="btn btn-warning btn-s" ng-click="uploader.cancelAll()" ng-disabled="!uploader.isUploading">
                            <span class="glyphicon glyphicon-ban-circle"></span> Cancel all
                        </button>
                        <button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()" ng-disabled="!uploader.queue.length">
                            <span class="glyphicon glyphicon-trash"></span> Remove all
                        </button>
                         -->
                    </div>

                </div>

            </div>

        </div>

    </body>
</html>
