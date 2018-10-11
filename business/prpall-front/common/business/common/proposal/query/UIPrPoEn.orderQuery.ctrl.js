/**
 * Created by sen on 2017/11/17.
 */

define(['app', 'constants', 'layer', 'jsonDB',"config", 'encodeUrl'], function (app, constants, layer, jsonDB,config) {
    'use strict';
    app.registerController('UIPrPoEnOrderQueryCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$state',"$window",'$$code',
        function ($rootScope, $scope, $$finder, $http, $filter, $state,$window,$$code) {
            $scope.selectListData={};// 级联下拉列表数据
            $scope.proposal = {};//查询条件的对象
            $scope.check={};//
            $scope.proposal.QueryList = {};//接口查询回来的
            $scope.proposal.prpTmain = {};
            $scope.proposal.prpTmain.pageNo = 1;
            $scope.proposal.prpTmain.pageSize = 20;
            //$scope.proposal.prpTmain.endorDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改起日期
            //$scope.proposal.prpTmain.endorDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改止日期
            //$scope.proposal.prpTmain.validDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改生效起期
            //$scope.proposal.prpTmain.validDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改生效止期
            //$scope.underWriteFlagList = [{'codeCode': '', 'codeName': '所有'},{'codeCode': '0', 'codeName': '初始值'}, {'codeCode': '1', 'codeName': '通过'}, {'codeCode': '2', 'codeName': '未通过'}, {'codeCode': '3', 'codeName': '无需核保'}, {'codeCode': '9', 'codeName': '待核保'}, {'codeCode': '10', 'codeName': '核保退回'}, {'codeCode': '11', 'codeName': '已撤单'}];
            $scope.underWriteFlagList = [{'codeCode': '0', 'codeName': '初始值'}, {'codeCode': '1', 'codeName': '通过'}, {'codeCode': '2', 'codeName': '未通过'}, {'codeCode': '3', 'codeName': '无需核批'}, {'codeCode': '9', 'codeName': '待核批'}, {'codeCode': '10', 'codeName': '核批退回'}];
            //提交查询信息
            $scope.totalItems = 0;
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

            //批量删除
            $scope.deletePrint= function () {
                var dto=angular.copy( $scope.proposal.QueryList);
                $scope.deletePrintlist=[];
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked){
                        $scope.deletePrintlist.push(dto);
                    }
                });
                if($scope.deletePrintlist.length<=0){
                    var cont;
                    cont = '请选中要删除的保单';
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
                }else{
                    layer.open({
                        area: ['729px', ''],
                        scrollbar: false,
                        /*offset: ['40%', '24%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "是否继续删除？",
                        btn: ['确定',"取消"],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            var endorseNoList=[];
                            angular.forEach($scope.deletePrintlist, function (data) {
                                endorseNoList.push(data.endorseNo);
                            })
                            $scope.DeleteEndorseRequestDto={
                                "endorseNoList":endorseNoList,
                                "userCode": $rootScope.user.userCode,//用户代码
                                "loginComCode": $rootScope.user.loginComCode,//用户登录机构
                                "loginGradeCodes": "111",
                                "tableName": "PrpDcompany",
                                "userCodeFields": "userCode",
                                "comCodeFields": "comCode"
                            }
                            $$finder.find('deleteEndorse',$scope.DeleteEndorseRequestDto,{
                                success: function (data) {
                                    var dto = angular.copy($scope.proposal);
                                    var content="";
                                    var failList=data.content.failMessageList;
                                    var successList=data.content.successMessageList;
                                    for(var i=0;i<failList.length/2;i++){
                                        content+=failList[i]+'<br/>';
                                    }
                                    for(var j=0;j<successList.length;j++){
                                        content+=successList[j];
                                    }
                                    layer.open({
                                        /*offset: ['45%', '28%'],*/
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        scrollbar: false,
                                        title: '温馨提示',
                                        content: content,
                                        btn: ['确定'],
                                        btn1: function(index, layero){
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                            $$finder.find('queryEndorsListInfo', dto, {
                                                success: function (data) {
                                                    console.log(data);
                                                    angular.forEach(data.content.content, function (data, index, array) {
                                                        var strOthFlag = data.othFlag;
                                                        //var underwriteFlag = data.underwriteFlag;
                                                        console.log(data.othFlag);
                                                        if (strOthFlag.substring(3, 4) != '2') {
                                                            if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "0") {
                                                                data.underwriteFlag = "初始值";
                                                                data.othFlag = "";
                                                                data.operate=1;
                                                            }else if (data.underwriteFlag == '8' && strOthFlag.substring(0, 1) == "0") {
                                                                data.underwriteFlag = "暂存";
                                                                data.othFlag = "";
                                                                data.operate=1;
                                                            }
                                                            else if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "1") {
                                                                data.underwriteFlag = "续保新保";
                                                                data.othFlag = "";
                                                                data.operate=1;
                                                            } else if (data.underwriteFlag == '1'||data.underwriteFlag == '4') {
                                                                if(data.underwriteFlag == '1'){
                                                                    data.underWriteFlag='1'
                                                                }
                                                                data.underwriteFlag = "通过";
                                                                data.othFlag = "核批信息";
                                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 4) != "3") {
                                                                data.underwriteFlag = "核批退回";
                                                                data.othFlag = "核批信息";
                                                                data.operate=1;
                                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 1) == "3") {
                                                                data.underwriteFlag = "拒保";
                                                                data.othFlag = "核批信息";
                                                            } else if (data.underwriteFlag == '3') {
                                                                data.underwriteFlag = "无需核批";
                                                                data.othFlag = "";
                                                            } else if (data.underwriteFlag == '9') {
                                                                data.underwriteFlag = "待核批";
                                                                data.othFlag = "";
                                                            }
                                                        }
                                                        else {
                                                            data.underwriteFlag = "已撤单";
                                                            data.othFlag = "核批信息";
                                                        }
                                                    })
                                                    $scope.proposal.QueryList = data.content.content;
                                                    // $scope.proposal.QueryList = data.content;
                                                    $scope.totalItems = data.content.totalCount;
                                                    //查询结果条数
                                                    $scope.paginationConfmm.totalItems = $scope.totalItems;
                                                },
                                                error: function (e) {
                                                    options.error(e);
                                                }
                                            });
                                        }
                                    });
                                }

                            })
                            layer.close(index);
                        },
                        btn2: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });

                }
            }
            //修改批文
            $scope.showReviseOfficial=false;
            $scope.reviseOfficial= function (index) {
                $scope.showReviseOfficial=true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                var dto=angular.copy( $scope.proposal.QueryList);
                $scope.endorseNo=dto[index].endorseNo;
                $$finder.find("queryPrpPtextByEndorseNo",{
                    "endorseNo":$scope.endorseNo
                },{
                    success: function (data) {
                        console.log(data);
                        var list=data.content;
                        $scope.endorseText="";
                        for(var i=0;i<list.length;i++){
                            $scope.endorseText+=list[i].endorseText+'\n';
                        }
                        $scope.policyNo=data.content[0].policyNo;//获取保单号
                        if($scope.endorseText){
                            $("#textOfficial").val($scope.endorseText);
                        }
                    }
                })

            }
            //保存批文
            $scope.saveOfficial= function () {
                $$finder.find("modifyPrpPtext",{
                    "endorseNo":$scope.endorseNo,
                    "strPtext": $("#textOfficial").val(),
                    "fromPage":"EditText"
                },{
                    success: function (data) {
                        console.log(data);
                        if(data.message=="成功"){
                            $scope.showReviseOfficial=false;
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                scrollbar: false,
                                title: '温馨提示',
                                content: "保存成功",
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        }else{
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                scrollbar: false,
                                title: '温馨提示',
                                content: data.message,
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        }

                    }
                })
            }
            //查看批单
            $scope.showCheckOfficial=false;
            $scope.txnlist= $scope.txnlist||{};
            $scope.checkOfficial= function (info) {
                $scope.showCheckOfficial=true;
                $scope.txnlist.policyNo=info.policyNo;
                $scope.txnlist.premiumNew=info.sumPremium+info.chgPremium;
                $scope.txnlist.amountNew=info.sumAmount+info.chgAmount;
                $scope.txnlist.premiumOld=info.sumPremium;
                $scope.txnlist.amountOld=info.sumAmount;
                $scope.txnlist.riskCode=info.riskCode;
                $scope.txnlist.endorseNo=info.endorseNo;
                $scope.proposal.prpTmain.sumPremium
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
            }
            //查询
            $scope.submit1 = function () {
                if( ($scope.proposal.prpTmain.policyNo!=null&&$scope.proposal.prpTmain.policyNo != "")
                    ||( $scope.proposal.prpTmain.endorseNo!="" && $scope.proposal.prpTmain.endorseNo!=undefined)
                    ||($scope.proposal.prpTmain.comCode!=""&&$scope.proposal.prpTmain.comCode!=undefined)
                    ||($scope.proposal.prpTmain.appliName!=""&&$scope.proposal.prpTmain.appliName!=undefined)
                    ||($scope.proposal.prpTmain.handler1Code!="" &&$scope.proposal.prpTmain.handler1Code!=undefined )
                    ||($scope.proposal.prpTmain.operatorCode!="" &&$scope.proposal.prpTmain.operatorCode!=null)
                    ||($scope.proposal.prpTmain.underwriteFlag!=""&&$scope.proposal.prpTmain.underwriteFlag!=undefined)
                    ||($scope.proposal.prpTmain.endorDateStart!=""&&$scope.proposal.prpTmain.endorDateStart!=undefined)
                    ||($scope.proposal.prpTmain.endorDateEnd!=""&&$scope.proposal.prpTmain.endorDateEnd!=undefined)
                    ||($scope.proposal.prpTmain.validDateStart!=""&&$scope.proposal.prpTmain.validDateStart!=undefined)
                    ||($scope.proposal.prpTmain.validDateEnd!=""&&$scope.proposal.prpTmain.validDateEnd!=undefined)
                    ||($scope.proposal.prpTmain.BusinessType1!=""&&$scope.proposal.prpTmain.BusinessType1!=undefined)
                    ||($scope.proposal.prpTmain.EndorType!=""&&$scope.proposal.prpTmain.EndorType!=undefined)
                ) {
                    var proposalNoReg =/^\d{15,}$/;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA5]+$/;// 数字汉子
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
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
                    }else if($scope.proposal.prpTmain.appliName&&!appliNameReg.test($scope.proposal.prpTmain.appliName)){
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
                    } else{
                        if($scope.proposal.prpTmain.policyNo||$scope.proposal.prpTmain.endorseNo){
                            $scope.proposal.prpTmain.endorDateStart = "";
                            $scope.proposal.prpTmain.endorDateEnd = "";
                            $scope.proposal.prpTmain.validDateStart ="";
                            $scope.proposal.prpTmain.validDateEnd ="";
                        }
                        $scope.proposal.prpTmain.pageNo = 1;
                        $scope.proposal.prpTmain.pageSize = 20;
                        var dto = angular.copy($scope.proposal);
                        $$finder.find('queryEndorsListInfo', dto, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content.content.length>0){
                                    console.log(data);
                                    // $scope.proposal.QueryList = data.content;
                                    angular.forEach(data.content.content, function (data, index, array) {
                                        var strOthFlag = data.othFlag;
                                        //var underwriteFlag = data.underwriteFlag;
                                        console.log(data.othFlag);
                                        if (strOthFlag.substring(3, 4) != '2') {
                                            if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "0") {
                                                data.underwriteFlag = "初始值";
                                                data.othFlag = "";
                                                data.operate=1;
                                            }else if (data.underwriteFlag == '8' && strOthFlag.substring(0, 1) == "0") {
                                                data.underwriteFlag = "暂存";
                                                data.othFlag = "";
                                                data.operate=1;
                                            }
                                            else if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "1") {
                                                data.underwriteFlag = "续保新保";
                                                data.othFlag = "";
                                                data.operate=1;
                                            } else if (data.underwriteFlag == '1'||data.underwriteFlag == '4') {
                                                if(data.underwriteFlag == '1'){
                                                    data.underWriteFlag='1'
                                                }
                                                data.underwriteFlag = "通过";
                                                data.othFlag = "核批信息";
                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 4) != "3") {
                                                data.underwriteFlag = "核批退回";
                                                data.othFlag = "核批信息";
                                                data.operate=1;
                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 1) == "3") {
                                                data.underwriteFlag = "拒保";
                                                data.othFlag = "核批信息";
                                            } else if (data.underwriteFlag == '3') {
                                                data.underwriteFlag = "无需核批";
                                                data.othFlag = "";
                                            } else if (data.underwriteFlag == '9') {
                                                data.underwriteFlag = "待核批";
                                                data.othFlag = "";
                                            }

                                        }
                                        else {
                                            data.underwriteFlag = "已撤单";
                                            data.othFlag = "核批信息";
                                        }
                                    })
                                    $scope.proposal.QueryList = data.content.content;
                                    $scope.totalItems = data.content.totalCount;
                                    //查询结果条数
                                    $scope.paginationConfmm.totalItems = $scope.totalItems;
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

                }else{
                    var content;
                    content = '至少输入一个查询条件！';
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
                }

                //var dto = angular.copy($scope.proposal);
                //信达版本
                // $$finder.find('queryEnorderListInfo', dto, {
                //     success: function (data) {
                //         console.log(data);
                //         // $scope.proposal.QueryList = data.content.content;
                //         $scope.proposal.QueryList = data.content.content;
                //         $scope.totalItems = data.content.totalCount;
                //         //查询结果条数
                //         $scope.paginationConfmm.totalItems = $scope.totalItems;
                //     },
                //     error: function (e) {
                //         options.error(e);
                //     }
                // });
                //国元版本
                /*  $$finder.find('queryEndorsListInfo', dto, {
                 success: function (data) {
                 console.log(data);
                 // $scope.proposal.QueryList = data.content.content;
                 $scope.proposal.QueryList = data.content;
                 $scope.totalItems = data.content.totalCount;
                 //查询结果条数
                 $scope.paginationConfmm.totalItems = $scope.totalItems;
                 },
                 error: function (e) {
                 options.error(e);
                 }
                 });*/
            }
            $scope.changeendorseNo= function (str) {
                if($scope.proposal.prpTmain.endorseNo||$scope.proposal.prpTmain.policyNo){
                    $scope.proposal.prpTmain.endorDateStart = "";//批改起日期
                    $scope.proposal.prpTmain.endorDateEnd = "";//批改止日期
                    $scope.proposal.prpTmain.validDateStart = "";//批改生效起期
                    $scope.proposal.prpTmain.validDateEnd ="";//批改生效止期
                    $scope.proposal.prpTmain.BusinessType1="";//政策商业性标识
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
            //日期校验
            $scope.compareDate=function(startDate,endDate){
                var content;
                if (startDate==""||!startDate) {
                    content = '请录入批改起期！';
                    $scope.proposal.prpTmain.endDate = "";
                    layer.open({
                        /*offset: ['40%', '40%'],*/
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
                }else {
                    var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                    var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                    if (startDate > endDate) {
                        var content;
                        content = '批改起期要大于批改止期';
                        /*$scope.proposal.prpMmodelMainRequest.endDate = "";*/
                        $scope.proposal.prpTmain.endorDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改起日期
                        $scope.proposal.prpTmain.endorDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改止日期
                        layer.open({
                            /*offset: ['40%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
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
            $scope.compareDate2=function(startDate,endDate){
                var content;
                if (startDate==""||!startDate) {
                    content = '请录入批改生效起期！';
                    $scope.proposal.prpTmain.operateDateEnd = "";
                    layer.open({
                        /*offset: ['40%', '40%'],*/
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
                        content = '批改生效止期要大于批改生效起期';
                        /*$scope.proposal.prpMmodelMainRequest.endDate = "";*/
                        $scope.proposal.prpTmain.validDateStart = $filter('date')(new Date().setDate('01'),'yyyy-MM-dd');//批改生效起期
                        $scope.proposal.prpTmain.validDateEnd = $filter('date')(new Date(),'yyyy-MM-dd');//批改生效止期
                        layer.open({
                            /*offset: ['40%', '40%'],*/
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
                    }
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
            $scope.QueryList = function () {

            };
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
                $scope.proposal.prpTmain= {
                    //endorDateStart : $filter('date')(new Date().setDate('01'),'yyyy-MM-dd'),
                    //endorDateEnd :$filter('date')(new Date(),'yyyy-MM-dd'),
                    //validDateStart: $filter('date')(new Date().setDate('01'),'yyyy-MM-dd'),
                    //validDateEnd:$filter('date')(new Date(),'yyyy-MM-dd'),
                    underwriteFlag:''
                };

                $scope.proposal.prpTmain.BusinessType1 = $scope.proposal.prpTmain.BusinessType1;
                $scope.proposal.prpTmain.BusinessType1='01';
                $scope.proposal.prpTmain.EndorType=$scope.proposal.prpTmain.EndorType;
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
                            console.log(dto);
                            $$finder.find('queryEndorsListInfo', dto, {
                                success: function (data) {
                                    console.log(data);
                                    angular.forEach(data.content.content, function (data, index, array) {
                                        var strOthFlag = data.othFlag;
                                        //var underwriteFlag = data.underwriteFlag;
                                        console.log(data.othFlag);
                                        if (strOthFlag.substring(3, 4) != '2') {
                                            if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "0") {
                                                data.underwriteFlag = "初始值";
                                                data.othFlag = "";
                                                data.operate=1;
                                            }else if (data.underwriteFlag == '8' && strOthFlag.substring(0, 1) == "0") {
                                                data.underwriteFlag = "暂存";
                                                data.othFlag = "";
                                                data.operate=1;
                                            }
                                            else if (data.underwriteFlag == '0' && strOthFlag.substring(0, 1) == "1") {
                                                data.underwriteFlag = "续保新保";
                                                data.othFlag = "";
                                                data.operate=1;
                                            } else if (data.underwriteFlag == '1'||data.underwriteFlag == '4') {
                                                if(data.underwriteFlag == '1'){
                                                    data.underWriteFlag='1'
                                                }
                                                data.underwriteFlag = "通过";
                                                data.othFlag = "核批信息";
                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 4) != "3") {
                                                data.underwriteFlag = "核批退回";
                                                data.othFlag = "核批信息";
                                                data.operate=1;
                                            } else if (data.underwriteFlag == '2' && strOthFlag.substring(3, 1) == "3") {
                                                data.underwriteFlag = "拒保";
                                                data.othFlag = "核批信息";
                                            } else if (data.underwriteFlag == '3') {
                                                data.underwriteFlag = "无需核批";
                                                data.othFlag = "";
                                            } else if (data.underwriteFlag == '9') {
                                                data.underwriteFlag = "待核批";
                                                data.othFlag = "";
                                            }
                                        }
                                        else {
                                            data.underwriteFlag = "已撤单";
                                            data.othFlag = "核批信息";
                                        }
                                    })
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

            //打印设置弹出
            $scope.orderLayerShow = false;
            $scope.configPrint = function () {
                var dto=angular.copy( $scope.proposal.QueryList);
                $scope.printlist=[];
                $scope.list=[];
                var printflag=false;
                var isSelect=0;
                angular.forEach($scope.proposal.QueryList,function(dto){
                    if(dto.checked){
                        isSelect=1;
                        if(dto.underWriteFlag&&dto.underWriteFlag=='1'){
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
                                    console.log(data);
                                    if(data.code=='0000'){
                                        angular.forEach(data.content, function (_data) {
                                            $scope.proposal.visaSerisal=_data.visaSerisal;
                                            $scope.visaType=_data.visaCode+'-'+_data.visaName;
                                            $scope.visaCode=_data.visaCode;
                                        })
                                    }else if(data.code=='9999'){
                                        layer.open({
                                            //offset: ['38%', '31%'],
                                            scrollbar: false,
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: data.message,
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
                            $scope.configPrintSet();
                            $scope.policyNo=$scope.list[0].endorseNo;
                            $scope.proposalNo=$scope.list[0].proposalNo;
                            layer.close(index);
                        },
                        btn2: function (index1, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index1);
                        }
                    });
                } else{
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
                            console.log(data);
                            if(data.code=='0000'){
                                angular.forEach(data.content, function (_data) {
                                    $scope.proposal.visaSerisal=_data.visaSerisal;
                                    $scope.visaType=_data.visaCode+'-'+_data.visaName;
                                    $scope.visaCode=_data.visaCode;
                                })
                            }else if(data.code=='9999'){
                                layer.open({
                                    //offset: ['38%', '31%'],
                                    scrollbar: false,
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: data.message,
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
                    $scope.configPrintSet();
                    $scope.policyNo=$scope.list[0].endorseNo;
                    $scope.proposalNo=$scope.list[0].proposalNo;
                }
                //$scope.orderLayerShow = true;

            };
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

                if ($scope.printType == 'PolicyPrint') {
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
                    //判断批单如果已经打印，就不能再次打印
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
                                $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrintOriginal?' + end + '&&comCode=' + $rootScope.user.loginComCode + '&&visaCode=' + $scope.visaCode+ '&&visaSerialNo=' + $scope.proposal.visaSerisal+'&&userCode='+ $rootScope.user.userCode);

                            }
                        },
                        error:function(e){
                            options.error(e);
                        }
                    });
                } else if ($scope.printType == 'PolicyPrint1') {
                    //批单抄件打印
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrint?' + end);
                } else if ($scope.printType == 'PaymentPlanPrint') {
                    //缴费通知书
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePaymentNoticePrint?' + end);
                }
            }
            //打印设置弹出
            $scope.policyDisabled=false
            $scope.orderLayerShow = false;
            $scope.configPrintSet = function() {
                $scope.orderLayerShow = !$scope.orderLayerShow;
                if($scope.orderLayerShow){
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }else{
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }
                if($scope.printType=='PolicyPrint' || $scope.printType=='PolicyPrint1' ){
                    $scope.policyDisabled=false
                }else{
                    $scope.policyDisabled=true
                }

            };
         /*   //打印类型选择
            $scope.printtype = 'PolicyPrint';
            $scope.choosePrintype = function (type) {
                $scope.printtype = type;
            };*/
            //打印类型选择
            $scope.policyDisabled=false
            $scope.printType = 'PolicyPrint';//默认选择的打印类型
            $scope.choosePrintype = function (type) {
                $scope.printType = type;
                if(type=='PolicyPrint' || type=='PolicyPrint1'){
                    $scope.policyDisabled=false
                }else{
                    $scope.policyDisabled=true
                }
            };
            //打印设置确定关闭设置页面
          /*  $scope.printSure = function () {
                //保存设置
                //待完善
                //打印设置页面关闭
                $scope.orderLayerShow = false

            };*/
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
            $scope.PlantingExcelDto={}
            $scope.downloadBeforeEndorseList = function (info) {
                $scope.PlantingExcelDto.userCode = $rootScope.user.userCode;
                $scope.PlantingExcelDto.policyNo = info.policyNo;
                $scope.PlantingExcelDto.payNo = 1;
                $scope.PlantingExcelDto.pageSize = 10;
                $$finder.find('getEndorExcel', $scope.PlantingExcelDto, {
                    success: function (data) {
                        console.log(data);
                        //window.open(data.content.fileId);
                        $window.open(data.content.fileId);
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.downloadChgList=function(info){
                $$finder.find('getChgEndorExcel', {
                    policyNo:info.policyNo
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            $window.open(data.content.shortLink);
                        }else if(data.code=='9999'){
                            layer.open({
                                //offset: ['38%', '31%'],
                                scrollbar: false,
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: data.message,
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
            $scope.downloadAfterEndorseList=function(info){
                $$finder.find('getAfterEndorExcel', {
                    endorseNo:info.endorseNo
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            $window.open(data.content.shortLink);
                        }else if(data.code=='9999'){
                            layer.open({
                                //offset: ['38%', '31%'],
                                scrollbar: false,
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: data.message,
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
            //打印信息选择
            $scope.isActive = function (type) {
                var printType = $scope.printType == type ? true : false;
                return printType
            };
            //关闭弹出框
            $scope.cancel = function () {
                $scope.orderLayerShow = false;
                $scope.showorderlayerBox = false;
                $scope.showReviseOfficial=false;
                $scope.showCheckOfficial=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            };
            //全选/多选功能按钮
            $scope.orderChecked = false;

            //测试数据
            $scope.$watch('endorse.prpPhead.businessType1.selected', function (a, b) {
                console.log(a)
                console.log(b)
            })


            var go = function (item, type) {
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIEndorse3107edit', {
                    editType: type,
                    bizNo: item.endorseNo,
                    policyNo:item.policyNo
                })

            };
            $scope.UIEndorseSee = function (item) {  //跳转批单查看页面
                go(item, 'show');
            };


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

            /**
             * 提交核批
             */
            $scope.submitEndorse = function () {
                var list=[];
                var layerflag=false;
                angular.forEach($scope.proposal.QueryList,function(dto){
                    var fall=true;
                    if(dto.underwriteFlag=="初始值" || dto.underwriteFlag=="核批退回" ){
                        var fall=false;
                    }
                    if(dto.checked&& fall){
                        layerflag=true;
                        dto.checked=false;
                    }else if(dto.checked){
                        list.push(dto.endorseNo);
                    }
                });
                if(list.length<=0){
                    var cont;
                    cont = '请选择提交正确的批单号码';
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
                    $scope.select_all="";
                }else if(list.length>0&&layerflag){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '已剔除错误状态的单号,是否继续提交核批！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            var keywords = {
                                "dLComCode": $rootScope.user.loginComCode,
                                "endorseNos":list,
                                "userCode": $rootScope.user.userCode};
                            $$finder.find('saveUndwrtByEndorseNo',keywords, {
                                success: function(data) {
                                    if(data  && data.content){
                                        console.log(data);
                                        layer.open({
                                            area: ['37%', '318px'],
                                            /*offset: ['28%', '30%'],*/
                                            scrollbar: false,
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: data.content[0],
                                            btn: ["关闭"],
                                            btn2: function (index, layero) {
                                                return false;
                                            }
                                        });
                                    }
                                },
                                error: function(e) {
                                    console.log(e);
                                }
                            });
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
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '是否确认提交核批！',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            var keywords = {
                                "dLComCode": $rootScope.user.loginComCode,
                                "endorseNos":list,
                                "userCode": $rootScope.user.userCode};
                            $$finder.find('saveUndwrtByEndorseNo',keywords, {
                                success: function(data) {
                                    if(data  && data.content){
                                        console.log(data);
                                        layer.open({
                                            area: ['37%', '318px'],
                                            /*offset: ['28%', '30%'],*/
                                            skin: 'large-layer-content',
                                            scrollbar: false,
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            content: data.content[0],
                                            btn: ["关闭"],
                                            btn2: function (index, layero) {
                                                return false;
                                            }
                                        });
                                    }
                                    $scope.submit1();
                                },
                                error: function(e) {
                                    console.log(e);
                                }
                            });
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            };
        }]);
});
