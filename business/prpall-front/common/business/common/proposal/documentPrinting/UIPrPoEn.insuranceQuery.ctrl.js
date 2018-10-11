/**
 * Created by sen on 2017/11/17.
 */
define(['app','constants','layer','jsonDB',"config"], function (app,constants,layer,jsonDB,config) {
    'use strict';
    app.registerController('UIPrPoEnInsuranceQueryCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','$window','$$code',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,$window,$$code) {
            $scope.selectListData={};// 级联下拉列表数据
            $scope.proposal = {};//查询条件的对象
            $scope.check={};
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 5;
            $scope.proposal.prpTmain.printFlag='0';
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
            $scope.totalItems=0;
            var cont="";
            $scope.submit=function(){
                if(!$scope.proposal.prpTmain.operateStartDate&&$scope.proposal.prpTmain.operateEndDate){
                    cont = '请录入制单起期！';
                    $scope.tishi();
                    return
                }
                $scope.proposal.prpTmain.pageNo = 1;
                $scope.proposal.prpTmain.pageSize = 20;

                if(($scope.proposal.prpTmain.proposalNo!=undefined &&$scope.proposal.prpTmain.proposalNo!="")
                    ||($scope.proposal.prpTmain.appliName!=undefined&&$scope.proposal.prpTmain.appliName!="")
                    ||($scope.proposal.prpTmain.appliCode!=undefined&&$scope.proposal.prpTmain.appliCode!="")
                    ||($scope.proposal.prpTmain.insuredName!=undefined&&$scope.proposal.prpTmain.insuredName!="")
                    ||($scope.proposal.prpTmain.insuredCode!=undefined&&$scope.proposal.prpTmain.insuredCode!="")
                    ||($scope.proposal.prpTmain.comCode!=undefined&&$scope.proposal.prpTmain.comCode!="")
                    ||($scope.proposal.prpTmain.handler1Code!=undefined&&$scope.proposal.prpTmain.handler1Code!="")
                    ||($scope.proposal.prpTmain.operatorCode!=undefined&&$scope.proposal.prpTmain.operatorCode!="")
                    ||($scope.proposal.prpTmain.printFlag!=undefined&&$scope.proposal.prpTmain.printFlag!="")
                    ||($scope.proposal.prpTmain.operateStartDate!=undefined&&$scope.proposal.prpTmain.operateStartDate!="")
                    ||($scope.proposal.prpTmain.operateEndDate!=undefined&&$scope.proposal.prpTmain.operateEndDate!="")
                ) {
                    var content="";
                    var proposalNoReg =/^\d{15,}$/;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉字
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                    var txtReg=/^[\u4E00-\u9FA5]+$/;//汉字
                    var comCodeReg=/(^[\u4E00-\u9FA5]+$)|(^[0-9]+$)/;
                    //;
                    if($scope.proposal.prpTmain.proposalNo&&!proposalNoReg.test($scope.proposal.prpTmain.proposalNo)){
                        //投保单号码
                        var reg=/^\d+$/g;
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
                    }else if($scope.proposal.prpTmain.insuredName&&!appliNameReg.test($scope.proposal.prpTmain.insuredName)){
                        //被保险人名称
                        content="被保险人名称格式错误，请修改!";
                        $scope.proposal.prpTmain.insuredName="";
                    }else if($scope.proposal.prpTmain.insuredCode&&!appliCodeReg.test($scope.proposal.prpTmain.insuredCode)){
                        //被保险人代码
                        content="被保险人代码格式错误，请修改!";
                        $scope.proposal.prpTmain.insuredCode="";
                    }else if($scope.proposal.prpTmain.handler1Code&&!appliCodeReg.test($scope.proposal.prpTmain.handler1Code)){
                        //业务员代码
                        content="业务员代码格式错误，请修改!";
                        $scope.proposal.prpTmain.handler1Code="";
                    }else if($scope.proposal.prpTmain.operatorCode&&!appliCodeReg.test($scope.proposal.prpTmain.operatorCode)){
                        //操作员代码
                        content="操作员代码格式错误，请修改!";
                        $scope.proposal.prpTmain.operatorCode="";
                    }
                    if(content){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else{
                        if($scope.proposal.prpTmain.proposalNo){
                            $scope.proposal.prpTmain.operateStartDate ="";
                            $scope.proposal.prpTmain.operateEndDate ="";
                        }
                        var dto = angular.copy($scope.proposal.prpTmain);
                        //;
                        $$finder.find('queryProposalListInfoByConditon',dto, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content.content.length>0){
                                    console.log(data);
                                    $scope.proposal.QueryList = data.content.content;

                                    $scope.totalItems=data.content.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems =  $scope.totalItems;
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
                                    $scope.paginationConfmm.totalItems=0;
                                }
                                $scope.select_all="";
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }


                }/*else  if(new Date($scope.proposal.prpTmain.operateStartDate.replace(/-/g,"\/")) >new Date($scope.proposal.prpTmain.operateEndDate.replace(/-/g,"\/"))){
                 layer.open({
                 offset: ['45%', '40%'],
                 skin: 'large-layer-content',
                 closeBtn: 0,
                 title: '温馨提示',
                 content: "起期不能大于止期!",
                 btn: ['确定'],
                 btn1: function(index, layero){
                 //按钮【按钮一】的回调
                 layer.close(index);
                 }
                 });
                 }*/else {
                    cont = '至少输入一个查询条件！';
                    $scope.tishi();
                }
            }
            $scope.changeproposalNo= function (str) {
                if(str){
                    $scope.proposal.prpTmain.operateStartDate="";
                    $scope.proposal.prpTmain.operateEndDate="";
                }else{
                    $scope.proposal.prpTmain={
                        operateStartDate:$scope.time.year+'-'+$scope.time.month+'-01',
                        operateEndDate:$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date
                    };
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
            //时间盘判断
            $scope.change=function(){
                if($scope.proposal.prpTmain.operateStartDate==''){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "请录入制单起期!",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
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
                    onChange:function(){//如果当前页有变动
                        if($scope.paginationConfmm.totalItems==0){//如果没有进行查询，不执行
                            return;
                        }else {
                            $scope.proposal.prpTmain.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.proposal.prpTmain.pageSize = $scope.paginationConfmm.itemsPerPage;
                            var dto = angular.copy($scope.proposal.prpTmain);
                            $$finder.find('queryProposalListInfoByConditon', dto, {
                                success: function (data) {
                                    $scope.proposal.QueryList = data.content.content;
                                    $scope.totalItems = data.content.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems = $scope.totalItems;
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
            //撤单
            $scope.revocation = function(x){
                $$finder.find('withdrawProposalnoSubmit', x, {
                    success: function (data) {
                        console.log(data)
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //全选
            $scope.checked = [];
            $scope.selectAll = function() {
                if($scope.select_all) {
                    $scope.checked = [];
                    angular.forEach($scope.guarantee, function(x) {
                        x.checked = true;
                        $scope.checked.push(x.policyNo);
                    })
                } else {
                    angular.forEach($scope.guarantee, function(x) {
                        x.checked = false;
                        $scope.checked = [];
                    })
                }
            };
            //单选proposal.QueryList
            // $scope.selectOne = function() {
            //     angular.forEach($scope.guarantee, function(x) {
            //         var index = $scope.checked.indexOf(x.proposalNo);
            //         if(x.checked && index === -1) { //如果被选中，且不再选中的集合中
            //             $scope.checked.push(x.proposalNo); //把东西存进选中的集合中
            //         } else if(!x.checked && index !== -1) { //如果存在就进行删除
            //             $scope.checked.splice(index, 1);
            //         };
            //     });
            //     if($scope.guarantee.length === $scope.checked.length) {
            //         $scope.select_all = true;
            //     } else {
            //         $scope.select_all = false;
            //     }
            //
            // }
            //单选
            $scope.selectOne = function() {
                angular.forEach($scope.proposal.QueryList, function(x) {
                    var index = $scope.checked.indexOf(x.proposalNo);
                    if(x.checked && index === -1) { //如果被选中，且不再选中的集合中
                        $scope.checked.push(x.proposalNo); //把东西存进选中的集合中
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
            //获取时间
            var date = new Date()
            $scope.getdate = {
                year: date.getFullYear(),
                month: date.getMonth(),
                day: date.getDate()
            }
            var _month = $scope.getdate.month;
            if (_month >= 10) {
                $scope.getdate.month = (_month + 1);
            } else {
                $scope.getdate.month = '0' + (_month + 1);
            }
            var _day = $scope.getdate.day;
            console.log(_day)
            if (_day >= 10) {
                $scope.getdate.day = (_day);
            } else {
                $scope.getdate.day = '0' + (_day);
            }
            //$scope.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
            //$scope.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
            //$scope.proposal.prpTmain.operateStartDate= $scope.beginTime;
            //$scope.proposal.prpTmain.operateEndDate=$scope.endTime;
            //获取投保单信息
            $scope.QueryList=function(){}
            //展开更多查询条件
            $scope.conditionShow=false;
            $scope.tabBtn = true;
            $scope.addFrom=function(){
                $scope.proposal.prpTmain.operateStartDate= $scope.beginTime;
                $scope.proposal.prpTmain.operateEndDate=$scope.endTime;
                $scope.tabBtn = !$scope.tabBtn;
                $scope.conditionShow=!$scope.conditionShow;

            };
            //投保单详情与修改跳转页面
            $scope.getProposalInfoPrint = function (index,addEditExamine) {
                var proposalNo=$scope.proposal.QueryList[index].proposalNo
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposal3107edit', {proposalNo:proposalNo,addEditExamine:addEditExamine})
            };
            //重置表单
            $scope.reset=function(){
                $scope.proposal.prpTmain={
                    //operateStartDate:$scope.time.year+'-'+$scope.time.month+'-01',
                    //operateEndDate:$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date,
                   printFlag:"0"
                };
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.QueryList ={}
                //$scope.$apply();
                //$scope.proposal.prpTmain.underWriteFlag=$scope.cpproposal.prpTmain.underWriteFlag;
                //$scope.proposal.prpTmain.BusinessType1=$scope.cpproposal.prpTmain.BusinessType1

            }
            //总保险金额的数字校验
            $scope.pressDecimal=function($event){
                if(($event.keyCode>=48 && $event.keyCode<=57) || $event.keyCode==46){
                    return true;
                }else{
                    $event.preventDefault();
                }
            }
            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.proposal.QueryList,function(info){
                        info.checked=true;
                        $scope.checked1.push (info.id);
                    })
                } else {
                    angular.forEach($scope.proposal.QueryList,function(info){
                        info.checked=false;
                        $scope.checked1 = [];
                    })
                }
            }
            //单选，反选
            $scope.selectOne=function(){
                angular.forEach($scope.proposal.QueryList , function (info) {
                    var index = $scope.checked1.indexOf(info.id);
                    if(info.checked && index === -1) {
                        $scope.checked1.push(info.id);
                    } else if (!info.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.proposal.QueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }
            //投保单查询页面的查看与修改
            $scope.revise=function(type){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposal3107edit',{type:type})
            }
            //隐藏险种方案
            //$scope.showRiskScheme=false;
            //$scope.riskNameHide=false;

            $scope.goScheduleAdd = function () {

            }
            // 投保单打印
            $scope.printProposals = function(){

                var proposalNo = $scope.checked[0];
                var dto=angular.copy( $scope.proposal.QueryList);
                var list=[];
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked){
                        list.push(dto.proposalNo);
                    }
                });
                if(list.length<=0){
                    var cont;
                    cont = '请选中投保单';
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: cont,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
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
            // $scope.printProposals = function(proposal){
            //     //var watchContract= proposal.proposalNoBI||proposal.proposalNoCI;
            //     console.log(888);
            //     console.log(proposal.proposalNo);
            //     var watchContract= proposal.proposalNo;
            //     //var watchContract= "131013400002008000463";
            //     // if(clientFlagCode=='ZY'){
            //     //     $window.open('/api/pa/proposal/proposalPrint?bizNo='+ watchContract);
            //     // }else{
            //     //     if(proposal.riskCode=='DDA'){
            //     //         $window.open(config.backend.DDAProposalPrint+'?bizNo='+ watchContract);
            //     //     }else{
            //     //         $window.open(config.backend.DDBProposalPrint+'?bizNo='+ watchContract);
            //     //     }
            //     // }
            //     $window.open('/print/InsuranceFormPrint?proposalNo='+ watchContract);
            //     //http://192.168.0.44:9010/print/InsuranceFormPrint?proposalNo=131013400002008000463
            // };

            $scope.tishi=function(){
                layer.open({
                    scrollbar: false,
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
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
                    $scope.proposal.prpTmain.operateEndDate="";
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
                    $scope.proposal.prpTmain.operateStartDate = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.proposal.prpTmain.operateEndDate = $filter("date")(new Date(),"yyyy-MM-dd");
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

            /*  //代码校验
             $scope.isNum=function(code) {
             var reg = /^[0-9]*$/;//验证是否为数字
             if (code != null && code != '') {
             if (!reg.test(code)) {
             layer.open({
             offset: ['35%', '40%'],
             skin: 'large-layer-content',
             closeBtn: 0,
             title: '温馨提示',
             content: cont,
             btn: ['确定'],
             btn1: function (index, layero) {
             //按钮【按钮一】的回调
             layer.close(index);
             },
             });
             return false
             }
             }
             return true

             }

             //名称校验
             $scope.isChinese=function(code){
             var reg=/^[\u2E80-\u9FFF]+$/
             if(code != null && code != ''){
             if(!reg.test(code)){
             layer.open({
             offset: ['35%', '40%'],
             skin: 'large-layer-content',
             closeBtn: 0,
             title: '温馨提示',
             content: cont,
             btn: ['确定'],
             btn1: function (index, layero) {
             //按钮【按钮一】的回调
             layer.close(index);
             },
             })
             return false
             }
             }
             return true
             }*/

        }]);
});

















































// define(['app', 'constants', 'layer', 'jsonDB'], function(app, constants, layer, jsonDB) {
//     'use strict';
//     app.registerController('UIPrPoEnInsuranceQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter',
//         function($rootScope, $scope, $$finder, $http, $filter) {
//             //提交查询信息
//             $scope.totalItems = 0;
//             //获取后台数据
//             $scope.guarantee = {}; //声明保单的对象
//             $scope.guaranteeSend = {};//入参
//             $scope.submit=function(){
//                 //查询保单列表信息
//                 $$finder.find('guarantee', {}, {
//                     success: function(data) {
//                         $scope.guarantee = data.data.resultObj.content;
//                         $scope.totalItems = $scope.guarantee.length;
//                         $scope.paginationConfmm.totalItems = $scope.totalItems;
//                     },
//                     error: function(e) {
//                         options.error(e);
//                     }
//                 });
//             }
//             //总保险金额校验
//             //    总保险金额的数字校验
//             $scope.preminm=function($event){
//                 if(($event.keyCode>=48 && $event.keyCode<=57) || $event.keyCode==46){
//                     return true;
//                 }else{
//                     $event.preventDefault();
//                 }
//             }
//             //全选
//             $scope.checked = [];
//             $scope.selectAll = function() {
//                 if($scope.select_all) {
//                     $scope.checked = [];
//                     angular.forEach($scope.guarantee, function(x) {
//                         x.checked = true;
//                         $scope.checked.push(x.policyNo);
//                     })
//                 } else {
//                     angular.forEach($scope.guarantee, function(x) {
//                         x.checked = false;
//                         $scope.checked = [];
//                     })
//                 }
//             };
//             //单选
//             $scope.selectOne = function() {
//                 angular.forEach($scope.guarantee, function(x) {
//                     var index = $scope.checked.indexOf(x.policyNo);
//                     if(x.checked && index === -1) { //如果被选中，且不再选中的集合中
//                         $scope.checked.push(x.policyNo); //把东西存进选中的集合中
//                     } else if(!x.checked && index !== -1) { //如果存在就进行删除
//                         $scope.checked.splice(index, 1);
//                     };
//                 });
//                 if($scope.guarantee.length === $scope.checked.length) {
//                     $scope.select_all = true;
//                 } else {
//                     $scope.select_all = false;
//                 }
//                 console.log($scope.checked);
//             }
//
//             //展开更多查询条件
//             $scope.SRC = "common/images/chenpeng/展开.png"
//             $scope.conditionShow = false;
//             $scope.addFrom = function() {
//                 $scope.conditionShow = !$scope.conditionShow
//                 $scope.SRC = !$scope.conditionShow ? "common/images/chenpeng/展开.png" : "common/images/chenpeng/收起.png"
//             };
//
//             //重置表单
//             $scope.reset = function() {
//                 $scope.guarantee = {};
//                 $scope.guaranteeSend = {};
//             }
//             //分页设置
//             var initPage2 = function() {
//                 $scope.paginationConfmm = {
//                     currentPage: 1,
//                     totalItems: 0,
//                     itemsPerPage: 5,
//                     pagesLength: 5,
//                     perPageOptions: [5, 10, 15, 20]
//                 };
//             };
//             initPage2();
//             $scope.paginationConfmm.totalItems = $scope.totalItems;
//
//             //打印设置弹出
//             $scope.configPrintSetShow = false;
//             $scope.configPrintSet = function() {
//                 $scope.configPrintSetShow = !$scope.configPrintSetShow;
//             };
//
//             //打印设置确定关闭设置页面1
//             $scope.printSure = function() {
//                 //保存设置
//                 //待完善
//                 //打印设置页面关闭
//                 $scope.configPrintSetShow = !$scope.configPrintSetShow;
//             }
//
//             //打印类型选择
//             $scope.printtype = 'original';
//             $scope.choosePrintype = function (type) {
//                 $scope.printtype = type;
//             };
//
//             //打印信息选择
//             $scope.isActive = function(type) {
//                 var printtype = $scope.printtype == type ? true : false;
//                 return printtype
//             }
//
//         }
//     ]);
// });