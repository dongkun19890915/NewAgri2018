
define(['app','config'], function (app,config) {
    'use strict';
    app.registerController('UIPrPoEnMainHeadCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$$code','commonApiServ','$state','$window',
        function ($rootScope,$scope,$$finder,$http,$filter,$$code,commonApiServ,$state,$window) {
            //初始化
            var user=angular.copy($rootScope.user);
            $scope.ComCodeInfo={};
            //$scope.proposal=$scope.proposal||{};
            //$scope.proposal.prpTmainDto=$scope.proposal.prpTmainDto||{}
            $scope.proposal.prpTmainDto.makeCom = user.makeCom;
            //操作员修改人
            $scope.proposal.prpTmainDto.operatorCode=user.userCode
            $scope.proposal.prpTmainDto.operatorName=user.userName
            $scope.proposal.prpTmainDto.updaterName=user.userName
            $scope.proposal.prpTmainDto.updaterCode=user.userCode
            $scope.changemodel=function(data){
                $scope.proposal=$scope.proposal||{};
                $scope.proposal.prpTmainDto=$scope.proposal.prpTmainDto||{}
                $scope.proposal.prpTmainDto.comCode=data.comCName
            }
            //给是否承保公示、是否验标、是否通过第三方识别赋默认值
            $scope.proposal.prpTmainDto.thirdKnow='1';
            $scope.proposal.prpTmainDto.notificationFlag='1';
            $scope.proposal.prpTmainDto.inceptionFlag='1';
            $scope.proposal.prpTmainDto.eccFlag='2';
            //续保起保日期校验
            $scope.checkStartDate = function(x){
                var strEditType = $scope.proposal.editType;//编辑类型
                var strRiskCode = $scope.proposal.prpTmainDto.classCode;//险种
                var strEndDateRenewal;//续保的终保日期
                //续保起保日期与原保单终保日期校验　
                if(strEditType == "RENEWAL") {
                    strEndDateRenewal = commonApiServ.getNextDateFullDate($scope.proposal.renewalEndTime, 1);
                    console.log(strEndDateRenewal)
                    if(commonApiServ.compareFullDate(x, strEndDateRenewal) < 0) {
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '续保的起保日期不得提前于原保单的终保日期！',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.prpTmainDto.startDate = '';
                        $scope.proposal.prpTmainDto.endDate = '';
                        return false;
                    }
                }
                //保存时强制置终保日期
                if(!("3101,3107,3108,3114,3122,3126,3161".indexOf(strRiskCode) > -1)) {
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate(commonApiServ.getNextYearFullDate(x, 1), -1);
                }
                //EDJ允许通过修改起保日期来修改终保日期
                if(strRiskCode == "EDJ") {
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate(commonApiServ.getNextYearFullDate(x, 1), -1);
                } else if(strRiskCode == "EGY") {
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate($scope.proposal.prpTmainDto.startDate, 6);
                } else if(strRiskCode == "2720") {//1天
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate($scope.proposal.prpTmainDto.startDate, 1);
                } else if(strRiskCode == "2703") {//6天
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate($scope.proposal.prpTmainDto.startDate, 6);
                } else if(strRiskCode == "2721") {//7天
                    $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate($scope.proposal.prpTmainDto.startDate, 7);
                }
                /* add by xiaojian 20051219 begin reason：船舶险根据保单类型显示终保日期，如果保单类型为“航次”则终保日期为起保日期后第180天 */
                else if(strRiskCode == "1102") {
                    if(fm.PolicyType.value == "14") //航次
                        $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate($scope.proposal.prpTmainDto.startDate, 180);
                    else
                        $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextDateFullDate(commonApiServ.getNextYearFullDate(x, 1), -1);
                } else if("3101,3107,3108,3114,3122,3126,3161".indexOf(strRiskCode) > -1) {
                    if ($scope.proposal.prpTmainDto.startDate != "") {//保险起始时间不为空的时候才做此判断
                        if (commonApiServ.compareFullDate($scope.proposal.prpTmainDto.startDate, $scope.proposal.prpTmainDto.signDate) < 0) {
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                scrollbar: false,
                                title: '温馨提示',
                                content: '保险起期早于当前日期、请确认！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                    var startDate = new Date(Date.parse($scope.proposal.prpTmainDto.startDate.replace(/-/g, "/"))).getTime();
                                    var endDate = new Date(Date.parse($scope.proposal.prpTmainDto.endDate.replace(/-/g, "/"))).getTime();
                                    var time = endDate - startDate;
                                    time = new Date(time).getFullYear();
                                    if (time > 1970) {
                                        layer.open({
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: "保险期间大于一年，请确认！",
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            }
                                        });
                                    }

                                }
                            });
                            return true;
                        } else {
                            var startDate = new Date(Date.parse($scope.proposal.prpTmainDto.startDate.replace(/-/g, "/"))).getTime();
                            var endDate = new Date(Date.parse($scope.proposal.prpTmainDto.endDate.replace(/-/g, "/"))).getTime();
                            var time = endDate - startDate;
                            time = new Date(time).getFullYear();
                            if (time > 1970) {
                                layer.open({
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,
                                    title: '温馨提示',
                                    content: "保险期间大于一年，请确认！",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        }
                    }
                }
                return true;
            }
            //判断制单日期和终保日期的校验
            $scope.checkEndDateWithOperateDate = function() {
                if($scope.proposal.prpTmainDto.endDate){
                    if(commonApiServ.compareFullDate($scope.proposal.prpTmainDto.startDate,$scope.proposal.prpTmainDto.endDate)==1){
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
                            title: '温馨提示',
                            content: '起保日期不能晚于终保日期！',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.prpTmainDto.startDate=''+$scope.getdatestar.year+'-'+$scope.dataNum($scope.getdatestar.month)+'-'+$scope.dataNum($scope.getdatestar.day)
                        $scope.proposal.prpTmainDto.endDate=''+($scope.getdate.year+1)+'-'+$scope.getdate.endMonth+'-'+($scope.getdate.endDay)
                        return false;
                    }else if(commonApiServ.compareFullDate($scope.proposal.prpTmainDto.signDate,$scope.proposal.prpTmainDto.endDate)==1){
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '制单日期不能大于终保日期！',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.prpTmainDto.startDate=''+$scope.getdatestar.year+'-'+$scope.dataNum($scope.getdatestar.month)+'-'+$scope.dataNum($scope.getdatestar.day)
                        $scope.proposal.prpTmainDto.endDate=''+($scope.getdate.year+1)+'-'+$scope.getdate.endMonth+'-'+($scope.getdate.endDay)
                        return false;
                    }else{
                        return true;
                    }
                }
            }
            //出单员意见长度校验
            $scope.checkLength1 = function (length) {
                var strValue = $scope.proposal.prpTmainDto.reMark;
                var intMaxLength ;
                var intCount = 0;
                var vChar;
                var i;
                var comment = '';
                if(typeof(length) != 'undefined'){
                    intMaxLength = length;
                }else{
                    intMaxLength = 1024;
                }
                if(strValue.indexOf("^")>-1)
                {
                    comment = '^为系统保留字符，不允许输入！'
                }
                for(i=0;i<strValue.length;i++)
                {
                    vChar = escape(strValue.charAt(i));
                    if(vChar.substring(0,2)=="%u"&&vChar.length==6)
                        intCount = intCount+2;
                    else
                        intCount = intCount+1;
                }
                if(intCount>intMaxLength)
                {
                    comment = "出单员意见输入过长，请重新输入！"
                }
                if(comment!=''){
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: comment,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }
            //归属机构校验
            $scope.checkCoinsTreaty1 = function() {
                var strStartDate = $scope.proposal.prpTmainDto.startDate;//起保日期
                var strComCode = $scope.proposal.prpTmainDto.comCode;//归属机构
                var strRiskCode = $scope.proposal.prpTmainDto.riskCode;//险种代码
                var strCoinsType = "";
                var strTreatyNo = "";
                var strCoinsPremiumType = "";
                if(strComCode == "" || strComCode == null) {
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '请选择机构！',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $scope.proposal.prpTmainDto.coinsFlag = "0";//连共保标志
                    return false;
                }
                //在此去掉，因为死循环影响提示
                //if(strStartDate == "" || strStartDate == null) {
                //    layer.open({
                //        skin: 'large-layer-content',
                //        scrollbar: false,
                //        closeBtn: 0,
                //        title: '温馨提示',
                //        content: '请先录入保单起保日期！',
                //        btn: ['确定'],
                //        btn1: function(index, layero){
                //            //按钮【按钮一】的回调
                //            layer.close(index);
                //        }
                //    });
                //    $scope.proposal.prpTmainDto.coinsFlag = "0";//连共保标志
                //    return false;
                //}
                /* //共保协议信息
                 $$finder.find('queryCoinsTreaty', {
                 'riskCode':'3224',//strRiskCode,//险种
                 'comCode':'3488000000',//strComCode,//归属机构
                 'startDate':'2016-01-01'//strStartDate//起保日期
                 }, {
                 success: function (data) {
                 console.log(data)
                 $scope.prpTitemKind = {};
                 $scope.prpTitemKind.unitAmount = "1.00";
                 },
                 error: function (e) {
                 options.error(e);
                 }
                 });*/

            }

            //说明文字展示隐藏
            $scope.explain=false;
            $scope.explainClick=function(){
                $scope.explain=!$scope.explain;
            };
            $scope.signDate=commonApiServ.getCurrentDate();
            //投保单录入页面的基本信息展开收起按钮
            $scope.isHide=true;
            $scope.isShow=function(){
                $scope.isHide=!$scope.isHide;
            }
            //后台请求数据
            //$scope.$watch('init',function(newvalue){
            //    if(newvalue){
            //        $scope.initdata()
            //    }
            //})
            //$scope.getInitdata=function(dataType,dataList,dataData){
            //    $$code.getCodes('codeType', dataType, { },$scope[dataData]||dataData).then(function (data) {
            //        $scope[dataList] = data;
            //    });
            //
            //}
            //$scope.getHanCode=function(data){
            //    $scope.proposal.prpTmainDto.comCName=data.comCName
            //    $scope.createProposal()
            //    $scope.handCodeData.riskCode=$scope.proposal.prpTmainDto.riskCode;
            //    //$scope.handCodeData.comCodeFields=$scope.proposal.prpTmainDto.comCode
            //
            //    $scope.getInitdata('queryHandler1CodeInfo','handCodeList','handCodeData')
            //}
            //$scope.initdata=function (){
            //    $scope.comCodeData.riskCode=$scope.proposal.prpTmainDto.riskCode
            //    //console.log($scope.proposal.prpTmainDto.riskCode)
            //    $scope.getInitdata('queryComCodeInfo','comCodeList','comCodeData')
            $$code.getCodes('codeType', 'BusinessCategory', {
            }).then(function (data) {
                if(data.prpDcodeListDtoList){
                    angular.forEach(data.prpDcodeListDtoList,function(data){
                        if('BusinessCategory'==data.codeType){
                            $scope.BusinessCategory = data.prpDcodeDtoList;
                        }
                    })
                }
            })
            //}
            //
            ////生成投保单号
            //$scope.createProposal=function(){
            //    $scope.proposal.prpTmainDto.comCode&&$$finder.find('creatProposal', {
            //        "tableName": "prptmain",//表名
            //        "iYear": new Date().getFullYear(),//当前年份
            //        "riskCode":$scope.proposal.prpTmainDto.riskCode,
            //        "iComCode":$scope.proposal.prpTmainDto.comCode,
            //        "userCode": '0122'
            //    }, {
            //        success: function (data) {
            //            $scope.proposal.prpTmainDto.proposalNo=data.content.billNo;
            //        },
            //        error: function (e) {
            //            options.error(e);
            //        }
            //    });
            //};

            //业务大类
            $scope.oneSelect=function(){
                $scope.parameterConvert.businessCategorySubmit();
                //console.log($scope.proposal.prpTmainDto.groupFlag)
            }
            //详情查询、批改初始化业务大类参数转换
            $scope.parameterConvert.businessCategoryInit = function(){
                var businessCategoryInitList = [];
                var groupFlag = $scope.proposal.prpTmainDto.groupFlag;
                if(groupFlag){
                    $scope.BusinessCategory=$scope.BusinessCategory||[]
                    for(var i = 0; i < $scope.BusinessCategory.length; i++){
                        if("1" == groupFlag.substring(i,i+1)){
                            businessCategoryInitList.push((i+1).toString());
                        }
                    }
                    $scope.proposal.prpTmainDto.businessCategory = businessCategoryInitList;
                    console.log('以下是业务大类')
                    console.log($scope.proposal.prpTmainDto.businessCategory)
                }
            }

            //投保单、批单保存参数转换
            $scope.parameterConvert.businessCategorySubmit = function(){
                var strGroupFlag = "00000000000000000000";
                var businessCategoryList = $scope.proposal.prpTmainDto.businessCategory;
                var busCategoryValue = 0;
                if(businessCategoryList){
                    for(var i = 0; i < businessCategoryList.length; i++){
                        if(businessCategoryList[i]){
                            busCategoryValue = businessCategoryList[i];
                            strGroupFlag = strGroupFlag.substring(0,busCategoryValue-1)+"1"+strGroupFlag.substring(busCategoryValue);
                        }
                    }
                }
                $scope.proposal.prpTmainDto.groupFlag = strGroupFlag;
            }

            //校验 政策/商业标志
            $scope.checkBusinessTypeCentral=function(){
                var riskCodeValue=$scope.proposal.prpTmainDto.riskCode;
                var businessType1Value=$scope.proposal.prpTmainDto.businessType1;

                if(riskCodeValue=='3151'|| riskCodeValue == '3229' || riskCodeValue == '3176' || riskCodeValue == '3230'){
                    if(businessType1Value=='01'){
                        layer.open({
                            /*offset: ['35%', '29%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '此险种不是“中央政策性”险种，请重新选择【政策/商业标志】!',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        //alert("此险种不是“中央政策性”险种，请重新选择【政策/商业标志】!");
                        //angular.element('#businessType1').focus();
                        $scope.proposal.prpTmainDto.businessType1=''
                        return ;
                    }
                }
                return;
            }
            //PerformanceRate跟绩效有关，maxCommissionRate这个是佣金率
            $scope.setRefreshMaxPerformanceFlagZeror = function () {
                $scope.proposal.prpTmainDto.PerformanceRateFlag = "0";
                $scope.proposal.prpTmainDto.CommissionRateFlag = "0";
                $scope.proposal.prpTmainDto.disabled=false;
                $scope.proposal.prpTmainDto.disabled=false;
            };
            //业务类型,这个留着以后用别删 by 周琦
            //时间比较
            $scope.compareDate = function(startDate,endDate,type){
                $scope.proposal.changeData()
                var startDate = parseInt(startDate.replace(/-/g,""),10);
                var endDate = parseInt(endDate.replace(/-/g,""),10);
                if(startDate>endDate){
                    var content;
                    if(type=="保险开始"){
                        //content = '保险期间的开始时间不能早于制单日期';
                        //$scope.proposal.prpTmainDto.startDate = "";
                    }else if(type=="投保日期"){
                        content = '投保日期需早于当前日期，请修改！';
                        $scope.proposal.prpTmainDto.operateDate=''+$scope.getdate.year+'-'+$scope.dataNum($scope.getdate.month+1)+'-'+$scope.dataNum($scope.getdate.day)
                    }
                    if(content){
                        layer.open({
                            /*offset: ['35%', '40%'],*/
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
                }else if(type=="保险截止"){
                    var startDate = new Date(Date.parse($scope.proposal.prpTmainDto.startDate.replace(/-/g,   "/"))).getTime();
                    var endDate = new Date(Date.parse($scope.proposal.prpTmainDto.endDate.replace(/-/g,   "/"))).getTime();
                    var time=endDate-startDate;
                    time=new Date(time).getFullYear();
                    if(time>1970){
                        layer.open({
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "保险期间大于一年，请确认！",
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }
                } else {
                    if(type=="保险开始"){
                        if($scope.proposal.prpTmainDto.startDate!=""){
                            $scope.proposal.prpTmainDto.endDate = commonApiServ.getNextYearFullDate($scope.proposal.prpTmainDto.startDate,1);
                        }

                    }
                }
            }
             var day3 = new Date();
             day3.setTime(day3.getTime()+24*60*60*1000);
              $scope.getdatestar={
                year:day3.getFullYear(),
                month:(day3.getMonth()+1),
                day:day3.getDate()
            }
            //获取时间
            var date = new Date();
            var month = date.getMonth();
            var day = date.getDate();
            //起保日期的初始化
            var startMonth;
            var startDay;
            //终保日期
            var endMonth;
            var endDay;
            if(month<10){
                startMonth = '0' +(month+1);
                endMonth = '0' +(month+1);
            }else {
                startMonth = month+1;
                endMonth = month+1;
            }
            if(day<10){
                startDay = '0' + (day+1);
                endDay = '0' + day;
            }else {
                startDay = day+1;
                endDay = day;
            }
            $scope.getdate={
                year:date.getFullYear(),
                month:month,
                day:day,
                startMonth:startMonth,
                startDay:startDay,
                endMonth:endMonth,
                endDay:endDay
            }
            $scope.dataNum=function(x){
                return x<10?'0'+x:x
            }

            //批改原因弹出框
            $scope.consoleShow = false;
            $scope.configPrintSet2 = function() {
                $scope.consoleShow = !$scope.consoleShow;
            }
            //-------------------------------投保单保存校验start---------------------------------
            $scope.checkMainHead = function () {
                var content = "";
                if(checkComCode(content)==false)
                {
                    return false;
                }
                var categoryFlag = false;
                var categorycount = 0;
                var businessCategoryList = $scope.proposal.prpTmainDto.businessCategory;
                if(businessCategoryList!=null) {
                    for (var i = 0; i < businessCategoryList.length; i++) {
                        if (businessCategoryList[i]) {
                            categoryFlag = true;
                            categorycount++;
                        }
                    }
                    var policyType = $scope.proposal.prpTmainDto.policyTyp;
                    if (!categoryFlag && policyType != null && policyType != '' && policyType != 'Q1' && policyType != 'Q2'
                        && policyType != 'E1' && policyType != 'E2'
                        && policyType != 'I27' && policyType != 'I28' && policyType != 'H23' && policyType != 'H24') {
                        content = "业务大类不能为空,请选择！";
                        return false;
                    }
                    if (categorycount >= 2 && policyType != null && policyTypee != '' && policyType != 'Q1' && policyType != 'Q2'
                        && policyType != 'E1' && policyType != 'E2'
                        && policyType != 'I27' && policyType != 'I28' && policyType != 'H23' && policyType != 'H24') {
                        content = "业务大类只能选择一项,请选择！";
                        return false;
                    }
                }
                if(checkBusinessType1_ManiHead(content) == false){ //检查“政策/商业性标志”与补贴信息中的补贴类型是否一致
                    return false;
                }


                if(content != ""){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
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
                    })
                    return false;
                }
            }
            //归属部门校验
            $scope.checkComCode = function(content)
            {
                var sComCode = $scope.proposal.prpTmainDto.comCode;//归属机构号
                if (sComCode == '3414002200') {
                    content = "无为县农业保险服务部 已经归属到芜湖中支，不允许在巢湖中支下出单！";
                }
                if (sComCode == '3414002300') {
                    content = "含山县农业保险服务部 已经归属到马鞍山中支，不允许在巢湖中支下出单！";
                }
                if (sComCode == '3414002400') {
                    content = "和县农业保险服务部 已经归属到马鞍山中支，不允许在巢湖中支下出单！";
                }
            }
            $scope.checkBusinessType1_ManiHead = function (content) {
                var businessType = $scope.proposal.prpTmainDto.businessType1;  //政策/商业性标志
                var isContain = false;                      //是否包含了 中央财政
                var count = $scope.proposal.prpTsubsidyDtoList.length;
                var j = 0;
                if(count<0){
                    return true;
                }
                angular.forEach($scope.proposal.prpTsubsidyDtoList,function(data,index){
                    if($scope.proposal.prpTsubsidyDtoList[index].subsidyCode == '03'){
                        isContain = true;
                        j = index;
                        return ;
                    }
                    if(businessType == "00"&& count > 1){
                        content = "商业险不能录入补贴信息";
                        return false;
                    }
                    if((businessType == "01" || businessType == "02") && count == 1){
                        content = "政策性业务必须至少录入一条补贴信息";
                        return false;
                    }
                    if(businessType == "01" && isContain == false){
                        content = "中央政策性业务必须录入补贴类型为”中央财政“的补贴信息";
                        return false;
                    }
                    if(businessType == "02" && isContain == true){
                        content = "地方政策性业务不能录入补贴类型为”中央财政“的补贴信息";
                        return false;
                    }
                    return true;
                });
            }

        //    关联信息
            $scope.showRelativeMessage=false;
            $scope.relativeMessage= function (str) {
                if(str){
                    $scope.showRelativeMessage=true;
                }
                $$finder.find('queryRelateByProposalNo',{
                    "proposalNo":str
                },{
                    success:function(data){
                        if(data.code=='0000'){
                            var QueryRelationResponseDto=data.content;
                            console.log(QueryRelationResponseDto);
                            $scope.relationPrposalNo=QueryRelationResponseDto.proposalNo;
                            $scope.relationPolicyNo=QueryRelationResponseDto.policyNo;
                            $scope.relationRepolicyNo=QueryRelationResponseDto.repolicyNo;
                            $scope.prpPheadDtoList=QueryRelationResponseDto.prpPheadDtoList;
                            $scope.prpLclaimDtoList=QueryRelationResponseDto.prpLclaimDtoList;//立案
                            $scope.prpLRegistDtoList=QueryRelationResponseDto.prpLRegistDtoList;//报案
                            $scope.prpLPrepayDtoList=QueryRelationResponseDto.prpLPrepayDtoList;//预赔
                            $scope.prpLCompensateDtoList=QueryRelationResponseDto.prpLCompensateDtoList;//实赔
                        }else {
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: data.message,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            })
                        }

                    },
                    error:function(e){
                        options.error(e);
                    }
                });
            };

            $scope.showRelative= function () {
                $scope.showRelativeMessage=false;
            }
            //跳转投保单详情页面
            $scope.goProposalNoDetail=function(endorseNo) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposal3107edit',{
                    addEditExamine:'Examine',
                    proposalNo:endorseNo
                });
            };
            //跳转批单详情页面
            $scope.goPrpheadDetail=function(endorseNo) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIEndorse3107edit',{
                    editType:'show',
                    bizNo:endorseNo
                });
            };
            //跳转保单详情页面
            $scope.goPolicyNoDetail=function(policyNo){
                if(policyNo){
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $state.go('UIPolicy3107show',{'policyNo':policyNo});
                }

            };
            //跳转报案详情页面
            $scope.goRegistDetail=function(info){
                if(info.registNo){
                    $window.open($rootScope.frontEnd.prpallClaimUrl+"/claim/#/UIAgriRegist?authSystemFlag&editType=SHOW&registNo="+info.registNo+"&businessNo="+info.registNo+"&policyNo="+info.policyNo+'&riskCode='+info.riskCode)
                }

            };
            //跳转立案详情页面
            $scope.goClaimDetail=function(info){
                if(info.claimNo){
                    $window.open($rootScope.frontEnd.prpallClaimUrl+"/claim/#/UIAgriClaimSee?authSystemFlag&editType=SHOW&businessNo="+info.claimNo+"&registNo="+info.registNo)
                }

            };
            //跳转预赔详情页面
            $scope.goPreCompensateDetail=function(info){
                if(info.preCompensateNo){
                    $window.open($rootScope.frontEnd.prpallClaimUrl+"/claim/#/UIAgriPrepayHandle?authSystemFlag&editType=SHOW&businessNo="+info.preCompensateNo+"&registNo="+info.registNo+"&claimNo="+info.claimNo)
                }

            };
            //跳转实赔详情页面
            $scope.goCompensateDetail=function(info){
                if(info.compensateNo){
                    $window.open($rootScope.frontEnd.prpallClaimUrl+"/claim/#/UIAgriCompenstate?authSystemFlag&editType=SHOW&businessNo="+info.compensateNo)
                }

            };

            ////茬次信息需获得的保险期间方法
            //$scope.proposal.getDate=function(startDate,endDate){
            //    if(($scope.proposal.prpTmainDto.startDate==undefined||$scope.proposal.prpTmainDto.startDate==null||$scope.proposal.prpTmainDto.startDate=='')
            //        ||($scope.proposal.prpTmainDto.endDate==undefined||$scope.proposal.prpTmainDto.endDate==null||$scope.proposal.prpTmainDto.endDate=='')){
            //        return 1
            //    }
            //    var startDate1=parseInt($scope.proposal.prpTmainDto.startDate.replace(/-/g,""),10);
            //    var endDate1=parseInt($scope.proposal.prpTmainDto.endDate.replace(/-/g,""),10);
            //   if(startDate<startDate1||endDate>endDate1){
            //        return -1
            //   }
            //    return 0
            //}
        }]);
});