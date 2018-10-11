/**
 * Created by colorfulcat on 2017/11/12.
 */
define([
    'app',
    'constants',
    'common/frame/header/header.ctrl',
    'common/frame/menu/menu.serv',
    'common/frame/menu/menu.ctrl',
    'common/frame/navigation/navigation.ctrl'
], function (app,constants) {
    'use strict';
    app.registerController('mainCtrl', ['$scope', '$rootScope','$http', '$state','$timeout','$$cherry','regexpConstants','$$finder',
        function ($scope, $rootScope,$http,$state,$timeout,$$cherry,regexpConstants) {
            $scope.regData = regexpConstants;
            /*
           * 菜单刷新高亮显示
           * */
            $scope.getMenuData=function(data){
                $scope.menuData=data;
            }
            $scope.currentURL ={
                currentType:"dashboard"
            };
            $scope.mainViewFlag=true;// 菜单及顶栏显示控制
            $rootScope.$on("$stateChangeStart",function (event,toState, toParams, fromState, fromParams) {
                console.log(toState.name);
                if(toState.name!="message") {
                    if (toParams.authSystemFlag == null || toParams.authSystemFlag == "") {
                        $scope.authSystemFlag = true;
                    } else {
                        $scope.authSystemFlag = false;
                    }
                }
                $rootScope.authSystemFlag=$scope.authSystemFlag;
                $rootScope.systemFlag=toParams.authSystemFlag;
            });
            $rootScope.$on("$stateChangeSuccess",function (event) {
                $timeout(function(){
                    $scope.currentURL.currentType = $state.$current.name;
                },200)
            });
            /**
             * 全选
             * @param scope 查询页面的$scope
             * @param list  查询结果的list
             */
            $scope.doCheckedAll = function (scope, list, checkedList){
                checkedList = checkedList||[];
                scope.checkedAll=!scope.checkedAll;
                angular.forEach(list,function(result){
                    result.checked=scope.checkedAll;
                });
                if(scope.checkedAll){
                    var ary = angular.copy(list);
                    ary.unshift(0,checkedList.length);
                    [].splice.apply(checkedList,ary);
                } else {
                    checkedList.length=0 ;
                }
            };

            /**
             * 勾选某一个
             * @param scope 查询页面的$scope
             * @param list  查询结果的list
             * @param result 当前点勾中勾出的操作项
             * @param checkedList 选中的list
             */
            $scope.doChecked = function (scope, list, result, checkedList) {
                checkedList = checkedList || [];
                checkedList.length=0;
                result.checked = !result.checked;
                if (list && list.length > 0) {
                    var flag = true;
                    for (var i = 0; i < list.length; i++) {
                        if (!list[i].checked) {
                            flag = false;
                        } else {
                            checkedList.push(list[i])
                        }
                    }
                    scope.checkedAll = flag;
                }
            };
           // 表单重置
            $scope.resetForm = function () {
                $state.go($state.current.name,{},{reload:true});
            };
            //保单关联按钮
            $scope.policyShow =function (policyNo) {
                if(policyNo){
                window.open($rootScope.frontEnd.claimPrpallUrl+constants.EXTERNALSYSTEMURL.POLICYSHOW+policyNo);
                }else {
                    layerMsg('保单号不存在，无法查看关联信息!');
                    return;
                }
            };
        }]);
});