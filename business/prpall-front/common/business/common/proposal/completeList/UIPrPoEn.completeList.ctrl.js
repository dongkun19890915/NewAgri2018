define(['app', 'constants', 'layer', 'jsonDB', 'jquery'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrEnCompleteListCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state', 'regexpConstants', 'FileUploader',
        function ($rootScope, $scope, $$finder, $http, $filter, $state, regexpConstants, FileUploader) {
            $scope.proposal = {}
            $scope.proposal.insureMainListDto = {};
            $scope.proposal.prpTmainAgriDto = {};
            $scope.proposal.prpTmainDto = {};
            $scope.proposal.prpTaddressDto = {};
            $scope.proposal.appliInsuredDto = {};
            $scope.listType = 1;
            //清单校验
            $scope.checkCode = function (str) {
                var reg = /^[0-9]{29}$/;
                if (str && !reg.test(str)) {
                    layer.open({
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '清单格式错误，请修改！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $scope.proposal.insureMainListDto.insureListCode = "";
                }
            };
            //清单导入的显示隐藏
            $scope.showImportList = false;
            $scope.openImportListLayer = function () {
                if ($scope.proposal.insureMainListDto.insureListCode) {
                    $$finder.find('checkDoesItExist', {
                        gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode
                    }, {
                        success: function (data) {
                            if (data.code === "0000") {
                                if (data.content && data.content > 0) {
                                    layer.open({
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: '已存在耳标号清单/连带被保险人清单，是否重新补录？',
                                        btn: ['确定', '取消'],
                                        btn1: function (index, layero) {
                                            layer.close(index);
                                            $scope.$apply(function () {
                                                showImportListLayer();
                                            });
                                        }
                                    })
                                } else {
                                    $scope.$apply(function () {
                                        showImportListLayer();
                                    });
                                }
                            } else {
                                showMessage('校验校验是否已经有耳标号或连带被保险人时错误！');
                            }
                        },
                    });
                } else {
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '请先选择清单！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("#insureListCode").focus();
                            layer.close(index);
                        }
                    });
                }

            };

            var showImportListLayer = function () {
                $scope.showImportList = true;
                $("html,body").css({overflow: "hidden"});
            };

            $scope.closeImportListLayer = function () {
                $scope.showImportList = false;
                $("html,body").css({overflow: "auto"});//出现滚动条
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        $scope.queryGisInsure();
                    }
                }
            };
            initPage2();
            $scope.clearDataList = function () {
                $scope.paginationConfmm2.totalItems = "";
                $scope.list = [];
            };
            //    清单查询
            $scope.relationListNoLayer = false;
            $scope.relationListQueryLayer = false;
            $scope.checkinsureListCode = function ($event, str) {
                $scope.list = [];
                var reg = /^[0-9]*$/;
                if (str && !reg.test(str)) {
                    layer.open({
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '清单号码格式错误，请修改！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("#insureListCode").focus();
                            layer.close(index);
                        }
                    });
                    $scope.proposal.insureMainListDto.insureListCode = "";
                } else {
                    $scope.queryRelationListNoLayer($scope.proposal.insureMainListDto.insureListCode)
                }
            };

            var queryCondition = {};
            $scope.isQueryFlag = true;
            var checkList = function () {
                $scope.list = [];

                if ($scope.isQueryFlag) {
                    queryCondition.pageNo = $scope.paginationConfmm2.currentPage = 1;
                    queryCondition.pageSize = $scope.paginationConfmm2.itemsPerPage = 20;
                } else {
                    queryCondition.pageNo = $scope.paginationConfmm2.currentPage;
                    queryCondition.pageSize = $scope.paginationConfmm2.itemsPerPage;
                    $scope.isQueryFlag = true;
                }
                queryCondition.gisInsureListCode = $scope.proposal.insureMainListDto.insureListCode;
                $$finder.find("queryMakeUpListByInsureListCode", queryCondition, {
                    success: function (data) {
                        console.log(data);
                        if (data.code == '0000' && data.content.content.length > 0) {
                            $scope.list = data.content.content;
                            //查询结果条数
                            $scope.totalItems = data.content.totalCount;
                            $scope.paginationConfmm2.totalItems = $scope.totalItems;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                        } else if (data.code == '9999') {
                            $scope.proposal.insureMainListDto.insureListCode = '';
                            layer.open({
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: data.message,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                    $("#insureListCode").focus();
                                }
                            });
                        } else {
                            $scope.proposal.insureMainListDto.insureListCode = '';
                            layer.open({
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '该清单无需补录！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                    $("#insureListCode").focus();
                                }
                            });
                        }
                    },
                    error: function (data) {
                    }
                })
            };
            //清单号查询按钮
            $scope.queryRelationListNoLayer = function () {
                $scope.gisFarmerListDtoList = {};
                if ($scope.proposal.insureMainListDto.insureListCode) {
                    checkList();
                } else {
                    $scope.relationListQueryLayer = true;
                    $("html,body").css({overflow: "hidden"});//隐藏滚动条
                    $scope.resetQueryGisInsure()
                }
            };
            var indexPage3 = function () {
                $scope.paginationConfmm2 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmm2.totalItems != 0) {
                            $scope.isQueryFlag = false;
                            $scope.queryRelationListNoLayer();
                        }
                    }
                }
            };
            indexPage3();
            //清单查询的重置按钮
            $scope.resetQueryGisInsure = function () {
                $scope.requestInsuranceQueryDto = {};
                $scope.requestInsuranceQueryDto.queryList = {};
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 2;
                $scope.totalItems = 0;
                //查询结果条数
                $scope.paginationConfmm.totalItems = $scope.totalItems;
                //initPage2();
                //获取时间
                var date = new Date();
                $scope.getdate = {
                    year: date.getFullYear(),
                    month: date.getMonth(),
                    day: date.getDate()
                };
                var _month = $scope.getdate.month;
                if (_month >= 10) {
                    $scope.getdate.month = (_month + 1);
                } else {
                    $scope.getdate.month = '0' + (_month + 1);
                }
                var _day = $scope.getdate.day;
                if (_day >= 10) {
                    $scope.getdate.day = (_day);
                } else {
                    $scope.getdate.day = '0' + (_day);
                }
                //$scope.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
                //$scope.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
                //$scope.requestInsuranceQueryDto.beginTime = $scope.beginTime;
                //$scope.requestInsuranceQueryDto.endTime = $scope.endTime;
                $scope.requestInsuranceQueryDto.queryList = {};
                $scope.requestInsuranceQueryDto.listAlias = null;
                $scope.requestInsuranceQueryDto.affrimOpName = null;
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 20;
            };
            //关闭按钮
            $scope.closeRelationListLayer = function () {
                $scope.relationListNoLayer = false;
                $scope.relationListQueryLayer = false;
                $("html,body").css({overflow: "auto"});//出现滚动条
                $scope.proposal.insureMainListDto.insureListCode = '';
                $scope.requestInsuranceQueryDto.beginTime = "";
                $scope.requestInsuranceQueryDto.endTime = "";
                $scope.proposal.prpTmainDto.businessProvince = '';
                $scope.proposal.prpTmainDto.businessTown = '';
                $scope.proposal.prpTmainDto.businessCountry = '';
                $scope.proposal.prpTmainDto.businessAreaName = '';
                $scope.proposal.prpTmainDto.businessArea = '';
                $scope.proposal.prpTaddressDto.addressName = '';
                $scope.proposal.appliInsuredDto.insuredType = null;
                $scope.proposal.appliInsuredDto.identifyType = null;
                $scope.proposal.appliInsuredDto.identifyNumber = null;
                $scope.proposal.appliInsuredDto.insuredName = null
                $scope.proposal.appliInsuredDto.insuredCode = null;
                $scope.proposal.appliInsuredDto.mobile = null;
            };
            //日期校验
            $scope.compareDate = function (startDate, endDate) {

                var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                if (startDate > endDate) {
                    var content;
                    content = '清单缮制止期不可早于缮制起期，请更改';
                    //$scope.requestInsuranceQueryDto.endTime = "";
                    layer.open({
                        //offset: ['38%', '38%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    //获取时间
                    var date = new Date();
                    $scope.getdate = {
                        year: date.getFullYear(),
                        month: date.getMonth(),
                        day: date.getDate()
                    };
                    var _month = $scope.getdate.month;
                    if (_month >= 10) {
                        $scope.getdate.month = (_month + 1);
                    } else {
                        $scope.getdate.month = '0' + (_month + 1);
                    }
                    var _day = $scope.getdate.day;
                    if (_day >= 10) {
                        $scope.getdate.day = (_day);
                    } else {
                        $scope.getdate.day = '0' + (_day);
                    }
                    //$scope.requestInsuranceQueryDto.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
                    //$scope.requestInsuranceQueryDto.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
                }
            };
            $scope.compareDate1 = function (startDate, endDate) {
                var content;
                //if (startDate == "" && endDate) {
                //    content = '请录入清单缮制起期！';
                //
                //    layer.open({
                //        //offset: ['40%', '40%'],
                //        skin: 'large-layer-content',
                //        scrollbar: false,
                //        closeBtn: 0,
                //        title: '温馨提示',
                //        content: content,
                //        btn: ['确定'],
                //        btn1: function (index, layero) {
                //            //按钮【按钮一】的回调
                //            layer.close(index);
                //        }
                //    });
                //}
                //if (endDate == "" && startDate) {
                //    content = '请录入清单缮制止期！';
                //
                //    layer.open({
                //        //offset: ['40%', '40%'],
                //        skin: 'large-layer-content',
                //        scrollbar: false,
                //        closeBtn: 0,
                //        title: '温馨提示',
                //        content: content,
                //        btn: ['确定'],
                //        btn1: function (index, layero) {
                //            //按钮【按钮一】的回调
                //            layer.close(index);
                //        }
                //    });
                //}
            };
            //获取归属区域省
            $scope.getUserRegion = function (ID, Field) {
                $$finder.find('getUserRegion', {
                    "userCode": $rootScope.user.userCode,//用户名
                    "parentID": ID//上级区域ID，默认显示省级时，parentID=0
                }, {
                    success: function (data) {
                        if (Field == 1) {
                            $scope.businessProvince = data.content;
                        } else if (Field == 2) {
                            $scope.businessTown = data.content;
                        } else if (Field == 3) {
                            $scope.businessCounty = data.content;
                        } else if (Field == 4) {
                            $scope.businessCity = data.content;
                        } else if (Field == 5) {
                            $scope.businessAreaName = data.content;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //获取归属区域市
            $scope.getUserRegion2 = function () {
                angular.forEach($scope.businessProvince, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fProvinceCode == data.gbbh) {
                        $scope.cityNameRegionid = data.regionid;
                    }
                });
                $scope.getUserRegion($scope.cityNameRegionid, 2)
            }
            //获取归属区域区
            $scope.getUserRegion3 = function () {
                angular.forEach($scope.businessTown, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fCityCode == data.gbbh) {
                        $scope.townNameRegionid = data.regionid;
                    }
                });
                $scope.getUserRegion($scope.townNameRegionid, 3)
            }
            //获取归属区域县
            $scope.getUserRegion4 = function () {
                angular.forEach($scope.businessCounty, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fCountyCode == data.gbbh) {
                        $scope.townRegionid = data.regionid;
                    }
                });
                $scope.getUserRegion($scope.townRegionid, 4)
            }
            //获取归属区域乡
            $scope.getUserRegion5 = function () {
                angular.forEach($scope.businessCity, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fTownCode == data.gbbh) {
                        $scope.areaRegionid = data.regionid;
                    }
                });
                $scope.getUserRegion($scope.areaRegionid, 5)
            }
            //查询结果
            $scope.loading = false;
            $scope.queryGisInsure = function () {
                var dto = angular.copy($scope.requestInsuranceQueryDto);
                dto.pageNo = 1;
                var address = angular.copy($scope.proposal.prpTmainDto);
                var NameReg = /^[\u4E00-\u9FA50-9]+$/g//汉字数字校验
                var appliNameReg = /^[\u4E00-\u9FA5A-Za-z0-9]+$/g;// 汉字数字字母
                var Name = /^[\u4E00-\u9FA5]+$/g//汉字
                var content = "";
                if (($scope.requestInsuranceQueryDto.insureListCode != undefined && $scope.requestInsuranceQueryDto.insureListCode != "" && $scope.requestInsuranceQueryDto.insureListCode != null)
                    || ($scope.requestInsuranceQueryDto.listAlias != undefined && $scope.requestInsuranceQueryDto.listAlias != "" && $scope.requestInsuranceQueryDto.listAlias != null)
                    || ($scope.requestInsuranceQueryDto.affrimOpName != undefined && $scope.requestInsuranceQueryDto.affrimOpName != "" && $scope.requestInsuranceQueryDto.affrimOpName != null)
                    || (($scope.requestInsuranceQueryDto.beginTime != undefined && $scope.requestInsuranceQueryDto.beginTime != "" && $scope.requestInsuranceQueryDto.beginTime != null)
                        || ($scope.requestInsuranceQueryDto.endTime != undefined && $scope.requestInsuranceQueryDto.endTime != "" && $scope.requestInsuranceQueryDto.endTime != null))
                    || (($scope.requestInsuranceQueryDto.businessProvinceName != undefined && $scope.requestInsuranceQueryDto.businessProvinceName != "" && $scope.requestInsuranceQueryDto.businessProvinceName != null)
                        || ($scope.requestInsuranceQueryDto.businessCityName != undefined && $scope.requestInsuranceQueryDto.businessCityName != "" && $scope.requestInsuranceQueryDto.businessCityName != null)
                        || ($scope.requestInsuranceQueryDto.businessCountyName != undefined && $scope.requestInsuranceQueryDto.businessCountyName != "" && $scope.requestInsuranceQueryDto.businessCountyName != null)
                        || ($scope.requestInsuranceQueryDto.businessTownName != undefined && $scope.requestInsuranceQueryDto.businessTownName != "" && $scope.requestInsuranceQueryDto.businessTownName != null)
                        || ($scope.requestInsuranceQueryDto.businessAreaName != undefined && $scope.requestInsuranceQueryDto.businessAreaName != "" && $scope.requestInsuranceQueryDto.businessAreaName != null))
                ) {


                } else {
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '请至少录入一个查询条件！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                if ($scope.requestInsuranceQueryDto.insureListCode) {
                    var reg = /^\d+$/g;
                    if (reg.test($scope.requestInsuranceQueryDto.insureListCode)) {
                        if ($scope.requestInsuranceQueryDto.insureListCode.length < 15) {
                            content = "清单号码需输入至少15位数！"
                        }
                    } else {
                        content = '清单号码格式错误，请修改';
                        $scope.requestInsuranceQueryDto.insureListCode = "";
                    }
                } else if ($scope.requestInsuranceQueryDto.listAlias && !Name.test($scope.requestInsuranceQueryDto.listAlias)) {
                    //投保单人名称
                    content = "清单名称格式错误，请修改";
                    $scope.requestInsuranceQueryDto.listAlias = "";
                } else if ($scope.requestInsuranceQueryDto.affrimOpName && !NameReg.test($scope.requestInsuranceQueryDto.affrimOpName)) {
                    //投保单人名称
                    content = "缮制人名称格式错误，请修改";
                    $scope.requestInsuranceQueryDto.affrimOpName = "";
                }
                if (content) {
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else {
                    $scope.loading = true;
                    var param = {
                        insureListCode: $scope.requestInsuranceQueryDto.insureListCode,
                        listAlias: $scope.requestInsuranceQueryDto.listAlias,
                        beginTime: $scope.requestInsuranceQueryDto.beginTime,
                        endTime: $scope.requestInsuranceQueryDto.endTime,
                        opName: $scope.requestInsuranceQueryDto.opName,
                        queryScenes: 'makeUpList',
                        serialNo: 1,
                        pageNo: $scope.requestInsuranceQueryDto.pageNo = 1,
                        pageSize: $scope.requestInsuranceQueryDto.pageSize = 20
                    };
                    if ($scope.requestInsuranceQueryDto.fProvinceCode) {
                        param.fProvinceCodes = [$scope.requestInsuranceQueryDto.fProvinceCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fCityCode) {
                        param.fCityCodes = [$scope.requestInsuranceQueryDto.fCityCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fCountyCode) {
                        param.fCountyCodes = [$scope.requestInsuranceQueryDto.fCountyCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fTownCode) {
                        param.fTownCodes = [$scope.requestInsuranceQueryDto.fTownCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fVillageCode) {
                        param.fVillageCodes = [$scope.requestInsuranceQueryDto.fVillageCode]
                    }
                    $$finder.find('findGisInsureMainLists', param, {
                        success: function (data) {
                            if (data.code == "0000" && data.content.content.length > 0) {
                                $scope.loading = false;
                                $scope.requestInsuranceQueryDto.queryList = data.content.content;
                                for (var i = 0; i < $scope.requestInsuranceQueryDto.queryList.length; i++) {
                                    $scope.date1 = $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime;
                                    $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime = $filter("date")($scope.date1, "yyyy-MM-dd");
                                }
                                $scope.totalItems = data.content.totalCount;
                                //查询结果条数
                                $scope.paginationConfmm.totalItems = $scope.totalItems;
                                $scope.paginationConfmm.currentPage = data.content.pageNo;
                                $scope.isSelected = function (x) {
                                    $scope.requestInsuranceQueryDto.queryList1 = data.content.content[x];
                                    //清单类型
                                    if ($scope.requestInsuranceQueryDto.queryList1.listType == 'D') {
                                        $scope.proposal.insureMainListDto.listTypeFlag = '大户';
                                    } else if ($scope.requestInsuranceQueryDto.queryList1.listType == 'S') {
                                        $scope.proposal.insureMainListDto.listTypeFlag = '散户';
                                    }
                                    //清单备注
                                    $scope.proposal.prpTmainAgriDto.relationListNoRemark = $scope.requestInsuranceQueryDto.queryList1.remark;
                                    //金禾清单号
                                    $scope.proposal.insureMainListDto.insureListCode = $scope.requestInsuranceQueryDto.queryList1.insureListCode;
                                    //清单序号
                                    $scope.proposal.insureMainListDto.serialNo = $scope.requestInsuranceQueryDto.queryList1.serialNo;
                                    //归属区域存储代码
                                    $scope.proposal.prpTmainDto.businessProvince = $scope.requestInsuranceQueryDto.queryList1.fProvinceCode;//省
                                    $scope.proposal.prpTmainDto.businessCity = $scope.requestInsuranceQueryDto.queryList1.fCityCode;//市
                                    $scope.proposal.prpTmainDto.businessCounty = $scope.requestInsuranceQueryDto.queryList1.fCountyCode;//区县
                                    $scope.proposal.prpTmainDto.businessTown = $scope.requestInsuranceQueryDto.queryList1.fTownCode;//乡镇
                                    $scope.proposal.prpTmainDto.businessArea = $scope.requestInsuranceQueryDto.queryList1.fVillageCode;//村
                                    //归属区域页面显示
                                    $scope.proposal.prpTmainDto.businessProvinceName = $scope.requestInsuranceQueryDto.queryList1.fProvinceName;
                                    $scope.proposal.prpTmainDto.businessCityName = $scope.requestInsuranceQueryDto.queryList1.fCityName;
                                    $scope.proposal.prpTmainDto.businessCountyName = $scope.requestInsuranceQueryDto.queryList1.fCountyName;
                                    $scope.proposal.prpTmainDto.businessTownName = $scope.requestInsuranceQueryDto.queryList1.fTownName;
                                    $scope.proposal.prpTmainDto.businessAreaName = $scope.requestInsuranceQueryDto.queryList1.fVillageName;
                                    //承保清单归属区域最后一级
                                    $scope.proposal.prpTmainDto.richflyAreasCode = $scope.requestInsuranceQueryDto.queryList1.pVillageCode;
                                    $scope.proposal.prpTmainDto.richflyAreasCname = $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                    //赋值到种植地点中的地址之中
                                    var addressName = $scope.requestInsuranceQueryDto.queryList1.provinceName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pCityName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pCountyName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pTownName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                    var addressNameArry = addressName.split('-');
                                    angular.forEach(addressNameArry, function (data, index) {
                                        if (data == 'undefined') {
                                            addressNameArry.splice(index, 1)
                                        }
                                    });
                                    $scope.proposal.prpTaddressDto.addressName = addressNameArry.join('-');
                                }
                            } else {
                                $scope.resetQueryGisInsure();
                                layer.open({
                                    //offset: ['45%', '40%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "无查询结果！",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                $scope.loading = false;
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmm.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.requestInsuranceQueryDto.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.requestInsuranceQueryDto.pageSize = $scope.paginationConfmm.itemsPerPage;
                            var dto = angular.copy($scope.requestInsuranceQueryDto);
                            var arr = Object.keys(dto);//js获取对象长度
                            //如果没有选择选项 就会提示弹层
                            if (arr.length <= 5 && $scope.requestInsuranceQueryDto.endTime == '' && $scope.requestInsuranceQueryDto.beginTime == '') {
                                layer.open({
                                    //offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '至少选择一个条件!',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            } else {
                                // dto.queryScenes = 'makeUpList';
                                // dto.serialNo = 1;
                                var param = {
                                    insureListCode: $scope.requestInsuranceQueryDto.insureListCode,
                                    listAlias: $scope.requestInsuranceQueryDto.listAlias,
                                    beginTime: $scope.requestInsuranceQueryDto.beginTime,
                                    endTime: $scope.requestInsuranceQueryDto.endTime,
                                    opName: $scope.requestInsuranceQueryDto.opName,
                                    queryScenes: 'makeUpList',
                                    pageNo: $scope.requestInsuranceQueryDto.pageNo,
                                    pageSize: $scope.requestInsuranceQueryDto.pageSize,
                                    serialNo: 1
                                };
                                if ($scope.requestInsuranceQueryDto.fProvinceCode) {
                                    param.fProvinceCodes = [$scope.requestInsuranceQueryDto.fProvinceCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fCityCode) {
                                    param.fCityCodes = [$scope.requestInsuranceQueryDto.fCityCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fCountyCode) {
                                    param.fCountyCodes = [$scope.requestInsuranceQueryDto.fCountyCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fTownCode) {
                                    param.fTownCodes = [$scope.requestInsuranceQueryDto.fTownCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fVillageCode) {
                                    param.fVillageCodes = [$scope.requestInsuranceQueryDto.fVillageCode]
                                }
                                $$finder.find('findGisInsureMainLists', param, {
                                    success: function (data) {
                                        $scope.requestInsuranceQueryDto.queryList = data.content.content;
                                        for (var i = 0; i < $scope.requestInsuranceQueryDto.queryList.length; i++) {
                                            $scope.date1 = $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime;
                                            $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime = $filter("date")($scope.date1, "yyyy-MM-dd");
                                        }
                                        $scope.totalItems = data.content.totalCount;
                                        //查询结果条数
                                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                                        $scope.isSelected = function (x) {
                                            $scope.requestInsuranceQueryDto.queryList1 = data.content.content[x];
                                            //清单类型
                                            if ($scope.requestInsuranceQueryDto.queryList1.listType == 'D') {
                                                $scope.proposal.insureMainListDto.listTypeFlag = '大户';
                                            } else if ($scope.requestInsuranceQueryDto.queryList1.listType == 'S') {
                                                $scope.proposal.insureMainListDto.listTypeFlag = '散户';
                                            }
                                            //清单备注
                                            $scope.proposal.prpTmainAgriDto.relationListNoRemark = $scope.requestInsuranceQueryDto.queryList1.remark
                                            //清单号
                                            $scope.proposal.insureMainListDto.insureListCode = $scope.requestInsuranceQueryDto.queryList1.insureListCode;
                                            //清单序号
                                            $scope.proposal.insureMainListDto.serialNo = $scope.requestInsuranceQueryDto.queryList1.serialNo;
                                            //归属区域存储代码
                                            $scope.proposal.prpTmainDto.businessProvince = $scope.requestInsuranceQueryDto.queryList1.fProvinceCode;//省
                                            $scope.proposal.prpTmainDto.businessCity = $scope.requestInsuranceQueryDto.queryList1.fCityCode;//市
                                            $scope.proposal.prpTmainDto.businessCounty = $scope.requestInsuranceQueryDto.queryList1.fCountyCode;//区县
                                            $scope.proposal.prpTmainDto.businessTown = $scope.requestInsuranceQueryDto.queryList1.fTownCode;//乡镇
                                            $scope.proposal.prpTmainDto.businessArea = $scope.requestInsuranceQueryDto.queryList1.fVillageCode;//村
                                            //归属区域页面显示
                                            $scope.proposal.prpTmainDto.businessProvinceName = $scope.requestInsuranceQueryDto.queryList1.fProvinceName;
                                            $scope.proposal.prpTmainDto.businessCityName = $scope.requestInsuranceQueryDto.queryList1.fCityName;
                                            $scope.proposal.prpTmainDto.businessCountyName = $scope.requestInsuranceQueryDto.queryList1.fCountyName;
                                            $scope.proposal.prpTmainDto.businessTownName = $scope.requestInsuranceQueryDto.queryList1.fTownName;
                                            $scope.proposal.prpTmainDto.businessAreaName = $scope.requestInsuranceQueryDto.queryList1.fVillageName;
                                            //承保清单归属区域最后一级
                                            $scope.proposal.prpTmainDto.richflyAreasCode = $scope.requestInsuranceQueryDto.queryList1.pVillageCode;
                                            $scope.proposal.prpTmainDto.richflyAreasCname = $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                            //赋值到种植地点中的地址之中
                                            var addressName = $scope.requestInsuranceQueryDto.queryList1.provinceName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pCityName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pCountyName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pTownName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                            var addressNameArry = addressName.split('-');
                                            angular.forEach(addressNameArry, function (data, index) {
                                                if (data == 'undefined') {
                                                    addressNameArry.splice(index, 1)
                                                }
                                            });
                                            $scope.proposal.prpTaddressDto.addressName = addressNameArry.join('-');
                                        }
                                        var select = document.getElementsByName('select');
                                        for (var i = 0; i < select.length; i++) {
                                            if (select[i].checked) {
                                                select[i].checked = false; //不选中
                                            }
                                        }
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                            }
                        }
                    }
                };
            };
            initPage2();
            //确定按钮
            $scope.closeRelationListNoLayer = function () {
                if (!$scope.requestInsuranceQueryDto.queryList1) {
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择一个清单或者点击关闭退出',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                checkList();
                $scope.relationListNoLayer = false;
                $scope.relationListQueryLayer = false;
                $("html,body").css({overflow: "auto"});//出现滚动条
            };
            //取消按钮
            $scope.cancel = function () {
                $scope.relationListNoLayer = false;
                $scope.relationListQueryLayer = false;
                $("html,body").css({overflow: "auto"});//出现滚动条
                $scope.proposal.insureMainListDto.insureListCode = '';
                $scope.requestInsuranceQueryDto.beginTime = "";
                $scope.requestInsuranceQueryDto.endTime = "";
            };

            $scope.proposal.hideIndentifyType = function () {
                $scope.hideIdentifyType = true;
            };

            //投保单号码点击
            $scope.getProposalInfo = function (businessNo, addEditExamine) {
                $("html,body").css({overflow: "auto"});//出现滚动条
                $state.go('UIproposal3107edit', {proposalNo: businessNo, addEditExamine: addEditExamine})
            };

            //清单详情
            $scope.checkqd = function ($event, str) {
                if (str == "" || str == null) {
                    layer.open({
                        //offset: ['40%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择清单！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else {
                    var path = $rootScope.frontEnd.prpallGisUrl+"/CallPage/ListShow/Index?listcode=" + str;
                    window.open(path);
                }
            };

            //模板下载
            $scope.downloadTemplate = function (num) {
                if (num) {
                    if (num == 1) {//耳标号
                        $$finder.find('downloadEarLabelList', {
                            gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode
                        }, {
                            success: function (data) {
                                if (data.code === "0000") {
                                    window.open(data.content.shortLink);
                                } else {
                                    showMessage('下载耳标号清单模板失败！');
                                }
                            },
                        });
                    } else {
                        $$finder.find('downloadJointInsured', {
                            gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode
                        }, {
                            success: function (data) {
                                if (data.code === "0000") {
                                    window.open(data.content.shortLink);
                                } else {
                                    showMessage('下载连带被保险人清单模板失败！');
                                }
                            },
                        });
                    }
                } else {
                    layer.open({
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "请选择清单补录类型！",
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            layer.close(index);
                        }
                    })
                }
            };

            $scope.checkFileType = function () {
                var fileType = $("#file").val();
                var suffix = fileType.substring(fileType.lastIndexOf(".") + 1, fileType.length).toLowerCase();
                if (fileType !== null && fileType !== "") {
                    if (suffix === 'xls' || suffix === 'xlsx') {
                        uploader.uploadAll();
                    } else {
                        showMessage('文件类型错误,请重新选择！', true);
                    }
                } else {
                    showMessage('请先选择文件！', true);
                }
            };

            var fileId = null;// 上传文件后得到fileserver返回的文件id
            // 重新选择文件时，清空队列，达到覆盖文件的效果
            $scope.clearItems = function () {
                uploader.clearQueue();
                $("#file").val('');
                fileId = null;
            };

            // 文件上传begin
            var uploader = $scope.uploader = new FileUploader({
                url: '/fileserver/uploadFile',
                formData: [{userCode: $rootScope.user.userCode}, {systemId: 'agri/tempfile'}, {bussType: 'agriprpall_complateList_ui'}],
                queueLimit: 1,//文件个数
                autoUpload: false,
                removeAfterUpload: false //上传后删除文件
            });
            // 成功的回调函数
            var selectFile = undefined;// 选中的文件
            uploader.onSuccessItem = function (fileItem, response, status, headers) {
                if (response.resultCode == "0000") {
                    // 上传成功后获取到文件id
                    fileId = response.resultObj.fileId;
                    showMessage("上传清单文件成功!");
                } else {
                    $scope.clearItems();
                    showMessage("上传清单文件失败！" + response.resultMsg);
                    $scope.payListState = false;
                }
            };
            // 展示信息弹层
            var showMessage = function (message, isBack) {
                layer.open({
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: message,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        if (isBack) {
                            $scope.clearItems();
                        }
                        layer.close(index);
                    }
                })
            };
            // 将文件id发送到后台解析
            $scope.uploadPayListExcel = function () {
                if (fileId == null || fileId == undefined) {
                    showMessage("请先上传清单！");
                } else {
                    submit('importEarLabelList');
                }
            };
            // 提交后台解析
            var submit = function (controllerName) {
                $$finder.find(controllerName, {
                    fileId: fileId
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            $scope.clearItems();
                            showMessage("补录清单成功！");
                        } else {
                            $scope.clearItems();
                            showMessage("文件解析错误！" + data.message);
                        }
                    },
                });
            };
        }]);
});