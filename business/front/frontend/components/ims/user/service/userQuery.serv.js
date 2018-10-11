/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
	var userQueryServ = function ($http, $q,ApiPath) {
        return {
			//分页查询用户
        	userQuery:function(userQueryCondtionDto){
        		var deferred = $q.defer();
        		var promise = $http({
        			method:'POST',
        			url:ApiPath.api.queryUserList,
        			data:userQueryCondtionDto
        		});
        		promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					}
        		);
        		return deferred.promise;
        	},
			//省级机构查询
			proviceComCodeQuery:function(userDto){
				var deferred = $q.defer();
				var promise = $http({
					method:"Post",
					url:ApiPath.api.queryDownComCode,
					data:userDto
				});
				promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					}
				);
				return deferred.promise;
		},
			//上传用户信息
			uploadFile:function (teamData){
				var deferred = $q.defer();
				var promise  = $http({
					method:"POST",
					url:ApiPath.api.uploadFile,
					enctype:'multipart/form-data',
					data:teamData,
					headers: {
						'Content-Type': undefined
					},transformRequest:function(data, headersGetter){
						var formData = new FormData();
						angular.forEach(data, function (value, key) {
							formData.append(key, value);
						});
						return formData;
					}
				});
				promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					});
				return deferred.promise;
			},

			/*用户信息批量导入*/
			insertUserAll:function (UserImportDto){
				var deferred = $q.defer();
				var promise  = $http({
					method:'POST',
					url:ApiPath.api.userImportExcel,
					data:UserImportDto,
					timeout: 1000 * 60 * 2
				});
				promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					});
				return deferred.promise;
			},

			//下载所有用户信息
			userDownload:function(userDto){
				var deferred = $q.defer();
				var promise = $http({
					method:"Post",
					url:ApiPath.api.downUserInfo,
					data:userDto,
					timeout:1000 * 60 * 2
				});
				promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					}
				);
				return deferred.promise;
			},
			downloadExcelTemplate: function (userDto) {
				var deferred = $q.defer();
				var promise = $http({
					method:"Post",
					url:ApiPath.api.downloadExcelTemplate,
					data:userDto
				});
				promise.then(
					function(answer){
						answer.status = true;
						deferred.resolve(answer);
					},
					function(error){
						error.status = false;
						deferred.reject(error);
					}
				);
				return deferred.promise;
			},

			/*查询现有岗位*/
			gradeQuery:function(userDto){
			var deferred = $q.defer();
			var promise = $http({
			    method:"Post",
			    url:ApiPath.api.queryGradeList,
			    data:userDto
			});
			promise.then(
			    function (answer) {
			        answer.status = true;
			        deferred.resolve(answer);
			    },
			    function (error) {
			        error.status = false;
			        deferred.reject(error);
			    });
			return deferred.promise;
			},
			/*服务层下载模板*/
			downLoadTemplate:function(fileId){
				window.open(ApiPath.api.downloadFile+'?fileId='+fileId );
			}
        }
    };
	moduleApp.service('userQueryServ',['$http','$q','ApiPath',userQueryServ]);

});

