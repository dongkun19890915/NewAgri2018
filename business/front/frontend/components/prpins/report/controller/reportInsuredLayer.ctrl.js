/**
 * Created by GuoXiangLian on 2016/9/26.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var reportInsuredLayerCtrl = function($scope) {
        $scope.structFlag = false;
        $scope.$on("reportInsuredLayerShow",function (event, params) { //监听来自父controller的信息
            $scope.PrpTinsuredPropDto=params.PrpTinsuredPropDto;
            if($scope.PrpTinsuredPropDto.buildStructure == '99'){
                $scope.structFlag = true;
            }else{
                $scope.structFlag = false;
            }
            $scope.reportProposalLook();
        });
        var _windowH = $(window).height();
        var layerH = $(".layerOver").height()+37;
        if(layerH > _windowH){
            $(".layerOver").css("height","450px");
            $(".revise_insurant").css("margin-top","-260px");
        }
        /*查看*/
        $scope.reportProposalLook = function(){
            $scope.reportInsuredLayer = true;
        };
        $scope.reportProposalLookClose = function(){
            $scope.reportInsuredLayer = false;
        }
    };
    moduleApp.controller('reportInsuredLayerCtrl',['$scope',reportInsuredLayerCtrl]);
});
