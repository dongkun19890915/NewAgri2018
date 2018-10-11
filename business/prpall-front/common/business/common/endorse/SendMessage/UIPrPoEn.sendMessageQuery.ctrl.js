/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnSendMessageQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state','$$code',
        function ($rootScope, $scope, $$finder, $http, $filter, $state,$$code) {
            $scope.selectListData={};// 级联下拉列表数据
            // 获取归属机构下拉列表
            $scope.getComCodeList=function(){
                var comCodeData={
                    comCode: '',
                    comCName: '',
                    riskCode: '',
                    gradeCodes: '111',
                    userCode: $scope.user.userCode,
                    loginComCode: $scope.user.loginComCode
                };
                $$code.getCodes('codeType', 'queryComCodeInfo', { },comCodeData).then(function (data) {
                    $scope.selectListData.comCodeList = data;
                });
            };
            $scope.smsConditionDto = {
                policyNo: null,
                phoneNo: null,
                appName: null,
                appCode: null,
                insuredName: null,
                insuredCode: null,
                makeCom: null,
                startDateStart: null,
                startDateEnd: null,
                endDateStart: null,
                endDateEnd: null,
            }
            // $scope.smsConditionDto.startDateStart=$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//起保开始时间
            //$scope.smsConditionDto.startDateEnd =  $filter('date')(new Date(),'yyyy-MM-dd');//终保时间

            //分页设置s
            $scope.submit = function () {
                if(($scope.smsConditionDto.policyNo!=null&&$scope.smsConditionDto.policyNo != "")
                    ||( $scope.smsConditionDto.phoneNo!="" && $scope.smsConditionDto.phoneNo!=undefined)
                    ||($scope.smsConditionDto.appName!=""&&$scope.smsConditionDto.appName!=undefined)
                    ||($scope.smsConditionDto.appCode!=""&&$scope.smsConditionDto.appCode!=undefined)
                    ||($scope.smsConditionDto.insuredName!="" &&$scope.smsConditionDto.insuredName!=undefined )
                    ||($scope.smsConditionDto.insuredCode!="" &&$scope.smsConditionDto.insuredCode!=undefined )
                    ||($scope.smsConditionDto.startDateStart!="" &&$scope.smsConditionDto.startDateStart!=undefined )
                    ||($scope.smsConditionDto.startDateEnd!="" &&$scope.smsConditionDto.startDateEnd!=undefined )
                    ||($scope.smsConditionDto.makeCom!="" &&$scope.smsConditionDto.makeCom!=null)
                    ||($scope.smsConditionDto.endDateStart!="" &&$scope.smsConditionDto.endDateStart!=undefined)
                    ||($scope.smsConditionDto.endDateEnd!="" &&$scope.smsConditionDto.endDateEnd!=undefined)
                ){
                    var telReg=/^1[3|4|5|9|6|7|8][0-9]\d{4,8}$/;//手机号码
                    var proposalNoReg =/^\d{15,}$/;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉子
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                    var content="";
                    if($scope.smsConditionDto.policyNo){
                        //保单号码
                        var reg=/^\d+$/g;
                        if(reg.test($scope.smsConditionDto.policyNo)){
                            if($scope.smsConditionDto.policyNo.length<15){
                                content="保单号码需输入至少15位数！"
                            }
                        }else{
                            content = '保单号码格式错误，请修改';
                            $scope.smsConditionDto.policyNo="";
                        }
                    }else if($scope.smsConditionDto.phoneNo&&!telReg.test($scope.smsConditionDto.phoneNo)){
                        //手机号
                        content="手机号格式错误，请修改";
                        $scope.smsConditionDto.phoneNo="";
                    }else if($scope.smsConditionDto.appName&&!appliNameReg.test($scope.smsConditionDto.appName)){
                        //投保人名称
                        content="投保人名称格式错误，请修改";
                        $scope.smsConditionDto.appName="";
                    }else if($scope.smsConditionDto.appCode&&!appliCodeReg.test($scope.smsConditionDto.appCode)){
                        //投保人代码
                        content="投保人代码格式错误，请修改";
                        $scope.smsConditionDto.appCode="";
                    }else if($scope.smsConditionDto.insuredName&&!appliNameReg.test($scope.smsConditionDto.insuredName)){
                        //被保险人名称
                        content="被保险人名称格式错误，请修改";
                        $scope.smsConditionDto.insuredName="";
                    }else if($scope.smsConditionDto.insuredCode&&!appliCodeReg.test($scope.smsConditionDto.insuredCode)){
                        //被保险人代码
                        content="被保险人代码格式错误，请修改";
                        $scope.smsConditionDto.insuredCode="";
                    }/*else if($scope.smsConditionDto.makeCom&&!appliNameReg.test($scope.smsConditionDto.makeCom)){
                        //出单机构
                        content="出单机构格式错误，请修改";
                        $scope.smsConditionDto.makeCom="";
                    }*/
                    if(content){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    } else{
                        if($scope.smsConditionDto.policyNo){
                            $scope.smsConditionDto.startDateStart =''
                            $scope.smsConditionDto.startDateEnd = ''
                            $scope.smsConditionDto.endDateStart= ''
                            $scope.smsConditionDto. endDateEnd =''
                        }
                        $scope.smsConditionDto = {
                            'policyNo': $scope.smsConditionDto.policyNo,
                            'phoneNo': $scope.smsConditionDto.phoneNo,
                            'appName': $scope.smsConditionDto.appName,
                            'appCode': $scope.smsConditionDto.appCode,
                            'insuredName': $scope.smsConditionDto.insuredName,
                            'insuredCode': $scope.smsConditionDto.insuredCode,
                            'makeCom': $scope.smsConditionDto.makeCom,
                            'startDateStart': $scope.smsConditionDto.startDateStart,
                            'startDateEnd': $scope.smsConditionDto.startDateEnd,
                            'endDateStart': $scope.smsConditionDto.endDateStart,
                            'endDateEnd': $scope.smsConditionDto.endDateEnd,
                            'pageNo': $scope.paginationConfmm.currentPage,
                            'pageSize': $scope.paginationConfmm.itemsPerPage
                        }
                        $$finder.find('querySmsListByCondition',$scope.smsConditionDto, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content.content.length>0){
                                    console.log(data);
                                    $scope.list = data.content.content;
                                    $scope.paginationConfmm.totalItems = data.content.totalCount;
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

                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }
                }else{
                    var content;
                    content = '至少输入一个查询条件！';
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
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
            $scope.policyNoChang= function (str) {
                if(str){
                    $scope.smsConditionDto.startDateStart="";
                    $scope.smsConditionDto.startDateEnd="";
                    $scope.smsConditionDto.endDateStart="";
                    $scope.smsConditionDto.endDateEnd="";
                }else{
                    $scope.smsConditionDto.startDateStart=$filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//起保开始时间
                    $scope.smsConditionDto.startDateEnd =  $filter('date')(new Date(),'yyyy-MM-dd');//终保时间
                    $scope.smsConditionDto.endDateStart=$scope.time.year+1+'-'+$scope.time.month+'-01';
                    $scope.smsConditionDto.endDateEnd=$scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date;
                }
            }
            //失去焦点校验
            $scope.check={};
            $scope.checkpolicyNo= function ($event,str) {
                //保单号码
                var reg=/^\d+$/g;
                if(str){
                    if(reg.test(str)){
                        if($scope.smsConditionDto.policyNo.length<15){
                            $scope.check.policyNo="保单号码需输入至少15位数！";
                            $event.target.focus();
                        }else{
                            $scope.check.policyNo="";
                        }
                    }else{
                        $scope.check.policyNo = '保单号码格式错误，请修改!';
                        $event.target.focus();
                    }
                }else{
                    $scope.check.policyNo="";
                }

            }
            $scope.checkphoneNo= function ($event,str) {
                //手机号
                var telReg2=/^1[3|4|5|9|6|7|8][0-9]{0,}$/;
                var telReg=/^1[3|4|5|9|6|7|8][0-9]{9}$/;
                if(str){
                    if(!telReg2.test(str)){
                        $scope.check.phoneNo="手机号号段错误，请修改!";
                        $event.target.focus();
                    }else if(str&&!telReg.test(str)){
                        $scope.check.phoneNo="手机号长度错误，请修改!";
                        $event.target.focus();
                    }else{
                        $scope.check.phoneNo="";
                    }
                }else{
                    $scope.check.phoneNo="";
                }
            }
            $scope.checkappName= function ($event,str) {
                //投保人名称
                var reg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.appName="投保人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.appName="";
                }
            }
            $scope.checkappCode= function ($event,str) {
                //投保人代码
                var reg=/^[A-Za-z0-9]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.appCode="投保人代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.appCode="";
                }
            }
            $scope.checkinsuredName= function ($event,str) {
                //被保险人名称
                var reg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.insuredName="被保险人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.insuredName="";
                }
            }
            $scope.checkinsuredCode= function ($event,str) {
                //被保险人代码
                var reg=/^[A-Za-z0-9]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.insuredCode="被保险人代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.insuredCode="";
                }
            }
            $scope.checkmakeCom= function ($event,str) {
            //    出单机构
                var  reg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.makeCom="出单机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.makeCom="";
                }
            }
            //日期校验
            $scope.compareDate=function(startDate,endDate){
                var content;
                if (startDate==""||!startDate) {
                    content = '请录入起保日期！';
                    $scope.smsConditionDto.startDateEnd = "";
                    layer.open({
                        //offset: ['40%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
                    var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                    var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                    if (startDate > endDate) {
                        var content;
                        content = '终保日期要大于起保日期';
                        /*$scope.proposal.prpMmodelMainRequest.endDate = "";*/
                        $scope.smsConditionDto.startDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//起保开始时间
                        $scope.smsConditionDto.startDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//终保时间
                        layer.open({
                            //offset: ['40%', '40%'],
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
                    }
                }
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
                $scope.smsConditionDto = {
                //startDateStart :$scope.time.year+'-'+$scope.time.month+'-01',
                //startDateEnd : $scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date,
                //endDateStart:  $scope.time.year+1+'-'+$scope.time.month+'-01',
                //endDateEnd : $scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date
                };
                $scope.list={};
                $scope.paginationConfmm.totalItems=0;
            }

            //展开更多查询条件
            $scope.SRC = "common/images/chenpeng/展开.png";
            $scope.sendMessageShow = false;
            $scope.addFrom = function () {
                $scope.sendMessageShow = !$scope.sendMessageShow;
                $scope.SRC = !$scope.sendMessageShow ? "common/images/chenpeng/展开.png" : "common/images/chenpeng/收起.png";
            };

            //是否要确认删除
            $scope.sendsuccess = function ( info) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '确定要重新发送吗？',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        layer.close(index);
                        $$finder.find('resendNotice', {
                            "id": info.id
                        }, {
                            success: function (data) {
                                if (data.content.resultMsg == '处理成功' || data.content.resultMsg == '处理失败') {
                                    $scope.distishi(data.content.resultMsg,info);
                                } else {
                                    $scope.distishi('操作失败',info);
                                }
                                $scope.submit();
                            }
                        })
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });
            }

            $scope.distishi = function (message,info) {
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
            };

            $scope.coinsuranceCount = true;//查看按钮
            $scope.messageAgentShow = false;//控制发送内容显示隐藏
            //条款详情弹出
            $scope.messageDetailsShow = false;

            $scope.coinsurance = function (content) {
                $scope.messageDetailsShow = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                $scope.messageAgentShow = !$scope.messageAgentShow;
                $scope.coinsuranceCount = !$scope.coinsuranceCount;
                $scope.content = content;
            }

            $scope.closeMessageDetailsShow = function () {
                $scope.messageDetailsShow = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            };



            $scope.compareDate1=function(startDate,endDate){
                var content;
                if (endDate&&!startDate) {
                    content = '请输入起保起期！';
                    $scope.smsConditionDto.startDateEnd = "";
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
                    $scope.day1(startDate,endDate);
                }
            }
            $scope.compareDate11=function(startDate,endDate){
                $scope.day1(startDate,endDate);
            }
            $scope.day1=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                if (startDate > endDate) {
                    var content;
                    content = '起保止期要大于起保起期';
                    $scope.smsConditionDto.startDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//起保开始时间
                    $scope.smsConditionDto.startDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//起保开始时间
                    layer.open({
                        //offset: ['40%', '40%'],
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
                }
            }
            $scope.compareDate3=function(startDate,endDate){
                var content;
                if (endDate&&!startDate) {
                    content = '请输入终保起期！';

                    $scope.smsConditionDto.endDateStart = "";
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
                    $scope.day3(startDate,endDate);
                }
            }
            $scope.compareDate33=function(startDate,endDate){
                $scope.day3(startDate,endDate);
            }
            $scope.day3=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                if (startDate > endDate) {
                    var content;
                    content = '终保止期要大于终保起期';
                    $scope.smsConditionDto.endDateStart=$scope.time.year+1+'-'+$scope.time.month+'-01',
                        $scope.smsConditionDto.endDateEnd =$scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date
                    layer.open({
                        /*offset: ['45%', '40%'],*/
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
                }
            }

            $scope.compareDate22=function(startDate,endDate){
                $scope.day2(startDate,endDate);
            }
            $scope.day2=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                if (startDate > endDate) {
                    var content;
                    content = '制单止期要大于制单起期';
                    /*$scope.proposal.prpMmodelMainRequest.endDate = "";*/
                    $scope.proposal.prpTmain.operateDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//制单开始日期
                    $scope.proposal.prpTmain.operateDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//制单截止日期
                    layer.open({
                        /*offset: ['45%', '40%'],*/
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
                }
            }
            //    创建日期初始化
            $scope.nowDate=new Date();
            $scope.time={
                year:$scope.nowDate.getFullYear(),
                month:(function () {
                    var month=$scope.nowDate.getMonth()+1;
                    return month>=10?month:"0"+month
                })(),
                date:(function(){
                    var date=$scope.nowDate.getDate();
                    return date>=10?date:"0"+date
                })()
            }

        }]);
});