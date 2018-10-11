/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportProposalCtrl = function($scope,$state,reportProposalServ,applicationFileUploadLayerServ,$stateParams,$filter) {
        $scope.reportFileSearchLayer = false;
        $scope.reportInsuredLayer = false;
        $scope.agentFlag = true;
        if($stateParams.policyDetailParam && $stateParams.policyDetailParam=='proposal'){
            $scope.policyDetailParam=$stateParams.policyDetailParam;
        }
        $scope.$watch('reportInsuredSwitch', function(){
            $scope.reportInsured =$scope.reportInsuredSwitch;
        });

        $scope.$watch('queryEndorseTempTotalItems', function(){
            if($scope.queryEndorseTempTotalItems){
                $scope.reportPaginationConf.totalItems=$scope.queryEndorseTempTotalItems;
                $scope.$watch('reportPaginationConf.currentPage + reportPaginationConf.itemsPerPage', $scope.queryCondition);
            }
        });

        //初始化界面
        var getReportList = function(){
            var InsuredFuzzyQueryConditionDto = {};
            InsuredFuzzyQueryConditionDto.policyNo = $stateParams.policyNo;
            InsuredFuzzyQueryConditionDto.pageNo = $scope.reportPaginationConf.currentPage;
            InsuredFuzzyQueryConditionDto.pageSize = $scope.reportPaginationConf.itemsPerPage;
            InsuredFuzzyQueryConditionDto.insuredName = $scope.insuredName;
            InsuredFuzzyQueryConditionDto.address = $scope.address;
            InsuredFuzzyQueryConditionDto.identifyNumber= $scope.idNum;
            if($scope.policyDetailParam=='endorse'){

            }else if($scope.policyDetailParam=='proposal'){
                InsuredFuzzyQueryConditionDto.proposalNo= $stateParams.policyNo;
                reportProposalServ.queryReportTProposal(InsuredFuzzyQueryConditionDto).then(
                    function(answer){
                        $scope.reportPaginationConf.totalItems = answer.data.totalCount;
                        $scope.reportInsured = answer.data.list;

                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }else if($scope.policyDetailParam=='proposalOffLine'){
            }else{
                reportProposalServ.queryReportProposal(InsuredFuzzyQueryConditionDto).then(
                    function(answer){
                        $scope.reportInsured = answer.data.list;
                        $scope.reportPaginationConf.totalItems=answer.data.totalCount;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }

        };
        var initFunPageInfo = function(){
            //初始化分页
            $scope.reportPaginationConf = {
                currentPage: 1,     //当前所在的页
                totalItems: 1,      //总共有多少条记录
                itemsPerPage: 5,   //每页展示的数据条数
                pagesLength: 5,    //分页条目的长度（如果设置建议设置为奇数）
                perPageOptions: [5, 10, 20, 50]   // 可选择显示条数的数组
            };
            $scope.proposalInfoDto = {pageNo:$scope.reportPaginationConf.currentPage,
                pageSize:$scope.reportPaginationConf.itemsPerPage};

            if($scope.policyDetailParam=='endorse'){

            }else if($scope.policyDetailParam=='proposal'){
                var prpCmainKeyDto = {};
                prpCmainKeyDto.policyNo= $stateParams.policyNo;
                reportProposalServ.queryReportProposalNo(prpCmainKeyDto).then(
                    function(answer){
                        var policyDto = answer.data;
                        var riskCode = answer.data.prpCmainDto.riskCode;
                        reportProposalServ.moduleInit().then(
                            function (answer) {
                                $scope.riskList = answer.data.riskConfig[riskCode];
                                $scope.policyDto = policyDto;
                                $scope.$watch('reportPaginationConf.currentPage + reportPaginationConf.itemsPerPage', getReportList);

                                if(riskCode == 'EQ02'){
                                    $scope.subsidyTypeName = $scope.policyDto.subsidyTypeName;
                                    $scope.subsidyList = $scope.policyDto.prpCSubsidyDtos;
                                    $scope.planDtos = $scope.policyDto.prpCplanDtos;
                                    if ($scope.policyDto.subsidyType == '' || $scope.policyDto.subsidyType == undefined) {
                                        $scope.subsidyFlag = false;
                                        return;
                                    }else{
                                        $scope.subsidyFlag = true;
                                    }
                                }else{
                                    $scope.emailRequiredFlag = true;
                                }

                            },function(error){
                                //console.log(JSON.stringify(error.data));
                            }
                        );
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }else if($scope.policyDetailParam=='proposalOffLine'){
            }else{
                var prpCmainKeyDto = {};
                prpCmainKeyDto.policyNo= $stateParams.policyNo;
                reportProposalServ.queryReportPolicyNo(prpCmainKeyDto).then(
                    function(answer){
                        var policyDto = answer.data;
                        var riskCode = answer.data.prpCmainDto.riskCode;
                        reportProposalServ.moduleInit().then(
                            function (answer) {
                                $scope.riskList = answer.data.riskConfig[riskCode];
                                $scope.policyDto = policyDto;
                                $scope.reportPaginationConf.totalItems = policyDto.totalCount;
                                if(riskCode == 'EQ02'){
                                    $scope.subsidyTypeName = $scope.policyDto.subsidyTypeName;
                                    $scope.subsidyList = $scope.policyDto.prpCSubsidyDtos;
                                    $scope.planDtos = $scope.policyDto.prpCplanDtos;
                                    if ($scope.policyDto.subsidyType == '' || $scope.policyDto.subsidyType == undefined) {
                                        $scope.subsidyFlag = false;
                                        return;
                                    }else{
                                        $scope.subsidyFlag = true;
                                    }
                                }else{
                                    $scope.emailRequiredFlag = true;
                                }
                                $scope.$watch('reportPaginationConf.currentPage + reportPaginationConf.itemsPerPage', getReportList);
                            },function(error){
                                //console.log(JSON.stringify(error.data));
                            }
                        );
                    },function(error){
                        //console.log(JSON.stringify(error.data));
                    }
                );
            }

        };
        initFunPageInfo();

        $scope.reBack=function(){
            $state.go('main.report');
        };
        $scope.queryCondition=function(){
            if($scope.policyDetailParam=='endorse'){
                var InsuredFuzzyQueryConditionDto = {};
                InsuredFuzzyQueryConditionDto.applyNo= $scope.applyNo;
                InsuredFuzzyQueryConditionDto.pageNo=$scope.reportPaginationConf.currentPage;
                InsuredFuzzyQueryConditionDto.pageSize=$scope.reportPaginationConf.itemsPerPage;

                InsuredFuzzyQueryConditionDto.insuredName=$scope.insuredName;
                InsuredFuzzyQueryConditionDto.address=$scope.address;
                InsuredFuzzyQueryConditionDto.identifyNumber=$scope.idNum;
                reportProposalServ.queryReportEndorseTranPolicy(InsuredFuzzyQueryConditionDto).then(
                    function(answer){
                        $scope.reportInsured = answer.data.list;
                        $scope.reportPaginationConf.totalItems = answer.data.totalCount;
                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }else if($scope.policyDetailParam=='proposalOffLine'){
                var InsuredFuzzyQueryConditionDto = {};
                InsuredFuzzyQueryConditionDto.pageNo=$scope.reportPaginationConf.currentPage;
                InsuredFuzzyQueryConditionDto.pageSize=$scope.reportPaginationConf.itemsPerPage;
                InsuredFuzzyQueryConditionDto.insuredName=$scope.insuredName;
                InsuredFuzzyQueryConditionDto.address=$scope.address;
                InsuredFuzzyQueryConditionDto.identifyNumber=$scope.idNum;
                InsuredFuzzyQueryConditionDto.proposalNo= $scope.proposalOffLine;
                reportProposalServ.queryReportTProposal(InsuredFuzzyQueryConditionDto).then(
                    function(answer){
                        $scope.reportPaginationConf.totalItems = answer.data.totalCount;
                        $scope.reportInsured = answer.data.list;

                    },function(error){
                        //cconsole.log(JSON.stringify(error.data));
                    }
                );
            }else{
                var insuredName = this.insuredName;
                var address = this.address;
                var idNum= this.idNum;
                $scope.insuredName = insuredName;
                $scope.address = address;
                $scope.idNum = idNum;
                if(insuredName == undefined &&  address == undefined &&  idNum == undefined){
                    insuredName = '';
                    address = '';
                    idNum = '';
                }
                getReportList();
            }
        };

        $scope.FileLayer = false;
        $scope.imgFileTypeT = false;
        /*文件查询*/
        $scope.reportFileClick = function(){
            $scope.queryImgFileList();
            $scope.reportFileSearchLayer = true;

           /* $scope.FileLayer = true;
            $scope.imgFileTypeT = true;
            $scope.$broadcast("uploadFileShow", {prpImgFileMainDto:{
                bussNo:$scope.policyDto.prpCmainDto.proposalNo,
                bussType:"T",
                userCode:$scope.user.userCode,
                comCode:$scope.user.comCode

            },prpImgFileIndexDto:{
                bussNo:$scope.policyDto.prpCmainDto.proposalNo
            }});*/

        };

        // 文件清单不包含 上传功能
        $scope.reportFileClickNoUnploadPower = function (){
            $scope.queryImgFileList();
            $scope.reportFileSearchLayer = true;
        };

        $scope.FilehideInsure = function(){
            $scope.FileLayer = false;
            $scope.imgFileTypeT = false;
            this.fileUploadForm.$setPristine();
            $(".validation-errorText").css('display','none');
        };

        /*被保险人批量导出*/
        $scope.downloadInsuredAll = function(){
            var exportQueryDto = {};
            exportQueryDto.exportType='Item';
            var filePath = $scope.filePath;
            if($scope.policyDetailParam=='endorse'){
                exportQueryDto.policyDetailParam='endorse';
            }else if($scope.policyDetailParam=='proposal' || $scope.policyDetailParam=='proposalOffLine'){
                exportQueryDto.policyDetailParam='proposal';
            }else{
                exportQueryDto.policyDetailParam='policy';
            }
            if($scope.policyDetailParam=='proposalOffLine'){
                exportQueryDto.bussinessNo=$scope.proposalOffLine;
            }else if($scope.policyDetailParam=='endorse'){
                exportQueryDto.bussinessNo=$scope.applyNo;
            }else{
                exportQueryDto.bussinessNo=$stateParams.policyNo;
            }

            reportProposalServ.downloadInsureds(exportQueryDto).then(
                function(answer){
                    if(answer.data.returnCode=='0000'){
                        var fileId = answer.data.shortLinkId;
                        if(undefined != answer.data.createFlag && "1"==answer.data.createFlag){
                            angular.alert("文件正在生成请稍后。");
                            return;
                        }
                        /*下载文件*/
                        reportProposalServ.downloadExcel(fileId);
                    }else{
                        angular.alert(answer.data.returnMessage);
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                })
        };

        $scope.queryImgFileList=function(){
            var uploadFileCond={};
            if($scope.policyDetailParam=='endorse'){
                uploadFileCond.bussType='E';
                uploadFileCond.bussNo = $scope.applyNo;
            }else if($scope.policyDetailParam=='proposalOffLine'){
                uploadFileCond.bussType='T';
                uploadFileCond.bussNo=$scope.proposalOffLine;
            } else if ($scope.policyDetailParam=='proposal' ) {
                uploadFileCond.bussType='T';
                uploadFileCond.bussNo=$stateParams.policyNo;
            } else{
                uploadFileCond.bussType='C';
                uploadFileCond.bussNo=$stateParams.policyNo;
            }
            uploadFileCond.pageSize=1000;
            uploadFileCond.pageNo=1;
            applicationFileUploadLayerServ.queryUploadFileList(uploadFileCond).then(
                function(answer){
                    $scope.uploadFileList=answer.data.list;
                    for(var i = 0;i<answer.data.list.length; i++) {
                        var upload = $scope.uploadFileList[i];
                        if ("jpg,png,bmp,ico,gif,jpeg,JPG,PNG,BMP,ICO,GIF,JPEG".indexOf(upload.fileExtentName) > -1) {
                            upload.isImg = true;
                            upload.imgUrl = "/comm-fileserver/downloadFile?type=view&fileId=" + upload.fileId + "&img.jpg";
                        } else {
                            upload.isImg = false;
                            upload.fileUrl = "/comm-fileserver/downloadFileByShortLinkId?shortLinkId=" + upload.fileShortId;
                        }
                    }
                },function(error){
                    //cconsole.log(JSON.stringify(error.data));
                }
            )
        };
        var isImgInit=false;
        $scope.showImgFile=function(d){
            window.open("/comm-fileserver/downloadFileByShortLinkId?shortLinkId="+ d.fileShortId);
        };
        $scope.reportFileSearchClose = function(){
            $scope.reportFileSearchLayer = false;
        };
        /*查看*/
        $scope.showInsure=function(PrpTinsuredPropDto){
            if(PrpTinsuredPropDto && PrpTinsuredPropDto.buildDate){
                try{
                   var date= new Date(PrpTinsuredPropDto.buildDate.replace(/-/,"/"));
                    PrpTinsuredPropDto.buildDate= $filter("date")(date, "yyyy-MM-dd");
                }catch(e){
                    angular.alert("建造日期 转化 出错");
                }
            }
            $scope.$broadcast("reportInsuredLayerShow", {PrpTinsuredPropDto:PrpTinsuredPropDto});
        };
        /*建筑结构*/
        $scope.structureClick = function(){
            $scope.insuredStructrueLayer = true;
        };
        $scope.structureClose = function(){
            $scope.insuredStructrueLayer = false;
        };
    };

    moduleApp.controller('reportProposalCtrl',['$scope','$state','reportProposalServ','applicationFileUploadLayerServ','$stateParams','$filter',reportProposalCtrl]);
});
