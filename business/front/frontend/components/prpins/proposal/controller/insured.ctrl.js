/**
 * Created by GuoXiangLian on 2016/10/5.
 */
define(['../module'], function (moduleApp) {
    'use strict';
    var insuredCtrl = function($scope,QuerySelectCode,FormFocus) {

        var queryData = function(condition){
            var promise = QuerySelectCode.getData(condition);
            promise.then(
                function(answer){
                    console.log("data:"+JSON.stringify(answer.data));
                },function(error){
                    //console.log("error:"+JSON.stringify(error));
                }
            );
            return promise;
        };

        /**
         * 界面初始化为省市区下拉框赋值
         * @author ZhangJiansen
         */
        var initSelect = function(){

            var townCode = $scope.PrpTinsuredPropDto.townCode;
            var cityCode = $scope.PrpTinsuredPropDto.cityCode;
            var provinceCode = $scope.PrpTinsuredPropDto.provinceCode;

            doSelect("000000",provinceCode,""); //省下拉框的上级默认为000000
            doSelect(provinceCode,cityCode,"province");
            doSelect(cityCode,townCode,"city");

        };


        /**
         * controller数据初始化总方法
         */
        var init = function(){

            if(!angular.isDefined($scope.PrpTinsuredPropDto)){
                $scope.PrpTinsuredPropDto = {};
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.provinceCode)){
                $scope.PrpTinsuredPropDto.provinceCode = "";
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.cityCode)){
                $scope.PrpTinsuredPropDto.cityCode = "";
            }
            if(!angular.isDefined($scope.PrpTinsuredPropDto.townCode)){
                $scope.PrpTinsuredPropDto.townCode = "";
            }

            /**
             * 页面打开时，初始化完给下拉框赋值
             */
            $scope.$watch('addLayer',function(){
                if($scope.addLayer == false){
                    initSelect();
                }
            });

        };

        /**
         * 处理下拉框选中赋值
         * @author ZhangJiansen
         * @param upperCode 上级下拉框值
         * @param codeCode  要给下拉框赋的值
         * @param flag 被选中的下拉框
         */
        var doSelect = function(upperCode,codeCode,flag){
            var condition = {codeType:"AreaCode",upperCode:upperCode};

            if(flag == "town"){
                console.log("选择town");
            } else if(flag == "city"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.PrpTinsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.townList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.townCode = codeCode;
                    }, function (error) {
                        $scope.townList = [];
                        //console.log(error.data);
                    }
                );

            }else if(flag == "province"){
                if(upperCode == null || upperCode == ""){
                    return;
                }
                $scope.PrpTinsuredPropDto.cityCode = "";//清空市
                $scope.cityList = [];
                $scope.PrpTinsuredPropDto.townCode = "";//清空县
                $scope.townList = [];//清空县列表
                condition.upperCode = upperCode;
                queryData(condition).then(
                    function (answer) {
                        $scope.cityList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.cityCode = codeCode;
                    }, function (error) {
                        $scope.cityList = [];
                        //console.log(error.data);
                    }
                );

            }else{
                $scope.townList = [];
                $scope.cityList = [];
                $scope.provinceList = [];
                queryData(condition).then(
                    function (answer) {
                        $scope.provinceList = answer.data.codeData;
                        $scope.PrpTinsuredPropDto.provinceCode = codeCode;
                    }, function (error) {
                        $scope.provinceList = [];
                        //console.log(error.data);
                    }
                );
                console.log("flag为空");
            }
        };

        /**
        * 区域下拉框选择响应方法
        */
        $scope.selectCode = function (item, flag) {
            doSelect(item.codeCode,"",flag);
        };
        init();

    };
    moduleApp.controller('insuredCtrl',['$scope','QuerySelectCode','FormFocus',insuredCtrl]);
});
