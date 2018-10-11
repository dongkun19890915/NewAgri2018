/**
 * Created by hanyuhuai on 2017/12/.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIEndorseTemplateCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state', 'regexpConstants','commonApiServ',
        function ($rootScope, $scope, $$finder, $http, $filter, $state, regexpConstants,commonApiServ) {
            $scope.utilNoticeModelDto = {
                noticeName: null,
                noticeContent: null,
                validStartDate: null,
                validEndDate: null,
                riskCode: null,
                comCode: null
            };


            $scope.utilNoticeModelRegex = regexpConstants.utilNoticeModelRegex;
            //分页设置
            $scope.info={};
            $scope.info.noticeCode='';

            $$finder.find('queryNoticeModelPaging', {
                "offset": 1,
                "length": 20,
            }, {
                success: function (data) {
                    $scope.list = data.content.content;
                    console.log($scope.list)
                    $scope.paginationConfmm.totalItems = data.content.totalCount;
                    angular.forEach($scope.list, function (data) {
                        if(commonApiServ.compareFullDate(data.validStartDate,data.createdTime)==1){
                            data.status="0"
                        }
                    })
                },
                error: function (e) {
                    options.error(e);
                }

            });



            $scope.submit = function () {
                $$finder.find('queryNoticeModelPaging', {
                    "offset": $scope.paginationConfmm.currentPage,
                    "length": $scope.paginationConfmm.itemsPerPage,
                    "noticeName": $scope.noticeName,
                    "type": $scope.type
                }, {
                    success: function (data) {
                        if(data.code=="0000"&&data.content.content.length>0){
                            $scope.list = data.content.content;
                            $scope.paginationConfmm.totalItems = data.content.totalCount;
                            angular.forEach($scope.list, function (data) {
                                if(commonApiServ.compareFullDate(data.validStartDate,data.createdTime)==1){
                                    data.status="0"
                                }
                            })
                        }else if(data.code=="9999"){
                            layer.open({
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '系统异常、请联系管理员！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.list=[];
                            $scope.paginationConfmm.totalItems=0;
                        }
                        $scope.select_all_message="";
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmm.totalItems == 0) {
                            return;
                        } else {
                            $scope.submit()
                        }
                    }

                };
            };
            initPage2();
            //重置表单
            $scope.reset = function () {
                $scope.utilNoticeModelDto = {};
                $scope.riskName = "";
                $scope.swflogDto = {};
            }


            //根据条款代码停用启用条款
            $scope.disableClause = function (info) {
                var currentTime=$filter('date')(new Date(),'yyyy-MM-dd');
                if(commonApiServ.compareFullDate(info.validStartDate,currentTime)==1){
                    $scope.distishi('短信模板使用日期不在有效期内');
                }else if(commonApiServ.compareFullDate(currentTime,info.validEndDate)==1){
                    $scope.distishi('短信模板已过期');
                }else{
                    $$finder.find('disableNoticeModel', {
                        "noticeCode": info.noticeCode,
                        "status": info.status
                    }, {
                        success: function (data) {
                            if (data.content.message == '短信模板已启用' || data.content.message == '短信模板已停用') {
                                $scope.distishi(data.content.message);
                            } else {
                                $scope.distishi('操作失败');
                            }
                        }
                    })
                    if (info.status == '1') {
                        //设置未启用
                        info.status = '0';
                    } else {
                        info.status = '1';
                    }
                }

            }
            $scope.distishi = function (message) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: message,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });
            }

            var nums;
            $scope.checked1 = [];
            $scope.selectAll=function(info){
                if($scope.select_all_message){
                    $scope.checked1 = [];
                    angular.forEach($scope.list,function(info){
                        if(info.status=='0'){
                            info.checked=true;
                            $scope.checked1.push (info.noticeCode);
                        }
                        nums=0;
                    })
                } else {
                    angular.forEach($scope.list,function(info){
                        info.checked=false;
                        $scope.checked1 = [];
                    })
                    nums=1;
                }
                if(nums==0&&$scope.checked1.length==0)
                {
                    $scope.posalDel('4');
                    $scope.select_all_message=false;
                }

            }

            //单选，反选
            $scope.selectOne=function(){
                angular.forEach($scope.list , function (data) {
                    var index = $scope.checked1.indexOf(data.noticeCode);
                    if(data.checked && index === -1) {
                        $scope.checked1.push(data.noticeCode);
                    } else if (!data.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.list.length==$scope.checked1.length){
                    $scope.select_all_message=true;
                }else {
                    $scope.select_all_message=false;
                }
            }

            //是否要确认删除
            $scope.flg = function (message, noticeCode) {
                if (message == '批删') {
                    $scope.plsc()
                }
                else if (message == '单删') {
                    $scope.deleteCoins(noticeCode)
                }
            }


            //批量删除条款信息
            $scope.plsc=function() {
                $scope.checked1 = [];$scope.plscFlag=false;
                angular.forEach($scope.list , function (data) {
                    if(data.checked) {
                        if(data.status=='0'){
                            $scope.checked1.push(data.noticeCode);
                        }else{
                            $scope.plscFlag=true;
                            data.checked=false;
                        }
                    }
                });
                if( $scope.checked1.length!=0&&$scope.plscFlag){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '已剔除有效模板，是否继续删除？',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            $$finder.find('deleteAllUtilNoticeModel', $scope.checked1
                                , {
                                    success: function (data) {
                                        if (data.content.message == 'success') {
                                            $scope.submit()
                                            $scope.posalDel('0')
                                            $scope.checked1 = $scope.cleanData
                                        } else {
                                            $scope.posalDel('1')
                                        }
                                    }
                                })
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if($scope.checked1.length!=0&&!$scope.plscFlag){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '确定要删除吗？此操作不可恢复！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            $$finder.find('deleteAllUtilNoticeModel', $scope.checked1
                                , {
                                    success: function (data) {
                                        if (data.content.message == 'success') {
                                            $scope.submit()
                                            $scope.posalDel('0')
                                            $scope.checked1 = $scope.cleanData
                                        } else {
                                            $scope.posalDel('1')
                                        }
                                    }
                                })
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else{
                    //如果未选中则提示未选中要删除的信息
                    $scope.posalDel('2');
                }
            }

            //单个删除条款信息回调重新加载查询
            $scope.deleteCoins = function (noticeCode) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '确定要删除吗？此操作不可恢复！',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        layer.close(index);
                        $$finder.find('deleteUtilNoticeModel', {
                            "noticeCode": noticeCode
                        }, {
                            success: function (data) {

                                if (data.content.message == '删除成功') {
                                    $scope.submit()
                                    $scope.posalDel('0')
                                } else {
                                    $scope.posalDel('1')
                                }
                            }
                        })
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });

            };

            //公用的提示信息
            $scope.posalDel = function (message) {
                var content;
                if (message == '0') {
                    content = '删除成功！';
                } else if (message == '1') {
                    content = '删除失败！'
                }
                else if (message == '2') {
                    content = '未选择要删除的信息！'
                }
                else if(message=='3'){content='不能选择有效短信模板！'}
                else if(message=='4'){content='当前页面没有无效短信模板！' }
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    scrollbar: false,
                    content: content,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });
            }


            //日期校验
            $scope.compareDate = function (startDate, endDate) {
                var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                if (startDate > endDate) {
                    var content;
                    content = '有效起期不能大于有效止期！';
                    $scope.utilNoticeModelDto.validStartDate = $filter('date')(new Date().setDate('01'), 'yyyy-MM-dd');//起保开始时间
                    $scope.utilNoticeModelDto.validEndDate = '';//终保时间
                    layer.open({
                        //offset: ['45%', '37%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }

            $scope.queryRiskCodeInfo = function () {
                $$finder.find('riskCode', {
                    userCode: '',//用户
                }, {
                    success: function (data) {
                        console.info(data)
                        if (data.code == '0000') {
                            $scope.itemArray = data.content;
                        } else {
                            var msg = "";
                            if (data.message) {
                                msg = data.message;
                            }
                            $scope.distishi(msg, data);
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });

            }

            //$scope.utilNoticeModelDto.comCodeList = ["5651", " 5652", "5653", "5654"]; //放到了选中完毕后
            //$scope.utilNoticeModelDto.comCodeList = $scope.swflogDto.handleCode;
            $scope.utilNoticeModelDto.moduleCode = "2";

            $scope.change = function (data) {
                $scope.riskName = "";
                $scope.utilNoticeModelDto.riskCode = data.riskCode;
                $scope.utilNoticeModelDto.comCode = data.riskCName;
            }
            $scope.addUtilNoticeModel = function () {
                /*console.info($scope.utilNoticeModelDto.riskCode);*/
                var content;
                if ($scope.utilNoticeModelDto.noticeName == null) {
                    content = '请填写模版名称！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.utilNoticeModelDto.noticeContent == null) {
                    content = '请选择短信内容！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.utilNoticeModelDto.validStartDate == ""||$scope.utilNoticeModelDto.validStartDate == null  ) {
                    content = '请输入有效起期！';
                    $scope.distishi(content, null);
                    return;
                }

                if ($scope.utilNoticeModelDto.validEndDate == null ||$scope.utilNoticeModelDto.validEndDate == "") {
                    content = '请输入有效止期！';
                    $scope.distishi(content, null);
                    return;
                }
                if (!$scope.utilNoticeModelDto.riskCName) {
                    content = '请输入适用险种！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($rootScope.treecheck== undefined||!$rootScope.treecheck.length ) {
                    content = '请输入适用机构！';
                    $scope.distishi(content, null);
                    return;
                }
                $scope.utilNoticeModelDto.comCodeList =[];
                angular.forEach($rootScope.treecheck,function(item){
                    $scope.utilNoticeModelDto.comCodeList.push(item.id);
                });
                $$finder.find('addUtilNoticeModel', $scope.utilNoticeModelDto, {

                    success: function (data) {
                        if (data.code == '0000') {
                            $scope.distishi(data.content.noticeCode+"\n"+'新增短信模板成功', data);
                            $scope.eject = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $scope.submit();
                        } else {
                            console.log($scope.utilNoticeModelDto);
                            var msg = "";
                            if (data.message) {
                                msg = "新增短信模板失败";
                            }
                            $scope.distishi(msg, data);
                            $scope.eject = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $scope.submit();
                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });


            }
            //控制新建短信模板的显隐
            $scope.eject = false;
            $scope.showPage = function (type) {
                $scope.riskName = null;
                if(type=='look'){
                    $rootScope.comTreeCtrlFlag=true;
                }else{
                    $rootScope.comTreeCtrlFlag=false;
                }
                $scope.eject = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
            };
            $scope.newUtilNoticeModel = function () {
                $scope.utilNoticeModelDto = {};
                $scope.riskName = "";
                $scope.riskDisable = false;

            };

            $scope.hidePage = function () {
                $scope.eject = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
                console.log($scope.swflogDto.handleCode)
            }

            $scope.riskDisable = false;
            //将页面设置为只读
            $scope.readonlymessage = function () {
                $scope.messageHide = true;
                $scope.riskDisable = true;
            }

            $scope.riskName = null;
            $scope.riskCNameShow = true;

            $rootScope.riskListData = "";
            $scope.listComCode = "";
            $scope.findUtilNoticeModel = function (noticeCode) {
                $scope.riskName = "";
                $$finder.find('findUtilNoticeModel', {
                    noticeCode: noticeCode,
                    comCode: $rootScope.user.loginComCode
                }, {
                    success: function (data) {
                        console.info(data)
                        if (data.code == '0000') {
                            console.info(data);
                            $scope.utilNoticeModelDto = data.content;
                            $scope.riskName = data.content.comCode;
                            $scope.listComCode = data.content.comCodeList;
                            $rootScope.riskListData = data.content.companyListDtos;
                        } else {
                            var msg = "";
                            if (data.message) {
                                msg = data.message;
                            }
                            $scope.distishi(msg, data);
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });

            }

            //取消页面只读状态
            $scope.writemessage = function () {
                $scope.messageHide = false;
            }

            $scope.sign = function () {

                $scope.determineButton = true;//显示确定按钮
                $scope.resetButton = true;//显示重置按钮
                $scope.gobackButton = false;//隐藏返回按钮
                $scope.editButton = false;//显示确定按钮

            }
            $scope.sign2 = function () {

                $scope.determineButton = false;//隐藏确定按钮
                $scope.resetButton = false;//隐藏重置按钮
                $scope.gobackButton = true;//显示返回按钮
                $scope.editButton = false;//显示确定按钮

            }

            $scope.noticeModelEdit = function () {
                $scope.riskDisable = false;
                $scope.determineButton = false;//隐藏确定按钮
                $scope.editButton = true;//显示确定按钮
                $scope.riskName = "";
            }

            $scope.updateUtilNoticeModel = function () {
                //$scope.utilNoticeModelDto.comCodeList = $scope.swflogDto.handleCode;
                $scope.utilNoticeModelDto.comCodeList =[];
                angular.forEach($rootScope.treecheck,function(item){
                    $scope.utilNoticeModelDto.comCodeList.push(item.id

                    );
                });
                var content;
                if ($scope.utilNoticeModelDto.noticeName == null) {
                    content = '请填写模版名称！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.utilNoticeModelDto.noticeContent == null) {
                    content = '请选择短信内容！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.utilNoticeModelDto.validStartDate == ""|| $scope.utilNoticeModelDto.validStartDate == null  ) {
                    content = '请输入有效起期！';
                    $scope.distishi(content, null);
                    return;
                }

                if ($scope.utilNoticeModelDto.validEndDate == null ||$scope.utilNoticeModelDto.validEndDate == "") {
                    content = '请输入有效止期！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($rootScope.treecheck== undefined||!$rootScope.treecheck.length ) {
                    content = '请输入适用机构！';
                    $scope.distishi(content, null);
                    return;
                }
                $$finder.find('updateUtilNoticeModel', $scope.utilNoticeModelDto, {
                    success: function (data) {
                        console.log($scope.utilNoticeModelDto)
                        if (data.code == '0000') {
                            $scope.distishi('修改短信模板成功', data);
                            $scope.eject = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $scope.submit();
                        } else {
                            var msg = "";
                            if (data.message) {
                                msg = "修改短信模板失败";
                            }
                            $scope.distishi(msg, data);
                            $scope.eject = false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $scope.submit();
                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }


            //短信模版管理的查看与修改
            $scope.revise = function (type) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposaledit')
            }
            $scope.showaddpage = false;
            $scope.underwriting = false;
            $scope.pay = false;
        }
    ]);
});