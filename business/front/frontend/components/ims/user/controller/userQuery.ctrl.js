/**
 * Created by GuoXiangLian on 2016/9/25.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var userQueryCtrl = function ($scope, $state, ApiPath, userQueryServ) {
        $scope.UserImportDto = {};
        var userCode = $scope.user.userCode;
        var userDto = {};
        var proviceUserDto = {"userCode": userCode};

        /*弹层*/
        $scope.userImportLayer = false;
        $scope.userImportFailLayer = true;
        $scope.downloadUserInfoLayer = true;
        $scope.userSucLayer = true;
        $scope.exitLayer = true;
        $scope.userFailLayer = true;
        $scope.downloadUserErr = true;
        if (!$scope.userFile) {
            $scope.userFile = {prpUserFileIndexDto: {}, prpUserFileMainDto: {}};
            $scope.prpUserFile = {}
        }
        $scope.userFailShow = function () {
            $scope.userFailLayer = false;
        };
        $scope.userImportFailLayerShow = function () {
            $scope.userImportFailLayer = false;
        };
        $scope.userSucLayerShow = function () {
            $scope.userSucLayer = false;
        };
        $scope.downloadUserInfoLayerShow = function () {
            $scope.downloadUserInfoLayer = false;
        };
        $scope.downloadUserErrShow = function () {
            $scope.downloadUserErr = false;
        };

        $scope.setUserField = function (fileName) {
            $scope.userFile.textfield = fileName;
        };

        //跳转链接
        $scope.userNew = function () {
            $state.go("main.usermaintain");
        };
        $scope.userUpdate = function (userDto) {
            $state.go("main.usermaintain", {"continueData": userDto.userCode});
        };
        $scope.modifyPass = function (userDto) {
            $state.go("main.modifyPassword", {"continueData": userDto.userCode});
        };

        /* 分页初始化 */
        var searchFlag = false;

        /*获取省级机构*/
        var queryProviceComCode = function (userDto) {
            userQueryServ.proviceComCodeQuery(userDto).then(
                function (answer) {
                    $scope.proviceComCodeList = answer.data;
                }, function (error) {
                    console.log(JSON.stringify(error.datea))
                }
            )
        };

        /*查询现有岗位*/
        var queryGrade = function () {
            userQueryServ.gradeQuery().then(
                function (answer) {
                    console.log(answer.data);
                    $scope.grades = answer.data;
                },
                function (error) {
                    console.log(JSON.stringify(error.date));
                }
            )
        };
        $scope.setMsg = function (msg) {
            $scope.message = msg;
        };
        $scope.processUserData = function (uploadResp) {
            $scope.UserImportDto.grades = $scope.grades;
            $scope.UserImportDto.fileId = uploadResp.fileId;
            userQueryServ.insertUserAll($scope.UserImportDto).then(
                function (answer) {
                    if (answer.data.resultCode == '0000') {
                        $scope.setMsg(answer.data.resultMsg);
                        $scope.userSucLayerShow();
                    } else if (answer.data.resultCode == '8888') {
                        //数据校验失败
                        var fileId = answer.data.resultMsg;
                        $scope.downloadUrl = ApiPath.api.downloadFile + "?fileId=" + fileId;
                        $scope.setMsg("数据校验失败!");
                        $scope.userImportFailLayerShow();
                        $scope.downloadUserErrShow();
                    } else {
                        $scope.setMsg(answer.data.resultMsg);
                        $scope.userFailShow();
                        $scope.downloadUserErrShow();
                    }
                    $scope.processImport = false;
                }, function (error) {
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*下载用户信息服务*/
        var downloadUser = function (userDto) {
            $scope.message = "请稍等......";
            $scope.downloadDisabled = true;
            userQueryServ.userDownload(userDto).then(
                function (answer) {
                    var fileId = answer.data.fileId;
                    window.open(ApiPath.api.downloadFile + '?fileId=' + fileId);
                    $scope.downloadUserInfoLayer = true;
                },
                function (error) {
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };

        /*用户分页查询*/
        var getUserList = function () {
            if (!searchFlag) {
                return;
            }
            $scope.userQueryCondition.pageNo = $scope.paginationConf.currentPage;
            $scope.userQueryCondition.pageSize = $scope.paginationConf.itemsPerPage;
            var data = $scope.userQueryCondition;
            userQueryServ.userQuery(data).then(
                function (answer) {
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.useQueryData = answer.data.list;
                }, function (error) {
                    //cconsole.log(JSON.stringify(error.data));
                });
        };
        /*查询岗位*/
        var queryGrade = function (nullDto) {
            userQueryServ.gradeQuery(nullDto).then(
                function (answer) {
                    angular.forEach(answer.data, function (data) {
                        data.gradeTName = true;
                        if (data.flag == "1") {
                            data.gradeTName = false;
                        }
                    });
                    $scope.grades = answer.data;
                    console.log(answer.data);
                },
                function (error) {
                    console.log(JSON.stringify(error.date))
                })
        };
        var initPage = function () {
            $scope.paginationConf = {
                currentPage: 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage: 10, // 每页展示的数据条数
                pagesLength: 10, // 分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30, 40, 50]
                // 可选择显示条数的数组
            };
            $scope.userQueryCondition = {
                pageNo: $scope.paginationConf.currentPage,
                pageSize: $scope.paginationConf.itemsPerPage
            };

            /*查询省级*/
            queryProviceComCode(proviceUserDto);
            $scope.$watch(
                'paginationConf.currentPage + paginationConf.itemsPerPage', getUserList);
        };
        initPage();

        /*关闭弹层*/
        $scope.closeImport = function () {
            $scope.userImportLayer = false;
            $scope.downloadUserInfoLayer = true;
        };

        /* 搜索按钮 */
        $scope.userPageQuery = function () {
            searchFlag = true;
            getUserList();
        };

        /*退出取消按钮*/
        $scope.exitCancel = function () {
            $scope.exitLayer = true;
        };
        $scope.exitClose = function () {
            $scope.exitLayer = true;
        };

        /*确认退出按钮*/
        $scope.exitSucClose = function () {
            $scope.exitLayer = true;
            $scope.userQueryCondition = {};
            $scope.useQueryData = {};
            $scope.paginationConf = {
                currentPage: 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage: 10, // 每页展示的数据条数
                pagesLength: 10, // 分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [10, 20, 30, 40, 50]
                // 可选择显示条数的数组
            };
            $state.go("main.user");
        };

        /*退出按钮*/
        $scope.exit1 = function () {
            $state.go("main.index")
        };

        /*重置按钮*/
        $scope.userPageReset = function () {
            $scope.userQueryCondition = {}
        };

        /*批量创建用户*/
        $scope.userImport = function () {
            $scope.userImportLayer = true;
            $scope.UserImportDto.password = "";
            $scope.UserImportDto.checkPassWord = "";
            var nullDto = {};
            queryGrade(nullDto);
        };

        //下载弹层框点击确定
        $scope.download = function () {
            downloadUser($scope.userQueryCondition);
        };

        /*弹层点击关闭*/
        $scope.userClose = function () {
            $scope.userSucLayer = true;
            $scope.userFailLayer = true;
            $scope.userImportFailLayer = true;
            $scope.userCheckPasswdAndUserCode = true;
            $scope.userUpdateSucLayer = true;
        };
        /*上传成功弹层点击关闭*/
        $scope.sucClose = function () {
            $scope.userSucLayer = true;
            $scope.userFailLayer = true;
            $scope.userImportFailLayer = true;
            $scope.userCheckPasswdAndUserCode = true;
            $scope.userUpdateSucLayer = true;
            $scope.closeImport();
        };

    };
    moduleApp.controller('userQueryCtrl', ['$scope', '$state', 'ApiPath', 'userQueryServ', userQueryCtrl]);
});
