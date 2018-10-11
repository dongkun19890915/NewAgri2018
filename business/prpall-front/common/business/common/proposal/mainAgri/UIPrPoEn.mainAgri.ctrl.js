define(['app', 'constants', 'layer', 'jsonDB', 'utilities', 'codes'], function (app, constants, layer, jsonDB, utilities, codes) {
    'use strict';
    app.registerController('UIPrPoEnMainAgriCtrl', ['$rootScope', '$filter', '$scope', '$$finder', '$http', '$state', 'commonApiServ', 'regexpConstants', '$$code', '$stateParams',
        function ($rootScope, $filter, $scope, $$finder, $http, $state, commonApiServ, regexpConstants, $$code, $stateParams) {
            //$scope.endorHide=true;
            //特别约定代码初始化
            //$scope.prpTengageDtoList.clauseCode='T31';
            $scope.proposal.prpModelMainSubDto= $scope.proposal.prpModelMainSubDto||{};
            $scope.proposal.prpTmainDto = $scope.proposal.prpTmainDto ||{};
            //$scope.endorseShow=true;//主险附加险新增按钮默认隐藏
            // 清单号校验
            $scope.regexp = {};
            $scope.currencyDisable = true;
            $scope.regexp.number = regexpConstants.number;
            $scope.regexp.Chinese = regexpConstants.Chinese;
            $scope.regexp.code= regexpConstants.code;
            $scope.isRaiseDate = true;
            //补贴信息的对象
            //$scope.proposal.prpTsubsidyDto = [];//补贴信息上来是没有的所以这个集合应该是空的
            $scope.onlyShow = false;
            $scope.rateflag=false;
            $scope.prpTitemKind = {};
            $scope.prpTitemKind.CalculateFlagSub = "N"
            var showUpdata = false
            var showUpdataindex = 0;
            var updata = false;
            //-----------给汇总币别与标的币别赋默认值start-------
            $scope.proposal.prpTfeeDto.currency2 = 'CNY';
            $scope.currency2Name = '人民币';
            $scope.proposal.prpTfeeDto.currency1 = 'CNY';
            //-----------给汇总币别与标的币别赋默认值end-------
            //--------------------------------监听险种改变就触发一次开始----------------------------------------------
            $scope.$watch('proposal.prpTmainDto.riskCode', function () {
                //种植方式个性化
                $scope.isRaiseType = false;
                $scope.isProposalType = false;
                if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                    || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                    || $scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                    || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102'
                    || $scope.proposal.prpTmainDto.riskCode == '3101'|| $scope.proposal.prpTmainDto.riskCode == '3114'
                    || $scope.proposal.prpTmainDto.riskCode == '3122'|| $scope.proposal.prpTmainDto.riskCode == '3126'
                    || $scope.proposal.prpTmainDto.riskCode == '3161'|| $scope.proposal.prpTmainDto.riskCode == '3149') {
                    $scope.isProposalType = true;
                } else if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                    $scope.isRaiseType = true;
                }
                if ($scope.proposal.prpTmainDto.riskCode == '3224' || $scope.proposal.prpTmainDto.riskCode == "3237" || $scope.proposal.prpTmainDto.riskCode == "3220" || $scope.proposal.prpTmainDto.riskCode == "3233") {
                    $scope.trRaiseName = "养殖时间";
                    $scope.addressTitle = "养殖地点";
                } else {
                    $scope.trRaiseName = "种植时间";
                    $scope.addressTitle = "种植地点";
                }
                if ($scope.proposal.prpTmainDto.riskCode == '3107' && $scope.proposal.prpTmainDto.comCode.substring(0, 2) == "41") {
                    $scope.risksshow = '41';
                }
                //赔付明细个性化
                $scope.isTriggerPoint = false;
                $scope.isTotalLossRatio = false;
                if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                    || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108' || $scope.proposal.prpTmainDto.riskCode == '3224'
                    || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                    || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3129' || $scope.proposal.prpTmainDto.riskCode == '3102'
                    || $scope.proposal.prpTmainDto.riskCode == '3101' || $scope.proposal.prpTmainDto.riskCode == '3114' || $scope.proposal.prpTmainDto.riskCode == '3122'
                    || $scope.proposal.prpTmainDto.riskCode == '3126' || $scope.proposal.prpTmainDto.riskCode == '3161' || $scope.proposal.prpTmainDto.riskCode == '3149' ) {
                    //显示起赔点、全损损失率
                    $scope.deductibleRateType = false;
                    $scope.totalLossRatioType = false;
                    $scope.isTriggerPoint = true;
                    $scope.isTotalLossRatio = true;
                } else if ($scope.proposal.prpTmainDto.riskCode == '3237') {
                    $scope.isIndemnity = true;
                    $scope.isTriggerPoint = true;
                    $scope.isTotalLossRatio = true;
                    $scope.deductibleRateType = true;//每次事故免赔率置灰
                    $scope.totalLossRatioType = true;//全损损失率置灰
                }
                if ($scope.proposal.prpTmainDto.riskCode == '3224') {
                    $scope.deductibleRateType = true;
                    $scope.totalLossRatioType = true;
                }

                //承保明细个性化
                if ($scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') {
                    $scope.isAgriUnitCostMain = false;//隐藏单位生产成本
                    $scope.isProportion = true;
                } else if ($scope.proposal.prpTmainDto.riskCode == '3107' || $scope.proposal.prpTmainDto.riskCode == '3162'
                    || $scope.proposal.prpTmainDto.riskCode == '3155' || $scope.proposal.prpTmainDto.riskCode == '3108'
                    || $scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3129') {
                    $scope.isTrue = true;//茬次信息
                    //不做处理
                    $scope.isAgriUnitCostMain = false;
                    $scope.isProportion = false;
                } else if ($scope.proposal.prpTmainDto.riskCode == '3237') {
                    $scope.isAgriUnitCostMain = true;
                } else if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                    || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                    $scope.isAgriUnitCostMain = true;//隐藏单位生产成本
                    $scope.isagriTimesAmount = false;//隐藏约定单价
                    $scope.isTrue = false;//茬次信息
                }
                if ($scope.proposal.prpTmainDto.riskCode == '3129') {
                    $scope.isRaiseDate = false;
                    $scope.isProposalType = false;
                    $scope.ZHshow = true;
                    $scope.isAgriUnitCostMain = true;
                }
                //保险金额确定方式个性化
                if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                    || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                    $scope.proposal.prpTmainAgriDto.remark = '1';
                }
                //---------------------------------------第一个绝对免赔率显示-----------------------------------
                $scope.absuDeduShowFirst = false;
                if ($scope.proposal.prpTmainDto.riskCode != '3129' && $scope.proposal.prpTmainDto.riskCode != '3130'
                    && $scope.proposal.prpTmainDto.riskCode != '3134' && $scope.proposal.prpTmainDto.riskCode != '3147'
                    && $scope.proposal.prpTmainDto.riskCode != '3141' && $scope.proposal.prpTmainDto.riskCode != '3102') {
                    $scope.absuDeduShowFirst = true;
                }
                //------------------------------------------第二个绝对免赔率（与免赔说明一起）----------------------------------------------------------
                $scope.absuDeduShowSecond = false;
                if ($scope.proposal.prpTmainDto.riskCode == '3130' || $scope.proposal.prpTmainDto.riskCode == '3102'
                    || $scope.proposal.prpTmainDto.riskCode == '3141') {
                    $scope.absuDeduShowSecond = true;
                }
            });

            //--------------------------------监听险种改变就触发一次结束----------------------------------------------
            //监听条款改变，险类下拉框重新初始化
            $scope.$watch('proposal.prpTmainDto.versionNo',function(){
                if($scope.radioType=='Y'){
                    getKindcode(1);
                }else if($scope.radioType=='N'){
                    getKindcode(2);
                }

            });

            //监听投保面积发生变化重新计算总保额
            //$scope.$watch('prpTitemKind.agriGrossQuantityMain',function(){
            //    gettotalAmount();
            //});

            $rootScope.isTrue=function(){
                $scope.trRaiseName="种植时间";
                $scope.addressTitle="种植地点";
                $scope.prpTitemKind.untilKindName="投保面积"
                $scope.isAgriUnitCostMain=true;//隐藏单位生产成本
                $scope.isagriTimesAmount=false;//隐藏约定单价
                $scope.isTrue=false;//茬次信息
            }

            //主险附加险录入校验
            $scope.recorver=function(n){
                if($scope.proposal.prpTitemKindDtoList && $scope.proposal.prpTitemKindDtoList.length>0){
                    angular.forEach( $scope.proposal.prpTitemKindDtoList, function (data, index) {
                        var length=$scope.proposal.prpTitemKindDtoList.length;
                        var main=""
                        if(data.radioType=="Y"){
                            main="主险" ;
                        }else if(data.radioType=="N"){
                            main="附加险" ;
                        }
                        var count=index+1;
                        if(data.flag !="D" && n.itemCode==data.itemCode && data.radioType==$scope.radioType && data.kindCode==$scope.prpTitemKind.kindCode){
                            n.itemDetailName="";
                            n.itemCode="";
                            n.model="";
                            n.replyN="";
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '第'+(length+1)+'条'+main+'标的与第'+count+'条'+main+'标的重复！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return
                        }
                    })
                }
            }
            $scope.claer=function(){
                $scope.prpTitemKind.itemCode="";
                $scope.prpTitemKind.model="";
                $scope.prpTitemKind.replyNo ='';
            }

            //监听修改主险附加险切换险别
            $scope.$watch('radioType',function(){
                if($scope.radioType=='Y'){
                    getKindcode(1);
                }else if($scope.radioType=='N'){
                    getKindcode(2);
                }
            });

            $scope.ifShow=true;
            $scope.isTrue=true;
            $scope.payDetail=true;
            //茬次信息新增一行
            console.log("$scope.proposalQueryHide",$scope.proposalQueryHide);
            console.log("$scope.endorseFlag",$scope.endorseFlag);
            $scope.changeAdd=function(){
                $scope.proposal.prpTitemKindAgriDtoListCopy=$scope.proposal.prpTitemKindAgriDtoListCopy||[]
                var newObject = {
                    "stratDate": "" ,//茬次起始日期
                    "endDate": "",//茬次终止日期
                    "distributingRate":"",//保险金额分布比例
                    "timesAmount": "",//茬次保险金额
                };
                //**************--------批改专属----***************
                // 如果是批改需要增加标志位 I ；
                if ($scope.endorseFlag) {
                    newObject.flag = 'I'
                }
                //**************--------批改专属----***************
                $scope.proposal.prpTitemKindAgriDtoListCopy.push(newObject);
                if($scope.proposal.prpTitemKindAgriDtoListCopy[0].stratDate==undefined || $scope.proposal.prpTitemKindAgriDtoListCopy[0].stratDate==null|| $scope.proposal.prpTitemKindAgriDtoListCopy[0].stratDate==""){
                    $scope.proposal.prpTitemKindAgriDtoListCopy[0].stratDate=$filter('date')(new Date().getTime()+86400000,'yyyy-MM-dd');
                    $scope.proposal.prpTitemKindAgriDtoListCopy[0].endDate=$filter('date')(new Date().getTime()+31536000000,'yyyy-MM-dd');
                }

            }

            //茬次信息删除按钮
            $scope.deleteCoins2 = function (index) {
                var prpTitemKindAgriDtoListCopy = $scope.proposal.prpTitemKindAgriDtoListCopy;
                //**************--------批改专属----***************
                // 如果是批改，并且是保单数据初始值。
                if ($scope.endorseFlag) {
                    // 批单点击删除 有可能为恢复
                    if (prpTitemKindAgriDtoListCopy[index].flag === 'D') { // 如果为恢复； 标识位置为 null
                        prpTitemKindAgriDtoListCopy[index].flag = null;
                    }else if (prpTitemKindAgriDtoListCopy[index].flag === 'I') { // 如果是新增的一条就删除一行
                        $scope.proposal.prpTitemKindAgriDtoListCopy.splice(index, 1);
                    } else { // 如果为删除 则从保存的数据中取出初始值将列表值赋值回来 并且置标识位为 D
                        prpTitemKindAgriDtoListCopy[index] = $scope.blPolicyInfoListingConvertCopyRestoreDTO.prpTitemKindAgriDtoListCopy[index];
                        prpTitemKindAgriDtoListCopy[index].flag = 'D'
                    }
                    //**************--------批改专属----***************
                } else {
                    $scope.proposal.prpTitemKindAgriDtoListCopy.splice(index, 1);
                }
            }

            $scope.check={};
            //茬次信息计算
            $scope.checkSumDistributingRate=function($event,distributingRate,index){
                //校验茬次金额比例只能输入整数和至多两位小数
                var reg = /^[0-9]\d*(\.\d{1,2})?$/;
                if (distributingRate && !reg.test(distributingRate)) {
                    $scope.check.distributingRate = "茬次金额分布比例只能输入整数和至多两位小数！";
                    $event.target.focus();
                    return
                } else {
                    $scope.check.distributingRate = "";
                }

                var sum=0;
                angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto) {
                    if(dto.flag && dto.flag=="D"){
                        //sum+=parseFloat(dto.distributingRate)
                    }else if(!dto.flag || dto.flag=="I"){
                        sum+=parseFloat(dto.distributingRate)
                    }

                });
                if(sum>100){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '茬次信息中的“保险金额分布比例”之和不能大于100！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                    $scope.proposal.prpTitemKindAgriDtoListCopy[index].distributingRate="";
                    return
                }
                $scope.kindCodeList = [];//险别集合
                $scope.itemCodeList = [];//标的代码集合
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    $scope.kindCodeList.push(data.kindCode);//险别集合
                    $scope.itemCodeList.push(data.itemCode);//标的代码集合
                })

                //查询标的险别关系表
                $$finder.find('queryFlag', {
                    "riskCode":$scope.proposal.prpTmainDto.riskCode,
                    "itemCodeList":$scope.itemCodeList,//标的代码集合itemListCodes
                    "kindCodeList": $scope.kindCodeList//险别
                }, {
                    success: function (data) {
                        prpDkindItemAgriList=data.content;
                        //获取主险信息
                        var sumAmount=0;
                        $scope.listMain=[];
                        angular.forEach($scope.proposal.prpTitemKindDtoList,function(dto) {
                            angular.forEach(data.content,function(dto1) {
                                if(dto.riskCode==dto1.riskCode && dto.kindCode==dto1.kindCode
                                    && dto.itemCode==dto1.itemCode && dto1.mainTimes=='1' ){
                                    $scope.listMain.push(dto);
                                    sumAmount+=parseFloat(dto.amount);
                                }
                            });
                        });

                        //计算茬次金额
                        var amount=0;
                        if($scope.listMain.length>0){
                            amount=(parseFloat(distributingRate)/100)*sumAmount;
                        }else{
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '主险中没有录入“蔬菜作物”标的信息，请录入该信息以计算茬次保险金额!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return
                        }
                        $scope.proposal.prpTitemKindAgriDtoListCopy[index].timesAmount=round(amount,2);
                        $scope.proposal.prpTitemKindAgriDtoListCopy[index].itemKindNo=$scope.listMain[0].itemKindNo;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });

            }

            //茬次信息控制茬次信息中的“保险金额分布比例”之和必须等于100
            $scope.sumDistributingRate=function(){
                var sum=0;
                angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto) {
                    if(isNaN(dto.distributingRate)){
                        dto.distributingRate=0;
                    }
                    //sum+=parseFloat(dto.distributingRate)
                    if(dto.flag && dto.flag=="D"){
                        //sum+=parseFloat(dto.distributingRate)
                    }else if(!dto.flag || dto.flag=="I"){
                        sum+=parseFloat(dto.distributingRate)
                    }
                });
                if(sum!=100){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '茬次信息中的“保险金额分布比例”之和必须等于100！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                    return false
                }
                return true
            }

            //茬次信息日期校验
            $scope.checkTimesDate=function(startDate,endDate,index){
                if((startDate!=undefined||startDate!=null||startDate!='')||(endDate!=undefined||endDate!=null||endDate!='')){
                    var startDate1=parseInt(startDate.replace(/-/g,""),10);
                    var endDate1=parseInt(endDate.replace(/-/g,""),10);
                    if($scope.proposal.getDate(startDate1,endDate1)==-1){
                        layer.open({
                            /*offset: ['35%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '茬次起止日期必须在保险期间内!',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        });
                        $scope.proposal.prpTitemKindAgriDtoListCopy[index].stratDate="";
                        $scope.proposal.prpTitemKindAgriDtoListCopy[index].endDate="";
                    }else{
                        if(startDate1>endDate1||endDate1<startDate){
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '茬次起始日期不能晚于终止日期!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy[index].endDate="";
                        }
                    }
                }
            }

            //校验多条茬次信息时，日期不能有交叉
            $scope.changeDate1=function(date,index){
                if(date!=null && date !="" && $scope.proposal.prpTitemKindAgriDtoListCopy && $scope.proposal.prpTitemKindAgriDtoListCopy.length>0){
                    var timesDate=parseInt(date.replace(/-/g,""),10);
                    var flag=false;
                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto,index1) {
                        //var startDate1=parseInt(dto.stratDate.replace(/-/g,""),10);
                        var endDate1=parseInt(dto.endDate.replace(/-/g,""),10);
                        if(timesDate<=endDate1 && index!=index1){
                            flag=true;
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '第'+(index+1)+'茬次信息和第'+(index1+1)+'条茬次信息起始日期有交叉!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy[index].stratDate="";
                            return
                        }
                    });
                    if(flag==true){
                        return
                    }
                }else if(date==null && date =="" && !date){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '茬次起始日期不能为空!',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                    $scope.proposal.prpTitemKindAgriDtoListCopy[index].stratDate="";
                }
            }

            //校验多条茬次信息时，日期不能有交叉
            $scope.changeDate2=function(date,index){
                if(date!=null && date !="" && $scope.proposal.prpTitemKindAgriDtoListCopy && $scope.proposal.prpTitemKindAgriDtoListCopy.length>0){
                    var timesDate=parseInt(date.replace(/-/g,""),10);
                    var flag=false;
                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto,index1) {
                        //var startDate1=parseInt(dto.stratDate.replace(/-/g,""),10);
                        var endDate1=parseInt(dto.endDate.replace(/-/g,""),10);
                        if(timesDate<=endDate1 && index!=index1){
                            flag=true
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '第'+(index+1)+'茬次信息和第'+(index1+1)+'条茬次信息终止日期有交叉!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            $scope.proposal.prpTitemKindAgriDtoListCopy[index].endDate="";
                            return
                        }
                    });
                    if(flag==true){
                        return
                    }
                }else if(date==null && date =="" && !date){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '茬次终止日期不能为空!',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                    $scope.proposal.prpTitemKindAgriDtoListCopy[index].stratDate="";
                }
            }

            //种植时间校验
            $scope.compareraiseDate= function () {
                if(commonApiServ.compareFullDate($scope.proposal.prpTmainDto.startDate,$scope.proposal.prpTmainAgriDto.raiseDate)==1||commonApiServ.compareFullDate($scope.proposal.prpTmainAgriDto.raiseDate,$scope.proposal.prpTmainDto.endDate)==1){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        scrollbar: false,
                        title: '温馨提示',
                        content: '种养殖时间不在保险期限内,请确认！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    });
                }
            }


            $scope.checkItemKindAgri=function(){
                //查询标的险别关系表
                $$finder.find('queryFlag', {
                    "riskCode":$scope.proposal.prpTmainDto.riskCode,
                    "itemCodeList":$scope.itemCodeList,//标的代码集合itemListCodes
                    "kindCodeList": $scope.kindCodeList//险别
                }, {
                    success: function (data) {
                        //获取主险信息
                        var sumAmount=0;
                        var listMain=[];
                        angular.forEach($scope.proposal.prpTitemKindDtoList,function(dto) {
                            angular.forEach(data.content,function(dto1) {
                                if(dto.riskCode==dto1.riskCode && dto.kindCode==dto1.kindCode
                                    && dto.itemCode==dto1.itemCode && dto1.mainTimes=='1' ){
                                    listMain.push(dto);
                                    sumAmount+=parseFloat(dto.amount);
                                }
                            });
                        });

                        if(listMain.length<=0){
                            layer.open({
                                /* offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '主险中没有录入“蔬菜作物”标的信息时，不能录入茬次信息!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                            return false;
                        }else{
                            if($scope.sumDistributingRate()==false){
                                return ;
                            }
                        }

                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy,function(dto,index) {
                            if(dto.flag && dto.flag=="D"){
                             }else if(!dto.flag || dto.flag=="I") {
                                $scope.proposal.prpTitemKindAgriDtoListCopy[index].timesAmount = round(((parseFloat($scope.proposal.prpTitemKindAgriDtoListCopy[index].distributingRate) / 100) * sumAmount), 2);
                             }
                            })


                    },
                    error: function (e) {
                        options.error(e);
                    }
                });

            }
            $scope.$watch('init', function (newvalue) {
                if (newvalue) {
                    $scope.initdata()
                }
            })
            $scope.initdata = function () {
                $scope.riskCode = $scope.proposal.prpTmainDto.riskCode
            }

            1
            //茬次信息需获得的保险期间方法
            $scope.proposal.getDate=function(startDate,endDate){
                if(($scope.proposal.prpTmainDto.startDate==undefined||$scope.proposal.prpTmainDto.startDate==null||$scope.proposal.prpTmainDto.startDate=='')
                    ||($scope.proposal.prpTmainDto.endDate==undefined||$scope.proposal.prpTmainDto.endDate==null||$scope.proposal.prpTmainDto.endDate=='')){
                    return 1
                }
                var startDate1=parseInt($scope.proposal.prpTmainDto.startDate.replace(/-/g,""),10);
                var endDate1=parseInt($scope.proposal.prpTmainDto.endDate.replace(/-/g,""),10);
                if(startDate<startDate1||endDate>endDate1){
                    return -1
                }
                return 0
            }

            //为了匹配投保数量的单位(亩或者头) 而加的下拉框初始化查询
            $$finder.find('getOptionCodeTwo',{
                prpDcodeListDtoList:[{
                    "codeType": "Unit",
                    "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种方案,
                }]
            }, {
                success: function (data) {
                    var datas=data.content.prpDcodeListDtoList[0]
                    $scope.selectListData.unitList=datas.prpDcodeDtoList;
                },
                error: function (e) {
                    options.error(e);
                }
            });

            $scope.checkpolicyType = function () {
                if($scope.proposal.insureMainListDto.insureListCode){
                    var content="";
                    angular.forEach($scope.selectListData.policyTypeList, function (data) {
                        if(data.codeCode==$scope.proposal.prpTmainDto.policyType){
                            if((data.codeCName.indexOf("个体") > -1 && $scope.proposal.insureMainListDto.listTypeFlag!='大户')||(data.codeCName.indexOf("团体") > -1 &&$scope.proposal.insureMainListDto.listTypeFlag!='散户')){
                                content="投保方式与清单类型不匹配！";
                                return
                            }
                        }
                    })
                    if(content != ""){
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        })
                        $scope.mulitSelectPolicyType1($scope.proposal.prpTmainDto.riskCode, $scope.proposal.prpTmainDto.policyType);
                        /*$scope.proposal.prpTmainDto.policyType={};*/

                    }
                }

            }
            //缴费计划
            $scope.proposal.isHide=false;
            $scope.changeIsHide= function () {
                $scope.proposal.isHide=!$scope.proposal.isHide;
                if($scope.proposal.prpTitemKindDtoList.length<=0){
                    $scope.totalAmount=0;
                    $scope.totalPay=0;
                }
            }
            //补贴信息
            $scope.isHidesubsidy=false;
            $scope.changesubsidy= function () {
                $scope.isHidesubsidy=!$scope.isHidesubsidy;
            }
            $scope.mulitSelectPolicyType1 = function (reqData,selectCode) {
                selectCode = '';
                if(!$scope.initFlag){
                    $scope.proposal.prpTmainDto.policyType = '';
                    $scope.selectListData.policyTypeList= [];
                }
                $$finder.find('getOptionCodeTwo',{
                    prpDcodeListDtoList:[{
                        "codeType": "PolicyType",
                        "riskCode": reqData,//险种方案,
                        "hpFlag":0,//贫困标志TODO
                    }]
                }, {
                    success: function (data) {
                        data.content.prpDcodeListDtoList[0].prpDcodeDtoList.unshift({codeCode:'',codeCName:'--请选择--'});//添加默认值
                        $scope.selectListData.policyTypeList=data.content.prpDcodeListDtoList[0].prpDcodeDtoList;
                        $scope.proposal.prpTmainDto.policyType = selectCode;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            };
            // $scope.checkCustomerType =function () {
            //     var content='';
            //     if ($scope.proposal.prpTmainDto.policyType=='H11' && $scope.proposal.proposal.appliInsuredDto.insuredType!='1' ){
            //         content="个体投保-种植大户的客户类型必须为个人"
            //     }
            //     if ($scope.proposal.prpTmainDto.policyType=='H12' && $scope.proposal.proposal.appliInsuredDto.insuredType=='1' ){
            //         content="个体投保-专业合作组织的客户类型不能为个人"
            //     }
            //     if ($scope.proposal.prpTmainDto.policyType=='H24' && $scope.proposal.proposal.appliInsuredDto.insuredType!='2' ){
            //         content="个体投保-规模经营主体的清单类型必须为单位"
            //     }
            //     if ($scope.proposal.prpTmainDto.policyType=='H21' && $scope.proposal.proposal.appliInsuredDto.insuredType!='3' ){
            //         content="团体投保-统保的清单类型必须为非企业团体"
            //     }
            //     if ($scope.proposal.prpTmainDto.policyType=='H22' && $scope.proposal.proposal.appliInsuredDto.insuredType=='1' ){
            //         content="团体投保-专业合作组织的清单类型不能为个人"
            //     }
            //     if ($scope.proposal.prpTmainDto.policyType=='H23' && $scope.proposal.proposal.appliInsuredDto.insuredType!='3' ){
            //         content="团体投保-贫困户的清单类型必须为非企业团体"
            //     }
            //     if(content != ""){
            //         layer.open({
            //             offset: ['45%', '40%'],
            //             skin: 'large-layer-content',
            //             closeBtn: 0,
            //             title: '温馨提示',
            //             content: content,
            //             btn: ['确定'],
            //             btn1: function (index, layero) {
            //                 //按钮【按钮一】的回调
            //                 layer.close(index);
            //             },
            //          })
            //
            //     }
            //}
            //修改标的类别后费率的校验
            $scope.setagriUnitCost = function() {
                var riskCode = $scope.proposal.prpTmainDto.riskCode;//险别
                var classCode = $scope.proposal.prpTmainDto.classCode;//险种
                var unitAmount;//单位保险金额
                var rate;//费率
                if(classCode=='3204'&&riskCode=='0001') {
                    $scope.onlyShow = true;
                    unitAmount='12';//单位成本
                    rate='2.5';//费率
                }
                if(classCode=='3204'&&riskCode=='0002') {
                    $scope.onlyShow = true;
                    unitAmount='20';
                    rate='4';
                }
                if(classCode=='3204'&&riskCode=='0003') {
                    $scope.onlyShow = true;
                    unitAmount='60';
                    rate='4';
                }
                if(classCode=='3205'&&riskCode=='0001') {
                    $scope.onlyShow = true;
                    unitAmount='12';
                    rate='2.5';
                }
                if(classCode=='3205'&&riskCode=='0002') {
                    $scope.onlyShow = true;
                    unitAmount='20';
                    rate='4';
                }
                if(classCode=='3205'&&riskCode=='0003') {
                    $scope.onlyShow = true;
                    unitAmount='60';
                    rate='4';
                }
                $scope.prpTitemKind.unitAmount = unitAmount;//单位保险金额
                $scope.prpTitemKind.rate = rate;//费率
            }
            //校验险种然后直接带出费率
            $scope.getDration = function() {
                var riskCode = $scope.proposal.prpTmainDto.riskCode;//险种
                var unitAmount;//单位保险金额
                var rate;//费率
                var versionNo = $scope.proposal.prpTmainDto.versionNo;//条款
                var untilName;//投保单位名称
                var untilName1;
                var untilKindName;//投保数量名称
                /* add by zhouyou 20061016 begin  当为生猪屠宰险时，单位保额与费率直接带出来*/
                if(riskCode == '3203') {//2801//3203
                    untilName = '头';
                    untilKindName = "投保头数";
                    untilName1 = '头';
                    if(versionNo == "生猪屠宰条款一") {//生猪屠宰条款一//TK280120170015
                        unitAmount = 1;
                        rate = 100;
                    }
                    if(versionNo == "生猪屠宰条款二") {
                        unitAmount = 2;
                        rate = 100;
                    }
                }
                /* add by zhouyou 20061016 end*/
                /* add by zhouyou 20061017 begin  当为林业险时，费率直接带出来*/
                if(riskCode == "3105") {
                    untilName = '亩';
                    untilKindName = "投保面积";
                    untilName1 = '亩';
                    if(versionNo == "基本险1-3年") {
                        rate = 2;
                    }
                    if(versionNo == "基本险4-6年") {
                        rate = 1.50;
                    }
                    if(versionNo == "基本险7-9年") {
                        rate = 1.20;
                    }
                    if(versionNo == "基本险10年以上") {
                        rate = 1.00;
                    }
                    if(versionNo == "基本险当年移栽") {
                        rate = 2.00;
                    }
                    if(versionNo == "特约险1-3年") {
                        rate = 0.80;
                    }
                    if(versionNo == "特约险4-6年") {
                        rate = 1.00;
                    }
                    if(versionNo == "特约险7-9年") {
                        rate = 1.20;
                    }
                    if(versionNo == "特约险10年以上") {
                        rate = 1.50;
                    }
                    if(versionNo == "特约险当年移栽") {
                        rate = 1.50;
                    }
                }
                /* add by zhouyou 20061026 begin
                 当大棚花卉种植保险协议、蔬菜制种保险协议时，费率直接带出来
                 当为农村稻、麦、油菜场火灾保险协议时  单位保险金额直接带出来*/
                if(riskCode == "3109") {
                    if(versionNo == "引进温室花卉") {
                        rate = 5.00;
                    }
                    if(versionNo == "其他大棚花卉") {
                        rate = 6.00;
                    }
                    if(versionNo == "单体管棚(棚架)") {
                        rate = 2.00;
                    }
                    if(versionNo == "单体管棚(薄膜)") {
                        rate = 18.00;
                    }
                    if(versionNo == "A型连栋棚(棚架)") {
                        rate = 1.50;
                    }
                    if(versionNo == "A型连栋棚(薄膜)") {
                        rate = 18.00;
                    }
                    if(versionNo == "B型连栋棚(棚架)") {
                        rate = 1.00;
                    }
                    if(versionNo == "B型连栋棚(薄膜)") {
                        rate = 12.00;
                    }
                    if(versionNo == "引进温室(棚架)") {
                        rate = 0.50;
                    }
                    if(versionNo == "引进温室(薄膜)") {
                        rate = 7.00;
                    }
                }
                if(riskCode == "3111") {
                    rate = 100;
                    if(versionNo == "稻、麦、油菜") {
                        unitAmount = 0.50;
                    }
                    if(versionNo == "稻柴") {
                        unitAmount = 25.00;
                    }
                    if(versionNo == "麦柴") {
                        unitAmount = 15.00;
                    }
                    if(versionNo == "油菜柴") {
                        unitAmount = 10.00;
                    }
                }
                if(riskCode == "3112") {
                    rate = 8.00;
                }
                $scope.prpTitemKind.unitAmount = unitAmount;//单位保险金额
                $scope.prpTitemKind.rate = rate;//费率
                if(untilName){
                    $scope.prpTitemKind.untilName = "元/" + untilName;//单位名称
                    $scope.prpTitemKind.untilKindName = untilKindName;//投保数量单位名称
                    $scope.prpTitemKind.untilName1 = untilName1;
                } else {
                    $scope.prpTitemKind.untilName = "元/亩";//单位名称
                    $scope.prpTitemKind.untilName1 = '亩';
                    if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                        || $scope.proposal.prpTmainDto.riskCode=='3130'|| $scope.proposal.prpTmainDto.riskCode=='3134'
                        || $scope.proposal.prpTmainDto.riskCode=='3147'|| $scope.proposal.prpTmainDto.riskCode=='3141'
                        || $scope.proposal.prpTmainDto.riskCode=='3129'|| $scope.proposal.prpTmainDto.riskCode=='3102'
                        || $scope.proposal.prpTmainDto.riskCode=='3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
                        || $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
                        || $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode == '3149'){
                        $scope.prpTitemKind.untilKindName = "投保面积";
                        $scope.prpTitemKind.agriUnitCostMaintitle = '单位生产成本';
                        $scope.prpTitemKind.unitCostName = '元';
                        $scope.prpTitemKind.agriUnitOutputMaintitle="单位保险产量";
                        $scope.prpTitemKind.agriUnitOutputMainName="公斤";
                    }else if ($scope.proposal.prpTmainDto.riskCode=='3220' ||$scope.proposal.prpTmainDto.riskCode=='3233' ){
                        $scope.prpTitemKind.proportionName = '%';
                        $scope.prpTitemKind.unitCostName = '元/头';
                        $scope.prpTitemKind.agriUnitCostMaintitle = '何价投保';
                        $scope.prpTitemKind.untilKindName = "投保头数";
                        $scope.prpTitemKind.untilName = "元";
                        $scope.prpTitemKind.untilName1 = '头';
                    } else if( $scope.proposal.prpTmainDto.riskCode=='3224'){
                        $scope.prpTitemKind.untilKindName = "投保面积";
                        $scope.prpTitemKind.agriUnitCostMaintitle = '单位保险产量';
                        $scope.prpTitemKind.unitCostName = '斤';
                        $scope.prpTitemKind.agriUnitOutputMaintitle="单位保险产量";
                        $scope.prpTitemKind.agriUnitOutputMainName="斤";
                        $scope.prpTitemKind.deductibleRate=0.00;//每次事故免赔率
                        $scope.prpTitemKind.totalLossRatio=0.00;//全损损失率
                    }else if($scope.proposal.prpTmainDto.riskCode=='3237'){
                        $scope.prpTitemKind.untilName = "元/亩";
                        $scope.prpTitemKind.untilKindName = "投保面积";
                        $scope.prpTitemKind.untilName1 = '亩';
                        $scope.prpTitemKind.deductibleRate=0.00;//每次事故免赔率
                        $scope.prpTitemKind.totalLossRatio=0.00;//全损损失率
                    }else if($scope.proposal.prpTmainDto.riskCode=='3134'||$scope.proposal.prpTmainDto.riskCode=='3147'
                        || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
                        $scope.prpTitemKind.untilName = "元/亩";
                        $scope.prpTitemKind.untilKindName = "投保面积";
                        $scope.prpTitemKind.untilName1 = '亩';
                    }

                }
            }
            //查询短期费率
            var shortfalg=''
            $scope.getShortRate = function (a) {
                var arrayTableShortRate=new Array();
                var itemCode="";
                if($scope.proposal.prpTmainDto.riskCode=='3129'){
                    if($scope.prpTitemKind.itemCode=="ZZ100" || $scope.prpTitemKind.itemCode=="ZZ200"){
                        itemCode=$scope.prpTitemKind.itemCode;
                    }
                }
                //查询短期费率表
                $$finder.find("queryByRiskCodeAndItemCode",{
                    "riskCode":$scope.proposal.prpTmainDto.riskCode,
                    "itemCode":itemCode
                },{
                    success: function (data) {
                        arrayTableShortRate.push(0);
                        console.log(data);
                        angular.forEach(data.content, function (data) {
                            arrayTableShortRate.push(data.shortRate)
                        })
                        shortfalg=a
                        $scope.prpTitemKind.shortRate = getShortRate(a,arrayTableShortRate)
                    },
                    error: function (data) {
                    }
                });
            }
            //判断是否选择条款
            $scope.checkClauseCode=function(){
                if(!$scope.proposal.prpTmainDto.versionNo){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: "请先选择条款！",
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
            }
            $scope.proposal.changeData=function(){
                if(!shortfalg)return
                $scope.prpTitemKind.shortRate=getShortRate(shortfalg)
                $scope.adjustMun('shortRate')
            }

            var getShortRateMonth = function(strStartDate, strStartHour, strEndDate, strEndHour) {
                var startDate = new Date(strStartDate.replace(/-/, "/"));
                var endDate = new Date(strEndDate.replace(/-/, "/"));
                var intMonthCount = dateDiff(startDate, endDate, "M");
                var dbShortRate = 0;
                var strRiskCode = "PUB";
                var arrayMonthShortRate;
                strRiskCode = $scope.riskCode;
                startDate = startDate.getDate();
                endDate = endDate.getDate();
                //if (startDate == endDate && parseInt(strStartHour, 10) < parseInt(strEndHour, 10)) {
                //    intMonthCount = intMonthCount + 1;
                //}
                dbShortRate = intMonthCount / 12 * 100;
                return dbShortRate;
            }


            /*日比例*/
            //按日比例计算短期系数

            var getShortRateDay = function(strStartDate, strStartHour, strEndDate, strEndHour) {
                var startDate = new Date(strStartDate.replace("-", "/"));
                var endDate = new Date(strEndDate.replace("-", "/"));

                var intDays = dateDiff(startDate, endDate, "D");
                var intDaysInYear = 365;
                var dbShortRate = 0;

                if (strStartHour == "0" && strEndHour == "0")
                    intDays = intDays - 1;
                else if (strStartHour == "24" && strEndHour == "24")
                    intDays = intDays - 1;
                else if (strStartHour == "24" && strEndHour == "0")
                    intDays = intDays - 2;
                if (startDate.getTime() < new Date("2008/02/29").getTime() && endDate.getTime() > new Date("2008/02/29").getTime() && intDays > 365) {
                    intDaysInYear = 365;//国元的需求，所有分母都是365天
                }

                dbShortRate = intDays / intDaysInYear * 100;
                return dbShortRate;
            }
            var getShortRateTable = function(strStartDate, strStartHour, strEndDate, strEndHour, strRiskCode,arrayTableShortRate) {
                var startDate = new Date(strStartDate.replace("-", "/"));
                var endDate = new Date(strEndDate.replace("-", "/"));
                var intDays = dateDiff(startDate, endDate, "D");
                var intMonthCount = dateDiff(startDate, endDate, "M");
                var dbTableShortRate = 0;
                strRiskCode = strRiskCode == null ? "PUB" : strRiskCode;
                startDate = startDate.getDate();
                endDate = endDate.getDate();
                if (startDate == endDate && parseInt(strStartHour, 10) < parseInt(strEndHour, 10))
                    intMonthCount = intMonthCount + 1;
                //modify by fengbao 2008-8-19
                //if(strRiskCode=="3141"|| strRiskCode=="3140"){
                //    arrayTableShortRate = new Array(0,30,40,50,60,65,70,75,80,85,90,95,100);
                //}else{
                //    /*此处就是短期数组根据保险期限的月份数，查找对应的费率，比如保险期限为一个月（终止日期 - 起始日期）先取数组中下标为1的数字，如果保险期间为9个月，得出为85，然后按照下面的计算公式计算短期费率*/
                //    arrayTableShortRate = new Array(0,30, 40, 50, 60, 65, 70, 75, 80, 85, 90, 95, 100);//公用短期费率
                //}
                //dbTableShortRate=intMonthCount>12?100:arrayTableShortRate[intMonthCount];
                dbTableShortRate = Math.floor(intMonthCount / 12) * 100 + arrayTableShortRate[intMonthCount % 12];
                return dbTableShortRate;
            }
            //短期费率方式
            var getShortRate = function (n,arrayTableShortRate) {
                var strStartDate = $scope.proposal.prpTmainDto.startDate;
                var strStartHour = $scope.proposal.prpTmainDto.startHour;
                var strEndDate = $scope.proposal.prpTmainDto.endDate;
                var strEndHour = $scope.proposal.prpTmainDto.EndHour;
                if (n == 1) {
                    return commonApiServ.roundToFixed2(getShortRateTable(strStartDate, strStartHour, strEndDate, strEndHour, $scope.riskCode,arrayTableShortRate))
                }
                if (n == 2) {
                    return commonApiServ.roundToFixed2(getShortRateDay(strStartDate, strStartHour, strEndDate, strEndHour))
                }
                if (n == 3) {
                    return '100.00'
                }
                if (n == 4) {
                    return commonApiServ.roundToFixed2(getShortRateMonth(strStartDate, strStartHour, strEndDate, strEndHour))
                }
            }
            //月比例
            //短期费率表方式计算（对应原月短期费率）
            function dateDiff(dateStart, dateEnd, MD) {
                var i;
                //按天计算差
                if (MD == "D") {
                    var endTm = dateEnd.getTime();
                    var startTm = dateStart.getTime();
                    var diffDay = (endTm - startTm) / 86400000 + 1;
                    return diffDay;
                }
                else//按月计算差
                {
                    var endD = dateEnd.getDate();
                    var endM = dateEnd.getMonth();
                    var endY = dateEnd.getFullYear();
                    var startD = dateStart.getDate();
                    var startM = dateStart.getMonth();
                    var startY = dateStart.getFullYear();
                    if (endD > startD)
                    //跟终端版fcalc_month函数统一，endD>startD时才加1
                    {
                        return (endY - startY) * 12 + (endM - startM) + 1;
                    }
                    else {
                        return (endY - startY) * 12 + (endM - startM);
                    }
                }
            }

            /*
             * @desc 计算短期费率函数
             * @desc 注意脚本中的计算短期费率的函数需要和PubTools.java中相应的方法保持一致
             * @param1 strMode 短期费率方式
             * @param2 strStartDate 起始日期
             * @param3 strStartHour 起始小时数
             * @param4 strEndDate 终止日期
             * @param5 strEndHour 终止小时数
             * @return dbShortRate 短期费率
             */
            var getShortRateEndorse = function(strMode,strStartDate,strStartHour,strEndDate,strEndHour)
            {
                var dbShortRate = 0;
                var strRiskCode = "PUB";
                //当开始日期与终止日期同一天时，不计短期费率
                if(strStartDate==strEndDate && strStartHour==strEndHour)
                {
                    dbShortRate = 100;
                }
                if(parseInt(strMode,10)==1) //短期费率表方式
                {
                    dbShortRate = getShortRateTable(strStartDate,strStartHour,strEndDate,strEndHour,$scope.riskCode);
                }
                else if(parseInt(strMode,10)==2) //日比例
                {
                    dbShortRate = getShortRateDay(strStartDate,strStartHour,strEndDate,strEndHour);
                }
                else if(parseInt(strMode,10)==4) //月比例
                {
                    dbShortRate = getShortRateMonth(strStartDate,strStartHour,strEndDate,strEndHour);
                }
                else
                {
                    dbShortRate = 100;//不计或者按年计算
                }

                return dbShortRate;
            }

            //获取保费总额，附加险不计算在内
            var gettotalAmount = function () {
                $scope.totalAmount = 0;
                $scope.totalPay = 0;
                for (var i = 0; i < $scope.proposal.prpTitemKindDtoList.length; i++) {
                    if($scope.proposal.prpTitemKindDtoList[i].flag.substr(0,1)!="D"){
                        if ($scope.proposal.prpTitemKindDtoList[i].calculateFlag == "Y") {
                            $scope.totalAmount += parseFloat($scope.proposal.prpTitemKindDtoList[i].amount * 1);
                        }
                        $scope.totalPay += parseFloat($scope.proposal.prpTitemKindDtoList[i].premium * 1);
                    }
                }
                $scope.totalPay=round($scope.totalPay ,2);
                $scope.totalAmount=round($scope.totalAmount,2);
                //$scope.totalAmount = $rootScope.amount($scope.totalAmount);
                //$scope.totalPay = $rootScope.amount($scope.totalPay);
                if ($scope.proposal.prpModelMainSubDto) {
                    $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                    $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                }
                if ($scope.proposal.prpTmainDto) {
                    $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay;
                    $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                }
            }
            //获取显示信息
            var getephemeral = function (index, data) {
                for (var i = 0; i < data.length; i++) {
                    if (index == data[i].codeCode) {
                        return data[i].codeCName
                    }
                }
            }

            $$code.getCodes('codeType', 'ShortRateFlagMain', {}).then(function (data) {
                angular.forEach(data.prpDcodeListDtoList, function (data) {
                    if ('ShortRateFlagMain' == data.codeType) {
                        $scope.ephemeral = data.prpDcodeDtoList;
                        $scope.prpTitemKind.shortRate1 = data.prpDcodeDtoList[$scope.prpTitemKind.shortRateFlag].codeCName
                    }
                })
            })
            $scope.prpTitemKind.shortRate1 = '不计';
            //查询币别
            $scope.getCurrency = function (x) {
                //信达版本
                // $scope.proposal.prpTfeeDto.feeCurrencyName2 = x;
                //国元版本
                $scope.proposal.prpTmainDto.currency = $scope.proposal.prpTfeeDto.currency2;//主表需要获取汇总币别，用于保存
                $scope.currency2Name = x;
            }
            //币别信息中的保费计算
            //第四步回写
            var refreshPlanByPayTimes = function () {
                if($scope.proposal.prpTmainDto.payTimes && $scope.proposal.prpTmainDto.payTimes>0){
                    $scope.changePayTplan($scope.proposal.prpTmainDto.payTimes)
                }else{
                    $scope.changePayTplan(1)
                }

            }
            //第三步币别信息表回写
            function getCollectItemKindFee() {
                var ExchangeDate = new Date();
                var ExchangeD = ExchangeDate.getDate();
                var ExchangeM = ExchangeDate.getMonth() + 1;
                var ExchangeY = ExchangeDate.getFullYear();
                var exchangeDate = ExchangeY + "-" + ExchangeM + "-" + ExchangeD;
                //币别兑换率查询
                $$finder.find('getExchangeRate', {
                    "iBaseCurrency": $scope.proposal.prpTfeeDto.currency2,//汇总币别
                    "iExchCurrency": $scope.proposal.prpTfeeDto.currency1,//支付币别
                    "iExchDate": exchangeDate//当前汇率查询时间
                }, {
                    success: function (data) {
                        var exchangeRate = data.content.exchangeRate;
                        //支付币别兑换率
                        $scope.proposal.prpTfeeDto.exchangeRate1 = exchangeRate;
                        //汇总币别兑换率
                        $scope.proposal.prpTfeeDto.exchangeRate2 = exchangeRate;
                        if (exchangeRate) {
                            //原币
                            $scope.proposal.prpTfeeDto.currency =  $scope.proposal.prpTfeeDto.currency2
                            //原总保额
                            $scope.proposal.prpTfeeDto.amount = round($scope.totalAmount,2);
                            //原总保费
                            $scope.proposal.prpTfeeDto.premium = round($scope.totalPay,2);
                            //支付总保费
                            $scope.proposal.prpTfeeDto.premium1 = round($scope.totalPay * $scope.proposal.prpTfeeDto.exchangeRate1,2);
                            //支付总保额
                            $scope.proposal.prpTfeeDto.amount1 = round($scope.totalAmount * $scope.proposal.prpTfeeDto.exchangeRate1,2);
                            //汇总中保费
                            $scope.proposal.prpTfeeDto.premium2 = round($scope.totalPay * exchangeRate,2);
                            //汇总总保额
                            $scope.proposal.prpTfeeDto.amount2 = round($scope.totalAmount * $scope.proposal.prpTfeeDto.exchangeRate2,2);
                        }
                        dealTMainForYGZFromPage();
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }

            //价税分离查询
            function dealTMainForYGZFromPage() {
                var ItemKindMainAndSub = getItemKindMainAndSub();
                var itemkind = ItemKindMainAndSub.itemkind || "";//主险个数
                var itemkindSub = ItemKindMainAndSub.itemkindSub || "";//附加险个数
                var strBizType = $stateParams.bizType;//获取编辑类型
                //主险险别转化
                var kindCodeArray=[];
                var itemKindNoArray=[];
                var premiumArray=[];
                angular.forEach($scope.proposal.prpTitemKindDtoList,function(data,index){
                    kindCodeArray.push(data.kindCode);
                    itemKindNoArray.push(data.itemKindNo);
                    premiumArray.push(data.premium);

                })
                var kindCodeStr=kindCodeArray.join('|');
                var itemKindNoMainStr = itemKindNoArray.join('|');
                var premiumMainStr = premiumArray.join('|');
                $$finder.find('dealTMainForYGZFromPage', {
                    //"riskCode": $scope.proposal.prpTmainDto.riskCode,//险种//$scope.proposal.prpTmainDto.classCode
                    //"comCode": $scope.proposal.prpTmainDto.comCode,//归属机构代码//3400009900//$scope.proposal.prpTmainDto.comCode
                    //"kindCodeMainStr":kindCodeStr+ "|",//主险险别//itemkind[0].kindCode+"|"||""
                    //"itemKindNoMainStr": itemkind[0].itemKindNo + "|" || "",//主险序号
                    //"mainCounts": itemkind.length || "",//主险个数
                    //"premiumMainStr": itemkind[0].premium + "|" || "",//主险保费
                    //"kindCodeSubStr": "",//附加险险别
                    //"PremiumSubStr": "",//附加险保费
                    //"subCounts": itemkindSub.length,//附加险个数
                    //"itemKindNoSubStr": ""//附加险序号
                    //-------由于取附加险得值不好取，所以将附加险与主险数据放在一起进行价税分离-------------------------
                    "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种//$scope.proposal.prpTmainDto.classCode
                    "comCode": $scope.proposal.prpTmainDto.comCode,//归属机构代码//3400009900//$scope.proposal.prpTmainDto.comCode
                    "kindCodeMainStr":kindCodeStr+ "|",//主险险别//itemkind[0].kindCode+"|"||""
                    "itemKindNoMainStr": itemKindNoMainStr + "|" || "",//主险序号
                    "mainCounts": kindCodeArray.length || "",//主险个数
                    "premiumMainStr": premiumMainStr + "|" || "",//主险保费
                    "kindCodeSubStr": "",//附加险险别
                    "PremiumSubStr": "",//附加险保费
                    "subCounts": 0,//附加险个数
                    "itemKindNoSubStr": ""//附加险序号
                    //-------由于取附加险得值不好取，所以将附加险与主险数据放在一起进行价税分离-------------------------
                }, {
                    success: function (data) {
                        if(strBizType == "ENDORSE_TYPE"){
                            refreshPlanForEndorse();
                        }else{
                            refreshPlanByPayTimes();
                        }
                        $scope.proposal.prpTfeeDto.noTaxPremium = round(data.content.sumNoTaxPremium,2);//不含税保费
                        $scope.proposal.prpTfeeDto.taxFee = round(data.content.sumTaxFee,2);
                        //支付币别不含税保费
                        $scope.proposal.prpTfeeDto.noTaxPremium1 = round(data.content.sumNoTaxPremium * $scope.proposal.prpTfeeDto.exchangeRate1,2);
                        //支付币别税额
                        $scope.proposal.prpTfeeDto.taxFee1=data.content.sumTaxFee!="0.00"?round(data.content.sumTaxFee * $scope.proposal.prpTfeeDto.exchangeRate1,2):'0.00';
                        //汇总币别不含税保费
                        $scope.proposal.prpTfeeDto.noTaxPremium2 = round(data.content.sumNoTaxPremium * $scope.proposal.prpTfeeDto.exchangeRate2,2);
                        //汇总币别税额
                        $scope.proposal.prpTfeeDto.taxFee2 =data.content.sumTaxFee!="0.00"?round(data.content.sumTaxFee * $scope.proposal.prpTfeeDto.exchangeRate2,2):"0.00";
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }


            //批改时刷新
            var refreshPlanForEndorse = function(){
                if($scope.blPolicyInfoConvertCopy){
                    var dbPremium1Old = 0;//原保单保费（不包含清单修改）
                    var dbPremium1New = 0;//保单批改后新保费
                    var dbSumPremium1Old = 0;
                    var dbSumPremium1New = 0;
                    var dbChgPremium1 = 0;
                    var intRowsCount = 0;
                    var subsidyCount = 0;
                    var Premiumold = 0;//原保单保费（不包含清单修改）
                    var Premiumnew = $scope.totalPay;//保单批改后新保费

                    //此处需要遍历如果是本次批改中新增的缴费批次，则删除

                    angular.forEach($scope.blPolicyInfoConvertCopy.prpTplanDtoList,function(data, index, array){
                        dbPremium1Old = data.planFee;
                        dbSumPremium1Old = dbSumPremium1Old+dbPremium1Old;
                    })
                    // angular.forEach($scope.proposal.prpTfeeDto,function(data, index, array){

                    dbPremium1New = $scope.proposal.prpTfeeDto.premium1;
                    dbSumPremium1New = dbSumPremium1New+dbPremium1New;
                    //})

                    dbChgPremium1 = round((dbSumPremium1New-dbSumPremium1Old),2);


                    var payTimes = $scope.proposal.prpTmainDto.payTimes;

                    if(dbChgPremium1!=0){
                        var dbSubsidyPremium1Old=0;//原保单补贴金额
                        var dbSubsidyPremium1New=0;//批改后补贴金额
                        dbPremium1Old=0;
                        dbPremium1New=0;
                        var subsidyList = []; // 补贴list
                        var paymentList = []; // 自缴list

                        angular.forEach($scope.blPolicyInfoConvertCopy.prpTsubsidyDtoList,function(data, index, array){
                            dbSubsidyPremium1Old = data.subsidyPremium;
                            dbPremium1Old = dbPremium1Old+dbSubsidyPremium1Old;
                        })

                        angular.forEach($scope.proposal.prpTsubsidyDtoList,function(data, index, array){
                            dbSubsidyPremium1New = data.subsidyPremium;
                            dbPremium1New = round(dbPremium1New+dbSubsidyPremium1New,2);

                        })

                        angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {

                            if (data.payReason == 'R10'&&data.newAddFlag!='1') { // 自定义标志；标识以区分政府补贴信息自缴部分
                                paymentList.push(data);
                            }else if(data.payReason == 'R20'&&data.newAddFlag!='1') {
                                paymentList.push(data);
                            }else if(data.newAddFlag!='1'){
                                subsidyList.push(data);
                            }

                        });
                        Premiumold = $scope.blPolicyInfoConvertCopy.prpTmainDto.sumPremium;
                        var premiumchge = round(Premiumnew-Premiumold,2);//保费变化值
                        var subsidychge =  round(dbPremium1New-dbPremium1Old,2);//补贴变化值
                        var subsidychgeGov = 0;//各类补贴临时变量
                        var subsidychgeSum = 0;//用于计算最后一条补贴缴费金额使用
                        if(premiumchge!=subsidychge){

                            //先删除本次批改中手动增加的，后面会根据变化量自动增加一条
                            angular.forEach($scope.proposal.prpTplanDtoList,function(data, index){
                                if(data.newAddFlag && data.newAddFlag ==="1"){
                                    $scope.proposal.prpTplanDtoList.splice(index,1);
                                }
                            });

                            var newObject = {
                                "payReasonName":paymentList[0].payReasonName,
                                "payReason": "自缴保费",
                                "planStartDate": "",
                                "planDate": "",
                                "planFee": "",
                                "delinquentFee": "",
                                "palnRealFee": "",
                                "newAddFlag":"",
                                "flag":"I",
                                "serialNo":"",
                                "payNo":"1",
                                "policyNo":$scope.proposal.prpTplanDtoList[0].policyNo,
                                "currency":$scope.proposal.prpTfeeDto.currency1,
                            };
                            if(dbChgPremium1 > 0){
                                newObject.payReason = 'R30';//加保/加费-保费
                            }else{
                                newObject.payReason = 'P40';//批减保费
                            }

                            newObject.payReason = '1';
                            newObject.planStartDate = $stateParams.validDate;
                            newObject.planDate = $stateParams.validDate;
                            newObject.planFee = round(premiumchge-subsidychge,2);
                            newObject.delinquentFee = round(premiumchge-subsidychge,2);
                            newObject.palnRealFee = "0.00";
                            newObject.newAddFlag = "1";
                            paymentList.push(angular.copy(newObject));

                            if(subsidychge!=0){

                                //缴费起期
                                //fm.GovPlanStartDate[intRowsCount].value = fm.StartDate.value;
                                //缴费止期
                                //fm.GovPlanDate[intRowsCount].value = fm.EndDate.value;
                                //缴费原因

                                var govPlanObject = {
                                    "payReasonName":subsidyList[0].payReasonName,
                                    "payReason": "",
                                    "planStartDate": "",//缴费起期
                                    "planDate": "",//缴费止期
                                    "currency": "",//币别
                                    "planFee": "",//应缴金额
                                    "delinquentFee": "",//拖欠金额
                                    "palnRealFee": "",//实缴金额
                                    "newAddFlag":"1",
                                    "flag":"I",
                                    "policyNo":$scope.proposal.prpTplanDtoList[0].policyNo,
                                    "serialNo":"",
                                    "payNo":"1",
                                }
                                subsidyCount = $scope.blPolicyInfoConvertCopy.prpTsubsidyDtoList.length;
                                angular.forEach($scope.blPolicyInfoConvertCopy.prpTsubsidyDtoList,function(data, index, array){
                                    angular.forEach($scope.proposal.prpTsubsidyDtoList,function(newData, newIndex, array){

                                        if(newData.subsidyCode == data.subsidyCode&&index==newIndex){
                                            subsidychgeGov = newData.subsidyPremium - data.subsidyPremium;
                                            if (data.subsidyCode == "03") {
                                                govPlanObject.payReason = "RS3";//中央财政
                                            }
                                            if (data.subsidyCode == "04") {
                                                govPlanObject.payReason = "RS4";//省级财政
                                            }
                                            if (data.subsidyCode == "05") {
                                                govPlanObject.payReason = "RS5";//地市财政
                                            }
                                            if (data.subsidyCode == "06") {
                                                govPlanObject.payReason = "RS6";//其他来源
                                            }
                                            if (data.subsidyCode == "07") {
                                                govPlanObject.payReason = "RS7";//县(区)财政
                                            }
                                            //币别
                                            govPlanObject.currency = $scope.proposal.prpTfeeDto.currency1;

                                            //应缴金额,最后一条记录的值为总保费减中的汇总金额，避免一分钱问题
                                            if(subsidyCount == index){
                                                govPlanObject.planFee = subsidychge-subsidychgeSum;
                                                govPlanObject.delinquentFee = round(subsidychgeGov,2);
                                            }else{
                                                govPlanObject.planFee = round(subsidychgeGov,2);
                                                govPlanObject.delinquentFee = round(subsidychgeGov,2);
                                                subsidychgeSum += subsidychgeGov;
                                            }
                                            //实缴金额（肯定为0）
                                            govPlanObject.palnRealFee = "0.00";
                                            govPlanObject.planStartDate = $scope.proposal.prpTmainDto.startDate;
                                            govPlanObject.planDate = $scope.proposal.prpTmainDto.endDate;
                                            subsidyList.push(angular.copy(govPlanObject));
                                        }
                                    })
                                })
                            }
                            $scope.proposal.prpTplanDtoList = subsidyList.concat(paymentList);
                        }
                    }else {//如果保费没有变化，删除新增的
                        angular.forEach($scope.proposal.prpTplanDtoList,function(item,index){
                            if(item.newAddFlag && item.newAddFlag ==="1"){
                                $scope.proposal.prpTplanDtoList.splice(index,1);
                            }
                        });
                    }
                }
            }


            //清单号查询弹层
            $scope.relationListNoLayer = false;
            $scope.closeRelationListLayer2= function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//隐藏滚动条
            }
            //点击x号或者确定关闭用户清单查询页面
            $scope.closeRelationListNoLayer2= function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//隐藏滚动条
            }

            //确定按钮
            $scope.closeRelationListNoLayer = function () {
                $scope.relationListNoLayer = false;
                $("html,body").css({overflow:"auto"});//隐藏滚动条

            }
            //合同信息 的收缩按钮
            $scope.isHidestretch=true;
            $scope.stretch= function () {
                $scope.isHidestretch=!$scope.isHidestretch;
            }
            //养殖地点 的收缩按钮
            $scope.isHideaddress=true;
            $scope.addressHide= function () {
                $scope.isHideaddress=!$scope.isHideaddress;
            }
            //币别信息 收缩按钮
            $scope.isHidemesSign=true;
            $scope.mesSignIsHide= function () {
                $scope.isHidemesSign=!$scope.isHidemesSign;
            }
            //清单号查询按钮
            $scope.queryRelationListNoLayer = function (num) {
                $scope.proposal.insureMainListDto.insureListCode = $scope.proposal.insureMainListDto.insureListCode || num
                if ($scope.proposal.insureMainListDto.insureListCode) {
                    $scope.relationListNoLayer = true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    $$finder.find("findGisFarmerListByInsureListCodeAndserialNo",{
                        "insureListCode":$scope.proposal.insureMainListDto.insureListCode,
                        "serialNo":$scope.proposal.insureMainListDto.serialNo,
                        'pageNo':$scope.paginationConfmm2.currentPage,
                        'pageSize':$scope.paginationConfmm2.itemsPerPage
                    },{
                        success: function (data) {
                            console.log(data);
                            $scope.gisFarmerListDtoList=data.content.gisFarmerListDtoList;
                            $scope.paginationConfmm2.totalItems=data.content.count;
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
                } else {
                    $scope.relationListQueryLayer = true;
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

            //获得主险和附加险的集合
            function getItemKindMainAndSub() {
                var arrayItem = {};
                var itemkind = new Array();
                var itemkindSub = new Array();
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    if (data.radioType == 'Y') {
                        itemkind.push(data);
                    } else {
                        itemkindSub.push(data);
                    }
                })
                arrayItem.itemkind = itemkind;
                arrayItem.itemkindSub = itemkindSub;
                return arrayItem;
            }

            //第二大步 计算每个险别的基准保费 计算险别保费与总保费
            function calculatePremiumMainBack() {
                var basePremium;//基准保费
                var SumBenMarkPremium = 0;//总保费
                //$scope.selfPremium=0;//自缴保费
                $scope.adjustRateMain = 0;//每个险别的无赔款优待金额
                $scope.insureRate = 1;//投保比例
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    //重新计算短期费率
                    //data.shortRate = getShortRate(data.shortRateFlag);
                    //基准保费计算   基准保费根据公式计算：保额*费率/短期费率除数（从数据库中取）*短期费率/100-每个险别的无赔款优待金额
                    basePremium = data.amount * data.rate / $scope.rateDivisor * data.shortRate / 100 - $scope.adjustRateMain;
                    data.basePremium = basePremium;
                    console.log('基准保费'+basePremium)
                    //自缴保费=基准保费*自缴比例*投保比例
                    data.selfPremium = basePremium * 10000 * $scope.selfRate * $scope.insureRate / 100 / 10000;
                    //补贴保费=基准保费*总补贴比例
                    data.subsidyPremium = parseFloat(basePremium * 10000 * $scope.govRate / 100 / 10000);
                    //险别保费=自交保费+补贴保费
                    data.premium =round(data.selfPremium + data.subsidyPremium,2);
                });
                //重新计算总保费
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    SumBenMarkPremium += parseFloat(data.premium);
                });
                $scope.totalPay = round(SumBenMarkPremium,2);//总保费
                if($scope.proposal.prpModelMainSubDto){
                    $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;//总保费
                }
                if($scope.proposal.prpTmainDto){
                    $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay;
                }


                console.log(SumBenMarkPremium)
                sumBenchMarkPreimum();//计算总的基准保费用来计算补贴金额
            }
            //getFee保费计算的第二个接口  回写主险、附加险、补贴金额
            function getFee() {
                $$finder.find('currencyEnsure', {
                    "gisInusrelistcode": $scope.proposal.insureMainListDto.insureListCode,//金禾清单号  查询出来的
                    "inusrelistcode": $scope.proposal.prpTmainAgriDto.relationListNo,//我方清单号 自动生成的
                    "flag": "getFee",
                    "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种代码
                    "serialNo":$scope.proposal.insureMainListDto.serialNo,//金禾获取
                    "itemListCodes":$scope.itemListCodesList,//标的清单编号["20180119000001121"]
                    "itemCodeList": $scope.itemCodeList,//标的代码集合itemListCodes
                    "kindCodeList": $scope.kindCodeList//险别
                }, {
                    success: function (data) {
                        console.log(data)
                        //承保数量
                        var statQuantity=0;
                        var riskCode=$scope.proposal.prpTmainDto.riskCode;
                        angular.forEach(data.content.bigList,function(data1,index1){
                            if(prpDkindItemAgriList && prpDkindItemAgriList.length>0){
                                angular.forEach(prpDkindItemAgriList,function(prpDkindItemAgri,index2){
                                    if(riskCode == prpDkindItemAgri.riskCode && data.content.kindCodeList[index1]==prpDkindItemAgri.kindCode
                                        && data.content.itemCodeList[index1]==prpDkindItemAgri.itemCode && prpDkindItemAgri.flag=='1'){
                                        statQuantity += parseFloat(data1);
                                    }
                                });
                            }
                        })
                        $scope.proposal.prpTmainDto.statQuantity=round(statQuantity,2);
                        //农户户次
                        $scope.proposal.prpTmainDto.sumInsured = data.content.count;
                        //$scope.totalPay=data.content.fPremium;//总保费
                        angular.forEach($scope.proposal.prpTitemKindDtoList, function (data2, index) {
                            if((data2.replyNo===data.content.itemListCodes[index]) && data2.kindCode===data.content.kindCodeList[index]){
                                data2.agriGrossQuantityMain = data.content.bigList[index];//投保面积
                                data2.quantity=data.content.bigList[index];//梳理数量  隐藏字段
                            }
                            if((data2.replyNo===data.content.itemListCodes[index]) && data2.kindCode===data.content.kindCodeList[index] && data2.kindCode=="3129M002" ){
                                data2.rate=round((data.content.sumPremiumList[index]/data2.unitAmount)*100,2);
                            }
                            data2.amount =  round(commonApiServ.billNum(data2.unitAmount * data2.agriGrossQuantityMain),2)
                            if((data2.replyNo===data.content.itemListCodes[index]) && data2.kindCode===data.content.kindCodeList[index] && data2.kindCode=="3129M003" ){
                                data2.amount=round(data.content.sumPremiumList[index]/(data2.rate/100),2);
                            }
                        })
                        gettotalAmount();//重新计算保额
                        calculatePremiumMainBack();//计算每个险别的基准办法来计算险别保费
                        if($scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
                            $scope.checkItemKindAgri();//茬次信息
                        }

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //保存时获取的老数据
            var proposalDtoConvertEndorseDto = function (proposalDto) {
                var endorseDto = {};
                proposalDto = angular.copy(proposalDto);
                if (proposalDto) {
                    //var responseQueryPolicyInfoDto =  data.responseQueryPolicyInfoDto;
                    endorseDto.prpCinsuredDtoList=[];
                    endorseDto.prpCaddressDtoList=[];
                    endorseDto.prpCfeeDtoList=[];
                    //基本信息转换
                    endorseDto.prpCmainDto = proposalDto.prpTmainDto;
                    endorseDto.prpCmainDto.sumPremium=0;
                    angular.forEach(proposalDto.prpTitemKindDtoList,function(item,index){
                        endorseDto.prpCmainDto.sumPremium+= parseFloat(item.premium);
                    });
                    endorseDto.prpCmainDto.operateDate = proposalDto.prpTmainDto.operateDate;
                    $scope.parameterConvert.businessCategorySubmit();
                    //合同信息
                    endorseDto.prpCmainAgriDto=proposalDto.prpTmainAgriDto;
                    endorseDto.prpCmainAgriDto.raiseDate=proposalDto.prpTmainAgriDto.raiseDate;
                    endorseDto.prpCmainAgriDto.policyNo=proposalDto.prpTmainAgriDto.policyNo;
                    endorseDto.prpCaddressDtoList[0]=proposalDto.prpTaddressDto;
                    if(proposalDto.plantingPolicyListDtoList!=undefined){
                        endorseDto.plantingPolicyListDtoList=proposalDto.plantingPolicyListDtoList;
                    }
                    endorseDto.prpCitemKindDtoList=proposalDto.prpTitemKindDtoList;
                    //用于茬次信息
                    var riskCode="";
                    //var itemKindNo="";
                    var kindCode="";
                    angular.forEach($scope.proposal.prpTitemKindDtoList,function(data,index){
                        data.calculateFlag=data.radioType;//prpTitemKindDtoList标识位
                        if(data.radioType==='Y') {
                            riskCode = data.riskCode;
                            //itemKindNo = data.itemKindNo;
                            kindCode = data.kindCode;
                        }
                    })

                    var prpTitemKindAgriDtoList=prpTitemKindAgriDtoList||[];
                    angular.forEach(proposalDto.prpTitemKindAgriDtoList,function(item){
                        if ((item.distributingRate == null && item.distributingRate == undefined)
                            && (item.timesAmount == null && item.timesAmount == undefined)) {
                            prpTitemKindAgriDtoList.push(item);
                        }
                    })
                    endorseDto.prpCitemKindAgriDtoList=prpTitemKindAgriDtoList;
                    endorseDto.prpCsubsidyDtoList=proposalDto.prpTsubsidyDtoList;
                    endorseDto.prpCfeeDtoList[0]=proposalDto.prpTfeeDto;
                    //endorseDto.prpCitemKindAgriDtoList[0].flag='U1';
                    //endorseDto.prpPheadDto.makeCom=$rootScope.user.makeCom;
                    endorseDto.prpCmainDto.makeCom=$rootScope.user.makeCom;

                    //endorseDto.endorseConditionDto.endoretype=$stateParams.endorseType;
                    endorseDto.prpCmainAgriDto.raiseSite=proposalDto.prpTaddressDto.addressName;
                    endorseDto.prpCmainDto.systemFlag='agri';
                    //特约信息
                    var prpCengageDtoList=prpCengageDtoList||[]
                    angular.forEach(proposalDto.prpTengageDtoCopy,function(item,index){
                        var obj = angular.copy(item);
                        obj.serialNo = proposalDto.prpTengageDtoCopy.length;//序号不能从0开始所以加1
                        obj.lineNo = 1;//换行
                        obj.titleFlag = 0;
                        obj.policyNo= endorseDto.prpCmainDto.policyNo;
                        obj.riskCode= endorseDto.prpCmainDto.riskCode;
                        obj.flag = obj.flag;
                        prpCengageDtoList.push(obj);
                        if(item.clausesContent) {//如果内容里有东西
                            var obj = angular.copy(item);
                            obj.serialNo = proposalDto.prpTengageDtoCopy.length - 1;
                            obj.lineNo = 2;//换行
                            obj.titleFlag = 1;
                            obj.flag = obj.flag;
                            obj.clauses = obj.clausesContent;//把内容放入名称属性中
                            obj.policyNo = endorseDto.prpCmainDto.policyNo;
                            obj.riskCode = endorseDto.prpCmainDto.riskCode;
                            prpCengageDtoList.push(obj);
                        }
                    })
                    if(prpCengageDtoList.length>0){
                        endorseDto.prpCengageDtoList=prpCengageDtoList;
                    }

                    endorseDto.prpCplanDtoList=proposalDto.prpTplanDtoList;
                    if(proposalDto.prpTexpenseDto){
                        endorseDto.prpCexpenseDto=proposalDto.prpTexpenseDto;
                    }
                    angular.forEach(endorseDto.prpCplanDtoList,function(data,index){
                        endorseDto.prpCplanDtoList[index].planStartDate = proposalDto.prpTplanDtoList[index].planStartDate;
                        //endorseDto.prpCplanDtoList[index].planDate = proposalDto.prpCplanDtoList[index].planDate;
                    });
                    //客户信息
                    endorseDto.prpCinsuredDtoList[0]=proposalDto.appliInsuredDto;
                    endorseDto.prpCinsuredDtoList[1]=proposalDto.insuredDto;
                    // angular.forEach(proposalDto.prpTinsuredDtoList,function(data){
                    //     //          data.proposalNo= proposalDto.prpTfeeDto.proposalNo
                    //     // data.riskCode= proposalDto.prpTfeeDto.riskCode
                    //     // if(data.insuredFlag === "2"){
                    //     //     endorseDto.appliInsuredDto = data;
                    //     // }else if(data.insuredFlag === "1"){
                    //     //     endorseDto.insuredDto = data;
                    //     // }
                    // });
                    if(proposalDto.prpDcustomerTaxPayInfoDto!=undefined){
                        endorseDto.prpDcustomerTaxPayInfoDto = proposalDto.prpDcustomerTaxPayInfoDto;
                    }
                    //其他信息转换

                    endorseDto.prpCcoinsDtoList = proposalDto.prpTcoinsDto;
                    endorseDto.prpCcoinsDetailDtoList = proposalDto.prpTcoinsDetailDto;
                    endorseDto.prpCplanCoinsDtoList = proposalDto.prpTplanCoinsDtoList;
                    if($scope.approvalPageFlag==true){
                        if(proposalDto.prpTmainDto.policySort=="普通"){
                            proposalDto.prpTmainDto.policySort="0"
                        }else if(proposalDto.prpTmainDto.policySort=="定额"){
                            proposalDto.prpTmainDto.policySort="1"
                        }
                        if(proposalDto.prpTmainDto.language=="中文"){
                            proposalDto.prpTmainDto.language="C"
                        }else if(proposalDto.prpTmainDto.language=="英文"){
                            proposalDto.prpTmainDto.language="E"
                        }else if(proposalDto.prpTmainDto.language=="其语种他"){
                            proposalDto.prpTmainDto.language="Z"
                        }
                    }
                    //茬次此信息
                    //var prpCitemKindAgriDtoList=prpCitemKindAgriDtoList||[]
                    if(proposalDto.prpTmainDto.riskCode=='3134' || proposalDto.prpTmainDto.riskCode=='3147'||proposalDto.prpTmainDto.riskCode=='3141' || proposalDto.prpTmainDto.riskCode=='3102'){
                        var times=0
                        angular.forEach(proposalDto.prpTitemKindAgriDtoListCopy,function(dto){
                            dto.policyNo=proposalDto.prpTmainDto.policyNo;
                            dto.riskCode=riskCode;
                            //dto.itemKindNo=itemKindNo;
                            dto.kindCode=kindCode;
                            if(isNaN(dto.times)){
                                dto.times=0;
                            }
                            times=times+1;
                            dto.times=times;
                            dto.flag=dto.flag
                            endorseDto.prpCitemKindAgriDtoList.push(dto);
                        });
                    }

                }
                return endorseDto
            };

            function getEndorseFee(){
                $scope.proposal.doSaveFlag=true;
                if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                    || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                    || $scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'
                    ||$scope.proposal.prpTmainDto.riskCode=='3237'||$scope.proposal.prpTmainDto.riskCode=='3101'
                    ||$scope.proposal.prpTmainDto.riskCode=='3114'||$scope.proposal.prpTmainDto.riskCode=='3122'
                    ||$scope.proposal.prpTmainDto.riskCode=='3126'||$scope.proposal.prpTmainDto.riskCode=='3161'
                    ||$scope.proposal.prpTmainDto.riskCode=='3149'){
                    return;
                }
                var endorseDto={};
                endorseDto = $scope.blEndorseInfoListingConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoListingConvertCopyDTO);
                $scope.blEndorseInfoOriginConvertCopyDTO = proposalDtoConvertEndorseDto($scope.blPolicyInfoOriginConvertCopyDTO);
                var endorseNewDto = {
                    blPolicyInfoDtoNew:endorseDto,
                    blPolicyInfoDtoOld:$scope.blEndorseInfoOriginConvertCopyDTO,
                    blEndorseDto: $scope.blEndorseDto
                }
                endorseNewDto.blEndorseDto.prpPheadDto.validDate = $stateParams.validDate//批改生效日期
                endorseNewDto.blEndorseDto.prpPheadDto.validHour = '0';//生效小时
                angular.forEach(endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList,function(item){
                    if(item.policyNo==null||item.policyNo==""||item.policyNo==undefined){
                        endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDetailDtoList=[];
                        endorseNewDto.blPolicyInfoDtoNew.prpCcoinsDtoList=[];
                    }
                });
                $$finder.find('calFee', endorseNewDto, {
                    success: function (data) {
                        console.log(data)
                        angular.forEach(data.content.blPolicyInfoDtoNew.prpCfeeDtoList, function (_data,inde1) {
                            _data.amount=round1(_data.amount,2);
                            _data.premium=round1(_data.premium,2);
                            _data.amount1=round1(_data.amount1,2);
                            _data.premium1=round1(_data.premium1,2);
                            _data.amount2=round1(_data.amount2,2);
                            _data.premium2=round1(_data.premium2,2);
                        });
                        $scope.proposal.prpTfeeDto.currency=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].currency;
                        $scope.proposal.prpTfeeDto.amount=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].amount;
                        $scope.proposal.prpTfeeDto.premium=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].premium;
                        $scope.proposal.prpTfeeDto.noTaxPremium=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].noTaxPremium;
                        $scope.proposal.prpTfeeDto.taxFee=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].taxFee;
                        $scope.proposal.prpTfeeDto.exchangeRate2=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].exchangeRate2;
                        $scope.proposal.prpTfeeDto.amount2=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].amount2;
                        $scope.proposal.prpTfeeDto.premium2=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].premium2;
                        $scope.proposal.prpTfeeDto.noTaxPremium2=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].noTaxPremium2;
                        $scope.proposal.prpTfeeDto.taxFee2=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].taxFee2;
                        $scope.proposal.prpTfeeDto.exchangeRate1=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].exchangeRate1;
                        $scope.proposal.prpTfeeDto.amount1=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].amount1;
                        $scope.proposal.prpTfeeDto.premium1=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].premium1;
                        $scope.proposal.prpTfeeDto.noTaxPremium1=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].noTaxPremium1;
                        $scope.proposal.prpTfeeDto.taxFee1=data.content.blPolicyInfoDtoNew.prpCfeeDtoList[0].taxFee1;
                        $scope.proposal.prpTplanDtoList=data.content.blPolicyInfoDtoNew.prpCplanDtoList;
                        var date1='';
                        var date2='';
                        angular.forEach(data.content.blPolicyInfoDtoNew.prpCplanDtoList, function (item1,inde1) {
                            if(item1.payReason=="R10"){
                                date1=item1.planDate;
                            }else if("PS3,PS4,PS5,PS6,PS7,R30,R20,R81,R82,P10,P40,R10".indexOf(item1.payReason)==-1){

                                date2=item1.planDate ;
                            };
                        });
                        $scope.proposal.prpTsubsidyDtoList=data.content.blPolicyInfoDtoNew.prpCsubsidyDtoList;
                        angular.forEach($scope.proposal.prpTsubsidyDtoList, function (item,inde) {
                            item.subsidyPremium=round(item.subsidyPremium,2)
                        })
                        $scope.proposal.prpTitemKindDtoList=data.content.blPolicyInfoDtoNew.prpCitemKindDtoList;
                        angular.forEach($scope.proposal.prpTitemKindDtoList, function (item,inde) {
                            item.radioType = item.flag.substr(1,1)== 1?'Y':'N';//给页面主险、附加险按钮赋值
                            item.shortRate=round(item.shortRate,2);
                            item.amount=round(item.amount,2);
                            item.premium=round(item.premium,2)
                            item.unitPremium=round(item.unitPremium,2)
                            if(item.quantity){
                                item.agriGrossQuantityMain = item.quantity;//投保面积
                            }
                            if(item.unitCost){
                                item.agriUnitCostMain = item.unitCost;//单位生产成本
                            }
                            if(item.unitOutput){
                                item.agriUnitOutputMain=item.unitOutput//单位保险产量
                            }
                            if(item.timesAmount){
                                item.agriTimesAmount = item.timesAmount;//约定单价
                            }
                            if(item.proportion){
                                item.proportion = item.proportion;//投保成数
                            }
                        });

                        angular.forEach($scope.proposal.prpTplanDtoList, function (item,inde) {
                            var startDate;
                            var str;
                            item.planFee=round(item.planFee,2);
                            if("PS3,PS4,PS5,PS6,PS7".indexOf(item.payReason)>0){
                                item.planDate= date2;
                            }else if(item.payReason=="R30"||item.payReason=="R20"||item.payReason=="R30"||item.payReason=="R81"||item.payReason=="R82"||item.payReason=="P10"||item.payReason=="P40"){
                                item.planDate=date1;
                            }
                            item.palnRealFee=round(parseFloat(item.planFee-item.delinquentFee),2)
                        });
                        $scope.kindCodeList = [];//险别集合
                        $scope.itemCodeList = [];//标的代码集合
                        angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                            $scope.kindCodeList.push(data.kindCode);//险别集合
                            $scope.itemCodeList.push(data.itemCode);//标的代码集合
                        })
                        if($scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
                            $scope.checkItemKindAgri();//茬次信息
                        }
                        gettotalAmount();

                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            var prpDkindItemAgriList = prpDkindItemAgriList||[]
            function selectFlag(riskcode,kindCodes,itemCodes){
                $$finder.find('queryFlag', {
                    "riskCode":riskcode,
                    "itemCodeList": kindCodes,//标的代码集合itemListCodes
                    "kindCodeList": itemCodes//险别
                }, {
                    success: function (data) {
                        console.log(data.content);
                        prpDkindItemAgriList=data.content;
                        getFee();
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
                return prpDkindItemAgriList;
            }

            //批单计算
            function setFee3Endorse(){

                calcPremiumEndorse();
                gettotalAmount();//重新计算保额
                calculatePremiumMainBackEndorse();//计算每个险别的基准办法来计算险别保费
                //calculateSubsidyFee();
                //getCollectItemKindFee();
                //refreshPlanByPayTimes();
            }


            //计算短期费率函数
            var calShortRateEndorse = function(index)
            {
                var itemkindOld = $scope.blPolicyInfoConvertCopy.prpTitemKindDtoList[index];
                var itemkindNew = $scope.proposal.prpTitemKindDtoList[index];
                var dbAmountOld = parseFloat(itemkindOld.amount);
                var dbAmountNew = parseFloat(itemkindNew.amount);
                var dbRateOld = parseFloat(itemkindOld.rate);
                var dbRateNew = parseFloat(itemkindNew.rate);
                var startHourNew = $scope.proposal.prpTmainDto.startHour;
                var startHourOld = $scope.blPolicyInfoConvertCopy.prpTmainDto.startHour;
                var startDateNew = $scope.proposal.prpTmainDto.startDate;
                var startDateOld = $scope.blPolicyInfoConvertCopy.prpTmainDto.startDate;
                var endHourNew = $scope.proposal.prpTmainDto.endHour;
                var endHourOld = $scope.blPolicyInfoConvertCopy.prpTmainDto.endHour;
                var endDateNew = $scope.proposal.prpTmainDto.endDate;
                var endDateOld = $scope.blPolicyInfoConvertCopy.prpTmainDto.endDate;
                if(isNaN(dbAmountOld))
                    dbAmountOld = 0;//原保额
                if(isNaN(dbRateOld))
                    dbRateOld = 0;//原费率
                if(isNaN(dbAmountNew))
                    dbAmountNew = 0;//新保额
                if(isNaN(dbRateNew))
                    dbRateNew = 0;//新费率

                //不计
                if(itemkindNew.shortRate == "3")
                {
                    return 100.00;
                }
                /*减保:原保费大于批改后名义保费，即为减保
                 * 对于减保：已了责任发生变化，所以就已了责任区间计算保费
                 * 新短期费率参与退费计算，所以退费要少，短期费率要小
                 * 未了责任短期费率=原短期费率-已了责任月份数（或天数）对应的短期费率
                 */
                else if(itemkindNew.flag=="D"||
                    dbAmountOld*dbRateOld>dbAmountNew*dbRateNew)
                {
                    return getShortRateEndorse(itemkindNew.shortRateFlag,
                        startDateOld,
                        startHourOld,
                        startDateOld,
                        endHourOld)-
                        getShortRateEndorse(itemkindNew.shortRateFlag,
                            startDateNew,
                            startHourNew,
                            getNextDateFullDate($stateParams.validDate,-1),
                            endHourNew);
                }
                /*
                 *对于保额和费率不变的情况,按照新保来计算
                 */
                else if (itemkindNew.flag!="I"&&
                    dbAmountOld*dbRateOld==dbAmountNew*dbRateNew)
                {
                    return getShortRateEndorse(itemkindNew.shortRateFlag,
                        startDateNew,startHourNew,
                        endDateNew,endHourNew);
                }
                /*加保:原保费小于批改后名义保费，即为减保
                 * 对于加保：未了责任发生变化，所以就未了责任区间计算保费
                 * 新短期费率参与加费计算，所以加费要多，短期费率要大
                 * 未了责任短期费率=未了责任月份数（或天数）对应的短期费率
                 */
                else
                {
                    return getShortRateEndorse(itemkindNew.shortRateFlag,
                        startDateNew,
                        startHourNew,
                        endDateNew,
                        endHourNew);
                }
            }



            var calcPremiumEndorse = function()
            {
                angular.forEach($scope.proposal.prpTitemKindDtoList,function(data, index, array){
                    data.shortRate = point(round(calShortRateEndorse(index),4),4);
                    data.amount = commonApiServ.billNum(data.unitAmount * data.agriGrossQuantityMain)

                    data.premium = formulizePremium(index);
                })

            }

            function calculatePremiumMainBackEndorse(){
                var basePremium;//基准保费
                var SumBenMarkPremium = 0;//总保费
                //$scope.selfPremium=0;//自缴保费
                $scope.adjustRateMain = 0;//每个险别的无赔款优待金额
                $scope.insureRate = 1;//投保比例
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    //基准保费计算   基准保费根据公式计算：保额*费率/短期费率除数（从数据库中取）*短期费率/100-每个险别的无赔款优待金额
                    basePremium = round(data.amount * data.rate / $scope.rateDivisor * data.shortRate / 100 - $scope.adjustRateMain,2);
                    data.basePremium = basePremium;
                    data.benchmarkPremium=basePremium;
                    console.log(data.shortRate)
                    //自缴保费=基准保费*自缴比例*投保比例
                    data.selfPremium = round(basePremium*10000 * $scope.selfRate * $scope.insureRate / 100/10000,2);
                    //补贴保费=基准保费*总补贴比例
                    data.subsidyPremium = round(basePremium*10000 * $scope.govRate / 100/10000,2);
                    //险别保费=自交保费+补贴保费
                    data.premium =round((data.selfPremium + data.subsidyPremium),2);
                });
                //重新计算总保费
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    SumBenMarkPremium += parseFloat(data.premium);
                })
                //$scope.totalPay =SumBenMarkPremium.toFixed(2) ;//总保费
                $scope.totalPay = round(SumBenMarkPremium, 2);
                if ($scope.proposal.prpModelMainSubDto) {
                    $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                }
                if ($scope.proposal.prpTmainDto) {
                    $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay

                }
                sumBenchMarkPreimum();//计算总的基准保费用来计算补贴金额
            }



            //setFee3  获取汇总保额、总保费、投保面积、户次
            function setFee3() {
                //遍历主险附加险
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                    $scope.kindCodeList.push(data.kindCode);//险别集合
                    $scope.agriUnitAmountMainList.push(data.unitAmount);//单位保额集合；单位保险金额
                    $scope.rateMainList.push(data.rate);//费率集合
                    $scope.shortRateFlagList.push(data.shortRateFlag);//短期费率集合
                    $scope.shortRateList.push(data.shortRate);//短期费率集合
                    $scope.calculateFlagList.push(data.radioType);//主险附加险标志集合
                    $scope.itemCodeList.push(data.itemCode);//标的代码集合
                    $scope.itemListCodesList.push(data.replyNo);//标的清单编号
                })
                //遍历补贴信息
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index, array) {
                    //03 04 05 06 07
                    data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                    //中央政策补贴方式
                    if (data.subsidyCode == '03') {
                        $scope.centralRate = data.subsidyRate;
                    }
                    //省级
                    if (data.subsidyCode == '04') {
                        $scope.provinceRate = data.subsidyRate;
                    }
                    //地市
                    if (data.subsidyCode == '05') {
                        $scope.cityRate = data.subsidyRate;
                    }
                    //其他
                    if (data.subsidyCode == '06') {
                        $scope.otherRate = data.subsidyRate;
                    }
                    //县区
                    if (data.subsidyCode == '07') {
                        $scope.townRate = data.subsidyRate;
                    }
                })
                if ($scope._calculatePremium=="0"){
                    //$scope.proposal.proposalNo=$scope._modelCode;
                    $scope.proposal.proposalNo=$rootScope.getModelCode;
                }else {
                    $scope.proposal.proposalNo=$scope.proposal.prpTmainDto.proposalNo;
                }
                // 第一步 保费计算的第一个接口   险别信息传过去，存在清单表中（后台）
                $$finder.find('currencyEnsure', {
                    "proposalNo":$scope.proposal.proposalNo,
                    "gisInusrelistcode": $scope.proposal.insureMainListDto.insureListCode,//金禾清单号  查询出来的
                    "inusrelistcode": $scope.proposal.prpTmainAgriDto.relationListNo,//我方清单号 自动生成的
                    "flag": "T02",//T02 getFee
                    "startDate": $scope.proposal.prpTmainDto.startDate,//起保日期1
                    "endDate": $scope.proposal.prpTmainDto.endDate,//终保日期
                    "kindCodeList": $scope.kindCodeList,//险别
                    "agriUnitAmountMainList": $scope.agriUnitAmountMainList,//单位保额集合；单位保险金额
                    "rateList": $scope.rateMainList,//费率集合
                    "shortRateFlagList": $scope.shortRateFlagList,//短期费率方式集合
                    "shortRateList": $scope.shortRateList,//短期费率集合
                    "fplanRate": $scope.selfRate,//自缴份额比例
                    "centralRate": $scope.centralRate,//中央财政补贴比例
                    "provinceRate": $scope.provinceRate,//省级财政补贴比例
                    "cityRate": $scope.cityRate,//地市财政补贴比例
                    "townRate": $scope.townRate,//县(区)财政补贴比例
                    "otherRate": $scope.otherRate,//其他来源补贴比例
                    "calculateFlagList": $scope.calculateFlagList,//主险附加险集合
                    "riskCode": $scope.proposal.prpTmainDto.riskCode,//险种代码
                    "itemCodeList": $scope.itemCodeList,//标的代码集合itemListCodes
                    "serialNo":$scope.proposal.insureMainListDto.serialNo,
                    "itemListCodes":$scope.itemListCodesList,//标的清单编号20180119000001121
                    "policyType":$scope.proposal.prpTmainAgriDto.raiseType,//养殖方式
                    "times":$scope.proposal.times//点击计算的次数，来进行判断清单保存时是否需要进行主键约束
                }, {
                    success: function (data) {
                        if(data.code=="9999"){
                            var message = data.message;
                            if(message==null && message==""){
                                message = "保费计算失败！"
                            }
                            layer.open({
                                /* offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: message,
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                        }else{
                            selectFlag($scope.proposal.prpTmainDto.riskCode,$scope.itemCodeList,$scope.kindCodeList);
                            //点击计算保存成功之后回写times字段
                            $scope.SetTimes();
                        }
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.CheckItemCodeListMethod =function(itemCodeList,itemListCode){
                $$finder.find('CheckItemCodeListMethod',{
                    "itemCodeLists":itemCodeList,//标的代码集合itemListCodes
                    "itemListCodes":itemListCode,//标的清单
                    "gisInsureListCode": $scope.proposal.insureMainListDto.insureListCode,//金禾清单号  查询出来的
                    "serialNo":$scope.proposal.insureMainListDto.serialNo,
                },{
                    success: function (data) {
                        if(data.content.flag!="1"){//代表查询的标的清单信息与标的，清单号不符合
                            layer.open({
                                /* offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '主险/附加险中的标的清单信息有误，请核查！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            });
                        }else{
                            setFee3();
                        }
                    }, error: function (e) {
                        options.error(e);
                    }
                });
            }
            $scope.checkPremium = function () {
                //如果没有主险则清空补贴，币别，缴费计划等信息
                if ($scope.proposal.prpTitemKindDtoList && $scope.proposal.prpTitemKindDtoList.length <= 0) {
                    $scope.proposal.prpTsubsidyDtoList = [];//补贴信息
                    $scope.proposal.prpTplanDtoList = [];//缴费计划
                    $scope.proposal.prpTfeeDto = {};//币别
                    $scope.proposal.prpTfeeDto.currency2 = 'CNY';
                    $scope.currency2Name = '人民币';
                    $scope.proposal.prpTfeeDto.currency1 = 'CNY';
                    return
                }
                $scope.proposal.doSaveFlag = true
                var list = $scope.proposal.prpTsubsidyDtoList;
                var length = $scope.proposal.prpTsubsidyDtoList.length;//补贴类型的长度
                var strBizType = $stateParams.bizType;//获取业务类型
                $scope.govRate = 0; //总补贴比例
                var subsidyRate = 0;
                //取政府补贴比例之和
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index, array) {
                    if (isNaN(data.subsidyRate) || data.subsidyRate == null || data.subsidyRate == 'undefined') {
                        subsidyRate = 0.00;
                    } else {
                        subsidyRate = data.subsidyRate;
                    }

                    if (data.subsidyType == "01") {
                        $scope.govRate = $scope.govRate + parseFloat(subsidyRate);//补贴比例
                    }
                })
                $scope.kindCodeList = [];//险别集合
                $scope.agriUnitAmountMainList = [],//单位保额集合；单位保险金额
                    $scope.rateMainList = [];//费率集合
                $scope.shortRateFlagList = [];//短期费率方式
                $scope.shortRateList = [];//短期费率集合
                $scope.centralRate = '';//中央财政补贴比例
                $scope.provinceRate = '';//省级财政补贴比例
                $scope.cityRate = '';//地市财政补贴比例
                $scope.townRate = '';//县区财政补贴比例
                $scope.otherRate = '';//其他财政补贴比例
                $scope.calculateFlagList = [];//主险附加险标识
                $scope.selfRate = 100 - $scope.govRate;//自缴比例
                $scope.itemCodeList = [];//标的代码集合
                $scope.itemListCodesList = [];//标的清单编号
                var content = "";
                if (!$scope.proposal.insureMainListDto.insureListCode) {
                    content = "请先选择清单信息！";
                } else if (!$scope.proposal.prpTmainAgriDto.relationListNo) {
                    content = "未生成【我方清单信息】请录入！";
                }
                var fll = true;
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                    if (data.radioType == 'Y') {
                        fll = false;
                    }
                })
                if ($scope.proposal.prpTitemKindDtoList.length > 0 && fll) {//主险附加险
                    content = "请先录入一条主险！";
                } else if (!$scope.proposal.prpTmainDto.startDate) {
                    content = "请先录入【保险期间起期】！";
                } else if (!$scope.proposal.prpTmainDto.endDate) {
                    content = "请先录入【保险期间止期】！";
                } else if ($scope.proposal.prpTsubsidyDtoList.length <= 0 && $scope.proposal.prpTmainDto.businessType1 != '00') {//补贴信息
                    content = "请先录入【补贴信息】！";
                } else if ($scope.proposal.prpTfeeDto.currency2 == '') {
                    content = "请先选择汇总币别!";
                } else if ($scope.proposal.prpTfeeDto.currency2 == '') {
                    content = "请先选择汇总币别!";
                } else if ($scope.proposal.prpTsubsidyDtoList.length > 0) {
                    angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                        if (!data.subsidyCode) {
                            content = "请先选择第" + (index + 1) + "条【补贴信息】的补贴类型！";
                            return;
                        }
                    })
                }
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (dto, index) {
                    if (!dto.replyNo) {
                        content = "标的清单未带出，请重新确认主险/附加险!"
                    }
                })

                if (content != "") {
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
                        },
                    })
                } else {
                    var kindCodeList = [];//险别集合
                    var itemCodeList = [];//标的代码集合
                    var itemListCode = [];//标的清单集合
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index, array) {
                        kindCodeList.push(data.kindCode);//险别集合
                        itemCodeList.push(data.itemCode);//标的代码集合
                        itemListCode.push(data.replyNo);//标的清单代码
                    })
                    if (strBizType == "ENDORSE_TYPE") {
                        getEndorseFee();

                    } else {
                        if ($scope.proposal.prpTmainDto.riskCode == '3134' || $scope.proposal.prpTmainDto.riskCode == '3147'
                            || $scope.proposal.prpTmainDto.riskCode == '3141' || $scope.proposal.prpTmainDto.riskCode == '3102') {
                            var contentFlag = true;
                            if (!$scope.proposal.prpTitemKindAgriDtoListCopy || $scope.proposal.prpTitemKindAgriDtoListCopy.length <= 0) {
                                contentFlag = false;
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: "请录入茬次信息!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    },
                                });
                                return false;
                            }

                            //茬次起止日期在保险期间内
                            for (var i = 0; i < $scope.proposal.prpTitemKindAgriDtoListCopy.length; i++) {
                                var startDate = parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].stratDate.replace(/-/g, ""), 10);
                                var endDate = parseInt($scope.proposal.prpTitemKindAgriDtoListCopy[i].endDate.replace(/-/g, ""), 10);
                                if ($scope.proposal.getDate(startDate, endDate) == -1) {
                                    contentFlag = false;
                                    layer.open({
                                        /*offset: ['35%', '40%'],*/
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        scrollbar: false,
                                        content: "第[" + (i + 1) + "]条茬次起止日期必须在保险期间内!",
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        },
                                    });
                                    return;
                                }
                            }
                            //查询标的险别关系表
                            $$finder.find('queryFlag', {
                                "riskCode": $scope.proposal.prpTmainDto.riskCode,
                                "itemCodeList": itemCodeList,//标的代码集合itemListCodes
                                "kindCodeList": kindCodeList//险别
                            }, {
                                success: function (data) {
                                    //获取主险信息
                                    var sumAmount = 0;
                                    var listMain = [];
                                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (dto) {
                                        angular.forEach(data.content, function (dto1) {
                                            if (dto.riskCode == dto1.riskCode && dto.kindCode == dto1.kindCode
                                                && dto.itemCode == dto1.itemCode && dto1.mainTimes == '1') {
                                                listMain.push(dto);
                                                sumAmount += parseFloat(dto.amount);
                                            }
                                        });
                                    });
                                    if (listMain.length <= 0) {
                                        contentFlag = false;
                                        layer.open({
                                            /* offset: ['35%', '40%'],*/
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: '主险中没有录入“蔬菜作物”标的信息时，不能录入茬次信息!',
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            },
                                        });
                                        return;
                                    } else {
                                        if ($scope.sumDistributingRate() == false) {
                                            contentFlag = false;
                                            return;
                                        }
                                    }
                                    var sum = 0;
                                    angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto) {
                                        if (dto.flag && dto.flag == "D") {
                                        } else if (!dto.flag || dto.flag == "I") {
                                            sum += parseFloat(dto.timesAmount)
                                        }
                                    });
                                    if (sum != sumAmount) {
                                        angular.forEach($scope.proposal.prpTitemKindAgriDtoListCopy, function (dto, index) {
                                            if (dto.flag && dto.flag == "D") {
                                            } else if (!dto.flag || dto.flag == "I") {
                                                $scope.proposal.prpTitemKindAgriDtoListCopy[index].timesAmount = round(((parseFloat($scope.proposal.prpTitemKindAgriDtoListCopy[index].distributingRate) / 100) * sumAmount), 2);
                                            }
                                        })
                                    }
                                    if (contentFlag == true) {
                                        $scope.CheckItemCodeListMethod(itemCodeList, itemListCode);
                                    }
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                        } else {
                            $scope.CheckItemCodeListMethod(itemCodeList, itemListCode);
                        }

                    }
                }
                $scope.DownloadHouseholdListFn();
                $scope.setPremiumFlag();//点击计算时将flag置为true,保存时方便校验共保信息
                if ($scope.proposal.prpTmainDto.riskCode=="3224" || $scope.proposal.prpTmainDto.riskCode=="3230"
                    ||$scope.proposal.prpTmainDto.riskCode=="3228"|| $scope.proposal.prpTmainDto.riskCode=="3232" ) {//查询共保协议
                    $scope.proposal.checkCoins();
                }
            }
            //查询特约条款编号
            $$finder.find('engageQueryClauseByRiskCode', {}, {
                success: function (data) {
                    console.log(data)
                    $scope.engageQueryClauseByRiskCodeList = data.content.codeData;
                },
                error: function (e) {
                    options.error(e);
                }
            });
            // 查看主险附加险新增信息
            $scope.mainAddRiskShow = function (data, index) {
                $scope.radioType = data.calculateFlag;
                $scope.prpTitemKind = data;
                $scope.showaddpage = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                $scope.onlyShow = true;
                $scope.payerr = false;
                showUpdata = true;
                showUpdataindex = index;
                $scope.prpTitemKind.shortRateFlagName = getephemeral(data.shortRateFlag, $scope.ephemeral);
                if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                    || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                    || $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
                    || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'
                    || $scope.proposal.prpTmainDto.riskCode=='3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
                    || $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
                    || $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode == '3149'){
                    $scope.prpTitemKind.untilKindName = "投保面积";
                    $scope.prpTitemKind.untilName = "元/亩";//单位名称
                    $scope.prpTitemKind.untilName1 = '亩';
                }else if ($scope.proposal.prpTmainDto.riskCode=='3220'){
                    $scope.prpTitemKind.untilKindName = "投保数量";
                }
                if(data.kindCode=="3129M003" && $scope.proposal.prpTmainDto.riskCode=='3129'){
                    $scope.deductibleRateType=true;
                    $scope.totalLossRatioType = true;
                    $scope.isTriggerPoint = false;
                    $rootScope.ZHshow1=true;
                    $scope.isTotalLossRatio = false;
                    $scope.ZHPFshow=true;
                }
                //如果是3134并且是附加险的话则隐藏赔付明细
                if($scope.proposal.prpTmainDto.riskCode=='3134'&& data.radioType=='N'){
                    $scope.payDetail=false;
                }else{
                    $scope.payDetail=true;
                }
            }
            var updateMain=false;
            var indexUpdate="";
            $scope.mainAddRiskUpdata = function (data, index) {
                indexUpdate=index;
                $scope.radioType = angular.copy(data.radioType)
                $scope.prpTitemKind = angular.copy(data);
                $scope.showaddpage = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条

                if($scope.endorseFlag && data.flag){
                    if(data.flag.substr(0,1)!="I") {
                        $scope.onlyShow = false;
                        $scope.endorShow = true;
                        $scope.mainSubFlag=true;
                    }
                }else{
                    $scope.mainSubFlag=false;
                    $scope.onlyShow = false;
                }

                $scope.payerr = false;
                showUpdata = true;
                updata = true
                updateMain=true;//判断是不是修改
                showUpdataindex = index;
                var n = $scope.radioType == 'Y' ? 1 : 2;
                getKindcode(n);

                $scope.getShortRate($scope.prpTitemKind.shortRateFlag);
                $scope.changeData({codeCode:data.kindCode,codeName:data.kindName}, 'updata');
                if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                    || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                    || $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
                    || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'
					|| $scope.proposal.prpTmainDto.riskCode=='3114'||$scope.proposal.prpTmainDto.riskCode=='3122'
                    || $scope.proposal.prpTmainDto.riskCode=='3126'||$scope.proposal.prpTmainDto.riskCode=='3161'
					|| $scope.proposal.prpTmainDto.riskCode=='3101'||$scope.proposal.prpTmainDto.riskCode=='3149'){
                    $scope.prpTitemKind.untilKindName = "投保面积";
                    $scope.prpTitemKind.untilName = "元/亩";//单位名称
                    $scope.prpTitemKind.untilName1 = '亩';
                }else if ($scope.proposal.prpTmainDto.riskCode=='3220'){
                    $scope.prpTitemKind.untilKindName = "投保数量";
                }
            }
            $scope.changeData = function (data, type) {
                if(data.codeCode=="3129M003"){
                    $scope.deductibleRateType=false;
                    $scope.totalLossRatioType = false;
                    $scope.isTriggerPoint = false;
                    $scope.ZHshow1=true;
                    $scope.isTotalLossRatio = false;
                    $scope.ZHPFshow=true;
                }else if(data.codeCode=="3129M002"){
                    $scope.deductibleRateType=false;
                    $scope.totalLossRatioType = false;
                    $scope.isTriggerPoint = false;
                    $scope.ZHshow1=true;
                    $scope.isTotalLossRatio = false;
                    $scope.ZHPFshow=false;
                    $scope.prpTitemKind.untilName="元/人";
                    $scope.prpTitemKind.untilKindName = "投保人数";
                    $scope.prpTitemKind.untilName1 = '人';
                }else if(data.codeCode=="3129M001"){
                    $scope.isTrue=true;//茬次信息
                    //不做处理
                    $scope.isAgriUnitCostMain=false;
                    $scope.isProportion=false;
                    $scope.prpTitemKind.untilKindName = "投保面积";
                    $scope.prpTitemKind.agriUnitCostMaintitle = '单位生产成本';
                    $scope.prpTitemKind.unitCostName = '元';
                    $scope.prpTitemKind.agriUnitOutputMaintitle="单位保险产量";
                    $scope.prpTitemKind.agriUnitOutputMainName="公斤";
                    $scope.isRaiseDate=false;
                    $scope.isProposalType=false;
                    $scope.ZHshow=true;
                    $scope.ZHPFshow=false;
                    $scope.ZHshow1=false;
                    $scope.isAgriUnitCostMain=true;
                    $scope.deductibleRateType=false;
                    $scope.totalLossRatioType = false;
                    $scope.isTriggerPoint = true;
                    $scope.isTotalLossRatio = true;
                }
                for(var i=0;i<$scope.proposal.prpTitemKindDtoList.length;i++){
                    var _data=$scope.proposal.prpTitemKindDtoList[i]
                    if(data.kindCode==_data.kindCode&&type!='updata'&&$scope.proposal.prpTmainDto.riskCode=='3134'
                        && $scope.proposal.prpTmainDto.riskCode=='3147'&& $scope.proposal.prpTmainDto.riskCode=='3141'&& $scope.proposal.prpTmainDto.riskCode=='3102'){
                        return
                    }
                }

                type = 'kindCode'
                $scope.prpTitemKind.kindName = data.codeName
                if (type == 'kindCode') {
                    //$scope.itemCodeType($scope.prpTitemKind.kindCode);
                    $$finder.find('initSelect', {
                        "codeType": "ItemCode0",
                        riskCode: $scope.proposal.prpTmainDto.riskCode,//险种
                        reserve1: $scope.proposal.prpTmainDto.versionNo,//条款
                        reserve2: data.codeCode//险别
                    }, {
                        success: function (data) {
                            $scope.itemDetailList = data.content.codeData
                        },
                    })
                }
            }

            //删除主险附加险
            $scope.mainAddRiskDel = function (index) {
                var prpTitemKindDtoList = $scope.proposal.prpTitemKindDtoList;
                var length= 0;
                var length2= 0;
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                    if(data.flag.substr(0,1)!="D"){
                        length=length+1;
                    }
                })
                //**************--------批改专属----***************
                // 如果是批改，并且是保单数据初始值。
                if ($scope.endorseFlag) {
                    // 批单点击删除 有可能为恢复
                    if (prpTitemKindDtoList[index].flag.substr(0,1) === 'D') { // 如果为恢复； 标识位置为 null
                        prpTitemKindDtoList[index].flag = prpTitemKindDtoList[index].radioType==="Y"?" 1":" 2" ;
                    }else if (prpTitemKindDtoList[index].flag && prpTitemKindDtoList[index].flag.substr(0,1)=== 'I') { // 如果是新增的一条就删除一行
                            $scope.proposal.prpTitemKindDtoList.splice(index, 1);
                    } else { // 如果为删除 则从保存的数据中取出初始值将列表值赋值回来 并且置标识位为 D
                        prpTitemKindDtoList[index] = $scope.blPolicyInfoListingConvertCopyRestoreDTO.prpTitemKindDtoList[index];
                        prpTitemKindDtoList[index].flag=prpTitemKindDtoList[index].radioType==="Y"?"D1":"D2" ;
                    }
                    //**************--------批改专属----***************
                    $scope.totalAmount = 0;
                    $scope.totalPay = 0
                    $scope.proposal.prpModelMainSubDto = $scope.proposal.prpModelMainSubDto || {}
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        if(data.flag.substr(0,1)!="D"){
                            $scope.totalAmount += parseFloat(data.amount);
                            $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                            $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                            $scope.totalPay +=parseFloat(data.premium)
                            $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                            $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay

                        }
                    })
                    $scope.totalAmount = round($scope.totalAmount, 2);
                    $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                    $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                    $scope.totalPay = round($scope.totalPay, 2);
                    $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                    $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay
                } else {
                    $scope.proposal.prpTitemKindDtoList.splice(index, 1)
                    $scope.totalAmount = 0;
                    $scope.totalPay = 0
                    $scope.proposal.prpModelMainSubDto = $scope.proposal.prpModelMainSubDto || {}
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        $scope.totalAmount+=parseFloat(data.amount);
                        $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                        $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                        $scope.totalPay+= parseFloat(data.premium);
                        $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                        $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay


                    })
                    $scope.totalAmount = round($scope.totalAmount, 2);
                    $scope.proposal.prpModelMainSubDto.sumAmount = $scope.totalAmount;
                    $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;
                    $scope.totalPay = round($scope.totalPay, 2);
                    $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                    $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay
                    if($scope.proposal.prpTmainDto.riskCode=='3134'||$scope.proposal.prpTmainDto.riskCode=='3147'
					||$scope.proposal.prpTmainDto.riskCode=='3224'||$scope.proposal.prpTmainDto.riskCode=='3141'
					||$scope.proposal.prpTmainDto.riskCode=='3129'|| $scope.proposal.prpTmainDto.riskCode=='3102'
					|| $scope.proposal.prpTmainDto.riskCode=='3101' ||$scope.proposal.prpTmainDto.riskCode=='3114'
					||$scope.proposal.prpTmainDto.riskCode=='3122'||$scope.proposal.prpTmainDto.riskCode=='3126'
					||$scope.proposal.prpTmainDto.riskCode=='3161'){
                        $scope.mainOrSubMain=false;
                    }else if(($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                        || $scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'
                        ||$scope.proposal.prpTmainDto.riskCode=='3237'|| $scope.proposal.prpTmainDto.riskCode=='3101'
						||$scope.proposal.prpTmainDto.riskCode=='3114'||$scope.proposal.prpTmainDto.riskCode=='3122'
						||$scope.proposal.prpTmainDto.riskCode=='3126'||$scope.proposal.prpTmainDto.riskCode=='3161'
                        ||$scope.proposal.prpTmainDto.riskCode=='3149' )&&$scope.proposal.prpTitemKindDtoList.length<=0){
                        $scope.mainOrSubMain=false;
                    }
                }
                angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                    if(data.flag.substr(0,1)!="D"){
                        length2= length2+1;
                    }
                })
                if(length!= length2){
                    $scope.proposal.doSaveFlag=false;
                }else{
                    $scope.proposal.doSaveFlag=true;
                }
            }
            //将新增按钮放开，不然不能新增主险
            $scope.proposal.ChangemainOrSubMain = function () {
                $scope.mainOrSubMain=false;
            }
            $scope.dd=function(){
                layer.open({
                    /*offset: ['45%', '40%'],*/
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
            var content;
            $scope.prpTitemKind.deductibleRate=null;
            $scope.prpTitemKind.triggerPoint=null;
            $scope.prpTitemKind.totalLossRatio=null;
            $scope.checkRatio = function (n,b) {
                //b作为标志用来判断,如果是投保单详细信息查询的时候,则不做以下的相应校验
                if (b==false) {

                    //var num = /^(100|[1-9]\d|\d)(.\d{1,4})$/
                    var num2 = /^(100|[0-9]{1,2})||(100|[0-9]{1,2})$/
                    var num3 = /^((\d|[123456789]\d)(\.\d{1,4})?|100)$/;
                    if ($scope.proposal.prpTmainDto.riskCode == '3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                        || $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
                        || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3130'
                        || $scope.proposal.prpTmainDto.riskCode=='3102' || $scope.proposal.prpTmainDto.riskCode=='3101'
						||$scope.proposal.prpTmainDto.riskCode=='3114'||$scope.proposal.prpTmainDto.riskCode=='3161'
					    ||$scope.proposal.prpTmainDto.riskCode=='3122'||$scope.proposal.prpTmainDto.riskCode=='3126'
                        ||$scope.proposal.prpTmainDto.riskCode=='3149' ) {
                        if ((($scope.prpTitemKind.deductibleRate != '' || $scope.prpTitemKind.deductibleRate == '0') && $scope.prpTitemKind.deductibleRate != null && $scope.prpTitemKind.deductibleRate !='NaN')
                            && (($scope.prpTitemKind.totalLossRatio != '' || $scope.prpTitemKind.totalLossRatio == '0')&& $scope.prpTitemKind.totalLossRatio != null && $scope.prpTitemKind.totalLossRatio!='NaN')
                            &&(($scope.prpTitemKind.triggerPoint != '' || $scope.prpTitemKind.triggerPoint == '0') && $scope.prpTitemKind.triggerPoint != null && $scope.prpTitemKind.triggerPoint !='NaN')) {
                            if (!num3.test($scope.prpTitemKind.deductibleRate)) {
                                content = '每次事故免赔率(%)格式不正确！';
                                $scope.dd();
                                $scope.prpTitemKind.deductibleRate = '';
                                return;
                            }
                            if (!num3.test($scope.prpTitemKind.triggerPoint)) {
                                content = '起赔点(%)格式不正确！';
                                $scope.dd();
                                $scope.prpTitemKind.triggerPoint = ''
                                return;
                            }
                            if (!num3.test($scope.prpTitemKind.totalLossRatio)) {
                                content = '全损损失率(%)格式不正确！';
                                $scope.dd();
                                $scope.prpTitemKind.totalLossRatio = '';
                                return;
                            }
                            if($scope.proposal.prpTmainDto.riskCode=='3129'){
                                if (!num3.test($scope.prpTitemKind.stabilityFundRate)) {
                                    content = '绝对免赔率(%)格式不正确！';
                                    $scope.dd();
                                    $scope.prpTitemKind.stabilityFundRate = '';
                                    return;
                                }
                            }
                            if($scope.prpTitemKind.triggerPoint===0 ||$scope.prpTitemKind.totalLossRatio===0 ){
                                layer.open({
                                    /*offset: ['45%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: "请确认,每次事故免赔率为0",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                            }
                        } else if($scope.prpTitemKind.deductibleRate==null ||!$scope.prpTitemKind.deductibleRate
                            ||$scope.prpTitemKind.deductibleRate==undefined || $scope.prpTitemKind.deductibleRate=="") {
                            //不做处理
                        }else{
                            content = '全部为必填项不能为空！';
                            $scope.dd();
                            return;
                        }
                        if (!$scope.prpTitemKind.triggerPoint && $scope.prpTitemKind.triggerPoint != 0) {
                            content = '请输入起赔点';
                            $scope.dd();
                            return
                        }
                        if($scope.proposal.prpTmainDto.riskCode=='3129') {
                            if (!$scope.prpTitemKind.stabilityFundRate && $scope.prpTitemKind.stabilityFundRate != 0) {
                                content = '请输入绝对免赔率';
                                $scope.dd();
                                return
                            }
                        }
                        if($scope.prpTitemKind.triggerPoint&&$scope.prpTitemKind.deductibleRate){
                            if (!$scope.prpTitemKind.triggerPoint || $scope.prpTitemKind.triggerPoint * 1 < $scope.prpTitemKind.deductibleRate * 1 && $scope.proposal.prpTmainDto.riskCode!='3141') {

                                content = '起赔点必须大于免赔率';
                                $scope.dd();
                                return
                            }
                            if ($scope.prpTitemKind.triggerPoint * 1 == $scope.prpTitemKind.deductibleRate) {
                                if ($scope.prpTitemKind.deductibleRate != 0||$scope.prpTitemKind.triggerPoint==0) {
                                    content = '起赔点必须大于免赔率';
                                    $scope.dd();
                                    return
                                }
                            }
                        }


                        //if ($scope.prpTitemKind.triggerPoint * 1 > $scope.prpTitemKind.deductibleRate * 1) {
                            if (!$scope.prpTitemKind.totalLossRatio && $scope.prpTitemKind.totalLossRatio != 0) {

                                content = '请输入全损损失率';
                                $scope.dd();
                                return
                            }
                            if (!$scope.prpTitemKind.totalLossRatio || $scope.prpTitemKind.totalLossRatio * 1 < $scope.prpTitemKind.triggerPoint * 1) {

                                content = '全损损失率必须大于起赔点';
                                $scope.dd();
                                return
                            }
                            if ($scope.prpTitemKind.totalLossRatio * 1 == $scope.prpTitemKind.triggerPoint * 1) {
                                if ($scope.prpTitemKind.triggerPoint != 0||$scope.prpTitemKind.totalLossRatio==0) {
                                    content = '全损损失率必须大于起赔点';
                                    $scope.dd();
                                    return
                                }
                            }
                            if (!n) {
                                return
                            }
                        //}
                    }else if( $scope.proposal.prpTmainDto.riskCode=='3237' || $scope.proposal.prpTmainDto.riskCode=='3224'  ){
                        if (!$scope.prpTitemKind.triggerPoint && $scope.prpTitemKind.triggerPoint != 0) {
                            content = '请输入起赔点(%)';
                            $scope.dd();
                            return
                        }
                        if (!num3.test($scope.prpTitemKind.triggerPoint)) {
                            content = '起赔点(%)格式不正确！';
                            $scope.dd();
                            $scope.prpTitemKind.triggerPoint = ''
                            return;
                        }
                        if($scope.prpTitemKind.triggerPoint===0 ){
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: "请确认,起赔点为0",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        }
                    }else if($scope.proposal.prpTmainDto.riskCode=='3233'){
                        if($scope.prpTitemKind.deductibleRate){
                            if (!num3.test($scope.prpTitemKind.deductibleRate)) {
                                content = '每次事故免赔率(%)格式不正确！';
                                $scope.dd();
                                $scope.prpTitemKind.deductibleRate = '';
                                return;
                            }
                        }

                        if($scope.prpTitemKind.deductibleRate===0){
                            layer.open({
                                /*offset: ['45%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: "请确认,每次事故免赔率为0",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                        }
                    }else if( $scope.proposal.prpTmainDto.riskCode=='3129'){
                        if (($scope.prpTitemKind.stabilityFundRate != '' && $scope.prpTitemKind.stabilityFundRate != null && $scope.prpTitemKind.stabilityFundRate!='NaN')
                            && ($scope.prpTitemKind.triggerPoint != '' && $scope.prpTitemKind.triggerPoint != null && $scope.prpTitemKind.triggerPoint !='NaN')
                            && ($scope.prpTitemKind.totalLossRatio != '' && $scope.prpTitemKind.totalLossRatio != null && $scope.prpTitemKind.totalLossRatio!='NaN')
                            && ($scope.prpTitemKind.stabilityFundRate != '' && $scope.prpTitemKind.stabilityFundRate != null && $scope.prpTitemKind.stabilityFundRate!='NaN')) {
                            if($scope.prpTitemKind.kindCode=="3129M001") {
                                if (!num3.test($scope.prpTitemKind.deductibleRate)) {
                                    content = '每次事故免赔率(%)格式不正确！';
                                    $scope.dd();
                                    $scope.prpTitemKind.deductibleRate = '';
                                    return;
                                }
                                if (!num3.test($scope.prpTitemKind.stabilityFundRate)) {
                                    content = '绝对免赔率(%)格式不正确！';
                                    $scope.dd();
                                    $scope.prpTitemKind.stabilityFundRate = '';
                                    return;
                                }
                                if (!num3.test($scope.prpTitemKind.triggerPoint)) {
                                    content = '起赔点(%)格式不正确！';
                                    $scope.dd();
                                    $scope.prpTitemKind.triggerPoint = ''
                                    return;
                                }
                                if (!num3.test($scope.prpTitemKind.totalLossRatio)) {
                                    content = '全损损失率(%)格式不正确！';
                                    $scope.dd();
                                    $scope.prpTitemKind.totalLossRatio = '';
                                    return;
                                }
                            }
                        }else if(($scope.prpTitemKind.deductibleRate==null||$scope.prpTitemKind.deductibleRate==undefined||$scope.prpTitemKind.deductibleRate=="")
                                ||($scope.prpTitemKind.stabilityFundRate==null||$scope.prpTitemKind.stabilityFundRate==undefined||$scope.prpTitemKind.stabilityFundRate=="")){
                            //不做处理
                        } else {
                            if($scope.prpTitemKind.kindCode=="3129M001"){
                                content = '全部为必填项不能为空！';
                                $scope.dd();
                                return;
                            }
                        }
                        //if (!$scope.prpTitemKind.stabilityFundRate && $scope.prpTitemKind.stabilityFundRate != 0) {
                        //    content = '请输入绝对免赔率';
                        //    $scope.dd();
                        //    return
                        //}
                        if($scope.prpTitemKind.kindCode=="3129M001"){
                            if (!$scope.prpTitemKind.triggerPoint && $scope.prpTitemKind.triggerPoint != 0) {
                                content = '请输入起赔点';
                                $scope.dd();
                                return
                            }
                            if($scope.prpTitemKind.triggerPoint&&$scope.prpTitemKind.deductibleRate){
                                if (!$scope.prpTitemKind.triggerPoint || $scope.prpTitemKind.triggerPoint * 1 < $scope.prpTitemKind.deductibleRate * 1 && $scope.proposal.prpTmainDto.riskCode!='3141') {
                                    content = '起赔点必须大于免赔率';
                                    $scope.dd();
                                    return
                                }
                                if ($scope.prpTitemKind.triggerPoint * 1 == $scope.prpTitemKind.deductibleRate) {
                                    if ($scope.prpTitemKind.deductibleRate != 0||$scope.prpTitemKind.triggerPoint==0) {
                                        content = '起赔点必须大于免赔率';
                                        $scope.dd();
                                        return
                                    }
                                }
                            }


                            //if ($scope.prpTitemKind.triggerPoint * 1 > $scope.prpTitemKind.deductibleRate * 1) {
                                if (!$scope.prpTitemKind.totalLossRatio && $scope.prpTitemKind.totalLossRatio != 0) {

                                    content = '请输入全损损失率';
                                    $scope.dd();
                                    return
                                }
                                if (!$scope.prpTitemKind.totalLossRatio || $scope.prpTitemKind.totalLossRatio * 1 < $scope.prpTitemKind.triggerPoint * 1) {

                                    content = '全损损失率必须大于起赔点';
                                    $scope.dd();
                                    return
                                }
                                if ($scope.prpTitemKind.totalLossRatio * 1 == $scope.prpTitemKind.triggerPoint * 1) {
                                    if ($scope.prpTitemKind.triggerPoint != 0 || $scope.prpTitemKind.totalLossRatio == 0) {
                                        content = '全损损失率必须大于起赔点';
                                        $scope.dd();
                                        return
                                    }
                                }
                                if ($scope.prpTitemKind.kindCode == "3129M001") {
                                    if (!$scope.prpTitemKind.stabilityFundRate || $scope.prpTitemKind.stabilityFundRate * 1 > $scope.prpTitemKind.deductibleRate * 1) {
                                        content = '每次事故免赔率必须大于绝对免赔率';
                                        $scope.dd();
                                        return
                                    }
                                    if ($scope.prpTitemKind.stabilityFundRate * 1 == $scope.prpTitemKind.deductibleRate) {
                                        if ($scope.prpTitemKind.deductibleRate != 0 || $scope.prpTitemKind.stabilityFundRate == 0) {
                                            content = '每次事故免赔率必须大于绝对免赔率';
                                            $scope.dd();
                                            return
                                        }
                                    }
                                }
                            //}
                            if (!n) {
                                return
                            }
                        }
                    }
                }
                $scope.showHide('pay')
            }
            //获取保额
            var getAmount = function () {
                var amount = $scope.prpTitemKind.unitAmount * $scope.prpTitemKind.agriGrossQuantityMain;
                $scope.prpTitemKind.amount= round(amount,2);
                $scope.adjustBill('amount');
                $scope.adjustMun('amount');
            }
            //显示关闭弹层/赔付明细：承保明细：
            $scope.showaddpage = false;
            $("html,body").css({overflow:"auto"});//出现滚动条
            $scope.underwriting = false;
            $scope.pay = false;
            $scope.showHide = function (type) {
                $scope.checkOutBdRed=false;
                if (showUpdata) {
                    if (type == 'showaddpage') {
                        $scope.underwriting = false;
                        $scope.pay = false;
                        updata=false;
                    }
                    showUpdata = false;
                    $scope.showHide(type);
                    return

                }else{
                    if (type == 'showaddpage') {
                        if ($scope.endorseFlag) {
                            $scope.endorShow = false;
                        }
                    }
                }

                if(!$scope.prpTitemKind.agriGrossQuantityMain){
                    $scope.prpTitemKind.agriGrossQuantityMain = 0;
                }
                if (type) {
                    //预防弹出层不能挡住新增按钮导致连续点击弹出框消失
                    if ($scope[type] == true && arguments[1])return
                    //初始化入口
                    if (arguments[1]) {
                        $scope.prpTitemKind = {}
                        $scope.onlyShow = false;
                        $scope.radioType = 'Y';
                        getKindcode(1);
                        $scope.prpTitemKind.itemKindNo = $scope.proposal.prpTmainDto.length ? $scope.proposal.prpTmainDto.length + 1 : 1
                        //getitemNoMain();
                        $scope.underwritingerr = false;
                        $scope.payerr = false;
                        $scope.prpTitemKind.currency = 'CNY'
                        //短期费率方式个性化
                        if ($scope.proposal.prpTmainDto.riskCode=='3134'){
                            $scope.prpTitemKind.shortRateFlag='2';
                            $scope.getShortRate($scope.prpTitemKind.shortRateFlag);
                        }else{
                            $scope.prpTitemKind.shortRateFlag='3';
                            $scope.prpTitemKind.shortRate = '100.00'
                        }
                        $scope.prpTitemKind.premiumCalMethod='0';//保费计算方式  默认值
                        $scope.getDration();
                    }
                    //获取保额
                    if (type == 'underwriting' && $scope.prpTitemKind.unitAmount) {
                        getAmount();
                        if($scope.prpTitemKind.premium==undefined||$scope.prpTitemKind.premium==""){
                            $scope.prpTitemKind.premium = round(($scope.prpTitemKind.amount * $scope.prpTitemKind.shortRate / 100 * $scope.prpTitemKind.rate / 100),2);
                        }
                    }
                    //没有选中确定金额方式不能点开承包明细
                    if (type == 'underwriting' && !$scope.proposal.prpTmainAgriDto.remark && ($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                        || $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
						||$scope.proposal.prpTmainDto.riskCode=='3101'||$scope.proposal.prpTmainDto.riskCode=='3114'
						||$scope.proposal.prpTmainDto.riskCode=='3122'||$scope.proposal.prpTmainDto.riskCode=='3126'
						||$scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode == '3149')) {
                        if (showUpdata) {
                            $scope[type] = !$scope[type];
                            return;
                        }
                        $scope.underwritingerr = true;
                        return
                    }
                    //if (type == 'underwriting' && $scope.proposal.prpTmainAgriDto.remark) {
                    //    changeProposalType1();
                    //}
                    //没有选中确定金额方式不能点赔付明细
                    if (type == 'pay' && !$scope.proposal.prpTmainAgriDto.remark && ($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                        || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                        || $scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3147'
						|| $scope.proposal.prpTmainDto.riskCode=='3101'|| $scope.proposal.prpTmainDto.riskCode=='3114'
						|| $scope.proposal.prpTmainDto.riskCode=='3122'|| $scope.proposal.prpTmainDto.riskCode=='3126'
						|| $scope.proposal.prpTmainDto.riskCode=='3161'|| $scope.proposal.prpTmainDto.riskCode == '3149')) {
                        if (showUpdata) {
                            $scope[type] = !$scope[type];
                            return;
                        }
                        $scope.payerr = true;
                        return
                    }
                    //取消按钮时初始化
                    if (type == 'showaddpage' && !arguments[1]) {
                        $scope.pay = false;
                        $scope.underwriting = false;
                        showUpdata = false;
                        $scope.onlyShow = false;
                        //getitemNoMain('cancel');
                    }
                    $scope[type] = !$scope[type];
                    if(type=="showaddpage"){
                        if($scope[type]){
                            $("html,body").css({overflow:"hidden"});
                        }else{
                            $("html,body").css({overflow:"auto"});
                        }
                    }

                    //隐藏/显示赔付明细
                    if($scope.radioType=='Y'){
                        $scope.payDetail=true;
                    }else if($scope.radioType=='N' && $scope.proposal.prpTmainDto.riskCode=='3134'){
                        $scope.payDetail=false;
                    }
                }



            };
            //点击确定的校验
            $scope.checkInsure = function(){
                var content="";
                if($scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'){
                    if($scope.prpTitemKind.proportion==""){
                        content = "请输入投保成数！";
                    }else if($scope.prpTitemKind.proportion>100){
                        content = "投保成数不能大于100%！";
                        $scope.prpTitemKind.proportion="";
                    }
                }
                if($scope.proposal.prpTmainDto.riskCode=='3134' || $scope.proposal.prpTmainDto.riskCode=='3147'|| $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3102'){
                    if (($scope.proposal.prpTmainAgriDto.remark=='1'|| $scope.proposal.prpTmainAgriDto.remark=='2')&&(!$scope.prpTitemKind.unitAmount&&$scope.prpTitemKind.unitAmount!="0")){
                        content='全部为必填项不能为空！';
                    }
                }else {
                    //if ($scope.proposal.prpTmainAgriDto.remark == '1' && (!$scope.prpTitemKind.agriUnitCostMain || !$scope.prpTitemKind.unitAmount)) {
                    //    content = '全部为必填项不能为空！';
                    //} else if ($scope.proposal.prpTmainAgriDto.remark == '2' && (!$scope.prpTitemKind.agriUnitOutputMain || !$scope.prpTitemKind.unitAmount || !$scope.prpTitemKind.agriTimesAmount)) {
                    //    content = '全部为必填项不能为空！';
                    //}
                    if ($scope.proposal.prpTmainAgriDto.remark=='1' && ($scope.prpTitemKind.agriUnitCostMain===0&& $scope.prpTitemKind.unitAmount===0)) {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "请确认单位生产成本及单位保险金额为0！",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else if ($scope.proposal.prpTmainAgriDto.remark=='2' && ($scope.prpTitemKind.agriUnitOutputMain===0|| $scope.prpTitemKind.unitAmount===0||$scope.prpTitemKind.untilKindName===0||$scope.prpTitemKind.agriTimesAmount===0)) {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "输入项为0，请确认！",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else if ($scope.proposal.prpTmainAgriDto.remark=='1' && ($scope.prpTitemKind.agriUnitCostMain===0&& $scope.prpTitemKind.unitAmount!=0)) {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "请确认单位生产成本为0！",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else if ($scope.proposal.prpTmainAgriDto.remark=='1' && ($scope.prpTitemKind.agriUnitOutputMain!=0&& $scope.prpTitemKind.unitAmount===0)) {
                        layer.open({
                            /*offset: ['45%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "请确认单位保险金额为0！",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }
                    else if ($scope.proposal.prpTmainAgriDto.remark=='1' &&( $scope.prpTitemKind.unitAmount=="" || $scope.prpTitemKind.unitAmount==undefined )) {
                        content = '全部为必填项不能为空！';
                    }else if($scope.proposal.prpTmainAgriDto.remark=='2'&&($scope.prpTitemKind.unitAmount=="" || $scope.prpTitemKind.unitAmount==undefined||
                        $scope.prpTitemKind.agriTimesAmount=="" ||$scope.prpTitemKind.agriTimesAmount==undefined)){
                        content = '全部为必填项不能为空！';
                    }
                }
                if (content){
                    $scope.underwriting=true;
                    layer.open({
                        /*offset: ['45%', '40%'],*/
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
                }

            }
            //根据 按何种方式确认保险金额 赔付明细触发的函数，现在在条款中配置，故在此无需重新赋值
            //function changeProposalType1() {
            //    var riskCode = $scope.proposal.prpTmainDto.riskCode;
            //    if('3141'.indexOf(riskCode) > -1) {
            //        var itemCode = $scope.prpTitemKind.itemCode;
            //        if(itemCode == "31c1" || itemCode == "31c2" || itemCode == "31c3" || itemCode == "31c0") {
            //            $scope.prpTitemKind.deductibleRate = "10";
            //            //spanDeductibleRateMain.innerHTML = "每次事故免赔率(%)：";
            //        } else {
            //            $scope.prpTitemKind.deductibleRate = "100";
            //            $scope.prpTitemKind.totalLossRatio = "100";
            //        }
            //    }
            //}
            //获取标的项目
            $scope.getModelMain = function (data) {
                if (data.codeName != "" && $scope.prpTitemKind.itemCode != "") {
                    $scope.prpTitemKind.itemDetailName = data.codeName
                    $scope.prpTitemKind.modelMain = $scope.prpTitemKind.itemCode
                    $scope.prpTitemKind.model = $scope.prpTitemKind.itemDetailName
                    $$finder.find('queryItemListCodeByPK', {

                        insureListCode: $scope.proposal.insureMainListDto.insureListCode,
                        serialNo: $scope.proposal.insureMainListDto.serialNo,
                        itemCode: $scope.prpTitemKind.itemCode
                    }, {
                        success: function (data) {
                            console.log(data)
                            if (data.code == "9999") {
                                $scope.prpTitemKind.replyNo = "";
                            } else {
                                $scope.prpTitemKind.replyNo = data.content.itemListCode;
                            }
                        },
                        error: function () {

                        }
                    })
                }
            }
            //切换短期费率默认值
            $scope.chgShortRateFlag=function(content){
                //如果标的类型是棚膜或者棚架短期费率方式默认为短期费率方式
                if ($scope.proposal.prpTmainDto.riskCode=='3141' || $scope.proposal.prpTmainDto.riskCode=='3147'){
                    if(content.codeCode=='AA110' || content.codeCode=='AA120' || content.codeCode=='AA130' || content.codeCode=='AA140'
                        || content.codeCode=='AA210' || content.codeCode=='AA220' || content.codeCode=='AA230' || content.codeCode=='AA240'){
                        $scope.prpTitemKind.shortRateFlag='1';
                    }else{
                        $scope.prpTitemKind.shortRateFlag='3';
                    }
                }
                $scope.getShortRate($scope.prpTitemKind.shortRateFlag);
            }

            $scope.click = function () {
                if ($scope.prpTitemKind.kindName == null) {
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '请选择险别',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
            }
            //单选按钮
            $scope.radioType = 'Y';
            //获取险别
            var getKindcode = function (n) {

                $$finder.find('initSelect', {
                    codeType: 'KindCode',
                    riskCode: $scope.proposal.prpTmainDto.riskCode,//险种
                    reserve1: $scope.proposal.prpTmainDto.versionNo,//条款
                    reserve2: n
                }, {
                    success: function (data) {
                        data.content = data.content || {}
                        $scope.KindCodeList = data.content.codeData

                    },
                })
            }
            $scope.rdChange = function (ele) {
                //防止点击附加险清空主险数据
                if(ele!=$scope.radioType &&($scope.proposal.prpTmainDto.riskCode=='3134' || $scope.proposal.prpTmainDto.riskCode=='3147'|| $scope.proposal.prpTmainDto.riskCode=='3224' || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3124'|| $scope.proposal.prpTmainDto.riskCode=='3102')){
                    //主险附加险切换清空所有内容
                    $scope.prpTitemKind.kindCode="" ;//险别
                    $scope.prpTitemKind.itemCode="";//标的
                    $scope.prpTitemKind.model="";//标的项目
                    $scope.prpTitemKind.premiumCalMethod="0";//保费计算公式
                    $scope.prpTitemKind.shortRateFlag='3';//短期费率方式
                    $scope.prpTitemKind.shortRate='100.00'//短期费率费率
                    $scope.prpTitemKind.unitPremium="";//单位保费
                    $scope.prpTitemKind.deductibleRate="";//每次事故免赔率
                    $scope.prpTitemKind.triggerPoint="";//起赔点
                    $scope.prpTitemKind.totalLossRatio="";//全损损失率
                    $scope.prpTitemKind.agriUnitCostMain="";//单位生产成本
                    $scope.prpTitemKind.agriUnitOutputMaintitle="";//
                    $scope.prpTitemKind.unitAmount="";//单位保险金额
                    $scope.prpTitemKind.agriGrossQuantityMain=0;//投保面积
                    $scope.prpTitemKind.agriTimesAmount="";//约定单价
                    $scope.prpTitemKind.unitAmountMain="";//单位保额
                    $scope.prpTitemKind.quantityMain="";//承保数量
                    $scope.prpTitemKind.amount="";//保额
                    $scope.prpTitemKind.rate="";//费率
                    $scope.prpTitemKind.premium="";//保费
                    $scope.prpTitemKind.replyNo="";//标的清单
                }
                //暂时锁定主险附加险不能点击
                //判断是3134和3147，3141可以选附加险
                if (ele && ($scope.proposal.prpTmainDto.riskCode=='3134'|| $scope.proposal.prpTmainDto.riskCode=='3224' || $scope.proposal.prpTmainDto.riskCode=='3147' || $scope.proposal.prpTmainDto.riskCode=='3141'|| $scope.proposal.prpTmainDto.riskCode=='3124'|| $scope.proposal.prpTmainDto.riskCode=='3102')) {
                    ele=ele;
                    if(ele=='N'){
                        if($scope.proposal.prpTmainDto.riskCode=='3134'){
                            $scope.payDetail=false;
                        }else{
                            $scope.payDetail=true;
                        }
                        $scope.radioType=ele;
                    }else if(ele=='Y'){
                        $scope.payDetail=true;
                        $scope.radioType=ele;
                    }
                }else {
                    ele = 'Y'
                }
                if (showUpdata) {
                    return
                }
                //$scope.prpTitemKind.kindCode = ''
                //var flag;
                if (!ele)return;
                $scope.radioType = ele;
                if (ele === 'Y') {
                    getKindcode(1)
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        if (data.radioType == 'N') {
                            $scope.prpTitemKind.itemKindNo = index + 1;
                            //$scope.radioType = 'Y';
                            //flag = true
                        }
                    });
                    //只能选择一次主险信息
                    //if (!flag) {
                    //    $scope.radioType = 'Y'
                    //}
                } else if (ele === 'N') {
                    //如果是附加险赔付明细消失
                    $scope.radioType = 'N';
                    getKindcode(2)
                }

            };
            //获取标的类型
            //$scope.changeData = function (data, type) {
            //    if(data.codeName){
            //        $scope.prpTitemKind.kindName = data.codeName;
            //    }
            //    if (type == 'kindCode') {
            //        $$finder.find('initSelect', {
            //            "codeType": "ItemCode0",
            //            riskCode: $scope.proposal.prpTmainDto.riskCode,//险种
            //            reserve1: $scope.proposal.prpTmainDto.versionNo,//条款
            //            reserve2: data.codeCode
            //        }, {
            //            success: function (data) {
            //                $scope.itemDetailList = data.content.codeData
            //            },
            //        })
            //    }
            //}
            //获取标的序号/获取取消之后的存储未完成录入的数据
            //var itemNoMain = 1;
            //var getitemNoMain = function (celfig) {
            //    if ($scope.prpTitemKind.radioType == 'Y') {
            //        angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
            //            if (data.radioType == 'N') {
            //                $scope.prpTitemKind.itemKindNo = index;
            //            }
            //        })
            //    } else {
            //        $scope.prpTitemKind.itemKindNo = $scope.proposal.prpTitemKindDtoList.length + 1 || 1
            //    }
            //    if (celfig) {
            //        $scope.proposalcopy = angular.copy($scope.proposal.prpTitemKind);
            //        return
            //    }
            //    $scope.proposal.prpTitemKind = {};
            //    if ($scope.proposalcopy) {
            //        $scope.prpTitemKind = $scope.proposalcopy;
            //        $scope.prpTitemKind.itemKindNo = $scope.proposal.prpTitemKindDtoList.length + 1 || 1
            //    }
            //};
            $scope.doSaveFlagChange=function(){
                $scope.proposal.doSaveFlag=false
            }
            $scope.checkValue = function(attr,Field){
                if(Field){
                    Field = parseFloat(Field);
                    $scope.prpTitemKind[attr] = Field;
                }
            }
            //新增主险附加险保存按钮
            $scope.proposal.prpTfeeDto = $scope.proposal.prpTfeeDto || {}
            $scope.printSure = function () {

                var falg=false;
                //校验第一条是否是主险，如不是则提示
                if($scope.proposal.prpTitemKindDtoList&&$scope.proposal.prpTitemKindDtoList.length<=0){
                    if($scope.radioType=='N'){
                        layer.open({
                            /*offset: ['35%', '40%'],*/
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: '还未录入主险信息，请先录入主险信息！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return
                    }
                }else if($scope.proposal.prpTitemKindDtoList.length>0){
                    var i=0;
                    var flag2=false;
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        if (data.radioType == 'Y'&&data.flag.substr(0,1)!="D") {
                            i = i + 1
                            flag2=true;
                        }
                    });
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        if(index == 0 && index==indexUpdate && data.radioType!=$scope.radioType && $scope.radioType=='N' && updateMain && (i==0 || i==1)){
                            falg=true
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '还未录入主险信息，请先录入主险信息！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            updateMain=false;
                            return
                        }else{
                            return
                        }
                    })

                }
                if(falg){
                    return
                }

                var ary2 = [ 'rate', 'totalLossRatio', 'triggerPoint', 'shortRate', 'shortRateFlag', 'currency', 'model', 'itemDetailName', 'kindCode']
                if ($scope.proposal.prpTmainAgriDto.remark == '2') {
                    for (var i = 0; i < ary2.length; i++) {
                        var str = $scope.prpTitemKind[ary2[i]]
                        if (!str || str=="") {
                            if ((($scope.proposal.prpTmainDto.riskCode == '3129'|| $scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233'  ) && (ary2[i] == 'totalLossRatio' || ary2[i] == 'triggerPoint')) || (($scope.proposal.prpTmainDto.riskCode == '3237' || $scope.proposal.prpTmainDto.riskCode == '3224') && (ary2[i] == 'totalLossRatio'))) {
                                //不做处理
                            } else if (($scope.proposal.prpTmainDto.riskCode == '3134' && $scope.radioType == 'N' && (ary2[i] == 'totalLossRatio' || ary2[i] == 'triggerPoint'))) {
                                //赔付明细不做处理不做处理
                            } else if (($scope.proposal.prpTmainDto.riskCode == '3134' && $scope.radioType == 'Y' && ary2[i] == 'agriUnitOutputMain')) {
                                //赔付明细不做处理不做处理
                            }else if(str=="0" &&(ary2[i]=='triggerPoint' ||ary2[i]=='totalLossRatio')){
                                //不做处理
                            }else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,
                                    title: '温馨提示',
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                        } else if (str == "0.00") {
                            if ((($scope.proposal.prpTmainDto.riskCode == '3129'||$scope.proposal.prpTmainDto.riskCode == '3220' || $scope.proposal.prpTmainDto.riskCode == '3233') && (ary2[i] == 'totalLossRatio' || ary2[i] == 'triggerPoint')) || (($scope.proposal.prpTmainDto.riskCode == '3237') && (ary2[i] == 'totalLossRatio'))) {
                                //不做处理
                            } else if (($scope.proposal.prpTmainDto.riskCode == '3134' && $scope.radioType == 'N' && ( ary2[i] == 'totalLossRatio' || ary2[i] == 'triggerPoint'))) {
                                //赔付明细不做处理不做处理
                            }
                            //else if (($scope.proposal.prpTmainDto.riskCode == '3134' && $scope.radioType == 'Y' && ary2[i] == 'agriUnitOutputMain')) {
                            //    //赔付明细不做处理不做处理
                            //}
                            else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }


                        } else {
                            if (!$scope.prpTitemKind.replyNo && $scope.queryHide) {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '条款与清单的标的不同,请修改！',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                            if (!$scope.prpTitemKind.premium && $scope.prpTitemKind.premium != 0) {
                                $scope.totalPay = round($scope.prpTitemKind.premium, 2);
                                $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                                $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay
                            }
                            if (!$scope.prpTitemKind.amount && $scope.prpTitemKind.amount != 0) {
                                $scope.totalAmount = round($scope.prpTitemKind.amount, 2);
                                $scope.proposal.prpModelMainSubDto.sumAmount= $scope.totalAmount;
                                $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount;

                            }
                            $scope.currency = $scope.prpTitemKind.currency;
                            //$scope.proposal.prpTfeeDto.currency = $scope.prpTitemKind.currency;
                            var data = $scope.prpTitemKind;
                            //数字格式化
                            //data.premium = commonApiServ.roundToFixed2(data.premium);
                            if (!data.premium && data.premium!=0) {
                                data.premium = round(data.premium, 2);
                            }
                            //data.rate = commonApiServ.roundToFixed4(data.rate);
                            data.rate = data.rate;
                            if (!data.amount && data.amount!=0) {
                                data.amount = round(data.amount, 2);
                            }
                            data.agriGrossQuantityMain = data.agriGrossQuantityMain;
                            if (!data.unitAmount && data.unitAmount!=0) {
                                data.unitAmount = round(data.unitAmount, 2);
                            }
                            if(!data.agriUnitCostMain && data.agriUnitCostMain!=0){
                                data.agriUnitCostMain = round(data.agriUnitCostMain, 2);
                            }
                            data.totalLossRatio = data.totalLossRatio;
                            data.triggerPoint = data.triggerPoint;
                            data.deductibleRate = data.deductibleRate;
                            data.shortRate = data.shortRate;
                            data.quantity = data.agriGrossQuantityMain;//梳理数量  隐藏字段
                            //if ($scope.prpTitemKind.premium == "0.00") {
                            //    $scope.prpTitemKind.rate = "";
                            //}
                        }

                    }
                }else if($scope.proposal.prpTmainAgriDto.remark=='1'){
                    var ary = ['rate', 'totalLossRatio', 'triggerPoint', 'shortRate', 'shortRateFlag', 'currency', 'model', 'itemDetailName', 'kindCode']
                    for (var i = 0; i < ary.length; i++) {
                        var str = $scope.prpTitemKind[ary[i]]
                        if (!str || str=="") {
                            if((($scope.proposal.prpTmainDto.riskCode == '3129'||$scope.proposal.prpTmainDto.riskCode=='3220'|| $scope.proposal.prpTmainDto.riskCode=='3233') && (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))||(($scope.proposal.prpTmainDto.riskCode=='3237'||$scope.proposal.prpTmainDto.riskCode=='3224') &&(ary[i]=='totalLossRatio'))){
                                //不做处理

                            }else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='N'&& (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))){
                                //赔付明细不做处理不做处理
                            }
                            //else if($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='Y'&& ary[i]=='agriUnitCostMain'){
                            //    //赔付明细不做处理不做处理
                            //}
                            else if(str=="0" &&(ary[i]=='triggerPoint' ||ary[i]=='totalLossRatio')){
                                //不做处理
                            }else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                        }else  if(str == "0.00" ){
                            if((($scope.proposal.prpTmainDto.riskCode == '3129'||$scope.proposal.prpTmainDto.riskCode=='3220'|| $scope.proposal.prpTmainDto.riskCode=='3233') && (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))||(($scope.proposal.prpTmainDto.riskCode=='3237'|| $scope.proposal.prpTmainDto.riskCode=='3224')&&(ary[i]=='deductibleRate'||ary[i]=='totalLossRatio'||ary[i]=='agriUnitCostMain'))){
                                //不做处理
                            }else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='N'&& (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))){
                                //赔付明细不做处理不做处理
                            }
                            //else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='Y'&& ary[i]=='agriUnitCostMain')){
                            //    //赔付明细不做处理不做处理
                            //}
                            else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }


                        }else{
                            if(!$scope.prpTitemKind.replyNo&& $scope.queryHide){
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: '条款与清单的标的不同,请修改',
                                    btn: ['确定'],
                                    scrollbar: false,
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                            if (!$scope.prpTitemKind.premium && $scope.prpTitemKind.premium != 0) {
                                $scope.totalPay = round($scope.prpTitemKind.premium, 2);
                                $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                                $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay

                            }
                            if (!$scope.prpTitemKind.amount && $scope.prpTitemKind.amount != 0) {
                                $scope.totalAmount = round($scope.prpTitemKind.amount, 2);
                                $scope.proposal.prpModelMainSubDto.sumAmount= $scope.totalAmount;
                                $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount
                            }
                            $scope.currency = $scope.prpTitemKind.currency;
                            //$scope.proposal.prpTfeeDto.currency = $scope.prpTitemKind.currency;
                            var data = $scope.prpTitemKind;
                            //数字格式化
                            //data.premium = commonApiServ.roundToFixed2(data.premium);
                            if (!data.premium && data.premium!=0) {
                                data.premium = round(data.premium, 2);
                            }
                            //data.rate = commonApiServ.roundToFixed4(data.rate);
                            data.rate = data.rate;
                            if (!data.amount && data.amount!=0) {
                                data.amount = round(data.amount, 2);
                            }
                            data.agriGrossQuantityMain = data.agriGrossQuantityMain;
                            if (!data.unitAmount && data.unitAmount!=0) {
                                data.unitAmount = round(data.unitAmount, 2);
                            }
                            if(!data.agriUnitCostMain && data.agriUnitCostMain!=0){
                                data.agriUnitCostMain = round(data.agriUnitCostMain,2);
                            }
                            data.totalLossRatio = data.totalLossRatio;
                            data.triggerPoint = data.triggerPoint;
                            data.deductibleRate = data.deductibleRate;
                            data.shortRate = data.shortRate;
                            data.quantity= data.agriGrossQuantityMain;//梳理数量  隐藏字段

                            //**************--------批改专属----***************
                            // 如果是批改需要增加标志位 I ；
                            if ($scope.endorseFlag&&updateMain==false) {
                                data.flag = 'I'
                            }
                            //**************--------批改专属----***************

                            //新需求可以不录投保面积，所以此时的保费为0
                            //if($scope.prpTitemKind.premium=="0.00"){
                            //    $scope.prpTitemKind.rate="";
                            //}
                        }

                    }
                }else {
                    var ary = ['rate', 'totalLossRatio', 'triggerPoint', 'shortRate', 'shortRateFlag', 'currency', 'model', 'itemDetailName', 'kindCode']
                    for (var i = 0; i < ary.length; i++) {
                        var str = $scope.prpTitemKind[ary[i]]
                        if (!str || str == "") {
                            if((($scope.proposal.prpTmainDto.riskCode == '3129'||$scope.proposal.prpTmainDto.riskCode=='3220'|| $scope.proposal.prpTmainDto.riskCode=='3233') && (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))||(($scope.proposal.prpTmainDto.riskCode=='3237'||$scope.proposal.prpTmainDto.riskCode=='3224') &&(ary[i]=='totalLossRatio'))){
                                //不做处理

                            }else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='N'&& (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))){
                                //赔付明细不做处理不做处理
                            }else if(($scope.proposal.prpTmainDto.riskCode == '3129'&& (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))){
                                //赔付明细不做处理不做处理
                            }
                            //else if($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='Y'&& ary[i]=='agriUnitCostMain'){
                            //    //赔付明细不做处理不做处理
                            //}
                            else if(str=="0" &&( ary[i]=='triggerPoint' ||ary[i]=='totalLossRatio')){
                                //不做处理
                            }else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    scrollbar: false,
                                    title: '温馨提示',
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                        }else  if(str == "0.00" ){
                            if((( $scope.proposal.prpTmainDto.riskCode == '3129'||$scope.proposal.prpTmainDto.riskCode=='3220'|| $scope.proposal.prpTmainDto.riskCode=='3233') && (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))||(($scope.proposal.prpTmainDto.riskCode=='3237'|| $scope.proposal.prpTmainDto.riskCode=='3224')&&(ary[i]=='totalLossRatio'))){
                                //不做处理
                            }else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='N'&& (ary[i]=='totalLossRatio'||ary[i]=='triggerPoint'))){
                                //赔付明细不做处理不做处理
                            }
                            //else if(($scope.proposal.prpTmainDto.riskCode=='3134'&& $scope.radioType=='Y'&& ary[i]=='agriUnitCostMain')){
                            //    //赔付明细不做处理不做处理
                            //}
                            else {
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '<i class="mes_sign">*</i>为必填项，请填写',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }


                        }else{
                            if(!$scope.prpTitemKind.replyNo&& $scope.queryHide){
                                layer.open({
                                    /*offset: ['35%', '40%'],*/
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    scrollbar: false,
                                    content: '条款与清单的标的不同,请修改',
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return
                            }
                            if (!$scope.prpTitemKind.premium && $scope.prpTitemKind.premium != 0) {
                                $scope.totalPay = round($scope.prpTitemKind.premium, 2);
                                $scope.proposal.prpModelMainSubDto.sumPremium = $scope.totalPay;
                                $scope.proposal.prpTmainDto.sumPremium = $scope.totalPay

                            }
                            if (!$scope.prpTitemKind.amount && $scope.prpTitemKind.amount != 0) {
                                $scope.totalAmount = round($scope.prpTitemKind.amount, 2);
                                $scope.proposal.prpModelMainSubDto.sumAmount= $scope.totalAmount;
                                $scope.proposal.prpTmainDto.sumAmount = $scope.totalAmount
                            }
                            $scope.currency = $scope.prpTitemKind.currency;
                            //$scope.proposal.prpTfeeDto.currency = $scope.prpTitemKind.currency;
                            var data = $scope.prpTitemKind;
                            //数字格式化
                            //data.premium = commonApiServ.roundToFixed2(data.premium);
                            if (!data.premium && data.premium!=0) {
                                data.premium = round(data.premium, 2);
                            }
                            //data.rate = commonApiServ.roundToFixed4(data.rate);
                            data.rate = data.rate;
                            if (!data.amount && data.amount!=0) {
                                data.amount = round(data.amount, 2);
                            }
                            data.agriGrossQuantityMain = data.agriGrossQuantityMain;
                            if (!data.unitAmount && data.unitAmount!=0) {
                                data.unitAmount = round(data.unitAmount, 2);
                            }
                            if(!data.agriUnitCostMain && data.agriUnitCostMain!=0){
                                data.agriUnitCostMain = round(data.agriUnitCostMain,2);
                            }
                            data.totalLossRatio = data.totalLossRatio;
                            data.triggerPoint = data.triggerPoint;
                            data.deductibleRate = data.deductibleRate;
                            data.shortRate = data.shortRate;
                            data.quantity= data.agriGrossQuantityMain;//梳理数量  隐藏字段

                            //**************--------批改专属----***************
                            // 如果是批改需要增加标志位 I ；
                            if ($scope.endorseFlag&&updateMain==false) {
                                data.flag = 'I'
                            }
                            //**************--------批改专属----***************
                            //新需求可以不录投保面积，所以此时的保费为0
                            //if($scope.prpTitemKind.premium=="0.00"){
                            //    $scope.prpTitemKind.rate="";
                            //}
                        }

                    }
                }
                if(!$scope.prpTitemKind.replyNo&& $scope.queryHide){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '条款与清单的标的不同,请修改',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return
                }
                $scope.proposalcopy = {};
                //$scope.proposal.prpTfeeDto.currency = $scope.prpTitemKind.currency;
                $scope.prpTitemKind.radioType = $scope.radioType;
                var prpTitemKindDtoList = $scope.proposal.prpTitemKindDtoList || [];
                //主险在前按顺序插入
                if (updata) {
                    showUpdata = false;
                    updata = false
                    console.log(showUpdataindex)
                    prpTitemKindDtoList.splice(showUpdataindex, 1, angular.copy($scope.prpTitemKind))
                    $scope.showHide('showaddpage');
                    $scope.radioType = 'N';
                    gettotalAmount();
                    return
                }

                if ($scope.prpTitemKind.radioType == 'Y') {
                    if (prpTitemKindDtoList.length == 0 || $scope.proposal.prpTmainDto.riskCode=='3129'
                        || $scope.proposal.prpTmainDto.riskCode=='3147'  || $scope.proposal.prpTmainDto.riskCode=='3130'|| $scope.proposal.prpTmainDto.riskCode=='3134') {
                        prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind))
                    }else{
                        if( $scope.proposal.prpTmainDto.riskCode=='3141'){
                            for (var i = 0; i < prpTitemKindDtoList.length; i++) {
                                if (prpTitemKindDtoList[i].radioType == 'Y') {
                                    if("331c1,AA110,AA210".indexOf((prpTitemKindDtoList[i].itemCode))>=0 && "331c1,AA110,AA210".indexOf($scope.prpTitemKind.itemCode)>=0){
                                        prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind));
                                        break;
                                    }else if("331c2,AA120,AA220".indexOf((prpTitemKindDtoList[i].itemCode))>=0 && "331c2,AA120,AA220".indexOf($scope.prpTitemKind.itemCode)>=0){
                                        prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind));
                                        break;
                                    }else if("331c3,AA130,AA230".indexOf((prpTitemKindDtoList[i].itemCode))>=0 && "331c3,AA130,AA230".indexOf($scope.prpTitemKind.itemCode)>=0){
                                        prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind));
                                        break;
                                    }else if("331c4,AA140,AA240".indexOf((prpTitemKindDtoList[i].itemCode))>=0 && "331c4,AA140,AA240".indexOf($scope.prpTitemKind.itemCode)>=0){
                                        prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind));
                                        break;
                                    }
                                    else{
                                        layer.open({
                                            /*offset: ['35%', '40%'],*/
                                            skin: 'large-layer-content',
                                            closeBtn: 0,
                                            title: '温馨提示',
                                            scrollbar: false,
                                            content: '3141险种只能录入同一类型多个主险',
                                            btn: ['确定'],
                                            btn1: function (index, layero) {
                                                //按钮【按钮一】的回调
                                                layer.close(index);
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    }
                    var prpTitemKindCopyDtoList=prpTitemKindCopyDtoList||[]
                    for (var i = 0; i < prpTitemKindDtoList.length; i++) {
                        if (prpTitemKindDtoList[i].radioType == 'Y') {
                            prpTitemKindCopyDtoList.push(prpTitemKindDtoList[i])
                        }
                    }
                    for (var i = 0; i < prpTitemKindDtoList.length; i++) {
                        if (prpTitemKindDtoList[i].radioType == 'N') {
                            prpTitemKindCopyDtoList.push(prpTitemKindDtoList[i])
                        }
                    }
                    $scope.proposal.prpTitemKindDtoList=prpTitemKindCopyDtoList;
                } else {
                    prpTitemKindDtoList.push(angular.copy($scope.prpTitemKind))
                }
                angular.forEach(prpTitemKindDtoList, function (data, index) {

                    data.proposalNo = $scope.proposal.prpTmainDto.proposalNo;
                    data.riskCode = $scope.proposal.prpTmainDto.riskCode;
                    prpTitemKindDtoList[index].itemKindNo = index + 1;
                    data.calculateFlag=data.radioType;//prpTitemKindDtoList标识位

                    //**************--------批改专属----***************
                    // 如果是批改需要增加标志位 I ；
                    if ($scope.endorseFlag) {
                        if(data.flag){
                            if(data.radioType==='Y'){
                                data.flag =data.flag+"1";
                            }else if(data.radioType==='N'){
                                data.flag =data.flag+"2";
                            }
                        }else{
                            if(data.radioType==='Y'){
                                data.flag=' 1';
                            }else if(data.radioType==='N'){
                                data.flag=' 2';
                            }
                        }

                    }else{
                        if(data.radioType==='Y'){
                            data.flag=' 1';
                        }else if(data.radioType==='N'){
                            data.flag=' 2';
                        }
                    }
                    //**************--------批改专属----***************
                    data.startDate=$scope.proposal.prpTmainDto.startDate;//起始日期
                    data.startHour=$scope.proposal.prpTmainDto.startHour;//起始小时
                    data.endDate=$scope.proposal.prpTmainDto.endDate;//终止日期
                    data.endHour=$scope.proposal.prpTmainDto.endHour;//终止小时
                });
                gettotalAmount();
                $scope.showHide('showaddpage');
                $scope.radioType = 'N';
                if($scope.proposal.prpTmainDto.riskCode=='3134'||$scope.proposal.prpTmainDto.riskCode=='3147'||$scope.proposal.prpTmainDto.riskCode=='3224'||$scope.proposal.prpTmainDto.riskCode=='3141'||$scope.proposal.prpTmainDto.riskCode=='3129'){
                    $scope.mainOrSubMain=false;
                }else if($scope.proposal.prpTmainDto.riskCode=='3107'|| $scope.proposal.prpTmainDto.riskCode=='3162'
                    || $scope.proposal.prpTmainDto.riskCode=='3155'|| $scope.proposal.prpTmainDto.riskCode=='3108'
                    || $scope.proposal.prpTmainDto.riskCode=='3220'||$scope.proposal.prpTmainDto.riskCode=='3233'
                    ||$scope.proposal.prpTmainDto.riskCode=='3237'||$scope.proposal.prpTmainDto.riskCode=='3101'
					||$scope.proposal.prpTmainDto.riskCode=='3114'||$scope.proposal.prpTmainDto.riskCode=='3122'
					||$scope.proposal.prpTmainDto.riskCode=='3126'||$scope.proposal.prpTmainDto.riskCode=='3161'
                    || $scope.proposal.prpTmainDto.riskCode == '3149'){
                    $scope.mainOrSubMain=true;
                }
                gettotalAmount();
                updata=false;
            };
            //获取保费

            //$scope.$watch('prpTitemKind.rate', function (newvalue) {
            //  $scope.prpTitemKind.rate=$scope.Mun($scope.prpTitemKind.rate||'')
            //  //去保费的四舍五入值保留两位小数
            //  $scope.prpTitemKind.preMium = Math.round($scope.prpTitemKind.amount * $scope.prpTitemKind.rate*$scope.prpTitemKind.shortRate/100)/ 100||''
            //  console.log($scope.prpTitemKind.preMium)
            //})
            $scope.$watch('proposal.prpTmainAgriDto.remark', function (newValue) {
                if (newValue == '2') {
                    $scope.showprice = true;
                    if($scope.proposal.prpTmainDto.riskCode =='3107'||$scope.proposal.prpTmainDto.riskCode =='3108'
                        || $scope.proposal.prpTmainDto.riskCode =='3155'||$scope.proposal.prpTmainDto.riskCode =='3162'
                        || $scope.proposal.prpTmainDto.riskCode =='3101'||$scope.proposal.prpTmainDto.riskCode =='3122'
                        || $scope.proposal.prpTmainDto.riskCode =='3114'||$scope.proposal.prpTmainDto.riskCode =='3126'
                        || $scope.proposal.prpTmainDto.riskCode =='3161'|| $scope.proposal.prpTmainDto.riskCode == '3149'
                    ){
                        $scope.isagriTimesAmount = true;
                    }
                } else {
                    $scope.showprice = false
                }
            })

            $scope.changePolicyType = function () {
                var configRisk = '2799-2705-2709-2712-2719-2720-2721-2722'; //混合险种：团、个单都能录入
                var riskCode1 = $scope.proposal.prpTmainDto.riskCode;
                var editType = $scope.proposal.editType;
                var policyType = $scope.proposal.prpTmainDto.businessType1;

                if (configRisk.indexOf(riskCode1) > -1) {
                    if (editType == "UPDATE") //修改时不能更改保单类型
                    {
                        if (policyType == "02")
                            $scope.PolicyType[policyType].codeName = '01_FIELD_SEPARATOR_集体';
                        else
                            $scope.PolicyType[policyType].codeName = '01_FIELD_SEPARATOR_个人';
                        return;
                    }
                    if (confirm("录入团单点\"确定\"，录入个单点\"取消\"") == true) {
                        $scope.policyType == "02";
                        $scope.PolicyType[policyType].codeName = '01_FIELD_SEPARATOR_集体';
                    } else {
                        $scope.policyType == "01";
                        $scope.PolicyType[policyType].codeName = '01_FIELD_SEPARATOR_个人';
                    }
                } else if (checkPlantingFarmerListFlag(riskCode1)) {
                    if (policyType == "H11" || policyType == "H12" || policyType == "H22") {
                        trCreateCirculationAreaTitle.style.display = "";
                    } else {
                        trCreateCirculationAreaTitle.style.display = "none";
                    }
                }
            }
            function checkPlantingFarmerListFlag(strRiskCode) {
                if (strRiskCode == '0311') {
                    return false;
                }
                var plantingFarmerListFlag = "3101";
                if (null != plantingFarmerListFlag && plantingFarmerListFlag.indexOf(strRiskCode) > -1)
                    return true;
                else return false;
            }

            //邮政编号地址信息校验
            $scope.checkLength = function (target) {
                var value = target.value;
                var length = target.length;
                var str;
                var count = 0;
                if (value == "") {
                    return true;
                }
                if (value.indexOf("^") > -1) {
                    alert("^为系统保留字符，不允许输入！");
                    $scope.proposal.prpTaddressDto.addressName = "";
                    return false;
                }
                for (var i = 0; i < value.length; i++) {
                    str = escape(value.charAt(i));
                    if (str.substring(0, 2) == "%u" && str.length == 6)
                        count = count + 2;
                    else
                        count = count + 1
                }
                if (count > length) {
                    alert("输入的内容超长!\n最大长度为255个英文字母!\n请重新输入!");
                    $scope.proposal.prpTaddressDto.addressName = "";
                }
            }
            //target代表当前节点,p是可输入的长度,s是小数点的可输入长度,minValue代表输入的最小值,maxValue代表输入的最大值
            $scope.checkDecimal = function (event, p, s, MinValue, MaxValue) {
                var strValue = event.target.value;
                if (strValue == "") {
                    strValue = "0";
                }
                var num = Number(strValue);
                if (isNaN(num)) {
                    alert("请输入合法的数字");
                    event.target.value = "";
                    return false;
                }
                $scope.parseInt = parseInt;
                p = parseInt(p, 10);
                s = parseInt(s, 10);
                var pLength;
                var sLength;
                var positions = strValue.indexOf(".");
                if (positions > -1) {
                    pLength = positions;
                    sLength = strValue.length - positions - 1;
                } else {
                    pLength = strValue.length;
                    sLength = 0;
                }
                if (pLength > (p - s) || sLength > s) {
                    alert("请输入合法的值\n整数位最长为" + (p - s) + "\n小数位最长为" + s);
                    //$scope.proposal.prpTsubsidyDto.subsidyRate = "";
                    event.target.value = "";
                    return false;
                }
                var value = (strValue);
                if (MaxValue != null && MinValue != null && MaxValue != "" && MinValue != "") {
                    MinValue = parseFloat(MinValue);
                    MaxValue = parseFloat(MaxValue);
                    if (isNaN(value) || value > MaxValue || value < MinValue) {
                        alert("请输入合法的值\n类型为数字,最小值为" + MinValue + ",最大值为" + MaxValue);
                        //$scope.proposal.prpTsubsidyDto.subsidyRate = "";
                        event.target.value = "";
                        return false;
                    }
                }
                return true;
            };

            $scope.getElementOrder = function (field) {
                var i = 0;
                var order = 0;
                //获取fieId.name这个节点
                var elements = document.getElementsByName(field.name);
                //获取节点的长度(应为节点是一个数组,所以可以得到他的长度)
                var elementsCount = elements.length;
                for (i = 0; i < elementsCount; i++) {
                    order++;
                    if (elements[i] == field) {
                        break;
                    }
                }
                return order;
            };

            $scope.tabBtn2 = true;
            $scope.showPageOnly = function () {
                $scope.tabBtn2 = !$scope.tabBtn2;
            };
            //判断币别是否一直的方法，保单币别和支付币别
            $scope.checkExchangeRateFee = function ($event, strFlag) {
                var strMessage = "";
                var index = 0;
                var valueName;
                var CurrencyNum;
                if (strFlag == 2) {
                    valueName = $scope.proposal.prpTfeeDto.exchangeRate2;
                    CurrencyNum = $scope.proposal.prpTfeeDto.currency2;
                } else if (strFlag == 1) {
                    valueName = $scope.proposal.prpTfeeDto.exchangeRate1;
                    CurrencyNum = $scope.proposal.prpTfeeDto.currency1;
                }
                var dbExchangeRate21 = parseFloat(valueName);
                if (isNaN(dbExchangeRate21)) {
                    dbExchangeRate21 = 0;
                }
                if ($scope.proposal.prpTfeeDto.currency == CurrencyNum && dbExchangeRate21 != 1) {
                    if (strFlag == 2) {
                        strMessage = "保单汇总币别的";
                    } else {
                        strMessage = "支付保费币别的";
                    }
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: strMessage + '折币币别与原币币别相同，兑换率不能修改！',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            layer.close(index);
                        },
                    })
                    if (strFlag == 2) {
                        $scope.proposal.prpTfeeDto.exchangeRate2 = "1.0000";
                    } else if (strFlag == 1) {
                        $scope.proposal.prpTfeeDto.exchangeRate1 = "1.0000";
                    }
                    return false;
                }
                return true;
            };
            //计算总的基准保费
            function sumBenchMarkPreimum() {
                var strEditType = $scope.proposal.editType;//获取编辑类型
                var sumBenMarkPremium = 0;//总的基准保费
                //对编辑类型进行校验,如果是新保则sumBenMarkPremium赋值是sumBenchMarkPremium
                //元素的值,否则为0.非新保时只能是个单才可以复制.因此为0是正确的.
                if (strEditType == "COPY_PROPOSAL" || strEditType == "COPY_POLICY" || strEditType == "RENEWAL") {
                    sumBenMarkPremium = 0;
                } else {
                    angular.forEach($scope.proposal.prpTitemKindDtoList, function (data, index) {
                        sumBenMarkPremium += parseFloat(data.basePremium);
                    })
                }
                calculateSubsidyFee();//计算补贴金额 回写到页面
            }

            //计算政府补贴金额
            function calculateSubsidyFee() {
                var sumBenchMark = $scope.totalPay;//这里就是总保费
                var SubsidyPremium = 0;//每个补贴金额
                var subsidyPremium = 0; //总的补贴金额
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                    if (data.subsidyType == "01") {
                        data.subsidyPremium=0;
                        if (index == $scope.proposal.prpTsubsidyDtoList.length - 1) {
                            //最后一笔政府补贴金额＝总保费－自缴－已计算得政府补贴
                            data.subsidyPremium = round((sumBenchMark - sumBenchMark * $scope.selfRate / 100 - subsidyPremium),2);
                        } else {
                            //补贴金额计算  总保费*补贴比例=总的基准保费*补贴金额
                            //subsidyRate每个补贴比例
                            SubsidyPremium = (Math.round(parseFloat(sumBenchMark) * parseFloat(data.subsidyRate) * 100)) / 10000;
                            SubsidyPremium = round(SubsidyPremium,2);
                            subsidyPremium += parseFloat(SubsidyPremium);//总的补贴金额
                            //console.log(subsidyPremium)
                            data.subsidyPremium = SubsidyPremium;
                        }
                    }
                });
                getCollectItemKindFee(); //第三步币别信息表回写
            }

            $scope.checksubsidyRate=function(index){
                $scope.proposal.prpTsubsidyDtoList[index].subsidyRate=$scope.proposal.prpTsubsidyDtoList[index].subsidyRate;
            }
            $scope.checkPremiummm  =function(index){
                $scope.proposal.doSaveFlag=false;
                var totalrate;
                angular.forEach($scope.proposal.prpTsubsidyDtoList,function(data,index){
                    totalrate+=(data.subsidyRate*1)
                })
                if(totalrate>100){
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '补贴比例不能大于100',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    $scope.proposal.prpTsubsidyDtoList[index].subsidyRate="";
                    $("#subsidyRate"+index).blur();
                }else if (totalrate<=0){
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '补贴比例不能小于0',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                    $scope.proposal.prpTsubsidyDtoList[index].subsidyRate="";
                    $("#subsidyRate").blur();
                }
            }
            //根据补贴金额计算补贴比例
            $scope.checkExchangeRateFee1 = function (x, index) {

                //非比例补贴
                if (x == "02") {
                    var sumBenchMark = $scope.totalPay;//sumBenchMarkPreimum();//这里就是总保费
                    var list = $scope.proposal.prpTsubsidyDtoList;
                    list[index].subsidyRate = list[index].subsidyPremium / sumBenchMark;
                    if(list[index].subsidyRate){
                        list[index].subsidyRate=0
                    }
                }
            }
            //对数字进行格式化,保证precision位
            function point(number, precision) {
                if (isNaN(number))
                    number = 0;
                var result = number.toString();
                if (result.indexOf(".") == -1)
                    result = result + ".";

                result = result + newString("0", precision);
                result = result.substring(0, precision + result.indexOf(".") + 1);
                return result;
            }

            //对数字四舍五入
            //数值,精度
            function round(number, precision) {
                if (isNaN(number))
                    number = 0;
                var prec = Math.pow(10, precision);
                var result = Math.round(number * prec);
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

            //对数字四舍五入
            //数值,精度
            function round1(number, precision) {
                if (isNaN(number))
                    number = 0;
                var prec = Math.pow(10, precision);
                var result = Math.round(number * prec);
                result = result / prec;
                ////小数点后只有一位数时，自动补零
                //var xsd=result.toString().split(".");
                //if(xsd.length>1){
                //    if(xsd[1].length<2){
                //        result=result.toString()+"0";
                //    }
                //}
                //if(xsd.length==1){
                //    result=result+".00";
                //}
                return result;
            }

            /**
             * 将给定字符串复制ｎ遍
             * @param intLength 字符串长度
             * @return 字符串
             */
            function newString(iString, iTimes) {
                var str = "";
                for (var i = 0; i < iTimes; i++)
                    str = str + iString;
                return str;
            }

            //补贴方式
            $scope.checkBusinessType1 = function () {
                var varBusinessType = $scope.proposal.prpTmainDto.businessType1;//获取保险类型
                if (varBusinessType == '00') {
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '商业性保险不能录入补贴信息',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                }
            }
            //补贴类型
            $scope.checkSubsidyType = function (target, index) {
                if (index != 0) {
                    if (index == 1) {
                        if ($scope.proposal.prpTsubsidyDtoList[0].subsidyCode == $scope.proposal.prpTsubsidyDtoList[1].subsidyCode) {
                            layer.open({
                                /*offset: ['35%', '40%'],*/
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                scrollbar: false,
                                content: '第1条和第2条补贴类型相同,请更改!',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                },
                            })
                            $scope.proposal.prpTsubsidyDtoList[1].subsidyCode = " ";
                            //$scope.addEquipmentFlag = true;
                            return false;
                        } else {
                            $scope.addEquipmentFlag = false;
                        }
                    } else {
                        for (var i = 0; i <= index; i++) {
                            for (var j = i + 1; j <= index; j++) {
                                if ($scope.proposal.prpTsubsidyDtoList[i].subsidyCode == $scope.proposal.prpTsubsidyDtoList[j].subsidyCode) {
                                    layer.open({
                                        /*offset: ['35%', '40%'],*/
                                        skin: 'large-layer-content',
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        scrollbar: false,
                                        content: "第" + (i + 1) + "条和第" + (j + 1) + "条补贴类型相同,请更改!",
                                        btn: ['确定'],
                                        btn1: function (index, layero) {
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        },
                                    })
                                    $scope.proposal.prpTsubsidyDtoList[j].subsidyCode = " ";
                                    //$scope.addEquipmentFlag = true;
                                    return false;
                                } else {
                                    $scope.addEquipmentFlag = false;
                                }
                            }
                        }
                    }
                }
                if ($scope.proposal.prpTmainDto.businessType1 == "02") {
                    if (target == "03") {
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: "地方政策，不能录入中央补贴类型！",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            },
                        })
                        $scope.proposal.prpTsubsidyDtoList[index].subsidyCode = " ";
                    }
                }
            };
            /**
             * 在录入政府补贴之前判断该保单业务是不是商业保险
             */
            $scope.addEquipment = function () {
                var varBusinessType = $scope.proposal.prpTmainDto.businessType1;//获取保险类型
                var length = $scope.proposal.prpTsubsidyDtoList.length;//长度
                if (varBusinessType == '00') {
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '商业性投保不可录入补贴信息',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                } else if (length == 5) {//补贴方式最多5种
                    layer.open({
                        /* offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '补贴方式最多5种',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                } else if (varBusinessType == "") {
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '请选择政策/商业标志',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        },
                    })
                } else {
                    var newObject = {
                        "proposalNo": $scope.proposal.prpTmainDto.proposalNo,
                        "riskCode": $scope.proposal.prpTmainDto.riskCode,
                        "classCode": $scope.proposal.prpTmainDto.classCode,
                        "comCode": $scope.proposal.prpTmainDto.comCode,
                        "currency": $scope.proposal.prpTfeeDto.currency,
                        "subsidyCode": "", //补贴类型
                        "subsidyType": '01', //补贴方式
                        "subsidyDepartment": "", //补贴单位
                        "subsidyRate": "", //补贴比例
                        "subsidyPremium":"", //补贴金额
                    };
                    $scope.proposal.prpTsubsidyDtoList.push(newObject); //后续添加model后再修改

                }
            };
            //补贴信息删除
            $scope.deletenNew = function (index) {
                $scope.proposal.prpTsubsidyDtoList.splice(index, 1);
            };
            $scope.checkExchangeRateFee1 = function (x, index) {
                //非比例补贴
                if (x == "02") {
                    // var sumBenchMark = 10000;
                    sumBenchMarkPreimum();//这里就是总保费
                    var list = $scope.proposal.prpTsubsidyDtoList;
                    list[index].subsidyRate = (list[index].subsidyPremium / sumBenchMark) / 100;
                }
            }
            //新增缴费计划
            $scope.addPayPlan = function(){
                var newObj = {
                    "payNo":"",
                    "serialNo":"",
                    "payReason":"",
                    'payReasonName':"",
                    "planStartDate": "",//缴费起期
                    "planDate": "",//缴费止期
                    "planRate":"",
                    "currency":$scope.proposal.prpTfeeDto.currency2,//币别
                    "planFee": "",//应缴金额
                    "delinquentFee": ""//拖欠金额
                };
                // 如果是批改需要增加标志位 I ；
                if ($scope.endorseFlag) {
                    newObj.flag = 'I'
                }
                //**************--------批改专属----***************
                $scope.proposal.prpTplanDtoList.push(newObj);

            };
            //新增缴费计划选择缴费原因赋缴费期次
            $scope.ChangeReason = function (tplan) {
                var Field = tplan.payReason;
                var newList = [];
                var flag = false;//用于校验选择的补贴类型缴费计划原因类型是否在补贴类型中
                var strGovPayReason = "";
                if(Field!="R10"){//去除自缴2保费原因
                    angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                        if (data.subsidyCode == "03") {
                            strGovPayReason = "RS3";
                        } else if (data.subsidyCode == "04") {
                            strGovPayReason = "RS4";
                        } else if (data.subsidyCode == "05") {
                            strGovPayReason = "RS5";
                        } else if (data.subsidyCode == "06") {
                            strGovPayReason = "RS6";
                        } else if (data.subsidyCode == "07") {
                            strGovPayReason = "RS7";
                        }
                        if (strGovPayReason == Field) {
                            flag = true;
                        }
                    });
                    if (!flag) {
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "不存在此类型的缴费原因！",
                            scrollbar: false,
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                layer.close(index);
                            }
                        });
                        tplan.payReason = " ";//将缴费原因置为空
                    }
                }
            };
            $scope.CheckSerialNo = function () {
                var newCentralList = [];//中央财政
                var newProvinceList = [];//省级财政
                var newCityList = [];//地市财政
                var newOtherList = [];//其他来源
                var newTownList = [];//县(区)来源
                var newFList = [];//自缴
                var newprpTplanDtoList = [];
                angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                    if (data.payReason == "RS3") {
                        newCentralList.push(data);
                    } else if (data.payReason == "RS4") {
                        newProvinceList.push(data);
                    } else if (data.payReason == "RS5") {
                        newCityList.push(data);
                    } else if (data.payReason == "RS6") {
                        newOtherList.push(data);
                    } else if (data.payReason == "RS7") {
                        newTownList.push(data);
                    } else {
                        newFList.push(data);
                    }
                });
                angular.forEach(newCentralList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                angular.forEach(newProvinceList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                angular.forEach(newCityList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                angular.forEach(newOtherList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                angular.forEach(newTownList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                angular.forEach(newFList, function (data, index) {
                    newprpTplanDtoList.push(data);
                });
                //----------------------设置serialNo序号开始---------------------
                angular.forEach(newprpTplanDtoList, function (data, index) {
                    data.serialNo = index + 1;
                });
                //----------------------设置serialNo序号结束---------------------
                //----------------------重置payNo缴费期次开始---------------------
                angular.forEach(newprpTplanDtoList, function (data, index) {
                    data.payNo = index + 1;
                });
                angular.forEach(newProvinceList, function (data, index) {
                    data.payNo = index + 1;
                });
                angular.forEach(newCityList, function (data, index) {
                    data.payNo = index + 1;
                });
                angular.forEach(newOtherList, function (data, index) {
                    data.payNo = index + 1;
                });
                angular.forEach(newTownList, function (data, index) {
                    data.payNo = index + 1;
                });
                angular.forEach(newFList, function (data, index) {
                    data.payNo = index + 1;
                });
                //----------------------重置payNo缴费期次结束---------------------
                $scope.checkPayNo(); //回写右上角缴费次数框
            }
            //----------------------回写右上角缴费次数框开始---------------------
            $scope.checkPayNo = function () {
                var maxPayNo = 1;
                angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                    if (data.payNo > maxPayNo) {
                        maxPayNo++;
                    }
                });
                $scope.proposal.prpTmainDto.payTimes = maxPayNo;
            }
            //----------------------回写右上角缴费次数框结束---------------------
            //校验缴费计划的缴费止期不能大于缴费起期
            $scope.CheckDate = function (planStartDate, planDate) {
                var planStartDate = parseInt(planStartDate.replace(/-/g, ""), 10);
                var planDate = parseInt(planDate.replace(/-/g, ""), 10);
                if (planStartDate > planDate) {
                    layer.open({
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: "缴费止期不能大于缴费起期！",
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            };
            //新增 缴费计划将应缴金额赋值给拖欠金额
            $scope.checkDelinquentFee = function(tplan){
                tplan.delinquentFee = tplan.planFee;
            };
            //根据输入的应缴金额反算比例
            $scope.checkPlanRate = function(tplan){
                var payReason = tplan.payReason;
                var newList = [];
                var sumPlanRate = 0;
                var sumSubsidyRate = 0;//补贴比例之和
                var strGovPayReason = "";
                var charge = 0;
                var sumcharge = 0;
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                    if (data.subsidyCode == "03") {
                        strGovPayReason = "RS3";
                    } else if (data.subsidyCode == "04") {
                        strGovPayReason = "RS4";
                    } else if (data.subsidyCode == "05") {
                        strGovPayReason = "RS5";
                    } else if (data.subsidyCode == "06") {
                        strGovPayReason = "RS6";
                    } else if (data.subsidyCode == "07") {
                        strGovPayReason = "RS7";
                    }
                    if(payReason==strGovPayReason){
                        sumPlanRate = data.subsidyRate;
                        charge = data.subsidyPremium;
                    }
                    sumSubsidyRate +=parseFloat(data.subsidyRate);
                    sumcharge +=parseFloat(data.subsidyPremium);
                });
                if(sumPlanRate==0){//如果sumPlanRate==0则表示不是政府补贴
                    sumPlanRate = 100-sumSubsidyRate;
                }
                if(charge==0){//sumcharge为0代表是非补贴部分
                    charge =$scope.totalPay - sumcharge;//总保费减去补贴 部分的费用就是自缴部分的费用
                }
                angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {//将当前原因的缴费信息提出来
                    if(data.payReason==payReason){
                        newList.push(data);
                    }
                });
                //newList的长度肯定大于等于1条
                var length = newList.length;
                var SumRate = 0;
                var rate = 0;
                if (length > 1) {//代表新增的缴费原因是先删除在新增的,因为不能添加没有补贴类型的缴费原因
                    angular.forEach(newList, function (data1, index1) {
                        if(index1==length-1){//最后一条做尾差处理
                            data1.planRate =round(sumPlanRate - SumRate,2);
                        }else{
                            rate = round(data1.planFee*sumPlanRate/charge,2);
                            data1.planRate = rate;
                        }
                        SumRate+= round(rate,2);
                    });
                }else{
                    tplan.planRate = sumPlanRate;
                }
                $scope.setPremiumFlag();//改变应缴金额时需要重新点击共保计算，防止比例发生改变
            };
            /**
             * name 缴费信息新增
             * @param n 将要变化的“自缴期数”；
             */
            $scope.changePayTplan = function (n,flag) {
                //if(flag&&flag!='R10'&&flag!='R20')return;
                n = Math.abs(Number(n));
                if (!n){
                    $scope.proposal.prpTmainDto.payTimes=0;
                    n=0
                };
                var subsidyList = []; // 补贴list
                var paymentList = []; // 自缴list
                /* angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                 if (data.payReasonName =="分期收保费"||data.payReasonName =="签单收保费") { // 自定义标志；标识以区分政府补贴信息自缴部分
                 paymentList.push(data)
                 }
                 });*/
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                    if (data.payReason == '1') { // 自定义标志；标识以区分政府补贴信息自缴部分
                        paymentList.push(data)
                    }
                });
                // 补贴部分获取
                subsidyList = [];
                var strGovPayReason = "";
                var GovPayReasonName = "";
                var sumSubsidyRate=0;//补贴比例之和
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                    sumSubsidyRate+=parseFloat(data.subsidyRate);
                    if (data.subsidyCode == "03") {
                        strGovPayReason = "RS3";
                        GovPayReasonName = "中央财政";
                    } else if (data.subsidyCode == "04") {
                        strGovPayReason = "RS4";
                        GovPayReasonName = "省级财政";
                    } else if (data.subsidyCode == "05") {
                        strGovPayReason = "RS5";
                        GovPayReasonName = "地市财政";
                    } else if (data.subsidyCode == "06") {
                        strGovPayReason = "RS6";
                        GovPayReasonName = "其他来源";
                    } else if (data.subsidyCode == "07") {
                        strGovPayReason = "RS7";
                        GovPayReasonName = "县(区)来源";
                    }
                    var newObj = {
                        "payReason": strGovPayReason,
                        'payReasonName':GovPayReasonName,
                        "planStartDate": $scope.proposal.prpTmainDto.startDate,//缴费起期
                        "planDate": $scope.proposal.prpTmainDto.endDate,//缴费止期
                        "planRate":data.subsidyRate,
                        "currency": $scope.proposal.prpTfeeDto.currency2,//币别
                        "planFee": round(data.subsidyPremium,2),//应缴金额
                        "delinquentFee": round(data.subsidyPremium,2)//拖欠金额
                    };
                    subsidyList.push(newObj);
                    newObj = null
                });
                /*if(paymentList.length==0){
                 n = n + subsidyList.length;
                 }*/
                n = n + subsidyList.length;
                var paymentLen = n - subsidyList.length; // 将要变化自缴的
                // 崩溃问题限制 “自缴的“输入最大值为4  ； “自缴的缴费计划”不能为0

                if (paymentLen.length <= 0) {
                    return
                }

                // 自缴部分计算
                var intStartDate = (new Date($scope.proposal.prpTmainDto.startDate)).getTime(); // 保险起期的毫秒数
                var intEndDate = (new Date($scope.proposal.prpTmainDto.endDate)).getTime();     // 保险止期的毫秒数
                var intDispersion = Math.floor((intEndDate - intStartDate) / paymentLen); // 保险期间平均的毫秒数
                var newObject = {// 添加的新元素
                    "payReason": "R10", // 自缴保费
                    "planStartDate": "",
                    "planDate": "",
                    "currency": "",
                    "planFee": "",
                    "delinquentFee": ""
                };
                var disparityLen = paymentLen - paymentList.length; // 差距的条数
                if (disparityLen > 0) {
                    for (var i = 0; i < disparityLen; i++) { // 补齐
                        paymentList.push(angular.copy(newObject))
                    }
                } else { // 去除多余元素
                    paymentList.slice(0, disparityLen)
                }

                // 补贴金额
                var subsidyPremium = 0;
                angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                    subsidyPremium += Number(data.subsidyPremium)
                });
                subsidyPremium=round(subsidyPremium,2)
                // 应缴金额 (总保费减去补贴金额)
                var payNo = round($scope.totalPay - subsidyPremium,2);
                // 改变自缴信息
                angular.forEach(paymentList, function (data, index) {
                    var intDateSub = 0;
                    var dateSub;
                    var endDateSub;
                    intDateSub = intStartDate+intDispersion*index;
                    dateSub = new Date(intDateSub);
                    endDateSub = getNextDateFullDate(convertFullDateToString(dateSub),30);
                    endDateSub=new Date(Date.parse(endDateSub.replace(/-/g,   "/"))).getTime();
                    data.planStartDate = $filter('date')(new Date(intStartDate + intDispersion * index), 'yyyy-MM-dd');
                    data.planDate = $filter('date')(new Date(endDateSub), 'yyyy-MM-dd');
                    data.planFee = round(payNo / paymentLen,2);  // 应缴金额
                    data.delinquentFee = round(data.planFee,2);  // 拖欠金额
                    data.currency = data.currency || $scope.proposal.prpTfeeDto.currency2; // 币别
                    data.payreFee =round(data.payreFee,2) || 0; // 实际缴纳金额
                    data.payNo = index; // 支付期号
                });
                // 更新自缴期数
                $scope.proposal.prpTmainDto.payTimes = paymentLen;

                $scope.proposal.prpTplanDtoList = subsidyList.concat(paymentList);
                //$scope.proposal.prpTmainDto.payTimes=$scope.proposal.prpTplanDtoList.length;
                var datanum = 0,tttplan=0;
                /* if(paymentList){
                 angular.forEach($scope.proposal.prpTplanDtoList, function (data) {
                 if(data.payReasonName=="签单收保费"){
                 data.payReason='R20';
                 return;
                 }
                 })
                 }*/
                angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                    data.payreFee = round((data.planFee - data.delinquentFee),2);
                    var num;
                    data.serialNo = index + 1;
                    if (data.payReason != 'R10') {
                        data.payNo = 1;
                        datanum++;
                    } else {
                        $scope.proposal.prpTplanDtoList[datanum].payReason='R10'
                        if(index!=$scope.proposal.prpTplanDtoList.length-1){
                            tttplan+=(data.planFee*1)
                        }
                        num = index+1 - datanum;
                        data.payNo = num;
                        data.planRate = 100-sumSubsidyRate;
                    }
                })
                $scope.proposal.prpTplanDtoList[$scope.proposal.prpTplanDtoList.length-1].planFee=round((payNo-tttplan),2);
                $scope.proposal.prpTplanDtoList[$scope.proposal.prpTplanDtoList.length-1].delinquentFee=round((payNo-tttplan),2);
            };

            //缴费计划操作删除
            $scope.changePayTplan2=function(n){
                //$scope.proposal.prpTplanDtoList.splice(n,1);
                //$scope.proposal.prpTmainDto.payTimes=$scope.proposal.prpTplanDtoList.length;
                //var paymentList=[]
                //angular.forEach($scope.proposal.prpTplanDtoList, function (data,index) {
                //    if(data.payReason=="R10"){
                //        paymentList.push(data);
                //    }
                //})
                //var intStartDate = (new Date($scope.proposal.prpTmainDto.startDate)).getTime(); // 保险起期的毫秒数
                //var intEndDate = (new Date($scope.proposal.prpTmainDto.endDate)).getTime();     // 保险止期的毫秒数
                //var intDispersion = Math.floor((intEndDate - intStartDate) / paymentList.length); // 保险期间平均的毫秒数
                //// 补贴金额
                //var subsidyPremium = 0;
                //angular.forEach($scope.proposal.prpTsubsidyDtoList, function (data, index) {
                //    subsidyPremium += Number(data.subsidyPremium)
                //});
                //// 应缴金额 (总保费减去补贴金额)
                //var payNo = $scope.totalPay - subsidyPremium;
                //angular.forEach(paymentList, function (data, index) {
                //    var intDateSub = 0;
                //    var dateSub;
                //    var endDateSub;
                //    intDateSub = intStartDate+intDispersion*index;
                //    dateSub = new Date(intDateSub);
                //    endDateSub = getNextDateFullDate(convertFullDateToString(dateSub),15);
                //    data.planStartDate = $filter('date')(new Date(intStartDate + intDispersion * index), 'yyyy-MM-dd');
                //    data.planDate = $filter('date')(new Date(endDateSub), 'yyyy-MM-dd');
                //    data.planFee = round((payNo / paymentList.length),2);  // 应缴金额
                //    data.delinquentFee = round(data.planFee,2);  // 拖欠金额
                //    data.currency = data.currency || $scope.proposal.prpTfeeDto.currency2; // 币别
                //    data.payreFee =round(data.payreFee,2) || 0; // 实际缴纳金额
                //    data.payNo = index; // 支付期号
                //});
                //var datanum = 0,tttplan=0;
                //angular.forEach($scope.proposal.prpTplanDtoList, function (data, index) {
                //    data.planDate=$filter('date')(new Date(new Date(data.planStartDate).getTime()+86400000*14), 'yyyy-MM-dd');
                //
                //    data.payreFee = round((data.planFee - data.delinquentFee),2);
                //    var num;
                //    data.serialNo = index + 1;
                //    if (data.payReason != 'R10') {
                //        data.payNo = 1;
                //        datanum++;
                //    } else {
                //        $scope.proposal.prpTplanDtoList[datanum].payReason='R10'
                //        if(index!=$scope.proposal.prpTplanDtoList.length-1){
                //            tttplan+=(data.planFee*1)
                //        }
                //        num = index+1 - datanum;
                //        data.payNo = num;
                //    }
                //})
                $scope.proposal.prpTplanDtoList.splice(n, 1);
                $scope.checkPayNo(); //回写右上角缴费次数框
            }
            //应缴金额校验
            $scope.pressDecimal = function (index, $event) {
                var value = String.fromCharCode($event.keyCode);
                if ((value >= 0 && value <= 9) || value == "?") {
                    return true;
                } else {
                    $scope.proposal.prpTplanDtoList[index].planFee = "";
                    return false;
                }
            };
            $scope.checkNumber = function (index) {
                var value = $scope.proposal.prpTplanDtoList[index].planFee;
                if (isNaN(value)) {
                    alert("数据不合法");
                    $scope.proposal.prpTplanDtoList[index].planFee = "";
                }
            };
            //缴费计划删除
            $scope.deleteEquipment = function (index) {
                $scope.proposal.prpTplanDtoList.splice(index, 1);
            };
            $scope.pressFullDate = function (index, $event) {
                var staValue = String.fromCharCode($event.keyCode);

                if (staValue >= 0 && staValue <= 9 || staValue == "?" || staValue == "?") {
                    return true;
                } else {
                    $scope.proposal.prpTplanDtoList[index].planStartDate = "";
                    return false;
                }
            }
            $scope.tabBtn = false;
            $scope.tabBtnChange = function () {
                $scope.tabBtn = !$scope.tabBtn;
            };
            //特约及附加信息新增
            $scope.addTeng = function () {
                $scope.proposal.prpTengageDtoCopy = $scope.proposal.prpTengageDtoCopy || [];
                //模拟数组
                var newObject = {
                    // "serialNo": "", //序号（特约及附加信息） // modify 2018/1/5 zhuqianqian 序号为后端生成 前端不需要添加
                    "clauseCode": $scope.engageQueryClauseByRiskCodeList[1].codeCode, //代码
                    "clauses": $scope.engageQueryClauseByRiskCodeList[1].codeName, //名称
                    "clausesContent": $scope.engageQueryClauseByRiskCodeList[1].clausesContext, //内容  000
                    "policyNo":$scope.proposal.prpTmainDto.policyNo,
                    "riskCode":$scope.proposal.prpTmainDto.riskCode,
                    "titleFlag":0

                };
                //**************--------批改专属----***************
                // 如果是批改需要增加标志位 I ；
                if ($scope.endorseFlag) {
                    newObject.flag = 'I'
                }
                //**************--------批改专属----***************

                $scope.proposal.prpTengageDtoCopy.push(newObject); //后续添加model后再修改
            };
            //特约及附加信息联动
            $scope.engageQueryClause = function (x, index, y) {
                console.log(y)
                $scope.proposal.prpTengageDtoCopy[index].clauses = x; //这个代码不要注掉求你们啦
                $scope.proposal.prpTengageDtoCopy[index].clausesContent = y;
            };
            //特约及附加信息删除
            $scope.deleteTeng = function (index) {
                var prpTengageDtoCopy = $scope.proposal.prpTengageDtoCopy;
                //**************--------批改专属----***************
                // 如果是批改，并且是保单数据初始值。
                if ($scope.endorseFlag) {
                    // 批单点击删除 有可能为恢复
                    if (prpTengageDtoCopy[index].flag === 'D') { // 如果为恢复； 标识位置为 null
                        prpTengageDtoCopy[index].flag = null;
                    } else if (prpTengageDtoCopy[index].flag === 'I') { // 如果是新增，就删除一行
                        $scope.proposal.prpTengageDtoCopy.splice(index, 1);
                    } else { // 如果为删除 则从保存的数据中取出初始值将列表值赋值回来 并且置标识位为 D
                        prpTengageDtoCopy[index] = $scope.blPolicyInfoListingConvertCopyRestoreDTO.prpTengageDtoCopy[index];
                        prpTengageDtoCopy[index].flag = 'D'
                    }
                    //**************--------批改专属----***************
                } else {
                    $scope.proposal.prpTengageDtoCopy.splice(index, 1);
                }
            };
            //特约及附加信息显示/隐藏
            $scope.tabBtn1 = false;
            $scope.tabBtnChange1 = function () {
                $scope.tabBtn1 = !$scope.tabBtn1;
            };
            //查看特约信息
            $scope.lookFlag = false;
            // 当前查看修改的特约对象
            $scope.curPrpTengage = {};
            $scope.lookClausesContext = function (prpTengageDtoList, indxe) {
                $scope.curPrpTengage = prpTengageDtoList;
                $scope.lookFlag = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
            };
            //特约内容关闭
            $scope.yeslookFlag = function (x) {
                $scope.lookFlag = false;
                $("html,body").css({overflow:"auto"});//显示滚动条
                $scope.curPrpTengage = {} // 每次关闭时清空curPrpTengage当前查看修改的特约对象
            };

            //初始化$scope.proposal.prpTitemKindDtoList
            //if ($scope.proposal.prpTitemKindDtoList[0] && !$scope.proposal.prpTitemKindDtoList[0].itemKindNo) {
            //    $scope.proposal.prpTitemKindDtoList = []
            //}

            //   费率
            $scope.checkOutBdRed=false;
            $scope.getRateAmount= function ($event) {
                if($scope.prpTitemKind.rate){
                    var content="";
                    var regex =/[0-9]/;
                    var str = regex.test($scope.prpTitemKind.rate);
                    if (str==false){
                        content="费率格式不正确！";
                        $scope.checkOutBdRed=true;
                        $scope.prpTitemKind.rate="";
                    }else  if($scope.prpTitemKind.rate>0&&$scope.prpTitemKind.rate<=100){
                        $scope.prpTitemKind.rate=$scope.prpTitemKind.rate;
                        $scope.checkOutBdRed=false;
                    }else if($scope.prpTitemKind.rate<=0){
                        $scope.checkOutBdRed=true;
                        $scope.prpTitemKind.rate="";
                        content="费率不能小于等于0";
                        $event.target.focus();
                    }else{
                        $scope.checkOutBdRed=true;
                        $scope.prpTitemKind.rate="";
                        content="费率不能大于100";
                        $event.target.focus();
                    }
                    if (content!=""){
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
                    }
                }

            }
            $scope.$watch("prpTitemKind.shortRate", function (newValue,oldValue) {
                $scope.adjustMun();
            })
            $scope.adjustMun = function (attr,type) {
                if($scope.proposal.prpTmainDto.riskCode=="3107") {
                    if( $scope.proposal.prpTmainDto.comCode.substring(0,2)=="41" && $scope.prpTitemKind.premiumCalMethod=="2") {
                        $scope.prpTitemKind.premium = round(($scope.prpTitemKind.agriGrossQuantityMain*$scope.prpTitemKind.unitPremium),2);
                        $scope.prpTitemKind.rate=($scope.prpTitemKind.premium/$scope.prpTitemKind.amount)*100;
                    }else{
                        $scope.prpTitemKind.premium = round(($scope.prpTitemKind.amount * $scope.prpTitemKind.shortRate / 100 * $scope.prpTitemKind.rate / 100),2);
                    }
                    $scope.adjustBill('premium')
                    return
                } else{
                    Math.round(($scope.prpTitemKind.amount * $scope.prpTitemKind.shortRate / 100 * $scope.prpTitemKind.rate / 100),2);
                    $scope.prpTitemKind.premium = round(($scope.prpTitemKind.amount * $scope.prpTitemKind.shortRate / 100 * $scope.prpTitemKind.rate / 100),2);
                    $scope.adjustBill('premium')
                    return
                }
                //else if($scope.proposal.prpTmainDto.riskCode=='3134'&&$scope.radioType=='Y'){
                //    var startDate = new Date($scope.proposal.prpTmainDto.startDate.replace("-", "/"));
                //    var endDate = new Date($scope.proposal.prpTmainDto.endDate.replace("-", "/"));
                //    var intDays = dateDiff(startDate, endDate, "D");
                //    $scope.prpTitemKind.premium = round(($scope.prpTitemKind.amount * $scope.prpTitemKind.shortRate / 100 * $scope.prpTitemKind.rate / 100 * (intDays/365)),2);
                //    $scope.adjustBill('premium')
                //    return
                //}

                //return commonApiServ.rateNum(attr)
            }

            //function returnFloat(value){
            //    var value=Math.round(parseFloat(value)*100)/100;
            //    var xsd=value.toString().split(".");
            //    if(xsd.length==1){
            //        value=value.toString()+".00";
            //        return value;
            //    }
            //    if(xsd.length>1){
            //        if(xsd[1].length<2){
            //            value=value.toString()+"0";
            //        }
            //        return value;
            //    }
            //}
            //
            $scope.checkFormat = function () {
                var field = $scope.prpTitemKind.rate;
                var rate;
                if(field.toString().indexOf('.') ==-1){
                    rate = field.toFixed(2);
                }else {
                    rate = field.toFixed(4);
                }
                $scope.prpTitemKind.rate = rate;
            }
            //单位保额233上限校验，已经确认不需要
            //$scope.check=function(data){
            //    if(data>233&& $scope.proposal.prpTmainDto.riskCode=="3155"){
            //        layer.open({
            //            offset: ['35%', '40%'],
            //            skin: 'large-layer-content',
            //            closeBtn: 0,
            //            title: '温馨提示',
            //            content: '单位保险金额不能大于233',
            //            btn: ['确定'],
            //            btn1: function (index, layero) {
            //                //按钮【按钮一】的回调
            //                layer.close(index);
            //            }
            //        });
            //        $scope.prpTitemKind.unitAmount='';
            //    }
            //
            //}
            //输入两位小数时默认保留四位，输入整数时保留两位小数
            //$scope.changecoinsSumAmount = function (data, attl) {
            //    data=parseFloat(data);
            //    if (data) {
            //        //var s = data.toString();
            //        /* var strr='';
            //         var rs = s.indexOf('.');
            //         if (rs < 0) {
            //         s += '.00'
            //         }
            //         var rss = s.indexOf('.');
            //         var w=s.substring(rss, s.indexOf('.') + 4)
            //         var w4=s.split(".")[1].length
            //         if(w4<4&&w=='.00'){
            //         strr =s;
            //
            //         }else if(w4<4&&w=='.000'){
            //         strr =s
            //         strr = strr.substring(0, strr.indexOf('.') + 3)+ '';
            //         }else {
            //         rss = s.length;
            //         while (s.length <= rss + 4) {
            //         s += '0';
            //         }
            //         strr = s.substring(0, s.indexOf('.') + 5)+ '';
            //         }*/
            //        if (attl == 'deductibleRate') {
            //            $scope.prpTitemKind.deductibleRate = data;
            //        } else if (attl == 'triggerPoint') {
            //            $scope.prpTitemKind.triggerPoint = data;
            //        } else if(attl=='totalLossRatio') {
            //            $scope.prpTitemKind.totalLossRatio =data;
            //        }else if(attl=='agriUnitCostMain'){
            //            $scope.prpTitemKind.agriUnitCostMain = data;
            //        }else if(attl=='unitAmount'){
            //            $scope.prpTitemKind.unitAmount = data;
            //        }else if(attl=='agriGrossQuantityMain'){
            //            $scope.prpTitemKind.agriGrossQuantityMain = data;
            //        }else if(attl=='agriTimesAmount'){
            //            $scope.prpTitemKind.agriTimesAmount = data;
            //        }
            //    }
            //
            //
            //}
            $$finder.find('queryPrpDcurrencyByCondition', {}, {
                success: function (data) {
                    data.content.splice(1,1);
                    //币别信息的集合
                    $scope.PrpDcurrencyDtoList = data.content;
                },
                error: function (e) {
                    options.error(e);
                }
            });

            $scope.adjustBill = function (attr) {
                $scope.doSaveFlagChange()
                //  $scope.prpTitemKind[attr] = commonApiServ.billNum1($scope.prpTitemKind[attr])
            }

            //邮政编号输入的长度是否符合要求
            $scope.checkLengthLimited = function (target) {
                var staValue = $scope.proposal.prpTaddressDto.addressCode;
                var intLengthMax = target.maxLength;
                var strNumber = new RegExp("^[0-9]*$");
                var flag = strNumber.test(staValue);
                if (staValue == null || staValue == "") {
                    return false;
                } else if ((staValue.length < intLengthMax && flag)) {
                    alert("输入的内容长度不够！\n长度应为" + intLengthMax + "个数字！\n请重新输入");
                    $scope.proposal.prpTaddressDto.addressCode = "";
                    return false;
                } else if (!flag) {
                    $scope.proposal.prpTaddressDto.addressCode = "";
                }
            }

            //投保方式
            $scope.changePolicyType = function () {
                var riskCode = $scope.proposal.prpTmainDto.comCode;//险种
                var configRisk = '2799-2705-2709-2712-2719-2720-2721-2722'; //混合险种：团、个单都能录入
                var messType = $scope.proposal.prpTmainDto.MessType || "";//大团单录入标志
                var editType = $scope.proposal.editType; //编辑类型
                var policyType = $scope.proposal.prpTmainDto.policyType;//投保方式
                if (configRisk.indexOf(riskCode) > -1) {
                    if (messType == "0" || messType == "1") //大团单
                    {
                        $scope.proposal.prpTmainDto.policyType = '02';
                        //setOption('PolicyType','02_FIELD_SEPARATOR_集体');
                        return;
                    }
                    if (editType == "UPDATE") //修改时不能更改保单类型
                    {
                        if (policyType == "02")
                            $scope.proposal.prpTmainDto.policyType = '02';
                        else
                            $scope.proposal.prpTmainDto.policyType = '01';
                        return;
                    }
                }
            }

            //刷新对币别信息的操作
            $scope.setRefreshFlagFeeZero = function () {
                getAmount()
                //setRefreshFlagCoinsZero();
            }
            //是否联共
            //var setRefreshFlagCoinsZero = function () {
            //    $scope.proposal.prpMainDto.RefreshFlagCoins = "0";
            //}

            $scope.calculatePremiumMain = function (CalculateRateFlag) {
                //获取当前主险附加险的行数
                // var findex = getElementOrder(Field)-1;
                //如果calculateRateFlag==1
                // if(parseInt(CalculateRateFlag,10)==1)
                //     fm.all("ShortRateMain")[findex].value = point(round(calShortRate(findex, "Main"), 4), 4);
                // fm.all("BenMarkPremiumMain")[findex].value = formulizePremium(findex, "Main");
                // fm.all("DisCountMainType")[findex].onchange();
                $scope.setMainInsuredRate();
                $scope.discountPremcalculateMain();
            }
            $scope.setMainInsuredRate=function (Field) {
                angular.forEach($scope.proposal.prpTitemKindDtoList,function (obj,index) {
                    var intIndex=index;
                    //获取补贴总数
                    var intCount = $scope.proposal.prpTsubsidyDtoList.length;
                    var i=0;
                    if(intCount != 0)
                    {
                        for(i = 1;i <= intCount; i++)
                        {
                            angular.forEach($scope.proposal.prpTsubsidyDtoList,function (data) {
                                //现在补贴类型已经没有02了
                                if (data.subsidytype=='02'){
                                    $scope.proposal.prpTitemKindDtoList[intIndex].discountMainType= '2';
                                    $scope.proposal.prpTitemKindDtoList[intIndex].discountMain='100';
                                }
                            })
                        }
                        i = i-1;
                    }
                    if(i == intCount)
                    {
                        if ($scope.proposal.prpTitemKindDtoList[intIndex].discountMainType=='1'){
                            $scope.proposal.prpTitemKindDtoList[intIndex].discountMain='0';
                        }
                        else if ($scope.proposal.prpTitemKindDtoList[intIndex].discountMainType=='2'){
                            $scope.proposal.prpTitemKindDtoList[intIndex].discountMain='100';
                        }
                        else {
                            $scope.proposal.prpTitemKindDtoList[intIndex].discountMain='';
                        }
                    }

                    //fm.DisCountMain[intIndex].onblur();

                    //setMainInsuredRate在老代码中没有找到
                    //$scope.checkDecimal(this,5,2,'0','100');
                    $scope.discountPremcalculateMain();                })
            }


            $scope.discountPremcalculateMain=function () {
                var benchmarkPremium=$scope.proposal.prpTmainDto.benchmarkPremium
                angular.forEach($scope.proposal.prpTitemKindDtoList,function (data) {
                    if (data.benmarkPremiumMain == null || data.benmarkPremiumMain == '')
                    {
                        data.premiumMain = "";// 保费
                        data.perpremiumMain = "";
                        data.govpremiumMain= "";
                    }
                    var subsidy = calculateSubsidy();
                    if (subsidy == null || subsidy == "")
                        subsidy = 0;

                    var perproportion = round((100 - round(parseFloat(subsidy), 4)) / 100, 4);
                    var perpremium = round(round(parseFloat(data.benmarkPremiumMain), 2) * round(parseFloat(perproportion), 4) * round(parseFloat(data.discountMain), 2) / 100, 4);
                    var govpremium = round(round(parseFloat(data.benmarkPremiumMain), 2) * round(parseFloat(subsidy), 2) / 100, 2);

                    data.premiumMain = point(round(perpremium + govpremium, 2), 2);
                    data.perpremiumMain = point(perpremium, 2);

                    data.govpremiumMain=point(govpremium,2);
                    calculateSubsidyFee();
                })
            }

            function calculateSubsidy()
            {
                var subsidy=0;
                for(var i=1;i<$scope.proposal.prpTsubsidyDtoList.length;i++)
                {
                    angular.forEach($scope.proposal.prpTsubsidyDtoList,function (data) {
                        if (data.subsidytype=='01'){
                            subsidy = parseFloat(subsidy) + parseFloat(data.subsidyRate);
                        }
                    })
                }
                return subsidy;
            }

            $scope.getModleName = function (data, e, type) {
                //补贴方式名称
                if (type == "Subsidytype") {
                    $scope.getSubsidyTypeNameName = e.target.innerText
                    $scope.getSubsidyTypeName()
                }
                //补贴类型名称
                if (type == "SubsidyCode") {
                    $scope.getSubsidyCodeNameName = e.target.innerText
                    $scope.getSubsidyTypeName()
                }

            }
            $scope.getSubsidyTypeNameData = {}
            $scope.getSubsidyTypeName = function (index) {
                if (index || index == 0) {
                    $scope.getSubsidyTypeNameData = $scope.proposal.prpTsubsidyDtoList[index]
                }
                if ($scope.getSubsidyTypeNameName && $scope.getSubsidyTypeNameData) {
                    $scope.getSubsidyTypeNameData.subsidyTypeName = $scope.getSubsidyTypeNameName
                }
                if ($scope.getSubsidyCodeNameName && $scope.getSubsidyTypeNameData) {
                    $scope.getSubsidyTypeNameData.subsidyName = $scope.getSubsidyCodeNameName
                }
            }
            //---------------如果比例补贴不填，默认赋0,start----------------------
            // $scope.checkIsNull = function (field) {
            //     var rate = field.subsidyRate;
            //     if(rate == null || rate =='undefined' || rate == ''){
            //         layer.open({
            //             offset: ['35%', '40%'],
            //             skin: 'large-layer-content',
            //             closeBtn: 0,
            //             title: '温馨提示',
            //             content: '补贴比例不能为空或为0',
            //             btn: ['确定'],
            //             btn1: function (index, layero) {
            //                 //按钮【按钮一】的回调
            //                 layer.close(index);
            //             }
            //     });
            // }
            // }
            //---------------如果比例补贴不填，默认赋0,end----------------------
            //补贴信息数字校验
            $scope.clearNoNum = function (obj, attr) {
                //先把非数字的都替换掉，除了数字和.
                obj[attr] = obj[attr].replace(/[^\d.]/g, "");
                //必须保证第一个为数字而不是.
                obj[attr] = obj[attr].replace(/^\./g, "");
                //保证只有出现一个.而没有多个.
                obj[attr] = obj[attr].replace(/\.{2,}/g, "");
                //保证.只出现一次，而不能出现两次以上
                obj[attr] = obj[attr].replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
                obj[attr]=(obj[attr]+'').replace(/^0+\./g,'0.');
                obj[attr].match(/^0+[1-9]+/)?obj[attr]=obj[attr].replace(/^0+/g,''):obj[attr];
                obj[attr]=Number(obj[attr])?obj[attr]:0;
                if(obj[attr]>100){
                    layer.open({
                        //offset: ['35%', '40%'],
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: '补贴比例不能大于100',
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    obj[attr]="";
                }
            }

            //校验只能输入数字
            $scope.changeToNum = function (type) {
                $scope.requestInsuranceQueryDto[type] = changeToNum($scope.requestInsuranceQueryDto [type]);
                $scope.requestInsuranceQueryDto.beginTime = null;
                $scope.requestInsuranceQueryDto.endTime = null
            }
            //补贴类型和方式改变时清空数据
            $scope.resetSubsidy = function (index) {
                if (index || index == 0) {
                    $scope.proposal.prpTsubsidyDtoList[index].subsidyRate = null;
                    $scope.proposal.prpTsubsidyDtoList[index].subsidyDepartment = null;
                    $scope.proposal.prpTsubsidyDtoList[index].subsidyPremium = null;
                }
            }

            /*
             普通批改变更保险金额的保费计算
             oldAmount  旧保额
             newAmount  新保额
             oldRate  旧费率
             newRate  新费率
             oldDiscount 旧折扣率
             newDiscount 新折扣率
             newShortRate 新短期费率
             oldShortRate 旧短期费率
             */
            var calculateByItem = function(oldAmount,newAmount,
                                           oldRate,newRate,
                                           oldDiscount,newDiscount,
                                           newShortRate,oldShortRate){

                oldShortRate = 1 ;//旧短期费率系数不参加计算了,已经体现在了旧保额里
                var chgPremium = 0;
                chgPremium = ( (newAmount - oldAmount) * newRate * newDiscount * newShortRate +
                    oldAmount * (newRate * newDiscount - oldRate * oldDiscount) * newShortRate ) *oldShortRate;
                return chgPremium;
            }


            //得到下n天
            var getNextDateFullDate = function(strDate,intCount)
            {
                var tempDate = new Date(replace(strDate,"-","/"));
                if(intCount == null)
                {
                    intCount =1;
                }

                var nextDateInMS = tempDate.getTime() + (intCount * 24 * 60 * 60 * 1000 );
                var strReturn = convertFullDateToString(new Date(nextDateInMS));
                return strReturn;
            }

            //得到日期的字符串表达形式，传入参数为Date类型
            //如果不传，则默认为当天
            var DATE_DELIMITER="-";       //日期分隔符
            var convertFullDateToString = function(date)
            {
                if(date==null)
                {
                    date = new Date();
                }

                var strDate = "";
                strDate = date.getFullYear() + DATE_DELIMITER +
                    (date.getMonth() + 1) + DATE_DELIMITER +
                    date.getDate();
                return strDate;
            }

            var formulizePremium = function (index) {
                var prpTitemkindList = $scope.proposal.prpTitemKindDtoList;
                var vAmount    = parseFloat( prpTitemkindList[index].amount); //保额
                var vRate      = parseFloat( prpTitemkindList[index].rate ); //费率
                var vShortRate = parseFloat( prpTitemkindList[index].shortRate ); //短期费率
                var vPremium = "";
                if(isNaN(vAmount   )) vAmount    = 0;
                if(isNaN(vRate     )) vRate      = 0;
                if(isNaN(vShortRate)) vShortRate = 0;

                vPremium = vAmount * vRate/100 * vShortRate/100;
                vPremium = round(vPremium,2);
                return vPremium;
            }

            //替换字符串函数
            function replace(strExpression,strFind,strReplaceWith)
            {
                var strReturn;
                var re = new RegExp(strFind,"g");
                if(strExpression==null)
                    return null;

                strReturn = strExpression.replace(re,strReplaceWith);
                return strReturn;
            }
            $scope.absuDeduRateForm = function ($event){
                var absuDedu = $scope.proposal.engageQueryClause.absuDedu;
                if(absuDedu!='' && absuDedu!=null && absuDedu!=undefined){
                    if(absuDedu>100){
                        layer.open({
                            /*offset: ['35%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '绝对免赔率不能大于100！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.engageQueryClause.absuDedu="";
                    }else if(parseFloat(absuDedu)==0){
                        layer.open({
                            /*offset: ['35%', '40%'],*/
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            scrollbar: false,
                            content: '绝对免赔率不能等于0！',
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.proposal.engageQueryClause.absuDedu="";
                    }else{
                        $scope.proposal.engageQueryClause.absuDedu= round(absuDedu,2);
                    }
                }
            };
            $scope.adjustMun2 = function (attr,type) {
                if (attr != 'amount') {
                    $scope.proposal.engageQueryClause[attr] = commonApiServ.rateNum($scope.proposal.engageQueryClause[attr],type)
                }
            }
            // function rateForm(num) {
            //     if (num * 10000 % 10000 == '0') {
            //         return (Math.round(num * 100) / 100).toFixed(2).toString()
            //     } else {
            //         return (Math.round(num * 10000) / 10000).toFixed(4).toString()
            //     }
            // }

            //    保留小数位的位数
            $rootScope.amount= function (str) {
                if(str){
                    var number=parseInt(str);
                    if(number==str){
                        return Number(str).toFixed(2);
                    }else{
                        return Number(str).toFixed(4);
                    }
                }
            }

            //    单位保费
            $scope.premiumFixed=true;
            $scope.changeNnitPremium= function (arr) {
                if(arr==1 || arr==9 || arr==0){
                    $scope.rateflag=false;
                    $scope.premiumFixed=true;
                    $scope.prpTitemKind.unitPremium='';
                }else{
                    $scope.rateflag=true;
                    $scope.premiumFixed=false;
                    $scope.prpTitemKind.unitPremium=27;
                }
                $scope.adjustMun();
            };
            $scope.changeunitPremium=function(){
                $scope.adjustMun();
            }
            //$scope.checkUnitPremium= function (str) {
            //    if(str){
            //        $scope.prpTitemKind.unitPremium=$rootScope.amount(str);
            //    }
            //}
            $scope.calculateAgriMain = function (field) {
                if($scope.proposal.prpTmainDto.riskCode=='3223'){
                    //  待完善
                }else if($scope.proposal.prpTmainDto.riskCode!='3176' && $scope.proposal.prpTmainDto.riskCode!='3230'){
                    // 3176毛竹,3230黄鳝,单位保额不需要被回写,是手动填写值
                    var agriUnitOutputMain = field.agriUnitOutputMain;//单位产量
                    var agriUnitCostMain = field.agriUnitCostMain;//单位成本
                    var proportion = field.proportion;//投保成数
                    var depreciationRate = field.depreciationRate;//折旧率
                    var agriUnitAmountMain=0;
                    if(agriUnitOutputMain!='undefined' && agriUnitOutputMain!=''&& agriUnitOutputMain!=null
                        && agriUnitCostMain!='undefined' && agriUnitCostMain!=''&& agriUnitCostMain!=null){
                        agriUnitAmountMain = parseFloat(agriUnitOutputMain)*parseFloat(agriUnitCostMain);
                    }else {
                        agriUnitAmountMain = 0;
                    }
                    if(proportion!='undefined' && proportion!=null && proportion!="")
                    {
                        agriUnitAmountMain=parseFloat(agriUnitAmountMain)*parseFloat(proportion)/100;
                    }
                    if(depreciationRate!='undefined' && depreciationRate!=null && depreciationRate!="")
                    {
                        agriUnitAmountMain=parseFloat(agriUnitAmountMain)*parseFloat(depreciationRate)/100;
                    }
                    /* if(agriUnitAmountMain!=0)
                     {
                     field.unitAmount = point(round(agriUnitAmountMain,2),2);
                     }else{
                     field.unitAmount = 0;
                     }*/
                }
                $scope.checkLimits(field);
                $scope.changeGrossQuantityMain(field);
                $scope.changeUnitAmountMain(field);
                //$scope.changecoinsSumAmount(field.unitAmount,'unitAmount');
            }
            // 检查单位保额是否超过条款规定最大值
            $scope.checkLimits = function (field) {
                var comment = '';
                var itemcode = field.itemCode;
                var unitamount = field.unitAmount;
                if($scope.proposal.prpTmainDto.riskCode=='3187'){
                    if(itemcode=="Z001") {
                        comment = "牡丹种植险的【标的类别】不能选择“Z001-牡丹种植保险”，请重新选择【标的类别】。";
                    }
                    if(itemcode=="Z002" && unitamount > 1500) {
                        comment = "1-4年生牡丹，单位保险金额不得超过1500元/亩，请重新输入单位保险金额。";
                    }
                    if(itemcode=="Z003" && unitamount > 3000) {
                        comment = "5年生及以上牡丹，单位保险金额不得超过3000元/亩，请重新输入单位保险金额。";
                    }
                }
                if($scope.proposal.prpTmainDto.riskCode=="3173"  && $scope.proposal.prpTmainDto.comCode.substr(0,2)=="42") {
                    if(itemcode!="p001") {
                        comment = "葡萄种植险的主险【标的类别】必须选择“p001-葡萄”，请重新选择【标的类别】。";
                    }
                }
                // 3223能繁母羊湖北专用,检查单位保额是否超过条款规定最大值
                if($scope.proposal.prpTmainDto.riskCode=="3223" && $scope.proposal.prpTmainDto.comCode.substr(0,2)=="42") {
                    if(unitamount > 1000) {
                        comment = "湖北省能繁母羊养殖险，单位保险金额不得超过1000元/头，请重新输入。";
                    }
                }
                if($scope.proposal.prpTmainDto.riskCode=="3176") {
                    if(unitamount > 1000) {
                        comment = "毛竹保险，单位保险金额不得超过1000元/亩，请重新输入。";
                    }
                }
                if($scope.proposal.prpTmainDto.riskCode=="3178") {
                    if(unitamount > 500.0) {
                        comment = "板蓝根种植保险，单位保险金额不得超过500元/亩，请重新输入。";
                    }
                }
                if(comment!=''){
                    layer.open({
                        /*offset: ['35%', '40%'],*/
                        skin: 'large-layer-content',
                        closeBtn: 0,
                        title: '温馨提示',
                        scrollbar: false,
                        content: comment,
                        btn: ['确定'],
                        btn1: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
            }
            $scope.changeGrossQuantityMain = function (field) {
                var agriGrossQuantityMain = field.agriGrossQuantityMain;
                field.quantityMain = agriGrossQuantityMain;
                if($scope.proposal.prpTmainDto.riskCode=='3177' && (agriGrossQuantityMain==null || agriGrossQuantityMain=='' || agriGrossQuantityMain=='undefined')) {
                    field.unitAmount = field.agriGrossQuantityMain;
                }
                if(agriGrossQuantityMain!=null && agriGrossQuantityMain!=""){
                    field.amount = point(round(parseFloat(field.unitAmount)*parseFloat(agriGrossQuantityMain),2),2);
                    if(field.amount==parseInt(field.amount)){
                        field.amount=parseInt(field.amount);
                    }
                }else{
                    //field.amount = 0.00;
                }
            }
            /*
             *农险,改变单位保险金额后的处理
             *新增的反算功能,既改变单位保险金额以后根据约定单价,
             *或者单位约定产量中一个确定的值,算出另外的值,如果其中有一个值为零,
             *那么另外计算出来的值也是零
             */
            $scope.changeUnitAmountMain = function (field) {
                var agriUnitAmountMain = field.unitAmount;
                field.unitAmountMain = agriUnitAmountMain;
                var agriGrossQuantityMain = field.agriGrossQuantityMain;
                if(agriUnitAmountMain!=null && agriUnitAmountMain!="" && agriUnitAmountMain!='undefined'){
                    field.amount=
                        point(round(parseFloat(agriUnitAmountMain)*
                            parseFloat(agriGrossQuantityMain),2),2);
                    if(field.amount==parseInt(field.amount)){
                        field.amount=parseInt(field.amount);
                    }
                }else{
                    //field.amount = 0.00;
                }
                var riskCode = $scope.proposal.prpTmainDto.riskCode;
                var agriUnitCostMain = field.agriUnitCostMain;
                var configRisk = '3101-3107-3108-3114-3122-3126-3186-3143-3151-3167-3197-3152-3153-3154-3155-3156-3187-3172-3190-3191-3194-3193-3223-3175-3177-3160-3164-3188-3161-3149'; //中央政策性 种植险
                if(configRisk.indexOf(riskCode)>-1){
                }else{
                    if(agriUnitCostMain!=null && agriUnitCostMain!="" && agriUnitCostMain!="0"){

                        field.agriUnitOutputMain=
                            point(round(parseFloat(agriUnitAmountMain)
                                /parseFloat(agriUnitCostMain),2),2);
                        if(field.amount==parseInt(field.amount)){
                            field.amount=parseInt(field.amount);
                        }
                    }else{
                        field.agriUnitCostMain="";
                    }
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
            //监测保险期间是否改变，如果改变则可能影响保费，需要重新计算//投保方式需要存清单，如果改变需要重新点击计算
            $scope.$watch('proposal.prpTmainDto.startDate+proposal.prpTmainDto.endDate+proposal.prpTmainAgriDto.raiseType',function(){
                $scope.doSaveFlagChange();
            });

            //获取当前时间
            $scope.nowDate=new Date();
            $scope.time={
                year:$scope.nowDate.getFullYear(),
                month:(function () {
                    var month=$scope.nowDate.getMonth()+1;
                    return month>=10?month:"0"+month
                })(),
                date:(function(){
                    var date=$scope.nowDate.getDate();
                    return date>=10?date:"0"+date
                })()
            }

            $scope.dataNum=function(x){
                return x<10?'0'+x:x
            }
            //新增缴费计划时给日期设默认值
            $scope.CheckStartAndEndDate=function(n,index){
                if(n=="R10"){
                    $scope.proposal.prpTplanDtoList[index].planStartDate=$scope.proposal.prpTmainDto.startDate;
                    $scope.proposal.prpTplanDtoList[index].planDate=$scope.time.year+'-'+($scope.dataNum($scope.nowDate.getMonth()+2))+'-'+($scope.time.date+1);
                }else if(n=='RS3' ||n=='RS4' || n=='RS5' || n=='RS6' || n=='RS7' ){
                    $scope.proposal.prpTplanDtoList[index].planStartDate=$scope.proposal.prpTmainDto.startDate;
                    $scope.proposal.prpTplanDtoList[index].planDate=$scope.proposal.prpTmainDto.endDate;
                }
            }

        }])
});