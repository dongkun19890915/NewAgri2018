define(['app', 'constants', 'layer', 'jsonDB', 'utilities', 'codes'], function (app, constants, layer, jsonDB, utilities, codes) {
    'use strict';
    app.registerController('UIPrPoEnAgriInventoryUpload', ['$rootScope', '$scope', '$$finder','$filter', '$http', '$state', 'commonApiServ', 'regexpConstants', '$$code',
        function ($rootScope, $scope, $$finder,$filter, $http, $state, commonApiServ, regexpConstants, $$code) {
            $scope.requestImportPlantUploadDto = {};//查询条件的对象
            $scope.plantUpLoadDto = {};//保存预投保表信息入参
            $scope.plantUpLoadDto.QueryList = {};//接口查询回来的
            $scope.formData = {};
            $scope.showSave = false;
            $scope.queryShow=false;
            $scope.plantUpLoadDto.QueryList.pageNo = 1;
            $scope.plantUpLoadDto.QueryList.pageSize = 5;
            $scope.downLoadURL = {};
            //清单号校验
            $scope.regexp = {};
            $scope.regexp.number = regexpConstants.number;
            $scope.regexp.Chinese = regexpConstants.Chinese;
            $scope.regexp.code = regexpConstants.code;
            $scope.businessCityList = [];
            $scope.businessCountyList = [];
            $scope.businessTownList = [];
            $scope.businessVillageList = [];
            /*清单号查询部分*/
            $scope.relationListNoLayer = false;
            $scope.relationListQueryLayer = false;
            $scope.requestInsuranceQueryDto = {};//清单弹层查询对象
            $scope.requestInsuranceQueryDto.queryList =[];//清单弹层查询接收对象
            $scope.requestInsuranceQueryDto.queryList1=[];
            $scope.requestInsuranceQueryDto.pageNo = 1;
            $scope.requestInsuranceQueryDto.pageSize = 2;



            /* 清单模版下载*/
            $scope.getDownLoadURL = function () {
                if($scope.plantUpLoadDto.riskCode==""||$scope.plantUpLoadDto.riskCode==undefined){
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择险种大类',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else{
                var downLoadURLDto = {
                    riskCode: $scope.plantUpLoadDto.riskCode
                };
                $$finder.find('exportExcel', downLoadURLDto, {
                    success: function (data) {

                        $scope.downLoadURL = data.content;
                        console.log($scope.downLoadURL.url);
                        $("#listdownLoadURLhref").attr("href", $scope.downLoadURL.url);
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
                }
            }

            /* 区域查询部分 */
            $scope.businessProvince = {};
            //省级信息初始化
            var getProvince = function () {
                var businessProvince = {
                    codeType: "AreasProvince",
                    fieldExt: ""
                };

                $$finder.find('queryAreasByCondition', businessProvince, {
                    success: function (data) {
                        $scope.businessProvinceList = data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            getProvince();
            var getProvinceName = function () {
                var businessProvince = {
                    codeType: "AreasProvince",
                    fieldExt: ""
                };
                $$finder.find('queryAreasByCondition', businessProvince, {
                    success: function (data) {
                        $scope.provinceList = data.content;

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getCityCode = function () {
                $scope.plantUpLoadDto.pCityCode="";
                $scope.plantUpLoadDto.pCityName="";
                $scope.plantUpLoadDto.pCountyCode="";
                $scope.plantUpLoadDto.pCountyName="";
                $scope.plantUpLoadDto.pTownCode="";
                $scope.plantUpLoadDto.pTownName="";
                $scope.plantUpLoadDto.pVillageCode="";
                $scope.plantUpLoadDto.pVillageName="";
                var businessCity = {};
                businessCity.codeType = "AreasCity";
                businessCity.fieldExt = $scope.plantUpLoadDto.provinceCode;
                var option = $("#plantingListprovinceCode option:selected");
                $scope.plantUpLoadDto.provinceName = option.text();
                console.log(option.text());
                $$finder.find('queryAreasByCondition', businessCity, {
                    success: function (data) {
                        $scope.businessCityList = data.content;
                        $scope.businessCountyList=[];
                        $scope.businessTownList=[];
                        $scope.businessVillageList=[];

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getCity = function () {
                $scope.requestInsuranceQueryDto.pCityCode="";
                $scope.requestInsuranceQueryDto.pCityName="";
                $scope.requestInsuranceQueryDto.pCountyCode="";
                $scope.requestInsuranceQueryDto.pCountyName="";
                $scope.requestInsuranceQueryDto.pTownCode="";
                $scope.requestInsuranceQueryDto.pTownName="";
                $scope.requestInsuranceQueryDto.pVillageCode="";
                $scope.requestInsuranceQueryDto.pVillageName="";
                var businessCity = {};
                businessCity.codeType = "AreasCity";
                businessCity.fieldExt = $scope.requestInsuranceQueryDto.provinceCode;
                var option = $("#plantingListprovince option:selected");
                $scope.requestInsuranceQueryDto.provinceName = option.text();
                console.log(option.text());
                $$finder.find('queryAreasByCondition', businessCity, {
                    success: function (data) {
                        $scope.cityList = data.content;
                        $scope.countyList =[];
                        $scope.townList=[];
                        $scope.villageList=[];

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //获取区信息
            $scope.getCountyCode = function () {
                $scope.plantUpLoadDto.pCountyCode="";
                $scope.plantUpLoadDto.pCountyName="";
                $scope.plantUpLoadDto.pTownCode="";
                $scope.plantUpLoadDto.pTownName="";
                $scope.plantUpLoadDto.pVillageCode="";
                $scope.plantUpLoadDto.pVillageName="";
                var cityCodedto = {};
                cityCodedto.codeType = "AreasTown";
                cityCodedto.fieldExt = $scope.plantUpLoadDto.pCityCode;
                var option = $("#plantingListCityCode option:selected");
                $scope.plantUpLoadDto.pCityName = option.text();
                $$finder.find('queryAreasByCondition', cityCodedto, {
                    success: function (data) {
                        $scope.businessCountyList = data.content;
                        $scope.businessTownList=[];
                        $scope.businessVillageList=[];

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getCounty = function () {
                $scope.requestInsuranceQueryDto.pCountyCode="";
                $scope.requestInsuranceQueryDto.pCountyName="";
                $scope.requestInsuranceQueryDto.pTownCode="";
                $scope.requestInsuranceQueryDto.pTownName="";
                $scope.requestInsuranceQueryDto.pVillageCode="";
                $scope.requestInsuranceQueryDto.pVillageName="";
                var cityCodedto = {};
                cityCodedto.codeType = "AreasTown";
                cityCodedto.fieldExt = $scope.requestInsuranceQueryDto.pCityCode;
                var option = $("#plantingListCity option:selected");
                $scope.requestInsuranceQueryDto.pCityName = option.text();
                $$finder.find('queryAreasByCondition', cityCodedto, {
                    success: function (data) {
                        $scope.countyList = data.content;
                        $scope.townList=[];
                        $scope.villageList=[];
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //获取县级信息
            $scope.getTownCode = function () {
                $scope.plantUpLoadDto.pTownCode="";
                $scope.plantUpLoadDto.pTownName="";
                $scope.plantUpLoadDto.pVillageCode="";
                $scope.plantUpLoadDto.pVillageName="";
                var businessCounty = {};
                businessCounty.codeType = "AreasCountry";
                businessCounty.fieldExt =$scope.plantUpLoadDto.pCountyCode;
                var option = $("#plantingListCountyCode option:selected");
                $scope.plantUpLoadDto.pCountyName = option.text();
                $$finder.find('queryAreasByCondition', businessCounty, {
                    success: function (data) {
                        console.log(data);
                        $scope.businessTownList = data.content;
                        $scope.businessvillageList=[];


                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getTown = function () {
                $scope.requestInsuranceQueryDto.pTownCode="";
                $scope.requestInsuranceQueryDto.pTownName="";
                $scope.requestInsuranceQueryDto.pVillageCode="";
                $scope.requestInsuranceQueryDto.pVillageName="";
                var businessCounty = {};
                businessCounty.codeType = "AreasCountry";
                businessCounty.fieldExt =$scope.requestInsuranceQueryDto.pCountyCode;
                var option = $("#plantingListCounty option:selected");
                console.log(option);
                $scope.requestInsuranceQueryDto.pCountyName = option.text();
                $$finder.find('queryAreasByCondition', businessCounty, {
                    success: function (data) {
                        console.log(data);
                        $scope.townList = data.content;
                        $scope.villageList=[];
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //获取乡镇信息
            $scope.getVillageCode = function () {
                $scope.plantUpLoadDto.pVillageCode="";
                $scope.plantUpLoadDto.pVillageName="";
                var businessVillage = {};
                businessVillage.codeType = "AreasVillage";
                businessVillage.fieldExt = $scope.plantUpLoadDto.pTownCode;
                var option = $("#plantingListTownCode option:selected");
                $scope.plantUpLoadDto.pTownName = option.text();
                $$finder.find('queryAreasByCondition', businessVillage, {
                    success: function (data) {
                        $scope.businessVillageList = data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getVillage = function () {
                $scope.requestInsuranceQueryDto.pVillageCode="";
                $scope.requestInsuranceQueryDto.pVillageName="";
                var businessVillage = {};
                businessVillage.codeType = "AreasVillage";
                businessVillage.fieldExt = $scope.requestInsuranceQueryDto.pTownCode;
                var option = $("#plantingListTown option:selected");
                $scope.requestInsuranceQueryDto.pTownName = option.text();
                $$finder.find('queryAreasByCondition', businessVillage, {
                    success: function (data) {
                        $scope.villageList = data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //获取村的信息
            $scope.getVillageName=function(){
                var option = $("#plantingListVillageCode option:selected");
                $scope.plantUpLoadDto.pVillageName = option.text();
            }
            $scope.getName=function(){
                var option = $("#plantingListVillage option:selected");
                $scope.requestInsuranceQueryDto.pVillageName = option.text();
            }

            //分页查询
            $scope.getPageInfo = function (dto) {
                $$finder.find('queryPlantUpLoadList', dto, {
                    success: function (data) {
                        $scope.plantUpLoadDtoList = data.content.content;
                        $scope.plantUpLoadDto.QueryList = angular.copy($scope.plantUpLoadDtoList);
                        //查询结果条数
                        $scope.paginationConf.totalItems = data.content.count;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //分页设置
            $scope.paginationConf = {
                currentPage: 1,//当前页
                totalItems: 0,//总条数
                itemsPerPage: 5,//每页条数
                pagesLength: 5,//总页数
                perPageOptions: [5, 10, 15, 20],
                onChange: function () {//如果当前页有变动
                    if ($scope.paginationConf.totalItems == 0 || $scope.paginationConf.totalItems == undefined) {//如果没有进行查询，不执行
                        return;
                    } else {
                        var queryMap = {
                            insureListCode: $scope.plantUpLoadDto.insureListCode,
                            serialNo: $scope.plantUpLoadDto.serialNo,
                            pageNo: $scope.paginationConf.currentPage,
                            pageSize: $scope.paginationConf.itemsPerPage
                        };
                        $scope.getPageInfo(queryMap);
                    }
                }
            }

            //上传exl表格
            $scope.fileUpload = function () {
                var fd = new FormData();
                var file = document.querySelector('input[type=file]').files[0];
                var content = "";
                if (file == undefined) {
                    content= '请选择要上传的文件';
                } else if($scope.plantUpLoadDto.riskCode==""||$scope.plantUpLoadDto.riskCode==undefined){
                    content ='请选择险种大类';
                }else if($scope.plantUpLoadDto.listTypeFlag==""||$scope.plantUpLoadDto.listTypeFlag==undefined){
                    content='请选择编辑类型';
                 }
                if(content!=""){
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                             //按钮【按钮一】的回调
                             layer.close(index);
                        }
                    });
                     return false;
                } else {
                    $scope.showSave = true;
                    fd.append('multipartFile', file);
                    $http({
                        method: 'POST',
                        url: "/api/agriprpall/importListing/uploadFile",
                        data: fd,
                        headers: {'Content-Type': undefined},
                        transformRequest: angular.identity
                    })
                        .success(function (data) {
                            if (data.code && data.code == '0000') {
                                //上传成功的操作
                                $scope.requestImportPlantUploadDto = data.content;
                                console.log(data.content);
                                $scope.requestImportPlantUploadDto.fileId = data.content.fileId;
                                $scope.requestImportPlantUploadDto.fileName = data.content.fileName;
                                $scope.plantUpLoadDto.listAlias = data.content.fileName;
                                // $scope.requestImportPlantUploadDto.comCode = '$rootScope.user.loginComCode';
                                $scope.requestImportPlantUploadDto.riskCode = $scope.plantUpLoadDto.riskCode;

                                $scope.dto = angular.copy($scope.requestImportPlantUploadDto);
                                $scope.arr = Object.keys($scope.dto);//js获取对象长度
                                $scope.dto.pageNo = $scope.paginationConf.currentPage;
                                $scope.dto.pageSize = $scope.paginationConf.itemsPerPage;
                                $scope.dto.insureListCode = $scope.plantUpLoadDto.insureListCode;
                                $scope.listInfoCommit($scope.dto);
                            }
                            console.log(data.content);
                        })
                        .error(function () {
                            //上传失败的操作
                            console.log("上传清单文件失败");
                        });
                }
            }
            //点击上传保存中间表并返回列表首页
            $scope.listInfoCommit = function (dto) {
                $$finder.find('saveGisPlantUpLoadList', dto, {
                    success: function (data) {
                        $scope.plantUpLoadDtoList = data.content.content;
                        $scope.plantUpLoadDto.QueryList = angular.copy($scope.plantUpLoadDtoList);
                        $scope.plantUpLoadDto.insureListCode = $scope.plantUpLoadDto.QueryList[0].insureListCode;
                        $scope.plantUpLoadDto.serialNo = $scope.plantUpLoadDto.QueryList[0].serialNo;
                        $scope.totalItems = data.content.totalCount;
                        //查询结果条数
                        $scope.paginationConf.totalItems = $scope.totalItems;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //选择批单时显示清单查询按钮
            $scope.querySetting = function () {
                if ($scope.plantUpLoadDto.listTypeFlag && $scope.plantUpLoadDto.listTypeFlag == "P") {
                    $scope.queryShow = true;
                } else {
                    $scope.queryShow = false;
                }
            }


            //清单号查询按钮
            $scope.queryRelationListLayer=function(){
                if($scope.plantUpLoadDto.insureListCode!=undefined&&$scope.plantUpLoadDto.insureListCode!=""){
                    $scope.plantUpLoadDto.insureListCode="";
                    $scope.plantUpLoadDto.remark="";
                    $scope.plantUpLoadDto.listAlias="";
                    $scope.plantUpLoadDto.listType="";
                    $scope.plantUpLoadDto.listBeginTime="";
                }
                if (!$scope.plantUpLoadDto.riskCode) {
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择险种大类',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return;

                }else {

                        $scope.relationListQueryLayer = true;
                        $scope.resetQueryGisInsure();
                        getProvinceName();
                        var curDate = new Date();
                        $scope.requestInsuranceQueryDto.endTime = $filter("date")(curDate, "yyyy-MM-dd");// 默认日期为当前日期
                        curDate.setDate(1);
                        $scope.requestInsuranceQueryDto.beginTime = $filter("date")(curDate, "yyyy-MM-dd");// 默认日期为当月的1号
                    }

            }
            $scope.queryRelationListNoLayer = function (num) {
                if($scope.requestInsuranceQueryDto.queryList1){
                    $scope.relationListNoLayer = true;
                }

            }
            var initPage2 = function () {
                console.log($scope.paginationConfmm);
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 2,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [2, 4, 6, 8],
                    onChange: function () {
                        if ($scope.paginationConfmm.totalItems == 0 || $scope.paginationConfmm.totalItems == undefined) {//如果没有进行查询，不执行
                            return;
                        } else {
                            query();
                        }
                    }
                }
            }
            initPage2();
            //清单弹层查询按钮
            $scope.queryGisInsure = function (){
                query();
            }
            var query=function(){
                console.log($scope.requestInsuranceQueryDto.endTime);
                $scope.requestInsuranceQueryDto.queryList=[];
                // $scope.requestInsuranceQueryDto.queryList1=[]
                var dto = angular.copy($scope.requestInsuranceQueryDto);
                dto.pageNo = $scope.paginationConfmm.currentPage;
                dto.pageSize = $scope.paginationConfmm.itemsPerPage;
                var arr = Object.keys(dto);//js获取对象长度
                // 如果没有选择选项 就会提示弹层
                if (arr.length <= 5 &&$scope.requestInsuranceQueryDto.endTime =="" && $scope.requestInsuranceQueryDto.beginTime =="") {
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '缮制日期为必选项',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else if ($scope.requestInsuranceQueryDto.endTime !="" && $scope.requestInsuranceQueryDto.beginTime =="") {
                    //console.log($scope.requestInsuranceQueryDto)
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请输入起期',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else{
                    $$finder.find('findGisInsureMainLists', $scope.requestInsuranceQueryDto, {
                        success: function (data) {
                            console.log(data);
                            $scope.requestInsuranceQueryDto.queryList = data.content.content;
                            console.log($scope.requestInsuranceQueryDto.queryList.length)
                            $scope.totalItems = data.content.totalCount;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                            // $scope.isSelected;

                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }


            }

            $scope.compareDate=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g,""),10);
                console.log(startDate)
                console.log(endDate)
                var endDate = parseInt(endDate.replace(/-/g,""),10);
                if(startDate>endDate) {
                    var content;
                    content = '清单缮制止期不可早于缮制起期，请更改';
                    // $scope.requestInsuranceQueryDto.endTime ="";
                    layer.open({
                        offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }

            $scope.getListPageInfo=function (dto) {
                                $$finder.find('queryPlantUpLoadList', dto, {
                    success: function (data) {
                        ;
                        $scope.plantUpLoadDtoList = data.content.content;
                        $scope.plantUpLoadDto.QueryList =angular.copy($scope.plantUpLoadDtoList);
                        $scope.plantUpLoadDto.insureListCode=$scope.plantUpLoadDto.QueryList[0].insureListCode;
                        $scope.plantUpLoadDto.serialNo = $scope.plantUpLoadDto.QueryList[0].insureListCode;
                        $scope.totalItems = data.content.totalCount;
                        //查询结果条数
                        //$scope.paginationConfmm.totalItems=data.content.count;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //清单弹层关闭按钮
            $scope.closeRelationListLayer = function () {
                $scope.relationListNoLayer = false;
                $scope.relationListQueryLayer = false;
                $scope.requestInsuranceQueryDto.insureListCode = '';
            }
            //清单弹层查询的重置按钮
            $scope.resetQueryGisInsure = function () {
                $scope.requestInsuranceQueryDto = {};
                $scope.requestInsuranceQueryDto.queryList =[];
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 2;
                //获取时间
                // var date = new Date()
                // $scope.getdate = {
                //     year: date.getFullYear(),
                //     month: date.getMonth(),
                //     day: date.getDate()
                // }
                // var _month = $scope.getdate.month;
                // if (_month >= 10) {
                //     $scope.getdate.month = (_month + 1);
                // } else {
                //     $scope.getdate.month = '0' + (_month + 1);
                // }
                // var _day = $scope.getdate.day;
                // if (_day >= 10) {
                //     $scope.getdate.day = (_day);
                // } else {
                //     $scope.getdate.day = '0' + (_day);
                // }
                // $scope.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
                // $scope.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
                // // var curDate = new Date();
                // $scope.requestInsuranceQueryDto.endTime = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当前日期
                // curDate.setDate(1);
                // $scope.requestInsuranceQueryDto.beginTime = $filter("date")(curDate,"yyyy-MM-dd");// 默认日期为当月的1号

                $scope.requestInsuranceQueryDto.beginTime = "";
                $scope.requestInsuranceQueryDto.endTime = "";
                $scope.requestInsuranceQueryDto.listAlias = "";
                $scope.requestInsuranceQueryDto.affrimOpName = "";
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 2;
            }
            //清单弹层确定按钮
            $scope.closeRelationListNoLayer = function () {
                if (!$scope.requestInsuranceQueryDto.queryList1) {
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择一个清单或者点击关闭退出',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });

                    return;
                }
                    $scope.relationListNoLayer=false;
                    $scope.relationListQueryLayer = false;


                    //     $scope.businessProvinceList[0]={
                    //         "areaCode":$scope.plantUpLoadDto.provinceCode,
                    //         "areaName":$scope.plantUpLoadDto.provinceName
                    //     };
                    //     $scope.businessCityList[0]={
                    //         "areaCode":$scope.plantUpLoadDto.pCityCode,
                    //         "areaName":$scope.plantUpLoadDto.pCityName
                    //     };
                    //     $scope.businessCountyList[0]={
                    //         "areaCode":$scope.plantUpLoadDto.pCountyCode,
                    //         "areaName":$scope.plantUpLoadDto.pCountyName
                    //     };
                    //     $scope.businessTownList[0]={
                    //         "areaCode":$scope.plantUpLoadDto.pTownCode,
                    //         "areaName":$scope.plantUpLoadDto.pTownName
                    //     };
                    //     $scope.businessVillageList [0]={
                    //         "areaCode":$scope.plantUpLoadDto.pVillageCode,
                    //         "areaName":$scope.plantUpLoadDto.pVillageName
                    //     };

             }

            //选中一条清单信息，回写数据
            $scope.isSelected = function (x) {
                if (!$scope.requestInsuranceQueryDto.queryList||$scope.requestInsuranceQueryDto.queryList.length==0) {
                    return;
                }
                var queryListDto = $scope.requestInsuranceQueryDto.queryList[x];
                //清单备注
                $scope.plantUpLoadDto.remark = $scope.requestInsuranceQueryDto.queryList[x].remark;
                //清单号
                $scope.plantUpLoadDto.insureListCode = $scope.requestInsuranceQueryDto.queryList[x].insureListCode;
                //清单名称
                $scope.plantUpLoadDto.listAlias = $scope.requestInsuranceQueryDto.queryList[x].listAlias;
                //清单类型
                $scope.plantUpLoadDto.listType = $scope.requestInsuranceQueryDto.queryList[x].listType;
                //清单序列号
                $scope.plantUpLoadDto.serialNo = $scope.requestInsuranceQueryDto.queryList[x].serialNo;
               //清单缮制日期
                $scope.plantUpLoadDto.listBeginTime=$scope.requestInsuranceQueryDto.queryList[x].listAffrimTime;

                //归属区域代码
                $scope.plantUpLoadDto.provinceCode = $scope.requestInsuranceQueryDto.queryList[x].fProvinceCode;
                $scope.plantUpLoadDto.pCityCode = $scope.requestInsuranceQueryDto.queryList[x].fPCityCode;
                $scope.plantUpLoadDto.pCountyCode = $scope.requestInsuranceQueryDto.queryList[x].fPCountyCode;
                $scope.plantUpLoadDto.pTownCode = $scope.requestInsuranceQueryDto.queryList[x].fPTownCode;
                $scope.plantUpLoadDto.pVillageCode = $scope.requestInsuranceQueryDto.queryList[x].fPVillageCode;
                //归属区域名称
                $scope.plantUpLoadDto.provinceName = $scope.requestInsuranceQueryDto.queryList[x].provinceName;
                $scope.plantUpLoadDto.pCityName = $scope.requestInsuranceQueryDto.queryList[x].pCityName;
                $scope.plantUpLoadDto.pCountyName = $scope.requestInsuranceQueryDto.queryList[x].pCountyName;
                $scope.plantUpLoadDto.pTownName = $scope.requestInsuranceQueryDto.queryList[x].pTownName;
                $scope.plantUpLoadDto.pVillageName = $scope.requestInsuranceQueryDto.queryList[x].pVillageName;


                //赋值到种植地点中的地址之中
                // $scope.plantUpLoadDto.fAreaName = $scope.requestInsuranceQueryDto.queryList[x].provinceName + '-' +
                //     $scope.requestInsuranceQueryDto.queryList[x].pCityName + '-' +
                //     $scope.requestInsuranceQueryDto.queryList[x].pCountyName + '-' +
                //     $scope.requestInsuranceQueryDto.queryList[x].pTownName + '-' +
                //     $scope.requestInsuranceQueryDto.queryList[x].pVillageName;
                // $scope.requestInsurance(x);
                $scope.requestInsuranceQueryDto.queryList1=$scope.requestInsuranceQueryDto.queryList[x]

            }
            //点击清单号码查看详细信息
            $scope.requestInsurance = function (index) {

                $$finder.find('queryInsurePreliminaryConfirm', {
                        "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.gisNyxInsuranceListDtos=data.content.gisNyxInsuranceListDtos;


                        }
                    });
            }


            /* 点击保存按钮保存清单信息 */
            $scope.saveGisList= function () {

                var dto=angular.copy($scope.plantUpLoadDto);
                var value=$("#plantingListVillageCode option:selected");
                $scope.plantUpLoadDto.pVillageName=value.text();
                console.log($scope.plantUpLoadDto.pVillageName);
                if($scope.plantUpLoadDto.pVillageCode=="" ||$scope.plantUpLoadDto.pVillageCode==undefined){
                    $scope.plantUpLoadDto.pVillageName="";
                }
                dto.fAreaCode=$scope.plantUpLoadDto.pVillageCode;
                dto.fAreaName=$scope.plantUpLoadDto.provinceName
                    +$scope.plantUpLoadDto.pCityName
                    +$scope.plantUpLoadDto.pCountyName
                    +$scope.plantUpLoadDto.pTownName
                    +$scope.plantUpLoadDto.pVillageName;
                dto.listBeginTime=date.getFullYear()+'-'+date.getMonth()+'-'+date.getDate();
                if($scope.plantUpLoadDto.provinceCode==''||$scope.plantUpLoadDto.provinceCode==undefined ){
                    layer.open({
                        offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择归属区域',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else{
                    $$finder.find('saveGisList', dto, {
                        success: function (data) {
                            var map = data.content;
                            if(data.code == "0000" && data.content.type){

                                layer.open({
                                    offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '保存清单文件成功',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            } else{
                                layer.open({
                                    offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '保存清单文件失败',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            };

                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

            };
            //获取时间
            var date=new Date()
            $scope.getdate={
                year:date.getFullYear(),
                month:date.getMonth()+1,
                day:date.getDate()
            }

            //重置按钮
            $scope.resetUploudGisInsure = function () {
                $scope.showSave=false;
                $scope.queryShow=false;
                $scope.plantUpLoadDto = {};
                // $scope.plantUpLoadDto.listBeginTime=''+$scope.getdate.year+'-'+($scope.getdate.month+1)+'-'+$scope.getdate.day;
                $scope.plantUpLoadDto.listBeginTime='';
                $scope.plantUpLoadDto.insureListCode='';
                $scope.requestInsuranceQueryDto={};
                $scope.businessCityList=[];
                $scope.businessCountyList=[];
                $scope.businessTownList=[];
                $scope.businessVillageList =[];
                var file = $("input[type=file]")
                file.after(file.clone().val(""));
                file.remove();
                getProvince();
            }




        }]
    )
});