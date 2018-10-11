/**
 * Created by ZhangJiansen on 2016/12/15.
 * 动态添加dom片段
 */
define(['angular'],
    function(angular) {
        'use strict';
        angular.module('sino.DDom',[])
            .directive("sinoDom", ['$q','$timeout','$compile',
                function ($q,$timeout,$compile) {
                    return {
                        restrict:'A',
                        replace: true,
                        link:function ($scope, element, attrs, ctrl) {
                            var dom = $compile($scope.$eval(attrs.sinoDom))($scope);
                            $(element).append(dom);
                        }
                    }
                }
            ]).directive("sinoFormModule", ['$q','$http','$compile',
                function ($q,$http,$compile) {
                    return {
                        restrict:'A',
                        controllerAs: 'vm',
                        replace: true,
                        compile:function(){
                            return function ($scope, element, attrs, ctrl) {
                                var type = $scope.$eval(attrs.modType);
                                console.log("type="+type);
                                if(type == 'D'){
                                    var domStr = $scope.$eval(attrs.sinoFormModule);
                                    var dom = $compile($scope.$eval(attrs.sinoFormModule))($scope);
                                    $(element).append(dom);
                                }else{
                                    var srcUrl = $scope.$eval(attrs.sinoFormModule);
                                    domStr = '<ng-include src="\''+srcUrl+'\'"></ng-include>';
                                    var dom = $compile(domStr)($scope);
                                    $(element).append(dom);
                                }
                            };
                        }
                    }
                }
            ]);
        });
