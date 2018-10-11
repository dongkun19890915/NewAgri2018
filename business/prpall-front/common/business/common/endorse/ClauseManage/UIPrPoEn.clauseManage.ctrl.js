/**
 * Created by sen on 2017/11/17.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnClauseManageCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','regexpConstants','commonApiServ','$$code',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,regexpConstants,commonApiServ,$$code) {
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.code=regexpConstants.code;//代码
            $scope.regData.Chinese=regexpConstants.Chinese;//汉字
            $scope.regData.number=regexpConstants.number;//数字
            $scope.info={};
            $scope.info.itemCode='';
            $scope.proposalClauseRegex = regexpConstants.utilNoticeModelRegex;

            $scope.proposal = {};
            $scope.check={};
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 5;
            $scope.proposal.PrpDclauseCodeDto={};
            $scope.proposal.PrpDclauseCodeComDto={};
            $scope.proposal.PrpDkindDto={};
            var content;
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
            //提交查询信息
            $scope.isable=true;
            $scope.submit=function(){
                if(!$scope.proposal.PrpDclauseCodeDto.createDateStart&&$scope.proposal.PrpDclauseCodeDto.createDateEnd){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content:  '请录入条款创建起期！',
                        scrollbar: false,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                var dto = angular.copy($scope.proposal.PrpDclauseCodeDto);
                var dto1 = angular.copy($scope.proposal.PrpDclauseCodeComDto);
                var dto2 = angular.copy($scope.proposal.PrpDkindDto);
                if(
                    ($scope.proposal.PrpDclauseCodeDto.clauseCode!=""&&$scope.proposal.PrpDclauseCodeDto.clauseCode!=null)
                    ||($scope.proposal.PrpDclauseCodeDto.clauseName!=undefined&&$scope.proposal.PrpDclauseCodeDto.clauseName!="")
                    ||($scope.proposal.PrpDclauseCodeDto.provence!=undefined&&$scope.proposal.PrpDclauseCodeDto.provence!="")
                    ||($scope.proposal.PrpDclauseCodeDto.riskCode!=undefined&&$scope.proposal.PrpDclauseCodeDto.riskCode!="")
                    ||($scope.proposal.PrpDclauseCodeDto.itemCode!=undefined&&$scope.proposal.PrpDclauseCodeDto.itemCode!="")
                    ||($scope.proposal.PrpDclauseCodeComDto.comCode!=undefined&&$scope.proposal.PrpDclauseCodeComDto.comCode!="")
                    ||($scope.proposal.PrpDclauseCodeDto.BusinessType1!=undefined&&$scope.proposal.PrpDclauseCodeDto.BusinessType1!="")
                    ||(($scope.proposal.PrpDclauseCodeDto.createDateStart!=undefined&&$scope.proposal.PrpDclauseCodeDto.createDateStart!="")
                    ||($scope.proposal.PrpDclauseCodeDto.createDateEnd!=undefined&&$scope.proposal.PrpDclauseCodeDto.createDateEnd!=""))
                    ||($scope.proposal.PrpDkindDto.createdby!=undefined&&$scope.proposal.PrpDkindDto.createdby!="")
                )
                {
                    var content="";
                    var clauseCodeReg=/^TK([0-9]{12}|[0-9]{4})$/;//条款代码验证
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉字
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                    var provenceReg=/^[\u4E00-\u9FA5]+$/;//汉字
                    if($scope.proposal.PrpDclauseCodeDto.clauseCode){
                        //模板号码
                        var rr=/^TK[0-9]+$/;
                        if(!rr.test($scope.proposal.PrpDclauseCodeDto.clauseCode)){
                            content = '条款代码格式错误，请修改';
                            $scope.proposal.PrpDclauseCodeDto.clauseCode="";
                        }else
                        if($scope.proposal.PrpDclauseCodeDto.clauseCode.length<6){
                            content="条款代码需至少输入6位数！";
                        }

                    }
                  /*  else if($scope.proposal.PrpDclauseCodeDto.clauseName&&!appliNameReg.test($scope.proposal.PrpDclauseCodeDto.clauseName)){
                        //条款名称
                        content="条款名称格式错误，请修改!";
                        $scope.proposal.PrpDclauseCodeDto.clauseName="";
                    }*//*else if($scope.proposal.PrpDclauseCodeComDto.comCode&&!appliNameReg.test($scope.proposal.PrpDclauseCodeComDto.comCode)){
                        //适用机构
                        content="适用机构格式错误，请修改!";
                        $scope.proposal.PrpDclauseCodeComDto.comCode="";
                    }*/else if($scope.proposal.PrpDkindDto.createdby&&!appliNameReg.test($scope.proposal.PrpDkindDto.createdby)){
                        //创建人名称
                        content="创建人名称格式错误，请修改!";
                        $scope.proposal.PrpDkindDto.createdby="";
                    }else if($scope.proposal.PrpDclauseCodeDto.provence&&!provenceReg.test($scope.proposal.PrpDclauseCodeDto.provence)){
                        //适用省份
                        content="适用省份格式错误，请修改!";
                        $scope.proposal.PrpDclauseCodeDto.provence="";
                    }else if($scope.proposal.PrpDclauseCodeDto.itemCode&&!provenceReg.test($scope.proposal.PrpDclauseCodeDto.itemCode)){
                        //标的
                        content="标的格式错误，请修改!";
                        $scope.proposal.PrpDclauseCodeDto.itemCode="";
                    }
                    if(content){
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
                    }else{
                        $scope.data=angular.copy({
                            "userCode":$rootScope.user.userCode,//用户代码
                            "loginComCode":$rootScope.user.loginComCode,//用户登录机构代码
                            "loginGradeCodes":"111",//用户登录岗位代码
                            "tableName":"PrpDclauseCodeCom",//表名
                            "clauseCode": dto.clauseCode,//条款号
                            "clauseName": dto.clauseName,//条款名
                            "riskCode": dto.riskCode,//险种
                            "businessType": dto.BusinessType1,//政策性
                            "validStatus": dto.validStatus1,//proposal.prpTmain.businessType1 有效无效
                            "provence": dto.provence, //适应省份
                            "comCode": dto1.comCode, //适应机构
                            "itemName": dto.itemCode, //标的
                            "createDateStart":dto.createDateStart,//开始日期
                            "createDateEnd": dto.createDateEnd,//结束日期
                            "operatorName": dto2.createdby, //创建人名称
                            "pageNo": $scope.paginationConfmm.currentPage,
                            "pageSize": $scope.paginationConfmm.itemsPerPage
                        })
                        $$finder.find('clausemanage',$scope.data, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content.content.length>0){
                                    $scope.proposal.prpTmain = data.content;
                                    $scope.proposal.prpTmain.clauseQueryList = data.content.content;
                                    $scope.totalItems = $scope.proposal.prpTmain.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems = $scope.totalItems;
                                    console.log(data)
                                    angular.forEach($scope.proposal.prpTmain.clauseQueryList,function(info){
                                        console.log(new Date())
                                        if( info.endDate.replace(/-/g,"\/") <= new Date()){
                                            info.isable=false;
                                        }else{
                                            info.isable=true;
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
                                    $scope.proposal.prpTmain.clauseQueryList=[];
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
                    var   cont = '至少输入一个查询条件！';
                    $scope.dd(cont);
                    return ;
                }

            }
            $scope.changeclauseCode= function (str) {
                if(str){
                    $scope.proposal.PrpDclauseCodeDto.createDateStart='';
                    $scope.proposal.PrpDclauseCodeDto.createDateEnd='';
                    $scope.proposal.PrpDclauseCodeDto.BusinessType1="";
                }else{
                    $scope.proposal.PrpDclauseCodeDto.createDateStart=''+$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+'01';
                    $scope.proposal.PrpDclauseCodeDto.createDateEnd=''+$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+$scope.number($scope.getdate.day)
                    $scope.proposal.PrpDclauseCodeDto.BusinessType1="01";
                }
            }
            //查询校验  blur事件校验
            $scope.checkclauseCode= function ($event,str) {
                var clauseCodeReg=/^TK[0-9]+$/;
                if(str&&!clauseCodeReg.test(str)){
                    $scope.check.clauseCode="条款代码格式错误，请修改！";
                    $event.target.focus();
                }else if(str.length<6&&str){
                    $scope.check.clauseCode="条款代码需至少输入6位数！";
                }else {
                    $scope.check.clauseCode="";
                }

            }
            /* $scope.checkclauseName= function ($event,str) {
             //条款名称
             var clauseNameReg=/^[\u4E00-\u9FA50-9]+$/;
             if(str&&!clauseNameReg.test(str)){
             $scope.check.clauseName="条款名称格式错误，请修改！";
             $event.target.focus();
             }else{
             $scope.check.clauseName=""
             }
             }*/
            $scope.checkclauseName1= function ($event,str) {
                //条款名称
                var clauseNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!clauseNameReg.test(str)){
                    $scope.check.clauseName1="条款名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.clauseName1=""
                }
            }
            $scope.checkcomCode= function ($event,str) {
                //适用机构
                var comCodeReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!comCodeReg.test(str)){
                    $scope.check.comCode="适用机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.comCode="";
                }
            }
            $scope.checkcreatedby= function ($event,str) {
                //创建人名称
                var createdbyReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!createdbyReg.test(str)){
                    $scope.check.createdby="创建人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.createdby="";
                }
            }
            $scope.checkprovence= function ($event,str) {
                //适用省份
                var provenceReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!provenceReg.test(str)){
                    $scope.check.provence="适用省份格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.provence="";
                }
            }
            $scope.checkriskCode= function ($event,str) {
                //险种
                var riskCodeReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!riskCodeReg.test(str)){
                    $scope.check.riskCode="险种格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.riskCode="";
                }
            }
            $scope.checkitemCode= function ($event,str) {
                //标的
                var itemCodeReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!itemCodeReg.test(str)){
                    $scope.check.itemCode="标的格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.itemCode="";
                }
            }
            //日期校验
            $scope.compareDate1 = function(startDate,endDate) {
                var content;
                if (endDate&&!startDate){
                    content = '请录入条款创建起期';
                    $scope.proposal.PrpDclauseCodeDto.createDateEnd="";
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
                    content = '条款创建止期要大于条款创建起期';
                    $scope.proposal.PrpDclauseCodeDto.createDateStart = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.proposal.PrpDclauseCodeDto.createDateEnd = $filter("date")(new Date(),"yyyy-MM-dd");
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
            //条款创建有效期校验
            $scope.compareStartDate= function (startDate,endDate) {
                if(commonApiServ.compareFullDate(startDate,endDate)==1){
                    layer.open({
                        //offset: ['40%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "起期不能大于止期！",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $scope.proposal.PrpDclauseCode.startDate="";
                    $scope.proposal.PrpDclauseCode.endDate="";
                }
            }
            //条款弹框险种数字校验
            $scope.checkYearCode1= function ($event,str) {
                //险种
                var yearReg1=/^[0-9]+$/;
                if(str!=''&&!yearReg1.test(str)){
                    $scope.check.createYear="年份格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.createYear="";
                }
            };
            //条款弹框年份数字校验
            $scope.checkriskCode1= function ($event,str) {
                //险种
                var riskCodeReg1=/^[0-9]+$/;
                if(str!=''&&!riskCodeReg1.test(str)){
                    $scope.check.riskCode="险种格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.riskCode="";
                }
            };
            //获取投保单信息
            $scope.clauseQueryList=function(){}
            //展开更多查询条件
            $scope.SRC="common/images/chenpeng/展开.png";
            $scope.clauseManageShow=false;
            $scope.addFrom=function(){
                $scope.clauseManageShow=!$scope.clauseManageShow;
                $scope.SRC=!$scope.clauseManageShow?"common/images/chenpeng/展开.png":"common/images/chenpeng/收起.png";
            };
            //重置表单
            $scope.reset=function(){
                /* $scope.proposal.PrpDclauseCodeDto="";*/
                $scope.proposal.PrpDclauseCodeDto.itemCode="";
                $scope.proposal.PrpDclauseCodeDto.clauseCode="";
                $scope.proposal.PrpDclauseCodeDto.clauseName="";
                $scope.proposal.PrpDclauseCodeDto.riskCode="";
                $scope.proposal.PrpDclauseCodeComDto.comCode="";
                $scope.proposal.PrpDkindDto.createdby="";
                $scope.proposal.PrpDclauseCodeDto.validStatus1="1";
                $scope.proposal.PrpDclauseCodeDto.BusinessType1='01';
                //$scope.proposal.PrpDclauseCodeDto.createDateStart=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+'01';
                //$scope.proposal.PrpDclauseCodeDto.createDateEnd=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+$scope.number($scope.getdate.day)
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.prpTmain.clauseQueryList ={}
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5,10, 20, 50],
                    onChange: function () {
                        if($scope.paginationConfmm.totalItems==0||!$scope.paginationConfmm.totalItems){
                            return ;
                        }else{
                            $scope.submit()
                        }
                    }
                };
            };
            initPage2();
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
            //全选
            $scope.checked1 = [];
            $scope.cleanData = [];
            var nums;
            $scope.selectAll=function(info){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.proposal.prpTmain.clauseQueryList,function(info){
                        if(info.validStatus1=='0'||info.validStatus=='0'||!info.validStatus1){
                            info.checked=true;
                            $scope.checked1.push (info.clauseCode);
                        }
                        nums=0;
                    })
                } else {
                    angular.forEach($scope.proposal.prpTmain.clauseQueryList,function(info){
                        info.checked=false;
                        $scope.checked1 = [];
                    })
                    nums=1;
                }
                if(nums==0&&$scope.checked1.length==0)
                {
                    $scope.posalDel('4');
                    $scope.select_all = "";
                }
   return
            }
            $scope.selectOne=function(clause){
                angular.forEach($scope.proposal.prpTmain.clauseQueryList,function (x)
                {
                    var index = $scope.checked1.indexOf(clause.clauseCode);
                    if(clause.checked&&index==-1&&(clause.validStatus=='0'||clause.validStatus1=='0'))
                    {
                        $scope.checked1.push(clause.clauseCode);
                    }else  if(clause.checked&&index==-1&&(clause.validStatus=='0'||clause.validStatus1=='0'))
                    {
                        clause.checked=false;
                        $scope.posalDel('3');
                    }else if(!clause.checked&&index!=-1)
                    {
                        $scope.checked1.splice(index,1);
                    }
                });

                if($scope.proposal.prpTmain.clauseQueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }

            }
            var fff=true;
            //条款详情弹出
            $scope.clauseDetailsShow = false;
            $scope.configPrintSet = function(type) {
                if(type=='look'){//当时查看条款详情时
                    $rootScope.comTreeCtrlFlag=true;
                }else{
                    $rootScope.comTreeCtrlFlag=false;
                }
                $rootScope.cancelChecked();
                console.log($scope.itemCodeList)
                console.log($scope.kindCodeList)
            /*    $scope.proposal.PrpDclauseCodeDto.clauseCode="";//查询页面查询条件置空
                $scope.proposal.PrpDclauseCodeDto.clauseName="";
                $scope.proposal.PrpDclauseCodeComDto.comCode="";
                $scope.proposal.PrpDkindDto.createdby="";
                $scope.proposal.PrpDclauseCodeDto.provence="";
                $scope.proposal.PrpDclauseCodeDto.riskCode="";
                $scope.proposal.PrpDclauseCodeDto.itemCode="";*/
                $scope.clauseDetailsShow = !$scope.clauseDetailsShow;
                if( $scope.clauseDetailsShow){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else{
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }
                $rootScope.comlist=[];
                $rootScope.treecheck=[];
                fff=false;
                $scope.reset1();
            };
            $scope.configPrintSet1 = function() {
                $scope.clauseDetailsShow = !$scope.clauseDetailsShow;
                if( $scope.clauseDetailsShow){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else{
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }
                $rootScope.comlist=[];
                $scope.respDto="";
            };
            //条款详情--险别配置
            $scope.clauseDetailsConfirmShow = false;//新建--条款详情--险别设置--险别内容下点击“添加”按钮，出险的输入框与确定按钮
            //点击“添加”按钮，输入框展示
            $scope.kindContext="";
            $scope.addcontent = function () {
                $scope.clauseDetailsConfirmShow = true;
                $scope.proposal.prpTmain.clausemanageQueryList[indexKind].kindContext=$scope.kindContext;
                $scope.kindContext="";
                //查询险别内容
                if(!$scope.proposal.PrpDclauseCode||!$scope.proposal.PrpDclauseCode.riskCode||$scope.proposal.PrpDclauseCode.riskCode==''){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择险种',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }else {
                    //var riskCode = angular.copy($scope.proposal.PrpDclauseCode.riskCode);
                    //$scope.kindContext='';
                    //$$finder.find('queryByKindContext', {
                    //    "riskCode": riskCode, //险种
                    //}, {
                    //    success: function (data) {
                    //        console.log(data)
                    //        angular.forEach(data.content,function(data){
                    //            $scope.kindContext=$scope.kindContext+"\n"+data.context
                    //        })
                    //    },
                    //    error: function (e) {
                    //        options.error(e);
                    //    }
                    //
                    //});
                }
            }
            $scope.insuranceDetail=function(info){
                $$finder.find('queryPrpdclauseInfoByCondition',{
                    "clauseCode":$scope.proposal.PrpDclauseCode.clauseCode,
                    "insuranceCode":info.insuranceCode
                },{
                    success:function(data){
                        if(info.str==undefined){
                            $scope.str="";
                            angular.forEach(data.content,function(data){
                                $scope.str += data.context;
                            });
                        }else if(info.str){
                            $scope.str=info.str;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                })
            }


            $scope.kindDetail=function(info){
                $$finder.find('queryByKindContext',{
                    "clauseCode":$scope.proposal.PrpDclauseCode.clauseCode,
                    "itemCode":info.itemCode
                },{
                    success:function(data){
                        if(info.kindContext==undefined){
                            $scope.kindContext="";
                            angular.forEach(data.content,function(data){
                                $scope.kindContext+=data.context;
                            });
                        }else if(info.kindContext){
                            $scope.kindContext=info.kindContext;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                })
            }
            //点击“确定”按钮之后，输入框收起
            $scope.coinsurance = function () {
                $scope.clauseDetailsConfirmShow = false;
            }
            //点击“详情”按钮，展示详情内容
            $scope.coinsurance1 = function () {
                $scope.agentFeeShow = false;
                $scope.agentFeeShow1_4 = !$scope.agentFeeShow1_4;
            }

            $scope.message1 = function () {
                alert("暂存成功！条款代码为TK310720170001");
            }
            //保存（暂存）

            $scope.message2 = function (flag) {
                $scope.saveTemporaryDisabled=true;
                var dto = angular.copy($scope.proposal.PrpDclauseCode);
                if(dto.reMark){
                    if(dto.reMark.length){
                        $scope.dd('备注不能超过25个字!');
                        $scope.saveTemporaryDisabled=false;
                        return
                    }
                }
                $scope.nglist=$scope.nglist||[];
                angular.forEach($rootScope.treecheck,function(item,index){
                    if(index=='0'){
                        $scope.nglist=[];
                    }
                    var containFlag="0";
                    if(item.ch){
                        containFlag="1";
                    }
                    $scope.nglist.push({
                        "comCode": item.id,
                        "comName": item.n,
                        "flag":"1",
                        "clauseCode":dto.clauseCode,
                        "containFlag":containFlag //是否包含下级机构
                    });
                });
                console.log($scope.nglist);
                var closeflag="";//控制弹框弹出顺序
                var objarray3=new Array();
                angular.forEach($scope.proposal.prpTmain.clausemanageQueryList,function(item,index){
                    if(item.kindCode==null||item.kindCode==""){
                        closeflag="1";
                        $scope.dd('请录入险别代码!');
                        $scope.saveTemporaryDisabled=false;

                    }else if(item.itemCode==null||item.itemCode==""){
                        closeflag="2";
                             $scope.dd('请录入标的!');
                        $scope.saveTemporaryDisabled=false;

                    }else {
                        objarray3.push({
                            "clauseCode":dto.clauseCode,//条款代码
                            "serialNo": index + 1,
                            "kindCode": item.kindCode,//险别代码
                            "itemCode":item.itemCode ,//标的代码
                            "calculateFlag": item.calculateFlag,//主险标识：1-主险，2-附加险
                            "kindContext":item.kindContext
                        });
                    }
                });
                var objarray4=new Array();
                angular.forEach($scope.proposal.prpTmain.clausemanageQueryList1,function(data){
                    if(data.insuranceCode==null||data.insuranceCode==""){
                        closeflag="3";
                        $scope.dd('请录入保险责任代码!');
                        $scope.saveTemporaryDisabled=false;
                        return
                    }else{
                        objarray4.push({
                            "clauseCode":dto.clauseCode,//条款代码
                            "insuranceCode" :data.insuranceCode,
                            "insuranceText":data.str
                        });
                    }
                });
                var createdateStr = $filter('date')(new Date(), "yyyy-MM-dd")
                var dto1 = {
                    "prpDclauseCodeDto": {
                        "clauseCode":dto.clauseCode,//条款代码
                        "createYear":dto.createYear ,//年份
                        "riskCode":dto.riskCode,//险种
                        "clauseName":dto.clauseName ,//条款名
                        "startDate": dto.startDate,//有效起期
                        "endDate": dto.endDate,//有效止期
                        "businessType":dto.BusinessType1 ,//政策性
                        "remark":dto.remark,//备注
                        "flag":flag,//暂存标志
                        "createdate":createdateStr,
                        "validStatus":dto.validStatus ,//条款状态
                        "operatorCode":$rootScope.user.userCode
                    },
                    "prpDclauseCodeComDtoList": $scope.nglist,
                    "prpDclauseCodeKindDtoList": objarray3 ,
                    "prpDrelationClauseCodeDtoList":objarray4,
                    "insuranceList":[
                        "1"
                    ]
                    //"isFlagList":[
                    //    "Y"
                    //]
                };
                if((dto.createYear!=""||dto.createYear!=null)
                    &&(dto.riskCode!=""||dto.riskCode!=null)
                    &&(dto.startDate!=""||dto.startDate!=null)
                    &&(dto.endDate!=""||dto.endDate!=null)
                    &&(dto.BusinessType1!=""||dto.BusinessType1!=null)
                    &&(dto.createdate!=""||dto.createdate!=null)
                    &&(dto.validStatus!=""||dto.validStatus!=null)
                    &&($scope.proposal.prpTmain.clausemanageQueryList1.length>0)
                    &&($scope.proposal.prpTmain.clausemanageQueryList.length>0)
                    &&closeflag==""
                    &&flag!='0'
                ){
                    if(flag=='1'){//保存
                        if(closeflag){
                            $scope.saveTemporaryDisabled=false;
                            return
                        }else if($scope.jiaoyan()==false){
                            $scope.saveTemporaryDisabled=false;
                            return
                        }else if($scope.configFlag==false){
                            $scope.saveTemporaryDisabled=false;
                            return
                        }
                        $$finder.find('saveClauseByComByKind',dto1, {
                            success: function (data) {
                                $scope.saveTemporaryDisabled=true;
                                if(data.code=='0000') {
                                    console.log(data);
                                    $scope.demo = data.content;
                                    layer.open({
                                        //offset: ['40%', '40%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: '保存成功！条款代码为<br/>'+data.content.success,
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                    //$scope.submit();
                                }else if(data.code='9999'){
                                    layer.open({
                                        //offset: ['40%', '40%'],
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        scrollbar: false,
                                        title: '温馨提示',
                                        content: '保存失败！条款代码为<br/>'+data.content.success,
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                }
                                closeflag="";
                                $scope.configPrintSet();
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }else if(flag=='2'){//修改条款
                        if(closeflag){
                            $scope.saveTemporaryDisabled=false;
                            return
                        }else if($scope.jiaoyan()==false){
                            $scope.saveTemporaryDisabled=false;
                            return
                        }
                        dto1.prpDclauseCodeDto.flag='1';
                        dto1.prpDclauseCodeDto.createDate= $scope.proposal.PrpDclauseCode.createDate;
                        $$finder.find('modifyClauseByComByKind', dto1, {
                            success: function (data) {
                                $scope.saveTemporaryDisabled=true;
                                console.log(data)
                                $scope.demo = data.content;
                                if(data.code=='0000'){
                                    layer.open({
                                        //offset: ['40%', '40%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: '保存成功',
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index)
                                        }
                                    });
                                    $scope.submit();
                                }else if(data.code=='9999'){
                                    layer.open({
                                        //offset: ['40%', '40%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: '修改失败!',
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index)
                                        }
                                    });
                                }

                                closeflag="";
                                $scope.configPrintSet();
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    }
                }else if(flag=='0'){//暂存不能启用有效的条款置状态
                    /*   if(dto1.prpDclauseCodeDto.clauseName==""||dto1.prpDclauseCodeDto.clauseName==undefined){
                     $scope.dd("请录入条款名称！");
                     return
                     }*/
                    if(dto1.prpDclauseCodeDto.riskCode==""||dto1.prpDclauseCodeDto.riskCode==undefined){
                        $scope.dd("请录入险种！");
                        $scope.saveTemporaryDisabled=false;
                        return
                    }
                    if(!$scope.proposal.PrpDclauseCode.clauseName){
                        $scope.dd("请录入条款名称！");
                        $scope.saveTemporaryDisabled=false;
                        return
                    }
                    if(dto1.prpDrelationClauseCodeDtoList.length==2){
                        if(dto1.prpDrelationClauseCodeDtoList[0].insuranceCode==dto1.prpDrelationClauseCodeDtoList[1].insuranceCode)
                        {
                            dto1.prpDrelationClauseCodeDtoList[1].insuranceCode='';
                            $scope.info.insuranceCode='';
                            $scope.dd("保险责任不能选择相同的！");
                            $scope.saveTemporaryDisabled=false;
                            return
                        }
                    }

                    $$finder.find('saveClauseByComByKind',dto1, {
                        success: function (data) {
                            $scope.saveTemporaryDisabled=true;
                            $scope.demo=data.content;
                            if(data.content.message=='success'){

                                layer.open({
                                    //offset: ['40%', '40%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '暂存成功! 条款代码为<br/>'+data.content.success,
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index)
                                    }
                                });
                            }else {
                                layer.open({
                                    //offset: ['40%', '40%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '暂存失败!',
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index)
                                    }
                                });
                            }


                            $scope.configPrintSet();
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                } else {
                    if(closeflag){
                        $scope.saveTemporaryDisabled=false;
                        return
                    }else{
                        $scope.jiaoyan();
                    }

                    /* else if(closeflag!="1"&&closeflag!="2"&&closeflag!="3"){//控制弹框弹出
                     layer.open({
                     offset: ['40%', '40%'],
                     skin: 'large-layer-content',
                     closeBtn: 0,
                     title: '温馨提示',
                     content: '请输入必填项！',
                     btn: ['确定'],
                     btn1: function(index, layero){
                     //按钮【按钮一】的回调
                     layer.close(index)
                     }
                     });
                     closeflag="";
                     }*/
                }
            };
            $scope.configFlag=true;//控制弹框不会连续弹出
            $scope.jiaoyan=function(){
                if($scope.proposal.PrpDclauseCode.riskCode==""||$scope.proposal.PrpDclauseCode.riskCode==null){
                    $scope.dd("请录入险种!");
                    return false
                }
                if($scope.proposal.PrpDclauseCode.BusinessType1!='01'&&($scope.proposal.PrpDclauseCode.riskCode=='3107'||$scope.proposal.PrpDclauseCode.riskCode=='3108'
                    || $scope.proposal.PrpDclauseCode.riskCode=='3162'|| $scope.proposal.PrpDclauseCode.riskCode=='3101'|| $scope.proposal.PrpDclauseCode.riskCode=='3114'
                    || $scope.proposal.PrpDclauseCode.riskCode=='3122'|| $scope.proposal.PrpDclauseCode.riskCode=='3126'|| $scope.proposal.PrpDclauseCode.riskCode=='3161')){
                    $scope.dd("中央政策性险种不可录入地方性或商业性!");
                    return false
                }
                if($scope.proposal.PrpDclauseCode.BusinessType1=='01'&&($scope.proposal.PrpDclauseCode.riskCode=='3155')){
                    $scope.dd("此险种不可录入中央政策性!");
                    return false
                }
                else if($scope.proposal.PrpDclauseCode.clauseName==""||$scope.proposal.PrpDclauseCode.clauseName==null ){
                    $scope.dd("请录入条款名称!");
                    return false
                }
                else if(($scope.proposal.PrpDclauseCode.startDate==""||$scope.proposal.PrpDclauseCode.startDate==null)&&($scope.proposal.PrpDclauseCode.endDate==""||$scope.proposal.PrpDclauseCode.endDate==null)){
                    $scope.dd("请录入有效期!");
                    return false
                }
                else if(($scope.proposal.PrpDclauseCode.startDate!==""||$scope.proposal.PrpDclauseCode.startDate!==null)&&($scope.proposal.PrpDclauseCode.endDate==""||$scope.proposal.PrpDclauseCode.endDate==null)){
                    $scope.dd("请录入有效止期!");
                    return false
                }
                else if(($scope.proposal.PrpDclauseCode.startDate==""||$scope.proposal.PrpDclauseCode.startDate==null)&&($scope.proposal.PrpDclauseCode.endDate!==""||$scope.proposal.PrpDclauseCode.endDate!==null)){
                    $scope.dd("请录入有效起期!");
                    return false
                }
               /* else if($scope.proposal.PrpDclauseCode.remark==""||$scope.proposal.PrpDclauseCode.remark==null){
                    $scope.dd("请录入备注！");
                    return false
                }*/
                else if($scope.nglist.length==0||$scope.nglist==null){
                    $scope.dd("请录入适用机构!");
                    return false
                }
                else if($scope.proposal.prpTmain.clausemanageQueryList.length==0){/*$scope.info.kindCode==""||$scope.info.kindCode==null||$scope.info.itemCName==""||$scope.info.itemCName==null*/

                    $scope.dd("请录入险别配置!");
                    return false

                }
                else if($scope.proposal.prpTmain.clausemanageQueryList1.length==0){/*$scope.info.kindCode==""||$scope.info.kindCode==null||$scope.info.itemCName==""||$scope.info.itemCName==null*/

                    $scope.dd("请录入保险责任!");
                    return false

                }
                if($scope.proposal.prpTmain.clausemanageQueryList.length>0){

                    $.each($scope.proposal.prpTmain.clausemanageQueryList,function(index,item){
                        if(item.kindCode==null||item.kindCode==""){
                            $scope.dd('请录入险别代码!');
                            return $scope.configFlag=false;
                        }else if(item.itemCode==null||item.itemCode==""){
                            $scope.dd('请录入标的!');
                            return $scope.configFlag=false;
                        }else if(item.kindContext){
                            $scope.configFlag=true;
                            if(item.kindContext.length>1000){
                                $scope.dd("险别内容不能超过1000个字!");
                                return $scope.configFlag=false;
                            }
                        }else {
                            $scope.configFlag=true;
                        }
                    })
                    if($scope.configFlag==false){
                        return false
                    }
                }
                if($scope.configFlag&&$scope.proposal.prpTmain.clausemanageQueryList1.length>0){
                    $.each($scope.proposal.prpTmain.clausemanageQueryList1,function(index,data){
                        if(data.insuranceCode==null||data.insuranceCode==""){
                            $scope.dd('请录入保险责任代码!');
                            return $scope.configFlag=false;
                        }else if(data.str){
                            $scope.configFlag=true;
                            if(data.str.length>1000){
                                $scope.dd("保险责任详情不能超过1000个字!");
                                return $scope.configFlag=false;
                            }
                        }else {
                            $scope.configFlag=true;
                        }
                    });
                    if($scope.configFlag==false){
                        return false
                    }
                }
            }

            //将页面设置为只读
            $scope.readonlyclause = function(){
                $scope.proposalQueryHide = true;
            }
            //取消页面只读状态
            $scope.writeclause = function(){
                $scope.proposalQueryHide = false;
            }

            //条款详情下险别配置信息的删除
            $scope.deleteCoins1 = function (index) {

                $scope.proposal.prpTmain.clausemanageQueryList.splice(index, 1);
            };
            //条款详情下险别配置的新增按钮
            $scope.addCoins = function () {
                $scope.proposal.prpTmain.clausemanageQueryList=$scope.proposal.prpTmain.clausemanageQueryList||[]
                //模拟数组
                var newObject = {
                    //'kindCode':'',//险别代码
                    //'calculateflag':'附加病虫害',//险别名称
                    //'itemCode':'附加病虫害',//主险/附加险
                    //'q':'',//标的
                    //'f':'是',//是否计入保额
                    //'a':'',//费率分位
                    //'g':'',//险别内容
                    "clauseCode":"",//条款代码
                    "serialNo": "",
                    "kindCode":"",//险别代码
                    "itemCode": "",//标的代码
                    "calculateFlag":"",
                    "itemCName":"",
                    "kindcContext":""
                };
                $scope.proposal.prpTmain.clausemanageQueryList.push(newObject);

            };
            //条款详情下保险责任的删除
            $scope.deleteCoins2 = function (index) {
                $scope.proposal.prpTmain.clausemanageQueryList1.splice(index, 1);
            }
            //条款详情下保险责任的新增按钮
            $scope.addCoins1 = function () {
                $scope.proposal.prpTmain.clausemanageQueryList1=$scope.proposal.prpTmain.clausemanageQueryList1||[]
                //模拟数组
                var newObject = {
                    //'a':'',//险别代码
                    //'b':'附加病虫害',//险别名称
                    //'c':'附加病虫害',//主险/附加险
                    //'d':'',//标的
                };
                if($scope.proposal.prpTmain.clausemanageQueryList1.length==0||$scope.proposal.prpTmain.clausemanageQueryList1.length==1){
                    $scope.proposal.prpTmain.clausemanageQueryList1.push(newObject);
                }else {
                    $scope.dd('保险责任最多添加两条！');
                    return
                }


            };
            //条款详情弹层下保险责任内容详情弹层展示
            $scope.consoleShow = false;
            var indexInsurance=0;
            $scope.configPrintSet2 = function(index,insuranceCode,insuranceName) {
                if(insuranceCode=='保险免除责任'||insuranceName=='保险免除责任'){
                    $scope.consoleShowTitle='保险免除责任简介'
                }else{
                    $scope.consoleShowTitle='保险责任简介'
                }
                $scope.consoleShow = !$scope.consoleShow;
                if(index!='w'){
                    indexInsurance=index;
                }
                //if(index==undefined){
                //    $scope.str="";
                //}
            };
            //
            $scope.configPrintSet3=function(){
                $scope.str="";
                $scope.consoleShow = false;
            }
            //险别详情
            $scope.consoleShowkind = false;
            var indexKind=0;
            $scope.configPrintSetkind = function(index) {
                $scope.consoleShowkind = !$scope.consoleShowkind;
                if(index!='w'){
                    indexKind=index;
                }
                //if(index==undefined){
                //    $scope.kindContext="";
                //}
            };
            $scope.configPrintSetkind1=function(){
                $scope.kindContext="";
                $scope.consoleShowkind = false;
            }
            //重置条款详情表单
            $scope.reset1=function(){
                $scope.proposal.PrpDclauseCode={};
                $scope.proposal.PrpDclauseCode.createYear=$scope.getdate.year;
                $scope.proposal.PrpDclauseCode.validStatus='1';
                $scope.proposal.PrpDclauseCode.BusinessType1='01';
                $scope.proposal.PrpDclauseCodeDto.validStatus1='1';
                $rootScope.comlist=[];//将机构树已经勾选的机构置为不勾选状态
                $scope.proposal.prpTmain.clausemanageQueryList1=[];
                $scope.proposal.prpTmain.clausemanageQueryList=[];
                $scope.str="";
                $scope.kindContext="";
                $scope.itemCodeList=""
                $scope.kindCodeList=""
                ////$scope.$apply();
                //$scope.proposal.prpTmain.underWriteFlag=$scope.cpproposal.prpTmain.underWriteFlag;
                //$scope.proposal.prpTmain.BusinessType1=$scope.cpproposal.prpTmain.BusinessType1;
            }
            //“新建”
            $scope.sign = function(){
                $scope.momentsave = true;//显示“修改”按钮
                $scope.reset2 = true;//显示“重置”按钮
                $scope.save = true;//显示“保存”按钮
                $scope.modify=false;//不显示“修改”按钮
                $scope.operate1 = true;//显示险别配置中--“操作”标签
                $scope.operate1_1 = true;//显示险别配置中--“删除”按钮
                $scope.operate1_2 = true;//显示险别配置中--“新增”按钮
                $scope.operate1_3 = true;//显示险别配置中--险别内容的“添加”按钮
                $scope.operate1_4 = false;//不显示险别配置中--险别内容的“详情”按钮
                $scope.agentFeeShow1_4 = false;//不显示险别配置中--险别内容的输入框
                $scope.operate2 = true;//显示保险责任中--“操作”标签
                $scope.operate2_1 = true;//显示保险责任中--“删除”按钮
                $scope.operate2_2 = true;//显示保险责任中--“新增”按钮
                $scope.messageHide=false;
                $rootScope.comlist=[];

            }
            //“修改”
            $scope.sign1 = function(info){
                $scope.momentsave = false;//不显示“暂存”按钮
                $scope.reset2 = false;//不显示“重置”按钮
                $scope.save = false;//不显示“保存”按钮
                $scope.modify=true;//显示“修改”按钮
                $scope.operate1 = true;//显示险别配置中--“操作”标签
                $scope.operate1_1 = true;//显示险别配置中--“删除”按钮
                $scope.operate1_2 = true;//显示险别配置中--“新增”按钮
                $scope.operate1_3 = true;//显示险别配置中--险别内容的“添加”按钮
                $scope.operate1_4 = false;//不显示险别配置中--险别内容的“详情”按钮
                $scope.agentFeeShow1_4 = false;//不显示险别配置中--险别内容的输入框
                $scope.operate2 = true;//显示保险责任中--“操作”标签
                $scope.operate2_1 = true;//显示保险责任中--“删除”按钮
                $scope.operate2_2 = true;//显示保险责任中--“新增”按钮
                $scope.messageHide=false;

            }
            //“查看”
            $scope.sign2 = function(){
                $scope.momentsave = false;//不显示“暂存”按钮
                $scope.modify=false;//不显示“修改”按钮
                $scope.reset2 = false;//不显示“重置”按钮
                $scope.save = false;//不显示“保存”按钮
                $scope.operate1 = false;//不显示险别配置中--“操作”标签
                $scope.operate1_1 = false;//不显示险别配置中--“删除”按钮
                $scope.operate1_2 = false;//不显示险别配置中--“新增”按钮
                $scope.operate1_3 = false;//不显示险别配置中--险别内容的“添加”按钮
                $scope.operate1_4 = true;//显示险别配置中--险别内容的“详情”按钮
                $scope.operate2 = false;//不显示保险责任中--“操作”标签
                $scope.operate2_1 = false;//不显示保险责任中--“删除”按钮
                $scope.operate2_2 = false;//不显示保险责任中--“新增”按钮
                $scope.agentFeeShow = false;//不显示编辑内容
                $scope.messageHide=true;

            }
            //根据条款代码停用启用条款
            $scope.disableClause=function(info) {
                var cuyyentTime=$filter('date')(new Date(),'yyyy-MM-dd');
                if (commonApiServ.compareFullDate(info.startDate, cuyyentTime) == 1) {
                    $scope.dd('条款模板使用日期不在有效期内');
                } else if (commonApiServ.compareFullDate(cuyyentTime, info.endDate) == 1) {
                    $scope.dd('条款模板已过期');
                }else if(info.flag=='0'){
                    $scope.dd('暂存模板需要先保存');
                } else {
                    if (info.validStatus == '1') {
                        //设置未启用
                        info.validStatus = '0';
                        info.validStatus1 = '0'
                    } else {
                        info.validStatus = '1'
                        info.validStatus1 = '1'
                    }
                    $$finder.find('disableClause', {
                        "clauseCode": info.clauseCode,
                        "validStatus": info.validStatus
                    }, {
                        success: function (data) {
                            if (data.content.message == 'success') {
                                $scope.distishi('0');
                                $scope.submit();
                            } else {
                                $scope.distishi('1');
                            }
                        }
                    })
                }
            }
            //单个删除条款信息回调重新加载查询
            $scope.deleteCoins = function (clauseCode) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '确定要删除吗?',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        $$finder.find('clauseCodeDel', {
                                clauseCode: clauseCode
                            }
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
                        layer.close(index);
                    }
                });
            };
            //批量删除条款信息
            $scope.plsc=function() {
                $scope.checked2=[];
                if($scope.proposal.prpTmain.clauseQueryList[0].validStatus1=='1'){
                    angular.forEach($scope.proposal.prpTmain.clauseQueryList, function (data) {
                        if(data.checked==true){
                            $scope.checked2.push(data);
                        }
                    })
                    if($scope.checked2.length>0){
                        $scope.posalDel('3');
                    }else{
                        $scope.posalDel('2');
                    }

                }else{
                    if( $scope.checked1.length!=0){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '确定要删除吗?',
                            scrollbar: false,
                            btn: ['确定', '取消'],
                            btn1: function (index, layero) {
                                $$finder.find('clauseCodeDelAll', $scope.checked1
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

            }
            //修改时校验是否选中条款 需求暂时不做提示，设计不合理，太过繁杂
            /*       $scope.upisSelect=function(info){
             if( $scope.checked1.length!=0&&info.checked==true){

             }else{
             //如果未选中则提示未选中的信息
             $scope.posalDel('2');
             configPrintSet();
             }
             }*/

            //是否要确认删除
            $scope.flg=function(message,info){
                //有效条款不允许删
                if(info!=null&&info.validStatus1=='1'){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '不可删除有效条款',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
                    if(message=='批删'){$scope.plsc();}
                    else if(message=='单删'){$scope.deleteCoins(info.clauseCode)}
                }
            }

            //公用的提示信息
            $scope.posalDel=function(message){
                var content;
                if(message=='0') {content = '删除成功！';}
                else if(message=='1'){content='删除失败！' }
                else if(message=='2'){content='请选中条款！'}
                else if(message=='3'){content='不能选择有效条款！'}
                else if(message=='4'){content='当前页面无无效条款！' }
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
                return
            }
            $scope.distishi=function(message){
                var content;
                if(message=='0')
                {
                    content = '操作成功！';
                }else{content='操作失败！' }
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
                        $scope.submit();
                    }
                });
            }
            $scope.dd=function(content){
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
            //带出险别只读信息
            $scope.change=function(dataList,index){
                //查询费率分位
                if($scope.proposal.PrpDclauseCode){
                    $$finder.find('queryByRiskCode', {
                        "riskCode":dataList.riskCode, //险种
                    }, {
                        success: function (data) {
                            $scope.curtor=data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }

                    });
                }
                $scope.proposal.prpTmain.clausemanageQueryList[index]=dataList
                console.log($scope.proposal.prpTmain.clausemanageQueryList)
            };
            $scope.change1=function(dataItem,index){
                console.log(dataItem);
                console.log($scope.proposal.prpTmain.clausemanageQueryList);
                $scope.proposal.prpTmain.clausemanageQueryList[index].itemCode= dataItem.itemCode;
                $scope.proposal.prpTmain.clausemanageQueryList[index].itemCName=dataItem.itemCName;
            };
            //险种不能为相同的
            $scope.checkSubsidyType = function (target, index) {
                if (index != 0) {
                    if (index == 1) {
                        if(($scope.proposal.prpTmain.clausemanageQueryList[0].itemCode == $scope.proposal.prpTmain.clausemanageQueryList[1].itemCode)&&
                            ($scope.proposal.prpTmain.clausemanageQueryList[0].itemCName == $scope.proposal.prpTmain.clausemanageQueryList[1].itemCName)&&
                            ($scope.proposal.prpTmain.clausemanageQueryList[0].kindCode == $scope.proposal.prpTmain.clausemanageQueryList[1].kindCode)&&
                            ($scope.proposal.prpTmain.clausemanageQueryList[0].kindCName == $scope.proposal.prpTmain.clausemanageQueryList[1].kindCName)) {
                            layer.open({
                                //offset: ['35%', '40%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '第1条和第2条险别 相同,请更改!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            })
                            $scope.proposal.prpTmain.clausemanageQueryList[1].itemCode="";
                            $scope.proposal.prpTmain.clausemanageQueryList[1].itemCName="";
                            //$scope.addEquipmentFlag = true;
                            return false;
                        }
                    }
                    else {
                        for (var i = 0; i <= index; i++) {
                            for (var j = i + 1; j <= index; j++) {
                                if (($scope.proposal.prpTmain.clausemanageQueryList[i].itemCode == $scope.proposal.prpTmain.clausemanageQueryList[j].itemCode)&&
                                    ($scope.proposal.prpTmain.clausemanageQueryList[i].itemCName == $scope.proposal.prpTmain.clausemanageQueryList[j].itemCName)&&
                                    ($scope.proposal.prpTmain.clausemanageQueryList[i].kindCode == $scope.proposal.prpTmain.clausemanageQueryList[j].kindCode)&&
                                    ($scope.proposal.prpTmain.clausemanageQueryList[i].kindCName == $scope.proposal.prpTmain.clausemanageQueryList[j].kindCName)) {
                                    layer.open({
                                        //offset: ['35%', '40%'],
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: "第" + (i + 1) + "条和第" + (j + 1) + "条险别相同,请更改!",
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        },
                                    })
                                    $scope.proposal.prpTmain.clausemanageQueryList[j].itemCode="";
                                    $scope.proposal.prpTmain.clausemanageQueryList[j].itemCName="";
                                    //$scope.addEquipmentFlag = true;
                                    return false;
                                }
                            }
                        }
                    }
                }

            };
            //查询险别名称
            $scope.selectKind=function(){
                if(!$scope.proposal.PrpDclauseCode||!$scope.proposal.PrpDclauseCode.riskCode||$scope.proposal.PrpDclauseCode.riskCode==''){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择险种',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }else {
                    $scope.kindCodeList={}
                    var riskCode = angular.copy($scope.proposal.PrpDclauseCode.riskCode);
                    $$finder.find('queryByRiskCode1', {
                        "riskCode": riskCode, //险种
                    }, {
                        success: function (data) {
                            $scope.kindCodeList = data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }

                    });
                }
            }

            //查询标的名称
            $scope.selectItem=function(index){
                if($scope.info.itemCName){

                }
                if(!$scope.proposal.PrpDclauseCode||!$scope.proposal.PrpDclauseCode.riskCode||$scope.proposal.PrpDclauseCode.riskCode==''){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择险种',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
                else if(!$scope.proposal.prpTmain.clausemanageQueryList[index].kindCode){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择险别代码',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    return
                }
                else{
                    $scope.itemCodeList={}
                    var riskCode = angular.copy($scope.proposal.PrpDclauseCode.riskCode);
                    var kindCode = $scope.proposal.prpTmain.clausemanageQueryList[index].kindCode;
                    $$finder.find('queryPrpDitemInfoDto', {
                        "riskCode":riskCode, //险种
                        "kindCode":kindCode,
                    }, {
                        success: function (data) {
                            $scope.itemCodeList=data.content;
                        },
                        error: function (e) {
                            options.error(e);
                        }

                    });
                }
            }


            //条款新建年份校验
            $scope.verifyYear=function(year){
                var reg=new RegExp("^[0-9]*$")
                if(reg.test(year)){
                    if(year.length>4 || year.length<4){
                        layer.open({
                            //offset: ['35%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '年份长度必须为4',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        })
                    }
                }else{
                    layer.open({
                        //offset: ['35%', '40%'],
                        scrollbar: false,
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '年份格式必须为数字',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
            }

            //有效日期校验
            $scope.verifyDate=function(startDate,endDate){
                if(startDate != null && endDate != null){
                    var startDate = parseInt(startDate.replace(/-/g,""),10);
                    console.log(startDate)
                    console.log(endDate)
                    var endDate = parseInt(endDate.replace(/-/g,""),10);
                    if(startDate>endDate) {
                        var content;
                        content = '有效止期要大于有效起期';
                        $scope.proposal.PrpDclauseCode.endDate = "";
                        layer.open({
                            //offset: ['35%', '40%'],
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
            }

            //查询保险责任名称和代码
            $scope.queryPrpDclauseInfo=function() {
                if(!$scope.proposal.PrpDclauseCode||!$scope.proposal.PrpDclauseCode.riskCode||$scope.proposal.PrpDclauseCode.riskCode==''){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择险种',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }else {
                    $$finder.find('initSelect', {
                        "codeType": "InsuranceDuty",
                        "riskCode": "",
                        "hpFlag":"0"
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.prpDclauseDtoList = [];
                            angular.forEach(data.content.codeData,function(item,index){
                                $scope.prpDclauseDtoList.push({
                                    "insuranceCode":item.codeCode,
                                    "clauseName":item.codeName
                                });
                            });
                            $scope.proposal.prpTmain.clausemanageQueryList1
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }

            //带出只读信息
            $scope.changeclause=function (datas,index){
          /*  $scope.proposal.prpTmain.clausemanageQueryList1=[{
                    "insuranceCode":"",
                    "clauseName":"",
                }]*/
                console.log(datas)
                $$finder.find('creatProposal',{
                    "tableName":datas.insuranceCode,
                    "riskCode":"3107",
                    "iComCode":$rootScope.user.loginComCode
                },{
                    success:function(data){
                        $scope.proposal.prpTmain.clausemanageQueryList1[index].insuranceCode=data.content.billNo;
                        $scope.proposal.prpTmain.clausemanageQueryList1[index].insuranceCode2=$scope.proposal.prpTmain.clausemanageQueryList1[index].insuranceCode;
                        $scope.proposal.prpTmain.clausemanageQueryList1[index].clauseName=datas.clauseName;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

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
            //查询保险责任内容
            $scope.str="";
            $scope.detail=function detail() {
                $scope.proposal.prpTmain.clausemanageQueryList1[indexInsurance].str=$scope.str;
                $scope.str="";
                //if(!$scope.proposal.prpTmain.clausemanageQueryList1[index]&&!$scope.proposal.prpTmain.clausemanageQueryList1[index].clauseCode && $scope.proposal.prpTmain.clausemanageQueryList1[index].clauseCode!=''){
                //    $$finder.find('queryPrpdclauseInfoByCondition',{
                //        "clauseCode":$scope.proposal.prpTmain.clausemanageQueryList1[index].clauseCode
                //    },{
                //        success: function (data) {
                //            console.log(data)
                //            //angular.forEach(data.content,function(data){
                //            //    $scope.str=$scope.str+"\n"+data.context
                //            //});
                //
                //        },
                //        error: function (e) {
                //            options.error(e);
                //        }
                //    });
                //}
            }
            $scope.queryByValid=function() {
                $$finder.find('riskCode',{
                }, {
                    success: function (data) {
                        $scope.riskCodeList = data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            $scope.clearclause= function () {
                $scope.proposal.prpTmain.clausemanageQueryList=[];
            }
            //根据条款代码查询条款详细信息
            $scope.clauseQueryDetail=function(clauseCode){
                $scope.proposal.prpTmain.clausemanageQueryList={};
                $scope.proposal.prpTmain.clausemanageQueryList1={};
                /* $scope.t1=$interval(fn,0);*/
                /* $clearInterval(t1);*/
                fff=true;
                $$finder.find('queryClauseCodeByComByKind',{
                    "clauseCode":clauseCode,
                    "userCode":$rootScope.user.userCode,
                    "comCode":$rootScope.user.loginComCode
                },{
                    success: function (data) {
                        $scope.respDto = data.content;
                        if (fff) {

                            $scope.proposal.PrpDclauseCode = $scope.respDto.prpDclauseCodeDto;
                            $scope.proposal.PrpDclauseCode.BusinessType1 = $scope.proposal.PrpDclauseCode.businessType;
                            $scope.proposal.prpTmain.clausemanageQueryList = $scope.respDto.prpDclauseCodeKindDtoList;
                            $scope.curtor = $scope.respDto.calculator;
                            console.log($scope.proposal.prpTmain.clausemanageQueryList);
                            $scope.proposal.prpTmain.clausemanageQueryList1 = $scope.respDto.prpDrelationClauseCodeDtoList;
                            angular.forEach($scope.proposal.prpTmain.clausemanageQueryList1, function (data) {
                                data.insuranceCode2=data.insuranceCode;
                            })
                            console.log($scope.proposal.prpTmain.clausemanageQueryList1);
                            $rootScope.comlist = $scope.respDto.companyListDtoList;

                            $rootScope.clauseflag=true;
                        }
                        console.log($scope.respDto.companyListDtoList);
                        $scope.nglist=$scope.respDto.prpDclauseCodeComDtoList

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }


        }]);
});