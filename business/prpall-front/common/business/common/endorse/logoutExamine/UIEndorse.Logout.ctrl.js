define(['app','constants','layer','jsonDB'], function (app,constants,layer,jsonDB) {
    'use strict';
    app.registerController('UIEndorseLogoutUpdateCtrl', ['$rootScope', '$scope','$$finder','$http','$filter','$location',
        function ($rootScope,$scope,$$finder,$http,$filter,$location) {
            $scope.Tittle={
                firstLev:'批改管理',
                secLev:'特殊批改查询',
                thirdLev:'保单注销'
            };
            //上一步
            $scope.last = function(){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $location.path('/UIproposal3107edit');
            };
            //下一步
            $scope.next = function(){

            };
            $scope.getPolicyInfo=function(policyNo){
                $("html,body").css({overflow:"auto"});//出现滚动条
                $state.go('UIPolicy3107show',{'policyNo':policyNo,'norepeat':true})
            }
            //查看详情
            $scope.totalItems = 0;
            $scope.showDetail = false;
            $scope.choosedDetail = function(){
                //查询保单列表信息
                $$finder.find('selectedGuaranteeDetails', {}, {
                    success: function(data) {
                        $scope.details = data.data.resultObj.content;
                        $scope.totalItems = $scope.details.length;
                        $scope.paginationConfmm.totalItems = $scope.totalItems;
                        $scope.showDetail = true;
                        $("html,body").css({overflow:"hidden"});//隐藏滚动条
                    },
                    error: function(e) {
                        options.error(e);
                    }
                });
            }
            //关闭详情页面
            $scope.cancel = function(){
                $scope.showDetail = false;
                $("html,body").css({overflow:"auto"});//出现滚动条
            }
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
			$scope.paginationConfmm.totalItems = $scope.totalItems;
        }]);
});