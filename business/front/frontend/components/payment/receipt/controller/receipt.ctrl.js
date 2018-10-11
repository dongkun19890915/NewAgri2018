/*索要发票*/
define(['../module'], function (moduleApp) {
    'use strict';
    var receiptCtrl = function($scope,$state,receiptServ,$stateParams,FormFocus) {
        var searchFlalg=false;
        $scope.salesManFlag = true;
        $scope.expressFlag = true;
        $scope.invoiceSpeFlag = true;
        $scope.invoiceEleFlag = false;
        $scope.invoicePapFlag = false;
        $scope.prpCinvoiceDto = {};
        $scope.prpCinvoiceDto.invoiceType = '0';
        $scope.prpCinvoiceDto.sendWay = '0';
        $scope.invoiceSFlag = false;
        $scope.invoiceEFlag = true;
        $scope.salesmanMFlag = false;
        $scope.expressMFlag = true;
        $scope.receiptLayer = true;
        $scope.onemailLayer = true;
        //初始化分页
        var getInsuredList = function(){
            if(!searchFlalg){
                return;
            }
            $scope.prpCinvoiceDto.policyNo="";
            if(!$scope.PolicyQueryConditionDto.bizNo&&!$scope.PolicyQueryConditionDto.applyName&&!$scope.PolicyQueryConditionDto.identifyNumber){
                angular.alert("请输入至少一项搜索条件！");
                return;
            }
            if(!$scope.PolicyQueryConditionDto.identifyNumber==false&&$scope.PolicyQueryConditionDto.identifyType==undefined){
                angular.alert("投保人证件号码必须和投保人证件类型一起录才能进行查询！");
                return;
            }
            $scope.PolicyQueryConditionDto.pageNo=$scope.paginationConf.currentPage;
            $scope.PolicyQueryConditionDto.pageSize=$scope.paginationConf.itemsPerPage;
            $scope.PolicyQueryConditionDto.bizType='C';
            var PolicyQueryConditionDto = $scope.PolicyQueryConditionDto;

            receiptServ.receiptSearch(PolicyQueryConditionDto).then(
                function(answer){
                    $scope.paginationConf.totalItems = answer.data.totalCount;
                    $scope.reportData=answer.data.list;
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            );
        };
        /*初始化*/
        var initFunc = function(){
            $scope.paginationConf = {
                currentPage: 1,
                totalItems: 0,
                itemsPerPage: 10,
                pagesLength: 10,
                perPageOptions: [10, 20,30,40,50]
            };
            $scope.PolicyQueryConditionDto = {pageNo:$scope.paginationConf.currentPage,
                pageSize:$scope.paginationConf.itemsPerPage};

            $scope.$watch('paginationConf.currentPage + paginationConf.itemsPerPage', getInsuredList);
        };
        initFunc();
        $scope.reportQuery = function(){
            searchFlalg = true;
            getInsuredList();
        };
        $scope.resetForm = function(){
            $scope.PolicyQueryConditionDto={}
        };
        $scope.sendWayClick = function () {
            $scope.salesManFlag = true;
            $scope.expressFlag = true;
            $scope.salesmanMFlag = false;
            $scope.expressMFlag = true;
            $scope.prpCinvoiceDto.sendWay = "0";
        };

        $scope.sendWayClick1 = function () {
            $scope.salesManFlag = false;
            $scope.expressFlag = false;
            $scope.salesmanMFlag = true;
            $scope.expressMFlag = false;
            $scope.prpCinvoiceDto.sendWay = "1";
        };
        /**提示框相关方法**/
        $scope.alert=function(opt){
            $scope.showAlertMsg=opt.msg;
            $scope.showAlertOneLayer=true;
        };
        $scope.showAlertOnlyOneClose =function(){
            $scope.showAlertOneLayer=false;
        };
       //不同发票类型选择不同class
        $scope.invoiceClick = function(){
            $scope.invoiceSpeFlag = true;
            $scope.invoiceEleFlag = false;
            $scope.invoicePapFlag = false;
            $scope.invoiceSFlag = false;
            $scope.invoiceEFlag = true;
            $scope.prpCinvoiceDto.invoiceType = "0";
        };
        $scope.invoiceClick1 = function(){
            $scope.invoiceSpeFlag = false;
            $scope.invoiceEleFlag = true;
            $scope.invoicePapFlag = false;
            $scope.invoiceSFlag = true;
            $scope.invoiceEFlag = false;
            $scope.prpCinvoiceDto.invoiceType = "2";
        };
        $scope.invoiceClick2 = function(){
            $scope.invoiceSpeFlag = false;
            $scope.invoiceEleFlag = false;
            $scope.invoicePapFlag = true;
            $scope.invoiceSFlag = true;
            $scope.invoiceEFlag = false;
            $scope.prpCinvoiceDto.invoiceType = "1";
        };
        //提交申请弹层关闭芳芳
        $scope.insuredOnlyOneClose = function(){
            $scope.receiptLayer = true;
        };
        //点击退出跳转主页面
        $scope.onEdit = function(){
            $state.go("main.index")
        };
        //发送邮件弹层关闭方法
        $scope.receiptOpenClose = function(){
            $scope.onemailLayer = true;
        };
        $scope.radioCheck = function(d){
            $scope.prpCinvoiceDto.policyNo=d.policyNo;
            $scope.prpCinvoiceDto.sumPremium=d.sumPremium;
        };
        //提交申请校验
        $scope.onEmail = function(){
            if($scope.prpCinvoiceDto.policyNo==undefined||$scope.prpCinvoiceDto.policyNo==""){
                $scope.receiptLayer = false;
                return;
            }

            if($scope.invoiceSFlag == false){
                if(!this.proposalForm.$valid){
                    FormFocus.focusEle("proposalForm");
                    return;
                }
            }
            if($scope.expressMFlag == false){
                if(!this.invoicForm.$valid){
                    FormFocus.focusEle("invoicForm");
                    return;
                }
            }
            if($scope.salesmanMFlag == false){
                if(!this.invoicForm2.$valid){
                    FormFocus.focusEle("invoicForm2");
                    return;
                }
            }
            if($scope.invoiceEFlag == false){
                if(!this.proposalForm2.$valid){
                    FormFocus.focusEle("proposalForm2");
                    return;
                }
            }
            $scope.onemailLayer = false;


        };
        //发送邮箱方法
        $scope.onSubmits = function(){
            //邮箱校验
            if(!this.emailForm.$valid){
                FormFocus.focusEle("emailForm");
                return;
            }else {
                receiptServ.onSubmits($scope.prpCinvoiceDto).then(
                    function (answer) {
                        $state.go("main.receiptSuccess");
                    }, function (error) {
                        //cconsole.log(JSON.stringify(error.data));
                    }
                )
            }
        };
    };
    moduleApp.controller('receiptCtrl',['$scope','$state','receiptServ','$stateParams','FormFocus',receiptCtrl]);
});
