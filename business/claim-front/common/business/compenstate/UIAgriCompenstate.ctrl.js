/**
 * DESC       : 国元农险理赔理算任修改页面
 * AUTHOR     : 国元农险项目组
 * CREATEDATE :
 * MODIFYLIST : Name           Date           Reason/Contents
 * --------------------------------------------------------
 */
define([
    'app',
    'constants',
    'layer',
    'config',
    'common/business/electronicsDocuments/UIAgriElectronics.examine.model.ctrl'
], function (app, constants, layer,config) {
    'use strict';
    app.registerController('UIAgriCompenstateCtrl', ['$rootScope', '$scope','$state','$filter', '$location', '$$finder','regexpConstants','$stateParams','$modal','FileUploader','$window','$timeout','commonApiServ',
        function ($rootScope, $scope, $state, $filter, $location, $$finder, regexpConstants,$stateParams,$modal,FileUploader,$window,$timeout,commonApiServ) {
            // 特约详情
            $scope.checkInfo = {};
            $scope.regData = regexpConstants;
            $scope.engage=false;
            $scope.curEngage ="";
            $scope.sumAmount = 0;//总赔付金额

            //更新总赔付金额
            $rootScope.$on('updatePayListNo',function (event,data) {
                //$scope.queryDto.payAmount = data.sumAccount;
                $scope.queryDto.payBillNo = data.listNo;//支付清单号
            });
            //更新总赔付金额
            $rootScope.$on('updateSumAmount',function (event,data) {
                $scope.sumAmount = data;
            });
            $scope.swichEngageDetil=function (item) {
                $scope.engage=!$scope.engage;
                $scope.curEngage= item.context;
            };
            $scope.queryDto={};
            $scope.communication = {};
             // 查询条件
            $scope.state = $stateParams.state;
            // 险类的开开关
            $scope.editType = $stateParams.editType;// 页面编辑类型
            // $scope.editType ="EDIT" ;

            if($scope.editType === "ADD" || $scope.editType === "EDIT"){
               $scope.showFlag = false;
            }else if($scope.editType === 'SHOW' ){
                $scope.showFlag = true;
            }
            //初始化
            function init() {
                // 查询险别
                $$finder.post("queryVirturlItemByPolicyNo",
                    {
                        flag:"2",
                        policyNo:$scope.queryDto.policyNo,
                        riskCode:$scope.queryDto.riskCode
                    }
                ).then(function (data) {
                    if(data){
                        $scope.kindCodeList =data;
                        var list=[];
                        var fall;
                        angular.forEach($scope.kindCodeList,function(dto){
                            if(list.length>0){
                                for(var i=0;i<list.length;i++){
                                    if(list[i].kindName==dto.kindName){
                                        fall=false;
                                    }else{
                                        fall=true;
                                    }
                                }
                            }else{
                                list.push(dto);
                            }
                            if(fall){
                                list.push(dto);
                            }
                        })
                        $scope.kindCodeList=list;
                    }
                }, function (error) {

                });

                // 查询费用下拉
                $$finder.post("baseCode",
                    {
                        initlist:[{
                            codeType:'ChargeCode',
                            // riskCode:$scope.queryDto.riskCode
                            riskCode:'0000'//TODO
                        }]
                    }
                ).then(function (data) {
                    if(data){
                        $scope.chargeList =data.data[0].resultobj.action_result;
                    }
                }, function (error) {

                });

                // 银行
                /*$$finder.post("queryByConditions",
                    {
                        codeType:'ATSBankCode'
                    }
                ).then(function (data) {
                    if(data){
                        $scope.BankList =data;
                    }
                }, function (error) {

                });
                // 省市
                $$finder.post("queryByConditions",
                    {
                        codeType:'ATSAreaCode'
                    }
                ).then(function (data) {
                    if(data){
                        $scope.AreaList =data;
                    }
                }, function (error) {

                });*/
                // 第三方机构ID
                /*$$finder.post("prpLexternalAgency",{}).then(
                    function (data) {
                        if(data){
                            $scope.taxdentifIds =data;
                        }
                }, function (error) {

                });*/

                //查询条款和标的
                $scope.codeListData= {};
                $$finder.post("queryPrpLRegistAndPrpCmainByConditions",
                    {
                        policyNo:$scope.queryDto.policyNo,
                        registNo:$scope.queryDto.registNo
                    }
                ).then(function (dat) {
                    //查询生长期
                    $$finder.post("queryPrpLGrowthByConditions",
                        {
                            riskCode:$scope.queryDto.riskCode,
                            clauseCode:dat.versionNo,
                            itemCode:dat.lossName
                        }
                    ).then(function (dat1) {
                        $scope.codeListData.GrowthList =dat1;
                    }, function (error) {

                    });

                }, function (error) {

                });
            }
            //出险方式和溃塘程度
            //$scope.riskCode=$stateParams.claimNo.substring(1,5);
            $scope.updateDamageDegree=function(data){
                if(data==='kt'){
                    $scope.damageDegreeFlag='kt';
                }else if(data==='mt'){
                    $scope.damageDegreeFlag='mt';
                }else if(data==='ft'){
                    $scope.damageDegreeFlag='ft';
                }

            }
            var compensatePageInit = function () {
                $scope.compensateDto = {
                    editType:$stateParams.editType || '',
                    registNo:$stateParams.registNo || '',
                    flowId:$stateParams.flowId || '',
                    compensateNo:$stateParams.compensateNo || '',
                    claimNo:$stateParams.claimNo || '',
                    logNo:$stateParams.logNo || ''
                };
                // 页面初始化
                $$finder.post("compensatePageInit", $scope.compensateDto).then(
                    function (data) {
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        if (data && !data.code) {
                            if (data.prpLCompensateDtoExt) {
                                // // 日期格式转换
                                $scope.compensate = data;
                                $scope.sumAmount = data.sumloss;
                                $scope.queryDto.validDate = data.prpLCompensateDtoExt.damageDate;//出险时间
                                $rootScope.billNo = $scope.queryDto.billNo;
                                $scope.checkFlag = $stateParams.checkFlag == 'true' ? true : false;
                                data.prpLCompensateDtoExt.statisticSym = $filter("date")(data.prpLCompensateDtoExt.statisticSym, "yyyy-MM-dd");  // 统计日期
                                data.prpLCompensateDtoExt.startDate = $filter("date")(data.prpLCompensateDtoExt.startDate, "yyyy-MM-dd");  // 保险起期
                                data.prpLCompensateDtoExt.endDate = $filter("date")(data.prpLCompensateDtoExt.endDate, "yyyy-MM-dd");  // 保险止期
                                data.prpLCompensateDtoExt.damageStartDate = $filter("date")(data.prpLCompensateDtoExt.damageStartDate, "yyyy-MM-dd");  // 出险日期
                            }
                            // var compensate = data.prpLCompensateDtoExt;
                            // data.prpLChargeDtoExtList =[{}];
                            // //  保险期间字段拼接
                            // var str = $filter("date")(compensate.startDate,"yyyy-MM-dd");
                            // str += "至";
                            // str += $filter("date")(compensate.endDate,"yyyy-MM-dd");
                            // data.insurancePeriod = str;
                            // // 日期格式转换
                            // compensate.damageStartDate = $filter("date")(compensate.damageStartDate,"yyyy-MM-dd");

                            $scope.queryDto = data;
                            //取共保主表的共保协议号
                            if($scope.queryDto.ccoinsDtoList && $scope.queryDto.ccoinsDtoList.length>0){
                                $scope.queryDto.coinsTreatyNo=$scope.queryDto.ccoinsDtoList[0].coinsTreatyNo;
                            }
                            if($scope.queryDto.riskCode=='3224'){
                                $scope.updateDamageDegree($scope.queryDto.prpLCompensateDtoExt.damageWay);
                            }
                            $scope.queryDto.prpLsumpayDtoList = [];//支付对象初始化
                            $scope.mriskSwitch = data.riskType == 'H'||data.riskCode=='3224'||data.riskCode=='3237' ? true : false; // 种植险为true 养殖为false
                            if ($scope.queryDto.msgCode == '9999') {
                                layerMsg($scope.queryDto.message);
                            }
                            console.log(data);
                            init();
                        } else {
                            layerMsg(data.message);
                            $scope.cancel();
                        }
                    });
            }


            $scope.authSystemFlag = $stateParams.authSystemFlag;
            if ($scope.authSystemFlag==true) {
                $$finder.post("queryByBusinessNo", $stateParams).then(
                    function (dto) {
                        console.log(dto)
                        console.log("以下是报案节点的相关数据内容")
                        console.log(dto)
                        $stateParams.policyNo = dto.policyNo;
                        $stateParams.riskCode = dto.riskCode;
                        $stateParams.claimNo = $stateParams.businessNo;
                        $stateParams.flowId = dto.flowId;
                        $stateParams.logNo = dto.logNo;
                        $stateParams.compensateNo = $stateParams.businessNo;
                        compensatePageInit();
                    }
                )
            }
            else {
                compensatePageInit();
            }

            $scope.openCompensateSettleListPage = function () {
                $state.go('UIAgriCompenstateSettleList')
            };


            //关联页面关闭
            $scope.closeRelative=function () {
                $scope.relateInfo=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //关联按钮
            $scope.relateInfo=false;
            $scope.showRelateInfo=function(){
                $scope.relateInfo=true;
                $("html,body").css({overflow:"hidden"});
                var policyNo=$scope.queryDto.policyNo;
                $$finder.post('relatePolicyInfo', {policyNo:policyNo}).then(
                    function (data) {
                        console.log("====以下是关联保单的相关信息")
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


            //显示流程图 关联按钮里面的查看按钮
            $scope.showFlow=function(result){
                window.open('#/UIAgriFlowSee?authSystemFlag=claim&registNo='+result.registNo);
            }

            /**
             * 添加列表信息
             * @param _type 类型
             *  prpLLossDtoExtList 赔付标的信息
             *  prpLChargeDtoExtList 赔付费用
             *  prpLCompensateEarDtoList 耳标号清单
             */
            $scope.addDtoExt = function (_type) {
                switch (_type){
                    //赔付标的信息
                    case "prpLLossDtoExtList":
                        var prpLLossDtoExt = {
                            kindName:'',//险别名称（H种植险）
                            amount:'',//保险金额
                            itemValue:'',//保险价值
                            sumLoss:'',//核定损失
                            sumRest:'',//残值
                            claimRate:'',//赔付比例
                            deductibleRate:'',//免赔率
                            deductible:'',//免赔额
                            sumrealPay:''//赔偿金额
                        };
                        $scope.queryDto.prpLLossDtoExtList.push(prpLLossDtoExt);
                        break;
                    //赔付费用
                    case "prpLChargeDtoExtList":
                        var prpLChargeDtoExt = {
                            KindCode:'',//险别代码
                            KindName:'',//险别名称
                            chargeCode:'',//费用代码
                            chargeName:'',//费用名称
                            checkDeptName:'',//待查勘机构
                            chargePayObjectType:'',//支付类型（B:外部，A内部）
                            payObjectName:'',//赔款接受人
                            currency:'',//币种
                            chargeAmount:'',//费用总额
                            prechargeAmount:'',//预付费用金额
                            sumRealPay:''//计入赔偿金额
                        };
                        $scope.queryDto.prpLChargeDtoExtList.push(prpLChargeDtoExt);
                        break;
                    //耳标号
                    case "prpLCompensateEarDtoList":
                        var prpLCompensateEarDto = {
                            code:'',//属性农户代码
                            idCard:'',//属性农户身份证号
                            name:'',//属性农户姓名
                            bank:'',//属性开户行名称
                            account:'',//属性银行账号
                            earNo:'',//属性耳标号
                            unitAmount:''//TODO 赔偿金额  (属性单位保险金额)还没确定
                        };
                        $scope.queryDto.prpLCompensateEarDtoList.push(prpLCompensateEarDto);
                        break;
                    //支付对象
                    case "prpLsumpayDtoList":
                        var prpLsumpayDto = {
                            serialNo:($scope.queryDto.prpLsumpayDtoList.length) + 1,//序号
                            accountBank:'',//银行名称
                            accountCode:'',//银行代码
                            accountName:'',//账户名
                            taxdentifId:'',//第三方机构ID
                            accountNo_first:'',//账号
                            accountNo:'',//账号确认(请再次输入账号)
                            payType:'',//赔款类型
                            sumthisPay:'',//赔款金额
                            currency:'',//币别
                            chargeCode:'',//费用代码
                            cardType:'',//卡/折标识
                            presidial:'',//省
                            cantonal:'',//市
                            settlementMode:'',//结算方式
                            remarkInfo:''//付款备注信息
                        };
                        $scope.queryDto.prpLsumpayDtoList.push(prpLsumpayDto);
                        break;
                }
            };
            /**
             * 删除列表信息
             * @param _type 类型
             * @param _index 删除项的下标
             *  prpLLossDtoExtList 赔付标的信息
             *  prpLChargeDtoExtList 赔付费用
             *  prpLCompensateEarDtoList 耳标号清单
             *  prpLsumpayDtoList 支付对象
             */
            $scope.delDtoExt = function (_type,_index) {
                switch (_type){
                    //赔付标的信息
                    case "prpLLossDtoExtList":
                        $scope.queryDto.prpLLossDtoExtList.splice(_index,1);
                        break;
                    //赔付费用
                    case "prpLChargeDtoExtList":
                        $scope.queryDto.prpLChargeDtoExtList.splice(_index,1);
                        break;
                    //耳标号
                    case "prpLCompensateEarDtoList":
                        $scope.queryDto.prpLCompensateEarDtoList.splice(_index,1);
                        break;
                    //支付对象
                    case "prpLsumpayDtoList":
                        $scope.queryDto.prpLsumpayDtoList.splice(_index,1);
                        break;
                }
            };


            //放弃任务
            $scope.giveup = function () {
                var dto = {
                    "swfLogFlowID":$stateParams.flowId,
                    "swfLogLogNo":$stateParams.logNo
                };
                var back=function(){
                    $state.go('UIAgriCompenstateQuery')
                };
                commonApiServ.giveupTemporary(dto,back);
            };

            /**
             * 支付对象账号校验
             * @param account
             * @param account2
             * @param index
             */
            $scope.verifyAccount = function (account,account2,index) {
              if (account != account2){
                  layerMsg("两次输入的账号不一样");
                  $scope.queryDto.prpLsumpayDtoList[index].accountNo = '';
              }
            };
            /**
             * 暂存
             */
            $scope.hold = function (type) {
                /*if($scope.queryDto.msgCode == '9999'){
                    layerMsg($scope.queryDto.message);
                    return
                }*/
                $scope.flag=false;
                if($scope.queryDto.contextPayCalcul==""||$scope.queryDto.contextPayCalcul==undefined){
                    layerMsg("请生成赔款计算过程");
                    return;
                }





                if ('sav'==type){
                    $scope.queryDto.buttonSaveType = '2';
                }else if('sub'==type){
                    $scope.queryDto.buttonSaveType = '4';
                }
                if ($rootScope.billNo){
                    $scope.queryDto.settleListCode = $rootScope.billNo;
                }else {
                    $scope.queryDto.settleListCode = $scope.queryDto.billNo;
                }
                //$scope.queryDto.prpLCompensateDtoExt.sumPaid=$scope.sumAmount;
                $$finder.post("saveSubmitBySaveIn",$scope.queryDto).then(
                    function (data) {
                        if (data.code != '9999' && 'sav'==type && typeof(data) != 'undefined' && typeof(data.compensateNo) != 'undefined' && data.compensateNo != null && data.compensateNo != '') {
                            $scope.editType='EDIT';
                            $scope.queryDto.prpLCompensateDtoExt.compensateNo=data.compensateNo;
                            layerMsg('理算暂存成功，理算书号为： '+data.compensateNo, function(){
                                $timeout(function () {  $state.go("UIAgriCompenstateQuery")})
                            });
                        } else if (data.code != '9999' && 'sub'==type && typeof(data) != 'undefined' && typeof(data.compensateNo) != 'undefined' && data.compensateNo != null && data.compensateNo != '') {
                            layerMsg('理算提交成功，理算书号为： '+data.compensateNo, function(){
                                $timeout(function () {  $state.go("UIAgriCompenstateQuery")})
                            });
                            $scope.flag=true;
                        }else if(data.code == '8888') {
                            $scope.editType='EDIT';
                            $scope.queryDto.prpLCompensateDtoExt.compensateNo=data.compensateNo;
                            layerMsg(data.message+"请重新提交!",function(){
                                $timeout(function () {  $state.go("UIAgriCompenstateQuery")}
                                )
                            });
                        }else {
                            if (data.message == '险别代码不能为空'){
                                layerMsg('险别名称不能为空');
                            }else {
                                layerMsg(data.message, function(){
                                    $timeout(function () {  $state.go("UIAgriCompenstateQuery")})
                                });
                            }
                        }
                        console.log(data)
                    }
                );
            };
            /**
             * 取消
             */
            $scope.cancel = function () {
             //返回查询页面
             $state.go('UIAgriCompenstateQuery');
             };
            /**
             * 返回
             */
            $scope.cancel1 = function () {
                //返回工作台
               window.history.back();
            };

          /*  $scope.cancel = function () {
                window.history.back();
            };*/


            /**
             * 双击域弹框
             * @param _type 数据类型
             */
            $scope.closeModal = function () {
                $scope.showDbModal = false;
            };
            $scope.ok = function (_item) {

            };
            $scope.openModal = function (_type) {
                $scope.showDbModal = true;
                //关闭弹框
                if(_type == 'chargeCode'){
                    $scope.modalTitle = '费用代码选择';
                }
                if(_type == 'chargeName'){
                    $scope.modalTitle = '费用名称选择';
                }
                if(_type == 'KindCode'){
                    $scope.modalTitle = '险别代码选择';
                }
                if(_type == 'KindName'){
                    $scope.modalTitle = '险别名称选择';
                }
            };

                //清单下载
            $scope.down=function(){
                var url = '';
                //清单下载
                var keywords = {
                    "listNo": $scope.queryDto.listNo || '',//理赔清单号
                    "policyNo": $scope.queryDto.policyNo || '',//保单号
                    "registNo": $scope.queryDto.registNo || '',//报案号
                    "compensateNo": $scope.queryDto.compensateNo || '',//计算书号
                    "fCode": $scope.queryDto.fCode || '',//农户号
                    "modeType": "1",//导出类型（1有数据，0无数据）
                    "type":"list",
                    "nodeType":$scope.queryDto.nodeType
                };
                if ( $scope.mriskSwitch) {
                    //种植险理赔清单导出Excel
                    url = 'nyxPlantingClaimListExportExcel';
                } else {
                    //养殖险理赔清单导出Excel
                    url = 'nyxBreedClaimListExportExcel';
                }
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
            /**
             * 清单导入
             */
            $scope.importList = function () {
                var url;
                if ($scope.queryDto.riskType == 'H'||$scope.queryDto.riskCode=='3224'||$scope.queryDto.riskCode=='3237') {
                    var keywords =
                    {
                        "registNo": $scope.queryDto.registNo,
                        "policyNo": $scope.queryDto.policyNo

                        // "registNo":"3310103"//报案号
                    };
                    url = 'plantingdownloadlList';
                } else {
                    var keywords =
                    {
                        "registNo": $scope.queryDto.registNo,
                        "policyNo": $scope.queryDto.policyNo

                        // "registNo":"3310103"//报案号
                    };
                    url = 'nyxdownloadlList';
                }
                $scope.dto = $scope.dto ||{}
                $$finder.post(url, keywords).then(
                    function (data) {
                        if (data.length <1) {
                            $scope.dto = 1;
                            layer.alert('请先关联清单！');
                        }
                        if ($scope.dto != 1&& $scope.dto!=undefined) {
                            $modal.open({
                                templateUrl:'common/business/compenstate/modal/UIAgriCompensate.importList.modal.html',
                                resolve:{
                                    _mriskSwitch:function () {
                                        //险种类型
                                        return $scope.mriskSwitch
                                    },
                                    queryDto:function () {
                                        //页面初始化后的对象
                                        return angular.copy($scope.queryDto);
                                    }
                                },
                                controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                                    var _growthPeriod = '';
                                    if (queryDto.riskCode == '3149'){
                                        _growthPeriod = "00";
                                    }else {
                                        _growthPeriod =  queryDto.prpLCompensateDtoExt.growthPeriod;
                                    }
                                    var _nodeType = queryDto.nodeType ;
                                    var uploader = $scope.uploader = new FileUploader({
                                        url:'/fileserver/uploadFile',
                                        formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_compensatemanage_ui'}],
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
                                                "comCode":queryDto.prpLCompensateDtoExt.comCode,
                                                "growthPeriod":_growthPeriod,//生长期
                                                "nodeType":_nodeType,
                                                "damageWay":queryDto.prpLCompensateDtoExt.damageWay,//出险方式 淡水鱼
                                                "damageDegree":queryDto.prpLCompensateDtoExt.damageDegree,//溃塘程度
                                            };
                                            if (_mriskSwitch){
                                                //    种植险
                                                var url = 'importPlantingClaimListExcel';
                                            }else if(!_mriskSwitch){
                                                //    养殖险
                                                var url = 'importBreedClaimListExcel';
                                            }
                                            $$finder.post(url,keywords).then(
                                                function (data) {
                                                    if(data && !data.code && data != 'gateway'){
                                                        $rootScope.billNo = data.listNo;
                                                        $scope.queryDto.billNo = data.listNo;
                                                        $rootScope.$broadcast('updateSumAmount',data.sumAmount);
                                                        layerMsg("导入成功");
                                                        $scope.queryDto.prpLCompensateDtoExt.coinsSumPaid=data.sumAmount;
                                                        //关闭模态框
                                                        $scope.closeModal();
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
                                    //初始化
                                    function init () {
                                        $scope.queryDto = queryDto;
                                        //文件上传实例

                                    }
                                    init();

                                    /**
                                     * 更新生长期
                                     * @param growthPeriod
                                     */
                                    $scope.updateGrowthPeriod = function (growthPeriod) {
                                        _growthPeriod = growthPeriod;
                                    };

                                    /**
                                     * 下载方法
                                     * @param _type 类型
                                     */
                                    $scope.download = function (_type) {
                                        var url = '';
                                        //定损清单下载
                                        if(_type == 'LossRateList'){
                                            //var keywords =
                                            //{
                                            //    "registNo":queryDto.registNo//报案号
                                            //    // "registNo":"3310103"//报案号
                                            //};
                                            //url = 'expBreedAndPlantingLossRateList';
                                            //$$finder.post(url,keywords).then(
                                            //    function (data) {
                                            //        if(data && data.url){
                                            //            $window.open(data.url);
                                            //        }else if(data && data.shortLink){
                                            //            $window.open(data.shortLink);
                                            //        }else if(data.code == '9999'){
                                            //            layerMsg("下载失败，"+data.message);
                                            //        }else {
                                            //            layerMsg("下载失败");
                                            //        }
                                            //    },
                                            //    function (e) {
                                            //        layerMsg("下载失败");
                                            //    }
                                            //);
                                        }else if(_type == 'ClaimList'){
                                            //理赔清单下载
                                            var keywords = {
                                                "listNo": queryDto.listNo || '',//理赔清单号
                                                "policyNo": queryDto.policyNo || '',//保单号
                                                "registNo": queryDto.registNo || '',//报案号
                                                //"compensateNo": queryDto.compensateNo || '',//计算书号
                                                "fCode": queryDto.fCode || '',//农户号
                                                "modeType": "1",//导出类型（1有数据，0无数据）
                                                "nodeType":queryDto.nodeType,
                                                "type":"import",
                                            };
                                            if (_mriskSwitch) {
                                                //种植险理赔清单导出Excel
                                                url = 'nyxPlantingClaimListExportExcel';
                                            } else if (!_mriskSwitch) {
                                                //养殖险理赔清单导出Excel
                                                url = 'nyxBreedClaimListExportExcel';
                                            }
                                        }else if(_type == 'policy'){
                                            //关联清单下载
                                            var keywords =
                                            {
                                                "registNo": $scope.queryDto.registNo,
                                                "policyNo": $scope.queryDto.policyNo

                                                // "registNo":"3310103"//报案号
                                            };
                                            url = 'downloadist';
                                        }
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
                                    };
                                    //关闭模态框
                                    $scope.closeModal = function () {
                                        $modalInstance.dismiss();
                                    };
                                }
                            });
                        }
                    }
                )
            };
            /**
             * 支付清单导入弹层
             */
            $scope.importPayList = function(){
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.importPayList.modal.html',
                    resolve:{
                        _mriskSwitch:function () {
                            //险种类型
                            return $scope.mriskSwitch
                        },
                        queryDto:function () {
                            //页面初始化后的对象
                            return angular.copy($scope.queryDto);
                        }
                    },
                    controller:function ($scope,$modalInstance,_mriskSwitch,queryDto,FileUploader) {
                        /** 下载 */
                        $scope.download = function (_type) {
                            var url = '';
                            if(_type == 'template') {
                                debugger;
                                //支付清单下载
                                if(!queryDto.payBillNo){
                                    //理赔清单组装
                                    var keywords =  {
                                        "listNo":queryDto.listNo || '',//理赔清单号
                                        "policyNo":queryDto.policyNo || '',//保单号
                                        "registNo":queryDto.registNo || '',//报案号
                                        "compensateNo":queryDto.compensateNo || '',//计算书号
                                        "fCode":queryDto.fCode || '',//农户号
                                        "modeType":"1",//导出类型（1有数据，0无数据）
                                        "nodeType":"compe"
                                    };
                                    url = 'expAssembleClaimPayList';
                                }else{
                                    //支付清单
                                    var keywords =
                                        {
                                            "listNo":queryDto.payBillNo//清单号
                                        };
                                    url = 'expNyxClaimPayList';
                                }
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && data.url){
                                            $window.open(data.url);
                                        }else if(data && data.shortLink){
                                            $window.open(data.shortLink);
                                        }else if(data.code == '9999'){
                                            $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                            //layerMsg("下载失败，"+data.message);
                                        }else {
                                            $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                            //layerMsg("下载失败");
                                        }
                                    },
                                    function (e) {
                                        $window.open('/api/agriclaim/templateFile/download?fileType=claimPayList');
                                        //layerMsg("下载失败");
                                    }
                                );
                            }else if(_type == 'PolicyList'){
                                var keywords =  {
                                    "policyNo":queryDto.policyNo || '',//保单号
                                    "registNo":queryDto.registNo || ''
                                };
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
                            }
                        };
                        var uploader = $scope.uploader = new FileUploader({
                            url:'/fileserver/uploadFile',
                            formData:[{userCode:$rootScope.user.userCode},{systemId:'tempfile'},{bussType:'agriclaim_paymanage_ui'}],
                            queueLimit:1,
                            autoUpload:false,
                            removeAfterUpload:false//上传后删除文件
                        });
                        uploader.onSuccessItem = function(item, response){
                            if(response.resultCode == '0000'){
                                //根据导入成功后的fileid调用保存
                                //判断导入的理赔清单类型
                                var keywords = {
                                    "fileId":response.resultObj.fileId,
                                    "comCode":queryDto.comCode
                                };
                                var url = 'importNyxClaimPayList';
                                $$finder.post(url,keywords).then(
                                    function (data) {
                                        if(data && !data.code && data != 'gateway'){
                                            $rootScope.$broadcast('updatePayListNo',data);
                                            layerMsg("导入成功");
                                            //关闭模态框
                                            $scope.closeModal();
                                        }else if(data && data.code == '9999'){
                                            layerMsg("导入失败! "+data.message);
                                        }else{
                                            layerMsg("导入失败");
                                        }
                                    },
                                    function (e) {
                                        layerMsg("导入失败"+e.message);
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
                        //初始化
                        function init () {
                            $scope.queryDto = queryDto;
                            //文件上传实例
                        }
                        init();
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };


            /**
             * 关联清单
             */
            $scope.showRelative=false;
            $scope.relevanceLists = function () {
                //查勘当前环节是否导入理赔清单
                var dto = {
                    "registNo":$scope.queryDto.registNo,
                    "nodeType":$scope.queryDto.nodeType
                };
                $$finder.post('queryAllByRegistNoAndNodeType',dto).then(
                    function (data) {
                        $scope.nyx=data;
                    }
                );
                $scope.showRelative=true;
                var queryDto=angular.copy($scope.queryDto);
                var data ={
                    "policyNo": queryDto.policyNo,
                    "bizNo":queryDto.registNo
                };
                $$finder.post('queryCompareBillByConditions', data).then(
                    function (data){
                        if(data && !data.code){
                            $.each(data,function (index,val) {
                                var listCreateTime = getMyDate(val.listCreateTime);
                                val.listCreateTime = listCreateTime;
                            });
                            $scope.RelevanceList = data;
                            angular.forEach($scope.RelevanceList,function (dto) {
                                if(dto.checkBoxFlag == '1'){
                                    $scope.sendCheckFlag(dto);
                                }
                            });
                            console.log($scope.RelevanceList);
                        }else {
                            layerMsg(data.message)
                        }
                    }
                );
            };
            //关联按钮清单下载
            $scope.downloadlist=function(){
                var url = '';
                //定损清单下载
                var keywords =
                {
                    "registNo":$scope.checkInfo.bizNo,
                    "lossListCode":$scope.checkInfo.lossListCode,
                    "policyNo":$scope.checkInfo.policyNo

                    // "registNo":"3310103"//报案号
                };
                url = 'downloadist';
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
            //接受单选框数据
            $scope.sendCheckFlag = function (info) {
                $scope.checkInfo = info;
            };
            //开始关联清单
            $scope.goRelevanceList = function () {
                $scope.backList=[];
                $scope.dto={};
                var queryDto=angular.copy($scope.queryDto);
                angular.forEach($scope.RelevanceList,function (dto) {
                    console.log(queryDto);
                    if(dto.checkBoxFlag){
                        $scope.backList.push(dto);
                    }
                });
                if($scope.backList.length<=0){
                    layerMsg("请选择后点击确认");
                }else  if ( $scope.nyx.length > 0){
                    layerMsg("已导入理赔清单，不可修改！")
                }else{
                    var keyMap = {
                        "lossListCode": $scope.checkInfo.lossListCode,
                        "bizNo":queryDto.registNo,
                        "checkBoxFlag": $scope.checkInfo.checkBoxFlag,
                        "serialNo":$scope.checkInfo.serialNo
                    };
                    $$finder.post('compareInsurance',keyMap).then(
                        function (data){
                            if (data.code=='0000'){
                                layerMsg("关联成功");
                                if( $scope.checkInfo.affectedArea!=null ||  $scope.checkInfo.deathQuantity!=null ||  $scope.checkInfo.disasterArea!=null ||  $scope.checkInfo.killQuantity!=null ||  $scope.checkInfo.noProductionArea!=null){
                                    $scope.queryDto.prpLCompensateDtoExt.killQuantity=$scope.checkInfo.killQuantity;
                                    $scope.queryDto.prpLCompensateDtoExt.deathQuantity=$scope.checkInfo.deathQuantity;
                                    $scope.queryDto.prpLCompensateDtoExt.noProductionArea=$scope.checkInfo.noProductionArea;
                                    $scope.queryDto.prpLCompensateDtoExt.affectedArea=$scope.checkInfo.affectedArea;
                                    $scope.queryDto.prpLCompensateDtoExt.disasterArea=$scope.checkInfo.disasterArea;
                                }
                            }else {
                                layerMsg("关联失败，请重试！");
                            }
                            $scope.showRelative=false;
                        }
                    );
                }

            };
            $scope.closeModal = function () {
                $scope.showRelative = false;
            };

            //时间格式处理
            function getMyDate(str){
                var oDate = new Date(str),
                    oYear = oDate.getFullYear(),
                    oMonth = oDate.getMonth()+1,
                    oDay = oDate.getDate(),
                    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) ;//最后拼接时间
                return oTime;
            };
            //补0操作
            function getzf(num){
                if(parseInt(num) < 10){
                    num = '0'+num;
                }
                return num;
            };

            /**
             * 理赔沟通
             */
            $scope.showCompensateComm = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.communicate.modal.html',
                    resolve:{
                        queryDto:function () {
                            return angular.copy($scope.queryDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,queryDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "policyNo": queryDto.policyNo || '',//保单号
                                "registNo": queryDto.registNo || '',//报案号
                                "claimNo": queryDto.claimNo || '',//立案号
                                "riskCode": queryDto.riskCode || '',//险种代码
                                "nodeType": queryDto.nodeType || '',//节点类型
                                "operatorCode": $scope.user.userCode || '',// 操作员代码
                                "operatorName": $scope.user.userName || '',// 操作员代码
                                "inputDate":'2017-10-27'//后端已获取当前时间，但加了非空校验所以此处写死
                            };
                            $$finder.post('queryClaimCommunicationByCondition',keywords).then(
                                function (data){
                                    if(data && !data.code){
                                        $scope.communication = data;
                                        $scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        layerMsg(data.message);
                                        $scope.closeModal();
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                }
                            );
                        }
                        init();
                        //重置
                        $scope.resetContext = function () {
                            $scope.communication.context = '';
                        };
                        //提交
                        $scope.submitCommuication = function () {
                            var keywords2 = {
                                "policyNo": $scope.communication.policyNo || '',
                                "registNo": $scope.communication.registNo || '',
                                "claimNo": $scope.communication.claimNo || '',
                                "riskCode": $scope.communication.riskCode || '',
                                "inputDate": $scope.communication.inputDate || '',
                                "nodeTypeName": $scope.communication.nodeTypeName || '',
                                "nodeType": $scope.communication.nodeType || '',
                                "operatorCode": $scope.communication.operatorCode || '',
                                "operatorName": $scope.communication.operatorName || '',
                                "context": $scope.communication.context || ''
                            };
                            $$finder.post('saveClaimCommunicationInfo',keywords2).then(
                                function (data) {
                                    if(data){
                                        layer.open({
                                            offset: ['35%', '40%'],
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            content: data.message,
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                layer.close(index);
                                                init();
                                            }
                                        });
                                    }
                                },function (e) {
                                    layerMsg("保存失败");
                                }
                            );
                        };
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };
            /**
             * 审核意见
             */
            $scope.showTraceInfo = function () {
                $modal.open({
                    templateUrl:'common/business/compenstate/modal/UIAgriCompensate.commonTraceInfo.modal.html',
                    resolve:{
                        queryDto:function () {
                            return angular.copy($scope.queryDto)
                        }
                    },
                    controller:function ($scope,$modalInstance,queryDto) {
                        //数据初始化
                        function init() {
                            $scope.showLoading = true;
                            var keywords = {
                                "businessNo": queryDto.claimNo || '',//业务号
                            };
                            $$finder.post('querySwfNotionByFlowId',keywords).then(
                                function (data){
                                    if(data && !data.code&&data.length>0){
                                        $scope.communication = data;
                                        //$scope.communication.inputDate = $filter('timeFilter')($scope.communication.inputDate);
                                        $scope.showLoading = false;
                                    }else if(data && data.code == '9999'){
                                        layerMsg(data.message);
                                        $scope.closeModal();
                                    }else{
                                        layerMsg("无审核意见！");
                                        $scope.closeModal();
                                    }
                                },
                                function (e) {
                                    layerMsg("下载失败");
                                }
                            );
                        }
                        init();
                        //关闭模态框
                        $scope.closeModal = function () {
                            $modalInstance.dismiss();
                        };
                    }
                });
            };
            /**
             * 电子单证
             */
            $scope.showElectronicDocu = function () {
                $modal.open({
                    templateUrl:'common/business/electronicsDocuments/UIAgriElectronics.examine.model.tpl.html',
                    resolve:{
                        items : function(){
                            return angular.copy($scope.compensate);
                        }},
                    controller:"UIAgriElectronicsCtrl"
                });
            };

            /**
             *   调查报告按钮
             */
          /*  $scope.showSurveyReport = function () {
                var dataDto ={
                  /!*  "policyNo":"231073400002018000465",
                     "bizNo":"431073400002018000516"*!/
                    "policyNo":$scope.queryDto.policyNo,
                    "bizNo":$scope.queryDto.registNo
                };
                $$finder.post('findCheckId', dataDto).then(
                    function (datew) {
                        console.log(datew)
                        if(datew.length>0&&datew[0].checkId){
                            $scope.checkId=datew[0].checkId
                            var GISIP="http://36.32.160.60:8888"
                            var classCode=$scope.queryDto.policyNo.substring(1,3);
                            if(classCode==31) {
                                var urlv = GISIP + '/CallPage/surveyShow/plantingSurvey?surveyID='+$scope.checkId;//种植险：
                                $window.open(urlv);
                            }else if(classCode==32) {
                                var urlv = GISIP + '/CallPage/surveyShow/cultivationSurvey?surveyID='+$scope.checkId;//养殖险：
                                $window.open(urlv);
                            }
                        } else {
                            layerMsg("查勘编号为空不能查询调查报告");
                            return
                        }
                    }
                )
            };*/
            $scope.showSurveyReport = function (){
                var classCode=$scope.queryDto.registNo.substring(1,3);
                if(!$scope.queryDto.registNo){
                    layerMsg("报案号为空不能查询调查报告");
                    return
                } else{
                if(classCode==31) {
                    $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.plantingSurveyurl+$scope.queryDto.registNo);
                }else if(classCode==32) {
                    $window.open($rootScope.frontEnd.claimGisUrl+constants.EXTERNALSYSTEMURL.cultivationSurveyurl+$scope.queryDto.registNo);
                }
                     }
            }


            /**
             * 赔款计算过程生成
             */
            $scope.queryClaimBillSummary = function () {
                var queryDto=angular.copy($scope.queryDto);
                var currentBillNo = "";
                if ($rootScope.billNo){
                    currentBillNo = $rootScope.billNo;
                }else {
                    currentBillNo = $scope.queryDto.billNo;
                }
                if ($scope.queryDto.riskType == 'H' || $scope.queryDto.riskCode == '3224'){
                    var keywords = {
                        policyNo:queryDto.policyNo,//保单号
                        kindCode:queryDto.kindCode,//险别代码
                        billNo:currentBillNo || '',//清单号
                        billFlag:queryDto.prpLCompensateDtoExt.billFlag,//清单标志（清单为1整单为0）
                        growthPeriod:queryDto.prpLCompensateDtoExt.growthPeriod || '',
                        registNo:queryDto.registNo,
                        damageWay:queryDto.prpLCompensateDtoExt.damageWay,
                        damageDegree:queryDto.prpLCompensateDtoExt.damageDegree
                    };
                    $$finder.post('queryClaimBillSummary',keywords).then(
                        function (data) {
                            if (data && data.code != '9999'){
                                if (data.code == '1111'){
                                    layerMsg("请先导入清单");
                                    return;
                                    //$scope.queryDto.contextPayCalcul += "     请导入清单后生成赔款计算过程    "
                                }

                                $scope.queryDto.contextPayCalcul = "理算过程如下:\r\n";
                                if (data.riskCName){
                                    $scope.queryDto.contextPayCalcul += "险别名称:"+data.riskCName+"\r\n"
                                }
                                if (data.lossrate || data.lossrate == 0){
                                    $scope.queryDto.contextPayCalcul += "损失率"+data.lossrate+"%: "+ data.description+"\r\n";
                                }
                                if ((data.lossrate || data.lossrate==0) && data.formula){
                                    $scope.queryDto.contextPayCalcul += "                  = "+data.formula+"\r\n";
                                }
                                if (data.lossarea || data.lossarea ==0){
                                    $scope.queryDto.contextPayCalcul += "赔付面积小计:"+data.lossarea+"\r\n";
                                }
                                if (data.result || data.result == 0){
                                    $scope.queryDto.contextPayCalcul += "赔款金额小计:"+data.result;
                                }

                                if (data.code == '2222'){
                                    $scope.queryDto.contextPayCalcul += "该险种无对应计算公式";
                                }
                                if (data.code == '3333'){
                                    $scope.queryDto.contextPayCalcul += "详见清单";
                                }
                                if (data.code == '4444'){
                                    $scope.queryDto.contextPayCalcul += "手动输入金额，无计算过程";
                                }
                                console.log(data)
                            }else if(data.code == '9999'){
                                layerMsg(data.message);
                            }
                        }
                    );
                }else {
                    var keywords = {
                        policyNo:queryDto.policyNo,//保单号
                        kindCode:queryDto.kindCode,//险别代码
                        listNo:currentBillNo || '',//清单号
                        registNo:queryDto.registNo
                    };
                    $$finder.post('queryBreedProcess',keywords).then(
                        function (data) {
                            if (data && data.code != '9999'){
                                if (data.code == '1111'){
                                    layerMsg("请先导入清单");
                                    return;
                                    // $scope.queryDto.contextPayCalcul += "     请导入清单后生成赔款计算过程    "
                                }
                                    $scope.queryDto.contextPayCalcul = "理算过程如下：\r\n";

                                    if (data.code == '2222'){
                                        $scope.queryDto.contextPayCalcul += "该险种无对应计算公式";
                                    }
                                    if (data.code == '3333'){
                                        $scope.queryDto.contextPayCalcul += "详见清单";
                                    }
                                    if (data.riskCName){
                                        $scope.queryDto.contextPayCalcul += "险别名称："+data.riskCName+"\r\n"
                                    }
                                    if (data.description){
                                        $scope.queryDto.contextPayCalcul += data.description+"\r\n";;
                                    }
                                    if (data.formula){
                                        $scope.queryDto.contextPayCalcul += "         = "+data.formula+"\r\n";
                                    }
                                    if (data.result || data.result == 0){
                                        $scope.queryDto.contextPayCalcul += "赔款金额小计："+data.result;
                                    }
                                    console.log(data)
                            }else if(data.code == '9999'){
                                layerMsg(data.message);
                            }
                        }
                    );
                }

            };

            /**
             * 下拉带出相关联的数据
             * @param _reled 被关联的数据
             * @param _index 被关联的数据
             * @param _rele 关联的索引
             */
            $scope.updateRelevanced = function (_reled,_index,_rele) {
                if(_reled == 'kindName'){
                    $.each($scope.kindCodeList,function (key,val) {
                       if(val.kindCode == _rele){
                           $scope.queryDto.prpLChargeDtoExtList[_index].kindName = val.kindName;
                       }
                    });
                }else if(_reled == 'kindCode'){
                    $.each($scope.kindCodeList,function (key,val) {
                        if(val.kindName == _rele){
                            $scope.queryDto.prpLChargeDtoExtList[_index].kindCode = val.kindCode;
                        }
                    });
                }else if(_reled == 'codecname'){
                    $.each($scope.chargeList,function (key,val) {
                        if(val.codecode == _rele){
                            $scope.queryDto.prpLChargeDtoExtList[_index].chargeName = val.codecname;
                        }
                    });
                }else if(_reled == 'codecode'){
                    $.each($scope.chargeList,function (key,val) {
                        if(val.codecname == _rele){
                            $scope.queryDto.prpLChargeDtoExtList[_index].chargeCode = val.codecode;
                        }
                    });
                }else if(_reled == 'accountCode'){
                    $scope.queryDto.prpLsumpayDtoList[_index].accountCode = _rele.codeCode;
                }else if(_reled == 'accountBank'){
                    $scope.queryDto.prpLsumpayDtoList[_index].accountBank = _rele.codeName;
                }else if(_reled == 'cantonal'){
                    $scope.queryDto.prpLsumpayDtoList[_index].cantonal = _rele.codeCode;
                }else if(_reled == 'presidial'){
                    $scope.queryDto.prpLsumpayDtoList[_index].presidial = _rele.codeName;
                }else if(_reled == 'chargeCode2'){
                    //支付的
                    $scope.queryDto.prpLsumpayDtoList[_index].chargeCode = _rele.codecode;
                }else if(_reled == 'chargeName2'){
                    //支付的
                    $scope.queryDto.prpLsumpayDtoList[_index].chargeName = _rele.codecname;
                }
            };

            /**
             * 汇总
             * 赔付汇总信息：
                 1.赔款金额 = 清单计算出来的金额 + 计入赔款金额之和
                 2.其他费用 = 费用金额之和 - 计入赔款金额之和
                 3.已预付赔款 = 已预赔或已实赔的赔款金额 （初始化带回）
                 4.已预付费用 = 已预配或者已实赔的费用   （初始化带回）
                 5.赔款合计 = 赔款金额 + 其他费用
                 6.本次赔付金额 = 赔款金额 + 其他费用 - 已预付赔款 - 已预付费用
                 7.送收付赔款  =  赔款金额 - 已预付赔款
                 8.送收付费用 = 其他费用 - 已预付费用
             */
            $scope.summarizing = function () {
                //1.赔款金额 = 清单计算出来的金额 + 计入赔款金额之和
                //计算计入赔款金额之和
                var sumRealPay = 0;
                $.each($scope.queryDto.prpLChargeDtoExtList,function (index,val) {
                    sumRealPay+=parseFloat(val.sumRealPay);
                });
                $scope.queryDto.prpLCompensateDtoExt.sumDutyPaid = parseFloat($scope.sumAmount) + sumRealPay;

                //2.其他费用 = 费用金额之和 - 计入赔款金额之和
                //计算费用金额之和
                var chargeAmount = 0;
                $.each($scope.queryDto.prpLChargeDtoExtList,function (index,val) {
                    chargeAmount+=parseFloat(val.chargeAmount);
                });
                if(parseFloat(chargeAmount) - sumRealPay < 0){
                    layerMsg("“计入赔款金额之和”不能大于“费用金额之和”");
                    return
                }
                $scope.queryDto.prpLCompensateDtoExt.sumNoDutyFee = parseFloat(chargeAmount) - sumRealPay;

                //5.赔款合计 = 赔款金额 + 其他费用
                $scope.queryDto.prpLCompensateDtoExt.sumPaid = $scope.queryDto.prpLCompensateDtoExt.sumDutyPaid + $scope.queryDto.prpLCompensateDtoExt.sumNoDutyFee;

                //6.本次赔付金额 = 赔款金额 + 其他费用 - 已预付赔款 - 已预付费用 $scope.queryDto.prpLCompensateDtoExt.sumPreChargeAmount
                $scope.queryDto.prpLCompensateDtoExt.sumThisPaid =( $scope.queryDto.prpLCompensateDtoExt.sumDutyPaid + $scope.queryDto.prpLCompensateDtoExt.sumNoDutyFee-$scope.queryDto.prpLCompensateDtoExt.sumPreChargeAmount - $scope.queryDto.prpLCompensateDtoExt.sumPrePaid).toFixed(2);
            };

            $scope.coinsSummarizing = function () {
                // 计算共保总赔付金额
                if ($scope.queryDto.ccoinsDtoList){
                    var list = $scope.queryDto.ccoinsDtoList;
                    var sumRate ='';
                    var sumAmount = '';
                    for(var i =0;i<list.length;i++){
                        sumRate += list[i].coinsRate;
                        sumAmount += list[i].coinsAmount;
                    }
                    var sumPaidAmount = sumAmount/(sumRate/100);
                    if ($scope.queryDto.prpLCompensateDtoExt.coinsPaidLossType == "1"){
                        $scope.queryDto.prpLCompensateDtoExt.coinsSelfSumPaid = sumPaidAmount;
                        $scope.queryDto.prpLCompensateDtoExt.coinsSumPaid = sumPaidAmount;
                        $scope.queryDto.prpLCompensateDtoExt.coinsOtherPaid = sumAmount;
                    }else if ($scope.queryDto.prpLCompensateDtoExt.coinsPaidLossType == "2"){
                        $scope.queryDto.prpLCompensateDtoExt.coinsSelfSumPaid = sumPaidAmount - sumAmount;
                        $scope.queryDto.prpLCompensateDtoExt.coinsSumPaid = sumPaidAmount - sumAmount;
                        $scope.queryDto.prpLCompensateDtoExt.coinsOtherPaid = '0';
                    }else {
                        layerMsg("请选择共保赔付类型！");
                    }
                }
            }

            // 出险次数信息记录查看
            $scope.openPerilCount = function () {
                if($scope.queryDto.perilCount===null||$scope.queryDto.perilCount<1){
                    layerMsg("您还没有出险次数！");
                    return false;
                };
                var url = '#/PerilCount?policyNo=' + $scope.queryDto.prpLCompensateDtoExt.policyNo ;
                $window.open(url);
            };

            /**
             * 页面规则教员
             * @param verifyType 校验类型
             * @param verifyData 校验的数据
             * @param name 要校验的元素name
             */
            $scope.ruleVerify = function (verifyType,verifyData,name) {
                if (verifyType == 'number'){
                    if (isNaN(verifyData)){
                        $('input[name='+name+']').addClass('ng-invalid');
                        layerMsg('只能输入数字');
                        $scope.verifyPass = false;
                    }else{
                        $('input[name='+name+']').removeClass('ng-invalid');
                        $scope.verifyPass = true;
                    }
                }
            };
        }]);
});