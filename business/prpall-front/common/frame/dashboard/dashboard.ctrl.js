/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer',
    'config'
], function (app,constants,layer,config) {
    'use strict';
    app.registerController('dashboardCtrl', ['$rootScope', '$scope','$$finder','$$logout','$sce','$state','$window','$$user',"$compile",
        function ($rootScope, $scope,$$finder,$$logout,$sce,$state,$window,$$user,$compile){
            $scope.dashboard='dasdadsd';
            $scope.proposal={};
            $scope.businessType='1';
            $scope.oprateTypeAll=[{title:'所有类型',code:0},{title:'待提交核保',code:1},{title:'核保退回待修改',code:2},{title:'待提交核批',code:3},{title:'核批退回待修改',code:4}
                ,{title:'待打印',code:5},{title:'待保存',code:6}];
            $scope.oprateTypeDetail=[{title:'所有类型',code:0},{title:'待保存',code:6}];
            //分页设置
            $scope.submit=function () {
                $$finder.find('queryMyJobByCondition', {
                    "userCode":$rootScope.user.userCode,
                    "businessNo":businessNo==null?"":$scope.businessNo,
                    "queryFlag":$scope.businessType,
                    "status":$scope.opType,
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if(data.code=="0000"){
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.list=data.content.content;
                            var index =$scope.paginationConfmm.itemsPerPage*($scope.paginationConfmm.currentPage-1);
                            for(var i=0;i< $scope.list.length;i++){
                                $scope.list[i].number=index+i+1;
                            }
                        }
                    }
                });
            }
            var initPage2 = function() {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 5,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if($scope.paginationConfmm.totalItems==0){
                            return ;
                        }else{
                            $scope.submit()
                        }
                    }

                };
            };
               //var pageNo=$scope.paginationConfmm.currentPage;
               // var pageSize= $scope.paginationConfmm.itemsPerPage;
               // var index=paginationConfmm.currentPage*(paginationConfmm.itemsPerPage-1);
            initPage2();

            $rootScope.changeBuesnessNo=function(){
                // 登录成功后请求菜单树
                //待处理投保单保单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "2",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.proposalNo = data.content.content
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.proposalNo.length; i++) {
                                $scope.proposalNo[i].number = index + i + 1;
                            }
                            $scope.proposal.proposalNo = data.content.totalCount;
                        }
                    }
                });
                //当日签单，未交保费，应收保费
                $$finder.find('queryPremiumInfo', {
                    "comCode": $rootScope.user.loginComCode
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            $scope.premiumAndAmount = data.content;
                        }
                    }
                })
                //待处理保单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "3",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.policyNo = data.content.content;
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.policyNo.length; i++) {
                                $scope.policyNo[i].number = index + i + 1;
                            }
                            $scope.proposal.policyNo = data.content.totalCount;
                        }
                    }
                });
                //待处理批单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "4",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.endorseNo = data.content.content;
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.endorseNo.length; i++) {
                                $scope.endorseNo[i].number = index + i + 1;
                            }
                            $scope.proposal.endorseNo = data.content.totalCount;
                        }
                    }
                });
                //待处理暂存单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "1",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.proposal.temporary = data.content.totalCount;
                            $scope.temporary = data.content.content
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.temporary.length; i++) {
                                $scope.temporary[i].number = index + i + 1;
                            }
                            $scope.list = $scope.temporary
                            $scope.paginationConfmm.itemsPerPage = 5;
                            $scope.paginationConfmm.currentPage = 1;
                            $scope.paginationConfmm.totalItems = $scope.proposal["temporary"];
                        }
                    }
                });
            }
            var _initIndexData = function () {

                // 登录成功后请求菜单树
                //待处理投保单保单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "2",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.proposalNo = data.content.content
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.proposalNo.length; i++) {
                                $scope.proposalNo[i].number = index + i + 1;
                            }
                            $scope.proposal.proposalNo = data.content.totalCount;
                        }
                    }
                });
                //当日签单，未交保费，应收保费
                $$finder.find('queryPremiumInfo', {
                    "comCode": $rootScope.user.loginComCode
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            $scope.premiumAndAmount = data.content;
                        }
                    }
                })
                //待处理保单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "3",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.policyNo = data.content.content;
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.policyNo.length; i++) {
                                $scope.policyNo[i].number = index + i + 1;
                            }
                            $scope.proposal.policyNo = data.content.totalCount;
                        }
                    }
                });
                //待处理批单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "4",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.endorseNo = data.content.content;
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.endorseNo.length; i++) {
                                $scope.endorseNo[i].number = index + i + 1;
                            }
                            $scope.proposal.endorseNo = data.content.totalCount;
                        }
                    }
                });
                //待处理暂存单
                $$finder.find('queryMyJobByCondition', {
                    "userCode": $rootScope.user.userCode,
                    "businessNo": "",
                    "queryFlag": "1",
                    "pageNo": $scope.paginationConfmm.currentPage,
                    "pageSize": $scope.paginationConfmm.itemsPerPage
                }, {
                    success: function (data) {
                        if (data.code == "0000") {
                            angular.forEach(data.content.content,function(dto) {
                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                    dto.status = '待打印';
                                }
                            })
                            $scope.proposal.temporary = data.content.totalCount;
                            $scope.temporary = data.content.content
                            var index = $scope.paginationConfmm.itemsPerPage * ($scope.paginationConfmm.currentPage - 1);
                            for (var i = 0; i < $scope.temporary.length; i++) {
                                $scope.temporary[i].number = index + i + 1;
                            }
                            $scope.list = $scope.temporary
                            $scope.paginationConfmm.itemsPerPage = 5;
                            $scope.paginationConfmm.currentPage = 1;
                            $scope.paginationConfmm.totalItems = $scope.proposal["temporary"];
                        }
                    }
                });
            };

            $rootScope.onQuery=function() {
             var userInfo = $rootScope.user;
                if (userInfo) {
                    setTimeout(function () {
                        _initIndexData();
                    }, 200);
                } else {
                    $$user.getLoginUser().then(function (data) {
                        /* $rootScope.start();
                         if(data.data.content.retCode == '200') {
                         }*/
                    }, function () {
                    });
                    setTimeout(function () {
                        _initIndexData();
                    }, 200);
                }
            }
            $rootScope.onQuery();
            var queryFlag='1'
            $scope.type = "temporary"
            $scope.changeClick=function(type){
                console.log(type)
                $scope.type = type;

                if(type == 'temporary'){
                    queryFlag='1'
                    $scope.oprateTypeDetail=[{title:'所有类型',code:0},{title:'待保存',code:6}];
                }
                if(type == 'proposalNo'){
                    queryFlag='2'
                    $scope.oprateTypeDetail=[{title:'所有类型',code:0},{title:'待提交核保',code:1},{title:'核保退回待修改',code:2},{title:'待打印',code:5}];
                }
                if(type == 'policyNo'){
                    queryFlag='3'
                    $scope.oprateTypeDetail=[{title:'所有类型',code:0},{title:'待打印',code:5}];
                }
                if(type == 'endorseNo'){
                    queryFlag='4'
                    $scope.oprateTypeDetail=[{title:'所有类型',code:0},{title:'待提交核批',code:3},{title:'核批退回待修改',code:4},{title:'待打印',code:5}];
                }
                $scope.opType = $scope.oprateTypeDetail[0].title;
                $scope.list=$scope[type]
                $scope.paginationConfmm.itemsPerPage=5;
                $scope.paginationConfmm.currentPage=1;
                $scope.paginationConfmm.totalItems = $scope.proposal[type];
                $scope.businessType=queryFlag;
            }
            //业务类型改变时 操作类型联动
            $scope.BsType=function(altt){
                if(altt=='1'){
                    $scope.type = 'temporary';
                }else if(altt=='2'){
                    $scope.type = 'proposalNo';
                }else if(altt=='3'){
                    $scope.type = 'policyNo';
                }else if(altt=='4'){
                    $scope.type = 'endorseNo';
                }
                if ($scope.type == 'temporary') {
                    queryFlag = '1'
                }
                if ($scope.type == 'proposalNo') {
                    queryFlag = '2'
                }
                if ($scope.type == 'policyNo') {
                    queryFlag = '3'
                }
                if ($scope.type == 'endorseNo') {
                    queryFlag = '4'
                }
                $scope.businessType=queryFlag;
            }
            //精确查询
            var businessNo=$scope.businessNo
            $scope.queryClick=function (businessNo,businessType) {

                if($scope.businessNo!=undefined&&$scope.businessNo!=''){
                    if($scope.businessNo.length<15) {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,//隐藏滚动条
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "业务号需输入至少15位数!",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return
                    }
                }
                if(businessType!='0')
                {
                    $scope.BsType(businessType);

                }
                    $$finder.find('queryMyJobByCondition', {
                        "userCode":$rootScope.user.userCode,
                        "businessNo":businessNo==null?"":$scope.businessNo,
                        "queryFlag":$scope.businessType,
                        "status":$scope.opType,
                        "pageNo":1,
                        "pageSize": $scope.paginationConfmm.itemsPerPage
                    }, {
                        success: function (data) {
                            if(data.code=="0000"&&data.content.content.length>0){
                                angular.forEach(data.content.content,function(dto) {
                                    if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                        dto.status = '待打印';
                                    }
                                })
                                $scope.list=data.content.content;
                                queryFlag='0';
                                $scope.paginationConfmm.totalItems=data.content.totalCount;
                                $scope.paginationConfmm.currentPage=data.content.currentPage;
                            }else{
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,//隐藏滚动条
                                    title: '温馨提示',
                                    content: "查询的数据不存在，请重新查询！",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        }
                    });



            }
            //全选
            $scope.checked1 = [];
            $scope.selectAll=function(){
                if($scope.select_all){
                    $scope.checked1 = [];
                    angular.forEach($scope.list,function(data){
                        data.checked=true;
                        $scope.checked1.push (data.businessNo);
                    })
                } else {
                    angular.forEach($scope.list,function(data){
                        data.checked=false;
                        $scope.checked1 = [];
                    })
                }
            }
            //单选，反选
            $scope.selectOne=function(){
                angular.forEach($scope.list , function (data) {
                    var index = $scope.checked1.indexOf(data.businessNo);
                    if(data.checked && index === -1) {
                        $scope.checked1.push(data.businessNo);
                    } else if (!data.checked && index !== -1){
                        $scope.checked1.splice(index, 1);
                    };
                });
                if($scope.list.length==$scope.checked1.length){
                    $scope.select_all=true;
                }else {
                    $scope.select_all=false;
                }
            }
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                //$state.go('UIPolicy3107show',{'policyNo':policyNo})
                var url=$state.href('UIPolicy3107show',{'policyNo':policyNo,'authSystemFlag':'claim'});
                window.open(url,"_blank");
            }
            var initPage3 = function() {
                $scope.paginationConfmm4= {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 5,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if($scope.paginationConfmm.totalItems==0){
                            return ;
                        }else{
                            $$finder.find('queryByPrpNoPrpCmainInfoList',{
                                proposalNos: $scope.billNoList,
                                "startDate":$scope.info.startDate,
                                "riskCode":$scope.info.riskCode,
                                "businessType1":$scope.info.businessType1,
                                "pageNo": $scope.paginationConfmm4.currentPage,
                                "pageSize": $scope.paginationConfmm4.itemsPerPage
                            }, {
                                success: function (data) {
                                    console.log(data);
                                    if (data.code == '0000' && data.content.content.length > 0) {
                                        $scope.detailRelativeInsureList = data.content.content;
                                        $scope.paginationConfmm4.totalItems = data.content.totalCount;
                                    }else if(data.code=='9999'){
                                        layer.open({
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: data.message,
                                            btn: ['确定'],
                                            btn1: function(index, layero){
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            },
                                        })
                                    }
                                }
                            }
                            )}
                    }

                };
            };
            initPage3();
            $scope.lookDetailRelativeInsureList= function () {
                $scope.showDetailRelativeInsure=true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条

            }
            $scope.closeDetailRelativeInsureList= function () {
                $scope.showDetailRelativeInsure=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.closeRelativeInsureListCode= function () {
                $scope.relativeInsureListCode=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.goRelativeInsureListCode= function () {
                $scope.relativeInsureListCode=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
                $$finder.find('submitUndwrtByProposal', {
                    "proposalno": $scope.billNoList,//保单号
                    "userCode":$rootScope.user.userCode,//用户编号
                    "DLComCode":$rootScope.user.loginComCode//机构编号,暂时写死了
                }, {
                    success: function (data) {
                        if(data.code=="0000"){
                            var content = "";
                            if (data.code == "0000") {
                                if (data.content.status != undefined && data.content.status == "9999") {
                                    content = "webService访问异常"//data.message;
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
                                    area: '37%',
                                    //offset: ['28%', '30%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,//隐藏滚动条
                                    closeBtn: 0,
                                    title: '提交核保',
                                    content: content,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        $$finder.find('queryMyJobByCondition', {
                                            "userCode":$rootScope.user.userCode,
                                            "businessNo":"",
                                            "queryFlag":"2",
                                            "pageNo": $scope.paginationConfmm.currentPage,
                                            "pageSize": $scope.paginationConfmm.itemsPerPage
                                        }, {
                                            success: function (data) {
                                                if(data.code=="0000"){
                                                    angular.forEach(data.content.totalCount,function(dto) {
                                                        if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                                            dto.status = '待打印';
                                                        }
                                                    })
                                                    $scope.proposal.proposalNo=data.content.totalCount;
                                                    queryFlag='2';
                                                    $scope.proposalNo=data.content.content
                                                    $scope.list=$scope.proposalNo;
                                                    $scope.paginationConfmm.itemsPerPage=5;
                                                    $scope.paginationConfmm.totalItems =data.content.content.totalCount ;
                                                }
                                            }
                                        });
                                        layer.close(index);
                                    }
                                });
                            }
                        }else if(data.code=='9999'){
                            layer.open({
                                area: ['37%', '318px'],
                                //offset: ['28%', '30%'],
                                skin: 'large-layer-content',
                                scrollbar: false,//隐藏滚动条
                                closeBtn: 0,
                                title: '提交核保',
                                content: data.message,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            })
                        }
                    }
                });
            }
            //提交核保//$scope.checked1
            $scope.relativeInsureListCode=false;
            $scope.showDetailRelativeInsure=false;
            $scope.submitUndwrtByProposal = function(info){
                $scope.info=info;
                $scope.billNoList=[info.businessNo];
                layer.open({
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    title: '温馨提示',
                    scrollbar: false,//隐藏滚动条
                    content: '是否确认提交核保',
                    btn: ['确定','取消'],
                    btn1: function (index, layero) {
                        //疑似重复性校验
                        $$finder.find('queryByPrpNoPrpCmainInfoList',{
                            proposalNos: $scope.billNoList,
                            "startDate":info.startDate,
                            'endDate':info.endDate,
                            "riskCode":info.riskCode,
                            "businessType1":info.businessType1,
                            "pageNo": $scope.paginationConfmm4.currentPage,
                            "pageSize": $scope.paginationConfmm4.itemsPerPage
                        },{
                            success: function (data) {
                                console.log(data);
                                if(data.code=='0000'&&data.content.content.length>0){
                                    $scope.relativeInsureListCode=true;
                                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                                    $scope.detailRelativeInsureList=data.content.content;
                                    $scope.paginationConfmm4.totalItems=data.content.totalCount;
                                }else if(data.code=='9999'){
                                    layer.open({
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        scrollbar: false,
                                        content: data.message,
                                        btn: ['确定'],
                                        btn1: function(index, layero){
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        },
                                    })
                                }else{
                                    $$finder.find('submitUndwrtByProposal', {
                                        "proposalno": $scope.billNoList,//保单号
                                        "userCode":$rootScope.user.userCode,//用户编号
                                        "DLComCode":$rootScope.user.loginComCode//机构编号,暂时写死了
                                    }, {
                                        success: function (data) {
                                            if(data.code=="0000"){
                                                var content = "";
                                                if (data.code == "0000") {
                                                    if (data.content.status != undefined && data.content.status == "9999") {
                                                        content ="webService访问异常";
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
                                                        scrollbar: false,//隐藏滚动条
                                                        closeBtn: 0,
                                                        title: '提交核保',
                                                        content: content,
                                                        btn: ['确定'],
                                                        btn1: function (index, layero) {
                                                            $$finder.find('queryMyJobByCondition', {
                                                                "userCode":$rootScope.user.userCode,
                                                                "businessNo":"",
                                                                "queryFlag":"2",
                                                                "pageNo": $scope.paginationConfmm.currentPage,
                                                                "pageSize": $scope.paginationConfmm.itemsPerPage
                                                            }, {
                                                                success: function (data) {
                                                                    if(data.code=="0000"){
                                                                        angular.forEach(data.content.content,function(dto) {
                                                                            if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                                                                dto.status = '待打印';
                                                                            }
                                                                        })
                                                                        $scope.proposal.proposalNo=data.content.totalCount;
                                                                        queryFlag='2';
                                                                        $scope.proposalNo=data.content.content
                                                                        $scope.list=$scope.proposalNo;
                                                                        $scope.paginationConfmm.itemsPerPage=5;
                                                                        $scope.paginationConfmm.totalItems =data.content.totalCount ;
                                                                    }
                                                                }
                                                            });
                                                            layer.close(index);
                                                        }
                                                    });
                                                }
                                            }else if(data.code=='9999'){
                                                layer.open({
                                                    area: ['37%', '318px'],
                                                    //offset: ['28%', '30%'],
                                                    skin: 'large-layer-content',
                                                    scrollbar: false,//隐藏滚动条
                                                    closeBtn: 0,
                                                    title: '提交核保',
                                                    content: data.message,
                                                    btn: ['确定'],
                                                    btn1: function (index, layero) {
                                                        layer.close(index);
                                                    }
                                                })
                                            }
                                        }
                                    });
                                }
                            }
                        })
                        layer.close(index);
                    },
                    btn2: function (index3, layero) {
                        layer.close(index3);
                     }
        });
            }

            //提交核批//$scope.checked1
            $scope.submitEnorder = function(billNo){
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,//隐藏滚动条
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '是否确认提交核批',
                    btn: ['确定','取消'],
                    btn1: function (index, layero) {
                        $$finder.find('saveUndwrtByEndorseNo', {
                            "endorseNos":[billNo],//保单号
                            "userCode":$rootScope.user.userCode,//用户编号
                            "dLComCode":$rootScope.user.loginComCode//机构编号,暂时写死了
                        }, {
                            success: function (data) {
                                if(data.code=="0000"){
                                    var content = "";
                                    if (data.code == "0000") {
                                        if (data.content.status != undefined && data.content.status == "9999") {
                                            content = "webService访问异常"//data.message;
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
                                            scrollbar: false,//隐藏滚动条
                                            area: ['37%', '318px'],
                                            //offset: ['28%', '30%'],
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '提交核批',
                                            content: content,
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                $$finder.find('queryMyJobByCondition', {
                                                    "userCode":$rootScope.user.userCode,
                                                    "businessNo":"",
                                                    "queryFlag":"4",
                                                    "pageNo": $scope.paginationConfmm.currentPage,
                                                    "pageSize": $scope.paginationConfmm.itemsPerPage
                                                }, {
                                                    success: function (data) {
                                                        if(data.code=="0000"){
                                                            angular.forEach(data.content.content,function(dto) {
                                                                if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                                                    dto.status = '待打印';
                                                                }
                                                            })
                                                            $scope.proposal.endorseNo=data.content.totalCount;
                                                            queryFlag='4';
                                                            $scope.endorseNo=data.content.content;
                                                            $scope.list=$scope.endorseNo;
                                                            $scope.paginationConfmm.itemsPerPage=5;
                                                            $scope.paginationConfmm.totalItems =data.content.content.totalCount ;
                                                        }
                                                    }
                                                });
                                                layer.close(index);
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    },
                    btn2: function (index3, layero) {
                        layer.close(index3);
                    }
                });
            }

            //打印类型选择
            //$scope.printType = 'PolicyPrint';//默认选择的打印类型
            $scope.choosePrintype = function (type) {
                $scope.printType = type;
                if(type=='PolicyPrint'||type=='original'){
                    $scope.policyDisabled=false
                }else{
                    $scope.policyDisabled=true
                }
            };
            //切换单证类型更新流水号
            $scope.changeVisaType=function(visaSerialNos){
                angular.forEach(visaSerialNos, function (_data) {
                    if($scope.visaCode==_data.visaCode) {
                        $scope.proposal.visaSerisal=_data.visaSerisal;
                    }
                })

            }
            //待打印
            $scope.configPrintSetShow = false;
            $scope.print=function(businessNo){
                if($scope.type=='proposalNo'){//当是投保单打印
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '是否确认打印！',
                        btn: ['确定', '取消'],
                        btn1: function (index1, layero) {
                            var print = 'proposalNo=' + businessNo;
                            $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/InsuranceFormPrint?' + print);
                            layer.close(index1);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });

                }else if($scope.type=='policyNo'){//当是保单打印
                    $scope.printType = 'PolicyPrint';//默认选择的打印类型
                    $scope.choosePrintype('PolicyPrint');
                    $scope.configPrintSetShow = true;
                     $("html,body").css({overflow:"hidden"});//隐藏滚动条
                     $scope.policyNo1=businessNo;
                     $scope.proposalNo1=businessNo
                    $$finder.find('queryVisaCodesAndVisaSerialNos', {
                        "businessNo": businessNo,
                        "comCode": $rootScope.user.loginComCode,
                        "userCode":$rootScope.user.userCode
                    }, {
                        success: function (data) {
                            var visaCodeAndNameList=[]
                            angular.forEach(data.content, function (_data,index) {
                                _data.visaSerisal = _data.visaSerisal;
                                _data.visaType=_data.visaCode+'-'+_data.visaName;
                                _data.visaCode=_data.visaCode;
                                visaCodeAndNameList.push(_data)
                            })
                            $scope.visaSerialNoList=visaCodeAndNameList;
                            $scope.codeNamePolicy=""
                            $scope.visaSerialNoList=visaCodeAndNameList;
                            $scope.visaCodePolicy=data.content[0].visaCode;
                            $scope.codeNamePolicy = data.content[0].visaCode+'-'+data.content[0].visaName;
                            $scope.proposal.visaSerisal = data.content[0].visaSerisal;
                        },
                        error: function (e) {
                            options.error(e);
                        }

                    });
                }else{//批单打印
                    $scope.printType = 'original';
                    $scope.choosePrintype('original');
                    $$finder.find('queryVisaCodesAndVisaSerialNos',{
                        "businessNo":businessNo,
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
                            var visaCodeAndNameList=[]
                            angular.forEach(data.content, function (_data,index) {
                                _data.visaSerisal = _data.visaSerisal;
                                _data.visaType=_data.visaCode+'-'+_data.visaName;
                                _data.visaCode=_data.visaCode;
                                visaCodeAndNameList.push(_data)
                            })
                            $scope.visaSerialNos=visaCodeAndNameList;
                            $scope.codeName="";
                            $scope.visaCodeEndorse=data.content[0].visaCode;
                            $scope.codeName = data.content[0].visaCode+'-'+data.content[0].visaName;
                            $scope.proposal.visaSerisal = data.content[0].visaSerisal;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                    $scope.orderLayerShow = true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    $scope.pdendorseNo=businessNo;
                }
            }
            $scope.printSure2 = function(endorseNo) {
                var print = 'endorseNo=' + endorseNo;
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

                    //批单正本全打
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrintOriginal?' + print + '&&comCode=' + $rootScope.user.loginComCode + '&&visaCode=' + $scope.visaCodeEndorse+ '&&visaSerialNo=' + $scope.proposal.visaSerisal+'&&userCode='+ $rootScope.user.userCode);

                    ////批单正本全打
                    //$window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrintOriginal?' + end);
                } else if ($scope.printType == 'duplicate') {
                    //批单抄件打印
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePrint?' + print);
                } else if ($scope.printType == 'advice') {
                    //缴费通知书
                    $window.open("/" + config.systemConfig.systemFlag + config.systemConfig.printFile + '?fileID=' + '/api/agriprpall/print/EndorsePaymentNoticePrint?' + print);
                }
            }

            //打印设置确定关闭设置页面
            $scope.configPrintSetfa = function () {
                //保存设置
                //待完善
                //打印设置页面关闭
                $scope.orderLayerShow = false
                $("html,body").css({overflow:"auto"});//出现滚动条

            };
            $scope.configPrintSet = function() {
                $scope.configPrintSetShow =false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //打印设置确定关闭设置页面1
            $scope.printSure = function() {
                if ($scope.printType == 'PolicyPrint') {
                    if (!$scope.proposal.visaSerisal || $scope.proposal.visaSerisal == '无可使用流水号') {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '保单打印时流水起始号不能为空!',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return false;
                    }
                }
                var policyNo= $scope.policyNo1;
                var proposalNo=$scope.proposalNo1;
                if($scope.printType == 'PolicyPrint'){
                    //保单正本打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/PolicyPrint?policyNo=' + policyNo);
                }else if($scope.printType == 'PolicyPrint1'){
                    //保单副本打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/PolicyPrint?policyNo=' + policyNo);
                }else if($scope.printType == 'InsuranceFormPrint'){
                    //投保单打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/InsuranceFormPrint?proposalNo=' + proposalNo);
                }else if($scope.printType == 'MainPrint'){
                    //主险清单打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/MainPrint?policyNo=' + policyNo);
                }else if($scope.printType == 'SpecialyAgreedPrint'){
                    //特别约定打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/SpecialyAgreedPrint?policyNo=' + policyNo);
                }else if($scope.printType == 'SubPrint'){
                    //附加险清单打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/SubPrint?policyNo=' + policyNo)
                }else if($scope.printType == 'PaymentPlanPrint'){
                    //缴费计划打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/PaymentPlanPrint?policyNo=' + policyNo)
                }else if($scope.printType == 'PaymentNoticePrint'){
                    //缴费通知书打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/PaymentNoticePrint?policyNo=' + policyNo)
                }else if($scope.printType == 'FilePrint'){
                    //承保卷宗打印
                    $window.open("/"+config.systemConfig.systemFlag+config.systemConfig.printFile+'?fileID=' + '/api/agriprpall/print/FilePrint?policyNo=' + policyNo)
                }else if($scope.printType == 'B5'){
                    //B5条款打印
                    var riskB5=policyNo.substring(1,5);
                    var com=policyNo.substring(5,7);
                    if(riskB5=='3107'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3107'+com)
					}else if(riskB5=='3101'){
						$window.open('/api/agriprpall/templateFile/download?fileType=3101'+com)		
					}else if(riskB5=='3114'){
						$window.open('/api/agriprpall/templateFile/download?fileType=3114'+com)	
					}else if(riskB5=='3122'){
						$window.open('/api/agriprpall/templateFile/download?fileType=3122'+com)	
					}else if(riskB5=='3126'){
						$window.open('/api/agriprpall/templateFile/download?fileType=3126'+com)
					}else if(riskB5=='3161'){
						$window.open('/api/agriprpall/templateFile/download?fileType=3161'+com)	
                    }else if(riskB5=='3102'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3102'+com)
                    }else if(riskB5=='3108'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3108'+com)
                    }else if(riskB5=='3129'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3129'+com)
                    }else if(riskB5=='3130'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3130'+com)
                    }else if(riskB5=='3134'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3134'+com)
                    }else if(riskB5=='3141'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3141'+com)
                    }else if(riskB5=='3147'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3147'+com)
                    }else if(riskB5=='3155'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3155'+com)
                    }else if(riskB5=='3162'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3162'+com)
                    }else if(riskB5=='3220'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3220'+com)
                    }else if(riskB5=='3224'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3224'+com)
                    }else if(riskB5=='3233'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3233'+com)
                    }else if(riskB5=='3237'){
                        $window.open('/api/agriprpall/templateFile/download?fileType=3237'+com)
                    }
                }
            };
            //打印类型选择
            //$scope.choosePrintype = function (type) {
            //    $scope.printType = type;
            //};
            //打印信息选择
            $scope.isActive = function(type) {
                var printType = $scope.printType == type ? true : false;
                return printType
            }
            //暂存单撤销
            $scope.revocationTem = function (data){
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,//隐藏滚动条
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '是否确认撤单！',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        if (data.status == '已撤单') {
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,//隐藏滚动条
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '该投保单已撤单！',
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        } else {
                            $$finder.find('withdrawProposalnoSubmit', data.businessNo, {
                                success: function (data) {
                                    if(data.code=="0000"){
                                        //待处理暂存单
                                        $$finder.find('queryMyJobByCondition', {
                                            "userCode":$rootScope.user.userCode,
                                            "businessNo":"",
                                            "queryFlag":"1",
                                            "pageNo": $scope.paginationConfmm.currentPage,
                                            "pageSize": $scope.paginationConfmm.itemsPerPage
                                        }, {
                                            success: function (data) {
                                                if(data.code=="0000"){
                                                    $scope.proposal.temporary=data.content.totalCount;
                                                    $scope.temporary=data.content.content
                                                    angular.forEach($scope.temporary,function(dto) {
                                                        if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                                            dto.status = '待打印';
                                                        }
                                                    })
                                                    $scope.list=$scope.temporary;
                                                    $scope.paginationConfmm.itemsPerPage=5;
                                                    $scope.paginationConfmm.totalItems =data.content.content.totalCount ;
                                                }
                                            }
                                        });
                                    }
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
           //投保单撤销
            $scope.revocation = function (data) {
                layer.open({
                    /*offset: ['45%', '40%'],*/
                    skin: 'large-layer-content',
                    scrollbar: false,//隐藏滚动条
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '是否确认撤单！',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        if (data.status == '已撤单') {
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,//隐藏滚动条
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '该投保单已撤单！',
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        } else {
                            $$finder.find('withdrawProposalnoSubmit', data.businessNo, {
                                success: function (data) {
                                    if(data.code=="0000"){
                                        //待处理投保单保单
                                        $$finder.find('queryMyJobByCondition', {
                                            "userCode":$rootScope.user.userCode,
                                            "businessNo":"",
                                            "queryFlag":"2",
                                            "pageNo": $scope.paginationConfmm.currentPage,
                                            "pageSize": $scope.paginationConfmm.itemsPerPage
                                        }, {
                                            success: function (data) {
                                                if(data.code=="0000"){
                                                    $scope.proposal.proposalNo=data.content.totalCount;
                                                    queryFlag='2';
                                                    $scope.proposalNo=data.content.content
                                                    angular.forEach($scope.proposalNo,function(dto) {
                                                        if((dto.status=='核保通过' || dto.status=='核批通过') && (dto.printNo==''||!dto.printNo)) {
                                                            dto.status = '待打印';
                                                        }
                                                    })
                                                    $scope.list=$scope.proposalNo;
                                                    $scope.paginationConfmm.itemsPerPage=5;
                                                    $scope.paginationConfmm.totalItems =data.content.content.totalCount ;
                                                }
                                             }
                                        });
                                    }
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

            //重置清空搜索条件
            $scope.stateToNext=function(){
                $scope.businessType='0';
                $scope.opType='0'
                $scope.businessNo=''
            }
            //$$finder.find("menuData",{
            //    "comCode":"3400000000",
            //    "userCode":"0537",
            //    "systemCode":"newagriprpall"
            //},{
            //    success: function(answer){
            //        //console.log(answer);
            //        if (answer.content) {
            //            $$menuServ.setMenuDate(answer.content);
            //            $scope.leftMenu = answer.content;
            //            var getimges=function(data){
            //                $.each(data,function (index, item) {
            //                    if(item.utiMenuDto.image){
            //                        item.utiMenuDto.image = $sce.trustAsHtml("<i class='iconfont'>&#xe62a;</i>")
            //                    }
            //                    if(item.childMenuList&&item.childMenuList!=0){
            //                        getimges(item.childMenuList)
            //                    }
            //                });
            //            }
            //            getimges($scope.leftMenu)
            //            $scope.data =changeData($scope.leftMenu)
            //        }
            //    },
            //    error:function(error){
            //        console.error("菜单获取错误:",angular.fromJson(error));
            //    }
            //});


            //删除常用功能

        /*    $scope.delete = function(type){
                $scope.isDelete = function(obj){
                    var myFunction = true;
                    if(obj==type){
                        myFunction =true;
                    }else{
                        myFunction =false
                    }
                    return myFunction;
                };
                $('.choose-right').find('.active').remove();

                $scope.isFun =function(parameter){
                    var  delFunction=  parameter==type ? true: false;
                    return delFunction;
                }
                $('.has-comfun').find('.delFunction').remove();

            };*/

            $scope.deleteAll=function(){

                $$finder.find("deleteUserMenuInfo",{
                    "userCode": $rootScope.user.userCode,
                    "menuId": "",
                },{
                    success: function (data) {
                        if(data.code=="0000"){

                        }
                    }
                },{
                    error:function(data){}
                })
            };

            // 弹出增加常用功能弹层或常用功能已满弹层
            $scope.add=function(){
                $("html,body").css({overflow:"hidden"}) //隐藏滚动条
                //var i=$('.choose-right ul li').length;
                /*  if(i>=6){
                 $('.layer-demo').css('display','block');
                 }else{

                 }*/
               $scope.chooseOne('One','001');
                $scope.neworiMenu=[];
                $('.layer-revise').css('display','block');
                //在常用功能弹层导入二级菜单数据
                $scope.data_old =[];
                $scope.data_menuList=[];
                $scope.data_menuId=[];
                $scope.data_url=[];
                console.log($scope.menuData);
                $scope.data_old=$scope.menuData;
                //console.log($scope.data_old);
                for(var j =0;j<$scope.data_old.length;j++){
                    // console.log($scope.data[j].nodes);
                    if($scope.data_old[j].nodes.length>0){
                        for(var x=0; x<$scope.data_old[j].nodes.length; x++){
                            //  console.log($scope.data[j].nodes[x].menuCName);
                            $scope.data_menuList.push($scope.data_old[j].nodes[x].menuCName);
                            $scope.data_menuId.push($scope.data_old[j].nodes[x].menuId+$scope.data_old[j].nodes[x].menuCName);
                            $scope.data_url.push($scope.data_old[j].nodes[x].url);


                            //$scope.data= $scope.data.push($scope.data_menuId+':'+$scope.data_menuList);

                        }
                    }else{
                        if($scope.data_old[j].menuId!='A100000000000000001'){
                            $scope.data_menuList.push($scope.data_old[j].menuCName);
                            $scope.data_menuId.push($scope.data_old[j].menuId+$scope.data_old[j].menuCName);
                            $scope.data_url.push($scope.data_old[j].url);
                        }

                    }

                }
                $rootScope.start();
                $scope.menu="";
                $scope.chooseOne("","");
                $(".has-comfun").find(".new").remove();
                $scope.chooseOne("One","001");




            }//关闭增加常用功能弹层
            $scope.delete_5=function(){
                $('.layer-revise').css('display','none');
                $("html,body").css({overflow:"auto"})  //出现滚动条
            }

            //修改常用功能
            // 选择图片
            $scope.chooseOne =function(type,icon){
                $scope.iconCode=icon;
                $scope.isActive=function(obj){
                    var test = obj==type ? true:false;
                    return test;
                };
                // 增加常用功能
                $scope.addContent=function(){
                    //常用功能区已满
                    /* var j=$('.has-comfun li').length;
                     if(j>=5){
                     $('.layer-demo').css('display','block');
                     $('.layer-revise').css('display','none');
                     }*/
                    // 下拉菜单选择功能
                    $scope.text="";
                    $scope.picture="";
                    $scope.flg=true;
                    $scope.text= $('.revise-select').find("option:selected").text();
                     if($scope.menu==''){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,//隐藏滚动条
                            closeBtn: 0,
                            title: '温馨提示',
                            content:"请选择常用功能菜单!" ,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }
                    //判断是否有该功能
                    angular.forEach($scope.oriMenu, function (data) {
                        if($scope.text==data.menuCName){
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,//隐藏滚动条
                                closeBtn: 0,
                                title: '温馨提示',
                                content:"该功能已存在!" ,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            return $scope.flg=false;
                        }
                    })
                    angular.forEach($scope.neworiMenu, function (data) {
                        if($scope.text==data.menuCName){
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,//隐藏滚动条
                                closeBtn: 0,
                                title: '温馨提示',
                                content:"该功能已在新增列表中!" ,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            return $scope.flg=false;
                        }
                    })
                    //var delete_10 ='<i class="iconfont icon-close" ng-click="">&#xe632;</i>' ;
                    if(type == 'One'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }if(type == 'Two'){
                        $scope.picture=  $('.comfun').find('.active').clone();
                    }if(type == 'Three'){
                        $scope.picture=  $('.comfun').find('.active').clone();
                    }if(type== 'Four'){
                        $scope.picture=  $('.comfun').find('.active').clone();
                    }if(type== 'Five'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }if(type== 'Six'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }if(type== 'Seven'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }if(type=='Eight'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }if(type=='Nine'){
                        $scope.picture =  $('.comfun').find('.active').clone();
                    }
                    if($scope.flg&&$scope.text&&$scope.picture){
                        var addP=$('.has-comfun').append("<li class='new'></li>");
                        var html="<i class=\"iconfont icon-close\" ng-click=\"deleteoriMenu($event,'1','"+$scope.text+"')\">&#xe632;</i>"
                            +"<span>"+$scope.text+"</span>";
                        var $html = $compile(html)($scope);
                        addP.find("li:last").append($html).prepend($scope.picture);
                        $scope.neworiMenu[$scope.neworiMenu.length]={
                            "userCode": $rootScope.user.userCode,
                            "comCode": $rootScope.user.loginComCode,
                            "systemCode": "127",
                            "menuId": 0,
                            "menuCName": $scope.text,
                            "url": $scope.getUrl(),
                            "iconExpand": icon,//字体图标
                            "validStatus": "1",
                            "sysFlag": "prpall"
                        }

                    }

                }
            };
            $scope.neworiMenu=[];//新增的功能
            //删除功能
            $scope.deleteoriMenu= function ($event,str,text) {
                if(str=="0"){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,//隐藏滚动条
                        closeBtn: 0,
                        title: '温馨提示',
                        content:"确定删除？" ,
                        btn: ['确定',"取消"],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $$finder.find("deleteUserMenuInfo",{
                                "userCode": $rootScope.user.userCode,
                                "menuCName":text,
                                "comCode":$rootScope.user.loginComCode
                            },{
                                success: function (data) {
                                    if(data.code=='0000'){
                                        layer.close(index);
                                        $rootScope.start();
                                        console.log($scope.neworiMenu);
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
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,//隐藏滚动条
                        closeBtn: 0,
                        title: '温馨提示',
                        content:"确定删除？" ,
                        btn: ['确定',"取消"],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            angular.element($event.target).parent().remove();
                            angular.forEach($scope.neworiMenu, function (data,index,array) {
                                if(text==data.menuCName){
                                    $scope.neworiMenu.splice(index,1);
                                }
                            })
                            layer.close(index);
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });


                }
            }
            $scope.goOriMenu= function (index) {
                //console.log(index);
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go($scope.oriMenu[index].url);
            }
            //常用功能已满确认
            $scope.delete_8=function(){
                $('.layer-demo').css('display','none');
            }
            $scope.getmenuId= function (text) {
                //获取当前选中功能的id
                $scope.menuList=$scope.data_menuList;
                console.log($scope.menuList);
                $scope.menuId = $scope.data_menuId;

                for(var i=0;i<$scope.menuList.length;i++){
                    if(text == $scope.menuList[i]){
                        $scope.trueId ="A"+$scope.menuId[i].replace(/[^0-9]/ig,"");
                        return $scope.trueId;

                    }
                }
            }
            $scope.getUrl= function () {
                //获取当前选中功能的url
                $scope.menuList=$scope.data_menuList;
                $scope.url = $scope.data_url;

                for(var i=0;i<$scope.menuList.length;i++){
                    if($scope.text == $scope.menuList[i]){
                        $scope.trueUrl = $scope.url[i];
                        return $scope.trueUrl;

                    }
                }
            }

            //保存新添加的常用功能
            $scope.saveFunction=function(data){

                if($scope.neworiMenu.length==0){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,//隐藏滚动条
                        closeBtn: 0,
                        title: '温馨提示',
                        content:"没有新增的功能!" ,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    $('.layer-revise').css('display','none');
                    $("html,body").css({overflow:"auto"})  //出现滚动条
                }else{
                    $$finder.find("saveUserMenu",$scope.neworiMenu,{
                        success: function (data) {
                            if(data.code=="0000"){
                                $rootScope.start();
                            }
                        }
                    },{
                        error:function(data){
                            console.log(data);
                        }
                    })

                    $('.layer-revise').css('display','none');
                    $("html,body").css({overflow:"auto"})  //出现滚动条
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,//隐藏滚动条
                        closeBtn: 0,
                        title: '温馨提示',
                        content:"保存成功!" ,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }

               /* $scope.text= $('.revise-select').find("option:selected").text();
                $scope.iconExpand
                console.log($scope.text);
                $scope.getmenuId($scope.text);
                $$finder.find("saveUserMenu",{
                    "userCode": $rootScope.user.userCode,
                    "systemCode": "127",
                    "menuId": $scope.trueId,
                    "menuCName": $scope.text,
                    "url": "",
                    "iconExpand": $scope.iconCode,//字体图标
                    "validStatus": "1",
                    "sysFlag": "prpall"
                },{
                    success: function (data) {}
                },{
                    error:function(data){}
                })*/
            }

            //常用功能初始化
            $rootScope.start= function () {
                $$finder.find("queryUserMenuInfo",{
                    "userCode": $rootScope.user.userCode,
                    "sysFlag":"prpall",
                    "comCode":$rootScope.user.loginComCode
                },{
                    success: function (data) {
                        if(data.code=="0000"){
                            $scope.oriMenu=[];
                            $scope.oriImage=[];
                            $scope.oriMenu = data.content;
                            console.log($scope.oriMenu);
                            /* for(var i=0;i<$scope.oriMenu.length;i++){
                             $scope.oriImage.push($scope.oriMenu[i].iconExpand);
                             }

                             if( $scope.oriImage='001'){
                             console.log( $scope.oriImage);
                             $scope.oriImage.iconExpand= $sce.trustAsHtml("<i class='iconfont icon-print'>&#xe61d;</i>");
                             }if( $scope.oriImage='002'){
                             console.log( $scope.oriImage);
                             $scope.oriImage.iconExpand= $sce.trustAsHtml("<i class='iconfont icon-print'>&#xe61c;</i>");
                             }*/
                        }


                    }
                },{
                    error:function(data){}
                })
            }

            $rootScope.start();
            //取消常用功能弹层
            $scope.oriFunction = function(){
                $("html,body").css({overflow:"auto"})  //出现滚动条
                $scope.oriMenu={};
                $scope.oriImage={};
                $$finder.find("queryUserMenuInfo",{
                    "userCode": $rootScope.user.userCode,
                    "sysFlag":"prpall",
                    "comCode":$rootScope.user.loginComCode
                },{
                    success: function (data) {
                        if(data.code=="0000"){
                            $scope.oriMenu = data.content;
                            $scope.oriImage=data.iconExpand;
                            if( $scope.oriImage=='001'){
                                console.log( $scope.oriImage);
                            }
                        }
                    }
                },{
                    error:function(data){}
                })
                $('.layer-revise').css('display','none');
            }
            //投保单详情与修改跳转页面
            $scope.getProposalInfo = function (index,addEditExamine) {
                var businessNo=$scope.list[index].businessNo;
                if(businessNo.substring(0,1)==1){
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $state.go('UIproposal3107edit', {proposalNo:businessNo,addEditExamine:addEditExamine})
                }else if(businessNo.substring(0,1)==2){
                    $("html,body").css({overflow:"auto"});//出现滚动条
                        $state.go('UIPolicy3107show',{'policyNo':businessNo,'norepeat':true})
                }else if(businessNo.substring(0,1)==3){
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $state.go('UIEndorse3107edit', {
                        editType: 'show',
                        bizNo: businessNo,
                    })
                }
                }
        //    金额大小单位切换

            $scope.money= function (str,type) {//万
                $scope.delinQuentFeeSumAmount="万";
                if(str){
                    var int=parseInt(str);
                    var x=int.toString().length;
                    switch (x){
                        case 3:$scope.delinQuentFeeSumAmount="十万";break;
                        case 4:$scope.delinQuentFeeSumAmount="百万";break;
                        case 5:$scope.delinQuentFeeSumAmount="千万";break;
                        case 6:$scope.delinQuentFeeSumAmount="亿";break;
                        case 7:$scope.delinQuentFeeSumAmount="十亿";break;
                        case 8:$scope.delinQuentFeeSumAmount="百亿";break;
                        case 9:$scope.delinQuentFeeSumAmount="千亿";break;
                    }
                    if(x>=4){
                        str=int.toString().slice(0,4);
                        str=str.slice(0,2)+"."+str.slice(2);
                    }
                    if(x==3){
                        str=str.toString().replace(/\./, "");
                        str=str.slice(0,2)+"."+str.slice(2,4);
                    }
                    if(type=='sumAmount'){
                        $scope.sumAmount=$scope.delinQuentFeeSumAmount;
                    }else if(type=="sumPremium"){
                        $scope.sumPremium=$scope.delinQuentFeeSumAmount;
                    }else if(type=="delinQuentFeeSumPremium"){
                        $scope.delinQuentFeeSumPremium=$scope.delinQuentFeeSumAmount;
                    }else if(type=="unpaidSumAmount"){
                        $scope.unpaidSumAmount=$scope.delinQuentFeeSumAmount;
                    }else if(type=="unpaidSumPremium"){
                        $scope.unpaidSumPremium=$scope.delinQuentFeeSumAmount;
                    }
                    return str;

                }
            }
        }]);
});