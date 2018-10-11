/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'layer'
], function (app,constants,layer) {
    'use strict';
    app.registerController('menuCtrl', ['$rootScope', '$scope','$$finder','$sce','menuServ','$$user',
        function ($rootScope, $scope, $$finder,$sce, menuServ, $$user){

            $scope.menu='menu';
            $scope.isActive=true;
            $scope.leftFlag=false;
            $scope.navClick = function(){
                $scope.showNavMenu = !$scope.showNavMenu;
                $scope.isActive=!$scope.isActive;
                $scope.leftFlag = !$scope.leftFlag;
                $scope.rightFlag = !$scope.rightFlag;
            };
            $scope.navClickOpen=function(){
                $scope.showNavMenu =false;
                $scope.isActive=false;
                $scope.leftFlag =true;
                $scope.rightFlag =! $scope.rightFlag;
            }

            $scope.showNavMenu = true;
            $scope.$on('SHOWNAVMENU', function(event, toState) {
                $timeout(function(){
                    $scope.showNavMenu = !$scope.showNavMenu;
                });
            });
            var changeData = function (data,id) {
                var result = [], temp;
                $.each(data,function (index, item) {
                    item.childIsOpen=false;
                    if(item.actionURL=='dashboard'){
                        item.childIsOpen=true;
                    }
                    if(item.upperId == id){
                        var obj = item;
                        temp = changeData(data, item.id);
                        if(temp.length > 0){
                            obj.nodes = temp;
                        }
                        result.push(obj);
                    }
                });
                return result;
            };

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

            //处理当前子集节点与遍历节点是否有纵级关系
            var dealSubMenu = function (currentDomChild,checkDom) {
                var isRelation = false;
                $.each(currentDomChild, function (index, currentChild) {
                    if ((checkDom.$modelValue.id == currentChild.id)
                        || (checkDom.$modelValue.id == currentChild.upperId)
                        || (checkDom.$modelValue.upperId == currentChild.id)) {
                        isRelation = true;
                        return false;
                    } else if (currentDomChild.nodes && currentDomChild.nodes.length > 0) {
                        dealSubMenu(currentDomChild.nodes, checkDom);
                    }
                });
                return isRelation;
            };

            //处理纵向菜单(包括当前结点及当前结点到顶级结点的所有相关父节点)
            var dealDepthMenu = function (currentDomChild) {
                // var isRelation = false;
                //获取所有菜单
                var els = document.querySelectorAll('[ui-tree-node]');
                $.each(els,function(index, el) {
                    el = angular.element(el);
                    var checkDom = el.scope();

                    if ((checkDom.$modelValue.menuId == currentDomChild.menuId)) {
                        // isRelation = true;
                        // return false;
                        $scope.depthList.push(checkDom);
                        if (checkDom.$parentNodeScope != null) {//如果有父节点
                            dealDepthMenu(checkDom.$parentNodeScope.$modelValue, checkDom);//递归处理相关父节点
                        }
                    }
                });

                //子集有遍历
                // $.each(currentDomChild, function (index, currentChild) {
                //     if ((checkDom.$modelValue.id == currentChild.id)) {
                //         // isRelation = true;
                //         // return false;
                //         $scope.depthList.push(checkDom);
                //         if (currentDomChild.nodes && currentDomChild.nodes.length > 0) {
                //             dealSubMenuNew(currentDomChild.nodes, checkDom);
                //         }
                //     }
                // });
                // return isRelation;

            };

            //根据当前结点处理纵级横级菜单
            $scope.dealDepthHorList = function (currentDom) {
                $scope.depthList = [];
                $scope.horList = [];

                //处理纵向菜单
                dealDepthMenu(currentDom.$modelValue);

                //获取所有菜单
                var els = document.querySelectorAll('[ui-tree-node]');
                //处理横向菜单
                $.each(els,function(index, el) {
                    el = angular.element(el);
                    var checkDom = el.scope();
                    var isExist = false;
                    //排除纵向菜单
                    console.log(checkDom)
                    for(var i =0;i< $scope.depthList.length;i++) {
                        if(checkDom.$modelValue.menuId == $scope.depthList[i].$modelValue.menuId){
                            isExist = true;
                            return;
                        }
                    }
                    if(!isExist){
                        $scope.horList.push(checkDom);
                    }
                });

                //console.log("纵向菜单 " , $scope.depthList.length);
                //console.log("横向菜单 ", $scope.horList.length);
            };

            //所有横级菜单折叠,不选中
            var dealHorToggleNoSelected = function () {
                $.each($scope.horList, function (index, hor) {
                    hor.$modelValue.childIsOpen = false;//设置当前节点不选中
                    if(!hor.collapsed){//所有横级菜单折叠
                        hor.collapse();
                    }
                });
            };

            //设置纵级菜单选中
            var dealDepthSelectedStatus = function(status) {
                $.each($scope.depthList, function (index, depth) {
                    depth.$modelValue.childIsOpen = status;//设置当前节点选中或者未选中
                });
            };

            //设置兄弟节点只有一个被选中
            var siblingOnlySelectedOne = function(testDom){
                $.each(testDom.siblings(), function (index, sibling) {
                    if(sibling.$modelValue.id == testDom.$modelValue.id){
                        sibling.$modelValue.childIsOpen = true;//设置当前节点选中
                    } else {
                        sibling.$modelValue.childIsOpen = false;//设置其他节点未选中
                    }
                });
            };
            //菜单切换处理
            $scope.toggleDealNew = function (scope, menu) {
                //定位当前结点的树对象
                var testDom = scope.$parent.$nodeScope;

                //如果menu有值,则为有路由结点,需要设置当前结点及相关父类结点为选中状态,同时所有横级菜单折叠,不选中,
                //反之,无需设置当前结点及相关父类结点为选中状态,只需保证所有横级菜单折叠,不选中即可。
                //最底层的菜单走这里
                if(menu){
                    testDom.toggle();
                    //设置兄弟节点只有一个被选中
                    siblingOnlySelectedOne(testDom);

                    //根据当前结点处理纵级横级菜单
                    $scope.dealDepthHorList(testDom);

                    //设置相关纵级菜单选中,同时所有横级菜单折叠,不选中
                    //1.设置相关纵级菜单选中(参数true为选中,false为不选中)
                    //dealDepthSelectedStatus(true);
                    //2.所有横级菜单折叠,不选中
                    dealHorToggleNoSelected();

                    //如果是父级菜单则走这里
                } else {
                    testDom.toggle();
                    //根据当前结点处理纵级横级菜单
                    $scope.dealDepthHorList(testDom);
                    //设置相关纵级菜单不选中,同时所有横级菜单折叠,不选中
                    //1.设置相关纵级菜单选中(参数true为选中,false为不选中)
                    //dealDepthSelectedStatus(false);
                    //2.所有横级菜单折叠,不选中
                    dealHorToggleNoSelected();

                    //统一处理匹配路径的结点,并且返回设置纵级菜单选中
                    //1.查找到的匹配路由的结点◊
                    var dealSelectedRoute = function () {
                        var getDom = {};//查找到的匹配路由的结点
                        //获取所有菜单
                        var els = document.querySelectorAll('[ui-tree-node]');
                        //处理横向菜单
                        $.each(els,function(index, el) {
                            el = angular.element(el);
                            var checkDom = el.scope();
                            if(checkDom.$modelValue.actionURL == $scope.currentURL.currentType){
                                getDom = checkDom;
                                return false;
                            }
                        });
                        return getDom;
                    };

                    //2.根据当前结点处理纵级横级菜单
                    $scope.dealDepthHorList(dealSelectedRoute());

                    //设置相关纵级菜单选中,同时所有横级菜单折叠,不选中
                    //1.设置相关纵级菜单选中(参数true为选中,false为不选中)
                    //dealDepthSelectedStatus(true);
                }
            };


            //判断子节点是否打开,并更改父节点打开状态
            //function updateChildIsOpen(data,currentType){
            //    var result = false;
            //    if(data&&data.length>0){
            //        $.each(data,function(index,item){
            //            var childIsOpen = updateChildIsOpen(item.nodes,currentType);
            //            item.childIsOpen=childIsOpen;
            //            if(childIsOpen||item.actionURL==currentType){
            //                item.childIsOpen = result =  true;
            //            }
            //        });
            //    }
            //    return result
            //}
            //外部调用
            //$scope.updateType_old = function(currentType){
            //    updateChildIsOpen($scope.data,currentType);
            //    console.log($scope.data);
            //};

            //设置菜单的不同背景
            $scope.menuColors=["oneMenu","twoMenu","threeMenu","fourMenu","fiveMenu","sixMenu"];
            // $scope.collapseAll = function () {
            //     $scope.$broadcast('angular-ui-tree:collapse-all');
            // };
            // $scope.collapseAll();//默认折叠
            //机构更改重新调用菜单查询接口

            $rootScope.onQueryMenu=function (value) {
                $$finder.post('showMenu', {
                    comCode:$rootScope.user.loginComCode,
                    userCode:$rootScope.user.userCode,
                    systemCode:constants.SYSTEMAGRI.systemCode
                }).then(
                    function (answer) {
                        console.log(answer);
                        if (answer) {
                            menuServ.setMenuDate(answer);
                            $scope.leftMenu = answer;
                            var getimges = function (data) {
                                $.each(data, function (index, item) {
                                    if (item.utiMenuDto.image) {
                                        item.utiMenuDto.image = $sce.trustAsHtml("<i class='iconfont'>&#xe62a;</i>")
                                    }
                                    if (item.childMenuList && item.childMenuList != 0) {
                                        getimges(item.childMenuList)
                                    }
                                });
                            }
                            getimges($scope.leftMenu)
                            $scope.data = changeData1($scope.leftMenu);

                            $scope.getMenuData($scope.data);
                        }

                    }, function (error) {
                        console.error("菜单获取错误:", angular.fromJson(error));
                    })
            }


            //$$user.getLoginUser().then(function (data) {
            //    if(data.data.content.retCode == '200') { // 登录成功后请求菜单树
            //        $$finder.post('showMenu', {
            //            comCode:$rootScope.user.loginComCode,
            //            userCode:$rootScope.user.userCode,
            //            systemCode:constants.SYSTEMAGRI.systemCode
            //        }).then(
            //            function (answer) {
            //                console.log(answer);
            //                if (answer) {
            //                    menuServ.setMenuDate(answer);
            //                    $scope.leftMenu = answer;
            //                    var getimges = function (data) {
            //                        $.each(data, function (index, item) {
            //                            if (item.utiMenuDto.image) {
            //                                item.utiMenuDto.image = $sce.trustAsHtml("<i class='iconfont'>&#xe62a;</i>")
            //                            }
            //                            if (item.childMenuList && item.childMenuList != 0) {
            //                                getimges(item.childMenuList)
            //                            }
            //                        });
            //                    }
            //                    getimges($scope.leftMenu)
            //                    $scope.data = changeData1($scope.leftMenu);
            //                    // $scope.getMenuData($scope.data);
            //                }
            //
            //            }, function (error) {
            //                console.error("菜单获取错误:", angular.fromJson(error));
            //        })
            //    }
            //
            //},function () {
            //
            //});
        }]);
});