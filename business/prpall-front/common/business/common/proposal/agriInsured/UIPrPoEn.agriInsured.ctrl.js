define(['app', 'constants', 'layer', 'jsonDB', 'jquery'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnAgriInsuredCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', 'regexpConstants', 'commonApiServ',
        function ($rootScope, $scope, $$finder, $http, $filter, regexpConstants,commonApiServ) {
            $scope.proposal.hideIndentifyType=function(){
                $scope.hideIdentifyType=true;
            }
            $scope.regData = {}; // 本页面使用正则的集合
            $scope.regData.telPhoneNumber = regexpConstants.telPhoneNumber;//手机号
            $scope.regData.phoneNumber = regexpConstants.phoneNumber;//固话
            $scope.regData.postCode = regexpConstants.postCode;//邮编
            $scope.regData.cardId = regexpConstants.cardId;//身份证
            $scope.regData.checkUsername=regexpConstants.checkUsername;//客户名称
            $scope.regData.code=regexpConstants.code;//代码
            $scope.regData.Chinese=regexpConstants.Chinese;//汉字
            $scope.regData.email=regexpConstants.email;//电子邮箱
            $scope.regData.bankId=regexpConstants.bankId//银行卡号
            //$scope.proposal = $scope.proposal||{};//个人信息的对象
            //$scope.proposal.prpDcustomerIdvDto = {};//新增或修改的客户信息的个人信息的对象
            //$scope.proposal.prpDcustomeridvDto = {};
            //$scope.proposal.prpDcustomerUnitDto = {};//新增或修改的客户信息的组织信息的对象
            //$scope.proposal.prpDcustomerTaxPayInfoDto = {};//新增或修改的纳税人信息的对象
            //$scope.proposal.appliInsuredDto = {};//投保人信息
            $scope.IdentifyTypeList = {};//证件类型集合
            $scope.InsuredTypeList = {};//客户性质集合
            $scope.BusinessTypeList = {};//职业类型集合
            $scope.PayInfoPayerTypeList = {};//纳税人类型集合
            $scope.PayInfoInvoiceTypeList = {};//发票类型
            $scope.RiskLevelList = {};//风险等级
            $scope.BusinessSortList = {};//公司性质
            $scope.PayInfoObjectList = {};//开票对象
            //给发票信息默认值
            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput="1";
            //$scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject = '1'//开票对象
            //$scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '02';//发票类型
            //$scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '04';//纳税人身份
            $scope.checkedBox = ["1"]
            //$scope.proposal.insuredDto = {};//被保险人的对象
            //$scope.proposal.appliInsuredDto.iscareclaim = 1; // 投保人的关注默认
            //$scope.proposal.appliInsuredDto.cashFocus = 1;
            //$scope.proposal.insuredDto.iscareclaim = 1;
            //$scope.proposal.insuredDto.cashFocus = 1;
            //$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = 1;//与投保人，被保人的关系
            //$scope.radioList = [{"code": 1,"name": "是"},{"code": 2,"name": "否"}];

            //发票购货方信息里的同投保人，被保险人change事件
            $scope.cheangTdInsuredIdentityInput = function(x){
                if(x == "2"){//2是被保险人
                    $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject = "2";
                    $scope.proposal.prpDcustomerTaxPayInfoDto.address =  $scope.proposal.insuredDto.insuredAddress;//购方地址
                    $scope.proposal.prpDcustomerTaxPayInfoDto.phone = $scope.proposal.insuredDto.phoneNumber;//购方电话
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.insuredDto.bank;//购方开户行
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.insuredDto.account;//购方帐号
                    $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.insuredDto.postCode;//邮政编码
                }else {//1是投保人
                    $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject = "1";
                    $scope.proposal.prpDcustomerTaxPayInfoDto.address =  $scope.proposal.appliInsuredDto.insuredAddress;//购方地址
                    $scope.proposal.prpDcustomerTaxPayInfoDto.phone = $scope.proposal.appliInsuredDto.phoneNumber;//购方电话
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.appliInsuredDto.bank;//购方开户行
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.appliInsuredDto.account;//购方帐号
                    $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.appliInsuredDto.postCode;//邮政编码
                }
            }

            //监听被保险人同投保人按钮
            $scope.$watch(function(){return $scope.proposal.appliInsuredDto}, function (newValue,oldValue) {
                if ($scope.checkedBox == true) {
                    for(var i in $scope.proposal.appliInsuredDto){
                        if(i!='insuredFlag'){
                             $scope.proposal.insuredDto[i]=$scope.proposal.appliInsuredDto[i]
                        }
                        $scope.proposal.insuredDto.account=$scope.proposal.appliInsuredDto.account

                    }
                    if($scope.proposal.insuredDto){
                        $scope.proposal.insuredDto.serialNo = "2";
                    }
                    $scope.RrtailHide2 = $scope.RrtailHide1;
                } else {
                    //$scope.proposal.insuredDto = {};
                    $scope.RrtailHide2 = false;
                }
            },true)
            //监听发票购货方同投保人按钮
            $scope.$watch(function(){return $scope.proposal.appliInsuredDto}, function (newValue,oldValue) {
              if($scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
                  $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject = '1';//开票对象
                  //购方电话，如果移动电话为空，就把固定电话赋值给购方电话
                  if ($scope.proposal.insuredDto.mobile!=""){
                      $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.appliInsuredDto.mobile;//移动电话
                  }
                  else{
                      $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.appliInsuredDto.phoneNumber;//固定电话
                  }
                  $scope.proposal.prpDcustomerTaxPayInfoDto.address = $scope.proposal.appliInsuredDto.insuredAddress;//购方地址
                  $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.appliInsuredDto.bank;//购方开户银行
                  $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.appliInsuredDto.account;//购方银行账户
                  $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.appliInsuredDto.postCode;//邮政编码
              }
            },true)
            //监听发票购货方同被保险人按钮
            $scope.$watch(function(){return $scope.proposal.insuredDto}, function (newValue,oldValue) {
                if($scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject = '2';//开票对象
                    //购方电话，如果移动电话为空，就把固定电话赋值给购方电话
                    if ($scope.proposal.insuredDto.mobile!=""){
                        $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.insuredDto.mobile
                    }
                    else{
                        $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.insuredDto.phoneNumber
                    }
                    $scope.proposal.prpDcustomerTaxPayInfoDto.address = $scope.proposal.insuredDto.insuredAddress;//购方地址
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.insuredDto.bank;//购方开户银行
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.insuredDto.account;//购方银行账户
                    $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.insuredDto.postCode;//邮政编码
                }
            },true)
            //按钮框
            $scope.check={};
            $scope.kegai=function(){
                if($scope.proposal.insuredDto.insuredType!=null&&$scope.proposal.insuredDto.insuredType!=""&&$scope.proposal.insuredDto.insuredType!=undefined){
                    $scope.kelei1=true;
                }else{
                    $scope.kelei1=false;
                }
                if(($scope.proposal.insuredDto.identifyType!=null&&$scope.proposal.insuredDto.identifyType!=""&&$scope.proposal.insuredDto.identifyType!=undefined)||($scope.proposal.insuredDto.insuredType=='3'&&($scope.proposal.insuredDto.identifyType==null||$scope.proposal.insuredDto.identifyType==""||$scope.proposal.insuredDto.identifyType==undefined))){
                    $scope.zhenglei1=true;
                }else{
                    $scope.zhenglei1=false;
                }
                if(($scope.proposal.insuredDto.identifyNumber!=null&&$scope.proposal.insuredDto.identifyNumber!=""&&$scope.proposal.insuredDto.identifyNumber!=undefined)||($scope.proposal.insuredDto.insuredType=='3'&& ($scope.proposal.insuredDto.identifyNumber==null||$scope.proposal.insuredDto.identifyNumber==""||$scope.proposal.insuredDto.identifyNumber==undefined))){
                    $scope.zhenghao1=true;
                    $scope.check.identifyNumber2="";
                }else{
                    $scope.zhenghao1=false;
                }
                if($scope.proposal.insuredDto.insuredName!=null&&$scope.proposal.insuredDto.insuredName!=""&&$scope.proposal.insuredDto.insuredName!=undefined){
                    $scope.keming1=true;
                }else{
                    $scope.keming1=false;
                }
                if($scope.proposal.insuredDto.mobile!=null&&$scope.proposal.insuredDto.mobile!=""&&$scope.proposal.insuredDto.mobile!=undefined){
                    $scope.yidian1=true;
                }else{
                    $scope.yidian1=false;
                }
                if($scope.proposal.insuredDto.insuredAddress!=null&&$scope.proposal.insuredDto.insuredAddress!=""&&$scope.proposal.insuredDto.insuredAddress!=undefined){
                    $scope.kedi1=true;
                }else{
                    $scope.kedi1=false;
                }
                if($scope.proposal.insuredDto.phoneNumber!=null&&$scope.proposal.insuredDto.phoneNumber!=""&&$scope.proposal.insuredDto.phoneNumber!=undefined){
                    $scope.gudian1=true;
                    $scope.check.phoneNumber1="";
                }else{
                    $scope.gudian1=false;
                }
                if($scope.proposal.insuredDto.bank!=null&&$scope.proposal.insuredDto.bank!=""&&$scope.proposal.insuredDto.bank!=undefined){
                    $scope.kaihu1=true;
                }else{
                    $scope.kaihu1=false;
                }
                if($scope.proposal.insuredDto.account!=null&&$scope.proposal.insuredDto.account!=""&&$scope.proposal.insuredDto.account!=undefined){
                    $scope.yinzhang1=true;
                }else{
                    $scope.yinzhang1=false;
                }
                if($scope.proposal.insuredDto.email!=""&&$scope.proposal.insuredDto.email!=null&&$scope.proposal.insuredDto.email!=undefined){
                    $scope.dianyou1=true;
                }else{
                    $scope.dianyou1=false;
                }
            }
            //被保险人同投保人按钮
            $scope.checkedBoxChange = function (event) {
                $scope.checkedBox = $scope.checkedBox[0];
                if ($scope.checkedBox == true) {
                    //for(var i in $scope.proposal.appliInsuredDto){
                    //    $scope.proposal.insuredDto[i]=$scope.proposal.appliInsuredDto[i]
                    //}
                    //信达版本
                    // $scope.proposal.insuredDto = angular.copy($scope.proposal.appliInsuredDto);
                    // $scope.proposal.insuredDto.insuredFlag="1";
                    // $scope.proposal.insuredDto.serialNo = "2";
                    //国元版本
                    for(var i in $scope.proposal.appliInsuredDto){
                        $scope.proposal.insuredDto[i]=$scope.proposal.appliInsuredDto[i]
                        $scope.proposal.insuredDto.account=$scope.proposal.appliInsuredDto.account
                    }
                    $scope.proposal.certificate1=false;
                    $scope.proposal.insuredDto.serialNo = "2";
                    $scope.RrtailHide2 = $scope.RrtailHide1;
                } else {
                    //$scope.proposal.insuredDto = {};
                    $scope.RrtailHide2 = false;
                    $scope.proposal.certificate1=true;
                    $scope.kelei1=false;
                    $scope.zhenglei1=false;
                    $scope.zhenghao1=false;
                    $scope.keming1=false;
                    $scope.yidian1=false;
                    $scope.kedi1=false
                    $scope.gudian1=false;
                    $scope.kaihu1=false;
                    //if($scope.proposal.insuredDto.insuredType=='3'){
                    //    $scope.zhenglei1=true;
                    //    $scope.zhenghao1=true;
                    //}
                    return true;
                }
                $scope.kegai();
            }
            $scope.queryTerroristInfoList = {};//接口查询回来的
            $scope.queryTerroristInfoList.pageNo = 1;
            $scope.queryTerroristInfoList.pageSize = 5;
            $scope.totalItems = 0;
            $scope.TerroristShow = false;
            //恐怖分子列表查询
            $scope.queryTerroristInfo = function () {
                $$finder.find('queryTerroristInfo', {}, {
                    success: function (data) {
                        console.log(data);
                        $scope.queryTerroristInfoList = data.content;
                        $scope.totalItems = data.content.length;
                        //查询结果条数
                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                        $scope.TerroristShow = true;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
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
                        if ($scope.paginationConfmm.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.queryTerroristInfoList.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.queryTerroristInfoList.pageSize = $scope.paginationConfmm.itemsPerPage;
                            $$finder.find('queryTerroristInfo', {}, {
                                success: function (data) {
                                    $scope.queryTerroristInfoList = data.content;
                                    $scope.totalItems = data.content.length;
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
            //关闭恐怖分子列表
            $scope.closeTerroristShow = function () {
                $scope.TerroristShow = false;
                $scope.queryTerroristInfoList = "";
            }
                function inputList(input,list){
                    var mailBox = [
                        "@qq.com",
                        "@sina.com",
                        "@163.com",
                        "@126.com",
                        "@yahoo.com.cn",
                        "@gmail.com",
                        "@sohu.com"
                    ];
                    input.bind('input propertychange', function() {
                        var key = input.val();
                        if(key.indexOf("@") != -1){
                            key = key.slice(0,key.indexOf("@"));
                        }
                        var mailBoxLen = mailBox.length;
                        var html = "";
                        for(var i=0; i<mailBoxLen; i++){
                            html += '<option value="'+ key + mailBox[i] +'"></option>';
                        }
                        list.html(html);
                    });
                }
                inputList($("#input"),$("#input_list"));
                inputList($("#input1"),$("#input_list1"));

            //发票类型校验
            $scope.checkForInvoiceType = function (x, y) {
                var content = '';
                if (y == '04' && x == '01') {
                    content = '个人不能使用增值税专用发票';
                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '02';
                }else if(x == '01' && y == '03'){
                    content ='非增值税纳税人不能使用增值税专用发票';
                }else if (x == '02' && y == '03') {
                    content = '非增值税纳税人不能使用增值税普通发票';
                }else if(x == '03' && y == '03'){
                    content ='非增值税纳税人不能使用电子普票';
                }else if(x == '01' && y == '02') {
                    content ='增值税小规模纳税人不能使用增值税专用发票';
                }
                if(content){
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: content,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType='';
                }

            }
            //关闭风险等级说明
            $scope.showLevelRisk=false;
            $scope.closeLevelRisk=function(){
                $scope.showLevelRisk=!$scope.showLevelRisk;
                if($scope.showLevelRisk){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else{
                    $("html,body").css({overflow:"auto"});//显示滚动条
                }
            }
            /* //修改客户信息
             $scope.changeCustomer = function(){
             $scope.showAddCustomer = true;
             if($scope.proposal.appliInsuredDto.appliInsuredInsuredType==2){
             $scope.show = false;
             }else{
             $scope.proposal.prpDcustomeridvDto.identifyType = $scope.proposal.appliInsuredDto.identifyType;//证件类型
             $scope.proposal.prpDcustomeridvDto.identifyNumber = $scope.proposal.appliInsuredDto.identifyNumber;//证件号码
             $scope.proposal.prpDcustomeridvDto.customerCName = $scope.proposal.appliInsuredDto.insuredName;//客户姓名
             $scope.proposal.prpDcustomeridvDto.customerCode = $scope.proposal.appliInsuredDto.insuredCode;//客户代码
             $scope.proposal.prpDcustomeridvDto.mobile = $scope.proposal.appliInsuredDto.mobile;//移动电话
             $scope.proposal.prpDcustomeridvDto.linkAddress = $scope.proposal.appliInsuredDto.insuredAddress;//客户地址
             $scope.proposal.prpDcustomeridvDto.phoneNumber = $scope.proposal.appliInsuredDto.phoneNumber;//固定电话
             $scope.proposal.prpDcustomeridvDto.bankAccount = $scope.proposal.appliInsuredDto.bankAccount;//银行账号
             $scope.proposal.prpDcustomeridvDto.openingBank = $scope.proposal.appliInsuredDto.openingBank;//开户行
             $scope.proposal.prpDcustomeridvDto.postCode = $scope.proposal.appliInsuredDto.postCode;//邮政编码
             $scope.proposal.prpDcustomeridvDto.iscareclaim = $scope.proposal.appliInsuredDto.iscareclaim; //是否关注
             $scope.proposal.prpDcustomerIdvDto.iscareclaim = $scope.proposal.appliInsuredDto.InsuredCashfocus;//行业密度
             $scope.proposal.prpDcustomeridvDto.riskLevel = $scope.proposal.appliInsuredDto.riskLevel;//风险等级
             $scope.show = true;
             }
             }
             //保存客户信息的方法
             $scope.savePrpDcustomerIdvUnit = function(){
             //如果客户类型是个人，客户名称是个人名
             if($scope.proposal.customerType==1){
             if($scope.proposal.prpDcustomerTaxPayInfoDto.address==''|| $scope.proposal.prpDcustomerTaxPayInfoDto.address ==null) {
             $scope.proposal.prpDcustomerTaxPayInfoDto.address = $scope.proposal.prpDcustomeridvDto.linkAddress;
             }
             if($scope.proposal.prpDcustomerTaxPayInfoDto.phone==''|| $scope.proposal.prpDcustomerTaxPayInfoDto.phone == null){
             $scope.proposal.prpDcustomerTaxPayInfoDto.phone = $scope.proposal.prpDcustomeridvDto.mobile;
             }
             }
             //保存
             var dto = angular.copy($scope.proposal);
             $$finder.find('savePrpDcustomerIdvUnit',dto, {
             success: function (data) {
             //成功后回显
             if($scope.proposal.customerType==1){//个人信息的回显
             $scope.proposal.appliInsuredDto.appliInsuredInsuredType = "1";//客户类型
             $scope.proposal.appliInsuredDto.identifyType = $scope.proposal.prpDcustomeridvDto.identifyType;//证件类型
             $scope.proposal.appliInsuredDto.identifyNumber = $scope.proposal.prpDcustomeridvDto.identifyNumber;//证件号码
             $scope.proposal.appliInsuredDto.insuredName = $scope.proposal.prpDcustomeridvDto.customerCName;//客户姓名
             $scope.proposal.appliInsuredDto.insuredCode = $scope.proposal.prpDcustomeridvDto.customerCode;//客户代码
             //proposal.appliInsuredDto.validityCertificate//证件有效期
             $scope.proposal.appliInsuredDto.mobile =  $scope.proposal.prpDcustomeridvDto.mobile;//移动电话
             $scope.proposal.appliInsuredDto.insuredAddress= $scope.proposal.prpDcustomeridvDto.linkAddress;//客户地址
             $scope.proposal.appliInsuredDto.phoneNumber = $scope.proposal.prpDcustomeridvDto.phoneNumber;//固定电话
             $scope.proposal.appliInsuredDto.InsuredLinkerName = $scope.proposal.prpDcustomeridvDto.customerCName;//联系人姓名,把客户名称赋给联系人名称，因为联系人信息在新增页面上没有
             $scope.proposal.appliInsuredDto.bankAccount = $scope.proposal.prpDcustomeridvDto.bankAccount;//银行账号
             $scope.proposal.appliInsuredDto.openingBank = $scope.proposal.prpDcustomeridvDto.openingBank;//开户行
             $scope.proposal.appliInsuredDto.postCode = $scope.proposal.prpDcustomeridvDto.postCode;//邮政编码
             $scope.proposal.appliInsuredDto.iscareclaim = $scope.proposal.prpDcustomeridvDto.iscareclaim||1; //是否关注
             $scope.proposal.appliInsuredDto.InsuredCashfocus = $scope.proposal.prpDcustomerIdvDto.iscareclaim||1;//行业密度
             $scope.proposal.appliInsuredDto.riskLevel = $scope.proposal.prpDcustomeridvDto.riskLevel;//风险等级
             //$scope.showAddCustomer = false;
             //$scope.proposal.prpDcustomerTaxPayInfoDto.customerName = //发票抬头
             }else{
             $scope.proposal.appliInsuredDto.appliInsuredInsuredType = "2";//客户类型
             $scope.proposal.appliInsuredDto.identifyType = $scope.proposal.prpDcustomerUnitDto.identifyType;//证件类型
             $scope.proposal.appliInsuredDto.identifyNumber = $scope.proposal.prpDcustomerUnitDto.identifyNumber;//证件号码
             $scope.proposal.appliInsuredDto.insuredName = $scope.proposal.prpDcustomerUnitDto.customerCName;//客户姓名
             $scope.proposal.appliInsuredDto.insuredCode = $scope.proposal.prpDcustomeridvDto.customerCode;//客户代码
             $scope.proposal.appliInsuredDto.mobile =  $scope.proposal.prpDcustomerUnitDto.mobile;//移动电话
             $scope.proposal.appliInsuredDto.insuredAddress= $scope.proposal.prpDcustomerUnitDto.postAddress;//客户地址
             $scope.proposal.appliInsuredDto.phoneNumber = $scope.proposal.prpDcustomerUnitDto.phoneNumber;//固定电话
             $scope.proposal.appliInsuredDto.InsuredLinkerName = $scope.proposal.prpDcustomeridvDto.customerCName;//联系人姓名,把客户名称赋给联系人名称，因为联系人信息在新增页面上没有
             $scope.proposal.appliInsuredDto.bankAccount = $scope.proposal.prpDcustomeridvDto.bankAccount;//银行账号
             $scope.proposal.appliInsuredDto.openingBank = $scope.proposal.prpDcustomeridvDto.openingBank;//开户行
             $scope.proposal.appliInsuredDto.postCode = $scope.proposal.prpDcustomeridvDto.postCode;//邮政编码
             $scope.proposal.appliInsuredDto.iscareclaim = $scope.proposal.prpDcustomerUnitDto.iscareclaim||1; //是否关注
             $scope.proposal.appliInsuredDto.InsuredCashfocus = $scope.proposal.prpDcustomerUnitDto.cashFocus||1;//行业密度
             $scope.proposal.appliInsuredDto.riskLevel = $scope.proposal.prpDcustomerUnitDto.riskLevel;//风险等级
             $scope.proposal.appliInsuredDto.prpDcustomerUnitComtype = $scope.proposal.prpDcustomerUnitDto.prpDcustomerUnitComtype||"";//公司性质
             }
             //关窗口
             $scope.showAddCustomer = false;
             },
             error: function (e) {
             options.error(e);
             }
             });
             }*/
            $scope.proposal.insuredDto.identifyType="";
            $scope.clearIdentifyNumber=function(){
                $scope.proposal.appliInsuredDto.identifyNumber="";
            }
            $scope.clearIdentifyNumber1=function(){
                $scope.proposal.insuredDto.identifyNumber="";
            }
            $scope.getPrintFlagList=function(n,att) {
                if(n=='1'){
                    $$finder.find('queryIdentifyType', {
                        "flag": att
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
                        "flag": att
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
            //风险等级说明
            $scope.showExplainFlag = true;
            $scope.showExplain = function () {//这里应该传入一个值
                $scope.showExplainFlag = !$scope.showExplainFlag;
            }
            //投保人展开按钮的切换
            $scope.tabBtn = true;
            $scope.tabBtn2 = false;
            $scope.tabBtnChange = function () {
                $scope.tabBtn = !$scope.tabBtn;
                $scope.tabBtn2 = !$scope.tabBtn2;
            };
            //证件号码校验
            $scope.check={};
            $scope.isNumber=function($event,str,index){
                var x;
                var conment;
                if(index=='1'){
                     x = $scope.proposal.appliInsuredDto.identifyType;
                }else if(index=='2'){
                     x = $scope.proposal.insuredDto.identifyType;
                }
                switch (x){
                    case "01"://身份证
                        var idReg=/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                        //if(str&&!idReg.test(str) ){//commonApiServ.IdCardValidate(str)校验身份证号码的真伪
                        if(str){
                            if(!commonApiServ.IdCardValidate(str)){
                                conment="身份证号码格式不正确，请修改！";
                                $event.target.focus();
                            }else{
                                conment="";
                            }
                        }else{
                            conment="";
                        }

                        break;
                }
                if(index=='1'){
                    $scope.check.identifyNumber1= conment;
                }else if(index=='2'){
                    $scope.check.identifyNumber2= conment;
                }
            }
            /* //显示投保人的新增客户页面
             $scope.addCustomer = function(){
             $scope.showAddCustomer = true;
             };
             //关闭投保人的新增客户页面
             $scope.closeAddCustomer = function(){
             $scope.showAddCustomer = false;
             };
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
             };*/
            //投保人展开按钮的切换
            $scope.tabBtn1 = true;
            $scope.tabBtnChangeOne = function () {
                $scope.tabBtn1 = !$scope.tabBtn1;
            };
            //发票信息展开按钮的切换
            $scope.tabBtn3 = true;
            $scope.tabBtnChangeTwo = function () {
                $scope.tabBtn3 = !$scope.tabBtn3;
            };

            //证件类型的初始化
            $scope.getPrintFlagList1=function() {
                if($scope.proposal.appliInsuredDto.insuredType!=""){
                    $$finder.find('queryIdentifyType', {
                        "flag": $scope.proposal.appliInsuredDto.insuredType
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.printFlagList = data.content.queryPrpDcodeDtoList

                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            //根据客户类型查询证件类型集合
            $scope.getPrintFlagList2 = function() {
                if($scope.proposal.insuredDto.insuredType!=""){//如果客户类型不为空
                    $$finder.find('queryIdentifyType', {
                        "flag": $scope.proposal.insuredDto.insuredType//客户累类型
                    }, {
                        success: function (data) {
                            console.log(data)
                            $scope.printFlagList = data.content.queryPrpDcodeDtoList
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            //清单带出时如果是非企业团体则置灰证件类型与身份证号码
            $scope.proposal.changeRrtailHide1 = function () {
                $scope.RrtailHide1=true;
                $scope.RrtailHide2=true;
            }
            //防止第一次录入的是非企业团体后又修改为个体或者团体
            $scope.proposal.changeRrtailHide2 = function (){
                $scope.RrtailHide1=false;
                $scope.RrtailHide2=false;
            }
            //客户类型变化时把证件类型置空
            $scope.isChange1=function(){
                $scope.proposal.appliInsuredDto.identifyType="";
                $scope.proposal.appliInsuredDto.identifyNumber="";
                var insuredType = $scope.proposal.appliInsuredDto.insuredType;
                  if(insuredType==3){
                      //散户的时候只读证件类型与身份证号码
                      $scope.RrtailHide1=true;
                      $scope.RrtailHide1=true;
                  }else{
                      $scope.RrtailHide1=false;
                      $scope.RrtailHide1=false;
                  }
                //发票购货方同投保人
                if($scope.proposal.appliInsuredDto.insuredType=='1'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '04';//开票对象为个人时，纳税人身份默认为个人
                }else if($scope.proposal.appliInsuredDto.insuredType=='2'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '01';//开票对象为单位时，纳税人身份默认增值税一般纳税人
                }else if($scope.proposal.appliInsuredDto.insuredType=='3'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '03';//开票对象为非企业团体时，纳税人身份默认非增值税纳税人
                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '04';//发票类型默认为暂不开票
                }
            }
            $scope.isChange2=function(){
                $scope.proposal.insuredDto.identifyType="";
                $scope.proposal.insuredDto.identifyNumber="";
                var insuredType = $scope.proposal.insuredDto.insuredType;
                if(insuredType==3){
                    //散户的时候只读证件类型与身份证号码
                    $scope.RrtailHide2=true;
                    $scope.RrtailHide2=true;
                }else{
                    $scope.RrtailHide2=false;
                    $scope.RrtailHide2=false;
                }
                //发票购货方同被保险人的时候
                if($scope.proposal.insuredDto.insuredType=='1'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '04';//开票对象为个人时，纳税人身份默认为个人
                }else if($scope.proposal.insuredDto.insuredType=='2'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '01';//开票对象为单位时，纳税人身份默认增值税一般纳税人
                }else if($scope.proposal.insuredDto.insuredType=='3'&&$scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '03';//开票对象为非企业团体时，纳税人身份默认非增值税纳税人
                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '04';//发票类型默认为暂不开票
                }
            }
            $scope.setIdent=function () {
                var insuredType = $scope.proposal.insuredDto.insuredType;
                if(insuredType==3){
                    //散户的时候只读证件类型与身份证号码
                    $scope.RrtailHide2=true;
                    $scope.RrtailHide2=true;
                }
            }
            /* //性别男的按钮样式切换
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
             };*/
            $scope.takeInfo=function () {
                //同投保人
                if ($scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
                   $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject='1';
                   $scope.proposal.prpDcustomerTaxPayInfoDto.address =  $scope.proposal.appliInsuredDto.insuredAddress;//购方地址
                   $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.appliInsuredDto.bank;//购方开户行
                   $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.appliInsuredDto.account;//购方帐号
                   $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.appliInsuredDto.postCode;//邮政编码
                    //购方电话
                   if($scope.proposal.appliInsuredDto.mobile!=""){//移动电话
                       $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.appliInsuredDto.mobile;
                   }
                   else{//固定电话
                       $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.appliInsuredDto.phoneNumber
                   }


                }
                //同被保险人
                if ($scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.payInfoObject='2';
                    $scope.proposal.prpDcustomerTaxPayInfoDto.address =  $scope.proposal.insuredDto.insuredAddress;//购方地址
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountBank = $scope.proposal.insuredDto.bank;//购方开户行
                    $scope.proposal.prpDcustomerTaxPayInfoDto.accountNo = $scope.proposal.insuredDto.account;//购方帐号
                    $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = $scope.proposal.insuredDto.postCode;//邮政编码
                    if ($scope.proposal.insuredDto.mobile!=""){
                        $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.insuredDto.mobile
                    }
                    else{
                        $scope.proposal.prpDcustomerTaxPayInfoDto.phone=$scope.proposal.insuredDto.phoneNumber
                    }

                }
                if($scope.proposal.appliInsuredDto.insuredType=='1'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '04';//开票对象为个人时，纳税人身份默认为个人
                }else if($scope.proposal.appliInsuredDto.insuredType=='2'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '01';//开票对象为单位时，纳税人身份默认增值税一般纳税人
                }else if($scope.proposal.appliInsuredDto.insuredType=='3'){
                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '03';//开票对象为非企业团体时，纳税人身份默认非增值税纳税人
                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '04';//发票类型默认为暂不开票
                }
            }
        //    客户信息收缩按钮
            $scope.isHidclient=true;
            $scope.clientIsHide= function () {
                $scope.isHidclient=!$scope.isHidclient;
            }
            //固定电话校验
            //$scope.checkPhoneNumber=function($event,phoneNumber){
            //    if(!phoneNumber || phoneNumber==null ||phoneNumber==""){
            //        $scope.check.mobile1="固定电话为必填项!";
            //        $event.target.focus();
            //    }else{
            //        $scope.check.mobile1="";
            //    }
            //}

            ////固定电话校验
            //$scope.checkPhoneNumber1=function($event,phoneNumber){
            //    if(!phoneNumber || phoneNumber==null ||phoneNumber==""){
            //        $scope.check.mobile="固定电话为必填项!";
            //        $event.target.focus();
            //    }else{
            //        $scope.check.mobile="";
            //    }
            //}
        //    移动电话校验
            $scope.appliInsuredCheckphoneNo= function ($event,str) {
                //手机号
                var telReg2=/^1[3|4|5|9|6|7|8][0-9]{0,}$/;
                var telReg=/^1[3|4|5|9|6|7|8][0-9]{9}$/;
                if(str){
                    if(!telReg2.test(str)){
                        $scope.check.phoneNumber="移动电话号段错误，请修改!";
                        $event.target.focus();
                    }else if(str&&!telReg.test(str)){
                        $scope.check.phoneNumber="移动电话长度错误，请修改!";
                        $event.target.focus();
                    }else{
                        $scope.check.phoneNumber="";
                    }
                }else{
                    $scope.check.phoneNumber="";
                }
            }
            $scope.insuredCheckphoneNo= function ($event,str) {
                //手机号
                var telReg2=/^1[3|4|5|9|6|7|8][0-9]{0,}$/;
                var telReg=/^1[3|4|5|9|6|7|8][0-9]{9}$/;
                if(str){
                    if(!telReg2.test(str)){
                        $scope.check.phoneNumber1="移动电话号段错误，请修改!";
                        $event.target.focus();
                    }else if(str&&!telReg.test(str)){
                        $scope.check.phoneNumber1="移动电话长度错误，请修改!";
                        $event.target.focus();
                    }else{
                        $scope.check.phoneNumber1="";
                    }
                }else{
                    $scope.check.phoneNumber1="";
                }
            }
            $scope.taxCheckphoneNo= function ($event,str) {
                //手机号
                var telReg2=/^1[3|4|5|9|6|7|8][0-9]{0,}$/;
                var telReg=/^1[3|4|5|9|6|7|8][0-9]{9}$/;
                if(str){
                    if(!telReg2.test(str)){
                        $scope.check.taxPhoneNo="购方电话号段错误，请修改!";
                        $event.target.focus();
                    }else if(str&&!telReg.test(str)){
                        $scope.check.taxPhoneNo="购方电话长度错误，请修改!";
                        $event.target.focus();
                    }else{
                        $scope.check.taxPhoneNo="";
                    }
                }else{
                    $scope.check.taxPhoneNo="";
                }
            }


        }]);
});