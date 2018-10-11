/**
 * Created by sen on 2017/11/17.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnCustomerCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state', 'commonApiServ',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,commonApiServ) {
            //提交查询信息
            $scope.totalItems=0;
            $scope.proposal={};
            $scope.proposal.customer={};
            $scope.proposal.customerType={};
            $scope.proposal.customerIdv={}
            //投保人新增客户页面中个人按钮的样式切换
            $scope.show=true;
            $scope.proposal.customerType = 1;
            $scope.organizationBtn = function(m){
                $scope.show= m;
                if(m==true){//如果是true
                    $scope.proposal.customerType = 1;//这个类型是个人
                }else{
                    $scope.proposal.customerType = 2;//这个类型是组织
                }
            };
            $scope.submit=function() {
                if(($scope.proposal.customer.identifyNumber==null||$scope.proposal.customer.identifyNumber=='')&&
                    ($scope.proposal.customer.customerCname==null||$scope.proposal.customer.customerCname=='')&&
                    ($scope.proposal.customer.customerCode==null ||$scope.proposal.customer.customerCode=='')&&
                    ($scope.proposal.customer.customerType==null ||$scope.proposal.customer.customerType=='')&&
                    ($scope.proposal.customer.identifyType==null ||$scope.proposal.customer.identifyType=='')){
                    layer.open({
                        scrollbar: false,
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '至少输入一个查询条件！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    return
                }
                if($scope.isNum($scope.proposal.customer.customerCode)==false){
                    return
                }
                if($scope.isChinese($scope.proposal.customer.customerCname)==false){
                    return
                }
                if($scope.isNum2($scope.proposal.customer.identifyNumber)==false){
                    return
                }
                $$finder.find('customer',{
                    "customerType":$scope.proposal.customer.customerType,
                    "identifyNumber":$scope.proposal.customer.identifyNumber,
                    "socialcode":$scope.proposal.customer.identifyNumber,
                    "customerCName":$scope.proposal.customer.customerCname,
                    "customerCode":$scope.proposal.customer.customerCode,
                    "identifyType":$scope.proposal.customer.identifyType,
                    "pageNo":$scope.paginationConfmm.currentPage,
                    "pageSize":$scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if(data.code=="0000"&&data.content.content.length>0){
                            $scope.proposal.customerQueryList=data.content.content;
                            if($scope.proposal.customer.customerType==1){
                                $scope.proposal.customerType='个人';
                            }else{
                                $scope.proposal.customerType='单位';
                            }
                            //$scope.cpproposal.prpTmain=$scope.proposal.prpTmain;
                            //$scope.totalItems=$scope.cpproposal.prpTmain.customerQueryList.length;
                            //查询结果条数
                            $scope.paginationConfmm.totalItems = data.content.totalCount;
                        }else if(data.code=="9999"){
                            layer.open({
                                scrollbar: false,
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '系统异常、请联系管理员！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.proposal.customerQueryList=[];
                            $scope.paginationConfmm.totalItems=0;
                        }
                        $scope.select_all="";
                    },
                    error: function (e) {
                        options.error(e);
                    }});

            }
            //获取后台数据
            //$scope.proposal={};
            //$scope.cpproposal={};
            //$$finder.find('customer',{}, {
            //    success: function (data) {
            //        $scope.proposal.prpTmain=data.data.proposal.prpTmain;
            //        $scope.cpproposal.prpTmain=$scope.proposal.prpTmain;
            //        $scope.cpproposal.prpTmain.customerQueryList={};
            //    },
            //    error: function (e) {
            //        options.error(e);
            //    }
            //});
            //获取投保单信息
            $scope.customerQueryList=function(){}
            //重置表单
            $scope.reset=function(){
                $scope.proposal.customer={};
                $scope.proposal.customer.customerType='1';
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.customerQueryList ={}
                //$scope.endorse.prpPhead.policyNoSign="";
                //$scope.proposal.prpTmain={};
                /* $scope.$apply();
                 $scope.proposal.prpTmain.underWriteFlag=$scope.cpproposal.prpTmain.underWriteFlag;
                 $scope.proposal.prpTmain.BusinessType1=$scope.cpproposal.prpTmain.BusinessType1;*/
            }
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange:function(){
                        if($scope.paginationConfmm.totalItems==0||!$scope.paginationConfmm.totalItems){
                            return;
                        }else {
                            $scope.submit();
                        }
                    }
                };
            };
            initPage2();
            $scope.paginationConfmm.totalItems =  $scope.totalItems;
            if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
                $scope.paginationConfmm.totalItems=0;
            }
            $scope.checked1 = [];
            $scope.selectOne=function(){
                angular.forEach($scope.proposal.prpTmain.customerQueryList , function (info) {
                    var index = $scope.checked1.indexOf(info.id);
                    if(info.checked && index === -1) {
                        $scope.checked1.push(info.id);
                    } else if (!info.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.proposal.prpTmain.customerQueryList.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }

            //客户密码设置弹层弹出
            $scope.configPrintSetShow = false;
            $scope.configPrintSet = function() {
                $scope.configPrintSetShow = !$scope.configPrintSetShow;
                if($scope.configPrintSetShow==true){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else{
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }

            };
            //点击“保存”按钮，弹出内容
            $scope.message2 = function () {
                $scope.saveTemporaryDisabled=false;
                //客户代码校验
                if($scope.proposal.customerIdv.customerCode!=null&&$scope.proposal.customerIdv.customerCode!=''){
                    if($scope.isNum($scope.proposal.customerIdv.customerCode)==false){
                        return
                    }
                }else{
                    layer.open({
                        scrollbar: false,
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请输入客户代码！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    return
                }
                //证件号码校验
                if(($scope.proposal.customerIdv.identifyNumber!=null && $scope.proposal.customerIdv.identifyNumber!='')
                    || ($scope.proposal.customerIdv.organizeCode!=null && $scope.proposal.customerIdv.organizeCode!='')){
                    if($scope.proposal.customerIdv.customerKind=='1'){
                        if($scope.isNumber2($scope.proposal.customerIdv.identifyNumber)==false){
                            return
                        }
                    }else if($scope.proposal.customerIdv.customerKind=='2'){
                        if($scope.isNumber2($scope.proposal.customerIdv.organizeCode)==false){
                            return
                        }
                    }
                }

                //邮政编码
                if($scope.proposal.customerIdv.postCode!=null && $scope.proposal.customerIdv.postCode!=''){
                    var reg =  /^[0-9]*$/;
                    if(!reg.test($scope.proposal.customerIdv.postCode)){
                        $scope.tishi("邮编格式错误，请修改！")
                        return
                    }else{
                        if($scope.proposal.customerIdv.postCode.length>6||$scope.proposal.customerIdv.postCode.length<6){
                            $scope.tishi("邮编长度为6，请修改！")
                            return
                        }
                    }
                }

                //客户名称校验
                if($scope.proposal.customerIdv.customerCName!=null && $scope.proposal.customerIdv.customerCName!=''){
                    if($scope.isChinese($scope.proposal.customerIdv.customerCName)==false){
                        return
                    }
                }
                //中文格式校验
                var reg = /^[\u4E00-\u9FA5]+$/;
                if($scope.proposal.customerIdv.comType!=null && $scope.proposal.customerIdv.comType!=''){
                    if(!reg.test($scope.proposal.customerIdv.comType)){
                        $scope.tishi("公司性质格式错误，请修改！")
                        return
                    }
                }

                var addr=/^[(\u4e00-\u9fa5)|(0-9)]+$/
                if($scope.proposal.customerIdv.addressCName != null && $scope.proposal.customerIdv.addressCName!=''){
                    if(!addr.test($scope.proposal.customerIdv.addressCName)){
                        $scope.tishi("客户地址格式错误，请修改！")
                        return
                    }
                }
                if($scope.proposal.customerIdv.customerKind=='2'){
                    if($scope.proposal.customerIdv.linkAddress!=null && $scope.proposal.customerIdv.linkAddress!=''){
                        if(!addr.test($scope.proposal.customerIdv.linkAddress)){
                            $scope.tishi("通讯地址格式错误，请修改！")
                            return
                        }
                    }
                }
                if($scope.proposal.customerIdv.nationality != null && $scope.proposal.customerIdv.nationality!=''){
                    if(!reg.test($scope.proposal.customerIdv.nationality)){
                        $scope.tishi("国籍格式错误，请修改！")
                        return
                    }
                }

                if($scope.proposal.customerIdv.jobTitle!=null && $scope.proposal.customerIdv.jobTitle!=''){
                    if(!reg.test($scope.proposal.customerIdv.jobTitle)){
                        $scope.tishi("职业名称格式错误，请修改！")
                        return
                    }
                }
                //营业执照校验
                if($scope.proposal.customerIdv.customerKind=='2') {
                    if ($scope.proposal.customerIdv.businessLicenceNo != null && $scope.proposal.customerIdv.businessLicenceNo != '') {
                        var reg1 = /^(?:(?![IOZSV])[\dA-Z]){2}\d{6}(?:(?![IOZSV])[\dA-Z]){10}$/;
                        if (!reg1.test($scope.proposal.customerIdv.businessLicenceNo)) {
                            $scope.tishi("营业执照格式错误，请修改！")
                            return
                        }
                    }
                }

                var reg2 = /^[0-9]{15,}$/
                if($scope.proposal.customerIdv.customerKind=='2') {
                    if ($scope.proposal.customerIdv.revenueCode != null && $scope.proposal.customerIdv.revenueCode != '') {
                        if (!reg2.test($scope.proposal.customerIdv.revenueCode)) {
                            $scope.tishi("税务登记证格式错误，请修改！")
                            return
                        }
                    }
                }
                if($scope.proposal.customerIdv.customerKind=='2') {
                    if ($scope.proposal.customerIdv.otherCodeNo != null && $scope.proposal.customerIdv.otherCodeNo != '') {
                        if (!reg2.test($scope.proposal.customerIdv.otherCodeNo)) {
                            $scope.tishi("其他证件号码格式错误，请修改！")
                            return
                        }
                    }
                }

                $$finder.find('saveByCustomerRiskLevel', {
                    "customerCode":$scope.proposal.customerIdv.customerCode,//客户代码
                    "customerKind":$scope.proposal.customerIdv.customerKind,//客户类型
                    "identifyNumber":$scope.proposal.customerIdv.identifyNumber,//证件号码
                    "sex":$scope.proposal.customerIdv.sex,//性别
                    "jobTitle":$scope.proposal.customerIdv.jobTitle,//职称
                    "postCode":$scope.proposal.customerIdv.postCode,//邮编
                    "isCareClaim":$scope.proposal.customerIdv.isCareClaim,//客户是否关注审计、理赔、退保信息
                    "comCode":$scope.proposal.customerIdv.comCode,//归属机构
                    "inputDate":$scope.proposal.customerIdv.inputDate,//输入日期可
                    "update_Date":$scope.proposal.customerIdv.update_Date,//修改日期
                    "customerCName":$scope.proposal.customerIdv.customerCName,//客户名称
                    "identifyType":$scope.proposal.customerIdv.identifyType,//客户类型
                    "validPeriod3":$scope.proposal.customerIdv.validPeriod3,//证件有效期
                    "nationality":$scope.proposal.customerIdv.nationality,//国籍
                    "addressCName":$scope.proposal.customerIdv.addressCName,//客户地址
                    "riskLevel":$scope.proposal.customerIdv.riskLevel,//客户风险等级
                    "cashFocus":$scope.proposal.customerIdv.cashFocus,//行业现金密度
                    "operatorCode":$scope.proposal.customerIdv.operatorCode,//操作员代码
                    "updaterCode":$scope.proposal.customerIdv.updaterCode,//最后修改人
                    "validStatus":$scope.proposal.customerIdv.validStatus,//状态
                    "comType":$scope.proposal.customerIdv.comType,//公司性质
                    "linkAddress":$scope.proposal.customerIdv.linkAddress,//通讯地址
                    "businessLicenceNo":$scope.proposal.customerIdv.businessLicenceNo,//营业执照
                    "businessLicenceValidPeriod":$scope.proposal.customerIdv.businessLicenceValidPeriod,//营业执照到期日
                    "revenueCode":$scope.proposal.customerIdv.revenueCode,//税务登记证
                    "revenuePeriod":$scope.proposal.customerIdv.revenuePeriod,//税务登记证到期时间
                    "otherCodeNo":$scope.proposal.customerIdv.otherCodeNo,//其他证件号码
                    "otherCodeValidPeriod":$scope.proposal.customerIdv.otherCodeValidPeriod,//其他证件有效期
                    "organizeCode":$scope.proposal.customerIdv.organizeCode,
                }, {
                    success: function (data) {
                        $scope.saveTemporaryDisabled=true;
                        if(data.content.message=="success"){
                            $scope.configPrintSet2()
                            layer.open({
                                scrollbar: false,
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '保存成功！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                    $scope.saveTemporaryDisabled=false;
                                },
                            })
                            $scope.submit();
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //设置客户风险等级--弹层展示
            $scope.consoleShow = false;
            $scope.configPrintSet2 = function() {
                $scope.saveTemporaryDisabled=false;
                $scope.consoleShow = !$scope.consoleShow;
                if($scope.consoleShow==true){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else {
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }
            };
            //客户密码设置页面点击“重置”按钮提示信息
            $scope.message= function () {
                $scope.proposal.customer.password1="";
                $scope.proposal.customer.password2="";
            }
            //客户密码设置页面点击“确定”按钮提示信息
            $scope.sendmessage = function(){
                var psdReg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                if(psdReg.test($scope.proposal.customer.password1)&&($scope.proposal.customer.password1===$scope.proposal.customer.password2)){
                   /* $$finder.find('savaPassword',{
                        "customerCode":$scope.proposal.customer.customerCode1,
                        "password":$scope.proposal.customer.password1
                    }, {
                        success: function (data) {
                            console.log(data);
                            if(data.content.message==success){
                                alert("客户密码设置成功！");
                            }
                        }
                    });*/
                    $scope.configPrintSet();
                }

                //if($scope.confirmPassword($scope.proposal.customer.password1,$scope.proposal.customer.password2)==false){
                //
                //}
                //$$finder.find('savaPassword',{
                //    "customerCode":$scope.proposal.customer.customerCode1,
                //    "password":$scope.proposal.customer.password1,
                //}, {
                //    success: function (data) {
                //
                //        if(data.content.message==success){
                //            alert("客户密码设置成功！");
                //        }
                //    },
                //    error: function (e) {
                //        options.error(e);
                //    }
                ////});
                //alert("客户密码设置成功！");

            }

            $scope.check={};

            //客户代码校验
            $scope.isNum=function(code) {
                var customerCodeReg = /^[^\u4e00-\u9fa5]{0,}$/;//不能输入汉字
                if (code != null && code != '') {
                    if (!customerCodeReg.test(code)) {
                        layer.open({
                            scrollbar: false,
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '客户代码格式错误，请修改!',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        });
                        $scope.proposal.customer.customerCode="";
                        return false
                    }
                }
                return true

            }
            $scope.checkcustomerCode= function ($event,str,index) {
                var customerCodeReg = /^[^\u4e00-\u9fa5]{0,}$/;//不能输入汉字
                if(index=='1'){

                    if(str&&!customerCodeReg.test(str)){
                        $scope.check.customerCode="客户代码格式错误，请修改！";
                        $event.target.focus();
                    }
                    else{
                        $scope.check.customerCode="";
                    }
                }else if(index=='2'){

                    if(str){
                        var customerCodeReg = /^[^\u4e00-\u9fa5]{0,}$/;//不能输入汉字
                        if(!customerCodeReg.test(str)){
                            $scope.check.customerCode1="客户代码格式错误，请修改！";
                            $event.target.focus();
                        }else{
                            $scope.check.customerCode1="";
                        }
                    }
                    else{
                        $scope.check.customerCode1="";
                    }
                }
            }
            $scope.tishi= function (txt) {
                layer.open({
                    scrollbar: false,
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    content: txt,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    },
                });
            }

            //证件号码校验
            $scope.isNum2=function(code){
                if($scope.proposal.customer.identifyNumber){
                    var x=$scope.proposal.customer.identifyType;
                    console.log(x);
                    switch (x){
                        case "01"://身份证
                            var idReg=/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                            if($scope.proposal.customer.identifyNumber&&!idReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("身份证号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "02"://户口薄
                            var hukouReg=/^[a-zA-Z0-9]{3,21}$/;
                            if($scope.proposal.customer.identifyNumber&&!hukouReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("户口薄号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "03"://护照
                            var huzhaoReg=/^[a-zA-Z0-9]{3,21}$/;
                            if($scope.proposal.customer.identifyNumber&&!huzhaoReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("护照号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "04"://军官证
                            var junguanReg=/^军[0-9]{7}$/;
                            if($scope.proposal.customer.identifyNumber&&!junguanReg.test($scope.proposal.customer.identifyNumber)) {
                                $scope.tishi("军官证号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber = "";
                                return false;
                            }
                            break;
                        case "05"://驾驶执照
                            var jiashiReg=/\d{18}/g;
                            if($scope.proposal.customer.identifyNumber&&!jiashiReg.test($scope.proposal.customer.identifyNumber)) {
                                $scope.tishi("驾驶执照号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber = "";
                                return false;
                            }
                            break;
                        case "06"://返乡证
                            var backReg=/[a-zA-z]{1}\d{11}/g;
                            if($scope.proposal.customer.identifyNumber&&!backReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("返乡证号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "26"://外国人永久居住证
                            var outerReg=/[a-zA-z]{3}\d{12}/g;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("驾外国人永久居留身份证号码格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "59"://返乡证
                            var outerReg=/^[0-9]{15,}$/;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("其他证件号格式不正确，请修改!");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                        case "61"://组织机构代码
                            var outerReg=/^[a-zA-Z0-9]{8}-[a-zA-Z0-9]/;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("组织机构代码证证件号格式不正确，请修改！");
                                $scope.proposal.customer.identifyNumber="";
                                return false
                            }
                            break;
                        case "62"://税务登记证
                            var outerReg=/^\d{15}/;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("税务登记证证件号格式不正确，请修改！");
                                $scope.proposal.customer.identifyNumber="";
                                return false
                            }
                            break;
                        case "63"://工商登记证
                            var outerReg=/^[0-9]{15,}$/;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("工商登记证证件号格式不正确，请修改！");
                                $scope.proposal.customer.identifyNumber="";
                                return false
                            }
                            break;
                        case "64"://统一社会信用代码登记证
                            var outerReg=/[^_IOZSVa-z\W]{2}\d{6}[^_IOZSVa-z\W]{10}/g;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("统一社会信用代码登记证证件号格式不正确，请修改！");
                                $scope.proposal.customer.identifyNumber="";
                                return false
                            }
                            break;
                        case "99"://其他
                            var outerReg=/^[0-9]{15,}$/;
                            if($scope.proposal.customer.identifyNumber&&!outerReg.test($scope.proposal.customer.identifyNumber)){
                                $scope.tishi("其他证件号格式不正确，请修改！");
                                $scope.proposal.customer.identifyNumber="";
                                return false;
                            }
                            break;
                    }
                }else{
                    return true;
                }

            }

            $scope.checkidentifyNumber= function ($event,str) {
                var x=$scope.proposal.customer.identifyType;
                switch (x){
                    case "01"://身份证
                        if(str){
                            if(!commonApiServ.IdCardValidate(str)){
                                $scope.check.identifyNumber="身份证号码格式不正确，请修改！";
                                $event.target.focus();
                            }else{
                                $scope.check.identifyNumber="";
                            }
                        }else{
                            $scope.check.identifyNumber="";
                        }
                        break;
                }
            }

            //客户名称校验
            $scope.isChinese=function(code){
                var reg=/^[\u4E00-\u9FFF()（）]+$/;
                if(code != null && code != ''){
                    if(!reg.test(code)){
                        layer.open({
                            scrollbar: false,
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '客户姓名格式错误，请修改!',
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
            }
            $scope.checked= function ($event,str,index) {
                var customerCnameReg = /^[\u4E00-\u9FA5]+$/;
                var addr=/^[(\u4e00-\u9fa5)|(0-9)]+$/
                if(index=='1') {
                    if (str && !customerCnameReg.test(str)) {
                        $scope.check.comType = "公司性质格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.comType = "";
                    }
                }else if(index=='2'){
                    if (str && !addr.test(str)) {
                        $scope.check.linkAddress = "通讯地址格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.linkAddress = "";
                    }
                }else if(index=='3'){
                    if (str && !customerCnameReg.test(str)) {
                        $scope.check.jobTitle = "职业名称格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.jobTitle = "";
                    }
                }else if(index=='4'){
                    if (str && !addr.test(str)) {
                        $scope.check.addressCName = "客户地址格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.addressCName = "";
                    }
                }else if(index=='111'){
                    var reg = /^[\u4E00-\u9FA5]+$/;
                    if (str && !reg.test(str)) {
                        $scope.check.nationality = "国籍格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.nationality = "";
                    }
                }
            }

            //设置密码时的默认值

            $scope.onChang1=function(info){
                $scope.proposal.customer.customerCname1=info.customerCName;
                $scope.proposal.customer.customerCode1=info.customerCode;
                $scope.proposal.customer.password1="";
                $scope.proposal.customer.password2="";
                $scope.check={};
            }

            //密码校验
            $scope.checkpassword1= function ($event,str) {
                var password1Reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                if(str){
                    if(!password1Reg.test(str)){
                        $scope.check.password1="密码不符合系统的密码设置规则，请重新输入!";
                        $event.target.focus();
                    }else{
                        $scope.check.password1="";
                    }
                }else{
                    $scope.check.password1="";
                }

            }
            $scope.confirmPassword=function($event,password1,password2){
                var password2Reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
                if(password2&&!password2Reg.test(password2)){
                    $scope.check.password2="密码不符合系统的密码设置规则，请重新输入!";
                    $event.target.focus();
                }else{
                    $scope.check.password2="";
                }
               if(password2&&(password1!==password2)){
                   $scope.check.password2="确认密码与密码不一致，请重新输入!";
                   $event.target.focus();
                   return false;
               }else{
                   $scope.check.password2="";
                   return true;
               }

            }

            //证件类型的初始化
            $scope.proposal.customerIdv.identifyType="";
            $scope.getPrintFlagList=function(n) {
                if(n=='1'){
                    $$finder.find('queryIdentifyType', {
                        "flag": $scope.proposal.customer.customerType
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.printFlagList = data.content.queryPrpDcodeDtoList;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }else if(n=='2'){
                    $$finder.find('queryIdentifyType', {
                        "flag": $scope.proposal.customerIdv.customerType
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.printFlagList1 = data.content.queryPrpDcodeDtoList;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            //密码显示
            $scope.change=function (){
                $scope.typePass=!$scope.typePass;
            }
            $scope.change1=function (){
                $scope.typePass1=!$scope.typePass1;
            }
            //客户类型变化时把证件类型置空
            $scope.identifyShow=true
            $scope.isChange=function(){
                $scope.check={};
                $scope.proposal.customerIdv.identifyNumber="";
                if($scope.proposal.customer.customerType=='3'){

                    $scope.identifyShow=false;
                }else{
                    $scope.identifyShow=true
                    $scope.proposal.customer.identifyType="";
                    $scope.proposal.customerIdv.identifyType="";
                    $scope.proposal.customer.identifyNumber="";
                }
            }
            //客户风险等级初始化
            $scope.readonly = true
            $scope.show = true;
            $scope.show1 = true;
            $scope.show3=true;
            $scope.show2=true;
            $scope.onChang2 = function(info,customerType){
                if(customerType=='个人'){
                    $scope.customerType ='1';

                }else if(customerType=='单位'){
                    $scope.customerType='2'
                }
                $scope.check.postCode = '';
                $scope.check.identifyNumber1='';
                $scope.check.jobTitle = '';
                $$finder.find('queryByPK', {
                    "customerType":$scope.customerType,//客户类型
                    "customerCode":info.customerCode,//客户编号
                }, {
                    success: function (data) {
                        var update_Date = $filter("date")(new Date(),"yyyy-MM-dd");
                        if(info.customerKind== 1){
                            $scope.show = true;
                            $scope.show1 = false;
                            $scope.show2=true
                            $scope.show3=false
                        } else {
                            $scope.show = false;
                            $scope.show1 = true;
                            $scope.show2=false
                            $scope.show3=true
                        }
                        console.log(data.content)
                        $scope.proposal.customerIdv = data.content;
                        $scope.proposal.customerIdv.customerType=$scope.customerType;
                        $scope.proposal.customerIdv.update_Date = update_Date;
                        $scope.proposal.customerIdv.cashFocus = data.content.cashFocus;
                        $scope.proposal.customerIdv.isCareClaim = data.content.isCareClaim;
                        $scope.proposal.customerIdv.sex = data.content.sex;//性别
                        if($scope.proposal.customerIdv.comType=='0001'){
                            $scope.proposal.customerIdv.comType = '机关';
                        }else if($scope.proposal.customerIdv.comType=='0002'){
                            $scope.proposal.customerIdv.comType = '事业单位';
                        }else if($scope.proposal.customerIdv.comType=='0003'){
                            $scope.proposal.customerIdv.comType = '社会团体';
                        }else if($scope.proposal.customerIdv.comType=='0004'){
                            $scope.proposal.customerIdv.comType = '国有企业';
                        }else if($scope.proposal.customerIdv.comType=='0005'){
                            $scope.proposal.customerIdv.comType = '集体企业';
                        }else if($scope.proposal.customerIdv.comType=='0006'){
                            $scope.proposal.customerIdv.comType = '三资企业';
                        }else if($scope.proposal.customerIdv.comType=='0007'){
                            $scope.proposal.customerIdv.comType = '私营企业';
                        }else if($scope.proposal.customerIdv.comType=='9999'){
                            $scope.proposal.customerIdv.comType = '其他';
                        }
                        $scope.getPrintFlagList('2');
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //关闭风险等级说明
            $scope.showLevelRisk=false;
            $scope.closeLevelRisk=function(){
                $scope.showLevelRisk=!$scope.showLevelRisk;
            }
            //行业现金密度
            $scope.rdChange = function (ele) {
                $scope.cashFocus=ele
            };
            //性别男的按钮样式切换
            $scope.boyBtn = true;
            $scope.boyBtnChange = function(){
                if($scope.boyBtn){
                    $scope.boyBtn = $scope.boyBtn;
                }else{
                    $scope.boyBtn = !$scope.boyBtn;
                    $scope.girlBtn = !$scope.girlBtn;
                }
            };
            //性别女的按钮样式切换
            $scope.girlBtn = true;
            $scope.girlBtnChange = function(){
                $scope.girlBtn = !$scope.girlBtn;
                $scope.boyBtn = !$scope.boyBtn;
            };

            //客户是否关注审计、理赔、退保信息按钮
            $scope.rdChange1 = function (ele) {
                $scope.isCareClaim=ele
            };

            //校验日期格式
            $scope.matchDate= function(str){
                var reg=/^\d{4}\-\d{2}\-\d{2}$/
                if(str != null && str != ''){
                    if(!reg.test(str)){
                        layer.open({
                            scrollbar: false,
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '日期格式输入不正确，请修改！(如:yyyy-MM-dd)',
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
            }

            //证件号码校验
            $scope.isNumber=function($event,str){
                var str;
                var x=$scope.proposal.customerIdv.identifyType;
                if($scope.proposal.customerIdv.customerKind=='1'){
                    str=$scope.proposal.customerIdv.identifyNumber;
                }else {
                    str=$scope.proposal.customerIdv.organizeCode;
                }
                switch (x){
                    case "01"://身份证
                        if(str){
                            if(!commonApiServ.IdCardValidate(str)){
                                $scope.check.identifyNumber1="身份证号码格式不正确，请修改！";
                                $event.target.focus();
                            }else{
                                $scope.check.identifyNumber1="";
                            }
                        }else{
                            $scope.check.identifyNumber1="";
                        }
                        break;
                }
            }

            //证件号码校验
            $scope.isNumber2=function(str){
                if(str){
                    var x=$scope.proposal.customerIdv.identifyType;
                    switch (x) {
                        case "01"://身份证
                            var idReg = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                            if (str && !idReg.test(str)) {
                                $scope.tishi("身份证号码格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false;
                            }
                            break;
                        case "02"://户口薄
                            var hukouReg = /^[a-zA-Z0-9]{3,21}$/;
                            if (str && !hukouReg.test(str)) {
                                $scope.tishi("户口薄证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "03"://护照
                            var huzhaoReg = /^[a-zA-Z0-9]{3,21}$/;
                            if (str && !huzhaoReg.test(str)) {
                                $scope.tishi("护照证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "04"://军官证
                            var junguanReg = /^军[0-9]{7}$/;
                            if (str && !junguanReg.test(str)) {
                                $scope.tishi("军官证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "05"://驾驶执照
                            var jiashiReg = /\d{18}/g;
                            if (str && !jiashiReg.test(str)) {
                                $scope.tishi("驾驶执照证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "06"://返乡证
                            var backReg = /[a-zA-z]{1}\d{11}/g;
                            if (str && !backReg.test(str)) {
                                $scope.tishi("返乡证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "26"://外国人永久居住证
                            var outerReg = /[a-zA-z]{3}\d{12}/g;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("外国人永久居住证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "59"://返乡证
                            var outerReg=/^[0-9]{15,}$/;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("其他证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.identifyNumber="";
                                return false
                            }
                            break;
                        case "61"://组织机构代码
                            var outerReg = /^[a-zA-Z0-9]{8}-[a-zA-Z0-9]/;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("组织机构代码证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.organizeCode="";
                                return false
                            }
                            break;
                        case "62"://税务登记证
                            var outerReg = /^\d{15}/;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("税务登记证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.organizeCode="";
                                return false
                            }
                            break;
                        case "63"://工商登记证
                            var outerReg = /^[0-9]{15,}$/;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("工商登记证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.organizeCode="";
                                return false
                            }
                            break;
                        case "64"://统一社会信用代码登记证
                            var outerReg = /[^_IOZSVa-z\W]{2}\d{6}[^_IOZSVa-z\W]{10}/g;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("统一社会信用代码登记证证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.organizeCode="";
                                return false
                            }
                            break;
                        case "99"://其他
                            var outerReg = /^[0-9]{15,}$/;
                            if (str && !outerReg.test(str)) {
                                $scope.tishi("其他证件号格式不正确，请修改!");
                                $scope.proposal.customerIdv.organizeCode="";
                                return false
                            }
                            break;
                    }
                }else{
                    return true;
                }
            }

            //营业执照格式校验
            $scope.card=function ($event,str) {
                var reg = /^(?:(?![IOZSV])[\dA-Z]){2}\d{6}(?:(?![IOZSV])[\dA-Z]){10}$/;
                if (str && !reg.test(str)) {
                    $scope.check.businessLicenceNo = "营业执照格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.businessLicenceNo = "";
                }

            }
            //邮编
            $scope.postCode=function ($event,str) {
                var reg =  /^[0-9]*$/;
                if (str && !reg.test(str)) {
                    $scope.check.postCode = "邮编格式错误，请修改！";
                    $event.target.focus();
                } else {
                    $scope.check.postCode = "";
                }

            }
            //税务登记证，其他证件号码格式校验
            $scope.revenueCode=function($event,str,index){
                var outerReg = /^[0-9]{15,}$/;
                if(index=='1'){
                    if (str && !outerReg.test(str)) {
                        $scope.check.revenueCode = "税务登记证格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.revenueCode = "";
                    }
                }else if(index=='2'){
                    if (str && !outerReg.test(str)) {
                        $scope.check.otherCodeNo = "其他证件号码格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.otherCodeNo = "";
                    }
                }
            }

            $scope.checkcustomerCname=function($event,str,index){
                var reg= /^[\u4E00-\u9FFF()（）]+$/;
                if(index=='1'){
                    if (str && !reg.test(str)) {
                        $scope.check.customerCname = "客户姓名格式错误，请修改！";
                        $event.target.focus();
                    }
                    else {
                        $scope.check.customerCname = "";
                    }
                }else if(index=='2'){
                    if (str && !reg.test(str)) {
                        $scope.check.customerCname1 = "客户姓名格式错误，请修改！";
                        $event.target.focus();
                    } else {
                        $scope.check.customerCname1 = "";
                    }
                }
            }


        }]);
});