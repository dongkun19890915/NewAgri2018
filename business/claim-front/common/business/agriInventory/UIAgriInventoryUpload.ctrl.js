define(['app', 'constants', 'layer', 'jsonDB', 'utilities', 'codes','config'], function (app, constants, layer, jsonDB, utilities, codes,config) {
    'use strict';
    app.registerController('UIAgriInventoryUpload', ['$rootScope', '$scope', '$$finder','$filter', '$http', '$state', 'commonApiServ', 'regexpConstants', '$$code','$window','$modal',
        function ($rootScope, $scope, $$finder,$filter, $http, $state, commonApiServ, regexpConstants, $$code,$window,$modal) {

            /**
             * 定损清单查询
             */
            $scope.queryList = function () {
                if(!$scope.plantUpLoadDto.listNo){
                    layerMsg("请输入清单号码");
                    return false;
                }
                var keywords = {
                    listNo: $scope.plantUpLoadDto.listNo || '',//TODO 清单号
                    pageNo: $scope.paginationConf.currentPage,
                    pageSize: $scope.paginationConf.itemsPerPage
                };
                var url = '';
                if($scope.plantUpLoadDto.riskCode == '28'){
                    //种植险
                    url = 'queryPlantingLossRateListByListNo';
                }else if($scope.plantUpLoadDto.riskCode == '32'){
                    //养殖险
                    url = 'queryBreedLossRateListDtoByListNo';
                }
                $$finder.post(url,keywords).then(function (data) {
                    if(data){
                        if(data.content){
                            $scope.plantUpLoadDto.QueryList = data.content;
                        }else{
                            $scope.plantUpLoadDto.QueryList = data;
                        }
                        $scope.plantUpLoadDto.listNo = $scope.plantUpLoadDto.QueryList[0].listNo || '';
                        $scope.paginationConf.totalItems = data.totalCount;
                        console.log($scope.plantUpLoadDto.QueryList)
                    }else{
                        layerMsg("查询失败");
                    }
                },function (e) {
                    layerMsg("查询失败!");
                });
            };

            /**
             * 分页设置初始化
             */
            function initPage() {
                $scope.paginationConf = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 10,//每页条数
                    perPageOptions: [5, 10, 20,50],
                    onChange: function () {//如果当前页有变动
                        if ($scope.paginationConf.totalItems == 0 || $scope.paginationConf.totalItems == undefined) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.queryList();
                        }
                    }
                };
            }
            /**
             * 初始化
             */
            function init() {
                $scope.riskType = 'readBreedingList';
                $scope.plantUpLoadDto = {};//保存预投保表信息入参
                $scope.plantUpLoadDto.QueryList = [];//接口查询回来的
                $scope.showSave = false;
                //清单号校验
                $scope.regexp = {};
                $scope.regexp.number = regexpConstants.number;
                $scope.regexp.Chinese = regexpConstants.Chinese;
                $scope.regexp.code = regexpConstants.code;

                //分页对象初始化
                initPage();
            }
            init();

            /* 清单模版下载*/
            $scope.getDownLoadURL = function () {
                if($scope.plantUpLoadDto.riskCode==""||$scope.plantUpLoadDto.riskCode==undefined){
                    layerMsg("请选择险种大类");
                }else{
                    var downLoadURLDto = {
                        riskCode: $scope.plantUpLoadDto.riskCode
                    };
                    $$finder.post('exportExcel', downLoadURLDto).then(
                        function (data) {
                            $window.open(data.url);
                        },
                        function (e) {
                            console.log(e);
                        }
                    );
                }
            };

            /**
             * 解析种植险并存入数据库
             * 解析养殖险险并存入数据库
             * @param _keywords
             */
            function listInfoCommit(_response) {
                var url = '';//地址
                var keywords = {
                    "fileName":_response.fileName,
                    "fileId":_response.fileId,
                    "riskCode":$scope.plantUpLoadDto.riskCode,
                    "policyNo":$scope.plantUpLoadDto.policyNo,
                    "registNo":$scope.plantUpLoadDto.registNo,
                    "pageNo":$scope.paginationConf.currentPage,
                    "pageSize":$scope.paginationConf.itemsPerPage
                };
                if(!$scope.plantUpLoadDto.riskCode){
                    layerMsg("请选择险种大类");
                    return false;
                }else if($scope.plantUpLoadDto.riskCode == '28'){
                    //种植险
                   $scope.riskType = url = 'readPlantingList';
                }else if($scope.plantUpLoadDto.riskCode == '32'){
                    //养殖险
                    $scope.riskType =  url = 'readBreedingList';
                }
                $$finder.post(url,keywords).then(
                    function (data) {
                        if(data && data.code != '9999'){
                            if(data.content){
                                $scope.plantUpLoadDto.QueryList = data.content;
                            }else{
                                $scope.plantUpLoadDto.QueryList = data;
                            }
                            $scope.plantUpLoadDto.listNo = $scope.plantUpLoadDto.QueryList[0].listNo || '';
                            $scope.paginationConf.totalItems = data.totalCount;
                            console.log($scope.plantUpLoadDto.QueryList)
                        }else{
                            layerMsg("保存清单文件失败");
                        }
                    },
                    function (e) {
                        layerMsg("保存清单文件失败");
                    });

            }

            //上传exl表格
            $scope.fileUpload = function () {
                var fd = new FormData();
                var file = document.querySelector('input[type=file]').files[0];
                if(!$scope.plantUpLoadDto.policyNo){
                    layerMsg("请输入保单号");
                }else if(!$scope.plantUpLoadDto.registNo){
                    layerMsg("请输入报案号");
                } else if($scope.plantUpLoadDto.riskCode==""||$scope.plantUpLoadDto.riskCode==undefined){
                    layerMsg("请选择险种大类");
                }else if (file == undefined || file == '') {
                    layerMsg("请选择要上传的文件");
                } else {
                    $scope.showSave = true;
                    fd.append('multipartFile', file);
                    $http({
                        method: 'POST',
                        url: config.backend.ip + config.backend.uploadBreedingList,
                        data: fd,
                        headers: {'Content-Type': undefined},
                        transformRequest: angular.identity
                    }).success(function (data) {
                            if (data.code && data.code == '0000') {
                                //上传成功的调取保存
                                listInfoCommit(data.content);
                            }else{
                                layerMsg("上传清单文件失败");
                            }
                        })
                        .error(function () {
                            //上传失败的操作
                            layer.alert("上传清单文件失败");
                        });
                }
            };

            //获取时间
            var date=new Date();
            $scope.getdate={
                year:date.getFullYear(),
                month:date.getMonth()+1,
                day:date.getDate()
            };
            // //重置按钮
            // $scope.resetUploudGisInsure = function () {
            //     $scope.showSave=false;
            //     $scope.plantUpLoadDto = {};
            //     $scope.plantUpLoadDto.QueryList = [];//接口查询回来的
            //     $scope.plantUpLoadDto.listBeginTime=''+$scope.getdate.year+'-'+($scope.getdate.month)+'-'+$scope.getdate.day;
            //     var file = $("input[type=file]");
            //     file.after(file.clone().val(""));
            //     file.remove();
            // };

            /**
             * 获取报案号
             */
            $scope.getRegistNo = function () {
                if (!$scope.plantUpLoadDto.policyNo){
                    layerMsg("请输入保单号");
                    return false;
                }
                $modal.open({
                    templateUrl:'common/business/agriInventory/modal/queryList.modal.html',
                    resolve:{
                        __plantUpLoadDto:function () {
                            return angular.copy($scope.plantUpLoadDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,__plantUpLoadDto) {
                        function init() {
                            $scope.showLoading = true;
                            $scope.paginationConf = {
                                currentPage: 1,//当前页
                                totalItems: 0,//总条数
                                itemsPerPage: 5,//每页条数
                                perPageOptions: [5, 10, 15, 20],
                                onChange: function () {//如果当前页有变动
                                    if ($scope.paginationConf.totalItems == 0 || $scope.paginationConf.totalItems == undefined) {//如果没有进行查询，不执行
                                        return;
                                    } else {
                                        queryRegistNo();
                                    }
                                }
                            };
                        }
                        init();

                        /**
                         * 获取报案号
                         */
                        function queryRegistNo() {
                           var keywords = {
                               policyNo: __plantUpLoadDto.policyNo || '',//保单号
                               riskCategory: "all",//默认all
                               status: 4,//默认
                               pageNo: $scope.paginationConf.currentPage,
                               pageSize: $scope.paginationConf.itemsPerPage
                           };
                           $$finder.post('queryPrpLregistList',keywords).then(function (data) {
                               if (data){
                                   console.log(data);
                                   $scope.showLoading = false;
                                   $scope.prpLregist = data.content;
                                   $scope.paginationConf.totalItems = data.totalCount;
                               }else if(!data){
                                   layerMsg("获取报案号失败!");
                                   $scope.closeModal();
                               }
                           },function (e) {
                               layerMsg("获取报案号失败!");
                               $scope.closeModal();
                           });
                       }
                        queryRegistNo();

                        /**
                         * 添加报案号
                         * @param _policyNo
                         */
                        $scope.registNoAdd = function (_regist) {
                            $modalInstance.close(_regist.registNo);
                        };
                        //关闭modal
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        }
                    }
                }).result.then(function (registNo) {
                    $scope.plantUpLoadDto.registNo = registNo;
                });
            };

            /**
             * 清单撤销
             */
            $scope.deleteByListNo = function (_List) {
              var keywords = {
                  "listNo":_List.listNo || '',
                  "riskCode":$scope.plantUpLoadDto.riskCode || ''
              };
                $$finder.post('deleteByListNo',keywords).then(function (data) {
                    if (data){
                        console.log(data);
                        layerMsg("撤销成功!");
                    }else if(!data){
                        layerMsg("撤销失败!");
                    }
                },function (e) {
                    layerMsg("撤销失败!");
                });
            };
        }])
});