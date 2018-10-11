/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB','config'], function (app, constants, layer, jsonDB,config) {
    'use strict';
    app.registerController('UIPrPoEnEndorsementQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state','$window','commonApiServ',
        '$$code',
        function ($rootScope, $scope, $$finder, $http, $filter, $state,$window,commonApiServ,$$code) {
            $scope.proposal = {};//查询条件的对象
            $scope.check={};
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 5;
            //$scope.proposal.prpTmain.endorDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改起日期
            //$scope.proposal.prpTmain.endorDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改止日期
            //$scope.proposal.prpTmain.validDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改生效起期
            //$scope.proposal.prpTmain.validDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改生效止期
            $scope.conditionShow=false;
            $scope.tabBtn = true;
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
            $scope.addFrom=function(){
                $scope.proposal.prpTmain.operateStartDate= $scope.beginTime;
                $scope.proposal.prpTmain.operateEndDate=$scope.endTime;
                $scope.tabBtn = !$scope.tabBtn;
                $scope.conditionShow=!$scope.conditionShow;

            };
            //提交查询信息
            $scope.totalItems = 0;
            $scope.submit = function () {
                if(!$scope.proposal.prpTmain.endorDateStart&&$scope.proposal.prpTmain.endorDateEnd){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content:  '请录入批改起期！',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                if(!$scope.proposal.prpTmain.validDateStart&&$scope.proposal.prpTmain.validDateEnd){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content:  '请录入批改生效起期！',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                if( ($scope.proposal.prpTmain.policyNo!=null&&$scope.proposal.prpTmain.policyNo != "")
                    ||( $scope.proposal.prpTmain.endorseNo!="" && $scope.proposal.prpTmain.endorseNo!=undefined)
                    ||($scope.proposal.prpTmain.comCode!=""&&$scope.proposal.prpTmain.comCode!=undefined)
                    ||($scope.proposal.prpTmain.appliName!=""&&$scope.proposal.prpTmain.appliName!=undefined)
                    ||($scope.proposal.prpTmain.handler1Code!="" &&$scope.proposal.prpTmain.handler1Code!=undefined )
                    ||($scope.proposal.prpTmain.operatorCode!="" &&$scope.proposal.prpTmain.operatorCode!=null)
                    ||($scope.proposal.prpTmain.endorDateStart!="" &&$scope.proposal.prpTmain.endorDateStart!=null)
                    ||($scope.proposal.prpTmain.endorDateEnd!="" &&$scope.proposal.prpTmain.endorDateEnd!=null)
                    ||($scope.proposal.prpTmain.validDateStart!="" &&$scope.proposal.prpTmain.validDateStart!=null)
                    ||($scope.proposal.prpTmain.validDateEnd!="" &&$scope.proposal.prpTmain.validDateEnd!=null)
                    ||($scope.proposal.prpTmain.EndorType!="" &&$scope.proposal.prpTmain.EndorType!=null)
                    ||($scope.proposal.prpTmain.BusinessType1!="" &&$scope.proposal.prpTmain.BusinessType1!=null)
                ){
                    var proposalNoReg =/^\d{15,}$/g;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/g;// 数字汉子
                    var sumAmountRge=/^\d+$/g;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/g;//数字  字母
                    var content="";
                    var regendorseNo=/^\d{15,21}[-]{0,1}\d{2}$/;
                    if($scope.proposal.prpTmain.endorseNo&&!regendorseNo.test($scope.proposal.prpTmain.endorseNo)){
                        //批改号码
                        var reg=/^\d+$/;
                        if(reg.test($scope.proposal.prpTmain.endorseNo)){
                            if($scope.proposal.prpTmain.endorseNo.length<15){
                                content = '批改号码需输入至少15位数！';
                                $scope.proposal.prpTmain.endorseNo="";
                            }
                        }else{
                            content = '批改号码格式错误，请修改';
                            $scope.proposal.prpTmain.endorseNo="";
                        }
                    }else if($scope.proposal.prpTmain.policyNo&&!proposalNoReg.test($scope.proposal.prpTmain.policyNo)){
                        //保单号码
                        var reg=/^\d+$/g;
                        if(reg.test($scope.proposal.prpTmain.policyNo)){
                            if($scope.proposal.prpTmain.policyNo.length<15){
                                content="保单号码需输入至少15位数！"
                            }
                        }else{
                            content = '保单号码格式错误，请修改';
                            $scope.proposal.prpTmain.policyNo="";
                        }
                    }/*else if($scope.proposal.prpTmain.comCode&&!appliNameReg.test($scope.proposal.prpTmain.comCode)){
                        //归属机构
                        content="归属机构格式错误，请修改";
                        $scope.proposal.prpTmain.comCode="";
                    }*/else if($scope.proposal.prpTmain.appliName&&!appliNameReg.test($scope.proposal.prpTmain.appliName)){
                        //投批改申请人
                        content="投保人名称格式错误，请修改";
                        $scope.proposal.prpTmain.appliName="";
                    }else if($scope.proposal.prpTmain.handler1Code&&!appliCodeReg.test($scope.proposal.prpTmain.handler1Code)){
                        //业务员代码
                        content="业务员代码格式错误，请修改";
                        $scope.proposal.prpTmain.handler1Code="";
                    }else if($scope.proposal.prpTmain.operatorCode&&!appliCodeReg.test($scope.proposal.prpTmain.operatorCode)){
                        //操作员代码
                        content="操作员代码格式错误，请修改";
                        $scope.proposal.prpTmain.operatorCode="";
                    }
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
                    } else {
                        if ($scope.proposal.prpTmain.policyNo || $scope.proposal.prpTmain.endorseNo) {
                            $scope.proposal.prpTmain.endorDateStart = "";
                            $scope.proposal.prpTmain.endorDateEnd = "";
                            $scope.proposal.prpTmain.validDateStart = "";
                            $scope.proposal.prpTmain.validDateEnd = "";
                        }
                        $scope.proposal.prpTmain.pageNo = 1;
                        $scope.proposal.prpTmain.pageSize = 20;
                        var dto = angular.copy($scope.proposal);
                        $$finder.find('queryEndorsListInfo', dto, {
                            success: function (data) {
                                console.log(data);
                                if(data.code=="0000"&&data.content.content.length>0){
                                    $scope.proposal.QueryList = data.content.content;
                                    // $scope.proposal.QueryList = data.content;
                                    $scope.totalItems = data.content.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems = $scope.totalItems;
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
                                    $scope.proposal.QueryList=[];
                                    $scope.paginationConfmm.totalItems = 0;
                                }
                                $scope.select_all="";
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

            //批改日期日期校验
            $scope.compareDate1 = function(startDate,endDate) {
                var content;
                if (endDate&&!startDate){
                    content = '请录入批改起期';
                    $scope.proposal.prpTmain.endorDateEnd="";
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
                    return false
                }else {
                    $scope.day1(startDate,endDate);
                }
            }
            $scope.compareDate11=function(startDate,endDate){
                $scope.day1(startDate,endDate);
            }
            $scope.day1=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10); //有效起期
                var endDate = parseInt(endDate.replace(/-/g, ""), 10); //有效止期
                var content;
                if (startDate>endDate){
                    content = '批改止期要大于批改起期';
                    $scope.proposal.prpTmain.endorDateStart = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.proposal.prpTmain.endorDateEnd = $filter("date")(new Date(),"yyyy-MM-dd");
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

                }
            }
            //批改生效日期日期校验
            $scope.compareDate2 = function(startDate,endDate) {
                var content;
                if (endDate&&!startDate){
                    content = '请录入批改生效起期';
                    $scope.proposal.prpTmain.validDateEnd="";
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
                    return false
                }else {
                    $scope.day1(startDate,endDate);
                }
            }
            $scope.compareDate22=function(startDate,endDate){
                $scope.day1(startDate,endDate);
            }
            $scope.day1=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10); //有效起期
                var endDate = parseInt(endDate.replace(/-/g, ""), 10); //有效止期
                var content;
                if (startDate>endDate){
                    content = '批改生效止期要大于批改生效起期';
                    $scope.proposal.prpTmain.validDateStart = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.proposal.prpTmain.validDateEnd = $filter("date")(new Date(),"yyyy-MM-dd");
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

                }
            }
            //输入批单清空日期
            $scope.changeendorseNo= function (str) {
                if($scope.proposal.prpTmain.endorseNo||$scope.proposal.prpTmain.policyNo){
                    $scope.proposal.prpTmain.endorDateStart = "";//批改起日期
                    $scope.proposal.prpTmain.endorDateEnd = "";//批改止日期
                    $scope.proposal.prpTmain.validDateStart ="";//批改生效起期
                    $scope.proposal.prpTmain.validDateEnd = "";//批改生效止期
                    $scope.proposal.prpTmain.BusinessType1="";
                }else{
                    $scope.proposal.prpTmain.endorDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改起日期
                    $scope.proposal.prpTmain.endorDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改止日期
                    $scope.proposal.prpTmain.validDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改生效起期
                    $scope.proposal.prpTmain.validDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改生效止期
                    $scope.proposal.prpTmain.BusinessType1="01";
                }
            }

            //失去焦点校验
            $scope.checkendorseNo= function ($event,str) {
                //批单号码
                var reg=/^\d{21}[-]\d{2}$/;
                var reg2=/^\d+$/;
                if(str){
                    if(!reg2.test(str)){
                        if(str&&!reg.test(str)){
                            $scope.check.endorseNo="批单号码格式错误，请修改！";
                            $event.target.focus();
                        }
                    }else if(str.length<15){
                        $scope.check.endorseNo="批改号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.endorseNo="";
                    }
                }else{
                    $scope.check.endorseNo="";
                }

            }

            $scope.checkpolicyNo= function ($event,str) {
                //保单号码
                var reg=/^\d+$/g;
                if(str){
                    if(reg.test(str)){
                        if($scope.proposal.prpTmain.policyNo.length<15){
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

            $scope.checkcomCode= function ($event,str) {
                //归属机构
                var reg=/(^[\u4E00-\u9FA5]+$)|(^[0-9]+$)/;
                if(str&&!reg.test(str)){
                    $scope.check.comCode="归属机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.comCode="";
                }
            }

            $scope.checkappliName= function ($event,str) {
                //批改申请人
                var reg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!reg.test(str)){
                    $scope.check.appliName="批改申请人格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.appliName="";
                }
            }
            $scope.checkhandler1Code= function ($event,str) {
                //业务员代码
                var handlerCodeReg=/^[0-9a-zA-z]+$/;
                if(str&&!handlerCodeReg.test(str)){
                    $scope.check.handler1Code="业务员代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.handler1Code="";
                }
            }

            $scope.checkoperatorCode= function ($event,str) {
                //操作员代码
                var operatorCodeReg=/^[0-9a-zA-z]+$/;
                if(str&&!operatorCodeReg.test(str)){
                    $scope.check.operatorCode="操作员代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.operatorCode="";
                }
            }
            //获取后台数据

            $scope.endorse = {};
            $scope.endorse.prpPhead = {};
            //$$finder.find('endorse', {}, {
            //    success: function (data) {
            //        $scope.oderQueryList = data.data.endorse;
            //        $scope.paginationConfmm.totalItems=$scope.oderQueryList.length;
            //        $scope.endorse.prpPhead.businessType1 = data.data.businessType1;
            //        $scope.endorse.prpPhead.endorType = data.data.endorType
            //    },
            //    error: function (e) {
            //        options.error(e);
            //    }
            //});
            //获取投保单信息
            //$scope.QueryList = function () {
            //
            //};
            $scope.inputStatus = {};

            //展开收起按钮;
            function initImgbut() {
                $scope.conditionShow = false;
                $scope.showBeforInveChange = true;
                $scope.showBeforInveInfo = false;
                $scope.showAfterInveInfo = false;
                $scope.conditionShowSRC = $scope.showBeforInveInfoSRC = $scope.showAfterInveInfoSRC = "common/images/chenpeng/展开.png";
                $scope.showBeforInveChangeSRC = "common/images/chenpeng/收起.png"
                $scope.showHidechange = function (type) {
                    $scope[type] = !$scope[type];
                    $scope[type + 'SRC'] = !$scope[type] ? "common/images/chenpeng/展开.png" : "common/images/chenpeng/收起.png"
                };
            }

            initImgbut()

            //重置表单
            $scope.reset = function () {
                $scope.proposal.prpTmain = {};
                $scope.proposal.prpTmain.BusinessType1='01'
                //$scope.proposal.prpTmain.endorDateStart=$scope.time.year+'-'+$scope.time.month+'-'+'01';
                //$scope.proposal.prpTmain.endorDateEnd=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                //$scope.proposal.prpTmain.validDateStart=$scope.time.year+'-'+$scope.time.month+'-'+'01';
                //$scope.proposal.prpTmain.validDateEnd=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.QueryList ={}
            };
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {//如果当前页有变动
                        if ($scope.paginationConfmm.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {

                            $scope.proposal.prpTmain.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.proposal.prpTmain.pageSize = $scope.paginationConfmm.itemsPerPage;
                            var dto = angular.copy($scope.proposal);
                            $$finder.find('queryEndorsListInfo', dto, {
                                success: function (data) {
                                    console.log(data);
                                    if(data.code=="0000"&&data.content.content.length>0){
                                        $scope.proposal.QueryList = data.content.content;
                                        // $scope.proposal.QueryList = data.content;
                                        $scope.totalItems = data.content.totalCount;
                                        //查询结果条数
                                        $scope.paginationConfmm.totalItems = $scope.totalItems;
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
                                        $scope.proposal.QueryList=[];
                                        $scope.paginationConfmm.totalItems = 0;
                                    }
                                    $scope.select_all="";
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        }
                    }
                };
                /*  //当前如果一页能显示出来，不展示分页、
                  if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.itemsPerPage){
                      $scope.paginationConfmm.totalItems=0;
                  }*/
            };
            initPage2();

            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.proposal.QueryList,function(data){
                        data.checked=true;
                        $scope.checked1.push (data.endorseNo);
                    })
                } else {
                    angular.forEach($scope.proposal.QueryList,function(data){
                        data.checked=false;
                        $scope.checked1 = [];
                    })
                }
            }
            //单选，反选
            $scope.selectOne=function(){
                angular.forEach($scope.proposal.QueryList , function (data) {
                    var index = $scope.checked1.indexOf(data.endorseNo);
                    if(data.checked && index === -1) {
                        $scope.checked1.push(data.endorseNo);
                    } else if (!data.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.proposal.QueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }
            $scope.onChange = function () {

            }
            $scope.paginationConfmm.totalItems = $scope.totalItems;

            //打印设置弹出configPrintSet
            $scope.orderLayerShow = false;
            $scope.printSure = function() {
                var dto = angular.copy($scope.proposal.QueryList);
                var list = [];

                angular.forEach($scope.proposal.QueryList, function (dto) {
                    if (dto.checked) {
                        list.push(dto.endorseNo);
                    }
                });
                var print = '';
                var end = '';
                for (var i = 0; i < list.length; i++) {
                    if (i == 0) {
                        print = 'endorseNo=' + list[i];
                    } else {
                        print = '&endorseNo=' + list[i];
                    }
                    end = end + print;
                }

                if ($scope.printType == 'original') {
                    if(!$scope.proposal.visaSerisal||$scope.proposal.visaSerisal=='无可使用流水号'){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '批单打印时流水起始号不能为空!',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return false;
                    }
                    //判断保单如果已经打印，就不能再次打印
                    $$finder.find('endorsePrintStatus',{
                        "endorseNos":list
                    },{
                        success:function(data){
                            $scope.policyYesPrint=data.content
                            if($scope.policyYesPrint.length>0){
                                layer.open({
                                    //offset: ['38%', '31%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '批单号'+$scope.policyYesPrint+'已打印,是否单号作废!',
                                    btn: ['确定', '取消'],
                                    btn1: function(index5, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index5);
                                        $$finder.find('trashTransVisa',{
                                            "userCode":$rootScope.user.userCode,
                                            "visaCode":$scope.visaCode.substring(0,10) ,
                                            "businessNos":list
                                        },{
                                            success:function(data){
                                                var cont="";
                                                if(data.code=="0000"){
                                                    cont="单号作废成功，请重新查询打印!"
                                                }else{
                                                    cont="单号作废成失败，请重新作废!"
                                                }
                                                layer.open({
                                                    //offset: ['38%', '31%'],
                                                    skin: 'large-layer-content',
                                                    scrollbar: false,
                                                    closeBtn: 0,
                                                    title: '温馨提示',
                                                    content:cont ,
                                                    btn: ['确定'],
                                                    btn1: function(index3, layero){
                                                        layer.close(index3);
                                                    }
                                                });
                                            },
                                            error:function(e){
                                                options.error(e);
                                            }
                                        })
                                    },
                                    btn2: function (index1, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index1);
                                    }

                                });

                            }else{
                                //批单正本全打
                                $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrintOriginal?' + end + '&&comCode=' + $rootScope.user.loginComCode + '&&visaCode=' + $("#visaCode").val()+ '&&visaSerialNo=' + $scope.proposal.visaSerisal+'&&userCode='+ $rootScope.user.userCode);

                            }
                        },
                        error:function(e){
                            options.error(e);
                        }
                    });
                    ////批单正本全打
                    //$window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrintOriginal?' + end);
                } else if ($scope.printType == 'duplicate') {
                    //批单抄件打印
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrint?' + end);
                } else if ($scope.printType == 'advice') {
                    //缴费通知书
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePaymentNoticePrint?' + end);
                }
            }
            $scope.configPrintSet = function () {
                var dto=angular.copy( $scope.proposal.QueryList);
                $scope.printlist=[];
                $scope.list=[];
                var printflag=false;
                var isSelect=0;
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked){
                        isSelect=1;
                        if(dto.underwriteFlag=='1'){
                            $scope.list.push(dto);
                        }else{
                            printflag=true;
                            dto.checked=false;
                        }

                    }
                });
                //批量打印时险种要求一样
                if($scope.list.length>1){
                    var riskcode=$scope.list[0].endorseNo.substring(1,5);
                    angular.forEach($scope.list,function(item){
                        if(riskcode!=item.endorseNo.substring(1,5)){
                            isSelect=2;
                        }
                    })
                }
                if(isSelect==0){
                    var cont;
                    cont = '请选中批单！';
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: cont,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if(isSelect==2){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '险种不一致的批单不能批量打印!',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if($scope.list.length==0&&printflag){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '未通过的批单或见费出单未收费的批单不可打印!',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if($scope.list.length>0&&printflag){
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '已剔除错误状态的单号,是否继续打印！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            console.log($scope.list)
                            for (var i = 0; i < 5; i++) {
                                if ($scope.list[i]) {
                                    $scope.printlist.push($scope.list[i]);
                                }
                            }
                            $scope.paginationConfmm1.totalItems = $scope.list.length;
                            $$finder.find('queryVisaCodesAndVisaSerialNos',{
                                "businessNo":$scope.list[0].endorseNo+','+$scope.list.length,
                                "comCode": $rootScope.user.loginComCode,
                                "userCode":$rootScope.user.userCode
                            }, {
                                success: function (data) {
                                    if(data.code=="9999"){
                                        layer.open({
                                            skin: 'large-layer-content',
                                            scrollbar: false,
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: data.message,
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                layer.close(index);
                                            }
                                        });
                                    }
                                    console.log(data);
                                    angular.forEach(data.content, function (_data) {
                                        $scope.proposal.visaSerisal=_data.visaSerisal;
                                        $scope.visaType=_data.visaCode+'-'+_data.visaName;
                                        $scope.visaCode=_data.visaCode;
                                    })
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                            $scope.orderLayerShow = true;
                            $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            $scope.endorseNo=$scope.list[0].endorseNo;
                            $scope.proposalNo=$scope.list[0].proposalNo;
                            layer.close(index);
                        },
                        btn2: function (index1, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index1);
                        }
                    });
                }else{
                    console.log($scope.list)
                    for (var i = 0; i < 5; i++) {
                        if ($scope.list[i]) {
                            $scope.printlist.push($scope.list[i]);
                        }
                    }
                    $scope.paginationConfmm1.totalItems = $scope.list.length;
                    $$finder.find('queryVisaCodesAndVisaSerialNos',{
                        "businessNo":$scope.list[0].endorseNo+','+$scope.list.length,
                        "comCode": $rootScope.user.loginComCode,
                        "userCode":$rootScope.user.userCode
                    }, {
                        success: function (data) {
                            if(data.code=="9999"){
                                layer.open({
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: data.message,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        layer.close(index);
                                    }
                                });
                            }
                            console.log(data);
                            angular.forEach(data.content, function (_data) {
                                $scope.proposal.visaSerisal=_data.visaSerisal;
                                $scope.visaType=_data.visaCode+'-'+_data.visaName;
                                $scope.visaCode=_data.visaCode;
                            })
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                    $scope.orderLayerShow = true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    $scope.endorseNo=$scope.list[0].endorseNo;
                    $scope.proposalNo=$scope.list[0].proposalNo;
                }
                //$scope.orderLayerShow = true;

            };

            //打印设置确定关闭设置页面

            //打印设置确定关闭设置页面
            $scope.configPrintSetfa = function () {
                //保存设置
                //待完善
                //打印设置页面关闭
                $scope.orderLayerShow = false
                $("html,body").css({overflow:"auto"});//出现滚动条

            };
            //打印类型选择
            $scope.printType = 'original';
            $scope.choosePrintype = function (type) {
                $scope.printType = type;
            };
            $scope.printListShow=false;
            $scope.showprintListShow= function () {
                $scope.printListShow=true;

            }
            $scope.showprintListHide= function () {
                $scope.printListShow=false;
            }
            var initPage3 = function ($event) {
                $scope.paginationConfmm1 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 5,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        $scope.printlist = [];
                        for (var i = ($scope.paginationConfmm1.currentPage - 1) * $scope.paginationConfmm1.itemsPerPage; i < $scope.paginationConfmm1.currentPage * $scope.paginationConfmm1.itemsPerPage; i++) {
                            if ($scope.list[i]) {
                                $scope.printlist.push($scope.list[i]);
                            }

                        }
                    }
                }
            };
            initPage3();
            //查看批单信息
            $scope.showorderlayerBox = false;
            $scope.lookDetail = function (info) {
                $scope.showorderlayerBox = true;
                $scope.personInfo = info;
                $$finder.find('endorseProposal', {}, {
                    success: function (data) {
                        $scope.endorseProposalLast = data.data.endorseProposalLast;
                        $scope.endorseProposalPresent = data.data.endorseProposalPresent;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                })
            };
            //打印信息选择
            $scope.isActive = function (type) {
                var printtype = $scope.printType == type ? true : false;
                return printtype
            };
            //关闭弹出框
            $scope.cancel = function () {
                $scope.orderLayerShow = false;
                $scope.showorderlayerBox = false
                $("html,body").css({overflow:"auto"});//出现滚动条
            };
            //全选/多选功能按钮
            $scope.orderChecked = false;
            //单选
            $scope.checked = [];
            $scope.selectOne = function() {
                console.log(222222)
                angular.forEach($scope.proposal.QueryList, function(x) {
                    console.log($scope.checked)
                    var index = $scope.checked.indexOf(x.endorseNo);
                    if(x.checked && index === -1) { //如果被选中，且不再选中的集合中
                        $scope.checked.push(x.endorseNo); //把东西存进选中的集合中
                    } else if(!x.checked && index !== -1) { //如果存在就进行删除
                        $scope.checked.splice(index, 1);
                    };
                });
                if($scope.proposal.QueryList.length === $scope.checked.length) {
                    $scope.select_all = true;
                } else {
                    $scope.select_all = false;
                }

            }

            // 批单打印
            $scope.configPrint = function(){

                var endorseNo = $scope.checked[0];

                //var watchContract= proposal.proposalNoBI||proposal.proposalNoCI;


                //$window.open('/print/InsuranceFormPrint?proposalNo='+ watchContract);
                //$window.open('/pdf/newpdf.html?fileID='+'http://localhost:9010/print/InsuranceFormPrint?proposalNo=131013400002008000463');//2017.12.28 改之前
                //$window.open('/prpall/pdf/newpdf.html?fileID='+'/api/agriprpall/print/InsuranceFormPrint?proposalNo=T28010118002018000092');
                $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID='+'/api/agriprpall/print/endorseInfoPrint?endorseNo='+endorseNo);
                //api/agriprpall/proposalmanage/queryProposalListInfoByConditon
                //http://192.168.0.44:9010/print/InsuranceFormPrint?proposalNo=131013400002008000463
            };

            ////测试数据
            //$scope.$watch('endorse.prpPhead.businessType1.selected', function (a, b) {
            //    console.log(a)
            //    console.log(b)
            //})


            var go = function (item, type) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIEndorse3107edit', {
                    editType: type,
                    bizNo: item.endorseNo,
                })
            };
            $scope.UIEndorseSee = function (item) {  //跳转批单查看页面
                go(item, 'show');
            };
            //模板创建日期初始值
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
            $scope.getProposalInfo = function (modelCode) {
                //var proposalNo=$scope.proposal.QueryList[index].proposalNo
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposalshow', {modelCode:modelCode})
            }
        }]);
});
