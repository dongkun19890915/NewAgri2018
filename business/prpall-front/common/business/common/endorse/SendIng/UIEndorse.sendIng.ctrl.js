/**
 * Created by hanyuhuai on 2017/12/.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIEndorseSendIngCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter',
        function ($rootScope, $scope, $$finder, $http, $filter) {

            $scope.reqMessageDto = {};
            $scope.disable = false;

            $scope.reqMessageDto.noticeContent = "";
            $scope.count = 0;
            $scope.sendNumber = 0;

            $scope.immediatelySend = function () {
                if ($scope.disable == false) {
                    $scope.disable = true;
                    $scope.reqMessageDto.sendTime= "";
                }
                else {
                    $scope.disable = false;
                }
            }


            $scope.confirm = function () {
                var content;
                if($scope.reqMessageDto.noticeContent.length >250) {
                    content = '短信内容不能超过250个字！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.reqMessageDto.policyNo == null) {
                    content = '请先关联保单！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.reqMessageDto.noticeName == null) {
                    content = '请选择短信模板！';
                    $scope.distishi(content, null);
                    return;
                }
                if ($scope.sendNumber == 0) {
                    content = '发送号码个数不能为0！';
                    $scope.distishi(content, null);
                    return;
                }

                if ($scope.count == 0) {
                    content = '短信内容不能为空！';
                    $scope.distishi(content, null);
                    return;
                }

                if ($scope.reqMessageDto.sendTime == null && $scope.reqMessageDto.immediatelySend == null) {
                    content = '请选择发送时间！';
                    $scope.distishi(content, null);
                    return;
                }

                if (Date.parse($scope.reqMessageDto.sendTime) <= new Date()) {
                    content = '发送时间不能小于当前时间！';
                    $scope.distishi(content, null);
                    return;
                }

                if ($scope.reqMessageDto.immediatelySend != null) {
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '确定要立即发送吗？',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            layer.close(index);

                            $$finder.find('getSmsContent', $scope.reqMessageDto, {
                                success: function (data) {
                                    if (data.code == '0000') {
                                        $scope.distishi('短信立即发送成功', data);
                                        $scope.reset();
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
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });

                }

                if ($scope.reqMessageDto.immediatelySend == null) {
                    $scope.reqMessageDto.immediatelySend = false;
                    $$finder.find('getSmsContent', $scope.reqMessageDto, {
                        success: function (data) {
                            if (data.code == '0000') {
                                $scope.distishi('短信预定发送成功', data);
                                $scope.reset();
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
            }

            //统计字数
            $scope.change=function (data){
                $scope.reqMessageDto.noticeContent=data.noticeContent;
                $scope.count=$scope.reqMessageDto.noticeContent.length;
            }

            //统计字数
            $scope.tolCount = function () {
                $scope.count=$scope.reqMessageDto.noticeContent.length;
            };
            $scope.changdu = function () {
                if($scope.reqMessageDto.noticeContent.length>250){
                    var content = '短信内容不能超过250个字！';
                    $scope.distishi(content, null);
                }
            };

            //根据短信模板获取短信内容
            $scope.findNoticeContent = function () {
                var riskCode="";
                if($scope.reqMessageDto.policyNo){
                    riskCode=$scope.reqMessageDto.policyNo.substring(1,5);
                }
                $$finder.find('findNoticeContent', {
                    userCode: $rootScope.user.userCode,//用户代码
                    comCode: $rootScope.user.loginComCode,//用户登录机构
                    "loginGradeCodes": "111",
                    "riskCode": riskCode,
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            $scope.itemArray =  data.content;
                        } else {
                            var msg="";
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

            /**
             * 关联保单
             */
            $scope.getSendNumber = function () {
                var content;
                if ($scope.reqMessageDto.policyNo == null) {
                    content = '保单号不能为空!';
                    $scope.distishi(content, null);
                    return;
                }
                $$finder.find('getSendNumber', {
                    "policyNo": $scope.reqMessageDto.policyNo,
                    "loginComCode": $rootScope.user.loginComCode,
                    "userCode": $rootScope.user.userCode,
                    "tableName": "PrpDcompany",
                    "userCodeFields": "userCode",
                    "comCodeFields": "comCode"
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            $scope.distishi('关联保单成功', data);
                            $scope.sendNumber = data.content.sendNumber;
                        } else if (data.code == '9999') {
                            $scope.distishi(data.message, data);
                        }
                    }
                })
            }


            $scope.distishi = function (message, data) {
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


            //重置表单
            $scope.reset = function () {
                $scope.reqMessageDto= {};
                $scope.count = 0;
                $scope.sendNumber = 0;
                $scope.disable = false;
            }

        }]);
});
