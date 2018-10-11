
/**
 * DESC       : 国元农险理赔报案任务修改页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'config'
], function (app, constants, layer,config) {
    'use strict';
    app.registerController('UIAgriRegistCtrl', ['$rootScope', '$scope', '$modal','$location', '$timeout','$$finder','FormFocus', '$filter', '$stateParams','regexpConstants','$window',"$state",
        function ($rootScope, $scope,$modal, $location, $timeout, $$finder, FormFocus, $filter, $stateParams, regexpConstants, $window, $state) {
            $scope.check={};
            $scope.editType = $stateParams.editType;
            var listNo ='';
            var editType = $stateParams.editType;
            // 当前页面状态
            $scope.addFlag = true;
            $scope.editFlag = true;
            $scope.showFlag = true;
            $scope.queryConnect = false ;
            //是否显示已撤销
            $scope.isCancelFlag = false;

            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                var policyNo=$scope.check.prpLregistDto.policyNo;
                $$finder.post('relatePolicyInfo', {policyNo:policyNo}).then(
                    function (data) {
                        console.log(data);
                        $scope.relateInfoDto = data;
                        angular.forEach($scope.relateInfoDto.prpLregistDtoList,function(result){
                            result.damageStartDate= $filter("date")(result.damageStartDate, "yyyy-MM-dd");
                        })

                        angular.forEach($scope.relateInfoDto.prpPheadDtoList,function (dto){
                            dto.underwriteEndDate = $filter("date")(dto.underwriteEndDate, "yyyy-MM-dd");
                        })


                    }
                )
            }
            //打开查看理赔联系记录的界面
            $scope.openQueryConnect = function () {
                $scope.queryConnect = true;
            }

            //关闭查看理赔联系记录的页面
            $scope.closeQueryConnect = function () {
                $scope.queryConnect = false;
            }

            // 本页面下拉框列表的数据 统一存放在codeListData
            $scope.codeListData ={};

            // 当前页面所需的正则
            $scope.regData = {};
            $scope.regData.positiveNumber = regexpConstants.positiveNumber;
            $scope.regData.postCode = regexpConstants.postCode;
            $scope.regData.phone = regexpConstants.phone;
            $scope.regData.chineseNumber = regexpConstants.chineseNumber;

            //—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*
            //自定义验证测试
            // $scope.rules = [
            //     {
            //         validator: function (val,callback) { // validator 需要执行的校验函数
                        // val 用户输入值
                        // $timeout(function () {
                        //     if($scope.data.ttt == val){
                        //         callback(null,"sync") // 校验通过后return callback 传入空值即可 异步校验要传入sync 标志
                        //     }else {
                        //         callback("想提示什么就输入什么","sync")
                        //     }
                        // },1000)
                    // },
                    // trigger:"blur" // 执行的契机 可选择 blur 或者 change 默认值blur
                // }
            // ];
            //—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*—*

            // 调用本页面的下拉框进行初始化 请求回来后统一存放当前scope.codeListData上
            var _data = {
                "casecadeConditionList": [
                    {
                        "name": "riskType",
                        "value": "I"
                    }
                ],
                "initlist": [
                    {
                        "codeType": "ReportType",
                        "riskCode": $stateParams.riskCode
                    },
                    {
                        "codeType": "DamageCode",
                        "riskCode": $stateParams.riskCode
                    },
                    {
                        "codeType": "Unit",
                        "riskCode": $stateParams.riskCode
                    },
                    {
                        "codeType": "DamageDetail",
                        "riskCode": $stateParams.riskCode
                    }
                ]
            };
            $$finder.post("baseCode", _data).then(function (data) {
                angular.forEach(data.data,function(item,index) {
                    $scope.codeListData[item.codeType] = item.resultobj.action_result;
                })
            },function (error) {

            });

            $$finder.post("queryReportType1",{}).then(
                function (data) {
                    console.log("以下是报案方式查询");
                    console.log(data);
                    $scope.codeListData1=data;
                }
            )

            var registPageInit = function () {

                $$finder.post("registPageInit", $stateParams).then(function (data) {
                    console.log("以下是初始化的入参")
                    console.log($stateParams)
                    console.log("====以下是报案登记页面的初始化结果")
                    console.log(data)
                    var request = {
                        policyNo:data.policyNo
                    }
                    $$finder.post("queryPrpCitemKind",request).then(function (prpCitemKindDtoList) {
                        console.log("以下是该保单号出险标的的查询结果")
                        console.log(prpCitemKindDtoList);
                        $scope.lossItemList = prpCitemKindDtoList;
                    })
                    //过滤相关的保单的条件
                    //如果是见费出单的险种 isSeeFeeFlag为1  在未收费前
                    if ($stateParams.editType == 'ADD') {
                        if (data.policyDto.prpCmainDto.isSeeFeeFlag == '1' && data.policyDto.prpCmainDto.riskCode == '3107') {
                            if (data.policyDto.prpCmainDto.underwriteFlag == '4') {
                                layer.open({
                                    offset: ['35%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    content: '该保单的险种是见费出单险种,未收费的情况下不允许报案',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        layer.close(index);
                                        $state.go('UIAgriRegistBeforeQuery')
                                    }
                                });
                            }
                        }
                    }
                    //如果有撤销时间 说明该报案登记应撤销
                    if (data.prpLregistDto.cancelDate != null) {
                        $scope.isCancelFlag = true;
                    }
                    // $$finder.post('initSelect', {
                    //     "codeType": "ItemCode0",
                    //     riskCode: data.policyDto.prpCmainDto.riskCode,//险种
                    //     reserve1: data.policyDto.prpCmainDto.versionNo,//条款
                    //     reserve2: data.policyDto.prpCitemKindAgriDtoList[0].kindCode//险别
                    // }).then(function (data) {
                    //     console.log("以下是标的的查询结果")
                    //     console.log(data)
                    //     $scope.lossItemList = data.codeData
                    //     $scope.check.prpLregistDto = $scope.check.prpLregistDto || {}
                    //     if ($scope.editType === 'ADD') {
                    //         $scope.check.prpLregistDto.lossName = '';
                    //     }
                    // }, function () {
                    //
                    // })
                    console.log(data)
                    if (data.prpLregistDto) {
                        // // 日期格式转换
                        data.prpLregistDto.inputDate = $filter("date")(data.prpLregistDto.inputDate, "yyyy-MM-dd"); // 输单时间
                        data.prpLregistDto.reportDate = $filter("date")(data.prpLregistDto.reportDate, "yyyy-MM-dd"); // 报案时间
                        // 出险时间
                        console.log('&&&&&&&&')
                        console.log(data.prpLregistDto.damageStartDate);
                        // data.prpLregistDto.damageDate = data.prpLregistDto.damageDate.splic
                        data.prpLregistDto.damageStartDate = $filter("date")(data.prpLregistDto.damageStartDate, "yyyy-MM-dd");
                        data.prpLregistDto.damageStartHour = $filter("date")(data.prpLregistDto.damageStartHour, "hh:mm:ss");
                        // 出险时间拼接
                        console.log("!!!!!!!!!!!")
                        console.log(data.prpLregistDto.damageStartDate)
                        data.prpLregistDto.damageStartDate = data.prpLregistDto.damageStartDate + ' ' + data.prpLregistDto.damageStartHour;
                        // 报案时间拼接
                        data.prpLregistDto.reportDate = data.prpLregistDto.reportDate + ' ' + data.prpLregistDto.reportHour;
                        data.prpLregistDto.startDate = $filter("date")(data.prpLregistDto.startDate, "yyyy-MM-dd");  // 保险起期
                        data.prpLregistDto.endDate = $filter("date")(data.prpLregistDto.endDate, "yyyy-MM-dd"); // 保险止期
                        console.log('以下是要报案的保单号的详细信息')
                        console.log('===========')
                        console.log(data)
                        $rootScope.check = data

                        $scope.check = data

                        console.log("===============")
                        console.log($scope.check)

                        if (editType == 'SHOW') {
                            var keywords = {
                                "policyNo": $scope.check.policyNo || '',//保单号
                                "registNo": $scope.check.registNo || '',//报案号
                                "claimNo": $scope.check.claimNo || '',//立案号
                                "riskCode": $scope.check.riskCode || '',//险种代码
                                "nodeType": $scope.check.nodeType || '',//节点类型
                                "operatorCode": $scope.user.userCode || '',// 操作员代码
                                "operatorName": $scope.user.userName || '',// 操作员代码
                                "inputDate": '2017-10-27'//后端已获取当前时间，但加了非空校验所以此处写死
                            };
                            console.log('以下是入参');
                            console.log(keywords);
                            console.log('===============')
                            console.log($scope.check.policyNo)
                            console.log($scope.check.registNo)
                            console.log($scope.check.claimNo)
                            console.log($scope.check.riskCode)
                            console.log($scope.check.nodeType)
                            console.log($scope.user.userCode)
                            console.log($scope.user.userName)
                            var queryConnect = function () {
                                $$finder.post('queryClaimCommunicationByCondition', keywords).then(
                                    function (data) {
                                        if (data && !data.code) {
                                            console.log('以下是理赔联系查看记录')
                                            console.log('==========')
                                            console.log(data)
                                            $scope.queryConnectList = data.prpLMessageDtoList;
                                            angular.forEach($scope.queryConnectList, function (data) {
                                                data.inputDate = $filter("date")(data.inputDate, "yyyy-MM-dd HH:mm:ss");
                                            })
                                            // $scope.communication = data;
                                            // $scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                            // $scope.showLoading = false;
                                        } else if (data && data.code == '9999') {
                                            layerMsg(data.message);
                                            $scope.closeModal();
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }
                            queryConnect();
                        }
                    }
                    $scope.goRelevanceList();
                    //初始化的时候不清空的话 养殖险会因为是汉字 而匹配不到下拉框中的数据下拉框会变成一条线 提到后面也会有问题
                    //调度环节会因为这个汉字的数据而在列表查询的翻译里报错 不加会报什么错等复现再说吧
                    if ($scope.editType != 'SHOW'&& $scope.editType != 'EDIT') {
                        $scope.check.prpLregistDto.lossName = '';
                    }
                    if ($scope.editType == 'EDIT'){
                        $scope.check.prpLregistDto.lossName = $scope.check.prpLregistDto.lossCode;
                    }
                    console.log($scope.check.prpLregistDto.damageStartDate)
                    console.log("以下是showFlag的状态======================")
                    console.log($scope.showFlag);
                });
            }
            //报案初始化
            //承保关联跳过来的页面缺少入参,在这里进行处理
            $scope.authSystemFlag = $stateParams.authSystemFlag;
            if ($scope.authSystemFlag==true) {
                $$finder.post("queryByBusinessNo", $stateParams).then(
                    function (dto) {
                        console.log(dto)
                        console.log("以下是报案节点的相关数据内容")
                        console.log(dto)
                        $stateParams.policyNo = dto.policyNo;
                        $stateParams.riskCode = dto.riskCode;
                        registPageInit();
                    }
                )
            }
            else {
                registPageInit();
            }



            $scope.showRelative=false;
            $scope.click=function(){
                $scope.showRelative=true;
            }
            $scope.closeModal = function () {
                $scope.showRelative = false;
            };

            $scope.goRelevanceList=function(){
                $scope.list=[];
                if($scope.check.prpLregistDto.damageMessage){
                    $scope.showRelative=false;
                    angular.forEach($scope.check.prpLregistDto.damageMessage, function (code) {
                        angular.forEach($scope.codeListData.DamageDetail, function (data) {
                            if(code==data.codecode){
                                $scope.list.push(data.codecname);
                            }

                        })

                    })
                    $scope.listdetail="";
                    angular.forEach($scope.list, function (data) {
                        $scope.listdetail+=data+" "
                    })

                }

                console.log($scope.codeListData.DamageDetail)
            }


            var validRegistFun =function () {
                //  出险时间校验
                var prpLregistDto = $scope.check.prpLregistDto;
                if((prpLregistDto.damageStartDate < prpLregistDto.startDate) || (prpLregistDto.damageStartDate > prpLregistDto.endDate)){
                    layerMsg("出险时间在保险期间以外,不给予报案!");
                    return false
                }
                if (prpLregistDto.inputDate < prpLregistDto.damageStartDate.slice(0,10)){
                    layerMsg("出险日期不能大于输单日期!");
                    return false
                }
                // 用于页面校验 报案时间不能大于当前日期
                var curDate = $filter("date")(new Date(), "yyyy-MM-dd HH:mm:ss");
                if (prpLregistDto.reportDate > curDate){
                    layerMsg("报案日期不能大于当前日期!");
                    return false
                }
                return true
            };
            var postData = function () {
                //$scope.check 日期格式转换
                var checkDto = angular.copy($scope.check);
                // 出险时间拆分
                var prpLregistDto = checkDto.prpLregistDto;

                var ary;
                ary = prpLregistDto.damageStartDate.trim().split(/\s/);
                prpLregistDto.damageStartDate = ary[0];
                prpLregistDto.damageStartHour = ary[1];
                // 报案时间拆分
                ary = prpLregistDto.reportDate.trim().split(/\s/);
                prpLregistDto.reportDate = ary[0];
                prpLregistDto.reportHour = ary[1];
                ary = null;
                //报案登记保存
                console.log("以下是要保存的报案登记对象=========")
                console.log(checkDto)
                console.log('以下是报案方式')
                $scope.check.prpLregistDto=$scope.check.prpLregistDto || {}
                console.log(prpLregistDto.reportType)
                checkDto.prpLregistDto.reportType=prpLregistDto.reportType
                $$finder.post("saveReport",checkDto).then(function (content) {
                    if(content.registNo&&content.policyNo){
                        if($scope.check.prpLclaimStatusDto.status === 4){ // 如果是提交
                            $scope.flag=true
                            layer.confirm('保单号： '+content.policyNo+'</br>报案号： '+content.registNo, {
                                title: '报案成功',
                                btn: ['打印抄单','返回'], //按钮
                                cancel:function () {
                                    window.history.back();
                                }
                            }, function(){
                                $window.open(constants.EXTERNALSYSTEMURL.PRINTURL+$location.$$protocol+"://"+$location.$$host+":"+$location.$$port+config.backend.ip+config.backend.copyPrint+'?registNo='+content.registNo);
                            }, function(){ //返回
                                window.history.back();
                            });
                        }else { // 如果是暂存
                            layerMsg('暂存成功'+'</br>保单号： '+content.policyNo+'</br>报案号： '+content.registNo);
                            $scope.check.prpLregistDto.registNo = content.registNo;
                            //暂存成功后返回查询页面
                            window.history.back();
                        }
                        var keywords = {
                            "lossListCode":listNo,
                            "registNo":content.registNo,
                            "policyNo":content.policyNo
                        };
                        $$finder.post('updateLossRateMainListByLossListCode', keywords).then(
                            function(data){

                            }
                        )
                    } else {
                        $scope.flag=true
                        layerMsg(content.message)
                    }

                });
            };
            //    导入清单
            var registNo=null;
            var isSuccess=111;
            $scope.importlist=function(){
               $modal.open({
                   templateUrl: 'common/business/regist/UIAgriRegist.importList.modal.html',
                   resolve:{
                       _mriskSwitch:function () {
                           //险种类型
                           return $scope.mriskSwitch
                       },
                       queryDto:function () {
                           //页面初始化后的对象
                           return angular.copy($scope.check);
                       }
                   },
                   controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                       var uploader = $scope.uploader = new FileUploader({
                           url:'/fileserver/uploadFile',
                           formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
                           queueLimit:1,
                           autoUpload:false,
                           removeAfterUpload:false//上传后删除文件
                       });
                       uploader.onSuccessItem = function(item, response, status, headers){
                           if(response.resultCode == '0000'){
                               //根据导入成功后的fileid调用保存
                               //判断导入的理赔清单类型
                               var keywords = {
                                   "fileId":response.resultObj.fileId,
                                   "fileName":"tttt",
                                   "riskCode":$rootScope.check.riskCode,
                                   "policyNo":$rootScope.check.policyNo,
                                   "damageStartDate":$rootScope.check.prpLregistDto.damageStartDate,
                                   "damageStartHour":$rootScope.check.prpLregistDto.damageStartHour,
                                   "userCode":$rootScope.user.userCode,
                                   "userName":$rootScope.user.userName,
                                   "nodeOrigin":$rootScope.check.nodeType,
                                   "registNo":$rootScope.check.registNo

                               };
                               console.log($rootScope.check.policyNo);
                               console.log($rootScope.check.prpLregistDto.damageStartDate);
                               console.log($rootScope.check.prpLregistDto.damageStartHour);
                               console.log(keywords);
                               $$finder.post("readBreedingList",keywords).then(
                                   function (data) {
                                       if(data && !data.code && data != 'gateway'){
                                           $rootScope.$broadcast('updateSumAmount',data.sumAmount);
                                           layerMsg("导入成功");
                                           isSuccess=222;
                                           //registNo=data.content[0].registNo;
                                           listNo=data.listNo;
                                       }else if(data && data.code == '9999'){
                                           layerMsg("导入失败! "+data.message);
                                       }else{
                                           layerMsg("导入失败");
                                       }
                                   },
                                   function (e) {
                                       layerMsg("导入失败");
                                   }
                               );
                           }
                           if(response.code == '9999'){
                               layerMsg("导入失败"+response.message);
                           }
                       };
                       $scope.uploader.onErrorItem = function(item, response, status, headers){
                           layerMsg("导入失败");
                       };
                       /**
                        * 下载方法
                        * @param _type 类型
                        */
                       $scope.download = function (_type) {
                           var url = '';
                           //耳标号承保清单下载
                           if(_type == 'LossRateList'){
                               var keywords =
                               {
                                   "policyNo":queryDto.policyNo,//报案号
                                   "registNo":queryDto.registNo
                                   // "registNo":"3310103"//报案号
                               };
                                   //种植险理赔清单导出Excel
                                   url = 'earmarkUnderwritingDownload';

                               $$finder.post(url,keywords).then(
                                   function (data) {
                                       if(data && data.url){
                                           $window.open(data.url);
                                       }else if(data && data.shortLink){
                                           $window.open(data.shortLink);
                                       }else if(data.code == '9999'){
                                           layerMsg("下载失败，"+data.message);
                                       }else {
                                           layerMsg("下载失败");
                                       }
                                   },
                                   function (e) {
                                       layerMsg("下载失败");
                                   }
                               );
                           }else if(_type == 'template'){
                               //模板下载
                                   //养殖险理赔清单空模版下载
                                   // url = 'nyxBreedClaimLis';
                                   /*$window.open('/api/agriclaim/templateFile/download?fileType=dingSunClaimList');*/
                               var keywords =
                               {
                                   "lossListCode":listNo,
                                   "policyNo":queryDto.policyNo,
                                   "registNo":$rootScope.check.registNo,
                                   "nodeType":"regis",
                               };
                               $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                                   function (data) {
                                       if(data && data.url){
                                           $window.open(data.url);
                                       }else if(data && data.shortLink){
                                           $window.open(data.shortLink);
                                       }else if(data.code == '9999'){
                                           layerMsg("下载失败，"+data.message);
                                       }else {
                                           layerMsg("下载失败");
                                       }
                                   },
                                   function (e) {
                                       layerMsg("下载失败");
                                   }
                               );

                           }else if(_type == 'policy'){
                               //保单清单下载
                               var keywords =
                               {
                                   //"policyNo":queryDto.policyNo//保单号
                                   "policyNo":"231013418002013000827"
                               };
                               url = 'NyxPolicyListExportExcel';
                               $$finder.post(url,keywords).then(
                                   function (data) {
                                       if(data && data.url){
                                           $window.open(data.url);
                                       }else if(data && data.shortLink){
                                           $window.open(data.shortLink);
                                       }else if(data.code == '9999'){
                                           layerMsg("下载失败，"+data.message);
                                       }else {
                                           layerMsg("下载失败");
                                       }
                                   },
                                   function (e) {
                                       layerMsg("下载失败");
                                   }
                               );
                           }
                       };
                       //关闭模态框
                       $scope.closeModal = function () {
                           $modalInstance.dismiss();
                       };
                       //确认按钮
                       $scope.determine = function () {
                           if(isSuccess!=222){
                               layerMsg("请导入清单！");
                           }else{
                               $modalInstance.dismiss();
                           }
                       };
                   }
               });
            }
            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }

            //清单下载
            $scope.downloadlist=function(){
                var keywords =
                {
                    "lossListCode":listNo,
                    "registNo":$scope.check.prpLregistDto.registNo,
                    "policyNo":$scope.check.prpLregistDto.policyNo,
                    "nodeType":"regis",
                    "origin":"0"
                };
                $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                    function (data) {
                        if(data && data.url){
                            $window.open(data.url);
                        }else if(data && data.shortLink){
                            $window.open(data.shortLink);
                        }else if(data.code == '9999'){
                            layerMsg("下载失败，"+data.message);
                        }else {
                            layerMsg("不存在GIS系统推送的定损数据，请稍后在进行下载");
                        }
                    },
                    function (e) {
                        layerMsg("下载失败");
                    }
                );
            }
