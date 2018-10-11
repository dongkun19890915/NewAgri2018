
define(['app','constants','layer','jsonDB','codes','config'], function (app,constants,layer,jsonDB,codes,config) {
    'use strict';
    app.registerController('UIPrPoEnRiskSchemeCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$state','$timeout','$$code','regexpConstants','commonApiServ','$stateParams',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,$timeout,$$code,regexpConstants,commonApiServ,$stateParams) {
            $scope.endorHide=true;//批改时删除和修改按钮隐藏
            //将机构树初始化为空
            $rootScope.modelComDtoList=[];
            $scope.proposal.engageQueryClause={};
            $scope.proposal.prpTitemKindAgri={};
            $scope.ShowExit=true;//出单向导退出按钮隐藏显示标识
            $$finder.find('queryAllClass',{
            },{
                success: function (data) {
                    $scope.prpDclassList=data.content
                },
                error: function (e) {
                }
            });
            // 清单号校验
            $scope.regexp = {};
            $scope.markedListItemList=null
            var itemCodeList=[];
            var quicklyGetInfo = function(FastQueryDto){
                $$finder.find('findGisInsureMainLists', FastQueryDto, {
                    success: function (data) {
                        if(data.code=="0000"&&data.content.content.length>0) {
                            $scope.requestInsurance(data.content.content[0].insureListCode,data.content.content[0].serialNo);
                            $scope.requestInsuranceQueryDto.queryList = data.content.content;
                            $scope.requestInsuranceQueryDto.queryList1 = data.content.content[0];
                            //清单类型
                            if ($scope.requestInsuranceQueryDto.queryList1.listType == 'D') {
                                $scope.proposal.insureMainListDto.listTypeFlag = '大户';
                            } else if ($scope.requestInsuranceQueryDto.queryList1.listType == 'S') {
                                $scope.proposal.insureMainListDto.listTypeFlag = '散户';
                            }
                            //清单备注
                            $scope.proposal.prpTmainAgriDto.relationListNoRemark = $scope.requestInsuranceQueryDto.queryList1.remark;
                            //金禾清单号
                            $scope.proposal.insureMainListDto.insureListCode = $scope.requestInsuranceQueryDto.queryList1.insureListCode;
                            //清单序号
                            $scope.proposal.insureMainListDto.serialNo = $scope.requestInsuranceQueryDto.queryList1.serialNo;
                            //归属区域存储代码
                            $scope.proposal.prpTmainDto.businessProvince = $scope.requestInsuranceQueryDto.queryList1.fProvinceCode;//省
                            $scope.proposal.prpTmainDto.businessCity = $scope.requestInsuranceQueryDto.queryList1.fCityCode;//市
                            $scope.proposal.prpTmainDto.businessCounty = $scope.requestInsuranceQueryDto.queryList1.fCountyCode;//区县
                            $scope.proposal.prpTmainDto.businessTown = $scope.requestInsuranceQueryDto.queryList1.fTownCode;//乡镇
                            $scope.proposal.prpTmainDto.businessArea = $scope.requestInsuranceQueryDto.queryList1.fVillageCode;//村
                            //归属区域页面显示
                            $scope.proposal.prpTmainDto.businessProvinceName = $scope.requestInsuranceQueryDto.queryList1.fProvinceName;
                            $scope.proposal.prpTmainDto.businessCityName = $scope.requestInsuranceQueryDto.queryList1.fCityName;
                            $scope.proposal.prpTmainDto.businessCountyName = $scope.requestInsuranceQueryDto.queryList1.fCountyName;
                            $scope.proposal.prpTmainDto.businessTownName = $scope.requestInsuranceQueryDto.queryList1.fTownName;
                            $scope.proposal.prpTmainDto.businessAreaName = $scope.requestInsuranceQueryDto.queryList1.fVillageName;
                            //承保清单归属区域最后一级
                            $scope.proposal.prpTmainDto.richflyAreasCode = $scope.requestInsuranceQueryDto.queryList1.pVillageCode;
                            $scope.proposal.prpTmainDto.richflyAreasCname = $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                            //赋值到种植地点中的地址之中
                            var addressName = $scope.requestInsuranceQueryDto.queryList1.pProvinceName + '-' +
                                $scope.requestInsuranceQueryDto.queryList1.pCityName + '-' +
                                $scope.requestInsuranceQueryDto.queryList1.pCountyName + '-' +
                                $scope.requestInsuranceQueryDto.queryList1.pTownName + '-' +
                                $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                            var addressNameArry = addressName.split('-');
                            angular.forEach(addressNameArry, function (data, index) {
                                if (data == 'undefined') {
                                    addressNameArry.splice(index, 1)
                                }
                            });
                            $scope.proposal.prpTaddressDto.addressName = addressNameArry.join("");
                            //查询标的清单
                            $$finder.find('queryMarkedList', {
                                "insureListCode":$scope.requestInsuranceQueryDto.queryList1.insureListCode,
                                "serialNo":$scope.requestInsuranceQueryDto.queryList1.serialNo//标的清单序号
                            }, {
                                success: function (data) {
                                    $scope.queryMarkedList=data.content;
                                    itemCodeList = [];//避免数据累加，造成重复数据
                                    for(var i=0;i<$scope.queryMarkedList.length;i++){
                                        itemCodeList.push($scope.queryMarkedList[i].itemCode);
                                    }
                                    //根据标的清单反查险种
                                    $$finder.find('queryByItemCode', {
                                        "itemCodeList": itemCodeList,
                                    }, {
                                        success: function (data) {
                                            $scope.riskCodeList=data.content;
                                            $$finder.find('queryAllClass',{
                                                classCode:$scope.riskCodeList[0].riskCode.substr(0,2)
                                            },{
                                                success: function (data) {
                                                    $scope.prpDclassList=data.content;
                                                    $scope.proposal.prpTmainDto.classCode =  $scope.prpDclassList[0].classCode;
                                                    $scope.proposal.prpTmainDto.className = $scope.prpDclassList[0].className;
                                                },
                                                error: function (e) {
                                                }
                                            });
                                        },
                                        error: function (e) {
                                            options.error(e);
                                        }
                                    });
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });

                        }else{
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: "该清单不存在！",
                                btn: ['确定'],
                                btn1: function(index, layero){
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            $scope.proposal.insureMainListDto.insureListCode="";
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //-------------------------------------------判断是否有值，如果有值则代表是快速出单业务，此处直接带出金禾清单号进行赋值开始 -----------------------------------------------------------------------
            if($stateParams.GisInsureListCode!=""&&$stateParams.GisInsureListCode!=undefined){
                $scope.FastFlag = true;//快速出单将清单置为只读
                $scope.ShowExit=false;//快速出单将出单向导页面退出按钮隐藏，避免用户点击退出菜单没有
                var FastQueryDto={};
                FastQueryDto.insureListCode = $stateParams.GisInsureListCode;
                //-------------------由于快速出单没有查询页面，所以在此随便定义一个查询页码与条数开始-------------------------------------------
                FastQueryDto.pageNo = 1;
                FastQueryDto.pageSize = 10;
                //-------------------由于快速出单没有查询页面，所以在此随便定义一个查询页码与条数结束-------------------------------------------
                quicklyGetInfo(FastQueryDto);

            }
            //-------------------------------------------判断是否有值，如果有值则代表是快速出单业务，此处直接带出金禾清单号进行赋值结束 -----------------------------------------------------------------------
            $scope.regexp.number = regexpConstants.number;
            $scope.regexp.Chinese = regexpConstants.Chinese;
            $scope.regexp.code= regexpConstants.code;
            //险种方案弹层 编辑类型
            $scope.showInp=false;
            $scope.selectedChange = function (value) {
                value=='COPY_PROPOSAL'? $scope.proposalNoTiShi='请输入投保单号':$scope.proposalNoTiShi='请输入保单号';
                if (value == 'NEW' || value === null) {
                    $scope.showInp = false;
                    $scope.proposal.editTypeName = '新保'
                    //给是否承保公示、是否验标、是否通过第三方识别赋默认值
                    $scope.proposal.prpTmainDto.thirdKnow = '1';//是否第三方识别
                    $scope.proposal.prpTmainDto.notificationFlag = '1';//是否承保公示
                    $scope.proposal.prpTmainDto.inceptionFlag = '1';//是否验标
                    $scope.proposal.prpTmainDto.eccFlag = '2';//是否抚贫项目
                    $scope.proposal.prpTmainDto.businessNature = 0;//业务来源
                    $scope.proposal.prpTmainDto.autoTransRenewFlag = '1';//缴费方式
                    $scope.proposal.prpTmainDto.startDate = '' + $scope.getdatestar.year + '-' + $scope.dataNum($scope.getdatestar.month) + '-' + $scope.dataNum($scope.getdatestar.day);////保险起期
                    $scope.proposal.prpTmainDto.endDate = '' + ($scope.getdate1.year + 1) + '-' + $scope.getdate1.endMonth + '-' + ($scope.getdate1.endDay);////保险止期
                    $scope.proposal.prpTmainDto.startHour = '0';//保险起期小时
                    $scope.proposal.prpTmainDto.endHour = '24';//保险止期小时
                    $scope.proposal.prpTmainDto.operateDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//投保日期
                    $scope.proposal.prpTmainDto.signDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//制单日期
                    var user = angular.copy($rootScope.user);
                    //$scope.proposal.prpTmainDto.makeCom = user.makeCom;
                    //操作员修改人
                    $scope.proposal.prpTmainDto.operatorCode = user.userCode
                    $scope.proposal.prpTmainDto.operatorName = user.userName
                    $scope.proposal.prpTmainDto.updaterName = user.userName
                    $scope.proposal.prpTmainDto.updaterCode = user.userCode
                    $scope.proposal.prpTmainDto.judicalScope = '1';//司法管轄
                    $scope.proposal.prpTmainDto.contractType = '1';//合同争议解决方式
                    $scope.proposal.prpTmainDto.inputDate = $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//操作日期
                    $scope.proposal.prpTmainDto.updateDate = $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//最近修改日期
                    $scope.proposal.prpTmainAgriDto.remark = "";//按何种方式确定保险金额
                    $scope.proposal.prpTitemKindDtoList = [];//主险附加险
                    $scope.proposal.engageQueryClause.absuDedu = "";
                    $scope.proposal.prpTitemKindAgri.stratDate = "";
                    $scope.proposal.prpTitemKindAgri.endDate = "";
                    $scope.proposal.isHide = false;
                    $scope.proposal.prpTsubsidyDtoList = [];//补贴信息
                    $scope.proposal.prpTplanDtoList = [];//缴费计划
                    $scope.proposal.prpTfeeDto = {};//币别
                    $scope.proposal.prpTfeeDto.currency2 = 'CNY';
                    $scope.currency2Name = '人民币';
                    $scope.proposal.prpTfeeDto.currency1 = 'CNY';
                    $scope.proposal.prpTengageDtoCopy = [];//特约
                } else {
                    $scope.showInp = true;
                    $scope.proposal.prpTmainDto.proposalNo = '';
                }
                $scope.proposal.prpTmainDto = {};
                $scope.clause = [];
                $scope.proposal.insureMainListDto.insureListCode = "";

            }

            //  投保单录入页面     出单向导的取消按钮跳转到控制台
            $scope.closeRiskScheme=function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('dashboard');
            };
            //点击修改方案
            $scope.riskScheme=function($event){
                if($scope.proposalQueryHide||$scope.endorseFlag){
                    $event.preventDefault();
                }else{
                    $scope.$emit('closeRiskScheme',true);
                }
            };
            $scope.messageHide=true;
            //根据清单带出客户信息
            $scope.requestInsurance = function (insureListCode,serialNo) {
                    $$finder.find('queryInsurePreliminaryConfirm', {
                        "insureListCode": insureListCode,//金禾清单号
                        "serialNo":serialNo//标的清单序号

                    }, {
                        success: function (data) {
                            //初始化
                            //$scope.proposal.appliInsuredDto.insuredType = '';
                            //$scope.proposal.appliInsuredDto.identifyType = '';
                            //$scope.proposal.appliInsuredDto.insuredName = '';
                            //$scope.proposal.appliInsuredDto.identifyNumber = '';
                            //$scope.proposal.appliInsuredDto.mobile = '';
                            //$scope.proposal.appliInsuredDto.insuredAddress = '';
                            //$scope.proposal.appliInsuredDto.bank = '';
                            //$scope.proposal.appliInsuredDto.account = ''
                            $rootScope.kelei=false;
                            $rootScope.zhenglei=false;
                            $rootScope.zhenghao=false;
                            $rootScope.keming=false;
                            $rootScope.yidian=false;
                            $rootScope.kedi=false;
                            $rootScope.gudian=false;
                            $rootScope.kaihu=false;
                            $rootScope.yinzhang=false;
                            $rootScope.dianyou=false;
                            $rootScope.kelei1=false;
                            $rootScope.zhenglei1=false;
                            $rootScope.zhenghao1=false;
                            $rootScope.keming1=false;
                            $rootScope.yidian1=false;
                            $rootScope.kedi1=false;
                            $rootScope.gudian1=false;
                            $rootScope.kaihu1=false;
                            $rootScope.yinzhang1=false;
                            $rootScope.dianyou1=false;
                            /*$scope.proposal.insuredDto='';*/
                            //当散户的情况下
                            if (data.content.gisFarmerListDtoList.length > 1) {
                                $scope.onlyReadAgri=true;
                                $scope.proposal.appliInsuredDto.certificateName = "9999999999999999";//客户代码
                                //客户名称
                                if (data.content.gisInsureMainListDto.pVillageName) {
                                    $scope.proposal.appliInsuredDto.insuredName = data.content.gisInsureMainListDto.pVillageName + '村' +
                                        data.content.gisFarmerListDtoList.length + "名农户";
                                } else if (data.content.gisInsureMainListDto.pTownName) {
                                    $scope.proposal.appliInsuredDto.insuredName = data.content.gisInsureMainListDto.pTownName + '镇' +
                                        data.content.gisFarmerListDtoList.length + "名农户";
                                } else if (data.content.gisInsureMainListDto.pCountyName) {
                                    $scope.proposal.appliInsuredDto.insuredName = data.content.gisInsureMainListDto.pCountyName + '区' +
                                        data.content.gisFarmerListDtoList.length + "名农户";
                                }
                                $scope.proposal.appliInsuredDto.insuredType = '3';//客户类型 --非企业团体
                                $scope.proposal.insuredDto.certificateName = $scope.proposal.appliInsuredDto.certificateName;
                                $scope.proposal.insuredDto.insuredName =  $scope.proposal.appliInsuredDto.insuredName;
                                $scope.proposal.insuredDto.insuredType = '3';//客户类型 --非企业团体
                                if($scope.proposal.appliInsuredDto.insuredType=='3'){
                                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '03';//开票对象为非企业团体时，纳税人身份默认非增值税纳税人
                                    $scope.proposal.prpDcustomerTaxPayInfoDto.invoiceType = '04';//发票类型默认为暂不开票
                                }
                                //清单代入不可修改
                                if(true){
                                    $rootScope.zhenglei=true;
                                    $rootScope.zhenghao=true;
                                    $rootScope.zhenghao1=true;
                                    $rootScope.kelei1=true;
                                    $rootScope.zhenglei1=true;
                                }
                                if($scope.proposal.appliInsuredDto.insuredType!=null&&$scope.proposal.appliInsuredDto.insuredType!=""&&$scope.proposal.appliInsuredDto.insuredType!=undefined){
                                    $rootScope.kelei=true;
                                }
                                //散户的时候只读证件类型与身份证号码
                                $scope.RrtailHide=true;
                                $scope.proposal.hideIndentifyType();
                            } else {
                                if (data.content.gisFarmerListDtoList[0].fIdType <= 59) {
                                    $scope.proposal.appliInsuredDto.insuredType = '1';  //客户类型
                                } else {
                                    $scope.proposal.appliInsuredDto.insuredType = '2';  //客户类型
                                }
                                ($scope.getPrintFlagList=function(n,att) {
                                    if(n=='1'){
                                        $$finder.find('queryIdentifyType', {
                                            "flag": att
                                        }, {
                                            success: function (data) {
                                                $rootScope.printFlagList = data.content.queryPrpDcodeDtoList;
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
                                                $rootScope.printFlagList1 = data.content.queryPrpDcodeDtoList;
                                            },
                                            error: function (e) {
                                                options.error(e);
                                            }
                                        });
                                    }
                                })('2', $scope.proposal.appliInsuredDto.insuredType)
                                //投保人
                                $scope.proposal.appliInsuredDto.identifyType = data.content.gisFarmerListDtoList[0].fIdType;//证件类型
                                //显示证件类型
                                $scope.proposal.appliInsuredDto.identifyNumber = data.content.gisFarmerListDtoList[0].fIdCard;//证件号码
                                $scope.proposal.appliInsuredDto.certificateName = data.content.gisFarmerListDtoList[0].fCode;//客户代码
                                $scope.proposal.appliInsuredDto.insuredName = data.content.gisFarmerListDtoList[0].fName;//客户名称
                                $scope.proposal.appliInsuredDto.mobile = data.content.gisFarmerListDtoList[0].fPhone;//移动电话
                                $scope.proposal.appliInsuredDto.insuredAddress = data.content.gisFarmerListDtoList[0].fAddress;//客户地址
                                $scope.proposal.appliInsuredDto.phoneNumber = data.content.gisFarmerListDtoList[0].fPhone;//固定电话
                                $scope.proposal.appliInsuredDto.account= data.content.gisFarmerListDtoList[0].accountNo;//银行账号
                                $scope.proposal.appliInsuredDto.bank = data.content.gisFarmerListDtoList[0].bankName;//开户行
                                //若客户类型为个人，则发票购货方信息中的纳税人身份默认为个人
                                if($scope.proposal.appliInsuredDto.insuredType=='1'){
                                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '04';//开票对象为个人时，纳税人身份默认为个人
                                    if(!$scope.proposal.appliInsuredDto.nationality){
                                        $scope.proposal.appliInsuredDto.nationality="中华人民共和国";
                                    }
                                }else if($scope.proposal.appliInsuredDto.insuredType=='2'){
                                    $scope.proposal.prpDcustomerTaxPayInfoDto.taxpayerType = '01';//开票对象为单位时，纳税人身份默认增值税一般纳税人
                                }


                                //被保险人
                                $scope.proposal.insuredDto.insuredType = $scope.proposal.appliInsuredDto.insuredType;//将投保人客户类型赋值给被保险人
                                $scope.proposal.insuredDto.identifyType = data.content.gisFarmerListDtoList[0].fIdType;//证件类型
                                $scope.proposal.insuredDto.identifyNumber = data.content.gisFarmerListDtoList[0].fIdCard;//证件号码
                                $scope.proposal.insuredDto.certificateName = data.content.gisFarmerListDtoList[0].fCode;//客户代码
                                $scope.proposal.insuredDto.insuredName = data.content.gisFarmerListDtoList[0].fName;//客户名称
                                $scope.proposal.insuredDto.mobile = data.content.gisFarmerListDtoList[0].fPhone;//移动电话
                                $scope.proposal.insuredDto.insuredAddress = data.content.gisFarmerListDtoList[0].fAddress;//客户地址
                                $scope.proposal.insuredDto.phoneNumber = data.content.gisFarmerListDtoList[0].fPhone;//固定电话
                                $scope.proposal.insuredDto.account= data.content.gisFarmerListDtoList[0].accountNo;//银行账号
                                $scope.proposal.insuredDto.bank = data.content.gisFarmerListDtoList[0].bankName;//开户行
                                $scope.getIdentity($scope.proposal.appliInsuredDto.insuredType,$scope.proposal.appliInsuredDto.identifyType);
                                $scope.nogai();
                            }

                            if ($scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput=='1'){
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
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
            };
            //直接输入清单号带出清单信息
            $scope.relativeInsureListCode=false;//清单编号重复性校验弹框
            $scope.getPlantingInfo = function(insureListCode,type){
                $scope.relationType=type;//标志是失去焦点还是点击确定
                var insureListCodereg=/^[0-9]{29}$/;//精确校验清单编号
                if(insureListCodereg.test(insureListCode)){
                    if($scope.queryHide){//出单向导
                        $$finder.find('queryPrpCmainInfo',{
                            gisInsureListCode:insureListCode,
                            pageNo: $scope.paginationConfmm4.currentPage,
                            pageSize: $scope.paginationConfmm4.itemsPerPage
                        },{
                            success: function (data) {
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
                                    var FastQueryDto={};
                                    FastQueryDto.insureListCode = insureListCode;
                                    //-------------------由于快速出单没有查询页面，所以在此随便定义一个查询页码与条数开始-------------------------------------------
                                    FastQueryDto.pageNo = 1;
                                    FastQueryDto.pageSize = 10;
                                    quicklyGetInfo(FastQueryDto);
                                }

                            }
                        })
                    }else{
                        var FastQueryDto={};
                        FastQueryDto.insureListCode = insureListCode;
                        //-------------------由于快速出单没有查询页面，所以在此随便定义一个查询页码与条数开始-------------------------------------------
                        FastQueryDto.pageNo = 1;
                        FastQueryDto.pageSize = 10;
                        quicklyGetInfo(FastQueryDto);
                    }

                }else if(insureListCode){
                    layer.open({
                        /*offset: ['45%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: "该清单编号格式错误，请修改！",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                            $("#insureListCode").focus();
                        }
                    });
                    $scope.proposal.insureMainListDto.insureListCode="";
                }
            }
            //关闭清单编号重复性校验弹框
            $scope.closeRelativeInsureListCode= function () {
                if($scope.relationType=='input'){
                    $scope.relativeInsureListCode=false;
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $scope.proposal.insureMainListDto.insureListCode="";
                    //清空之前清单带来的信息
                    $scope.proposal.prpTmainDto.classCode ="";
                    $scope.proposal.prpTmainDto.riskCode="";
                    $scope.queryMarkedList=[];
                }else{
                    $scope.relativeInsureListCode=false;
                    $("html,body").css({overflow:"auto"});//出现滚动条
                }


            }
            $scope.goRelativeInsureListCode= function (insureListCode) {
                $scope.relativeInsureListCode=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
                if($scope.relationType=='input'){
                    var FastQueryDto={};
                    FastQueryDto.insureListCode = insureListCode;
                    //-------------------由于快速出单没有查询页面，所以在此随便定义一个查询页码与条数开始-------------------------------------------
                    FastQueryDto.pageNo = 1;
                    FastQueryDto.pageSize = 10;
                    quicklyGetInfo(FastQueryDto);
                }else{
                    $scope.relationListNoLayer = false;
                    $("html,body").css({overflow:"auto"});//出现滚动条
                    $scope.relationListQueryLayer = false;
                    $$finder.find('queryMarkedList', {

                        // "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode,//金禾清单号
                        "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                        "serialNo":$scope.proposal.insureMainListDto.serialNo//标的清单序号
                    }, {
                        success: function (data) {
                            $scope.queryMarkedList=data.content
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                    $scope.requestInsurance($scope.proposal.insureMainListDto.insureListCode,$scope.proposal.insureMainListDto.serialNo);

                }


            }
            //查看关联有效保单列表弹框
            $scope.showDetailRelativeInsure=false;
            $scope.lookDetailRelativeInsureList= function () {
                $scope.showDetailRelativeInsure=true;
            }
            $scope.closeDetailRelativeInsureList= function () {
                $scope.showDetailRelativeInsure=false;
            }
            var indexPage5=function () {
                $scope.paginationConfmm4 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        $$finder.find('queryPrpCmainInfo',{
                            gisInsureListCode:$scope.proposal.insureMainListDto.insureListCode,
                            pageNo: $scope.paginationConfmm4.currentPage,
                            pageSize: $scope.paginationConfmm4.itemsPerPage
                        },{
                            success: function (data) {
                                if(data.code=='0000'&&data.content.content.length>0){
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
                                }

                            }
                        })
                    }
                }
            };
            indexPage5();
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                //$state.go('UIPolicy3107show',{'policyNo':policyNo})
                var url=$state.href('UIPolicy3107show',{'policyNo':policyNo,authSystemFlag:'claim'});
                window.open(url,"_blank");
            }
            //下一步按钮
            $scope.yesRiskScheme=function(){
                if($scope.prpMmodelMainDto.riskScheme&&!$scope.proposal.insureMainListDto.insureListCode){
                    $rootScope.hideIdentifyType=true;
                    $scope.proposal.appliInsuredDto={};
                    $scope.proposal.insuredDto={};
                    $scope.proposal.prpDcustomerTaxPayInfoDto = {};
                    $rootScope.kelei=false;
                    $rootScope.zhenglei=false;
                    $rootScope.zhenghao=false;
                    $rootScope.keming=false;
                    $rootScope.yidian=false;
                    $rootScope.kedi=false;
                    $rootScope.gudian=false;
                    $rootScope.kaihu=false;
                    $rootScope.yinzhang=false;
                    $rootScope.dianyou=false;
                    $rootScope.kelei1=false;
                    $rootScope.zhenglei1=false;
                    $rootScope.zhenghao1=false;
                    $rootScope.keming1=false;
                    $rootScope.yidian1=false;
                    $rootScope.kedi1=false;
                    $rootScope.gudian1=false;
                    $rootScope.kaihu1=false;
                    $rootScope.yinzhang1=false;
                    $rootScope.dianyou1=false;
                }else{
                    $rootScope.hideIdentifyType=false;
                }
                if(!$scope.proposal.editType){
                    $scope.proposal.editType=$scope.prpMmodelMainDto.riskScheme
                }
                if($scope.proposal.prpTitemKindDtoList&&$scope.proposal.insureMainListDto.insureListCode) {
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (dto, index) {
                        $$finder.find('queryItemListCodeByPK', {
                            insureListCode: $scope.proposal.insureMainListDto.insureListCode,
                            serialNo: $scope.proposal.insureMainListDto.serialNo,
                            itemCode: dto.itemCode
                        }, {
                            success: function (data) {
                                if(data.code=='0000'){
                                    dto.replyNo = data.content.itemListCode
                                }

                            },
                            error: function () {

                            }
                        })
                    })

                }
                var agricultureRiskCodes = [];
                agricultureRiskCodes.push('3107');
                agricultureRiskCodes.push('3108');
                agricultureRiskCodes.push('3121');
                agricultureRiskCodes.push('3122');
                var agricultureComCodes = [];
                var policyBizTypeObj=[];
                agricultureComCodes.push('3400009900');
                var loginComCode=$rootScope.user.loginComCode;
                var riskCode=$scope.proposal.prpTmainDto.riskCode;
                for (var i=0;i<agricultureRiskCodes.length;i++){
                    if(agricultureRiskCodes[i]==riskCode){
                        for (var j=0;j<agricultureComCodes.length;j++){
                            if (loginComCode==agricultureComCodes[j]){
                                policyBizTypeObj=[{
                                    "policyBizType":"01",
                                    "policyBizTypeName":"政策性农业险"
                                }]
                            }
                            else
                            {
                                policyBizTypeObj=[{
                                    "policyBizType":"02",
                                    "policyBizTypeName":"商业性农业险"
                                }]
                            }
                        }
                    }
                    else
                    {
                        for (var j=0;j<agricultureComCodes.length;j++){
                            if (loginComCode==agricultureComCodes[j]){
                                policyBizTypeObj=[{
                                    "policyBizType":"03",
                                    "policyBizTypeName":"政策性涉农险"
                                }]
                            }
                            else
                            {
                                policyBizTypeObj=[{
                                    "policyBizType":"04",
                                    "policyBizTypeName":"商业性涉农险"
                                },{
                                    "policyBizType":"05",
                                    "policyBizTypeName":"非农险"
                                }
                                ]
                            }
                        }
                    }
                }
                $scope.proposal.prpTmainDto.policyBizType=policyBizTypeObj[0].policyBizType
                $scope.proposal.prpTmainDto.policyBizTypeName=policyBizTypeObj[0].policyBizTypeName
                var content = '';
                var applaynameReg=/^[\u4e00-\u9fa5]+$/;
                var v= applaynameReg.test($scope.prpMmodelMainDto.modelName);
                var applaynameReg1 = /^[0-9\u4e00-\u9fa5]+$/;
                var vv = applaynameReg1.test($scope.prpMmodelMainDto.modelName);
                var  applaynameReg2 = /(?!\d+$)[\d\u4e00-\u9fa5]/;
                var vvv = applaynameReg2.test($scope.prpMmodelMainDto.modelName);
                if (!$scope.prpMmodelMainDto.riskScheme && $scope.handler1CodeShow){
                    content = '请录入创建类型!';
                }else if($scope.showInp&&!$scope.proposal.prpTmainDto.copyOldNo){
                    if($scope.proposal.editType=='COPY_PROPOSAL'){
                        content="请录入投保单号！";
                    }else{
                        content="请录入保单号！"
                    }
                }else if($scope.prpMmodelMainDto.riskScheme=='1'&&!$scope.proposal.modelCode){
                    content="请录入模板号！"
                }else if($scope.proposal.prpTmainDto.classCode==''){
                    content = '请录入险类!';
                }else if($scope.proposal.prpTmainDto.riskCode==''){
                    content = '请录入险种!';
                }else if($scope.proposal.prpTmainDto.comCode ==''&&!$scope.prpMmodelMainDto.riskScheme) {
                    content = '请录入归属机构!';
                }else if ($scope.prpMmodelMainDto.riskScheme&&($rootScope.treecheck==undefined||$rootScope.treecheck.length==0)){
                    content = '请录入适用机构!';
                }else if ($scope.prpMmodelMainDto.riskScheme&&!$scope.prpMmodelMainDto.modelName){
                    content = '请录入模板名称!';
                }else if ($scope.prpMmodelMainDto.riskScheme&&(($scope.prpMmodelMainDto.modelName&&v==false)&&vv==false)){
                    content = '模板名称格式为:XXX_XXXX年XXX（行政单位）XX品种XX季别XX客户类型XX条款名称投保模版,请修改!';
                }else if ($scope.prpMmodelMainDto.riskScheme&&(($scope.prpMmodelMainDto.modelName&&v==false)&&vv==true&&vvv==false)){
                    content = '模板名称格式为:XXX_XXXX年XXX（行政单位）XX品种XX季别XX客户类型XX条款名称投保模版,请修改!';
                }else if ($scope.prpMmodelMainDto.riskScheme&&!$scope.prpMmodelMainDto.startDate){
                    content = '请录入有效起期!';
                }
                else if ($scope.prpMmodelMainDto.riskScheme&&!$scope.prpMmodelMainDto.endDate){
                    content = '请录入有效止期!';
                }else if((!$scope.prpMmodelMainDto.riskScheme&&$scope.proposal.insureMainListDto.insureListCode =='') || (!$scope.prpMmodelMainDto.riskScheme&&$scope.proposal.insureMainListDto.insureListCode==undefined)){
                    content = '请录入清单!';
                }else if((!$scope.prpMmodelMainDto.riskScheme)&&($scope.proposal.prpTmainDto.versionNo==''||!$scope.proposal.prpTmainDto.versionNo)) {
                    content = '请录入条款!';
                }else {
                    if (!$scope.prpMmodelMainDto.riskScheme){
                        // 校验清单和所选的险种是否有匹配的清单
                        if($scope.proposal.insureMainListDto.serialNo&&!$scope.relativeInsureListCode){
                            $$finder.find('matchGisItemList',{
                                gisInsureListCode: $scope.proposal.insureMainListDto.insureListCode,
                                serialNo: $scope.proposal.insureMainListDto.serialNo,
                                riskCode: $scope.proposal.prpTmainDto.riskCode
                            },{
                                success:function (data){
                                    if (data.code === "9999"&&!$scope.relativeInsureListCode) {
                                        layer.open({
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: data.message,
                                            btn: ['确定'],
                                            btn1: function(index, layero){
                                                layer.close(index);
                                            },
                                        });
                                    }else {
                                        if(!$scope.relativeInsureListCode){
                                            nextStep();
                                        }

                                    }
                                },
                                error: function (e) {
                                }
                            });
                        }

                    }else {
                        nextStep();
                    }
                }
                if(content != ""){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    return false;
                }
                //如果险种或归属机构切换了则需要重新生成投保单号
                var proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                var riskCode = $scope.proposal.prpTmainDto.riskCode;
                //如果是投保模板，把归属机构写为登录机构
                if($scope.prpMmodelMainDto.riskScheme){
                    $scope.proposal.prpTmainDto.comCode= $rootScope.user.loginComCode
                    $scope.proposal.prpTmainDto.comCName=$rootScope.loginComCName;
                }
                var comCode = $scope.proposal.prpTmainDto.comCode;
                if(proposalNo!=null && proposalNo!='' && proposalNo!=undefined
                    && proposalNo.substring(1,5)==riskCode && proposalNo.substring(5,11)== comCode.substring(0,6)&&$scope.proposal.editType=='NEW'){
                    //不做任何处理
                }else {
                    //生成投保单号
                    $$finder.find('creatProposal', {
                        "tableName": "prptmain",//表名
                        "iYear": new Date().getFullYear(),//当前年份
                        "riskCode":riskCode,
                        "iComCode":comCode,
                        "userCode": $rootScope.user.userCode
                    }, {
                        success: function (data) {
                            $scope.proposal.prpTmainDto.proposalNo=data.content.billNo;
                            //我方清单号生成---生成投保单后才生成清单号，避免发生跳号的情况
                            $$finder.find('creatProposal', {
                                "tableName": "insureMainList",
                                "iYear": new Date().getFullYear(),//当前年份
                                "riskCode": riskCode,//险种  "3101"
                                "iComCode": comCode,//归属机构 "3400000000"
                                "userCode": $rootScope.user.userCode
                            }, {
                                success: function (data) {
                                    $scope.proposal.prpTmainAgriDto.relationListNo = data.content.billNo;
                                    $scope.proposal.times = 1;//如果清单号重新生成了，将times置为1，计算保存时需要用entityManager.persist保存
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });

                }
            };

            // 出单向导的下一步后续操作，异步请求防止页面提前跳转
            var nextStep = function () {
                $scope.proposal.prpMmodelMainDtoTem=$scope.prpMmodelMainDto;
                $rootScope.comTreeCtrlCommentFlag=true;
                $rootScope.comTreeCtrlFlag=true;
                //$rootScope.modelComDtoList=$rootScope.treecheck;
                if($scope.proposal.insureMainListDto.insureListCode){
                    var dto = angular.copy($scope.requestInsuranceQueryDto);
                    dto.beginTime='';
                    dto.endTime='';
                    dto.pageNo=1;
                    dto .insureListCode=$scope.proposal.insureMainListDto.insureListCode;
                    $$finder.find('findGisInsureMainLists', dto, {
                        success: function (data) {
                            //点击下一步时清楚  主险附加险相关信息
                            $scope.$watch("proposal.insureMainListDto.insureListCode", function (newValue, oldValue) {
                                if(oldValue!=newValue){
                                    if($scope.proposal.editType=="NEW"){
                                        $scope.checkedBoxInsured=true;//展示被保险人同投保人按钮
                                        $scope.proposal.prpTitemKindDtoList=[];
                                        //将新增按钮放开，不然不能新增主险
                                        $scope.proposal.ChangemainOrSubMain();
                                        $scope.proposal.engageQueryClause.absuDedu="";
                                        $scope.proposal.prpTitemKindAgri.stratDate="";
                                        $scope.proposal.prpTitemKindAgri.endDate="";
                                        $scope.proposal.isHide=false;
                                    }
                                }
                            });
                            if(data.code="0000"&&data.content.content.length>0){
                                if ($scope.proposal.editType=='COPY_PROPOSAL'){
                                    $scope.proposal.editTypeName='复制投保单';
                                }
                                if ($scope.proposal.editType=='COPY_POLICY'){
                                    $scope.proposal.editTypeName='复制保单';
                                }
                                if ($scope.proposal.editType=='RENEWAL'){
                                    $scope.proposal.editTypeName='在本公司续保';
                                }else{
                                    $scope.checkedBoxInsured=true;//展示被保险人同投保人按钮
                                    $scope.proposal.editTypeName='新保';
                                }
                                //生成投保单号
                                //------------------------注释掉，复制投保单会调用2次，存在跳号------------------------------
                                //$$finder.find('creatProposal', {
                                //    "tableName": "prptmain",//表名
                                //    "iYear": new Date().getFullYear(),//当前年份
                                //    "riskCode":riskCode,
                                //    "iComCode":$rootScope.user.loginComCode,
                                //    "userCode": $rootScope.user.userCode
                                //}, {
                                //    success: function (data) {
                                //        console.log(data)
                                //        $scope.proposal.prpTmainDto.proposalNo=data.content.billNo;
                                //    },
                                //    error: function (e) {
                                //        options.error(e);
                                //    }
                                //});
                                if ($scope.proposal.prpTmainDto.versionNo) {//剔除模板新建时没有选择条款导致控制台报错
                                    $$finder.find('queryByPkAndTranslate', {
                                        clauseCode: $scope.proposal.prpTmainDto.versionNo//条款代码
                                    }, {
                                        success: function (data) {
                                            $scope.proposal.prpTmainDto.businessType1Name = data.content.message;
                                            $scope.proposal.prpTmainDto.businessType1 = data.content.businessType;
                                        },
                                        error: function (e) {
                                        }
                                    });
                                }
                                //$scope.getComCodeList();//归属机构下拉初始化
                                $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainDto.policyType);//投保方式下拉初始化获取
                                $scope.mulitSelectUnit($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainAgriDto.statUnitCode);//承保数量计数单位--种植险
                                $scope.mulitSelectRaiseType($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainAgriDto.raiseType);//养殖方式
                                //保费计算中的费率除数
                                $$finder.find('queryByRiskCode',{
                                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                                }, {
                                    success: function (data) {
                                        $scope.rateDivisor=data.content;
                                        $scope.getrateDivisor( $scope.rateDivisor)
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                                /*if($scope.swflogDto.handleCode.length>0){
                                    $scope.getComCodeTree($scope.swflogDto.handleCode);
                                }*/
                                //模板归属业务人员下拉框初始化
                                if($scope.prpMmodelMainDto.riskScheme){
                                    var handCodeData={
                                        "userCode": $scope.user.userCode,
                                        "userName": $scope.user.userName,
                                        "loginComCode":  $scope.user.loginComCode,
                                        "loginGradeCodes": "111",
                                        "tableName": "prpduser",
                                        "userCodeFields": "userCode",
                                        "comCodeFields": $scope.proposal.prpTmainDto.comCode,
                                        "riskCode": $scope.proposal.prpTmainDto.riskCode
                                    };
                                    // handCodeList归属业务员下拉列表
                                    $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                                        $scope.selectListData.handCodeList = data;
                                    });
                                }
                                $scope.$emit('closeRiskScheme',false);
                            }else{
                                layer.open({
                                    /*offset: ['35%', '35%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: "您输入的清单编号在系统中不存在，请重新输入！",
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                })
                            }

                        }
                    })

                }else{
                    $scope.proposal.certificate=true;
                    $scope.proposal.certificate1=true;
                    if ($scope.proposal.editType=='NEW'){
                        $scope.checkedBoxInsured=true;//展示被保险人同投保人按钮
                        $scope.proposal.editTypeName='新保'
                    }
                    if ($scope.proposal.editType=='2'){
                        $scope.proposal.editTypeName='复制投保单'
                    }
                    if ($scope.proposal.editType=='3'){
                        $scope.proposal.editTypeName='复制保单'
                    }
                    if ($scope.proposal.editType=='4'){
                        $scope.proposal.editTypeName='续保'
                    }
                    //如果是投保模板，把归属机构写为登录机构
                    if($scope.prpMmodelMainDto.riskScheme){
                        $scope.proposal.prpTmainDto.comCode= $rootScope.user.loginComCode
                        $scope.proposal.prpTmainDto.comCName=$rootScope.loginComCName;
                    }
                    var handCodeData={
                        "userCode": $scope.user.userCode,
                        "userName": $scope.user.userName,
                        "loginComCode":  $scope.user.loginComCode,
                        "loginGradeCodes": "111",
                        "tableName": "prpduser",
                        "userCodeFields": "userCode",
                        "comCodeFields": $scope.proposal.prpTmainDto.comCode,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode
                    };
                    // handCodeList归属业务员下拉列表
                    $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                        $scope.selectListData.handCodeList = data;
                    });
                    if($scope.proposal.prpTmainDto.versionNo){
                        $$finder.find('queryByPkAndTranslate',{
                            clauseCode:$scope.proposal.prpTmainDto.versionNo//条款代码
                        },{
                            success:function (data){
                                $scope.proposal.prpTmainDto.businessType1Name=data.content.message;
                                $scope.proposal.prpTmainDto.businessType1=data.content.businessType;
                            },
                            error: function (e) {
                            }
                        });
                    }else{
                        //将政策、商业标志显示
                        $scope.proposal.businessType1Show=true
                        $scope.proposal.modelBusinessType1Show=true;

                    }
                    $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode,$scope.proposal.prpTmainDto.policyType);//投保方式下拉初始化获取
                    $scope.$emit('closeRiskScheme',false);
                }
            }





            var choose;
            $scope.chooseRiskcClassCode=function(selecte){
                if(choose==null){
                    choose=selecte;
                    $scope.proposal.prpTmainDto.riskCode='';
                }
                if(choose!=selecte){
                    choose=null;
                    $scope.proposal.prpTmainDto.riskCode='';
                    $scope.clause='';
                }
            };
            $scope.chooseClassCode = function (selected) {
                $scope.proposal.prpTmainDto.className=selected.className;
            }
            //险种必选 不选险种就选择险类就弹出弹层
            $scope.chooseRiskCode=function(selected){
                $scope.proposal.prpTmainDto.riskCodeName=selected.riskCName;
                if(!$scope.proposal.prpTmainDto.classCode){
                    $scope.proposal.prpTmainDto.riskCode='';
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '请先选择险种',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else {
                    $scope.getComCodeList();//归属机构下拉初始化
                    var comCode = $scope.proposal.prpTmainDto.comCode;
                    if(comCode!='' && comCode!=null && comCode!=undefined){
                        $scope.getItemsAndModel();
                    }
                }
            };
            //快速出单时，切换登陆机构带出归属机构
            $scope.QuickGetChangeComCode = function(){
                $scope.getComCodeList();//归属机构下拉初始化
            }
            $scope.getItemsAndModel=function(){
                //选择条款数据
                $$finder.find('prpdClauseCode',{
                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                    comCode:$scope.proposal.prpTmainDto.comCode//归属机构
                }, {
                    success: function (data) {
                        $scope.clause=data.content;
                        if($scope.clause.length==1){//当仅有一条条款时默认选中
                            $scope.value=$scope.clause[0].clauseName;
                            $scope.proposal.prpTmainDto.versionNo=$scope.clause[0].clauseCode;
                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
                //选择模板数据
                $$finder.find('prpMmodelMainByRiskCode',{

                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                    comCode:$scope.proposal.prpTmainDto.comCode//归属机构
                }, {
                    success: function (data) {
                        $scope.model=data.content;
                        $scope.operatecodeList=[];
                        angular.forEach($scope.model, function (data, index) {
                            $scope.operatecodeList.push(data.operatorCode);
                        });
                        //选择模板数据
                        $$finder.find('getOperatorCode', $scope.operatecodeList
                        , {
                            success: function (data) {
                                $scope.operatorList=data.content;
                                angular.forEach($scope.model, function (data1, index) {
                                    angular.forEach($scope.operatorList, function (data2, index) {
                                        if(data1.operatorCode==data2.userCode){
                                            data1.remark = data2.userName
                                        }
                                    });
                                });
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
                $scope.getComCodeList();//归属机构下拉初始化
            };
            //模板修改的时候点击修改方案根据机构查询条款
            $scope.getClause = function(){
                $rootScope.comTreeCtrlFlag=false;
                if($scope.proposal.modelCode==""||$scope.proposal.modelCode==null||!$scope.proposal.modelCode){
                    $scope.prpMmodelMainDto.riskScheme="0";
                }
                var queryClauseList = [];
                angular.forEach($scope.proposal.prpMmodelComDtoList, function (data, index) {
                    queryClauseList.push(data.comCode);
                });
                $$finder.find('queryItemByRiskCodeAndCom',{
                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                    comCodeList:queryClauseList//适用机构
                }, {
                    success: function (data) {
                        $scope.clause=data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.getItemsss=function(){
                var comCodeList =[];
                angular.forEach($scope.proposal.prpMmodelComDtoList, function (data, index) {
                    comCodeList.push(data.comCode);
                });
                $$finder.find('queryItemByRiskCodeAndCom',{
                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                    comCodeList:comCodeList//适用机构
                }, {
                    success: function (data) {
                        $scope.clause=data.content;
                        if($scope.clause.length==1){//当仅有一条条款时默认选中
                            $scope.value=$scope.clause[0].clauseName;
                            $scope.proposal.prpTmainDto.versionNo=$scope.clause[0].clauseCode;
                        }
                        if($scope.proposal.prpTmainDto.versionNo){

                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //选择条款
            $scope.getItems=function(){
                var comCodeList =[];
                if($rootScope.treecheck){
                    for (var i=0;i<$rootScope.treecheck.length;i++){
                        comCodeList.push($rootScope.treecheck[i].id)
                    }
                }
                $$finder.find('queryItemByRiskCodeAndCom',{
                    riskCode:$scope.proposal.prpTmainDto.riskCode,//险种
                    comCodeList:comCodeList//适用机构
                }, {
                    success: function (data) {
                        $scope.clause=data.content;

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //选择险种下拉搜索框
            $scope.$watch('proposal.prpTmainDto.classCode',function(newvalue){
                if(newvalue){
                    $$finder.find('queryRiskCodeInfoQuick',{
                        classCode:newvalue,//险类
                        "itemCodeList": itemCodeList,
                    }, {
                        success: function (data) {
                            $scope.riskCodeList=data.content;
                            if(itemCodeList.length>0){
                                $scope.proposal.prpTmainDto.riskCode = $scope.riskCodeList[0].riskCode;
                                $scope.proposal.prpTmainDto.riskCodeName = $scope.riskCodeList[0].riskCName;
                                $scope.getComCodeList();//归属机构下拉初始化
                            }


                        },
                        error: function (e) {
                            options.error(e);
                        }
                    })
                }
            });

            //主页面条款输入框禁用
            $scope.reverseData=function(data,event,type){
                if(type=='EditType'){
                    $scope.editType=event.target.innerText
                }else{
                    $scope.classCode=event.target.innerText
                }
            }

            /*清单号查询部分*/
            //清单号查询弹层
            $scope.relationListNoLayer = false;
            $scope.relationListQueryLayer = false;
            $scope.closeRelationListLayer2= function () {
                $scope.relationListNoLayer = false;
                $scope.relationListQueryLayer = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //清单号查询按钮
            $scope.queryRelationListNoLayer = function (num,serialNo) {
                if(num){//用户清单列表分页问题
                    $scope.paginationConfmm2.currentPage=1;
                }
                $scope.proposal.insureMainListDto.insureListCode = num||$scope.proposal.insureMainListDto.insureListCode
                if ($scope.proposal.insureMainListDto.insureListCode) {
                    var dto = angular.copy($scope.requestInsuranceQueryDto);
                    dto.insureListCode=$scope.proposal.insureMainListDto.insureListCode;
                    dto.pageNo=1;
                    $$finder.find("findGisInsureMainLists",dto, {
                        success: function (data) {
                            if(data.code="0000"&&data.content.content.length>0){
                                $scope.proposal.insureMainListDto.serialNo=data.content.content[0].serialNo;
                                $$finder.find("findGisFarmerListByInsureListCodeAndserialNo",{
                                    "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                                    "serialNo":$scope.proposal.insureMainListDto.serialNo,
                                    'pageNo':$scope.paginationConfmm2.currentPage,
                                    'pageSize':$scope.paginationConfmm2.itemsPerPage
                                },{
                                    success: function (data) {
                                        if(data.code=="0000"&&data.content.gisFarmerListDtoList.length>0){
                                            $timeout(function () {
                                                if($scope.relativeInsureListCode&&$scope.relationType=='input'){
                                                    return
                                                }else{
                                                    $scope.relationListNoLayer = true;
                                                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                                                    $scope.gisFarmerListDtoList=data.content.gisFarmerListDtoList;
                                                    $scope.paginationConfmm2.totalItems=data.content.count;
                                                }
                                            },30)
                                        }else{
                                            layer.open({
                                                /*offset: ['40%', '36%'],*/
                                                skin: 'large-layer-content',
                                                closeBtn: 0,
                                                title: '温馨提示',
                                                scrollbar: false,
                                                content: '您输入的清单编号在系统中不存在，请重新输入！',
                                                btn: ['确定'],
                                                btn1: function (index, layero) {
                                                    //按钮【按钮一】的回调
                                                    layer.close(index);
                                                    $("#insureListCode").focus();
                                                }
                                            });
                                            $scope.proposal.insureMainListDto.insureListCode="";
                                        }

                                    },
                                    error: function (data) {
                                        layer.open({
                                            /*offset: ['35%', '40%'],*/
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: '查询的数据不存在，请重新查询！',
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            }
                                        });
                                    }
                                });
                            }else{
                                layer.open({
                                    /*offset: ['35%', '36%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: "您输入的清单编号在系统中不存在，请重新输入！",
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                })
                                $scope.proposal.insureMainListDto.insureListCode="";
                            }
                        },
                        error: function (data) {
                        }
                    })

                    //    if(serialNo){
                    //    $scope.proposal.insureMainListDto.serialNo=serialNo;
                    //}

                } else {
                    $scope.relationListQueryLayer = true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    $scope.resetQueryGisInsure()
                }
            }
            var indexPage3=function () {
                $scope.paginationConfmm2 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        $scope.queryRelationListNoLayer();
                    }
                }
            };
            indexPage3();
            //取消按钮
            $scope.cancel = function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
                $scope.relationListQueryLayer = false;
                $scope.proposal.insureMainListDto.insureListCode = '';
                $scope.requestInsuranceQueryDto.beginTime="";
                $scope.requestInsuranceQueryDto.endTime="";
            }
            //确定按钮
            $scope.closeRelationListNoLayer = function (type) {
                $scope.relationType=type;
                if (!$scope.requestInsuranceQueryDto.queryList1) {
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '请选择一个清单或者点击关闭退出',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }else{
                    if($scope.queryHide){
                        $$finder.find('queryPrpCmainInfo',{
                            gisInsureListCode:$scope.proposal.insureMainListDto.insureListCode,
                            pageNo: $scope.paginationConfmm4.currentPage,
                            pageSize: $scope.paginationConfmm4.itemsPerPage
                        },{
                            success: function (data) {
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
                                    $scope.relationListNoLayer = false;
                                    $("html,body").css({overflow:"auto"});//出现滚动条
                                    $scope.relationListQueryLayer = false;
                                    $$finder.find('queryMarkedList', {

                                        // "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode,//金禾清单号
                                        "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                                        "serialNo":$scope.proposal.insureMainListDto.serialNo//标的清单序号
                                    }, {
                                        success: function (data) {
                                            $scope.queryMarkedList=data.content
                                        },
                                        error: function (e) {
                                            options.error(e);
                                        }
                                    });
                                    $scope.requestInsurance($scope.proposal.insureMainListDto.insureListCode,$scope.proposal.insureMainListDto.serialNo);

                                }
                            }
                        })
                    }else{
                        $scope.relationListNoLayer = false;
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $scope.relationListQueryLayer = false;
                        $$finder.find('queryMarkedList', {

                            // "insureListCode": $scope.requestInsuranceQueryDto.queryList[index].insureListCode,//金禾清单号
                            "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                            "serialNo":$scope.proposal.insureMainListDto.serialNo//标的清单序号
                        }, {
                            success: function (data) {
                                $scope.queryMarkedList=data.content
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                        $scope.requestInsurance($scope.proposal.insureMainListDto.insureListCode,$scope.proposal.insureMainListDto.serialNo);

                    }

                }

              }

            $scope.closeRelationListNoLayer2= function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            //获取归属区域省
            $scope.getUserRegion =function(ID,Field){
                $$finder.find('getUserRegion', {
                    "userCode":$rootScope.user.userCode,//用户名
                    "parentID":ID//上级区域ID，默认显示省级时，parentID=0
                }, {
                    success: function (data) {
                        if(Field==1){
                            $scope.businessProvince = data.content;
                        }else if(Field==2){
                            $scope.businessTown = data.content;
                        }else if(Field==3){
                            $scope.businessCounty = data.content;
                        }else if(Field==4){
                            $scope.businessCity = data.content;
                        }else if(Field==5){
                            $scope.businessAreaName = data.content;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //获取归属区域市
            $scope.getUserRegion2 = function(){
                angular.forEach($scope.businessProvince, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fProvinceCode == data.gbbh) {
                          $scope.cityNameRegionid=data.regionid;
                    }
                });
                $scope.getUserRegion($scope.cityNameRegionid,2)
            }
            //获取归属区域区
            $scope.getUserRegion3 = function(){
                angular.forEach($scope.businessTown, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fCityCode == data.gbbh) {
                        $scope.townNameRegionid=data.regionid;
                    }
                });
                $scope.getUserRegion($scope.townNameRegionid,3)
            }
            //获取归属区域县
            $scope.getUserRegion4 = function(){
                angular.forEach($scope.businessCounty, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fCountyCode == data.gbbh) {
                        $scope.townRegionid=data.regionid;
                    }
                });
                $scope.getUserRegion($scope.townRegionid,4)
            }
            //获取归属区域乡
            $scope.getUserRegion5 = function(){
                angular.forEach($scope.businessCity, function (data, index) {
                    if ($scope.requestInsuranceQueryDto.fTownCode == data.gbbh) {
                        $scope.areaRegionid=data.regionid;
                    }
                });
                $scope.getUserRegion($scope.areaRegionid,5)
            }

            //日期校验
            $scope.compareDate1 = function(startDate,endDate) {
                var content;
                //if (endDate&&!startDate){
                //    content = '请录入清单缮制起期';
                //    $scope.requestInsuranceQueryDto.endTime="";
                //    layer.open({
                //        offset: ['40%', '40%'],
                //        skin: 'large-layer-content',
                //        closeBtn: 0,
                //        title: '温馨提示',
                //        scrollbar: false,
                //        content: content,
                //        btn: ['确定'],
                //        btn1: function(index, layero){
                //            //按钮【按钮一】的回调
                //            layer.close(index);
                //        }
                //    });
                //    return false
                //}else {
                if(endDate&&startDate){
                    $scope.day1(startDate,endDate);
                }
            }
            $scope.compareDate11=function(startDate,endDate){
                if(endDate&&startDate){
                    $scope.day1(startDate,endDate);
                }
            }
            $scope.day1=function(startDate,endDate){
                var startDate = parseInt(startDate.replace(/-/g, ""), 10); //有效起期
                var endDate = parseInt(endDate.replace(/-/g, ""), 10); //有效止期
                var content;
                if (startDate>endDate){
                    content = '清单缮制止期要大于清单缮制起期';
                    $scope.requestInsuranceQueryDto.beginTime = $filter('date')(new Date().setDate("01"),"yyyy-MM-dd");
                    $scope.requestInsuranceQueryDto.endTime = $filter("date")(new Date(),"yyyy-MM-dd");
                    layer.open({
                        offset: ['40%', '40%'],
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
            //fenge
            /*$scope.compareDate=function(startDate,endDate){

                var startDate = parseInt(startDate.replace(/-/g,""),10);
                var endDate = parseInt(endDate.replace(/-/g,""),10);
                if(startDate>endDate) {
                    var content;
                    content = '清单缮制止期不可早于缮制起期，请更改';
                    //$scope.requestInsuranceQueryDto.endTime = "";
                    layer.open({
                        /!*offset: ['38%', '38%'],*!/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    //获取时间
                    var date = new Date()
                    $scope.getdate = {
                        year: date.getFullYear(),
                        month: date.getMonth(),
                        day: date.getDate()
                    }
                    var _month = $scope.getdate.month;
                    if (_month >= 10) {
                        $scope.getdate.month = (_month + 1);
                    } else {
                        $scope.getdate.month = '0' + (_month + 1);
                    }
                    var _day = $scope.getdate.day;
                    if (_day >= 10) {
                        $scope.getdate.day = (_day);
                    } else {
                        $scope.getdate.day = '0' + (_day);
                    }
                    $scope.requestInsuranceQueryDto.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
                    $scope.requestInsuranceQueryDto.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
                }
            }*/
            //模板名称校验
            $scope.checkModelName = function ($event,modelName) {
                var applaynameReg=/^[\u4e00-\u9fa5]+$/;
                var v= applaynameReg.test(modelName);
                var applaynameReg1 = /^[0-9\u4e00-\u9fa5]+$/;
                var vv = applaynameReg1.test(modelName);
                var  applaynameReg2 = /(?!\d+$)[\d\u4e00-\u9fa5]/;
                var vvv = applaynameReg2.test(modelName);
                if((modelName&&v==false)&&vv==false){
                    $scope.proposal.checkModelName="请输入正确的模板名称!";
                    $event.target.focus();
                }else if((modelName&&v==false)&&vv==true&&vvv==false){
                    $scope.proposal.checkModelName="请输入正确的模板名称!";
                    $event.target.focus();
                }else{
                    $scope.proposal.checkModelName="";
                }

            }
            $scope.findModelCode=function(){
                if($scope.prpMmodelMainDto.modelCode==null || $scope.prpMmodelMainDto.modelCode==undefined) {
                    $$finder.find('creatProposal', {
                        "tableName": "prpmmodelmain",//表名
                        "iYear": new Date().getFullYear(),//当前年份
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "iComCode": $rootScope.user.loginComCode,
                        "userCode": $rootScope.user.userCode
                    }, {
                        success: function (data) {
                            $scope.prpMmodelMainDto.modelCode = data.content.billNo;
                            $rootScope.getModelCode = $scope.prpMmodelMainDto.modelCode;
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            //清单号查询服务  陈澎
            //清单号查询按钮
            $scope.requestInsuranceQueryDto = {};
            $scope.requestInsuranceQueryDto.queryList = {};
            $scope.requestInsuranceQueryDto.pageNo = 1;
            $scope.requestInsuranceQueryDto.pageSize = 2;
            //清单查询的重置按钮
            $scope.resetQueryGisInsure = function () {
                $scope.requestInsuranceQueryDto = {};
                $scope.requestInsuranceQueryDto.queryList = {};
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 2;
                $scope.totalItems = 0;
                //查询结果条数
                $scope.paginationConfmm.totalItems = $scope.totalItems;
                //initPage2();
                //获取时间
                var date = new Date()
                $scope.getdate = {
                    year: date.getFullYear(),
                    month: date.getMonth(),
                    day: date.getDate()
                }
                var _month = $scope.getdate.month;
                if (_month >= 10) {
                    $scope.getdate.month = (_month + 1);
                } else {
                    $scope.getdate.month = '0' + (_month + 1);
                }
                var _day = $scope.getdate.day;
                if (_day >= 10) {
                    $scope.getdate.day = (_day);
                } else {
                    $scope.getdate.day = '0' + (_day);
                }
                //$scope.beginTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + '01';
                //$scope.endTime = $scope.getdate.year + '-' + $scope.getdate.month + '-' + $scope.getdate.day;
                //$scope.requestInsuranceQueryDto.beginTime = $scope.beginTime;
                //$scope.requestInsuranceQueryDto.endTime = $scope.endTime;
                $scope.requestInsuranceQueryDto.queryList = {};
                $scope.requestInsuranceQueryDto.listAlias = null;
                $scope.requestInsuranceQueryDto.affrimOpName = null;
                $scope.requestInsuranceQueryDto.pageNo = 1;
                $scope.requestInsuranceQueryDto.pageSize = 20;
            }
            //查询结果
            $scope.loading=false;
            $scope.queryGisInsure = function () {
                //if(!$scope.requestInsuranceQueryDto.beginTime&&$scope.requestInsuranceQueryDto.endTime){
                //    layer.open({
                //        /*offset: ['45%', '40%'],*/
                //        skin: 'large-layer-content',
                //        closeBtn: 0,
                //        title: '温馨提示',
                //        scrollbar: false,
                //        content:  '请录入清单缮制起期！',
                //        btn: ['确定'],
                //        btn1: function(index, layero){
                //            //按钮【按钮一】的回调
                //            layer.close(index);
                //        }
                //    });
                //    return
                //}
                var dto = angular.copy($scope.requestInsuranceQueryDto);
                dto.pageNo=1;
                var address = angular.copy($scope.proposal.prpTmainDto);
                var NameReg=/^[\u4E00-\u9FA50-9]+$/g//汉字数字校验
                var appliNameReg=/^[\u4E00-\u9FA5A-Za-z0-9]+$/g;// 汉字数字字母
                var Name=/^[\u4E00-\u9FA5]+$/g//汉字
                var content="";
                if(($scope.requestInsuranceQueryDto.insureListCode!=undefined&&$scope.requestInsuranceQueryDto.insureListCode!=""&&$scope.requestInsuranceQueryDto.insureListCode!=null)
                    ||($scope.requestInsuranceQueryDto.listAlias!=undefined&&$scope.requestInsuranceQueryDto.listAlias!=""&&$scope.requestInsuranceQueryDto.listAlias!=null)
                    ||($scope.requestInsuranceQueryDto.affrimOpName!=undefined&&$scope.requestInsuranceQueryDto.affrimOpName!=""&&$scope.requestInsuranceQueryDto.affrimOpName!=null)
                    ||(($scope.requestInsuranceQueryDto.beginTime!=undefined&&$scope.requestInsuranceQueryDto.beginTime!=""&&$scope.requestInsuranceQueryDto.beginTime!=null)
                    ||($scope.requestInsuranceQueryDto.endTime!=undefined&&$scope.requestInsuranceQueryDto.endTime!=""&&$scope.requestInsuranceQueryDto.endTime!=null))
                    ||(($scope.requestInsuranceQueryDto.fProvinceCode!=undefined&&$scope.requestInsuranceQueryDto.fProvinceCode!=""&&$scope.requestInsuranceQueryDto.fProvinceCode!=null)
                    ||($scope.requestInsuranceQueryDto.fCityCode!=undefined&&$scope.requestInsuranceQueryDto.fCityCode!=""&&$scope.requestInsuranceQueryDto.fCityCode!=null)
                    ||($scope.requestInsuranceQueryDto.fCountyCode!=undefined&&$scope.requestInsuranceQueryDto.fCountyCode!=""&&$scope.requestInsuranceQueryDto.fCountyCode!=null)
                    ||($scope.requestInsuranceQueryDto.fTownCode!=undefined&&$scope.requestInsuranceQueryDto.fTownCode!=""&&$scope.requestInsuranceQueryDto.fTownCode!=null)
                    ||($scope.requestInsuranceQueryDto.fVillageCode!=undefined&&$scope.requestInsuranceQueryDto.fVillageCode!=""&&$scope.requestInsuranceQueryDto.fVillageCode!=null))
                )
                {


                }else{
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请至少录入一个查询条件！',
                        btn: ['确定'],
                        scrollbar: false,
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                if($scope.requestInsuranceQueryDto.insureListCode){
                    var reg=/^\d+$/g;
                    if(reg.test($scope.requestInsuranceQueryDto.insureListCode)){
                        if($scope.requestInsuranceQueryDto.insureListCode.length<15){
                            content="清单号码需输入至少15位数！"
                        }
                    }else{
                        content = '清单号码格式错误，请修改';
                        $scope.requestInsuranceQueryDto.insureListCode="";
                    }
                }/*else if($scope.requestInsuranceQueryDto.listAlias&&!Name.test($scope.requestInsuranceQueryDto.listAlias)){
                    //投保单人名称
                    content="清单名称格式错误，请修改";
                    $scope.requestInsuranceQueryDto.listAlias="";
                }*/else if($scope.requestInsuranceQueryDto.affrimOpName&&!NameReg.test($scope.requestInsuranceQueryDto.affrimOpName)){
                    //投保单人名称
                    content="缮制人名称格式错误，请修改";
                    $scope.requestInsuranceQueryDto.affrimOpName="";
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
                }else {
                    $scope.loading=true;
                    if($scope.requestInsuranceQueryDto.insureListCode){
                        $scope.requestInsuranceQueryDto.beginTime = "";
                        $scope.requestInsuranceQueryDto.endTime ="";
                        dto.beginTime = "";
                        dto.endTime ="";
                    }
                    var param = {
                        insureListCode:$scope.requestInsuranceQueryDto.insureListCode,
                        listAlias:$scope.requestInsuranceQueryDto.listAlias,
                        beginTime:$scope.requestInsuranceQueryDto.beginTime,
                        endTime:$scope.requestInsuranceQueryDto.endTime,
                        opName:$scope.requestInsuranceQueryDto.opName,
                        riskCode:$scope.proposal.prpTmainDto.riskCode,
                        queryScenes:'proposal',
                        pageNo:$scope.requestInsuranceQueryDto.pageNo = 1,
                        pageSize:$scope.requestInsuranceQueryDto.pageSize = 20
                    };
                    if ($scope.requestInsuranceQueryDto.fProvinceCode) {
                        param.fProvinceCodes=[$scope.requestInsuranceQueryDto.fProvinceCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fCityCode) {
                        param.fCityCodes=[$scope.requestInsuranceQueryDto.fCityCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fCountyCode) {
                        param.fCountyCodes=[$scope.requestInsuranceQueryDto.fCountyCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fTownCode) {
                        param.fTownCodes=[$scope.requestInsuranceQueryDto.fTownCode]
                    }
                    if ($scope.requestInsuranceQueryDto.fVillageCode) {
                        param.fVillageCodes=[$scope.requestInsuranceQueryDto.fVillageCode]
                    }
                    $$finder.find('findGisInsureMainLists', param, {
                        success: function (data) {
                            if(data.code=="0000"&&data.content.content.length>0) {
                                $scope.loading=false;
                                $scope.requestInsuranceQueryDto.queryList = data.content.content;
                                for (var i = 0; i < $scope.requestInsuranceQueryDto.queryList.length; i++) {
                                    $scope.date1 = $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime;
                                    $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime = $filter("date")($scope.date1, "yyyy-MM-dd");
                                }
                                $scope.totalItems = data.content.totalCount;
                                //查询结果条数
                                $scope.paginationConfmm.totalItems = $scope.totalItems;
                                $scope.paginationConfmm.currentPage=data.content.pageNo;
                                $scope.isSelected = function (x) {
                                    $scope.requestInsuranceQueryDto.queryList1 = data.content.content[x];
                                    //清单类型
                                    if ($scope.requestInsuranceQueryDto.queryList1.listType == 'D') {
                                        $scope.proposal.insureMainListDto.listTypeFlag = '大户';
                                    } else if ($scope.requestInsuranceQueryDto.queryList1.listType == 'S') {
                                        $scope.proposal.insureMainListDto.listTypeFlag = '散户';
                                    }
                                    //清单备注
                                    $scope.proposal.prpTmainAgriDto.relationListNoRemark = $scope.requestInsuranceQueryDto.queryList1.remark;
                                    //金禾清单号
                                    $scope.proposal.insureMainListDto.insureListCode = $scope.requestInsuranceQueryDto.queryList1.insureListCode;
                                    //清单序号
                                    $scope.proposal.insureMainListDto.serialNo = $scope.requestInsuranceQueryDto.queryList1.serialNo;
                                    //归属区域存储代码
                                    $scope.proposal.prpTmainDto.businessProvince = $scope.requestInsuranceQueryDto.queryList1.fProvinceCode;//省
                                    $scope.proposal.prpTmainDto.businessCity = $scope.requestInsuranceQueryDto.queryList1.fCityCode;//市
                                    $scope.proposal.prpTmainDto.businessCounty = $scope.requestInsuranceQueryDto.queryList1.fCountyCode;//区县
                                    $scope.proposal.prpTmainDto.businessTown = $scope.requestInsuranceQueryDto.queryList1.fTownCode;//乡镇
                                    $scope.proposal.prpTmainDto.businessArea = $scope.requestInsuranceQueryDto.queryList1.fVillageCode;//村
                                    //归属区域页面显示
                                    $scope.proposal.prpTmainDto.businessProvinceName = $scope.requestInsuranceQueryDto.queryList1.fProvinceName;
                                    $scope.proposal.prpTmainDto.businessCityName = $scope.requestInsuranceQueryDto.queryList1.fCityName;
                                    $scope.proposal.prpTmainDto.businessCountyName = $scope.requestInsuranceQueryDto.queryList1.fCountyName;
                                    $scope.proposal.prpTmainDto.businessTownName = $scope.requestInsuranceQueryDto.queryList1.fTownName;
                                    $scope.proposal.prpTmainDto.businessAreaName = $scope.requestInsuranceQueryDto.queryList1.fVillageName;
                                    //承保清单归属区域最后一级
                                    $scope.proposal.prpTmainDto.richflyAreasCode = $scope.requestInsuranceQueryDto.queryList1.pVillageCode;
                                    $scope.proposal.prpTmainDto.richflyAreasCname = $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                    //赋值到种植地点中的地址之中
                                    var addressName = $scope.requestInsuranceQueryDto.queryList1.pProvinceName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pCityName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pCountyName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pTownName + '-' +
                                        $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                    var addressNameArry = addressName.split('-');
                                    angular.forEach(addressNameArry, function (data, index) {
                                        if (data == 'undefined') {
                                            addressNameArry.splice(index, 1)
                                        }
                                    });
                                    $scope.proposal.prpTaddressDto.addressName = addressNameArry.join("")
                                    //我方清单号生成
                                    // $$finder.find('creatProposal', {
                                    //     "tableName": "insureMainList",
                                    //     "iYear": new Date().getFullYear(),//当前年份
                                    //     "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种  "3101"
                                    //     "iComCode": $scope.proposal.prpTmainDto.comCode,//归属机构 "3400000000"
                                    //     "userCode": $rootScope.user.userCode
                                    // }, {
                                    //     success: function (data) {
                                    //         $scope.proposal.prpTmainAgriDto.relationListNo = data.content.billNo;
                                    //         console.log(data.content.billN)
                                    //     },
                                    //     error: function (e) {
                                    //         options.error(e);
                                    //     }
                                    // });
                                    // $scope.requestInsurance(x);//清单详细信息
                                    //  $scope.queryMarkedList(x);//清单标的
                                }
                            }else{
                                $scope.resetQueryGisInsure();
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "无查询结果！",
                                    scrollbar: false,
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                $scope.loading=false;
                            }
                        },
                        error: function (e) {
                            options.error(e);
                        }
                    });
                }
            }
            $scope.findNo=function(editType,prpsaNo){//编辑类型     输入的业务号
                var modelCodeReg=/^\d{15,}$/;//至少15位
                var content="";
                editType=='COPY_PROPOSAL'? $scope.prpsaNoType='0':$scope.prpsaNoType='1';//0是投保单   1是保单

                if(prpsaNo){//当有业务号时
                    if(modelCodeReg.test(prpsaNo)){//满足正则校验  校验是否存在
                        //复制投保单
                        if ($scope.proposal.editType=='COPY_PROPOSAL'){
                            //关闭出单向导,显示主页面
                            //$scope.$emit('closeRiskScheme',false);
                            //投保单详细信息查询
                            $$finder.find('queryProposalInfo', {
                                "proposalNo": prpsaNo,
                                "familyNos": null
                            }, {
                                success: function (data) {
                                    if(data.code=="0000"&&data.content){
                                        $scope.riskCode=data.content.prpTmainDto.riskCode;
                                        $scope.proposalQueryMessage(data,$scope.proposal.editType);
                                        $scope.proposal.prpTmainDto.startDate=null;
                                        $scope.proposal.prpTmainDto.endDate=null;
                                        //------------------校验模板与条款开始------------------------------
                                        $scope.checkClauseAndModel(data.content.prpTmainDto.versionNo,data.content.prpTmainDto.groupNo,"COPY_PROPOSAL");
                                        //-------------------校验模板与条款结束-----------------------------
                                        $scope.proposal.editType="COPY_PROPOSAL";//编辑类型
                                        $scope.proposal.prpTmainDto.copyOldNo=prpsaNo;
                                        //$scope.proposal.prpTmainDto=data.content.prpTmainDto;
                                        $scope.getItemsAndModel();
                                    }else{
                                        layer.open({
                                            /*offset: ['35%', '40%'],*/
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: "输入的投保单号不存在!",
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            }
                                        });
                                        $scope.proposal.prpTmainDto.proposalNo="";
                                    }
                                }
                            })
                        }
                        //复制保单    //在本公司续保
                        else{
                            //关闭出单向导,显示主页面
                            //$scope.$emit('closeRiskScheme',false);

                            //保单详细信息详情
                            $$finder.find('queryPolicyInfoByPolicyNo', {
                                    "policyNo":prpsaNo,
                                    "languageFlag":"zh-CN",
                                    "loginComCode": $rootScope.user.loginComCode,
                                    "userCode": $rootScope.user.userCode,
                                }, {
                                    success: function (data) {
                                        if(data.code=="0000"&&data.content){
                                            //-----------------增加一个copy标识，代表是复制保单或续保
                                            $scope.queryPolicyInfo(data,'copy');
                                            $scope.proposal.prpTmainDto.startDate=null;
                                            $scope.proposal.prpTmainDto.endDate=null;
                                            //------------------校验模板与条款开始------------------------------
                                            $scope.checkClauseAndModel(data.content.prpCmainDto.versionNo,data.content.prpCmainDto.groupNo,"");
                                            //-------------------校验模板与条款结束-----------------------------
                                            $scope.proposal.prpTmainDto.copyOldNo=prpsaNo;
                                            $scope.proposal.editType=editType;//编辑类型
                                            $scope.getItemsAndModel();
                                            //$scope.riskCode
                                        }else{
                                            layer.open({
                                                /*offset: ['35%', '40%'],*/
                                                skin: 'large-layer-content',
                                                closeBtn: 0,
                                                title: '温馨提示',
                                                content: "输入的保单号不存在!",
                                                btn: ['确定'],
                                                scrollbar: false,
                                                btn1: function (index, layero) {
                                                    //按钮【按钮一】的回调
                                                    layer.close(index);
                                                }
                                            });
                                            $scope.proposal.prpTmainDto.copyOldNo="";
                                        }

                                    },
                                    error: function () {
                                    }
                                }
                            )
                        }

                        /* else if($scope.proposal.editType=='RENEWAL'){
                         //关闭出单向导,显示主页面
                         //$scope.$emit('closeRiskScheme',false);
                         }
                         */

                    }else{
                        if($scope.prpsaNoType=='0'){
                            content="请输入正确的投保单号！"
                        }else{
                            content="请输入正确的保单号！"
                        }
                    }


                }else{
                    if($scope.prpsaNoType=="1"){
                        content="请输入正确的保单号！";
                    }else{
                        content="请输入正确的投保单号！";
                    }

                }
                if(content){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
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
                /* if(prpsaNo!=''&&prpsaNo!=null){
                 if(prpsaNo&&!modelCodeReg.test(prpsaNo))
                 {
                 $scope.hint($event,'1');
                 }else {
                 //执行查询方法
                 }
                 }else {
                 //提示弹窗
                 $scope.hint($event,$scope.proposal.editType);
                 return;
                 }*/
            }
            //更改业务号
            $scope.changeproposalNo= function () {
                $scope.proposal.prpTmainDto.classCode="";
                $scope.proposal.prpTmainDto.riskCode="";
                $scope.proposal.prpTmainDto.comCode="";
                $scope.clause=[];
                $scope.proposal.insureMainListDto.insureListCode="";
            }
            //清单号查询结果的分页设置
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmm.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $scope.requestInsuranceQueryDto.pageNo = $scope.paginationConfmm.currentPage;
                            $scope.requestInsuranceQueryDto.pageSize = $scope.paginationConfmm.itemsPerPage;
                            var dto = angular.copy($scope.requestInsuranceQueryDto);
                            var arr = Object.keys(dto);//js获取对象长度
                            //如果没有选择选项 就会提示弹层
                            if (arr.length <= 5 && $scope.requestInsuranceQueryDto.endTime == '' && $scope.requestInsuranceQueryDto.beginTime == '') {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '至少选择一个条件!',
                                    scrollbar: false,
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            } else {
                                var param = {
                                    insureListCode:$scope.requestInsuranceQueryDto.insureListCode,
                                    listAlias:$scope.requestInsuranceQueryDto.listAlias,
                                    beginTime:$scope.requestInsuranceQueryDto.beginTime,
                                    endTime:$scope.requestInsuranceQueryDto.endTime,
                                    opName:$scope.requestInsuranceQueryDto.opName,
                                    riskCode:$scope.proposal.prpTmainDto.riskCode,
                                    queryScenes:'proposal',
                                    pageNo:$scope.requestInsuranceQueryDto.pageNo,
                                    pageSize:$scope.requestInsuranceQueryDto.pageSize
                                };
                                if ($scope.requestInsuranceQueryDto.fProvinceCode) {
                                    param.fProvinceCodes=[$scope.requestInsuranceQueryDto.fProvinceCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fCityCode) {
                                    param.fCityCodes=[$scope.requestInsuranceQueryDto.fCityCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fCountyCode) {
                                    param.fCountyCodes=[$scope.requestInsuranceQueryDto.fCountyCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fTownCode) {
                                    param.fTownCodes=[$scope.requestInsuranceQueryDto.fTownCode]
                                }
                                if ($scope.requestInsuranceQueryDto.fVillageCode) {
                                    param.fVillageCodes=[$scope.requestInsuranceQueryDto.fVillageCode]
                                }
                                $$finder.find('findGisInsureMainLists', param, {
                                    success: function (data) {
                                        $scope.requestInsuranceQueryDto.queryList = data.content.content;
                                        for(var i=0;i<$scope.requestInsuranceQueryDto.queryList.length;i++){
                                            $scope.date1 = $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime;
                                            $scope.requestInsuranceQueryDto.queryList[i].listAffrimTime = $filter("date")(  $scope.date1, "yyyy-MM-dd");
                                        }
                                        $scope.totalItems = data.content.totalCount;
                                        //查询结果条数
                                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                                        $scope.isSelected = function (x) {
                                            $scope.requestInsuranceQueryDto.queryList1 = data.content.content[x];
                                            //清单类型
                                            if ($scope.requestInsuranceQueryDto.queryList1.listType == 'D') {
                                                $scope.proposal.insureMainListDto.listTypeFlag = '大户';
                                            } else if ($scope.requestInsuranceQueryDto.queryList1.listType == 'S') {
                                                $scope.proposal.insureMainListDto.listTypeFlag = '散户';
                                            }
                                            //清单备注
                                            $scope.proposal.prpTmainAgriDto.relationListNoRemark = $scope.requestInsuranceQueryDto.queryList1.remark
                                            //清单号
                                            $scope.proposal.insureMainListDto.insureListCode = $scope.requestInsuranceQueryDto.queryList1.insureListCode;
                                            //清单序号
                                            $scope.proposal.insureMainListDto.serialNo = $scope.requestInsuranceQueryDto.queryList1.serialNo;
                                            //归属区域存储代码
                                            $scope.proposal.prpTmainDto.businessProvince = $scope.requestInsuranceQueryDto.queryList1.fProvinceCode;//省
                                            $scope.proposal.prpTmainDto.businessCity = $scope.requestInsuranceQueryDto.queryList1.fCityCode;//市
                                            $scope.proposal.prpTmainDto.businessCounty = $scope.requestInsuranceQueryDto.queryList1.fCountyCode;//区县
                                            $scope.proposal.prpTmainDto.businessTown= $scope.requestInsuranceQueryDto.queryList1.fTownCode;//乡镇
                                            $scope.proposal.prpTmainDto.businessArea = $scope.requestInsuranceQueryDto.queryList1.fVillageCode;//村
                                            //归属区域页面显示
                                            $scope.proposal.prpTmainDto.businessProvinceName=$scope.requestInsuranceQueryDto.queryList1.fProvinceName;
                                            $scope.proposal.prpTmainDto.businessCityName=$scope.requestInsuranceQueryDto.queryList1.fCityName;
                                            $scope.proposal.prpTmainDto.businessCountyName=$scope.requestInsuranceQueryDto.queryList1.fCountyName;
                                            $scope.proposal.prpTmainDto.businessTownName=$scope.requestInsuranceQueryDto.queryList1.fTownName;
                                            $scope.proposal.prpTmainDto.businessAreaName=$scope.requestInsuranceQueryDto.queryList1.fVillageName;
                                            //承保清单归属区域最后一级
                                            $scope.proposal.prpTmainDto.richflyAreasCode=$scope.requestInsuranceQueryDto.queryList1.pVillageCode;
                                            $scope.proposal.prpTmainDto.richflyAreasCname=$scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                            //赋值到种植地点中的地址之中
                                            var addressName= $scope.requestInsuranceQueryDto.queryList1.pProvinceName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pCityName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pCountyName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pTownName + '-' +
                                                $scope.requestInsuranceQueryDto.queryList1.pVillageName;
                                            var addressNameArry=addressName.split('-');
                                            angular.forEach(addressNameArry,function(data,index){
                                                if(data=='undefined'){
                                                    addressNameArry.splice(index,1)
                                                }
                                            });
                                            $scope.proposal.prpTaddressDto.addressName=addressNameArry.join('-');
                                            //我方清单号生成
                                            // $$finder.find('creatProposal', {
                                            //     "tableName": "insureMainList",
                                            //     "iYear": new Date().getFullYear(),//当前年份
                                            //     "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种  "3101"
                                            //     "iComCode": $scope.proposal.prpTmainDto.comCode,//归属机构 "3400000000"
                                            //     "userCode": $rootScope.user.userCode
                                            // }, {
                                            //     success: function (data) {
                                            //         $scope.proposal.prpTmainAgriDto.relationListNo = data.content.billNo;
                                            //     },
                                            //     error: function (e) {
                                            //         options.error(e);
                                            //     }
                                            // });
                                            //$scope.requestInsurance(x);
                                            //$scope.queryMarkedList();//清单标的
                                        }
                                        var select = document.getElementsByName('select');
                                        for(var i=0;i<select.length;i++){
                                            if(select[i].checked)
                                            {
                                                select[i].checked=false; //不选中
                                            }
                                        }
                                    },
                                    error: function (e) {
                                        options.error(e);
                                    }
                                });
                            }
                        }
                    }
                };
            };
            initPage2();
            //点击清单号码查看详细信息

            //清单带入信息不可修改
            $scope.nogai=function(){
                //投保人清单信息带入不可修改
                if($scope.proposal.appliInsuredDto.insuredType!=null&&$scope.proposal.appliInsuredDto.insuredType!=""&&$scope.proposal.appliInsuredDto.insuredType!=undefined){
                    $rootScope.kelei=true;
                }
                if($scope.proposal.appliInsuredDto.identifyType!=null&&$scope.proposal.appliInsuredDto.identifyType!=""&&$scope.proposal.appliInsuredDto.identifyType!=undefined){
                    $rootScope.zhenglei=true;
                }
                if($scope.proposal.appliInsuredDto.identifyNumber!=null&&$scope.proposal.appliInsuredDto.identifyNumber!=""&&$scope.proposal.appliInsuredDto.identifyNumber!=undefined){
                    $rootScope.zhenghao=true;
                }
                if($scope.proposal.appliInsuredDto.insuredName!=null&&$scope.proposal.appliInsuredDto.insuredName!=""&&$scope.proposal.appliInsuredDto.insuredName!=undefined){
                    $rootScope.keming=true;
                }
                if($scope.proposal.appliInsuredDto.mobile!=null&&$scope.proposal.appliInsuredDto.mobile!=""&&$scope.proposal.appliInsuredDto.mobile!=undefined){
                    $rootScope.yidian=true;
                }
                if($scope.proposal.appliInsuredDto.insuredAddress!=null&&$scope.proposal.appliInsuredDto.insuredAddress!=""&&$scope.proposal.appliInsuredDto.insuredAddress!=undefined){
                    $rootScope.kedi=true;
                }
                if($scope.proposal.appliInsuredDto.phoneNumber!=null&&$scope.proposal.appliInsuredDto.phoneNumber!=""&&$scope.proposal.appliInsuredDto.phoneNumber!=undefined){
                    $rootScope.gudian=true;
                }
                if($scope.proposal.appliInsuredDto.bank!=null&&$scope.proposal.appliInsuredDto.bank!=""&&$scope.proposal.appliInsuredDto.bank!=undefined){
                    $rootScope.kaihu=true;
                }
                if($scope.proposal.appliInsuredDto.account!=null&&$scope.proposal.appliInsuredDto.account!=""&&$scope.proposal.appliInsuredDto.account!=undefined){
                    $rootScope.yinzhang=true;
                }
                if($scope.proposal.appliInsuredDto.email!=""&&$scope.proposal.appliInsuredDto.email!=null&&$scope.proposal.appliInsuredDto.email!=undefined){
                    $rootScope.dianyou=true;
                }
                //被保险人清单信息带入不可修改

                if($scope.proposal.insuredDto.insuredType!=null&&$scope.proposal.insuredDto.insuredType!=""&&$scope.proposal.insuredDto.insuredType!=undefined){
                    $rootScope.kelei1=true;
                }
                if($scope.proposal.insuredDto.identifyType!=null&&$scope.proposal.insuredDto.identifyType!=""&&$scope.proposal.insuredDto.identifyType!=undefined){
                    $rootScope.zhenglei1=true;
                }
                if($scope.proposal.insuredDto.identifyNumber!=null&&$scope.proposal.insuredDto.identifyNumber!=""&&$scope.proposal.insuredDto.identifyNumber!=undefined){
                    $rootScope.zhenghao1=true;
                }
                if($scope.proposal.insuredDto.insuredName!=null&&$scope.proposal.insuredDto.insuredName!=""&&$scope.proposal.insuredDto.insuredName!=undefined){
                    $rootScope.keming1=true;
                }
                if($scope.proposal.insuredDto.mobile!=null&&$scope.proposal.insuredDto.mobile!=""&&$scope.proposal.insuredDto.mobile!=undefined){
                    $rootScope.yidian1=true;
                }
                if($scope.proposal.insuredDto.insuredAddress!=null&&$scope.proposal.insuredDto.insuredAddress!=""&&$scope.proposal.insuredDto.insuredAddress!=undefined){
                    $rootScope.kedi1=true;
                }
                if($scope.proposal.insuredDto.phoneNumber!=null&&$scope.proposal.insuredDto.phoneNumber!=""&&$scope.proposal.insuredDto.phoneNumber!=undefined){
                    $rootScope.gudian1=true;
                }
                if($scope.proposal.insuredDto.bank!=null&&$scope.proposal.insuredDto.bank!=""&&$scope.proposal.insuredDto.bank!=undefined){
                    $rootScope.kaihu1=true;
                }
                if($scope.proposal.insuredDto.account!=null&&$scope.proposal.insuredDto.account!=""&&$scope.proposal.insuredDto.account!=undefined){
                    $rootScope.yinzhang1=true;
                }
                if($scope.proposal.insuredDto.email!=""&&$scope.proposal.insuredDto.email!=null&&$scope.proposal.insuredDto.email!=undefined){
                    $rootScope.dianyou1=true;
                }
            }
            var tishi;
            $scope.hint=function($event,hints){
                if(hints=='1'&&hints)
                {
                    tishi='保单号格式不正确，请修改';
                    $scope.proposal.prpTmainDto.proposalNo=''
                }
                else if(hints=='COPY_PROPOSAL'){
                    tishi='请输入投保单号';
                }else {
                    tishi='请输入保单号';
                }
                layer.open({
                    /*offset: ['35%', '40%'],*/
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    scrollbar: false,
                    title: '温馨提示',
                    content: tishi,
                    btn: ['确定'],
                    btn1: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });
            }
            //关闭按钮
            $scope.closeRelationListLayer = function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
                $scope.relationListQueryLayer = false;
                $scope.proposal.insureMainListDto.insureListCode = '';
                $scope.requestInsuranceQueryDto.beginTime="";
                $scope.requestInsuranceQueryDto.endTime="";
                $scope.proposal.prpTmainDto.businessProvince = '';
                $scope.proposal.prpTmainDto.businessTown = '';
                $scope.proposal.prpTmainDto.businessCountry = '';
                $scope.proposal.prpTmainDto.businessAreaName = '';
                $scope.proposal.prpTmainDto.businessArea = '';
                $scope.proposal.prpTaddressDto.addressName = '';
                $scope.proposal.appliInsuredDto.insuredType = null;
                $scope.proposal.appliInsuredDto.identifyType = null;
                $scope.proposal.appliInsuredDto.identifyNumber = null;
                $scope.proposal.appliInsuredDto.insuredName = null
                $scope.proposal.appliInsuredDto.insuredCode = null;
                $scope.proposal.appliInsuredDto.mobile = null;
            }
            //显示隐藏标的清单列表
            $scope.markedList=false;
            //标的清单显示
            var indexPage4=function () {
                $scope.paginationConfmm3 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        $scope.showMarkedList($scope.queryMarkedList,$scope.queryMarkedListIndex)
                    }
                }
            };
            indexPage4();
            $scope.showMarkedList=function(queryMarkedList,index){
                var itemListCodes=[];
                itemListCodes.push($scope.queryMarkedList[index].itemListCode);
                $scope.queryMarkedListIndex=index;//保留当前的下标供分页使用
                $scope.markedListItemList = itemListCodes;
                $$finder.find('queryGisFarmerItemInfoDetail',{
                        insureListCode:$scope.proposal.insureMainListDto.insureListCode,
                        serialNo:$scope.proposal.insureMainListDto.serialNo,
                        itemListCodes:itemListCodes,
                        pageNo : $scope.paginationConfmm3.currentPage,
                        pageSize : $scope.paginationConfmm3.itemsPerPage
                    },
                    {
                        success:function (data) {
                            if(!data.content){
                                layer.open({
                                    /*offset: ['40%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "无标的预览！",
                                    scrollbar: false,
                                    btn: ['确定'],
                                    btn1: function(index, layero){
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }else{
                                $scope.insureCountTitle = '投保数量';
                                var itemCode = $scope.queryMarkedList[index].itemCode;
                                if (itemCode === 'ZZ200' || itemCode === 'ZZ100') {
                                    $scope.insureCountTitle = '投保人数';
                                }
                                $scope.famerListItem = data.content.content[0];
                                $scope.totalItems = data.content.totalCount;
                                //查询结果条数
                                $scope.paginationConfmm3.totalItems = $scope.totalItems;
                                $scope.markedList = true;
                                $("html,body").css({overflow: "hidden"});//隐藏滚动条
                            }
                        },
                        error:function () {

                        }
                    })
            }
            $scope.fieldList=false;
            $scope.herdfieldList=false;
            //点击投保数量
            $scope.showFieldList = function (famerListItem,index) {
                $scope.fCodePage=$scope.famerListItem[index].fCode;
                $scope.itemCode=$scope.famerListItem[index].itemCode;
                $scope.famerListItemPage=famerListItem;
                $$finder.find('queryGisFieldList',{
                    insureListCode:$scope.proposal.insureMainListDto.insureListCode,
                    serialNo:$scope.proposal.insureMainListDto.serialNo,
                    fCode:$scope.famerListItem[index].fCode,
                    pageNo : $scope.paginationConfmmField.currentPage,
                    pageSize : $scope.paginationConfmmField.itemsPerPage,
                    itemCode : $scope.itemCode
                },{
                    success: function (data) {
                        if (data.content.content.length > 0) {
                            var resultDto = data.content.content[0];
                            $scope.detailsType = resultDto.detailsType;
                            $scope.resultListDetails = resultDto.content;
                            var showDetails = true;
                            if ($scope.detailsType) {
                                if ($scope.detailsType === 'other') {
                                    $scope.detailsTitle = '田块信息';
                                } else if ($scope.detailsType === 'earLabel') {
                                    $scope.detailsTitle = '耳标号清单';
                                } else if ($scope.detailsType === 'joinInsured') {
                                    $scope.detailsTitle = '连带被保险人信息';
                                } else if ($scope.detailsType === 'load') {
                                    $scope.detailsTitle = '小额贷款责任险信息';
                                } else if ($scope.detailsType === 'showMap') {
                                    showDetails = false;
                                }
                            }
                            if (showDetails){
                                $scope.totalItems = data.content.totalCount;
                                //查询结果条数
                                $scope.paginationConfmmField.totalItems = $scope.totalItems;
                                angular.forEach($scope.resultListDetails, function (data, index) {
                                    $scope.fieldList = true;
                                    selected_itemName = data.itemName = famerListItem.itemName;
                                    selected_fName = data.fName = famerListItem.fName;
                                })
                            } else {
                                var insureListCode = $scope.proposal.insureMainListDto.insureListCode;
                                if (insureListCode && insureListCode !== '' && insureListCode !== null) {
                                    var path = $rootScope.frontEnd.prpallGisUrl+"/CallPage/ListShow/Index?listcode=" + insureListCode;
                                    window.open(path);
                                }
                            }
                        } else {
                            console.log("没有查询到信息");
                        }
                    },
                    error: function (e) {
                    }
                });
            }

            //点击投保数量
            $scope.markListDownload = function (famerListItem) {
                var content;
                $$finder.find('markListDownload',{
                    insureListCode:$scope.proposal.insureMainListDto.insureListCode,
                    serialNo:$scope.proposal.insureMainListDto.serialNo,
                    itemListCodes:$scope.markedListItemList
                },{
                    success: function (data) {
                        content = '您已成功下载标的清单编号为'+$scope.proposal.insureMainListDto.insureListCode+'的标的清单列表！';
                        layer.open({
                            /*offset: ['33%', '30%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: content,
                            scrollbar: false,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        window.open(data.content.message);
                    },
                    error: function (e) {
                        content = '您下载标的清单编号为'+$scope.proposal.insureMainListDto.insureListCode+'的标的清单列表操作失败，请重新下载！';
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
                });

            }


            var selected_itemName = "";
            var selected_fName = "";

            var initFieldPage=function(famerListItem){
                $scope.paginationConfmmField = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 20,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if ($scope.paginationConfmmField.totalItems == 0) {//如果没有进行查询，不执行
                            return;
                        } else {
                            $$finder.find('queryGisFieldList',{
                                insureListCode:$scope.proposal.insureMainListDto.insureListCode,
                                serialNo:$scope.proposal.insureMainListDto.serialNo,
                                fCode:$scope.fCodePage,
                                pageNo : $scope.paginationConfmmField.currentPage,
                                pageSize : $scope.paginationConfmmField.itemsPerPage,
                                itemCode : $scope.itemCode
                            },{
                                success: function (data) {
                                    if (data.content.content.length > 0) {
                                        var resultDto = data.content.content[0];
                                        $scope.detailsType = resultDto.detailsType;
                                        $scope.resultListDetails = resultDto.content;
                                        var showDetails = true;
                                        if ($scope.detailsType) {
                                            if ($scope.detailsType === 'other') {
                                                $scope.detailsTitle = '田块信息';
                                            } else if ($scope.detailsType === 'earLabel') {
                                                $scope.detailsTitle = '耳标号清单';
                                            } else if ($scope.detailsType === 'joinInsured') {
                                                $scope.detailsTitle = '连带被保险人信息';
                                            } else if ($scope.detailsType === 'load') {
                                                $scope.detailsTitle = '小额贷款责任险信息';
                                            } else if ($scope.detailsType === 'showMap') {
                                                showDetails = false;
                                            }
                                        }
                                        if (showDetails){
                                            $scope.totalItems = data.content.totalCount;
                                            //查询结果条数
                                            $scope.paginationConfmmField.totalItems = $scope.totalItems;
                                            angular.forEach($scope.resultListDetails, function (data, index) {
                                                $scope.fieldList = true;
                                                data.itemName = selected_itemName;
                                                data.fName = selected_fName;
                                            })
                                        } else {
                                            var insureListCode = $scope.proposal.insureMainListDto.insureListCode;
                                            if (insureListCode && insureListCode !== '' && insureListCode !== null) {
                                                var path = $rootScope.frontEnd.prpallGisUrl+"/CallPage/ListShow/Index?listcode=" + insureListCode;
                                                window.open(path);
                                            }
                                        }
                                    } else {
                                        console.log("没有查询到信息");
                                    }
                                },
                                error: function (e) {
                                }
                            });
                        }
                    }
                }
            }
            initFieldPage();
            $scope.modelCompareDate=function(startDate,endDate){
                var content;
                if (startDate==""||!startDate) {
                    content = '请录入有效起期';
                    $scope.prpMmodelMainDto.endDate = "";
                    layer.open({
                        /*offset: ['40%', '40%'],*/
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
                }else {
                    var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                    var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                    if (startDate > endDate) {
                        var content;
                        content = '有效止期要大于有效起期';
                        layer.open({
                            /*offset: ['40%', '40%'],*/
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
                        $scope.prpMmodelMainDto.endDate = "";
                    }
                }
            }

            //去掉请输入模板号的红框
            $scope.checkQuery = function(){
                $scope.proposal.checkModelCode="";
                //$scope.proposal.modelCode="";
            }
            //点击查询的校验
            $scope.checkFind = function(str){
                //模板号码
                var modelCodeReg=/^TB[0-9]+$/;
                var modelFlag=modelCodeReg.test(str);
                var content1="";
                if (!str){
                    content1="请输入正确的模板号！";
                    $scope.content1(content1);
                }else if(modelFlag==false){
                    content1="模版号码格式错误，请修改！";
                    $scope.content1(content1);
                }else{
                    $$finder.find('queryPrpMmodelMainByHyperLink',{
                        "modelCode":$scope.proposal.modelCode,//模板号码
                        "userCode":$rootScope.user.userCode,
                        "comCode":$rootScope.user.loginComCode
                    },{
                        success: function (data) {
                            if (data.content.map.message!=""){
                                content1="输入的模板号不存在，请输入正确的模板号";
                                $scope.content1(content1);
                            }else{
                                $rootScope.treecheck=data.content.prpMmodelComDtoList;
                                //查询机构树
                                $$finder.find('getCompanyTree', {
                                    "modelCode": $scope.proposal.modelCode,
                                    "userCode":$rootScope.user.userCode,
                                    "comCode":$rootScope.user.loginComCode
                                }, {
                                    success: function (data1) {
                                        $rootScope.modelComDtoList = data1.content.companyListDtoList;//适用机构
                                    },
                                    error: function () {

                                    }
                                })

                                $scope.proposal.prpTitemKindDtoList = data.content.prpModelItemKindDtoList;//主险附加险(不完全)
                                $scope.proposal.prpMmodelComDtoList=data.content.prpMmodelComDtoList;
                                        $scope.versionNoNone = data.content.prpModelMainSubDto.versionNo;//条款
                                        if(!$scope.proposal.prpTmainDto.versionNo){
                                                }else {
                                            angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                                                $scope.proposal.prpTitemKindDtoList[index].kindName = '';
                                                $scope.proposal.prpTitemKindDtoList[index].kindCode = '';
                                                $scope.proposal.prpTitemKindDtoList[index].itemDetailName = '';
                                                $scope.proposal.prpTitemKindDtoList[index].itemCode = '';
                                                $scope.proposal.prpTitemKindDtoList[index].model = '';
                                                $scope.proposal.prpTitemKindDtoList[index].replyNo = '';

                                            })
                                            $scope.versionNo = $scope.proposal.prpTmainDto.versionNo;
                                        }
                                        //data.content.prpModelMainSubDto.versionNo="";
                                        $scope.comCode=data.content.prpModelMainSubDto.comCode;
                                        //归属机构中文名称
                                        if($scope.proposal.prpTmainDto.comCName){
                                            $scope.proposal.comCNameCopy = $scope.proposal.prpTmainDto.comCName;
                                        }
                                        //归属区域:省
                                        if($scope.proposal.prpTmainDto.businessProvinceName){
                                            $scope.proposal.businessProvinceNameCopy=$scope.proposal.prpTmainDto.businessProvinceName;
                                        }
                                        //归属区域:市
                                        if($scope.proposal.prpTmainDto.businessCityName){
                                            $scope.proposal.businessCityNameCopy = $scope.proposal.prpTmainDto.businessCityName;
                                        }
                                        //归属区域:区(县)
                                        if($scope.proposal.prpTmainDto.businessCountyName){
                                            $scope.proposal.businessCountyNameCopy = $scope.proposal.prpTmainDto.businessCountyName;
                                        }
                                        //归属区域:乡/镇
                                        if($scope.proposal.prpTmainDto.businessTownName){
                                            $scope.proposal.businessTownNameCopy = $scope.proposal.prpTmainDto.businessTownName;
                                        }
                                        //归属区域:村
                                        if($scope.proposal.prpTmainDto.businessAreaName){
                                            $scope.proposal.businessTownNameCopy = $scope.proposal.prpTmainDto.businessTownName;
                                        }
                                        //险类
                                        if($scope.proposal.prpTmainDto.classCode){
                                            $scope.proposal.classCodeCopy = $scope.proposal.prpTmainDto.classCode;
                                        }
                                        //险种
                                        if($scope.proposal.prpTmainDto.riskCode){
                                            $scope.proposal.riskCodeCopy = $scope.proposal.prpTmainDto.riskCode;
                                        }
                                        //有效起期
                                        if(!$scope.prpMmodelMainDto.startDate){
                                           $scope.prpMmodelMainDto.startDate = data.content.prpMmodelMainDto.startDate;
                                        }
                                        //有效止期
                                        if(!$scope.prpMmodelMainDto.endDate){
                                           $scope.prpMmodelMainDto.endDate = data.content.prpMmodelMainDto.endDate;
                                        }
                                        //模板名称
                                        if(!$scope.prpMmodelMainDto.modelName){
                                           $scope.prpMmodelMainDto.modelName = data.content.prpMmodelMainDto.modelName;
                                        }
                                        $scope.proposal.prpTmainDto = data.content.prpModelMainSubDto;//基本信息（不完全）
                                        //险类(如果险类不为空，先把险类赋值给一个字段，如果这个字段不为空，说明我复制模板之前选择了险类，在prpModelMainSubDto给prpTmainDto赋值晚之后，把这个字段的值赋值（就是之前选的模板）给险类)
                                        if($scope.proposal.classCodeCopy){
                                            $scope.proposal.prpTmainDto.classCode = $scope.proposal.classCodeCopy;
                                        }else{
                                            $scope.proposal.prpTmainDto.className = data.content.className.substring(2);//险类
                                        }
                                        //险种
                                        if($scope.proposal.riskCodeCopy){
                                            $scope.proposal.prpTmainDto.riskCode = $scope.proposal.riskCodeCopy;
                                        }else{
                                            $scope.proposal.prpTmainDto.riskCodeName = data.content.riskCname.substring(5);//险种
                                        }
                                        $scope.getItemsss();
                                        $scope.TKKwords= $scope.versionNoNone;
                                        if(!$scope.prpMmodelMainDto.modelCode){
                                            //生成模板号
                                            $$finder.find('creatProposal', {
                                                "tableName": "prpmmodelmain",//表名
                                                "iYear": new Date().getFullYear(),//当前年份
                                                "riskCode": $scope.proposal.prpTmainDto.riskCode,
                                                "iComCode": $rootScope.user.loginComCode,
                                                "userCode": $rootScope.user.userCode
                                            }, {
                                                success: function (data) {
                                                    $scope.prpMmodelMainDto.modelCode = data.content.billNo;
                                                },
                                                error: function (e) {
                                                    options.error(e);
                                                }
                                            });

                                        }
                                        if($scope.proposal.comCNameCopy){
                                            $scope.proposal.prpTmainDto.comCName=$scope.proposal.comCNameCopy ;
                                        }
                                        //归属区域:省
                                        if($scope.proposal.businessProvinceNameCopy){
                                            $scope.proposal.prpTmainDto.businessProvinceName = $scope.proposal.businessProvinceNameCopy;
                                        }
                                        //归属区域:市
                                        if($scope.proposal.businessCityNameCopy){
                                            $scope.proposal.prpTmainDto.businessCityName = $scope.proposal.businessCityNameCopy;
                                        }
                                        //归属区域:区(县)
                                        if($scope.proposal.businessCountyNameCopy){
                                            $scope.proposal.prpTmainDto.businessCountyName = $scope.proposal.businessCountyNameCopy;
                                        }
                                        //归属区域:乡/镇
                                        if($scope.proposal.prpTmainDto.businessTownNameCopy){
                                            $scope.proposal.prpTmainDto.businessTownName  = $scope.proposal.prpTmainDto.businessTownNameCopy;
                                        }
                                        //归属区域:村
                                        if($scope.proposal.businessTownNameCopy){
                                            $scope.proposal.prpTmainDto.businessTownName = $scope.proposal.businessTownNameCopy;
                                        }
                                        $scope.proposal.prpTmainDto.comCode=$scope.comCode;
                                        if($scope.versionNoNone){
                                            $scope.proposal.prpTmainDto.versionNo=$scope.versionNoNone;
                                        }
                                        if($scope.versionNo){
                                            $scope.proposal.prpTmainDto.versionNo=$scope.versionNo;
                                        }
                                        data.content.prpModelAddressSubDto=data.content.prpModelAddressSubDto||{};
                                        data.content.prpModelCoinsDetailDtoList=data.content.prpModelCoinsDetailDtoList||{};
                                        data.content.prpModelCoinsSubDtoList=data.content.prpModelCoinsSubDtoList||{};
                                        data.content.prpModelEngageSubDtoList=data.content.prpModelEngageSubDtoList||{};
                                        data.content.prpModelItemKindAgriDtoList=data.content.prpModelItemKindAgriDtoList||{};
                                        data.content.prpModelItemKindDtoList= data.content.prpModelItemKindDtoList||{};
                                        data.content.prpModelPlanCoinsDtoList=data.content.prpModelPlanCoinsDtoList||{};
                                        data.content.prpModelPlanSubDtoList=data.content.prpModelPlanSubDtoList||{};
                                        data.content.prpModelSubsidyDtoList=data.content.prpModelSubsidyDtoList||{};
                                        data.content.queryModelPrpTengageDtoList=data.content.queryModelPrpTengageDtoList||{}
                                        data.content.prpModelMainAgriSubDto=data.content.prpModelMainAgriSubDto||{};
                                        data.content.prpModelFeeSubDto=data.content.prpModelFeeSubDto||{};
                                        data.content.appliInsuredDto=data.content.appliInsuredDto||{};
                                        data.content.insuredDto=data.content.insuredDto||{};
                                        $scope.proposal.prpDcustomerTaxPayInfoDto=$scope.proposal.prpDcustomerTaxPayInfoDto||{};
                                        ////投保人和被保人信息
                                        //$scope.proposal.appliInsuredDto = data.content.appliInsuredDto||{};
                                        //$scope.proposal.insuredDto = data.content.insuredDto||{};
                                        //$scope.proposal.prpDcustomerTaxPayInfoDto=data.content.prpModelCustomerTaxPayInfoSubDto

                                        $scope.prpMmodelMainDto = $scope.prpMmodelMainDto || {};
                                        $scope.proposal.prpDcustomerTaxPayInfoDto=$scope.proposal.prpDcustomerTaxPayInfoDto||{};
                                        data.content.prpModelCustomerTaxPayInfoSubDto=data.content.prpModelCustomerTaxPayInfoSubDto||{};
                                        //$rootScope.getModelCode = data.content.prpMmodelMainDto.modelCode;
                                        $scope.proposal.prpTmainDto.contractType = data.content.prpModelMainSubDto.argueSolution;//合同争议解决方式
                                        //$scope.proposal.prpTmainDto.comCode = data.content.prpModelMainSubDto.comCode,//归属机构

                                        $scope.proposal.prpTmainDto.handler1Code=data.content.prpModelMainSubDto.handler1Code,//归属业务人员
                                        $scope.handler1Code=$scope.proposal.prpTmainDto.handler1Code;
                                        $scope.proposal.prpTmainDto.businessCategory = data.content.prpModelMainSubDto.groupFlag;//业务大类
                                        //$scope.proposal.prpTaddressDto.addressName = data.content.prpModelAddressSubDto.addressName;种植地点，已经选择清单就不要赋值
                                        $scope.proposal.prpTitemKindAgriDtoList = data.content.prpModelItemKindAgriDtoList;
                                        $scope.proposal.prpTmainAgriDto = data.content.prpModelMainAgriSubDto;
                                        $scope.proposal.prpTmainAgriDto.raiseDate=$filter('date')(data.content.prpModelMainAgriSubDto.raiseDate, 'yyyy-MM-dd');
                                        $scope.proposal.prpMmodelComDtoList = data.content.prpMmodelComDtoList
                                        $scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;//缴费计划（不完全）
                                        $scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;//补贴信息
                                        $scope.proposal.prpTfeeDto = data.content.prpModelFeeSubDto;//币别信息
                                        $scope.proposal.prpTfeeDto.currency2 = data.content.prpModelMainSubDto.currency;//汇总币别
                                        $scope.proposal.prpDcustomerTaxPayInfoDto = data.content.prpModelCustomerTaxPayInfoSubDto;
                                        $scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;
                                        $scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;
                                        $scope.currency2Name = data.content.currency2Name;
                                        $rootScope.totalAmount = data.content.prpModelMainSubDto.sumAmount//总保额
                                        $rootScope.totalPay = data.content.prpModelMainSubDto.sumPremium;//总保费
                                        $scope.proposal.prpTmainDto.updaterName = data.content.updaterName;//最近修改人
                                        $scope.proposal.prpTmainDto.operatorName = data.content.operatorName;//操作员名称
                                        $scope.proposal.prpTmainDto.reMark = data.content.prpModelMainSubDto.remark//*出单员意见
                                        $scope.proposal.prpTmainDto.comCode = data.content.prpModelMainSubDto.comCode,//归属机构
                                        $scope.proposal.prpTmainDto.class = $scope.proposal.prpTmainDto.classCode;
                                        //$scope.proposal.prpTmainDto.classCode = data.content.className;//险类
                                        $scope.proposal.insureListCode1= data.content.insureListCode;
                                        $scope.proposal.prpTcoinsDtoList = data.content.prpModelCoinsSubDtoList;
                                        $scope.proposal.prpTcoinsDetailDtoList = data.content.prpModelCoinsDetailDtoList;
                                        $scope.proposal.prpTplanCoinsDtoList = data.content.prpModelPlanCoinsDtoList;
                                        //$scope.proposal.insuredDto.BusinessSort = data.content.insuredDto.businessSort,//公司性质
                                        //$scope.proposal.appliInsuredDto.BusinessSort=data.content.appliInsuredDto.businessSort//公司性质
                                        //$scope.proposal.prpTmainAgriDto.relationListNo=data.content.prpModelMainAgriSubDto.relationListNo;//我方清单号
                                        $scope.proposal.prpTengageDtoCopy=$scope.proposal.prpTengageDtoCopy||[];
                                        angular.forEach(data.content.queryModelPrpTengageDtoList, function (data, index) {
                                            var obj = {
                                                clauseCode: data.clauseCode,//特约代码
                                                clauses: data.clauseName,//特约名称
                                                clausesContent: data.clausesContent//特约内容
                                            };
                                            $scope.proposal.prpTengageDtoCopy.push(obj)
                                        });
                                        angular.forEach(data.content.prpModelCoinsSubDtoList, function (data, index) {
                                            data.mainProposalNo=data.mainPolicyNo;//主保单号码
                                            data.coinsSumAmount=$scope.proposal.prpTcoinsDetailDtoList[index].coinsAmount//共保保额
                                            data.coinsSumPremium=$scope.proposal.prpTcoinsDetailDtoList[index].coinsPremium//共保保费
                                            data.policyNo="1";
                                        });
                                        //共保方补贴信息
                                        angular.forEach(data.content.prpModelPlanCoinsDtoList, function (data, index){
                                            data.realPay=data.planFee-data.delinquentFee;//实缴金额
                                            if (data.payReason=='03'){
                                                data.reason='中央财政';//缴费原因
                                            }
                                            if (data.payReason=='04'){
                                                data.reason='省级财政';//缴费原因
                                            }
                                            if (data.payReason=='07'){
                                                data.reason='县(区)财政';//缴费原因
                                            }
                                            if (data.payReason=='06'){
                                                data.reason='其他来源';//缴费原因
                                            }
                                            if (data.payReason=='05'){
                                                data.reason='地市财政';//缴费原因
                                            }
                                            if (data.payReason=='GP81'){
                                                data.reason='自缴保费';//缴费原因
                                            }
                                            if ($scope.proposal.prpTcoinsDetailDtoList.length>=3){
                                                data.coinsName=$scope.proposal.prpTcoinsDetailDtoList[2].coinsName;
                                            }

                                        });
                                        //绝对免赔率
                                        $scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
                                        angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
                                            if (data.clauseCode == 'TX001') {
                                                $scope.proposal.engageQueryClause.absuDedu= $scope.proposal.prpTengageDtoCopy.splice(index, 1)[0].clausesContent;

                                            }
                                        });
                                    //投保人和被保人信息

                                    $scope.proposal.appliInsuredDto = data.content.appliInsuredDto||{};
                                    $scope.proposal.insuredDto = data.content.insuredDto||{};
                                    //证件类型初始化
                                    $scope.getIdentity($scope.proposal.appliInsuredDto.insuredType,$scope.proposal.appliInsuredDto.identifyType);
                                    $scope.proposal.prpDcustomerTaxPayInfoDto=data.content.prpModelCustomerTaxPayInfoSubDto
                                    $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = data.content.insuredDto.postCode;//邮政编码
                                    $scope.proposal.appliInsuredDto.certificateName = data.content.appliInsuredDto.certificatEName;//客户代码
                                    $scope.proposal.insuredDto.certificateName = data.content.insuredDto.certificatEName;//客户代码
                                    $scope.proposal.appliInsuredDto.isCareClaim = data.content.appliInsuredDto.iscareClaim,//客户是否关注审计、理赔、退保信息
                                    $scope.proposal.insuredDto.isCareClaim = data.content.insuredDto.iscareClaim//客户是否关注审计、理赔、退保信息
                                        //客户信息中被保险人中的  同投保人选择按钮
                                        data.content.appliInsuredDto.insuredCode == data.content.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                                        //发票购货方信息  选择同投保人、被投保人
                                        if (data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1" ){
                                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                                        }else if(data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "2" ){
                                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
                                        }else {
                                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                                        }
                                        //data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1" ? $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1" : $scope.tdInsuredIdentityInput = "";
                                        angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                                            if (data.payReason == 'R10') {
                                                data.payReasonName = '签单收保费'
                                            }
                                            if (data.payReason == 'R20') {
                                                data.payReasonName = '分期收保费'
                                            }
                                            if (data.payReason == 'RS3') {
                                                data.payReasonName = '中央财政'
                                            }
                                            if (data.payReason == 'RS4') {
                                                data.payReasonName = '省级财政'
                                            }
                                            if (data.payReason == 'RS7') {
                                                data.payReasonName = '县(区)财政'
                                            }
                                            if (data.payReason == 'RS6') {
                                                data.payReasonName = '其他来源'
                                            }
                                            if (data.payReason == 'RS5') {
                                                data.payReasonName = '地市财政'
                                            }
                                            data.payreFee = data.planFee - data.delinquentFee
                                            if (!isNaN(data.planDate)) {
                                                data.planDate = $filter('date')(data.planDate, 'yyyy-MM-dd');
                                                data.planStartDate = $filter('date')(data.planStartDate, 'yyyy-MM-dd');
                                            }

                                        })
                                        //主险附加险
                                        angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                                            data.shortRate=round(data.shortRate,2);
                                            data.amount=round(data.amount,2);
                                            data.premium=round(data.premium,2)
                                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMaintitle='单位保险产量'
                                            $scope.proposal.prpTitemKindDtoList[index].agriUnitCostMaintitle = '单位生产成本'
                                            $scope.proposal.prpTitemKindDtoList[index].radioType = data.flag == 1 ? 'Y' : 'N';
                                            $scope.proposal.prpTitemKindDtoList[index].premiumCalMethod = data.premiumcalMethod//保费计算方式


                                        })

                                        //茬次信息赋值
                                        var prpTitemKindAgriDtoListCopy = []
                                        var prpModelItemKindAgriDtoList1=[]
                                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                                            angular.forEach(data.content.prpModelItemKindAgriDtoList, function (_data) {
                                                if ((_data.distributingRate != null && _data.distributingRate != undefined)
                                                    && (_data.timesAmount != null && _data.timesAmount != undefined)
                                                    && (_data.stratDate != null && _data.stratDate != undefined)
                                                    && (_data.endDate != null && _data.endDate != undefined)
                                                    && _data.times>0) {
                                                    _data.stratDate = "";
                                                    _data.endDate = "";
                                                    prpTitemKindAgriDtoListCopy.push(_data);
                                                }else{
                                                    prpModelItemKindAgriDtoList1.push(_data)
                                                }
                                            });
                                            $scope.proposal.prpTitemKindAgriDtoListCopy = prpTitemKindAgriDtoListCopy;
                                            data.content.prpModelItemKindAgriDtoList=prpModelItemKindAgriDtoList1;
                                        }

                                        angular.forEach(data.content.prpModelItemKindAgriDtoList, function (data, index) {
                                            $scope.proposal.prpTitemKindDtoList[index].agriUnitCostMain = data.unitCost;//单位生产成本
                                            $scope.proposal.prpTitemKindDtoList[index].unitCostName = '元';
                                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMain = data.unitCost;//单位保险产量
                                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMainName="公斤";
                                            $scope.proposal.prpTitemKindDtoList[index].unitAmount = data.unitAmount
                                            $scope.proposal.prpTitemKindDtoList[index].agriGrossQuantityMain = data.grossQuantity// 投保面积
                                            $scope.proposal.prpTitemKindDtoList[index].agriTimesAmount = data.timesAmount;
                                        })


                                        //政策性
                                        if (data.content.prpModelMainSubDto.businessType1 == '00') {
                                            $scope.proposal.prpTmainDto.businessType1Name = "商业性"
                                        } else if (data.content.prpModelMainSubDto.businessType1 == '01') {
                                            $scope.proposal.prpTmainDto.businessType1Name = "中央政策性"
                                        } else if (data.content.prpModelMainSubDto.businessType1 == '02') {
                                            $scope.proposal.prpTmainDto.businessType1Name = "地方政策性"
                                        }
                                        //
                                        $$finder.find('queryByRiskCode',{
                                            riskCode:data.content.prpModelMainSubDto.riskCode,//险种
                                        }, {
                                            success: function (data) {
                                                $scope.rateDivisor=data.content;
                                                $scope.getrateDivisor( $scope.rateDivisor)
                                            },
                                            error: function (e) {
                                                options.error(e);
                                            }
                                        });
                                        //业务大类
                                        $scope.parameterConvert.businessCategoryInit();

                                         //$scope.getPlantingInfo(data.content.gisInsureListCode,'input');
                                        if (!$scope.proposal.insureMainListDto.insureListCode){
                                            $scope.proposal.insureMainListDto.insureListCode=data.content.gisInsureListCode,//清单编号
                                            $scope.proposal.prpTmainAgriDto.relationListNoRemark=data.content.remark,//清单备注
                                            $scope.proposal.insureMainListDto.listTypeFlag=data.content.listTypeFlag,//清单类型
                                            $scope.proposal.prpTmainDto.businessProvinceName=data.content.fProvinceName;//归属区域:省
                                            $scope.proposal.prpTmainDto.businessCityName=data.content.fCityName;//归属区域:市
                                            $scope.proposal.prpTmainDto.businessCountyName=data.content.fCountyName;//归属区域:区(县)
                                            $scope.proposal.prpTmainDto.businessTownName=data.content.fTownName;//归属区域:乡/镇
                                            $scope.proposal.prpTmainDto.businessAreaName=data.content.fVillageName;//归属区域:村
                                            $scope.proposal.insureMainListDto.serialNo=data.content.serialNo;//清单序列号
                                            $scope.proposal.prpTaddressDto.addressName = data.content.prpModelAddressSubDto.addressName;//种植地点
                                            if (data.content.listTypeFlag=='D'){
                                                $scope.proposal.insureMainListDto.listTypeFlag='大户';
                                            }
                                            if (data.content.listTypeFlag=='S'){
                                                $scope.proposal.insureMainListDto.listTypeFlag='散户';
                                            }
                                            $$finder.find('queryMarkedList', {
                                                "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                                                "serialNo":$scope.proposal.insureMainListDto.serialNo//标的清单序号
                                            }, {
                                                success: function (data) {
                                                    $scope.queryMarkedList=data.content
                                                },
                                                error: function (e) {
                                                    options.error(e);
                                                }
                                            });
                                            //$scope.getPlantingInfo(proposal.insureMainListDto.insureListCode,$scope.proposal.insureMainListDto.serialNo);
                                            //根据清单带出客户信息
                                        }else{
                                            angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                                                $scope.proposal.prpTitemKindDtoList[index].kindName = '';
                                                $scope.proposal.prpTitemKindDtoList[index].kindCode='';
                                                $scope.proposal.prpTitemKindDtoList[index].itemDetailName='';
                                                $scope.proposal.prpTitemKindDtoList[index].itemCode='';
                                                $scope.proposal.prpTitemKindDtoList[index].model='';
                                                $scope.proposal.prpTitemKindDtoList[index].replyNo='';

                                            })
                                        }
                                        //归属机构
                                        $scope.getComCodeList()
                                        //归属机构下拉初始化传参
                                        var handCodeData={
                                            "userCode": $scope.user.userCode,
                                            "userName": $scope.user.userName,
                                            "loginComCode":  $scope.user.loginComCode,
                                            "loginGradeCodes": "111",
                                            "tableName": "prpduser",
                                            "userCodeFields": "userCode",
                                            "comCodeFields": $scope.proposal.prpTmainDto.comCode,
                                            "riskCode": $scope.proposal.prpTmainDto.riskCode
                                        };
                                        // handCodeList归属业务员下拉列表
                                        $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                                            $scope.selectListData.handCodeList = data;
                                            $scope.proposal.prpTmainDto.handler1Code = $scope.handler1Code;
                                        });
                                        //投保方式
                                        $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, data.content.prpModelMainSubDto.policyType);//投保方式下拉初始化获取
                                        //共保不显示就粘这一段
                                        if ($scope.proposal.prpTmainDto.coinsFlag != '0') {
                                            $rootScope.PremiumShow = true;
                                            $rootScope.showCoins = true;
                                            $scope.proposal.otherAgentFeeShow = true;
                                            $rootScope.isHide = true;
                                        }



                            }

                        },
                        error: function (e) {
                        }
                    });
                }
            }
            //
            $scope.content1=function(content1){
                if(content1!=""){
                    layer.open({
                        /*offset: ['40%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content1,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }
            //标的清单隐藏
            $scope.closeMarkedList=function(){
                $scope.fieldList=false;
                $scope.markedList=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.closeFieldList= function () {
                $scope.fieldList=false;
            }
            $scope.closeHerdFieldList= function () {
                $scope.herdfieldList=false;
            }
            //选择模板带出模板信息
            $scope.getModelInfo = function(modelCode){
                $$finder.find('queryPrpMmodelMainByHyperLink', {
                    "modelCode": modelCode,
                    "userCode":$rootScope.user.userCode,
                    "comCode":$rootScope.user.loginComCode
                }, {
                    success: function (data) {
                        if(data.code=='0000'){
                            //查询机构树
                            $$finder.find('getCompanyTree', {
                                "modelCode": $scope.proposal.modelCode,
                                "userCode":$rootScope.user.userCode,
                                "comCode":$rootScope.user.loginComCode
                            }, {
                                success: function (data) {
                                    $rootScope.modelComDtoList = data.content.companyListDtoList;//适用机构
                                },
                                error: function () {

                                }
                            })
                        }

                        $scope.proposal.prpTitemKindDtoList = data.content.prpModelItemKindDtoList;//主险附加险(不完全)
                        if(!$scope.proposal.prpTmainDto.versionNo){
                            $scope.versionNoNone = data.content.prpModelMainSubDto.versionNo;//条款
                        }else{
                            angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                                $scope.proposal.prpTitemKindDtoList[index].kindName = '';
                                $scope.proposal.prpTitemKindDtoList[index].kindCode='';
                                $scope.proposal.prpTitemKindDtoList[index].itemDetailName='';
                                $scope.proposal.prpTitemKindDtoList[index].itemCode='';
                                $scope.proposal.prpTitemKindDtoList[index].model='';
                                $scope.proposal.prpTitemKindDtoList[index].replyNo='';

                            })
                            $scope.versionNo = $scope.proposal.prpTmainDto.versionNo;
                        }
                        data.content.prpModelMainSubDto.versionNo="";
                        $scope.comCode=$scope.proposal.prpTmainDto.comCode;
                        //归属机构中文名称
                        if($scope.proposal.prpTmainDto.comCName){
                            $scope.proposal.comCNameCopy = $scope.proposal.prpTmainDto.comCName;
                        }
                        //归属区域:省
                        if($scope.proposal.prpTmainDto.businessProvinceName){
                            $scope.proposal.businessProvinceNameCopy=$scope.proposal.prpTmainDto.businessProvinceName;
                        }
                        //归属区域:市
                        if($scope.proposal.prpTmainDto.businessCityName){
                            $scope.proposal.businessCityNameCopy = $scope.proposal.prpTmainDto.businessCityName;
                        }
                        //归属区域:区(县)
                        if($scope.proposal.prpTmainDto.businessCountyName){
                            $scope.proposal.businessCountyNameCopy = $scope.proposal.prpTmainDto.businessCountyName;
                        }
                        //归属区域:乡/镇
                        if($scope.proposal.prpTmainDto.businessTownName){
                            $scope.proposal.businessTownNameCopy = $scope.proposal.prpTmainDto.businessTownName;
                        }
                        //归属区域:村
                        if($scope.proposal.prpTmainDto.businessAreaName){
                            $scope.proposal.businessTownNameCopy = $scope.proposal.prpTmainDto.businessTownName;
                        }
                        //险类
                        $scope.proposal.classCodeCopy = $scope.proposal.prpTmainDto.classCode;
                        //险种
                        $scope.proposal.riskCodeCopy = $scope.proposal.prpTmainDto.riskCode;
                        $scope.proposal.prpTmainDto = data.content.prpModelMainSubDto;//基本信息（不完全）
                        //险类
                        $scope.proposal.prpTmainDto.classCode = $scope.proposal.classCodeCopy;
                        //$scope.proposal.prpTmainDto.startDate="";
                        //$scope.proposal.prpTmainDto.endDate="";
                        //险种
                        $scope.proposal.prpTmainDto.riskCode = $scope.proposal.riskCodeCopy;
                        if($scope.proposal.comCNameCopy){
                            $scope.proposal.prpTmainDto.comCName=$scope.proposal.comCNameCopy ;
                        }
                        //归属区域:省
                        if($scope.proposal.businessProvinceNameCopy){
                            $scope.proposal.prpTmainDto.businessProvinceName = $scope.proposal.businessProvinceNameCopy;
                        }
                        //归属区域:市
                        if($scope.proposal.businessCityNameCopy){
                            $scope.proposal.prpTmainDto.businessCityName = $scope.proposal.businessCityNameCopy;
                        }
                        //归属区域:区(县)
                        if($scope.proposal.businessCountyNameCopy){
                            $scope.proposal.prpTmainDto.businessCountyName = $scope.proposal.businessCountyNameCopy;
                        }
                        //归属区域:乡/镇
                        if($scope.proposal.prpTmainDto.businessTownNameCopy){
                            $scope.proposal.prpTmainDto.businessTownName  = $scope.proposal.prpTmainDto.businessTownNameCopy;
                        }
                        //归属区域:村
                        if($scope.proposal.businessTownNameCopy){
                            $scope.proposal.prpTmainDto.businessTownName = $scope.proposal.businessTownNameCopy;
                        }
                        $scope.proposal.prpTmainDto.comCode=$scope.comCode;
                        if($scope.versionNoNone){
                            $scope.proposal.prpTmainDto.versionNo=$scope.versionNoNone;
                        }
                        if($scope.versionNo){
                            $scope.proposal.prpTmainDto.versionNo=$scope.versionNo;
                        }
                        var user = angular.copy($rootScope.user);
                        $scope.proposal.prpTmainDto.operatorName = user.userName//操作人
                        $scope.proposal.prpTmainDto.updaterName = user.userName//修改人

                        $scope.proposal.prpTmainDto.operateDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//投保日期
                        $scope.proposal.prpTmainDto.signDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//制单日期
                        $scope.proposal.prpTmainDto.inputDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//操作日期
                        $scope.proposal.prpTmainDto.updateDate='' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//最近修改日期

                        //$scope.proposal.prpTmainDto.startDate = '' + $scope.getdatestar.year + '-' + $scope.dataNum($scope.getdatestar.month) + '-' + $scope.dataNum($scope.getdatestar.day);////保险起期
                        //$scope.proposal.prpTmainDto.endDate = '' + ($scope.getdate1.year + 1) + '-' + $scope.getdate1.endMonth + '-' + ($scope.getdate1.endDay);////保险止期

                        data.content.prpModelAddressSubDto=data.content.prpModelAddressSubDto||{};
                        data.content.prpModelCoinsDetailDtoList=data.content.prpModelCoinsDetailDtoList||{};
                        data.content.prpModelCoinsSubDtoList=data.content.prpModelCoinsSubDtoList||{};
                        data.content.prpModelEngageSubDtoList=data.content.prpModelEngageSubDtoList||{};
                        data.content.prpModelItemKindAgriDtoList=data.content.prpModelItemKindAgriDtoList||{};
                        data.content.prpModelItemKindDtoList= data.content.prpModelItemKindDtoList||{};
                        data.content.prpModelPlanCoinsDtoList=data.content.prpModelPlanCoinsDtoList||{};
                        data.content.prpModelPlanSubDtoList=data.content.prpModelPlanSubDtoList||{};
                        data.content.prpModelSubsidyDtoList=data.content.prpModelSubsidyDtoList||{};
                        data.content.queryModelPrpTengageDtoList=data.content.queryModelPrpTengageDtoList||{}
                        data.content.prpModelMainAgriSubDto=data.content.prpModelMainAgriSubDto||{};
                        data.content.prpModelFeeSubDto=data.content.prpModelFeeSubDto||{};
                        data.content.appliInsuredDto=data.content.appliInsuredDto||{};
                        data.content.insuredDto=data.content.insuredDto||{};
                        $scope.proposal.prpDcustomerTaxPayInfoDto=$scope.proposal.prpDcustomerTaxPayInfoDto||{};
                        //$scope.proposal.appliInsuredDto = data.content.appliInsuredDto||{};
                        //$scope.proposal.insuredDto = data.content.insuredDto||{};
                        $scope.prpMmodelMainDto = $scope.prpMmodelMainDto || {};
                        $scope.proposal.prpDcustomerTaxPayInfoDto=$scope.proposal.prpDcustomerTaxPayInfoDto||{};
                        data.content.prpModelCustomerTaxPayInfoSubDto=data.content.prpModelCustomerTaxPayInfoSubDto||{};
                        $rootScope.getModelCode = data.content.prpMmodelMainDto.modelCode;
                        $scope.proposal.prpTmainDto.riskCodeName = data.content.riskCname;//险种

                        $scope.proposal.prpTmainDto.contractType = data.content.prpModelMainSubDto.argueSolution;//合同争议解决方式
                        //$scope.proposal.prpTmainDto.comCode = data.content.prpModelMainSubDto.comCode,//归属机构

                        $scope.proposal.prpTmainDto.handler1Code=data.content.prpModelMainSubDto.handler1Code,//归属业务人员
                        $scope.handler1Code=$scope.proposal.prpTmainDto.handler1Code;
                        $scope.proposal.prpTmainDto.businessCategory = data.content.prpModelMainSubDto.groupFlag;//业务大类
                        //$scope.proposal.prpTaddressDto.addressName = data.content.prpModelAddressSubDto.addressName;种植地点，已经选择清单就不要赋值
                        $scope.proposal.prpTitemKindAgriDtoList = data.content.prpModelItemKindAgriDtoList;
                        $scope.proposal.prpTmainAgriDto = data.content.prpModelMainAgriSubDto;
                        $scope.proposal.prpTmainAgriDto.raiseDate=$filter('date')(data.content.prpModelMainAgriSubDto.raiseDate, 'yyyy-MM-dd');

                        $scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;//缴费计划（不完全）
                        $scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;//补贴信息
                        $scope.proposal.prpTfeeDto = data.content.prpModelFeeSubDto;//币别信息
                        $scope.proposal.prpTfeeDto.currency2 = data.content.prpModelMainSubDto.currency;//汇总币别
                        $scope.proposal.prpDcustomerTaxPayInfoDto = data.content.prpModelCustomerTaxPayInfoSubDto;
                        $scope.proposal.prpTplanDtoList = data.content.prpModelPlanSubDtoList;
                        $scope.proposal.prpTsubsidyDtoList = data.content.prpModelSubsidyDtoList;
                        $scope.currency2Name = data.content.currency2Name;
                        $rootScope.totalAmount = data.content.prpModelMainSubDto.sumAmount//总保额
                        $rootScope.totalPay = data.content.prpModelMainSubDto.sumPremium;//总保费
                        $scope.proposal.prpTmainDto.updaterName = data.content.updaterName;//最近修改人
                        $scope.proposal.prpTmainDto.operatorName = data.content.operatorName;//操作员名称
                        $scope.proposal.prpDcustomerTaxPayInfoDto.postCode = data.content.insuredDto.postCode;//邮政编码
                        //$scope.proposal.appliInsuredDto.certificateName = data.content.appliInsuredDto.certificatEName;//客户代码
                        //$scope.proposal.insuredDto.certificateName = data.content.insuredDto.certificatEName;//客户代码
                        //$scope.proposal.appliInsuredDto.isCareClaim = data.content.appliInsuredDto.iscareClaim,//客户是否关注审计、理赔、退保信息
                        //    $scope.proposal.insuredDto.isCareClaim = data.content.insuredDto.iscareClaim//客户是否关注审计、理赔、退保信息
                        $scope.proposal.prpTmainDto.reMark = data.content.prpModelMainSubDto.remark//*出单员意见
                        $scope.proposal.prpTmainDto.class = $scope.proposal.prpTmainDto.classCode;
                        $scope.proposal.prpTmainDto.className = data.content.className;//险类
                        $scope.proposal.insureListCode1= data.content.insureListCode;
                        $scope.proposal.prpTcoinsDtoList = data.content.prpModelCoinsSubDtoList;
                        $scope.proposal.prpTcoinsDetailDtoList = data.content.prpModelCoinsDetailDtoList;
                        $scope.proposal.prpTplanCoinsDtoList = data.content.prpModelPlanCoinsDtoList;
                        //$scope.proposal.insuredDto.BusinessSort = data.content.insuredDto.businessSort,//公司性质
                        //$scope.proposal.appliInsuredDto.BusinessSort=data.content.appliInsuredDto.businessSort//公司性质
                        //$scope.proposal.prpTmainAgriDto.relationListNo=data.content.prpModelMainAgriSubDto.relationListNo;//我方清单号
                        $scope.proposal.prpTengageDtoCopy=$scope.proposal.prpTengageDtoCopy||[];
                        angular.forEach(data.content.queryModelPrpTengageDtoList, function (data, index) {
                            var obj = {
                                clauseCode: data.clauseCode,//特约代码
                                clauses: data.clauseName,//特约名称
                                clausesContent: data.clausesContent//特约内容
                            };
                            $scope.proposal.prpTengageDtoCopy.push(obj)
                        });
                        angular.forEach(data.content.prpModelCoinsSubDtoList, function (data, index) {
                            data.mainProposalNo=data.mainPolicyNo;//主保单号码
                            data.coinsSumAmount=$scope.proposal.prpTcoinsDetailDtoList[index].coinsAmount//共保保额
                            data.coinsSumPremium=$scope.proposal.prpTcoinsDetailDtoList[index].coinsPremium//共保保费
                            data.policyNo="1";
                        });
                        //共保方补贴信息
                        angular.forEach(data.content.prpModelPlanCoinsDtoList, function (data, index){
                            data.realPay=data.planFee-data.delinquentFee;//实缴金额
                            if (data.payReason=='03'){
                                data.reason='中央财政';//缴费原因
                            }
                            if (data.payReason=='04'){
                                data.reason='省级财政';//缴费原因
                            }
                            if (data.payReason=='07'){
                                data.reason='县(区)财政';//缴费原因
                            }
                            if (data.payReason=='06'){
                                data.reason='其他来源';//缴费原因
                            }
                            if (data.payReason=='05'){
                                data.reason='地市财政';//缴费原因
                            }
                            if (data.payReason=='GP81'){
                                data.reason='自缴保费';//缴费原因
                            }
                            if ($scope.proposal.prpTcoinsDetailDtoList.length>=3){
                                data.coinsName=$scope.proposal.prpTcoinsDetailDtoList[2].coinsName;
                            }

                        });
                        //绝对免赔率
                        $scope.proposal.engageQueryClause = $scope.proposal.engageQueryClause || {};
                        angular.forEach($scope.proposal.prpTengageDtoCopy, function (data, index) {
                            if (data.clauseCode == 'TX001') {
                                $scope.proposal.engageQueryClause.absuDedu= $scope.proposal.prpTengageDtoCopy.splice(index, 1)[0].clausesContent;

                            }
                        });
                        //客户信息中被保险人中的  同投保人选择按钮
                        data.content.appliInsuredDto.insuredCode == data.content.insuredDto.insuredCode ? $scope.checkedBox = ["1"] : $scope.checkedBox = [];
                        //发票购货方信息  选择同投保人、被投保人
                        if (data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1" ){
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1";
                            if(data.content.appliInsuredDto.nationality){
                                $scope.proposal.appliInsuredDto.nationality=data.content.appliInsuredDto.nationality;
                            }
                        }else if(data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "2" ){
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "2"
                        }else {
                            $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "";
                        }
                        //data.content.prpModelCustomerTaxPayInfoSubDto.payInfoObject == "1" ? $scope.proposal.prpDcustomerTaxPayInfoDto.tdInsuredIdentityInput = "1" : $scope.tdInsuredIdentityInput = "";
                        angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                            if (data.payReason == 'R10') {
                                data.payReasonName = '签单收保费'
                            }
                            if (data.payReason == 'R20') {
                                data.payReasonName = '分期收保费'
                            }
                            if (data.payReason == 'RS3') {
                                data.payReasonName = '中央财政'
                            }
                            if (data.payReason == 'RS4') {
                                data.payReasonName = '省级财政'
                            }
                            if (data.payReason == 'RS7') {
                                data.payReasonName = '县(区)财政'
                            }
                            if (data.payReason == 'RS6') {
                                data.payReasonName = '其他来源'
                            }
                            if (data.payReason == 'RS5') {
                                data.payReasonName = '地市财政'
                            }
                            data.payreFee = data.planFee - data.delinquentFee
                            if (!isNaN(data.planDate)) {
                                data.planDate = $filter('date')(data.planDate, 'yyyy-MM-dd');
                                data.planStartDate = $filter('date')(data.planStartDate, 'yyyy-MM-dd');
                            }

                        })
                        //主险附加险
                        angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMaintitle='单位保险产量'
                            $scope.proposal.prpTitemKindDtoList[index].agriUnitCostMaintitle = '单位生产成本'
                            $scope.proposal.prpTitemKindDtoList[index].radioType = data.flag == 1 ? 'Y' : 'N';
                            $scope.proposal.prpTitemKindDtoList[index].premiumCalMethod = data.premiumcalMethod//保费计算方式


                        })
                        angular.forEach(data.content.prpModelItemKindAgriDtoList, function (data, index) {
                            $scope.proposal.prpTitemKindDtoList[index].agriUnitCostMain = data.unitCost;//单位生产成本
                            $scope.proposal.prpTitemKindDtoList[index].unitCostName = '元';
                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMain = data.unitCost;//单位保险产量
                            $scope.proposal.prpTitemKindDtoList[index].agriUnitOutputMainName="公斤";
                            $scope.proposal.prpTitemKindDtoList[index].unitAmount = data.unitAmount
                            $scope.proposal.prpTitemKindDtoList[index].agriGrossQuantityMain = data.grossQuantity// 投保面积
                            $scope.proposal.prpTitemKindDtoList[index].agriTimesAmount = data.timesAmount;
                        })


                        //政策性
                        if (data.content.prpModelMainSubDto.businessType1 == '00') {
                            $scope.proposal.prpTmainDto.businessType1Name = "商业性"
                        } else if (data.content.prpModelMainSubDto.businessType1 == '01') {
                            $scope.proposal.prpTmainDto.businessType1Name = "中央政策性"
                        } else if (data.content.prpModelMainSubDto.businessType1 == '02') {
                            $scope.proposal.prpTmainDto.businessType1Name = "地方政策性"
                        }
                        //
                        $$finder.find('queryByRiskCode',{
                            riskCode:data.content.prpModelMainSubDto.riskCode,//险种
                        }, {
                            success: function (data) {
                                $scope.rateDivisor=data.content;
                                $scope.getrateDivisor( $scope.rateDivisor)
                            },
                            error: function (e) {
                                options.error(e);
                            }
                        });
                        //业务大类
                        $scope.parameterConvert.businessCategoryInit();
                        $scope.getPlantingInfo(data.content.gisInsureListCode,'input');
                        if (!$scope.proposal.insureMainListDto.insureListCode){
                            $scope.proposal.insureMainListDto.insureListCode=data.content.gisInsureListCode,//清单编号
                            $scope.proposal.prpTmainAgriDto.relationListNoRemark=data.content.remark,//清单备注
                            $scope.proposal.insureMainListDto.listTypeFlag=data.content.listTypeFlag,//清单类型
                            $scope.proposal.prpTmainDto.businessProvinceName=data.content.fProvinceName;//归属区域:省
                            $scope.proposal.prpTmainDto.businessCityName=data.content.fCityName;//归属区域:市
                            $scope.proposal.prpTmainDto.businessCountyName=data.content.fCountyName;//归属区域:区(县)
                            $scope.proposal.prpTmainDto.businessTownName=data.content.fTownName;//归属区域:乡/镇
                            $scope.proposal.prpTmainDto.businessAreaName=data.content.fVillageName;//归属区域:村
                            $scope.proposal.insureMainListDto.serialNo=data.content.serialNo;//清单序列号
                            $scope.proposal.prpTaddressDto.addressName = data.content.prpModelAddressSubDto.addressName;//种植地点
                            if (data.content.listTypeFlag=='D'){
                                $scope.proposal.insureMainListDto.listTypeFlag='大户';
                            }
                            if (data.content.listTypeFlag=='S'){
                                $scope.proposal.insureMainListDto.listTypeFlag='散户';
                            }
                            //根据清单带出客户信息
                            $scope.requestInsurance(data.content.gisInsureListCode,data.content.serialNo)
                        }else{
                            angular.forEach(data.content.prpModelItemKindDtoList, function (data, index) {
                                $scope.proposal.prpTitemKindDtoList[index].kindName = '';
                                $scope.proposal.prpTitemKindDtoList[index].kindCode='';
                                $scope.proposal.prpTitemKindDtoList[index].itemDetailName='';
                                $scope.proposal.prpTitemKindDtoList[index].itemCode='';
                                $scope.proposal.prpTitemKindDtoList[index].model='';
                                $scope.proposal.prpTitemKindDtoList[index].replyNo='';

                            })
                        }
                        //归属业务员
                        //$scope.getHanCode({comCName: $scope.proposal.prpTmainDto.comCName}, $scope.proposal.prpTmainDto.handler1Code);

                        //归属机构下拉初始化传参
                        var handCodeData={
                            "userCode": $scope.user.userCode,
                            "userName": $scope.user.userName,
                            "loginComCode":  $scope.user.loginComCode,
                            "loginGradeCodes": "111",
                            "tableName": "prpduser",
                            "userCodeFields": "userCode",
                            "comCodeFields": $scope.proposal.prpTmainDto.comCode,
                            "riskCode": $scope.proposal.prpTmainDto.riskCode
                        };
                        // handCodeList归属业务员下拉列表
                        $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                            $scope.selectListData.handCodeList = data;
                            $scope.proposal.prpTmainDto.handler1Code = $scope.handler1Code;
                        });
                        //投保方式
                        $scope.mulitSelectPolicyType($scope.proposal.prpTmainDto.riskCode, data.content.prpModelMainSubDto.policyType);//投保方式下拉初始化获取
                        //共保不显示就粘这一段
                        if ($scope.proposal.prpTmainDto.coinsFlag != '0') {
                            $rootScope.PremiumShow = true;
                            $rootScope.showCoins = true;
                            $scope.proposal.otherAgentFeeShow = true;
                            $rootScope.isHide = true;
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }

                });
            }
            //校验输入的清单号是否有特殊字符
            $scope.checkinsureListCode = function ($event,str) {
                var reg = /^[0-9]*$/;
                if(str && !reg.test(str)){
                    layer.open({
                        /*offset: ['40%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '清单号码格式错误，请修改！',
                        scrollbar: false,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            $("#insureListCode").focus();
                            layer.close(index);
                        }
                    });
                    $scope.proposal.insureMainListDto.insureListCode="";
                }else {
                    $scope.queryRelationListNoLayer($scope.proposal.insureMainListDto.insureListCode)
                }
            }
            $scope.checkqd = function ($event,str) {
                if(str ==""||str ==null){
                    layer.open({
                        /*offset: ['40%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请先选择清单！',
                        scrollbar: false,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else{
                    var path=$rootScope.frontEnd.prpallGisUrl+"/CallPage/ListShow/Index?listcode="+str;
                    window.open(path);
                }
            }
            //校验模板与条款是否存在有效
            $scope.checkClauseAndModel = function(versionNo,modelCode,flag){
                var content="";
                if(flag=="COPY_PROPOSAL"){
                    content = "您所选的投保单中";
                }else{
                    content = "您所选的保单中";
                }
                //校验条款是否可用
                $$finder.find('getPrpDclauseCodeInfo',{
                    clauseCode:versionNo//条款代码
                }, {
                    success: function (data_1) {
                        if(data_1.content==undefined){
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: content+versionNo+"条款已停用或者删除!",
                                btn: ['确定'],
                                btn1: function (index, layero) {
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
                //校验保存的时候模板是否可用
                if(modelCode!="" && modelCode!=null){//判断模板是否有，没有就跳过此校验
                    $$finder.find('getPrpmmodelmainInfo',{
                        modelCode:modelCode//模板代码
                    },{
                        success:function (data_2){
                            if(data_2.content==undefined){
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: content+modelCode+"模板已停用或者删除!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        },
                        error: function (e) {
                        }
                    });
                }
            }
        /*//    条款列表选中之后把该条款名称展示在搜索框内
            $scope.getversionNo= function (str) {
                $scope.TKKwords=str;
            }
            //    模板列表选中之后把该模板名称展示在搜索框内
            $scope.getmodelCode= function (str) {
                $scope.MBKwords=str;
            }*/

            //获取时间
            var date1 = new Date();
            var month = date1.getMonth();
            var day = date1.getDate();
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
            $scope.getdate1={
                year:date1.getFullYear(),
                month:month,
                day:day,
                startMonth:startMonth,
                startDay:startDay,
                endMonth:endMonth,
                endDay:endDay
            }
            var day3 = new Date();
            day3.setTime(day3.getTime()+24*60*60*1000);
            $scope.getdatestar={
                year:day3.getFullYear(),
                month:(day3.getMonth()+1),
                day:day3.getDate()
            }
            $scope.dataNum=function(x){
                return x<10?'0'+x:x
            }

            //对数字四舍五入
            //数值,精度
            function round(number, precision) {
                if (isNaN(number))
                    number = 0;
                var prec = Math.pow(10, precision);
                var result = Math.round(number * prec);
                /* modify by xiaojian 20051219 reason：恢复20050711此函数的文件，如下处理有问题 */
                //if(Math.round((result-number*prec)*10)==-5)
                //  result = result+1;
                result = result / prec;

                //小数点后只有一位数时，自动补零
                var xsd=result.toString().split(".");
                if(xsd.length>1){
                    if(xsd[1].length<2){
                        result=result.toString()+"0";
                    }
                }
                if(xsd.length==1){
                    result=result+".00";
                }
                return result;
            }
        //    切换单选按钮
            $scope.changeRadioSelectFlag=-1;
            $scope.changeRadioSelect= function ($event,index) {
                if($scope.changeRadioSelectFlag==index){
                    $event.target.checked=false;
                    $scope.requestInsuranceQueryDto.queryList1="";
                    $scope.changeRadioSelectFlag=-1;
                }else{
                    $scope.changeRadioSelectFlag=index;
                    $scope.isSelected(index);
                }

            }
            $scope.changeClauseSelectFlag=-1;
            $scope.changeClauseSelect= function ($event,index) {
                if($scope.changeClauseSelectFlag==index){
                    $event.target.checked=false;
                    $scope.changeClauseSelectFlag=-1;
                    $scope.proposal.prpTmainDto.versionNo='';
                }else{
                    $scope.changeClauseSelectFlag=index;
                }
            }
            $scope.changeModelCodeSelectFlag=-1;
            $scope.changeModelCodeSelect= function ($event,index) {
                if($scope.changeModelCodeSelectFlag==index){
                    $event.target.checked=false;
                    $scope.changeModelCodeSelectFlag=-1;
                    $scope.proposal.prpTmainDto.modelCode='';
                }else{
                    $scope.changeModelCodeSelectFlag=index;
                }
            }
            //当切换模板时清空数据
            $scope.changeModelMsg= function (riskScheme) {
                $scope.proposal.prpTmainDto.classCode='';
                $scope.proposal.prpTmainDto.riskCode='';
                $scope.proposal.modelCode="";
                /* $scope.proposal.prpTmainDto={};
                 //给是否承保公示、是否验标、是否通过第三方识别赋默认值
                 $scope.proposal.prpTmainDto.thirdKnow = '1';//是否第三方识别
                 $scope.proposal.prpTmainDto.notificationFlag = '1';//是否承保公示
                 $scope.proposal.prpTmainDto.inceptionFlag = '1';//是否验标
                 $scope.proposal.prpTmainDto.eccFlag = '2';//是否抚贫项目
                 $scope.proposal.prpTmainDto.businessNature = 0;//业务来源
                 $scope.proposal.prpTmainDto.autoTransRenewFlag = '1';//缴费方式
                 $scope.proposal.prpTmainDto.startDate = '' + $scope.getdatestar.year + '-' + $scope.dataNum($scope.getdatestar.month) + '-' + $scope.dataNum($scope.getdatestar.day);////保险起期
                 $scope.proposal.prpTmainDto.endDate = '' + ($scope.getdate1.year + 1) + '-' + $scope.getdate1.endMonth + '-' + ($scope.getdate1.endDay);////保险止期
                 $scope.proposal.prpTmainDto.startHour = '0';//保险起期小时
                 $scope.proposal.prpTmainDto.endHour = '24';//保险止期小时
                 $scope.proposal.prpTmainDto.operateDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//投保日期
                 $scope.proposal.prpTmainDto.signDate = '' + $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//制单日期
                 var user = angular.copy($rootScope.user);
                 //$scope.proposal.prpTmainDto.makeCom = user.makeCom;
                 //操作员修改人
                 $scope.proposal.prpTmainDto.operatorCode = user.userCode
                 $scope.proposal.prpTmainDto.operatorName = user.userName
                 $scope.proposal.prpTmainDto.updaterName = user.userName
                 $scope.proposal.prpTmainDto.updaterCode = user.userCode
                 $scope.proposal.prpTmainDto.judicalScope = '1';//司法管轄
                 $scope.proposal.prpTmainDto.contractType = '1';//合同争议解决方式
                 $scope.proposal.prpTmainDto.inputDate = $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//操作日期
                 $scope.proposal.prpTmainDto.updateDate = $scope.getdate1.year + '-' + $scope.getdate1.endMonth + '-' + $scope.getdate1.endDay;//最近修改日期
                 $scope.proposal.prpTmainAgriDto.remark = "";//按何种方式确定保险金额
                 $scope.proposal.prpTitemKindDtoList = [];//主险附加险
                 $scope.proposal.engageQueryClause.absuDedu = "";
                 $scope.proposal.prpTitemKindAgri.stratDate = "";
                 $scope.proposal.prpTitemKindAgri.endDate = "";
                 $scope.proposal.isHide = false;
                 $scope.proposal.prpTsubsidyDtoList = [];//补贴信息
                 $scope.proposal.prpTplanDtoList = [];//缴费计划
                 $scope.proposal.prpTfeeDto = {};//币别
                 $scope.proposal.prpTfeeDto.currency2 = 'CNY';
                 $scope.currency2Name = '人民币';
                 $scope.proposal.prpTfeeDto.currency1 = 'CNY';
                 $scope.proposal.prpTengageDtoCopy = [];//特约*/
                $scope.prpMmodelMainDto={};
                $scope.prpMmodelMainDto.validstatus='1';
                $scope.prpMmodelMainDto.riskScheme=riskScheme;
                $scope.proposal.insureMainListDto.insureListCode='';
                $scope.queryMarkedList=[];
                $scope.clause=[];
                $scope.model=[];
                $scope.TKKwords='';
                //清机构数
                var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                if(treeObj){
                    treeObj.checkAllNodes(false);
                }
                $rootScope.modelComDtoList=[];
            }
        }]);
});