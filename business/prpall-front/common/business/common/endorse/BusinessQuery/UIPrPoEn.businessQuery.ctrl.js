/**
 * Created by hanyuhuai on 2017/12/.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIPrPoEnBusinessQuery', ['$rootScope', '$scope','$$finder','$http','$filter','$state',
        function ($rootScope,$scope,$$finder,$http,$filter,$state) {
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
            //获取时间
            var date=new Date()
            $scope.getdate={
                year:date.getFullYear(),
                month:date.getMonth(),
                day:date.getDate()
            }
            $scope.number=function(x)
            {
                return x<10 ? '0'+x:x

            }
            //提交查询信息
            $scope.totalItems=0;
            $scope.proposal={};
            $scope.proposal.prpBusinesslist={};
            var content;
            var isQueryFlag = true;
            $scope.submit=function(){
               var startDate=  $scope.proposal.prpBusinessDto.startDate;
                var endDate =$scope.proposal.prpBusinessDto.endDate;
                if($scope.listType == null || $scope.listType=="")
                {
                    content = '请选择清单类型！';
                    $scope.dd();
                    return ;
                }else if($scope.listType=='D')
                {
                    var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                    var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                    if (startDate != endDate)
                    {
                        content = '操作起止日期需为同一天！';
                        $scope.dd();
                        return ;
                    }
                  }
                 else if(startDate != null && endDate != null) {
                    var startDate = parseInt(startDate.replace(/-/g, ""), 10);
                    var endDate = parseInt(endDate.replace(/-/g, ""), 10);
                    if (startDate > endDate) {
                        content = '有效止期要大于有效起期';
                        $scope.proposal.prpBusinessDto.endDate = "";
                        $scope.dd();
                        return ;
                    }else if(!$scope.proposal.prpBusinessDto.startDate&&$scope.proposal.prpBusinessDto.endDate){
                        content="请输入起期！";
                        $scope.dd();
                        return ;
                    }
                }
                $scope.data=angular.copy({
                    "listType":$scope.listType,//清单类型
                    "startDate":$scope.proposal.prpBusinessDto.startDate,//开始日期
                    "endDate": $scope.proposal.prpBusinessDto.endDate,//结束日期
                    "classCode":$scope.proposal.prpBusinessDto.classCode,//险种
                    "comCode": $rootScope.user.loginComCode,//机构
                });
                if (isQueryFlag) {
                    $scope.data.pageNo = $scope.paginationConfmm.currentPage = 1;
                    $scope.data.pageSize = $scope.paginationConfmm.itemsPerPage = 20;
                } else {
                    $scope.data.pageNo = $scope.paginationConfmm.currentPage;
                    $scope.data.pageSize = $scope.paginationConfmm.itemsPerPage;
                    isQueryFlag = true;
                }
                $$finder.find('prpbusinoesslist',$scope.data, {
                    success: function (data) {
                        if(data.code="0000"&&data.content.content.length>0){
                            $scope.proposal.prpBusinesslist.clauseQueryList = data.content.content;
                            //查询结果条数
                            $scope.showPage = true;
                            $scope.paginationConfmm.totalItems = data.content.totalCount;
                            var numWS = 0;
                            $scope.proposal.listTypeWS = '';
                            $scope.proposal.listTypeD = '';
                            angular.forEach(data.content.content, function (info) {
                                if ($scope.listType == 'D') {
                                    var num = parseFloat(info.sumPremium);
                                    numWS = numAdd(numWS, num);

                                } else if ($scope.listType == 'W') {
                                    var num = parseFloat(info.delinQuentFee);
                                    numWS = numAdd(numWS, num);

                                } else if ($scope.listType == 'S') {
                                    var num = parseFloat(info.delinQuentFee);
                                    numWS = numAdd(numWS, num);
                                }
                            })
                            var rs = numWS.toString().indexOf('.');
                            if (rs < 0) {
                                numWS += '.00'
                            } else {
                                rs = numWS.length;
                                while (numWS.length <= rs + 4) {
                                    numWS += '0';
                                }
                            }
                            numWS = numWS.substring(0, numWS.indexOf('.') + 5)+ '';

                            if($scope.listType=='S'||$scope.listType=='W'){
                                $scope.proposal.listTypeWS=numWS+'';
                            }else {
                                $scope.proposal.listTypeD=numWS+'';
                            }
                        }else if(data.code=="9999"){
                            layer.open({
                                skin: 'large-layer-content',
                                scrollbar: false,
                                closeBtn: 0,
                                title: '温馨提示',
                                content: '系统异常、请联系管理员！',
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    layer.close(index);
                                }
                            });
                        }else{
                            $scope.paginationConfmm.totalItems=0;
                            $scope.proposal.prpBusinesslist.clauseQueryList=[];
                        }

                    },
                    error: function (e) {
                    }
                });
            }
            //小数相加时精度丢失问题
            function numAdd(num1, num2) {
                var baseNum, baseNum1, baseNum2;
                try {
                    baseNum1 = num1.toString().split(".")[1].length;
                } catch (e) {
                    baseNum1 = 0;
                }
                try {
                    baseNum2 = num2.toString().split(".")[1].length;
                } catch (e) {
                    baseNum2 = 0;
                }
                baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
                var precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;//精度
                return ((num1 * baseNum + num2 * baseNum) / baseNum).toFixed(precision);;
            };
            $scope.dd=function(){
                    layer.open({
                        //offset: ['45%', '40%'],
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
            //分页设置
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50],
                    onChange: function () {
                        if($scope.paginationConfmm.totalItems==0||!$scope.paginationConfmm.totalItems){
                            return ;
                        }else{
                            isQueryFlag = false;
                            $scope.submit()
                        }
                    }
                };
            };
            initPage2();
            $scope.paginationConfmm.totalItems =  $scope.totalItems;
            if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
                $scope.paginationConfmm.totalItems=0;
            }
            $scope.stateToNext = function(){
                $scope.showPage=false;
                $scope.listType = "";
                $scope.proposal.prpBusinessDto.classCode="";
                $scope.proposal.prpBusinessDto.startDate=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-01';
                $scope.proposal.prpBusinessDto.endDate=$scope.getdate.year+'-'+$scope.number($scope.getdate.month+1)+'-'+$scope.number($scope.getdate.day)
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.prpBusinesslist.clauseQueryList ={}
            }
            //导出excel
            $scope.excel=function(){
               $$finder.find('prpbusinoesslistexcel',$scope.data,{
                   success: function (data) {
                       if(data.code="0000"){
                           var shortLink = data.content.shortLink;
                           window.open(shortLink);
                       }
                   }
               })
            }
            $scope.setdata= function(x){
                if(x==1)
                {
                    $scope.proposal.prpBusinessDto.startDate= $scope.number($scope.getdate.year)+'-'+ $scope.number($scope.getdate.month+1)+'-'+'01';
                    $scope.proposal.prpBusinessDto.endDate= $scope.number($scope.getdate.year)+'-'+ $scope.number($scope.getdate.month+1)+'-'+ $scope.number($scope.getdate.day);
                }else {
                    $scope.proposal.prpBusinessDto.startDate= $scope.number($scope.getdate.year)+'-'+ $scope.number($scope.getdate.month+1)+'-'+ $scope.number($scope.getdate.day);
                    $scope.proposal.prpBusinessDto.endDate=$scope.number($scope.getdate.year)+'-'+ $scope.number($scope.getdate.month+1)+'-'+  $scope.number($scope.getdate.day);
                }

            }
        }]);
});