// 损失清单数据导入
            var isSuccess=111;
            $scope.import=function(){
                $modal.open({
                    templateUrl: 'common/business/regist/UIAgriRegist.Plantingrisk.importList.modal.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.check);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                        var uploader = $scope.uploader = new FileUploader({
                            url:'/fileserver/uploadFile',
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_regist'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response, status, headers){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                //判断导入的理赔清单类型
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "fileName":"PlantingList",
                                    "riskCode":$rootScope.check.riskCode,
                                    "policyNo":$rootScope.check.policyNo,
                                    "damageStartDate":$rootScope.check.prpLregistDto.damageStartDate,
                                    "damageStartHour":$rootScope.check.prpLregistDto.damageStartHour,
                                    "userCode":$rootScope.user.userCode,
                                    "userName":$rootScope.user.userName,
                                    "nodeOrigin":$rootScope.check.nodeType,
                                    "registNo":$rootScope.check.registNo

                                };
                                console.log($rootScope.check.policyNo);
                                console.log($rootScope.check.prpLregistDto.damageStartDate);
                                console.log($rootScope.check.prpLregistDto.damageStartHour);
                                console.log(keywords);
                                $$finder.post("readPlantingList",keywords).then(
                                    function (data) {
                                        if(data && !data.code && data != 'gateway'){
                                            $rootScope.$broadcast('updateSumAmount',data.sumAmount);
                                            layerMsg("导入成功");
                                            isSuccess=222;
                                            //registNo=data.content[0].registNo;
                                            listNo=data.listNo;
                                        }else if(data && data.code == '9999'){
                                            layerMsg("导入失败! "+data.message);
                                        }else{
                                            layerMsg("导入失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("导入失败");
                                    }
                                );
                            }
                            if(response.code == '9999'){
                                layerMsg("导入失败"+response.message);
                            }
                        };
                        $scope.uploader.onErrorItem = function(item, response, status, headers){
                            layerMsg("导入失败");
                        };
                        /**
                         * 下载方法
                         * @param _type 类型
                         */
                        $scope.plantingdownload = function (_type) {
                            var url = '';
                            //耳标号承保清单下载
                            if(_type == 'LossRateList'){
                                var keywords =
                                {
                                    "policyNo":queryDto.policyNo,//报案号
                                    "registNo":queryDto.registNo
                                    // "registNo":"3310103"//报案号
                                };
                                //种植险理赔清单导出Excel
                                url = 'earmarkUnderwritingDownload';

                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'template'){
                                //模板下载
                                //养殖险理赔清单空模版下载
                                // url = 'nyxBreedClaimLis';
                                /*$window.open('/api/agriclaim/templateFile/download?fileType=PlantingDingSunList');*/
                                var keywords =
                                {
                                    "lossListCode":listNo,
                                    "policyNo":queryDto.policyNo,
                                    "registNo":$rootScope.check.registNo,
                                    "nodeType":"regis",
                                };
                                $$finder.post("expBreedAndPlantingLossRateList",keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );

                            }else if(_type == 'policy'){
                                //保单清单下载
                                var keywords =
                                {
                                    //"policyNo":queryDto.policyNo//保单号
                                    "policyNo":"231013418002013000827"
                                };
                                url = 'NyxPolicyListExportExcel';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            layerMsg("下载失败，"+data.message);
                                        }else {
                                            layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("下载失败");
                                    }
                                );
                            }
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                        //确认按钮
                        $scope.determine = function () {
                            if(isSuccess!=222){
                                layerMsg("请导入清单！");
                            }else{
                                $modalInstance.dismiss();
                            }
                        };
                    }
                });
            }
            /**
             * submitRegist 报案提交 或 暂存的方法
             *
             * @param btnType 操作按钮类型 sub 为提交，save 为暂存
             */
            $scope.submitRegist = function (btnType) {
                if (btnType === 'sub') {
                    $scope.flag=false
                    //提交前的必填项的数据校验
                    if (!$scope.check.prpLregistDto.damageStartDate) {
                        layerMsg("请录入出险时间！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.lossName) {
                        layerMsg("请录入受损标的！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.damageCode) {
                        layerMsg("请录入出险原因！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.damageAddress) {
                        layerMsg("请录入出险地点！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.reportorName) {
                        layerMsg("请录入报案人！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.reportDate) {
                        layerMsg("请录入报案时间")
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.lossesNumber) {
                        layerMsg("请录入赔付数量！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.linkerName) {
                        layerMsg("请录入联系人");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.phoneNumber) {
                        layerMsg("请录入联系电话！");
                        return false;
                    }
                    if (!$scope.check.prpLregistDto.estimateLoss) {
                        layerMsg("请录入报损金额")
                        return false;
                    }
                }

                //  传给后台暂存或提交的标志 , 4是所有提交，暂存2
                var prpLregistDto = $scope.check.prpLregistDto;
                if(btnType === 'sub'){
                    $scope.check.prpLclaimStatusDto.status = 4;
                    if ($scope.registForm.$valid) {
                        if(!validRegistFun()){
                            return
                        }
                    } else {
                        // 表单校验不通过 定位到第一个不通过的元素
                        FormFocus.focusEle('registForm');
                        return
                    }
                }else if(btnType === 'save'){
                    // $scope.check.prpLclaimStatusDto.status = $scope.check.riskType === 'H'? 3:$scope.check.riskType === 'I'?2:null;
                    $scope.check.prpLclaimStatusDto.status = 2;
                    if(!validRegistFun()){
                        return
                    }
                }
                //获取报案出险延期天数 出险时间减去报案时间大于配置的天数给与提示
                var delayDays=$scope.check.configValue;
                var regist_damage = (new Date(prpLregistDto.damageStartDate).getTime()- new Date(prpLregistDto.damageStartDate).getTime())/(24*60*60*1000);
                if(regist_damage>=delayDays) {
                    // layerMsg("提示：报案出险延期天数大于" + delayDays + "天，\n");
                    layer.confirm("提示：报案出险延期天数大于" + delayDays + "天，\n", {
                        title: '提示',
                        btn: ['确定','取消'] //按钮
                    }, function(){
                        postData()

                    }, function(){

                    });
                } else {
                    postData()


                }
            };
            if(editType === "ADD"){ // 报案
                $scope.editFlag = false;
                $scope.showFlag = false;
            }else if(editType === "EDIT"){ // 修改
                $scope.addFlag = false;
                $scope.showFlag = false;
            }else if(editType === "SHOW"){ // 查看
                $scope.addFlag = false;
                $scope.editFlag = false;
            }else {
                // window.history.back()

            }

            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.check.perilCount===null||$scope.check.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                };
                var url = '#/PerilCount?policyNo=' + $stateParams.policyNo;
                $window.open(url);
            };
            /**
             * 保单打印
             * @param _registNo 报案号
             */
            $scope.policyPrint = function () {
                $window.open(constants.EXTERNALSYSTEMURL.PRINTURL+$location.$$protocol+"://"+$location.$$host+":"+$location.$$port+config.backend.ip+config.backend.copyPrint+'?registNo='+$scope.check.prpLregistDto.registNo);
            }

            $scope.return = function () {
                // $state.go('UIAgriRegistBeforeQuery')
                $window.history.back();
            }
        }]);
});