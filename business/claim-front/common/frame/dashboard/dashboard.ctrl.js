/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app,constants,layer) {
    'use strict';
    app.registerController('dashboardCtrl', ['$rootScope', '$scope','$$finder','$state',"$compile","$filter","$$user",'menuServ','regexpConstants',
        function ($rootScope, $scope, $$finder, $state,$compile,$filter,$$user,menuServ,regexpConstants){
            $(".index-right").height($(".index-left").height());
            $scope.regData = regexpConstants;
            //定义常用菜单显示变量,为true的时候显示
            $scope.commonUserMenu = false;

            $scope.querySpecFlag = false;

            $scope.dashboard='首页';
            $scope.queryDto = {}; // 查询条件
            $scope.showFlag = true;
            $scope.paginationConf ={
                currentPage : 1, // 当前所在的页
                totalItems: 0, // 总共有多少条记录
                itemsPerPage : 5, // 每页展示的数据条数
                perPageOptions : [5 , 10],
                onChange : function () { // 值回调
                    $scope.submit();
                }
            };
            //分页设置
            $scope.submit=function () {
                var nodeStatus = ''
                //已处理的情况
                if ($scope.showFlag==true){
                    nodeStatus = '4'
                    $$finder.post('queryMyJobDetail', {
                        "handlerCode":$rootScope.user.userCode,
                        "nodeStatus":nodeStatus,
                        "nodeType":$scope.nodeType,
                        "policyNo":$scope.policyNo,
                        "registNo":$scope.registNo,
                        "pageNo": $scope.paginationConf.currentPage,
                        "pageSize": $scope.paginationConf.itemsPerPage
                    }).then(
                        function (data) {
                            $scope.taskQueryDto=data.content;
                            //循环查询出来的列表,并将报案时间由时间戳转换成正常时间
                            angular.forEach(data.content,function (value) {
                                console.log(value)
                                value.reportDate=$filter('date')(value.reportDate,'yyyy-MM-dd');
                            })
                            var index =$scope.paginationConf.itemsPerPage*($scope.paginationConf.currentPage-1);
                            $scope.paginationConf.totalItems = data.totalCount;
                        },
                        function () {
                            console.log('不好意思,分页出错了')
                        }
                    )
                }
                //待处理的情况 待处理的情况不需要跟人对应,所以不要穿handlerCode
                else {
                    nodeStatus = '0'
                    $$finder.post('queryMyJobDetail', {
                        "nodeStatus":nodeStatus,
                        "nodeType":$scope.nodeType,
                        "policyNo":$scope.policyNo,
                        "registNo":$scope.registNo,
                        "pageNo": $scope.paginationConf.currentPage,
                        "pageSize": $scope.paginationConf.itemsPerPage
                    }).then(
                        function (data) {
                            $scope.taskQueryDto=data.content;
                            //循环查询出来的列表,并将报案时间由时间戳转换成正常时间
                            angular.forEach(data.content,function (value) {
                                console.log(value)
                                value.reportDate=$filter('date')(value.reportDate,'yyyy-MM-dd');
                            })
                            var index =$scope.paginationConf.itemsPerPage*($scope.paginationConf.currentPage-1);
                            $scope.paginationConf.totalItems = data.totalCount;
                        },
                        function () {
                            console.log('不好意思,分页出错了')
                        }
                    )
                }
            }

            console.log($rootScope.oriMenu)

            $scope.sched=$scope.sched || {}
            $scope.check=$scope.check || {}
            $scope.compe=$scope.compe || {}
            //待处理调度任务对象定义
            $scope.waitSched=$scope.waitSched || {}
            //待处理查勘定损对象定义
            $scope.waitCheck=$scope.waitSched || {}
            //待处理理算对象定义
            $scope.waitCompe=$scope.waitCompe || {}


            var queryMyJobCount = function () {

                //调度任务查询(已处理) 首页默认显示调度任务(已处理) 这个是列表查询的默认展示
                $$finder.post('queryMyJobDetail', {
                    "handlerCode": $rootScope.user.userCode,
                    //默认显示第一页,5条数据
                    "pageNo": "1",
                    "pageSize": "5",
                    //4为已处理 0 未处理 2代表暂存(正在处理)
                    "nodeStatus": "4",
                    //sched为调度
                    "nodeType": "sched"
                }).then(
                    function (data) {
                        console.log('调度任务查询(已处理)');
                        console.log(data);
                        $scope.taskQueryDto = data.content;
                        //循环查询出来的列表,并将报案时间由时间戳转换成正常时间
                        angular.forEach(data.content, function (value) {
                            console.log(value)
                            value.reportDate = $filter('date')(value.reportDate, 'yyyy-MM-dd');
                        })
                        //调度任务待处理右上角数字赋值
                        $scope.schedTotalCount = data.totalCount;
                        //分页插件赋值
                        $scope.paginationConf.totalItems = data.totalCount;
                        $scope.nodeType = 'sched';
                    },
                    function () {
                        console.log('不好意思,因为某种原因,查询失败了')
                    }
                )


                //调度任务查询(待处理) 确定的查询条件等待后端确认
                $$finder.post('queryMyJobDetail', {
                    "pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "0",
                    "nodeType": "sched"
                }).then(
                    function (data) {
                        console.log('调度任务查询(未处理)');
                        console.log(data);
                        console.log(data.totalCount)
                        $scope.schedWaitingTotalCount = data.totalCount;
                    }
                )

                //查勘定损任务查询(已处理) 用来查询总条数
                $$finder.post('queryMyJobDetail', {
                    "handlerCode": $rootScope.user.userCode,
                    "pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "4",
                    "nodeType": "check"
                }).then(
                    function (data) {
                        console.log('查勘定损任务查询(已处理)');
                        console.log(data);
                        $scope.checkTotalCount = data.totalCount;
                    }
                )

                //查勘定损任务查询(未处理) 用来查询总条数
                $$finder.post('queryMyJobDetail', {
                    "handlerCode":$rootScope.user.userCode,
                    "pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "0",
                    "nodeType": "check"
                }).then(
                    function (data) {
                        console.log('查勘定损任务查询(未处理)');
                        console.log(data);
                        $scope.checkWaitingTotalCount = data.totalCount;
                    }
                )

                //理算任务查询(已处理) 用来查询总条数
                $$finder.post('queryMyJobDetail', {
                    "handlerCode": $rootScope.user.userCode,
                    "pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "4",
                    "nodeType": "compe"
                }).then(
                    function (data) {
                        console.log('理算任务查询(已处理)');
                        console.log(data);
                        $scope.compeTotalCount = data.totalCount;
                    }
                )

                //理算任务查询(待处理) 用来查询总条数
                $$finder.post('queryMyJobDetail', {
                    "pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "0",
                    "nodeType": "compe"
                }).then(
                    function (data) {
                        console.log('理算任务查询(未处理)');
                        console.log(data);
                        $scope.compeWaitingTotalCount = data.totalCount;
                    }
                )
            }

            queryMyJobCount();

            //点击待处理触发事件 所有待处理任务和人是无关的
            $scope.waitQuery = function (data) {
                //showflag代表已处理或者未处理,true已处理,false未处理
                $scope.showFlag=false;
                if (data!=null){
                    $scope.nodeType=data
                }
                console.log($scope.showFlag);
                console.log('以下是要登录的节点' + $scope.nodeType)
                var queryDto = {"pageNo": "1",
                    "pageSize": "5",
                    "nodeStatus": "0",
                    "policyNo":$scope.policyNo,
                    "registNo":$scope.registNo,
                    "nodeType": $scope.nodeType
                }
                if ($scope.nodeType=="check"){
                    queryDto = {"pageNo": "1",
                        "pageSize": "5",
                        "nodeStatus": "0",
                        "handlerCode":$rootScope.user.userCode,
                        "policyNo":$scope.policyNo,
                        "registNo":$scope.registNo,
                        "nodeType": $scope.nodeType
                    }
                }else {
                    queryDto = {
                        "pageNo": "1",
                        "pageSize": "5",
                        "nodeType": $scope.nodeType,
                        "policyNo": $scope.policyNo,
                        "registNo": $scope.registNo,
                        "nodeStatus": "0",
                    }
                }
                if ($scope.policyNo != undefined && $scope.registNo != undefined){
                   queryDto = {
                       "pageNo":"1",
                       "pageSize":"5",
                       "nodeType":$scope.nodeType,
                       "policyNo":$scope.policyNo,
                       "registNo":$scope.registNo,
                       "nodeStatus":"0",
                   }
                }

                    $$finder.post('queryMyJobDetail', queryDto).then(
                        function (data) {
                            console.log('具体节点查询');
                            console.log(data);
                            $scope.taskQueryDto = data.content;
                            //循环查询出来的列表,并将报案时间由时间戳转换成正常时间
                            angular.forEach(data.content, function (value) {
                                console.log(value)
                                value.reportDate = $filter('date')(value.reportDate, 'yyyy-MM-dd');
                            })
                            $scope.paginationConf.totalItems = data.totalCount;
                            $scope.paginationConf.currentPage = 1;
                            $scope.paginationConf.itemsPerPage = 5;

                        }
                    );
            }

            //$$finder.post('showMenu', {
            //    comCode:'0000180005',
            //    userCode:"Y007",
            //    systemCode:"newagriclaim"
            //}).then(
            //    function (answer) {
            //        console.log(answer);
            //        $scope.leftMenu = answer;
            //        if (answer) {
            //            menuServ.setMenuDate(answer);
            //            $scope.leftMenu = answer;
            //            var getimges = function (data) {
            //                $.each(data, function (index, item) {
            //                    if (item.utiMenuDto.image) {
            //                        item.utiMenuDto.image = $sce.trustAsHtml("<i class='iconfont'>&#xe62a;</i>")
            //                    }
            //                    if (item.childMenuList && item.childMenuList != 0) {
            //                        getimges(item.childMenuList)
            //                    }
            //                });
            //            }
            //            getimges($scope.leftMenu)
            //            $scope.data = changeData1($scope.leftMenu);
            //        }
            //
            //    }, function (error) {
            //        console.error("菜单获取错误:", angular.fromJson(error));
            //    })

            console.log('以下是未处理和待处理标志')
            console.log($scope.showFlag)
            console.log('以下是当前的登录机构')
            //在切换任务节点的时候进行查询(点击已处理按钮也调用这个方法)
            $scope.queryMyJob = function (data) {
                if (data!=null){
                    $scope.nodeType=data;
                }
                $scope.showFlag=true
                console.log('当前的showflag标志为:true代表已处理4 false代表未处理0')
                console.log($scope.showFlag)

                var queryDto = {
                    "handlerCode":$rootScope.user.userCode,
                    "pageNo":"1",
                    "pageSize":"5",
                    //切换任务节点的时候查询的默认是已处理的任务 所以为4
                    "nodeStatus":"4",
                    "policyNo":$scope.policyNo,
                    "registNo":$scope.registNo,
                    "nodeType":$scope.nodeType
                };

                if ($scope.policyNo != undefined && $scope.registNo != undefined){
                    queryDto = {
                        "pageNo":"1",
                        "pageSize":"5",
                        "nodeType":$scope.nodeType,
                        "policyNo":$scope.policyNo,
                        "registNo":$scope.registNo,
                        "nodeStatus":"4",
                    }
                }


                $$finder.post('queryMyJobDetail',queryDto).then(
                    function (data) {
                        console.log('以下是要查询的节点');
                        console.log($rootScope.nodeType);
                        console.log(data);
                        $scope.taskQueryDto=data.content;
                        //循环查询出来的列表,并将报案时间由时间戳转换成正常时间
                        angular.forEach(data.content,function (value) {
                            console.log(value)
                            value.reportDate=$filter('date')(value.reportDate,'yyyy-MM-dd');
                        })
                        $scope.paginationConf.currentPage=1;
                        $scope.paginationConf.totalItems = data.totalCount;
                        $scope.paginationConf.itemsPerPage = 5;
                    }
                );

            }

            //快速查询 根据保单号,报案号以及 相应的节点进行查询
            $scope.querySpec = function () {
                if ($scope.policyNo == null && $scope.registNo == null){
                    layerMsg("快速查询请输入保单号或报案号")
                    return false;
                }

                $scope.querySpecFlag = true;
                //快速查询默认查询已处理的
                $$finder.post('queryMyJobDetail',{
                    "handlerCode":$rootScope.user.userCode,
                    "pageNo":"1",
                    "pageSize":"5",
                    "nodeType":$scope.nodeType,
                    "policyNo":$scope.policyNo,
                    "registNo":$scope.registNo,
                    "nodeStatus":"4",
                }).then(
                    function (data) {
                        console.log('快速查询');
                        console.log(data);
                        $scope.taskQueryDto=data.content;
                        $scope.showFlag=true;
                        $scope.paginationConf.totalItems=data.totalCount;
                        angular.forEach(data.content,function (value) {
                            console.log(value)
                            value.reportDate=$filter('date')(value.reportDate,'yyyy-MM-dd');
                        })
                    }
                )
            }


            // 弹出个人定制菜单弹层
            $scope.openComFunLayer = function () {
                $scope.$broadcast("ComFunLayerSwitch");
            }

            //调度任务处理
            $scope.goDispatch = function () {
                $state.go("dashboardDispatch")
            }

            //登录之后请求用户的常用登录菜单
            $$user.getLoginUser().then(function (data) {
                queryMyJobCount();
                //$$finder.post("queryUserMenuInfo", {
                //    userCode: $rootScope.user.userCode,
                //    sysFlag: constants.SYSTEMAGRI.systemCode,
                //    comCode: $rootScope.user.loginComCode
                //}).then(
                //    function (answer) {
                //        console.log(answer)
                //        $scope.userMenu = answer;
                //        console.log('以下是该用户的常用菜单');
                //        console.log($scope.userMenu);
                //        console.log($scope.userMenu[0].menuCName)
                //    },
                //    function () {
                //    }
                //)
            });

            //查询所有的用户的常用菜单 常用菜单初始化
            $rootScope.start = function () {
                $$finder.post("queryUserMenuInfo", {
                    userCode: $rootScope.user.userCode,
                    sysFlag: "newclaim",
                    comCode: $rootScope.user.loginComCode
                }).then(
                    function (answer1) {
                        console.log(answer1)
                        $scope.userMenu = answer1;
                        console.log('以下是该用户的常用菜单');
                        console.log($scope.userMenu);
                        console.log($scope.userMenu[0].menuCName)
                    },
                    function () {
                    }
                )
            }
             $rootScope.start()

            //查看处理链接
            $scope.manage = function (type,item) {
                var nodeType = $scope.nodeType
                //var registNo=  $scope.queryMyJobDtoCopy.
                if (type) {
                    //type为true的时候是待处理链接为处理
                    if(nodeType=='regis'){
                        //报案任务
                        //$state.go('UIAgriRegist',{editType:'SHOW',registNo:item.registNo,riskCode:item.riskCode})
                        $state.go('UIAgriRegist',{editType:'SHOW',policyNo:item.policyNo,registNo:item.registNo,riskCode:item.policyNo.substring(1,5)})

                    }
                    if(nodeType=='compp'){
                        //理算任务
                        $state.go('UIAgriCompenstate',{editType:'SHOW',compensateNo:item.businessNo,claimNo:item.claimNo,flowId:item.flowId,logNo:item.logNo,checkFlag:false})
                    }
                    if(nodeType=='check'){
                        //勘察定损
                        $state.go('UIAgriCheck',{editType:'SHOW',registNo:item.registNo,flowId:item.flowId,logNo:item.logNo,checkNo:item.registNo})
                    }
                    if(nodeType=='speci'){
                        //特殊赔案
                        $state.go('UIAgriPrepayHandle',{date:JSON.stringify(item)})
                    }
                    if(nodeType=='sched'){
                        //调度
                        $state.go('UIAgriDispatchReassignment',{editType:'SHOW',riskCode:item.riskCode,registNo:item.registNo,policyNo:item.policyNo,nodeType:nodeType,swflogFlowId:item.swflogFlowId,swflogLogNo:item.swflogLogNo})
                    }
                    if(nodeType=='claim'){
                        //立案
                        $state.go('UIAgriClaimHandle',{editType:'SHOW',claimNo:item.businessNo,registNo:item.registNo,flowId:item.flowId,logNo:item.logNo,riskCode:item.riskCode,policyNo:item.policyNo})
                    }
                } else {
                    //type为false的时候是待处理链接为查看
                    if(nodeType=='regis'){
                        //报案任务
                        $state.go('UIAgriRegist',{editType:'EDIT',registNo:item.registNo,riskCode:item.riskCode})
                    }
                    if(nodeType=='compe'){
                        //理算任务
                        $state.go('UIAgriCompenstate',{editType:'ADD',flowId:item.flowId,compensateNo:item.compensateNo,claimNo:item.businessNo,logNo:item.logNo,checkFlag:true})
                    }
                    if(nodeType=='check'){
                        //勘察定损
                        $state.go('UIAgriCheck',{editType:'ADD',registNo:item.registNo,flowId:item.flowId,logNo:item.logNo,checkNo:item.registNo})
                    }
                    if(nodeType=='speci'){
                        //特殊赔案
                        $state.go('UIAgriPrepayHandle',{date:JSON.stringify(item)})
                    }
                    if(nodeType=='sched'){
                        //调度
                        $state.go('UIAgriDispatchEdit',{editType:'ADD',riskCode:item.riskCode,registNo:item.registNo,policyNo:item.policyNo,nodeType:nodeType,swflogFlowId:item.flowId,swflogLogNo:item.logNo})
                    }
                    if(nodeType=='claim'){
                        //立案
                        $state.go('UIAgriClaimSee',{editType:'ADD',claimNo:item.claimNo,riskCode:item.riskCode,policyNo:item.policyNo})
                    }
                }
            }

            //点击常用菜单的跳转事件
            $scope.goOriMenu= function (index) {
                //console.log(index);
                $state.go($scope.userMenu[index].url);
            }


            // 弹出增加常用功能弹层或常用功能已满弹层
            $scope.add=function(){
                $scope.commonUserMenu=true;
                $("html,body").css({overflow:"hidden"}) //隐藏滚动条
                //var i=$('.choose-right ul li').length;
                /*  if(i>=6){
                 $('.layer-demo').css('display','block');
                 }else{

                 }*/
                debugger;
                $scope.chooseOne('One','001');
                $scope.neworiMenu=[];
                $('.layer-revise').css('display','block');
                //在常用功能弹层导入二级菜单数据
                $scope.data_old =[];
                $scope.data_menuList=[];
                $scope.data_menuId=[];
                $scope.data_url=[];
                console.log($scope.menuData);
                $scope.data_old=$scope.menuData;
                //console.log($scope.data_old);
                for(var j =0;j<$scope.data_old.length;j++){
                    // console.log($scope.data[j].nodes);
                    if($scope.data_old[j].nodes.length>0){
                        for(var x=0; x<$scope.data_old[j].nodes.length; x++){
                            //  console.log($scope.data[j].nodes[x].menuCName);
                            $scope.data_menuList.push($scope.data_old[j].nodes[x].menuCName);
                            $scope.data_menuId.push($scope.data_old[j].nodes[x].menuId+$scope.data_old[j].nodes[x].menuCName);
                            $scope.data_url.push($scope.data_old[j].nodes[x].url);


                            //$scope.data= $scope.data.push($scope.data_menuId+':'+$scope.data_menuList);

                        }
                    }else{
                        if($scope.data_old[j].menuId!='A100000000000000032'){
                            $scope.data_menuList.push($scope.data_old[j].menuCName);
                            $scope.data_menuId.push($scope.data_old[j].menuId+$scope.data_old[j].menuCName);
                            $scope.data_url.push($scope.data_old[j].url);
                        }

                    }

                }
                $rootScope.start();
                $scope.menu="";
                $scope.chooseOne("","");
                $(".has-comfun").find(".new").remove();
                $scope.chooseOne("One","001");

            }

            $scope.getUrl= function () {
                //获取当前选中功能的url
                $scope.menuList=$scope.data_menuList;
                $scope.url = $scope.data_url;

                for(var i=0;i<$scope.menuList.length;i++){
                    if($scope.text == $scope.menuList[i]){
                        $scope.trueUrl = $scope.url[i];
                        return $scope.trueUrl;

                    }
                }
            }


            // 修改常用功能
            // 选择图片
                $scope.chooseOne = function (type, icon) {
                    $scope.iconCode = icon;
                    $scope.isActive = function (obj) {
                        var test = obj == type ? true : false;
                        return test;
                    };
                    // 增加常用功能
                    $scope.addContent = function () {
                        //常用功能区已满
                        /* var j=$('.has-comfun li').length;
                         if(j>=5){
                         $('.layer-demo').css('display','block');
                         $('.layer-revise').css('display','none');
                         }*/
                        // 下拉菜单选择功能
                        $scope.text = "";
                        $scope.picture = "";
                        $scope.flg = true;
                        $scope.text = $('.revise-select').find("option:selected").text();
                        debugger
                        if ($scope.text == '请选择常用功能') {
                            layer.open({
                                offset: ['45%', '40%'],
                                skin: 'large-layer-content',
                                closeBtn: 0,
                                title: '温馨提示',
                                content: "请选择常用功能菜单!",
                                btn: ['确定'],
                                btn1: function (index, layero) {
                                    //按钮【按钮一】的回调
                                    layer.close(index);
                                }
                            });
                            return $scope.flg = false;
                        }
                        //判断是否有该功能
                        angular.forEach($scope.userMenu, function (data) {
                            if ($scope.text == data.menuCName) {
                                layer.open({
                                    offset: ['45%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "该功能已存在!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return $scope.flg = false;
                            }
                        })
                        angular.forEach($scope.neworiMenu, function (data) {
                            if ($scope.text == data.menuCName) {
                                layer.open({
                                    offset: ['45%', '40%'],
                                    skin: 'large-layer-content',
                                    closeBtn: 0,
                                    title: '温馨提示',
                                    content: "该功能已在新增列表中!",
                                    btn: ['确定'],
                                    btn1: function (index, layero) {
                                        //按钮【按钮一】的回调
                                        layer.close(index);
                                    }
                                });
                                return $scope.flg = false;
                            }
                        })
                        //var delete_10 ='<i class="iconfont icon-close" ng-click="">&#xe632;</i>' ;
                        if(type == 'One'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }if(type == 'Two'){
                            $scope.picture=  $('.comfun').find('.active').clone();
                        }if(type == 'Three'){
                            $scope.picture=  $('.comfun').find('.active').clone();
                        }if(type== 'Four'){
                            $scope.picture=  $('.comfun').find('.active').clone();
                        }if(type== 'Five'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }if(type== 'Six'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }if(type== 'Seven'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }if(type=='Eight'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }if(type=='Nine'){
                            $scope.picture =  $('.comfun').find('.active').clone();
                        }
                        if ($scope.flg && $scope.text&&$scope.picture) {
                            var addP = $('.has-comfun').append("<li class='new'></li>");
                            var html = "<i class=\"iconfont icon-close\" ng-click=\"deleteoriMenu($event,'1','" + $scope.text + "')\">&#xe632;</i>"
                                + "<span>" + $scope.text + "</span>";
                            var $html = $compile(html)($scope);
                            addP.find("li:last").append($html).prepend($scope.picture);
                            $scope.neworiMenu[$scope.neworiMenu.length] = {
                                "userCode": $rootScope.user.userCode,
                                "comCode": $rootScope.user.loginComCode,
                                "systemCode": "127",
                                "menuId": 0,
                                "menuCName": $scope.text,
                                "url": $scope.getUrl(),
                                "iconExpand": icon,//字体图标
                                "validStatus": "1",
                                "sysFlag": "newclaim"
                            }
                        }
                    }
                };


                //保存新添加的常用功能
                $scope.saveFunction = function (data) {
                    if ($scope.neworiMenu.length == 0) {
                        layer.open({
                            offset: ['45%', '40%'],
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "没有新增的功能!",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                        $scope.commonUserMenu = false;
                    } else {
                        $$finder.post("saveUserMenu", $scope.neworiMenu)
                            .then(function (data) {
                                 $rootScope.start();
                            }, function () {

                            })

                        $('.layer-revise').css('display', 'none');
                        layer.open({
                            offset: ['45%', '40%'],
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "保存成功!",
                            btn: ['确定'],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }

                }

                //常用菜单取消按钮
                $scope.oriFunction = function () {
                    $scope.commonUserMenu = false;
                    $scope.oriMenu = {};
                    $scope.oriImage = {};
                    $$finder.find("queryUserMenuInfo", {
                        "userCode": $rootScope.user.userCode,
                        "sysFlag": "newclaim",
                        "comCode": $rootScope.user.loginComCode
                    }, {
                        success: function (data) {
                            if (data.code = "0000") {
                                $scope.userMenu = data.content;
                                $scope.userMenu = data.iconExpand;
                                if ($scope.oriImage == '001') {
                                    console.log($scope.oriImage);
                                }
                            }
                        }
                    }, {
                        error: function (data) {
                        }
                    })
                }

                $scope.neworiMenu = [];//新增的功能
                //常用菜单删除功能
                $scope.deleteoriMenu = function ($event, str, text) {
                    if (str == "0") {
                        layer.open({
                            offset: ['45%', '40%'],
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "确定删除？",
                            btn: ['确定', "取消"],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                $$finder.post("deleteUserMenuInfo", {
                                    "userCode": $rootScope.user.userCode,
                                    "menuCName": text,
                                    "comCode": $rootScope.user.loginComCode
                                }).then(function (data) {
                                    layer.close(index);
                                     $rootScope.start()
                                }, function () {
                                })
                            },
                            btn2: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });

                    } else {
                        layer.open({
                            offset: ['45%', '40%'],
                            skin: 'large-layer-content',
                            closeBtn: 0,
                            title: '温馨提示',
                            content: "确定删除？",
                            btn: ['确定', "取消"],
                            btn1: function (index, layero) {
                                //按钮【按钮一】的回调
                                angular.element($event.target).parent().remove();
                                angular.forEach($scope.neworiMenu, function (data, index, array) {
                                    if (text == data.menuCName) {
                                        $scope.neworiMenu.splice(index, 1);
                                    }
                                })
                                layer.close(index);
                            },
                            btn2: function (index, layero) {
                                //按钮【按钮一】的回调
                                layer.close(index);
                            }
                        });
                    }
                }

                //关闭增加常用功能弹层
                $scope.delete_5 = function () {
                    $scope.commonUserMenu = false;
                }

            //递归取菜单
            var changeData1=function(data,ary){
                var ary=ary||[];
                angular.forEach(data,function(item,index){
                    ary.push(item.utiMenuDto)
                    item.utiMenuDto.nodes=[];
                    if(item.childMenuList&&item.childMenuList.length!=0){
                        changeData1(item.childMenuList,item.utiMenuDto.nodes)
                    }
                })
                return ary
            }

        }]);
});