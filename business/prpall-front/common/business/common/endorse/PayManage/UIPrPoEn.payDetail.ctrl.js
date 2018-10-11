/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnPayDetailCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state', '$stateParams', 'FileUploader',
        function ($rootScope, $scope, $$finder, $http, $filter, $state, $stateParams, FileUploader) {
            console.log($stateParams);
            var backCtrlName = "UIPrPoEnPayManageMaint";
            var loginComCode = $rootScope.user.loginComCode;// 登录机构代码
            var viewType = $stateParams.viewType;// 页面显示状态
            var endorseNo = $scope.endorseNo = $stateParams.endorseNo;// 批单号码
            var costType = $stateParams.costType;// 费用类型
            var typeView = typeof viewType;
            var typeEndorseNo = typeof endorseNo;
            var typeCost = typeof costType;
            var typeString = typeof '';
            var endorseInfo = $stateParams.endorseInfo;// 上一个页面传递的信息
            var queryList = [];// 前端假分页储存所有数据的数组
            var selectFile = undefined;// 选中的文件
            var fileId = null;// 上传文件后得到fileserver返回的文件id
            $scope.QueryList = [];// 当前页的显示的数据
            $scope.isEdit = false;// 该页面元素是否可编辑
            $scope.policyNo = $stateParams.policyNo;
            $scope.payListState = false;// 清单支付信息是否成功导入标志
            $scope.uploadShow = false;// 导入清单弹出
            $scope.downloadShow = false;// 下载清单弹出

            console.log("endorseInfo", endorseInfo);
            // 展示信息弹层
            var showMessage = function (message, isback) {
                layer.open({
                    scrollbar: false,
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    content: message,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        layer.close(index);
                        if (isback) {
                            $scope.cancel();
                        }
                    }
                })
            };

            // 返回上一页
            $scope.cancel = function () {
                $("#file").val('');
                $("html,body").css({overflow: "auto"});//出现滚动条
                $state.go(backCtrlName);
            };

            // 判断当前页面的类型，确定当前页面的元素是否可以编辑
            if (viewType === 'view') {
                $scope.isEdit = false;
                $scope.payListState = true;
            } else if (viewType === 'modify') {
                $scope.isEdit = true;
                $scope.payListState = true;
            } else if (viewType === 'input') {
                $scope.isEdit = true;
                backCtrlName = 'UIPrPoEnPayManageEnter';
            } else {
                $scope.cancel();
            }

            // 查询支付详细信息
            var getPayInfoDetails = function (endorseNos, costType, success) {
                $$finder.find('queryPayInfoDetails', {
                    endorseNo: endorseNos,
                    costType: costType
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            success(data.content);
                        } else {
                            showMessage('查询清单详细信息失败！');
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        chgPage();
                    }
                };
            };
            initPage2();

            // 清单支付信息录入前端假分页操作
            var chgPage = function () {
                var total = $scope.paginationConfmm.totalItems;
                if (total != 0 && queryList != null && queryList.length > 0) {
                    $scope.QueryList.splice(0, queryList.length);
                    var lineNumber = ($scope.paginationConfmm.currentPage - 1) * $scope.paginationConfmm.itemsPerPage;
                    var itemsPerPage = $scope.paginationConfmm.itemsPerPage;
                    itemsPerPage = lineNumber + itemsPerPage > total ? (total - lineNumber) : itemsPerPage;
                    for (var i = lineNumber; i < lineNumber + itemsPerPage; i++) {
                        $scope.QueryList.push(queryList[i])
                    }
                }
            };

            // 展示/隐藏 上传页面弹层
            $scope.uploadShowPage = function () {
                $scope.uploadShow = !$scope.uploadShow;
                if ($scope.uploadShow == true) {
                    $("html,body").css({overflow: "hidden"});//隐藏滚动条
                } else {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                }
                $("#file").val('');
            };

            // 展示/隐藏 下载页面弹层
            $scope.downloadShowPage = function () {
                $scope.downloadShow = !$scope.downloadShow;
                if ($scope.downloadShow == true) {
                    $("html,body").css({overflow: "hidden"});//隐藏滚动条
                } else {
                    $("html,body").css({overflow: "auto"});//出现滚动条
                }
            };

            // 下载支付清单-模板文件
            $scope.downloadTemplate = function () {
                $$finder.find('downloadPayListTempLate', {
                    endorseNo: endorseNo,
                    costType: endorseInfo.costTypeCode
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            window.open(data.content.shortLink);
                        } else {
                            showMessage("支付清单模板下载失败！" + data.message);
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            // 下载批改变化量清单文件
            $scope.downloadEndorseList = function () {
                $$finder.find('exportEndorseList', {
                    endorseNo: endorseNo
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            window.open(data.content.shortLink);
                        } else {
                            showMessage("批改清单下载失败！");
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            // 下载支付清单
            $scope.downloadPayList = function () {
                $$finder.find('exportInsureListExcel', {
                    endorseNo: endorseNo,
                    costType: costType
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            window.open(data.content.shortLink);
                        } else {
                            showMessage("批改变化量清单下载失败！" + data.message);
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            // 文件上传begin
            var uploader = $scope.uploader = new FileUploader({
                url: '/fileserver/uploadFile',
                formData: [{userCode: $rootScope.user.userCode}, {systemId: 'agri/tempfile'}, {bussType: 'agriprpall_paymanage_ui'}],
                queueLimit: 1,//文件个数
                autoUpload: false,
                removeAfterUpload: false //上传后删除文件
            });

            // 成功的回调函数
            uploader.onSuccessItem = function (fileItem, response, status, headers) {
                if (response.resultCode == "0000") {
                    // 上传成功后获取到文件id
                    fileId = response.resultObj.fileId;
                    showMessage("导入清单文件成功!");
                } else {
                    showMessage("导入清单文件失败！" + response.resultMsg);
                    $scope.payListState = false;
                }
            };

            // 提交后台解析
            var submit = function (controllerName) {
                $$finder.find(controllerName, {
                    fileId: fileId,
                    endorseNo: endorseInfo.endorseNo,
                    costType: endorseInfo.costTypeCode,
                    loginComCode: loginComCode,
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            queryList = data.content;
                            $scope.totalItems = queryList.length;
                            // 查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                            $scope.uploadShowPage();
                            fileId = null;
                            $scope.payListState = true;
                            chgPage();
                        } else {
                            showMessage("文件解析错误！" + data.message);
                            $scope.payListState = false;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            // 将文件id发送到后台解析
            $scope.uploadPayListExcel = function () {
                if (fileId == null || fileId == undefined) {
                    showMessage("请先导入清单！");
                } else {
                    if (viewType == 'input') {
                        submit('importPayInfoExcel');
                    } else if (viewType == 'modify') {
                        submit('modifyListPayInfo');
                    } else {
                        showMessage("操作类型不正确！");
                    }
                }
            };

            // 重新选择文件时，清空队列，达到覆盖文件的效果
            $scope.clearItems = function () {
                uploader.clearQueue();
                $("#file").val('');
            };

            //添加文件之后，把文件信息赋给scope
            uploader.onAfterAddingFile = function (fileItem) {
                selectFile = fileItem._file;
            };
            // 文件上传end

            // 校验参数是否正常接收
            if (endorseInfo === undefined) {
                if (typeView !== typeString || viewType === ''
                    || typeEndorseNo !== typeString || endorseNo === ''
                    || typeCost !== typeString || costType === '') {
                    $scope.cancel();
                } else {
                    getPayInfoDetails(endorseNo, costType, function (data) {
                        queryList = data.prpPayMainDtos;
                        $scope.totalItems = queryList.length;
                        // 查询结果条数
                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                        chgPage();
                    });
                }
            } else {
                endorseNo = $scope.endorseNo = endorseNo = endorseInfo.endorseNo;
                costType = endorseInfo.costTypeCode;
                $scope.policyNo = endorseInfo.policyNo;
            }
        }]);
});