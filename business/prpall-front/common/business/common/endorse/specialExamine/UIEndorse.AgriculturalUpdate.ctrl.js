/**
 * DESC: 农险angular－特殊批改变更保险期限界面
 * Created by sen on 2017/11/12.
 * --------------------------------------------------------
 *      sunyaohui       2018-01-06     项目部署
 */
define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIEndorseAgriculturalUpdateCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$location','$stateParams','$modal','$$code','$state','commonApiServ',
        function ($rootScope,$scope,$$finder,$http,$filter,$location,$stateParams,$modal,$$code,$state,commonApiServ) {
            console.log($scope.responseQueryPolicyListInfoDtoList)
            console.log($scope.endorseConditionDto)
            if($scope.endorseConditionDto==undefined){
                $scope.endorseConditionDto={};
                $scope.responseQueryPolicyListInfoDtoList={};
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIEndorseSpecial');
            }
            console.log($scope.endorseConditionDto);
            $scope.endorseDate = $filter('date')(new Date(),'yyyy-MM-dd');
            //$scope.endorseDate1 = "";
            $scope.endorseConditionDto.validDate=$filter('date')(new Date().getTime()+86400000,'yyyy-MM-dd');
            $scope.endorseConditionDto.endorDate=$scope.endorseDate;
            $scope.number=$scope.responseQueryPolicyListInfoDtoList.length
            $scope.disabled=true;
            //获取当前时间
            $scope.nowDate=new Date();
            $scope.time={
                year:$scope.nowDate.getFullYear(),
                month:(function () {
                    var month=$scope.nowDate.getMonth()+1;
                    return month>=10?month:"0"+month
                })(),
                date:(function(){
                    var date=$scope.nowDate.getDate()+1;
                    return date>=10?date:"0"+date
                })()
            }
          $scope.addOneDate= function(date,days){  var d=new Date(date);  d.setDate(d.getDate()+days);  var month=d.getMonth()+1;  var day = d.getDate();  if(month<10){  month = "0"+month;  }  if(day<10){  day = "0"+day;  }  var val = d.getFullYear()+"-"+month+"-"+day;  return val;  }
          $scope.endorseDate1=$scope.addOneDate(new Date(),1);
            $scope.bijiao=function($event,m){
                var reg =/^\d{1,3}(\.\d{1,4})?$/;
                if(m && !reg.test(m)){
                    $scope.check.rate = "费率只能输入整数且长度为3位和至多四位小数！";
                    $event.target.focus();
                    return
                }else{
                    $scope.check.rate = "";
                }
                if(m>100){
                    $scope.check.rate = "费率不能大于100！";
                    $event.target.focus();
                    return
                }else{
                    $scope.check.rate = "";
                }
            }

            //校验单位保额
            $scope.check={};
            $scope.changeUnitAmount=function($event,unitAmount){
                var reg =/^\d{1,10}(\.\d{1,2})?$/;
                if(unitAmount && !reg.test(unitAmount)){
                    $scope.check.unitAmount = "单位保额只能输入整数且长度为10位和至多两位小数！";
                    $event.target.focus();
                    return
                }else{
                    $scope.check.unitAmount = "";
                }

            }
            //归属部门d
            //var loginComCode=$scope.comcodeIndex;
            //var LoginComName='';
            //var comList=$scope.comcodeIndexList;
            //angular.forEach(comList,function(com){
            //    if(com.comCode==loginComCode){
            //        LoginComName=com.comCName;
            //        return
            //    }
            //})
            //$scope.endorseConditionDto.loginComCName=LoginComName;
            var oldSubsidy=oldSubsidy||{};//记录初始化的补贴信息
            /**
             * 转化时间戳为当前日期
             * @param target 时间戳
             * @param dateNum 当前时间+dateNum（默认为1天）
             * @returns {string}
             */
            $scope.getEndorseYear = function (target,dateNum) {
                var newDate = new Date();
                newDate.setTime(target);
                //默认获取批单生效时间+1
                if(dateNum){
                    newDate.setDate(newDate.getDate() + dateNum);
                }
                var year = newDate.toString();
                return year.substring(0,10);
            };
            //获取当前时间
            $scope.nowDate=new Date();
            $scope.time={
                year:$scope.nowDate.getFullYear(),
                month:(function () {
                    var month=$scope.nowDate.getMonth()+1;
                    return month>=10?month:"0"+month
                })(),
                date:(function(){
                    var date=$scope.nowDate.getDate()+1;
                    return date>=10?date:"0"+date
                })()
            }
            //批改生效日期 与批改日期检验
            $scope.compare= function (endorseDate1,endorseDate) {
                $scope.endorseDate1=endorseDate1;
                if(!endorseDate1){
                    layerMsg("批改生效日期不能为空!");
                    return false;
                }else if(!endorseDate){
                    layerMsg("批改日期不能为空!");
                    return false;
                }else if(endorseDate){
                    if(commonApiServ.compareFullDate(endorseDate,endorseDate1)==1){
                        layer.open({
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            scrollbar: false,
                            title: '温馨提示',
                            content: '批改生效日期日期小于批改日期！',
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        return false;
                    }
                }

            }
            /**
             * 页面规则校验
             */
            var ruleVerify = function () {
                var valid = true;
                //调整费率校验
                if($scope.endorse.endorseConditionDto.rate){
                    if ($scope.endorse.endorseConditionDto.rate<0 || $scope.endorse.endorseConditionDto.rate>100){
                        layerMsg('调整费率范围为0-100');
                        valid = false;
                    }
                }else if(!$scope.endorse.blEndorseDtoList[0].prpPheadDto.appliName){
                    layerMsg('批改申请人不能为空！');
                    valid = false;
                }else if(!$scope.endorseDate1){
                    layerMsg('批改生效日期不能为空！');
                    valid = false;
                }else if(!$scope.endorse.endorseConditionDto.endDate&&$scope.endorseConditionDto.endorType=='01'){
                    layerMsg('保险期间日期不能为空！');
                    valid = false;
                }else if($scope.endorse.endorseConditionDto.endDate<$scope.responseQueryPolicyListInfoDtoList[0].startDate&&$scope.endorseConditionDto.endorType=='01'){
                    layerMsg('保险止期必须大于保险起期！');
                    valid = false;
                }else if($scope.endorse.blEndorseDtoList[0].prpPheadDto.endorseType=="02"){
                    if(!$scope.endorse.endorseConditionDto.endorseReason || $scope.endorse.endorseConditionDto.endorseReason==""
                        || $scope.endorse.endorseConditionDto.endorseReason==null){
                        layerMsg('请先输入批改原因');
                        valid = false;
                    }
                }
                return valid;
            };
            //上一步
            $scope.last = function(){
                //特批查询
                $("html,body").css({overflow:"auto"});//出现滚动条
                $location.path('/UIEndorseSpecial');
            };
            //下一步

            $scope.next = function(){

                if(!ruleVerify()){
                    return false;
                }
                //特殊批改 生成批文
                angular.forEach($scope.endorse.blEndorseDtoList,function(item,index){
                    item.prpPheadDto.validDate=$scope.endorseDate1;
                    item.prpPheadDto.validHour=0;
                    item.prpPheadDto.endorDate=$scope.endorseDate;
                    item.prpPheadDto.policyNo=$scope.responseQueryPolicyListInfoDtoList[index].policyNo;
                    item.prpPheadDto.makeCom=$rootScope.user.makeCom;
                    //item.prpCmainDto.makeCom=$rootScope.user.makeCom;
                });

                //$scope.endorse.blEndorseDtoList.prpPheadDto=$scope.responseQueryPolicyListInfoDtoList.get
                $scope.endorse.endorseConditionDto.loginComCode=$rootScope.user.loginComCode;
                if($scope.endorse.endorseConditionDto.endorType=='85'&&($scope.endorse.endorseConditionDto.handler1Code==""||$scope.endorse.endorseConditionDto.handler1Code==undefined)){
                    layer.open({
                        //offset: ['35%', '35%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: "请选择归属业务员！",
                        btn: ["关闭"],
                        btn1: function (index) {
                            layer.close(index);
                        }
                    });
                    return;
                }
                $scope.endorse.endorseConditionDto.validDate= $("#endorseDate1").val();
                $scope.endorse.endorseConditionDto.handler1Code=$scope.endorse.endorseConditionDto.handler1Code;
                $scope.endorse.endorseConditionDto.validHour=0;
                $scope.endorse.endorseConditionDto.endHour=24;
                $scope.endorse.endorseConditionDto.agriStartDate=$scope.responseQueryPolicyListInfoDtoList[0].startDate;
                if($scope.endorse.endorseConditionDto.endorType=='71'){
                    $scope.endorse.prpCsubsidyDtoListNew=$scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList//补贴信息
                    var flag=false;
                    angular.forEach($scope.endorse.prpCsubsidyDtoListNew,function(item,index){
                        if(item.subsidyRate==""||item.subsidyRate==undefined){
                            flag=true;
                            layer.open({
                                //offset: ['35%', '35%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: "补贴比例不可为空！",
                                btn: ["关闭"],
                                btn1: function (index) {
                                    layer.close(index);
                                }
                            });
                            return;
                        }
                    });
                    if(flag==true){
                        return;
                    }
                }else if($scope.endorse.endorseConditionDto.endorType=='11'){
                    $scope.endorse.prpCitemKindDtoListNew=$scope.endorse.blEndorseDtoList[0].prpPitemKindDtoList//调整费率
                    var flag=false;
                    angular.forEach($scope.endorse.prpCitemKindDtoListNew,function(item,index){
                       if(item.rate==""||item.rate==undefined){
                           flag=true;
                           layer.open({
                               //offset: ['35%', '35%'],
                               skin: 'large-layer-content',
                               scrollbar: false,
                               closeBtn: 0,
                               title: '温馨提示',
                               content: "费率不可为空！",
                               btn: ["关闭"],
                               btn1: function (index) {
                                   layer.close(index);
                               }
                           });
                           return;
                       }
                    });
                    if(flag==true){
                        return;
                    }
                }else if($scope.endorse.endorseConditionDto.endorType=='91'){
                    $scope.endorse.prpCitemKindDtoListNew=$scope.endorse.blEndorseDtoList[0].prpPitemKindDtoListCopy//单位保额
                    var flag=false;
                    angular.forEach($scope.endorse.prpCitemKindDtoListNew,function(item,index){
                        if(item.unitAmount==""||item.unitAmount==undefined){
                            flag=true;
                            layer.open({
                                //offset: ['35%', '35%'],
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: "单位保额不可为空！",
                                btn: ["关闭"],
                                btn1: function (index) {
                                    layer.close(index);
                                }
                            });
                            return;
                        }
                    });
                    if(flag==true){
                        return;
                    }
                }
                $scope.endorse.endorseConditionDto.shortRateFlag=$scope.prpTitemKind.shortRateFlag;
                //$scope.endorse.responseQueryPolicyListInfoDtoList=$scope.responseQueryPolicyListInfoDtoList;

                var keywords = $scope.endorse;
                $$finder.find('endorseapproval', keywords, {
                    success: function(data) {
                        if(data && data.content) {
                            $scope.endorseTextObj = data.content;
                            $scope.endorseText = "";
                            if ($scope.endorse.endorseConditionDto.endorType== '01') {
                                console.log(data.content[0].blEndorseDto.prpPmainDto.endDate);

                                if (!data.content[0].blEndorseDto || !data.content[0].blEndorseDto.prpPtextDtoList[0].endorseText) {
                                    layerMsg("未返回批文信息");
                                    return false;
                                }
                                angular.forEach(data.content[0].blEndorseDto.prpPtextDtoList, function (text, index) {
                                    $scope.endorseText += (text.endorseText + "\r\n");
                                });

                                $scope.obtainText = true;//批文页面

                            }else if(data.content[0].blEndorseDto && data.content[0].blEndorseDto.prpPtextDtoList[0].endorseText){
                                angular.forEach($scope.endorseTextObj,function(item){
                                    item.blEndorseDto.endorseConditionDto=$scope.endorse.endorseConditionDto;
                                });
                                angular.forEach(data.content[0].blEndorseDto.prpPtextDtoList, function (text, index) {
                                    $scope.endorseText += (text.endorseText + "\r\n");
                                });
                                $scope.saveEnderseText();
                            }
                        }
                    },
                    error: function(e) {
                        console.log(e);
                    }
                });
            };
            /**
             * 关闭批文页面
             */
            $scope.closeEnderseText = function () {
                $scope.obtainText = false;
            };
            /**
             * 批文改变
             * @param _endorseText 批文
             */
            $scope.changeEndorseText = function (_endorseText) {
                //$scope.endorseTextObj[0].blEndorse.prpPtextDtoList[0].endorseText = _endorseText;
            };
            /**
             * 保存批文页面
             */
            $scope.saveEnderseText = function () {
                angular.forEach($scope.endorseTextObj,function(item){
                    item.blEndorseDto.prpPheadDto.operatorCode=$rootScope.user.userCode;
                });
                angular.forEach($scope.endorseTextObj,function(item){
                    item.blEndorseDto.endorseConditionDto.strText=$scope.endorseText;
                    item.blEndorseDto.endorseConditionDto.remark=item.blPolicyInfoDtoNew.prpCmainDto.remark;
                })
                $$finder.find('endorsesave', $scope.endorseTextObj, {
                    success: function (data) {
                        if(data && data.content){
                            $scope.infoToView.saveEnderseFlag = true;
                            $scope.endorseList=data.content.endorseList;

                            console.log($scope.endorseList)
                            $scope.aaa=["1","2","3"]
                            console.log($scope.aaa)
                            $modal.open({
                                templateUrl: 'common/business/common/endorse/model/UIEdorse.saveApproval.model.tpl.html',
                                resolve: {
                                    batch:function () {
                                        return data.content
                                    }
                                },
                                backdrop:'static',
                                controller: function ($scope, $modalInstance,batch) {
                                    $scope.batch = batch;
                                    $scope.canSubmitEndorse = true;//提交核批按钮
                                    $scope.lookEndorseBtn=false;
                                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                                    /**
                                     * 提交核批
                                     */
                                    $scope.submitEndorse = function () {
                                        var keywords = {
                                            "dLComCode": $rootScope.user.loginComCode,
                                            "endorseNos":batch.endorseList,
                                            "userCode": $rootScope.user.userCode
                                        };
                                        $$finder.find('saveUndwrtByEndorseNo',keywords, {
                                            success: function(data) {
                                                if(data  && data.content){
                                                    layer.open({
                                                        //offset: ['35%', '35%'],
                                                        skin: 'large-layer-content',
                                                        scrollbar: false,
                                                        closeBtn: 0,
                                                        title: '温馨提示',
                                                        content: data.content[0],
                                                        btn: ["关闭"],
                                                        btn1: function (index) {
                                                            layer.close(index);
                                                            $scope.quit();
                                                            $("html,body").css({overflow:"auto"});//出现滚动条
                                                            $state.go('UIEndorseSpecial');
                                                        }
                                                    });
                                                    $scope.canSubmitEndorse = false;//提交核批按钮
                                                }
                                            },
                                            error: function(e) {
                                                console.log(e);
                                            }
                                        });
                                    };
                                    /**
                                     * 查看批单
                                     */
                                    $scope.lookEndorse = function () {
                                        $modalInstance.dismiss();
                                        $("html,body").css({overflow:"auto"});//出现滚动条
                                        $state.go('UIEndorseSpecial');
                                    };
                                    /**
                                     * 关闭弹框
                                     */
                                    $scope.quit = function () {
                                        $modalInstance.dismiss();
                                        $("html,body").css({overflow:"auto"});//出现滚动条
                                        $state.go('UIEndorseSpecial');
                                    };
                                }
                            });
                        }else if(data.code == '9999'){
                            layerMsg(data.message);
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            };
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
            //查看详情
            $scope.totalItems = 0;
            $scope.showDetail = false;
            $scope.choosedDetail = function(){
                $scope.showDetail = true;
                $("html,body").css({overflow:"hidden"});//隐藏滚动条
                $scope.details=$scope.responseQueryPolicyListInfoDtoList;
                $scope.totalItems = $scope.details.length;
                $scope.paginationConfmm.totalItems = $scope.totalItems;
                //查询保单列表信息
               /* $$finder.find('selectedGuaranteeDetails', {}, {
                    success: function(data) {
                        $scope.details = data.data.resultObj.content;
                        $scope.totalItems = $scope.details.length;
                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                    },
                    error: function(e) {
                        options.error(e);
                    }
                });*/
            };
            //关闭详情页面
            $scope.cancel = function(){
                $scope.showDetail = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            };
            //分页设置
			var initPage2 = function() {
				$scope.paginationConfmm = {
					currentPage: 1,
					totalItems: 0,
					itemsPerPage: 20,
					pagesLength: 5,
					perPageOptions: [5, 10, 20, 50]
				};
			};
			initPage2();

            /**
             * 数据数据获取
             * @param _endorseType 特批类型
             * @param _keywords 入参
             */
            $scope.prpTitemKind=$scope.prpTitemKind||{}
            $$code.getCodes('codeType', 'ShortRateFlagMain', {}).then(function (data) {
                angular.forEach(data.prpDcodeListDtoList, function (data) {
                    if ('ShortRateFlagMain' == data.codeType) {
                        $scope.ephemeral = data.prpDcodeDtoList;
                        if($scope.prpTitemKind.shortRateFlag){
                            $scope.prpTitemKind.shortRate1 = data.prpDcodeDtoList[$scope.prpTitemKind.shortRateFlag].codeCName
                        }
                    }
                })
            })

            /**
             * 初始化数据
             * @param _endorseType
             * @param _keywords
             * @param initType
             */
            var findInit = function (_endorseType,_keywords,initType) {
                $$finder.find(_endorseType, _keywords, {
                    success: function (data) {
                        if(data.code=='0000'&&data.content.message){
                            console.log(data.content);
                            layerMsg(data.content.message);
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go('UIEndorseSpecial');
                        }else if (data && data.content){
                            angular.extend($scope.endorse,data.content);
                            //短期费率方式默认值
                            $scope.endorse.endorseConditionDto.validDate= $("#endorseDate1").val();
                            if(!$scope.endorse.endorseConditionDto.shortRateFlag){
                                $scope.endorse.endorseConditionDto.shortRateFlag = '1';
                            }

                            delete $scope.endorse.endorseConditionDto.endoretype;
                            //批改生效小时 如果没有默认0
                            if(!$scope.endorse.blEndorseDtoList[0].prpPheadDto.validHour){
                                $scope.endorse.blEndorseDtoList[0].prpPheadDto.validHour = '0';
                            }
                            //批改生效日期
                            console.log($scope.endorse.blEndorseDtoList[0].prpPheadDto.validDate)
                                //= $scope.getEndorseYear($scope.endorse.blEndorseDtoList[0].prpPheadDto.validDate,1);
                            //批改日期
                            $scope.endorse.blEndorseDtoList[0].prpPheadDto.endorDate = $scope.getEndorseYear($scope.endorse.blEndorseDtoList[0].prpPheadDto.endorDate);
                            if($scope.endorse.blEndorseDtoList.length>1){
                                $scope.endorse.blEndorseDtoList[0].prpPheadDto.appliName='';//批改申请申人清空
                            }
                            //归属部门
                            var comCode = _keywords.responseQueryPolicyListInfoDtoList[0].comCode;
                            $scope.endorseConditionDto.comCode = comCode;
                            $$finder.find('queryByPKByMap',{
                                comCode:comCode
                            }, {
                                success: function (data) {
                                    $scope.endorseConditionDto.comCName = data.content.comCName;
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                            /**
                             * 更新归属业务员
                             */
                            var handCodeData={
                                "userCode": $scope.user.userCode,
                                "userName": $scope.user.userName,
                                "loginComCode":  $scope.user.loginComCode,
                                "loginGradeCodes": "111",
                                "tableName": "prpduser",
                                "userCodeFields": "userCode",
                                "comCodeFields": comCode,
                                "riskCode": $scope.responseQueryPolicyListInfoDtoList[0].policyNo,
                            };
                            $$code.getCodes('codeType', "queryHandler1CodeInfo", { },handCodeData).then(function (data) {
                                $scope.handCodeList = data;

                            });
                            //归属部门
                            //angular.forEach($rootScope.comcodeIndexList,function(com,index){
                            //    if(com.comCode==$rootScope.comcodeIndex){
                            //        $scope.endorseConditionDto.loginComCName=com.comCName;
                            //    }
                            //})
                            //判断是否是调整补贴费率
                            if($scope.endorse.responseQueryPolicyListInfoDtoList){
                                if($scope.endorse.responseQueryPolicyListInfoDtoList[0]=="不符合批改条件"){
                                    layer.open({
                                        /*offset: ['45%', '40%'],*/
                                        skin: 'large-layer-content',
                                        scrollbar: false,
                                        closeBtn: 0,
                                        title: '温馨提示',
                                        content: $scope.endorse.responseQueryPolicyListInfoDtoList[0],
                                        btn: ['确定'],
                                        btn1: function(index, layero){
                                            //按钮【按钮一】的回调
                                            layer.close(index);
                                        }
                                    });
                                }else{
                                    if($scope.endorse.endorseConditionDto.endorType=='71'){
                                        oldSubsidy = angular.copy($scope.endorse.responseQueryPolicyListInfoDtoList);
                                        $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList=$scope.endorse.responseQueryPolicyListInfoDtoList;
                                        angular.forEach( $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList, function (data) {
                                            data.subsidyRate=""
                                        })
                                        console.log( $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList);
                                    }else if($scope.endorse.endorseConditionDto.endorType=='11'){
                                        angular.forEach( $scope.endorse.responseQueryPolicyListInfoDtoList, function (data) {
                                            data.rate=""
                                        })
                                        $scope.endorse.blEndorseDtoList[0].prpPitemKindDtoList=$scope.endorse.responseQueryPolicyListInfoDtoList
                                    }else if($scope.endorse.endorseConditionDto.endorType=='91'){
                                        angular.forEach( $scope.endorse.responseQueryPolicyListInfoDtoList, function (data) {
                                            data.unitAmount=""
                                        })
                                        $scope.endorse.blEndorseDtoList[0].prpPitemKindDtoListCopy=$scope.endorse.responseQueryPolicyListInfoDtoList
                                    }

                                }

                            }
                            //如果是业务员批改
                            if(initType == "UIEndorsehandler1Code"){

                                $scope.handler1Name = angular.copy(data.content.endorseConditionDto.handler1Name);
                            }
                            //if(data.content.endorseConditionDto.endorType=='71'){
                            //    var strPolicyNo="";
                            //    angular.forEach($rootScope.policyNo,function(data,index){
                            //        angular.forEach($scope.responseQueryPolicyListInfoDtoList,function(item,no){
                            //            if($rootScope.policyNo.policyNo==$scope.responseQueryPolicyListInfoDtoList.blEndorseDtoList.prpPheadDto.policyNo){
                            //                data.splice(index,22)
                            //            }
                            //        });
                            //    });
                            //    angular.forEach($rootScope.policyNo,function(data,index){
                            //        strPolicyNo+=data.policyNo+" ";
                            //    });
                            //    console.log(strPolicyNo);
                            //}
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            };


            $scope.getShortRate = function (value) {
                $scope.endorse.endorseConditionDto.shortRateFlag=value;
            }
            //---批改业务员加的，应该用上面的查询归属业务员，为防测试变卦暂时注释掉
            //var list=[];
            //angular.forEach($scope.responseQueryPolicyListInfoDtoList,function(item){
            //    list.push(item.policyNo);
            //});
            //$$finder.find('queryUserCode',{
            //    "comCode":$scope.user.loginComCode,
            //    "policyNos":list,
            //},{
            //    success:function(data){
            //        $scope.handCodeList=data.content;
            //    },
            //    error:function(e){
            //
            //    }
            //})
            $scope.updateHandler = function (_handler) {
                $scope.endorse.endorseConditionDto.handler1Code=_handler;
            };
            /**
             * 补贴项添加
             */
            $scope.addSubsidy = function () {
                var item =  {
                    subsidyCode:'',//补贴类型
                    subsidyType:'',//补贴方式
                    subsidyRate:'',//补贴比例
                    subsidyDepartment:'',//补贴单位
                    subsidyPremium:'',//补贴金额
                    operationFlag:'A'//操作标识 A:增加 U:修改
                };
                $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList.push(item);
            };
            /**
             * 补贴项删除
             * @param _subsidy 要删除的
             */
            $scope.delSubsidy = function (_subsidyIndex) {
                $scope.subsidys.splice(_subsidyIndex,1);
            };
            /**
             * 补贴项修改
             * @param _index 修改的索引
             */
            $scope.updateSubsidy = function (_index) {
                //判断是否修改的是后端传的数据
                if(oldSubsidy[_index]){
                    $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].operationFlag = 'U';
                }
            };
            /**
             * 单位保险金额修改
             * @param _index
             */
            //$scope.updateUnitAmountMain=function(_index){
            //    $scope.endorse.blEndorseDtoList[0].prpPitemKindDtoListCopy[_index].operationFlag = 'U';
            //}

            /**
             * 单位保险金额修改
             * @param _index
             */
            //$scope.updateRate=function(_index){
            //    $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].operationFlag = 'U';
            //}

            /**
             * 根据补贴比例带出补贴金额 或者 根据补贴金额带出补贴比例
             * @param _index 要修改的选项
             * @param _type 类型
             */
            //$rootScope.amount= function (str) {
            //    if(str){
            //        var number=parseInt(str);
            //        if(number==str){
            //            return Number(str).toFixed(2);
            //        }else{
            //            return Number(str).toFixed(4);
            //        }
            //    }
            //}
            $scope.calcSubsidy = function (_index,_type,$event) {
                switch (_type){
                    //根据补贴比例带出补贴金额
                    case "subsidyRate":
                        var reg =/^\d{1,3}(\.\d{1,2})?$/;
                        if($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate && !reg.test($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate)){
                            $scope.check.subsidyRate = "补贴比例只能输入整数且长度为3位和至多两位小数！";
                            $event.target.focus();
                            break;
                        }else{
                            $scope.check.subsidyRate = "";
                        }
                        if($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate > 100 || $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate < 0){
                            //layerMsg('补贴比例只能为0%-100%');
                            //$scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate = 0;
                            // $('input[name="'+$event.target.name+'"]').css('background','#D9534F');
                            $scope.check.subsidyRate = "补贴比例只能为0%-100%";
                            $event.target.focus();
                            break;
                        }else{
                            $scope.check.subsidyRate = "";
                        }
                        $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate=$scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate;
                        $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyPremium = (($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate)/100) * ($scope.endorse.endorseConditionDto.sumPremium);
                        break;
                    //根据补贴金额带出补贴比例
                    case "subsidyPremium":
                        if($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyPremium > $scope.endorse.endorseConditionDto.sumPremium){
                            layerMsg('补贴金额不能大于保费');
                            $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyPremium = 0;
                            // $('input[name="'+$event.target.name+'"]').css('background','#D9534F');
                            break;
                        }
                        $scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyRate = ($scope.endorse.blEndorseDtoList[0].prpPsubsidyDtoList[_index].subsidyPremium)/($scope.endorse.endorseConditionDto.sumPremium) * 100;
                        break;
                }
            };
            /**
             * 初始化信息
             */
            var init = function () {
                //获取路由参数
                $scope.endorseObj = JSON.parse($stateParams.endorse);

                $scope.obtainText = false;//批文页面
                $scope.infoToView = {
                    "saveEnderseFlag":false
                };
                $scope.endorse = {
                    "blEndorseDtoList": [
                        {
                            "prpPheadDto": {
                                "policyNo": '',//保单号
                                "makeCom": '',//出单机构
                                "operatorCode": $rootScope.user.userCode,//操作人员代码
                                "endorDate": $scope.endorseDate,//批改日期
                                "validDate": $scope.endorseDate1,//批改生效日期
                                "validHour": 0,//批改生效小时
                                "appliName": "",//申请人
                                "endorseType": "",//批改方式
                                "endorseMessage": "",
                                "endorseNo": ""
                            }
                        }
                    ],
                    "endorseConditionDto": {
                        "endorseName":'',//批改申请人
                        "endorType": $scope.endorseConditionDto.endorType,//批改方式
                        "shortRateFlag":'1',//短期费率方式
                        "validDate":$scope.endorseDate1,//批改生效日期
                        "endorDate":$scope.endorseDate,//批改日期
                        "endorseReason":'',//批改方式原因
                        "startHour":"",//开始小时
                        "startDate":'',// 保险起期
                        "endDate":"",//保险止期
                        "endHour":""//结束小时
                    },
                    "prpCitemKindDtoListNew":$scope.responseQueryPolicyListInfoDtoList.prpCitemKindDtoListNew,
                    "prpCsubsidyDtoListNew":$scope.responseQueryPolicyListInfoDtoList.prpCsubsidyDtoListNew,
                };
                //补贴列表项
                $scope.subsidys = [
                    {
                        subsidyType:'01',//补贴类型

                        subsidyCode:'03',//补贴方式
                        subsidyRate:'30',//补贴比例
                        subsidyCompany:'30',//补贴单位
                        subsidyMoney:'30'//补贴金额
                    }
                ];

                switch ($scope.endorseObj.endorseType){
                    //变更保险期限
                    case 'UIEndorseAgriculturalUpdate':
                        $scope.publicShow=true;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'变更保险期限'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":"01",//特殊批改类型 01-变更保险期限，
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords);
                        break;
                    //业务来源批改
                    case 'UIEndorseBusinesSourcesModified':
                        $scope.publicShow=true;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'业务来源批改'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":""//TODO 业务来源批改
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords);
                        break;
                    //业务员批改
                    case 'UIEndorsehandler1Code':
                        $scope.publicShow=false;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'业务员批改'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":"85",// 业务员批改
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords,"UIEndorsehandler1Code");
                        break;
                    //调整费率
                    case 'UIEndorseAdjustRate':
                        $scope.publicShow=true;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'调整费率'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":"11"// 调整费率
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords);
                        break;
                    //调整补贴信息
                    case 'UIEndorseAdjustSubsidy':
                        $scope.publicShow=true;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'调整补贴信息'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":"71",// 调整补贴信息
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords);
                        break;
                    //调整单位保额
                    case 'UIEndorseAdjustUnitInsured':
                        $scope.publicShow=true;
                        $scope.Tittle={
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'调整单位保额'
                        };
                        var keywords = {
                            //"policyNo":$scope.endorseObj.policy.policyNo || '',//保单号
                            //"endorType":"91"// 调整单位保额
                            "responseQueryPolicyListInfoDtoList":$scope.responseQueryPolicyListInfoDtoList,
                            "endorseConditionDto":$scope.endorseConditionDto,
                        };
                        findInit('specialEndorIni',keywords);
                        break;
                };
            };
            init();
            Window.prototype.layerMsg = function(data,target){
                // var icon = target == 'success'?"1":target == 'error'?"2":"0";
                layer.open({
                    //offset: ['35%', '40%'],
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: data,
                    btn: ['确定'],
                    btn1: function (index) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });

            };
			// $scope.paginationConfmm.totalItems = $scope.totalItems;
        }]);
});