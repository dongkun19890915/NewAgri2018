/**
 * Created by sen on 2017/11/17.
 */

define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIProposalManagement', ['$rootScope', '$scope','$$finder','$http','$filter','$state','$$code',
        function ($rootScope,$scope,$$finder,$http,$filter,$state,$$code) {
            $scope.endorHide=true;//批改时删除和修改按钮隐藏
            //提交查询信息
            $scope.proposal = {};
            $scope.check={};
            $scope.proposal.prpMmodelMainRequest = {};
            $scope.proposal.prpMmodelMainRequest.pageNo = 1;
            $scope.proposal.prpMmodelMainRequest.pageSize = 5;
            var content;
            $scope.selectListData={};// 级联下拉列表数据
            // 获取归属机构下拉列表
            $scope.getComCodeList=function(){
                var comCodeData={
                    comCode: '',
                    comCName: '',
                    riskCode: '',
                    gradeCodes: '111',
                    userCode: $scope.user.userCode,
                    loginComCode: $scope.user.loginComCode
                };
                $$code.getCodes('codeType', 'queryComCodeInfo', { },comCodeData).then(function (data) {
                    $scope.selectListData.comCodeList = data;
                });
            };
            $scope.submit = function () {
                if(
                    ($scope.proposal.prpMmodelMainRequest.modelCode!=undefined&&$scope.proposal.prpMmodelMainRequest.modelCode!="")
                    ||($scope.proposal.prpMmodelMainRequest.modelName!=undefined&&$scope.proposal.prpMmodelMainRequest.modelName!="")
                    ||($scope.proposal.prpMmodelMainRequest.comCode!=undefined&&$scope.proposal.prpMmodelMainRequest.comCode!="")
                    ||($scope.proposal.prpMmodelMainRequest.riskCode!=undefined&&$scope.proposal.prpMmodelMainRequest.riskCode!="")
                    ||($scope.proposal.prpMmodelMainRequest.itemName!=undefined&&$scope.proposal.prpMmodelMainRequest.itemName!="")
                    ||($scope.proposal.prpMmodelMainRequest.createBy!=undefined&&$scope.proposal.prpMmodelMainRequest.createBy!="")
                    ||($scope.proposal.prpMmodelMainRequest.applayname!=undefined&&$scope.proposal.prpMmodelMainRequest.applayname!="")
                    ||($scope.proposal.prpMmodelMainRequest.insuredname!=undefined&&$scope.proposal.prpMmodelMainRequest.insuredname!="")
                    ||($scope.proposal.prpMmodelMainRequest.startDate!=undefined&&$scope.proposal.prpMmodelMainRequest.startDate!="")
                    ||($scope.proposal.prpMmodelMainRequest.endDate!=undefined&&$scope.proposal.prpMmodelMainRequest.endDate!="")
                    ||($scope.proposal.prpMmodelMainRequest.BusinessType1!=undefined&&$scope.proposal.prpMmodelMainRequest.BusinessType1!="")
                    ||($scope.proposal.prpMmodelMainRequest.validStatus!=undefined&&$scope.proposal.prpMmodelMainRequest.validStatus!="")
                  )
                {
                    var content="";
                    var numberReg=/^\d{15,}$/;//至少15位数字
                    var appliNameReg=/^[\u4E00-\u9FA50-9]+$/;// 数字汉字
                    var sumAmountRge=/^\d+$/;//数字
                    var appliCodeReg=/^[A-Za-z0-9]+$/;//数字  字母
                    var provenceReg=/^[\u4E00-\u9FA5]+$/;//汉字
                    var modelCodeReg=/^TB[0-9]/;
                    var rr=/^TB[0-9]+$/;
                    if($scope.proposal.prpMmodelMainRequest.modelCode){
                        //模板号码
                        var rr=/^TB[0-9]+$/;
                        if(rr.test($scope.proposal.prpMmodelMainRequest.modelCode)){
                            if($scope.proposal.prpMmodelMainRequest.modelCode.length<15){
                                content="模板号码需输入至少15位数！";
                            }
                        }else{
                            content = '模板号码格式错误，请修改';
                            $scope.proposal.prpMmodelMainRequest.modelCode="";
                        }
                    }
                    else if($scope.proposal.prpMmodelMainRequest.modelName&&!appliNameReg.test($scope.proposal.prpMmodelMainRequest.modelName)){
                        //模板名称
                        content="模版名称格式错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.modelName="";
                    }/*else if($scope.proposal.prpMmodelMainRequest.comCode&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.comCode)){
                        //适用机构
                        content="适用机构错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.comCode="";
                    }*/
                    //else if($scope.proposal.prpMmodelMainRequest.riskCode&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.riskCode)){
                    //    //险种
                    //    content="险种格式错误，请修改！";
                    //    $scope.proposal.prpMmodelMainRequest.riskCode="";
                    //}
                    else if($scope.proposal.prpMmodelMainRequest.itemName&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.itemName)){
                        //标的
                        content="标的格式错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.itemName="";
                    }else if($scope.proposal.prpMmodelMainRequest.createBy&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.createBy)){
                        //创建人名称
                        content="创建人名称格式错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.createBy="";
                    }else if($scope.proposal.prpMmodelMainRequest.applayname&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.applayname)){
                        //投保人名称
                        content="投保人名称格式错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.applayname="";
                    }else if($scope.proposal.prpMmodelMainRequest.insuredname&&!provenceReg.test($scope.proposal.prpMmodelMainRequest.insuredname)){
                        //被投保险人名称
                        content="被投保险人名称格式错误，请修改！";
                        $scope.proposal.prpMmodelMainRequest.insuredname="";
                    }

                    if(content){
                        layer.open({
                            //offset: ['45%', '40%'],
                            skin: 'large-layer-content',
                            scrollbar: false,
                            closeBtn: 0,
                            title: '温馨提示',
                            content: content,
                            btn: ['确定'],
                            btn1: function(index, layero){
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }else{
                        if($scope.proposal.prpMmodelMainRequest.modelCode){
                            $scope.proposal.prpMmodelMainRequest.startDate="";
                            $scope.proposal.prpMmodelMainRequest.endDate="";
                        }
                        $$finder.find('UIProposalManagement', {
                            "modelCode": $scope.proposal.prpMmodelMainRequest.modelCode,
                            "modelName": $scope.proposal.prpMmodelMainRequest.modelName,
                            "comCode": $scope.proposal.prpMmodelMainRequest.comCode,
                            "appledName": $scope.proposal.prpMmodelMainRequest.applayname,
                            "userName": $scope.proposal.prpMmodelMainRequest.createBy,
                            "insuredName": $scope.proposal.prpMmodelMainRequest.insuredname,
                            "riskCode": $scope.proposal.prpMmodelMainRequest.riskCode,
                            "itemCName": $scope.proposal.prpMmodelMainRequest.itemName,
                            "startDate": $scope.proposal.prpMmodelMainRequest.startDate,
                            "endDate": $scope.proposal.prpMmodelMainRequest.endDate,
                            "businessType1": $scope.proposal.prpMmodelMainRequest.BusinessType1,
                            "validStatus": $scope.proposal.prpMmodelMainRequest.validStatus,
                            "pageNo": $scope.paginationConfmm.currentPage,
                            "pageSize": $scope.paginationConfmm.itemsPerPage
                        }, {
                            success: function (data) {
                                if(data.code=="0000"&&data.content){
                                    if (data == "" || data == null) {
                                        $scope.proposal.clauseQueryList = null;
                                        $scope.paginationConfmm.totalItems = 0;
                                    } else {
                                        $scope.select_all="";
                                        $scope.proposal.clauseQueryList = data.content.content;

                                        //查询结果条数
                                        $scope.paginationConfmm.totalItems = data.content.totalCount;
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
                                    $scope.proposal.clauseQueryList=[];
                                    $scope.paginationConfmm.totalItems=0;
                                }
                                $scope.select_all="";

                                //$scope.proposal.prpMmodelMainRequest=data.data.proposal.prpMmodelMainRequest;
                                //$scope.cpproposal.prpMmodelMainRequest=$scope.proposal.prpMmodelMainRequest;
                                //$scope.totalItems=$scope.cpproposal.prpMmodelMainRequest.clauseQueryList.length;

                            },
                            error: function (e) {
                                console.log(e);
                            }
                        });
                    }
                }else
                {
                    content = '至少输入一查询条件！';
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: content,
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                    return ;
                }

            }
            $scope.changemodelCode= function (str) {
                if(str){
                    $scope.proposal.prpMmodelMainRequest.startDate="";
                    $scope.proposal.prpMmodelMainRequest.endDate="";
                    $scope.proposal.prpMmodelMainRequest.BusinessType1="";
                }else{
                    $scope.proposal.prpMmodelMainRequest.startDate=$scope.time.year+'-'+$scope.time.month+'-01';
                    $scope.proposal.prpMmodelMainRequest.endDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                    $scope.proposal.prpMmodelMainRequest.BusinessType1="01";
                }
            }
            //查询校验  blur事件校验
            $scope.checkmodelCode= function ($event,str) {
                //模板号码
                var modelCodeReg=/^TB[0-9]+$/;
                if(str&&!modelCodeReg.test(str)){
                    $scope.check.modelCode="模版号码格式错误，请修改！";
                    $event.target.focus();

                }else{
                    $scope.check.modelCode="";
                }
            }
            $scope.checkmodelName= function ($event,str) {
                //模板名称
                var modelNameReg=/^[\u4E00-\u9FA50-9]+$/;
                if(str&&!modelNameReg.test(str)){
                    $scope.check.modelName="模版名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.modelName="";
                }
            }
            $scope.checkcomCode= function ($event,str) {
                //适用机构
                var comCodeReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!comCodeReg.test(str)){
                    $scope.check.comCode="适用机构格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.comCode="";
                }
            }
            $scope.checkriskCode= function ($event,str) {
                //险种
                var riskCodeReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!riskCodeReg.test(str)){
                    $scope.check.riskCode="险种格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.riskCode="";
                }
            }
            $scope.checkitemName= function ($event,str) {
                //标的
                var itemNameReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!itemNameReg.test(str)){
                    $scope.check.itemName="标的格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.itemName="";
                }
            }
            $scope.checkcreateBy= function ($event,str) {
                //创建人名称
                var createByReg=/^[\u4E00-\u9FA5]+$/;
                if(str&&!createByReg.test(str)){
                    $scope.check.createBy="创建人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.createBy="";
                }
            }
            $scope.checkapplayname= function ($event,str) {
                //投保人名称
                var applaynameReg=/^[\u4e00-\u9fa5]+$/;
               var v= applaynameReg.test(str);
                var applaynameReg1 = /^[0-9\u4e00-\u9fa5]+$/;
                var vv = applaynameReg1.test(str);
                var  applaynameReg2 = /(?!\d+$)[\d\u4e00-\u9fa5]/;
                var vvv = applaynameReg2.test(str);
                if((str&&v==false)&&vv==false){
                    $scope.check.applayname="投保人名称格式错误，请修改！";
                    $event.target.focus();
                }else if((str&&v==false)&&vv==true&&vvv==false){
                    $scope.check.applayname="投保人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.applayname="";
                }
                //var applaynameReg=/^(?![0-9])[0-9\u4e00-\u9fa5]+$/;
                //var v=applaynameReg.test(str);
                //if (str&&v==false){
                //    $scope.check.applayname="投保人名称格式错误，请修改！";
                //    $event.target.focus();
                //}else{
                //      $scope.check.applayname="";
                //    }
            }
            $scope.checkinsuredname= function ($event,str) {
                //被保险人名称
                var insurednameReg=/([\u4e00-\u9fa5]+)([0-9]*$)/;
                if(str&&!insurednameReg.test(str)){
                    $scope.check.insuredname="被保险人名称格式错误，请修改！";
                    $event.target.focus();
                }else{
                    $scope.check.insuredname="";
                }
            }
            //获取后台数据
            //$scope.proposal={};
            //$scope.cpproposal={};
            //$$finder.find('proposalAdmin',{}, {
            //    success: function (data) {
            //        $scope.proposal.prpMmodelMainRequest=data.data.proposal.prpMmodelMainRequest;
            //        $scope.cpproposal.prpMmodelMainRequest=$scope.proposal.prpMmodelMainRequest;
            //        $scope.cpproposal.prpMmodelMainRequest.clauseQueryList={};
            //    },
            //    error: function (e) {
            //       console.log(e);
            //    }
            //});
            //获取投保单信息
            $scope.QueryList = function () {
            }
            //展开更多查询条件
            $scope.SRC = "common/images/chenpeng/展开.png";
            $scope.conditionShow = false;
            $scope.addFrom = function () {
                $scope.conditionShow = !$scope.conditionShow;
                $scope.SRC = !$scope.conditionShow ? "common/images/chenpeng/展开.png" : "common/images/chenpeng/收起.png";
            };
            //重置表单
            $scope.reset = function () {
                $scope.proposal.prpMmodelMainRequest = {};
                $scope.proposal.prpMmodelMainRequest.validStatus = '1';
                $scope.proposal.prpMmodelMainRequest.BusinessType1 = '01';
                $scope.proposal.prpMmodelMainRequest.startDate=$scope.time.year+'-'+$scope.time.month+'-'+'01';
                $scope.proposal.prpMmodelMainRequest.endDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                $scope.paginationConfmm.totalItems=""
                $scope.proposal.clauseQueryList ={}
                //$scope.$apply();
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
                        if ($scope.paginationConfmm.totalItems == 0 || !$scope.paginationConfmm.totalItems) {
                            return;
                        } else {
                            $scope.submit();
                        }
                    }
                };
            };
            initPage2();
            //$scope.paginationConfmm.totalItems =  $scope.totalItems;
            //if($scope.paginationConfmm.totalItems<=$scope.paginationConfmm.perPageOptions){
            //    $scope.paginationConfmm.totalItems=0;
            //}

            //    总保险金额的数字校验
            $scope.pressDecimal = function ($event) {
                if (($event.keyCode >= 48 && $event.keyCode <= 57) || $event.keyCode == 46) {
                    return true;
                } else {
                    $event.preventDefault();
                }
            }
            //全选
            $scope.checked1 = [];
            $scope.cleanData = [];
            var nums;
            $scope.selectAll = function () {
                $scope.checked1 = [];
                if ($scope.select_all) {
                    angular.forEach($scope.proposal.clauseQueryList, function (info) {
                        if(info.validStatus1=='0'){
                            info.checked = true;
                            $scope.checked1.push(info.modelCode);
                        }
                        nums=0;
                    })
                } else {
                    angular.forEach($scope.proposal.clauseQueryList, function (info) {
                        info.checked = false;
                        $scope.checked1 = [];
                    })
                    nums=1;
                }
                if( nums==0&&$scope.checked1.length==0){
                    $scope.tishi('4');
                    $scope.select_all=false;
                }
            }
            //点选
            //信达版本
            // $scope.selectOne=function(clause){
            //     angular.forEach($scope.proposal.clauseQueryList,function (x)
            //     {
            //         var index = $scope.checked1.indexOf(clause.modelCode);
            //         if(clause.checked&&index==-1)
            //         {
            //             $scope.checked1.push(clause.modelCode);
            //         }else if(!clause.checked&&index!=-1)
            //         {
            //             $scope.checked1.splice(index,1);
            //         }
            //     });
            //     if($scope.proposal.clauseQueryList.length==$scope.checked1.length){
            //         $scope.select_all=true;
            //     }else {
            //         $scope.select_all=false;
            //     }
            // }
            //国元版本
            $scope.selectOne = function (clause) {
                angular.forEach($scope.proposal.clauseQueryList, function (x) {
                    var index = $scope.checked1.indexOf(clause.modelCode);
                    if (clause.checked && index == -1&&clause.validStatus1=='0') {
                        $scope.checked1.push(clause.modelCode);
                    } else  if(clause.checked&&index==-1&&clause.validStatus1!='0')
                    {
                        clause.checked=false;
                        $scope.tishi('3');
                    }else if (!clause.checked && index != -1) {
                        $scope.checked1.splice(index, 1);
                    }
                });
                if ($scope.proposal.clauseQueryList.length == $scope.checked1.length) {
                    $scope.select_all = true;
                } else {
                    $scope.select_all = false;
                }
            }
            //根据模板代码停用启用模板
            $scope.disableClause = function (info) {
                var currTime=new Date().getTime();
                if(currTime>info.endDate){
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '模板已过期',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if(currTime<info.startDate){
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '模板使用日期不在有效期内',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else if(info.flag=='0'){
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '暂存模板需要先保存',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }else{
                    if (info.validStatus == '1') {
                        //设置未启用
                        info.validStatus = '0'
                        info.validStatus1 = '0'
                    } else {
                        info.validStatus = '1'
                        info.validStatus1= '1'
                    }
                    $$finder.find('StateSettings', {
                        "modelCode": info.modelCode,
                        "validStatus": info.validStatus
                    }, {
                        success: function (data) {
                            if (data.content.message == 'success') {
                                $scope.distishi('0');
                                $scope.submit();
                            } else {
                                $scope.distishi('1');
                            }
                        }
                    })
                }

            }
            //单个删模板信息回调重新加载查询
            $scope.manage = [];
            $scope.deleteCoins = function (modelCode) {
                $scope.manage.push(modelCode)
                layer.open({
                    //offset: ['45%', '40%'],
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: '确定要删除吗？',
                    btn: ['确定', '取消'],
                    btn1: function (index, layero) {
                        $$finder.find('prpModelMainDel', $scope.manage,
                            {
                                success: function (data) {
                                    if (data.content.message == 'success') {
                                        $scope.submit()
                                        $scope.tishi('0')
                                    } else {
                                        $scope.tishi('1')
                                    }
                                }
                            })
                    },
                    btn2: function (index, layero) {
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                })
            };
            //批量删除模板信息
            $scope.plsc = function () {
                if ($scope.checked1.length != 0) {
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '确定要删除吗？',
                        btn: ['确定', '取消'],
                        btn1: function (index, layero) {
                            $$finder.find('prpModelMainDel', $scope.checked1
                                , {
                                    success: function (data) {
                                        if (data.content.message == 'success') {
                                            $scope.submit()
                                            $scope.tishi('0')
                                            $scope.checked1 = $scope.cleanData
                                        } else {
                                            $scope.tishi('1')
                                        }
                                    }
                                })
                        },
                        btn2: function (index, layero) {
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                } else {
                    //如果未选中则提示未选中要删除的信息
                    $scope.tishi('2')
                }
            }
            //是否要确认删除
            $scope.flg=function(message,info){
                //有效模板不允许删
                if(info!=null&&info.validStatus1=='1'){
                    layer.open({
                        //offset: ['45%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
                        content: '不可删除有效模版',
                        btn: ['确定'],
                        btn1: function(index, layero){
                            //按钮【按钮一】的回调
                            layer.close(index);
                        }
                    });
                }
                else  if(message=='批删'){$scope.plsc();}
                else if(message=='单删'){$scope.deleteCoins(info.modelCode)}
            }


            //公用的提示信息
            $scope.tishi=function(message){
                var content;
                if(message=='0') {content = '删除成功！';}
                else if(message=='1'){content='删除失败！' }
                else if(message=='2'){content='请选择模版！' }
                else if(message=='3'){content='不能选择有效模版！' }
                else if(message=='4'){content='当前页面无无效模版！' }
                layer.open({
                    //offset: ['45%', '40%'],
                    skin: 'large-layer-content',
                    scrollbar: false,
                    closeBtn: 0,
                    title: '温馨提示',
                    content: content,
                    btn: ['确定'],
                    btn1: function(index, layero){
                        //按钮【按钮一】的回调
                        layer.close(index);
                    }
                });
            }
            $scope.distishi=function(message){
                if(message=='0')
                {
                    content = '操作成功！';
                }else{content='操作失败！' }
                $scope.dd()
            }
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
            $scope.queryByValid=function() {
                $$finder.find('riskCode',{
                }, {
                    success: function (data) {
                        $scope.riskCodeList = data.content;
                    },
                    error: function (e) {
                        options.error(e);
                    }
                });
            }
            //投保单查询页面的查看与修改
            $scope.revise=function(type){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIproposaledit',{type:type})
            }
            //投保单查询页面的删除
            $scope.deleteaa=function(index){
                $scope.proposal.clauseQueryList.splice(index,1);
            }
            //跳转到新增模版页面
            $scope.newTemplate = function(type){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $rootScope.comTreeCtrlFlag=false;
                $state.go('UIproposaledit',{type:type})
            }
            //隐藏险种方案
            //$scope.showRiskScheme=false;
            //$scope.riskNameHide=false;
            //日期校验
            $scope.compareDate=function(startDate,endDate){
                var content;
                if (startDate==""||!startDate) {
                    content = '请录入模版创建起期';
                    $scope.proposal.prpMmodelMainRequest.endDate = "";
                    layer.open({
                        //offset: ['40%', '40%'],
                        skin: 'large-layer-content',
                        scrollbar: false,
                        closeBtn: 0,
                        title: '温馨提示',
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
                        content = '模版创建止期要大于模版创建起期';
                        /*$scope.proposal.prpMmodelMainRequest.endDate = "";*/
                        $scope.proposal.prpMmodelMainRequest.startDate=$scope.time.year+'-'+$scope.time.month+'-'+'01';
                        $scope.proposal.prpMmodelMainRequest.endDate=$scope.time.year+'-'+$scope.time.month+'-'+$scope.time.date;
                        layer.open({
                            //offset: ['40%', '40%'],
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
            }
            //模板创建日期初始值
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
            //模板详细信息查询
            $scope.getProposalInfo = function (modelCode) {
                //var proposalNo=$scope.proposal.QueryList[index].proposalNo
                $("html,body").css({overflow:"auto"});//出现滚动条
                $rootScope.comTreeCtrlFlag=true;
                $state.go('UIproposalshow', {modelCode:modelCode})
            }
            //模板修改
            $scope.modifyModelInfo = function (modelCode){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $rootScope.comTreeCtrlFlag=false;
                $state.go('UIproposalshow', {modelCode:modelCode,flag:"1"});
            }
        }]);
});