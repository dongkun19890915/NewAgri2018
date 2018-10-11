/**
 */
define([
    'angular',
    'config',
    'constants'
], function (angular, config, constants) {
    /**
     * @ngdoc service
     * @name cherry.commonality
     *
     * @description
     * cherry.commonality 提供了公共信息
     *
     */
    angular.module('cherry.commonality', [])

        .factory('$$commonality', ['$http','$q',
            function (finderConfig, $http, $q) {
                // angular.extend(constants.TARGET, finderConfig.TARGET);
                return {
                    inspectEmpty: function (target) {
                        //判断查询条件是否为空校验
                        var querySpecialflag = false;
                        //循环遍历表单下节点
                        for(var i=0;i<document[target].elements.length-1;i++)
                        {
                            if(document[target].elements[i].value!=""&&document[target].elements[i].value!="?"&&document[target].elements[i].value!="0"&&document[target].elements[i].value!='on')
                            {
                                querySpecialflag = true;
                            }
                        }
                        return querySpecialflag;
                    },
                    inspectFormat: function (target) {
                        var ele;
                        var Ele = $("[name="+target+"] .ng-invalid:not(ng-form)");
                        if (angular.isDefined(Ele[0])) {
                            if($scope[target].$valid){
                                //查询
                            }else {
                                if (Ele[0].nodeName == 'CODE-TYPE') {
                                    ele = Ele[0].children[0].children[0].children[0];
                                } else if(Ele[0].nodeName == 'SELECT' || Ele[0].nodeName == 'select'){
                                    ele = Ele[0];
                                } else if (Ele[0].nodeName == 'SELECT-LIST' || Ele[0].nodeName == 'select-list') {
                                    ele = Ele[0].children[1]
                                } else {
                                    ele = Ele[0];
                                }
                                if (angular.isDefined(ele)) {

                                    var _formFocus = Ele[0];
                                    var _nodeValue;
                                    if (_formFocus.attributes['warn-layer']) {
                                        _nodeValue = _formFocus.attributes['warn-layer'].nodeValue;
                                    }else if($(_formFocus).parent()[0].attributes['warn-layer']){
                                        _nodeValue = $(_formFocus).parent()[0].attributes['warn-layer'].nodeValue;
                                    }
                                    if(_nodeValue){
                                        layerMsg(_nodeValue+"格式错误");
                                        return false;
                                    }
                                    return true;
                                }
                            }

                        }
                    }
                };

            }])
})
;