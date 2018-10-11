/**
 * DESC: 农险angular－特殊批改全单退保／保单注销控制器
 * Created by sen on 2017/11/12.
 * --------------------------------------------------------
 *      sunyaohui       2018-01-06     项目部署
 */
define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('cancellationAndFullSurrendPolicyCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$location','$stateParams','$modal','$$user','$state','commonApiServ',
        function ($rootScope, $scope, $$finder, $http, $filter, $location,$stateParams,$modal,$$user,$state,commonApiServ) {
            //获取路由参数
            $scope.endorseObj = JSON.parse($stateParams.endorse);
            $scope.number=$scope.endorseObj.policy.length;
            $scope.details1=[];
            $scope.details=[];
            $scope.endorseConditionDto={};
           if($rootScope.endorseConditionDto==undefined){
               $rootScope.endorseConditionDto={};
               $("html,body").css({overflow:"auto"});//出现滚动条
               $state.go('UIEndorseSpecial');
           };
            $scope.details1=$scope.endorseObj.policy;
            $scope.endorseDate = $filter('date')(new Date(),'yyyy-MM-dd');
            $scope.endorseDate1 = $filter('date')(new Date().getTime()+86400000,'yyyy-MM-dd');
            $scope.choosedDetail = function() {
                $scope.paginationConfmm1.totalItems =  $scope.number;
                $scope.paginationConfmm1.currentPage = 1;
                $scope.paginationConfmm1.itemsPerPage = 5;
                for (var i = ($scope.paginationConfmm1.currentPage - 1) * $scope.paginationConfmm1.itemsPerPage; i < $scope.paginationConfmm1.currentPage * $scope.paginationConfmm1.itemsPerPage; i++) {
                    if ($scope.details1[i]) {
                        $scope.details.push($scope.details1[i]);
                    }
                    $scope.showDetail = true;
                    $("html,body").css({overflow:"hidden"});//隐藏滚动条
                }
            };
            $scope.cancel=function(){
                $scope.showDetail=false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
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
            //批改生效日期 与批改日期检验
            $scope.compare= function (endorseDate1,endorseDate) {
                if(endorseDate){
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
             * 批文信息
             */
            $scope.showAdjust = function () {
                // $scope.obtainText = true;
            };

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
                    newDate.setDate(newDate.getDate() + dateNum );
                }
                var year = newDate.toISOString();
                return year.substring(0,10);
            };
            var initPage3 = function ($event) {
                $scope.paginationConfmm1 = {
                    currentPage: 1,//当前页
                    totalItems: 0,//总条数
                    itemsPerPage: 5,//每页条数
                    pagesLength: 5,//总页数
                    perPageOptions: [5, 10, 20, 50],
                    onChange:function() {
                        $scope.details = [];
                        for (var i = ($scope.paginationConfmm1.currentPage - 1) * $scope.paginationConfmm1.itemsPerPage; i <$scope.paginationConfmm1.currentPage * $scope.paginationConfmm1.itemsPerPage; i++) {
                            if($scope.details1[i]){
                                $scope.details.push($scope.details1[i]);
                            }

                        }
                    }

                };
            };
            initPage3();
            /**
             * 当前日期转化为时间戳
             * @param stringTime 当前时间（2018-01-01）
             * @returns {number}
             */
            $scope.stampTime = function (stringTime) {
                return Date.parse(new Date(stringTime));
            };

            $scope.publicShow=true;
            //上一步
            $scope.last = function(){
                //特批查询
                $("html,body").css({overflow:"auto"});//出现滚动条
                $location.path('/UIEndorseSpecial');
            };
            //下一步 全单退保 ，保单注销 特批生成批文
            $scope.next = function(){
                if(!$scope.endorse.blEndorseDtoList[0].prpPheadDto.appliName){
                    layerMsg('批改申请人不能为空！');
                }else if(!$scope.endorseDate1){
                    layerMsg('批改生效日期不能为空！');
                }else if($scope.endorse.blEndorseDtoList[0].prpPheadDto.endorseType=="02"&&(!$scope.endorse.endorseConditionDto.endorseReason || $scope.endorse.endorseConditionDto.endorseReason==""|| $scope.endorse.endorseConditionDto.endorseReason==null)){
                        layerMsg('请先输入批改原因');
                }else{
                    $scope.endorse.endorseConditionDto.loginComCode=$rootScope.user.loginComCode;
                    $scope.endorse.endorseConditionDto.validHour=0;
                    $scope.endorse.endorseConditionDto.endHour=24;
                    $scope.endorse.endorseConditionDto.agriStartDate=$scope.responseQueryPolicyListInfoDtoList[0].startDate;
                    $scope.endorse.responseQueryPolicyListInfoDtoList=$scope.responseQueryPolicyListInfoDtoList;
                    $scope.endortype1=$scope.endorse.endorseConditionDto.endorType;
                    angular.forEach($scope.endorse.blEndorseDtoList,function(item,index){
                        //item.prpPheadDto.validDate=$scope.endorseDate1;
                        //item.prpPheadDto.validHour=0;
                        //item.prpPheadDto.endorDate=$scope.endorseDate;
                        item.prpPheadDto.policyNo=$scope.responseQueryPolicyListInfoDtoList[index].policyNo;
                    });
                    var keywords=$scope.endorse;

                    $$finder.find('endorseapproval',keywords, {
                        success: function(data) {
                            //显示批文信息页面
                            $scope.obtainText = false;
                            $scope.endorseTextObj = data.content;
                            //   $scope.endorseText = data.content[0].blEndorseDto.prpPtextDtoList[0].endorseText;
                            if($scope.endortype1!='92') {
                                if ($scope.endorseTextObj != null) {
                                    $scope.saveEnderseText();
                                }
                            }else{
                                var contText='注销成功！保单为:';
                                angular.forEach($scope.details1,function(com,index){
                                    if(index==0) {
                                        contText += com.policyNo;
                                    }else{
                                        contText +=","+com.policyNo;
                                    }
                                })
                                layer.open({
                                    //offset: ['28%', '30%'],
                                    skin: 'large-layer-content',
                                    scrollbar: false,
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: contText,
                                    btn: ["关闭"],
                                    btn1: function (index, layero) {
                                        layer.close(index);
                                        $("html,body").css({overflow:"auto"});//出现滚动条
                                        $state.go('UIEndorseSpecial');
                                    }
                                });
                            }
                        },
                        error: function(e) {
                            console.log(e);
                        }
                    });
                }

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
                $scope.endorseTextObj[0].blEndorse.prpPtextDtoList[0].endorseText = _endorseText;
            };
            /**
             * 保存批文页面
             */
            $scope.saveEnderseText = function () {
                $$finder.find('endorsesave', $scope.endorseTextObj, {
                    success: function (data) {
                        if(data  && data.content){
                            //$scope.infoToView.saveEnderseFlag = true;
                            console.log(data);
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
                                                if(data && data.content){
                                                    console.log(data);
                                                    layer.open({
                                                        //offset: ['35%', '35%'],
                                                        skin: 'large-layer-content',
                                                        scrollbar: false,
                                                        closeBtn: 0,
                                                        title: '温馨提示',
                                                        content: data.content[0],
                                                        btn: ["关闭"],
                                                        btn1: function (index, layero) {
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
                                       // $scope.quit();
                                        //$state.go('UIEndorse3107edit', {
                                        //    editType: 'show',
                                        //    bizNo: batch.endorseList[0],
                                        //})
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
                            }).result.then();
                        }else if(data.code == '9999'){
                            layerMsg(data.message);
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            };
            //查看详情
            $scope.totalItems = 0;
            $scope.showDetail = false;
            $("html,body").css({overflow:"auto"});//出现滚动条
            //$scope.choosedDetail = function(){
            //    //查询保单列表信息
            //    $$finder.find('selectedGuaranteeDetails', {}, {
            //        success: function(data) {
            //            if(data.code="0000"){
            //                $scope.details = data.data.resultObj.content;
            //                $scope.totalItems = $scope.details.length;
            //                $scope.paginationConfmm.totalItems = $scope.totalItems;
            //                $scope.showDetail = true;
            //            }
            //        },
            //        error: function(e) {
            //            console.log(e);
            //        }
            //    });
            //};
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
             * 初始化
             * @param _type 特批类型
             * @param _keywords 入参
             */
            var findInit = function (_type,_keywords) {
                $rootScope.endorseConditionDto.validDate=$scope.endorseDate1;
                $rootScope.endorseConditionDto.endorDate=$scope.endorseDate;
                $rootScope.endorseConditionDto.userCode=$rootScope.user.userCode;
                $$finder.find('specialEndorIni', {
                    "responseQueryPolicyListInfoDtoList":$rootScope.responseQueryPolicyListInfoDtoList,
                    "endorseConditionDto":$rootScope.endorseConditionDto,
                }, {
                    success: function (data) {
                        if(data.code=='0000'&&data.content.message){
                            console.log(data.content);
                            layerMsg(data.content.message);
                            $("html,body").css({overflow:"auto"});//出现滚动条
                            $state.go('UIEndorseSpecial');
                        }else if(data && data.content){
                            angular.extend($scope.endorse,data.content);
                            //短期费率方式默认值
                            if(!$scope.endorse.endorseConditionDto.shortRateFlag){
                                $scope.endorse.endorseConditionDto.shortRateFlag = '3';
                            }
                            //endoretype改为endorType
                            //$scope.endorse.endorseConditionDto.endorType = $scope.endorse.endorseConditionDto.endoretype;
                            //delete $scope.endorse.endorseConditionDto.endoretype;
                            //批改生效小时 如果没有默认0
                            //if(!$scope.endorse.blEndorseDtoList[0].prpPheadDto.validHour){
                            //    $scope.endorse.blEndorseDtoList[0].prpPheadDto.validHour = '0';
                            //}
                            if($scope.endorse.blEndorseDtoList.length>1){
                                $scope.endorse.blEndorseDtoList[0].prpPheadDto.appliName='';//批改申请申人清空
                            }
                            //angular.forEach($rootScope.comcodeIndexList,function(com,index){
                            //    if(com.comCode==$rootScope.user.loginComCode){
                            //        $scope.endorseConditionDto.loginComCName=com.comCName;
                            //        $scope.endorse.blEndorseDtoList[0].prpPheadDto.makeCom=$rootScope.comcodeIndex;
                            //    }
                            //})
                            //归属部门
                            var comCode = $rootScope.responseQueryPolicyListInfoDtoList[0].comCode;
                            $scope.endorseConditionDto.comCode = comCode;
                            $$finder.find('queryByPKByMap',{
                                comCode:comCode
                            }, {
                                success: function (data) {
                                    $scope.endorseConditionDto.loginComCName = data.content.comCName;
                                },
                                error: function (e) {
                                    options.error(e);
                                }
                            });
                            //批改生效日期
                            $scope.endorse.blEndorseDtoList[0].prpPheadDto.validDate = $filter('date')(new Date().getTime()+86400000,'yyyy-MM-dd');
                            //批改生效小时
                            $scope.endorse.blEndorseDtoList[0].prpPheadDto.validHour = '0';
                            //批改日期
                            $scope.endorse.blEndorseDtoList[0].prpPheadDto.endorDate = $filter('date')(new Date(),'yyyy-MM-dd') ;
                        }/*else{
                            layerMsg("初始化失败");
                        }*/
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            };
            /**
             * 初始化信息
             */
            var init = function () {
                $scope.infoToView = {
                    "saveEnderseFlag":false
                };
                //批文信息显示
                $scope.obtainText = false;
                //初始化入参
                $scope.endorse = {
                    "blEndorseDtoList": [
                        {
                            "prpPheadDto": {
                                "policyNo": '',//保单号
                                "makeCom": '',//出单机构
                                "operatorCode": "",//操作人员代码
                                "endorDate": "",//批改日期
                                "validDate": "",//批改生效日期
                                "validHour": '',//批改生效小时
                                "appliName": "",//申请人
                                "endorseType": "",//特殊批改类型
                                "endorseMessage": "",
                                "endorseNo": ""
                            }
                        }
                    ],
                    "endorseConditionDto": {
                        "endorType": "",//特殊批改类型
                        "shortRateFlag": '1',//短期费率
                        "iRate": '',
                        "breedingFarmerListFlag": '',
                        "agriStartDate": "",//保险起期（yyyy-MM-dd）
                        "startHour": "",//起期小时
                        "endDate": "",//保险止期（yyyy-MM-dd）
                        "endHour": "",//止期小时
                        "unitAmountMain": []
                    }
                };
                //判断特批类型
                switch ($scope.endorseObj.endorseType){
                    //保单注销
                    case 'UIEndorseCancellationPolicy':
                        $scope.publicShow=false;
                        $scope.Tittle = {
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'保单注销'
                        };
                        /**
                         * 保单注销初始化
                         */
                        var policyNoArr=[];
                        angular.forEach($scope.endorseObj.policy,function(com,index){

                            policyNoArr.push(com.policyNo);
                        })
                        var keywords = {
                            "policyNo":policyNoArr,//保单号
                            // "policyNo":"231013400002017000106",
                            "endorType":"19"//特殊批改类型（01-变更保险期限，19-注销保单，21全单退保）
                        };
                       findInit("endorseinit",keywords);
                        console.log('进入保单注销');
                        break;
                    //全单退保
                    case 'UIEndorseFullSurrender':
                        $scope.publicShow=true;
                        $scope.Tittle = {
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'全单退保'
                        };
                        /**
                         * 全单退保初始化
                         */
                        var policyNoArr=[];
                        angular.forEach($scope.endorseObj.policy,function(com,index){

                            policyNoArr.push(com.policyNo);
                        })
                        var keywords = {
                            "policyNo":policyNoArr,//保单号
                            // "policyNo":"231013400002017000106",
                            "endorType":"21"//特殊批改类型（01-变更保险期限，19-注销保单，21全单退保）
                        };
                        findInit("endorseinit",keywords);
                        console.log('进入全单退保');
                        break;
                    //见费出单保单注销
                    case 'UIEndorseeExpenseCancelPolicy':
                        $scope.publicShow=false;
                        $scope.Tittle = {
                            firstLev:'批改管理',
                            secLev:'特殊批改查询',
                            thirdLev:'见费出单保单注销'
                        };
                        /**
                         * 见费出单保单注销初始化
                         */
                        var policyNoArr=[];
                        angular.forEach($scope.endorseObj.policy,function(com,index){

                            policyNoArr.push(com.policyNo);
                        })
                        var keywords = {
                            "policyNo":policyNoArr,//保单号
                            // "policyNo":"231013400002017000106",
                            "endorType":"19"//TODO 特殊批改类型（01-变更保险期限，19-注销保单，21全单退保）
                        };
                        findInit("endorseinit",keywords);
                        console.log('见费出单保单注销');
                        break;
                }
            };
            init();
            Window.prototype.layerMsg = function(data,target){
                // var icon = target == 'success'?"1":target == 'error'?"2":"0";
                layer.open({
                    //offset: ['35%', '40%'],
                    skin: 'large-layer-content',
                    closeBtn: 0,
                    scrollbar: false,
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