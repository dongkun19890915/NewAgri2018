define([
    'jedate',
    'angular'
],function(jeDate){

    angular.module("angular-jedate", [])
    /**
     * @ngdoc directive
     * @name $$cherry.directive:jedate
     * @description
     * jedate日期控件及日期处理
     * @restrict A
     * @scope
     * @param {string} ngModel ngModel绑定值
     * @example
     <example module="cherry.directive">
     <file name="index.html">
     <input type="text"
     ng-model="proposal.CI.prpTmain.startDate"
     id="date1" name="date" jedate format="YYYY-MM-DD">
     </file>
     </example>
     */
        .directive('jedate', ['$timeout', '$parse', function ($timeout, $parse) {

            /**
             * 对外放出一个接口,触发指令函数
             * @param waitEvent
             * @param scope
             */
            var validation = function (waitEvent, scope) {
                if (waitEvent) {
                    $timeout(function () {
                        waitEvent(scope.$parent);
                    }, 100)
                }
            };

            return {
                restrict: "A",
                require:"ngModel",
                scope:{
                    'ngModel':'='
                },
                link: function (scope, element, attrs, ctrl) {
                    var id = attrs.id;
                    var oldModel = scope.ngModel||'';
                    var DATE_VALID1 = /^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-8])))$/;
                    var DATE_VALID2 = /^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-9])))$/;
                    var options = {
                        dateCell:"#" + id
                    };
                    if(attrs.myBlur){
                        var blurCallBack=$parse(attrs.myBlur);
                    }

                    var changeCallBack = $parse(attrs.ngChange);
                    var _changeCallBack = $parse(attrs.waitChange);

                    /**
                     * 日期格式校验
                     * @param regex 正则
                     * @param data  当前日期
                     * @param attrs attrs
                     * @param oldModel 之前日期
                     * @returns {*}
                     */
                    var validationData=function(regex,data,attrs,oldModel){
                        if(regex.test(data)){
                            if(data<attrs.minDate){
                                layerMsg('日期小于最小日期');
                                data = oldModel;
                            }else if(data>attrs.maxDate){
                                layerMsg('日期大于最大日期');
                                data = oldModel;
                            }
                        }else{
                            //layerMsg('日期格式不正确');
                            data = oldModel;
                        }
                        return data;
                    };

                    //检测手动录入模式
                    ctrl.$parsers.unshift(function(){
                        scope.$parent.inputStatus.manual=true;
                    });

                    options.minDate = attrs.minDate;//最小日期
                    options.maxDate = attrs.maxDate;//最大日期
                    //options.isClear = false;//默认不展示清空按钮
                    options.isTime = attrs.isTime;//默认关闭时间选择
                    options.festival = false;//默认显示节日
                    options.skinCell = attrs.skincell;//风格调用，CSS中增加了3种风格（红、绿、蓝）
                    options.format = attrs.format;//日期格式设置( YYYY-MM-DD hh:mm:ss 设置 年-月-日 时:分:秒; YYYY-MM-DD 设置 年-月-日)
                    options.clearRestore = false; //清空输入框，返回预设日期，输入框非空的情况下有效
                    options.choosefun=function(elem, val){ //选中回调

                        scope.$apply(function(){
                            scope.ngModel=val;
                            //scope.$parent.infoToView.jedateChange = true;
                            validation(changeCallBack, scope);
                            validation(_changeCallBack, scope);

                        });
                        if(blurCallBack)
                            blurCallBack(scope.$parent.$parent);
                    };

                    options.clearfun = function () { //清空回调
                        scope.$apply(function(){
                            scope.ngModel="";
                            //scope.$parent.infoToView.jedateChange = true;
                            validation(changeCallBack, scope);
                            validation(_changeCallBack, scope);
                        })
                    };

                    options.okfun =function(elem, val){ //确定回调
                        scope.$apply(function(){
                            scope.ngModel=val;
                            //scope.$parent.infoToView.jedateChange = true;
                            validation(changeCallBack, scope);
                            validation(_changeCallBack, scope);
                        })
                    };

                    element.on('blur',function(){
                        var viewValue = ctrl.$viewValue;
                        if(!viewValue)
                            return;
                        var date =viewValue.replace(/-|\s|:|\//g,'');
                        date= date.substring(0, 4) + '-' + date.substring(4, 6) + '-' + date.substring(6, 8);
                        if(date.substring(0,4)%4==0){
                            date = validationData(DATE_VALID2,date,attrs,oldModel);
                        }else{
                            date = validationData(DATE_VALID1,date,attrs,oldModel);
                        }
                        scope.$apply(function(){
                            scope.ngModel=date;
                            //判断是否弹出日期插件
                            if(!$('#jedatebox').css('display')){
                                validation(_changeCallBack, scope);
                            }
                        })
                    });

                    element.on('change',function(){
                        //scope.$parent.infoToView.jedateChange = true;
                    });

                    $timeout(function(){
                        $(options.dateCell).jeDate(options);
                    },1);
                }
            }
        }]);

});