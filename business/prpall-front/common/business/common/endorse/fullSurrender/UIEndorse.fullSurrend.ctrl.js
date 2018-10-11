/**
 * Created by colorfulcat on 2017/11/12.
 */
define(['app', 'constants', 'layer', 'jsonDB'], function (app, constants, layer, jsonDB) {
    'use strict';
    app.registerController('UIEndorseFullSurrenderCtrl', ['$rootScope', '$scope', '$$finder', '$http', '$filter', '$location',
        function ($rootScope, $scope, $$finder, $http, $filter, $location) {
            $$finder.find('fullSurrender', {}, {
                success: function (data) {
                    $scope.fullSurrenderList = data.data.fullSurrenderList;
                    $scope.totalItems = data.data.fullSurrenderList.length

                },
                error: function (e) {
                    options.error(e);
                }
            });
            var initPage2 = function () {
                $scope.paginationConfmm = {
                    currentPage: 1,
                    totalItems: 0,
                    itemsPerPage: 20,
                    pagesLength: 5,
                    perPageOptions: [5, 10, 20, 50]
                };
            };

            initPage2();
            $scope.paginationConfmm.totalItems = $scope.totalItems;

            //上一步下一步按钮
            $scope.isAdjust = false;
            $scope.showAdjust=function(){
                if($scope.isAdjust){
                    //跳转支付页面不在了
                    //$location.path('/')
                }else{
                    $scope.isAdjust=!$scope.isAdjust
                }
            }
            $scope.showPrevPage=function(){
                    if( $scope.isAdjust){
                        $scope.isAdjust=!$scope.isAdjust
                    }else{
                        //上一步可以跳转的页面暂定为保单查询
                        $("html,body").css({overflow:"auto"});//出现滚动条
                        $location.path('/UIPrPoEnQuery')
                    }
            }
        }]);


});