/**
 * Created by sen on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'jsonDB'
], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIEndorseSpecialCtrl', ['$rootScope', '$scope', '$modal','$$finder', '$http', '$filter', '$state','commonApiServ','$$code',
        function ($rootScope, $scope,$modal, $$finder, $http, $filter, $state,commonApiServ,$$code) {
            $scope.selectListData={};// 级联下拉列表数据
            $scope.queryListAll={};
            $scope.proposal = {};//查询条件的对象
            $scope.proposal.QueryList = {};//接口查询回来的
            /**
             * 转化时间戳为当前日期
             * @param target 时间戳
             * @param dateNum 当前时间+dateNum（默认为1天）
             * @returns {string}
             */
            $scope.getEndorseYear = function (target,dateNum) {
                var newDate = new Date();
                newDate.setTime(target);
                //默认获取批单生效时间+1
                if(dateNum){
                    newDate.setDate(newDate.getDate() + dateNum);
                }
                var year = newDate.toISOString();
                return year.substring(0,10);
            };

            /**
             * 当前日期转化为时间戳
             * @param stringTime 当前时间（2018-01-01）
             * @returns {number}
             */
            $scope.stampTime = function (stringTime) {
                return Date.parse(new Date(stringTime));
            };
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

            /**
             * 起始保单号连动终止保单号
             */
            $scope.queryResultsNo = function () {
                 $scope.endorse.policyNoEnd = $scope.endorse.policyNo;
            };
            $scope.changepolicyNo= function (policyNo) {
                if($scope.endorse.policyNo||$scope.endorse.policyNoEnd||$scope.endorse.policyEndStart||$scope.endorse.proposalNo){
                    $scope.endorse.startDate = '';//起保开始时间
                    $scope.endorse.startDateEnd = '';//起保开始时间
                    $scope.endorse.endDate ='';//终保时间
                    $scope.endorse.endStartDate = '';//终保时间间
                    $scope.endorse.operateDateStart ='';//制单开始日期
                    $scope.endorse.operateDateEnd ='';//制单截止日期
                    $scope.endorse.BusinessType1="";
                }else{
                    $scope.endorse.BusinessType1="01";
                    currentDate();
                }
            }
            /**
             * 起始日期带出终止日期
             */
           /* $scope.queryResultsDate = function () {

                $scope.endorse.endDate = $scope.addDate($scope.endorse.startDate,7);
            };*/

            /**
             * 制单日期起期带出制单日期止期
             */
            /*$scope.queryResultsOperateDate = function () {

                 $scope.endorse.operateDateEnd = $scope.addDate($scope.endorse.operateDateStart,7);
            };*/

            $scope.addDate = function (starDate,day) {
                //字符串"2019-01-01"转日期类型
                var isdate = new Date(starDate.replace(/-/g,"/"));
                //添加天数
                isdate = new Date((isdate/1000+(86400*day))*1000);
                //date 转 字符串
                return isdate.getFullYear()+"-"+(isdate.getMonth()+1)+"-"+(isdate.getDate());
            };

            /**
             * 日期对比
             * @param startTime 起始时间（2017-01-01）
             * @param endTime 终止时间 （2017-02-02）
             * @returns {boolean}
             */
            $scope.checkDate = function (startTime,endTime) {

                var startTime = new Date(Date.parse(startTime));
                var endTime = new Date(Date.parse(endTime));
                if(startTime <= endTime){
                    return true;
                }else {
                    layerMsg("终止日期不能大于起始日期！");
                    return false;
                }

            };

            /**
             * 校验提示信息
             * @param _formFocus
             */
            var formFocusPrompt = function (_formFocus) {
                var _nodeValue;
                if (_formFocus.attributes['warn-layer']) {
                    _nodeValue = _formFocus.attributes['warn-layer'].nodeValue;
                }else if($(_formFocus).parent()[0].attributes['warn-layer']){
                    _nodeValue = $(_formFocus).parent()[0].attributes['warn-layer'].nodeValue;
                }
                if(_nodeValue){
                    layerMsg(_nodeValue+"格式错误");
                    return false;
                }
                return true;
            };

            /**
             * 重置
             * 清除已输入的条件信息
             */
            $scope.reset = function () {

                $scope.endorse.BusinessType1="01";
                init();
            };
            $scope.reset1 = function () {
                $scope.endorse = {
                    "policyNo":"",//保单号
                    "policyNoEnd":"",//结束保单号
                    "proposalNo":"",//投保单号
                    "userCode":$rootScope.user.userCode,//用户代码
                    "loginComCode":$rootScope.user.loginComCode,//用户登录机构代码
                    "loginGradeCode":"111",//用户登录岗位代码
                    "tableName":"",//表名
                    "userCodeFields":"",//TODO userCode字段
                    "comCodeFields":"",//comCode字段
                    "riskCode":"",//TODO 险种代码
                    "appliCode":"",//投保人代码
                    "appliName":"",//投保人姓名
                    "insuredCode":"",//被保险人代码
                    "insuredName":"",//被保险人姓名
                    "sumAmount":"",//总保额
                    "sumPremium":"",//总保费
                    "comCode":"",//归属机构
                    "handlerCode":"",//业务员代码
                    "operatorCode":"",//操作员代码
                    "operateDateStart":"",//制单日期起期
                    "operateDateEnd":"",//制单日期止期
                    "startDate":"",//保险起期
                    "endDate":"",//保险止期
                    "endorType":"",
                    "validHour":"0",//
                    "validDate":"",
                    "queryFlag":"2",//1-保单列表查询，2-特殊批改保单列表查询
                    "underWriteFlag":"",//投保状态 0初始值,1通过,2不通过,3无需核保,9待核保
                    "pageNo":'1',//查询页码
                    "pageSize":'50'//查询每页数量
                };
                //currentDate();
                $scope.endorse.BusinessType1="01";
                $scope.paginationConfmm.totalItems=""
                $scope.queryResults ={}
            };
            /**
             * 特殊批改保单列表查询
             */
            $scope.querySpecial = function (target) {
              /*  //判断查询条件是否为空校验
                var querySpecialflag = false;
                //循环遍历表单下节点
                for(var i=0;i<document.myForm.elements.length-8;i++)
                {
                    if(document.myForm.elements[i].value!="")
                    {
                        querySpecialflag = true;
                    }
                }
                if (!querySpecialflag){
                    layerMsg("至少输入一个查询条件！");
                    return false;
                }*/
                if (!$scope.endorse.policyNo &&!$scope.endorse.policyNoEnd &&!$scope.endorse.policyEndStart &&!$scope.endorse.proposalNo &&!$scope.endorse.appliName &&!$scope.endorse.appliCode &&!$scope.endorse.insuredName
                    &&!$scope.endorse.insuredCode &&!$scope.endorse.sumAmount &&!$scope.endorse.sumPremium &&!$scope.endorse.comCode &&!$scope.endorse.handlerCode&&!$scope.endorse.operatorCode
                    &&!$scope.endorse.startDate &&!$scope.endorse.startDateEnd &&!$scope.endorse.endDate &&!$scope.endorse.endStartDate &&!$scope.endorse.operateDateStart&&!$scope.endorse.operateDateEnd&&!$scope.endorse.BusinessType1
                )
                {
                    layerMsg("至少输入一个查询条件！");
                    return false;
                }
                //保单号
                if($scope.endorse.policyNo){
                    var reg=/^\d+$/;
                    if(reg.test($scope.endorse.policyNo)){
                        if($scope.endorse.policyNo.length<15){
                            layerMsg("保单号码需输入至少15位数！");
                            return false;
                        }
                    }else{
                        layerMsg('保单号码格式错误，请修改!');
                        $scope.endorse.policyNo="";
                        return false;
                    }
                }
                if($scope.endorse.policyNoEnd){
                    var reg=/^\d+$/;
                    if(reg.test($scope.endorse.policyNoEnd)){
                        if($scope.endorse.policyNoEnd.length<15){
                            layerMsg("保单号码需输入至少15位数！");
                            return false;
                        }
                    }else{
                        layerMsg('保单号码格式错误，请修改!');
                        $scope.endorse.policyNoEnd="";
                        return false;
                    }
                }
                //保单号的处理
                if($scope.endorse.policyEndStart){
                    $scope.proposalText=$scope.endorse.policyEndStart;
                    $scope.proposalText= $scope.proposalText.split(",");
                    for(var i=0;i< $scope.proposalText.length;i++){
                        if( $scope.proposalText[i].length!==21){
                            layerMsg("保单号格式错误，请修改！");
                            return false;
                        }

                    }
                }
                if($scope.endorse.proposalNo){
                    var reg=/^\d+$/;
                    if(reg.test($scope.endorse.proposalNo)){
                        if($scope.endorse.proposalNo.length<15){
                            layerMsg("投保单号码需输入至少15位数！");
                            return false;
                        }
                    }else{
                        layerMsg('投保单号码格式错误，请修改!');
                        $scope.endorse.proposalNo="";
                        return false;
                    }
                }
                var proposalNoReg =/^\d{15,}$/;//至少15位数字
                var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉子
                var sumAmountRge=/^[0-9]+([.]{1}[0-9]+){0,1}$/;//数字
                var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                var comCodeReg=/(^[\u4E00-\u9FA5]+$)|(^[0-9]+$)/;
                if($scope.endorse.appliName&&!appliNameReg.test($scope.endorse.appliName)){
                    //投保人名称
                    layerMsg("投保人名称格式错误，请修改!");
                    $scope.endorse.appliName="";
                    return false;
                }
                if($scope.endorse.appliCode&&!appliCodeReg.test($scope.endorse.appliCode)){
                    //投保人代码
                    layerMsg("投保人代码格式错误，请修改!");
                    $scope.endorse.appliCode="";
                    return false;
                }
                if($scope.endorse.insuredCode&&!appliCodeReg.test($scope.endorse.insuredCode)){
                    //被保险人代码
                    layerMsg("被保人代码格式错误，请修改!");
                    $scope.endorse.insuredCode="";
                    return false;
                }
                if($scope.endorse.insuredName&&!appliNameReg.test($scope.endorse.insuredName)){
                    //被保险人名称
                    layerMsg("被保人名称格式错误，请修改!");
                    $scope.endorse.insuredName="";
                    return false;
                }
                if($scope.endorse.sumAmount&&!sumAmountRge.test($scope.endorse.sumAmount)){
                    //总保险金额
                    layerMsg("总保险金额格式错误，请修改!");
                    $scope.endorse.sumAmount="";
                    return false;
                }
                if($scope.endorse.sumPremium&&!sumAmountRge.test($scope.endorse.sumPremium)){
                    //总保险费
                    layerMsg("总保险费格式错误，请修改!");
                    $scope.endorse.sumPremium="";
                    return false;
                }
                /*if($scope.endorse.comCode&&!comCodeReg.test($scope.endorse.comCode)){
                    //归属机构
                    layerMsg("归属机构格式错误，请修改!");
                    $scope.endorse.comCode="";
                    return false;
                }*/
                if($scope.endorse.handlerCode&&!appliCodeReg.test($scope.endorse.handlerCode)){
                    //业务员代码
                    layerMsg("业务员代码格式错误，请修改!");
                    $scope.endorse.handlerCode="";
                    return false;
                }
                if($scope.endorse.operatorCodee&&!appliCodeReg.test($scope.endorse.operatorCode)){
                    //操作员代码
                    layerMsg("操作员代码格式错误，请修改!");
                    $scope.endorse.operatorCode="";
                    return false;
                }

                //制单日期起期于制单日期止期比较
                if($scope.endorse.operateDateStart && $scope.endorse.operateDateEnd){

                    if(!($scope.checkDate($scope.endorse.operateDateStart,$scope.endorse.operateDateEnd))){
                        layerMsg("制单日期止期不能早于制单日期起期");
                        return false;
                    }
                }
                //起保日期和终保日期比较
                if($scope.endorse.startDate && $scope.endorse.endDate){

                    if(!($scope.checkDate($scope.endorse.startDate,$scope.endorse.endDate))){
                        if(!($scope.checkDate($scope.endorse.operateDateStart,$scope.endorse.operateDateEnd))){
                            layerMsg("终保日期不能早于起保日期");
                            return false;
                        }
                    }
                }

                var ele;
                var Ele = $("[name=myForm] .ng-invalid:not(ng-form)");
                if (angular.isDefined(Ele[0])) {
                    if($scope.myForm.$valid){
                        //查询
                    }else {
                        if (Ele[0].nodeName == 'CODE-TYPE') {
                            ele = Ele[0].children[0].children[0].children[0];
                        } else if(Ele[0].nodeName == 'SELECT'){
                            ele = Ele[0];
                        } else if (Ele[0].nodeName == 'SELECT-LIST' || Ele[0].nodeName == 'select-list') {
                            ele = Ele[0].children[1]
                        } else {
                            ele = Ele[0];
                        }
                        if (angular.isDefined(ele)) {
                            return formFocusPrompt(Ele[0])
                        }
                    }

                }

                //查询保单列表信息
                //如果有保单号，投保单号则清空日期
                if( $scope.endorse.policyNoEnd || $scope.endorse.proposalNo || $scope.endorse.policyNo){
                    $scope.endorse.startDate = '';//起保日期
                    $scope.endorse.startDateEnd = '';//起保日期
                    $scope.endorse.endDate = '';//终保日期
                    $scope.endorse.endStartDate = '';//终保日期
                    $scope.endorse.operateDateStart = '';//制单日期起期
                    $scope.endorse.operateDateEnd = '';//制单日期止期
                }else{
                    if($scope.endorse.operateDateStart&&!$scope.endorse.operateDateEnd){
                        layerMsg("请输入制单止期！");
                        return false;
                    }else if(!$scope.endorse.operateDateStart&&$scope.endorse.operateDateEnd){
                        layerMsg("请输入制单起期！");
                        return false;
                    }
                }
                // //投保单不为空清空起保日期终保日期
                // if($scope.endorse.proposalNo){
                //     $scope.endorse.startDate = '';
                //     $scope.endorse.endDate = '';
                // }

                $rootScope.responseQueryPolicyListInfoDtoList={};
                $rootScope.endorseConditionDto={};
                var keywords = $scope.endorse;
                keywords.pageNo = $scope.paginationConfmm.currentPage;
                keywords.pageSize = $scope.paginationConfmm.itemsPerPage;
                keywords.policyNoRan=$scope.proposalText;
                $rootScope.endorseConditionDto=$scope.endorse;

                $$finder.find('queryPolicyListByConditon',
                    //入参数据
                    keywords,
                    {
                    success: function(data) {
                        if(data.code=="0000" && data.content.content.length>0){
                            console.log(data);
                            var list = data.content.content;
                            angular.forEach(list, function (_data) {
                            var strOthFlag = _data.othFlag;
                            if(strOthFlag.substr(3,1)!='2'){
                                if ( _data.underWriteFlag == '0' && strOthFlag.substr(0,1) == "0") {
                                    _data.othFlag = "普通新保"
                                }else if( _data.underWriteFlag == '0' && strOthFlag.substr(0,1) == "1"){
                                    _data.othFlag = "续保新保"
                                }else if( _data.underWriteFlag == '1'){
                                    _data.othFlag = "核保通过"
                                }else if( _data.underWriteFlag == '2' && strOthFlag.substr(3,1) != "3"){
                                    _data.othFlag = "核保打回"
                                }else if( _data.underWriteFlag == '2' && strOthFlag.substr(3,1) == "3"){
                                    _data.othFlag = "拒保"
                                }else if( _data.underWriteFlag == '3'){
                                    _data.othFlag = "自动核保"
                                }else if( _data.underWriteFlag == '9'){
                                    _data.othFlag = "待核保"
                                }else if(_data.underWriteFlag == '4'){
                                    _data.othFlag = "见费出单没收费"
                                }
                            }
                            if (strOthFlag.substr(3, 1) == "2") {
                                _data.othFlag = "已撤单"
                            }
                            if (strOthFlag.substr(3, 1) == "1") {
                                _data.othFlag = "已注销";
                            }
                            else if (strOthFlag.substr(2, 1) == "1") {
                                _data.othFlag = "全单退保";
                            }
                            if (strOthFlag.substr(4, 1) == "1") {
                                _data.othFlag = "已遗失";
                            }
                            if (strOthFlag.substr(4, 1) == "1") {
                                _data.othFlag = "已遗失";
                            }
                        });
                            //获取列表数据
                            $scope.queryResults = list;
                            //总条数
                            $scope.paginationConfmm.totalItems = data.content.totalCount || 0;

                            $rootScope.endorseConditionDto=$scope.endorse;


                        }else if(data.code=="9999"){
                            layer.open({
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '系统异常、请联系管理员！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.queryResults=[];
                            $scope.paginationConfmm.totalItems=0;
                        }
                        $scope.select_all="";
                    },
                    error: function(e) {
                        console.log(e)
                    }
                });
            };

            $scope.showOther=false;
            /**
             * 关闭弹框
             */
            $scope.closeModel = function () {
                $scope.eject=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            };
            /**
             * 下一步
             */
            var content1='';
            $scope.nextStep=function(){
                content1='';
                $scope.checkedqueryResults=[];
                angular.forEach($scope.queryResults, function (data) {
                    if(data.choosed){
                        $scope.checkedqueryResults.push(data);
                    }
                })
                $scope.policyNoList= [];
                for(var i=0;i<$scope.checkedqueryResults.length;i++){
                    $scope.policyNoList.push($scope.checkedqueryResults[i].policyNo)
                }
                $$finder.find('queryPrintNo',{
                    "policyNoList": $scope.policyNoList
                },{
                    success:function(data){
                        console.log(data.content);
                        if(data.content){
                            content1=data.content.message;

                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
                if($scope.checkedqueryResults.length<=0){
                    layerMsg("请选择要批改的保单");
                }else{
                    $scope.eject=true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }
                var dto={"codeType":"EndorType","riskCode":""}
                $$finder.find('initSelect',dto,{
                    success:function(data){
                        $scope.queryListAll=data.content.codeData;
                        $scope.value=$scope.queryListAll[0].codeCode;
                        $scope.queryList=$scope.queryListAll[0].codeName;
                    },
                    error:function (e){
                        options.error(e);
                    }
                });
            };

            //var dto={"prpDcodeListDtoList":[{"codeType":"EndorType","riskCode":""}]}
            //$$finder.find('getOptionCodeTwo',dto,{
            //
            //    success:function(data){
            //        $scope.queryList=data.content.prpDcodeListDtoList[0].prpDcodeDtoList;
            //        $scope.queryList=data.content.codeData;
            //        console.log($scope.queryList)
            //    },
            //    error:function (e){
            //        options.error(e);
            //    }
            //});

            //查询校验  blur事假校验
            $scope.check={};
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
            $scope.checkpolicyNo2= function ($event,str) {
                //保单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.policyNo2="保单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.policyNo2="保单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.policyNo2="";
                    }
                }else{
                    $scope.check.policyNo2="";
                }
            }
            $scope.checkpolicyEndStart= function ($event,str) {

               if(str){
                   $scope.proposalText=$scope.endorse.policyEndStart;
                   $scope.proposalText= $scope.proposalText.split(",");
                   for(var i=0;i< $scope.proposalText.length;i++){
                       if( $scope.proposalText[i].length!==21){
                           $scope.check.policyEndStart="保单号格式错误，请修改！";
                           $event.target.focus();
                           return
                       }else{
                           $scope.check.policyEndStart="";
                       }

                   }
               }else{
                   $scope.check.policyEndStart="";
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
            $scope.checkproposalNo= function ($event,str) {
                //投保单号码
                if(str){
                    var reg=/^\d+$/;
                    if(!reg.test(str)){
                        $scope.check.proposalNo="投保单号码格式错误，请修改！";
                        $event.target.focus();
                    }else if(str.length<15){
                        $scope.check.proposalNo="投保单号码需输入至少15位数！";
                        $event.target.focus();
                    }else{
                        $scope.check.proposalNo="";
                    }
                }else{
                    $scope.check.proposalNo="";
                }
            }
            $scope.checksumAmount= function ($event,str) {
                //总保险金额
                var sumAmountReg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
                if(str&&!sumAmountReg.test(str)){
                    $scope.check.sumAmount="总保险金额格式从错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.sumAmount="";
                }
            }
            $scope.checksumPremium= function ($event,str) {
                //总保险费
                var sumPremiumReg=/^[0-9]+([.]{1}[0-9]+){0,1}$/;
                if(str&&!sumPremiumReg.test(str)){
                    $scope.check.sumPremium="总保险费格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.sumPremium="";
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
            //批改类型单选按钮切换
            $scope.changeSpecialTypeFlag=0;
            $scope.changeSpecialType= function (value,$event,index) {
                if($scope.changeSpecialTypeFlag==index){
                    $event.target.checked=false;
                    $scope.changeSpecialTypeFlag=-1;
                    $scope.codeCode="9999";
                }else{
                    $scope.changeSpecialTypeFlag=index;
                    $scope.codeCode=value.codeCode;
                }
            }
            /**
             * 选择批改类型 点击确定方法
             */
            $scope.codeCode="";
            $scope.checked=function(value){
                $scope.codeCode=value.codeCode;
            }
            $scope.printSure=function(){
                if(content1!=""&&$scope.codeCode!='92'&&$scope.codeCode!='19'){
                    layer.open({
                        //offset: ['32%', '34%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content1,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return false;
                }
                if(!$scope.codeCode){
                    $scope.checked($scope.queryListAll[0]);
                }

                console.log($scope.codeCode);
                if(!$scope.codeCode||$scope.codeCode=='9999'){
                    layerMsg("请选择批改类型");
                    return false;
                }
                //判断是不是商业
                var content="";
                angular.forEach($scope.queryResults,function (data) {
                  if(data.businessType1=='00'&&$scope.codeCode=='71'){
                      content="商业性保单不可调整补贴信息！"
                  }else if(data.isSeeFeeFlag=='0'&&$scope.codeCode=='92'){
                      content="此险种是非见费出单！"
                  }
                    if(content!=""){
                        layer.open({
                            //offset: ['35%', '40%'],
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
                        return false;
                    }
                });

                if(content!=""){
                    return false;
                }


                var selected = false;
                var endorse = {};

                $.each($scope.queryResults,function (index,val) {
                    if (val.choosed){
                        endorse.policy = val;
                        selected = true;
                        return false;
                    }
                });
                endorse.policy=$scope.checkedqueryResults;//获取所有选中的批单
                //获取当前时间并处理
                var nowDate=$filter("date")(new Date(),"yyyy-MM-dd");
                nowDate=parseInt(nowDate.replace(/[-]/ig,""));
                /* $.each($scope.queryResults,function (index,val) {
                     if (val.choosed){
                         endorse.policy = val;
                         selected = true;
                         return false;
                     }
                 });*/
                switch ($scope.codeCode){
                    case "01"://变更保险期限
                        //判断是否终保  及所有选中的批单是否是同一个
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layer.open({
                                //offset: ['40%', '26%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: "您所选保单中含有已终保保单，不可进行批改操作，请重新选择！",
                                btn: ['确定'],
                                btn1: function (index) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });

                            //layerMsg("您所选保单中如下保单已终保，不可进行批改操作，请重新选择！保单为："+str);
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        var starList=[];
                        var starDate=$scope.checkedqueryResults[0].startDate;
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            if(starDate!==$scope.checkedqueryResults[i].startDate){
                                starList.push($scope.checkedqueryResults[i].policyNo)
                            }
                        }
                       if(starList.length>0){
                            var str2="";
                            for(var j=0;j<starList.length;j++){
                                str2+="\n"+starList[j];
                            }
                            layerMsg("您所选保单中含有起保日期不一致保单，不可统一进行变更保险期限操作，请重新选择！")
                            $scope.closeModel();
                           selected=false;
                           return;
                       }else{
                            selected=true;
                        }
                        break;
                    case "19"://保单注销
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "92"://见费出单保险注销
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "11"://费率
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "91"://保额
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "71"://补贴信息
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "21"://补贴信息
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;
                    case "85"://业务员批改
                        var endList=[];
                        for(var i=0;i<$scope.checkedqueryResults.length;i++){
                            var endDate=parseInt($scope.checkedqueryResults[i].endDate.replace(/[-]/ig,""));
                            if(endDate<nowDate){
                                endList.push($scope.checkedqueryResults[i].policyNo);
                            }
                        }
                        if(endList.length>0){
                            var str="";
                            for(var j=0;j<endList.length;j++){
                                str+="\n"+endList[j];
                            }
                            layerMsg("您所选保单中含有已终保保单，不可进行批改操作，请重新选择！");
                            selected=false;
                            $scope.closeModel();
                            return
                        }
                        break;


                }


                $rootScope.responseQueryPolicyListInfoDtoList=$scope.checkedqueryResults;
                var stateType ='';
                if (selected){
                    if($scope.codeCode=='01'){//变更保险期限
                        endorse.endorseType = 'UIEndorseAgriculturalUpdate';
                         stateType = 'UIEndorseAgriculturalUpdate';
                    }
                    if($scope.codeCode=='21'){//全单退保
                        endorse.endorseType = 'UIEndorseFullSurrender';
                         stateType = 'UIEndorseFullSurrender';
                    }
                    if($scope.codeCode=='19'){//保单注销
                        endorse.endorseType = 'UIEndorseCancellationPolicy';
                         stateType = 'UIEndorseCancellationPolicy';
                    }
                    if($scope.codeCode=='92'){//见费出单保单注销
                        endorse.endorseType = 'UIEndorseeExpenseCancelPolicy';
                         stateType = 'UIEndorseeExpenseCancelPolicy';
                    }
                    if($scope.codeCode=='11'){//调整费率
                        endorse.endorseType = 'UIEndorseAdjustRate';
                         stateType = 'UIEndorseAdjustRate';
                    }
                    if($scope.codeCode=='71'){//调整补贴信息
                        endorse.endorseType = 'UIEndorseAdjustSubsidy';
                         stateType = 'UIEndorseAdjustSubsidy';
                    }
                    if($scope.codeCode=='91'){//调整单位保额
                        endorse.endorseType = 'UIEndorseAdjustUnitInsured';
                         stateType = 'UIEndorseAdjustUnitInsured';
                    }
                    if($scope.codeCode=='85'){//业务员批改
                        endorse.endorseType = 'UIEndorsehandler1Code';
                        stateType = 'UIEndorsehandler1Code';
                    }
                    $scope.endorse.endorType=$scope.codeCode;
                    if(!(['UIEndorseFullSurrender','UIEndorseCancellationPolicy','UIEndorseeExpenseCancelPolicy'].indexOf(stateType)>-1)){
                        stateType = "UIEndorseAgriculturalUpdate";
                    }
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $state.go(stateType,{endorse:JSON.stringify(endorse)});
                }
            };
            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.queryResults,function(data){
                        data.choosed=true;
                        $scope.checked1.push (data.policyNo);
                    })
                } else {
                    angular.forEach($scope.queryResults,function(data){
                        data.choosed=false;
                        $scope.checked1 = [];
                    })
                }
            }
            //单选，反选
            $scope.selectOne=function(){
                angular.forEach($scope.queryResults , function (data) {
                    var index = $scope.checked1.indexOf(data.policyNo);
                    if(data.choosed && index === -1) {
                        $scope.checked1.push(data.policyNo);
                    } else if (!data.choosed && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.queryResults.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }
            /**
             * 单选监听
             * @param _pilicy 保单对象
             */
          /*  $scope.checkListener = function (_policy) {
                $.each($scope.queryResults,function (index,val) {
                   if(val.policyNo == _policy.policyNo ){
                       $scope.queryResults[index].choosed = true;
                   }else{
                       val.choosed = false;
                   }
                });
            };*/

            /**
             * 分页初始化 by sunyaohui
             */
            var initPage2 = function() {
                $scope.paginationConfmm = {
                    numberOfPages:1,
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {//如果当前页有变动
                        if ($scope.paginationConfmm.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {
                            //查询保单列表信息

                            var keywords = angular.copy($scope.endorse);
                            if($scope.endorse.policyEndStart){
                                $scope.proposalText=$scope.endorse.policyEndStart;
                                $scope.proposalText= $scope.proposalText.split(",");
                            }
                            keywords.pageNo = $scope.paginationConfmm.currentPage;
                            keywords.pageSize = $scope.paginationConfmm.itemsPerPage;
                            keywords.policyNoRan=$scope.proposalText;
                            $$finder.find('queryPolicyListByConditon',
                                //入参数据
                                keywords,
                                {
                                    success: function(data) {
                                        $scope.querySpecial('myForm')
                                    },
                                    error: function(e) {
                                        console.log(e)
                                    }
                                });
                        }
                    }
                };
            };

            /**
             * 初始化信息
             */
            var init = function () {
                //查询条件显示开关
                $scope.showOther=false;
                //初始化调用分页条件
                initPage2();
                //保单查询初始化

                $scope.endorse = {
                    "policyNo":"",//保单号
                    "policyNoEnd":"",//结束保单号
                    "proposalNo":"",//投保单号
                    "userCode":$rootScope.user.userCode,//用户代码
                    "loginComCode":$rootScope.user.loginComCode,//用户登录机构代码
                    "loginGradeCode":"111",//用户登录岗位代码
                    "tableName":"",//表名
                    "userCodeFields":"",//TODO userCode字段
                    "comCodeFields":"",//comCode字段
                    "riskCode":"",//TODO 险种代码
                    "appliCode":"",//投保人代码
                    "appliName":"",//投保人姓名
                    "insuredCode":"",//被保险人代码
                    "insuredName":"",//被保险人姓名
                    "sumAmount":"",//总保额
                    "sumPremium":"",//总保费
                    "comCode":"",//归属机构
                    "handlerCode":"",//业务员代码
                    "operatorCode":"",//操作员代码
                    "operateDateStart":"",//制单日期起期
                    "operateDateEnd":"",//制单日期止期
                    "startDate":"",//保险起期
                    "endDate":"",//保险止期
                    "endorType":"",
                    "validHour":"0",//
                    "validDate":"",
                    "queryFlag":"2",//1-保单列表查询，2-特殊批改保单列表查询
                    "underWriteFlag":"",//投保状态 0初始值,1通过,2不通过,3无需核保,9待核保
                    "pageNo":'1',//查询页码
                    "pageSize":'50'//查询每页数量
                };
                //currentDate();
            };




            Window.prototype.layerMsg = function(data,target){
                // var icon = target == 'success'?"1":target == 'error'?"2":"0";
                layer.open({
                    //offset: ['40%', '40%'],
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    scrollbar: false,
                    title: '温馨提示',
                    content: data,
                    btn: ['确定'],
                    btn1: function (index) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });

            };

            /**
             * 获取当前日期
             */
            var currentDate = function () {
                // 获取当前时间
                var newDate = new Date();
                // 获取当前时间每月1号
                var startDate = newDate;
                // 制单日期止期
                $scope.endorse.operateDateEnd = newDate.toISOString().substring(0,10);
                //起保止期
                $scope.endorse.startDateEnd = startDate.toISOString().substring(0,10);
                startDate.setDate(1);
                // 起始日期
                $scope.endorse.startDate = startDate.toISOString().substring(0,10);
                // 制单日期起期
                $scope.endorse.operateDateStart = startDate.toISOString().substring(0,10);
                //
                startDate.setFullYear(startDate.getFullYear()+1);
                // 保险起期
                $scope.endorse.endDate = startDate.toISOString().substring(0,10);

                startDate.setDate(new Date().getDate());
                //保险止期
                $scope.endorse.endStartDate = startDate.toISOString().substring(0,10);
            };
            init();
            window.onload= function () {

            }
            $("input[name='type']").eq(0).attr("checked","checked");
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
        //   日期比较
            $scope.queryResultsDate= function (startData,endData,type) {
                var content="";
                if(type=="起保日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="起保日期的起期不能大于止期！";
                        // 获取当前时间
                        var newDate = new Date();
                        // 获取当前时间每月1号
                        var startDate = newDate;

                        //起保止期
                        $scope.endorse.startDateEnd = startDate.toISOString().substring(0,10);
                        startDate.setDate(1);
                        // 起始日期
                        $scope.endorse.startDate = startDate.toISOString().substring(0,10);
                    }
                }else if(type=="终保日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="终保日期的起期不能大于止期！";
                        // 获取当前时间
                        var newDate = new Date();
                        // 获取当前时间每月1号
                        var startDate = newDate;
                        startDate.setDate(1);
                        startDate.setFullYear(startDate.getFullYear()+1);
                        // 保险起期
                        $scope.endorse.endDate = startDate.toISOString().substring(0,10);

                        startDate.setDate(new Date().getDate());
                        //保险止期
                        $scope.endorse.endStartDate = startDate.toISOString().substring(0,10);
                    }
                }else if(type=="制单日期"){
                    if(commonApiServ.compareFullDate(startData,endData)==1){
                        content="制单日期的起期不能大于止期！";
                        // 获取当前时间
                        var newDate = new Date();
                        // 获取当前时间每月1号
                        var startDate = newDate;
                        // 制单日期止期
                        $scope.endorse.operateDateEnd = newDate.toISOString().substring(0,10);
                        startDate.setDate(1);
                        // 制单日期起期
                        $scope.endorse.operateDateStart = startDate.toISOString().substring(0,10);
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
        }]);
});