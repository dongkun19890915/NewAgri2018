/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB','config'], function(app, constants, layer, jsonDB,config) {
    'use strict';
    app.registerController('UIPrPoEnVoucherQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter','$state','$window','$$code',
        function($rootScope, $scope, $$finder, $http, $filter,$state,$window,$$code) {
            //提交查询信息
            $scope.totalItems = 0;
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
            //保单详细信息页面跳转
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
            $scope.proposal = {};//查询条件的对象
            $scope.check={};//查询格式校验提示对象
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 20;
            $scope.obj={
                "policyNo": "",//保单号
                "proposalNo":"",
                "printFlag": "",//打印状态 0/1
                "appliCode": "",//投保人代码
                "appliName": "",//投保人名称
                "insuredCode": "",//被保人代码
                "insuredName": "",//被保人名称
                "handlerCode": "",//业务员代码
                "operatorCode": "",//操作员代码
                "operateDateStart":"",//制单日期起期
                "operateDateEnd": "",//制单日期止期
                "comCode": "",//归属机构
                "queryFlag":"1",
                "pageNo": 1,
                "pageSize": 20
            };
            $scope.proposal.prpTmain=angular.copy($scope.obj);
            $scope.proposal.prpTmain.printFlag='0';
            //提交查询信息
            $scope.totalItems=0;
            var cont="";
            //返回按钮
            $scope.goBackDashboard=function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('dashboard');
            }
            $scope.submit=function(){
                if(!$scope.proposal.prpTmain.operateDateStart&&$scope.proposal.prpTmain.operateDateEnd){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "请录入制单起期！",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                if(
                    ($scope.proposal.prpTmain.proposalNo!="" &&$scope.proposal.prpTmain.proposalNo!=null)
                    ||($scope.proposal.prpTmain.policyNo!=null&&$scope.proposal.prpTmain.policyNo != "")
                    ||($scope.proposal.prpTmain.appliName!="" && $scope.proposal.prpTmain.appliName!=undefined)
                    ||($scope.proposal.prpTmain.appliCode!=""&&$scope.proposal.prpTmain.appliCode!=undefined)
                    ||($scope.proposal.prpTmain.insuredName!=""&&$scope.proposal.prpTmain.insuredName!=undefined)
                    ||($scope.proposal.prpTmain.insuredCode!="" &&$scope.proposal.prpTmain.insuredCode!=undefined )
                    ||($scope.proposal.prpTmain.printFlag!=undefined&&$scope.proposal.prpTmain.printFlag!="")
                    ||($scope.proposal.prpTmain.comCode!=undefined&&$scope.proposal.prpTmain.comCode!="")
                    ||($scope.proposal.prpTmain.handlerCode!=undefined&&$scope.proposal.prpTmain.handlerCode!="")
                    ||($scope.proposal.prpTmain.operatorCode!=undefined&&$scope.proposal.prpTmain.operatorCode!="")
                    ||($scope.proposal.prpTmain.fName!=undefined&&$scope.proposal.prpTmain.fName!="")
                    ||($scope.proposal.prpTmain.fCode!=undefined&&$scope.proposal.prpTmain.fCode!="")
                    ||($scope.proposal.prpTmain.operateDateStart!=undefined&&$scope.proposal.prpTmain.operateDateStart!="")
                    ||($scope.proposal.prpTmain.operateDateEnd!=undefined&&$scope.proposal.prpTmain.operateDateEnd!="")
                ) {
                    var content="";
                    var proposalNoReg =/^\d{15,}$/;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉字
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                    var txtReg=/^[\u4E00-\u9FA5]+$/;//汉字
                    var comCodeReg=/(^[\u4E00-\u9FA5]+$)|(^[0-9]+$)/;
                    if($scope.proposal.prpTmain.proposalNo){
                        //投保单号码
                        var reg=/^\d+$/g;
                        if(reg.test($scope.proposal.prpTmain.proposalNo)){
                            if($scope.proposal.prpTmain.proposalNo.length<15){
                                content="投保单号码需输入至少15位数！"
                            }
                        }else{
                            content = '投保单号码格式错误，请修改！';
                            $scope.proposal.prpTmain.proposalNo="";
                        }
                    }else if($scope.proposal.prpTmain.policyNo&&!proposalNoReg.test($scope.proposal.prpTmain.policyNo)){
                        //保单号码
                        var reg=/^\d+$/;
                        if(reg.test($scope.proposal.prpTmain.policyNo)){
                            if($scope.proposal.prpTmain.policyNo.length<15){
                                content="保单号码需输入至少15位数！"
                            }
                        }else{
                            content = '保单号码格式错误，请修改！';
                            $scope.proposal.prpTmain.policyNo="";
                        }
                    }else if($scope.proposal.prpTmain.appliName&&!appliNameReg.test($scope.proposal.prpTmain.appliName)){
                        //投保人名称
                        content="投保人名称格式错误，请修改！";
                        $scope.proposal.prpTmain.appliName="";
                    }else if($scope.proposal.prpTmain.fName&&!appliNameReg.test($scope.proposal.prpTmain.fName)){
                        //投保人名称
                        content="农户名称称格式错误，请修改！";
                        $scope.proposal.prpTmain.appliName="";
                    }else if($scope.proposal.prpTmain.fCode&&!appliCodeReg.test($scope.proposal.prpTmain.fCode)){
                        //投保人代码
                        content="农户代码格式错误，请修改！";
                        $scope.proposal.prpTmain.appliCode="";
                    }else if($scope.proposal.prpTmain.appliCode&&!appliCodeReg.test($scope.proposal.prpTmain.appliCode)){
                        //投保人代码
                        content="投保人代码格式错误，请修改！";
                        $scope.proposal.prpTmain.appliCode="";
                    }else if($scope.proposal.prpTmain.insuredName&&!appliNameReg.test($scope.proposal.prpTmain.insuredName)){
                        //被保险人名称
                        content="被保险人名称格式错误，请修改！";
                        $scope.proposal.prpTmain.insuredName="";
                    }else if($scope.proposal.prpTmain.insuredCode&&!appliCodeReg.test($scope.proposal.prpTmain.insuredCode)){
                        //被保险人代码
                        content="被保险人代码格式错误，请修改！";
                        $scope.proposal.prpTmain.insuredCode="";
                    }/*else if($scope.proposal.prpTmain.comCode&&!comCodeReg.test($scope.proposal.prpTmain.comCode)){
                        //归属机构
                        content="归属机构格式错误，请修改！";
                        $scope.proposal.prpTmain.comCode="";
                    }*/else if($scope.proposal.prpTmain.handler1Code&&!appliCodeReg.test($scope.proposal.prpTmain.handler1Code)){
                        //业务员代码
                        content="业务员代码格式错误，请修改！";
                        $scope.proposal.prpTmain.handler1Code="";
                    }else if($scope.proposal.prpTmain.operatorCode&&!appliCodeReg.test($scope.proposal.prpTmain.operatorCode)){
                        //操作员代码
                        content="操作员代码格式错误，请修改！";
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
                    }else {
                        if ($scope.proposal.prpTmain.proposalNo||$scope.proposal.prpTmain.policyNo) {
                            $scope.proposal.prpTmain.operateDateStart = "";
                            $scope.proposal.prpTmain.operateDateEnd = "";
                        }
                        $scope.proposal.prpTmain.pageNo = $scope.paginationConfmm.currentPage;
                        $scope.proposal.prpTmain.pageSize = $scope.paginationConfmm.itemsPerPage;
                        $scope.proposal.prpTmain.queryFlag='1'
                        var dto = angular.copy($scope.proposal.prpTmain);
                        $$finder.find('queryPolicyListByConditon',dto, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content.content.length>0){
                                    var list = data.content.content;
                                    $scope.proposal.QueryList = list;
                                    $scope.totalItems=data.content.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems =  $scope.totalItems;
                                }else if(data.code=="9999"){
                                    layer.open({
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        scrollbar: false,
                                        title: '温馨提示',
                                        content: '系统异常、请联系管理员！',
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            layer.close(index);
                                        }
                                    });
                                }else{
                                    $scope.proposal.QueryList=[];
                                    $scope.paginationConfmm.totalItems=0;
                                }
                                $scope.select_all="";

                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }
                }else {
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


            //全选
            $scope.checked = [];
            $scope.selectAll = function() {
                if($scope.select_all) {
                    $scope.checked = [];
                    angular.forEach($scope.proposal.QueryList, function(x) {
                        x.checked = true;
                        $scope.checked.push(x.proposalNo);
                    })
                } else {
                    angular.forEach($scope.proposal.QueryList, function(x) {
                        x.checked = false;
                        $scope.checked = [];
                    })
                }
            };
            $scope.configPrint=function(){
                var list=[];
                angular.forEach($scope.proposal.QueryList,function(dto){
                   if(dto.checked){
                        list.push(dto);
                    }
                });
                if(list.length>0){
                    var print = '';
                    var endpolicyNo = '';//保单号
                    for (var i = 0; i < list.length; i++) {
                        if (i == 0) {
                            print = 'policyNo=' + list[i].policyNo;
                        } else {
                            print = '&policyNo=' + list[i].policyNo;
                        }
                        //保单号
                        endpolicyNo = endpolicyNo + print;
                    }
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/VoucherPrinting?' + endpolicyNo);
                }else{
                    layer.open({
                        //offset: ['40%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content:"请先选择单号!",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }
            //单选
            $scope.selectOne = function(y) {
                angular.forEach($scope.proposal.QueryList, function(x) {
                    var index = $scope.checked.indexOf(x.policyNo);
                    if(x.checked && index === -1) { //如果被选中，且不再选中的集合中
                        $scope.checked.push(x.policyNo); //把东西存进选中的集合中
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
            $scope.changeproposalNo= function () {
                if($scope.proposal.prpTmain.proposalNo||$scope.guaranteeSend.policyNo){
                    $scope.guaranteeSend.makeDate="";
                    $scope.endorse.prpPhead.validDate="";
                }else{
                    $scope.guaranteeSend.makeDate=$scope.time.year+'-'+$scope.time.month+'-01';
                    $scope.endorse.prpPhead.validDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                }
            }
            //展开更多查询条件
            $scope.SRC = "common/images/chenpeng/展开.png"
            $scope.conditionShow = false;
            $scope.addFrom = function() {
                $scope.conditionShow = !$scope.conditionShow
                $scope.SRC = !$scope.conditionShow ? "common/images/chenpeng/展开.png" : "common/images/chenpeng/收起.png"
            };
            //获取时间
            var date=new Date()
            $scope.getdate={
                year:date.getFullYear(),
                month:date.getMonth(),
                day:date.getDate()
            }
            $scope.number=function(x)
            {
                return x<10 ? '0'+x:x

            }
            //重置表单
            $scope.reset = function() {
                $scope.proposal.prpTmain = {};
                //$scope.proposal.prpTmain.operateDateStart=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+'01';
                //$scope.proposal.prpTmain.operateDateEnd=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+$scope.number($scope.getdate.day)
                $scope.paginationConfmm.totalItems="";
                $scope.proposal.prpTmain.printFlag='0';
                $scope.proposal.QueryList ={}
            }
            //分页设置
            var initPage2 = function() {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50]
                };
            };
            initPage2();
            $scope.paginationConfmm.totalItems = $scope.totalItems;

            //打印设置弹出
            $scope.configPrintSetShow = false;
            $scope.configPrintSet = function() {
                $scope.configPrintSetShow = !$scope.configPrintSetShow;
            };

            //打印设置确定关闭设置页面1
            $scope.printSure = function() {
                //保存设置
                //待完善
                //打印设置页面关闭
                $scope.configPrintSetShow = !$scope.configPrintSetShow;
            }

            //打印类型选择
            $scope.printtype = 'original';
            $scope.choosePrintype = function (type) {
                $scope.printtype = type;
            };

            //打印信息选择
            $scope.isActive = function(type) {
                var printtype = $scope.printtype == type ? true : false;
                return printtype
            }
			//获取当前时间
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
            //日期校验
            $scope.compareDate1 = function(startDate,endDate) {
                var content;
                if (endDate&&!startDate){
                    content = '请录入制单起期';
                    $scope.proposal.prpTmain.operateDateEnd ="";
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
                    content = '制单止期要大于制单起期';
                    $scope.proposal.prpTmain.operateDateStart = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.proposal.prpTmain.operateDateEnd = $filter("date")(new Date(),"yyyy-MM-dd");
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
            //查询校验  blur事假校验
            $scope.checkproposalNo= function ($event,str) {
                //投保单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.proposalNo="投保单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.proposalNo="投保单号码需至少输入15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.proposalNo="";
                    }
                }else{
                    $scope.check.proposalNo="";
                }
            }
            $scope. changproposalNoAndPolicyNo=function(policyNo){
                if($scope.proposal.prpTmain.proposalNo||$scope.proposal.prpTmain.policyNo){
                    $scope.proposal.prpTmain.operateDateStart = "";//制单日期
                    $scope.proposal.prpTmain.operateDateEnd ="";//制单日期
                }else{
                    $scope.proposal.prpTmain.operateDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//制单日期
                    $scope.proposal.prpTmain.operateDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//制单日期
                }
            }
            $scope.checkpolicyNo= function ($event,str) {
                //保单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.policyNo="保单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.policyNo="保单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.policyNo="";
                    }
                }else{
                    $scope.check.policyNo="";
                }
            }
            $scope.checkappliName= function ($event,str) {
                //投保人名称
                var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str){
                    if(!appliNameReg.test(str)){
                        $scope.check.appliName="投保人名称格式错误，请修改！";
                        $event.target.focus();
                    }
                }else{
                    $scope.check.appliName=""
                }
            }
            $scope.checkappliCode= function ($event,str) {
                //投保人代码
                var appliCodeReg=/^[0-9a-zA-z]+$/;
                if(str&&!appliCodeReg.test(str)){
                    $scope.check.appliCode="投保人代码格式不正确，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.appliCode="";
                }
            }
            $scope.checkinsuredName= function ($event,str) {
                //被保险人名称
                var insuredNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!insuredNameReg.test(str)){
                    $scope.check.insuredName="被保险人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.insuredName="";
                }
            }
            $scope.checkinsuredCode= function ($event,str) {
                //被保险人代码
                var insuredCodeReg=/^[0-9a-zA-z]+$/;
                if(str&&!insuredCodeReg.test(str)){
                    $scope.check.insuredCode="被保险人代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.insuredCode="";
                }
            }
            $scope.checkcomCode= function ($event,str) {
                //归属机构
                var comCodeReg=/(^[\u4E00-\u9FA5]+$)|(^[0-9]+$)/;
                if(str&&!comCodeReg.test(str)){
                    $scope.check.comCode="归属机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.comCode="";
                }
            }
            $scope.checkhandlerCode= function ($event,str) {
                //业务员代码
                var handlerCodeReg=/^[0-9a-zA-z]+$/;
                if(str&&!handlerCodeReg.test(str)){
                    $scope.check.handlerCode="业务员代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.handlerCode="";
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
            $scope.checkFCode= function ($event,str) {
                //操作员代码
                var fCode=/^[0-9a-zA-z]+$/;
                if(str&&!fCode.test(str)){
                    $scope.check.fCode="农户代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.fCode="";
                }
            }
            $scope.checkFName= function ($event,str) {
                //操作员代码
                var fName=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!fName.test(str)){
                    $scope.check.fName="操作员代码格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.fName="";
                }
            }
            $scope.tishi=function(x){
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
            }

        }
    ]);
});