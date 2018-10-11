/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB','config', 'encodeUrl'], function (app, constants, layer, jsonDB,config) {
    'use strict';
    app.registerController('UIPrPoEnQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state','commonApiServ','$window','$$code',
        function ($rootScope, $scope, $$finder, $http, $filter, $state,commonApiServ,$window,$$code) {
            $scope.selectListData={};// 级联下拉列表数据
            $scope.proposal = {};//查询条件的对象
            $scope.check={};
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 20;
            $scope.proposal.prpTmain.printFlag='0';
            //$scope.relativeInsureListCode=false;
            $("#relativeInsureListCode").hide();
            $scope.getdate = commonApiServ.setDateTime();
            //$scope.proposal.prpTmain.startDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//起保开始时间
            //$scope.getdate1 = commonApiServ.getNextYearFullDate($scope.proposal.prpTmain.startDate,1,2);//起保截止时间
            //$scope.proposal.prpTmain.operateStartDate = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//制单开始日期
            //$scope.proposal.prpTmain.operateEndDate = $filter('date')(new Date(),'yyyy-MM-dd');//制单截止日期
            $scope.underWriteFlagList = [/*{'codeCode': '', 'codeName': '所有'},*/{'codeCode': '0', 'codeName': '初始值'}, {'codeCode': '1', 'codeName': '通过'}, {'codeCode': '2', 'codeName': '不通过'}, {'codeCode': '3', 'codeName': '无需核保'}, {'codeCode': '9', 'codeName': '待核保'}, {'codeCode': '10', 'codeName': '核保退回'}, {'codeCode': '11', 'codeName': '已撤单'}];
            //日期校验
            $scope.checkDate = function(x,y){
                if(commonApiServ.compareFullDate(x,y) == 1){
                    $scope.proposal.prpTmain.operateEndDate =''+$scope.getdate.year+'-'+$scope.getdate.month+'-'+ $scope.getdate.day;
                    layer.open({
                        /*area: ['37%', '318px'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '制单截止日期不能早于制单起始日期',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            layer.close(index);
                        }
                    });
                }
            }

            /*$scope.limt = function(y){
             if(commonApiServ.compareFullDate(y,$scope.proposal.prpTmain.operateStartDate) == 1){
             layer.open({
             /!*area: ['37%', '318px'],*!/
             skin: 'large-layer-content',
             closeBtn: 0,
             title: '温馨提示',
             content: '制单截止日期不能早于制单起始日期',
             btn: ['确定'],
             btn1: function (index, layero) {
             layer.close(index);
             }
             });
             return $scope.proposal.prpTmain.operateEndDate =''+$scope.getdate.year+'-'+$scope.getdate.month+'-'+ $scope.getdate.day;
             }
             }*/
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

            //提交查询信息
            $scope.totalItems = 0;
            $scope.submit = function () {
                if (($scope.proposal.prpTmain.proposalNo != ""&&$scope.proposal.prpTmain.proposalNo !=undefined)
                    ||($scope.proposal.prpTmain.appliName != ""&&$scope.proposal.prpTmain.appliName != undefined)
                    ||($scope.proposal.prpTmain.appliCode != ""&&$scope.proposal.prpTmain.appliCode !=undefined )
                    ||($scope.proposal.prpTmain.insuredName != ""&&$scope.proposal.prpTmain.insuredName !=undefined)
                    ||($scope.proposal.prpTmain.insuredCode != ""&&$scope.proposal.prpTmain.insuredCode !=undefined)
                    ||($scope.proposal.prpTmain.sumAmount != ""&&$scope.proposal.prpTmain.sumAmount != undefined)
                    ||($scope.proposal.prpTmain.sumPremium != ""&&$scope.proposal.prpTmain.sumPremium != undefined)
                    ||($scope.proposal.prpTmain.comCode !=""&&$scope.proposal.prpTmain.comCode != undefined)
                    ||($scope.proposal.prpTmain.handler1Code != ""&&$scope.proposal.prpTmain.handler1Code != undefined)
                    ||($scope.proposal.prpTmain.operatorCode != ""&&$scope.proposal.prpTmain.operatorCode !=undefined)
                    ||($scope.proposal.prpTmain.underWriteFlag != ""&&$scope.proposal.prpTmain.underWriteFlag!=undefined)
                    ||($scope.proposal.prpTmain.printFlag != ""&&$scope.proposal.prpTmain.printFlag!=undefined)
                    ||($scope.proposal.prpTmain.startDate != ""&&$scope.proposal.prpTmain.startDate!=undefined)
                    ||($scope.proposal.prpTmain.startEndDate != ""&&$scope.proposal.prpTmain.startEndDate!=undefined)
                    ||($scope.proposal.prpTmain.endStartDate != ""&&$scope.proposal.prpTmain.endStartDate!=undefined)
                    ||($scope.proposal.prpTmain.endDate != ""&&$scope.proposal.prpTmain.endDate!=undefined)
                    ||($scope.proposal.prpTmain.operateStartDate != ""&&$scope.proposal.prpTmain.operateStartDate!=undefined)
                    ||($scope.proposal.prpTmain.operateEndDate != ""&&$scope.proposal.prpTmain.operateEndDate!=undefined)
                    ||($scope.proposal.prpTmain.BusinessType1 != ""&&$scope.proposal.prpTmain.BusinessType1!=undefined)
                )
                {
                    var proposalNoReg =/^\d{15,}$/;//投保单号码验证正则
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 投保人名称、被保人名称、归属机构验证正则
                    var sumAmountRge=/^\d+$/;//总保险金额、总保险费验证正则
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//投保人代码、被保人代码验证正则
                    var content="";
                    if($scope.proposal.prpTmain.proposalNo&&!proposalNoReg.test($scope.proposal.prpTmain.proposalNo)){
                        var reg=/^\d+$/;
                        if(reg.test($scope.proposal.prpTmain.proposalNo)){
                            if($scope.proposal.prpTmain.proposalNo.length<15){
                                content="投保单号码需输入至少15位数！"
                            }
                        }else{
                            content = '投保单号码格式错误，请修改!';
                            $scope.proposal.prpTmain.proposalNo="";
                        }
                    }else if($scope.proposal.prpTmain.appliName&&!appliNameReg.test($scope.proposal.prpTmain.appliName)){
                        //投保人名称
                        content="投保人名称格式错误，请修改!";
                        $scope.proposal.prpTmain.appliName="";
                    }else if($scope.proposal.prpTmain.appliCode&&!appliCodeReg.test($scope.proposal.prpTmain.appliCode)){
                        //投保人代码
                        content="投保人代码格式错误，请修改!";
                        $scope.proposal.prpTmain.appliCode="";
                    }else if($scope.proposal.prpTmain.insuredCode&&!appliCodeReg.test($scope.proposal.prpTmain.insuredCode)){
                        //被保人代码
                        content="被投保人代码格式错误，请修改!";
                        $scope.proposal.prpTmain.insuredCode="";
                    }else if($scope.proposal.prpTmain.insuredName&&!appliNameReg.test($scope.proposal.prpTmain.insuredName)){
                        //被保人名称
                        content="被保人名称格式错误，请修改!";
                        $scope.proposal.prpTmain.insuredName="";
                    }else if($scope.proposal.prpTmain.handler1Code&&!appliCodeReg.test($scope.proposal.prpTmain.handler1Code)){
                        //业务员代码
                        content="业务员代码格式错误，请修改!";
                        $scope.proposal.prpTmain.handler1Code="";
                    }else if($scope.proposal.prpTmain.operatorCode&&!appliCodeReg.test($scope.proposal.prpTmain.operatorCode)){
                        //操作员代码
                        content="操作员代码格式错误，请修改!";
                        $scope.proposal.prpTmain.operatorCode="";
                    }else if($scope.proposal.prpTmain.sumAmount&&!sumAmountRge.test($scope.proposal.prpTmain.sumAmount)){
                        //总保险金额
                        content="总保险金额格式错误，请修改!";
                        $scope.proposal.prpTmain.sumAmount="";
                    }else if($scope.proposal.prpTmain.sumPremium&&!sumAmountRge.test($scope.proposal.prpTmain.sumPremium)){
                        //总保险费
                        content="总保险费格式错误，请修改!";
                        $scope.proposal.prpTmain.sumPremium="";
                    }
                    if(content){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: content,
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else {
                        if($scope.proposal.prpTmain.proposalNo){
                            $scope.proposal.prpTmain.startDate = "";
                            $scope.proposal.prpTmain.startEndDate ="";
                            $scope.proposal.prpTmain.endStartDate ="";
                            $scope.proposal.prpTmain.endDate = "";
                            $scope.proposal.prpTmain.operateStartDate ="";
                            $scope.proposal.prpTmain.operateEndDate ="";
                        }
                        $scope.proposal.prpTmain.pageNo = 1;
                        $scope.proposal.prpTmain.pageSize = 20;
                        queryProposalListInfoByConditon();
                    }
                }
                else {
                    var content;
                    content = '至少输入一个查询条件!';
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
            $scope.queryResultsDate= function (startData,endData,type) {
                var content="";
                if(type=="起保日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="起保日期的起期不能大于止期！";
                        $scope.proposal.prpTmain.startDate=$scope.time.year+'-'+$scope.time.month+'-01'
                        $scope.proposal.prpTmain.startEndDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                    }
                }else if(type=="终保日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="终保日期的起期不能大于止期！";
                        $scope.proposal.prpTmain.endStartDate=$scope.time.year+1+'-'+$scope.time.month+'-01';
                        $scope.proposal.prpTmain.endDate=$scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date;
                    }
                }else if(type=="制单日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="制单日期的起期不能大于止期！";
                       $scope.proposal.prpTmain.operateStartDate=$scope.time.year+'-'+$scope.time.month+'-01';
                        $scope.proposal.prpTmain.operateEndDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                    }
                }
                if(content){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
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
                        $scope.check.proposalNo="保单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.proposalNo="";
                    }
                }else{
                    $scope.check.proposalNo="";
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
            $scope.checksumAmount= function ($event,str) {
                //总保险金额
                var sumAmountReg=/^[0-9]+$/;
                if(str&&!sumAmountReg.test(str)){
                    $scope.check.sumAmount="总保险金额格式从错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.sumAmount="";
                }
            }
            $scope.checksumPremium= function ($event,str) {
                //总保险费
                var sumPremiumReg=/^[0-9]+$/;
                if(str&&!sumPremiumReg.test(str)){
                    $scope.check.sumPremium="总保险费格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.sumPremium="";
                }
            }
            $scope.checkcomCode= function ($event,str) {
                //归属机构
                var comCodeReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!comCodeReg.test(str)){
                    $scope.check.comCode="归属机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.comCode="";
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
            $scope.changeproposalNo=function(PolicyNo){
                if(PolicyNo!=null&&PolicyNo!='')
                {
                    $scope.proposal.prpTmain.startDate = '';//起保开始时间
                    $scope.proposal.prpTmain.startEndDate = '';//起保开始时间
                    $scope.proposal.prpTmain.endStartDate ='';//终保时间
                    $scope.proposal.prpTmain.endDate = '';//终保时间间
                    $scope.proposal.prpTmain.operateStartDate ='';//制单开始日期
                    $scope.proposal.prpTmain.operateEndDate ='';//制单截止日期
                }else{
                    $scope.proposal.prpTmain.startDate=$scope.time.year+'-'+$scope.time.month+'-01';
                    $scope.proposal.prpTmain.startEndDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                    $scope.proposal.prpTmain.endStartDate=$scope.time.year+1+'-'+$scope.time.month+'-01';
                    $scope.proposal.prpTmain.endDate=$scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date;
                    $scope.proposal.prpTmain.operateStartDate=$scope.time.year+'-'+$scope.time.month+'-01';
                    $scope.proposal.prpTmain.operateEndDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
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
                    onChange: function () {//如果当前页有变动
                        if ($scope.paginationConfmm.totalItems == 0||$scope.paginationConfmm.totalItems ==undefined) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.proposal.prpTmain.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.proposal.prpTmain.pageSize = $scope.paginationConfmm.itemsPerPage;
                            queryProposalListInfoByConditon();
                        }
                    }
                }
            };
            initPage2();
            //核保详情查询
            $scope.policyInfo = false;
            $scope.getViewTrace = function (x,othFlag) {
                if(x&&othFlag){
                    $$finder.find('getViewTrace', {//getViewTrace这个是国元的
                        "proposalNo": x//proposalNo同上
                    }, {
                        success: function (data) {
                            //
                            if (data.content.length > 0) {
                                $scope.examineList = data.content;
                                $scope.policyInfo = true;
                                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            }else{
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '未查询到核保信息',
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }

            }
            //关闭详情
            $scope.closepolicyInfoShow = function () {
                $scope.policyInfo = false;
                $("html,body").css({overflow:"auto"});//显示滚动条
            }
            //提交核保//$scope.checked1
            $scope.repeatTrueList=[];
            $scope.submitUndwrtByProposal = function () {
                $scope.list=[];
                var templist=[]
                var layerflag=false;
                var selectflag=false;
                var repeatList=[];
                $scope.repeatTrueList=[];
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked){
                        selectflag=true;
                    }
                    if(dto.checked&&dto.underWriteFlag=='暂存'){
                        templist.push(dto.proposalNo)
                    }
                    if(dto.checked&&(dto.underWriteFlag!='普通新保'&&dto.underWriteFlag!='续保新保'&&dto.underWriteFlag!='核保退回')){
                        layerflag=true;
                        dto.checked=false;
                    }else if(dto.checked){
                        $scope.list.push(dto.proposalNo);
                        repeatList.push(dto);
                    }
                });
                if(selectflag==false){
                    layer.open({
                        //offset: ['38%', '35%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择投保单号!',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return false;
                }
                if(templist.length>0){
                    templist=[];
                    layer.open({
                        //offset: ['38%', '35%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '暂存投保单应先保存后，才能提交核保！',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return false;
                }
                if($scope.list.length<=0){
                    var cont;
                    cont = '您所选的投保单已提交核保，不可重复提交！';
                    layer.open({
                        //offset: ['38%', '35%'],
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
                }else if($scope.list.length>0&&layerflag){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '已剔除错误状态的单号,是否继续提交核保！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            var repeatTrueListStr='';
                            angular.forEach(repeatList, function (data) {
                                if(data.repeatFlag){
                                    $scope.repeatTrueList.push(data.proposalNo);
                                    repeatTrueListStr+=data.proposalNo+"&nbsp;&nbsp;&nbsp;";
                                }
                            })
                            if($scope.repeatTrueList.length>0){
                                //$scope.relativeInsureListCode=true;
                                $("#relativeInsureListCode").show();
                                $("#repeatTrueList").html(repeatTrueListStr);
                                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            }else{
                                $$finder.find('submitUndwrtByProposal', {
                                    "proposalno": $scope.list,//保单号
                                    "userCode": $rootScope.user.userCode,//用户编号//
                                    "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                                }, {
                                    success: function (data) {
                                        var content = "";
                                        if (data.code == "0000") {
                                            if (data.content.status != undefined && data.content.status == "9999") {
                                                content = "webService应用连接失败！"
                                            } else {
                                                angular.forEach(data.content, function (info) {
                                                    content += "<br>" + info + "</br>";
                                                });
                                            }
                                        } else {
                                            content =  data.message;
                                        }
                                        if (content) {
                                            layer.open({
                                                /*offset: ['45%', '40%'],*/
                                                skin: 'large-layer-content',
                                                scrollbar: false,
                                                closeBtn: 0,
                                                title: '温馨提示',
                                                content: content,
                                                btn: ['确定'],
                                                btn1: function (index, layero) {
                                                    layer.close(index);
                                                }
                                            })
                                        }
                                    }
                                });
                            }
                            layer.close(index);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else {
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '是否确认提交核保！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            var repeatTrueListStr='';
                            angular.forEach(repeatList, function (data) {
                                if(data.repeatFlag){
                                    $scope.repeatTrueList.push(data.proposalNo);
                                    repeatTrueListStr+=data.proposalNo+"&nbsp;&nbsp;&nbsp;";
                                }
                            })
                            if( $scope.repeatTrueList.length>0){
                                //$scope.relativeInsureListCode=true;
                                $("#relativeInsureListCode").show();
                                $("#repeatTrueList").html(repeatTrueListStr);
                                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                            }else{
                                $$finder.find('submitUndwrtByProposal', {
                                    "proposalno": $scope.list,//保单号
                                    "userCode": $rootScope.user.userCode,//用户编号//
                                    "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                                }, {
                                    success: function (data) {
                                        var content = "";
                                        if (data.code == "0000") {
                                            if (data.content.status != undefined && data.content.status == "9999") {
                                                content = "webService应用连接失败！"//data.message;
                                            } else {
                                                angular.forEach(data.content, function (info) {
                                                    content += "<br>" + info + "</br>";
                                                });
                                            }
                                        } else {
                                            content = data.message;
                                        }
                                        if (content) {
                                            layer.open({
                                                area: ['37%', '318px'],
                                                //offset: ['28%', '30%'],
                                                skin: 'large-layer-content',
                                                scrollbar: false,
                                                closeBtn: 0,
                                                title: '提交核保',
                                                content: content,
                                                btn: ['确定'],
                                                btn1: function (index, layero) {
                                                    queryProposalListInfoByConditon();
                                                    layer.close(index);
                                                }
                                            });
                                        }
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                            }
                            layer.close(index);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }
            $scope.goRelativeInsureListCode= function () {
                //$scope.relativeInsureListCode=false;
                $("#relativeInsureListCode").hide();
                $("html,body").css({overflow:"auto"});//出现滚动条
                $$finder.find('submitUndwrtByProposal', {
                    "proposalno": $scope.list,//保单号
                    "userCode": $rootScope.user.userCode,//用户编号//
                    "DLComCode": $rootScope.user.loginComCode//机构编号,暂时写死了//国元的DLComCode
                }, {
                    success: function (data) {
                        var content = "";
                        if (data.code == "0000") {
                            if (data.content.status != undefined && data.content.status == "9999") {
                                content =data.message;
                            } else {
                                angular.forEach(data.content, function (info) {
                                    content += "<br>" + info + "</br>";
                                });
                            }
                        } else {
                            content =data.message;
                        }
                        if (content) {
                            layer.open({
                                area: ['37%', '318px'],
                                //offset: ['28%', '30%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '提交核保',
                                content: content,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    queryProposalListInfoByConditon();
                                    layer.close(index);
                                }
                            });
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.closeRelativeInsureListCode= function () {
               $("#relativeInsureListCode").hide();
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.showDetailRelativeInsure=false;
            $scope.closeDetailRelativeInsureList= function () {
                $scope.showDetailRelativeInsure=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                //$state.go('UIPolicy3107show',{'policyNo':policyNo});
                var url=$state.href('UIPolicy3107show',{'policyNo':policyNo});
                window.open(url,"_blank");
            }
            $scope.lookDetailRelativeInsureList= function (flag,info,index) {
                $scope.index=index;
                var list=[info.proposalNo];
                if(flag==true){
                    $scope.showDetailRelativeInsure=true;
                    $scope.paginationConfmm4.currentPage=1;
                    $$finder.find('queryByPrpNoPrpCmainInfoList',{
                        proposalNos:list,
                        startDate:info.startDate,
                        endDate:info.endDate,
                        riskCode:info.riskCode,
                        businessType1:info.businessType1,
                        pageNo:$scope.paginationConfmm4.currentPage,
                        pageSize:$scope.paginationConfmm4.itemsPerPage

                    },{
                        success: function (data) {
                            console.log(data);
                            if(data.code=='0000'){
                                $scope.detailRelativeInsureList=data.content.content;
                                $scope.paginationConfmm4.totalItems=data.content.totalCount;
                            }
                        }
                    })
                }
            }
            var initPage3 = function() {
                $scope.paginationConfmm4= {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if($scope.paginationConfmm.totalItems==0){
                            return ;
                        }else {
                            $$finder.find('queryByPrpNoPrpCmainInfoList',{
                                proposalNos:[$scope.proposal.QueryList[$scope.index].proposalNo],
                                startDate:$scope.proposal.QueryList[$scope.index].startDate,
                                endDate:$scope.proposal.QueryList[$scope.index].endDate,
                                riskCode:$scope.proposal.QueryList[$scope.index].riskCode,
                                businessType1:$scope.proposal.QueryList[$scope.index].businessType1,
                                pageNo:$scope.paginationConfmm4.currentPage,
                                pageSize:$scope.paginationConfmm4.itemsPerPage

                            },{
                                success: function (data) {
                                    console.log(data);
                                    if(data.code=='0000'){
                                        $scope.detailRelativeInsureList=data.content.content;
                                        $scope.paginationConfmm4.totalItems=data.content.totalCount;
                                    }
                                }
                            })
                        }
                    }

                };
            };
            initPage3();
            //撤单
            $scope.revocation = function (x) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    scrollbar: false,
                    content: '是否确认撤单！',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        if (x.othFlag == '已撤单') {
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '该投保单已撤单！',
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        } else {
                            $$finder.find('withdrawProposalnoSubmit', x.proposalNo, {
                                success: function (data) {
                                    queryProposalListInfoByConditon();
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                            layer.close(index);
                        }
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                })
            }
            //获取投保单信息
            $scope.QueryList = function () {
            }
            //展开更多查询条件
            $scope.conditionShow = false;
            $scope.tabBtn = true;
            $scope.addFrom = function () {
                $scope.tabBtn = !$scope.tabBtn;
                $scope.conditionShow = !$scope.conditionShow;
            };
            //重置表单
            $scope.reset = function () {
                $scope.proposal.prpTmain = {};
                //$scope.proposal.prpTmain.startDate = $scope.time.year+'-'+$scope.time.month+'-01';
                //$scope.proposal.prpTmain.startEndDate =  $scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                //$scope.proposal.prpTmain.endStartDate =  $scope.time.year+1+'-'+$scope.time.month+'-01';
                //$scope.proposal.prpTmain.endDate =  $scope.time.year+1+'-'+$scope.time.month+'-'+$scope.time.date;
                //$scope.proposal.prpTmain.operateStartDate =  $scope.time.year+'-'+$scope.time.month+'-01';//制单开始日期
                //$scope.proposal.prpTmain.operateEndDate =  $scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;//制单截止日期
                //$scope.proposal.prpTmain.BusinessType1='01';
                $scope.proposal.prpTmain.underWriteFlag = $scope.proposal.prpTmain.underWriteFlag;
                $scope.proposal.prpTmain.BusinessType1 = $scope.proposal.prpTmain.BusinessType1;
                $scope.proposal.prpTmain.printFlag='0';
                //$scope.endorse.prpPhead.EndorType=$scope.endorse.prpPhead.EndorType;
                //$scope.endorse.prpPhead.EndorType='01';
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.QueryList ={}
            }
            //总保险金额的数字校验
            $scope.pressDecimal = function ($event) {
                if (($event.keyCode >= 48 && $event.keyCode <= 57) || $event.keyCode == 46) {
                    return true;
                } else {
                    $event.preventDefault();
                }
            }
          /*  //输入号码时清空时间搜索，否则添加默认时间
            $scope.proposalNoChange=function(proposalNo){
                if(proposalNo!=null&&proposalNo!='')
                {
                    $scope.proposal.prpTmain.startDate ='';
                    $scope.proposal.prpTmain.startEndDate =  '';
                    $scope.proposal.prpTmain.endStartDate = '';
                    $scope.proposal.prpTmain.endDate =  '';
                    $scope.proposal.prpTmain.operateStartDate =  '';//制单开始日期
                    $scope.proposal.prpTmain.operateEndDate = '';//制单截止日期

                }else {
                    $scope.reset();
                }

            }*/
            //全选
            $scope.checked1 = [];
            $scope.selectAll = function () {
                if ($scope.select_all) {
                    $scope.checked1 = [];
                    angular.forEach($scope.proposal.QueryList, function (info) {
                        info.checked = true;
                        $scope.checked1.push(info.proposalNo);
                    })
                } else {
                    angular.forEach($scope.proposal.QueryList, function (info) {
                        info.checked = false;
                        $scope.checked1 = [];
                    })
                }
            }
            //单选，反选
            $scope.selectOne = function () {
                angular.forEach($scope.proposal.QueryList, function (info) {
                    var index = $scope.checked1.indexOf(info.proposalNo);
                    if (info.checked && index === -1) {
                        $scope.checked1.push(info.proposalNo);
                    } else if (!info.checked && index !== -1) {
                        $scope.checked1.splice(index, 1);
                    }
                    ;
                });
                if ($scope.proposal.QueryList.length == $scope.checked1.length) {
                    $scope.select_all = true;
                } else {
                    $scope.select_all = false;
                }
            }
            //投保单查询页面的查看与修改
            $scope.revise = function (type) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposal3107edit', {type: type})
            }
            // 投保单打印
            $scope.printProposals = function(){

                var dto=angular.copy( $scope.proposal.QueryList);
                var list=[];
                var fals=false;
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked&&dto.underWriteFlag!='通过'){
                         fals=true;
                        dto.checked=false;
                    }else if(dto.checked) {
                        list.push(dto.proposalNo);
                    }
                });

                if(list.length<=0 ){
                    var cont;
                    cont = '未选择正确的打印单号';
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: cont,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if(list.length>0&&fals){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '存在不符合单号已剔除，是否继续打印！',
                        btn: ['确定', '取消'],
                        btn1: function (index1, layero) {
                            var index = list.length;
                            var print = '';
                            var end = '';
                            for (var i = 0; i < index; i++) {
                                if (i == 0) {
                                    print = 'proposalNo=' + list[i];
                                } else {
                                    print = '&proposalNo=' + list[i];
                                }
                                end = end + print;
                            }
                            $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/InsuranceFormPrint?' + end);
                            layer.close(index1);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $scope.select_all="";
                } else {
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '是否确认打印！',
                        btn: ['确定', '取消'],
                        btn1: function (index1, layero) {
                            var index = list.length;
                            var print = '';
                            var end = '';
                            for (var i = 0; i < index; i++) {
                                if (i == 0) {
                                    print = 'proposalNo=' + list[i];
                                } else {
                                    print = '&proposalNo=' + list[i];
                                }
                                end = end + print;
                            }
                            $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/InsuranceFormPrint?' + end);
                            layer.close(index1);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
                //api/agriprpall/proposalmanage/queryProposalListInfoByConditon
                //http://192.168.0.44:9010/print/InsuranceFormPrint?proposalNo=131013400002008000463
            };
            function queryProposalListInfoByConditon() {
                var dto = angular.copy($scope.proposal.prpTmain);
                $$finder.find('queryProposalListInfoByConditon', dto, {
                    success: function (data) {
                        if(data.code=="0000"&&data.content.content.length>0){
                            var list = data.content.content;
                            angular.forEach(list, function (data, index, array) {
                                var strOthFlag = data.othFlag;
                                var underWriteFlag = data.underWriteFlag;
                                console.log(data.othFlag);
                                if (strOthFlag.substring(3, 4) != '2') {
                                    if (data.underWriteFlag == '0' && strOthFlag.substring(0, 1) == "0") {
                                        data.underWriteFlag = "普通新保";
                                        data.othFlag = "";
                                        data.operate=1;
                                    }else if (data.underWriteFlag == '8' && strOthFlag.substring(0, 1) == "0") {
                                        data.underWriteFlag = "暂存";
                                        data.othFlag = "";
                                        data.operate=1;
                                    }
                                    else if (data.underWriteFlag == '0' && strOthFlag.substring(0, 1) == "1") {
                                        data.underWriteFlag = "续保新保";
                                        data.othFlag = "";
                                        data.operate=1;
                                    } else if (data.underWriteFlag == '1') {
                                        data.underWriteFlag = "通过";
                                        data.othFlag = "核保信息";
                                    } else if (data.underWriteFlag == '2' && strOthFlag.substring(3, 4) != "3") {
                                        data.underWriteFlag = "核保退回";
                                        data.othFlag = "核保信息";
                                        data.operate=1;
                                    } else if (data.underWriteFlag == '2' && strOthFlag.substring(3, 4) == "3") {
                                        data.underWriteFlag = "拒保";
                                        data.othFlag = "核保信息";
                                    } else if (data.underWriteFlag == '3') {
                                        data.underWriteFlag = "无需核保";
                                        data.othFlag = "";
                                        data.othFlag = "核保信息";
                                    } else if (data.underWriteFlag == '9') {
                                        data.underWriteFlag = "待核保";
                                        data.othFlag = "";
                                    }
                                }
                                else {
                                    data.underWriteFlag = "已撤单";
                                    data.othFlag = "核保信息";
                                }
                            })
                            //console.log(data);
                            $scope.proposal.QueryList = list;
                            $scope.totalItems = data.content.totalCount;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = $scope.totalItems;
                        }else if(data.code=="9999"){
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '系统异常、请联系管理员！',
                                scrollbar: false,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.proposal.QueryList.length=0;
                            $scope.paginationConfmm.totalItems=0;
                        }
                        $scope.select_all="";

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //上传影像
            $scope.upLoading = function (businessNo) {
                console.log("影像上传");
                $$finder.find("transportXML", {
                    "businessNo": businessNo,
                    "loginUserCode": $rootScope.user.userCode,
                    "loginUserName": $rootScope.user.userName,
                    "loginComCode": $rootScope.user.loginComCode,
                    "loginComName": $rootScope.loginComCName
                }, {
                    success: function (data) {
                        if (data.code == '0000') {
                            console.log("transportXML", data);
                            var responseXML = data.content.responseXML;
                            var factoryUrl = $rootScope.frontEnd.prpallSunECMUrl + "/SunECM/servlet/RouterServlet";
                            ECM_POST(factoryUrl, {
                                format: 'xml',
                                code: 'ECM0001',
                                xml: responseXML
                            }, 1000, $rootScope.frontEnd.prpallSunECMKeys); // 其他参数详见接口文档
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };

            //投保单详情与修改跳转页面
            $scope.getProposalInfo = function (index,addEditExamine) {
                var proposalNo=$scope.proposal.QueryList[index].proposalNo
                var riskCode=$scope.proposal.QueryList[index].riskCode
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposal3107edit', {proposalNo:proposalNo,addEditExamine:addEditExamine,'riskCode':riskCode })
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