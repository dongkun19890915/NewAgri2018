/**
 * Created by ZhangJiansen on 2016/9/10.
 * Controller层只处理视图数据绑定，后端交互在service处理
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var insureCtrl = function($q,$rootScope,$scope,$modal,$http,$state)
    {
        $scope.proposalStep = "1";

        //双击域
        $scope.search=function(riskCode){
            var ModalInstanceCtrl = function ($scope, $modalInstance) {

                var getRiskData=function(){
                    var url=moduleApp.basePath+"/controller/risk.json";
                    var deferred=$q.defer();
                    var promise=$http({
                        method:"get",
                        url:url,
                        data:riskCode
                    });
                    promise.then(
                        //通讯成功
                        function(answer){
                            deferred.resolve(answer);
                        },
                        //通讯失败
                        function(error){
                            deferred.reject(error);
                        }
                    );
                    return promise;
                };

                //模糊查询国家
                getRiskData().then(function(answer){
                        $scope.choiseData=answer.data;
                    },
                    function(error){
                    });

                $scope.ok = function (selectData) {
                    $modalInstance.close(selectData);
                };
                $scope.cancel = function () {
                    $modalInstance.dismiss();
                };
            };
            $modal.open({
                // backdrop: 'static',//点击弹框外部区域弹框不关闭
                animation: true,
                templateUrl: 'frame/common/prompt/tpl/choiceModal.html',
                controller: ModalInstanceCtrl,
                size: 'sm',
                resolve: {}
            }).result.then(function (selectData) {
                $scope.gRiskCode = selectData.code;
                $scope.gRiskName = selectData.name;
                var disStyle = $scope.gDisStyle || "flow";
                    //($scope.gDisStyle ? $scope.gDisStyle:"flow");
                $state.go('main.insure.add',{riskCode:selectData.code,disStyle:disStyle},{reload:'main.insure.add'});
            });
        };
    };
    moduleApp.controller('insureCtrl',['$q','$rootScope','$scope','$modal','$http','$state',insureCtrl]);
});